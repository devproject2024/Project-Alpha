package net.one97.paytm.o2o.movies.seat_selection;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.o2o.movies.common.f;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.seat_selection.c;
import org.json.JSONObject;

public final class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final Context f75828a;

    public d(Context context) {
        k.c(context, "context");
        this.f75828a = context;
    }

    static final class a<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f75829a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMoviesSession f75830b;

        a(d dVar, CJRMoviesSession cJRMoviesSession) {
            this.f75829a = dVar;
            this.f75830b = cJRMoviesSession;
        }

        public final void subscribe(z<CJRSeat> zVar) {
            net.one97.paytm.o2o.movies.common.b.c.a();
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesSelectSeat", (String) null);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f75830b.getCinemaID())) {
                jSONObject.put("cinemaId", this.f75830b.getCinemaID());
            }
            if (!TextUtils.isEmpty(this.f75830b.getSessionID())) {
                jSONObject.put(H5Param.SESSION_ID, this.f75830b.getSessionID());
            }
            jSONObject.put("screenOnTop", this.f75830b.getScreenTop());
            if (!TextUtils.isEmpty(this.f75830b.getProviderId())) {
                jSONObject.put("providerId", this.f75830b.getProviderId());
            }
            if (!TextUtils.isEmpty(this.f75830b.getScreenFormat())) {
                jSONObject.put("screenFormat", this.f75830b.getScreenFormat());
            }
            jSONObject.put("freeSeating", this.f75830b.isFreeSeating());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("socialDistancing", 1);
            jSONObject.put(Constants.EASY_PAY_CONFIG_PREF_KEY, jSONObject2);
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = this.f75829a.f75828a;
            cVar.f42880d = a2;
            cVar.f42879c = a.C0715a.POST;
            cVar.f42885i = new CJRSeat();
            cVar.f42884h = jSONObject.toString();
            cVar.f42878b = a.c.MOVIES;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.j = new C1496a(zVar);
            cVar.l().a();
        }

        /* renamed from: net.one97.paytm.o2o.movies.seat_selection.d$a$a  reason: collision with other inner class name */
        public static final class C1496a implements b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f75831a;

            C1496a(z zVar) {
                this.f75831a = zVar;
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                net.one97.paytm.o2o.movies.common.a.c.a(this.f75831a, (Throwable) new f(i2, iJRPaytmDataModel, networkCustomError));
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f75831a;
                if (iJRPaytmDataModel != null) {
                    net.one97.paytm.o2o.movies.common.a.c.a(zVar, (CJRSeat) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat");
            }
        }
    }

    public final y<CJRSeat> a(CJRMoviesSession cJRMoviesSession) {
        k.c(cJRMoviesSession, "session");
        y<CJRSeat> a2 = y.a(new a(this, cJRMoviesSession)).b(io.reactivex.rxjava3.i.a.d()).a(io.reactivex.rxjava3.android.b.a.a());
        k.a((Object) a2, "Single.create<CJRSeat> {…dSchedulers.mainThread())");
        return a2;
    }
}
