package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRShimmerAnimationLayout extends RelativeLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRShimmerAnimationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        LayoutInflater.from(context).inflate(R.layout.shimmer_animation_layout, this, true);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.recharge_shimmer);
        View findViewById = findViewById(R.id.shimmer);
        k.a((Object) findViewById, "findViewById<View>(R.id.shimmer)");
        findViewById.setVisibility(0);
        k.a((Object) loadAnimation, "animation");
        loadAnimation.setFillAfter(false);
        findViewById(R.id.shimmer).startAnimation(loadAnimation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRShimmerAnimationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRShimmerAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }
}
