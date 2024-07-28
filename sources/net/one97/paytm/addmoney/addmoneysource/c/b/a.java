package net.one97.paytm.addmoney.addmoneysource.c.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.addmoney.addmoneysource.c.a.a;
import net.one97.paytm.addmoney.addmoneysource.c.c.b;
import net.one97.paytm.addmoney.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class a implements a.C0841a, h {

    /* renamed from: a  reason: collision with root package name */
    private a.b f48205a;

    /* renamed from: b  reason: collision with root package name */
    private int f48206b;

    /* renamed from: c  reason: collision with root package name */
    private b f48207c;

    /* renamed from: d  reason: collision with root package name */
    private String f48208d;

    /* renamed from: e  reason: collision with root package name */
    private String f48209e;

    /* renamed from: f  reason: collision with root package name */
    private String f48210f;

    /* renamed from: g  reason: collision with root package name */
    private double f48211g;

    /* renamed from: h  reason: collision with root package name */
    private String f48212h;

    /* renamed from: i  reason: collision with root package name */
    private String f48213i;

    public final void a() {
    }

    public final void b() {
    }

    public a(a.b bVar, b bVar2, int i2, double d2) {
        this.f48205a = bVar;
        this.f48206b = i2;
        this.f48207c = bVar2;
        this.f48211g = d2;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f48205a.d();
        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            this.f48212h = net.one97.paytm.helper.a.b().a((CJRPGTokenList) iJRPaytmDataModel);
            if (!TextUtils.isEmpty(this.f48212h)) {
                this.f48207c.a(this, this.f48212h, Double.toString(this.f48211g), this.f48206b, "SourcePPBPresenter");
                return;
            }
            this.f48205a.d();
            this.f48205a.e();
        } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
            this.f48205a.c();
            CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
            this.f48208d = cJRRechargePayment.getMID();
            this.f48210f = cJRRechargePayment.getOrderId();
            this.f48209e = cJRRechargePayment.getmTxnToken();
            c.a().f48962e = cJRRechargePayment;
            c.a().a(this.f48208d, this.f48210f, this.f48209e);
            String mid = cJRRechargePayment.getMID();
            String orderId = cJRRechargePayment.getOrderId();
            String str = cJRRechargePayment.getmTxnToken();
            String str2 = this.f48213i;
            HashMap hashMap = new HashMap();
            hashMap.put("mid", mid);
            hashMap.put("orderId", orderId);
            hashMap.put("channelId", SDKConstants.WAP);
            hashMap.put("txnToken", str);
            hashMap.put("paymentMode", SDKConstants.AI_KEY_PPBL);
            hashMap.put(PayUtility.MPIN, str2);
            this.f48205a.a(hashMap);
        } else if (iJRPaytmDataModel instanceof CJRRechargeCart) {
            this.f48207c.a((h) this, "SourcePPBPresenter");
        } else if (iJRPaytmDataModel instanceof CJRVerifyPasscodeResponse) {
            CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) iJRPaytmDataModel;
            if (cJRVerifyPasscodeResponse.getError() == null) {
                this.f48205a.b();
                this.f48213i = cJRVerifyPasscodeResponse.getAccessToken();
                this.f48205a.c();
                this.f48207c.a((h) this, "SourcePPBPresenter");
                return;
            }
            this.f48205a.a(cJRVerifyPasscodeResponse.getErrorDescription());
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        this.f48205a.d();
        if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
            this.f48205a.a(networkCustomError.getAlertMessage());
        } else {
            this.f48205a.a(networkCustomError);
        }
    }

    public final void c() {
        this.f48205a.a();
    }

    public final void a(String str) {
        this.f48211g = this.f48205a.f();
        this.f48205a.b();
        this.f48205a.c();
        this.f48207c.a(str, this, "SourcePPBPresenter");
    }
}
