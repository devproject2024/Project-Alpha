package net.one97.paytm.p2b.view.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import kotlin.g.b.k;
import net.one97.paytm.p2b.R;

public final class P2bShimmerAnimationLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f12881a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f12882b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P2bShimmerAnimationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        LayoutInflater.from(context).inflate(R.layout.p2b_shimmer_animation_layout, this, true);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.p2b_shimmer_anim);
        k.a((Object) loadAnimation, "AnimationUtils.loadAnima… R.anim.p2b_shimmer_anim)");
        this.f12882b = loadAnimation;
        this.f12881a = findViewById(R.id.shimmer);
        this.f12882b.setFillAfter(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public P2bShimmerAnimationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public P2bShimmerAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void a() {
        View view = this.f12881a;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f12881a;
        if (view2 != null) {
            view2.clearAnimation();
        }
    }
}
