package net.one97.paytm.vipcashback.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.CashbackCrossPromoData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class CashbackVoucherDetailsActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20656a = new a((byte) 0);
    private static final String q = CashbackVoucherDetailsActivity.class.getSimpleName();
    private static final String r = "EXPIRED";
    private static final String s = s;
    private static final String t = t;
    private static final String u = u;

    /* renamed from: d  reason: collision with root package name */
    private String f20657d;

    /* renamed from: e  reason: collision with root package name */
    private String f20658e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f20659f = "";

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.vipcashback.g.d f20660g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f20661h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f20662i = "";
    /* access modifiers changed from: private */
    public String j = "";
    private String k;
    private CashbackCrossPromoData l;
    private String m;
    private String n;
    private String o;
    private final View.OnClickListener p = new d(this);
    private HashMap v;

    public final View a(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherDetailsActivity f20666a;

        e(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
            this.f20666a = cashbackVoucherDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            h hVar = (h) obj;
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20666a.a(R.id.loader));
            if (hVar != null && hVar.f20893a == 104) {
                FrameLayout frameLayout = (FrameLayout) this.f20666a.a(R.id.dealDetailLayout);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a((Context) this.f20666a, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                    final /* synthetic */ e this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.f20666a.onBackPressed();
                    }
                });
            } else if (hVar != null && hVar.f20893a == 101) {
                CashbackVoucherDetailsActivity.a(this.f20666a, (IJRPaytmDataModel) hVar.f20894b);
            } else if (hVar != null && hVar.f20893a == 102) {
                FrameLayout frameLayout2 = (FrameLayout) this.f20666a.a(R.id.dealDetailLayout);
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
                d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                Throwable th = hVar.f20895c;
                if (th != null) {
                    d.a.a((NetworkCustomError) th, (FragmentActivity) this.f20666a, Boolean.FALSE, 8);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        CashbackCrossPromoData cashbackCrossPromoData;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_offer_detail_new);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        if (getIntent() != null) {
            this.f20658e = getIntent().getStringExtra(Utility.EVENT_CATEGORY_PROMOCODE);
            this.f20659f = getIntent().getStringExtra("siteid");
            Intent intent = getIntent();
            String str = null;
            this.f20657d = intent != null ? intent.getStringExtra("gameid") : null;
            if (getIntent().hasExtra("cb_promodata")) {
                Intent intent2 = getIntent();
                Serializable serializableExtra = intent2 != null ? intent2.getSerializableExtra("cb_promodata") : null;
                if (serializableExtra != null) {
                    cashbackCrossPromoData = (CashbackCrossPromoData) serializableExtra;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.CashbackCrossPromoData");
                }
            } else {
                cashbackCrossPromoData = null;
            }
            this.l = cashbackCrossPromoData;
            Intent intent3 = getIntent();
            this.m = intent3 != null ? intent3.getStringExtra("voucherid") : null;
            Intent intent4 = getIntent();
            this.n = intent4 != null ? intent4.getStringExtra("redemptionType") : null;
            Intent intent5 = getIntent();
            if (intent5 != null) {
                str = intent5.getStringExtra("client");
            }
            this.o = str;
        }
        Button button = (Button) a(R.id.payButton);
        if (button != null) {
            button.setOnClickListener(this.p);
        }
        TextView textView = (TextView) a(R.id.moreDetails);
        if (textView != null) {
            textView.setOnClickListener(this.p);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgDealCopy);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this.p);
        }
        TextView textView2 = (TextView) a(R.id.tapToAvail);
        if (textView2 != null) {
            textView2.setOnClickListener(this.p);
        }
        TextView textView3 = (TextView) a(R.id.voucherCodeText);
        if (textView3 != null) {
            textView3.setOnClickListener(this.p);
        }
        ImageView imageView = (ImageView) a(R.id.back_arrow);
        if (imageView != null) {
            imageView.setOnClickListener(this.p);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object, com.paytm.network.a] */
    /* JADX WARNING: type inference failed for: r2v42 */
    /* JADX WARNING: type inference failed for: r2v43 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPostCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onPostCreate(r12)
            int r12 = net.one97.paytm.vipcashback.R.id.dealDetailView
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r0 = 4
            if (r12 == 0) goto L_0x0011
            r12.setVisibility(r0)
        L_0x0011:
            int r12 = net.one97.paytm.vipcashback.R.id.moreDetails
            android.view.View r12 = r11.findViewById(r12)
            if (r12 == 0) goto L_0x0353
            android.widget.TextView r12 = (android.widget.TextView) r12
            android.text.SpannableString r1 = new android.text.SpannableString
            android.content.res.Resources r2 = r11.getResources()
            int r3 = net.one97.paytm.vipcashback.R.string.more_details
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.<init>(r2)
            android.text.style.UnderlineSpan r2 = new android.text.style.UnderlineSpan
            r2.<init>()
            int r3 = r1.length()
            r4 = 0
            r1.setSpan(r2, r4, r3, r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r12 = r11.l
            r1 = 2
            r2 = 0
            r3 = 1
            if (r12 == 0) goto L_0x01ff
            int r12 = net.one97.paytm.vipcashback.R.id.dealDetailView
            android.view.View r12 = r11.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x0052
            r12.setVisibility(r4)
        L_0x0052:
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r12 = r11.l
            if (r12 != 0) goto L_0x0059
            kotlin.g.b.k.a()
        L_0x0059:
            if (r12 == 0) goto L_0x0060
            java.lang.String r0 = r12.getTermsConditions()
            goto L_0x0061
        L_0x0060:
            r0 = r2
        L_0x0061:
            r11.f20662i = r0
            java.lang.String r0 = r12.getCtaDeeplink()
            r11.k = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r0.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = r12.getFrontendRedemptionType()     // Catch:{ Exception -> 0x009f }
            r0.append(r5)     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = " "
            r0.append(r5)     // Catch:{ Exception -> 0x009f }
            int r5 = net.one97.paytm.vipcashback.R.string.worth_test     // Catch:{ Exception -> 0x009f }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x009f }
            java.lang.String r7 = r12.getValue()     // Catch:{ Exception -> 0x009f }
            r6[r4] = r7     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = r11.getString(r5, r6)     // Catch:{ Exception -> 0x009f }
            r0.append(r5)     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009f }
            int r5 = net.one97.paytm.vipcashback.R.id.cashbackText     // Catch:{ Exception -> 0x009f }
            android.view.View r5 = r11.a((int) r5)     // Catch:{ Exception -> 0x009f }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x009f }
            if (r5 == 0) goto L_0x00b3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x009f }
            r5.setText(r0)     // Catch:{ Exception -> 0x009f }
            goto L_0x00b3
        L_0x009f:
            int r0 = net.one97.paytm.vipcashback.R.id.cashbackText
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00b3
            java.lang.String r5 = r12.getCrossPromoText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x00b3:
            int r0 = net.one97.paytm.vipcashback.R.id.viewDetails
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00c4
            java.lang.String r5 = r12.getCrossPromoUsageText()
            net.one97.paytm.v2.b.a.a(r0, r5)
        L_0x00c4:
            int r0 = net.one97.paytm.vipcashback.R.id.winningTextView
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00d9
            int r5 = net.one97.paytm.vipcashback.R.string.cb_you_won
            java.lang.String r5 = r11.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x00d9:
            java.lang.String r0 = r12.getCrossPromoCode()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00ea
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r0 = 0
            goto L_0x00eb
        L_0x00ea:
            r0 = 1
        L_0x00eb:
            r5 = 8
            if (r0 != 0) goto L_0x011b
            int r0 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00fc
            r0.setVisibility(r4)
        L_0x00fc:
            int r0 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0142
            net.one97.paytm.vipcashback.f.d$a r6 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r6 = r12.getCrossPromoCode()
            java.lang.String r7 = "resModel.crossPromoCode"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.d(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            goto L_0x0142
        L_0x011b:
            int r0 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0128
            r0.setVisibility(r5)
        L_0x0128:
            int r0 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0135
            r0.setVisibility(r5)
        L_0x0135:
            int r0 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r0 = r11.a((int) r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            if (r0 == 0) goto L_0x0142
            r0.setVisibility(r5)
        L_0x0142:
            net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
            if (r12 == 0) goto L_0x014b
            java.lang.String r0 = r12.getValidFrom()
            goto L_0x014c
        L_0x014b:
            r0 = r2
        L_0x014c:
            java.lang.String r6 = "resModel?.validFrom"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r6 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            java.lang.String r0 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r0, (java.lang.String) r6)
            net.one97.paytm.vipcashback.f.d$a r7 = net.one97.paytm.vipcashback.f.d.f20859a
            if (r12 == 0) goto L_0x015f
            java.lang.String r2 = r12.getValidUpto()
        L_0x015f:
            java.lang.String r7 = "resModel?.validUpto"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.lang.String r2 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r2, (java.lang.String) r6)
            int r6 = net.one97.paytm.vipcashback.R.id.validity
            android.view.View r6 = r11.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0183
            int r7 = net.one97.paytm.vipcashback.R.string.voucher_detail_date_format
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r4] = r0
            r1[r3] = r2
            java.lang.String r0 = r11.getString(r7, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x0183:
            int r0 = net.one97.paytm.vipcashback.R.id.pin
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0190
            r0.setVisibility(r5)
        L_0x0190:
            int r0 = net.one97.paytm.vipcashback.R.id.pin_text
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x019d
            r0.setVisibility(r5)
        L_0x019d:
            int r0 = net.one97.paytm.vipcashback.R.id.earnedForText
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01aa
            r0.setVisibility(r5)
        L_0x01aa:
            java.lang.String r0 = r12.getCta()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01ba
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01b9
            goto L_0x01ba
        L_0x01b9:
            r3 = 0
        L_0x01ba:
            if (r3 != 0) goto L_0x01dd
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r11.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x01c9
            r0.setVisibility(r4)
        L_0x01c9:
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r11.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x01e0
            java.lang.String r1 = r12.getCta()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x01e0
        L_0x01dd:
            r11.a()
        L_0x01e0:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r12 = r12.getCrossPromocodeIcon()
            com.squareup.picasso.aa r12 = r0.a((java.lang.String) r12)
            int r0 = net.one97.paytm.vipcashback.R.drawable.cashback_icon_holder
            com.squareup.picasso.aa r12 = r12.a((int) r0)
            int r0 = net.one97.paytm.vipcashback.R.id.cardOfferImage
            android.view.View r0 = r11.a((int) r0)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r0 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r0
            r12.a((android.widget.ImageView) r0)
            goto L_0x0344
        L_0x01ff:
            int r12 = net.one97.paytm.vipcashback.R.id.loader
            android.view.View r12 = r11.a((int) r12)
            com.airbnb.lottie.LottieAnimationView r12 = (com.airbnb.lottie.LottieAnimationView) r12
            net.one97.paytm.common.widgets.a.a(r12)
            r12 = r11
            androidx.fragment.app.FragmentActivity r12 = (androidx.fragment.app.FragmentActivity) r12
            net.one97.paytm.vipcashback.g.a r5 = new net.one97.paytm.vipcashback.g.a
            android.app.Application r6 = r11.getApplication()
            java.lang.String r7 = "application"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r7 = r11.f20658e
            r0[r4] = r7
            java.lang.String r7 = r11.f20659f
            r0[r3] = r7
            java.lang.String r7 = r11.o
            r0[r1] = r7
            r1 = 3
            java.lang.String r7 = r11.n
            r0[r1] = r7
            r5.<init>(r6, r0)
            androidx.lifecycle.al$b r5 = (androidx.lifecycle.al.b) r5
            androidx.lifecycle.al r12 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r12, (androidx.lifecycle.al.b) r5)
            java.lang.Class<net.one97.paytm.vipcashback.g.d> r0 = net.one97.paytm.vipcashback.g.d.class
            androidx.lifecycle.ai r12 = r12.a(r0)
            net.one97.paytm.vipcashback.g.d r12 = (net.one97.paytm.vipcashback.g.d) r12
            r11.f20660g = r12
            net.one97.paytm.vipcashback.g.d r12 = r11.f20660g
            if (r12 == 0) goto L_0x0344
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            net.one97.paytm.vipcashback.f.a$a r1 = net.one97.paytm.vipcashback.f.a.f20855a
            java.lang.String r1 = r12.f21018a
            java.lang.String r5 = r12.f21019b
            java.lang.String r6 = r12.f21020c
            java.lang.String r7 = r12.f21021d
            net.one97.paytm.vipcashback.g.d$b r8 = new net.one97.paytm.vipcashback.g.d$b
            r8.<init>(r0)
            com.paytm.network.listener.b r8 = (com.paytm.network.listener.b) r8
            java.lang.String r9 = "promoCode"
            kotlin.g.b.k.c(r1, r9)
            java.lang.String r9 = "siteId"
            kotlin.g.b.k.c(r5, r9)
            java.lang.String r9 = "apiListener"
            kotlin.g.b.k.c(r8, r9)
            net.one97.paytm.vipcashback.f.f r9 = net.one97.paytm.vipcashback.f.f.a()
            java.lang.String r10 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.lang.String r9 = net.one97.paytm.vipcashback.f.f.o()
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x027f
            goto L_0x031a
        L_0x027f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r9 = 47
            r2.append(r9)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.vipcashback.g.d$a$a r2 = net.one97.paytm.vipcashback.g.d.a.f21022a
            java.lang.String r2 = net.one97.paytm.vipcashback.g.d.a.f21024c
            java.lang.String r1 = net.one97.paytm.vipcashback.f.d.a.d(r1, r2, r5)
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.vipcashback.g.d$a$a r2 = net.one97.paytm.vipcashback.g.d.a.f21022a
            java.lang.String r2 = net.one97.paytm.vipcashback.g.d.a.f21025d
            java.lang.String r5 = "en_US"
            java.lang.String r1 = net.one97.paytm.vipcashback.f.d.a.d(r1, r2, r5)
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x02bb
            int r2 = r2.length()
            if (r2 != 0) goto L_0x02b9
            goto L_0x02bb
        L_0x02b9:
            r2 = 0
            goto L_0x02bc
        L_0x02bb:
            r2 = 1
        L_0x02bc:
            if (r2 != 0) goto L_0x02e5
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x02cb
            int r2 = r2.length()
            if (r2 != 0) goto L_0x02ca
            goto L_0x02cb
        L_0x02ca:
            r3 = 0
        L_0x02cb:
            if (r3 != 0) goto L_0x02e5
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.vipcashback.g.d$a$a r2 = net.one97.paytm.vipcashback.g.d.a.f21022a
            java.lang.String r2 = net.one97.paytm.vipcashback.g.d.a.f21026e
            java.lang.String r1 = net.one97.paytm.vipcashback.f.d.a.d(r1, r2, r6)
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            net.one97.paytm.vipcashback.g.d$a$a r2 = net.one97.paytm.vipcashback.g.d.a.f21022a
            java.lang.String r2 = net.one97.paytm.vipcashback.g.d.a.f21027f
            java.lang.String r1 = net.one97.paytm.vipcashback.f.d.a.d(r1, r2, r7)
        L_0x02e5:
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            com.paytm.network.b r2 = net.one97.paytm.vipcashback.f.d.a.c()
            com.paytm.network.a$a r3 = com.paytm.network.a.C0715a.GET
            com.paytm.network.b r2 = r2.a((com.paytm.network.a.C0715a) r3)
            com.paytm.network.b r1 = r2.a((java.lang.String) r1)
            net.one97.paytm.vipcashback.f.d$a r2 = net.one97.paytm.vipcashback.f.d.f20859a
            java.util.HashMap r2 = net.one97.paytm.vipcashback.f.d.a.b()
            java.util.Map r2 = (java.util.Map) r2
            com.paytm.network.b r1 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            net.one97.paytm.common.entity.vipcashback.CashbackVoucherDetailsResponse r2 = new net.one97.paytm.common.entity.vipcashback.CashbackVoucherDetailsResponse
            r2.<init>()
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            com.paytm.network.b r1 = r1.a((com.paytm.network.model.IJRPaytmDataModel) r2)
            java.lang.String r2 = "myvoucherdetails"
            com.paytm.network.b r1 = r1.c(r2)
            com.paytm.network.b r1 = r1.a((com.paytm.network.listener.b) r8)
            com.paytm.network.a r2 = r1.l()
        L_0x031a:
            android.app.Application r12 = r12.getApplication()
            android.content.Context r12 = (android.content.Context) r12
            boolean r12 = com.paytm.utility.b.c((android.content.Context) r12)
            if (r12 == 0) goto L_0x032c
            if (r2 == 0) goto L_0x0335
            r2.a()
            goto L_0x0335
        L_0x032c:
            if (r2 == 0) goto L_0x0335
            net.one97.paytm.vipcashback.f.h r12 = net.one97.paytm.vipcashback.f.h.b(r2)
            r0.setValue(r12)
        L_0x0335:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            r12 = r11
            androidx.lifecycle.q r12 = (androidx.lifecycle.q) r12
            net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity$e r1 = new net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity$e
            r1.<init>(r11)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r0.observe(r12, r1)
        L_0x0344:
            net.one97.paytm.vipcashback.c.b r12 = net.one97.paytm.vipcashback.c.a.b()
            r0 = r11
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = "/cashback-voucher/code"
            java.lang.String r2 = "cashback"
            r12.sendOpenScreenWithDeviceInfo(r1, r2, r0)
            return
        L_0x0353:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity.onPostCreate(android.os.Bundle):void");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherDetailsActivity f20665a;

        d(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
            this.f20665a = cashbackVoucherDetailsActivity;
        }

        public final void onClick(View view) {
            k.a((Object) view, "view");
            int id = view.getId();
            if (id == R.id.payButton) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a(view);
                d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity = this.f20665a;
                TextView textView = (TextView) cashbackVoucherDetailsActivity.a(R.id.voucherCodeText);
                k.a((Object) textView, "voucherCodeText");
                d.a.a((Context) cashbackVoucherDetailsActivity, new l("\\s").replace((CharSequence) textView.getText().toString(), ""), false);
                CashbackVoucherDetailsActivity.d(this.f20665a);
                net.one97.paytm.vipcashback.b.a aVar3 = new net.one97.paytm.vipcashback.b.a();
                kotlin.g.a.a<x> aVar4 = new a(this);
                k.c(aVar4, "listner");
                aVar3.f20703a = aVar4;
                aVar3.show(this.f20665a.getSupportFragmentManager(), "");
            } else if (id == R.id.moreDetails) {
                d.a aVar5 = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a(view);
                d.a aVar6 = net.one97.paytm.vipcashback.f.d.f20859a;
                CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity2 = this.f20665a;
                d.a.a((AJRCashBackBaseActivity) cashbackVoucherDetailsActivity2, cashbackVoucherDetailsActivity2.f20661h, "CashbackVoucherDetailsActivity", this.f20665a.getString(R.string.terms_and_conditions), this.f20665a.f20662i, 0);
            } else if (id == R.id.imgDealCopy || id == R.id.voucherCodeText || id == R.id.tapToAvail) {
                d.a aVar7 = net.one97.paytm.vipcashback.f.d.f20859a;
                CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity3 = this.f20665a;
                TextView textView2 = (TextView) cashbackVoucherDetailsActivity3.a(R.id.voucherCodeText);
                k.a((Object) textView2, "voucherCodeText");
                d.a.a((Context) cashbackVoucherDetailsActivity3, new l("\\s").replace((CharSequence) textView2.getText().toString(), ""), false);
                CashbackVoucherDetailsActivity.f(this.f20665a);
                CashbackVoucherDetailsActivity.d(this.f20665a);
            } else if (id == R.id.back_arrow) {
                this.f20665a.onBackPressed();
            }
        }

        static final class a extends kotlin.g.b.l implements kotlin.g.a.a<x> {
            final /* synthetic */ d this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.this$0 = dVar;
            }

            public final void invoke() {
                CashbackVoucherDetailsActivity.e(this.this$0.f20665a);
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherDetailsActivity f20664a;

        c(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
            this.f20664a = cashbackVoucherDetailsActivity;
        }

        public final void run() {
            if (!this.f20664a.isFinishing()) {
                TextView textView = (TextView) this.f20664a.a(R.id.tapToAvail);
                if (textView != null) {
                    textView.setText(this.f20664a.getResources().getString(R.string.tap_to_avail_offer));
                }
                TextView textView2 = (TextView) this.f20664a.a(R.id.tapToAvail);
                if (textView2 != null) {
                    textView2.setTextColor(androidx.core.content.b.c(this.f20664a, R.color.color_506d85));
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f20664a.a(R.id.iv_voucher_code_copy);
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(8);
                }
                int parseColor = Color.parseColor("#1D2F54");
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.f20664a.a(R.id.imgDealCopy);
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setColorFilter(parseColor);
                }
                TextView textView3 = (TextView) this.f20664a.a(R.id.voucherCodeText);
                if (textView3 != null) {
                    textView3.setTextColor(androidx.core.content.b.c(this.f20664a, R.color.color_1d2f54));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001d, code lost:
        r0 = r0.getBackground();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r5 = this;
            int r0 = net.one97.paytm.vipcashback.R.id.moreDetails
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "moreDetails"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 8
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r1 = 0
            if (r0 == 0) goto L_0x0028
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0028
            android.graphics.drawable.Drawable r0 = r0.mutate()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r0 == 0) goto L_0x00b0
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r2 = 3
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.color_00c4ff
            int r4 = androidx.core.content.b.c(r3, r4)
            r0.setStroke(r2, r4)
            int r2 = net.one97.paytm.vipcashback.R.color.white
            int r2 = androidx.core.content.b.c(r3, r2)
            r0.setColor(r2)
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x005c
            android.content.res.Resources r2 = r5.getResources()
            int r4 = net.one97.paytm.vipcashback.R.string.more_details
            java.lang.String r2 = r2.getString(r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x005c:
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x006a
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
        L_0x006a:
            if (r1 == 0) goto L_0x00a8
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r1
            r0 = -2
            r1.width = r0
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0080
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r0.setLayoutParams(r1)
        L_0x0080:
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0093
            int r1 = net.one97.paytm.vipcashback.R.color.color_00c4ff
            int r1 = androidx.core.content.b.c(r3, r1)
            r0.setTextColor(r1)
        L_0x0093:
            int r0 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r5.a((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x00a7
            net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity$b r1 = new net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity$b
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x00a7:
            return
        L_0x00a8:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x00b0:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity.a():void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherDetailsActivity f20663a;

        b(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
            this.f20663a = cashbackVoucherDetailsActivity;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            k.a((Object) view, "it");
            d.a.a(view);
            d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
            CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity = this.f20663a;
            AJRCashBackBaseActivity aJRCashBackBaseActivity = cashbackVoucherDetailsActivity;
            String a2 = cashbackVoucherDetailsActivity.f20661h;
            String string = this.f20663a.getString(R.string.terms_and_conditions);
            String b2 = this.f20663a.f20662i;
            String c2 = this.f20663a.j;
            k.c(aJRCashBackBaseActivity, "activity");
            k.c("CashbackVoucherDetailsActivity", SDKConstants.EVENT_KEY_SCREEN_NAME);
            LayoutInflater layoutInflater = aJRCashBackBaseActivity.getLayoutInflater();
            View view2 = null;
            if (layoutInflater != null) {
                view2 = layoutInflater.inflate(R.layout.cb_offer_details_bottomsheet_lyt, (ViewGroup) null);
            }
            net.one97.paytm.vipcashback.f.d.f20861c = view2;
            com.google.android.material.bottomsheet.a aVar3 = new com.google.android.material.bottomsheet.a(aJRCashBackBaseActivity);
            aVar3.setContentView(net.one97.paytm.vipcashback.f.d.f20861c);
            View b3 = net.one97.paytm.vipcashback.f.d.f20861c;
            if (b3 == null) {
                k.a();
            }
            TextView textView = (TextView) b3.findViewById(R.id.title);
            if (!(string == null || textView == null)) {
                textView.setText(string);
            }
            aVar3.show();
            if (net.one97.paytm.vipcashback.f.d.f20861c != null) {
                View b4 = net.one97.paytm.vipcashback.f.d.f20861c;
                if (b4 == null) {
                    k.a();
                }
                ((ImageView) b4.findViewById(R.id.close)).setOnClickListener(new d.a.g(aVar3));
                boolean z = false;
                if (b2 != null) {
                    if (!(b2.length() == 0)) {
                        d.a.a(b2, c2, aJRCashBackBaseActivity);
                        return;
                    }
                }
                if (a2 != null) {
                    if (a2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        d.a.a(aJRCashBackBaseActivity, a2, "CashbackVoucherDetailsActivity");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x053a  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0615  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0655  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity r13, com.paytm.network.model.IJRPaytmDataModel r14) {
        /*
            int r0 = net.one97.paytm.vipcashback.R.id.dealDetailView
            android.view.View r0 = r13.a((int) r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0.setVisibility(r1)
        L_0x000e:
            if (r14 == 0) goto L_0x065d
            net.one97.paytm.common.entity.vipcashback.CashbackVoucherDetailsResponse r14 = (net.one97.paytm.common.entity.vipcashback.CashbackVoucherDetailsResponse) r14
            net.one97.paytm.common.entity.vipcashback.MyVoucherDetailsResData r14 = r14.getResponse()
            r0 = 0
            if (r14 == 0) goto L_0x001e
            java.lang.String r2 = r14.getTermsUrl()
            goto L_0x001f
        L_0x001e:
            r2 = r0
        L_0x001f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            if (r2 == 0) goto L_0x002d
            int r2 = r2.length()
            if (r2 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r2 = 0
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = ""
            goto L_0x0040
        L_0x0033:
            if (r14 == 0) goto L_0x003a
            java.lang.String r2 = r14.getTermsUrl()
            goto L_0x003b
        L_0x003a:
            r2 = r0
        L_0x003b:
            if (r2 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            r13.f20661h = r2
            if (r14 == 0) goto L_0x0049
            java.lang.String r2 = r14.getTermsText()
            goto L_0x004a
        L_0x0049:
            r2 = r0
        L_0x004a:
            r13.f20662i = r2
            if (r14 == 0) goto L_0x0053
            java.lang.String r2 = r14.getRedemptionTermsText()
            goto L_0x0054
        L_0x0053:
            r2 = r0
        L_0x0054:
            r13.j = r2
            if (r14 == 0) goto L_0x005d
            java.lang.String r2 = r14.getDeeplink()
            goto L_0x005e
        L_0x005d:
            r2 = r0
        L_0x005e:
            r13.k = r2
            if (r14 == 0) goto L_0x0067
            java.lang.String r2 = r14.getBgImage()
            goto L_0x0068
        L_0x0067:
            r2 = r0
        L_0x0068:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0075
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r2 = 0
            goto L_0x0076
        L_0x0075:
            r2 = 1
        L_0x0076:
            if (r2 != 0) goto L_0x0093
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            if (r14 == 0) goto L_0x0083
            java.lang.String r4 = r14.getBgImage()
            goto L_0x0084
        L_0x0083:
            r4 = r0
        L_0x0084:
            com.squareup.picasso.aa r2 = r2.a((java.lang.String) r4)
            int r4 = net.one97.paytm.vipcashback.R.id.cardImage
            android.view.View r4 = r13.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r2.a((android.widget.ImageView) r4)
        L_0x0093:
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            r5 = 8
            if (r14 == 0) goto L_0x017f
            java.lang.String r6 = r14.getRedemptionType()
            if (r6 == 0) goto L_0x017f
            java.lang.String r7 = "VOUCHER"
            boolean r6 = r6.equals(r7)
            if (r6 != r3) goto L_0x017f
            int r6 = net.one97.paytm.vipcashback.R.id.viewDetails
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 32
            if (r6 == 0) goto L_0x00d6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = net.one97.paytm.vipcashback.R.string.cb_avail_offer
            java.lang.String r9 = r13.getString(r9)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = r14.getDescriptionText()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            net.one97.paytm.v2.b.a.a(r6, r8)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x00d6:
            java.lang.String r6 = r14.getTitle()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x00e7
            int r6 = r6.length()
            if (r6 != 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r6 = 0
            goto L_0x00e8
        L_0x00e7:
            r6 = 1
        L_0x00e8:
            if (r6 == 0) goto L_0x0107
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r8 = net.one97.paytm.vipcashback.R.string.cb_voucher
            java.lang.String r8 = r13.getString(r8)
            r6.append(r8)
            r6.append(r7)
            java.lang.String r7 = r14.getSavingsText()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x013b
        L_0x0107:
            java.lang.String r6 = r14.getTitle()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = " "
            r8.<init>(r9)
            int r9 = net.one97.paytm.vipcashback.R.string.cb_voucher
            java.lang.String r9 = r13.getString(r9)
            java.lang.String r10 = "getString(R.string.cb_voucher)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            if (r9 == 0) goto L_0x0179
            java.lang.String r9 = r9.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r14.getSavingsText()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r6 = kotlin.g.b.k.a((java.lang.String) r6, (java.lang.Object) r7)
        L_0x013b:
            int r7 = net.one97.paytm.vipcashback.R.id.cashbackText
            android.view.View r7 = r13.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x014a
            net.one97.paytm.v2.b.a.a(r7, r6)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x014a:
            int r6 = net.one97.paytm.vipcashback.R.id.validity
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x015d
            java.lang.String r7 = r14.getValidity()
            net.one97.paytm.v2.b.a.a(r6, r7)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x015d:
            int r6 = net.one97.paytm.vipcashback.R.id.pin
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x016a
            r6.setVisibility(r5)
        L_0x016a:
            int r6 = net.one97.paytm.vipcashback.R.id.pin_text
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x031a
            r6.setVisibility(r5)
            goto L_0x031a
        L_0x0179:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r2)
            throw r13
        L_0x017f:
            int r6 = net.one97.paytm.vipcashback.R.id.viewDetails
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0196
            if (r14 == 0) goto L_0x0190
            java.lang.String r7 = r14.getUsageText()
            goto L_0x0191
        L_0x0190:
            r7 = r0
        L_0x0191:
            net.one97.paytm.v2.b.a.a(r6, r7)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x0196:
            int r6 = net.one97.paytm.vipcashback.R.id.cashbackText
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x01ad
            if (r14 == 0) goto L_0x01a7
            java.lang.String r7 = r14.getDescriptionText()
            goto L_0x01a8
        L_0x01a7:
            r7 = r0
        L_0x01a8:
            net.one97.paytm.v2.b.a.a(r6, r7)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x01ad:
            java.lang.String r6 = "dd MMM yyyy"
            java.lang.String r7 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
            if (r14 == 0) goto L_0x0215
            java.lang.String r8 = r14.getValidFrom()
            if (r8 == 0) goto L_0x0215
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 != 0) goto L_0x01c3
            r8 = 1
            goto L_0x01c4
        L_0x01c3:
            r8 = 0
        L_0x01c4:
            if (r8 != 0) goto L_0x0215
            java.lang.String r8 = r14.getValidUpto()
            if (r8 == 0) goto L_0x0215
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 != 0) goto L_0x01d6
            r8 = 1
            goto L_0x01d7
        L_0x01d6:
            r8 = 0
        L_0x01d7:
            if (r8 != 0) goto L_0x0215
            int r8 = net.one97.paytm.vipcashback.R.id.validity
            android.view.View r8 = r13.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0293
            int r9 = net.one97.paytm.vipcashback.R.string.offer_validity_from
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r11 = r14.getValidFrom()
            if (r11 != 0) goto L_0x01f3
            kotlin.g.b.k.a()
        L_0x01f3:
            java.lang.String r11 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r11, (java.lang.String) r7, (java.lang.String) r6)
            r10[r1] = r11
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r11 = r14.getValidUpto()
            if (r11 != 0) goto L_0x0204
            kotlin.g.b.k.a()
        L_0x0204:
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r11, (java.lang.String) r7, (java.lang.String) r6)
            r10[r3] = r6
            java.lang.String r6 = r13.getString(r9, r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
            goto L_0x0293
        L_0x0215:
            if (r14 == 0) goto L_0x0253
            java.lang.String r8 = r14.getValidUpto()
            if (r8 == 0) goto L_0x0253
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0227
            r8 = 1
            goto L_0x0228
        L_0x0227:
            r8 = 0
        L_0x0228:
            if (r8 != 0) goto L_0x0253
            int r8 = net.one97.paytm.vipcashback.R.id.validity
            android.view.View r8 = r13.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0293
            int r9 = net.one97.paytm.vipcashback.R.string.offer_valid_till_redemption
            java.lang.Object[] r10 = new java.lang.Object[r3]
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r11 = r14.getValidUpto()
            if (r11 != 0) goto L_0x0243
            kotlin.g.b.k.a()
        L_0x0243:
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r11, (java.lang.String) r7, (java.lang.String) r6)
            r10[r1] = r6
            java.lang.String r6 = r13.getString(r9, r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
            goto L_0x0293
        L_0x0253:
            if (r14 == 0) goto L_0x0293
            java.lang.String r8 = r14.getValidFrom()
            if (r8 == 0) goto L_0x0293
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0265
            r8 = 1
            goto L_0x0266
        L_0x0265:
            r8 = 0
        L_0x0266:
            if (r8 != 0) goto L_0x0293
            int r8 = net.one97.paytm.vipcashback.R.id.validity
            android.view.View r8 = r13.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r9 = "validity"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            int r9 = net.one97.paytm.vipcashback.R.string.offer_valid_from_redemption
            java.lang.Object[] r10 = new java.lang.Object[r3]
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r11 = r14.getValidFrom()
            if (r11 != 0) goto L_0x0284
            kotlin.g.b.k.a()
        L_0x0284:
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r11, (java.lang.String) r7, (java.lang.String) r6)
            r10[r1] = r6
            java.lang.String r6 = r13.getString(r9, r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
        L_0x0293:
            if (r14 == 0) goto L_0x029a
            java.lang.String r6 = r14.getSecret()
            goto L_0x029b
        L_0x029a:
            r6 = r0
        L_0x029b:
            if (r6 == 0) goto L_0x0300
            java.lang.String r6 = r14.getSecret()
            if (r6 == 0) goto L_0x02b3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x02ad
            r6 = 1
            goto L_0x02ae
        L_0x02ad:
            r6 = 0
        L_0x02ae:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x02b4
        L_0x02b3:
            r6 = r0
        L_0x02b4:
            if (r6 != 0) goto L_0x02b9
            kotlin.g.b.k.a()
        L_0x02b9:
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0300
            int r6 = net.one97.paytm.vipcashback.R.id.pin
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x02cc
            r6.setVisibility(r1)
        L_0x02cc:
            int r6 = net.one97.paytm.vipcashback.R.id.pin_text
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x02d9
            r6.setVisibility(r1)
        L_0x02d9:
            int r6 = net.one97.paytm.vipcashback.R.id.pin_text
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x031a
            java.lang.String r7 = r14.getSecret()
            if (r7 == 0) goto L_0x02f9
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            kotlin.m.l r8 = new kotlin.m.l
            java.lang.String r9 = "..."
            r8.<init>((java.lang.String) r9)
            java.lang.String r9 = "$0 "
            java.lang.String r7 = r8.replace((java.lang.CharSequence) r7, (java.lang.String) r9)
            goto L_0x02fa
        L_0x02f9:
            r7 = r0
        L_0x02fa:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x031a
        L_0x0300:
            int r6 = net.one97.paytm.vipcashback.R.id.pin
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x030d
            r6.setVisibility(r5)
        L_0x030d:
            int r6 = net.one97.paytm.vipcashback.R.id.pin_text
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x031a
            r6.setVisibility(r5)
        L_0x031a:
            int r6 = net.one97.paytm.vipcashback.R.id.earnedForText
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0327
            r6.setVisibility(r1)
        L_0x0327:
            if (r14 == 0) goto L_0x032e
            java.lang.String r6 = r14.getEarnedForText()
            goto L_0x032f
        L_0x032e:
            r6 = r0
        L_0x032f:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x033c
            int r6 = r6.length()
            if (r6 != 0) goto L_0x033a
            goto L_0x033c
        L_0x033a:
            r6 = 0
            goto L_0x033d
        L_0x033c:
            r6 = 1
        L_0x033d:
            if (r6 != 0) goto L_0x03b1
            int r6 = net.one97.paytm.vipcashback.R.id.earnedForText
            android.view.View r6 = r13.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x03b1
            int r7 = net.one97.paytm.vipcashback.R.string.voucher_won_label
            java.lang.Object[] r8 = new java.lang.Object[r3]
            if (r14 == 0) goto L_0x03a5
            java.lang.String r9 = r14.getEarnedForText()
            if (r9 == 0) goto L_0x03a5
            java.lang.String r10 = "$this$decapitalize"
            kotlin.g.b.k.d(r9, r10)
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0365
            r10 = 1
            goto L_0x0366
        L_0x0365:
            r10 = 0
        L_0x0366:
            if (r10 == 0) goto L_0x03a3
            char r10 = r9.charAt(r1)
            boolean r10 = java.lang.Character.isLowerCase(r10)
            if (r10 != 0) goto L_0x03a3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r9.substring(r1, r3)
            java.lang.String r12 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.b(r11, r12)
            if (r11 == 0) goto L_0x039d
            java.lang.String r2 = r11.toLowerCase()
            kotlin.g.b.k.b(r2, r4)
            r10.append(r2)
            java.lang.String r2 = r9.substring(r3)
            java.lang.String r4 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.b(r2, r4)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            goto L_0x03a6
        L_0x039d:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>(r2)
            throw r13
        L_0x03a3:
            r2 = r9
            goto L_0x03a6
        L_0x03a5:
            r2 = r0
        L_0x03a6:
            r8[r1] = r2
            java.lang.String r2 = r13.getString(r7, r8)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
        L_0x03b1:
            java.lang.String r2 = "voucherCodeText"
            if (r14 == 0) goto L_0x044e
            java.lang.String r4 = r14.getPromocode()
            if (r4 == 0) goto L_0x044e
            java.lang.String r6 = "No Coupon code Required"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r6, (boolean) r3)
            if (r4 != r3) goto L_0x044e
            int r4 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            r4.setVisibility(r1)
            int r2 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x03e9
            java.lang.String r4 = r14.getPromocode()
            if (r4 != 0) goto L_0x03e4
            kotlin.g.b.k.a()
        L_0x03e4:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x03e9:
            int r2 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r2 = r13.a((int) r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x03f8
            r2.setOnClickListener(r0)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x03f8:
            int r2 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r2 = r13.a((int) r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x0409
            int r4 = net.one97.paytm.vipcashback.R.drawable.ic_copy_button_cashback_fade
            r2.setImageResource(r4)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x0409:
            int r2 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r2 = r13.a((int) r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x0416
            r2.setClickable(r1)
        L_0x0416:
            int r2 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0425
            r2.setOnClickListener(r0)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x0425:
            int r2 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0434
            r2.setOnClickListener(r0)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x0434:
            int r2 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x04be
            r4 = r13
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.vipcashback.R.color.color_4c8ba6c1
            int r4 = androidx.core.content.b.c(r4, r5)
            r2.setTextColor(r4)
            kotlin.x r2 = kotlin.x.f47997a
            goto L_0x04be
        L_0x044e:
            if (r14 == 0) goto L_0x0455
            java.lang.String r4 = r14.getPromocode()
            goto L_0x0456
        L_0x0455:
            r4 = r0
        L_0x0456:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0463
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0461
            goto L_0x0463
        L_0x0461:
            r4 = 0
            goto L_0x0464
        L_0x0463:
            r4 = 1
        L_0x0464:
            if (r4 != 0) goto L_0x0497
            int r4 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r4 = r13.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            r4.setVisibility(r1)
            int r2 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x04be
            net.one97.paytm.vipcashback.f.d$a r4 = net.one97.paytm.vipcashback.f.d.f20859a
            if (r14 == 0) goto L_0x0487
            java.lang.String r4 = r14.getPromocode()
            goto L_0x0488
        L_0x0487:
            r4 = r0
        L_0x0488:
            if (r4 != 0) goto L_0x048d
            kotlin.g.b.k.a()
        L_0x048d:
            java.lang.String r4 = net.one97.paytm.vipcashback.f.d.a.d(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x04be
        L_0x0497:
            int r2 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x04a4
            r2.setVisibility(r5)
        L_0x04a4:
            int r2 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x04b1
            r2.setVisibility(r5)
        L_0x04b1:
            int r2 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r2 = r13.a((int) r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x04be
            r2.setVisibility(r5)
        L_0x04be:
            int r2 = net.one97.paytm.vipcashback.R.id.winningTextView
            android.view.View r2 = r13.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x04dc
            if (r14 == 0) goto L_0x04d1
            java.lang.String r4 = r14.getWinningText()
            if (r4 == 0) goto L_0x04d1
            goto L_0x04d7
        L_0x04d1:
            int r4 = net.one97.paytm.vipcashback.R.string.cb_you_won
            java.lang.String r4 = r13.getString(r4)
        L_0x04d7:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x04dc:
            if (r14 == 0) goto L_0x04e3
            java.lang.String r2 = r14.getCta()
            goto L_0x04e4
        L_0x04e3:
            r2 = r0
        L_0x04e4:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x04f1
            int r2 = r2.length()
            if (r2 != 0) goto L_0x04ef
            goto L_0x04f1
        L_0x04ef:
            r2 = 0
            goto L_0x04f2
        L_0x04f1:
            r2 = 1
        L_0x04f2:
            if (r2 != 0) goto L_0x0531
            if (r14 == 0) goto L_0x04fb
            java.lang.String r2 = r14.getDeeplink()
            goto L_0x04fc
        L_0x04fb:
            r2 = r0
        L_0x04fc:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0509
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0507
            goto L_0x0509
        L_0x0507:
            r2 = 0
            goto L_0x050a
        L_0x0509:
            r2 = 1
        L_0x050a:
            if (r2 != 0) goto L_0x0531
            int r2 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r2 = r13.a((int) r2)
            android.widget.Button r2 = (android.widget.Button) r2
            if (r2 == 0) goto L_0x0519
            r2.setVisibility(r1)
        L_0x0519:
            int r2 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r2 = r13.a((int) r2)
            android.widget.Button r2 = (android.widget.Button) r2
            if (r2 == 0) goto L_0x0534
            if (r14 == 0) goto L_0x052a
            java.lang.String r4 = r14.getCta()
            goto L_0x052b
        L_0x052a:
            r4 = r0
        L_0x052b:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x0534
        L_0x0531:
            r13.a()
        L_0x0534:
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            if (r14 == 0) goto L_0x053f
            java.lang.String r4 = r14.getIcon()
            goto L_0x0540
        L_0x053f:
            r4 = r0
        L_0x0540:
            com.squareup.picasso.aa r2 = r2.a((java.lang.String) r4)
            int r4 = net.one97.paytm.vipcashback.R.drawable.cashback_icon_holder
            com.squareup.picasso.aa r2 = r2.a((int) r4)
            int r4 = net.one97.paytm.vipcashback.R.id.cardOfferImage
            android.view.View r4 = r13.a((int) r4)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
            r2.a((android.widget.ImageView) r4)
            if (r14 == 0) goto L_0x055c
            java.lang.String r2 = r14.getStatus()
            goto L_0x055d
        L_0x055c:
            r2 = r0
        L_0x055d:
            java.lang.String r4 = r
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 != 0) goto L_0x0585
            if (r14 == 0) goto L_0x056c
            java.lang.String r2 = r14.getStatus()
            goto L_0x056d
        L_0x056c:
            r2 = r0
        L_0x056d:
            java.lang.String r4 = s
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 != 0) goto L_0x0585
            if (r14 == 0) goto L_0x057c
            java.lang.String r14 = r14.getStatus()
            goto L_0x057d
        L_0x057c:
            r14 = r0
        L_0x057d:
            java.lang.String r2 = u
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r3)
            if (r14 == 0) goto L_0x0654
        L_0x0585:
            int r14 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0594
            r14.setOnClickListener(r0)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x0594:
            int r14 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r14 = r13.a((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            if (r14 == 0) goto L_0x05a3
            r14.setOnClickListener(r0)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x05a3:
            int r14 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x05b2
            r14.setOnClickListener(r0)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x05b2:
            int r14 = net.one97.paytm.vipcashback.R.id.voucherCodeText
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x05ca
            r2 = r13
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.vipcashback.R.color.color_4c8ba6c1
            int r2 = androidx.core.content.b.c(r2, r3)
            r14.setTextColor(r2)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x05ca:
            int r14 = net.one97.paytm.vipcashback.R.id.tapToAvail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x05e2
            r2 = r13
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.vipcashback.R.color.color_4c8ba6c1
            int r2 = androidx.core.content.b.c(r2, r3)
            r14.setTextColor(r2)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x05e2:
            int r14 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r14 = r13.a((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            if (r14 == 0) goto L_0x05f3
            int r2 = net.one97.paytm.vipcashback.R.drawable.ic_copy_button_cashback_fade
            r14.setImageResource(r2)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x05f3:
            int r14 = net.one97.paytm.vipcashback.R.id.imgDealCopy
            android.view.View r14 = r13.a((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            if (r14 == 0) goto L_0x0600
            r14.setClickable(r1)
        L_0x0600:
            int r14 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r14 = r13.a((int) r14)
            android.widget.Button r14 = (android.widget.Button) r14
            if (r14 == 0) goto L_0x0615
            android.graphics.drawable.Drawable r14 = r14.getBackground()
            if (r14 == 0) goto L_0x0615
            android.graphics.drawable.Drawable r14 = r14.mutate()
            goto L_0x0616
        L_0x0615:
            r14 = r0
        L_0x0616:
            if (r14 == 0) goto L_0x0655
            android.graphics.drawable.GradientDrawable r14 = (android.graphics.drawable.GradientDrawable) r14
            r1 = 3
            r2 = r13
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.common.assets.R.color.light_grey
            int r3 = androidx.core.content.b.c(r2, r3)
            r14.setStroke(r1, r3)
            int r1 = net.one97.paytm.vipcashback.R.color.color_4c8ba6c1
            int r1 = androidx.core.content.b.c(r2, r1)
            r14.setColor(r1)
            int r14 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r14 = r13.a((int) r14)
            android.widget.Button r14 = (android.widget.Button) r14
            if (r14 == 0) goto L_0x063f
            r14.setOnClickListener(r0)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x063f:
            int r14 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r13 = r13.a((int) r14)
            android.widget.Button r13 = (android.widget.Button) r13
            if (r13 == 0) goto L_0x0654
            int r14 = net.one97.paytm.vipcashback.R.color.color_ffffff
            int r14 = androidx.core.content.b.c(r2, r14)
            r13.setTextColor(r14)
            kotlin.x r13 = kotlin.x.f47997a
        L_0x0654:
            return
        L_0x0655:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r13.<init>(r14)
            throw r13
        L_0x065d:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.CashbackVoucherDetailsResponse"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity.a(net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public static final /* synthetic */ int d(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
        ArrayList arrayList;
        CharSequence charSequence = cashbackVoucherDetailsActivity.m;
        if (!(charSequence == null || charSequence.length() == 0)) {
            arrayList = new ArrayList();
            String str = cashbackVoucherDetailsActivity.m;
            if (str == null) {
                k.a();
            }
            arrayList.add(str);
        } else {
            arrayList = null;
        }
        net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(cashbackVoucherDetailsActivity, "voucher_code_copy_clicked", "my_vouchers", arrayList, (String) null, "/cashback-offers/vouchers-listing", "cashback");
        return 0;
    }

    public static final /* synthetic */ void e(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
        String str = cashbackVoucherDetailsActivity.k;
        if (str != null) {
            boolean z = true;
            if (!p.b(str, "https://", true) && !p.b(str, "http://", true)) {
                z = false;
            }
            if (z) {
                cashbackVoucherDetailsActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
            } else {
                net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(cashbackVoucherDetailsActivity, cashbackVoucherDetailsActivity.k);
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(cashbackVoucherDetailsActivity, "cashback_offers", "redeem_now_clicked", new ArrayList(), (String) null, "/cashback-offers/voucher-code", "cashback");
        }
    }

    public static final /* synthetic */ void f(CashbackVoucherDetailsActivity cashbackVoucherDetailsActivity) {
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        AppCompatImageView appCompatImageView = (AppCompatImageView) cashbackVoucherDetailsActivity.a(R.id.imgDealCopy);
        k.a((Object) appCompatImageView, "imgDealCopy");
        d.a.a((View) appCompatImageView);
        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
        TextView textView = (TextView) cashbackVoucherDetailsActivity.a(R.id.voucherCodeText);
        k.a((Object) textView, "voucherCodeText");
        d.a.a((View) textView);
        d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
        TextView textView2 = (TextView) cashbackVoucherDetailsActivity.a(R.id.tapToAvail);
        k.a((Object) textView2, "tapToAvail");
        d.a.a((View) textView2);
        TextView textView3 = (TextView) cashbackVoucherDetailsActivity.a(R.id.tapToAvail);
        if (textView3 != null) {
            textView3.setText(cashbackVoucherDetailsActivity.getResources().getString(R.string.voucher_code_copied_label));
        }
        TextView textView4 = (TextView) cashbackVoucherDetailsActivity.a(R.id.tapToAvail);
        if (textView4 != null) {
            textView4.setTextColor(androidx.core.content.b.c(cashbackVoucherDetailsActivity, R.color.color_21c17a));
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) cashbackVoucherDetailsActivity.a(R.id.iv_voucher_code_copy);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
        int parseColor = Color.parseColor("#506D85");
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) cashbackVoucherDetailsActivity.a(R.id.imgDealCopy);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setColorFilter(parseColor);
        }
        TextView textView5 = (TextView) cashbackVoucherDetailsActivity.a(R.id.voucherCodeText);
        if (textView5 != null) {
            textView5.setTextColor(androidx.core.content.b.c(cashbackVoucherDetailsActivity, R.color.color_506d85));
        }
        new Handler().postDelayed(new c(cashbackVoucherDetailsActivity), 2000);
    }
}
