package net.one97.paytm.addmoney.togv.d;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.togv.b.b;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.helper.a;

public final class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    b.C0857b f48714a;

    /* renamed from: b  reason: collision with root package name */
    private final String f48715b = "AddMoneyToGvStatusPresenter";

    /* renamed from: c  reason: collision with root package name */
    private String f48716c;

    /* renamed from: d  reason: collision with root package name */
    private String f48717d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.addmoney.togv.c.a.b f48718e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f48719f;

    public b(b.C0857b bVar, net.one97.paytm.addmoney.togv.c.a.b bVar2, String str, String str2, boolean z) {
        this.f48716c = str;
        this.f48717d = str2;
        this.f48714a = bVar;
        this.f48718e = bVar2;
        this.f48719f = z;
    }

    public final void b() {
        this.f48718e.a("AddMoneyToGvStatusPresenter");
    }

    public final void a() {
        this.f48714a.a(true);
        this.f48718e.a(new h() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                CJROrderSummaryPayment cJROrderSummaryPayment;
                CJRAttributes attributes;
                b.this.f48714a.a(false);
                CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
                CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
                CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
                if (productDetail == null || (attributes = productDetail.getAttributes()) == null) {
                    str = "";
                } else {
                    str = attributes.getRedemptionPointPrice();
                }
                int orderStatus = cJROrderSummary.getOrderStatus();
                String itemStatus = cJROrderedCart.getItemStatus();
                double totalPrice = cJROrderedCart.getTotalPrice();
                String id = cJROrderSummary.getId();
                String str7 = null;
                if (cJROrderedCart.getFullFillmentOject() != null) {
                    try {
                        str7 = cJROrderedCart.getFullFillmentOject().getPpiDetailsId();
                        cJROrderedCart.getFullFillmentOject().getBalance();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str7)) {
                    AddMoneyUtils.c(cJROrderSummary.getCreatedAt());
                }
                String b2 = AddMoneyUtils.b(cJROrderSummary.getCreatedAt());
                if (cJROrderedCart.getRechargeConfiguration() != null) {
                    cJROrderedCart.getRechargeConfiguration().get(CJRQRScanResultModel.KEY_COMMENT_SMALL);
                    str3 = cJROrderedCart.getRechargeConfiguration().get("name");
                    str2 = cJROrderedCart.getRechargeConfiguration().get("targetMobile");
                } else {
                    str3 = "";
                    str2 = str3;
                }
                if (cJROrderSummary.getPaymentInfo() == null || cJROrderSummary.getPaymentInfo().size() <= 0 || (cJROrderSummaryPayment = cJROrderSummary.getPaymentInfo().get(0)) == null) {
                    str6 = "";
                    str5 = str6;
                    str4 = str5;
                } else {
                    String bankTransactionId = cJROrderSummaryPayment.getBankTransactionId();
                    String paymentBank = cJROrderSummaryPayment.getPaymentBank();
                    str5 = cJROrderSummaryPayment.getPaymentMethod();
                    str6 = paymentBank;
                    str4 = bankTransactionId;
                }
                String paymentText = cJROrderSummary.getPaymentText();
                if (orderStatus == 2) {
                    if ("2,5,15".contains(itemStatus)) {
                        b.this.f48714a.a(totalPrice, id, b2, str3, str2, str6, str5, str4);
                    } else if ("7,20".contains(itemStatus)) {
                        b.this.f48714a.a(str, totalPrice, id, b2, str3, str2, str6, str5, str4);
                    } else if ("6,8,18".contains(itemStatus)) {
                        b.this.f48714a.a(totalPrice, id, b2, str3, str2, str6, str5, str4, b.this.f48714a.c());
                    } else {
                        b.this.f48714a.a(totalPrice, id, b2, str3, str2, str6, str5, str4, paymentText);
                    }
                } else if (orderStatus == 1 || orderStatus == 3) {
                    b.this.f48714a.b(totalPrice, id, b2, str3, str2, str6, str5, str4, paymentText);
                } else if (orderStatus == 4 || orderStatus == 8 || orderStatus == 5) {
                    b.this.f48714a.a(totalPrice, id, b2, str3, str2, str6, str5, str4, paymentText);
                } else {
                    b.this.f48714a.b(totalPrice, id, b2, str3, str2, str6, str5, str4, paymentText);
                }
                b.this.f48718e.a((h) new h() {
                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                        if (cJRCashWallet.getResponse() != null) {
                            j.d(a.b().j(), j.b(cJRCashWallet.getResponse()));
                            b.this.f48714a.a(j.a(cJRCashWallet.getResponse()));
                        }
                    }

                    public final void b(NetworkCustomError networkCustomError) {
                        b.this.f48714a.a(-1.0d);
                    }
                }, "AddMoneyToGvStatusPresenter");
            }

            public final void b(NetworkCustomError networkCustomError) {
                b.this.f48714a.a(false);
                b.this.f48718e.a((h) new h() {
                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                        if (cJRCashWallet.getResponse() != null) {
                            j.d(a.b().j(), j.b(cJRCashWallet.getResponse()));
                            b.this.f48714a.a(j.a(cJRCashWallet.getResponse()));
                        }
                    }

                    public final void b(NetworkCustomError networkCustomError) {
                        b.this.f48714a.a(-1.0d);
                    }
                }, "AddMoneyToGvStatusPresenter");
            }
        }, "AddMoneyToGvStatusPresenter", this.f48716c, this.f48719f);
    }
}
