package net.one97.paytm.passbook.mgv.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class GVTicketView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f57991a;

    /* renamed from: b  reason: collision with root package name */
    private Path f57992b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f57993c = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GVTicketView(Context context) {
        super(context);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GVTicketView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GVTicketView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        a();
    }

    private final void a() {
        this.f57991a = new Paint(1);
        Paint paint = this.f57991a;
        if (paint == null) {
            k.a("mPaint");
        }
        paint.setColor(-16711936);
        Paint paint2 = this.f57991a;
        if (paint2 == null) {
            k.a("mPaint");
        }
        paint2.setStrokeWidth(10.0f);
        Paint paint3 = this.f57991a;
        if (paint3 == null) {
            k.a("mPaint");
        }
        paint3.setStyle(Paint.Style.STROKE);
        this.f57993c.add(new a(0.0f));
        this.f57992b = new Path();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f57993c.add(new a(((float) getWidth()) * 0.72f));
        this.f57993c.add(new a((((float) getWidth()) * 0.72f) + 100.0f));
        this.f57993c.add(new a((float) getWidth()));
        Path path = this.f57992b;
        if (path == null) {
            k.a("mPath");
        }
        path.moveTo(this.f57993c.get(0).f57994a, this.f57993c.get(0).f57995b);
        int size = this.f57993c.size();
        for (int i2 = 1; i2 < size; i2++) {
            if (i2 == 2) {
                RectF rectF = new RectF(this.f57993c.get(i2 - 1).f57994a, 0.0f, this.f57993c.get(i2).f57994a, 40.0f);
                Path path2 = this.f57992b;
                if (path2 == null) {
                    k.a("mPath");
                }
                path2.arcTo(rectF, 0.0f, 360.0f);
            } else {
                Path path3 = this.f57992b;
                if (path3 == null) {
                    k.a("mPath");
                }
                path3.lineTo(this.f57993c.get(i2).f57994a, this.f57993c.get(i2).f57995b);
            }
        }
        if (canvas != null) {
            Path path4 = this.f57992b;
            if (path4 == null) {
                k.a("mPath");
            }
            Paint paint = this.f57991a;
            if (paint == null) {
                k.a("mPaint");
            }
            canvas.drawPath(path4, paint);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        float f57994a;

        /* renamed from: b  reason: collision with root package name */
        float f57995b = 0.0f;

        public a(float f2) {
            this.f57994a = f2;
        }
    }
}
