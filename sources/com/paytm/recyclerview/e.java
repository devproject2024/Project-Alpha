package com.paytm.recyclerview;

import android.view.View;
import com.paytm.recyclerview.RecyclerView;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f15351a;

    /* renamed from: b  reason: collision with root package name */
    int f15352b;

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    /* synthetic */ e(RecyclerView.LayoutManager layoutManager, byte b2) {
        this(layoutManager);
    }

    private e(RecyclerView.LayoutManager layoutManager) {
        this.f15352b = Integer.MIN_VALUE;
        this.f15351a = layoutManager;
    }

    public final int a() {
        if (Integer.MIN_VALUE == this.f15352b) {
            return 0;
        }
        return e() - this.f15352b;
    }

    public static e a(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return a(layoutManager);
        }
        if (i2 == 1) {
            return b(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static e a(RecyclerView.LayoutManager layoutManager) {
        return new e(layoutManager) {
            public final int c() {
                return this.f15351a.n - this.f15351a.k();
            }

            public final int d() {
                return this.f15351a.n;
            }

            public final void a(int i2) {
                RecyclerView.LayoutManager layoutManager = this.f15351a;
                if (layoutManager.f15224i != null) {
                    RecyclerView recyclerView = layoutManager.f15224i;
                    int a2 = recyclerView.f15209d.a();
                    for (int i3 = 0; i3 < a2; i3++) {
                        recyclerView.f15209d.b(i3).offsetLeftAndRight(i2);
                    }
                }
            }

            public final int b() {
                return this.f15351a.i();
            }

            public final int c(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return RecyclerView.LayoutManager.c(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int d(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return RecyclerView.LayoutManager.d(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int b(View view) {
                return RecyclerView.LayoutManager.g(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public final int a(View view) {
                return RecyclerView.LayoutManager.e(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int e() {
                return (this.f15351a.n - this.f15351a.i()) - this.f15351a.k();
            }

            public final int f() {
                return this.f15351a.k();
            }

            public final int g() {
                return this.f15351a.l;
            }
        };
    }

    private static e b(RecyclerView.LayoutManager layoutManager) {
        return new e(layoutManager) {
            public final int c() {
                return this.f15351a.o - this.f15351a.l();
            }

            public final int d() {
                return this.f15351a.o;
            }

            public final void a(int i2) {
                RecyclerView.LayoutManager layoutManager = this.f15351a;
                if (layoutManager.f15224i != null) {
                    RecyclerView recyclerView = layoutManager.f15224i;
                    int a2 = recyclerView.f15209d.a();
                    for (int i3 = 0; i3 < a2; i3++) {
                        recyclerView.f15209d.b(i3).offsetTopAndBottom(i2);
                    }
                }
            }

            public final int b() {
                return this.f15351a.j();
            }

            public final int c(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return RecyclerView.LayoutManager.d(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int d(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return RecyclerView.LayoutManager.c(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int b(View view) {
                return RecyclerView.LayoutManager.h(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public final int a(View view) {
                return RecyclerView.LayoutManager.f(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int e() {
                return (this.f15351a.o - this.f15351a.j()) - this.f15351a.l();
            }

            public final int f() {
                return this.f15351a.l();
            }

            public final int g() {
                return this.f15351a.m;
            }
        };
    }
}
