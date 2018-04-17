package nghich.banned.project.magicproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by nghich on 10/29/2017.
 */

public class NormalTopView extends View {
    private float width;
    private float height;
    private int selX;
    private int selY;
    private Rect selRect = new Rect();
    private static final float numberFinalFloat = 4f;
    private static final int numberFinalInt = 4;
    private static final float textSize = 0.55f;

    private PlayNormalActivity playNormalActivity = new PlayNormalActivity();
    public NormalTopView(Context context) {
        super(context);
        this.playNormalActivity = (PlayNormalActivity) context;
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
        for (int i = 0; i < numberFinalInt; i++) {
            canvas.drawLine(0, i * height, getWidth(), i * height, light);
            canvas.drawLine(0, i * height + 1, getWidth(), i * height + 1, light);
            canvas.drawLine(i * width, 0, i * width, getHeight(), light);
            canvas.drawLine(i * width + 1, 0, i * width + 1, getHeight(), light);
        }

        //draw number
        Paint foreground = new Paint();

        foreground.setColor(getResources().getColor(R.color.square_foreground));
        foreground.setStyle(Paint.Style.FILL);
        foreground.setTextSize(width * textSize);
        foreground.setTextScaleX(width / height);
        foreground.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        float x = width / 2;
        float y = (height / 2) - ((fontMetrics.ascent + fontMetrics.descent) / 2);
        for (int i = 0; i < numberFinalInt; i++) {
            for (int j = 0; j < numberFinalInt; j++) {
                canvas.drawText(this.playNormalActivity.getTitleString(i,j), i * width + x, j * height + 1.5f * y, foreground);
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
        select((int) (event.getX() / width), (int) (event.getY() / height));
        return true;
    }

    private void select(int x, int y) {
        invalidate(selRect);
        selX = Math.min(Math.max(x, 0), numberFinalInt -1);
        selY = Math.min(Math.max(y, 0), numberFinalInt -1);
        getRect(selX, selY, selRect);
        invalidate(selRect);
    }

    public void setSelectedTile(String title) {
        playNormalActivity.setTitle(selX, selY, title);
        invalidate();
    }
}
