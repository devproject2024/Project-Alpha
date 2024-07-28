package net.one97.paytm.passbook.mlv.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.s;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.passbook.beans.mlv.MLVPaginator;
import net.one97.paytm.passbook.beans.mlv.MLoyalResponse;
import net.one97.paytm.passbook.beans.mlv.MLoyalResponseStatus;
import net.one97.paytm.passbook.beans.mlv.MerchantItem;
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.beans.mlv.Response;
import net.one97.paytm.passbook.beans.mlv.Result;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public int f58099a;

    /* renamed from: b  reason: collision with root package name */
    int f58100b = 20;

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f58101c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<e> f58102d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<x> f58103e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<ArrayList<UserMLVTemplateDetail>> f58104f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<ArrayList<MerchantItem>> f58105g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> f58106h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<String> f58107i = new y<>();
    public ArrayList<UserMLVTemplateDetail> j = new ArrayList<>();
    public boolean k;
    public boolean l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class c implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58110a;

        c(a aVar) {
            this.f58110a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String result;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel != null) {
                MLoyalResponse mLoyalResponse = (MLoyalResponse) iJRDataModel;
                MLoyalResponseStatus status = mLoyalResponse.getStatus();
                if (!(status == null || (result = status.getResult()) == null || !p.a(result, "success", true))) {
                    this.f58110a.f58105g.postValue(mLoyalResponse.getMerchantList());
                    this.f58110a.l = true;
                }
                this.f58110a.f58101c.postValue(Boolean.FALSE);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mlv.MLoyalResponse");
        }
    }

    static final class d implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58111a;

        d(a aVar) {
            this.f58111a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f58111a.f58101c.postValue(Boolean.FALSE);
        }
    }

    public final void a() {
        if (!this.k) {
            net.one97.paytm.passbook.mlv.c.a aVar = net.one97.paytm.passbook.mlv.c.a.f58097a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            a(net.one97.paytm.passbook.mlv.c.a.a(application, this.f58100b, this.f58099a + 1, new C1112a(this), new b(this)));
        }
    }

    /* renamed from: net.one97.paytm.passbook.mlv.e.a$a  reason: collision with other inner class name */
    public static final class C1112a implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58108a;

        C1112a(a aVar) {
            this.f58108a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            k.c(iJRDataModel, Payload.RESPONSE);
            this.f58108a.f58101c.postValue(Boolean.FALSE);
            Response response = ((MlvTemplateListResponse) iJRDataModel).getResponse();
            Result result = response != null ? response.getResult() : null;
            if (result == null) {
                this.f58108a.f58107i.postValue(null);
            } else if (k.a((Object) "SUCCESS", (Object) result.getResultCode())) {
                if (response != null) {
                    this.f58108a.f58099a++;
                    if (response.getUserTemplateDetails().size() < this.f58108a.f58100b) {
                        this.f58108a.k = true;
                    }
                    int i2 = this.f58108a.f58099a + 1;
                    MLVPaginator paginator = response.getPaginator();
                    if (i2 >= (paginator != null ? paginator.getTotalPage() : 0)) {
                        this.f58108a.k = true;
                    }
                    this.f58108a.j.addAll(response.getUserTemplateDetails());
                    this.f58108a.f58104f.postValue(this.f58108a.j);
                    if (this.f58108a.k) {
                        a aVar = this.f58108a;
                        if (!aVar.l) {
                            net.one97.paytm.passbook.mlv.c.a aVar2 = net.one97.paytm.passbook.mlv.c.a.f58097a;
                            Application application = aVar.getApplication();
                            k.a((Object) application, "getApplication()");
                            aVar.a(net.one97.paytm.passbook.mlv.c.a.a(application, new c(aVar), new d(aVar)));
                        }
                    }
                }
            } else if (k.a((Object) "USER_VALIDATION_FAILED", (Object) result.getResultCode())) {
                this.f58108a.f58103e.postValue(x.f47997a);
            } else {
                this.f58108a.f58107i.postValue(result.getMessage());
            }
        }
    }

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58109a;

        b(a aVar) {
            this.f58109a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f58109a.f58101c.postValue(Boolean.FALSE);
            this.f58109a.f58106h.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    public final void a(e eVar) {
        k.c(eVar, "request");
        if (net.one97.paytm.passbook.mapping.a.c((Context) getApplication())) {
            getApplication();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(eVar);
            this.f58101c.postValue(Boolean.TRUE);
            return;
        }
        this.f58102d.postValue(eVar);
    }
}
