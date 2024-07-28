package net.one97.paytm.upgradeKyc.aotp.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.m.p;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.KycPinEntryView;
import net.one97.paytm.upgradeKyc.utils.l;

public final class EnterAadhaarOtpActivity extends UpgradeKycBaseActivity implements KycPinEntryView.b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f65499g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.aotp.b.b f65500a;

    /* renamed from: b  reason: collision with root package name */
    public String f65501b;

    /* renamed from: d  reason: collision with root package name */
    public String f65502d;

    /* renamed from: e  reason: collision with root package name */
    final String f65503e = "1600039";

    /* renamed from: f  reason: collision with root package name */
    final String f65504f = "1000007";

    /* renamed from: h  reason: collision with root package name */
    private boolean f65505h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public KycAadharEkycDetails.KycResponse f65506i;
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> j = new c(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> k = new h(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> l = new b(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharEkycDetails>> m = new k(this);
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "digit");
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycCheckDoc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65507a;

        b(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65507a = enterAadhaarOtpActivity;
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
                int i2 = b.f65533c[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65507a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity = this.f65507a;
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            kotlin.g.b.k.a();
                        }
                        EnterAadhaarOtpActivity.a(enterAadhaarOtpActivity, (KycCheckDoc) resulttype);
                        return;
                    }
                    EnterAadhaarOtpActivity enterAadhaarOtpActivity2 = this.f65507a;
                    String string = enterAadhaarOtpActivity2.getString(R.string.some_went_wrong);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                    enterAadhaarOtpActivity2.c(string);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65507a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f65507a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65507a.a(R.id.wallet_loader));
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity3 = this.f65507a;
                        String string2 = enterAadhaarOtpActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity3.c(string2);
                    }
                }
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharGenOTP>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65508a;

        c(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65508a = enterAadhaarOtpActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            String statusMessage;
            KycAadharGenOTP kycAadharGenOTP;
            String statusCode;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            String str = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f65531a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65508a.a(R.id.wallet_loader));
                    KycAadharGenOTP kycAadharGenOTP2 = (KycAadharGenOTP) bVar.f66169b;
                    if (kycAadharGenOTP2 == null || (statusMessage = kycAadharGenOTP2.getStatusMessage()) == null || !p.a(statusMessage, "success", true) || (kycAadharGenOTP = (KycAadharGenOTP) bVar.f66169b) == null || (statusCode = kycAadharGenOTP.getStatusCode()) == null || !statusCode.equals("00")) {
                        KycAadharGenOTP kycAadharGenOTP3 = (KycAadharGenOTP) bVar.f66169b;
                        if (!TextUtils.isEmpty(kycAadharGenOTP3 != null ? kycAadharGenOTP3.getErrorErrorMessage() : null)) {
                            EnterAadhaarOtpActivity enterAadhaarOtpActivity = this.f65508a;
                            KycAadharGenOTP kycAadharGenOTP4 = (KycAadharGenOTP) bVar.f66169b;
                            if (kycAadharGenOTP4 != null) {
                                str = kycAadharGenOTP4.getErrorErrorMessage();
                            }
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            enterAadhaarOtpActivity.c(str);
                            return;
                        }
                        KycAadharGenOTP kycAadharGenOTP5 = (KycAadharGenOTP) bVar.f66169b;
                        if (!TextUtils.isEmpty(kycAadharGenOTP5 != null ? kycAadharGenOTP5.getErrorMessage() : null)) {
                            EnterAadhaarOtpActivity enterAadhaarOtpActivity2 = this.f65508a;
                            KycAadharGenOTP kycAadharGenOTP6 = (KycAadharGenOTP) bVar.f66169b;
                            if (kycAadharGenOTP6 != null) {
                                str = kycAadharGenOTP6.getErrorMessage();
                            }
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            enterAadhaarOtpActivity2.c(str);
                            return;
                        }
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity3 = this.f65508a;
                        String string = enterAadhaarOtpActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity3.c(string);
                        return;
                    }
                    KycAadharGenOTP kycAadharGenOTP7 = (KycAadharGenOTP) bVar.f66169b;
                    if (kycAadharGenOTP7 != null) {
                        str = kycAadharGenOTP7.getReferenceNumber();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65508a.a(R.id.wallet_loader));
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity4 = this.f65508a;
                        String string2 = enterAadhaarOtpActivity4.getString(R.string.otp_sent_aadhaar);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.otp_sent_aadhaar)");
                        enterAadhaarOtpActivity4.c(string2);
                        return;
                    }
                    EnterAadhaarOtpActivity enterAadhaarOtpActivity5 = this.f65508a;
                    String string3 = enterAadhaarOtpActivity5.getString(R.string.some_went_wrong);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.some_went_wrong)");
                    enterAadhaarOtpActivity5.c(string3);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65508a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f65508a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65508a.a(R.id.wallet_loader));
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity6 = this.f65508a;
                        String string4 = enterAadhaarOtpActivity6.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string4, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity6.c(string4);
                    }
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<EkycDataResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65513a;

        h(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65513a = enterAadhaarOtpActivity;
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
                int i2 = b.f65532b[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65513a.a(R.id.wallet_loader));
                    EkycDataResponse ekycDataResponse = (EkycDataResponse) bVar.f66169b;
                    if (ekycDataResponse == null || ekycDataResponse.getStatusCode() != 200) {
                        EkycDataResponse ekycDataResponse2 = (EkycDataResponse) bVar.f66169b;
                        if (!TextUtils.isEmpty(ekycDataResponse2 != null ? ekycDataResponse2.getMessage() : null)) {
                            EnterAadhaarOtpActivity enterAadhaarOtpActivity = this.f65513a;
                            EkycDataResponse ekycDataResponse3 = (EkycDataResponse) bVar.f66169b;
                            if (ekycDataResponse3 != null) {
                                str = ekycDataResponse3.getMessage();
                            }
                            if (str == null) {
                                kotlin.g.b.k.a();
                            }
                            enterAadhaarOtpActivity.c(str);
                            return;
                        }
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity2 = this.f65513a;
                        String string = enterAadhaarOtpActivity2.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity2.c(string);
                        return;
                    }
                    EnterAadhaarOtpActivity.b(this.f65513a);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65513a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f65513a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65513a.a(R.id.wallet_loader));
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity3 = this.f65513a;
                        String string2 = enterAadhaarOtpActivity3.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity3.c(string2);
                    }
                }
            }
        }
    }

    static final class k<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KycAadharEkycDetails>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65516a;

        k(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65516a = enterAadhaarOtpActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            String errorErrorCode;
            String errorErrorCode2;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f65534d[dVar.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                        }
                    } else if (bVar.f66170c != null) {
                        l.a();
                        Context context = this.f65516a;
                        NetworkCustomError networkCustomError = bVar.f66170c;
                        if (networkCustomError == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!l.a(context, networkCustomError)) {
                            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                            EnterAadhaarOtpActivity enterAadhaarOtpActivity = this.f65516a;
                            String string = enterAadhaarOtpActivity.getString(R.string.some_went_wrong);
                            kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                            enterAadhaarOtpActivity.c(string);
                        }
                    }
                } else if (bVar.f66169b != null) {
                    ResultType resulttype = bVar.f66169b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    KycAadharEkycDetails kycAadharEkycDetails = (KycAadharEkycDetails) resulttype;
                    if (!TextUtils.isEmpty(kycAadharEkycDetails.getIsMinor())) {
                        net.one97.paytm.upgradeKyc.utils.j.e(this.f65516a.getApplicationContext(), kycAadharEkycDetails.getIsMinor());
                    }
                    if (kycAadharEkycDetails.getStatusCode() == null || kycAadharEkycDetails.getStatusMessage() == null) {
                        String errorErrorCode3 = kycAadharEkycDetails.getErrorErrorCode();
                        if (errorErrorCode3 == null || !p.a(errorErrorCode3, "900001", true) || TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage())) {
                            String errorErrorCode4 = kycAadharEkycDetails.getErrorErrorCode();
                            if (((errorErrorCode4 == null || !p.a(errorErrorCode4, "203", true)) && ((errorErrorCode2 = kycAadharEkycDetails.getErrorErrorCode()) == null || !p.a(errorErrorCode2, "201", true))) || TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage())) {
                                String errorErrorCode5 = kycAadharEkycDetails.getErrorErrorCode();
                                if (((errorErrorCode5 == null || !p.a(errorErrorCode5, "9761", true)) && ((errorErrorCode = kycAadharEkycDetails.getErrorErrorCode()) == null || !p.a(errorErrorCode, "9762", true))) || TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage())) {
                                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                                    EnterAadhaarOtpActivity.a(this.f65516a);
                                    return;
                                }
                                ((KycPinEntryView) this.f65516a.a(R.id.otpView)).a();
                                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                                final com.paytm.utility.h hVar = new com.paytm.utility.h(this.f65516a);
                                hVar.a();
                                hVar.a(kycAadharEkycDetails.getErrorErrorMessage());
                                hVar.a(-3, this.f65516a.getString(R.string.ok), new View.OnClickListener(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ k f65522a;

                                    {
                                        this.f65522a = r1;
                                    }

                                    public final void onClick(View view) {
                                        hVar.dismiss();
                                        this.f65522a.f65516a.finish();
                                    }
                                });
                                hVar.show();
                                return;
                            }
                            ((KycPinEntryView) this.f65516a.a(R.id.otpView)).a();
                            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                            final com.paytm.utility.h hVar2 = new com.paytm.utility.h(this.f65516a);
                            hVar2.a();
                            hVar2.a(kycAadharEkycDetails.getErrorErrorMessage());
                            hVar2.a(-3, this.f65516a.getString(R.string.msg_see_other_options), new View.OnClickListener(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ k f65520a;

                                {
                                    this.f65520a = r1;
                                }

                                public final void onClick(View view) {
                                    hVar2.dismiss();
                                    EnterAadhaarOtpActivity.a(this.f65520a.f65516a);
                                }
                            });
                            hVar2.show();
                            return;
                        }
                        ((KycPinEntryView) this.f65516a.a(R.id.otpView)).a();
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65516a.a(R.id.wallet_loader));
                        final com.paytm.utility.h hVar3 = new com.paytm.utility.h(this.f65516a);
                        hVar3.a();
                        hVar3.a(kycAadharEkycDetails.getErrorErrorMessage());
                        hVar3.a(-2, this.f65516a.getString(R.string.msg_see_other_options), new View.OnClickListener(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ k f65517a;

                            {
                                this.f65517a = r1;
                            }

                            public final void onClick(View view) {
                                hVar3.dismiss();
                                EnterAadhaarOtpActivity.a(this.f65517a.f65516a);
                            }
                        });
                        hVar3.a(-1, this.f65516a.getString(R.string.kyc_try_again), new View.OnClickListener() {
                            public final void onClick(View view) {
                                hVar3.dismiss();
                            }
                        });
                        hVar3.show();
                    } else if (!kotlin.g.b.k.a((Object) kycAadharEkycDetails.getStatusCode(), (Object) WebLogin.RESPONSE_CODE_SUCCESS) || !p.a(kycAadharEkycDetails.getStatusMessage(), "success", true)) {
                        ((KycPinEntryView) this.f65516a.a(R.id.otpView)).a();
                        EnterAadhaarOtpActivity enterAadhaarOtpActivity2 = this.f65516a;
                        String string2 = enterAadhaarOtpActivity2.getString(R.string.some_went_wrong);
                        kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        enterAadhaarOtpActivity2.c(string2);
                    } else if (kycAadharEkycDetails.getKycResponse() != null) {
                        this.f65516a.f65506i = kycAadharEkycDetails.getKycResponse();
                        net.one97.paytm.upgradeKyc.aotp.b.b d2 = this.f65516a.d();
                        String str = this.f65516a.f65502d;
                        if (str == null) {
                            kotlin.g.b.k.a("userAadhaarNum");
                        }
                        KycAadharEkycDetails.KycResponse kycResponse = kycAadharEkycDetails.getKycResponse();
                        kotlin.g.b.k.a((Object) kycResponse, "kycAadharEkycDetails.kycResponse");
                        String uid = kycResponse.getUid();
                        kotlin.g.b.k.a((Object) uid, "kycAadharEkycDetails.kycResponse.uid");
                        kotlin.g.b.k.c(str, "userAdhar");
                        kotlin.g.b.k.c(uid, "eKycRef");
                        d2.f65552b = str;
                        d2.f65556f = uid;
                        d2.f65559i.setValue(str);
                    }
                } else {
                    EnterAadhaarOtpActivity enterAadhaarOtpActivity3 = this.f65516a;
                    String string3 = enterAadhaarOtpActivity3.getString(R.string.some_went_wrong);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.some_went_wrong)");
                    enterAadhaarOtpActivity3.c(string3);
                }
            }
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "passcode");
        if (this.f65505h) {
            b("otp_entered", "/kyc/video_kyc/otp_verify");
            b("verify_initiated", "/kyc/video_kyc/otp_verify");
        }
        UpgradeKycBaseActivity.a(this, "/kyc/adhaar-screen", "otp_entered", (HashMap) null, (String) null, 12);
        net.one97.paytm.upgradeKyc.aotp.b.b bVar = this.f65500a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String str2 = this.f65501b;
        if (str2 == null) {
            kotlin.g.b.k.a("mRefNumber");
        }
        kotlin.g.b.k.c(str, "otp");
        kotlin.g.b.k.c(str2, "refNumber");
        bVar.f65556f = str2;
        bVar.f65553c.setValue(str);
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.aadhaar_otp_activity;
    }

    public final net.one97.paytm.upgradeKyc.aotp.b.b d() {
        net.one97.paytm.upgradeKyc.aotp.b.b bVar = this.f65500a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        a("/kyc/adhaar-screen", "kyc_new", "signal");
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("reference_number")) == null) {
            str = "";
        }
        this.f65501b = str;
        Intent intent2 = getIntent();
        if (intent2 == null || (str2 = intent2.getStringExtra("aadhaar")) == null) {
            str2 = "";
        }
        this.f65502d = str2;
        if (getIntent() != null && getIntent().hasExtra("isVideoKYCFlow")) {
            this.f65505h = getIntent().getBooleanExtra("isVideoKYCFlow", false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.kyc_aadhaar_card));
        sb.append(" ");
        String str3 = this.f65502d;
        if (str3 == null) {
            kotlin.g.b.k.a("userAadhaarNum");
        }
        sb.append(str3);
        String sb2 = sb.toString();
        TextView textView = (TextView) a(R.id.kyc_aadhaar_tv);
        kotlin.g.b.k.a((Object) textView, "kyc_aadhaar_tv");
        textView.setText(sb2);
        KycPinEntryView kycPinEntryView = (KycPinEntryView) a(R.id.otpView);
        kotlin.g.b.k.a((Object) kycPinEntryView, "otpView");
        kycPinEntryView.setOnPinEnteredListener(this);
        ((TextView) a(R.id.tv_retry)).setOnClickListener(new i(this));
        ((TextView) a(R.id.tv_in_person)).setOnClickListener(new j(this));
        this.f65500a = (net.one97.paytm.upgradeKyc.aotp.b.b) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.aotp.b.b.class);
        net.one97.paytm.upgradeKyc.aotp.b.b bVar = this.f65500a;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        q qVar = this;
        bVar.f65554d.observe(qVar, this.j);
        net.one97.paytm.upgradeKyc.aotp.b.b bVar2 = this.f65500a;
        if (bVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar2.f65555e.observe(qVar, this.m);
        net.one97.paytm.upgradeKyc.aotp.b.b bVar3 = this.f65500a;
        if (bVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar3.f65558h.observe(qVar, this.k);
        net.one97.paytm.upgradeKyc.aotp.b.b bVar4 = this.f65500a;
        if (bVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar4.j.observe(qVar, this.l);
    }

    public final void c() {
        super.c();
        b("go_back_clicked", "/kyc/video_kyc/otp_verify");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65514a;

        i(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65514a = enterAadhaarOtpActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.upgradeKyc.aotp.b.b.a(this.f65514a.d());
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65515a;

        j(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65515a = enterAadhaarOtpActivity;
        }

        public final void onClick(View view) {
            EnterAadhaarOtpActivity.a(this.f65515a);
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65509a;

        d(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65509a = enterAadhaarOtpActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            e.a.b().a((Context) this.f65509a, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000007&l1=1600201");
            dialogInterface.dismiss();
            this.f65509a.finish();
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65510a;

        e(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65510a = enterAadhaarOtpActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f65510a.finish();
        }
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65511a;

        f(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65511a = enterAadhaarOtpActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s", new Object[]{this.f65511a.f65504f, this.f65511a.f65503e});
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            kotlin.g.b.k.a((Object) format, "deeplink");
            e.a.b().a((Context) this.f65511a, format);
            dialogInterface.dismiss();
            this.f65511a.finish();
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EnterAadhaarOtpActivity f65512a;

        g(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
            this.f65512a = enterAadhaarOtpActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            this.f65512a.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        Snackbar.a((View) (ConstraintLayout) a(R.id.parent_otp), (CharSequence) str, -1).c();
    }

    public static final /* synthetic */ void a(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
        if (enterAadhaarOtpActivity.f65505h) {
            enterAadhaarOtpActivity.b("in_person_verification", "/kyc/video_kyc/otp_verify");
        }
        enterAadhaarOtpActivity.startActivity(new Intent(enterAadhaarOtpActivity, InPersonVerification.class));
        enterAadhaarOtpActivity.finish();
    }

    public static final /* synthetic */ void b(EnterAadhaarOtpActivity enterAadhaarOtpActivity) {
        Intent intent = new Intent(enterAadhaarOtpActivity, CompleteProfileAadhaarActivity.class);
        String str = enterAadhaarOtpActivity.f65501b;
        if (str == null) {
            kotlin.g.b.k.a("mRefNumber");
        }
        intent.putExtra("reference_number", str);
        intent.putExtra("aadhaarData", enterAadhaarOtpActivity.f65506i);
        intent.putExtra("isVideoKYCFlow", enterAadhaarOtpActivity.f65505h);
        enterAadhaarOtpActivity.startActivity(intent);
        enterAadhaarOtpActivity.finish();
    }

    public static final /* synthetic */ void a(EnterAadhaarOtpActivity enterAadhaarOtpActivity, KycCheckDoc kycCheckDoc) {
        if (p.a(kycCheckDoc.getStatus(), "success", true)) {
            if (!TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(enterAadhaarOtpActivity);
                builder.setMessage(kycCheckDoc.getMessage());
                builder.setCancelable(false);
                builder.setNegativeButton(enterAadhaarOtpActivity.getString(R.string.kyc_report_issue), new d(enterAadhaarOtpActivity));
                builder.setPositiveButton(enterAadhaarOtpActivity.getString(R.string.ok), new e(enterAadhaarOtpActivity));
                builder.show();
            }
            if (kycCheckDoc.getData() != null) {
                KycCheckDoc.Data data = kycCheckDoc.getData();
                kotlin.g.b.k.a((Object) data, "kycCheckDoc.data");
                if (!TextUtils.isEmpty(data.getVerifyOtp())) {
                    KycCheckDoc.Data data2 = kycCheckDoc.getData();
                    kotlin.g.b.k.a((Object) data2, "kycCheckDoc.data");
                    if (!p.a(data2.getVerifyOtp(), "1", true)) {
                        KycCheckDoc.Data data3 = kycCheckDoc.getData();
                        kotlin.g.b.k.a((Object) data3, "kycCheckDoc.data");
                        if (p.a(data3.getVerifyOtp(), "0", true) && !TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(enterAadhaarOtpActivity);
                            builder2.setMessage(kycCheckDoc.getMessage());
                            builder2.setCancelable(false);
                            builder2.setNegativeButton(enterAadhaarOtpActivity.getString(R.string.kyc_report_issue), new f(enterAadhaarOtpActivity));
                            builder2.setPositiveButton(enterAadhaarOtpActivity.getString(R.string.ok), new g(enterAadhaarOtpActivity));
                            builder2.show();
                        }
                    }
                }
            }
        } else if (p.a(kycCheckDoc.getStatus(), "error", true) && p.a(kycCheckDoc.getResponseCode(), "4024", true)) {
            String h2 = net.one97.paytm.upgradeKyc.utils.j.h(enterAadhaarOtpActivity.getApplicationContext());
            if (TextUtils.isEmpty(h2) || !p.a(h2, "true", true)) {
                net.one97.paytm.upgradeKyc.aotp.b.b bVar = enterAadhaarOtpActivity.f65500a;
                if (bVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                String str = enterAadhaarOtpActivity.f65501b;
                if (str == null) {
                    kotlin.g.b.k.a("mRefNumber");
                }
                bVar.a(str);
            }
        } else if (!p.a(kycCheckDoc.getStatus(), "error", true)) {
            String string = enterAadhaarOtpActivity.getString(R.string.some_went_wrong);
            kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
            enterAadhaarOtpActivity.c(string);
        } else if (!TextUtils.isEmpty(kycCheckDoc.getMessage())) {
            String message = kycCheckDoc.getMessage();
            kotlin.g.b.k.a((Object) message, "kycCheckDoc.message");
            enterAadhaarOtpActivity.c(message);
        } else {
            net.one97.paytm.upgradeKyc.aotp.b.b bVar2 = enterAadhaarOtpActivity.f65500a;
            if (bVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            String str2 = enterAadhaarOtpActivity.f65501b;
            if (str2 == null) {
                kotlin.g.b.k.a("mRefNumber");
            }
            bVar2.a(str2);
        }
    }
}
