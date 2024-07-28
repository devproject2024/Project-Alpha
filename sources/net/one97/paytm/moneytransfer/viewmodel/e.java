package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel;
import net.one97.paytm.common.entity.moneytransfer.UPIBankHealthResponseModel;
import net.one97.paytm.moneytransfer.e.d;
import net.one97.paytm.moneytransfer.model.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.RefreshAccountResponse;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.f.b;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class e extends androidx.lifecycle.a {
    public static final b l = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<C0981e>> f54728a;

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.a<c>> f54729b;

    /* renamed from: c  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<String>> f54730c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public a f54731d;

    /* renamed from: e  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<String>> f54732e;

    /* renamed from: f  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<d>> f54733f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54734g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54735h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54736i;
    public boolean j;
    public boolean k;
    private net.one97.paytm.moneytransfer.b.a.b m;
    private net.one97.paytm.upi.registration.b.a.b n;
    private net.one97.paytm.upi.profile.b.b o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
        this.m = net.one97.paytm.moneytransfer.b.a(application);
        this.n = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) null);
        this.f54728a = new y<>();
        this.f54729b = new y<>();
        this.o = net.one97.paytm.upi.g.a();
        this.f54733f = new y<>();
        this.f54732e = new y<>();
    }

    public static final class g implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54748a;

        g(e eVar) {
            this.f54748a = eVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            this.f54748a.a();
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                String str = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str)) {
                    kotlin.g.b.k.a((Object) str, "responseCode");
                    if (m.a(Integer.parseInt(str))) {
                        y a2 = this.f54748a.f54730c;
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        a2.setValue(c.a.b());
                        return;
                    }
                }
                if (p.a("1006", str, true)) {
                    y b2 = this.f54748a.f54728a;
                    if (b2 != null) {
                        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                        b2.setValue(c.a.a(new C0981e("", 1)));
                        return;
                    }
                    return;
                }
                y b3 = this.f54748a.f54728a;
                if (b3 != null) {
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b3.setValue(c.a.a(upiCustomVolleyError));
                }
            }
        }
    }

    private void b() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.n;
        if (bVar != null) {
            bVar.b((a.C1389a) new g(this), "", "");
        }
    }

    public final void a() {
        net.one97.paytm.moneytransfer.b.a.b bVar = this.m;
        String str = null;
        Boolean valueOf = bVar != null ? Boolean.valueOf(bVar.b()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        boolean z = true;
        if (valueOf.booleanValue()) {
            net.one97.paytm.moneytransfer.b.a.b bVar2 = this.m;
            Boolean valueOf2 = bVar2 != null ? Boolean.valueOf(bVar2.a()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf2.booleanValue()) {
                y<net.one97.paytm.moneytransfer.model.c<C0981e>> yVar = this.f54728a;
                if (yVar != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar.setValue(c.a.a(new C0981e("", 1)));
                    return;
                }
                return;
            }
        }
        y<net.one97.paytm.moneytransfer.model.c<C0981e>> yVar2 = this.f54728a;
        if (yVar2 != null) {
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar2.setValue(c.a.a());
        }
        net.one97.paytm.upi.registration.b.a.b bVar3 = this.n;
        if (bVar3 != null) {
            str = bVar3.b();
        }
        CharSequence charSequence = str;
        if (charSequence != null && !p.a(charSequence)) {
            z = false;
        }
        if (z) {
            b();
            return;
        }
        net.one97.paytm.upi.registration.b.a.b bVar4 = this.n;
        if (bVar4 != null) {
            bVar4.d(new f(this), "", "");
        }
    }

    public static final class f implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54747a;

        f(e eVar) {
            this.f54747a = eVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                y b2 = this.f54747a.f54728a;
                if (b2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b2.setValue(c.a.a(new C0981e(((UpiToken) upiBaseDataModel).getUpiToken(), 0)));
                    return;
                }
                return;
            }
            y b3 = this.f54747a.f54728a;
            if (b3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                b3.setValue(c.a.a(new C0981e("", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null) {
                return;
            }
            if (p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y b2 = this.f54747a.f54728a;
                if (b2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    b2.setValue(c.a.a(new C0981e("", 1)));
                    return;
                }
                return;
            }
            y b3 = this.f54747a.f54728a;
            if (b3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                b3.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends BankAccountDetails.BankAccountCredentials> list, String str12) {
        try {
            net.one97.paytm.moneytransfer.b.a.b bVar = this.m;
            if (bVar != null) {
                bVar.a(str, str2, str3, str4, str5, str6, new CLRemoteResultReceiver(new MoneyTransferPaymentViewModel$fetchMPin$1(this, new Handler())), str7, str8, str9, str10, str11, list, str12);
            }
        } catch (IllegalStateException unused) {
            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
            upiCustomVolleyError.setAlertMessage(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG.toString());
            y<net.one97.paytm.moneytransfer.model.c<String>> yVar = this.f54732e;
            if (yVar != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        net.one97.paytm.moneytransfer.e.d dVar = new net.one97.paytm.moneytransfer.e.d();
        y<net.one97.paytm.moneytransfer.model.a<c>> yVar = this.f54729b;
        if (yVar != null) {
            a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
            yVar.setValue(a.C0968a.a());
        }
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        dVar.a(application, new i(this), str, str2, str3);
    }

    public static final class i implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54750a;

        i(e eVar) {
            this.f54750a = eVar;
        }

        public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
            kotlin.g.b.k.c(pPBPrevalidateResponseModel, Payload.RESPONSE);
            e.a(this.f54750a, pPBPrevalidateResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            y c2 = this.f54750a.f54729b;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.a(networkCustomError));
            }
        }

        public final void a() {
            y c2 = this.f54750a.f54729b;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.b());
            }
        }
    }

    public final void b(String str, String str2, String str3) {
        net.one97.paytm.moneytransfer.e.d dVar = new net.one97.paytm.moneytransfer.e.d();
        y<net.one97.paytm.moneytransfer.model.a<c>> yVar = this.f54729b;
        if (yVar != null) {
            a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
            yVar.setValue(a.C0968a.a());
        }
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "getApplication()");
        dVar.b(application, new j(this), str, str2, str3);
    }

    public static final class j implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54751a;

        j(e eVar) {
            this.f54751a = eVar;
        }

        public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
            kotlin.g.b.k.c(pPBPrevalidateResponseModel, Payload.RESPONSE);
            e.a(this.f54751a, pPBPrevalidateResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            y c2 = this.f54751a.f54729b;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.a(networkCustomError));
            }
        }

        public final void a() {
            y c2 = this.f54751a.f54729b;
            if (c2 != null) {
                a.C0968a aVar = net.one97.paytm.moneytransfer.model.a.f54024d;
                c2.setValue(a.C0968a.b());
            }
        }
    }

    public static final class h implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54749a;

        public h(e eVar) {
            this.f54749a = eVar;
        }

        public final void a(UPIBankHealthResponseModel uPIBankHealthResponseModel) {
            kotlin.g.b.k.c(uPIBankHealthResponseModel, "responseModel");
            this.f54749a.f54731d = new a(uPIBankHealthResponseModel.getAction(), uPIBankHealthResponseModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            this.f54749a.f54731d = new a(UpiConstants.BANK_HEALTH_STATUS_ALLOW, (UPIBankHealthResponseModel) null);
        }
    }

    public static final class k implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54752a;

        k(e eVar) {
            this.f54752a = eVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof RefreshAccountResponse) {
                RefreshAccountResponse refreshAccountResponse = (RefreshAccountResponse) upiBaseDataModel;
                if (!p.a(refreshAccountResponse.getStatus(), "SUCCESS", true) || !p.a("0", refreshAccountResponse.getRespCode(), true)) {
                    y d2 = this.f54752a.f54733f;
                    if (d2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
                        String respCode = refreshAccountResponse.getRespCode();
                        kotlin.g.b.k.a((Object) respCode, "response.respCode");
                        d2.setValue(c.a.a(new d(bankAccount, 2, respCode)));
                        return;
                    }
                    return;
                }
                y d3 = this.f54752a.f54733f;
                if (d3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    RefreshAccountResponse.RefreshedBankAccount refreshedBankAccount = refreshAccountResponse.getRefreshedBankAccount();
                    kotlin.g.b.k.a((Object) refreshedBankAccount, "response.refreshedBankAccount");
                    BankAccountDetails.BankAccount bankAccount2 = refreshedBankAccount.getBankAccount();
                    kotlin.g.b.k.a((Object) bankAccount2, "response.refreshedBankAccount.bankAccount");
                    d3.setValue(c.a.a(new d(bankAccount2, 0, "")));
                    return;
                }
                return;
            }
            y d4 = this.f54752a.f54733f;
            if (d4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                d4.setValue(c.a.a(new d(new BankAccountDetails.BankAccount(), 2, "")));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y d2 = this.f54752a.f54733f;
            if (d2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                d2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public final void a(UserUpiDetails userUpiDetails) {
        kotlin.g.b.k.c(userUpiDetails, "userUpiDetails");
        y<net.one97.paytm.moneytransfer.model.c<d>> yVar = this.f54733f;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        net.one97.paytm.upi.profile.b.b bVar = this.o;
        if (bVar != null) {
            bVar.a(userUpiDetails, UpiConstants.RefreshAccountOperations.SYNC_MPIN_ACCOUNT, (a.C1382a) new k(this), "");
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.viewmodel.e$e  reason: collision with other inner class name */
    public static final class C0981e {

        /* renamed from: a  reason: collision with root package name */
        public final String f54745a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f54746b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0981e)) {
                return false;
            }
            C0981e eVar = (C0981e) obj;
            return kotlin.g.b.k.a((Object) this.f54745a, (Object) eVar.f54745a) && kotlin.g.b.k.a((Object) this.f54746b, (Object) eVar.f54746b);
        }

        public final int hashCode() {
            String str = this.f54745a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.f54746b;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "UPITokenModel(token=" + this.f54745a + ", result=" + this.f54746b + ")";
        }

        public C0981e(String str, Integer num) {
            this.f54745a = str;
            this.f54746b = num;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f54739a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54740b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54741c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.g.b.k.a((Object) this.f54739a, (Object) cVar.f54739a) && kotlin.g.b.k.a((Object) this.f54740b, (Object) cVar.f54740b) && kotlin.g.b.k.a((Object) this.f54741c, (Object) cVar.f54741c);
        }

        public final int hashCode() {
            Integer num = this.f54739a;
            int i2 = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.f54740b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f54741c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "PrevalidateModel(proceedCode=" + this.f54739a + ", title=" + this.f54740b + ", message=" + this.f54741c + ")";
        }

        public c(Integer num, String str, String str2) {
            this.f54739a = num;
            this.f54740b = str;
            this.f54741c = str2;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f54737a;

        /* renamed from: b  reason: collision with root package name */
        public final UPIBankHealthResponseModel f54738b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f54737a, (Object) aVar.f54737a) && kotlin.g.b.k.a((Object) this.f54738b, (Object) aVar.f54738b);
        }

        public final int hashCode() {
            String str = this.f54737a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            UPIBankHealthResponseModel uPIBankHealthResponseModel = this.f54738b;
            if (uPIBankHealthResponseModel != null) {
                i2 = uPIBankHealthResponseModel.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "BankHealthModel(status=" + this.f54737a + ", upiBankHealthResponseModel=" + this.f54738b + ")";
        }

        public a(String str, UPIBankHealthResponseModel uPIBankHealthResponseModel) {
            this.f54737a = str;
            this.f54738b = uPIBankHealthResponseModel;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final BankAccountDetails.BankAccount f54742a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f54743b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54744c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.g.b.k.a((Object) this.f54742a, (Object) dVar.f54742a) && kotlin.g.b.k.a((Object) this.f54743b, (Object) dVar.f54743b) && kotlin.g.b.k.a((Object) this.f54744c, (Object) dVar.f54744c);
        }

        public final int hashCode() {
            BankAccountDetails.BankAccount bankAccount = this.f54742a;
            int i2 = 0;
            int hashCode = (bankAccount != null ? bankAccount.hashCode() : 0) * 31;
            Integer num = this.f54743b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.f54744c;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "UPIRefreshPinModel(bankAccount=" + this.f54742a + ", result=" + this.f54743b + ", errorCode=" + this.f54744c + ")";
        }

        public d(BankAccountDetails.BankAccount bankAccount, Integer num, String str) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            kotlin.g.b.k.c(str, CLConstants.FIELD_ERROR_CODE);
            this.f54742a = bankAccount;
            this.f54743b = num;
            this.f54744c = str;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(e eVar, Bundle bundle) {
        y<net.one97.paytm.moneytransfer.model.c<String>> yVar;
        y<net.one97.paytm.moneytransfer.model.c<String>> yVar2;
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                if (eVar.f54734g && p.a(string, "USER_ABORTED", true) && (yVar2 = eVar.f54732e) != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar2.setValue(c.a.a((UpiCustomVolleyError) null));
                }
                if ((eVar.f54735h || eVar.f54734g || eVar.f54736i || eVar.j || eVar.k) && (yVar = eVar.f54732e) != null) {
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
            y<net.one97.paytm.moneytransfer.model.c<String>> yVar3 = eVar.f54732e;
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
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(3, r3, r0)));
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
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(0, r3, r0)));
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
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(4, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f0, code lost:
        if (r1 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f9, code lost:
        if (r1.intValue() != 1124) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(4, r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0120, code lost:
        if (r1 != null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
        if (r1.intValue() != 1005) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012b, code lost:
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(4, r3, r0)));
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
        r5 = r5.f54729b;
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
        r5.setValue(net.one97.paytm.moneytransfer.model.a.C0968a.a((java.lang.Object) new net.one97.paytm.moneytransfer.viewmodel.e.c(2, r3, r0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.viewmodel.e r5, net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel r6) {
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x00b4
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x00ef
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x011f
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x014f
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x0180
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x01ae
            net.one97.paytm.moneytransfer.model.a$a r1 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r1 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
            androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.a<net.one97.paytm.moneytransfer.viewmodel.e$c>> r5 = r5.f54729b
            if (r5 == 0) goto L_0x01e3
            net.one97.paytm.moneytransfer.model.a$a r2 = net.one97.paytm.moneytransfer.model.a.f54024d
            net.one97.paytm.moneytransfer.viewmodel.e$c r2 = new net.one97.paytm.moneytransfer.viewmodel.e$c
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.viewmodel.e.a(net.one97.paytm.moneytransfer.viewmodel.e, net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel):void");
    }
}
