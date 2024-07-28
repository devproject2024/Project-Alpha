package net.one97.paytm.passbook.subWallet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import easypay.manager.Constants;
import net.one97.paytm.passbook.R;

public class DividerView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static int f58916a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f58917b = 1;

    /* renamed from: c  reason: collision with root package name */
    private Paint f58918c;

    /* renamed from: d  reason: collision with root package name */
    private int f58919d;

    /* JADX INFO: finally extract failed */
    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashGap, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashLength, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashThickness, 3);
            this.f58919d = obtainStyledAttributes.getInt(R.styleable.DividerView_dvorientation, f58917b);
            obtainStyledAttributes.recycle();
            this.f58918c = new Paint();
            this.f58918c.setAntiAlias(true);
            this.f58918c.setColor(Color.rgb(Constants.EASY_PAY_MINIMIZE_ASSIST, 229, 237));
            this.f58918c.setStyle(Paint.Style.STROKE);
            this.f58918c.setStrokeWidth((float) dimensionPixelSize3);
            this.f58918c.setPathEffect(new DashPathEffect(new float[]{(float) dimensionPixelSize2, (float) dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public DividerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f58919d == f58916a) {
            float height = ((float) getHeight()) * 0.5f;
            canvas.drawLine(0.0f, height, (float) getWidth(), height, this.f58918c);
            return;
        }
        float width = ((float) getWidth()) * 0.5f;
        canvas.drawLine(width, 0.0f, width, (float) getHeight(), this.f58918c);
    }
}
