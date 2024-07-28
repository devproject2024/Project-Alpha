package net.one97.paytm.upi.mandate.f;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.AuthMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandateListResponseModel;
import net.one97.paytm.upi.mandate.utils.c;
import net.one97.paytm.upi.mandate.utils.f;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends androidx.lifecycle.a implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public int f67214a;

    /* renamed from: b  reason: collision with root package name */
    public final y<net.one97.paytm.upi.mandate.data.a<List<MandateItem>>> f67215b;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.upi.mandate.data.b f67216c = g.a((Context) getApplication());

    /* renamed from: d  reason: collision with root package name */
    private final i f67217d;

    /* renamed from: e  reason: collision with root package name */
    private MandateItem f67218e;

    /* renamed from: f  reason: collision with root package name */
    private String f67219f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f67220g;

    /* renamed from: h  reason: collision with root package name */
    private BankAccountDetails.BankAccount f67221h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final y<net.one97.paytm.upi.mandate.data.a<String>> f67222i;
    /* access modifiers changed from: private */
    public MandateDefaultResponseModel j;
    private final Application k;

    public final void a(t tVar) {
        k.c(tVar, "error");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.k = application;
        Context applicationContext = this.k.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        this.f67217d = new i(applicationContext);
        this.f67215b = new y<>();
        this.f67222i = new y<>();
        this.f67217d.a((i.a) this);
    }

    public final void a() {
        this.f67220g = f.a(this.f67214a);
        y<net.one97.paytm.upi.mandate.data.a<List<MandateItem>>> yVar = this.f67215b;
        a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
        yVar.setValue(a.C1355a.a(this.f67220g));
        this.f67216c.a(this.f67214a, (b.a) new C1361b(this));
    }

    /* renamed from: net.one97.paytm.upi.mandate.f.b$b  reason: collision with other inner class name */
    public static final class C1361b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67224a;

        C1361b(b bVar) {
            this.f67224a = bVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateListResponseModel) {
                MandateListResponseModel mandateListResponseModel = (MandateListResponseModel) upiBaseDataModel;
                if (p.a("FAILURE", mandateListResponseModel.getStatus(), true)) {
                    y a2 = this.f67224a.f67215b;
                    a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
                    a2.setValue(a.C1355a.a(new UpiCustomVolleyError(mandateListResponseModel.getRespMessage()), this.f67224a.f67220g));
                    return;
                }
                List<MandateItem> mandateItemList = mandateListResponseModel.getMandateItemList();
                if (mandateItemList != null) {
                    for (MandateItem mandateItem : mandateItemList) {
                        mandateItem.setValidityStartDate(b.b(mandateItem.getValidityStartDate()));
                        mandateItem.setValidityEndDate(b.b(mandateItem.getValidityEndDate()));
                    }
                }
                y a3 = this.f67224a.f67215b;
                a.C1355a aVar2 = net.one97.paytm.upi.mandate.data.a.f67116e;
                a3.setValue(a.C1355a.a(mandateItemList, this.f67224a.f67220g));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y a2 = this.f67224a.f67215b;
            a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
            a2.setValue(a.C1355a.a(upiCustomVolleyError, this.f67224a.f67220g));
        }
    }

    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67223a;

        a(b bVar) {
            this.f67223a = bVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
                MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
                if (k.a((Object) c.FAILURE.getType(), (Object) mandateDefaultResponseModel.getStatus())) {
                    k.a((Object) mandateDefaultResponseModel.getRespCode(), (Object) "1006");
                    return;
                }
                y c2 = this.f67223a.f67222i;
                a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
                c2.setValue(a.C1355a.a(mandateDefaultResponseModel.getRespMessage(), false));
                this.f67223a.j = mandateDefaultResponseModel;
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y c2 = this.f67223a.f67222i;
            a.C1355a aVar = net.one97.paytm.upi.mandate.data.a.f67116e;
            c2.setValue(a.C1355a.a(upiCustomVolleyError, false));
        }
    }

    public final void a(String str) {
        String str2;
        k.c(str, PayUtility.MPIN);
        MandateItem mandateItem = this.f67218e;
        if (mandateItem == null) {
            k.a("_mandateItem");
        }
        String txnId = mandateItem.getTxnId();
        String deviceId = UpiUtils.getDeviceId(getApplication());
        k.a((Object) deviceId, "UpiUtils.getDeviceId(getApplication())");
        String str3 = this.f67219f;
        if (str3 == null) {
            k.a("_authorizationType");
        }
        MandateItem mandateItem2 = this.f67218e;
        if (mandateItem2 == null) {
            k.a("_mandateItem");
        }
        String umn = mandateItem2.getUmn();
        MandateItem mandateItem3 = this.f67218e;
        if (mandateItem3 == null) {
            k.a("_mandateItem");
        }
        String bankIfsc = mandateItem3.getPayer().getBankIfsc();
        if (bankIfsc == null) {
            k.a();
        }
        MandateItem mandateItem4 = this.f67218e;
        if (mandateItem4 == null) {
            k.a("_mandateItem");
        }
        String bankAccount = mandateItem4.getPayer().getBankAccount();
        if (bankAccount == null) {
            k.a();
        }
        BankAccountDetails.BankAccount bankAccount2 = this.f67221h;
        if (bankAccount2 == null || (str2 = bankAccount2.getAccRefId()) == null) {
            str2 = "";
        }
        this.f67216c.a(new AuthMandateRequestModel(txnId, deviceId, str3, str, umn, bankIfsc, bankAccount, str2, ""), (b.a) new a(this));
    }

    public static final /* synthetic */ String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
        if (str == null) {
            k.a();
        }
        return simpleDateFormat.format(new Date(Long.parseLong(str)));
    }
}
