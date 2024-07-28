package net.one97.paytm.wallet.newdesign.fastscan.FastScan;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import net.one97.paytm.wallet.R;

public class ScanAnimationView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private TranslateAnimation f70876a;

    public ScanAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(b.a(context, R.drawable.new_scanner_anim_gradient));
        setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f70876a == null) {
            this.f70876a = new TranslateAnimation(0.0f, 0.0f, 0.0f, ((a(200) - a(60)) - a(2)) - a(4));
            this.f70876a.setDuration(2000);
            this.f70876a.setRepeatMode(2);
            this.f70876a.setRepeatCount(-1);
        }
    }

    private float a(int i2) {
        return TypedValue.applyDimension(1, (float) i2, getContext().getResources().getDisplayMetrics());
    }

    public final void a() {
        if (this.f70876a != null) {
            setVisibility(0);
            startAnimation(this.f70876a);
        }
    }

    public void setAnimationColor(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            getBackground().setTint(i2);
        } else {
            getBackground().mutate().setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
    }

    public final void b() {
        clearAnimation();
        setVisibility(4);
    }
}
