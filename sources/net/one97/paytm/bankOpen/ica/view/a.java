package net.one97.paytm.bankOpen.ica.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f16624a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16625b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16626c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f16627d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f16628e = new Paint();

    public a(int i2, int i3, int i4, int i5, int i6) {
        float f2 = Resources.getSystem().getDisplayMetrics().density * 1.0f;
        this.f16626c = i2;
        this.f16627d.setStrokeCap(Paint.Cap.ROUND);
        this.f16627d.setStrokeWidth(f2);
        this.f16627d.setStyle(Paint.Style.STROKE);
        this.f16627d.setAntiAlias(true);
        this.f16627d.setColor(i5);
        this.f16628e.setStrokeCap(Paint.Cap.ROUND);
        this.f16628e.setStrokeWidth(f2);
        this.f16628e.setStyle(Paint.Style.FILL);
        this.f16628e.setAntiAlias(true);
        this.f16628e.setColor(i6);
        this.f16625b = i3;
        this.f16624a = i4;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            float width = (((float) recyclerView.getWidth()) - (((float) ((this.f16626c * 2) * itemCount)) + ((float) (Math.max(0, itemCount - 1) * this.f16625b)))) / 2.0f;
            float height = ((float) recyclerView.getHeight()) - (((float) this.f16624a) / 2.0f);
            int i3 = this.f16626c;
            float f2 = (float) ((i3 * 2) + this.f16625b);
            float f3 = ((float) i3) + width;
            for (int i4 = 0; i4 < itemCount; i4++) {
                canvas.drawCircle(f3, height, (float) this.f16626c, this.f16627d);
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
                int i5 = this.f16626c;
                canvas.drawCircle(width + ((float) i5) + (((float) ((i5 * 2) + this.f16625b)) * ((float) i2)), height, (float) i5, this.f16628e);
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        rect.bottom = this.f16624a;
    }
}
