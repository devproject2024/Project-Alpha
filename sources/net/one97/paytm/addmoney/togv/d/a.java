package net.one97.paytm.addmoney.togv.d;

import android.text.TextUtils;
import com.google.gson.o;
import com.google.gson.q;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.common.model.SendMoneyP2PLimitStatusModel;
import net.one97.paytm.addmoney.common.model.SendMoneyP2PLimitStatusResponseObjectModel;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.togv.b.a;
import net.one97.paytm.addmoney.togv.c.a.b;
import net.one97.paytm.addmoney.utils.b;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.wallet.newdesign.addmoney.model.ConsolidatePaymentInstrumentationRes;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a implements a.C0856a {

    /* renamed from: a  reason: collision with root package name */
    a.b f48708a;

    /* renamed from: b  reason: collision with root package name */
    private final String f48709b = "AddMoneyToGVPresenter";

    /* renamed from: c  reason: collision with root package name */
    private b f48710c;

    public final void a() {
    }

    public a(a.b bVar, b bVar2) {
        this.f48708a = bVar;
        this.f48710c = bVar2;
    }

    public final void b() {
        this.f48710c.a("AddMoneyToGVPresenter");
    }

    public final void a(String str) {
        this.f48708a.a(true);
        this.f48710c.a(new h() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                a.this.f48708a.a(false);
                if (iJRPaytmDataModel instanceof ConsolidatePaymentInstrumentationRes) {
                    ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = (ConsolidatePaymentInstrumentationRes) iJRPaytmDataModel;
                    if (consolidatePaymentInstrumentationRes.getPaymentOptionList() == null || consolidatePaymentInstrumentationRes.getPaymentOptionList().size() <= 0) {
                        a.this.f48708a.a((String) null);
                        return;
                    }
                    for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : consolidatePaymentInstrumentationRes.getPaymentOptionList()) {
                        if (next.getDestinationPayment().getPaymentType().equalsIgnoreCase(b.C0862b.WALLET.name())) {
                            a.b bVar = a.this.f48708a;
                            String displayName = next.getDestinationPayment().getDisplayName();
                            next.getDestinationPayment().getPhoneNumber();
                            bVar.b(displayName);
                            return;
                        }
                    }
                    a.this.f48708a.a((String) null);
                    return;
                }
                a.this.f48708a.a((String) null);
            }

            public final void b(NetworkCustomError networkCustomError) {
                a.this.f48708a.a(false);
                if (networkCustomError == null) {
                    a.this.f48708a.a((String) null);
                    return;
                }
                try {
                    if (!(networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null)) {
                        String str = new String(networkCustomError.networkResponse.data);
                        new q();
                        o oVar = (o) q.a(str);
                        String c2 = oVar.b(CLConstants.FIELD_ERROR_CODE).c();
                        networkCustomError.setmAlertTitle(c2);
                        networkCustomError.setAlertMessage(oVar.b("message").c());
                        if ("BT_INV_435".equalsIgnoreCase(c2)) {
                            networkCustomError.setAlertMessage((String) null);
                        } else if ("BT_ISE_436".equalsIgnoreCase(c2)) {
                            a.this.f48708a.g();
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                "BT_INV_435".equalsIgnoreCase(networkCustomError.getAlertTitle());
                a.this.f48708a.a(networkCustomError.getAlertMessage());
            }
        }, str, "AddMoneyToGVPresenter");
    }

    public final void a(double d2, String str, boolean z) {
        this.f48708a.a(true);
        this.f48710c.a(new h() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                SendMoneyP2PLimitStatusResponseObjectModel response = ((SendMoneyP2PLimitStatusModel) iJRPaytmDataModel).getResponse();
                if (response == null) {
                    a.this.f48708a.a(false);
                    a.this.f48708a.a((String) null, (String) null);
                } else if (response.isLimitApplicable()) {
                    a.this.f48708a.a(false);
                    a.this.f48708a.a((String) null, response.getMessage());
                } else if ("GIFT_VOUCHER".equalsIgnoreCase(response.getAddMoneyDestination())) {
                    a.this.f48708a.f();
                } else {
                    a.this.f48708a.a(false);
                    a.this.f48708a.a((String) null, response.getMessage());
                }
            }

            public final void b(NetworkCustomError networkCustomError) {
                a.this.f48708a.a(false);
                a.this.f48708a.a(networkCustomError.getErrorType().name(), networkCustomError.getAlertMessage());
            }
        }, "AddMoneyToGVPresenter", d2, str, z);
    }

    public final void a(boolean z) {
        double c2 = this.f48708a.c();
        if (Double.compare(c2, 0.0d) != 0) {
            String d2 = this.f48708a.d();
            if (!TextUtils.isEmpty(d2) && d2.length() == 10) {
                this.f48708a.a(true);
                this.f48710c.a(new h() {
                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        a.this.f48708a.a((CJRRechargePayment) iJRPaytmDataModel);
                    }

                    public final void b(NetworkCustomError networkCustomError) {
                        a.this.f48708a.a(false);
                        try {
                            if (!(networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null)) {
                                String str = new String(networkCustomError.networkResponse.data);
                                new q();
                                o oVar = (o) q.a(str);
                                if (oVar != null) {
                                    networkCustomError.setmAlertTitle(oVar.b("error_title").c());
                                    networkCustomError.setAlertMessage(oVar.b("error").c());
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            a.this.f48708a.b("Error", "Some thing Went Wrong.Please try again");
                        }
                        a.this.f48708a.b(networkCustomError.getErrorType().name(), networkCustomError.getAlertMessage());
                    }
                }, "AddMoneyToGVPresenter", (String) null, c2, d2, (String) null, this.f48708a.e(), z);
            }
        }
    }
}
