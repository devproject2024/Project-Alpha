package net.one97.paytm.addmoney.common.c;

import android.text.TextUtils;
import android.view.View;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.addmoney.common.a.a;
import net.one97.paytm.addmoney.common.d.b;
import net.one97.paytm.addmoney.common.model.AccountBalanceModel;
import net.one97.paytm.addmoney.common.model.AccountNameModel;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardDataModel;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.common.model.UAMErrorType;
import net.one97.paytm.addmoney.common.model.UpiUserState;
import net.one97.paytm.addmoney.common.model.WalletLimitsResponseModelAddMoney;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantPayMethod;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantSavedInstruments;
import net.one97.paytm.addmoney.common.paymethodresponse.SavedCard;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.i;
import net.one97.paytm.addmoney.utils.AddMoneyCardView;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusTxnWiseResponse;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileModel;

public final class a implements a.C0849a, h {

    /* renamed from: a  reason: collision with root package name */
    a.c f48441a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<SourceCardDataModel> f48442b;

    /* renamed from: c  reason: collision with root package name */
    int f48443c;

    /* renamed from: d  reason: collision with root package name */
    b f48444d;

    /* renamed from: e  reason: collision with root package name */
    int f48445e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final String f48446f = "AddMoneySourcePresenter";

    /* renamed from: g  reason: collision with root package name */
    private String f48447g;

    /* renamed from: h  reason: collision with root package name */
    private String f48448h;

    /* renamed from: i  reason: collision with root package name */
    private String f48449i;
    private SourceCardType j = SourceCardType.NO_CARD;
    private int k = -1;
    private int l = 0;
    private CustProductList m;
    private String n;
    private int o;
    private double p;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 100.0d;
    private double t = 5000.0d;
    private String u;
    private WalletLimitsResponseModelAddMoney v;
    private boolean w;

    public a(a.c cVar, int i2, b bVar) {
        this.f48441a = cVar;
        this.f48444d = bVar;
        this.f48443c = i2;
        this.p = -1.0d;
        this.v = null;
        this.f48442b = new ArrayList<>();
    }

    public final void b() {
        this.f48441a = null;
        this.f48444d.a(getClass().getName());
    }

    private void r() {
        CustProductList custProductList = this.m;
        if (custProductList != null && "ISSUED".equals(custProductList.getIsaStatus())) {
            p();
            this.f48444d.a(this.m.getIsaAccNum(), "AddMoneySourcePresenter", this);
        }
    }

    public final void m() {
        this.v = null;
    }

    public final void n() {
        this.f48444d.b(this, this.f48441a.m(), this.f48441a.a(), this.f48443c, "AddMoneySourcePresenter");
    }

    public final String e() {
        return this.n;
    }

    public final CustProductList k() {
        return this.m;
    }

    public final void d() {
        p();
        this.f48444d.a((h) this, getClass().getName());
    }

    public final double f() {
        return this.p;
    }

    public final double h() {
        if (Double.compare(this.r, 0.0d) < 0) {
            return -1.0d;
        }
        return j.a(this.p - i());
    }

    public final double i() {
        this.q = 0.0d;
        this.q = j.a(this.p, this.q, this.r);
        return this.q;
    }

    public final double g() {
        return this.r;
    }

    public final int c() {
        return this.f48442b.size();
    }

    public final void a(int i2, a.b bVar) {
        SourceCardDataModel sourceCardDataModel = this.f48442b.get(i2);
        AddMoneyCardView a2 = bVar.a(sourceCardDataModel);
        a2.post(new Runnable(bVar, sourceCardDataModel, i2, a2) {
            private final /* synthetic */ a.b f$1;
            private final /* synthetic */ SourceCardDataModel f$2;
            private final /* synthetic */ int f$3;
            private final /* synthetic */ View f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                a.this.a(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a.b bVar, SourceCardDataModel sourceCardDataModel, int i2, View view) {
        bVar.a(sourceCardDataModel.getType().getNumVal());
        if (i2 == v()) {
            bVar.a(this.r);
        } else {
            bVar.a(0.0d);
        }
        boolean isOpenInInnerContainer = sourceCardDataModel.isOpenInInnerContainer();
        if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
            isOpenInInnerContainer = true;
        }
        bVar.a(sourceCardDataModel, isOpenInInnerContainer, view);
    }

    public final void a(int i2) {
        if (this.l > 0) {
            this.f48441a.b(UAMErrorType.PLEASE_WAIT);
            return;
        }
        SourceCardDataModel sourceCardDataModel = null;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f48442b.size()) {
                i3 = 0;
                break;
            }
            sourceCardDataModel = this.f48442b.get(i3);
            if (sourceCardDataModel.getType().getNumVal() == i2) {
                break;
            }
            i3++;
        }
        String a2 = this.f48441a.a();
        if (sourceCardDataModel.getType() != SourceCardType.OTHER_BANKS) {
            if (TextUtils.isEmpty(a2) || a2.trim().equals("0")) {
                this.f48441a.a(UAMErrorType.AMOUNTNULL);
                if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                    this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
                    return;
                }
                return;
            }
            try {
                this.f48441a.d();
            } catch (NumberFormatException unused) {
                this.f48441a.a(UAMErrorType.VALID_AMOUNT);
                if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                    this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
                    return;
                }
                return;
            }
        }
        if (!this.f48441a.g()) {
            this.f48441a.h();
            if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
                return;
            }
            return;
        }
        this.o = i3;
        if (sourceCardDataModel.getType() == SourceCardType.DEBIT_CARD) {
            try {
                double parseDouble = Double.parseDouble(a2);
                double p2 = this.f48441a.p();
                if (Double.compare(parseDouble, p2) > 0) {
                    this.f48441a.a("", String.valueOf(p2), sourceCardDataModel);
                } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    s();
                } else {
                    s();
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                this.f48441a.a(UAMErrorType.INVALID_AMOUNT);
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.CREDIT_CARD) {
            if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                s();
            } else {
                s();
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.OTHER_BANKS) {
            if (this.m == null) {
                d();
            } else {
                s();
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.WALLET) {
            try {
                double parseDouble2 = Double.parseDouble(a2);
                if (Double.compare(parseDouble2, this.t) > 0) {
                    a.c cVar = this.f48441a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.t);
                    cVar.a(sb.toString(), "", sourceCardDataModel);
                    return;
                }
                if (Double.compare(parseDouble2, this.s) >= 0) {
                    if (Double.compare(parseDouble2, this.t) <= 0) {
                        if (Double.compare(0.0d, h()) == 0) {
                            this.f48441a.a(UAMErrorType.INSUFFICIENT_BALANCE);
                            return;
                        } else if (Double.compare(parseDouble2, h()) > 0) {
                            this.f48441a.a(UAMErrorType.INSUFFICIENT_BALANCE);
                            return;
                        } else {
                            s();
                            return;
                        }
                    }
                }
                a.c cVar2 = this.f48441a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.s);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.t);
                cVar2.a(sb3, sb4.toString(), sourceCardDataModel);
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
                this.f48441a.a(UAMErrorType.INVALID_AMOUNT);
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.BHIM_UPI) {
            try {
                double parseDouble3 = Double.parseDouble(a2);
                if (Double.compare(parseDouble3, this.f48441a.f()) > 0) {
                    a.c cVar3 = this.f48441a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f48441a.f());
                    cVar3.a("", sb5.toString(), sourceCardDataModel);
                    return;
                }
                if (Double.compare(parseDouble3, this.f48441a.e()) >= 0) {
                    if (Double.compare(parseDouble3, this.f48441a.f()) <= 0) {
                        if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                            s();
                            return;
                        } else {
                            s();
                            return;
                        }
                    }
                }
                a.c cVar4 = this.f48441a;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.f48441a.e());
                String sb7 = sb6.toString();
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.f48441a.f());
                cVar4.a(sb7, sb8.toString(), sourceCardDataModel);
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
                this.f48441a.a(UAMErrorType.INVALID_AMOUNT);
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.NET_BANKING) {
            if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                s();
            } else {
                s();
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.PPB) {
            if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                s();
            } else {
                s();
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI) {
            try {
                double parseDouble4 = Double.parseDouble(a2);
                if (Double.compare(parseDouble4, this.f48441a.f()) > 0) {
                    a.c cVar5 = this.f48441a;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(this.f48441a.f());
                    cVar5.a("", sb9.toString(), sourceCardDataModel);
                    this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
                    return;
                }
                if (Double.compare(parseDouble4, this.f48441a.e()) >= 0) {
                    if (Double.compare(parseDouble4, this.f48441a.f()) <= 0) {
                        if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                            s();
                            this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                            return;
                        }
                        s();
                        this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                        return;
                    }
                }
                a.c cVar6 = this.f48441a;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(this.f48441a.e());
                String sb11 = sb10.toString();
                StringBuilder sb12 = new StringBuilder();
                sb12.append(this.f48441a.f());
                cVar6.a(sb11, sb12.toString(), sourceCardDataModel);
                this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
            } catch (NumberFormatException e5) {
                e5.printStackTrace();
                this.f48441a.a(UAMErrorType.INVALID_AMOUNT);
                this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC) {
            try {
                double parseDouble5 = Double.parseDouble(a2);
                double p3 = this.f48441a.p();
                if (Double.compare(parseDouble5, p3) > 0) {
                    this.f48441a.a("", String.valueOf(p3), sourceCardDataModel);
                    this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
                } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    s();
                    this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                } else {
                    s();
                    this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                }
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
                this.f48441a.a(UAMErrorType.INVALID_AMOUNT);
                this.f48441a.a(false, sourceCardDataModel.getType().getNumVal());
            }
        } else if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
            if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                s();
                this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                return;
            }
            s();
            this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
        } else if (sourceCardDataModel.getType() == SourceCardType.FD) {
            this.f48441a.c("paytmmp://payment_bank?featuretype=redeem_fd&amount_to_redeem=".concat(String.valueOf(this.f48441a.d())));
        } else {
            PaymentDestinationType.TO_WALLET.getNumVal();
            s();
        }
    }

    private void s() {
        for (int i2 = 0; i2 < this.f48442b.size(); i2++) {
            SourceCardDataModel sourceCardDataModel = this.f48442b.get(i2);
            if (!(i2 == this.o || !sourceCardDataModel.isOpenInInnerContainer() || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC)) {
                sourceCardDataModel.setOpenInInnerContainer(false);
                this.f48441a.a(i2);
            }
        }
        SourceCardDataModel sourceCardDataModel2 = this.f48442b.get(this.o);
        if (!(sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC)) {
            sourceCardDataModel2.setOpenInInnerContainer(!sourceCardDataModel2.isOpenInInnerContainer());
            this.f48441a.a(this.o);
        }
        if (this.o + 1 <= this.f48442b.size() - 1) {
            this.f48441a.b(this.o + 1);
        } else {
            this.f48441a.b(this.o);
        }
        try {
            ((net.one97.paytm.addmoney.common.view.a) this.f48441a).d(this.f48442b.get(this.o).getType().getNumVal());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void l() {
        int i2;
        if (this.o != -1 && this.f48442b.size() > 0 && this.f48442b.size() >= (i2 = this.o)) {
            SourceCardDataModel sourceCardDataModel = this.f48442b.get(i2);
            if (sourceCardDataModel.getType() != SourceCardType.PAYMENT_ITEM_TYPE_UPI && sourceCardDataModel.getType() != SourceCardType.PAYMENT_ITEM_TYPE_DC && sourceCardDataModel.getType() != SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                sourceCardDataModel.setOpenInInnerContainer(false);
                this.f48441a.a(this.o);
                this.o = -1;
            }
        }
    }

    private void t() {
        int i2 = 0;
        SourceCardDataModel sourceCardDataModel = null;
        while (i2 < this.f48442b.size()) {
            sourceCardDataModel = this.f48442b.get(i2);
            if (sourceCardDataModel.getType() == SourceCardType.FD) {
                break;
            }
            i2++;
        }
        if (sourceCardDataModel != null && (sourceCardDataModel.getDataModel() instanceof AccountBalanceModel)) {
            ((AccountBalanceModel) sourceCardDataModel.getDataModel()).setmSlfdBalance(c.a().j.doubleValue());
            this.f48441a.a(i2);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.f48441a != null) {
            q();
            if (iJRPaytmDataModel instanceof CustProductList) {
                this.m = (CustProductList) iJRPaytmDataModel;
                c.a().f48963f = this.m;
                r();
            } else if (iJRPaytmDataModel instanceof AccountNameModel) {
                this.n = ((AccountNameModel) iJRPaytmDataModel).getName();
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                String a2 = net.one97.paytm.helper.a.b().a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2)) {
                    p();
                    this.f48444d.a((h) this, a2, this.f48441a.a(), this.f48443c, "AddMoneySourcePresenter");
                    return;
                }
                this.f48441a.c();
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                this.f48447g = cJRRechargePayment.getMID();
                this.f48448h = cJRRechargePayment.getOrderId();
                this.f48449i = cJRRechargePayment.getmTxnToken();
                c.a().f48962e = cJRRechargePayment;
                c.a().a(this.f48447g, this.f48448h, this.f48449i);
            } else {
                boolean z = true;
                if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                    CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                    if (cJRRechargeCart.getCartStatus().getResult().equalsIgnoreCase("SUCCESS")) {
                        if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || TextUtils.isEmpty(cJRRechargeCart.getCart().getErrorCode()))) {
                            String errorCode = cJRRechargeCart.getCart().getErrorCode();
                            if (errorCode.equalsIgnoreCase("RWL_1000") || errorCode.equalsIgnoreCase("RWL_0003") || errorCode.equalsIgnoreCase("RWL_1001")) {
                                String errorInfo = cJRRechargeCart.getCart().getErrorInfo();
                                String error = cJRRechargeCart.getCart().getError();
                                a.c cVar = this.f48441a;
                                if (cVar != null) {
                                    cVar.a(errorInfo, error);
                                }
                                if (!z && !this.f48441a.a(cJRRechargeCart)) {
                                    this.f48441a.a(cJRRechargeCart.getCart());
                                    return;
                                }
                            }
                        }
                        z = false;
                        this.f48441a.a(cJRRechargeCart.getCart());
                        return;
                    }
                    this.f48441a.q();
                } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
                    CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                    if (cJRCashWallet.getResponse() != null) {
                        this.p = cJRCashWallet.getResponse().getPaytmWalletBalance();
                        if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                            this.f48441a.a(v());
                        } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                            a.c cVar2 = this.f48441a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.p);
                            cVar2.b(sb.toString());
                        }
                    }
                } else if (iJRPaytmDataModel instanceof CJRP2BStatus) {
                    CJRP2BStatus cJRP2BStatus = (CJRP2BStatus) iJRPaytmDataModel;
                    if (cJRP2BStatus != null && cJRP2BStatus.getResponse() != null && cJRP2BStatus.getResponse().getStatusTxnWiseResponse() != null) {
                        CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = cJRP2BStatus.getResponse().getStatusTxnWiseResponse();
                        try {
                            if (!TextUtils.isEmpty(statusTxnWiseResponse.getMinTxnAmount())) {
                                this.s = Double.parseDouble(statusTxnWiseResponse.getMinTxnAmount());
                            }
                            if (!TextUtils.isEmpty(statusTxnWiseResponse.getMaxTxnAmount())) {
                                this.t = Double.parseDouble(statusTxnWiseResponse.getMaxTxnAmount());
                            }
                            if (!TextUtils.isEmpty(statusTxnWiseResponse.getFixedCommission())) {
                                this.q = Double.parseDouble(statusTxnWiseResponse.getFixedCommission());
                            }
                            if (!TextUtils.isEmpty(statusTxnWiseResponse.getFloatCommission())) {
                                this.r = Double.parseDouble(statusTxnWiseResponse.getFloatCommission());
                            }
                            this.f48441a.a(v());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (iJRPaytmDataModel instanceof CJPayMethodResponse) {
                    CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) iJRPaytmDataModel;
                    this.f48441a.a(cJPayMethodResponse);
                    u();
                    if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                        a(this.f48441a.l(), cJPayMethodResponse);
                    } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                        a(this.f48441a.k(), cJPayMethodResponse);
                    }
                } else if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                    CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) iJRPaytmDataModel;
                    if (cJRAccountSummary != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                        if (Double.compare(c.a().j.doubleValue(), Double.MIN_VALUE) == 0) {
                            c.a().j = Double.valueOf(cJRAccountSummary.getSlfdBalance());
                            t();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance());
                        this.u = sb2.toString();
                        if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                            this.f48441a.b(this.u);
                        }
                    }
                } else if (iJRPaytmDataModel instanceof WalletLimitsResponseModelAddMoney) {
                    this.v = (WalletLimitsResponseModelAddMoney) iJRPaytmDataModel;
                    WalletLimitsResponseModelAddMoney walletLimitsResponseModelAddMoney = this.v;
                    if (walletLimitsResponseModelAddMoney != null && walletLimitsResponseModelAddMoney.getResponse() != null) {
                        if (!this.v.getResponse().getIsLimitApplicable().booleanValue()) {
                            s();
                            int i2 = this.o;
                            if (i2 >= 0 && i2 < this.f48442b.size()) {
                                SourceCardDataModel sourceCardDataModel = this.f48442b.get(this.o);
                                if (sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                                    this.f48441a.a(true, sourceCardDataModel.getType().getNumVal());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String message = this.v.getResponse().getMessage();
                        if (this.v.getResponse().getDeepLink() == null || this.v.getResponse().getLabel() == null) {
                            this.f48441a.a(message);
                        } else {
                            this.f48441a.a(message, this.v.getResponse().getDeepLink(), this.v.getResponse().getLabel());
                        }
                        int i3 = this.o;
                        if (i3 >= 0 && i3 < this.f48442b.size()) {
                            SourceCardDataModel sourceCardDataModel2 = this.f48442b.get(this.o);
                            if (sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI || sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC || sourceCardDataModel2.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                                this.f48441a.a(false, sourceCardDataModel2.getType().getNumVal());
                            }
                        }
                        this.f48441a.a(UAMErrorType.WALLET_LIMIT_BREACH);
                    }
                } else {
                    this.f48441a.a(false);
                }
            }
        }
    }

    private void u() {
        MerchantSavedInstruments merchantSavedMethods = g.a().getMerchantSavedMethods();
        if (merchantSavedMethods != null) {
            new ArrayList();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (SavedCard next : merchantSavedMethods.getSavedCards()) {
                if (SDKConstants.DEBIT.equalsIgnoreCase(next.getPayMethod())) {
                    z2 = true;
                } else if (SDKConstants.CREDIT.equalsIgnoreCase(next.getPayMethod())) {
                    z3 = true;
                }
            }
            if (z2) {
                if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    if (net.one97.paytm.helper.a.b().g("addMoneyPPBLViaDebitCardEnabled")) {
                        net.one97.paytm.helper.a.b();
                        SourceCardDataModel sourceCardDataModel = new SourceCardDataModel((IJRDataModel) null, SourceCardType.PAYMENT_ITEM_TYPE_DC);
                        sourceCardDataModel.setOpenInInnerContainer(true);
                        this.f48442b.add(sourceCardDataModel);
                    }
                } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    SourceCardDataModel sourceCardDataModel2 = new SourceCardDataModel((IJRDataModel) null, SourceCardType.PAYMENT_ITEM_TYPE_DC);
                    sourceCardDataModel2.setOpenInInnerContainer(true);
                    this.f48442b.add(sourceCardDataModel2);
                }
            }
            if (this.f48443c != PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                z = z3;
            }
            if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal() && net.one97.paytm.helper.a.b().g("addMoneyPPBFDEnabled") && "ISSUED".equalsIgnoreCase(c.a().f48966i)) {
                this.w = true;
            }
            if (z) {
                SourceCardDataModel sourceCardDataModel3 = new SourceCardDataModel((IJRDataModel) null, SourceCardType.PAYMENT_ITEM_TYPE_CC);
                sourceCardDataModel3.setOpenInInnerContainer(true);
                this.f48442b.add(sourceCardDataModel3);
            }
        }
    }

    private void a(String str, CJPayMethodResponse cJPayMethodResponse) {
        CustProductList custProductList;
        if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            if (!k.b() && net.one97.paytm.helper.a.b().g("addMoneyPPBLViaWalletEnabled")) {
                this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.WALLET));
            }
            if (net.one97.paytm.helper.a.b().g("addMoneyPPBFDEnabled") && this.w && !g.a().l) {
                AccountBalanceModel accountBalanceModel = new AccountBalanceModel();
                accountBalanceModel.setmSlfdBalance(c.a().j.doubleValue());
                accountBalanceModel.setStatus(c.a().f48966i);
                this.f48442b.add(new SourceCardDataModel(accountBalanceModel, SourceCardType.FD));
            }
            if (net.one97.paytm.helper.a.b().g("addMoneyPPBLViaDebitCardEnabled")) {
                net.one97.paytm.helper.a.b();
                this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.DEBIT_CARD));
            }
            if (net.one97.paytm.helper.a.b().g("addMoneyPPBLOtherBankEnabled")) {
                this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.OTHER_BANKS));
            }
            this.f48441a.n();
        } else if (this.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
            String[] split = str.split("\\s*,\\s*");
            List<MerchantPayMethod> merchantPayMethods = cJPayMethodResponse.getCjrPayMethods().getPayMethodViews().getMerchantPayMethods();
            for (String str2 : split) {
                for (MerchantPayMethod payMethod : merchantPayMethods) {
                    if (str2.trim().equalsIgnoreCase(payMethod.getPayMethod().trim())) {
                        String trim = str2.trim();
                        if (trim.equalsIgnoreCase(SDKConstants.DEBIT)) {
                            this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.DEBIT_CARD));
                        } else if (trim.equalsIgnoreCase(SDKConstants.CREDIT)) {
                            this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.CREDIT_CARD));
                        } else if (trim.equalsIgnoreCase("NET_BANKING")) {
                            this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.NET_BANKING));
                        } else if (trim.equalsIgnoreCase("UPI")) {
                            this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.BHIM_UPI));
                        } else if (trim.equalsIgnoreCase("NET_BANKING_PPBL") && (custProductList = this.m) != null && "ISSUED".equals(custProductList.getIsaStatus())) {
                            this.f48442b.add(new SourceCardDataModel((IJRDataModel) null, SourceCardType.PPB));
                        }
                    }
                }
            }
            this.f48441a.n();
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (this.f48441a != null) {
            q();
            this.f48441a.b();
            if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                this.f48441a.b(networkCustomError);
                if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getUrl())) {
                    if (networkCustomError.getUrl().contains("checkUserBalance")) {
                        this.f48441a.a(v());
                    } else if (networkCustomError.getUrl().contains("txnValidation")) {
                        this.f48441a.a(v());
                    }
                }
                this.f48441a.a(false);
                return;
            }
            this.f48441a.a(networkCustomError);
        }
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        this.l++;
        this.f48441a.o();
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        this.l--;
        if (this.l <= 0) {
            this.f48441a.a(false);
            this.l = 0;
        }
    }

    private int v() {
        for (int i2 = 0; i2 < this.f48442b.size(); i2++) {
            if (this.f48442b.get(i2).getType().getNumVal() == SourceCardType.WALLET.getNumVal()) {
                return i2;
            }
        }
        return -1;
    }

    public final String j() {
        return this.u;
    }

    public final String o() {
        CustProductList custProductList = this.m;
        if (custProductList != null) {
            return custProductList.getIsaAccNum();
        }
        return null;
    }

    public final void a() {
        p();
        this.f48444d.a(this.f48441a.i(), this.f48441a.j(), "AddMoneySourcePresenter", this);
        this.m = c.a().f48963f;
        if (this.m == null) {
            d();
        } else if (c.a().f48965h == null) {
            r();
        } else {
            this.u = c.a().f48965h;
            this.f48441a.b(this.u);
        }
        if (!k.b()) {
            this.f48444d.b((i) new i() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    a.this.q();
                    if (((UpiAvailabilityModel) upiBaseDataModel).getResponse().isUpiUser()) {
                        a aVar = a.this;
                        aVar.p();
                        aVar.f48444d.a((i) new i() {
                            public final void a(UpiBaseDataModel upiBaseDataModel) {
                                boolean z;
                                a.this.q();
                                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                                if ("success".equalsIgnoreCase(upiProfileModel.getStatus()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                                    a aVar = a.this;
                                    if (aVar.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                                        Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                if (!it2.next().getIfsc().startsWith("PYTM")) {
                                                    z = true;
                                                    break;
                                                }
                                            } else {
                                                z = false;
                                                break;
                                            }
                                        }
                                        if (!z || !net.one97.paytm.helper.a.b().g("addMoneyPPBUPIEnabled")) {
                                            aVar.f48445e = UpiUserState.NO_ACCOUNT_LINKED.getNumVal();
                                            return;
                                        }
                                        aVar.f48445e = UpiUserState.VALID_UPI_USER.getNumVal();
                                        if (!k.b()) {
                                            net.one97.paytm.helper.a.b();
                                            SourceCardDataModel sourceCardDataModel = new SourceCardDataModel((IJRDataModel) null, SourceCardType.PAYMENT_ITEM_TYPE_UPI);
                                            sourceCardDataModel.setOpenInInnerContainer(true);
                                            aVar.f48442b.add(0, sourceCardDataModel);
                                            aVar.f48441a.n();
                                        }
                                    } else if (aVar.f48443c == PaymentDestinationType.TO_WALLET.getNumVal()) {
                                        aVar.f48445e = UpiUserState.VALID_UPI_USER.getNumVal();
                                        SourceCardDataModel sourceCardDataModel2 = new SourceCardDataModel((IJRDataModel) null, SourceCardType.PAYMENT_ITEM_TYPE_UPI);
                                        sourceCardDataModel2.setOpenInInnerContainer(true);
                                        aVar.f48442b.add(0, sourceCardDataModel2);
                                        aVar.f48441a.n();
                                    }
                                }
                            }

                            public final void a(NetworkCustomError networkCustomError) {
                                if (a.this.f48441a != null) {
                                    a.this.q();
                                    a.this.f48441a.b();
                                    if (TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                                        a.this.f48441a.b(new NetworkCustomError(networkCustomError.networkResponse, networkCustomError.toString()));
                                        a.this.f48441a.a(false);
                                        return;
                                    }
                                    a.this.f48441a.a(new NetworkCustomError());
                                }
                            }
                        }, aVar.getClass().getName());
                        return;
                    }
                    a.this.f48445e = UpiUserState.NO_UPI_USER.getNumVal();
                }

                public final void a(NetworkCustomError networkCustomError) {
                    if (a.this.f48441a != null) {
                        a.this.q();
                        a.this.f48441a.b();
                        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                            a.this.f48441a.b(new NetworkCustomError(networkCustomError.networkResponse, networkCustomError.toString()));
                            a.this.f48441a.a(false);
                            return;
                        }
                        a.this.f48441a.a(new NetworkCustomError());
                    }
                }
            }, getClass().getName());
            p();
            this.f48444d.c(this, "AddMoneySourcePresenter");
        }
        p();
        this.f48444d.b((h) this, "AddMoneySourcePresenter");
        if (this.f48443c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal() && !k.b()) {
            CustProductList custProductList = this.m;
            String isaIfsc = (custProductList == null || TextUtils.isEmpty(custProductList.getIsaIfsc())) ? "PYTM0123456" : this.m.getIsaIfsc();
            CustProductList custProductList2 = this.m;
            String isaAccNum = (custProductList2 == null || TextUtils.isEmpty(custProductList2.getIsaAccNum())) ? "" : this.m.getIsaAccNum();
            p();
            this.f48444d.a(isaIfsc, isaAccNum, "", (h) this, "AddMoneySourcePresenter");
        }
    }
}
