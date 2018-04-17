package nghich.banned.project.magicproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MSI on 11/9/2017.
 */

public class ConfirmDialogFragment extends DialogFragment {
    String text ="";
    TextView txtComfirm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_comfirm, container);

        getDialog().setTitle("Comfirm");

        return view;
    }
}
