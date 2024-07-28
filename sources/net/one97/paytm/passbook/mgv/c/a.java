package net.one97.paytm.passbook.mgv.c;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.s;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mgv.Data;
import net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    int f57963a;

    /* renamed from: b  reason: collision with root package name */
    int f57964b = 20;

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f57965c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<e> f57966d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<ArrayList<UserCardDetail>> f57967e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> f57968f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<String> f57969g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<UserTemplateDetail> f57970h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<UserCardDetail> f57971i = new ArrayList<>();
    public boolean j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    /* renamed from: net.one97.paytm.passbook.mgv.c.a$a  reason: collision with other inner class name */
    public static final class C1101a implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57972a;

        C1101a(a aVar) {
            this.f57972a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
            r1 = r4.getPaginator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onResponse(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.passbook.mapping.IJRDataModel r4 = (net.one97.paytm.passbook.mapping.IJRDataModel) r4
                java.lang.String r0 = "response"
                kotlin.g.b.k.c(r4, r0)
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                androidx.lifecycle.y<java.lang.Boolean> r0 = r0.f57965c
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                r0.postValue(r1)
                net.one97.paytm.passbook.beans.mgv.ListAllGVResponse r4 = (net.one97.paytm.passbook.beans.mgv.ListAllGVResponse) r4
                java.lang.String r0 = r4.getStatus()
                java.lang.String r1 = "SUCCESS"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x0078
                net.one97.paytm.passbook.beans.mgv.GVListData r4 = r4.getData()
                if (r4 == 0) goto L_0x0077
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                int r1 = r0.f57963a
                r2 = 1
                int r1 = r1 + r2
                r0.f57963a = r1
                java.util.ArrayList r0 = r4.getUserCardDetails()
                int r0 = r0.size()
                net.one97.paytm.passbook.mgv.c.a r1 = r3.f57972a
                int r1 = r1.f57964b
                if (r0 >= r1) goto L_0x003e
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                r0.j = r2
            L_0x003e:
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                int r0 = r0.f57963a
                int r0 = r0 + r2
                if (r4 == 0) goto L_0x0054
                net.one97.paytm.passbook.beans.mgv.MGVPaginator r1 = r4.getPaginator()
                if (r1 == 0) goto L_0x0054
                int r1 = r1.getTotalPage()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x0055
            L_0x0054:
                r1 = 0
            L_0x0055:
                int r1 = r1.intValue()
                if (r0 < r1) goto L_0x005f
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                r0.j = r2
            L_0x005f:
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.UserCardDetail> r0 = r0.f57971i
                java.util.ArrayList r4 = r4.getUserCardDetails()
                java.util.Collection r4 = (java.util.Collection) r4
                r0.addAll(r4)
                net.one97.paytm.passbook.mgv.c.a r4 = r3.f57972a
                androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.UserCardDetail>> r4 = r4.f57967e
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.UserCardDetail> r0 = r0.f57971i
                r4.postValue(r0)
            L_0x0077:
                return
            L_0x0078:
                net.one97.paytm.passbook.mgv.c.a r0 = r3.f57972a
                androidx.lifecycle.y<java.lang.String> r0 = r0.f57969g
                java.lang.String r4 = r4.getErrorMessage()
                r0.postValue(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mgv.c.a.C1101a.onResponse(java.lang.Object):void");
        }
    }

    public final void a(String str) {
        k.c(str, PayUtility.TEMPLATE_ID);
        if (!this.j) {
            net.one97.paytm.passbook.mgv.b.a aVar = net.one97.paytm.passbook.mgv.b.a.f57962a;
            Application application = getApplication();
            k.a((Object) application, "getApplication()");
            a(net.one97.paytm.passbook.mgv.b.a.a(application, this.f57964b, this.f57963a + 1, str, new C1101a(this), new b(this)));
        }
    }

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57973a;

        b(a aVar) {
            this.f57973a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f57973a.f57965c.postValue(Boolean.FALSE);
            this.f57973a.f57968f.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    public static final class c implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57974a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f57975b;

        public c(a aVar, String str) {
            this.f57974a = aVar;
            this.f57975b = str;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            k.c(iJRDataModel, Payload.RESPONSE);
            this.f57974a.f57965c.postValue(Boolean.FALSE);
            ListAllTemplateResponse listAllTemplateResponse = (ListAllTemplateResponse) iJRDataModel;
            if ("SUCCESS".equals(listAllTemplateResponse.getStatus())) {
                Data data = listAllTemplateResponse.getData();
                if (data != null) {
                    Iterator<UserTemplateDetail> it2 = data.getUserTemplateDetails().iterator();
                    while (it2.hasNext()) {
                        UserTemplateDetail next = it2.next();
                        if (next.getCardTemplate().getId().equals(this.f57975b)) {
                            this.f57974a.f57970h.postValue(next);
                            return;
                        }
                    }
                    this.f57974a.f57970h.postValue(null);
                    return;
                }
                return;
            }
            this.f57974a.f57969g.postValue(listAllTemplateResponse.getErrorMessage());
        }
    }

    public static final class d implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57976a;

        public d(a aVar) {
            this.f57976a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f57976a.f57965c.postValue(Boolean.FALSE);
            this.f57976a.f57968f.postValue(new s(Integer.valueOf(i2), iJRPaytmDataModel, networkCustomError));
        }
    }

    public final void a(e eVar) {
        k.c(eVar, "request");
        if (net.one97.paytm.passbook.mapping.a.c((Context) getApplication())) {
            getApplication();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(eVar);
            this.f57965c.postValue(Boolean.TRUE);
            return;
        }
        this.f57966d.postValue(eVar);
    }
}
