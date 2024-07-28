package net.one97.paytm.passbook.landing.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.passbook.beans.BankAccStatusListener;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;

public final class g extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final g f57781b = new g();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57783a;

        b(y yVar) {
            this.f57783a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRAccountSummary) {
                y yVar = this.f57783a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    static final class d<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57785a;

        d(y yVar) {
            this.f57785a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRAccountSummary) {
                y yVar = this.f57785a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    public static final class f<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57787a;

        public f(y yVar) {
            this.f57787a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CustProductList) {
                y yVar = this.f57787a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    static final class h<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57789a;

        h(y yVar) {
            this.f57789a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CustProductList) {
                y yVar = this.f57789a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private g() {
    }

    public static final class e implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57786a;

        public e(y yVar) {
            this.f57786a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CustProductList) {
                y yVar = this.f57786a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final LiveData<net.one97.paytm.passbook.mapping.a.f<CustProductList>> b() {
        y yVar = new y();
        String str = com.paytm.utility.b.e(a(), net.one97.paytm.passbook.d.b().a(UpiConstantServiceApi.GTM_KEY_PPB_CURRENT_ACCOUNT_URL)) + "&accType=ICA";
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(a());
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put("User-Token", a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        k.a((Object) str, "custProductListUrl");
        a(str, new CustProductList(), hashMap, new h(yVar), new C1096g(yVar));
        return yVar;
    }

    /* renamed from: net.one97.paytm.passbook.landing.repositories.g$g  reason: collision with other inner class name */
    static final class C1096g implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57788a;

        C1096g(y yVar) {
            this.f57788a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CustProductList) {
                y yVar = this.f57788a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final LiveData<net.one97.paytm.passbook.mapping.a.f<CJRAccountSummary>> c() {
        y yVar = new y();
        k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String k = net.one97.paytm.passbook.mapping.e.k();
        Map hashMap = new HashMap();
        String lowerCase = "Authorization".toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        String a2 = net.one97.paytm.passbook.mapping.b.a(a());
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put(lowerCase, a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        k.a((Object) k, "userBalanceUrl");
        a(k, new CJRAccountSummary(), hashMap, new b(yVar), new a(yVar));
        return yVar;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57782a;

        a(y yVar) {
            this.f57782a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                y yVar = this.f57782a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final LiveData<net.one97.paytm.passbook.mapping.a.f<CJRAccountSummary>> a(String str) {
        k.c(str, "currentAcctRefId");
        y yVar = new y();
        String a2 = net.one97.paytm.passbook.d.b().a(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
        k.a((Object) a2, "PassbookHelper.getImplLi…nt_bank_balance_new_URL\")");
        String str2 = p.a(a2, "account_type=isa", "", false) + "&account_ref_id=" + str + "&account_type=ica";
        Map hashMap = new HashMap();
        String lowerCase = "Authorization".toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        String a3 = net.one97.paytm.passbook.mapping.b.a(a());
        k.a((Object) a3, "CJRServerUtility.getSSOToken(context)");
        hashMap.put(lowerCase, a3);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        a(str2, new CJRAccountSummary(), hashMap, new d(yVar), new c(yVar));
        return yVar;
    }

    static final class c implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57784a;

        c(y yVar) {
            this.f57784a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                y yVar = this.f57784a;
                f.a aVar = net.one97.paytm.passbook.mapping.a.f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final void a(BankAccStatusListener bankAccStatusListener) {
        net.one97.paytm.passbook.d.b().a(a(), bankAccStatusListener);
    }

    public static boolean d() {
        return net.one97.paytm.passbook.d.b().a("icaEnabled", false);
    }
}
