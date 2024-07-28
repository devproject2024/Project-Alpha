package com.travel.customViews;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class b extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    int f23409a;

    /* renamed from: b  reason: collision with root package name */
    int f23410b = 20;

    /* renamed from: c  reason: collision with root package name */
    int f23411c;

    /* renamed from: d  reason: collision with root package name */
    int f23412d;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        super.getItemOffsets(rect, view, recyclerView, sVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            k.a();
        }
        if (adapter != null) {
            recyclerView.post(new a(this, recyclerView, view, childAdapterPosition, ((a) adapter).a()));
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.customViews.CircularAdapter");
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView f23414b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f23415c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f23416d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f23417e;

        a(b bVar, RecyclerView recyclerView, View view, int i2, int i3) {
            this.f23413a = bVar;
            this.f23414b = recyclerView;
            this.f23415c = view;
            this.f23416d = i2;
            this.f23417e = i3;
        }

        public final void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = this.f23414b;
            if (recyclerView == null) {
                throw new u("null cannot be cast to non-null type com.travel.customViews.GalleryLoopRecyclerView");
            } else if (((GalleryLoopRecyclerView) recyclerView).getOrientation() == 0) {
                b bVar = this.f23413a;
                RecyclerView recyclerView2 = this.f23414b;
                View view = this.f23415c;
                int i4 = this.f23416d;
                int i5 = this.f23417e;
                int width = recyclerView2.getWidth() - c.a((bVar.f23409a * 4) + (bVar.f23410b * 2));
                int height = recyclerView2.getHeight();
                bVar.f23412d = c.a(bVar.f23409a * 2) + width;
                c.a(i4 == 0 ? bVar.f23410b + (bVar.f23409a * 2) : bVar.f23409a);
                int i6 = i5 - 1;
                if (i4 == i6) {
                    c.a(bVar.f23410b + (bVar.f23409a * 2));
                } else {
                    c.a(bVar.f23409a);
                }
                if (i4 == 0) {
                    i3 = c.a(16);
                } else {
                    i3 = 0;
                }
                b.a(view, i3, 0, i4 == i6 ? c.a(16) : 0, 0, width, height);
                RecyclerView.LayoutManager layoutManager = ((GalleryLoopRecyclerView) this.f23414b).getLayoutManager();
                if (layoutManager != null) {
                    CenterZoomLayoutManager centerZoomLayoutManager = (CenterZoomLayoutManager) layoutManager;
                    View view2 = this.f23415c;
                    k.c(view2, "child");
                    float width2 = ((float) centerZoomLayoutManager.getWidth()) / 2.0f;
                    float f2 = centerZoomLayoutManager.f23407b * width2;
                    float min = ((((1.0f - centerZoomLayoutManager.f23406a) - 1.0f) * (Math.min(f2, Math.abs(width2 - (((float) (centerZoomLayoutManager.getDecoratedRight(view2) + centerZoomLayoutManager.getDecoratedLeft(view2))) / 2.0f))) - 0.0f)) / (f2 - 0.0f)) + 1.0f;
                    view2.setScaleX(min);
                    view2.setScaleY(min);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.customViews.CenterZoomLayoutManager");
            } else {
                b bVar2 = this.f23413a;
                ViewGroup viewGroup = this.f23414b;
                View view3 = this.f23415c;
                int i7 = this.f23416d;
                int i8 = this.f23417e;
                int width3 = viewGroup.getWidth();
                int height2 = viewGroup.getHeight() - c.a((bVar2.f23409a * 4) + (bVar2.f23410b * 2));
                bVar2.f23411c = c.a(bVar2.f23409a * 2) + height2;
                if (i7 == 0) {
                    i2 = bVar2.f23410b + (bVar2.f23409a * 2);
                } else {
                    i2 = bVar2.f23409a;
                }
                b.a(view3, 0, c.a(i2), 0, i7 == i8 + -1 ? c.a(bVar2.f23410b + (bVar2.f23409a * 2)) : c.a(bVar2.f23409a), width3, height2);
            }
        }
    }

    static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        boolean z;
        boolean z2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            boolean z3 = true;
            if (layoutParams2.leftMargin == i2 && layoutParams2.topMargin == i3 && layoutParams2.rightMargin == i4 && layoutParams2.bottomMargin == i5) {
                z = false;
            } else {
                layoutParams2.setMargins(i2, i3, i4, i5);
                z = true;
            }
            if (layoutParams2.width != i6) {
                layoutParams2.width = i6;
                z2 = true;
            } else {
                z2 = false;
            }
            if (layoutParams2.height != i7) {
                layoutParams2.height = i7;
            } else {
                z3 = false;
            }
            if (z2 || z || z3) {
                view.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }
}
