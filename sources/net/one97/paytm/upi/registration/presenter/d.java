package net.one97.paytm.upi.registration.presenter;

import android.text.TextUtils;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiInitiateSmsModel;
import net.one97.paytm.upi.common.UpiInitiateSmsV3Response;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.models.UpiExpireSmsTokenModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.SignupStepCodeResponse;
import net.one97.paytm.upi.common.upi.UpiCreateProfileResponse;
import net.one97.paytm.upi.common.upi.UpiProfileBaseResponseModel;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.registration.a.d;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class d implements d.b, a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    b f68624a;

    /* renamed from: b  reason: collision with root package name */
    d.c f68625b;

    /* renamed from: c  reason: collision with root package name */
    AccountProviderBody.AccountProvider f68626c;

    /* renamed from: d  reason: collision with root package name */
    int f68627d = -1;

    /* renamed from: e  reason: collision with root package name */
    String f68628e;

    /* renamed from: f  reason: collision with root package name */
    UpiProfileModel.ProfileDetails f68629f;

    /* renamed from: g  reason: collision with root package name */
    private final String f68630g = "RegistrationProgressPresenter";

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.upi.h.a f68631h;

    /* renamed from: i  reason: collision with root package name */
    private int f68632i;
    private String j;
    private String k = "";
    private UpiConstants.UpiExpireSmsTokenState l;
    private UpiConstants.UpiDeviceBindingState m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private ArrayList<String> r = new ArrayList<>();

    public d(b bVar, net.one97.paytm.upi.h.a aVar, d.c cVar, AccountProviderBody.AccountProvider accountProvider, int i2, String str, int i3) {
        this.f68624a = bVar;
        this.f68631h = aVar;
        this.f68625b = cVar;
        this.f68626c = accountProvider;
        this.f68632i = i2;
        this.j = str;
        this.f68627d = i3;
        this.f68628e = cVar.getClass().getSimpleName();
        this.l = UpiConstants.UpiExpireSmsTokenState.NO_RESPONSE;
        this.m = UpiConstants.UpiDeviceBindingState.NO_RESPONSE;
        this.f68625b.a(this);
    }

    public final void e() {
        this.f68625b.a(this.f68626c);
        if (this.f68624a.g()) {
            this.f68625b.g();
            this.f68624a.b(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (upiBaseDataModel instanceof UpiProfileBaseResponseModel) {
                        UpiProfileBaseResponseModel upiProfileBaseResponseModel = (UpiProfileBaseResponseModel) upiBaseDataModel;
                        String respCode = upiProfileBaseResponseModel.getRespCode();
                        if ("0".equalsIgnoreCase(respCode) || "INT-1222".equalsIgnoreCase(respCode)) {
                            if (d.this.f68627d != -1) {
                                d.this.f68624a.c(true);
                            }
                            b bVar = d.this.f68624a;
                            d dVar = d.this;
                            bVar.d(dVar, "RegistrationProgressPresenter", dVar.f68628e);
                        } else if ("1005".equalsIgnoreCase(respCode)) {
                            if (d.this.f68627d != -1) {
                                d.this.f68624a.c(true);
                            }
                            b bVar2 = d.this.f68624a;
                            d dVar2 = d.this;
                            bVar2.d(dVar2, "RegistrationProgressPresenter", dVar2.f68628e);
                        } else if ("1001".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("INT-1621".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.NON_COMPLIANT_APP_VERSION_FOR_DEVICE_BINDING.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("INT-1622".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("INT-1031".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("INT-1622".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("INT-1057".equalsIgnoreCase(respCode)) {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        } else if ("1006".equalsIgnoreCase(respCode)) {
                            d.this.f68624a.c(new a.C1389a() {
                                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                                    if (upiAvailabilityModel != null && "success".equalsIgnoreCase(upiAvailabilityModel.getStatus()) && !upiAvailabilityModel.getResponse().isSameDevice()) {
                                        d.this.f68625b.a(d.this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal(), (String) null);
                                    }
                                }

                                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                                    d.this.f68625b.a(d.this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal(), (String) null);
                                }
                            }, "", "");
                        } else {
                            d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), upiProfileBaseResponseModel.getRespMessage());
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    d.this.f68625b.a(d.this.f68626c, UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal(), "");
                }
            }, "RegistrationProgressPresenter");
            return;
        }
        a(this.f68625b.f(), this.j, "");
    }

    public final void a(boolean z, String str, String str2) {
        this.f68624a.a(this, "RegistrationProgressPresenter", this.f68628e, z, str, str2);
    }

    public final void g() {
        if (this.m == UpiConstants.UpiDeviceBindingState.NO_RESPONSE && this.l == UpiConstants.UpiExpireSmsTokenState.NO_RESPONSE && !TextUtils.isEmpty(this.k)) {
            this.l = UpiConstants.UpiExpireSmsTokenState.IN_PROGRESS;
            this.f68624a.a(this, "expiry", this.f68628e, this.k);
        }
    }

    public final void a() {
        if (!this.n) {
            this.n = true;
            this.f68625b.g();
            this.f68625b.a();
        }
    }

    public final void b() {
        if (!this.o) {
            this.o = true;
            this.f68625b.g();
            this.f68625b.a();
        }
    }

    public final void a(int i2) {
        this.p += i2;
    }

    public final void c() {
        this.q++;
        if (this.q >= this.p) {
            this.f68625b.c();
            this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.SMS_NOT_SENT.ordinal(), (String) null);
        }
    }

    public final void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("vmn", str2);
        }
        if (!TextUtils.isEmpty(this.j)) {
            hashMap.put("carrier", this.j);
        }
        this.f68625b.b(true);
        this.f68624a.a((a.C1389a) this, "RegistrationProgressPresenter", str, (HashMap<String, String>) hashMap, this.f68628e);
    }

    public final void d() {
        this.f68625b.b(this.f68626c);
    }

    public final void h() {
        this.f68624a.a(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (d.this.f68625b != null) {
                    String str = "";
                    if (upiBaseDataModel instanceof UpiCreateProfileResponse) {
                        UpiCreateProfileResponse upiCreateProfileResponse = (UpiCreateProfileResponse) upiBaseDataModel;
                        if (!upiCreateProfileResponse.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equals(upiCreateProfileResponse.getRespCode())) {
                            d.this.f68625b.a(upiCreateProfileResponse.getRespCode(), upiCreateProfileResponse.getRespMessage());
                            return;
                        }
                        Iterator<SignupStepCodeResponse> it2 = upiCreateProfileResponse.getAccountDetails().getStepResponses().iterator();
                        while (it2.hasNext()) {
                            SignupStepCodeResponse next = it2.next();
                            if (!next.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.REGISTER_DEVICE)) {
                                if (next.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.CREATE_VPA)) {
                                    if (!"0".equals(next.getRespCode()) || next.getDetails().getVpaDetails() == null) {
                                        d.this.f68625b.a(next.getRespCode(), next.getRespMessage());
                                        return;
                                    }
                                    str = next.getDetails().getVpaDetails().get(0).getVpa();
                                }
                                if (next.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.FETCH_ACCOUNT)) {
                                    "0".equals(next.getRespCode());
                                }
                                if (next.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.LINK_ACCOUNT) && "0".equals(next.getRespCode())) {
                                    d.this.f68629f = upiCreateProfileResponse.getAccountDetails().getProfileDetail();
                                }
                            }
                        }
                        d.this.f68625b.a(str, d.this.f68629f);
                        return;
                    }
                    d.this.f68625b.a(str, str);
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (d.this.f68625b != null) {
                    d.this.f68625b.a("", "");
                }
            }
        }, "RegistrationProgressPresenter");
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        d.c cVar;
        if (upiBaseDataModel instanceof UpiToken) {
            if (!this.f68625b.d() || (cVar = this.f68625b) == null) {
                this.f68624a.c(new a.C1389a() {
                    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                        d.this.f68625b.b();
                    }

                    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                        d.this.f68625b.b();
                    }
                }, "", "");
            } else {
                cVar.e();
            }
        } else if (upiBaseDataModel instanceof BaseUpiResponse) {
            this.f68625b.b(false);
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
            String response = baseUpiResponse.getResponse();
            if (baseUpiResponse.getMobileAppData() != null && !baseUpiResponse.getMobileAppData().equals("")) {
                ((List) baseUpiResponse.getMobileAppData()).get(0);
            }
            this.m = UpiConstants.UpiDeviceBindingState.DEVICE_BINDING_FAILED;
            if (baseUpiResponse.isSuccess()) {
                this.m = UpiConstants.UpiDeviceBindingState.DEVICE_BINDING_SUCCESS;
                UpiConstants.UpiExpireSmsTokenState upiExpireSmsTokenState = UpiConstants.UpiExpireSmsTokenState.TOKEN_EXPIRE_SUCCESS;
                if ("0".equalsIgnoreCase(response) || "INT-1222".equalsIgnoreCase(response)) {
                    if (this.f68627d != -1) {
                        this.f68624a.c(true);
                    }
                    this.f68624a.d(this, "RegistrationProgressPresenter", this.f68628e);
                }
                this.f68625b.a(true);
            } else if ("1005".equalsIgnoreCase(response)) {
                this.m = UpiConstants.UpiDeviceBindingState.DEVICE_BINDING_SUCCESS;
                UpiConstants.UpiExpireSmsTokenState upiExpireSmsTokenState2 = UpiConstants.UpiExpireSmsTokenState.TOKEN_EXPIRE_SUCCESS;
                if (this.f68627d != -1) {
                    this.f68624a.c(true);
                }
                this.f68625b.a(true);
                this.f68624a.d(this, "RegistrationProgressPresenter", this.f68628e);
            } else if ("1001".equalsIgnoreCase(response)) {
                this.f68625b.a(false);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.MOBIlE_NOT_REGISTERED.ordinal(), baseUpiResponse.getMessage());
            } else if ("1004".equalsIgnoreCase(response) || "INT-1228".equalsIgnoreCase(response) || "INT-1234".equalsIgnoreCase(response)) {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.SMS_NOT_RECEIVED.ordinal(), baseUpiResponse.getMessage());
            } else if ("INT-1232".equalsIgnoreCase(response)) {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.SMS_NOT_RECEIVED.ordinal(), baseUpiResponse.getMessage());
            } else if ("INT-1233".equalsIgnoreCase(response)) {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.SMS_TOKEN_EXPIRED.ordinal(), baseUpiResponse.getMessage());
            } else if ("INT-1621".equalsIgnoreCase(response)) {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.NON_COMPLIANT_APP_VERSION_FOR_DEVICE_BINDING.ordinal(), baseUpiResponse.getMessage());
            } else if ("INT-1622".equalsIgnoreCase(response)) {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.UNIQUE_MOBILE_NUMBER_ALLOWED_LIMIT_AGAINST_DEVICE_ID_BREACHED.ordinal(), baseUpiResponse.getMessage());
            } else {
                this.f68625b.a(true);
                this.f68625b.a(this.f68626c, -1, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), baseUpiResponse.getMessage());
            }
        } else if (upiBaseDataModel instanceof UpiInitiateSmsModel) {
            UpiInitiateSmsModel upiInitiateSmsModel = (UpiInitiateSmsModel) upiBaseDataModel;
            if ("SUCCESS".equalsIgnoreCase(upiInitiateSmsModel.getStatus())) {
                this.k = upiInitiateSmsModel.getVerificationData();
                if (!TextUtils.isEmpty(this.k)) {
                    this.f68625b.a(this.f68632i, this.k);
                    return;
                }
            }
            this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), (String) null);
        } else if (upiBaseDataModel instanceof UpiExpireSmsTokenModel) {
            this.l = UpiConstants.UpiExpireSmsTokenState.TOKEN_EXPIRE_FAILED;
            if ("SUCCESS".equalsIgnoreCase(((UpiExpireSmsTokenModel) upiBaseDataModel).getStatus())) {
                this.l = UpiConstants.UpiExpireSmsTokenState.TOKEN_EXPIRE_SUCCESS;
            }
        } else if (upiBaseDataModel instanceof UpiInitiateSmsV3Response) {
            UpiInitiateSmsV3Response upiInitiateSmsV3Response = (UpiInitiateSmsV3Response) upiBaseDataModel;
            if (upiInitiateSmsV3Response.getStatus().equalsIgnoreCase("SUCCESS") && "0".equals(upiInitiateSmsV3Response.getRespCode())) {
                this.k = upiInitiateSmsV3Response.getRespDetails().getVerificationData();
                ArrayList<UpiInitiateSmsV3Response.Vmn> vmnDetails = upiInitiateSmsV3Response.getRespDetails().getVmnDetails();
                if (vmnDetails != null && !vmnDetails.isEmpty()) {
                    this.r.clear();
                    Iterator<UpiInitiateSmsV3Response.Vmn> it2 = vmnDetails.iterator();
                    while (it2.hasNext()) {
                        this.r.add(it2.next().getVmn());
                    }
                }
                if (!TextUtils.isEmpty(this.k)) {
                    this.f68625b.a(this.f68632i, this.k);
                    return;
                }
            }
            this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), (String) null);
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null || (!UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) && !"410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()))) {
            String fullUrl = upiCustomVolleyError.getFullUrl();
            if (TextUtils.isEmpty(fullUrl)) {
                return;
            }
            if (fullUrl.contains("device-binding-v2")) {
                this.m = UpiConstants.UpiDeviceBindingState.DEVICE_BINDING_FAILED;
                this.f68625b.b(false);
                this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), (String) null);
            } else if (fullUrl.contains("get-token")) {
                this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.NPCI_OR_TOKEN_ERROR.ordinal(), (String) null);
            } else if (fullUrl.contains("initiate-sms")) {
                this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.NETWORK_CONNECTION_ERROR.ordinal(), (String) null);
            } else if (fullUrl.contains(StringSet.token)) {
                this.l = UpiConstants.UpiExpireSmsTokenState.TOKEN_EXPIRE_FAILED;
                this.f68625b.a(this.f68626c, this.f68632i, UpiConstants.RegistrationErrorOrigin.OTHER_ERROR.ordinal(), (String) null);
            }
        } else {
            this.f68625b.a(upiCustomVolleyError);
        }
    }

    public final void f() {
        this.f68624a.c("RegistrationProgressPresenter");
    }

    public final ArrayList<String> i() {
        return this.r;
    }
}
