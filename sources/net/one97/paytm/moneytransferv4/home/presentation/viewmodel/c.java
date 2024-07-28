package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel;
import net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.e.d;
import net.one97.paytm.moneytransfer.model.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.RefreshAccountResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.f.b;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class c extends androidx.lifecycle.a {
    public static final b q = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.b.a.b f55600a;

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<e>> f55601b;

    /* renamed from: c  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.a<C1032c>> f55602c;

    /* renamed from: d  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.a<Boolean>> f55603d;

    /* renamed from: e  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<String>> f55604e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public a f55605f;

    /* renamed from: g  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<String>> f55606g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.upi.profile.b.b f55607h;

    /* renamed from: i  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<d>> f55608i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final y<net.one97.paytm.moneytransfer.model.c<ArrayList<UpiProfileDefaultBank>>> o;
    public final Map<String, String> p = new LinkedHashMap();
    private net.one97.paytm.upi.registration.b.a.b r;
    /* access modifiers changed from: private */
    public final y<ArrayList<UpiProfileDefaultBank>> s;
    /* access modifiers changed from: private */
    public final y<String> t;
    /* access modifiers changed from: private */
    public final y<String> u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
        this.f55600a = net.one97.paytm.moneytransfer.b.a(application);
        this.r = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) null);
        this.f55601b = new y<>();
        this.f55602c = new y<>();
        this.f55603d = new y<>();
        this.f55607h = net.one97.paytm.upi.g.a();
        this.f55608i = new y<>();
        this.f55606g = new y<>();
        this.o = new y<>();
        this.s = new y<>();
        this.t = new y<>();
        this.u = new y<>();
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        kotlin.g.b.k.c(str2, "balance");
        this.p.put(str, str2);
    }

    public static final class h implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55621a;

        h(c cVar) {
            this.f55621a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            this.f55621a.a();
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                String str = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str)) {
                    kotlin.g.b.k.a((Object) str, "responseCode");
                    if (net.one97.paytm.moneytransfer.utils.m.a(Integer.parseInt(str))) {
                        y a2 = this.f55621a.f55604e;
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        a2.setValue(c.a.b());
                        return;
                    }
                }
                if (p.a("1006", str, true)) {
                    y b2 = this.f55621a.f55601b;
                    if (b2 != null) {
                        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                        b2.setValue(c.a.a(new e("", 1)));
                        return;
                    }
                    return;
                }
                y b3 = this.f55621a.f55601b;
                if (b3 != null) {
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b3.setValue(c.a.a(upiCustomVolleyError));
                }
            }
        }
    }

    private void i() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.r;
        if (bVar != null) {
            bVar.b((a.C1389a) new h(this), "", "");
        }
    }

    public final void a() {
        net.one97.paytm.moneytransfer.b.a.b bVar = this.f55600a;
        String str = null;
        Boolean valueOf = bVar != null ? Boolean.valueOf(bVar.b()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        boolean z = true;
        if (valueOf.booleanValue()) {
            net.one97.paytm.moneytransfer.b.a.b bVar2 = this.f55600a;
            Boolean valueOf2 = bVar2 != null ? Boolean.valueOf(bVar2.a()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf2.booleanValue()) {
                y<net.one97.paytm.moneytransfer.model.c<e>> yVar = this.f55601b;
                if (yVar != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar.setValue(c.a.a(new e("", 1)));
                    return;
                }
                return;
            }
        }
        y<net.one97.paytm.moneytransfer.model.c<e>> yVar2 = this.f55601b;
        if (yVar2 != null) {
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar2.setValue(c.a.a());
        }
        net.one97.paytm.upi.registration.b.a.b bVar3 = this.r;
        if (bVar3 != null) {
            str = bVar3.b();
        }
        CharSequence charSequence = str;
        if (charSequence != null && !p.a(charSequence)) {
            z = false;
        }
        if (z) {
            i();
            return;
        }
        net.one97.paytm.upi.registration.b.a.b bVar4 = this.r;
        if (bVar4 != null) {
            bVar4.d(new f(this), "", "");
        }
    }

    public static final class f implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55619a;

        f(c cVar) {
            this.f55619a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                y b2 = this.f55619a.f55601b;
                if (b2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b2.setValue(c.a.a(new e(((UpiToken) upiBaseDataModel).getUpiToken(), 0)));
                    return;
                }
                return;
            }
            y b3 = this.f55619a.f55601b;
            if (b3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                b3.setValue(c.a.a(new e("", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null) {
                return;
            }
            if (p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y b2 = this.f55619a.f55601b;
                if (b2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b2.setValue(c.a.a(new e("", 1)));
                    return;
                }
                return;
            }
            y b3 = this.f55619a.f55601b;
            if (b3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                b3.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        net.one97.paytm.moneytransfer.e.d dVar = new net.one97.paytm.moneytransfer.e.d();
        y<net.one97.paytm.moneytransfer.model.a<C1032c>> yVar = this.f55602c;
        if (yVar != null) {
            a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
            yVar.setValue(a.C0968a.a());
        }
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        dVar.a(application, new k(this), str, str2, str3);
    }

    public static final class k implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55624a;

        k(c cVar) {
            this.f55624a = cVar;
        }

        public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
            kotlin.g.b.k.c(pPBPrevalidateResponseModel, Payload.RESPONSE);
            c.a(this.f55624a, pPBPrevalidateResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            y c2 = this.f55624a.f55602c;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.a(networkCustomError));
            }
        }

        public final void a() {
            y c2 = this.f55624a.f55602c;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.b());
            }
        }
    }

    public final void b() {
        net.one97.paytm.moneytransfer.e.d dVar = new net.one97.paytm.moneytransfer.e.d();
        y<net.one97.paytm.moneytransfer.model.a<Boolean>> yVar = this.f55603d;
        if (yVar != null) {
            a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
            yVar.setValue(a.C0968a.a());
        }
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        dVar.a(application, "", new j(this));
    }

    public static final class j implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55623a;

        j(c cVar) {
            this.f55623a = cVar;
        }

        public final void a(boolean z) {
            y d2 = this.f55623a.f55603d;
            if (d2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                d2.setValue(a.C0968a.a((Object) Boolean.valueOf(z)));
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            y d2 = this.f55623a.f55603d;
            if (d2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                d2.setValue(a.C0968a.a((Object) Boolean.FALSE));
            }
        }

        public final void a() {
            y d2 = this.f55623a.f55603d;
            if (d2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                d2.setValue(a.C0968a.b());
            }
        }
    }

    public final void b(String str, String str2, String str3) {
        net.one97.paytm.moneytransfer.e.d dVar = new net.one97.paytm.moneytransfer.e.d();
        y<net.one97.paytm.moneytransfer.model.a<C1032c>> yVar = this.f55602c;
        if (yVar != null) {
            a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
            yVar.setValue(a.C0968a.a());
        }
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        dVar.b(application, new l(this), str, str2, str3);
    }

    public static final class l implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55625a;

        l(c cVar) {
            this.f55625a = cVar;
        }

        public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
            kotlin.g.b.k.c(pPBPrevalidateResponseModel, Payload.RESPONSE);
            c.a(this.f55625a, pPBPrevalidateResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            y c2 = this.f55625a.f55602c;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.a(networkCustomError));
            }
        }

        public final void a() {
            y c2 = this.f55625a.f55602c;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.b());
            }
        }
    }

    public static final class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55622a;

        public i(c cVar) {
            this.f55622a = cVar;
        }

        public final void a(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
            kotlin.g.b.k.c(uPIBankHealthResponseModel, "responseModel");
            this.f55622a.f55605f = new a(uPIBankHealthResponseModel.getAction(), uPIBankHealthResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            this.f55622a.f55605f = new a(UpiConstants.BANK_HEALTH_STATUS_ALLOW, (UPIBankHealthResponseModel) null);
        }
    }

    public static final class m implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55626a;

        public m(c cVar) {
            this.f55626a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof RefreshAccountResponse) {
                RefreshAccountResponse refreshAccountResponse = (RefreshAccountResponse) upiBaseDataModel;
                if (!p.a(refreshAccountResponse.getStatus(), "SUCCESS", true) || !p.a("0", refreshAccountResponse.getRespCode(), true)) {
                    y e2 = this.f55626a.f55608i;
                    if (e2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
                        String respCode = refreshAccountResponse.getRespCode();
                        kotlin.g.b.k.a((Object) respCode, "response.respCode");
                        e2.setValue(c.a.a(new d(bankAccount, 2, respCode)));
                        return;
                    }
                    return;
                }
                y e3 = this.f55626a.f55608i;
                if (e3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    RefreshAccountResponse.RefreshedBankAccount refreshedBankAccount = refreshAccountResponse.getRefreshedBankAccount();
                    kotlin.g.b.k.a((Object) refreshedBankAccount, "response.refreshedBankAccount");
                    BankAccountDetails.BankAccount bankAccount2 = refreshedBankAccount.getBankAccount();
                    kotlin.g.b.k.a((Object) bankAccount2, "response.refreshedBankAccount.bankAccount");
                    e3.setValue(c.a.a(new d(bankAccount2, 0, "")));
                    return;
                }
                return;
            }
            y e4 = this.f55626a.f55608i;
            if (e4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                e4.setValue(c.a.a(new d(new BankAccountDetails.BankAccount(), 2, "")));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y e2 = this.f55626a.f55608i;
            if (e2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                e2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f55617a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f55618b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return kotlin.g.b.k.a((Object) this.f55617a, (Object) eVar.f55617a) && kotlin.g.b.k.a((Object) this.f55618b, (Object) eVar.f55618b);
        }

        public final int hashCode() {
            String str = this.f55617a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.f55618b;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "UPITokenModel(token=" + this.f55617a + ", result=" + this.f55618b + ")";
        }

        public e(String str, Integer num) {
            this.f55617a = str;
            this.f55618b = num;
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c  reason: collision with other inner class name */
    public static final class C1032c {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f55611a;

        /* renamed from: b  reason: collision with root package name */
        public final String f55612b;

        /* renamed from: c  reason: collision with root package name */
        public final String f55613c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1032c)) {
                return false;
            }
            C1032c cVar = (C1032c) obj;
            return kotlin.g.b.k.a((Object) this.f55611a, (Object) cVar.f55611a) && kotlin.g.b.k.a((Object) this.f55612b, (Object) cVar.f55612b) && kotlin.g.b.k.a((Object) this.f55613c, (Object) cVar.f55613c);
        }

        public final int hashCode() {
            Integer num = this.f55611a;
            int i2 = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.f55612b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f55613c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "PrevalidateModel(proceedCode=" + this.f55611a + ", title=" + this.f55612b + ", message=" + this.f55613c + ")";
        }

        public C1032c(Integer num, String str, String str2) {
            this.f55611a = num;
            this.f55612b = str;
            this.f55613c = str2;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f55609a;

        /* renamed from: b  reason: collision with root package name */
        public final UPIBankHealthResponseModel f55610b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f55609a, (Object) aVar.f55609a) && kotlin.g.b.k.a((Object) this.f55610b, (Object) aVar.f55610b);
        }

        public final int hashCode() {
            String str = this.f55609a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            UPIBankHealthResponseModel uPIBankHealthResponseModel = this.f55610b;
            if (uPIBankHealthResponseModel != null) {
                i2 = uPIBankHealthResponseModel.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "BankHealthModel(status=" + this.f55609a + ", upiBankHealthResponseModel=" + this.f55610b + ")";
        }

        public a(String str, UPIBankHealthResponseModel uPIBankHealthResponseModel) {
            this.f55609a = str;
            this.f55610b = uPIBankHealthResponseModel;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final BankAccountDetails.BankAccount f55614a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f55615b;

        /* renamed from: c  reason: collision with root package name */
        public final String f55616c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.g.b.k.a((Object) this.f55614a, (Object) dVar.f55614a) && kotlin.g.b.k.a((Object) this.f55615b, (Object) dVar.f55615b) && kotlin.g.b.k.a((Object) this.f55616c, (Object) dVar.f55616c);
        }

        public final int hashCode() {
            BankAccountDetails.BankAccount bankAccount = this.f55614a;
            int i2 = 0;
            int hashCode = (bankAccount != null ? bankAccount.hashCode() : 0) * 31;
            Integer num = this.f55615b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.f55616c;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "UPIRefreshPinModel(bankAccount=" + this.f55614a + ", result=" + this.f55615b + ", errorCode=" + this.f55616c + ")";
        }

        public d(BankAccountDetails.BankAccount bankAccount, Integer num, String str) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            kotlin.g.b.k.c(str, CLConstants.FIELD_ERROR_CODE);
            this.f55614a = bankAccount;
            this.f55615b = num;
            this.f55616c = str;
        }
    }

    public final boolean c() {
        l.a aVar = net.one97.paytm.moneytransfer.utils.l.f54175a;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        int b2 = l.a.a(application).b("mt_pull_down_count", 0, false);
        c.a aVar2 = net.one97.paytm.moneytransfer.d.c.C;
        if (b2 < net.one97.paytm.moneytransfer.d.c.b(c.a.a().t)) {
            return true;
        }
        return false;
    }

    public static final class g implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55620a;

        g(c cVar) {
            this.f55620a = cVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (kotlin.g.b.k.a((Object) upiProfileModel.getStatus(), (Object) "SUCCESS") && p.a("0", upiProfileModel.getRespCode(), true)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (upiProfileModel.getResponse() != null) {
                        UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                        kotlin.g.b.k.a((Object) response, "profile.response");
                        UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                        kotlin.g.b.k.a((Object) profileDetail, "profile.response\n       …           .profileDetail");
                        if (profileDetail.getProfileVpaList() != null) {
                            UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                            kotlin.g.b.k.a((Object) response2, "profile.response");
                            UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                            kotlin.g.b.k.a((Object) profileDetail2, "profile.response\n       …           .profileDetail");
                            for (UpiProfileDefaultBank next : profileDetail2.getProfileVpaList()) {
                                kotlin.g.b.k.a((Object) next, "upiProfileDefaultBank");
                                if (next.getDebitBank() != null) {
                                    BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                    kotlin.g.b.k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
                                    if (debitBank.getAccount() != null) {
                                        arrayList2.add(next);
                                        BankAccountDetails.BankAccount debitBank2 = next.getDebitBank();
                                        kotlin.g.b.k.a((Object) debitBank2, "upiProfileDefaultBank.debitBank");
                                        linkedHashMap.put(debitBank2.getAccount(), next);
                                    }
                                }
                                if (next.isPrimary()) {
                                    this.f55620a.t.setValue(next.getVirtualAddress());
                                    y g2 = this.f55620a.u;
                                    BankAccountDetails.BankAccount debitBank3 = next.getDebitBank();
                                    g2.setValue(debitBank3 != null ? debitBank3.getCustomerName() : null);
                                }
                            }
                        }
                    }
                    if (upiProfileModel.getResponse() != null) {
                        UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                        kotlin.g.b.k.a((Object) response3, "profile.response");
                        UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                        kotlin.g.b.k.a((Object) profileDetail3, "profile.response.profileDetail");
                        if (profileDetail3.getBankAccountList() != null) {
                            UpiProfileModel.AccountDetails response4 = upiProfileModel.getResponse();
                            kotlin.g.b.k.a((Object) response4, "profile.response");
                            UpiProfileModel.ProfileDetails profileDetail4 = response4.getProfileDetail();
                            kotlin.g.b.k.a((Object) profileDetail4, "profile.response.profileDetail");
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetail4.getBankAccountList();
                            kotlin.g.b.k.a((Object) bankAccountList, "profile.response.profileDetail.bankAccountList");
                            for (BankAccountDetails.BankAccount debitBank4 : bankAccountList) {
                                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                                upiProfileDefaultBank.setDebitBank(debitBank4);
                                upiProfileDefaultBank.setVirtualAddress((String) this.f55620a.t.getValue());
                                BankAccountDetails.BankAccount debitBank5 = upiProfileDefaultBank.getDebitBank();
                                kotlin.g.b.k.a((Object) debitBank5, "upiProfileDefaultBank.debitBank");
                                linkedHashMap.put(debitBank5.getAccount(), upiProfileDefaultBank);
                            }
                        }
                    }
                    for (Map.Entry value : linkedHashMap.entrySet()) {
                        Object value2 = value.getValue();
                        if (value2 == null) {
                            kotlin.g.b.k.a();
                        }
                        arrayList.add(value2);
                    }
                    y h2 = this.f55620a.o;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    h2.setValue(c.a.a(arrayList));
                    this.f55620a.s.setValue(arrayList2);
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            String str = upiCustomVolleyError.getmErrorCode();
            if (kotlin.g.b.k.a((Object) UpiUtils.AUTHENTICATION_FAILURE_401, (Object) str) || kotlin.g.b.k.a((Object) "410", (Object) str)) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c.a.b();
                return;
            }
            y h2 = this.f55620a.o;
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            h2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void d() {
        net.one97.paytm.upi.profile.b.b bVar = this.f55607h;
        if (bVar == null) {
            kotlin.g.b.k.a();
        }
        bVar.a((a.C1382a) new g(this), "", "");
    }

    public final y<String> e() {
        y<String> yVar = this.t;
        if (yVar == null) {
            kotlin.g.b.k.a();
        }
        return yVar;
    }

    public final y<String> f() {
        y<String> yVar = this.u;
        if (yVar == null) {
            kotlin.g.b.k.a();
        }
        return yVar;
    }

    public final Boolean g() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.r;
        if (bVar != null) {
            return Boolean.valueOf(bVar.e());
        }
        return null;
    }

    public final String h() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.r;
        if (bVar != null) {
            return bVar.n();
        }
        return null;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(c cVar, Bundle bundle) {
        y<net.one97.paytm.moneytransfer.model.c<String>> yVar;
        y<net.one97.paytm.moneytransfer.model.c<String>> yVar2;
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                if (cVar.j && p.a(string, "USER_ABORTED", true) && (yVar2 = cVar.f55606g) != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar2.setValue(c.a.a((UpiCustomVolleyError) null));
                }
                if ((cVar.k || cVar.j || cVar.l || cVar.m || cVar.n) && (yVar = cVar.f55606g) != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar.setValue(c.a.a((UpiCustomVolleyError) null));
                    return;
                }
                return;
            }
        }
        Serializable serializable = bundle.getSerializable("credBlocks");
        if (serializable != null) {
            HashMap hashMap = (HashMap) serializable;
            String str = "";
            for (String str2 : hashMap.keySet()) {
                try {
                    JSONObject jSONObject = new JSONObject((String) hashMap.get(str2));
                    q.a(jSONObject.toString());
                    str = jSONObject.getJSONObject("data").getString("code") + AppConstants.COMMA + jSONObject.getJSONObject("data").getString(CLConstants.FIELD_KI) + AppConstants.COMMA + jSONObject.getJSONObject("data").getString("encryptedBase64String");
                    q.a(jSONObject.getJSONObject("data").getString("encryptedBase64String"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            y<net.one97.paytm.moneytransfer.model.c<String>> yVar3 = cVar.f55606g;
            if (yVar3 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar3.setValue(c.a.a(str));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0189, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x018b, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x018d, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0196, code lost:
        if (r6 == null) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0198, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x019d, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x019e, code lost:
        if (r6 == null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01a0, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01a4, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(3, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        if (r6 == null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        r1 = java.lang.Boolean.valueOf(r6.getProceedFlag());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r1 != null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        if (r1.booleanValue() == false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0093, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
        if (r6 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a3, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a4, code lost:
        if (r6 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a6, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00aa, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(0, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b9, code lost:
        if (r6.getResponseCode() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bb, code lost:
        r1 = r6.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c0, code lost:
        if (r1 != null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c9, code lost:
        if (r1.intValue() != 1281) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cb, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cd, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cf, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d7, code lost:
        if (r6 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d9, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00de, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00df, code lost:
        if (r6 == null) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e1, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e5, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(4, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f0, code lost:
        if (r1 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f9, code lost:
        if (r1.intValue() != 1124) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fd, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ff, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0107, code lost:
        if (r6 == null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0109, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010f, code lost:
        if (r6 == null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0111, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0115, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(4, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0120, code lost:
        if (r1 != null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
        if (r1.intValue() != 1005) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012b, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x012d, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012f, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0137, code lost:
        if (r6 == null) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0139, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013f, code lost:
        if (r6 == null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0141, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0145, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(4, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0150, code lost:
        if (r1 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0152, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0159, code lost:
        if (r1.intValue() != 1893) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015b, code lost:
        r5 = r5.f55602c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015d, code lost:
        if (r5 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x015f, code lost:
        r1 = net.one97.paytm.moneytransfer.model.a.f54024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0168, code lost:
        if (r6 == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016a, code lost:
        r3 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016f, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0170, code lost:
        if (r6 == null) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0172, code lost:
        r0 = r6.getTooltipMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0176, code lost:
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.C1032c(2, r3, r0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c r5, net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x000c
            boolean r1 = r6.getDisplayMessageFlag()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            if (r1 != 0) goto L_0x0012
            kotlin.g.b.k.a()
        L_0x0012:
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01af
            if (r6 == 0) goto L_0x001f
            java.lang.String r1 = r6.getAccountStatus()
            goto L_0x0020
        L_0x001f:
            r1 = r0
        L_0x0020:
            if (r1 != 0) goto L_0x0023
            return
        L_0x0023:
            int r2 = r1.hashCode()
            switch(r2) {
                case -1284940774: goto L_0x0181;
                case 2432586: goto L_0x0070;
                case 90759495: goto L_0x0067;
                case 472894066: goto L_0x005d;
                case 696544716: goto L_0x0053;
                case 807292011: goto L_0x0049;
                case 1925346054: goto L_0x0040;
                case 1990776172: goto L_0x0036;
                case 2082211488: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x01ae
        L_0x002c:
            java.lang.String r2 = "FROZEN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0189
        L_0x0036:
            java.lang.String r2 = "CLOSED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0189
        L_0x0040:
            java.lang.String r2 = "ACTIVE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0078
        L_0x0049:
            java.lang.String r2 = "INACTIVE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0189
        L_0x0053:
            java.lang.String r2 = "BLOCKED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0189
        L_0x005d:
            java.lang.String r2 = "TOTAL_FREEZED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0189
        L_0x0067:
            java.lang.String r2 = "CREDIT_FREEZED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
            goto L_0x0078
        L_0x0070:
            java.lang.String r2 = "OPEN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
        L_0x0078:
            if (r6 == 0) goto L_0x0083
            boolean r1 = r6.getProceedFlag()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0084
        L_0x0083:
            r1 = r0
        L_0x0084:
            if (r1 != 0) goto L_0x0089
            kotlin.g.b.k.a()
        L_0x0089:
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00b5
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x00b4
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x00a3
            java.lang.String r3 = r6.getMessage()
            goto L_0x00a4
        L_0x00a3:
            r3 = r0
        L_0x00a4:
            if (r6 == 0) goto L_0x00aa
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x00aa:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x00b4:
            return
        L_0x00b5:
            java.lang.Integer r1 = r6.getResponseCode()
            if (r1 == 0) goto L_0x0180
            java.lang.Integer r1 = r6.getResponseCode()
            r2 = 4
            if (r1 != 0) goto L_0x00c3
            goto L_0x00f0
        L_0x00c3:
            int r3 = r1.intValue()
            r4 = 1281(0x501, float:1.795E-42)
            if (r3 != r4) goto L_0x00f0
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x00ef
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x00de
            java.lang.String r3 = r6.getMessage()
            goto L_0x00df
        L_0x00de:
            r3 = r0
        L_0x00df:
            if (r6 == 0) goto L_0x00e5
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x00e5:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x00ef:
            return
        L_0x00f0:
            if (r1 != 0) goto L_0x00f3
            goto L_0x0120
        L_0x00f3:
            int r3 = r1.intValue()
            r4 = 1124(0x464, float:1.575E-42)
            if (r3 != r4) goto L_0x0120
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x011f
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x010e
            java.lang.String r3 = r6.getMessage()
            goto L_0x010f
        L_0x010e:
            r3 = r0
        L_0x010f:
            if (r6 == 0) goto L_0x0115
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x0115:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x011f:
            return
        L_0x0120:
            if (r1 != 0) goto L_0x0123
            goto L_0x0150
        L_0x0123:
            int r3 = r1.intValue()
            r4 = 1005(0x3ed, float:1.408E-42)
            if (r3 != r4) goto L_0x0150
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x014f
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x013e
            java.lang.String r3 = r6.getMessage()
            goto L_0x013f
        L_0x013e:
            r3 = r0
        L_0x013f:
            if (r6 == 0) goto L_0x0145
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x0145:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x014f:
            return
        L_0x0150:
            if (r1 != 0) goto L_0x0153
            return
        L_0x0153:
            int r1 = r1.intValue()
            r2 = 1893(0x765, float:2.653E-42)
            if (r1 != r2) goto L_0x0180
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x0180
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x016f
            java.lang.String r3 = r6.getMessage()
            goto L_0x0170
        L_0x016f:
            r3 = r0
        L_0x0170:
            if (r6 == 0) goto L_0x0176
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x0176:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x0180:
            return
        L_0x0181:
            java.lang.String r2 = "DEBIT_FREEZED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ae
        L_0x0189:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x01ae
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r1 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            r2 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r6 == 0) goto L_0x019d
            java.lang.String r3 = r6.getMessage()
            goto L_0x019e
        L_0x019d:
            r3 = r0
        L_0x019e:
            if (r6 == 0) goto L_0x01a4
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x01a4:
            r1.<init>(r2, r3, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r1)
            r5.setValue(r6)
        L_0x01ae:
            return
        L_0x01af:
            if (r6 == 0) goto L_0x01b6
            java.lang.String r1 = r6.getMessage()
            goto L_0x01b7
        L_0x01b6:
            r1 = r0
        L_0x01b7:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01c6
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r2)
        L_0x01c6:
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c>> r5 = r5.f55602c
            if (r5 == 0) goto L_0x01e3
            net.one97.paytm.moneytransfer.model.a$a r2 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c r2 = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c$c
            r3 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            if (r6 == 0) goto L_0x01d9
            java.lang.String r0 = r6.getTooltipMessage()
        L_0x01d9:
            r2.<init>(r3, r1, r0)
            net.one97.paytm.moneytransfer.model.a r6 = net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) r2)
            r5.setValue(r6)
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c, net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel):void");
    }
}
