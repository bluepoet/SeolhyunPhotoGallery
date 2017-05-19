package net.bluepoet.exercise.seolhyungallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bluepoet on 2017. 5. 19..
 */

public class ThumbnailDownloader<Token> extends HandlerThread {
    private static final String TAG = "ThumbnailDownloader";
    private static final int MESSAGE_DOWNLOAD = 0;

    private Handler mHandler;
    private Map<Token, String> requestMap = Collections.synchronizedMap(new HashMap<Token, String>());

    private Handler mResponseHandler;
    private ThumbnailDownloadListener<Token> mThumbnailDownloadListener;

    public interface ThumbnailDownloadListener<Token> {
        void onThumbnailDownloaded(Token token, Bitmap thumbnail);
    }

    public void setThumbnailDownloadListener(ThumbnailDownloadListener<Token> mThumbnailDownloadListener) {
        this.mThumbnailDownloadListener = mThumbnailDownloadListener;
    }

    public ThumbnailDownloader(Handler responseHandler) {
        super(TAG);
        this.mResponseHandler = responseHandler;
    }

    @Override
    protected void onLooperPrepared() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == MESSAGE_DOWNLOAD) {
                    Token token = (Token) msg.obj;
                    handleRequest(token);
                }
            }
        };
    }

    private void handleRequest(final Token token) {
        try {
            final String url = requestMap.get(token);
            if(url == null) return;

            byte[] bitmapBytes = new PhotoFetcher().getUrlBytes(url);
            final Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
            Log.i(TAG, "Bitmap created");

            mResponseHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(requestMap.get(token) != url) {
                        return;
                    }

                    requestMap.remove(token);
                    mThumbnailDownloadListener.onThumbnailDownloaded(token, bitmap);
                }
            });
        } catch (IOException e) {
           Log.e(TAG, "Error downloading image", e);
        }
    }

    public void cleanQueue() {
        mHandler.removeMessages(MESSAGE_DOWNLOAD);
        requestMap.clear();
    }

    public void queueThumbnail(Token token, String url) {
        Log.i(TAG, "Got an url : " + url);
        requestMap.put(token, url);

        mHandler.obtainMessage(MESSAGE_DOWNLOAD, token).sendToTarget();
    }
}
