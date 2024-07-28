package net.one97.paytm.passbook.mlv.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.s;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mlv.MLVListResponse;
import net.one97.paytm.passbook.beans.mlv.MLVPaginator;
import net.one97.paytm.passbook.beans.mlv.MLVResponse;
import net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail;
import net.one97.paytm.passbook.beans.mlv.Result;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    int f58123a;

    /* renamed from: b  reason: collision with root package name */
    int f58124b = 20;

    /* renamed from: c  reason: collision with root package name */
    public y<x> f58125c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f58126d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<e> f58127e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<ArrayList<MLVUserCardDetail>> f58128f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> f58129g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<String> f58130h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<MLVUserCardDetail> f58131i = new ArrayList<>();
    boolean j;

    static final class a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58132a;

        a(c cVar) {
            this.f58132a = cVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            this.f58132a.f58126d.postValue(Boolean.FALSE);
            if (iJRDataModel != null) {
                MLVResponse response = ((MLVListResponse) iJRDataModel).getResponse();
                Result result = response != null ? response.getResult() : null;
                if (result == null) {
                    return;
                }
                if ("SUCCESS".equals(result.getResultCode())) {
                    if (response != null) {
                        this.f58132a.f58123a++;
                        if (response.getUserCardDetails().size() < this.f58132a.f58124b) {
                            this.f58132a.j = true;
                        }
                        int i2 = this.f58132a.f58123a + 1;
                        MLVPaginator paginator = response.getPaginator();
                        if (i2 >= (paginator != null ? paginator.getTotalPage() : 0)) {
                            this.f58132a.j = true;
                        }
                        this.f58132a.f58131i.addAll(response.getUserCardDetails());
                        this.f58132a.f58128f.postValue(this.f58132a.f58131i);
                    }
                } else if (k.a((Object) "USER_VALIDATION_FAILED", (Object) result.getResultCode())) {
                    this.f58132a.f58125c.postValue(x.f47997a);
                } else {
                    this.f58132a.f58130h.postValue(result.getMessage());
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mlv.MLVListResponse");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(String str) {
        k.c(str, PayUtility.TEMPLATE_ID);
        if (!this.j) {
            net.one97.paytm.passbook.mlv.c.a aVar = net.one97.paytm.passbook.mlv.c.a.f58097a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            a(net.one97.paytm.passbook.mlv.c.a.a(application, this.f58124b, this.f58123a + 1, str, new a(this), new b(this)));
        }
    }

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58133a;

        b(c cVar) {
            this.f58133a = cVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f58133a.f58126d.postValue(Boolean.FALSE);
            this.f58133a.f58129g.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    public final void a(e eVar) {
        k.c(eVar, "request");
        if (net.one97.paytm.passbook.mapping.a.c((Context) getApplication())) {
            getApplication();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(eVar);
            this.f58126d.postValue(Boolean.TRUE);
            return;
        }
        this.f58127e.postValue(eVar);
    }
}
