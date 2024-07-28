package net.one97.paytm.upgradeKyc.aotp.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.u;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.activity.VerifyDocActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.videokyc.activity.AddPanVideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import org.json.JSONObject;

public final class EnterAadhaarDetailsActivity extends UpgradeKycBaseActivity implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.aotp.b.a f65474a;

    /* renamed from: b  reason: collision with root package name */
    boolean f65475b;

    /* renamed from: d  reason: collision with root package name */
    List<TncData> f65476d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    boolean f65477e = true;

    /* renamed from: f  reason: collision with root package name */
    final String f65478f = "1600039";

    /* renamed from: g  reason: collision with root package name */
    final String f65479g = "1000007";

    /* renamed from: h  reason: collision with root package name */
    public String f65480h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f65481i;
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> j = new b(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> k = new q(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> l = new p(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> m = new h(this);
    /* access modifiers changed from: private */
    public KycAadharEkycDetails.KycResponse n;
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> o = new c(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> p = new a(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> q = new i(this);
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65482a;

        a(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65482a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65529f[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65482a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65482a;
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            kotlin.g.b.k.a();
                        }
                        EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity, (KycCheckDoc) resulttype);
                        return;
                    }
                    EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65482a;
                    String string = enterAadhaarDetailsActivity2.getString(R.string.some_went_wrong);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                    enterAadhaarDetailsActivity2.a(string);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65482a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65482a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65482a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity3 = this.f65482a;
                        String string2 = enterAadhaarDetailsActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity3.a(string2);
                    }
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycSavedUserData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65483a;

        b(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65483a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            List<KYCDetail> kYCDetail;
            KYCDetail kYCDetail2;
            List<KYCDetail> kYCDetail3;
            KYCDetail kYCDetail4;
            List<KYCDetail> kYCDetail5;
            KYCDetail kYCDetail6;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65524a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65483a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        KycSavedUserData kycSavedUserData = (KycSavedUserData) bVar.f66169b;
                        Integer statusCode = kycSavedUserData != null ? kycSavedUserData.getStatusCode() : null;
                        if (statusCode != null && statusCode.intValue() == 200) {
                            KycSavedUserData kycSavedUserData2 = (KycSavedUserData) bVar.f66169b;
                            if (kycSavedUserData2 == null || (kYCDetail3 = kycSavedUserData2.getKYCDetail()) == null || (kYCDetail4 = kYCDetail3.get(0)) == null || !Integer.valueOf(kYCDetail4.getAction()).equals(4)) {
                                KycSavedUserData kycSavedUserData3 = (KycSavedUserData) bVar.f66169b;
                                if (kycSavedUserData3 == null || (kYCDetail = kycSavedUserData3.getKYCDetail()) == null || (kYCDetail2 = kYCDetail.get(0)) == null || !Integer.valueOf(kYCDetail2.getAction()).equals(6)) {
                                    EnterAadhaarDetailsActivity.a(this.f65483a, true);
                                } else {
                                    EnterAadhaarDetailsActivity.c(this.f65483a);
                                }
                                EnterAadhaarDetailsActivity.d(this.f65483a);
                            }
                            EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65483a;
                            KycSavedUserData kycSavedUserData4 = (KycSavedUserData) bVar.f66169b;
                            if (!(kycSavedUserData4 == null || (kYCDetail5 = kycSavedUserData4.getKYCDetail()) == null || (kYCDetail6 = kYCDetail5.get(0)) == null)) {
                                str = kYCDetail6.getUuid();
                            }
                            enterAadhaarDetailsActivity.a(str, (KycAadharEkycDetails.KycResponse) null);
                            EnterAadhaarDetailsActivity.d(this.f65483a);
                        }
                    }
                    EnterAadhaarDetailsActivity.a(this.f65483a, true);
                    EnterAadhaarDetailsActivity.d(this.f65483a);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65483a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity.a(this.f65483a, false);
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65483a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        EnterAadhaarDetailsActivity.a(this.f65483a, true);
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65483a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65483a;
                        String string = enterAadhaarDetailsActivity2.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity2.a(string);
                        EnterAadhaarDetailsActivity.d(this.f65483a);
                    }
                }
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65484a;

        c(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65484a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            KycAadharGenOTP kycAadharGenOTP;
            String errorCode;
            String errorCode2;
            String errorErrorCode;
            String subErrorCode;
            String subErrorCode2;
            String subErrorCode3;
            String statusCode;
            KycAadharGenOTP kycAadharGenOTP2;
            KycAadharGenOTP kycAadharGenOTP3;
            String statusMessage;
            KycAadharGenOTP kycAadharGenOTP4;
            String statusCode2;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65528e[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65484a.a(R.id.wallet_loader));
                    KycAadharGenOTP kycAadharGenOTP5 = (KycAadharGenOTP) bVar.f66169b;
                    if (kycAadharGenOTP5 == null || (statusMessage = kycAadharGenOTP5.getStatusMessage()) == null || !kotlin.m.p.a(statusMessage, "success", true) || (kycAadharGenOTP4 = (KycAadharGenOTP) bVar.f66169b) == null || (statusCode2 = kycAadharGenOTP4.getStatusCode()) == null || !statusCode2.equals("00")) {
                        KycAadharGenOTP kycAadharGenOTP6 = (KycAadharGenOTP) bVar.f66169b;
                        if (kycAadharGenOTP6 == null || (statusCode = kycAadharGenOTP6.getStatusCode()) == null || !statusCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            KycAadharGenOTP kycAadharGenOTP7 = (KycAadharGenOTP) bVar.f66169b;
                            if (kycAadharGenOTP7 == null || (errorErrorCode = kycAadharGenOTP7.getErrorErrorCode()) == null || !errorErrorCode.equals("500")) {
                                KycAadharGenOTP kycAadharGenOTP8 = (KycAadharGenOTP) bVar.f66169b;
                                if ((kycAadharGenOTP8 == null || (errorCode2 = kycAadharGenOTP8.getErrorCode()) == null || !errorCode2.equals("200")) && ((kycAadharGenOTP = (KycAadharGenOTP) bVar.f66169b) == null || (errorCode = kycAadharGenOTP.getErrorCode()) == null || !errorCode.equals("201"))) {
                                    KycAadharGenOTP kycAadharGenOTP9 = (KycAadharGenOTP) bVar.f66169b;
                                    if (!TextUtils.isEmpty(kycAadharGenOTP9 != null ? kycAadharGenOTP9.getErrorErrorMessage() : null)) {
                                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65484a;
                                        KycAadharGenOTP kycAadharGenOTP10 = (KycAadharGenOTP) bVar.f66169b;
                                        if (kycAadharGenOTP10 != null) {
                                            str = kycAadharGenOTP10.getErrorErrorMessage();
                                        }
                                        if (str == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity, str);
                                        return;
                                    }
                                    KycAadharGenOTP kycAadharGenOTP11 = (KycAadharGenOTP) bVar.f66169b;
                                    if (!TextUtils.isEmpty(kycAadharGenOTP11 != null ? kycAadharGenOTP11.getErrorMessage() : null)) {
                                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65484a;
                                        KycAadharGenOTP kycAadharGenOTP12 = (KycAadharGenOTP) bVar.f66169b;
                                        if (kycAadharGenOTP12 != null) {
                                            str = kycAadharGenOTP12.getErrorMessage();
                                        }
                                        if (str == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity2, str);
                                        return;
                                    }
                                    EnterAadhaarDetailsActivity enterAadhaarDetailsActivity3 = this.f65484a;
                                    String string = enterAadhaarDetailsActivity3.getString(R.string.otp_uidai_fail);
                                    kotlin.g.b.k.a((Object) string, "getString(R.string.otp_uidai_fail)");
                                    EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity3, false, string, false, 5);
                                    return;
                                }
                                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65484a.a(R.id.wallet_loader));
                                EnterAadhaarDetailsActivity enterAadhaarDetailsActivity4 = this.f65484a;
                                String string2 = enterAadhaarDetailsActivity4.getString(R.string.otp_uidai_fail_error);
                                kotlin.g.b.k.a((Object) string2, "getString(R.string.otp_uidai_fail_error)");
                                EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity4, false, string2, false, 5);
                                return;
                            }
                            KycAadharGenOTP kycAadharGenOTP13 = (KycAadharGenOTP) bVar.f66169b;
                            if (kycAadharGenOTP13 == null || (subErrorCode3 = kycAadharGenOTP13.getSubErrorCode()) == null || !subErrorCode3.equals("112")) {
                                KycAadharGenOTP kycAadharGenOTP14 = (KycAadharGenOTP) bVar.f66169b;
                                if (kycAadharGenOTP14 == null || (subErrorCode2 = kycAadharGenOTP14.getSubErrorCode()) == null || !subErrorCode2.equals("952")) {
                                    KycAadharGenOTP kycAadharGenOTP15 = (KycAadharGenOTP) bVar.f66169b;
                                    if (kycAadharGenOTP15 == null || (subErrorCode = kycAadharGenOTP15.getSubErrorCode()) == null || !subErrorCode.equals("UID005")) {
                                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity5 = this.f65484a;
                                        String string3 = enterAadhaarDetailsActivity5.getString(R.string.some_went_wrong);
                                        kotlin.g.b.k.a((Object) string3, "getString(R.string.some_went_wrong)");
                                        EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity5, string3);
                                        return;
                                    }
                                    EnterAadhaarDetailsActivity enterAadhaarDetailsActivity6 = this.f65484a;
                                    String string4 = enterAadhaarDetailsActivity6.getString(R.string.kyc_uidai_failure);
                                    kotlin.g.b.k.a((Object) string4, "getString(R.string.kyc_uidai_failure)");
                                    EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity6, string4);
                                    return;
                                }
                                EnterAadhaarDetailsActivity enterAadhaarDetailsActivity7 = this.f65484a;
                                String string5 = enterAadhaarDetailsActivity7.getString(R.string.kyc_uidai_failure);
                                kotlin.g.b.k.a((Object) string5, "getString(R.string.kyc_uidai_failure)");
                                EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity7, string5);
                                return;
                            }
                            EnterAadhaarDetailsActivity enterAadhaarDetailsActivity8 = this.f65484a;
                            String string6 = enterAadhaarDetailsActivity8.getString(R.string.otp_uidai_fail_error);
                            kotlin.g.b.k.a((Object) string6, "getString(R.string.otp_uidai_fail_error)");
                            EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity8, false, string6, true, 1);
                            return;
                        }
                        if (!TextUtils.isEmpty((bVar == null || (kycAadharGenOTP3 = (KycAadharGenOTP) bVar.f66169b) == null) ? null : kycAadharGenOTP3.getReferenceNumber())) {
                            EnterAadhaarDetailsActivity enterAadhaarDetailsActivity9 = this.f65484a;
                            KycAadharGenOTP kycAadharGenOTP16 = (KycAadharGenOTP) bVar.f66169b;
                            String referenceNumber = kycAadharGenOTP16 != null ? kycAadharGenOTP16.getReferenceNumber() : null;
                            if (referenceNumber == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.c(referenceNumber, "<set-?>");
                            enterAadhaarDetailsActivity9.f65480h = referenceNumber;
                        }
                        if (!(bVar == null || (kycAadharGenOTP2 = (KycAadharGenOTP) bVar.f66169b) == null)) {
                            str = kycAadharGenOTP2.getData();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            new KycAadharEkycDetails();
                            JSONObject jSONObject2 = jSONObject.getJSONObject("ekyc_json");
                            KycAadharEkycDetails.KycResponse kycResponse = new KycAadharEkycDetails.KycResponse();
                            kycResponse.setName(jSONObject2.optString("name"));
                            kycResponse.setCo(jSONObject2.optString("care_of"));
                            kycResponse.setDob(jSONObject2.optString("date_of_birth"));
                            kycResponse.setDistrict(jSONObject2.optString("district"));
                            kycResponse.setGender(jSONObject2.optString("gender"));
                            kycResponse.setHouse(jSONObject2.optString("house"));
                            kycResponse.setLandMark(jSONObject2.optString(AddEditGstinViewModelKt.BODY_PARAM_LANDMARK));
                            kycResponse.setPostalCode(jSONObject2.optString("postal_code"));
                            kycResponse.setState(jSONObject2.optString("state"));
                            kycResponse.setStreet(jSONObject2.optString("street"));
                            kycResponse.setVtc(jSONObject2.optString("vtc"));
                            kycResponse.setPhoto(jSONObject2.optString("photo"));
                            kycResponse.setUid(jSONObject2.optString("uid"));
                            TextInputEditText textInputEditText = (TextInputEditText) this.f65484a.a(R.id.aadhaar_no_tv);
                            kotlin.g.b.k.a((Object) textInputEditText, "aadhaar_no_tv");
                            Editable text = textInputEditText.getText();
                            if (text == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) text, "aadhaar_no_tv.text!!");
                            String replace = new kotlin.m.l("-").replace((CharSequence) text, "");
                            this.f65484a.n = kycResponse;
                            if (this.f65484a.n != null) {
                                net.one97.paytm.upgradeKyc.aotp.b.a d2 = this.f65484a.d();
                                String e2 = this.f65484a.e();
                                kotlin.g.b.k.c(replace, "userAdhar");
                                kotlin.g.b.k.c(e2, "eKycRef");
                                d2.f65540f = replace;
                                d2.p = e2;
                                d2.m.setValue(replace);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    KycAadharGenOTP kycAadharGenOTP17 = (KycAadharGenOTP) bVar.f66169b;
                    if (!TextUtils.isEmpty(kycAadharGenOTP17 != null ? kycAadharGenOTP17.getReferenceNumber() : null)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65484a.a(R.id.wallet_loader));
                        Intent intent = new Intent(this.f65484a, EnterAadhaarOtpActivity.class);
                        KycAadharGenOTP kycAadharGenOTP18 = (KycAadharGenOTP) bVar.f66169b;
                        if (kycAadharGenOTP18 != null) {
                            str = kycAadharGenOTP18.getReferenceNumber();
                        }
                        intent.putExtra("reference_number", str);
                        TextInputEditText textInputEditText2 = (TextInputEditText) this.f65484a.a(R.id.aadhaar_no_tv);
                        kotlin.g.b.k.a((Object) textInputEditText2, "aadhaar_no_tv");
                        Editable text2 = textInputEditText2.getText();
                        if (text2 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) text2, "aadhaar_no_tv.text!!");
                        intent.putExtra("aadhaar", new kotlin.m.l("-").replace((CharSequence) text2, ""));
                        intent.putExtra("isVideoKYCFlow", this.f65484a.f65481i);
                        this.f65484a.startActivity(intent);
                        this.f65484a.finish();
                    }
                } else if (i2 == 2 && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65484a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65484a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity10 = this.f65484a;
                        String string7 = enterAadhaarDetailsActivity10.getString(R.string.otp_uidai_fail);
                        kotlin.g.b.k.a((Object) string7, "getString(R.string.otp_uidai_fail)");
                        EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity10, false, string7, false, 5);
                    }
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<CJRAadharPanSave>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65489a;

        h(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65489a = enterAadhaarDetailsActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v4, types: [java.util.List] */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r10) {
            /*
                r9 = this;
                net.one97.paytm.upgradeKyc.kycV3.b.b r10 = (net.one97.paytm.upgradeKyc.kycV3.b.b) r10
                r0 = 0
                if (r10 == 0) goto L_0x0008
                net.one97.paytm.upgradeKyc.kycV3.b.d r1 = r10.f66168a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.upgradeKyc.aotp.activity.a.f65527d
                int r1 = r1.ordinal()
                r1 = r2[r1]
                java.lang.String r2 = "getString(R.string.some_went_wrong)"
                r3 = 1
                if (r1 == r3) goto L_0x0051
                r0 = 2
                if (r1 == r0) goto L_0x001d
                goto L_0x0050
            L_0x001d:
                com.paytm.network.model.NetworkCustomError r0 = r10.f66170c
                if (r0 == 0) goto L_0x0050
                net.one97.paytm.upgradeKyc.utils.l.a()
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r0 = r9.f65489a
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.network.model.NetworkCustomError r10 = r10.f66170c
                if (r10 != 0) goto L_0x002f
                kotlin.g.b.k.a()
            L_0x002f:
                boolean r10 = net.one97.paytm.upgradeKyc.utils.l.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r10)
                if (r10 != 0) goto L_0x0050
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r10 = r10.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r10 = (com.airbnb.lottie.LottieAnimationView) r10
                net.one97.paytm.common.widgets.a.b(r10)
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r0 = r10.getString(r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r10.a((java.lang.String) r0)
            L_0x0050:
                return
            L_0x0051:
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x005c
                java.lang.String r1 = r1.getErrorErrorMessage()
                goto L_0x005d
            L_0x005c:
                r1 = r0
            L_0x005d:
                java.lang.String r4 = ""
                java.lang.String r5 = "-"
                java.lang.String r6 = "aadhaar_no_tv.text!!"
                java.lang.String r7 = "aadhaar_no_tv"
                if (r1 == 0) goto L_0x0155
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x0072
                java.lang.String r1 = r1.getErrorErrorCode()
                goto L_0x0073
            L_0x0072:
                r1 = r0
            L_0x0073:
                java.lang.String r8 = "4009"
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r8)
                if (r1 == 0) goto L_0x00da
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r1 = r9.f65489a
                int r2 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r1 = r1.a((int) r2)
                com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
                net.one97.paytm.common.widgets.a.b(r1)
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x0093
                java.lang.String r1 = r1.getErrorErrorMessage()
                goto L_0x0094
            L_0x0093:
                r1 = r0
            L_0x0094:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00b1
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r1 = r9.f65489a
                ResultType r10 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r10 = (net.one97.paytm.common.entity.CJRAadharPanSave) r10
                if (r10 == 0) goto L_0x00a8
                java.lang.String r0 = r10.getErrorErrorMessage()
            L_0x00a8:
                if (r0 != 0) goto L_0x00ad
                kotlin.g.b.k.a()
            L_0x00ad:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity.c(r1, r0)
                return
            L_0x00b1:
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00bc
                java.lang.String r1 = r1.getErrorMessage()
                goto L_0x00bd
            L_0x00bc:
                r1 = r0
            L_0x00bd:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00d9
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r1 = r9.f65489a
                ResultType r10 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r10 = (net.one97.paytm.common.entity.CJRAadharPanSave) r10
                if (r10 == 0) goto L_0x00d1
                java.lang.String r0 = r10.getErrorMessage()
            L_0x00d1:
                if (r0 != 0) goto L_0x00d6
                kotlin.g.b.k.a()
            L_0x00d6:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity.c(r1, r0)
            L_0x00d9:
                return
            L_0x00da:
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x00e5
                java.lang.String r1 = r1.getErrorErrorCode()
                goto L_0x00e6
            L_0x00e5:
                r1 = r0
            L_0x00e6:
                java.lang.String r8 = "9561"
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r8)
                if (r1 != 0) goto L_0x011d
                ResultType r10 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r10 = (net.one97.paytm.common.entity.CJRAadharPanSave) r10
                if (r10 == 0) goto L_0x00f8
                java.lang.String r0 = r10.getErrorErrorCode()
            L_0x00f8:
                java.lang.String r10 = "9562"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r10)
                if (r10 == 0) goto L_0x0101
                goto L_0x011d
            L_0x0101:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r10 = r10.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r10 = (com.airbnb.lottie.LottieAnimationView) r10
                net.one97.paytm.common.widgets.a.b(r10)
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r0 = r10.getString(r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r10.a((java.lang.String) r0)
                return
            L_0x011d:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                r10.f65477e = r3
                net.one97.paytm.upgradeKyc.aotp.b.a r10 = r10.d()
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r0 = r9.f65489a
                boolean r0 = r0.f65475b
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r1 = r9.f65489a
                int r2 = net.one97.paytm.upgradeKyc.R.id.aadhaar_no_tv
                android.view.View r1 = r1.a((int) r2)
                com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
                android.text.Editable r1 = r1.getText()
                if (r1 != 0) goto L_0x013f
                kotlin.g.b.k.a()
            L_0x013f:
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                kotlin.m.l r2 = new kotlin.m.l
                r2.<init>((java.lang.String) r5)
                java.lang.String r1 = r2.replace((java.lang.CharSequence) r1, (java.lang.String) r4)
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r2 = r9.f65489a
                boolean r2 = r2.f65477e
                r10.a(r0, r1, r2)
                return
            L_0x0155:
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x0160
                java.util.List r1 = r1.getDocuments()
                goto L_0x0161
            L_0x0160:
                r1 = r0
            L_0x0161:
                if (r1 == 0) goto L_0x01fe
                ResultType r1 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r1 = (net.one97.paytm.common.entity.CJRAadharPanSave) r1
                if (r1 == 0) goto L_0x01fe
                java.util.List r1 = r1.getDocuments()
                if (r1 == 0) goto L_0x01fe
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r3
                if (r1 != r3) goto L_0x01fe
                ResultType r10 = r10.f66169b
                net.one97.paytm.common.entity.CJRAadharPanSave r10 = (net.one97.paytm.common.entity.CJRAadharPanSave) r10
                if (r10 == 0) goto L_0x0182
                java.util.List r0 = r10.getDocuments()
            L_0x0182:
                if (r0 != 0) goto L_0x0187
                kotlin.g.b.k.a()
            L_0x0187:
                java.util.Iterator r10 = r0.iterator()
            L_0x018b:
                boolean r0 = r10.hasNext()
                if (r0 == 0) goto L_0x01c8
                java.lang.Object r0 = r10.next()
                net.one97.paytm.common.entity.CJRAadharPanDocList r0 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r0
                if (r0 == 0) goto L_0x018b
                java.lang.String r1 = r0.getDocCode()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x018b
                java.lang.String r1 = r0.getDocCode()
                java.lang.String r2 = "aadhar"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
                if (r1 == 0) goto L_0x018b
                java.lang.String r1 = r0.getDocValue()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x018b
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                android.content.Context r10 = (android.content.Context) r10
                java.lang.String r0 = r0.getDocValue()
                net.one97.paytm.upgradeKyc.utils.j.a((android.content.Context) r10, (java.lang.String) r0)
            L_0x01c8:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                net.one97.paytm.upgradeKyc.aotp.b.a r10 = r10.d()
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r0 = r9.f65489a
                boolean r0 = r0.f65475b
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r1 = r9.f65489a
                int r2 = net.one97.paytm.upgradeKyc.R.id.aadhaar_no_tv
                android.view.View r1 = r1.a((int) r2)
                com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
                android.text.Editable r1 = r1.getText()
                if (r1 != 0) goto L_0x01e8
                kotlin.g.b.k.a()
            L_0x01e8:
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                kotlin.m.l r2 = new kotlin.m.l
                r2.<init>((java.lang.String) r5)
                java.lang.String r1 = r2.replace((java.lang.CharSequence) r1, (java.lang.String) r4)
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r2 = r9.f65489a
                boolean r2 = r2.f65477e
                r10.a(r0, r1, r2)
                return
            L_0x01fe:
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r10 = r10.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r10 = (com.airbnb.lottie.LottieAnimationView) r10
                net.one97.paytm.common.widgets.a.b(r10)
                net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity r10 = r9.f65489a
                int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
                java.lang.String r0 = r10.getString(r0)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r10.a((java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity.h.onChanged(java.lang.Object):void");
        }
    }

    static final class i<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65490a;

        i(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65490a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            EkycDataResponse ekycDataResponse;
            String errorCode;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65530g[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65490a.a(R.id.wallet_loader));
                    EkycDataResponse ekycDataResponse2 = (EkycDataResponse) bVar.f66169b;
                    if (ekycDataResponse2 != null && ekycDataResponse2.getStatusCode() == 200) {
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65490a;
                        enterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity.e(), this.f65490a.n);
                    } else if (bVar == null || (ekycDataResponse = (EkycDataResponse) bVar.f66169b) == null || (errorCode = ekycDataResponse.getErrorCode()) == null || !errorCode.equals("409")) {
                        EkycDataResponse ekycDataResponse3 = (EkycDataResponse) bVar.f66169b;
                        if (!TextUtils.isEmpty(ekycDataResponse3 != null ? ekycDataResponse3.getMessage() : null)) {
                            EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65490a;
                            EkycDataResponse ekycDataResponse4 = (EkycDataResponse) bVar.f66169b;
                            if (ekycDataResponse4 != null) {
                                str = ekycDataResponse4.getMessage();
                            }
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            enterAadhaarDetailsActivity2.a(str);
                            return;
                        }
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity3 = this.f65490a;
                        String string = enterAadhaarDetailsActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity3.a(string);
                    } else {
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity4 = this.f65490a;
                        enterAadhaarDetailsActivity4.a(enterAadhaarDetailsActivity4.e(), this.f65490a.n);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65490a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65490a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65490a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity5 = this.f65490a;
                        String string2 = enterAadhaarDetailsActivity5.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity5.a(string2);
                    }
                }
            }
        }
    }

    static final class p<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65497a;

        p(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65497a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65526c[dVar.ordinal()];
                if (i2 == 1) {
                    KYCTncAccept kYCTncAccept = (KYCTncAccept) bVar.f66169b;
                    if (kotlin.m.p.a(kYCTncAccept != null ? kYCTncAccept.getStatus() : null, "success", true)) {
                        KYCTncAccept kYCTncAccept2 = (KYCTncAccept) bVar.f66169b;
                        if (kotlin.g.b.k.a((Object) kYCTncAccept2 != null ? kYCTncAccept2.getResponseCode() : null, (Object) "2004")) {
                            net.one97.paytm.upgradeKyc.aotp.b.a d2 = this.f65497a.d();
                            TextInputEditText textInputEditText = (TextInputEditText) this.f65497a.a(R.id.aadhaar_name_tv);
                            kotlin.g.b.k.a((Object) textInputEditText, "aadhaar_name_tv");
                            String valueOf = String.valueOf(textInputEditText.getText());
                            TextInputEditText textInputEditText2 = (TextInputEditText) this.f65497a.a(R.id.aadhaar_no_tv);
                            kotlin.g.b.k.a((Object) textInputEditText2, "aadhaar_no_tv");
                            Editable text = textInputEditText2.getText();
                            if (text == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) text, "aadhaar_no_tv.text!!");
                            String replace = new kotlin.m.l("-").replace((CharSequence) text, "");
                            kotlin.g.b.k.c("aadhar", "docCode");
                            kotlin.g.b.k.c(valueOf, "adharName");
                            kotlin.g.b.k.c(replace, "adharNum");
                            d2.f65540f = "aadhar";
                            d2.f65541g = valueOf;
                            d2.f65539e.setValue(replace);
                            return;
                        }
                    }
                    KYCTncAccept kYCTncAccept3 = (KYCTncAccept) bVar.f66169b;
                    if (kotlin.m.p.a(kYCTncAccept3 != null ? kYCTncAccept3.getStatus() : null, "error", false)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65497a.a(R.id.wallet_loader));
                        KYCTncAccept kYCTncAccept4 = (KYCTncAccept) bVar.f66169b;
                        if (!TextUtils.isEmpty(kYCTncAccept4 != null ? kYCTncAccept4.getMessage() : null)) {
                            EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65497a;
                            KYCTncAccept kYCTncAccept5 = (KYCTncAccept) bVar.f66169b;
                            if (kYCTncAccept5 != null) {
                                str = kYCTncAccept5.getMessage();
                            }
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            EnterAadhaarDetailsActivity.c(enterAadhaarDetailsActivity, str);
                            return;
                        }
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65497a;
                        String string = enterAadhaarDetailsActivity2.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity2.a(string);
                    }
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65497a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65497a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65497a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity3 = this.f65497a;
                        String string2 = enterAadhaarDetailsActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity3.a(string2);
                    }
                }
            }
        }
    }

    static final class q<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65498a;

        q(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65498a = enterAadhaarDetailsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            ArrayList<TncData> tncDataList;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            ArrayList<TncData> arrayList = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = a.f65525b[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65498a.a(R.id.wallet_loader));
                    KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) bVar.f66169b;
                    if (kYCFetchTnc != null && (tncDataList = kYCFetchTnc.getTncDataList()) != null && (!tncDataList.isEmpty())) {
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity = this.f65498a;
                        KYCFetchTnc kYCFetchTnc2 = (KYCFetchTnc) bVar.f66169b;
                        if (kYCFetchTnc2 != null) {
                            arrayList = kYCFetchTnc2.getTncDataList();
                        }
                        if (arrayList == null) {
                            kotlin.g.b.k.a();
                        }
                        List<TncData> list = arrayList;
                        kotlin.g.b.k.c(list, "<set-?>");
                        enterAadhaarDetailsActivity.f65476d = list;
                        aa aaVar = aa.f47921a;
                        String string = this.f65498a.getString(R.string.kyc_i_agree_to_the);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.kyc_i_agree_to_the)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + this.f65498a.getString(R.string.terms_amp_conditions) + "</a> "}, 1));
                        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity2 = this.f65498a;
                        CheckBox checkBox = (CheckBox) enterAadhaarDetailsActivity2.a(R.id.aadhaar_tnc_cb);
                        kotlin.g.b.k.a((Object) checkBox, "aadhaar_tnc_cb");
                        EnterAadhaarDetailsActivity.a(enterAadhaarDetailsActivity2, (TextView) checkBox, format);
                    }
                } else if (i2 == 2 && bVar.f66170c != null) {
                    net.one97.paytm.upgradeKyc.utils.l.a();
                    Context context = this.f65498a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!net.one97.paytm.upgradeKyc.utils.l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65498a.a(R.id.wallet_loader));
                        EnterAadhaarDetailsActivity enterAadhaarDetailsActivity3 = this.f65498a;
                        String string2 = enterAadhaarDetailsActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarDetailsActivity3.a(string2);
                    }
                }
            }
        }
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.enter_aadhaar_details_lyt;
    }

    public final net.one97.paytm.upgradeKyc.aotp.b.a d() {
        net.one97.paytm.upgradeKyc.aotp.b.a aVar = this.f65474a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public final String e() {
        String str = this.f65480h;
        if (str == null) {
            kotlin.g.b.k.a("mRefNumber");
        }
        return str;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("/kyc/adhaar-screen", "kyc_new", "signal");
        if (getIntent() != null && getIntent().hasExtra("isVideoKYCFlow")) {
            this.f65481i = getIntent().getBooleanExtra("isVideoKYCFlow", false);
        }
        a(R.id.dont_have_adhar_view).setOnClickListener(new j(this));
        ((Button) a(R.id.proceed_btn)).setOnClickListener(new k(this));
        ((TextInputEditText) a(R.id.aadhaar_no_tv)).addTextChangedListener(new l());
        ((CheckBox) a(R.id.aadhaar_tnc_cb)).setOnCheckedChangeListener(new m(this));
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.aadhaar_no_tv);
        kotlin.g.b.k.a((Object) textInputEditText, "aadhaar_no_tv");
        View.OnFocusChangeListener onFocusChangeListener = this;
        textInputEditText.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.aadhaar_name_tv);
        kotlin.g.b.k.a((Object) textInputEditText2, "aadhaar_name_tv");
        textInputEditText2.setOnFocusChangeListener(onFocusChangeListener);
        this.f65474a = (net.one97.paytm.upgradeKyc.aotp.b.a) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.aotp.b.a.class);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar = this.f65474a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar.l.observe(qVar, this.j);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar2 = this.f65474a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar2.f65537c.observe(qVar, this.k);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar3 = this.f65474a;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar3.f65538d.observe(qVar, this.l);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar4 = this.f65474a;
        if (aVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar4.f65543i.observe(qVar, this.m);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar5 = this.f65474a;
        if (aVar5 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar5.j.observe(qVar, this.o);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar6 = this.f65474a;
        if (aVar6 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar6.o.observe(qVar, this.q);
        net.one97.paytm.upgradeKyc.aotp.b.a aVar7 = this.f65474a;
        if (aVar7 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar7.q.observe(qVar, this.p);
        if (this.f65481i) {
            TextView textView = (TextView) a(R.id.enter_aadhaar_heading_tv);
            kotlin.g.b.k.a((Object) textView, "enter_aadhaar_heading_tv");
            textView.setText(getString(R.string.kyc_enter_aadhaar_no));
        } else {
            d.a aVar8 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            CharSequence a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("non_kyc_aadhaar_page_heading_text") : null;
            if (!TextUtils.isEmpty(a2)) {
                TextView textView2 = (TextView) a(R.id.enter_aadhaar_heading_tv);
                kotlin.g.b.k.a((Object) textView2, "enter_aadhaar_heading_tv");
                textView2.setText(a2);
            }
        }
        net.one97.paytm.upgradeKyc.aotp.b.a aVar9 = this.f65474a;
        if (aVar9 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        kotlin.g.b.k.c("aadhaar-otp", "fetchReason");
        aVar9.k.setValue("aadhaar-otp");
    }

    public static final class n extends net.one97.paytm.upgradeKyc.utils.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65495a;

        n(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65495a = enterAadhaarDetailsActivity;
        }

        public final void a(String str) {
            kotlin.g.b.k.c(str, "url");
            if (kotlin.m.p.a((CharSequence) str, (CharSequence) "https://www.google.com", true)) {
                e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
                Intent intent = new Intent(this.f65495a, Class.forName(e.a.b().d()));
                intent.putExtra("url", this.f65495a.f65476d.get(0).getUrl());
                intent.putExtra("Close", true);
                this.f65495a.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, KycAadharEkycDetails.KycResponse kycResponse) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this, CompleteProfileAadhaarActivity.class);
            intent.putExtra("reference_number", str);
            if (kycResponse != null) {
                intent.putExtra("aadhaarData", this.n);
            }
            intent.putExtra("isVideoKYCFlow", this.f65481i);
            startActivity(intent);
            finish();
            return;
        }
        String string = getString(R.string.some_went_wrong);
        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
        a(string);
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f65496a;

        o(com.paytm.utility.h hVar) {
            this.f65496a = hVar;
        }

        public final void onClick(View view) {
            this.f65496a.dismiss();
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65485a;

        d(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65485a = enterAadhaarDetailsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a((Context) this.f65485a, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000007&l1=1600201");
            dialogInterface.dismiss();
            this.f65485a.finish();
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65486a;

        e(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65486a = enterAadhaarDetailsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f65486a.finish();
        }
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65487a;

        f(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65487a = enterAadhaarDetailsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s", new Object[]{this.f65487a.f65479g, this.f65487a.f65478f});
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            kotlin.g.b.k.a((Object) format, "deeplink");
            e.a.b().a((Context) this.f65487a, format);
            dialogInterface.dismiss();
            this.f65487a.finish();
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65488a;

        g(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65488a = enterAadhaarDetailsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f65488a.finish();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65491a;

        j(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65491a = enterAadhaarDetailsActivity;
        }

        public final void onClick(View view) {
            this.f65491a.startActivity(new Intent(this.f65491a, VerifyDocActivity.class));
            this.f65491a.finish();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65492a;

        k(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65492a = enterAadhaarDetailsActivity;
        }

        public final void onClick(View view) {
            if (this.f65492a.f65481i) {
                this.f65492a.b("aadhaar_proceed_clicked", "/kyc/video_kyc/aotp");
            }
            UpgradeKycBaseActivity.a(this.f65492a, "/kyc/adhaar-screen", "aadhaar_proceed_clicked", (HashMap) null, (String) null, 12);
            if (this.f65492a.f() && (!this.f65492a.f65476d.isEmpty())) {
                net.one97.paytm.upgradeKyc.aotp.b.a d2 = this.f65492a.d();
                int version = this.f65492a.f65476d.get(0).getVersion();
                String code = this.f65492a.f65476d.get(0).getCode();
                kotlin.g.b.k.a((Object) code, "tncList[0].code");
                kotlin.g.b.k.c(code, "tncCode");
                d2.f65536b.setValue(new kotlin.o(code, Integer.valueOf(version)));
            }
        }
    }

    public static final class l implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char f65493a = '-';

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        l() {
        }

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
            if (editable.length() > 0 && editable.length() % 5 == 0 && this.f65493a == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(this.f65493a)).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(this.f65493a));
            }
        }
    }

    static final class m implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarDetailsActivity f65494a;

        m(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
            this.f65494a = enterAadhaarDetailsActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            UpgradeKycBaseActivity.a(this.f65494a, "/kyc/adhaar-screen", "understand_button_clicked", (HashMap) null, (String) null, 12);
        }
    }

    /* access modifiers changed from: private */
    public final boolean f() {
        int length;
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.aadhaar_no_tv);
        kotlin.g.b.k.a((Object) textInputEditText, "aadhaar_no_tv");
        String valueOf = String.valueOf(textInputEditText.getText());
        CharSequence charSequence = valueOf;
        if (!TextUtils.isEmpty(charSequence) && valueOf.length() == 19) {
            this.f65475b = true;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        if (TextUtils.isEmpty(charSequence) || (valueOf.length() >= 14 && (15 > (length = valueOf.length()) || 18 < length))) {
            TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.aadhaar_name_tv);
            kotlin.g.b.k.a((Object) textInputEditText2, "aadhaar_name_tv");
            if (TextUtils.isEmpty(textInputEditText2.getText())) {
                String string = getString(R.string.kyc_error_name);
                kotlin.g.b.k.a((Object) string, "getString(R.string.kyc_error_name)");
                a(string);
                TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.aadhaar_name_tv);
                kotlin.g.b.k.a((Object) textInputEditText3, "aadhaar_name_tv");
                a((EditText) textInputEditText3);
                return false;
            }
            CheckBox checkBox = (CheckBox) a(R.id.aadhaar_tnc_cb);
            kotlin.g.b.k.a((Object) checkBox, "aadhaar_tnc_cb");
            if (!checkBox.isChecked()) {
                String string2 = getString(R.string.tnc_accept);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.tnc_accept)");
                a(string2);
                return false;
            }
            if (!TextUtils.isEmpty(charSequence) && valueOf.length() == 14) {
                TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.aadhaar_no_tv);
                kotlin.g.b.k.a((Object) textInputEditText4, "aadhaar_no_tv");
                if (!com.paytm.utility.b.H(String.valueOf(textInputEditText4.getText()))) {
                    String string3 = getString(R.string.error_correct_aadhaar);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.error_correct_aadhaar)");
                    a(string3);
                    return false;
                }
            }
            return true;
        }
        if (valueOf.length() < 14) {
            String string4 = getString(R.string.error_correct_aadhaar);
            kotlin.g.b.k.a((Object) string4, "getString(R.string.error_correct_aadhaar)");
            a(string4);
        } else {
            String string5 = getString(R.string.error_correct_vid);
            kotlin.g.b.k.a((Object) string5, "getString(R.string.error_correct_vid)");
            a(string5);
        }
        TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.aadhaar_no_tv);
        kotlin.g.b.k.a((Object) textInputEditText5, "aadhaar_no_tv");
        a((EditText) textInputEditText5);
        return false;
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        Snackbar.a((View) (ConstraintLayout) a(R.id.enter_aadhaar_parent_lyt), (CharSequence) str, -1).c();
    }

    private void a(EditText editText) {
        kotlin.g.b.k.c(editText, H5AppUtil.short_prepareTime);
        try {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    public final void c() {
        super.c();
        if (this.f65481i) {
            b("go_back_clicked", "/kyc/video_kyc/aotp");
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z && view != null) {
            if (view.getId() == R.id.aadhaar_no_tv) {
                if (this.f65481i) {
                    b("aadhaar_number_entered", "/kyc/video_kyc/aotp");
                }
                UpgradeKycBaseActivity.a(this, "/kyc/adhaar-screen", "aadhaar_number_entered", (HashMap) null, (String) null, 12);
            }
            if (view.getId() == R.id.aadhaar_name_tv) {
                if (this.f65481i) {
                    b("aadhaar_name_entered", "/kyc/video_kyc/aotp");
                }
                UpgradeKycBaseActivity.a(this, "/kyc/adhaar-screen", "aadhaar_name_entered", (HashMap) null, (String) null, 12);
            }
        }
    }

    static /* synthetic */ void a(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity, boolean z, String str, boolean z2, int i2) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        Intent intent = new Intent(enterAadhaarDetailsActivity, InPersonVerification.class);
        intent.putExtra("ekyc_complete", z);
        intent.putExtra("inperson_verification_title", str);
        intent.putExtra("hideAotpAadhaar", z2);
        enterAadhaarDetailsActivity.startActivity(intent);
        enterAadhaarDetailsActivity.finish();
    }

    public static final /* synthetic */ void c(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
        if (enterAadhaarDetailsActivity.f65481i) {
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            net.one97.paytm.upgradeKyc.helper.f fVar = e.a.a().f66030a;
            if (fVar == null) {
                kotlin.g.b.k.a();
            }
            if (!net.one97.paytm.upgradeKyc.utils.j.e(fVar.a())) {
                enterAadhaarDetailsActivity.startActivity(new Intent(enterAadhaarDetailsActivity, AddPanVideoKycActivity.class));
                enterAadhaarDetailsActivity.finish();
                return;
            }
            enterAadhaarDetailsActivity.startActivity(new Intent(enterAadhaarDetailsActivity, VideoKycActivity.class));
            enterAadhaarDetailsActivity.finish();
            return;
        }
        a(enterAadhaarDetailsActivity, true, (String) null, false, 6);
    }

    public static final /* synthetic */ void a(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity, boolean z) {
        if (z) {
            Group group = (Group) enterAadhaarDetailsActivity.a(R.id.enter_adhar_details_lyt_grp);
            kotlin.g.b.k.a((Object) group, "enter_adhar_details_lyt_grp");
            net.one97.paytm.upgradeKyc.kycV3.b.b(group);
            if (enterAadhaarDetailsActivity.f65481i) {
                TextView textView = (TextView) enterAadhaarDetailsActivity.a(R.id.tv_video_kyc);
                kotlin.g.b.k.a((Object) textView, "tv_video_kyc");
                net.one97.paytm.upgradeKyc.kycV3.b.b(textView);
                return;
            }
            TextView textView2 = (TextView) enterAadhaarDetailsActivity.a(R.id.tv_video_kyc);
            kotlin.g.b.k.a((Object) textView2, "tv_video_kyc");
            net.one97.paytm.upgradeKyc.kycV3.b.a((View) textView2);
            return;
        }
        Group group2 = (Group) enterAadhaarDetailsActivity.a(R.id.enter_adhar_details_lyt_grp);
        kotlin.g.b.k.a((Object) group2, "enter_adhar_details_lyt_grp");
        net.one97.paytm.upgradeKyc.kycV3.b.a((View) group2);
        TextView textView3 = (TextView) enterAadhaarDetailsActivity.a(R.id.tv_video_kyc);
        kotlin.g.b.k.a((Object) textView3, "tv_video_kyc");
        net.one97.paytm.upgradeKyc.kycV3.b.a((View) textView3);
    }

    public static final /* synthetic */ void d(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity) {
        net.one97.paytm.upgradeKyc.aotp.b.a aVar = enterAadhaarDetailsActivity.f65474a;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        kotlin.g.b.k.c("paytm_app_aadhaar_otp_v_1_0", "tncSet");
        aVar.f65535a.setValue("paytm_app_aadhaar_otp_v_1_0");
    }

    public static final /* synthetic */ void a(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity, TextView textView, String str) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 24) {
            charSequence = Html.fromHtml(str, 0);
        } else {
            charSequence = Html.fromHtml(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        textView.setLinkTextColor(androidx.core.content.b.c(enterAadhaarDetailsActivity, R.color.paytm_blue));
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new n(enterAadhaarDetailsActivity));
    }

    public static final /* synthetic */ void c(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity, String str) {
        com.paytm.utility.h hVar = new com.paytm.utility.h(enterAadhaarDetailsActivity);
        hVar.setTitle(enterAadhaarDetailsActivity.getString(R.string.error));
        hVar.a(str);
        hVar.a(-3, enterAadhaarDetailsActivity.getString(R.string.ok), new o(hVar));
        hVar.show();
    }

    public static final /* synthetic */ void a(EnterAadhaarDetailsActivity enterAadhaarDetailsActivity, KycCheckDoc kycCheckDoc) {
        if (kotlin.m.p.a(kycCheckDoc.getStatus(), "success", true)) {
            if (!TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(enterAadhaarDetailsActivity);
                builder.setMessage(kycCheckDoc.getMessage());
                builder.setCancelable(false);
                builder.setNegativeButton(enterAadhaarDetailsActivity.getString(R.string.kyc_report_issue), new d(enterAadhaarDetailsActivity));
                builder.setPositiveButton(enterAadhaarDetailsActivity.getString(R.string.ok), new e(enterAadhaarDetailsActivity));
                builder.show();
            }
            if (kycCheckDoc.getData() != null) {
                KycCheckDoc.Data data = kycCheckDoc.getData();
                kotlin.g.b.k.a((Object) data, "kycCheckDoc.data");
                if (!TextUtils.isEmpty(data.getVerifyOtp())) {
                    KycCheckDoc.Data data2 = kycCheckDoc.getData();
                    kotlin.g.b.k.a((Object) data2, "kycCheckDoc.data");
                    if (!kotlin.m.p.a(data2.getVerifyOtp(), "1", true)) {
                        KycCheckDoc.Data data3 = kycCheckDoc.getData();
                        kotlin.g.b.k.a((Object) data3, "kycCheckDoc.data");
                        if (kotlin.m.p.a(data3.getVerifyOtp(), "0", true) && !TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(enterAadhaarDetailsActivity);
                            builder2.setMessage(kycCheckDoc.getMessage());
                            builder2.setCancelable(false);
                            builder2.setNegativeButton(enterAadhaarDetailsActivity.getString(R.string.kyc_report_issue), new f(enterAadhaarDetailsActivity));
                            builder2.setPositiveButton(enterAadhaarDetailsActivity.getString(R.string.ok), new g(enterAadhaarDetailsActivity));
                            builder2.show();
                        }
                    }
                }
            }
        } else if (kotlin.m.p.a(kycCheckDoc.getStatus(), "error", true) && kotlin.m.p.a(kycCheckDoc.getResponseCode(), "4024", true)) {
            String h2 = net.one97.paytm.upgradeKyc.utils.j.h(enterAadhaarDetailsActivity.getApplicationContext());
            if (TextUtils.isEmpty(h2) || !kotlin.m.p.a(h2, "true", true)) {
                net.one97.paytm.upgradeKyc.aotp.b.a aVar = enterAadhaarDetailsActivity.f65474a;
                if (aVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                String str = enterAadhaarDetailsActivity.f65480h;
                if (str == null) {
                    kotlin.g.b.k.a("mRefNumber");
                }
                aVar.a(str);
            }
        } else if (!kotlin.m.p.a(kycCheckDoc.getStatus(), "error", true)) {
            String string = enterAadhaarDetailsActivity.getString(R.string.some_went_wrong);
            kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
            enterAadhaarDetailsActivity.a(string);
        } else if (!TextUtils.isEmpty(kycCheckDoc.getMessage())) {
            String message = kycCheckDoc.getMessage();
            kotlin.g.b.k.a((Object) message, "kycCheckDoc.message");
            enterAadhaarDetailsActivity.a(message);
        } else {
            net.one97.paytm.upgradeKyc.aotp.b.a aVar2 = enterAadhaarDetailsActivity.f65474a;
            if (aVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            String str2 = enterAadhaarDetailsActivity.f65480h;
            if (str2 == null) {
                kotlin.g.b.k.a("mRefNumber");
            }
            aVar2.a(str2);
        }
    }
}
