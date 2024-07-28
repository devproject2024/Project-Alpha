package com.business.common_module.zxingutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.business.common_module.R;
import com.google.zxing.t;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f7385b = {0, 64, 128, 192, PriceRangeSeekBar.INVALID_POINTER_ID, 192, 128, 64};

    /* renamed from: a  reason: collision with root package name */
    List<t> f7386a;

    /* renamed from: c  reason: collision with root package name */
    private e f7387c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f7388d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f7389e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7390f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7391g;

    /* renamed from: h  reason: collision with root package name */
    private final int f7392h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7393i;
    private int j;
    private List<t> k;
    private boolean l;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f7390f = resources.getColor(R.color.viewfinder_mask);
        this.f7391g = resources.getColor(R.color.result_view);
        this.f7392h = resources.getColor(R.color.viewfinder_laser);
        this.f7393i = resources.getColor(R.color.possible_result_points);
        this.j = 0;
        this.f7386a = new ArrayList(5);
        this.k = null;
    }

    public final void setScanOnly(boolean z) {
        this.l = z;
    }

    public final void setCameraManagerModified(e eVar) {
        this.f7387c = eVar;
    }

    public final void onDraw(Canvas canvas) {
        e eVar = this.f7387c;
        if (eVar != null) {
            Rect e2 = eVar.e();
            Rect f2 = this.f7387c.f();
            if (e2 != null && f2 != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.f7388d.setColor(this.f7389e != null ? this.f7391g : this.f7390f);
                float f3 = (float) width;
                canvas.drawRect(0.0f, 0.0f, f3, (float) e2.top, this.f7388d);
                canvas.drawRect(0.0f, (float) e2.top, (float) e2.left, (float) (e2.bottom + 1), this.f7388d);
                float f4 = f3;
                canvas.drawRect((float) (e2.right + 1), (float) e2.top, f4, (float) (e2.bottom + 1), this.f7388d);
                canvas.drawRect(0.0f, (float) (e2.bottom + 1), f4, (float) height, this.f7388d);
                NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(R.drawable.frame);
                ninePatchDrawable.setBounds(e2.left + 0, e2.top + 0, e2.right + 0, e2.bottom + 0);
                ninePatchDrawable.draw(canvas);
                if (this.f7389e != null) {
                    this.f7388d.setAlpha(160);
                    canvas.drawBitmap(this.f7389e, (Rect) null, e2, this.f7388d);
                    return;
                }
                this.f7388d.setColor(this.f7392h);
                this.f7388d.setAlpha(f7385b[this.j]);
                this.j = (this.j + 1) % f7385b.length;
                float width2 = ((float) e2.width()) / ((float) f2.width());
                float height2 = ((float) e2.height()) / ((float) f2.height());
                List<t> list = this.f7386a;
                List<t> list2 = this.k;
                int i2 = e2.left;
                int i3 = e2.top;
                if (list.isEmpty()) {
                    this.k = null;
                } else {
                    this.f7386a = new ArrayList(5);
                    this.k = list;
                    this.f7388d.setAlpha(160);
                    this.f7388d.setColor(this.f7393i);
                    synchronized (list) {
                        for (t next : list) {
                            canvas.drawCircle((float) (((int) (next.f40584a * width2)) + i2), (float) (((int) (next.f40585b * height2)) + i3), 6.0f, this.f7388d);
                        }
                    }
                }
                if (list2 != null) {
                    this.f7388d.setAlpha(80);
                    this.f7388d.setColor(this.f7393i);
                    synchronized (list2) {
                        for (t next2 : list2) {
                            canvas.drawCircle((float) (((int) (next2.f40584a * width2)) + i2), (float) (((int) (next2.f40585b * height2)) + i3), 3.0f, this.f7388d);
                        }
                    }
                }
                postInvalidateDelayed(80, e2.left - 6, e2.top - 6, e2.right + 6, e2.bottom + 6);
            }
        }
    }

    public final void a() {
        Bitmap bitmap = this.f7389e;
        this.f7389e = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }
}
