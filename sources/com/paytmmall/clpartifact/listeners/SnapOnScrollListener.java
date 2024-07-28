package com.paytmmall.clpartifact.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SnapOnScrollListener extends RecyclerView.l {
    private Behavior behavior;
    private ISnapPositionChangeListener onSnapPositionChangeListener;
    private final z snapHelper;
    private int snapPosition;

    public enum Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapOnScrollListener(z zVar, Behavior behavior2, ISnapPositionChangeListener iSnapPositionChangeListener, int i2, g gVar) {
        this(zVar, (i2 & 2) != 0 ? Behavior.NOTIFY_ON_SCROLL : behavior2, (i2 & 4) != 0 ? null : iSnapPositionChangeListener);
    }

    public final Behavior getBehavior() {
        return this.behavior;
    }

    public final void setBehavior(Behavior behavior2) {
        k.c(behavior2, "<set-?>");
        this.behavior = behavior2;
    }

    public final ISnapPositionChangeListener getOnSnapPositionChangeListener() {
        return this.onSnapPositionChangeListener;
    }

    public final void setOnSnapPositionChangeListener(ISnapPositionChangeListener iSnapPositionChangeListener) {
        this.onSnapPositionChangeListener = iSnapPositionChangeListener;
    }

    public SnapOnScrollListener(z zVar, Behavior behavior2, ISnapPositionChangeListener iSnapPositionChangeListener) {
        k.c(zVar, "snapHelper");
        k.c(behavior2, "behavior");
        this.snapHelper = zVar;
        this.behavior = behavior2;
        this.onSnapPositionChangeListener = iSnapPositionChangeListener;
        this.snapPosition = -1;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        if (this.behavior == Behavior.NOTIFY_ON_SCROLL) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        k.c(recyclerView, "recyclerView");
        if (this.behavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE && i2 == 0) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    private final void maybeNotifySnapPositionChange(RecyclerView recyclerView) {
        int snapPosition2 = getSnapPosition(this.snapHelper, recyclerView);
        int i2 = 0;
        if (this.snapPosition != snapPosition2) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter != null) {
                i2 = adapter.getItemCount();
            }
            if (snapPosition2 < i2) {
                ISnapPositionChangeListener iSnapPositionChangeListener = this.onSnapPositionChangeListener;
                if (iSnapPositionChangeListener != null) {
                    iSnapPositionChangeListener.onSnapPositionChange(snapPosition2);
                }
                this.snapPosition = snapPosition2;
            }
        }
    }

    public final int getSnapPosition(z zVar, RecyclerView recyclerView) {
        k.c(zVar, "receiver$0");
        k.c(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        k.a((Object) layoutManager, "recyclerView.layoutManag… RecyclerView.NO_POSITION");
        View findSnapView = zVar.findSnapView(layoutManager);
        if (findSnapView == null) {
            return -1;
        }
        k.a((Object) findSnapView, "findSnapView(layoutManag… RecyclerView.NO_POSITION");
        return layoutManager.getPosition(findSnapView);
    }
}
