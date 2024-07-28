package androidx.recyclerview.widget;

import androidx.core.d.m;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<k> f4291a = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static Comparator<b> f4292e = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            if ((bVar.f4304d == null) != (bVar2.f4304d == null)) {
                return bVar.f4304d == null ? 1 : -1;
            }
            if (bVar.f4301a != bVar2.f4301a) {
                return bVar.f4301a ? -1 : 1;
            }
            int i2 = bVar2.f4302b - bVar.f4302b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = bVar.f4303c - bVar2.f4303c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f4293b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f4294c;

    /* renamed from: d  reason: collision with root package name */
    long f4295d;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b> f4296f = new ArrayList<>();

    k() {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4301a;

        /* renamed from: b  reason: collision with root package name */
        public int f4302b;

        /* renamed from: c  reason: collision with root package name */
        public int f4303c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f4304d;

        /* renamed from: e  reason: collision with root package name */
        public int f4305e;

        b() {
        }
    }

    static class a implements RecyclerView.LayoutManager.a {

        /* renamed from: a  reason: collision with root package name */
        int f4297a;

        /* renamed from: b  reason: collision with root package name */
        int f4298b;

        /* renamed from: c  reason: collision with root package name */
        int[] f4299c;

        /* renamed from: d  reason: collision with root package name */
        int f4300d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(RecyclerView recyclerView, boolean z) {
            this.f4300d = 0;
            int[] iArr = this.f4299c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.d()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f4297a, this.f4298b, recyclerView.mState, this);
                }
                if (this.f4300d > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.f4300d;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.b();
                }
            }
        }

        public final void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f4300d * 2;
                int[] iArr = this.f4299c;
                if (iArr == null) {
                    this.f4299c = new int[4];
                    Arrays.fill(this.f4299c, -1);
                } else if (i4 >= iArr.length) {
                    this.f4299c = new int[(i4 * 2)];
                    System.arraycopy(iArr, 0, this.f4299c, 0, iArr.length);
                }
                int[] iArr2 = this.f4299c;
                iArr2[i4] = i2;
                iArr2[i4 + 1] = i3;
                this.f4300d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int i2) {
            if (this.f4299c != null) {
                int i3 = this.f4300d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f4299c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            int[] iArr = this.f4299c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4300d = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f4294c == 0) {
            this.f4294c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.f4297a = i2;
        aVar.f4298b = i3;
    }

    public final void run() {
        RecyclerView recyclerView;
        b bVar;
        long j = 0;
        try {
            m.a("RV Prefetch");
            if (!this.f4293b.isEmpty()) {
                int size = this.f4293b.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView2 = this.f4293b.get(i2);
                    if (recyclerView2.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView2.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j2) + this.f4295d;
                    int size2 = this.f4293b.size();
                    int i3 = 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        RecyclerView recyclerView3 = this.f4293b.get(i4);
                        if (recyclerView3.getWindowVisibility() == 0) {
                            recyclerView3.mPrefetchRegistry.a(recyclerView3, false);
                            i3 += recyclerView3.mPrefetchRegistry.f4300d;
                        }
                    }
                    this.f4296f.ensureCapacity(i3);
                    int i5 = 0;
                    for (int i6 = 0; i6 < size2; i6++) {
                        RecyclerView recyclerView4 = this.f4293b.get(i6);
                        if (recyclerView4.getWindowVisibility() == 0) {
                            a aVar = recyclerView4.mPrefetchRegistry;
                            int abs = Math.abs(aVar.f4297a) + Math.abs(aVar.f4298b);
                            int i7 = i5;
                            int i8 = 0;
                            while (i8 < aVar.f4300d * 2) {
                                if (i7 >= this.f4296f.size()) {
                                    bVar = new b();
                                    this.f4296f.add(bVar);
                                } else {
                                    bVar = this.f4296f.get(i7);
                                }
                                int i9 = aVar.f4299c[i8 + 1];
                                try {
                                    bVar.f4301a = i9 <= abs;
                                    bVar.f4302b = abs;
                                    bVar.f4303c = i9;
                                    bVar.f4304d = recyclerView4;
                                    bVar.f4305e = aVar.f4299c[i8];
                                    i7++;
                                    i8 += 2;
                                } catch (Throwable th) {
                                    th = th;
                                    j = 0;
                                    this.f4294c = j;
                                    m.a();
                                    throw th;
                                }
                            }
                            i5 = i7;
                        }
                    }
                    Collections.sort(this.f4296f, f4292e);
                    for (int i10 = 0; i10 < this.f4296f.size(); i10++) {
                        b bVar2 = this.f4296f.get(i10);
                        if (bVar2.f4304d == null) {
                            break;
                        }
                        RecyclerView.v a2 = a(bVar2.f4304d, bVar2.f4305e, bVar2.f4301a ? Long.MAX_VALUE : nanos);
                        if (!(a2 == null || a2.mNestedRecyclerView == null || !a2.isBound() || a2.isInvalid() || (recyclerView = (RecyclerView) a2.mNestedRecyclerView.get()) == null)) {
                            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.b() != 0) {
                                recyclerView.removeAndRecycleViews();
                            }
                            a aVar2 = recyclerView.mPrefetchRegistry;
                            aVar2.a(recyclerView, true);
                            if (aVar2.f4300d != 0) {
                                m.a("RV Nested Prefetch");
                                RecyclerView.s sVar = recyclerView.mState;
                                RecyclerView.a aVar3 = recyclerView.mAdapter;
                                sVar.f4093d = 1;
                                sVar.f4094e = aVar3.getItemCount();
                                sVar.f4096g = false;
                                sVar.f4097h = false;
                                sVar.f4098i = false;
                                for (int i11 = 0; i11 < aVar2.f4300d * 2; i11 += 2) {
                                    a(recyclerView, aVar2.f4299c[i11], nanos);
                                }
                                m.a();
                            }
                        }
                        bVar2.f4301a = false;
                        bVar2.f4302b = 0;
                        bVar2.f4303c = 0;
                        bVar2.f4304d = null;
                        bVar2.f4305e = 0;
                    }
                    j = 0;
                }
            }
            this.f4294c = j;
            m.a();
        } catch (Throwable th2) {
            th = th2;
            this.f4294c = j;
            m.a();
            throw th;
        }
    }

    private static RecyclerView.v a(RecyclerView recyclerView, int i2, long j) {
        boolean z;
        int b2 = recyclerView.mChildHelper.b();
        int i3 = 0;
        while (true) {
            if (i3 >= b2) {
                z = false;
                break;
            }
            RecyclerView.v childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.c(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return null;
        }
        RecyclerView.n nVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.v a2 = nVar.a(i2, j);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    nVar.a(a2, false);
                } else {
                    nVar.a(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }
}
