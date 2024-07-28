package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.h.u;
import java.util.ArrayList;
import net.one97.paytm.common.entity.p2p.SenderDisplayInformation;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.a;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final int f55141a;

    /* renamed from: b  reason: collision with root package name */
    final View f55142b;

    /* renamed from: c  reason: collision with root package name */
    final PopupWindow f55143c;

    /* renamed from: d  reason: collision with root package name */
    final c f55144d;

    /* renamed from: e  reason: collision with root package name */
    View f55145e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f55146f;

    /* renamed from: g  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f55147g;

    /* renamed from: h  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f55148h;

    /* renamed from: i  reason: collision with root package name */
    final ViewTreeObserver.OnScrollChangedListener f55149i;
    final View.OnAttachStateChangeListener j;
    private final float k;
    private final SenderDisplayInformation l;
    private final b m;
    private Context n;
    private ArrayList<String> o;

    public interface b {
        void a(SenderDisplayInformation senderDisplayInformation);
    }

    public interface c {
        void a();
    }

    /* synthetic */ a(C0999a aVar, byte b2) {
        this(aVar);
    }

    private a(C0999a aVar) {
        LinearLayout.LayoutParams layoutParams;
        this.f55147g = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                c.a(a.this.f55145e.getViewTreeObserver(), this);
                ViewTreeObserver viewTreeObserver = a.this.f55142b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnScrollChangedListener(a.this.f55149i);
                }
                if (a.this.f55146f != null) {
                    a.this.f55145e.getViewTreeObserver().addOnGlobalLayoutListener(a.this.f55148h);
                }
                PointF a2 = a.a(a.this);
                a.this.f55143c.setClippingEnabled(true);
                a.this.f55143c.update((int) a2.x, (int) a2.y, a.this.f55143c.getWidth(), a.this.f55143c.getHeight());
            }
        };
        this.f55148h = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                float f2;
                float f3;
                c.a(a.this.f55145e.getViewTreeObserver(), this);
                RectF a2 = b.a(a.this.f55142b);
                RectF a3 = b.a(a.this.f55145e);
                int i2 = -1;
                if (Gravity.isVertical(a.this.f55141a)) {
                    f2 = ((float) a.this.f55145e.getPaddingLeft()) + b.a(2.0f);
                    float width = ((a3.width() / 2.0f) - (((float) a.this.f55146f.getWidth()) / 2.0f)) - (a3.centerX() - a2.centerX());
                    if (width > f2) {
                        f2 = (((float) a.this.f55146f.getWidth()) + width) + f2 > a3.width() ? (a3.width() - ((float) a.this.f55146f.getWidth())) - f2 : width;
                    }
                    float top = (float) a.this.f55146f.getTop();
                    if (a.this.f55141a != 48) {
                        i2 = 1;
                    }
                    f3 = top + ((float) i2);
                } else {
                    float paddingTop = ((float) a.this.f55145e.getPaddingTop()) + b.a(2.0f);
                    float height = ((a3.height() / 2.0f) - (((float) a.this.f55146f.getHeight()) / 2.0f)) - (a3.centerY() - a2.centerY());
                    f3 = height > paddingTop ? (((float) a.this.f55146f.getHeight()) + height) + paddingTop > a3.height() ? (a3.height() - ((float) a.this.f55146f.getHeight())) - paddingTop : height : paddingTop;
                    float left = (float) a.this.f55146f.getLeft();
                    if (a.this.f55141a != 3) {
                        i2 = 1;
                    }
                    f2 = ((float) i2) + left;
                }
                a.this.f55146f.setX(f2);
                a.this.f55146f.setY(f3);
            }
        };
        this.f55149i = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                PointF a2 = a.a(a.this);
                a.this.f55143c.update((int) a2.x, (int) a2.y, a.this.f55143c.getWidth(), a.this.f55143c.getHeight());
            }
        };
        this.j = new View.OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                a.this.f55143c.dismiss();
            }
        };
        this.f55141a = Gravity.getAbsoluteGravity(aVar.f55160e, u.j(aVar.k));
        this.k = aVar.f55164i;
        this.f55142b = aVar.k;
        this.n = this.f55142b.getContext();
        this.l = aVar.f55161f;
        this.f55143c = new PopupWindow(aVar.j);
        this.f55143c.setWidth(this.n.getResources().getDisplayMetrics().widthPixels - this.n.getResources().getDimensionPixelOffset(R.dimen.dimen_32dp));
        this.f55143c.setHeight(-2);
        PopupWindow popupWindow = this.f55143c;
        int i2 = aVar.m;
        View inflate = ((LayoutInflater) this.n.getSystemService("layout_inflater")).inflate(R.layout.mt_v4_tooltip, (ViewGroup) null);
        ((TooltipView) inflate.findViewById(R.id.root)).setArrowPosition(i2, this.n.getResources().getDimensionPixelOffset(R.dimen.dimen_16dp));
        this.f55145e = inflate.findViewById(R.id.root);
        ((TextView) inflate.findViewById(R.id.heading)).setText(this.l.getHeading());
        ((TextView) inflate.findViewById(R.id.message)).setText(this.l.getDisplayMessage());
        TextView textView = (TextView) inflate.findViewById(R.id.ctaLink);
        if (!TextUtils.isEmpty(this.l.getCtaText())) {
            textView.setText(this.l.getCtaText());
        }
        textView.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ a.C0999a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.this.a(this.f$1, view);
            }
        });
        if (aVar.f55159d) {
            this.f55146f = new ImageView(aVar.j);
            if (Gravity.isVertical(this.f55141a)) {
                layoutParams = new LinearLayout.LayoutParams((int) aVar.f55163h, (int) aVar.f55162g, 0.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams((int) aVar.f55162g, (int) aVar.f55163h, 0.0f);
            }
            layoutParams.gravity = 17;
            this.f55146f.setLayoutParams(layoutParams);
            if (this.f55141a != 48) {
                Gravity.getAbsoluteGravity(8388611, u.j(this.f55142b));
            }
        }
        int a2 = (int) b.a(5.0f);
        int i3 = this.f55141a;
        if (i3 == 3) {
            this.f55145e.setPadding(a2, 0, 0, 0);
        } else if (i3 == 5) {
            this.f55145e.setPadding(0, 0, a2, 0);
        } else if (i3 == 48 || i3 == 80) {
            this.f55145e.setPadding(a2, 0, a2, 0);
        }
        popupWindow.setContentView(this.f55145e);
        this.f55143c.setOutsideTouchable(aVar.f55158c);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f55143c.setElevation((float) this.n.getResources().getDimensionPixelOffset(R.dimen.dimen_4dp));
        }
        this.f55143c.setBackgroundDrawable(new ColorDrawable(0));
        this.m = aVar.f55156a;
        this.f55144d = aVar.f55157b;
        this.o = new ArrayList<>();
        this.f55143c.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public final void onDismiss() {
                a.this.f55144d.a();
                a.this.f55142b.getViewTreeObserver().removeOnScrollChangedListener(a.this.f55149i);
                a.this.f55142b.removeOnAttachStateChangeListener(a.this.j);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(C0999a aVar, View view) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.l);
            this.o.clear();
            this.o.add(String.valueOf(aVar.l));
            this.o.add(aVar.n);
            this.o.add(this.l.getCtaText());
            try {
                d.c().a(view.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_INFO_CTA_CLICKED, this.o, "", CJRGTMConstants.MT_V4_BOTTOMSHEET, "wallet");
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
        this.f55143c.dismiss();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.a$a  reason: collision with other inner class name */
    public static final class C0999a {

        /* renamed from: a  reason: collision with root package name */
        b f55156a;

        /* renamed from: b  reason: collision with root package name */
        c f55157b;

        /* renamed from: c  reason: collision with root package name */
        boolean f55158c;

        /* renamed from: d  reason: collision with root package name */
        boolean f55159d;

        /* renamed from: e  reason: collision with root package name */
        int f55160e;

        /* renamed from: f  reason: collision with root package name */
        SenderDisplayInformation f55161f;

        /* renamed from: g  reason: collision with root package name */
        float f55162g;

        /* renamed from: h  reason: collision with root package name */
        float f55163h;

        /* renamed from: i  reason: collision with root package name */
        float f55164i;
        Context j;
        View k;
        boolean l;
        int m;
        String n;
        private boolean o;
        private int p;
        private int q;
        private int r;
        private float s;
        private float t = 1.0f;
        private Drawable u;
        private CharSequence v;
        private ColorStateList w;
        private Typeface x = Typeface.DEFAULT;

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x00b1, code lost:
            if (r5 == null) goto L_0x00b5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0999a(android.view.View r4, int r5) {
            /*
                r3 = this;
                r3.<init>()
                r0 = 1065353216(0x3f800000, float:1.0)
                r3.t = r0
                android.graphics.Typeface r0 = android.graphics.Typeface.DEFAULT
                r3.x = r0
                android.content.Context r0 = r4.getContext()
                r3.j = r0
                r3.k = r4
                int[] r4 = net.one97.paytm.moneytransfer.R.styleable.Tooltip
                android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r5, r4)
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_cancelable
                r0 = 0
                boolean r5 = r4.getBoolean(r5, r0)
                r3.f55158c = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_dismissOnClick
                boolean r5 = r4.getBoolean(r5, r0)
                r3.o = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_arrowEnabled
                r0 = 1
                boolean r5 = r4.getBoolean(r5, r0)
                r3.f55159d = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_backgroundColor
                r1 = -7829368(0xffffffffff888888, float:NaN)
                int r5 = r4.getColor(r5, r1)
                r3.p = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_cornerRadius
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                float r5 = r4.getDimension(r5, r1)
                r3.s = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_arrowHeight
                float r5 = r4.getDimension(r5, r1)
                r3.f55162g = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_arrowWidth
                float r5 = r4.getDimension(r5, r1)
                r3.f55163h = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_arrowDrawable
                android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
                r3.u = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_margin
                float r5 = r4.getDimension(r5, r1)
                r3.f55164i = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_padding
                r1 = -1
                int r5 = r4.getDimensionPixelSize(r5, r1)
                r3.r = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_gravity
                r2 = 80
                int r5 = r4.getInteger(r5, r2)
                r3.f55160e = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_text
                java.lang.String r5 = r4.getString(r5)
                r3.v = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_textColor
                android.content.res.ColorStateList r5 = r4.getColorStateList(r5)
                r3.w = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_textStyle
                int r5 = r4.getInteger(r5, r1)
                r3.q = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_lineSpacingMultiplier
                float r2 = r3.t
                float r5 = r4.getFloat(r5, r2)
                r3.t = r5
                int r5 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_fontFamily
                java.lang.String r5 = r4.getString(r5)
                int r2 = net.one97.paytm.moneytransfer.R.styleable.Tooltip_android_typeface
                int r1 = r4.getInt(r2, r1)
                int r2 = r3.q
                if (r5 == 0) goto L_0x00b4
                android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r2)
                if (r5 != 0) goto L_0x00c6
                goto L_0x00b5
            L_0x00b4:
                r5 = 0
            L_0x00b5:
                if (r1 == r0) goto L_0x00c4
                r0 = 2
                if (r1 == r0) goto L_0x00c1
                r0 = 3
                if (r1 == r0) goto L_0x00be
                goto L_0x00c6
            L_0x00be:
                android.graphics.Typeface r5 = android.graphics.Typeface.MONOSPACE
                goto L_0x00c6
            L_0x00c1:
                android.graphics.Typeface r5 = android.graphics.Typeface.SERIF
                goto L_0x00c6
            L_0x00c4:
                android.graphics.Typeface r5 = android.graphics.Typeface.SANS_SERIF
            L_0x00c6:
                r3.x = r5
                r4.recycle()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.a.C0999a.<init>(android.view.View, int):void");
        }

        public final C0999a a() {
            this.f55158c = true;
            return this;
        }

        public final C0999a a(boolean z) {
            this.l = z;
            return this;
        }

        public final C0999a a(String str) {
            this.n = str;
            return this;
        }

        public final C0999a a(int i2) {
            this.f55164i = this.j.getResources().getDimension(i2);
            return this;
        }

        public final C0999a b() {
            this.f55160e = 48;
            return this;
        }

        public final C0999a a(b bVar) {
            this.f55156a = bVar;
            return this;
        }

        public final C0999a a(SenderDisplayInformation senderDisplayInformation) {
            this.f55161f = senderDisplayInformation;
            return this;
        }

        public final C0999a b(int i2) {
            this.m = i2;
            return this;
        }

        public final C0999a a(c cVar) {
            this.f55157b = cVar;
            return this;
        }

        public final a c() {
            if (this.f55162g == -1.0f) {
                this.f55162g = this.j.getResources().getDimension(R.dimen.default_tooltip_arrow_height);
            }
            if (this.f55163h == -1.0f) {
                this.f55163h = this.j.getResources().getDimension(R.dimen.default_tooltip_arrow_width);
            }
            if (this.f55164i == -1.0f) {
                this.f55164i = this.j.getResources().getDimension(R.dimen.default_tooltip_margin);
            }
            if (this.r == -1) {
                this.r = this.j.getResources().getDimensionPixelSize(R.dimen.default_tooltip_padding);
            }
            a aVar = new a(this, (byte) 0);
            if (!aVar.f55143c.isShowing()) {
                aVar.f55145e.getViewTreeObserver().addOnGlobalLayoutListener(aVar.f55147g);
                aVar.f55142b.addOnAttachStateChangeListener(aVar.j);
                aVar.f55142b.post(new Runnable() {
                    public final void run() {
                        PointF a2 = a.a(a.this);
                        if (a.this.f55142b.isShown()) {
                            a.this.f55143c.showAsDropDown(a.this.f55142b, (int) a2.x, (int) a2.y);
                        }
                    }
                });
            }
            return aVar;
        }
    }

    static /* synthetic */ PointF a(a aVar) {
        PointF pointF = new PointF();
        View view = aVar.f55142b;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        RectF rectF = new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getMeasuredWidth()), (float) (iArr[1] + view.getMeasuredHeight()));
        PointF pointF2 = new PointF(rectF.centerX(), rectF.centerY());
        int i2 = aVar.f55141a;
        if (i2 == 3) {
            pointF.x = (rectF.left - ((float) aVar.f55145e.getWidth())) - aVar.k;
            pointF.y = pointF2.y - (((float) aVar.f55145e.getHeight()) / 2.0f);
        } else if (i2 == 5) {
            pointF.x = rectF.right + aVar.k;
            pointF.y = pointF2.y - (((float) aVar.f55145e.getHeight()) / 2.0f);
        } else if (i2 == 48) {
            pointF.x = pointF2.x - (((float) aVar.f55145e.getWidth()) / 2.0f);
            pointF.y = ((rectF.top - ((float) aVar.f55145e.getHeight())) + ((float) aVar.n.getResources().getDimensionPixelOffset(R.dimen.dimen_10dp))) - aVar.k;
        } else if (i2 == 80) {
            pointF.x = pointF2.x - (((float) aVar.f55145e.getWidth()) / 2.0f);
            pointF.y = rectF.bottom + aVar.k;
        }
        return pointF;
    }
}
