package com.paytmmall.clpartifact.view.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

abstract class BaseLayoutMargin extends RecyclerView.h {
    private OnClickLayoutMarginItemListener listener;
    private final MarginDelegate marginDelegate;
    private final int spacing;
    private final int spanCount;

    BaseLayoutMargin(int i2, int i3) {
        this.spanCount = i2;
        this.spacing = i3;
        this.marginDelegate = new MarginDelegate(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void setOnClickLayoutMarginItemListener(OnClickLayoutMarginItemListener onClickLayoutMarginItemListener) {
        this.listener = onClickLayoutMarginItemListener;
    }

    /* access modifiers changed from: package-private */
    public void setPadding(RecyclerView recyclerView, int i2) {
        setPadding(recyclerView, i2, i2, i2, i2);
    }

    /* access modifiers changed from: package-private */
    public void setPadding(RecyclerView recyclerView, int i2, int i3, int i4, int i5) {
        recyclerView.setClipToPadding(false);
        recyclerView.setScrollBarStyle(33554432);
        recyclerView.setPadding(i4, i2, i5, i3);
    }

    /* access modifiers changed from: package-private */
    public MarginDelegate getMarginDelegate() {
        return this.marginDelegate;
    }

    /* access modifiers changed from: package-private */
    public void calculateMargin(Rect rect, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.marginDelegate.calculateMargin(rect, i2, i3, i4, i5, z, z2);
    }

    public int getSpacing() {
        return this.spacing;
    }

    public int getSpanCount() {
        return this.spanCount;
    }

    /* access modifiers changed from: package-private */
    public void setupClickLayoutMarginItem(Context context, View view, int i2, int i3, RecyclerView.s sVar) {
        if (this.listener != null) {
            view.setOnClickListener(onClickItem(context, view, i2, i3, sVar));
        }
    }

    private View.OnClickListener onClickItem(Context context, View view, int i2, int i3, RecyclerView.s sVar) {
        return new View.OnClickListener(context, view, i2, i3, sVar) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ View f$2;
            private final /* synthetic */ int f$3;
            private final /* synthetic */ int f$4;
            private final /* synthetic */ RecyclerView.s f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void onClick(View view) {
                BaseLayoutMargin.this.lambda$onClickItem$0$BaseLayoutMargin(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view);
            }
        };
    }

    public /* synthetic */ void lambda$onClickItem$0$BaseLayoutMargin(Context context, View view, int i2, int i3, RecyclerView.s sVar, View view2) {
        OnClickLayoutMarginItemListener onClickLayoutMarginItemListener = this.listener;
        if (onClickLayoutMarginItemListener != null) {
            onClickLayoutMarginItemListener.onClick(context, view, i2, i3, sVar);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
    }
}
