package nghich.banned.project.magicproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by nghich on 10/22/2017.
 */

public class EasyTopView extends View {

    private float width;
    private float height;
    private int selX;
    private int selY;
    private static final int row = 3;
    private static final float numberFinalFloat = 3f;
    private Rect selRect = new Rect();
    private PlayEasyActivity playEasyActivity = new PlayEasyActivity();

    public EasyTopView(Context context) {
        super(context);
        this.playEasyActivity = (PlayEasyActivity) context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w / numberFinalFloat;
        height = h / numberFinalFloat;
        getRect(selX, selY, selRect);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void getRect(int x, int y, Rect rect) {
        rect.set((int) (x * width), (int) (y * height),
                (int) (x * width + width), (int) (y * height + height));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint background = new Paint();
        background.setColor(getResources().getColor(R.color.background));
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);

        Paint dark = new Paint();
        dark.setColor(getResources().getColor(R.color.square_dark));
        Paint light = new Paint();
        dark.setColor(getResources().getColor(R.color.square_light));

        //draw line
        for (int i = 0; i < row; i++) {
            canvas.drawLine(0, i * height, getWidth(), i * height, light);
            canvas.drawLine(0, i * height + 1, getWidth(), i * height + 1, light);
            canvas.drawLine(i * width, 0, i * width, getHeight(), light);
            canvas.drawLine(i * width + 1, 0, i * width + 1, getHeight(), light);
        }

        //draw number
        Paint foreground = new Paint();

        foreground.setColor(getResources().getColor(R.color.square_foreground));
        foreground.setStyle(Paint.Style.FILL);
        foreground.setTextSize(width * 0.55f);
        foreground.setTextScaleX(width / height);
        foreground.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        float x = width / 2;
        float y = (height / 2) - ((fontMetrics.ascent + fontMetrics.descent) / 2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                canvas.drawText(this.playEasyActivity.getTitleString(i,j), i * width + x, j * height + 1.5f * y, foreground);
            }
        }

        Paint selected = new Paint();
        selected.setColor(getResources().getColor(R.color.square_selected));
        canvas.drawRect(selRect, selected);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            return super.onTouchEvent(event);
        }
        select((int) (event.getX() / width),
                (int) (event.getY() / height));
        return true;
    }

    private void select(int x, int y) {
        invalidate(selRect);
        selX = Math.min(Math.max(x, 0), 2);
        selY = Math.min(Math.max(y, 0), 2);
        getRect(selX, selY, selRect);
        invalidate(selRect);
    }

    public void setSelectedTile(String title) {
        playEasyActivity.setTitle(selX, selY, title);
        invalidate();
    }
}
