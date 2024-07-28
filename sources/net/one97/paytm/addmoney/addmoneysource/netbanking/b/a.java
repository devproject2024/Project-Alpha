package net.one97.paytm.addmoney.addmoneysource.netbanking.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.addmoneysource.netbanking.a.a;
import net.one97.paytm.addmoney.addmoneysource.netbanking.c.b;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a implements a.C0844a, h {

    /* renamed from: a  reason: collision with root package name */
    private final String f48317a = "SourceOtherBankPresenter";

    /* renamed from: b  reason: collision with root package name */
    private a.c f48318b;

    /* renamed from: c  reason: collision with root package name */
    private b f48319c;

    /* renamed from: d  reason: collision with root package name */
    private String f48320d;

    /* renamed from: e  reason: collision with root package name */
    private int f48321e;

    /* renamed from: f  reason: collision with root package name */
    private int f48322f;

    /* renamed from: g  reason: collision with root package name */
    private String f48323g;

    /* renamed from: h  reason: collision with root package name */
    private String f48324h;

    /* renamed from: i  reason: collision with root package name */
    private String f48325i;
    private List<net.one97.paytm.addmoney.common.b> j;
    private double k;
    private net.one97.paytm.addmoney.common.b l;

    public a(a.c cVar, b bVar, int i2, String str, double d2) {
        this.f48318b = cVar;
        this.f48319c = bVar;
        this.f48321e = i2;
        this.f48320d = str;
        this.k = d2;
        this.f48322f = 0;
    }

    public final void a() {
        this.j = g.a().f48982i;
        this.f48318b.a();
    }

    public final void b() {
        this.f48319c.a("SourceOtherBankPresenter");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.f48318b != null) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                String a2 = net.one97.paytm.helper.a.b().a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2)) {
                    a(true);
                    a(false);
                    b bVar = this.f48319c;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.k);
                    bVar.a(this, a2, sb.toString(), this.f48321e, "SourceOtherBankPresenter");
                    return;
                }
                a(false);
                this.f48318b.b();
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                a(false);
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                this.f48323g = cJRRechargePayment.getMID();
                this.f48324h = cJRRechargePayment.getOrderId();
                this.f48325i = cJRRechargePayment.getmTxnToken();
                c.a().f48962e = cJRRechargePayment;
                c.a().a(this.f48323g, this.f48324h, this.f48325i);
                a.c cVar = this.f48318b;
                String str = this.l.f48422d;
                String str2 = this.l.k;
                HashMap hashMap = new HashMap();
                hashMap.put("mid", c.a().f48959b);
                hashMap.put("orderId", c.a().f48960c);
                hashMap.put("channelId", SDKConstants.WAP);
                hashMap.put("txnToken", c.a().f48961d);
                hashMap.put("paymentMode", str);
                hashMap.put("channelCode", str2);
                cVar.a(hashMap);
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f48322f++;
            this.f48318b.a(true);
            return;
        }
        this.f48322f--;
        if (this.f48322f <= 0) {
            this.f48318b.a(false);
            this.f48322f = 0;
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (this.f48318b != null) {
            a(false);
            if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                this.f48318b.a(networkCustomError.getAlertMessage());
            } else {
                this.f48318b.a(networkCustomError);
            }
        }
    }

    public final void a(int i2, a.b bVar) {
        net.one97.paytm.addmoney.common.b bVar2 = this.j.get(i2);
        bVar.a(bVar2.f48425g, bVar2.f48420b);
    }

    public final boolean b(int i2) {
        List<net.one97.paytm.addmoney.common.b> list = this.j;
        if (list == null || list.get(i2).f48427i == null) {
            return false;
        }
        return this.j.get(i2).f48427i.getStatus();
    }

    public final String c(int i2) {
        List<net.one97.paytm.addmoney.common.b> list = this.j;
        if (list == null || list.get(i2).f48427i == null) {
            return null;
        }
        return this.j.get(i2).f48427i.getMsg();
    }

    public final int c() {
        List<net.one97.paytm.addmoney.common.b> list = this.j;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void a(net.one97.paytm.addmoney.common.b bVar) {
        this.l = bVar;
        g();
    }

    public final void a(int i2) {
        this.f48318b.c();
        this.k = this.f48318b.d();
        this.l = this.j.get(i2);
        g();
    }

    private void g() {
        a(true);
        this.f48319c.a((h) this, "SourceOtherBankPresenter");
    }

    public final String d() {
        net.one97.paytm.addmoney.common.b bVar = this.l;
        return bVar != null ? bVar.f48419a : "";
    }

    public final String e() {
        net.one97.paytm.addmoney.common.b bVar = this.l;
        return bVar != null ? bVar.f48420b : "";
    }

    public final String f() {
        net.one97.paytm.addmoney.common.b bVar = this.l;
        return bVar != null ? bVar.f48425g : "";
    }
}
