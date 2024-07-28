package net.one97.paytm.moneytransfer.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;

public final class MoneyTransferShimmerAnimationLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f54139a;

    /* renamed from: b  reason: collision with root package name */
    private Animation f54140b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoneyTransferShimmerAnimationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        LayoutInflater.from(context).inflate(R.layout.mt_shimmer_animation_layout, this, true);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.mt_shimmer_anim);
        k.a((Object) loadAnimation, "AnimationUtils.loadAnima…, R.anim.mt_shimmer_anim)");
        this.f54140b = loadAnimation;
        this.f54139a = findViewById(R.id.shimmer);
        this.f54140b.setFillAfter(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MoneyTransferShimmerAnimationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MoneyTransferShimmerAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void a() {
        View view = this.f54139a;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f54139a;
        if (view2 != null) {
            view2.startAnimation(this.f54140b);
        }
    }

    public final void b() {
        View view = this.f54139a;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f54139a;
        if (view2 != null) {
            view2.clearAnimation();
        }
    }
}
