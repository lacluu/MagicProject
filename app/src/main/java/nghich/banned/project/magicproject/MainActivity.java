package nghich.banned.project.magicproject;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by nghich on 10/22/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickToRule(View view){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_rule);
        dialog.setTitle("Rule");

        dialog.show();
    }
    public void clickToEasy(View view){
        Intent intent = new Intent(this, EasyActivity.class);
        startActivity(intent);
    }

    public void clickToNormal(View view){
        Intent intent = new Intent(this, NormalActivity.class);
        startActivity(intent);
    }
}
