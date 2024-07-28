package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.SendOtpErrorModel;
import net.one97.paytm.common.entity.upgradeKyc.SendOtpMinorKycModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.l;

public final class KycParentConsentRequired extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private KycAadharEkycDetails.KycResponse f65334a;

    /* renamed from: b  reason: collision with root package name */
    private String f65335b;

    /* renamed from: d  reason: collision with root package name */
    private int f65336d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65337e;

    public final View a(int i2) {
        if (this.f65337e == null) {
            this.f65337e = new HashMap();
        }
        View view = (View) this.f65337e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65337e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.kyc_minor_parent_consent_required;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.kyc_minor_button_proceed) {
            if (this.f65336d == 3) {
                d();
                return;
            }
            TextInputEditText textInputEditText = (TextInputEditText) a(R.id.kyc_minor_enter_num_et);
            k.a((Object) textInputEditText, "kyc_minor_enter_num_et");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (!TextUtils.isEmpty(valueOf) && b.b(valueOf)) {
                this.f65336d++;
                d.a aVar = d.f66026a;
                String a2 = d.a.a() != null ? d.a("minorKycSendOtp") : null;
                if (URLUtil.isValidUrl(a2)) {
                    Context context = this;
                    String e2 = b.e(context, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.d.a(context));
                    String str = this.f65335b;
                    if (str == null) {
                        k.a();
                    }
                    hashMap.put("reference_number", str);
                    hashMap.put("action", "MINOR_KYC");
                    TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.kyc_minor_enter_num_et);
                    k.a((Object) textInputEditText2, "kyc_minor_enter_num_et");
                    String valueOf2 = String.valueOf(textInputEditText2.getText());
                    if (!TextUtils.isEmpty(valueOf2)) {
                        hashMap.put("mobileNo", valueOf2);
                    }
                    a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new SendOtpMinorKycModel((String) null, (String) null, (SendOtpErrorModel) null, (String) null, 15, (g) null)).b("").c(KycParentConsentRequired.class.getName()).a(e2).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new a(this)).l();
                    if (b.c(context)) {
                        b.k(context, getString(R.string.please_wait));
                        l.a();
                    } else {
                        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        k.a((Object) l, "ntwrkCall");
                        a.C1317a.a(context, l);
                    }
                } else {
                    b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
                }
            }
        }
        if (view != null && view.getId() == R.id.kyc_minor_know_more_tv) {
            Intent intent = new Intent(this, KnowMoreMinorKyc.class);
            intent.putExtra("aadhaarData", this.f65334a);
            startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        KycAadharEkycDetails.KycResponse kycResponse;
        String uid;
        super.onCreate(bundle);
        if (getIntent() != null) {
            if (getIntent().hasExtra("aadhaarData")) {
                this.f65334a = (KycAadharEkycDetails.KycResponse) getIntent().getSerializableExtra("aadhaarData");
            }
            if (getIntent().hasExtra("reference_number")) {
                this.f65335b = getIntent().getStringExtra("reference_number");
            }
        }
        KycAadharEkycDetails.KycResponse kycResponse2 = this.f65334a;
        String str = null;
        if (!TextUtils.isEmpty(kycResponse2 != null ? kycResponse2.getName() : null)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_name);
            k.a((Object) roboTextView, "tv_name");
            KycAadharEkycDetails.KycResponse kycResponse3 = this.f65334a;
            roboTextView.setText(kycResponse3 != null ? kycResponse3.getName() : null);
        }
        StringBuilder sb = new StringBuilder("");
        KycAadharEkycDetails.KycResponse kycResponse4 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse4 != null ? kycResponse4.getCo() : null)) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_co);
            k.a((Object) roboTextView2, "tv_co");
            roboTextView2.setVisibility(0);
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_co);
            k.a((Object) roboTextView3, "tv_co");
            KycAadharEkycDetails.KycResponse kycResponse5 = this.f65334a;
            roboTextView3.setText(kycResponse5 != null ? kycResponse5.getCo() : null);
        }
        KycAadharEkycDetails.KycResponse kycResponse6 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse6 != null ? kycResponse6.getHouse() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse7 = this.f65334a;
            sb.append(kycResponse7 != null ? kycResponse7.getHouse() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse8 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse8 != null ? kycResponse8.getLocation() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse9 = this.f65334a;
            sb.append(kycResponse9 != null ? kycResponse9.getLocation() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse10 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse10 != null ? kycResponse10.getStreet() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse11 = this.f65334a;
            sb.append(kycResponse11 != null ? kycResponse11.getStreet() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse12 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse12 != null ? kycResponse12.getLandMark() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse13 = this.f65334a;
            sb.append(kycResponse13 != null ? kycResponse13.getLandMark() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse14 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse14 != null ? kycResponse14.getDistrict() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse15 = this.f65334a;
            sb.append(kycResponse15 != null ? kycResponse15.getDistrict() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse16 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse16 != null ? kycResponse16.getPostOffice() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse17 = this.f65334a;
            sb.append(kycResponse17 != null ? kycResponse17.getPostOffice() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse18 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse18 != null ? kycResponse18.getState() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse19 = this.f65334a;
            sb.append(kycResponse19 != null ? kycResponse19.getState() : null);
            sb.append(",\n");
        }
        KycAadharEkycDetails.KycResponse kycResponse20 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse20 != null ? kycResponse20.getPostalCode() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse21 = this.f65334a;
            sb.append(kycResponse21 != null ? kycResponse21.getPostOffice() : null);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.tv_address);
            k.a((Object) roboTextView4, "tv_address");
            roboTextView4.setVisibility(0);
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.tv_address);
            k.a((Object) roboTextView5, "tv_address");
            roboTextView5.setText(sb);
        }
        KycAadharEkycDetails.KycResponse kycResponse22 = this.f65334a;
        if (!TextUtils.isEmpty(kycResponse22 != null ? kycResponse22.getUid() : null) && (kycResponse = this.f65334a) != null && (uid = kycResponse.getUid()) != null && uid.length() == 12) {
            KycAadharEkycDetails.KycResponse kycResponse23 = this.f65334a;
            if (kycResponse23 != null) {
                str = kycResponse23.getUid();
            }
            if (str == null) {
                k.a();
            }
            StringBuilder insert = new StringBuilder(str).insert(4, ' ');
            k.a((Object) insert, "sb.insert(4, ' ')");
            StringBuilder insert2 = insert.insert(9, ' ');
            k.a((Object) insert2, "sb.insert(9, ' ')");
            RoboTextView roboTextView6 = (RoboTextView) a(R.id.tv_aadhaar_num);
            k.a((Object) roboTextView6, "tv_aadhaar_num");
            roboTextView6.setText(insert2);
        }
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.kyc_minor_button_proceed)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.kyc_minor_know_more_tv)).setOnClickListener(onClickListener);
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycParentConsentRequired f65338a;

        a(KycParentConsentRequired kycParentConsentRequired) {
            this.f65338a = kycParentConsentRequired;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError != null) {
                l.a();
                l.a((Context) this.f65338a, networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            KycParentConsentRequired.a(this.f65338a, iJRPaytmDataModel);
        }
    }

    private final void d() {
        net.one97.paytm.upgradeKyc.d.b bVar = new net.one97.paytm.upgradeKyc.d.b();
        Bundle bundle = new Bundle();
        bundle.putInt("noOfAttempts", 3 - this.f65336d);
        bVar.setArguments(bundle);
        bVar.show(getSupportFragmentManager(), bVar.getTag());
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 122 && i3 == -1) {
            finish();
        }
    }

    public static final /* synthetic */ void a(KycParentConsentRequired kycParentConsentRequired, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof SendOtpMinorKycModel)) {
            b.p();
            SendOtpMinorKycModel sendOtpMinorKycModel = (SendOtpMinorKycModel) iJRPaytmDataModel;
            if (TextUtils.isEmpty(sendOtpMinorKycModel.getStatusCode()) || !p.a(sendOtpMinorKycModel.getStatusCode(), WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                if (sendOtpMinorKycModel.getError() != null && !TextUtils.isEmpty(sendOtpMinorKycModel.getError().getErrorCode())) {
                    String errorCode = sendOtpMinorKycModel.getError().getErrorCode();
                    if (p.a(errorCode, "7005", false) || p.a(errorCode, "7006", false)) {
                        kycParentConsentRequired.d();
                    } else {
                        b.b((Context) kycParentConsentRequired, kycParentConsentRequired.getString(R.string.error), sendOtpMinorKycModel.getError().getErrorMsg());
                    }
                }
            } else if (!TextUtils.isEmpty(sendOtpMinorKycModel.getRefNumber())) {
                kycParentConsentRequired.f65335b = sendOtpMinorKycModel.getRefNumber();
                Intent intent = new Intent(kycParentConsentRequired, KycVerifyOtpParentMobile.class);
                TextInputEditText textInputEditText = (TextInputEditText) kycParentConsentRequired.a(R.id.kyc_minor_enter_num_et);
                k.a((Object) textInputEditText, "kyc_minor_enter_num_et");
                intent.putExtra("parentMobileNumber", String.valueOf(textInputEditText.getText()));
                intent.putExtra("reference_number", kycParentConsentRequired.f65335b);
                intent.putExtra("aadhaarData", kycParentConsentRequired.f65334a);
                kycParentConsentRequired.startActivityForResult(intent, 122);
            }
        }
    }
}
