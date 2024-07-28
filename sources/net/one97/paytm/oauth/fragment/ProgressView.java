package net.one97.paytm.oauth.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;

public class ProgressView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private LottieAnimationView f56158a;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f56158a = (LottieAnimationView) findViewById(R.id.lottie_view_id);
        if (this.f56158a == null) {
            throw new IllegalArgumentException("Layout must have child with id lottie_view_id");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OAuthUtils.a(this.f56158a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        OAuthUtils.b(this.f56158a);
        super.onDetachedFromWindow();
    }
}
