package root.workshop.View.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by root on 15.12.15.
 */
public class GridMindMapItemView extends View {
    private Paint mButtonPaint;
    private String text;
    int maxWidth = 90;
    float realWidth = 0;
    int cnt = 0;
    int backgr;
    Paint paint = new Paint();

    public GridMindMapItemView(Context context,String text,int backgr) {
        super(context); this.text=text;
        this.backgr = backgr;
        float[] measuredWidth = new float[1];
        cnt = paint.breakText(text, true, maxWidth, measuredWidth);
        realWidth = measuredWidth[0];
    }

    public GridMindMapItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridMindMapItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        super.onSizeChanged(w, w, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setWillNotDraw(false);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);



        mButtonPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mButtonPaint.setStyle(Paint.Style.FILL);
        mButtonPaint.setShadowLayer(10.0f, 0.0f, 3.5f, Color.argb(100, 0, 0, 0));

        setClickable(true);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2.6), mButtonPaint);


        paint.setColor(Color.WHITE);
        paint.setTextSize(15);


        canvas.drawText(text, getWidth() / 2 - realWidth / 2-4, getHeight() / 2+4,paint);


    }


}
