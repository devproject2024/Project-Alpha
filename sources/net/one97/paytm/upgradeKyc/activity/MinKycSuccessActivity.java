package net.one97.paytm.upgradeKyc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.j;

public final class MinKycSuccessActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private KYCDetail f65383a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65384b;

    public final View a(int i2) {
        if (this.f65384b == null) {
            this.f65384b = new HashMap();
        }
        View view = (View) this.f65384b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65384b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("/kyc/upgrade-benefits", "kyc_new", "signal");
        Intent intent = getIntent();
        Boolean bool = null;
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("kyc_additional_info") : null;
        if (!(serializableExtra instanceof KYCDetail)) {
            serializableExtra = null;
        }
        this.f65383a = (KYCDetail) serializableExtra;
        ((Button) a(R.id.min_kyc_success_upgrade_btn)).setOnClickListener(new a(this));
        ((ImageView) a(R.id.btn_back)).setOnClickListener(new b(this));
        e.a aVar = e.f66028b;
        CharSequence g2 = j.g(e.a.b().a());
        if (!TextUtils.isEmpty(g2)) {
            TextView textView = (TextView) a(R.id.kyc_expires_value_tv);
            k.a((Object) textView, "kyc_expires_value_tv");
            textView.setVisibility(0);
            TextView textView2 = (TextView) a(R.id.kyc_expires_value_tv);
            k.a((Object) textView2, "kyc_expires_value_tv");
            textView2.setText(g2);
            TextView textView3 = (TextView) a(R.id.kyc_expires_tv);
            k.a((Object) textView3, "kyc_expires_tv");
            textView3.setVisibility(0);
        }
        a(R.id.footer_layout).setOnClickListener(new c(this));
        TextView textView4 = (TextView) a(R.id.kyc_again_doubt_tv);
        k.a((Object) textView4, "kyc_again_doubt_tv");
        textView4.setText(getString(R.string.kyc_again_question));
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            bool = Boolean.valueOf(net.one97.paytm.upgradeKyc.helper.d.a("isOfferAvailableForCompletingKYC", false));
        }
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_offers);
            k.a((Object) relativeLayout, "ll_offers");
            net.one97.paytm.upgradeKyc.kycV3.b.b(relativeLayout);
            ((TextView) a(R.id.know_more)).setOnClickListener(new d(this));
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.ll_offers);
        k.a((Object) relativeLayout2, "ll_offers");
        net.one97.paytm.upgradeKyc.kycV3.b.a((View) relativeLayout2);
    }

    public final int a() {
        return R.layout.min_kyc_success_layout;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycSuccessActivity f65385a;

        a(MinKycSuccessActivity minKycSuccessActivity) {
            this.f65385a = minKycSuccessActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f65385a, "/kyc/upgrade-benefits", "upgrade_account_buton_clicked", (HashMap) null, (String) null, 12);
            MinKycSuccessActivity.a(this.f65385a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycSuccessActivity f65386a;

        b(MinKycSuccessActivity minKycSuccessActivity) {
            this.f65386a = minKycSuccessActivity;
        }

        public final void onClick(View view) {
            this.f65386a.finish();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycSuccessActivity f65387a;

        c(MinKycSuccessActivity minKycSuccessActivity) {
            this.f65387a = minKycSuccessActivity;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kycAgainLearnMoreUrl") : null;
            e.a aVar2 = e.f66028b;
            Intent intent = new Intent(this.f65387a, Class.forName(e.a.b().d()));
            intent.putExtra("url", a2);
            this.f65387a.startActivity(intent);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycSuccessActivity f65388a;

        d(MinKycSuccessActivity minKycSuccessActivity) {
            this.f65388a = minKycSuccessActivity;
        }

        public final void onClick(View view) {
            MinKycSuccessActivity.b(this.f65388a);
        }
    }

    public static final /* synthetic */ void a(MinKycSuccessActivity minKycSuccessActivity) {
        minKycSuccessActivity.startActivity(new Intent(minKycSuccessActivity, InPersonVerification.class));
        minKycSuccessActivity.finish();
    }

    public static final /* synthetic */ void b(MinKycSuccessActivity minKycSuccessActivity) {
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        Intent intent = null;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("offersForCompletingKYC") : null;
        try {
            e.a aVar2 = e.f66028b;
            intent = new Intent(minKycSuccessActivity, Class.forName(e.a.b().d()));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        if (intent != null) {
            intent.putExtra("url", a2);
            intent.putExtra("title", minKycSuccessActivity.getString(R.string.offers));
            minKycSuccessActivity.startActivity(intent);
        }
    }
}
