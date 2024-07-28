package net.one97.paytm.moneytransfer.presenter;

import android.os.Handler;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.moneytransfer.a.f;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.passbook.b.a.b;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class d implements f.b {

    /* renamed from: a  reason: collision with root package name */
    f.a f54078a;

    /* renamed from: b  reason: collision with root package name */
    a f54079b;

    /* renamed from: c  reason: collision with root package name */
    private final String f54080c = "MoneyTransferPostPaymentPresenter";

    /* renamed from: d  reason: collision with root package name */
    private final String f54081d = "MoneyTransferPostPaymentPresenter";

    /* renamed from: e  reason: collision with root package name */
    private b f54082e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.b.a.b f54083f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f54084g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f54085h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f54086i;
    private String j;
    private a.C1382a k = new a.C1382a() {
        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (d.this.c()) {
                d.this.f54078a.b((BaseUpiResponse) upiBaseDataModel);
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (!d.this.c()) {
                return;
            }
            if (H5BridgeContext.INVALID_ID.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || UpiConstants.NETWORK_ERROR_CODE.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                d.this.f54078a.b(upiCustomVolleyError);
            } else {
                d.this.f54078a.a(upiCustomVolleyError);
            }
        }
    };

    public final void e() {
    }

    public d(f.a aVar, b bVar, net.one97.paytm.moneytransfer.b.a.b bVar2, net.one97.paytm.upi.registration.b.a.b bVar3, net.one97.paytm.upi.profile.b.b bVar4, net.one97.paytm.upi.h.a aVar2) {
        this.f54078a = aVar;
        this.j = aVar.getClass().getSimpleName();
        this.f54082e = bVar;
        this.f54083f = bVar2;
        this.f54084g = bVar3;
        this.f54085h = bVar4;
        this.f54079b = aVar2;
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        if (c()) {
            this.f54078a.a(accountProvider);
        }
    }

    public final void a(String str) {
        b bVar = this.f54082e;
        if (bVar != null) {
            bVar.b((a.C1379a) new a.C1379a() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    if (d.this.c() && (upiBaseDataModel instanceof BaseUpiResponse)) {
                        d.this.f54078a.a((BaseUpiResponse) upiBaseDataModel);
                    }
                }

                public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                    if (d.this.c()) {
                        upiCustomVolleyError.getAlertMessage();
                        if (H5BridgeContext.INVALID_ID.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || UpiConstants.NETWORK_ERROR_CODE.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                            d.this.f54078a.c(upiCustomVolleyError);
                        } else if (net.one97.paytm.upi.passbook.b.a.b.a.f67623a.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                            d.this.f54078a.d();
                        } else {
                            d.this.f54078a.a((BaseUpiResponse) null);
                        }
                    }
                }
            }, str, "MoneyTransferPostPaymentPresenter", this.j);
        }
    }

    public final void a() {
        if (!this.f54083f.b() || this.f54083f.a()) {
            this.f54084g.d(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (!d.this.c()) {
                        return;
                    }
                    if (upiBaseDataModel instanceof UpiToken) {
                        d.this.f54078a.a(((UpiToken) upiBaseDataModel).getUpiToken());
                    } else {
                        d.this.f54078a.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (d.this.c()) {
                        d.this.f54078a.a(false);
                        if (upiCustomVolleyError == null || !"1006".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                            d.this.f54078a.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                        } else {
                            d.this.f54078a.b_(0);
                        }
                    }
                }
            }, "MoneyTransferPostPaymentPresenter", this.j);
        } else {
            this.f54078a.b_(0);
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, UpiProfileDefaultBank upiProfileDefaultBank, String str10, CommonPayParams commonPayParams, String str11, String str12) {
        this.f54078a.c();
        net.one97.paytm.moneytransfer.b.a.b bVar = this.f54083f;
        a.C1382a aVar = this.k;
        bVar.a(aVar, str2, "MoneyTransferPostPaymentPresenter", str, str3, str4, str5, str6, str7, str8, str9, upiProfileDefaultBank, str10, this.j, commonPayParams, str11, str12);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, boolean z, CommonPayParams commonPayParams, String str12, String str13) {
        this.f54078a.c();
        net.one97.paytm.moneytransfer.b.a.b bVar = this.f54083f;
        a.C1382a aVar = this.k;
        bVar.a(aVar, str2, "MoneyTransferPostPaymentPresenter", str, str3, str4, str5, str6, str7, str8, str9, str10, upiProfileDefaultBank, str11, z, this.j, commonPayParams, str12, str13);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, UpiProfileDefaultBank upiProfileDefaultBank, String str8) {
        this.f54078a.c();
        this.f54083f.a(this.k, str2, "MoneyTransferPostPaymentPresenter", str, str3, str4, str5, str6, str7, upiProfileDefaultBank, str8, this.j);
    }

    public final void a(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12) {
        this.f54086i = z;
        try {
            this.f54083f.a(str, str2, str3, str4, str5, str6, new CLRemoteResultReceiver(new MoneyTransferPostPaymentPresenter$5(this, new Handler(), z2)), str7, str8, str9, str10, str11, list, str12);
        } catch (IllegalStateException unused) {
            this.f54078a.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
        }
    }

    public final void a(final UpiProfileDefaultBank upiProfileDefaultBank) {
        this.f54078a.a(true);
        if (upiProfileDefaultBank.getDebitBank().getIfsc().contains("PYTM")) {
            net.one97.paytm.upi.profile.b.b bVar = this.f54085h;
            upiProfileDefaultBank.getDebitBank().getAccount();
            bVar.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (d.this.c()) {
                        d.this.f54078a.a(false);
                        if (upiBaseDataModel instanceof CJRAccountSummary) {
                            CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                            if (cJRAccountSummary.getStatus() == null || !cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                                d.this.f54078a.a("", "");
                            } else {
                                d.this.f54078a.a(String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance()), "");
                            }
                        } else {
                            d.this.f54078a.a("", "");
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (d.this.c()) {
                        d.this.f54078a.a(false);
                        d.this.f54078a.a("", "");
                    }
                }
            });
        } else if (!this.f54083f.b() || this.f54083f.a()) {
            this.f54084g.d(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (d.this.c()) {
                        d.this.f54078a.a(false);
                        if (upiBaseDataModel instanceof UpiToken) {
                            d dVar = d.this;
                            String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                            UpiProfileDefaultBank upiProfileDefaultBank = upiProfileDefaultBank;
                            String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                            dVar.f54079b.a(upiSequenceNo, "", upiToken, 0, upiProfileDefaultBank.getDebitBank(), new CLRemoteResultReceiver(new MoneyTransferPostPaymentPresenter$9(dVar, new Handler(), upiSequenceNo, upiProfileDefaultBank)));
                            return;
                        }
                        d.this.f54078a.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (d.this.c()) {
                        d.this.f54078a.a(false);
                        if (upiCustomVolleyError == null || !"1006".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                            d.this.f54078a.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                        } else {
                            d.this.f54078a.b_(0);
                        }
                    }
                }
            }, "MoneyTransferPostPaymentPresenter", this.j);
        } else {
            this.f54078a.b_(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(List<GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse next : list) {
            if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            }
        }
        this.f54078a.a(true);
        this.f54085h.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (!d.this.c()) {
                    return;
                }
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    d.this.f54078a.a(false);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                        d.this.f54078a.a("", baseUpiResponse.getResponse());
                        return;
                    }
                    try {
                        if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                            d.this.f54078a.a(((UpiCheckBalanceModel) baseUpiResponse.getMobileAppData()).getAvailableBalance(), "");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    d.this.f54078a.a(false);
                    d.this.f54078a.a("", "");
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (d.this.c()) {
                    d.this.f54078a.a(false);
                    d.this.f54078a.a("", "");
                }
            }
        }, "MoneyTransferPostPaymentPresenter", this.j);
    }

    public final boolean b() {
        return this.f54083f.a();
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(CLConstants.INPUT_KEY_TRUST, str3);
        hashMap.put("deviceToken", this.f54083f.c());
        this.f54085h.a(str2, str, str4, str5, str6, (HashMap<String, String>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.f54078a != null;
    }

    public final void f() {
        b bVar = this.f54082e;
        if (bVar != null) {
            bVar.a("MoneyTransferPostPaymentPresenter");
        }
        this.f54078a = null;
    }

    public final void b(String str) {
        this.f54083f.b(str);
    }
}
