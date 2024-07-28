package net.one97.paytm.p2b.c;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Iterator;
import net.one97.paytm.P2B.P2bLimitStatusModel;
import net.one97.paytm.P2B.SendMoneyP2PLimitStatusResponseObjectModel;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusTxnWiseResponse;
import net.one97.paytm.p2b.a.d;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.a.a;

public class c implements d.a, a.C0169a {

    /* renamed from: a  reason: collision with root package name */
    a f56899a;

    /* renamed from: b  reason: collision with root package name */
    boolean f56900b;

    /* renamed from: c  reason: collision with root package name */
    String f56901c = c.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d.b f56902d;

    /* renamed from: e  reason: collision with root package name */
    private CJRP2BStatus f56903e;

    /* renamed from: f  reason: collision with root package name */
    private double f56904f;

    /* renamed from: g  reason: collision with root package name */
    private double f56905g;

    /* renamed from: h  reason: collision with root package name */
    private double f56906h;

    /* renamed from: i  reason: collision with root package name */
    private double f56907i;
    private double j;
    private double k;
    private double l;

    public c(d.b bVar, a aVar, boolean z, String str) {
        this.f56902d = bVar;
        this.f56899a = aVar;
        this.f56900b = z;
        this.f56901c = str;
    }

    public final void c(String str) {
        this.f56902d.a();
        this.f56899a.a(this, (String) null, str, (String) null, this.f56900b, this.f56901c);
    }

    public final void a() {
        a aVar = this.f56899a;
        if (aVar != null) {
            aVar.a(this.f56901c);
        }
    }

    public final String a(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "") : str;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.j = Double.parseDouble(a(str));
                this.k = this.f56907i;
                this.l = k.b(this.j, this.k);
            } catch (NumberFormatException unused) {
            }
        }
    }

    private boolean e(String str) {
        try {
            if (TextUtils.isEmpty(str) || !g()) {
                return false;
            }
            double parseDouble = Double.parseDouble(str);
            if (this.f56905g <= 0.0d) {
                return true;
            }
            if (parseDouble < this.f56904f || parseDouble > this.f56905g) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean d(String str) {
        if (e(str)) {
            return true;
        }
        d.b bVar = this.f56902d;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56904f);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f56905g);
        bVar.a(sb2, sb3.toString());
        return false;
    }

    public final double f() {
        return this.f56906h;
    }

    public final boolean g() {
        return this.f56903e != null;
    }

    public final void h() {
        this.f56902d.a();
        new a.C0169a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                boolean z;
                c.this.f56902d.b();
                P2bLimitStatusModel p2bLimitStatusModel = (P2bLimitStatusModel) iJRPaytmDataModel;
                if (p2bLimitStatusModel == null || p2bLimitStatusModel.getResponse() == null) {
                    c.this.f56902d.b((String) null);
                    return;
                }
                Iterator<SendMoneyP2PLimitStatusResponseObjectModel> it2 = p2bLimitStatusModel.getResponse().iterator();
                String str = null;
                loop0:
                while (true) {
                    z = false;
                    while (true) {
                        if (!it2.hasNext()) {
                            break loop0;
                        }
                        SendMoneyP2PLimitStatusResponseObjectModel next = it2.next();
                        if (next.isLimitApplicable()) {
                            str = next.getMessage();
                        }
                        if (z || next.isLimitApplicable()) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    c.this.f56902d.b(str);
                } else {
                    c.this.f56902d.d();
                }
            }

            public final void a(NetworkCustomError networkCustomError) {
                c.this.f56902d.b();
                c.this.f56902d.b((String) null);
            }
        };
    }

    public final double b() {
        return this.j;
    }

    public final double c() {
        return this.k;
    }

    public final double d() {
        return this.l;
    }

    public final double e() {
        return this.f56907i;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z;
        this.f56902d.b();
        if (iJRPaytmDataModel instanceof CJRP2BStatus) {
            this.f56903e = (CJRP2BStatus) iJRPaytmDataModel;
            CJRP2BStatus cJRP2BStatus = this.f56903e;
            if (cJRP2BStatus == null || cJRP2BStatus.getResponse() == null || cJRP2BStatus.getResponse().getStatusTxnWiseResponse() == null) {
                if (cJRP2BStatus == null || !cJRP2BStatus.getStatusCode().equals("RWL_0002")) {
                    this.f56902d.a((NetworkCustomError) null);
                } else {
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setAlertMessage(cJRP2BStatus.getmStatusMessage());
                    this.f56902d.a(networkCustomError);
                }
                z = false;
            } else {
                z = cJRP2BStatus.getResponse().isValidForTxn();
            }
            if (z) {
                a(this.f56903e);
                this.f56902d.a(this.f56903e);
            }
        }
    }

    public final void a(CJRP2BStatus cJRP2BStatus) {
        this.f56903e = cJRP2BStatus;
        CJRP2BStatus cJRP2BStatus2 = this.f56903e;
        if (cJRP2BStatus2 != null && cJRP2BStatus2.getResponse() != null && this.f56903e.getResponse().getStatusTxnWiseResponse() != null) {
            CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = this.f56903e.getResponse().getStatusTxnWiseResponse();
            try {
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getMinTxnAmount())) {
                    this.f56904f = Double.parseDouble(statusTxnWiseResponse.getMinTxnAmount());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getMaxTxnAmount())) {
                    this.f56905g = Double.parseDouble(statusTxnWiseResponse.getMaxTxnAmount());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getFixedCommission())) {
                    this.f56906h = Double.parseDouble(statusTxnWiseResponse.getFixedCommission());
                }
                if (!TextUtils.isEmpty(statusTxnWiseResponse.getFloatCommission())) {
                    this.f56907i = Double.parseDouble(statusTxnWiseResponse.getFloatCommission());
                }
                if (!TextUtils.isEmpty(this.f56902d.c())) {
                    Double.parseDouble(a(this.f56902d.c()));
                    this.k = this.f56907i;
                }
                this.f56902d.a(Double.toString(this.f56907i));
            } catch (Exception unused) {
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        this.f56902d.b();
        this.f56902d.a(networkCustomError);
    }
}
