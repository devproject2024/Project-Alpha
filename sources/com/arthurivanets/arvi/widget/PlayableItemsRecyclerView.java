package com.arthurivanets.arvi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.arthurivanets.arvi.b.b.a;
import com.arthurivanets.arvi.k;
import com.arthurivanets.arvi.widget.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class PlayableItemsRecyclerView extends RecyclerView implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<c.b> f31029a = a.a(c.b.DRAGGING, c.b.IDLING);

    /* renamed from: b  reason: collision with root package name */
    private final Set<c.b> f31030b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private int f31031c;

    /* renamed from: d  reason: collision with root package name */
    private int f31032d;

    /* renamed from: e  reason: collision with root package name */
    private c.a f31033e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31034f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31035g;

    public PlayableItemsRecyclerView(Context context) {
        super(context);
        c();
    }

    public PlayableItemsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public PlayableItemsRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        this.f31031c = 0;
        this.f31032d = 0;
        this.f31033e = c.a.ONE_AT_A_TIME;
        this.f31034f = true;
        this.f31030b.addAll(f31029a);
        setRecyclerListener(new RecyclerView.o() {
            public final void onViewRecycled(RecyclerView.v vVar) {
                PlayableItemsRecyclerView.this.a(vVar);
            }
        });
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final void onChildAttachedToWindow(View view) {
        super.onChildAttachedToWindow(view);
        RecyclerView.v childViewHolder = getChildViewHolder(view);
        if (childViewHolder instanceof a) {
            a aVar = (a) childViewHolder;
            if (k.a(getContext()).c(aVar.i(), aVar.h()) && k.a(getContext()).a(aVar.i(), aVar.h()).j() && aVar.l()) {
                aVar.a();
            }
        }
    }

    public final void onChildDetachedFromWindow(View view) {
        super.onChildDetachedFromWindow(view);
        RecyclerView.v childViewHolder = getChildViewHolder(view);
        if (childViewHolder instanceof a) {
            ((a) childViewHolder).d();
        }
    }

    /* access modifiers changed from: private */
    public void a(RecyclerView.v vVar) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            if (!aVar.l()) {
                aVar.d();
            }
        }
    }

    public final void a(boolean z) {
        ArrayList<a> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        boolean equals = c.a.MULTIPLE_SIMULTANEOUSLY.equals(this.f31033e);
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v findContainingViewHolder = findContainingViewHolder(getChildAt(i2));
            if (findContainingViewHolder instanceof a) {
                a aVar = (a) findContainingViewHolder;
                if (aVar.k()) {
                    arrayList.add(aVar);
                }
            }
        }
        for (a aVar2 : arrayList) {
            if (aVar2.l() && (!z2 || equals)) {
                if (!aVar2.j() && this.f31034f && z) {
                    aVar2.a();
                }
                z2 = true;
            } else if (aVar2.j()) {
                aVar2.b();
            }
        }
    }

    public final void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v findContainingViewHolder = findContainingViewHolder(getChildAt(i2));
            if (findContainingViewHolder instanceof a) {
                a aVar = (a) findContainingViewHolder;
                if (aVar.k()) {
                    aVar.d();
                }
            }
        }
    }

    public final c.a getAutoplayMode() {
        return this.f31033e;
    }

    public final void setPlaybackTriggeringStates(c.b... bVarArr) {
        com.arthurivanets.arvi.b.b.c.a((Object) bVarArr);
        this.f31030b.clear();
        this.f31030b.addAll(bVarArr.length == 0 ? f31029a : a.a(bVarArr));
    }

    public final Set<c.b> getPlaybackTriggeringStates() {
        return this.f31030b;
    }

    private static c.b a(int i2) {
        if (i2 == 1) {
            return c.b.DRAGGING;
        }
        if (i2 != 2) {
            return c.b.IDLING;
        }
        return c.b.SETTLING;
    }

    public final void setAutoplayEnabled(boolean z) {
        this.f31034f = z;
        if (z) {
            a(true);
            return;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v findContainingViewHolder = findContainingViewHolder(getChildAt(i2));
            if (findContainingViewHolder instanceof a) {
                a aVar = (a) findContainingViewHolder;
                if (aVar.k()) {
                    aVar.c();
                }
            }
        }
    }

    public final void onScrollStateChanged(int i2) {
        super.onScrollStateChanged(i2);
        a(d());
    }

    public final void onScrolled(int i2, int i3) {
        super.onScrolled(i2, i3);
        this.f31035g = Math.abs(this.f31031c - i2) > 0 || Math.abs(this.f31032d - i3) > 0;
        a(d());
        this.f31031c = i2;
        this.f31032d = i3;
    }

    private boolean d() {
        c.b a2 = a(getScrollState());
        return this.f31030b.contains(a2) && ((c.b.DRAGGING.equals(a2) && !this.f31035g) || c.b.SETTLING.equals(a2) || c.b.IDLING.equals(a2));
    }

    public final void a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v findContainingViewHolder = findContainingViewHolder(getChildAt(i2));
            if (findContainingViewHolder instanceof a) {
                a aVar = (a) findContainingViewHolder;
                if (aVar.k()) {
                    aVar.b();
                }
            }
        }
    }

    public final void setAutoplayMode(c.a aVar) {
        com.arthurivanets.arvi.b.b.c.a((Object) aVar);
        this.f31033e = aVar;
        if (this.f31034f) {
            a(true);
        }
    }
}
