package net.one97.paytm.passbook.transactionDetail.d;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.beans.transactionsTag.AllTagsResponse;
import net.one97.paytm.passbook.beans.transactionsTag.UpdateTagsResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f59141a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<e> f59142b = new y<>();

    /* renamed from: net.one97.paytm.passbook.transactionDetail.d.a$a  reason: collision with other inner class name */
    public static final class C1139a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59143a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f59144b;

        public C1139a(a aVar, x.e eVar) {
            this.f59143a = aVar;
            this.f59144b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            this.f59143a.f59141a.postValue(Boolean.FALSE);
            ((y) this.f59144b.element).postValue((AllTagsResponse) ((IJRDataModel) obj));
        }
    }

    public static final class c<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59147a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f59148b;

        public c(a aVar, x.e eVar) {
            this.f59147a = aVar;
            this.f59148b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            this.f59147a.f59141a.postValue(Boolean.FALSE);
            ((y) this.f59148b.element).postValue((UpdateTagsResponse) ((IJRDataModel) obj));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f59146b;

        public b(a aVar, x.e eVar) {
            this.f59145a = aVar;
            this.f59146b = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkCustomError");
            this.f59145a.f59141a.postValue(Boolean.FALSE);
            ((y) this.f59146b.element).postValue(networkCustomError);
        }
    }

    public static final class d implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59149a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f59150b;

        public d(a aVar, x.e eVar) {
            this.f59149a = aVar;
            this.f59150b = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkCustomError");
            this.f59149a.f59141a.postValue(Boolean.FALSE);
            ((y) this.f59150b.element).postValue(networkCustomError);
        }
    }

    public final void a(e eVar) {
        if (com.paytm.utility.b.c((Context) getApplication())) {
            a();
            if (eVar != null) {
                getApplication();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(eVar);
                return;
            }
            return;
        }
        this.f59142b.postValue(eVar);
    }

    private final void a() {
        this.f59141a.postValue(Boolean.TRUE);
    }
}
