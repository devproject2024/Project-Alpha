package net.one97.paytm.passbook.search.b;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private C1128a f58392a;

    /* renamed from: b  reason: collision with root package name */
    private int f58393b;

    /* renamed from: net.one97.paytm.passbook.search.b.a$a  reason: collision with other inner class name */
    public interface C1128a {
        int a(int i2);

        void a(View view, int i2);

        int b(int i2);

        boolean c(int i2);
    }

    public a(C1128a aVar) {
        this.f58392a = aVar;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int childAdapterPosition;
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) != -1) {
            int a2 = this.f58392a.a(childAdapterPosition);
            View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(this.f58392a.b(a2), recyclerView, false);
            this.f58392a.a(inflate, a2);
            inflate.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), inflate.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), inflate.getLayoutParams().height));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            this.f58393b = measuredHeight;
            inflate.layout(0, 0, measuredWidth, measuredHeight);
            int bottom = inflate.getBottom();
            View view = null;
            int i3 = 0;
            while (true) {
                if (i3 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt2 = recyclerView.getChildAt(i3);
                int height = (a2 == i3 || !this.f58392a.c(recyclerView.getChildAdapterPosition(childAt2))) ? 0 : this.f58393b - childAt2.getHeight();
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
            if (view == null || !this.f58392a.c(recyclerView.getChildAdapterPosition(view))) {
                canvas.save();
                canvas.translate(0.0f, 0.0f);
                inflate.draw(canvas);
                canvas.restore();
                return;
            }
            canvas.save();
            canvas.translate(0.0f, (float) (view.getTop() - inflate.getHeight()));
            inflate.draw(canvas);
            canvas.restore();
        }
    }
}
