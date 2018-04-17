package nghich.banned.project.magicproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nghich on 10/22/2017.
 */

public class PlayEasyActivity extends AppCompatActivity {

    Context context = (Context) this;
    private int[] puzzle;
    private boolean[] tmpPuzzle;
    EasyTopFragment easyTopFragment;
    FragmentManager fm;
    private static final int row = 3;
    private int sumSquare;
    private int[][] plArray = new int[row][row];
    private TextView txtSquareNumber;
    private TextView txtSum;
    private boolean running = false;
    private int seconds = 0;
    private int square;

    private Button btnNumE1;
    private Button btnNumE2;
    private Button btnNumE3;
    private Button btnNumE4;
    private Button btnNumE5;
    private Button btnNumE6;
    private Button btnNumE7;
    private Button btnNumE8;
    private Button btnNumE9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        square = getIntent().getIntExtra("square", 1);
        selectSquare(square);
        runTimer();

    }

    @Override
    protected void onStop() {
        running = false;
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        running = true;
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        running = false;
        super.onPause();
    }

    public void clickPauseGame(View view) {
        running = false;
        final Dialog dialogs = new Dialog(this);
        dialogs.setContentView(R.layout.dialog_menu);
        dialogs.setCanceledOnTouchOutside(false);

        Button btnDialogMenu = (Button) dialogs.findViewById(R.id.btnDialogChange);
        btnDialogMenu.setBackgroundColor(getResources().getColor(R.color.button_background));
        btnDialogMenu.setTextColor(getResources().getColor(R.color.button_font_color));
        btnDialogMenu.setLeft(7);
        btnDialogMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(R.layout.dialog_comfirm);
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                builder.show();
            }
        });

        Button btnDialogContinues = (Button) dialogs.findViewById(R.id.btnDialogContinues);
        btnDialogContinues.setBackgroundColor(getResources().getColor(R.color.button_background));
        btnDialogContinues.setTextColor(getResources().getColor(R.color.button_font_color));
        btnDialogContinues.setLeft(7);
        btnDialogContinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs.dismiss();
                running = true;
            }
        });

        Button btnDialogRetry = (Button) dialogs.findViewById(R.id.btnDialogRetry);
        btnDialogRetry.setBackgroundColor(getResources().getColor(R.color.button_background));
        btnDialogRetry.setTextColor(getResources().getColor(R.color.button_font_color));
        btnDialogRetry.setLeft(7);
        btnDialogRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(R.layout.dialog_comfirm);
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialogs.dismiss();
                        seconds = 0;
                        selectSquare(square);
                    }
                });
                builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                builder.show();
            }
        });

        dialogs.show();
    }

    public void clickToDelete(View view) {
        easyTopFragment.easyTopView.setSelectedTile("");
    }

    public void clickNum(View view) {
        boolean result = false;
        Button btnNumber = (Button) view;
        switch (view.getId()) {
            case R.id.btnNumE1:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE2:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE3:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE4:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE5:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE6:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE7:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE8:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNumE9:
                easyTopFragment.easyTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
        }
        if (result != false) {
            running = false;
            final Dialog dialogWin = new Dialog(this);
            dialogWin.setContentView(R.layout.dialog_win_game);
            dialogWin.setCanceledOnTouchOutside(false);

            Button btnMenu = (Button) dialogWin.findViewById(R.id.btnMenu);
            btnMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            Button btnRetry = (Button) dialogWin.findViewById(R.id.btnRetry);
            btnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogWin.dismiss();
                    seconds = 0;
                    selectSquare(square);
                }
            });

            Button btnNext = (Button) dialogWin.findViewById(R.id.btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogWin.dismiss();
                    seconds = 0;
                    square++;
                    selectSquare(square);
                }
            });

            dialogWin.show();
        }
    }

    public void selectSquare(int squareNumber) {
        easyTopFragment = new EasyTopFragment();
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.linearTop, easyTopFragment, easyTopFragment.getTag()).commit();
        int[] arrayButtonValue = null;
        switch (squareNumber) {
            case 1:
                puzzle = new int[]{2, 0, 4, 0, 5, 3, 6, 0, 8};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 2:
                puzzle = new int[]{0, 1, 0, 3, 5, 0, 4, 0, 2};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 3:
                puzzle = new int[]{4, 0, 8, 0, 0, 1, 2, 7, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 4:
                puzzle = new int[]{2, 9, 0, 0, 5, 3, 0, 0, 8};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 5:
                puzzle = new int[]{4, 0, 2, 0, 0, 7, 8, 0, 6};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 6:
                puzzle = new int[]{0, 0, 2, 1, 5, 0, 0, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 7:
                puzzle = new int[]{8, 3, 0, 0, 0, 9, 6, 7, 2};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 8:
                puzzle = new int[]{8, 0, 0, 0, 0, 7, 4, 9, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 9:
                puzzle = new int[]{0, 0, 4, 7, 0, 3, 0, 1, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 10:
                puzzle = new int[]{0, 3, 4, 0, 0, 0, 6, 7, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 11:
                puzzle = new int[]{9, 0, 7, 0, 6, 0, 0, 0, 3};
                arrayButtonValue = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
                sumSquare = 18;
                break;
            case 12:
                puzzle = new int[]{0, 3, 0, 5, 7, 0, 0, 0, 4};
                arrayButtonValue = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11};
                sumSquare = 21;
                break;
            case 13:
                puzzle = new int[]{0, 0, 0, 5, 25, 0, 0, 0, 20};
                arrayButtonValue = new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45};
                sumSquare = 75;
                break;
            case 14:
                puzzle = new int[]{0, 1, 0, 0, 0, 7, 4, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 15:
                puzzle = new int[]{9, 0, 0, 0, 5, 0, 0, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 16:
                puzzle = new int[]{6, 0, 8, 0, 0, 3, 2, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 17:
                puzzle = new int[]{0, 0, 2, 3, 0, 0, 0, 1, 6};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 18:
                puzzle = new int[]{0, 0, 8, 0, 5, 3, 0, 9, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 19:
                puzzle = new int[]{0, 0, 0, 0, 0, 9, 0, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            case 20:
                puzzle = new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0};
                arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                sumSquare = 15;
                break;
            default:
                Toast.makeText(getBaseContext(), "This is the last square!", Toast.LENGTH_SHORT).show();
        }
        setupValueForButton(arrayButtonValue);

        tmpPuzzle = setupArrayBoolean(puzzle);
        txtSquareNumber = (TextView) findViewById(R.id.tvSquareNumber);
        txtSquareNumber.setText("Square Easy " + squareNumber);

        txtSum = (TextView) findViewById(R.id.txtSum);
        txtSum.setText("Sum = " + sumSquare);
        running = true;
    }

    public void setupValueForButton(int[] input) {
        for (int i = 0; i < input.length; i++) {
            switch (i) {
                case 0:
                    btnNumE1 = (Button) findViewById(R.id.btnNumE1);
                    btnNumE1.setText(input[i] + "");
                    break;
                case 1:
                    btnNumE2 = (Button) findViewById(R.id.btnNumE2);
                    btnNumE2.setText(input[i] + "");
                case 2:
                    btnNumE3 = (Button) findViewById(R.id.btnNumE3);
                    btnNumE3.setText(input[i] + "");
                case 3:
                    btnNumE4 = (Button) findViewById(R.id.btnNumE4);
                    btnNumE4.setText(input[i] + "");
                case 4:
                    btnNumE5 = (Button) findViewById(R.id.btnNumE5);
                    btnNumE5.setText(input[i] + "");
                case 5:
                    btnNumE6 = (Button) findViewById(R.id.btnNumE6);
                    btnNumE6.setText(input[i] + "");
                case 6:
                    btnNumE7 = (Button) findViewById(R.id.btnNumE7);
                    btnNumE7.setText(input[i] + "");
                case 7:
                    btnNumE8 = (Button) findViewById(R.id.btnNumE8);
                    btnNumE8.setText(input[i] + "");
                case 8:
                    btnNumE9 = (Button) findViewById(R.id.btnNumE9);
                    btnNumE9.setText(input[i] + "");
            }
        }
    }

    public boolean checkAll() {
        plArray = changeToArray();
        boolean checkVertical = checkVetical(plArray);
        boolean checkHorizontal = checkHorizontal(plArray);
        boolean checkDiagonal = checkDiagonal(plArray);
        if ((checkVertical && checkHorizontal) && checkDiagonal) {
            return true;
        }
        return false;
    }

    public boolean[] setupArrayBoolean(int[] inputPuz) {
        boolean[] booleanPuzz = new boolean[inputPuz.length];
        for (int i = 0; i < inputPuz.length; i++) {
            if (inputPuz[i] != 0) {
                booleanPuzz[i] = false;
            } else {
                booleanPuzz[i] = true;
            }
        }
        return booleanPuzz;
    }

    public void setTitle(int x, int y, String value) {
        if (tmpPuzzle[y * row + x] != false) {
            if (value != "") {
                puzzle[y * row + x] = Integer.parseInt(value);
            } else {
                puzzle[y * row + x] = 0;
            }
        }
    }

    public int getTile(int x, int y) {
        return puzzle[y * row + x];
    }

    protected String getTitleString(int x, int y) {
        int v = getTile(x, y);
        if (v == 0)
            return "";
        else
            return String.valueOf(v);
    }

    public boolean checkVetical(int[][] input) {
        boolean result = false;
        //hang doc
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += input[i][j];
            }
            if (sum == sumSquare) {
                result = true;
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkHorizontal(int[][] input) {
        boolean result = false;
        //hang ngang
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += input[j][i];
            }
            if (sum == sumSquare) {
                result = true;
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkDiagonal(int[][] input) {
        if ((input[0][0] + input[1][1] + input[2][2]) == sumSquare) {
            if ((input[0][2] + input[1][1] + input[2][0]) == sumSquare) {
                return true;
            }
        }
        return false;
    }

    public int[][] changeToArray() {
        int[][] result = new int[row][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = puzzle[j + i * row];
            }
        }
        return result;
    }

    public void runTimer() {
        final TextView txtTime = (TextView) findViewById(R.id.tvTime);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int second = seconds % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, second);
                txtTime.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
