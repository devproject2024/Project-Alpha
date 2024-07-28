package com.travel.widget;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class b extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private a f28589a;

    /* renamed from: b  reason: collision with root package name */
    private C0495b f28590b;

    /* renamed from: c  reason: collision with root package name */
    private int f28591c;

    /* renamed from: d  reason: collision with root package name */
    private int f28592d = -1;

    public interface a {
        int a();

        int a(int i2);

        void a(View view, int i2);

        boolean b(int i2);
    }

    /* renamed from: com.travel.widget.b$b  reason: collision with other inner class name */
    public interface C0495b {
        void a(int i2, View view);
    }

    public b(a aVar, C0495b bVar) {
        this.f28589a = aVar;
        this.f28590b = bVar;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int childAdapterPosition;
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) != -1) {
            int a2 = this.f28589a.a(childAdapterPosition);
            View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(this.f28589a.a(), recyclerView, false);
            this.f28589a.a(inflate, a2);
            inflate.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), inflate.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), inflate.getLayoutParams().height));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            this.f28591c = measuredHeight;
            inflate.layout(0, 0, measuredWidth, measuredHeight);
            int bottom = inflate.getBottom();
            View view = null;
            int i3 = 0;
            while (true) {
                if (i3 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt2 = recyclerView.getChildAt(i3);
                int height = (a2 == i3 || !this.f28589a.b(recyclerView.getChildAdapterPosition(childAt2))) ? 0 : this.f28591c - childAt2.getHeight();
                if (childAt2.getTop() > 0) {
                    i2 = childAt2.getBottom() + height;
                } else {
                    i2 = childAt2.getBottom();
                }
                if (i2 > bottom && childAt2.getTop() <= bottom) {
                    view = childAt2;
                    break;
                }
                i3++;
            }
            if ((view == null || !this.f28589a.b(recyclerView.getChildAdapterPosition(view))) && this.f28592d != a2) {
                C0495b bVar = this.f28590b;
                if (bVar != null) {
                    bVar.a(a2, inflate);
                }
                this.f28592d = a2;
            }
        }
    }
}
