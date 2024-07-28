package net.one97.paytm.upi.mandate.view.model;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.PendingCollectMandateDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.AuthMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.utils.d;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.w;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends androidx.lifecycle.a implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final net.one97.paytm.upi.passbook.b.a.b f67581a = g.b();

    /* renamed from: b  reason: collision with root package name */
    public final net.one97.paytm.upi.registration.b.a.b f67582b = g.a((net.one97.paytm.upi.h.a) null);

    /* renamed from: c  reason: collision with root package name */
    public final y<r<MandateDefaultResponseModel>> f67583c;

    /* renamed from: d  reason: collision with root package name */
    public MandateItem f67584d;

    /* renamed from: e  reason: collision with root package name */
    public String f67585e;

    /* renamed from: f  reason: collision with root package name */
    public MandateDefaultResponseModel f67586f;

    /* renamed from: g  reason: collision with root package name */
    public UpiPendingRequestModel f67587g;

    /* renamed from: h  reason: collision with root package name */
    public UpiProfileDefaultBank f67588h;

    /* renamed from: i  reason: collision with root package name */
    private final net.one97.paytm.upi.mandate.data.b f67589i = g.a((Context) getApplication());
    private final net.one97.paytm.upi.profile.b.b j = g.a();
    private final i k;
    private final y<r<String>> l;
    private final y<MandateItem> m;
    private CreateMandateUiModel n;
    private String o;
    private final Application p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.p = application;
        Context applicationContext = this.p.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        this.k = new i(applicationContext);
        this.f67583c = new y<>();
        this.l = new y<>();
        this.m = new y<>();
        this.o = "";
        this.k.a((i.a) this);
    }

    public final void a(MandateItem mandateItem) {
        MandateItem mandateItem2 = mandateItem;
        k.c(mandateItem2, "mandateItem");
        this.f67584d = mandateItem2;
        y<MandateItem> yVar = this.m;
        MandateItem mandateItem3 = this.f67584d;
        if (mandateItem3 == null) {
            k.a("_mandateItem");
        }
        yVar.setValue(mandateItem3);
        MandateItem mandateItem4 = this.f67584d;
        if (mandateItem4 == null) {
            k.a("_mandateItem");
        }
        String amount = mandateItem4.getAmount();
        MandateItem mandateItem5 = this.f67584d;
        if (mandateItem5 == null) {
            k.a("_mandateItem");
        }
        String vpa = mandateItem5.getPayee().getVpa();
        MandateItem mandateItem6 = this.f67584d;
        if (mandateItem6 == null) {
            k.a("_mandateItem");
        }
        String userName = mandateItem6.getPayee().getUserName();
        MandateItem mandateItem7 = this.f67584d;
        if (mandateItem7 == null) {
            k.a("_mandateItem");
        }
        String note = mandateItem7.getNote();
        MandateItem mandateItem8 = this.f67584d;
        if (mandateItem8 == null) {
            k.a("_mandateItem");
        }
        String mcc = mandateItem8.getPayee().getMcc();
        MandateItem mandateItem9 = this.f67584d;
        if (mandateItem9 == null) {
            k.a("_mandateItem");
        }
        String vpa2 = mandateItem9.getPayer().getVpa();
        MandateItem mandateItem10 = this.f67584d;
        if (mandateItem10 == null) {
            k.a("_mandateItem");
        }
        String bankIfsc = mandateItem10.getPayer().getBankIfsc();
        MandateItem mandateItem11 = this.f67584d;
        if (mandateItem11 == null) {
            k.a("_mandateItem");
        }
        String bankName = mandateItem11.getPayer().getBankName();
        MandateItem mandateItem12 = this.f67584d;
        if (mandateItem12 == null) {
            k.a("_mandateItem");
        }
        String bankAccount = mandateItem12.getPayer().getBankAccount();
        MandateItem mandateItem13 = this.f67584d;
        if (mandateItem13 == null) {
            k.a("_mandateItem");
        }
        String validityStartDate = mandateItem13.getValidityStartDate();
        MandateItem mandateItem14 = this.f67584d;
        if (mandateItem14 == null) {
            k.a("_mandateItem");
        }
        String validityEndDate = mandateItem14.getValidityEndDate();
        MandateItem mandateItem15 = this.f67584d;
        if (mandateItem15 == null) {
            k.a("_mandateItem");
        }
        String umn = mandateItem15.getUmn();
        MandateItem mandateItem16 = this.f67584d;
        if (mandateItem16 == null) {
            k.a("_mandateItem");
        }
        String refUrl = mandateItem16.getRefUrl();
        MandateItem mandateItem17 = this.f67584d;
        if (mandateItem17 == null) {
            k.a("_mandateItem");
        }
        String refCategory = mandateItem17.getRefCategory();
        net.one97.paytm.upi.mandate.d.a aVar = net.one97.paytm.upi.mandate.d.a.f67112a;
        this.n = new CreateMandateUiModel(amount, vpa, userName, note, mcc, (String) null, "P2M", vpa2, bankIfsc, bankName, bankAccount, (List) null, validityStartDate, validityEndDate, umn, (String) null, refUrl, refCategory, (String) null, (w.a) null, (w.b) null, net.one97.paytm.upi.mandate.d.a.a(mandateItem, (String) null), (UpdateInfo) null, (String) null, 14452768, (kotlin.g.b.g) null);
        String accRefId = mandateItem.getAccRefId();
        if (accRefId == null) {
            accRefId = "";
        }
        this.o = accRefId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        r1 = (r1 = r1.getDebitBank()).getCredsAllowed();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r15 = this;
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r0 = r15.f67587g
            java.lang.String r1 = "_mandateItem"
            if (r0 != 0) goto L_0x0017
            net.one97.paytm.upi.mandate.data.model.MandateItem r0 = r15.f67584d
            if (r0 != 0) goto L_0x000d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000d:
            net.one97.paytm.upi.mandate.data.model.MandatePayer r0 = r0.getPayer()
            java.lang.String r0 = r0.getVpa()
        L_0x0015:
            r5 = r0
            goto L_0x002a
        L_0x0017:
            if (r0 != 0) goto L_0x001c
            kotlin.g.b.k.a()
        L_0x001c:
            net.one97.paytm.upi.common.upi.PendingCollectMandateDetails r0 = r0.getMandateDetails()
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            java.lang.String r0 = r0.getUmn()
            goto L_0x0015
        L_0x002a:
            net.one97.paytm.upi.mandate.utils.a r0 = new net.one97.paytm.upi.mandate.utils.a
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0033
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0033:
            java.lang.String r2 = r2.getAmount()
            java.lang.String r3 = net.one97.paytm.upi.util.UpiUtils.convertToTwoPlaces(r2)
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0042
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0042:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r4 = r2.getVpa()
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0051
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0051:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r6 = r2.getUserName()
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0060
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0060:
            java.lang.String r7 = r2.getNote()
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x006b
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006b:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r8 = r2.getBankAccount()
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x007a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007a:
            java.lang.String r9 = r2.getTxnId()
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0085
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0085:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r2 = r2.getMcc()
            if (r2 != 0) goto L_0x0091
            java.lang.String r2 = ""
        L_0x0091:
            r10 = r2
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r15.f67584d
            if (r2 != 0) goto L_0x0099
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0099:
            java.lang.String r12 = r2.getRefUrl()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r15.f67588h
            r2 = 0
            if (r1 == 0) goto L_0x00b4
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x00b4
            net.one97.paytm.upi.common.upi.BankAccountDetails$CredsAllowed r1 = r1.getCredsAllowed()
            if (r1 == 0) goto L_0x00b4
            java.util.List r1 = r1.getChild()
            r13 = r1
            goto L_0x00b5
        L_0x00b4:
            r13 = r2
        L_0x00b5:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r15.f67588h
            if (r1 == 0) goto L_0x00c5
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = r1.getBankName()
            r14 = r1
            goto L_0x00c6
        L_0x00c5:
            r14 = r2
        L_0x00c6:
            java.lang.String r11 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            net.one97.paytm.upi.mandate.utils.i r1 = r15.k
            r1.a((net.one97.paytm.upi.mandate.utils.a) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.model.a.a():void");
    }

    public final void b(String str) {
        String str2;
        String str3;
        BankAccountDetails.BankAccount debitBank;
        String accRefId;
        MandateItem mandateItem = this.f67584d;
        if (mandateItem == null) {
            k.a("_mandateItem");
        }
        String str4 = "RECURRING";
        if (!k.a((Object) mandateItem.getType(), (Object) str4)) {
            str4 = "ONETIME";
        }
        String str5 = str4;
        MandateItem mandateItem2 = this.f67584d;
        if (mandateItem2 == null) {
            k.a("_mandateItem");
        }
        String txnId = mandateItem2.getTxnId();
        String deviceId = UpiUtils.getDeviceId(getApplication());
        k.a((Object) deviceId, "UpiUtils.getDeviceId(getApplication())");
        String str6 = this.f67585e;
        if (str6 == null) {
            k.a("_authorizationType");
        }
        MandateItem mandateItem3 = this.f67584d;
        if (mandateItem3 == null) {
            k.a("_mandateItem");
        }
        String umn = mandateItem3.getUmn();
        MandateItem mandateItem4 = this.f67584d;
        if (mandateItem4 == null) {
            k.a("_mandateItem");
        }
        String bankIfsc = mandateItem4.getPayer().getBankIfsc();
        String str7 = bankIfsc == null ? "" : bankIfsc;
        MandateItem mandateItem5 = this.f67584d;
        if (mandateItem5 == null) {
            k.a("_mandateItem");
        }
        String bankAccount = mandateItem5.getPayer().getBankAccount();
        if (bankAccount == null) {
            str2 = "";
        } else {
            str2 = bankAccount;
        }
        UpiProfileDefaultBank upiProfileDefaultBank = this.f67588h;
        if (upiProfileDefaultBank == null || (debitBank = upiProfileDefaultBank.getDebitBank()) == null || (accRefId = debitBank.getAccRefId()) == null) {
            str3 = "";
        } else {
            str3 = accRefId;
        }
        AuthMandateRequestModel authMandateRequestModel = new AuthMandateRequestModel(txnId, deviceId, str6, str, umn, str7, str2, str3, str5);
        this.f67583c.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
        this.f67589i.a(authMandateRequestModel, (b.a) new C1374a(this));
    }

    /* renamed from: net.one97.paytm.upi.mandate.view.model.a$a  reason: collision with other inner class name */
    public static final class C1374a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67590a;

        C1374a(a aVar) {
            this.f67590a = aVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                this.f67590a.f67586f = mandateDefaultResponseModel;
                if (k.a((Object) net.one97.paytm.upi.mandate.utils.c.FAILURE.getType(), (Object) mandateDefaultResponseModel.getStatus())) {
                    this.f67590a.f67583c.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
                } else {
                    new Handler().postDelayed(new C1375a(this, upiBaseDataModel), 2000);
                }
            }
        }

        /* renamed from: net.one97.paytm.upi.mandate.view.model.a$a$a  reason: collision with other inner class name */
        static final class C1375a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1374a f67591a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ UpiBaseDataModel f67592b;

            C1375a(C1374a aVar, UpiBaseDataModel upiBaseDataModel) {
                this.f67591a = aVar;
                this.f67592b = upiBaseDataModel;
            }

            public final void run() {
                this.f67591a.f67590a.f67583c.setValue(new r(u.SUCCESS, this.f67592b, (t) null, false, 12));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67590a.f67583c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67590a.f67583c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public final void a(String str) {
        k.c(str, PayUtility.MPIN);
        UpiPendingRequestModel upiPendingRequestModel = this.f67587g;
        if (upiPendingRequestModel == null) {
            b(str);
            return;
        }
        if (upiPendingRequestModel == null) {
            k.a();
        }
        this.f67583c.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
        UpiProfileDefaultBank upiProfileDefaultBank = this.f67588h;
        if (upiProfileDefaultBank == null) {
            k.a();
        }
        String txnId = upiPendingRequestModel.getTxnId();
        String payeeVa = upiPendingRequestModel.getPayeeVa();
        String virtualAddress = upiProfileDefaultBank.getVirtualAddress();
        String amount = upiPendingRequestModel.getAmount();
        String note = upiPendingRequestModel.getNote();
        String payeeName = upiPendingRequestModel.getPayeeName();
        String txnId2 = upiPendingRequestModel.getTxnId();
        PendingCollectMandateDetails mandateDetails = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails, "pendingResponseModel.mandateDetails");
        this.j.a(new c(this), txnId, "", str, payeeVa, virtualAddress, amount, note, payeeName, upiProfileDefaultBank, txnId2, "", mandateDetails.getUmn());
    }

    public static final class b implements a.C1379a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67593a;

        public b(a aVar) {
            this.f67593a = aVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess()) {
                    this.f67593a.f67583c.setValue(new r(u.ERROR, (Object) null, new t.a(baseUpiResponse.getMessage()), false, 10));
                } else {
                    new Handler().postDelayed(new C1376a(this, upiBaseDataModel), 2000);
                }
            }
        }

        /* renamed from: net.one97.paytm.upi.mandate.view.model.a$b$a  reason: collision with other inner class name */
        static final class C1376a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f67594a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ UpiBaseDataModel f67595b;

            C1376a(b bVar, UpiBaseDataModel upiBaseDataModel) {
                this.f67594a = bVar;
                this.f67595b = upiBaseDataModel;
            }

            public final void run() {
                a aVar = this.f67594a.f67593a;
                String seqNo = ((BaseUpiResponse) this.f67595b).getSeqNo();
                k.a((Object) seqNo, "response.seqNo");
                String response = ((BaseUpiResponse) this.f67595b).getResponse();
                k.a((Object) response, "response.response");
                String message = ((BaseUpiResponse) this.f67595b).getMessage();
                k.a((Object) message, "response.message");
                aVar.f67586f = new MandateDefaultResponseModel("PENDING", seqNo, response, message, (String) null, (String) null, (String) null);
                this.f67594a.f67593a.f67583c.setValue(new r(u.SUCCESS, new MandateDefaultResponseModel("", "", "", "", (String) null, (String) null, (String) null), (t) null, false, 12));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67593a.f67583c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67593a.f67583c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67596a;

        c(a aVar) {
            this.f67596a = aVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            UpiBaseDataModel upiBaseDataModel2 = upiBaseDataModel;
            if (upiBaseDataModel2 instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel2;
                if (!baseUpiResponse.isSuccess()) {
                    this.f67596a.f67583c.setValue(new r(u.ERROR, (Object) null, new t.a(baseUpiResponse.getMessage()), false, 10));
                    return;
                }
                a aVar = this.f67596a;
                String seqNo = baseUpiResponse.getSeqNo();
                k.a((Object) seqNo, "response.seqNo");
                String response = baseUpiResponse.getResponse();
                k.a((Object) response, "response.response");
                String message = baseUpiResponse.getMessage();
                k.a((Object) message, "response.message");
                aVar.f67586f = new MandateDefaultResponseModel("PENDING", seqNo, response, message, (String) null, (String) null, (String) null);
                y a2 = this.f67596a.f67583c;
                u uVar = u.SUCCESS;
                String seqNo2 = baseUpiResponse.getSeqNo();
                k.a((Object) seqNo2, "response.seqNo");
                String response2 = baseUpiResponse.getResponse();
                k.a((Object) response2, "response.response");
                String message2 = baseUpiResponse.getMessage();
                k.a((Object) message2, "response.message");
                a2.setValue(new r(uVar, new MandateDefaultResponseModel("Success", seqNo2, response2, message2, (String) null, (String) null, (String) null), (t) null, false, 12));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67596a.f67583c.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67596a.f67583c.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }

    public final void a(t tVar) {
        k.c(tVar, "error");
        this.f67583c.setValue(new r(u.ERROR, (Object) null, tVar, false, 10));
    }

    public final void a(UpiPendingRequestModel upiPendingRequestModel, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.f67587g = upiPendingRequestModel;
        this.f67588h = upiProfileDefaultBank;
        this.f67585e = d.APPROVE.getType();
        a();
    }
}
