package net.one97.paytm.passbook.cashbackVoucher;

import android.app.Application;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse;
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.mapping.a.f;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    y<f<ListAllTemplateResponse>> f57154a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    y<f<MlvTemplateListResponse>> f57155b = new y<>();

    static final class a<T> implements z<f<? extends ListAllTemplateResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57156a;

        a(c cVar) {
            this.f57156a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f57156a.f57154a.setValue((f) obj);
        }
    }

    static final class b<T> implements z<f<? extends MlvTemplateListResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57157a;

        b(c cVar) {
            this.f57157a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f57157a.f57155b.setValue((f) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
    }
}
