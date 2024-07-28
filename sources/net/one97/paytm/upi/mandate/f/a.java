package net.one97.paytm.upi.mandate.f;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel;
import net.one97.paytm.upi.mandate.data.model.CheckMandateStatusResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.utils.f;
import net.one97.paytm.upi.mandate.utils.s;
import net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends androidx.lifecycle.a implements b.a {

    /* renamed from: g  reason: collision with root package name */
    public static final c f67197g = new c((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.upi.mandate.data.b f67198a = g.a((Context) getApplication());

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.upi.mandate.view.model.b> f67199b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final s<b> f67200c = new s<>();

    /* renamed from: d  reason: collision with root package name */
    public CreateMandateUiModel f67201d;

    /* renamed from: e  reason: collision with root package name */
    public String f67202e;

    /* renamed from: f  reason: collision with root package name */
    public final Application f67203f;

    /* renamed from: h  reason: collision with root package name */
    private Timer f67204h;

    /* renamed from: i  reason: collision with root package name */
    private int f67205i;
    private final int j = this.m.length;
    private int k = 1;
    private String l;
    private final Integer[] m = f.a();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f67203f = application;
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public final String a() {
        String str = this.l;
        if (str == null) {
            k.a("_umn");
        }
        return str;
    }

    public final void a(CreateMandateUiModel createMandateUiModel, MandateDefaultResponseModel mandateDefaultResponseModel) {
        CreateMandateUiModel createMandateUiModel2 = createMandateUiModel;
        k.c(createMandateUiModel2, "createMandateData");
        k.c(mandateDefaultResponseModel, "createMandateStatus");
        this.f67201d = createMandateUiModel2;
        String status = mandateDefaultResponseModel.getStatus();
        String respCode = mandateDefaultResponseModel.getRespCode();
        String respMessage = mandateDefaultResponseModel.getRespMessage();
        CreateMandateUiModel createMandateUiModel3 = this.f67201d;
        if (createMandateUiModel3 == null) {
            k.a("_createMandateData");
        }
        String amount = createMandateUiModel3.getAmount();
        CreateMandateUiModel createMandateUiModel4 = this.f67201d;
        if (createMandateUiModel4 == null) {
            k.a("_createMandateData");
        }
        String payeeAccountVpa = createMandateUiModel4.getPayeeAccountVpa();
        CreateMandateUiModel createMandateUiModel5 = this.f67201d;
        if (createMandateUiModel5 == null) {
            k.a("_createMandateData");
        }
        String payeeAccountName = createMandateUiModel5.getPayeeAccountName();
        CreateMandateUiModel createMandateUiModel6 = this.f67201d;
        if (createMandateUiModel6 == null) {
            k.a("_createMandateData");
        }
        String payerBankName = createMandateUiModel6.getPayerBankName();
        CreateMandateUiModel createMandateUiModel7 = this.f67201d;
        if (createMandateUiModel7 == null) {
            k.a("_createMandateData");
        }
        String payerBankAcc = createMandateUiModel7.getPayerBankAcc();
        String seqNo = mandateDefaultResponseModel.getSeqNo();
        CreateMandateUiModel createMandateUiModel8 = this.f67201d;
        if (createMandateUiModel8 == null) {
            k.a("_createMandateData");
        }
        String comments = createMandateUiModel8.getComments();
        CreateMandateUiModel createMandateUiModel9 = this.f67201d;
        if (createMandateUiModel9 == null) {
            k.a("_createMandateData");
        }
        String startDate = createMandateUiModel9.getStartDate();
        CreateMandateUiModel createMandateUiModel10 = this.f67201d;
        if (createMandateUiModel10 == null) {
            k.a("_createMandateData");
        }
        String endDate = createMandateUiModel10.getEndDate();
        CreateMandateUiModel createMandateUiModel11 = this.f67201d;
        if (createMandateUiModel11 == null) {
            k.a("_createMandateData");
        }
        net.one97.paytm.upi.mandate.view.model.b bVar = new net.one97.paytm.upi.mandate.view.model.b(true, status, respCode, respMessage, amount, payeeAccountVpa, payeeAccountName, payerBankName, payerBankAcc, seqNo, (String) null, (String) null, comments, startDate, endDate, createMandateUiModel11.getCategory(), 35840);
        this.f67202e = mandateDefaultResponseModel.getQrData();
        this.f67199b.setValue(bVar);
        if (net.one97.paytm.upi.mandate.utils.c.PENDING.getType().equals(mandateDefaultResponseModel.getStatus())) {
            d();
        }
    }

    public final CreateMandateUiModel b() {
        CreateMandateUiModel createMandateUiModel = this.f67201d;
        if (createMandateUiModel == null) {
            k.a("_createMandateData");
        }
        return createMandateUiModel;
    }

    public final net.one97.paytm.upi.mandate.view.model.b c() {
        net.one97.paytm.upi.mandate.view.model.b value = this.f67199b.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "uiStateLiveData.value!!");
        return value;
    }

    private final void d() {
        if (e()) {
            this.k = f();
            C1359a aVar = new C1359a();
            this.f67204h = new Timer();
            Timer timer = this.f67204h;
            if (timer == null) {
                k.a();
            }
            timer.schedule(aVar, ((long) this.k) * 1000);
            this.f67205i++;
        }
    }

    private final boolean e() {
        return this.f67205i < this.j;
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (upiBaseDataModel instanceof CheckMandateStatusResponseModel) {
            CheckMandateStatusResponseModel checkMandateStatusResponseModel = (CheckMandateStatusResponseModel) upiBaseDataModel;
            if (checkMandateStatusResponseModel.isSuccess()) {
                net.one97.paytm.upi.mandate.data.model.b mobileAppData = checkMandateStatusResponseModel.getMobileAppData();
                if (mobileAppData != null) {
                    net.one97.paytm.upi.mandate.data.model.a aVar = mobileAppData.f67154a;
                    String str7 = "";
                    if (aVar == null || (str = aVar.f67152f) == null) {
                        str = str7;
                    }
                    this.l = str;
                    net.one97.paytm.upi.mandate.data.model.a aVar2 = mobileAppData.f67154a;
                    String str8 = null;
                    if (aVar2 != null) {
                        str2 = aVar2.f67147a;
                    } else {
                        str2 = null;
                    }
                    net.one97.paytm.upi.mandate.data.model.a aVar3 = mobileAppData.f67154a;
                    if (!(aVar3 == null || (str6 = aVar3.f67149c) == null)) {
                        str7 = str6;
                    }
                    boolean a2 = p.a((CharSequence) str7, (CharSequence) "ZM", true);
                    net.one97.paytm.upi.mandate.view.model.b c2 = c();
                    if (!e() || (str2 != null && !p.a(str2, "PENDING", true))) {
                        y<net.one97.paytm.upi.mandate.view.model.b> yVar = this.f67199b;
                        boolean e2 = e();
                        net.one97.paytm.upi.mandate.data.model.a aVar4 = mobileAppData.f67154a;
                        if (aVar4 != null) {
                            str3 = aVar4.f67148b;
                        } else {
                            str3 = null;
                        }
                        net.one97.paytm.upi.mandate.data.model.a aVar5 = mobileAppData.f67154a;
                        if (aVar5 != null) {
                            str4 = aVar5.f67150d;
                        } else {
                            str4 = null;
                        }
                        net.one97.paytm.upi.mandate.data.model.a aVar6 = mobileAppData.f67154a;
                        if (aVar6 != null) {
                            str8 = aVar6.f67151e;
                        }
                        yVar.setValue(net.one97.paytm.upi.mandate.view.model.b.a(c2, e2, str2, str4, str3, str8, a2));
                    } else {
                        y<net.one97.paytm.upi.mandate.view.model.b> yVar2 = this.f67199b;
                        boolean e3 = e();
                        net.one97.paytm.upi.mandate.data.model.a aVar7 = mobileAppData.f67154a;
                        if (aVar7 != null) {
                            str5 = aVar7.f67148b;
                        } else {
                            str5 = null;
                        }
                        net.one97.paytm.upi.mandate.data.model.a aVar8 = mobileAppData.f67154a;
                        if (aVar8 != null) {
                            str8 = aVar8.f67151e;
                        }
                        yVar2.setValue(net.one97.paytm.upi.mandate.view.model.b.a(c2, e3, str2, "", str5, str8, a2));
                    }
                    if (net.one97.paytm.upi.mandate.utils.c.PENDING.getType().equals(str2) && e()) {
                        d();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f67199b.setValue(net.one97.paytm.upi.mandate.view.model.b.a(c(), false, "FAILURE", checkMandateStatusResponseModel.getMessage(), (String) null, (String) null, false));
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (!k.a((Object) upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null, (Object) UpiUtils.AUTHENTICATION_FAILURE_401)) {
            d();
        }
    }

    private final int f() {
        return this.m[this.f67205i].intValue();
    }

    public final void onCleared() {
        super.onCleared();
        Timer timer = this.f67204h;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.f67204h;
        if (timer2 != null) {
            timer2.purge();
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.f.a$a  reason: collision with other inner class name */
    final class C1359a extends TimerTask {
        public C1359a() {
        }

        public final void run() {
            a aVar = a.this;
            String upiSequenceNo = UpiUtils.getUpiSequenceNo();
            String str = aVar.c().f67605i;
            if (str == null) {
                k.a();
            }
            String deviceId = UpiUtils.getDeviceId(aVar.f67203f.getApplicationContext());
            k.a((Object) upiSequenceNo, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
            k.a((Object) deviceId, "deviceId");
            String mobile = UpiUtils.getMobile(aVar.f67203f.getApplicationContext());
            k.a((Object) mobile, "UpiUtils.getMobile(app.applicationContext)");
            aVar.f67198a.a(new CheckMandateStatusRequestModel(upiSequenceNo, str, deviceId, "paytm", mobile), (b.a) aVar);
        }
    }

    public static abstract class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        /* renamed from: net.one97.paytm.upi.mandate.f.a$b$a  reason: collision with other inner class name */
        public static final class C1360a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f67207a;

            /* renamed from: b  reason: collision with root package name */
            private final String f67208b;

            /* renamed from: c  reason: collision with root package name */
            private final String f67209c;

            /* renamed from: d  reason: collision with root package name */
            private final String f67210d;

            /* renamed from: e  reason: collision with root package name */
            private final String f67211e;

            /* renamed from: f  reason: collision with root package name */
            private final String f67212f;

            /* renamed from: g  reason: collision with root package name */
            private final String f67213g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1360a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                super((byte) 0);
                k.c(str, "url");
                k.c(str2, "payeeName");
                k.c(str3, "amount");
                k.c(str7, "qrDate");
                this.f67207a = str;
                this.f67208b = str2;
                this.f67209c = str3;
                this.f67210d = str4;
                this.f67211e = str5;
                this.f67212f = str6;
                this.f67213g = str7;
            }
        }
    }
}
