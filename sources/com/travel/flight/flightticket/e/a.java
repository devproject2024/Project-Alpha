package com.travel.flight.flightticket.e;

import android.view.View;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicValidationAutoSuggest;
import java.lang.ref.WeakReference;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<C0470a> f24875a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<View> f24876b;

    /* renamed from: c  reason: collision with root package name */
    private int f24877c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24878d;

    /* renamed from: com.travel.flight.flightticket.e.a$a  reason: collision with other inner class name */
    public interface C0470a {
        void a(CJRDynamicValidationAutoSuggest cJRDynamicValidationAutoSuggest, View view, int i2, boolean z);

        void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
    }

    public a(C0470a aVar, int i2, View view, boolean z) {
        this.f24875a = new WeakReference<>(aVar);
        if (view != null) {
            this.f24876b = new WeakReference<>(view);
        }
        this.f24877c = i2;
        this.f24878d = z;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        WeakReference<View> weakReference;
        WeakReference<C0470a> weakReference2 = this.f24875a;
        if (weakReference2 != null && weakReference2.get() != null && (weakReference = this.f24876b) != null && weakReference.get() != null) {
            ((C0470a) this.f24875a.get()).a((CJRDynamicValidationAutoSuggest) iJRPaytmDataModel, (View) this.f24876b.get(), this.f24877c, this.f24878d);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        WeakReference<C0470a> weakReference = this.f24875a;
        if (weakReference != null && weakReference.get() != null) {
            ((C0470a) this.f24875a.get()).handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }
}
