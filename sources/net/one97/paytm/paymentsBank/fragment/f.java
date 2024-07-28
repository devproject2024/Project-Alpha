package net.one97.paytm.paymentsBank.fragment;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class f extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f18503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18504b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18505c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f18506d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f18507e = new Paint();

    public f(int i2, int i3, int i4, int i5, int i6) {
        float f2 = Resources.getSystem().getDisplayMetrics().density * 1.0f;
        this.f18505c = i2;
        this.f18506d.setStrokeCap(Paint.Cap.ROUND);
        this.f18506d.setStrokeWidth(f2);
        this.f18506d.setStyle(Paint.Style.STROKE);
        this.f18506d.setAntiAlias(true);
        this.f18506d.setColor(i5);
        this.f18507e.setStrokeCap(Paint.Cap.ROUND);
        this.f18507e.setStrokeWidth(f2);
        this.f18507e.setStyle(Paint.Style.FILL);
        this.f18507e.setAntiAlias(true);
        this.f18507e.setColor(i6);
        this.f18504b = i3;
        this.f18503a = i4;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            float width = (((float) recyclerView.getWidth()) - (((float) ((this.f18505c * 2) * itemCount)) + ((float) (Math.max(0, itemCount - 1) * this.f18504b)))) / 2.0f;
            float height = ((float) recyclerView.getHeight()) - (((float) this.f18503a) / 2.0f);
            int i3 = this.f18505c;
            float f2 = (float) ((i3 * 2) + this.f18504b);
            float f3 = ((float) i3) + width;
            for (int i4 = 0; i4 < itemCount; i4++) {
                canvas.drawCircle(f3, height, (float) this.f18505c, this.f18506d);
                f3 += f2;
            }
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i2 = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                i2 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else {
                return;
            }
            if (i2 != -1 && recyclerView.getLayoutManager().findViewByPosition(i2) != null) {
                int i5 = this.f18505c;
                canvas.drawCircle(width + ((float) i5) + (((float) ((i5 * 2) + this.f18504b)) * ((float) i2)), height, (float) i5, this.f18507e);
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        rect.bottom = this.f18503a;
    }
}
