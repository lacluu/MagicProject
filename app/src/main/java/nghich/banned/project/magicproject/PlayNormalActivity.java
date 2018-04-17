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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nghich on 10/29/2017.
 */

public class PlayNormalActivity extends AppCompatActivity {

    Context context= (Context) this;
    public int[] puzzle;
    public boolean[] tmpPuzzle;
    NormalTopFragment normalTopFragment;
    FragmentManager fm;
    private final int row = 4;
    private boolean running = false;
    private int seconds = 0;
    private int square;
    private TextView txtSquareNumber;
    private TextView txtSum;
    private int sumSquare;

    private int[][] plArray = new int[row][row];

    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnNum10;
    private Button btnNum11;
    private Button btnNum12;
    private Button btnNum13;
    private Button btnNum14;
    private Button btnNum15;
    private Button btnNum16;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_normal);

        square = getIntent().getIntExtra("square", 1);
        selectSquare(square);
        runTimer();
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
        normalTopFragment.normalTopView.setSelectedTile("0");
    }

    public void clickNum(View view) {
        boolean result = false;
        Button btnNumber = (Button) view;

        switch (view.getId()) {
            case R.id.btnNum1:
                normalTopFragment.normalTopView.setSelectedTile("1");
                result = checkAll();
                break;
            case R.id.btnNum2:
                normalTopFragment.normalTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNum3:
                normalTopFragment.normalTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNum4:
                normalTopFragment.normalTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNum5:
                normalTopFragment.normalTopView.setSelectedTile(btnNumber.getText().toString());
                result = checkAll();
                break;
            case R.id.btnNum6:
                normalTopFragment.normalTopView.setSelectedTile("6");
                result = checkAll();
                break;
            case R.id.btnNum7:
                normalTopFragment.normalTopView.setSelectedTile("7");
                result = checkAll();
                break;
            case R.id.btnNum8:
                normalTopFragment.normalTopView.setSelectedTile("8");
                result = checkAll();
                break;
            case R.id.btnNum9:
                normalTopFragment.normalTopView.setSelectedTile("9");
                result = checkAll();
                break;
            case R.id.btnNum10:
                normalTopFragment.normalTopView.setSelectedTile("10");
                result = checkAll();
                break;
            case R.id.btnNum11:
                normalTopFragment.normalTopView.setSelectedTile("11");
                result = checkAll();
                break;
            case R.id.btnNum12:
                normalTopFragment.normalTopView.setSelectedTile("12");
                result = checkAll();
                break;
            case R.id.btnNum13:
                normalTopFragment.normalTopView.setSelectedTile("13");
                result = checkAll();
                break;
            case R.id.btnNum14:
                normalTopFragment.normalTopView.setSelectedTile("14");
                result = checkAll();
                break;
            case R.id.btnNum15:
                normalTopFragment.normalTopView.setSelectedTile("15");
                result = checkAll();
                break;
            case R.id.btnNum16:
                normalTopFragment.normalTopView.setSelectedTile("16");
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

        normalTopFragment = new NormalTopFragment();
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.linearTop, normalTopFragment, normalTopFragment.getTag()).commit();
        int[] arrayButtonValue = null;
        switch (squareNumber) {

            case 1:
                puzzle = new int[]{1, 8, 0, 13, 14, 0, 7, 2, 0, 10, 6, 3, 4, 5, 0, 16};
                break;
            case 2:
                puzzle = new int[]{0, 12, 14, 7, 15, 0, 4, 0, 8, 13, 0, 2, 0, 3, 5, 16};
                break;
            case 3:
                puzzle = new int[]{0, 7, 0, 9, 11, 0, 5, 0, 0, 12, 0, 6, 8, 0, 10, 0};
                break;
            case 4:
                puzzle = new int[]{0, 5, 14, 0, 9, 0, 7, 2, 15, 0, 1, 8, 0, 3, 0, 13};
                break;
            case 5:
                puzzle = new int[]{0, 0, 0, 9, 0, 15, 0, 0, 11, 0, 2, 7, 0, 1, 13, 12};
                break;
            case 6:
                puzzle = new int[]{1, 8, 0, 11, 12, 0, 7, 2, 0, 10, 4, 0, 6, 0, 0, 16};
                break;
            case 7:
                puzzle = new int[]{0, 14, 8, 0, 0, 0, 10, 5, 12, 7, 0, 2, 6, 0, 3, 16};
                break;
            case 8:
                puzzle = new int[]{2, 11, 7, 0, 13, 8, 0, 0, 0, 5, 9, 0, 3, 0, 6, 15};
                break;
            case 9:
                puzzle = new int[]{4, 0, 15, 10, 0, 16, 0, 3, 14, 11, 0, 0, 7, 2, 0, 13};
                break;
            case 10:
                puzzle = new int[]{5, 0, 0, 8, 0, 0, 0, 0, 4, 0, 0, 1, 9, 6, 0, 12};
                break;
            case 11:
                puzzle = new int[]{0, 2, 3, 13, 5, 0, 10, 0, 9, 0, 0, 12, 4, 0, 15, 1};
                break;
            case 12:
                puzzle = new int[]{11, 10, 8, 5, 7, 0, 0, 9, 14, 0, 0, 4, 2, 3, 13, 16};
                break;
            case 13:
                puzzle = new int[]{0, 4, 14, 0, 13, 0, 0, 3, 8, 0, 0, 10, 0, 9, 7, 0};
                break;
            case 14:
                puzzle = new int[]{0, 5, 2, 0, 9, 0, 0, 14, 3, 10, 0, 8, 0, 15, 12, 0};
                break;
            case 15:
                puzzle = new int[]{4, 0, 14, 9, 0, 13, 8, 0, 0, 12, 1, 0, 5, 0, 0, 16};
                break;
            case 16:
                puzzle = new int[]{13, 0, 3, 10, 12, 0, 0, 15, 0, 0, 0, 0, 7, 0, 0, 4};
                break;
            case 17:
                puzzle = new int[]{0, 0, 15, 0, 0, 16, 5, 0, 0, 9, 0, 0, 0, 3, 10, 0};
                break;
            case 18:
                puzzle = new int[]{0, 11, 0, 16, 0, 8, 0, 3, 0, 0, 0, 0, 0, 10, 0, 13};
                break;
            case 19:
                puzzle = new int[]{0, 0, 0, 0, 5, 12, 2, 15, 0, 0, 0, 0, 11, 6, 16, 1};
                break;
            case 20:
                puzzle = new int[]{12, 2, 15, 0, 7, 0, 4, 10, 6, 16, 0, 11, 0, 3, 14, 8};
                break;
            default:
                Toast.makeText(getBaseContext(), "This is the last square!", Toast.LENGTH_SHORT).show();
                break;
        }
        sumSquare = 34;
        arrayButtonValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        setupValueForButton(arrayButtonValue);

        tmpPuzzle = setupArrayBoolean(puzzle);

        txtSquareNumber = (TextView) findViewById(R.id.tvSquareNumber);
        txtSquareNumber.setText("Square Normal " + squareNumber);

        txtSum = (TextView) findViewById(R.id.txtSum);
        txtSum.setText("Sum = " + sumSquare);
        running = true;
    }

    public void setupValueForButton(int[] input) {
        for (int i = 0; i < input.length; i++) {
            switch (i) {
                case 0:
                    btnNum1 = (Button) findViewById(R.id.btnNum1);
                    btnNum1.setText(input[i] + "");
                    break;
                case 1:
                    btnNum2 = (Button) findViewById(R.id.btnNum2);
                    btnNum2.setText(input[i] + "");
                    break;
                case 2:
                    btnNum3 = (Button) findViewById(R.id.btnNum3);
                    btnNum3.setText(input[i] + "");
                    break;
                case 3:
                    btnNum4 = (Button) findViewById(R.id.btnNum4);
                    btnNum4.setText(input[i] + "");
                    break;
                case 4:
                    btnNum5 = (Button) findViewById(R.id.btnNum5);
                    btnNum5.setText(input[i] + "");
                    break;
                case 5:
                    btnNum6 = (Button) findViewById(R.id.btnNum6);
                    btnNum6.setText(input[i] + "");
                    break;
                case 6:
                    btnNum7 = (Button) findViewById(R.id.btnNum7);
                    btnNum7.setText(input[i] + "");
                    break;
                case 7:
                    btnNum8 = (Button) findViewById(R.id.btnNum8);
                    btnNum8.setText(input[i] + "");
                    break;
                case 8:
                    btnNum9 = (Button) findViewById(R.id.btnNum9);
                    btnNum9.setText(input[i] + "");
                    break;
                case 9:
                    btnNum10 = (Button) findViewById(R.id.btnNum10);
                    btnNum10.setText(input[i] + "");
                    break;
                case 10:
                    btnNum11 = (Button) findViewById(R.id.btnNum11);
                    btnNum11.setText(input[i] + "");
                    break;
                case 11:
                    btnNum12 = (Button) findViewById(R.id.btnNum12);
                    btnNum12.setText(input[i] + "");
                    break;
                case 12:
                    btnNum13 = (Button) findViewById(R.id.btnNum13);
                    btnNum13.setText(input[i] + "");
                    break;
                case 13:
                    btnNum14 = (Button) findViewById(R.id.btnNum14);
                    btnNum14.setText(input[i] + "");
                    break;
                case 14:
                    btnNum15 = (Button) findViewById(R.id.btnNum15);
                    btnNum15.setText(input[i] + "");
                    break;
                case 15:
                    btnNum16 = (Button) findViewById(R.id.btnNum16);
                    btnNum16.setText(input[i] + "");
                    break;
            }
        }
    }

    public boolean checkAll() {
        plArray = changeToArray();

        boolean checkVertical = checkVetical(plArray);
        Log.d("checkVertical: ", checkVertical + "");
        boolean checkHorizontal = checkHorizontal(plArray);
        Log.d("checkHorizontal: ", checkVertical + "");
        if (checkVertical && checkHorizontal) {
            return true;
        }
        return false;
    }

    /**
     * Khi ham nay run: neu phan tu trong mang nhap vao khac 0 thi tuong ung voi phan tu trong mang boolean = false
     */
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

    public int[] fromPuzzleString(String input) {
        int[] puzz = new int[input.length()];
        for (int i = 0; i < puzz.length; i++) {
            puzz[i] = input.charAt(i) - '0';
        }
        return puzz;
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
        //hang ngang
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += input[i][j];
            }
            if (sum == 34) {
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
        //hang doc
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += input[j][i];
            }
            if (sum == 34) {
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
        if ((input[0][0] + input[1][1] + input[2][2] +input[3][3]) == sumSquare) {
            if ((input[0][3] + input[1][2] + input[2][1] + input[3][0]) == sumSquare) {
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
