package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import net.one97.paytm.moneytransfer.R;

public final class TooltipView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f55131a;

    /* renamed from: b  reason: collision with root package name */
    private Path f55132b;

    /* renamed from: c  reason: collision with root package name */
    private Path f55133c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f55134d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f55135e;

    /* renamed from: f  reason: collision with root package name */
    private final g f55136f = h.a(new d(this));

    /* renamed from: g  reason: collision with root package name */
    private final g f55137g = h.a(new c(this));

    /* renamed from: h  reason: collision with root package name */
    private int f55138h;

    /* renamed from: i  reason: collision with root package name */
    private int f55139i;
    private a j = a.BOTTOM;
    private int k;

    public enum a {
        TOP,
        BOTTOM
    }

    static {
        Class<TooltipView> cls = TooltipView.class;
        f55131a = new i[]{y.a((v) new w(y.b(cls), "tenDips", "getTenDips()F")), y.a((v) new w(y.b(cls), "oneDips", "getOneDips()F"))};
    }

    private final float getOneDips() {
        return ((Number) this.f55137g.getValue()).floatValue();
    }

    private final float getTenDips() {
        return ((Number) this.f55136f.getValue()).floatValue();
    }

    public static final /* synthetic */ Path a(TooltipView tooltipView) {
        Path path = tooltipView.f55133c;
        if (path == null) {
            k.a("dashPath");
        }
        return path;
    }

    static final class d extends l implements kotlin.g.a.a<Float> {
        final /* synthetic */ TooltipView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TooltipView tooltipView) {
            super(0);
            this.this$0 = tooltipView;
        }

        public final float invoke() {
            return this.this$0.getResources().getDimension(R.dimen.dimen_10dp);
        }
    }

    static final class c extends l implements kotlin.g.a.a<Float> {
        final /* synthetic */ TooltipView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TooltipView tooltipView) {
            super(0);
            this.this$0 = tooltipView;
        }

        public final float invoke() {
            return this.this$0.getResources().getDimension(R.dimen.dimen_1dp);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipView(Context context) {
        super(context);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        a();
    }

    private final void a() {
        setWillNotDraw(false);
        this.f55132b = new Path();
        this.f55133c = new Path();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(new CornerPathEffect(getResources().getDimension(R.dimen.dimen_3dp)));
        this.f55135e = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.parseColor("#dde5ed"));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setPathEffect(new CornerPathEffect(getResources().getDimension(R.dimen.dimen_3dp)));
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(getResources().getDimension(R.dimen.dimen_0_5dp));
        this.f55134d = paint2;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        k.c(canvas, "canvas");
        super.onDraw(canvas);
        int i2 = this.f55138h;
        if (i2 != 0) {
            int i3 = this.k;
            if (i3 == 0) {
                this.k = i2;
            } else {
                this.f55138h = i3;
            }
            if (this.j == a.BOTTOM) {
                this.f55138h -= this.f55139i;
                Path path = this.f55132b;
                if (path == null) {
                    k.a("fillPath");
                }
                path.moveTo(0.0f, 0.0f);
                path.lineTo((float) getWidth(), 0.0f);
                path.lineTo((float) getWidth(), ((float) getHeight()) - getTenDips());
                path.lineTo(((float) this.f55138h) + getTenDips(), ((float) getHeight()) - getTenDips());
                path.lineTo((float) this.f55138h, (float) getHeight());
                path.lineTo(((float) this.f55138h) - getTenDips(), ((float) getHeight()) - getTenDips());
                path.lineTo(0.0f, ((float) getHeight()) - getTenDips());
                path.lineTo(0.0f, 0.0f);
                Path path2 = this.f55132b;
                if (path2 == null) {
                    k.a("fillPath");
                }
                Paint paint = this.f55135e;
                if (paint == null) {
                    k.a("fillPaint");
                }
                canvas.drawPath(path2, paint);
                Path path3 = this.f55133c;
                if (path3 == null) {
                    k.a("dashPath");
                }
                path3.moveTo(0.0f, 0.0f);
                path3.lineTo((float) getWidth(), 0.0f);
                path3.lineTo((float) getWidth(), ((float) getHeight()) - getTenDips());
                path3.lineTo(((float) this.f55138h) + getTenDips(), ((float) getHeight()) - getTenDips());
                path3.lineTo((float) this.f55138h, (float) getHeight());
                path3.lineTo(((float) this.f55138h) - getTenDips(), ((float) getHeight()) - getTenDips());
                path3.lineTo(0.0f, ((float) getHeight()) - getTenDips());
                path3.lineTo(0.0f, 0.0f);
                Path path4 = this.f55133c;
                if (path4 == null) {
                    k.a("dashPath");
                }
                Paint paint2 = this.f55134d;
                if (paint2 == null) {
                    k.a("dashPaint");
                }
                canvas.drawPath(path4, paint2);
            } else {
                this.f55138h -= this.f55139i;
                Path path5 = this.f55132b;
                if (path5 == null) {
                    k.a("fillPath");
                }
                path5.moveTo(0.0f, getTenDips());
                path5.lineTo(((float) this.f55138h) - getTenDips(), getTenDips());
                path5.lineTo((float) this.f55138h, 0.0f);
                path5.lineTo(((float) this.f55138h) + getTenDips(), getTenDips());
                path5.lineTo((float) getWidth(), getTenDips());
                path5.lineTo((float) getWidth(), (float) getHeight());
                path5.lineTo(0.0f, (float) getHeight());
                path5.lineTo(0.0f, getTenDips());
                Path path6 = this.f55132b;
                if (path6 == null) {
                    k.a("fillPath");
                }
                Paint paint3 = this.f55135e;
                if (paint3 == null) {
                    k.a("fillPaint");
                }
                canvas.drawPath(path6, paint3);
                Path path7 = this.f55133c;
                if (path7 == null) {
                    k.a("dashPath");
                }
                path7.moveTo(0.0f, getTenDips());
                path7.lineTo(((float) this.f55138h) - getTenDips(), getTenDips());
                path7.lineTo((float) this.f55138h, 0.0f);
                path7.lineTo(((float) this.f55138h) + getTenDips(), getTenDips());
                path7.lineTo((float) getWidth(), getTenDips());
                path7.lineTo((float) getWidth(), (float) getHeight());
                path7.lineTo(0.0f, (float) getHeight());
                path7.lineTo(0.0f, getTenDips());
                Path path8 = this.f55133c;
                if (path8 == null) {
                    k.a("dashPath");
                }
                Paint paint4 = this.f55134d;
                if (paint4 == null) {
                    k.a("dashPaint");
                }
                canvas.drawPath(path8, paint4);
            }
            Path path9 = this.f55133c;
            if (path9 == null) {
                k.a("dashPath");
            }
            canvas.clipPath(path9);
        }
    }

    public final void setArrowPosition(int i2, int i3) {
        this.f55138h = i2;
        this.f55139i = i3;
    }

    public final void setTooltipPosition(a aVar) {
        k.c(aVar, "tooltipPosition");
        this.j = aVar;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this));
        }
    }

    public static final class b extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TooltipView f55140a;

        b(TooltipView tooltipView) {
            this.f55140a = tooltipView;
        }

        public final void getOutline(View view, Outline outline) {
            if (outline != null) {
                try {
                    outline.setConvexPath(TooltipView.a(this.f55140a));
                } catch (Exception unused) {
                }
            }
        }
    }
}
