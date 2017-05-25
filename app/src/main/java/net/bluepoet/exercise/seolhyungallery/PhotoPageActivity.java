package net.bluepoet.exercise.seolhyungallery;

import android.support.v4.app.Fragment;

/**
 * Created by bluepoet on 2017. 5. 25..
 */

public class PhotoPageActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PhotoPageFragment();
    }
}
