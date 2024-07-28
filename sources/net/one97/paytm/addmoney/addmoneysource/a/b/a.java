package net.one97.paytm.addmoney.addmoneysource.a.b;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.addmoneysource.a.a.a;
import net.one97.paytm.addmoney.addmoneysource.a.c.b;
import net.one97.paytm.addmoney.common.model.DebitCardViewType;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse;

public final class a implements a.C0839a, h {

    /* renamed from: a  reason: collision with root package name */
    private final String f48122a = "AddMoneyDebitCardPresenter";

    /* renamed from: b  reason: collision with root package name */
    private final String f48123b = "20";

    /* renamed from: c  reason: collision with root package name */
    private String f48124c;

    /* renamed from: d  reason: collision with root package name */
    private String f48125d;

    /* renamed from: e  reason: collision with root package name */
    private String f48126e;

    /* renamed from: f  reason: collision with root package name */
    private char f48127f = '-';

    /* renamed from: g  reason: collision with root package name */
    private char f48128g = '/';

    /* renamed from: h  reason: collision with root package name */
    private a.b f48129h;

    /* renamed from: i  reason: collision with root package name */
    private b f48130i;
    private CJRBinResponse j;
    private String k;
    private int l;
    private int m;
    private double n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private boolean w;
    private String x = SDKConstants.DEBIT;
    private List<net.one97.paytm.addmoney.common.b> y;
    private String z;

    public a(a.b bVar, b bVar2, int i2, double d2, String str, String str2) {
        this.f48129h = bVar;
        this.f48130i = bVar2;
        this.n = d2;
        this.m = i2;
        this.x = str;
        this.q = str2;
    }

    public final void a() {
        if (this.x.equals(SDKConstants.CREDIT)) {
            this.y = g.a().a(SDKConstants.CREDIT);
        } else if (this.x.equals(SDKConstants.DEBIT)) {
            this.y = g.a().a(SDKConstants.DEBIT);
        }
        this.f48129h.a(this.y);
    }

    public final void b() {
        this.f48129h = null;
        this.f48130i.a("AddMoneyDebitCardPresenter");
    }

    public final void a(String str) {
        String str2 = this.f48126e;
        if (str2 != null) {
            if (str2.equalsIgnoreCase(SDKConstants.AMEX)) {
                if (str.trim().length() == 4) {
                    this.f48129h.a();
                }
            } else if (str.trim().length() == 3) {
                this.f48129h.a();
            }
        }
        this.f48125d = str;
    }

    public final void b(String str) {
        if (str.length() == 5) {
            this.f48129h.a(DebitCardViewType.NEW_CVV.getNumVal());
        }
        String str2 = str.toString();
        String valueOf = String.valueOf(this.f48128g);
        this.f48124c = str2.replace(valueOf, this.f48128g + "20");
    }

    public final void c(String str) {
        String str2 = this.f48126e;
        if (str2 != null) {
            if (str2.equalsIgnoreCase(SDKConstants.AMEX) && str.length() == 18) {
                this.l = 15;
                this.f48129h.a(DebitCardViewType.NEW_EXPIRY.getNumVal());
            } else if (this.f48126e.equalsIgnoreCase(SDKConstants.DINERS) && str.length() == 17) {
                this.l = 14;
                this.f48129h.a(DebitCardViewType.NEW_EXPIRY.getNumVal());
            } else if (this.f48126e.equalsIgnoreCase(SDKConstants.MAESTRO) && str.length() == 23) {
                this.l = 19;
                this.f48129h.a(DebitCardViewType.NEW_EXPIRY.getNumVal());
            } else if ((this.f48126e.equalsIgnoreCase(SDKConstants.MASTER) || this.f48126e.equalsIgnoreCase(SDKConstants.VISA)) && str.length() == 19) {
                this.l = 16;
                this.f48129h.a(DebitCardViewType.NEW_EXPIRY.getNumVal());
            }
        }
        this.k = str;
        if (this.k.length() == 7) {
            this.f48130i.a(this.k.replace(String.valueOf(this.f48127f), ""), this.q, this, "binDetailRequest");
        }
        if (this.k.length() < 7) {
            this.f48130i.a("binDetailRequest");
            this.f48126e = null;
            this.j = null;
            this.f48129h.c();
            this.l = 0;
        }
    }

    public final void a(net.one97.paytm.addmoney.common.b bVar, String str, String str2, double d2) {
        int i2 = 0;
        if (this.x.equalsIgnoreCase(SDKConstants.DEBIT)) {
            g a2 = g.a();
            String str3 = bVar.f48421c;
            while (true) {
                if (i2 >= a2.f48980g.size()) {
                    break;
                } else if (a2.f48980g.get(i2).f48421c.equals(str3)) {
                    a2.f48980g.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            g a3 = g.a();
            String str4 = bVar.f48421c;
            while (true) {
                if (i2 >= a3.f48981h.size()) {
                    break;
                } else if (a3.f48981h.get(i2).f48421c.equals(str4)) {
                    a3.f48981h.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.p = str2;
        this.z = bVar.f48421c + "||" + str + "|";
        this.t = bVar.f48420b;
        this.u = bVar.f48419a;
        this.v = bVar.f48424f;
        this.n = d2;
        j();
    }

    private void j() {
        this.f48129h.b(true);
        this.f48130i.a((h) this, "AddMoneyDebitCardPresenter");
    }

    public final void a(boolean z2) {
        this.o = z2;
    }

    public final void c() {
        this.p = "pin";
    }

    public final void d() {
        this.p = "otp";
    }

    public final void e() {
        net.one97.paytm.addmoney.cvvHelp.b.a aVar;
        if (this.f48126e == null || TextUtils.isEmpty(this.k)) {
            aVar = net.one97.paytm.addmoney.cvvHelp.b.a.NON_AMEX;
        } else if (this.f48126e.equalsIgnoreCase(SDKConstants.AMEX)) {
            aVar = net.one97.paytm.addmoney.cvvHelp.b.a.AMEX;
        } else {
            aVar = net.one97.paytm.addmoney.cvvHelp.b.a.NON_AMEX;
        }
        this.f48129h.a(aVar);
    }

    public final String f() {
        return this.t;
    }

    public final String g() {
        return this.u;
    }

    public final String h() {
        return this.v;
    }

    public final String i() {
        if (c.a().f48963f != null) {
            return c.a().f48963f.getIsaAccNum();
        }
        return null;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        a.b bVar = this.f48129h;
        if (bVar != null) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
                if (cJRPGTokenList != null) {
                    String a2 = net.one97.paytm.helper.a.b().a(cJRPGTokenList);
                    if (!TextUtils.isEmpty(a2)) {
                        b bVar2 = this.f48130i;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.n);
                        bVar2.a(this, a2, sb.toString(), this.m, "AddMoneyDebitCardPresenter");
                        return;
                    }
                    this.f48129h.b(false);
                    this.f48129h.b();
                }
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                bVar.b(false);
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                this.q = cJRRechargePayment.getMID();
                this.s = cJRRechargePayment.getOrderId();
                this.r = cJRRechargePayment.getmTxnToken();
                c.a().f48962e = cJRRechargePayment;
                c.a().a(this.q, this.s, this.r);
                this.f48129h.a((HashMap) AddMoneyUtils.a(this.p, cJRRechargePayment.getmTxnToken(), cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), this.x.equalsIgnoreCase(SDKConstants.DEBIT) ? SDKConstants.DEBIT : SDKConstants.CREDIT, this.z, this.o ? "1" : "0"));
            } else if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                this.f48130i.a((h) this, "AddMoneyDebitCardPresenter");
            } else if (!(iJRPaytmDataModel instanceof CJRBinResponse)) {
                bVar.a(false, "");
            } else if (this.k.length() >= 7) {
                this.j = (CJRBinResponse) iJRPaytmDataModel;
                BinDetail binDetail = this.j.getBody().getBinDetail();
                if (binDetail != null) {
                    this.f48126e = binDetail.getChannelName();
                    if (binDetail.getHasLowSuccess() == null || !binDetail.getHasLowSuccess().getStatus()) {
                        this.f48129h.a(false, "");
                    } else {
                        this.f48129h.a(true, binDetail.getHasLowSuccess().getMsg());
                    }
                }
                if (SDKConstants.MAESTRO.equalsIgnoreCase(this.f48126e)) {
                    this.f48129h.d();
                }
                try {
                    this.f48129h.a(this.j.getBody().getBinDetail().getChannelName());
                } catch (Exception unused) {
                }
                if (this.w) {
                    this.f48129h.b(false);
                    this.w = false;
                    a(this.n);
                }
            }
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        a.b bVar = this.f48129h;
        if (bVar != null) {
            bVar.b(false);
            this.f48129h.a(false);
            if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                this.f48129h.b(networkCustomError.getAlertMessage());
            } else {
                this.f48129h.a(networkCustomError);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if ((r7 % 10 == 0) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0180, code lost:
        if (r0 != false) goto L_0x0189;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(double r12) {
        /*
            r11 = this;
            java.lang.String r0 = r11.k
            java.lang.String r1 = "-"
            java.lang.String r2 = ""
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x022d
            int r0 = r0.length()
            if (r0 > 0) goto L_0x0012
            goto L_0x022d
        L_0x0012:
            java.lang.String r0 = r11.k
            if (r0 == 0) goto L_0x022b
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x022b
            java.lang.String r0 = r11.f48126e
            java.lang.String r5 = "RUPAY"
            boolean r0 = r5.equalsIgnoreCase(r0)
            r5 = 4
            if (r0 != 0) goto L_0x002e
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r5)
            goto L_0x0232
        L_0x002e:
            java.lang.String r0 = r11.k
            java.lang.String r0 = r0.replace(r1, r2)
            net.one97.paytm.addmoney.common.model.CardType r0 = net.one97.paytm.addmoney.common.model.CardType.detect(r0)
            net.one97.paytm.addmoney.common.model.CardType r6 = net.one97.paytm.addmoney.common.model.CardType.UNKNOWN
            if (r0 != r6) goto L_0x0095
            int r0 = r11.l
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r11.k
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            int r6 = r11.l
            if (r0 == r6) goto L_0x0059
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r4)
            goto L_0x0232
        L_0x0059:
            java.lang.String r0 = r11.k
            java.lang.String r0 = r0.replace(r1, r2)
            int r6 = r0.length()
            r7 = 14
            if (r6 < r7) goto L_0x008e
            int r6 = r0.length()
            int r6 = r6 - r4
            r7 = 0
            r8 = 0
        L_0x006e:
            if (r6 < 0) goto L_0x0085
            char r9 = r0.charAt(r6)
            int r9 = r9 + -97
            if (r8 != r4) goto L_0x007a
            int r9 = r9 * 2
        L_0x007a:
            int r10 = r9 / 10
            int r7 = r7 + r10
            int r9 = r9 % 10
            int r7 = r7 + r9
            r8 = r8 ^ 1
            int r6 = r6 + -1
            goto L_0x006e
        L_0x0085:
            int r7 = r7 % 10
            if (r7 != 0) goto L_0x008b
            r0 = 1
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r0 != 0) goto L_0x0095
        L_0x008e:
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r4)
            goto L_0x0232
        L_0x0095:
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r0 = r11.j
            r6 = 2
            if (r0 == 0) goto L_0x0116
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r0 = r0.getBody()
            if (r0 == 0) goto L_0x0116
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r0 = r11.j
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r0 = r0.getBody()
            net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail r0 = r0.getBinDetail()
            if (r0 == 0) goto L_0x0116
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r0 = r11.j
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r0 = r0.getBody()
            net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail r0 = r0.getBinDetail()
            java.lang.String r0 = r0.getPaymentMode()
            java.lang.String r7 = "CREDIT_CARD"
            boolean r0 = r7.equalsIgnoreCase(r0)
            java.lang.String r8 = "DEBIT_CARD"
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = r11.x
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00ee
            int r0 = r11.m
            net.one97.paytm.addmoney.common.model.PaymentDestinationType r4 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_PAYTM_BANK
            int r4 = r4.getNumVal()
            if (r0 != r4) goto L_0x00e2
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.b((boolean) r3)
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.c(r3)
            goto L_0x0232
        L_0x00e2:
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.b((boolean) r3)
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.c(r6)
            goto L_0x0232
        L_0x00ee:
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r0 = r11.j
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r0 = r0.getBody()
            net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail r0 = r0.getBinDetail()
            java.lang.String r0 = r0.getPaymentMode()
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0116
            java.lang.String r0 = r11.x
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0116
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.b((boolean) r3)
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.c(r4)
            goto L_0x0232
        L_0x0116:
            java.lang.String r0 = r11.f48126e
            java.lang.String r7 = "MAESTRO"
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0189
            java.lang.String r0 = r11.f48124c
            if (r0 == 0) goto L_0x0182
            int r0 = r0.length()
            r8 = 7
            if (r0 < r8) goto L_0x0182
            java.lang.String r0 = r11.f48124c
            java.lang.String r8 = "/"
            java.lang.String[] r0 = r0.split(r8)
            r8 = r0[r3]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x017f
            java.util.Calendar r8 = java.util.Calendar.getInstance()
            r9 = r0[r3]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r9.intValue()
            r10 = 12
            if (r9 > r10) goto L_0x017f
            r9 = r0[r4]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r9.intValue()
            int r10 = r8.get(r4)
            if (r9 > r10) goto L_0x017d
            r9 = r0[r4]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r9.intValue()
            int r10 = r8.get(r4)
            if (r9 != r10) goto L_0x017f
            r0 = r0[r3]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r0.intValue()
            int r8 = r8.get(r6)
            if (r0 <= r8) goto L_0x017f
        L_0x017d:
            r0 = 1
            goto L_0x0180
        L_0x017f:
            r0 = 0
        L_0x0180:
            if (r0 != 0) goto L_0x0189
        L_0x0182:
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r6)
            goto L_0x0232
        L_0x0189:
            java.lang.String r0 = r11.f48126e
            boolean r0 = r7.equalsIgnoreCase(r0)
            r6 = 3
            if (r0 != 0) goto L_0x01b1
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            net.one97.paytm.addmoney.common.model.DebitCardViewType r8 = net.one97.paytm.addmoney.common.model.DebitCardViewType.RADIO_ATM_NEW_CARD
            int r8 = r8.getNumVal()
            boolean r0 = r0.b((int) r8)
            if (r0 != 0) goto L_0x01b1
            java.lang.String r0 = r11.f48125d
            if (r0 == 0) goto L_0x01aa
            int r0 = r0.length()
            if (r0 >= r6) goto L_0x01b1
        L_0x01aa:
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r6)
            goto L_0x0232
        L_0x01b1:
            java.lang.String r0 = r11.f48126e
            if (r0 == 0) goto L_0x0205
            java.lang.String r8 = "Amex"
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x01dd
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            net.one97.paytm.addmoney.common.model.DebitCardViewType r7 = net.one97.paytm.addmoney.common.model.DebitCardViewType.RADIO_ATM_NEW_CARD
            int r7 = r7.getNumVal()
            boolean r0 = r0.b((int) r7)
            if (r0 != 0) goto L_0x0205
            java.lang.String r0 = r11.f48125d
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 == r5) goto L_0x0205
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r6)
            goto L_0x0232
        L_0x01dd:
            java.lang.String r0 = r11.f48126e
            boolean r0 = r0.equalsIgnoreCase(r7)
            if (r0 != 0) goto L_0x0205
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            net.one97.paytm.addmoney.common.model.DebitCardViewType r5 = net.one97.paytm.addmoney.common.model.DebitCardViewType.RADIO_ATM_NEW_CARD
            int r5 = r5.getNumVal()
            boolean r0 = r0.b((int) r5)
            if (r0 != 0) goto L_0x0205
            java.lang.String r0 = r11.f48125d
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 == r6) goto L_0x0205
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r6)
            goto L_0x0232
        L_0x0205:
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r0 = r11.j
            if (r0 != 0) goto L_0x022b
            r11.w = r4
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.b((boolean) r4)
            java.lang.String r0 = r11.k
            char r4 = r11.f48127f
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.replace(r4, r2)
            r4 = 6
            java.lang.String r0 = r0.substring(r3, r4)
            net.one97.paytm.addmoney.addmoneysource.a.c.b r4 = r11.f48130i
            java.lang.String r5 = r11.q
            java.lang.String r6 = "binDetailRequest"
            r4.a(r0, r5, r11, r6)
            goto L_0x0232
        L_0x022b:
            r3 = 1
            goto L_0x0232
        L_0x022d:
            net.one97.paytm.addmoney.addmoneysource.a.a.a$b r0 = r11.f48129h
            r0.a((boolean) r4, (int) r4)
        L_0x0232:
            if (r3 == 0) goto L_0x02a5
            r11.n = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "|"
            r12.<init>(r13)
            java.lang.String r0 = r11.k
            java.lang.String r0 = r0.replace(r1, r2)
            r12.append(r0)
            r12.append(r13)
            java.lang.String r0 = r11.f48125d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0254
            r0 = r2
            goto L_0x0256
        L_0x0254:
            java.lang.String r0 = r11.f48125d
        L_0x0256:
            r12.append(r0)
            r12.append(r13)
            java.lang.String r13 = r11.f48124c
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0265
            goto L_0x0271
        L_0x0265:
            java.lang.String r13 = r11.f48124c
            char r0 = r11.f48128g
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r13.replace(r0, r2)
        L_0x0271:
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            r11.z = r12
            java.lang.String r12 = "otp"
            r11.p = r12
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r12 = r11.j
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r12 = r12.getBody()
            net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail r12 = r12.getBinDetail()
            java.lang.String r12 = r12.getIssuingBank()
            r11.t = r12
            java.lang.String r12 = r11.k
            r11.u = r12
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse r12 = r11.j
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody r12 = r12.getBody()
            net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail r12 = r12.getBinDetail()
            java.lang.String r12 = r12.getChannelName()
            r11.v = r12
            r11.j()
        L_0x02a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.addmoneysource.a.b.a.a(double):void");
    }
}
