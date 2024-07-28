package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmoney.lite.mod.util.PMConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;

public final class WalletUpgradedSuccessActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, View> f65434a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65435b;

    public final View a(int i2) {
        if (this.f65435b == null) {
            this.f65435b = new HashMap();
        }
        View view = (View) this.f65435b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65435b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        e.a aVar = e.f66028b;
        Context context = this;
        e.a.b().a("/kyc-wallet-upgrade/aadhaar-otp/full-kyc-success", "kyc", context);
        d.a aVar2 = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar3 = d.f66026a;
            if (d.a.a() == null) {
                k.a();
            }
            str = d.a("kycFetchProfileInfoV2");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str) && !TextUtils.isEmpty(com.paytm.utility.d.a(context))) {
            String e2 = com.paytm.utility.b.e(context, str);
            StringBuilder sb = new StringBuilder();
            if (e2 == null) {
                k.a();
            }
            sb.append(e2);
            sb.append("&fields=profileStatus");
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(getApplicationContext());
            k.a((Object) a2, "CJRNetUtility.getSSOToken(this.applicationContext)");
            hashMap.put("session_token", a2);
            CJRAadharPanGet cJRAadharPanGet = new CJRAadharPanGet();
            a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) cJRAadharPanGet).a(sb.toString() + "&profileParams=MINKYC,FULLKYC,VERIFIEDAADHAR,VERIFIEDPAN").c(MinKycPanAadharUpgradeActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new a(this)).l();
            if (com.paytm.utility.b.c(getApplicationContext())) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
                l.a();
            }
        }
        ((TextView) a(R.id.tv_addpan)).setOnClickListener(new b(this));
    }

    public final int a() {
        return R.layout.activity_wallet_upgraded_success;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WalletUpgradedSuccessActivity f65437a;

        b(WalletUpgradedSuccessActivity walletUpgradedSuccessActivity) {
            this.f65437a = walletUpgradedSuccessActivity;
        }

        public final void onClick(View view) {
            WalletUpgradedSuccessActivity.a(this.f65437a);
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WalletUpgradedSuccessActivity f65436a;

        a(WalletUpgradedSuccessActivity walletUpgradedSuccessActivity) {
            this.f65436a = walletUpgradedSuccessActivity;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65436a.a(R.id.wallet_loader));
            WalletUpgradedSuccessActivity.a(this.f65436a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            l.a();
            if (!l.a((Context) this.f65436a, networkCustomError)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65436a.a(R.id.wallet_loader));
            }
        }
    }

    public static final /* synthetic */ void a(WalletUpgradedSuccessActivity walletUpgradedSuccessActivity) {
        walletUpgradedSuccessActivity.startActivity(new Intent(walletUpgradedSuccessActivity, PanUpdateActivity.class));
        walletUpgradedSuccessActivity.finish();
    }

    public static final /* synthetic */ void a(WalletUpgradedSuccessActivity walletUpgradedSuccessActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z;
        if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            TextView textView = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_name);
            k.a((Object) textView, "tv_name");
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
            textView.setText(cJRAadharPanGet.getName());
            String gender = cJRAadharPanGet.getGender();
            if (!TextUtils.isEmpty(gender)) {
                if (k.a((Object) gender, (Object) "M")) {
                    TextView textView2 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_gender_details);
                    k.a((Object) textView2, "tv_gender_details");
                    textView2.setText(walletUpgradedSuccessActivity.getString(R.string.male));
                } else if (k.a((Object) gender, (Object) AppConstants.FEED_SUB_TYPE)) {
                    TextView textView3 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_gender_details);
                    k.a((Object) textView3, "tv_gender_details");
                    textView3.setText(walletUpgradedSuccessActivity.getString(R.string.female));
                } else {
                    TextView textView4 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_gender_details);
                    k.a((Object) textView4, "tv_gender_details");
                    textView4.setText(walletUpgradedSuccessActivity.getString(R.string.na));
                }
            }
            TextView textView5 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_dob);
            k.a((Object) textView5, "tv_dob");
            textView5.setText(cJRAadharPanGet.getDob());
            int i2 = 0;
            if (cJRAadharPanGet.getDocuments() != null) {
                Iterator<CJRAadharPanDocList> it2 = cJRAadharPanGet.getDocuments().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRAadharPanDocList next = it2.next();
                    k.a((Object) next, PMConstants.UploadTypes.DOC);
                    if (k.a((Object) next.getDocCode(), (Object) "pan")) {
                        z = true;
                        TextView textView6 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_pan_details);
                        k.a((Object) textView6, "tv_pan_details");
                        textView6.setText(next.getDocValue());
                        if (k.a((Object) next.getEditableAction(), (Object) "NON_EDITABLE_TICKED")) {
                            ((TextView) walletUpgradedSuccessActivity.a(R.id.tv_pan_details)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_kyc_badge, 0);
                        } else if (k.a((Object) next.getEditableAction(), (Object) "NON_EDITABLE_WAITING")) {
                            ((TextView) walletUpgradedSuccessActivity.a(R.id.tv_pan_details)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pending_copy, 0);
                        }
                    }
                }
            }
            z = false;
            TextView textView7 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_pan);
            k.a((Object) textView7, "tv_pan");
            textView7.setVisibility(z ? 0 : 8);
            TextView textView8 = (TextView) walletUpgradedSuccessActivity.a(R.id.tv_pan_details);
            k.a((Object) textView8, "tv_pan_details");
            textView8.setVisibility(z ? 0 : 8);
            LinearLayout linearLayout = (LinearLayout) walletUpgradedSuccessActivity.a(R.id.addPanStripe);
            if (linearLayout == null) {
                k.a();
            }
            if (z) {
                i2 = 8;
            }
            linearLayout.setVisibility(i2);
            View a2 = walletUpgradedSuccessActivity.a(R.id.lyt_kyc_details);
            k.a((Object) a2, "lyt_kyc_details");
            net.one97.paytm.upgradeKyc.kycV3.b.b(a2);
            View a3 = walletUpgradedSuccessActivity.a(R.id.top_separator);
            k.a((Object) a3, "top_separator");
            net.one97.paytm.upgradeKyc.kycV3.b.b(a3);
        }
    }
}
