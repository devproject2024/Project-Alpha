package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f4354a;

    /* renamed from: b  reason: collision with root package name */
    int f4355b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f4356c;

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    /* synthetic */ u(RecyclerView.LayoutManager layoutManager, byte b2) {
        this(layoutManager);
    }

    private u(RecyclerView.LayoutManager layoutManager) {
        this.f4355b = Integer.MIN_VALUE;
        this.f4356c = new Rect();
        this.f4354a = layoutManager;
    }

    public final int a() {
        if (Integer.MIN_VALUE == this.f4355b) {
            return 0;
        }
        return e() - this.f4355b;
    }

    public static u a(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return a(layoutManager);
        }
        if (i2 == 1) {
            return b(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static u a(RecyclerView.LayoutManager layoutManager) {
        return new u(layoutManager) {
            public final int c() {
                return this.f4354a.getWidth() - this.f4354a.getPaddingRight();
            }

            public final int d() {
                return this.f4354a.getWidth();
            }

            public final void a(int i2) {
                this.f4354a.offsetChildrenHorizontal(i2);
            }

            public final int b() {
                return this.f4354a.getPaddingLeft();
            }

            public final int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4354a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4354a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int b(View view) {
                return this.f4354a.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public final int a(View view) {
                return this.f4354a.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int c(View view) {
                this.f4354a.getTransformedBoundingBox(view, true, this.f4356c);
                return this.f4356c.right;
            }

            public final int d(View view) {
                this.f4354a.getTransformedBoundingBox(view, true, this.f4356c);
                return this.f4356c.left;
            }

            public final int e() {
                return (this.f4354a.getWidth() - this.f4354a.getPaddingLeft()) - this.f4354a.getPaddingRight();
            }

            public final int f() {
                return this.f4354a.getPaddingRight();
            }

            public final int g() {
                return this.f4354a.getWidthMode();
            }

            public final int h() {
                return this.f4354a.getHeightMode();
            }
        };
    }

    public static u b(RecyclerView.LayoutManager layoutManager) {
        return new u(layoutManager) {
            public final int c() {
                return this.f4354a.getHeight() - this.f4354a.getPaddingBottom();
            }

            public final int d() {
                return this.f4354a.getHeight();
            }

            public final void a(int i2) {
                this.f4354a.offsetChildrenVertical(i2);
            }

            public final int b() {
                return this.f4354a.getPaddingTop();
            }

            public final int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4354a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f4354a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int b(View view) {
                return this.f4354a.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public final int a(View view) {
                return this.f4354a.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int c(View view) {
                this.f4354a.getTransformedBoundingBox(view, true, this.f4356c);
                return this.f4356c.bottom;
            }

            public final int d(View view) {
                this.f4354a.getTransformedBoundingBox(view, true, this.f4356c);
                return this.f4356c.top;
            }

            public final int e() {
                return (this.f4354a.getHeight() - this.f4354a.getPaddingTop()) - this.f4354a.getPaddingBottom();
            }

            public final int f() {
                return this.f4354a.getPaddingBottom();
            }

            public final int g() {
                return this.f4354a.getHeightMode();
            }

            public final int h() {
                return this.f4354a.getWidthMode();
            }
        };
    }
}
