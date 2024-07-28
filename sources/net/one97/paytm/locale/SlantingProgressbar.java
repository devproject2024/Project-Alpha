package net.one97.paytm.locale;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.paytm.utility.q;
import net.one97.paytm.landingpage.R;

public class SlantingProgressbar extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f53052a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f53053b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f53054c = 5;

    /* renamed from: d  reason: collision with root package name */
    private float f53055d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f53056e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f53057f;

    /* renamed from: g  reason: collision with root package name */
    private String f53058g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f53059h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f53060i = "#fc3d39";

    public SlantingProgressbar(Context context) {
        super(context);
    }

    public SlantingProgressbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SlantingProgressBarLocale, 0, 0);
        try {
            setProgress(obtainStyledAttributes.getInt(R.styleable.SlantingProgressBarLocale_slantingProgress, 0));
            setBackgroundColor(obtainStyledAttributes.getString(R.styleable.SlantingProgressBarLocale_progressBackgroundColor));
            setBorderRadius(obtainStyledAttributes.getInt(R.styleable.SlantingProgressBarLocale_borderRadius, 20));
            setRoundedBorderColor(obtainStyledAttributes.getInt(R.styleable.SlantingProgressBarLocale_barBorderColor, 0));
            setProgressColor(obtainStyledAttributes.getString(R.styleable.SlantingProgressBarLocale_slantingProgressColor));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setBorderRadius(int i2) {
        this.f53054c = i2;
    }

    public int getProgress() {
        return this.f53056e;
    }

    public void setProgress(int i2) {
        if (i2 >= 0) {
            this.f53056e = i2;
            invalidate();
            return;
        }
        q.b("Invalid 'progress' value detected, value should be between 0 and 100");
    }

    public void setRoundedBorderColor(int i2) {
        if (i2 == 0) {
            this.f53057f = getResources().getColor(R.color.white);
            q.b("Color set to White: " + this.f53057f);
            return;
        }
        this.f53057f = i2;
        q.b("Color set to custom: " + this.f53057f);
    }

    private int getRoundedBorderColor() {
        return this.f53057f;
    }

    public void setSlantingProgressFullColor(String str) {
        if (TextUtils.isEmpty(this.f53060i)) {
            this.f53060i = "#fc3d39";
        }
    }

    public void setBackgroundColor(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f53058g = "#CBF1FD";
        } else {
            this.f53058g = str;
        }
    }

    public void setProgressColor(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f53059h = "#00b9f5";
        } else {
            this.f53059h = str;
        }
    }

    public float getViewHeight() {
        return this.f53052a;
    }

    public void setViewHeight(float f2) {
        this.f53052a = f2;
    }

    public float getViewWidth() {
        return this.f53053b;
    }

    public void setViewWidth(float f2) {
        this.f53053b = f2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f53052a = (float) getHeight();
        this.f53053b = (float) getWidth();
        this.f53055d = getProcessedProgress();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(this.f53058g));
        canvas.drawPaint(paint);
        paint.setColor(getProcessedProgressColor());
        paint.setAntiAlias(true);
        q.d("Height: " + this.f53052a);
        canvas.drawRect(0.0f, 0.0f, this.f53055d, this.f53052a, paint);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(this.f53055d, 0.0f);
        path.lineTo(this.f53055d + this.f53052a, 0.0f);
        path.lineTo(this.f53055d, this.f53052a);
        path.close();
        canvas.drawPath(path, paint);
        int roundedBorderColor = getRoundedBorderColor();
        float height = (float) getHeight();
        float width = (float) getWidth();
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(roundedBorderColor);
        paint2.setAntiAlias(true);
        Path path2 = new Path();
        path2.moveTo(0.0f, 0.0f);
        float f2 = height / 2.0f;
        path2.lineTo(0.0f, f2);
        int i2 = this.f53054c;
        path2.quadTo(height / ((float) i2), height / ((float) i2), f2, 0.0f);
        path2.lineTo(0.0f, 0.0f);
        canvas.drawPath(path2, paint2);
        path2.reset();
        path2.moveTo(0.0f, height);
        path2.lineTo(f2, height);
        int i3 = this.f53054c;
        path2.quadTo(height / ((float) i3), height - (height / ((float) i3)), 0.0f, f2);
        path2.lineTo(0.0f, height);
        canvas.drawPath(path2, paint2);
        path2.reset();
        path2.moveTo(width, 0.0f);
        float f3 = width - f2;
        path2.lineTo(f3, 0.0f);
        int i4 = this.f53054c;
        path2.quadTo(width - (height / ((float) i4)), height / ((float) i4), width, f2);
        path2.lineTo(width, 0.0f);
        canvas.drawPath(path2, paint2);
        path2.reset();
        path2.moveTo(width, height);
        path2.lineTo(f3, height);
        int i5 = this.f53054c;
        path2.quadTo(width - (height / ((float) i5)), height - (height / ((float) i5)), width, f2);
        path2.lineTo(width, height);
        canvas.drawPath(path2, paint2);
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        int i6 = (roundedBorderColor & 16777215) | 1711276032;
        q.d("Faded Color Code: ".concat(String.valueOf(i6)));
        paint3.setColor(i6);
        Canvas canvas2 = canvas;
        float f4 = height;
        Paint paint4 = paint3;
        canvas2.drawRect(0.0f, 0.0f, 1.0f, f4, paint4);
        canvas2.drawRect(width - 1.0f, 0.0f, width, f4, paint4);
    }

    private float getProcessedProgress() {
        return (float) ((this.f53056e == 99 ? getWidth() * 98 : getWidth() * this.f53056e) / 100);
    }

    private int getProcessedProgressColor() {
        if (this.f53056e > 100) {
            return Color.parseColor(this.f53060i);
        }
        return Color.parseColor(this.f53059h);
    }
}
