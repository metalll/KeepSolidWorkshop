package root.workshop.View.MyView;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import org.androidannotations.annotations.EView;


public class GridMindMapItemView extends View {
    private int         Size;
    private String      Text="Идея";
    private int         ForegroundView=Color.WHITE;
    private int         BackgroundView= Color.RED;
    private Bitmap      bitmap = null;
    private Rect        mTextBoundRect = new Rect();
    private Paint       paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint       textPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private float         bAlpha=0;
    private float         fAlpha=0;

    public GridMindMapItemView(Context context,String Text,int Background,int bAlpha,int Foreground,int fAlpha) {
        super(context);
        this.Text=Text;
        this.BackgroundView=Background;
        this.ForegroundView=Foreground;
        this.bAlpha=bAlpha;
        this.fAlpha=fAlpha;

        this.invalidate();

    }

    public GridMindMapItemView(Context context) {
        super(context);

    }

    public GridMindMapItemView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap=bitmap;

    }

    public GridMindMapItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public GridMindMapItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GridMindMapItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mWidth = measure(widthMeasureSpec);
        int mHeight = measure(heightMeasureSpec);
        Size = Math.min(mWidth, mHeight);
        setMeasuredDimension(Size, Size);

    }


    private int measure(int measureSpec) {
        int result = 0;
        int specMoge = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMoge == MeasureSpec.UNSPECIFIED) result = 200;
        else result = specSize;
        return result;
    }



    @Override
    protected void onDraw(Canvas canvas) {



            paint.setColor(BackgroundView);
            paint.setAlpha((int)bAlpha);
            canvas.drawCircle(Size / 2, Size / 2, Size / 2.5F, paint);

            textPaint.setColor(ForegroundView);
        textPaint.setAlpha((int)fAlpha);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);

        textPaint.setTextSize(Size / 8F);

        textPaint.getTextBounds(Text, 0, Text.length(), mTextBoundRect);
            float mTextWidth = textPaint.measureText(Text);
            float mTextHeight = mTextBoundRect.height();

            canvas.drawText(Text,
                    Size / 2 - (mTextWidth / 2f),
                    Size / 2 + (mTextHeight / 2 / 2f),
                    textPaint
            );






    }

    public void setText(String text) {
        Text = text;
        this.invalidate();
    }

    public String getText()
    {
        return Text;
    }




    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.invalidate();
    }

    public float getbAlpha() {
        return bAlpha;
    }

    public float getfAlpha() {
        return fAlpha;
    }

    public void setfAlpha(float fAlpha) {
        this.fAlpha = fAlpha;
        this.invalidate();
    }

    public void setbAlpha(float bAlpha) {
        this.bAlpha = bAlpha;
        this.invalidate();
    }

    public int getBackgroundView() {
        return BackgroundView;
    }

    public void setBackgroundView(int backgroundView) {
        BackgroundView = backgroundView;
        this.invalidate();
    }

    public int getForegroundView() {
        return ForegroundView;
    }

    public void setForegroundView(int foregroundView) {
        ForegroundView = foregroundView;
        this.invalidate();
    }
}
