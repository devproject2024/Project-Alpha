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
import net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo;
import net.one97.paytm.passbook.beans.mlv.MLVPaginator;
import net.one97.paytm.passbook.beans.mlv.MLVTransactionListResponse;
import net.one97.paytm.passbook.beans.mlv.MLVTransactionResponse;
import net.one97.paytm.passbook.beans.mlv.Result;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class b extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    int f58112a;

    /* renamed from: b  reason: collision with root package name */
    public y<x> f58113b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f58114c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<e> f58115d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<ArrayList<MLVAccountTransactionInfo>> f58116e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> f58117f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<String> f58118g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<MLVAccountTransactionInfo> f58119h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    boolean f58120i;
    private int j = 20;

    static final class a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58121a;

        a(b bVar) {
            this.f58121a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            this.f58121a.f58114c.postValue(Boolean.FALSE);
            if (iJRDataModel != null) {
                MLVTransactionListResponse response = ((MLVTransactionResponse) iJRDataModel).getResponse();
                Result result = response != null ? response.getResult() : null;
                if (result == null) {
                    return;
                }
                if ("SUCCESS".equals(result.getResultCode())) {
                    if (response != null) {
                        this.f58121a.f58112a++;
                        if (response.getUserTransactionList().size() < this.f58121a.f58112a) {
                            this.f58121a.f58120i = true;
                        }
                        int i2 = this.f58121a.f58112a + 1;
                        MLVPaginator paginator = response.getPaginator();
                        if (i2 >= (paginator != null ? paginator.getTotalPage() : 0)) {
                            this.f58121a.f58120i = true;
                        }
                        this.f58121a.f58119h.addAll(response.getUserTransactionList());
                        this.f58121a.f58116e.postValue(this.f58121a.f58119h);
                    }
                } else if (k.a((Object) "USER_VALIDATION_FAILED", (Object) result.getResultCode())) {
                    this.f58121a.f58113b.postValue(x.f47997a);
                } else {
                    this.f58121a.f58118g.postValue(result.getMessage());
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mlv.MLVTransactionResponse");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(String str) {
        k.c(str, "cardNo");
        if (!this.f58120i) {
            net.one97.paytm.passbook.mlv.c.a aVar = net.one97.paytm.passbook.mlv.c.a.f58097a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            a(net.one97.paytm.passbook.mlv.c.a.b(application, this.j, this.f58112a + 1, str, new a(this), new C1113b(this)));
        }
    }

    /* renamed from: net.one97.paytm.passbook.mlv.e.b$b  reason: collision with other inner class name */
    static final class C1113b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58122a;

        C1113b(b bVar) {
            this.f58122a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f58122a.f58114c.postValue(Boolean.FALSE);
            this.f58122a.f58117f.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    private void a(e eVar) {
        k.c(eVar, "request");
        if (net.one97.paytm.passbook.mapping.a.c((Context) getApplication())) {
            getApplication();
            c.a();
            c.b(eVar);
            this.f58114c.postValue(Boolean.TRUE);
            return;
        }
        this.f58115d.postValue(eVar);
    }
}
