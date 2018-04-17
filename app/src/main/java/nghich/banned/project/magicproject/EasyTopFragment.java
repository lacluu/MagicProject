package nghich.banned.project.magicproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nghich on 10/22/2017.
 */

public class EasyTopFragment extends Fragment {

    public EasyTopView easyTopView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        easyTopView = new EasyTopView(getContext());
        return easyTopView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
