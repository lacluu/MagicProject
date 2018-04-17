package nghich.banned.project.magicproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by nghich on 10/30/2017.
 */

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_square);
    }

    public void clickSquare(View view){
        Intent intent = new Intent(this,PlayNormalActivity.class);
        switch (view.getId()){
            case R.id.btnSquare1:
                intent.putExtra("square", 1);
                break;
            case R.id.btnSquare2:
                intent.putExtra("square", 2);
                break;
            case R.id.btnSquare3:
                intent.putExtra("square", 3);
                break;
            case R.id.btnSquare4:
                intent.putExtra("square", 4);
                break;
            case R.id.btnSquare5:
                intent.putExtra("square", 5);
                break;
            case R.id.btnSquare6:
                intent.putExtra("square", 6);
                break;
            case R.id.btnSquare7:
                intent.putExtra("square", 7);
                break;
            case R.id.btnSquare8:
                intent.putExtra("square", 8);
                break;
            case R.id.btnSquare9:
                intent.putExtra("square", 9);
                break;
            case R.id.btnSquare10:
                intent.putExtra("square", 10);
                break;
            case R.id.btnSquare11:
                intent.putExtra("square", 11);
                break;
            case R.id.btnSquare12:
                intent.putExtra("square", 12);
                break;
            case R.id.btnSquare13:
                intent.putExtra("square", 13);
                break;
            case R.id.btnSquare14:
                intent.putExtra("square", 14);
                break;
            case R.id.btnSquare15:
                intent.putExtra("square", 15);
                break;
            case R.id.btnSquare16:
                intent.putExtra("square", 16);
                break;
            case R.id.btnSquare17:
                intent.putExtra("square", 17);
                break;
            case R.id.btnSquare18:
                intent.putExtra("square", 18);
                break;
            case R.id.btnSquare19:
                intent.putExtra("square", 19);
                break;
            case R.id.btnSquare20:
                intent.putExtra("square", 20);
                break;
        }
        startActivity(intent);
    }
}
