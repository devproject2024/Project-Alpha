package net.one97.paytm.games.view.pfg.pinnedheader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class c extends RecyclerView.h implements a {

    /* renamed from: a  reason: collision with root package name */
    private Rect f35745a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f35746b = -1;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int top;
        int height;
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        if ((recyclerView.getAdapter() instanceof b) && recyclerView.getChildCount() > 0) {
            b bVar = (b) recyclerView.getAdapter();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            while (true) {
                if (childAdapterPosition < 0) {
                    childAdapterPosition = -1;
                    break;
                } else if (bVar.b(childAdapterPosition)) {
                    break;
                } else {
                    childAdapterPosition--;
                }
            }
            this.f35746b = childAdapterPosition;
            if (childAdapterPosition != -1) {
                RecyclerView.v onCreateViewHolder = bVar.onCreateViewHolder(recyclerView, bVar.getItemViewType(childAdapterPosition));
                bVar.onBindViewHolder(onCreateViewHolder, childAdapterPosition);
                View view = onCreateViewHolder.itemView;
                if (view.isLayoutRequested()) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (layoutParams != null) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((recyclerView.getMeasuredWidth() - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824);
                        if (layoutParams.height > 0) {
                            i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                        } else {
                            i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        }
                        view.measure(makeMeasureSpec, i2);
                        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    } else {
                        throw new NullPointerException("PinnedHeaderItemDecoration");
                    }
                }
                int i3 = 0;
                for (int i4 = 0; i4 < recyclerView.getChildCount(); i4++) {
                    if (bVar.b(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i4))) && (top = recyclerView.getChildAt(i4).getTop()) < (height = view.getHeight()) && top > 0) {
                        i3 = top - height;
                    }
                }
                int save = canvas.save();
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams2 != null) {
                    canvas.translate((float) layoutParams2.leftMargin, (float) i3);
                    canvas.clipRect(0, 0, recyclerView.getWidth(), view.getMeasuredHeight());
                    view.draw(canvas);
                    canvas.restoreToCount(save);
                    if (this.f35745a == null) {
                        this.f35745a = new Rect();
                    }
                    this.f35745a.set(0, 0, recyclerView.getWidth(), view.getMeasuredHeight() + i3);
                    return;
                }
                throw new NullPointerException("PinnedHeaderItemDecoration");
            }
            this.f35745a = null;
        }
    }

    public final Rect a() {
        return this.f35745a;
    }

    public final int b() {
        return this.f35746b;
    }
}
