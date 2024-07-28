package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.R;

public class AppCompatSeekBar extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private final j f1488a;

    public AppCompatSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        y.a((View) this, getContext());
        this.f1488a = new j(this);
        this.f1488a.a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j jVar = this.f1488a;
        if (jVar.f1752c != null) {
            int max = jVar.f1751b.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = jVar.f1752c.getIntrinsicWidth();
                int intrinsicHeight = jVar.f1752c.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                jVar.f1752c.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((jVar.f1751b.getWidth() - jVar.f1751b.getPaddingLeft()) - jVar.f1751b.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) jVar.f1751b.getPaddingLeft(), (float) (jVar.f1751b.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    jVar.f1752c.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        j jVar = this.f1488a;
        Drawable drawable = jVar.f1752c;
        if (drawable != null && drawable.isStateful() && drawable.setState(jVar.f1751b.getDrawableState())) {
            jVar.f1751b.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        j jVar = this.f1488a;
        if (jVar.f1752c != null) {
            jVar.f1752c.jumpToCurrentState();
        }
    }
}
