package net.one97.paytm.common.widgets;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;

public final class g extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f49905a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f49906b;

    /* renamed from: c  reason: collision with root package name */
    private int f49907c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49908d;

    public g(Drawable drawable) {
        this(drawable, false);
    }

    public g(Drawable drawable, boolean z) {
        this.f49905a = new Rect();
        this.f49906b = drawable;
        this.f49907c = 1;
        this.f49908d = z;
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (recyclerView.getLayoutManager() != null) {
            int i6 = this.f49907c;
            if (i6 == 1 || i6 == 2) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i4 = recyclerView.getPaddingLeft();
                    i5 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i4, recyclerView.getPaddingTop(), i5, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i5 = recyclerView.getWidth();
                    i4 = 0;
                }
                int childCount = recyclerView.getChildCount() - (this.f49908d ? 1 : 0);
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = recyclerView.getChildAt(i7);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.f49905a);
                    int round = this.f49905a.bottom + Math.round(u.p(childAt));
                    this.f49906b.setBounds(i4, round - this.f49906b.getIntrinsicHeight(), i5, round);
                    this.f49906b.draw(canvas);
                }
                canvas.restore();
            }
            int i8 = this.f49907c;
            if (i8 == 0 || i8 == 2) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i2 = recyclerView.getPaddingTop();
                    i3 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                    canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), i3);
                } else {
                    i3 = recyclerView.getHeight();
                    i2 = 0;
                }
                int childCount2 = recyclerView.getChildCount() - (this.f49908d ? 1 : 0);
                for (int i9 = 0; i9 < childCount2; i9++) {
                    View childAt2 = recyclerView.getChildAt(i9);
                    recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.f49905a);
                    int round2 = this.f49905a.right + Math.round(u.o(childAt2));
                    this.f49906b.setBounds(round2 - this.f49906b.getIntrinsicWidth(), i2, round2, i3);
                    this.f49906b.draw(canvas);
                }
                canvas.restore();
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2 = this.f49907c;
        if (i2 == 1) {
            rect.set(0, 0, 0, this.f49906b.getIntrinsicHeight());
        } else if (i2 == 0) {
            rect.set(0, 0, this.f49906b.getIntrinsicWidth(), 0);
        } else {
            rect.set(0, 0, this.f49906b.getIntrinsicWidth(), this.f49906b.getIntrinsicHeight());
        }
    }
}
