package net.one97.paytm.upi.requestmoney.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.requestmoney.a.d;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.requestmoney.b.a.b;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class d implements d.a, a.C1402a {

    /* renamed from: a  reason: collision with root package name */
    b f69186a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.upi.h.a f69187b;

    /* renamed from: c  reason: collision with root package name */
    d.b f69188c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f69189d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f69190e;

    /* renamed from: f  reason: collision with root package name */
    private List<UpiProfileDefaultBank> f69191f;

    /* renamed from: g  reason: collision with root package name */
    private LinkedHashMap<String, UpiProfileDefaultBank> f69192g;

    /* renamed from: h  reason: collision with root package name */
    private String f69193h;

    /* renamed from: i  reason: collision with root package name */
    private String f69194i = "";
    private final String j = "UpiRequestMoneyPresenter";
    private List<UpiProfileDefaultBank> k;

    public d(b bVar, net.one97.paytm.upi.profile.b.b bVar2, net.one97.paytm.upi.registration.b.a.b bVar3, net.one97.paytm.upi.h.a aVar, d.b bVar4) {
        this.f69186a = bVar;
        this.f69189d = bVar2;
        this.f69190e = bVar3;
        this.f69187b = aVar;
        this.f69188c = bVar4;
        this.f69191f = new ArrayList();
        this.f69192g = new LinkedHashMap<>();
        this.k = new ArrayList();
    }

    public final void a() {
        this.f69188c.h();
    }

    public final void a(String str, String str2, RequestMoneyV2Activity.b bVar) {
        if (!this.f69186a.a()) {
            this.f69188c.g();
            return;
        }
        this.f69188c.a(true, bVar);
        this.f69186a.b(this, "UpiRequestMoneyPresenter", str, str2, "");
    }

    public final void a(Bundle bundle) {
        this.f69188c.a(bundle);
    }

    public final void b() {
        if (this.f69186a.a()) {
            this.f69188c.a(true, (RequestMoneyV2Activity.b) null);
            this.f69186a.a(this, "UpiRequestMoneyPresenter", "");
            return;
        }
        this.f69188c.g();
    }

    public final void e() {
        if (!this.f69186a.a()) {
            this.f69188c.g();
            return;
        }
        this.f69188c.e();
        this.f69188c.f();
    }

    public final void f() {
        this.f69186a.a("UpiRequestMoneyPresenter");
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, String str, String str2, String str3, String str4, String str5) {
        if (!this.f69186a.a()) {
            this.f69188c.g();
        } else if (upiProfileDefaultBank != null) {
            this.f69188c.a(true, (RequestMoneyV2Activity.b) null);
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str5;
            this.f69186a.a(new a.C1402a() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    d.this.f69188c.a(false, (RequestMoneyV2Activity.b) null);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || (!"92".equalsIgnoreCase(baseUpiResponse.getResponse()) && !"0".equalsIgnoreCase(baseUpiResponse.getResponse()))) {
                        d.b bVar = d.this.f69188c;
                        baseUpiResponse.isSuccess();
                        String response = baseUpiResponse.getResponse();
                        String message = baseUpiResponse.getMessage();
                        baseUpiResponse.getBankRRN();
                        baseUpiResponse.getUpiTranlogId();
                        baseUpiResponse.getSeqNo();
                        bVar.a(response, message);
                        return;
                    }
                    d.this.f69188c.a(true);
                    d.this.f69186a.a(new UpiDBTransactionModel("request", str6, str8, "", "upi", str7, String.valueOf(System.currentTimeMillis())));
                    d.this.f69188c.i();
                }

                public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                    d.this.f69188c.a(false, (RequestMoneyV2Activity.b) null);
                    d.this.f69188c.a(false);
                }
            }, "UpiRequestMoneyPresenter", upiProfileDefaultBank.getCreditBank().getIfsc(), upiProfileDefaultBank.getCreditBank().getAccount(), upiProfileDefaultBank.getVirtualAddress().toLowerCase(), str.toLowerCase(), str2, str3, str4, str5, "");
        }
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        this.f69188c.a(false, (RequestMoneyV2Activity.b) null);
        if (upiBaseDataModel instanceof UpiProfileModel) {
            UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
            if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null) {
                this.f69191f.clear();
                this.f69188c.a(this.f69191f);
                if (upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                    for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                        if (!(next.getCreditBank() == null || next.getCreditBank().getAccount() == null)) {
                            this.f69192g.put(next.getCreditBank().getAccount(), next);
                        }
                        if (next.isPrimary()) {
                            this.f69194i = next.getVirtualAddress();
                        }
                    }
                }
                if (upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null && !upiProfileModel.getResponse().getProfileDetail().getBankAccountList().isEmpty()) {
                    Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                    while (it2.hasNext()) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setVirtualAddress(this.f69194i);
                        upiProfileDefaultBank.setCreditBank(it2.next());
                        if (upiProfileDefaultBank.getCreditBank() != null && !TextUtils.isEmpty(upiProfileDefaultBank.getCreditBank().getAccount()) && !TextUtils.isEmpty(upiProfileDefaultBank.getCreditBank().getIfsc())) {
                            this.f69192g.put(upiProfileDefaultBank.getCreditBank().getAccount(), upiProfileDefaultBank);
                        }
                    }
                }
                for (Map.Entry<String, UpiProfileDefaultBank> value : this.f69192g.entrySet()) {
                    this.f69191f.add(value.getValue());
                }
                this.f69188c.b(this.f69191f);
            }
        } else if (upiBaseDataModel instanceof BaseUpiResponse) {
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
            if (!baseUpiResponse.isSuccess() || !"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                this.f69188c.a(false, baseUpiResponse.getResponse(), (ValidateVpaResponse) null);
                return;
            }
            String str = (String) baseUpiResponse.getMobileAppData();
            if (str.toLowerCase().contains("success")) {
                this.f69193h = str.substring(str.indexOf("=") + 1);
            }
            if (!TextUtils.isEmpty(this.f69193h)) {
                this.f69188c.a(this.f69193h);
                this.f69188c.a(true, "", (ValidateVpaResponse) null);
                return;
            }
            this.f69188c.a(false, "", (ValidateVpaResponse) null);
        } else if (upiBaseDataModel instanceof ValidateVpaResponse) {
            ValidateVpaResponse validateVpaResponse = (ValidateVpaResponse) upiBaseDataModel;
            if (!"success".equalsIgnoreCase(validateVpaResponse.getStatus()) || !"0".equalsIgnoreCase(validateVpaResponse.getRespCode())) {
                this.f69188c.a(false, validateVpaResponse.getRespMessage(), validateVpaResponse);
            } else if (!TextUtils.isEmpty(validateVpaResponse.getName())) {
                this.f69188c.a(validateVpaResponse.getName());
                this.f69188c.a(true, "", validateVpaResponse);
                if (!"VERIFIED".equalsIgnoreCase(validateVpaResponse.getSignStatus())) {
                }
            } else {
                this.f69188c.a(false, "", validateVpaResponse);
            }
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        d.b bVar = this.f69188c;
        if (bVar != null) {
            bVar.a(false, (RequestMoneyV2Activity.b) null);
            this.f69188c.a(upiCustomVolleyError);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        d.b bVar = this.f69188c;
        if (bVar != null) {
            bVar.a(accountProvider, this.f69194i);
        }
    }

    public final void a(final UpiProfileDefaultBank upiProfileDefaultBank) {
        this.f69188c.b(true);
        if (upiProfileDefaultBank.getCreditBank().getIfsc().contains("PYTM")) {
            net.one97.paytm.upi.profile.b.b bVar = this.f69189d;
            upiProfileDefaultBank.getCreditBank().getAccount();
            bVar.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    d.this.f69188c.b(false);
                    if (upiBaseDataModel instanceof CJRAccountSummary) {
                        CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                        if (cJRAccountSummary.getStatus() == null || !cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                            d.this.f69188c.a("", "", "");
                            return;
                        }
                        AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                        d.this.f69188c.a(String.valueOf(accountBalanceModel.getTotalBalance()), String.valueOf(accountBalanceModel.getEffectiveBalance()), "");
                        return;
                    }
                    d.this.f69188c.a("", "", "");
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    d.this.f69188c.b(false);
                    d.this.f69188c.a("", "", "");
                }
            });
        } else if (!this.f69186a.a()) {
            this.f69188c.b(false);
            this.f69188c.g();
        } else {
            this.f69190e.d(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    d.this.f69188c.b(false);
                    if (upiBaseDataModel instanceof UpiToken) {
                        d dVar = d.this;
                        String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                        UpiProfileDefaultBank upiProfileDefaultBank = upiProfileDefaultBank;
                        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                        dVar.f69187b.a(upiSequenceNo, "", upiToken, 0, upiProfileDefaultBank.getCreditBank(), new CLRemoteResultReceiver(new RequestMoneyV2Presenter$4(dVar, new Handler(), upiSequenceNo, upiProfileDefaultBank)));
                        return;
                    }
                    d.this.f69188c.a(RequestMoneyV2Activity.a.SOMETHING_WENT_WRONG);
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    d.this.f69188c.b(false);
                    if (upiCustomVolleyError == null || !"1006".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle())) {
                        d.this.f69188c.a(RequestMoneyV2Activity.a.SOMETHING_WENT_WRONG);
                    } else {
                        d.this.f69188c.g();
                    }
                }
            }, "UpiRequestMoneyPresenter", "");
        }
    }

    public final void a(UserUpiDetails userUpiDetails) {
        this.f69189d.a(userUpiDetails, UpiConstants.RefreshAccountOperations.SYNC_MPIN_ACCOUNT, (a.C1382a) new a.C1382a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            }
        }, "UpiRequestMoneyPresenter");
    }

    /* access modifiers changed from: package-private */
    public final void a(List<GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse next : list) {
            if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            }
        }
        this.f69188c.b(true);
        this.f69189d.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    d.this.f69188c.b(false);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                        d.this.f69188c.a("", "", baseUpiResponse.getResponse());
                        return;
                    }
                    try {
                        if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) baseUpiResponse.getMobileAppData();
                            d.this.f69188c.a(upiCheckBalanceModel.getTotalBal(), upiCheckBalanceModel.getAvailableBalance(), "");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    d.this.f69188c.b(false);
                    d.this.f69188c.a("", "", "");
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                d.this.f69188c.b(false);
                d.this.f69188c.a("", "", "");
            }
        }, "UpiRequestMoneyPresenter", "");
    }
}
