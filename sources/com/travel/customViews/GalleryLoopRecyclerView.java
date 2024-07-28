package com.travel.customViews;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class GalleryLoopRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private a f23408a;

    public interface a {
        void a(int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryLoopRecyclerView(Context context) {
        super(context);
        if (context == null) {
            k.a();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryLoopRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (context == null) {
            k.a();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryLoopRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (context == null) {
            k.a();
        }
    }

    public final void setScrollStopListener(a aVar) {
        k.c(aVar, "scrollStopListener");
        this.f23408a = aVar;
    }

    public final int getFirstVisibleItemPosition() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager == null) {
            k.a();
        }
        return linearLayoutManager.findFirstCompletelyVisibleItemPosition();
    }

    public final boolean fling(int i2, int i3) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        Resources system = Resources.getSystem();
        k.a((Object) system, "Resources.getSystem()");
        int i4 = system.getDisplayMetrics().widthPixels;
        if (linearLayoutManager == null) {
            k.a();
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition());
        View findViewByPosition2 = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
        if (findViewByPosition == null) {
            k.a();
        }
        int width = (i4 - findViewByPosition.getWidth()) / 2;
        if (findViewByPosition2 == null) {
            k.a();
        }
        int left = findViewByPosition.getLeft() - width;
        int width2 = (((i4 - findViewByPosition2.getWidth()) / 2) + findViewByPosition2.getWidth()) - findViewByPosition2.getRight();
        if (i2 > 0) {
            smoothScrollBy(left, 0);
            return true;
        }
        smoothScrollBy(-width2, 0);
        return true;
    }

    public final void onScrollStateChanged(int i2) {
        super.onScrollStateChanged(i2);
        if (i2 == 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
            a aVar = this.f23408a;
            if (aVar != null && linearLayoutManager != null) {
                aVar.a(linearLayoutManager.findFirstCompletelyVisibleItemPosition());
            }
        }
    }

    public final int getOrientation() {
        if (!(getLayoutManager() instanceof LinearLayoutManager)) {
            throw new RuntimeException("Orientation not supported");
        } else if (!(getLayoutManager() instanceof GridLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null) {
                return ((LinearLayoutManager) layoutManager).getOrientation();
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        } else {
            throw new RuntimeException("Orientation not supported");
        }
    }
}
