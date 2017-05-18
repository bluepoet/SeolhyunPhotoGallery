package net.bluepoet.exercise.seolhyungallery;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeolhyunGalleryActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SeolhyunGalleryFragment();
    }
}
