package root.workshop.View.MyView;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

import root.workshop.BL.GlobalManager;
import root.workshop.Model.MindMap;
import root.workshop.R;

/**
 * Created by root on 24.12.15.
 */
public class MindMapView extends FrameLayout {
    Context context;

    private int         Size;
    private Paint       paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private float       cx;
    private float       cy;

    public MindMapView(Context context) {

        super(context);
        this.context=context;
        setWillNotDraw(false); //разрешаем рисовать в ViewGroup

    }

    public MindMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        setWillNotDraw(false); //разрешаем рисовать в ViewGroup
    }

    public MindMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        setWillNotDraw(false); //разрешаем рисовать в ViewGroup
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MindMapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context=context;
        setWillNotDraw(false); //разрешаем рисовать в ViewGroup
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mWidth = measure(widthMeasureSpec);
        int mHeight = measure(heightMeasureSpec);
        Size = Math.min(mWidth, mHeight);
        setMeasuredDimension(Size, Size);


        getChildAt(0).measure(Size / 5, Size / 5);


        if(getChildCount()>1) {

            for (int i = 1; i < getChildCount();) {



                View v = getChildAt(i);
                v.measure(Size / 5, Size / 5);
                v.setX(new BigDecimal((Size / 2.9) * Math.cos((i - 1) * ((360 / getChildCount() - 1))) + cx / 2 + (Size / 5) / 2).floatValue());
                v.setY(new BigDecimal((Size / 2.9) * Math.sin((i - 1) * (360 / (getChildCount() - 1))) + cy / 2 + (Size / 5) /2).floatValue());
                v.invalidate();

                i++;
            }
        }

        calcSizes();
    }


    private int measure(int measureSpec) {
        int result = 0;
        int specMoge = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMoge == MeasureSpec.UNSPECIFIED) result = 200;
        else result = specSize;
        return result;
    }

    private void calcSizes()
    {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        cx = Size * 0.5f;
        cy = cx;





    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,Size/2.9f,paint);

    }
}
