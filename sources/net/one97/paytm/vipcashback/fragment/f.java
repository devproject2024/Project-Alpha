package net.one97.paytm.vipcashback.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.jackpocket.scratchoff.a.d;
import com.squareup.picasso.w;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.j;
import net.one97.paytm.vipcashback.fragment.g;
import net.one97.paytm.vipcashback.view.CircularImageViewCashback;
import net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout;
import net.one97.paytm.vipcashback.widget.CustomCardView;

public final class f implements net.one97.paytm.v2.features.b.a {

    /* renamed from: a  reason: collision with root package name */
    com.jackpocket.scratchoff.c f20974a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintLayout f20975b;

    /* renamed from: c  reason: collision with root package name */
    boolean f20976c;

    /* renamed from: d  reason: collision with root package name */
    kotlin.g.a.b<? super Boolean, x> f20977d;

    /* renamed from: e  reason: collision with root package name */
    m<? super Integer, ? super String, x> f20978e;

    /* renamed from: f  reason: collision with root package name */
    final Context f20979f;

    /* renamed from: g  reason: collision with root package name */
    private CardView f20980g;

    /* renamed from: h  reason: collision with root package name */
    private View f20981h;

    /* renamed from: i  reason: collision with root package name */
    private final CoroutineExceptionHandler f20982i = new a(CoroutineExceptionHandler.Key);
    private final ScratchCardData j;
    private final boolean k;
    private final kotlin.g.a.b<String, x> l;

    static final class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f20987a = new c();

        c() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            k.c(view, "v");
            k.c(motionEvent, "m");
            return true;
        }
    }

    public f(Context context, ScratchCardData scratchCardData, boolean z, kotlin.g.a.b<? super String, x> bVar) {
        k.c(context, "mContext");
        k.c(scratchCardData, "mCardInfo");
        this.f20979f = context;
        this.j = scratchCardData;
        this.k = z;
        this.l = bVar;
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            k.c(fVar, "context");
            k.c(th, "exception");
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    /* JADX WARNING: type inference failed for: r0v46, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.String, kotlin.x> r10) {
        /*
            r9 = this;
            r0 = 0
            r9.f20977d = r0
            r9.f20978e = r10
            android.view.View r1 = r9.f20981h
            if (r1 != 0) goto L_0x029d
            android.content.Context r1 = r9.f20979f
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = net.one97.paytm.vipcashback.R.layout.cashback_card_new
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r0, r3)
            r9.f20981h = r1
            boolean r1 = r9.k
            if (r1 != 0) goto L_0x003e
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x002b
            int r2 = net.one97.paytm.vipcashback.R.id.dummyView
            android.view.View r1 = r1.findViewById(r2)
            if (r1 == 0) goto L_0x002b
            r1.setVisibility(r3)
        L_0x002b:
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x003e
            int r2 = net.one97.paytm.vipcashback.R.id.dummyView
            android.view.View r1 = r1.findViewById(r2)
            if (r1 == 0) goto L_0x003e
            net.one97.paytm.vipcashback.fragment.f$c r2 = net.one97.paytm.vipcashback.fragment.f.c.f20987a
            android.view.View$OnTouchListener r2 = (android.view.View.OnTouchListener) r2
            r1.setOnTouchListener(r2)
        L_0x003e:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r1 = r9.j
            boolean r1 = r1.isScratchCard
            r2 = 8
            if (r1 == 0) goto L_0x021c
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x0053
            int r4 = net.one97.paytm.vipcashback.R.id.cardView
            android.view.View r1 = r1.findViewById(r4)
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            r9.f20980g = r1
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x0063
            int r4 = net.one97.paytm.vipcashback.R.id.containerRL
            android.view.View r1 = r1.findViewById(r4)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L_0x0064
        L_0x0063:
            r1 = r0
        L_0x0064:
            r9.f20975b = r1
            net.one97.paytm.vipcashback.fragment.g$a r1 = net.one97.paytm.vipcashback.fragment.g.f20995a
            android.content.Context r1 = r9.f20979f
            android.view.View r4 = r9.f20981h
            if (r4 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r5 = r9.j
            net.one97.paytm.vipcashback.fragment.g.a.a(r1, r4, r5, r10)
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r1 = r9.j
            if (r1 == 0) goto L_0x00a4
            java.lang.String r1 = r1.cardHeadline
            if (r1 == 0) goto L_0x00a4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x008b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r1 = 0
            goto L_0x008c
        L_0x008b:
            r1 = 1
        L_0x008c:
            if (r1 != 0) goto L_0x00a4
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x00bd
            int r4 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00bd
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r4 = r9.j
            java.lang.String r4 = r4.cardHeadline
            net.one97.paytm.v2.b.a.a(r1, r4)
            goto L_0x00bd
        L_0x00a4:
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x00bd
            int r4 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00bd
            android.content.Context r4 = r9.f20979f
            int r5 = net.one97.paytm.vipcashback.R.string.sticker_winning_text
            java.lang.CharSequence r4 = r4.getText(r5)
            r1.setText(r4)
        L_0x00bd:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r1 = r9.j
            java.lang.Boolean r1 = r1.luckyDraw
            java.lang.String r4 = "mCardInfo.luckyDraw"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00f5
            net.one97.paytm.vipcashback.f.j r1 = net.one97.paytm.vipcashback.f.j.LUCKY_DRAW_THEME
            android.view.View r4 = r9.f20981h
            if (r4 == 0) goto L_0x00df
            int r5 = net.one97.paytm.vipcashback.R.id.luckyAmountView
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00df
            r4.setVisibility(r3)
        L_0x00df:
            android.view.View r4 = r9.f20981h
            if (r4 == 0) goto L_0x0111
            int r5 = net.one97.paytm.vipcashback.R.id.luckyAmountView
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0111
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r5 = r9.j
            java.lang.String r5 = r5.redemptionMaxAmount
            net.one97.paytm.v2.b.a.a(r4, r5)
            goto L_0x0111
        L_0x00f5:
            net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r1 = r9.j
            java.lang.String r1 = r1.scratchCardId
            net.one97.paytm.vipcashback.f.j r1 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r1, (boolean) r3)
            android.view.View r4 = r9.f20981h
            if (r4 == 0) goto L_0x0111
            int r5 = net.one97.paytm.vipcashback.R.id.luckyAmountView
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0111
            r5 = 4
            r4.setVisibility(r5)
        L_0x0111:
            android.view.View r4 = r9.f20981h
            if (r4 == 0) goto L_0x020d
            if (r4 != 0) goto L_0x011a
            kotlin.g.b.k.a()
        L_0x011a:
            int r5 = net.one97.paytm.vipcashback.R.id.scratch_view
            android.view.View r5 = r4.findViewById(r5)
            net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout r5 = (net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout) r5
            java.lang.String r6 = "scratchableView"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = r5
            android.view.View r6 = (android.view.View) r6
            int r7 = net.one97.paytm.vipcashback.R.id.container
            android.view.View r7 = r6.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0137
            r7.setVisibility(r3)
        L_0x0137:
            int r7 = net.one97.paytm.vipcashback.R.id.container
            android.view.View r7 = r6.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0145
            android.graphics.drawable.Drawable r0 = r7.getBackground()
        L_0x0145:
            if (r0 == 0) goto L_0x0205
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            if (r0 == 0) goto L_0x0156
            java.lang.String r7 = r1.getBgColor()
            int r7 = android.graphics.Color.parseColor(r7)
            r0.setColor(r7)
        L_0x0156:
            int r0 = net.one97.paytm.vipcashback.R.id.scratchHereView
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x016b
            java.lang.String r7 = r1.getTextColor()
            int r7 = android.graphics.Color.parseColor(r7)
            r0.setTextColor(r7)
        L_0x016b:
            int r0 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0180
            java.lang.String r7 = r1.getTextColor()
            int r7 = android.graphics.Color.parseColor(r7)
            r0.setTextColor(r7)
        L_0x0180:
            int r0 = net.one97.paytm.vipcashback.R.id.bgConfetti
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0191
            int r1 = r1.getIcon()
            r0.setImageResource(r1)
        L_0x0191:
            int r0 = net.one97.paytm.vipcashback.R.id.lockView
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x019e
            r0.setVisibility(r2)
        L_0x019e:
            int r0 = net.one97.paytm.vipcashback.R.id.scratchHereView
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01b0
            boolean r1 = r9.k
            if (r1 == 0) goto L_0x01ad
            r2 = 0
        L_0x01ad:
            r0.setVisibility(r2)
        L_0x01b0:
            com.jackpocket.scratchoff.c r0 = new com.jackpocket.scratchoff.c
            android.content.Context r1 = r9.f20979f
            r0.<init>(r1)
            net.one97.paytm.vipcashback.f.f r1 = net.one97.paytm.vipcashback.f.f.a()
            java.lang.String r2 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r1 = net.one97.paytm.vipcashback.f.f.Q()
            double r1 = (double) r1
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r1 / r7
            com.jackpocket.scratchoff.c r0 = r0.a((double) r1)
            android.content.Context r1 = r9.f20979f
            r2 = 15
            com.jackpocket.scratchoff.c r0 = r0.a((android.content.Context) r1, (int) r2)
            com.jackpocket.scratchoff.c r0 = r0.d()
            com.jackpocket.scratchoff.c r0 = r0.c()
            net.one97.paytm.vipcashback.fragment.f$g r1 = new net.one97.paytm.vipcashback.fragment.f$g
            r1.<init>(r9, r4)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            com.jackpocket.scratchoff.c r0 = r0.a((java.lang.Runnable) r1)
            int r1 = net.one97.paytm.vipcashback.R.id.cardView
            android.view.View r1 = r4.findViewById(r1)
            com.jackpocket.scratchoff.c r0 = r0.a((android.view.View) r6, (android.view.View) r1)
            r9.f20974a = r0
            net.one97.paytm.vipcashback.fragment.f$h r0 = new net.one97.paytm.vipcashback.fragment.f$h
            r0.<init>(r9, r4)
            net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout$a r0 = (net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout.a) r0
            r5.setScratchLister(r0)
            androidx.cardview.widget.CardView r0 = r9.f20980g
            if (r0 == 0) goto L_0x020d
            r0.setEnabled(r3)
            goto L_0x020d
        L_0x0205:
            kotlin.u r10 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r10.<init>(r0)
            throw r10
        L_0x020d:
            com.jackpocket.scratchoff.c r0 = r9.f20974a
            if (r0 == 0) goto L_0x025b
            net.one97.paytm.vipcashback.fragment.f$d r1 = new net.one97.paytm.vipcashback.fragment.f$d
            r1.<init>(r9)
            com.jackpocket.scratchoff.a.d$a r1 = (com.jackpocket.scratchoff.a.d.a) r1
            r0.a((com.jackpocket.scratchoff.a.d.a) r1)
            goto L_0x025b
        L_0x021c:
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x0229
            int r3 = net.one97.paytm.vipcashback.R.id.cardView
            android.view.View r1 = r1.findViewById(r3)
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            goto L_0x022a
        L_0x0229:
            r1 = r0
        L_0x022a:
            r9.f20980g = r1
            android.view.View r1 = r9.f20981h
            if (r1 == 0) goto L_0x0238
            int r0 = net.one97.paytm.vipcashback.R.id.containerRL
            android.view.View r0 = r1.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
        L_0x0238:
            r9.f20975b = r0
            android.view.View r0 = r9.f20981h
            if (r0 == 0) goto L_0x024b
            int r1 = net.one97.paytm.vipcashback.R.id.scratch_view
            android.view.View r0 = r0.findViewById(r1)
            net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout r0 = (net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout) r0
            if (r0 == 0) goto L_0x024b
            r0.setVisibility(r2)
        L_0x024b:
            net.one97.paytm.vipcashback.fragment.g$a r0 = net.one97.paytm.vipcashback.fragment.g.f20995a
            android.content.Context r0 = r9.f20979f
            android.view.View r1 = r9.f20981h
            if (r1 != 0) goto L_0x0256
            kotlin.g.b.k.a()
        L_0x0256:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r2 = r9.j
            net.one97.paytm.vipcashback.fragment.g.a.a(r0, r1, r2, r10)
        L_0x025b:
            android.view.View r0 = r9.f20981h
            if (r0 == 0) goto L_0x0273
            int r1 = net.one97.paytm.vipcashback.R.id.closeView
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0273
            net.one97.paytm.vipcashback.fragment.f$e r1 = new net.one97.paytm.vipcashback.fragment.f$e
            r1.<init>(r9)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x0273:
            net.one97.paytm.v2.features.b.b r0 = new net.one97.paytm.v2.features.b.b
            android.content.Context r1 = r9.f20979f
            r2 = r9
            net.one97.paytm.v2.features.b.a r2 = (net.one97.paytm.v2.features.b.a) r2
            r0.<init>(r1, r2)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r9.f20975b
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 == 0) goto L_0x0285
            r0.f20075b = r1
        L_0x0285:
            android.view.View r0 = r9.f20981h
            if (r0 == 0) goto L_0x029d
            int r1 = net.one97.paytm.vipcashback.R.id.containerRL
            android.view.View r0 = r0.findViewById(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L_0x029d
            net.one97.paytm.vipcashback.fragment.f$f r1 = new net.one97.paytm.vipcashback.fragment.f$f
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x029d:
            android.view.View r10 = r9.f20981h
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.f.a(kotlin.g.a.m):android.view.View");
    }

    static final class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20988a;

        d(f fVar) {
            this.f20988a = fVar;
        }

        public final void a(double d2) {
            if (d2 > 0.0d) {
                f fVar = this.f20988a;
                fVar.f20976c = true;
                kotlin.g.a.b<? super Boolean, x> bVar = fVar.f20977d;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                }
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20989a;

        e(f fVar) {
            this.f20989a = fVar;
        }

        public final void onClick(View view) {
            m<? super Integer, ? super String, x> mVar = this.f20989a.f20978e;
            if (mVar != null) {
                mVar.invoke(3, "");
            }
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.fragment.f$f  reason: collision with other inner class name */
    static final class C0406f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f20990a;

        C0406f(m mVar) {
            this.f20990a = mVar;
        }

        public final void onClick(View view) {
            m mVar = this.f20990a;
            if (mVar != null) {
                mVar.invoke(3, "");
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20992b;

        g(f fVar, View view) {
            this.f20991a = fVar;
            this.f20992b = view;
        }

        public final void run() {
            f.a(this.f20991a);
        }
    }

    static final class h implements CustomScratchableRelativeLayout.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20994b;

        h(f fVar, View view) {
            this.f20993a = fVar;
            this.f20994b = view;
        }

        public final void a() {
            com.jackpocket.scratchoff.c cVar = this.f20993a.f20974a;
            if (cVar != null) {
                cVar.a();
            }
            f.a(this.f20993a);
        }
    }

    public final void a(View view, Object obj) {
        k.c(view, "view");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loadingView);
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        if (obj instanceof ScratchCardData) {
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.loadingView);
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(8);
            }
            TextView textView = (TextView) view.findViewById(R.id.cashbackCTA);
            if (textView != null) {
                textView.setVisibility(0);
            }
            a(view, (ScratchCardData) obj);
            return;
        }
        LottieAnimationView lottieAnimationView3 = (LottieAnimationView) view.findViewById(R.id.loadingView);
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.cashbackCTA);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    private void a(View view, ScratchCardData scratchCardData) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator withLayer;
        ViewPropertyAnimator rotationY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator withEndAction;
        k.c(view, "view");
        k.c(scratchCardData, "data");
        x.e eVar = new x.e();
        eVar.element = (CustomCardView) view.findViewById(R.id.cardView);
        this.f20975b = (ConstraintLayout) view.findViewById(R.id.containerRL);
        ConstraintLayout constraintLayout = this.f20975b;
        if (constraintLayout != null) {
            Resources resources = this.f20979f.getResources();
            k.a((Object) resources, "mContext.resources");
            constraintLayout.setCameraDistance(resources.getDisplayMetrics().density * 8000.0f);
        }
        ConstraintLayout constraintLayout2 = this.f20975b;
        if (constraintLayout2 != null) {
            constraintLayout2.setLayerType(2, (Paint) null);
        }
        ConstraintLayout constraintLayout3 = this.f20975b;
        if (constraintLayout3 != null && (animate = constraintLayout3.animate()) != null && (withLayer = animate.withLayer()) != null && (rotationY = withLayer.rotationY(90.0f)) != null && (duration = rotationY.setDuration(350)) != null && (withEndAction = duration.withEndAction(new b(this, scratchCardData, eVar, view))) != null) {
            withEndAction.start();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ScratchCardData f20984b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f20985c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f20986d;

        b(f fVar, ScratchCardData scratchCardData, x.e eVar, View view) {
            this.f20983a = fVar;
            this.f20984b = scratchCardData;
            this.f20985c = eVar;
            this.f20986d = view;
        }

        public final void run() {
            ImageView imageView;
            ViewPropertyAnimator viewPropertyAnimator = null;
            if (this.f20984b.isLockedCard) {
                View inflate = LayoutInflater.from(this.f20983a.f20979f).inflate(R.layout.locked_card_new, (ViewGroup) null, false);
                f fVar = this.f20983a;
                ScratchCardData scratchCardData = this.f20984b;
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                j a2 = d.a.a(scratchCardData != null ? scratchCardData.scratchCardId : null, false);
                fVar.a(inflate, scratchCardData, a2);
                if (!(inflate == null || (imageView = (ImageView) inflate.findViewById(R.id.bgConfetti)) == null)) {
                    imageView.setImageResource(a2.getIcon());
                }
                CustomCardView customCardView = (CustomCardView) this.f20985c.element;
                if (customCardView != null) {
                    customCardView.removeAllViews();
                }
                CustomCardView customCardView2 = (CustomCardView) this.f20985c.element;
                if (customCardView2 != null) {
                    customCardView2.addView(inflate);
                }
            } else if (this.f20984b.isBetterLuck) {
                g.a aVar2 = g.f20995a;
                g.a.a(this.f20983a.f20979f, this.f20986d, this.f20984b, (m<? super Integer, ? super String, kotlin.x>) null);
            } else if (this.f20984b.isGame) {
                View inflate2 = LayoutInflater.from(this.f20983a.f20979f).inflate(R.layout.locked_card_new, (ViewGroup) null, false);
                f fVar2 = this.f20983a;
                ScratchCardData scratchCardData2 = this.f20984b;
                j jVar = j.GAME_CAMPAIGN_THEME;
                if (inflate2 != null) {
                    fVar2.a(inflate2, scratchCardData2, jVar);
                    ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.bgConfetti);
                    k.a((Object) imageView2, "bgConfetti");
                    imageView2.setVisibility(8);
                    CircularImageViewCashback circularImageViewCashback = (CircularImageViewCashback) inflate2.findViewById(R.id.thumbnailView);
                    k.a((Object) circularImageViewCashback, "thumbnailView");
                    circularImageViewCashback.setVisibility(0);
                    w.a().a(scratchCardData2 != null ? scratchCardData2.scratchCardImage : null).a(R.drawable.cashback_placeholder).a((ImageView) (CircularImageViewCashback) inflate2.findViewById(R.id.thumbnailView));
                }
                CustomCardView customCardView3 = (CustomCardView) this.f20985c.element;
                if (customCardView3 != null) {
                    customCardView3.removeAllViews();
                }
                CustomCardView customCardView4 = (CustomCardView) this.f20985c.element;
                if (customCardView4 != null) {
                    customCardView4.addView(inflate2);
                }
            }
            ConstraintLayout constraintLayout = this.f20983a.f20975b;
            if (constraintLayout != null) {
                constraintLayout.setRotationY(-90.0f);
            }
            ConstraintLayout constraintLayout2 = this.f20983a.f20975b;
            if (constraintLayout2 != null) {
                viewPropertyAnimator = constraintLayout2.animate();
            }
            if (viewPropertyAnimator == null) {
                k.a();
            }
            viewPropertyAnimator.withLayer().rotation(0.0f).rotationY(0.0f).setDuration(400).setListener(new Animator.AnimatorListener() {
                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, ScratchCardData scratchCardData, j jVar) {
        String str;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.container);
            boolean z = false;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.close);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView = (TextView) view.findViewById(R.id.lockedCardDescription);
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) view.findViewById(R.id.lockView);
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = (ImageView) view.findViewById(R.id.container);
            Drawable drawable = null;
            Drawable background = imageView4 != null ? imageView4.getBackground() : null;
            if (background != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(Color.parseColor(jVar.getBgColor()));
                }
                ImageView imageView5 = (ImageView) view.findViewById(R.id.cashBackUnit);
                if (imageView5 != null) {
                    imageView5.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lockedCardBottomLayout);
                if (linearLayout != null) {
                    linearLayout.setBackgroundResource(R.drawable.locked_card_text_bg_drawable);
                }
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.lockedCardBottomLayout);
                if (linearLayout2 != null) {
                    drawable = linearLayout2.getBackground();
                }
                if (drawable != null) {
                    GradientDrawable gradientDrawable2 = (GradientDrawable) drawable;
                    if (gradientDrawable2 != null) {
                        gradientDrawable2.setColor(Color.parseColor(jVar.getTextBgColor()));
                    }
                    TextView textView2 = (TextView) view.findViewById(R.id.scratchHereView);
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    TextView textView3 = (TextView) view.findViewById(R.id.lockedCardDescription);
                    if (textView3 != null) {
                        net.one97.paytm.v2.b.a.a(textView3, scratchCardData.description);
                    }
                    TextView textView4 = (TextView) view.findViewById(R.id.lockedCardDescription);
                    if (textView4 != null) {
                        textView4.setTextColor(Color.parseColor(jVar.getTextColor()));
                    }
                    TextView textView5 = (TextView) view.findViewById(R.id.title);
                    if (textView5 != null) {
                        textView5.setTextColor(Color.parseColor(jVar.getTextColor()));
                    }
                    if (!(scratchCardData == null || (str = scratchCardData.cardHeadline) == null)) {
                        CharSequence charSequence = str;
                        if (charSequence == null || charSequence.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            TextView textView6 = (TextView) view.findViewById(R.id.title);
                            if (textView6 != null) {
                                net.one97.paytm.v2.b.a.a(textView6, scratchCardData.cardHeadline);
                                return;
                            }
                            return;
                        }
                    }
                    TextView textView7 = (TextView) view.findViewById(R.id.title);
                    if (textView7 != null) {
                        textView7.setText(this.f20979f.getText(R.string.sticker_winning_text));
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public final void a() {
        CardView cardView = this.f20980g;
        ViewParent parent = cardView != null ? cardView.getParent() : null;
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f20980g);
            Context context = this.f20979f;
            if (context != null) {
                ((Activity) context).finish();
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void b() {
        CardView cardView = this.f20980g;
        ViewParent parent = cardView != null ? cardView.getParent() : null;
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f20980g);
            Context context = this.f20979f;
            if (context != null) {
                ((Activity) context).finish();
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final /* synthetic */ void a(f fVar) {
        CustomScratchableRelativeLayout customScratchableRelativeLayout;
        CustomScratchableRelativeLayout customScratchableRelativeLayout2;
        kotlin.g.a.b<String, kotlin.x> bVar = fVar.l;
        if (bVar != null) {
            ScratchCardData scratchCardData = fVar.j;
            String str = scratchCardData != null ? scratchCardData.scratchCardId : null;
            k.a((Object) str, "mCardInfo?.scratchCardId");
            bVar.invoke(str);
        }
        CardView cardView = fVar.f20980g;
        if (cardView != null) {
            cardView.setEnabled(true);
        }
        View view = fVar.f20981h;
        if (!(view == null || (customScratchableRelativeLayout2 = (CustomScratchableRelativeLayout) view.findViewById(R.id.scratch_view)) == null)) {
            customScratchableRelativeLayout2.a();
        }
        View view2 = fVar.f20981h;
        if (!(view2 == null || (customScratchableRelativeLayout = (CustomScratchableRelativeLayout) view2.findViewById(R.id.scratch_view)) == null)) {
            customScratchableRelativeLayout.setVisibility(8);
        }
        kotlin.g.a.b<? super Boolean, kotlin.x> bVar2 = fVar.f20977d;
        if (bVar2 != null) {
            bVar2.invoke(Boolean.TRUE);
        }
    }
}
