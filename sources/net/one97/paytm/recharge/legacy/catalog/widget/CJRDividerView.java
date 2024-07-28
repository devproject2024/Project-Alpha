package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import net.one97.paytm.recharge.R;

@Deprecated
public class CJRDividerView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static int f62976a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f62977b;

    /* renamed from: c  reason: collision with root package name */
    private int f62978c;

    /* JADX INFO: finally extract failed */
    public CJRDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashGap, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashLength, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DividerView_dashThickness, 3);
            int color = obtainStyledAttributes.getColor(R.styleable.DividerView_color, -16777216);
            this.f62978c = obtainStyledAttributes.getInt(R.styleable.DividerView_orientation, f62976a);
            obtainStyledAttributes.recycle();
            this.f62977b = new Paint();
            this.f62977b.setAntiAlias(true);
            this.f62977b.setColor(color);
            this.f62977b.setStyle(Paint.Style.STROKE);
            this.f62977b.setStrokeWidth((float) dimensionPixelSize3);
            this.f62977b.setPathEffect(new DashPathEffect(new float[]{(float) dimensionPixelSize2, (float) dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public CJRDividerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f62978c == f62976a) {
            float height = ((float) getHeight()) * 0.5f;
            canvas.drawLine(0.0f, height, (float) getWidth(), height, this.f62977b);
            return;
        }
        float width = ((float) getWidth()) * 0.5f;
        canvas.drawLine(width, 0.0f, width, (float) getHeight(), this.f62977b);
    }
}
