package net.one97.travelpass.g;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.model.MyPassesResponse;
import net.one97.travelpass.model.TPAboutResponse;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.model.TravelPassOffers;
import net.one97.travelpass.model.TravelPassSubscribeResponse;
import net.one97.travelpass.model.TravelPassWithOffersData;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<TravelPass> f30471a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.travelpass.e.a> f30472b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<TravelPass> f30473c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<net.one97.travelpass.e.a> f30474d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<net.one97.travelpass.e.a> f30475e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public net.one97.travelpass.d.a f30476f = new net.one97.travelpass.d.a();

    /* renamed from: g  reason: collision with root package name */
    public y<MyPassesResponse> f30477g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<BookingDetailsResponse> f30478h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<TravelPassSubscribeResponse> f30479i = new y<>();
    public y<net.one97.travelpass.e.a> j = new y<>();
    public y<TravelPassSubscribeResponse> k = new y<>();
    public y<net.one97.travelpass.e.a> l = new y<>();
    public y<TPAboutResponse> m = new y<>();
    public y<net.one97.travelpass.e.a> n = new y<>();
    private y<TravelPassOffers> o = new y<>();
    private y<TravelPassWithOffersData> p = new y<>();

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30483a;

        d(a aVar) {
            this.f30483a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30483a.f30472b.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof TravelPass)) {
                this.f30483a.f30471a.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void a(Context context) {
        if (context != null && this.f30476f != null) {
            net.one97.travelpass.d.a.a(context, new d(this));
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30484a;

        public e(a aVar) {
            this.f30484a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30484a.f30474d.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof TravelPass)) {
                this.f30484a.f30473c.setValue(iJRPaytmDataModel);
            }
        }
    }

    /* renamed from: net.one97.travelpass.g.a$a  reason: collision with other inner class name */
    public static final class C0514a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30480a;

        C0514a(a aVar) {
            this.f30480a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30480a.f30472b.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof MyPassesResponse)) {
                this.f30480a.f30477g.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void b(Context context) {
        if (context != null && this.f30476f != null) {
            net.one97.travelpass.d.a.b(context, new C0514a(this));
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30481a;

        public b(a aVar) {
            this.f30481a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30481a.f30475e.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof BookingDetailsResponse)) {
                this.f30481a.f30478h.setValue(iJRPaytmDataModel);
            }
        }
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30485a;

        public f(a aVar) {
            this.f30485a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30485a.j.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof TravelPassSubscribeResponse)) {
                this.f30485a.f30479i.setValue(iJRPaytmDataModel);
            }
        }
    }

    public static final class g implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30486a;

        public g(a aVar) {
            this.f30486a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30486a.l.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof TravelPassSubscribeResponse)) {
                this.f30486a.k.setValue(iJRPaytmDataModel);
            }
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30482a;

        c(a aVar) {
            this.f30482a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30482a.n.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof TPAboutResponse)) {
                this.f30482a.m.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void c(Context context) {
        if (context != null && this.f30476f != null) {
            net.one97.travelpass.d.a.c(context, new c(this));
        }
    }
}
