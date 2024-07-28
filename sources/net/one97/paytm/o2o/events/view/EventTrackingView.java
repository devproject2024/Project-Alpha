package net.one97.paytm.o2o.events.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.common.CJREventTrackingInfo;

public class EventTrackingView extends FrameLayout {
    /* access modifiers changed from: private */
    public static final Typeface G = Typeface.create(Typeface.DEFAULT, 0);
    /* access modifiers changed from: private */
    public static final Typeface H = Typeface.create(Typeface.DEFAULT, 1);
    public a A;
    Drawable B;
    Drawable C;
    Drawable D;
    Drawable E;
    Drawable F;
    private Context I;
    private float J;
    private float K;

    /* renamed from: a  reason: collision with root package name */
    float f73788a;

    /* renamed from: b  reason: collision with root package name */
    float f73789b;

    /* renamed from: c  reason: collision with root package name */
    float f73790c;

    /* renamed from: d  reason: collision with root package name */
    float f73791d;

    /* renamed from: e  reason: collision with root package name */
    float f73792e;

    /* renamed from: f  reason: collision with root package name */
    float f73793f;

    /* renamed from: g  reason: collision with root package name */
    float f73794g;

    /* renamed from: h  reason: collision with root package name */
    public float f73795h;

    /* renamed from: i  reason: collision with root package name */
    public float f73796i;
    float j;
    float k;
    float l;
    float m;
    public float n = 0.0f;
    int o;
    int p;
    int q;
    int r;
    int s = -7829368;
    int t = Color.parseColor("#20bf7a");
    int u = -65536;
    String v;
    String w;
    Paint x = new Paint();
    ArrayList<b> y = new ArrayList<>();
    public List<CJREventTrackingInfo> z;

    public EventTrackingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = context;
        setWillNotDraw(false);
        this.f73788a = this.I.getResources().getDimension(R.dimen.item_status_big_circle_radius);
        this.f73789b = this.I.getResources().getDimension(R.dimen.item_status_progress_small_circle_radius);
        this.f73790c = this.I.getResources().getDimension(R.dimen.item_status_line_width);
        this.f73791d = this.I.getResources().getDimension(R.dimen.item_order_status_text_size);
        this.f73792e = this.I.getResources().getDimension(R.dimen.item_order_date_text_size);
        this.f73793f = this.I.getResources().getDimension(R.dimen.item_order_text_top_margin);
        this.f73794g = this.I.getResources().getDimension(R.dimen.item_order_text_height);
        this.J = this.I.getResources().getDimension(R.dimen.item_status_progress_start_end_padding);
        this.f73796i = this.I.getResources().getDimension(R.dimen.dimen_30dp);
        this.j = this.I.getResources().getDimension(R.dimen.normal_vertical_line_height);
        this.k = this.I.getResources().getDimension(R.dimen.circle_to_line_gap);
        this.l = this.I.getResources().getDimension(R.dimen.status_date_text_width);
        this.m = this.I.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_y);
        this.K = this.I.getResources().getDimension(R.dimen.dimen_20dp);
        this.q = this.I.getResources().getColor(R.color.greyish_brown);
        this.r = this.I.getResources().getColor(R.color.color_909090);
        this.s = this.I.getResources().getColor(R.color.item_status_small_circle_color);
        this.u = this.I.getResources().getColor(R.color.item_status_redish_color);
        this.t = this.I.getResources().getColor(R.color.item_status_greenish_color);
        this.D = this.I.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.gree_tick_icon);
        this.E = this.I.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.small_green_circle);
        this.C = this.I.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.auto_cancel_icon);
        this.B = this.I.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.dispatch_due_icon);
        this.F = this.I.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.small_grey_circle);
        this.v = this.I.getResources().getString(R.string.format_yyyy_mm_dd_hh_mm_ss_str);
        this.w = this.I.getResources().getString(R.string.format_dd_MMM_str);
        this.f73795h = this.f73796i;
        setLayerType(1, (Paint) null);
    }

    public void setViewHeight(float f2) {
        setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ((f2 + this.K) - this.j)));
    }

    public final Point a() {
        int i2;
        a aVar;
        this.y = new ArrayList<>();
        float f2 = this.f73793f;
        float f3 = this.f73795h;
        Point point = new Point(0, 0);
        int i3 = (int) f3;
        Point point2 = new Point((int) f2, i3);
        Point point3 = null;
        final int i4 = 0;
        float f4 = 0.0f;
        while (i4 < this.z.size()) {
            CJREventTrackingInfo cJREventTrackingInfo = this.z.get(i4);
            if (cJREventTrackingInfo != null) {
                int i5 = this.q;
                String str = cJREventTrackingInfo.isActive() ? "green" : "grey";
                String a2 = i.a(cJREventTrackingInfo.getDate(), this.v, this.w);
                if ("grey".equalsIgnoreCase(str)) {
                    i5 = this.r;
                }
                this.y.add(new d(a2, i5, this.f73792e, new Point(com.paytm.utility.b.c(20), i3)));
                int i6 = this.t;
                point2.x = (int) (((float) point2.x) + this.f73793f + this.l);
                if (f4 == 0.0f) {
                    f4 = (float) point2.x;
                } else {
                    point2.x = (int) f4;
                }
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 112785) {
                    if (hashCode == 98619139 && str.equals("green")) {
                        c2 = 0;
                    }
                } else if (str.equals("red")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    aVar = new a(this.D, this.f73788a, new Point(point2));
                } else if (c2 != 1) {
                    aVar = new a(this.F, this.f73789b, new Point(point2));
                    i6 = this.s;
                } else {
                    aVar = new a(this.C, this.f73788a, new Point(point2));
                }
                this.y.add(aVar);
                i2 = i3;
                d dVar = new d(cJREventTrackingInfo.getLabel(), i5, this.f73791d, new Point((int) (((float) point2.x) + this.f73793f), point2.y));
                this.y.add(dVar);
                if (!TextUtils.isEmpty(cJREventTrackingInfo.getInfo())) {
                    Paint paint = new Paint();
                    dVar.a(paint);
                    Rect rect = new Rect();
                    paint.getTextBounds(dVar.f73806a, 0, dVar.f73806a.length(), rect);
                    int width = (int) (((float) point2.x) + this.f73793f + ((float) ((int) ((float) rect.width()))));
                    TextView textView = (TextView) LayoutInflater.from(this.I).inflate(R.layout.event_summary_info, this, false);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    layoutParams.leftMargin = width + com.paytm.utility.b.a(3, getContext());
                    layoutParams.topMargin = point2.y - (((int) dVar.b(new Paint())) >> 1);
                    textView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            EventTrackingView.this.A.a(i4);
                        }
                    });
                    addView(textView);
                }
                if (point3 != null) {
                    this.y.add(new c(i6, new Point(point3), new Point(point2.x, (int) (((float) point2.y) - (aVar.f73799a + this.k))), this.f73790c));
                }
                float f5 = this.j;
                point2.y = (int) (((float) point2.y) + aVar.f73799a + this.k);
                Point point4 = new Point(point2);
                point2.y = (int) (((float) point2.y) + aVar.f73799a + this.k + f5);
                point2.x = (int) (((float) point2.x) - (this.l + this.f73793f));
                this.n = Math.max(this.n, (float) point2.y);
                point3 = point4;
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return point;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.o = getWidth();
        this.p = getHeight();
        this.x.setAntiAlias(true);
        Iterator<b> it2 = this.y.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            Paint paint = this.x;
            next.a(paint);
            next.a(canvas, paint);
        }
    }

    static abstract class b {
        public abstract void a(Canvas canvas, Paint paint);

        public abstract void a(Paint paint);

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        float f73799a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f73800b;

        /* renamed from: c  reason: collision with root package name */
        private Point f73801c;

        public final void a(Paint paint) {
        }

        a(Drawable drawable, float f2, Point point) {
            super((byte) 0);
            this.f73800b = drawable;
            this.f73799a = f2;
            this.f73801c = point;
        }

        public final void a(Canvas canvas, Paint paint) {
            this.f73800b.setBounds((int) (((float) this.f73801c.x) - this.f73799a), (int) (((float) this.f73801c.y) - this.f73799a), (int) (((float) this.f73801c.x) + this.f73799a), (int) (((float) this.f73801c.y) + this.f73799a));
            this.f73800b.draw(canvas);
        }
    }

    static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private int f73802a;

        /* renamed from: b  reason: collision with root package name */
        private Point f73803b;

        /* renamed from: c  reason: collision with root package name */
        private Point f73804c;

        /* renamed from: d  reason: collision with root package name */
        private float f73805d;

        c(int i2, Point point, Point point2, float f2) {
            super((byte) 0);
            this.f73802a = i2;
            this.f73803b = point;
            this.f73804c = point2;
            this.f73805d = f2;
        }

        public final void a(Paint paint) {
            paint.setStrokeWidth(this.f73805d);
            paint.setColor(this.f73802a);
        }

        public final void a(Canvas canvas, Paint paint) {
            canvas.drawLine((float) this.f73803b.x, (float) this.f73803b.y, (float) this.f73804c.x, (float) this.f73804c.y, paint);
        }
    }

    static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        String f73806a;

        /* renamed from: b  reason: collision with root package name */
        boolean f73807b;

        /* renamed from: c  reason: collision with root package name */
        private int f73808c;

        /* renamed from: d  reason: collision with root package name */
        private float f73809d;

        /* renamed from: e  reason: collision with root package name */
        private Point f73810e;

        /* renamed from: f  reason: collision with root package name */
        private int f73811f = -1;

        public d(String str, int i2, float f2, Point point) {
            super((byte) 0);
            this.f73809d = f2;
            this.f73808c = i2;
            this.f73810e = point;
            if (str == null) {
                this.f73806a = "";
            } else {
                this.f73806a = str;
            }
            this.f73807b = true;
        }

        public final void a(Paint paint) {
            if (this.f73807b) {
                paint.setTypeface(EventTrackingView.H);
            } else {
                paint.setTypeface(EventTrackingView.G);
            }
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(this.f73809d);
            paint.setColor(this.f73808c);
        }

        public final void a(Canvas canvas, Paint paint) {
            canvas.drawText(this.f73806a, (float) this.f73810e.x, ((float) this.f73810e.y) + (b(paint) / 2.0f), paint);
        }

        public final float b(Paint paint) {
            int i2 = this.f73811f;
            if (i2 > 0) {
                return (float) i2;
            }
            a(paint);
            Rect rect = new Rect();
            String str = this.f73806a;
            paint.getTextBounds(str, 0, str.length(), rect);
            int height = rect.height();
            this.f73811f = height;
            return (float) height;
        }
    }
}
