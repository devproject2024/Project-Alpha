package com.paytmmall.clpartifact.view.activity;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class RecoExpandActivity$setRecoRV$1 implements RecyclerView.k {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ RecoExpandActivity this$0;

    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        k.c(recyclerView, "rv");
        k.c(motionEvent, "e");
    }

    RecoExpandActivity$setRecoRV$1(RecoExpandActivity recoExpandActivity, RecyclerView recyclerView) {
        this.this$0 = recoExpandActivity;
        this.$recyclerView = recyclerView;
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        k.c(recyclerView, "rv");
        k.c(motionEvent, "e");
        if (this.$recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY()) != null) {
            return false;
        }
        this.this$0.goBack();
        return true;
    }
}
