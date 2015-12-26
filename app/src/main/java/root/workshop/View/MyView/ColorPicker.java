package root.workshop.View.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPicker extends View implements View.OnTouchListener {

    protected static final int		SET_COLOR	= 0;
    protected static final int		SET_SATUR	= 1;
    protected static final int		SET_ALPHA	= 2;

    private int				mMode;

   


    float                       alpha;
    float						cx;
    float						cy;
    float						rad_1; //
    float						rad_2; //
    float						rad_3; //
    float						r_centr; // радиусы наших окружностей

    float						r_sel_c; //
    float						r_sel_s; //
    float						r_sel_a; // границы полей выбора

    // всякие краски
    private Paint				p_color = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint				p_satur = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint				p_alpha = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint				p_white = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint				p_handl = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint				p_centr = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float				deg_col; // углы поворота
    private float				deg_sat; // указателей - стрелок
    private float				deg_alp; // ********************

    private float				lc; //
    private float				lm; // отступы и выступы линий
    private float				lw; //
    private int                 curColor;
    private int[]               mColor=new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.RED};
    private int[] argb = new int[] {	255, 0, 0, 0};

    private float[] hsv = new float[] {0, 1f, 1f};
    private int					size;
    private OnColorChangeListener	listener;

    public interface OnColorChangeListener {
        public void onDismiss(int val, float alpha);
        public void onColorChanged(int val, float alpha);
    }

    public void setOnColorChangeListener(OnColorChangeListener l) {
        this.listener = l;
    }




    public ColorPicker(Context context) {
        this(context, null);
    }

    public ColorPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setFocusable(true);

        p_color.setStyle(Paint.Style.STROKE);
        p_satur.setStyle(Paint.Style.STROKE);
        p_alpha.setStyle(Paint.Style.STROKE);
        p_centr.setStyle(Paint.Style.FILL_AND_STROKE);
        p_white.setStrokeWidth(2);
        p_white.setColor(Color.WHITE);
        p_white.setStyle(Paint.Style.STROKE);
        p_handl.setStrokeWidth(5);
        p_handl.setColor(Color.WHITE);
        p_handl.setStrokeCap(Paint.Cap.ROUND);

        setOnTouchListener(this);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mWidth = measure(widthMeasureSpec);
        int mHeight = measure(heightMeasureSpec);
        size = Math.min(mWidth, mHeight);
        setMeasuredDimension(size, size);

        // Вычислили размер доступной области, определили что меньше
        // и установили размер нашей View в виде квадрата со стороной в
        // высоту или ширину экрана в зависимости от ориентации.
        // Вместо Math.min как вариант можно использовать getConfiguration,
        // величину size можно умножать на какие-нибудь коэффициенты,
        // задавая размер View относительно размера экрана. Например так:

		/*int orient = getResources().getConfiguration().orientation;

		switch (orient) {
		case Configuration.ORIENTATION_PORTRAIT:
			size = (int) (measureHeight * port);

			break;
		case Configuration.ORIENTATION_LANDSCAPE:
			size = (int) (measureHeight * land);
			break;
		}*/

        calculateSizes();
        // И запустили метод для расчетов всяких наших размеров
    }

    private int measure(int measureSpec) {
        int result = 0;
        int specMoge = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMoge == MeasureSpec.UNSPECIFIED) result = 200;
        else result = specSize;
        return result;
    }

    private void calculateSizes() {
        //
        //
        cx = size * 0.5f;
        cy = cx;
        lm = size * 0.043f;
        lw = size * 0.035f;
        rad_1 = size * 0.44f;
        r_sel_c = size * 0.39f;
        rad_2 = size * 0.34f;
        r_sel_s = size * 0.29f;
        rad_3 = size * 0.24f;
        r_sel_a = size * 0.19f;
        r_centr = size * 0.18f;

        lc = size * 0.08f;
        p_color.setStrokeWidth(lc);
        p_satur.setStrokeWidth(lc);
        p_alpha.setStrokeWidth(lc);


    }

    @Override
    protected void onDraw(Canvas c) {
        Shader s = new SweepGradient(cx, cy, mColor, null);
        p_color.setShader(s);

        super.onDraw(c);
        c.drawCircle(cx, cy, rad_1, p_color);


        SweepGradient s1 = null;
        int[] sg = new int[] {
                Color.HSVToColor(new float[] {deg_col, 1, 0}), Color.HSVToColor(new float[] {deg_col, 1, 1}), Color.HSVToColor(new float[] { hsv[0], 0, 1}), Color.HSVToColor(new float[] { hsv[0], 0, 0.5f}), Color.HSVToColor(new float[] {deg_col, 1, 0})
        };
        s1 = new SweepGradient(cx, cy, sg, null);
        p_satur.setShader(s1);

        c.drawCircle(cx, cy, rad_2, p_satur);

        c.drawCircle(cx, cy, rad_3 - lw, p_white);
        c.drawCircle(cx, cy, rad_3, p_white);
        c.drawCircle(cx, cy, rad_3 + lw, p_white);
// вытаскиваем компоненты RGB из нашего цвета
        int ir = Color.red(curColor);
        int ig = Color.green(curColor);
        int ib = Color.blue(curColor);
        // массив из двух цветов – наш и он же полностью прозрачный
        int e = Color.argb(0, ir, ig, ib);
        int[] mCol = new int[] {curColor, e};
        // Это мы уже проходили
        Shader sw = new SweepGradient(cx, cy, mCol, null);
        p_alpha.setShader(sw);

        c.drawCircle(cx, cy, rad_3, p_alpha);

        float d = deg_col;
        c.rotate(d, cx, cy);
        c.drawLine(cx + rad_1 + lm, cy, cx + rad_1 - lm, cy, p_handl);
        c.rotate(-d, cx, cy);
        d = deg_sat;
        c.rotate(d, cx, cy);
        c.drawLine(cx + rad_2 + lm, cy, cx + rad_2 - lm, cy, p_handl);
        c.rotate(-d, cx, cy);
        d = deg_alp;
        c.rotate(d, cx, cy);
        c.drawLine(cx + rad_3 + lm, cy, cx + rad_3 - lm, cy, p_handl);
        c.rotate(-d, cx, cy);

    }

    protected float getAngle(float x, float y) {
        float deg = 0;
        if (x != 0) deg = y / x;
        deg = (float) Math.toDegrees(Math.atan(deg));
        if (x < 0) deg += 180;
        else if (x > 0 && y < 0) deg += 360;
        return deg;
    }

    protected void setSatScale(float f) {
        deg_sat = f;
        if (f < 90) {
            hsv[1] = 1;
            hsv[2] = f / 90;
        }
        else if (f >= 90 && f < 180) {
            hsv[1] = 1 - (f - 90) / 90;
            hsv[2] = 1;
        }
        else {
            hsv[1] = 0;
            hsv[2] = 1 - (f - 180) / 180;
        }
        curColor = Color.HSVToColor(argb[0], hsv);
        p_centr.setColor(curColor);
    }


    protected void setAlphaScale(float f) {
        deg_alp = f;
        argb[0] = (int) (255 - f / 360 * 255);
        curColor = Color.HSVToColor(argb[0], hsv);
        alpha = (float) Color.alpha(curColor) / 255;
        p_centr.setColor(curColor);
    }

    protected void setColScale(float f) {
        deg_col = f;
        hsv[0] = f;
        curColor = Color.HSVToColor(argb[0], hsv);
        p_centr.setColor(curColor);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            // Тут мы определяем, что сделал юзер
            case MotionEvent.ACTION_DOWN:
                float a = Math.abs(event.getX() - cx);
                float b = Math.abs(event.getY() - cy);
                float c = (float) Math.sqrt(a * a + b * b);
                if (c > r_sel_c) mMode = SET_COLOR;
                else if (c < r_sel_c && c > r_sel_s) mMode = SET_SATUR;
                else if (c < r_sel_s && c > r_sel_a) mMode = SET_ALPHA;

                break;



            case MotionEvent.ACTION_MOVE:
                float x = event.getX() - cx;
                float y = event.getY() - cy;
                switch (mMode) {
                    case SET_COLOR:
                        setColScale(getAngle(x, y));
                        break;

                    case SET_SATUR:
                        setSatScale(getAngle(x, y));
                        break;

                    case SET_ALPHA:
                        setAlphaScale(getAngle(x, y));
                        break;
                }
                listener.onColorChanged(curColor,alpha);
                invalidate();

                break;





            case MotionEvent.ACTION_UP:
                v.performClick();
                break;
        }
        invalidate();
        return true;
    }

    public void setUsedColor(int color, float a) {
        curColor = color;
        Color.colorToHSV(curColor, hsv);
        setColScale(hsv[0]);
        float deg = 0;
        if (hsv[1] == 1) deg = 90 * hsv[2];
        else if (hsv[2] == 1) deg = 180 - 90 * hsv[1];
        else if (hsv[1] == 0) deg = 360 - 180 * hsv[2];
        setSatScale(deg);
        setAlphaScale(360 - 360 * a);
    }
    @Override
    public boolean performClick() {
        return super.performClick();
    }
}