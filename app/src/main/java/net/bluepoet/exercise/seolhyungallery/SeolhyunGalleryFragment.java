package net.bluepoet.exercise.seolhyungallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by daumkakao on 2017. 5. 18..
 */

public class SeolhyunGalleryFragment extends Fragment {
    GridView mGridView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_seolhyun_gallery, container, false);
        mGridView = (GridView) v.findViewById(R.id.gridView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
