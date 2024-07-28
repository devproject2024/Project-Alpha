package net.one97.paytm.vipcashback.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.CashbackDealData;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModal;
import net.one97.paytm.common.entity.vipcashback.CashbackDeeplinkItem;
import net.one97.paytm.common.entity.vipcashback.CashbackStageItem;
import net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;

public final class CashbackAdditionalOfferActivity extends AJRCashBackBaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f20649a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public VIPCashBackOffer f20650d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f20651e = -1;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f20652f;

    public final View a(int i2) {
        if (this.f20652f == null) {
            this.f20652f = new HashMap();
        }
        View view = (View) this.f20652f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20652f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cashback_additional_offer);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.a((CharSequence) "");
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.b(true);
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("gameid") : null;
        Intent intent2 = getIntent();
        int i2 = -1;
        if (intent2 != null) {
            i2 = intent2.getIntExtra("txnnumber", -1);
        }
        this.f20651e = i2;
        CashbackDeeplinkItem cashbackDeeplinkItem = net.one97.paytm.vipcashback.c.a.b().getCashbackDeeplinkItem((IJRDataModel) getIntent().getSerializableExtra("extra_home_data"));
        if (TextUtils.isEmpty(stringExtra) && cashbackDeeplinkItem != null) {
            stringExtra = cashbackDeeplinkItem.getCashbackOfferId();
            Integer cashbackTxnNo = cashbackDeeplinkItem.getCashbackTxnNo();
            k.a((Object) cashbackTxnNo, "item.cashbackTxnNo");
            this.f20651e = cashbackTxnNo.intValue();
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            a(false);
            if (stringExtra == null) {
                k.a();
            }
            StringBuilder sb = new StringBuilder();
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            sb.append(f.c());
            sb.append("/");
            sb.append(stringExtra);
            String sb2 = sb.toString();
            d.a aVar = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(sb2);
            d.a aVar2 = d.f20859a;
            Context context = this;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.a(context)).a((IJRPaytmDataModel) new CashBackBaseMyOfferModal()).c(this.f20644b).a((com.paytm.network.listener.b) new a(this)).l();
            if (com.paytm.utility.b.c(context)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loader));
                l.a();
                return;
            }
            k.a((Object) l, "networkCall");
            a(l);
            return;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("stageItem");
        if (serializableExtra != null) {
            a((CashbackStageItem) serializableExtra);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.CashbackStageItem");
    }

    public final void onBackPressed() {
        if (!this.f20649a || this.f20650d == null) {
            super.onBackPressed();
        }
    }

    private final void a(boolean z) {
        if (z) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.consLayoutMain);
            k.a((Object) constraintLayout, "consLayoutMain");
            constraintLayout.setVisibility(0);
            CardView cardView = (CardView) a(R.id.cardViewDetails);
            k.a((Object) cardView, "cardViewDetails");
            cardView.setVisibility(0);
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtValidity);
            k.a((Object) roboTextView, "txtValidity");
            roboTextView.setVisibility(0);
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblViewDetails);
            k.a((Object) roboTextView2, "lblViewDetails");
            roboTextView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.consLayoutMain);
        k.a((Object) constraintLayout2, "consLayoutMain");
        constraintLayout2.setVisibility(8);
        CardView cardView2 = (CardView) a(R.id.cardViewDetails);
        k.a((Object) cardView2, "cardViewDetails");
        cardView2.setVisibility(8);
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.txtValidity);
        k.a((Object) roboTextView3, "txtValidity");
        roboTextView3.setVisibility(8);
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.lblViewDetails);
        k.a((Object) roboTextView4, "lblViewDetails");
        roboTextView4.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.vipcashback.CashbackStageItem r11) {
        /*
            r10 = this;
            r0 = 1
            r10.a((boolean) r0)
            if (r11 != 0) goto L_0x0009
            r10.onBackPressed()
        L_0x0009:
            java.lang.String r1 = "dd MMM yyyy"
            r2 = 0
            if (r11 == 0) goto L_0x0013
            net.one97.paytm.cashback.posttxn.CashbackDealData r3 = r11.getCashbackDealData()
            goto L_0x0014
        L_0x0013:
            r3 = r2
        L_0x0014:
            if (r3 == 0) goto L_0x020f
            net.one97.paytm.cashback.posttxn.CashbackDealData r3 = r11.getCashbackDealData()
            int r4 = net.one97.paytm.vipcashback.R.id.txtTitle
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            java.lang.String r5 = "txtTitle"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = "dealData"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r5 = r3.getDealText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            net.one97.paytm.vipcashback.f.d$a r4 = net.one97.paytm.vipcashback.f.d.f20859a
            r4 = r10
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.vipcashback.R.id.imgVoucher
            android.view.View r5 = r10.a((int) r5)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r5 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r5
            java.lang.String r6 = "imgVoucher"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r6 = r3.getDealIcon()
            net.one97.paytm.vipcashback.f.d.a.a((android.content.Context) r4, (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r5, (java.lang.String) r6)
            int r4 = net.one97.paytm.vipcashback.R.id.imgVoucher
            android.view.View r4 = r10.a((int) r4)
            net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
            r4.setCircularBorder(r0)
            int r4 = net.one97.paytm.vipcashback.R.id.imgCopy
            android.view.View r4 = r10.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            r5 = r10
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            int r4 = net.one97.paytm.vipcashback.R.id.txtPromoCode
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            r4.setOnClickListener(r5)
            java.lang.String r4 = r3.getDealCode()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 8
            java.lang.String r6 = "txtPromoCode"
            if (r4 != 0) goto L_0x00c8
            java.lang.String r4 = r3.getDealCode()
            if (r4 == 0) goto L_0x00c8
            java.lang.String r7 = "No Coupon code Required"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r7, (boolean) r0)
            if (r4 != r0) goto L_0x00c8
            int r4 = net.one97.paytm.vipcashback.R.id.txtPromoCode
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r6 = r3.getDealCode()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            int r4 = net.one97.paytm.vipcashback.R.id.imgCopy
            android.view.View r4 = r10.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            if (r4 == 0) goto L_0x00b1
            r4.setVisibility(r5)
        L_0x00b1:
            int r4 = net.one97.paytm.vipcashback.R.id.imgCopy
            android.view.View r4 = r10.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            r4.setOnClickListener(r2)
            int r4 = net.one97.paytm.vipcashback.R.id.txtPromoCode
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            r4.setOnClickListener(r2)
            goto L_0x0101
        L_0x00c8:
            java.lang.String r4 = r3.getDealCode()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00f3
            int r4 = net.one97.paytm.vipcashback.R.id.txtPromoCode
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r5 = r3.getDealCode()
            if (r5 == 0) goto L_0x00ec
            net.one97.paytm.vipcashback.f.d$a r6 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r5 = net.one97.paytm.vipcashback.f.d.a.d(r5)
            goto L_0x00ed
        L_0x00ec:
            r5 = r2
        L_0x00ed:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            goto L_0x0101
        L_0x00f3:
            int r4 = net.one97.paytm.vipcashback.R.id.txtPromoCode
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r4.setVisibility(r5)
        L_0x0101:
            int r4 = net.one97.paytm.vipcashback.R.id.tv_voucher_decription
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            java.lang.String r5 = "tv_voucher_decription"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = r3.getDealUsageText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            java.lang.String r4 = "dd/MM/yyyy"
            net.one97.paytm.vipcashback.f.d$a r5 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r5 = r3.getDealValidFrom()
            java.lang.String r6 = "dealData.dealValidFrom"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = net.one97.paytm.vipcashback.f.d.a.b((java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r6 = r3.getDealExpiry()
            java.lang.String r7 = "txtValidity"
            r8 = 0
            if (r6 == 0) goto L_0x016c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 != 0) goto L_0x013b
            r6 = 1
            goto L_0x013c
        L_0x013b:
            r6 = 0
        L_0x013c:
            r6 = r6 ^ r0
            if (r6 != r0) goto L_0x016c
            net.one97.paytm.vipcashback.f.d$a r6 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r6 = r3.getDealExpiry()
            java.lang.String r9 = "dealData.dealExpiry"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r1 = net.one97.paytm.vipcashback.f.d.a.b((java.lang.String) r6, (java.lang.String) r4, (java.lang.String) r1)
            int r4 = net.one97.paytm.vipcashback.R.id.txtValidity
            android.view.View r4 = r10.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            int r6 = net.one97.paytm.vipcashback.R.string.offer_validity_from
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r8] = r5
            r7[r0] = r1
            java.lang.String r1 = r10.getString(r6, r7)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            goto L_0x0186
        L_0x016c:
            int r1 = net.one97.paytm.vipcashback.R.id.txtValidity
            android.view.View r1 = r10.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r4 = net.one97.paytm.vipcashback.R.string.offer_validity_from_date
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r8] = r5
            java.lang.String r4 = r10.getString(r4, r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x0186:
            int r1 = net.one97.paytm.vipcashback.R.id.lblViewDetails
            android.view.View r1 = r10.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity$b r4 = new net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity$b
            r4.<init>(r10, r3)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
            if (r11 == 0) goto L_0x019f
            net.one97.paytm.cashback.posttxn.CashbackDealData r1 = r11.getCashbackDealData()
            goto L_0x01a0
        L_0x019f:
            r1 = r2
        L_0x01a0:
            java.lang.String r3 = "cashbackStageItem?.cashbackDealData"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r1 = r1.getSecretPin()
            if (r1 == 0) goto L_0x020f
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01b5
            r1 = 1
            goto L_0x01b6
        L_0x01b5:
            r1 = 0
        L_0x01b6:
            r1 = r1 ^ r0
            if (r1 != r0) goto L_0x020f
            int r0 = net.one97.paytm.vipcashback.R.id.divider
            android.view.View r0 = r10.a((int) r0)
            java.lang.String r1 = "divider"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r8)
            int r0 = net.one97.paytm.vipcashback.R.id.pinNumber
            android.view.View r0 = r10.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            java.lang.String r1 = "pinNumber"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r8)
            int r0 = net.one97.paytm.vipcashback.R.id.pinNumber
            android.view.View r0 = r10.a((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r4 = net.one97.paytm.vipcashback.R.string.deal_pin
            java.lang.String r4 = r10.getString(r4)
            r1.append(r4)
            java.lang.String r4 = " "
            r1.append(r4)
            if (r11 == 0) goto L_0x01fb
            net.one97.paytm.cashback.posttxn.CashbackDealData r2 = r11.getCashbackDealData()
        L_0x01fb:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r11 = r2.getSecretPin()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setText(r11)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity.a(net.one97.paytm.common.entity.vipcashback.CashbackStageItem):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackAdditionalOfferActivity f20654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CashbackDealData f20655b;

        b(CashbackAdditionalOfferActivity cashbackAdditionalOfferActivity, CashbackDealData cashbackDealData) {
            this.f20654a = cashbackAdditionalOfferActivity;
            this.f20655b = cashbackDealData;
        }

        public final void onClick(View view) {
            d.a aVar = d.f20859a;
            CashbackAdditionalOfferActivity cashbackAdditionalOfferActivity = this.f20654a;
            AppCompatActivity appCompatActivity = cashbackAdditionalOfferActivity;
            String string = cashbackAdditionalOfferActivity.getString(R.string.offer_tnc);
            CashbackDealData cashbackDealData = this.f20655b;
            k.a((Object) cashbackDealData, "dealData");
            String dealTerms = cashbackDealData.getDealTerms();
            k.c(appCompatActivity, "activity");
            com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(appCompatActivity);
            View inflate = appCompatActivity.getLayoutInflater().inflate(R.layout.cb_offer_details_bottomsheet_lyt, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.title);
            k.a((Object) findViewById, "bottomSheetView.findViewById<TextView>(R.id.title)");
            ((TextView) findViewById).setText(string);
            TextView textView = (TextView) inflate.findViewById(R.id.tnc_text);
            k.a((Object) textView, "tncTV");
            d.a aVar3 = d.f20859a;
            textView.setText(d.a.a(dealTerms, textView));
            ((ImageView) inflate.findViewById(R.id.close)).setOnClickListener(new d.a.o(aVar2));
            aVar2.setContentView(inflate);
            aVar2.show();
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackAdditionalOfferActivity f20653a;

        a(CashbackAdditionalOfferActivity cashbackAdditionalOfferActivity) {
            this.f20653a = cashbackAdditionalOfferActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0115, code lost:
            if (r1.equals(r0.getRedemptionType()) != false) goto L_0x0117;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModal
                if (r0 == 0) goto L_0x0166
                net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModal r6 = (net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModal) r6
                int r0 = r6.getStatus()
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L_0x0137
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r0 = r6.getData()
                if (r0 == 0) goto L_0x0137
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r0 = r5.f20653a
                net.one97.paytm.common.widgets.a.b((com.airbnb.lottie.LottieAnimationView) r0.a(net.one97.paytm.vipcashback.R.id.loader))
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r0 = r5.f20653a
                r0.f20649a = true
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r0 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.getData()
                if (r6 == 0) goto L_0x012f
                r0.f20650d = r6
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.f20650d
                if (r6 == 0) goto L_0x0166
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.f20650d
                r0 = 0
                if (r6 == 0) goto L_0x003f
                net.one97.paytm.common.entity.vipcashback.Info r6 = r6.getInfo()
                goto L_0x0040
            L_0x003f:
                r6 = r0
            L_0x0040:
                if (r6 == 0) goto L_0x0129
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.f20650d
                if (r6 == 0) goto L_0x0055
                net.one97.paytm.common.entity.vipcashback.Info r6 = r6.getInfo()
                if (r6 == 0) goto L_0x0055
                java.util.ArrayList r6 = r6.getTransactions()
                goto L_0x0056
            L_0x0055:
                r6 = r0
            L_0x0056:
                if (r6 == 0) goto L_0x0129
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                int r6 = r6.f20651e
                if (r6 < 0) goto L_0x0129
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.f20650d
                if (r6 == 0) goto L_0x0079
                net.one97.paytm.common.entity.vipcashback.Info r6 = r6.getInfo()
                if (r6 == 0) goto L_0x0079
                java.util.ArrayList r6 = r6.getTransactions()
                if (r6 == 0) goto L_0x0079
                int r6 = r6.size()
                goto L_0x007a
            L_0x0079:
                r6 = 0
            L_0x007a:
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r1 = r5.f20653a
                int r1 = r1.f20651e
                if (r6 <= r1) goto L_0x0129
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer r6 = r6.f20650d
                if (r6 == 0) goto L_0x00a9
                net.one97.paytm.common.entity.vipcashback.Info r6 = r6.getInfo()
                if (r6 == 0) goto L_0x00a9
                java.util.ArrayList r6 = r6.getTransactions()
                if (r6 == 0) goto L_0x00a9
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r1 = r5.f20653a
                int r1 = r1.f20651e
                java.lang.Object r6 = r6.get(r1)
                net.one97.paytm.common.entity.vipcashback.VIPCashBackTransaction r6 = (net.one97.paytm.common.entity.vipcashback.VIPCashBackTransaction) r6
                if (r6 == 0) goto L_0x00a9
                java.util.ArrayList r6 = r6.getStages()
                goto L_0x00aa
            L_0x00a9:
                r6 = r0
            L_0x00aa:
                if (r6 == 0) goto L_0x00b1
                int r1 = r6.size()
                goto L_0x00b2
            L_0x00b1:
                r1 = 0
            L_0x00b2:
                if (r1 <= 0) goto L_0x0123
                if (r6 == 0) goto L_0x00bd
                java.lang.Object r1 = r6.get(r2)
                net.one97.paytm.common.entity.vipcashback.CashbackStageItem r1 = (net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r1
                goto L_0x00be
            L_0x00bd:
                r1 = r0
            L_0x00be:
                if (r1 == 0) goto L_0x0123
                net.one97.paytm.vipcashback.d.a$g$a r1 = net.one97.paytm.vipcashback.d.a.g.f20797a
                java.lang.String r1 = net.one97.paytm.vipcashback.d.a.g.f20800d
                if (r6 == 0) goto L_0x00cf
                java.lang.Object r3 = r6.get(r2)
                net.one97.paytm.common.entity.vipcashback.CashbackStageItem r3 = (net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r3
                goto L_0x00d0
            L_0x00cf:
                r3 = r0
            L_0x00d0:
                java.lang.String r4 = "stages?.get(0)"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                java.lang.String r3 = r3.getRedemptionStatus()
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0123
                net.one97.paytm.vipcashback.d.a$h$a r1 = net.one97.paytm.vipcashback.d.a.h.f20802a
                java.lang.String r1 = net.one97.paytm.vipcashback.d.a.h.f20805d
                if (r6 == 0) goto L_0x00ee
                java.lang.Object r3 = r6.get(r2)
                net.one97.paytm.common.entity.vipcashback.CashbackStageItem r3 = (net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r3
                goto L_0x00ef
            L_0x00ee:
                r3 = r0
            L_0x00ef:
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                java.lang.String r3 = r3.getRedemptionType()
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x0117
                net.one97.paytm.vipcashback.d.a$h$a r1 = net.one97.paytm.vipcashback.d.a.h.f20802a
                java.lang.String r1 = net.one97.paytm.vipcashback.d.a.h.f20806e
                if (r6 == 0) goto L_0x010a
                java.lang.Object r0 = r6.get(r2)
                net.one97.paytm.common.entity.vipcashback.CashbackStageItem r0 = (net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r0
            L_0x010a:
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                java.lang.String r0 = r0.getRedemptionType()
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x0123
            L_0x0117:
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r0 = r5.f20653a
                java.lang.Object r6 = r6.get(r2)
                net.one97.paytm.common.entity.vipcashback.CashbackStageItem r6 = (net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r6
                r0.a((net.one97.paytm.common.entity.vipcashback.CashbackStageItem) r6)
                return
            L_0x0123:
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                r6.onBackPressed()
                return
            L_0x0129:
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                r6.onBackPressed()
                return
            L_0x012f:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer"
                r6.<init>(r0)
                throw r6
            L_0x0137:
                java.util.ArrayList r0 = r6.getErrors()
                if (r0 == 0) goto L_0x0166
                java.util.ArrayList r0 = r6.getErrors()
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0166
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r0 = r5.f20653a
                net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
                java.util.ArrayList r6 = r6.getErrors()
                java.lang.Object r6 = r6.get(r2)
                java.lang.String r1 = "response.errors[0]"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal r6 = (net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r6
                com.paytm.network.model.NetworkCustomError r6 = net.one97.paytm.vipcashback.f.d.a.a((net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r6)
                r0.a((com.paytm.network.model.NetworkCustomError) r6)
                net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity r6 = r5.f20653a
                net.one97.paytm.common.widgets.a.b((com.airbnb.lottie.LottieAnimationView) r6.a(net.one97.paytm.vipcashback.R.id.loader))
            L_0x0166:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.activity.CashbackAdditionalOfferActivity.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "p2");
            this.f20653a.a(networkCustomError);
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20653a.a(R.id.loader));
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCopy;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.txtPromoCode;
            if (valueOf == null || valueOf.intValue() != i3) {
                return;
            }
        }
        d.a aVar = d.f20859a;
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtPromoCode);
        k.a((Object) roboTextView, "txtPromoCode");
        d.a.a((Context) this, new l("\\s").replace((CharSequence) roboTextView.getText().toString(), ""), true);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        if (valueOf != null && valueOf.intValue() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
