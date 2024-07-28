package net.one97.paytm.paymentsBank.slfd.createfd.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.createfd.a.a;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0333a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PBTncData> f19044a;

    /* renamed from: b  reason: collision with root package name */
    private SlfdNomineeModel f19045b;

    /* renamed from: c  reason: collision with root package name */
    private int f19046c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19047d;

    /* renamed from: e  reason: collision with root package name */
    private String f19048e;

    /* renamed from: f  reason: collision with root package name */
    private String f19049f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19050g;

    /* renamed from: h  reason: collision with root package name */
    private final a.b f19051h;

    /* renamed from: i  reason: collision with root package name */
    private final b f19052i;
    private final ArrayList<SlfdNomineeModel> j;

    private a(a.b bVar, b bVar2, ArrayList<SlfdNomineeModel> arrayList) {
        k.c(bVar, "createSlfdView");
        k.c(bVar2, "slfdRepository");
        k.c(arrayList, "slfdNomineeList");
        this.f19051h = bVar;
        this.f19052i = bVar2;
        this.j = arrayList;
        this.f19044a = new ArrayList<>();
        this.f19046c = -1;
        this.f19048e = "";
        this.f19049f = "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b1, code lost:
        r14 = r14.getAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onResponse(java.lang.Object r14) {
        /*
            r13 = this;
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            r1 = 0
            r0.a(r1)
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            r0.b((boolean) r1)
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeListModel
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0052
            java.util.ArrayList<net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel> r0 = r13.j
            net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeListModel r14 = (net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeListModel) r14
            java.util.ArrayList r14 = r14.getNomineeList()
            if (r14 != 0) goto L_0x0020
            kotlin.g.b.k.a()
        L_0x0020:
            java.util.Collection r14 = (java.util.Collection) r14
            r0.addAll(r14)
            java.util.ArrayList<net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel> r14 = r13.j
            int r14 = r14.size()
            if (r14 <= 0) goto L_0x004c
            r13.f19046c = r1
            java.util.ArrayList<net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel> r14 = r13.j
            int r0 = r13.f19046c
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel r14 = (net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel) r14
            r13.f19045b = r14
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r14 = r13.f19051h
            net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel r0 = r13.f19045b
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r0.getName()
            if (r0 != 0) goto L_0x0048
        L_0x0047:
            r0 = r2
        L_0x0048:
            r14.a((java.lang.String) r0)
            return
        L_0x004c:
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r14 = r13.f19051h
            r14.a()
            return
        L_0x0052:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.model.slfd.ValidateSlfdModel
            if (r0 == 0) goto L_0x008e
            net.one97.paytm.paymentsBank.model.slfd.ValidateSlfdModel r14 = (net.one97.paytm.paymentsBank.model.slfd.ValidateSlfdModel) r14
            boolean r0 = r14.getLimitBreach()
            if (r0 == 0) goto L_0x0088
            r0 = 1187(0x4a3, float:1.663E-42)
            java.lang.Integer r1 = r14.getResponseCode()
            if (r1 != 0) goto L_0x0067
            goto L_0x0073
        L_0x0067:
            int r1 = r1.intValue()
            if (r0 != r1) goto L_0x0073
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r14 = r13.f19051h
            r14.b()
            return
        L_0x0073:
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            java.lang.String r1 = r14.getStatus()
            if (r1 != 0) goto L_0x007d
            java.lang.String r1 = "Limit breach"
        L_0x007d:
            java.lang.String r14 = r14.getMessage()
            if (r14 != 0) goto L_0x0084
            r14 = r2
        L_0x0084:
            r0.a((java.lang.String) r1, (java.lang.String) r14)
            return
        L_0x0088:
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r14 = r13.f19051h
            r14.b()
            return
        L_0x008e:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.model.slfd.BankFfResponse
            if (r0 == 0) goto L_0x00d4
            net.one97.paytm.paymentsBank.model.slfd.BankFfResponse r14 = (net.one97.paytm.paymentsBank.model.slfd.BankFfResponse) r14
            int r0 = r14.getResponseCode()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x00c2
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            net.one97.paytm.paymentsBank.model.slfd.Payload r1 = r14.getPayload()
            if (r1 == 0) goto L_0x00aa
            java.lang.String r1 = r1.getOrderid()
            if (r1 != 0) goto L_0x00ab
        L_0x00aa:
            r1 = r2
        L_0x00ab:
            net.one97.paytm.paymentsBank.model.slfd.Payload r14 = r14.getPayload()
            if (r14 == 0) goto L_0x00bc
            java.lang.Double r14 = r14.getAmount()
            if (r14 == 0) goto L_0x00bc
            double r2 = r14.doubleValue()
            goto L_0x00be
        L_0x00bc:
            r2 = 0
        L_0x00be:
            r0.a((java.lang.String) r1, (double) r2)
            return
        L_0x00c2:
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            int r1 = r14.getResponseCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r14 = r14.getResponseMessage()
            r0.a((java.lang.String) r1, (java.lang.String) r14)
            return
        L_0x00d4:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse
            java.lang.String r1 = "success"
            if (r0 == 0) goto L_0x010c
            net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse r14 = (net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse) r14
            java.lang.String r0 = r14.getStatus()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00fa
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            java.lang.String r14 = r14.getOrderId()
            if (r14 != 0) goto L_0x00f0
            r14 = r2
        L_0x00f0:
            java.lang.String r1 = r13.f19048e
            double r1 = java.lang.Double.parseDouble(r1)
            r0.a((java.lang.String) r14, (double) r1)
            return
        L_0x00fa:
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            java.lang.Integer r1 = r14.getResponseCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r14 = r14.getMessage()
            r0.a((java.lang.String) r1, (java.lang.String) r14)
            return
        L_0x010c:
            boolean r0 = r14 instanceof net.one97.paytm.bankCommon.model.PBKYCFetchTnc
            java.lang.String r3 = "Error"
            java.lang.String r4 = "error"
            r5 = 1
            if (r0 == 0) goto L_0x0166
            net.one97.paytm.bankCommon.model.PBKYCFetchTnc r14 = (net.one97.paytm.bankCommon.model.PBKYCFetchTnc) r14
            java.lang.String r0 = r14.getStatus()
            if (r0 == 0) goto L_0x013d
            java.lang.String r0 = r14.getStatus()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r5)
            if (r0 == 0) goto L_0x013d
            java.lang.String r0 = r14.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01d2
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            java.lang.String r14 = r14.getMessage()
            r0.a((java.lang.String) r3, (java.lang.String) r14)
            return
        L_0x013d:
            java.lang.String r0 = r14.getStatus()
            if (r0 == 0) goto L_0x0165
            java.lang.String r0 = r14.getStatus()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 == 0) goto L_0x0165
            java.util.ArrayList r0 = r14.getTncDataList()
            if (r0 == 0) goto L_0x0165
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBTncData> r0 = r13.f19044a
            java.util.ArrayList r14 = r14.getTncDataList()
            java.util.Collection r14 = (java.util.Collection) r14
            r0.addAll(r14)
            boolean r14 = r13.f19047d
            if (r14 == 0) goto L_0x0165
            r13.f()
        L_0x0165:
            return
        L_0x0166:
            boolean r0 = r14 instanceof net.one97.paytm.bankCommon.model.PBKYCTncAccept
            if (r0 == 0) goto L_0x01d2
            net.one97.paytm.bankCommon.model.PBKYCTncAccept r14 = (net.one97.paytm.bankCommon.model.PBKYCTncAccept) r14
            java.lang.String r0 = r14.getStatus()
            if (r0 == 0) goto L_0x0192
            java.lang.String r0 = r14.getStatus()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r5)
            if (r0 == 0) goto L_0x0192
            java.lang.String r0 = r14.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01d2
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r0 = r13.f19051h
            java.lang.String r14 = r14.getMessage()
            r0.a((java.lang.String) r3, (java.lang.String) r14)
            return
        L_0x0192:
            java.lang.String r0 = r14.getStatus()
            if (r0 == 0) goto L_0x01d2
            java.lang.String r0 = r14.getStatus()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 == 0) goto L_0x01d2
            java.lang.String r14 = r14.getResponseCode()
            java.lang.String r0 = "2004"
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r0)
            if (r14 == 0) goto L_0x01d2
            net.one97.paytm.paymentsBank.slfd.createfd.a.a$b r14 = r13.f19051h
            r14.b((boolean) r5)
            net.one97.paytm.paymentsBank.slfd.a.a.b r6 = r13.f19052i
            r7 = r13
            net.one97.paytm.bankCommon.g.g$b r7 = (net.one97.paytm.bankCommon.g.g.b) r7
            r8 = r13
            net.one97.paytm.bankCommon.g.g$a r8 = (net.one97.paytm.bankCommon.g.g.a) r8
            java.lang.String r9 = r13.f19048e
            net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel r14 = r13.f19045b
            if (r14 == 0) goto L_0x01ca
            java.lang.String r14 = r14.getNomineeFinservId()
            if (r14 != 0) goto L_0x01c8
            goto L_0x01ca
        L_0x01c8:
            r10 = r14
            goto L_0x01cb
        L_0x01ca:
            r10 = r2
        L_0x01cb:
            boolean r11 = r13.f19050g
            java.lang.String r12 = r13.f19049f
            r6.a(r7, r8, r9, r10, r11, r12)
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.createfd.b.a.onResponse(java.lang.Object):void");
    }

    public /* synthetic */ a(a.b bVar, b bVar2) {
        this(bVar, bVar2, new ArrayList());
    }

    public final void a() {
        this.f19051h.a(true);
        a(false);
        e();
    }

    public final void b() {
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void a(SlfdNomineeModel slfdNomineeModel, int i2) {
        String str;
        k.c(slfdNomineeModel, "nominee");
        this.f19045b = slfdNomineeModel;
        this.f19046c = i2;
        a.b bVar = this.f19051h;
        SlfdNomineeModel slfdNomineeModel2 = this.f19045b;
        if (slfdNomineeModel2 == null || (str = slfdNomineeModel2.getName()) == null) {
            str = "";
        }
        bVar.a(str);
    }

    private void e() {
        this.f19051h.a(true);
        this.f19052i.d(this, this);
    }

    private void f() {
        if (this.f19044a.size() > 0) {
            this.f19051h.a(true);
            this.f19052i.a((g.b<IJRPaytmDataModel>) this, (g.a) this, this.f19044a);
        }
    }

    public final void a(String str) {
        k.c(str, "amount");
        this.f19048e = str;
        this.f19051h.a(true);
        this.f19052i.a((g.b<IJRPaytmDataModel>) this, (g.a) this, "IBPAN", this.f19048e, "20263");
    }

    public final void a(String str, String str2, boolean z) {
        k.c(str, "amount");
        k.c(str2, "txnToken");
        this.f19048e = str;
        this.f19049f = str2;
        this.f19050g = z;
        if (this.f19044a.size() == 0) {
            e();
            this.f19047d = true;
            return;
        }
        f();
    }

    public final void c() {
        this.f19051h.b(this.f19046c);
    }

    public final void d() {
        if (this.f19044a.size() > 0) {
            this.f19051h.a(this.f19044a);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f19051h.a(true);
        }
        this.f19052i.c(this, this);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f19051h.a(false);
        this.f19051h.b(false);
        this.f19051h.a("", networkCustomError != null ? networkCustomError.getAlertMessage() : null);
    }
}
