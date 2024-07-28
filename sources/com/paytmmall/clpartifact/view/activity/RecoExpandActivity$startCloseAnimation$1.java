package com.paytmmall.clpartifact.view.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class RecoExpandActivity$startCloseAnimation$1 implements Animation.AnimationListener {
    final /* synthetic */ View $itemView;
    final /* synthetic */ RecyclerView.LayoutManager $layoutManager;
    final /* synthetic */ int $pos;
    final /* synthetic */ RecoExpandActivity this$0;

    public final void onAnimationRepeat(Animation animation) {
        k.c(animation, "animation");
    }

    RecoExpandActivity$startCloseAnimation$1(RecoExpandActivity recoExpandActivity, int i2, RecyclerView.LayoutManager layoutManager, View view) {
        this.this$0 = recoExpandActivity;
        this.$pos = i2;
        this.$layoutManager = layoutManager;
        this.$itemView = view;
    }

    public final void onAnimationStart(Animation animation) {
        k.c(animation, "animation");
        if (this.$pos >= 2) {
            new Handler().postDelayed(new RecoExpandActivity$startCloseAnimation$1$onAnimationStart$1(this), 50);
        }
    }

    public final void onAnimationEnd(Animation animation) {
        k.c(animation, "animation");
        this.$itemView.setVisibility(8);
        if (this.$pos <= 1) {
            this.this$0.finish();
        }
    }
}
