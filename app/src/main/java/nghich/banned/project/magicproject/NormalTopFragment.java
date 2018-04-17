package nghich.banned.project.magicproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nghich on 10/29/2017.
 */

public class NormalTopFragment extends Fragment {

    public NormalTopView normalTopView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        normalTopView = new NormalTopView(getContext());
        return normalTopView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
