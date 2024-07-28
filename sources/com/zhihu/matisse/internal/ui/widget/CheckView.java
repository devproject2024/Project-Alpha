package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b.f;
import com.paytm.android.chat.R;

public class CheckView extends View {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45856a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45857b;

    /* renamed from: c  reason: collision with root package name */
    private int f45858c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f45859d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f45860e;

    /* renamed from: f  reason: collision with root package name */
    private TextPaint f45861f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f45862g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f45863h;

    /* renamed from: i  reason: collision with root package name */
    private float f45864i;
    private Rect j;
    private boolean k = true;

    public CheckView(Context context) {
        super(context);
        a(context);
    }

    public CheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CheckView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (this.f45864i * 32.0f), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    private void a(Context context) {
        this.f45864i = context.getResources().getDisplayMetrics().density;
        this.f45859d = new Paint();
        this.f45859d.setAntiAlias(true);
        this.f45859d.setStyle(Paint.Style.STROKE);
        this.f45859d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.f45859d.setStrokeWidth(this.f45864i * 1.5f);
    }

    public void setChecked(boolean z) {
        if (!this.f45856a) {
            this.f45857b = z;
            invalidate();
            return;
        }
        throw new IllegalStateException("CheckView is countable, call setCheckedNum() instead.");
    }

    public void setCountable(boolean z) {
        this.f45856a = z;
    }

    public void setCheckedNum(int i2) {
        if (!this.f45856a) {
            throw new IllegalStateException("CheckView is not countable, call setChecked() instead.");
        } else if (i2 == Integer.MIN_VALUE || i2 > 0) {
            this.f45858c = i2;
            if (this.f45858c > 0) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
            invalidate();
        } else {
            throw new IllegalArgumentException("checked num can't be negative.");
        }
    }

    public void setEnabled(boolean z) {
        if (this.k != z) {
            this.k = z;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.f45862g == null) {
            this.f45862g = new Paint();
            this.f45862g.setAntiAlias(true);
            Paint paint = this.f45862g;
            float f2 = this.f45864i;
            paint.setShader(new RadialGradient((f2 * 32.0f) / 2.0f, (f2 * 32.0f) / 2.0f, f2 * 15.25f, new int[]{Color.parseColor("#00000000"), Color.parseColor("#0D000000"), Color.parseColor("#0D000000"), Color.parseColor("#00000000")}, new float[]{0.5081967f, 0.704918f, 0.8032787f, 1.0f}, Shader.TileMode.CLAMP));
        }
        float f3 = this.f45864i;
        canvas2.drawCircle((f3 * 32.0f) / 2.0f, (f3 * 32.0f) / 2.0f, f3 * 15.25f, this.f45862g);
        float f4 = this.f45864i;
        canvas2.drawCircle((f4 * 32.0f) / 2.0f, (f4 * 32.0f) / 2.0f, f4 * 11.5f, this.f45859d);
        if (this.f45856a) {
            if (this.f45858c != Integer.MIN_VALUE) {
                a();
                float f5 = this.f45864i;
                canvas2.drawCircle((f5 * 32.0f) / 2.0f, (32.0f * f5) / 2.0f, f5 * 11.0f, this.f45860e);
                if (this.f45861f == null) {
                    this.f45861f = new TextPaint();
                    this.f45861f.setAntiAlias(true);
                    this.f45861f.setColor(-1);
                    this.f45861f.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                    this.f45861f.setTextSize(this.f45864i * 12.0f);
                }
                String valueOf = String.valueOf(this.f45858c);
                canvas2.drawText(valueOf, (float) (((int) (((float) canvas.getWidth()) - this.f45861f.measureText(valueOf))) / 2), (float) (((int) ((((float) canvas.getHeight()) - this.f45861f.descent()) - this.f45861f.ascent())) / 2), this.f45861f);
            }
        } else if (this.f45857b) {
            a();
            float f6 = this.f45864i;
            canvas2.drawCircle((f6 * 32.0f) / 2.0f, (32.0f * f6) / 2.0f, f6 * 11.0f, this.f45860e);
            this.f45863h.setBounds(getCheckRect());
            this.f45863h.draw(canvas2);
        }
        setAlpha(this.k ? 1.0f : 0.5f);
    }

    private void a() {
        if (this.f45860e == null) {
            this.f45860e = new Paint();
            this.f45860e.setAntiAlias(true);
            this.f45860e.setStyle(Paint.Style.FILL);
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.item_checkCircle_backgroundColor});
            int color = obtainStyledAttributes.getColor(0, f.b(getResources(), R.color.zhihu_item_checkCircle_backgroundColor, getContext().getTheme()));
            obtainStyledAttributes.recycle();
            this.f45860e.setColor(color);
        }
    }

    private Rect getCheckRect() {
        if (this.j == null) {
            float f2 = this.f45864i;
            int i2 = (int) (((f2 * 32.0f) / 2.0f) - ((16.0f * f2) / 2.0f));
            float f3 = (float) i2;
            this.j = new Rect(i2, i2, (int) ((f2 * 32.0f) - f3), (int) ((f2 * 32.0f) - f3));
        }
        return this.j;
    }
}
