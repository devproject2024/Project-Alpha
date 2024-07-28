package com.google.zxing.client.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.business.merchant_payments.mapqr.vision.ViewFinder;
import com.google.zxing.client.android.a.d;
import com.google.zxing.t;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f40097c = {0, 64, 128, 192, PriceRangeSeekBar.INVALID_POINTER_ID, 192, 128, 64};

    /* renamed from: a  reason: collision with root package name */
    Bitmap f40098a;

    /* renamed from: b  reason: collision with root package name */
    List<t> f40099b;

    /* renamed from: d  reason: collision with root package name */
    private d f40100d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f40101e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    private final int f40102f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40103g;

    /* renamed from: h  reason: collision with root package name */
    private final int f40104h;

    /* renamed from: i  reason: collision with root package name */
    private final int f40105i;
    private int j;
    private List<t> k;
    private boolean l;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f40102f = resources.getColor(R.color.viewfinder_mask);
        this.f40103g = resources.getColor(R.color.result_view);
        this.f40104h = resources.getColor(R.color.viewfinder_laser);
        this.f40105i = resources.getColor(R.color.possible_result_points);
        this.j = 0;
        this.f40099b = new ArrayList(5);
        this.k = null;
    }

    public final void setScanOnly(boolean z) {
        this.l = z;
    }

    public final void setCameraManager(d dVar) {
        this.f40100d = dVar;
    }

    public final void onDraw(Canvas canvas) {
        Rect rect;
        d dVar = this.f40100d;
        if (dVar != null) {
            if (this.l) {
                Point point = dVar.f40123a.f40119b;
                if (point == null) {
                    rect = null;
                } else {
                    int a2 = d.a(point.x, (int) ViewFinder.MAX_FRAME_WIDTH);
                    int a3 = d.a(point.y, 675);
                    int i2 = (point.x - a2) / 2;
                    int i3 = (point.y - a3) / 2;
                    Rect rect2 = new Rect(i2, i3, i2 + a2, a2 + i3);
                    new StringBuilder("Calculated framing rect: ").append(rect2);
                    rect = rect2;
                }
            } else {
                rect = dVar.e();
            }
            Rect f2 = this.f40100d.f();
            if (rect != null && f2 != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.f40101e.setColor(this.f40098a != null ? this.f40103g : this.f40102f);
                float f3 = (float) width;
                canvas.drawRect(0.0f, 0.0f, f3, (float) rect.top, this.f40101e);
                canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), this.f40101e);
                float f4 = f3;
                canvas.drawRect((float) (rect.right + 1), (float) rect.top, f4, (float) (rect.bottom + 1), this.f40101e);
                canvas.drawRect(0.0f, (float) (rect.bottom + 1), f4, (float) height, this.f40101e);
                NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(R.drawable.frame);
                ninePatchDrawable.setBounds(rect.left + 0, rect.top + 0, rect.right + 0, rect.bottom + 0);
                ninePatchDrawable.draw(canvas);
                if (this.f40098a != null) {
                    this.f40101e.setAlpha(160);
                    canvas.drawBitmap(this.f40098a, (Rect) null, rect, this.f40101e);
                    return;
                }
                this.f40101e.setColor(this.f40104h);
                this.f40101e.setAlpha(f40097c[this.j]);
                this.j = (this.j + 1) % f40097c.length;
                float width2 = ((float) rect.width()) / ((float) f2.width());
                float height2 = ((float) rect.height()) / ((float) f2.height());
                List<t> list = this.f40099b;
                List<t> list2 = this.k;
                int i4 = rect.left;
                int i5 = rect.top;
                if (list.isEmpty()) {
                    this.k = null;
                } else {
                    this.f40099b = new ArrayList(5);
                    this.k = list;
                    this.f40101e.setAlpha(160);
                    this.f40101e.setColor(this.f40105i);
                    synchronized (list) {
                        for (t next : list) {
                            canvas.drawCircle((float) (((int) (next.f40584a * width2)) + i4), (float) (((int) (next.f40585b * height2)) + i5), 6.0f, this.f40101e);
                        }
                    }
                }
                if (list2 != null) {
                    this.f40101e.setAlpha(80);
                    this.f40101e.setColor(this.f40105i);
                    synchronized (list2) {
                        for (t next2 : list2) {
                            canvas.drawCircle((float) (((int) (next2.f40584a * width2)) + i4), (float) (((int) (next2.f40585b * height2)) + i5), 3.0f, this.f40101e);
                        }
                    }
                }
                postInvalidateDelayed(80, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
            }
        }
    }
}
