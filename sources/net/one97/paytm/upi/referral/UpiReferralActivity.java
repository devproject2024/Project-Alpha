package net.one97.paytm.upi.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.utility.StringUtility;
import kotlin.g.b.w;
import kotlin.g.b.y;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.ReferralCodeResponse;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class UpiReferralActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f68366a;

    /* renamed from: b  reason: collision with root package name */
    final int f68367b;

    /* renamed from: c  reason: collision with root package name */
    final int f68368c = 1;

    /* renamed from: d  reason: collision with root package name */
    final int f68369d = 2;

    /* renamed from: e  reason: collision with root package name */
    final int f68370e = 3;

    /* renamed from: f  reason: collision with root package name */
    final int f68371f = 4;

    /* renamed from: g  reason: collision with root package name */
    String f68372g = "";

    /* renamed from: h  reason: collision with root package name */
    private final int f68373h = 201;

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.g f68374i = kotlin.h.a(new b(this));
    private final kotlin.g j = kotlin.h.a(new o(this));
    private final kotlin.g k = kotlin.h.a(new q(this));
    private final kotlin.g l = kotlin.h.a(new d(this));
    private final kotlin.g m = kotlin.h.a(new v(this));
    private final kotlin.g n = kotlin.h.a(new u(this));
    private final kotlin.g o = kotlin.h.a(new a(this));
    private final kotlin.g p = kotlin.h.a(new s(this));
    private final kotlin.g q = kotlin.h.a(new c(this));
    private final kotlin.g r = kotlin.h.a(new t(this));
    private final kotlin.g s = kotlin.h.a(new p(this));
    private String t = "";
    private Dialog u;

    static {
        Class<UpiReferralActivity> cls = UpiReferralActivity.class;
        f68366a = new kotlin.k.i[]{y.a((kotlin.g.b.v) new w(y.b(cls), "backIv", "getBackIv()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "inviteBtn", "getInviteBtn()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "moreBtn", "getMoreBtn()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "facebookBtn", "getFacebookBtn()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "whatsappBtn", "getWhatsappBtn()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "twitterBtn", "getTwitterBtn()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "MessengerBtn", "getMessengerBtn()Landroid/widget/ImageView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "titleTv", "getTitleTv()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "descTv", "getDescTv()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "tncTv", "getTncTv()Landroid/widget/TextView;")), y.a((kotlin.g.b.v) new w(y.b(cls), "inviteLav", "getInviteLav()Lcom/airbnb/lottie/LottieAnimationView;"))};
    }

    private ImageView d() {
        return (ImageView) this.l.getValue();
    }

    private ImageView e() {
        return (ImageView) this.m.getValue();
    }

    private ImageView f() {
        return (ImageView) this.n.getValue();
    }

    private ImageView g() {
        return (ImageView) this.o.getValue();
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_back_arrow);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class o extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final TextView invoke() {
            View findViewById = this.this$0.findViewById(R.id.btn_invite);
            if (findViewById != null) {
                return (TextView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    static final class q extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_more_logo);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_facebook);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class v extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_whatsapp);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class u extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_twitter);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final ImageView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_messenger);
            if (findViewById != null) {
                return (ImageView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    static final class s extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final TextView invoke() {
            View findViewById = this.this$0.findViewById(R.id.tv_referral_title);
            if (findViewById != null) {
                return (TextView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final TextView invoke() {
            View findViewById = this.this$0.findViewById(R.id.tv_referral_desc);
            if (findViewById != null) {
                return (TextView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    static final class t extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final TextView invoke() {
            View findViewById = this.this$0.findViewById(R.id.tv_tnc);
            if (findViewById != null) {
                return (TextView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    static final class p extends kotlin.g.b.l implements kotlin.g.a.a<LottieAnimationView> {
        final /* synthetic */ UpiReferralActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(UpiReferralActivity upiReferralActivity) {
            super(0);
            this.this$0 = upiReferralActivity;
        }

        public final LottieAnimationView invoke() {
            View findViewById = this.this$0.findViewById(R.id.iv_referral_img);
            if (findViewById != null) {
                return (LottieAnimationView) findViewById;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
        }
        net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_referral);
        UpiUtils.setStatusBarColor(getResources().getColor(R.color.white), this);
        Context context = this;
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo("/bhim-upi/referral", "wallet", context);
        CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
        ((ImageView) this.f68374i.getValue()).setOnClickListener(new f(this));
        ((TextView) this.j.getValue()).setOnClickListener(new g(this));
        ((ImageView) this.k.getValue()).setOnClickListener(new h(this));
        ((TextView) this.r.getValue()).setOnClickListener(new i(this));
        if (!UpiAppUtils.isAppInstalled(context, UpiConstants.FACEBOOK_PACKAGE_NAME)) {
            d().setVisibility(8);
        }
        if (!UpiAppUtils.isAppInstalled(context, UpiConstants.TW_PACKAGE_NAME)) {
            f().setVisibility(8);
        }
        if (!UpiAppUtils.isAppInstalled(context, UpiConstants.MSG_PACKAGE_NAME)) {
            g().setVisibility(8);
        }
        if (!UpiAppUtils.isAppInstalled(context, UpiConstants.WT_PACKAGE_NAME)) {
            e().setVisibility(8);
        }
        d().setOnClickListener(new j(this));
        f().setOnClickListener(new k(this));
        e().setOnClickListener(new l(this));
        g().setOnClickListener(new m(this));
        ((TextView) this.q.getValue()).setText(getString(R.string.upi_invite_cashback_text));
        View findViewById = findViewById(R.id.iv_referral_img);
        if (findViewById != null) {
            ((LottieAnimationView) findViewById).setAnimation(R.raw.upi_invite_and_earn);
            View findViewById2 = findViewById(R.id.iv_referral_img);
            if (findViewById2 != null) {
                ((LottieAnimationView) findViewById2).setRepeatCount(-1);
                new Handler().postDelayed(new n(this), 50);
                a(false, (Integer) null);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
        throw new kotlin.u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68378a;

        f(UpiReferralActivity upiReferralActivity) {
            this.f68378a = upiReferralActivity;
        }

        public final void onClick(View view) {
            this.f68378a.finish();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68379a;

        g(UpiReferralActivity upiReferralActivity) {
            this.f68379a = upiReferralActivity;
        }

        public final void onClick(View view) {
            if (!(this.f68379a.f68372g.length() == 0)) {
                this.f68379a.h();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68379a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68371f));
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68380a;

        h(UpiReferralActivity upiReferralActivity) {
            this.f68380a = upiReferralActivity;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68380a, GAConstants.CATEGORY.UPI_ONB_V1, "invite_button_clicked", "more", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
            if (!(this.f68380a.f68372g.length() == 0)) {
                this.f68380a.h();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68380a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68371f));
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68381a;

        i(UpiReferralActivity upiReferralActivity) {
            this.f68381a = upiReferralActivity;
        }

        /* JADX WARNING: type inference failed for: r6v13, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                net.one97.paytm.upi.referral.UpiReferralActivity r6 = r5.f68381a
                android.view.LayoutInflater r0 = r6.getLayoutInflater()
                r1 = 0
                if (r0 == 0) goto L_0x0010
                int r2 = net.one97.paytm.upi.R.layout.offer_details_bottomsheet_lyt
                android.view.View r0 = r0.inflate(r2, r1)
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                com.google.android.material.bottomsheet.a r2 = new com.google.android.material.bottomsheet.a
                android.content.Context r6 = (android.content.Context) r6
                r2.<init>(r6)
                r2.setContentView((android.view.View) r0)
                r2.show()
                if (r0 == 0) goto L_0x0029
                int r6 = net.one97.paytm.upi.R.id.tnc_text
                android.view.View r6 = r0.findViewById(r6)
                r1 = r6
                android.widget.TextView r1 = (android.widget.TextView) r1
            L_0x0029:
                if (r1 == 0) goto L_0x0032
                android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()
                r1.setMovementMethod(r6)
            L_0x0032:
                if (r1 == 0) goto L_0x0051
                net.one97.paytm.upi.common.UpiGTMLoader r6 = net.one97.paytm.upi.common.UpiGTMLoader.getInstance()
                java.lang.String r6 = r6.getUpiInviteTerms()
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 24
                if (r3 < r4) goto L_0x0048
                r3 = 0
                android.text.Spanned r6 = android.text.Html.fromHtml(r6, r3)
                goto L_0x004c
            L_0x0048:
                android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            L_0x004c:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r1.setText(r6)
            L_0x0051:
                if (r0 == 0) goto L_0x0065
                int r6 = net.one97.paytm.upi.R.id.close
                android.view.View r6 = r0.findViewById(r6)
                if (r6 == 0) goto L_0x0065
                net.one97.paytm.upi.referral.UpiReferralActivity$r r0 = new net.one97.paytm.upi.referral.UpiReferralActivity$r
                r0.<init>(r2)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r6.setOnClickListener(r0)
            L_0x0065:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.referral.UpiReferralActivity.i.onClick(android.view.View):void");
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68382a;

        j(UpiReferralActivity upiReferralActivity) {
            this.f68382a = upiReferralActivity;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68382a, GAConstants.CATEGORY.UPI_ONB_V1, "invite_button_clicked", "facebook", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
            if (!(this.f68382a.f68372g.length() == 0)) {
                this.f68382a.a();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68382a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68367b));
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68383a;

        k(UpiReferralActivity upiReferralActivity) {
            this.f68383a = upiReferralActivity;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68383a, GAConstants.CATEGORY.UPI_ONB_V1, "invite_button_clicked", "twitter", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
            if (!(this.f68383a.f68372g.length() == 0)) {
                this.f68383a.c();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68383a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68369d));
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68384a;

        l(UpiReferralActivity upiReferralActivity) {
            this.f68384a = upiReferralActivity;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68384a, GAConstants.CATEGORY.UPI_ONB_V1, "invite_button_clicked", "whatsapp", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
            if (!(this.f68384a.f68372g.length() == 0)) {
                this.f68384a.b();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68384a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68368c));
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68385a;

        m(UpiReferralActivity upiReferralActivity) {
            this.f68385a = upiReferralActivity;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68385a, GAConstants.CATEGORY.UPI_ONB_V1, "invite_button_clicked", "messenger", "", "", GAConstants.SCREEN_NAME.UPI_PROFILE_INVITE_PAGE, "wallet");
            if (!(this.f68385a.f68372g.length() == 0)) {
                this.f68385a.i();
                return;
            }
            UpiReferralActivity upiReferralActivity = this.f68385a;
            upiReferralActivity.a(true, Integer.valueOf(upiReferralActivity.f68370e));
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68386a;

        n(UpiReferralActivity upiReferralActivity) {
            this.f68386a = upiReferralActivity;
        }

        public final void run() {
            View findViewById = this.f68386a.findViewById(R.id.iv_referral_img);
            if (findViewById != null) {
                ((LottieAnimationView) findViewById).playAnimation();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        if (!(this.f68372g.length() == 0)) {
            Activity activity = this;
            String str = this.f68372g;
            String str2 = this.t;
            kotlin.g.b.k.c(activity, "actvity");
            kotlin.g.b.k.c(str, "context");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            activity.startActivity(Intent.createChooser(intent, "Share via"));
        } else {
            a(true, Integer.valueOf(this.f68371f));
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "invite_button_clicked", (String) null, (String) null, (String) null, "/bhim-upi/referral", "wallet");
    }

    /* access modifiers changed from: private */
    public final void a(boolean z, Integer num) {
        if (z) {
            a(true);
        }
        net.one97.paytm.upi.registration.b.a.b.a.a(getApplicationContext()).d(new e(this, num, z), "");
    }

    public static final class e implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiReferralActivity f68375a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f68376b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f68377c;

        e(UpiReferralActivity upiReferralActivity, Integer num, boolean z) {
            this.f68375a = upiReferralActivity;
            this.f68376b = num;
            this.f68377c = z;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            this.f68375a.a(false);
            if (upiBaseDataModel instanceof ReferralCodeResponse) {
                ReferralCodeResponse referralCodeResponse = (ReferralCodeResponse) upiBaseDataModel;
                if (kotlin.m.p.a(referralCodeResponse.getStatus(), "success", true)) {
                    UpiReferralActivity upiReferralActivity = this.f68375a;
                    String str = referralCodeResponse.getReferralContent() + StringUtility.NEW_LINE + referralCodeResponse.getReferralUrl();
                    kotlin.g.b.k.c(str, "<set-?>");
                    upiReferralActivity.f68372g = str;
                    Integer num = this.f68376b;
                    if (num != null) {
                        UpiReferralActivity.b(this.f68375a, Integer.valueOf(num.intValue()));
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            this.f68375a.a(false);
            if (upiCustomVolleyError == null) {
                kotlin.g.b.k.a();
            }
            if (!upiCustomVolleyError.getmErrorCode().equals(UpiConstants.NETWORK_ERROR_CODE)) {
                Toast.makeText(this.f68375a, R.string.upi_some_went_wrong, 0).show();
            } else if (this.f68377c) {
                UpiReferralActivity upiReferralActivity = this.f68375a;
                CustomDialog.showAlert(upiReferralActivity, upiReferralActivity.getString(R.string.no_connection), this.f68375a.getString(R.string.no_internet_new_message));
            }
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f68387a;

        r(com.google.android.material.bottomsheet.a aVar) {
            this.f68387a = aVar;
        }

        public final void onClick(View view) {
            this.f68387a.dismiss();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f68373h && i3 == -1) {
            h();
        }
    }

    private static void a(Context context, String str, String str2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "packageName");
        kotlin.g.b.k.c(str2, "msg");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setPackage(str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        String str = UpiConstants.FACEBOOK_PACKAGE_NAME;
        kotlin.g.b.k.a((Object) str, "UpiConstants.FACEBOOK_PACKAGE_NAME");
        a(this, str, this.f68372g);
    }

    public final void b() {
        String str = UpiConstants.WT_PACKAGE_NAME;
        kotlin.g.b.k.a((Object) str, "UpiConstants.WT_PACKAGE_NAME");
        a(this, str, this.f68372g);
    }

    public final void c() {
        String str = UpiConstants.TW_PACKAGE_NAME;
        kotlin.g.b.k.a((Object) str, "UpiConstants.TW_PACKAGE_NAME");
        a(this, str, this.f68372g);
    }

    /* access modifiers changed from: private */
    public final void i() {
        if (Build.VERSION.SDK_INT >= 19) {
            Context context = this;
            String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context);
            if (defaultSmsPackage != null) {
                a(context, defaultSmsPackage, this.f68372g);
                return;
            }
            return;
        }
        String string = Settings.Secure.getString(getContentResolver(), "sms_default_application");
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        PackageManager packageManager = applicationContext.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(packageManager.getLaunchIntentForPackage(string), 0);
        if (resolveActivity.activityInfo.packageName != null) {
            String str = resolveActivity.activityInfo.packageName;
            kotlin.g.b.k.a((Object) str, "mInfo.activityInfo.packageName");
            a(this, str, this.f68372g);
        }
    }

    public final void a(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        if (z) {
            if (this.u == null) {
                this.u = UpiAppUtils.getWalletStyleProgressDialog(this);
            }
            Dialog dialog4 = this.u;
            if (dialog4 != null) {
                if (dialog4 == null) {
                    kotlin.g.b.k.a();
                }
                if (!dialog4.isShowing() && (dialog3 = this.u) != null) {
                    dialog3.show();
                }
            }
        } else if (!isFinishing() && (dialog = this.u) != null) {
            if (dialog == null) {
                kotlin.g.b.k.a();
            }
            if (dialog.isShowing() && (dialog2 = this.u) != null) {
                dialog2.dismiss();
            }
        }
    }

    public static final /* synthetic */ void b(UpiReferralActivity upiReferralActivity, Integer num) {
        int i2 = upiReferralActivity.f68371f;
        if (num != null && num.intValue() == i2) {
            upiReferralActivity.h();
        } else if (!TextUtils.isEmpty(upiReferralActivity.f68372g)) {
            int i3 = upiReferralActivity.f68368c;
            if (num != null && num.intValue() == i3) {
                upiReferralActivity.b();
                return;
            }
            int i4 = upiReferralActivity.f68367b;
            if (num != null && num.intValue() == i4) {
                upiReferralActivity.a();
                return;
            }
            int i5 = upiReferralActivity.f68369d;
            if (num != null && num.intValue() == i5) {
                upiReferralActivity.c();
                return;
            }
            int i6 = upiReferralActivity.f68370e;
            if (num != null && num.intValue() == i6) {
                upiReferralActivity.i();
            }
        }
    }
}
