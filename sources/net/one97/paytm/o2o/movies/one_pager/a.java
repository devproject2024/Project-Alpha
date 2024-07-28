package net.one97.paytm.o2o.movies.one_pager;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.entity.CJRCitiesResponse;
import net.one97.paytm.o2o.movies.entity.CJRInsiderCityResponse;
import net.one97.paytm.o2o.movies.utils.n;

public class a extends androidx.lifecycle.a implements b {

    /* renamed from: a  reason: collision with root package name */
    public y<OpEntertainmentResponse> f75645a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<OpConfigResponse> f75646b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<CJRHomePageV2> f75647c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<CJRMovieHomeDataResponse> f75648d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<CJRCitiesResponse> f75649e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<CJRInsiderCityResponse> f75650f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    private String f75651g = "EntertainmentDiscoveryViewModel";

    public a(Application application) {
        super(application);
    }

    public final void a(Context context) {
        c.a();
        String a2 = c.a("movieCityListV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            if (com.paytm.utility.b.r(context)) {
                a2 = n.a("UserId", com.paytm.utility.b.n(context), n.a("customer_id", com.paytm.utility.b.n(context), a2));
            }
            a(com.paytm.utility.b.s(context, a2), (IJRPaytmDataModel) new CJRCitiesResponse());
        }
    }

    public final void a() {
        a("https://api.insider.in/tag/home-cities", (IJRPaytmDataModel) new CJRInsiderCityResponse());
    }

    public final void a(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            c.a();
            String a2 = c.a("movieMoviesURLV3", (String) null);
            try {
                if (!TextUtils.isEmpty(str)) {
                    a2 = n.a("groupResult", "true", n.a("city", URLEncoder.encode(str, AppConstants.UTF_8).toLowerCase(), a2));
                }
            } catch (UnsupportedEncodingException unused) {
            }
            if (URLUtil.isValidUrl(a2)) {
                String replace = com.paytm.utility.b.s(context, a2).replace("custId", "userId");
                String n = com.paytm.utility.b.n((Context) getApplication());
                if (!v.a(n) && n.c((Context) getApplication())) {
                    replace = replace + "&userId=" + n;
                }
                a(replace, (IJRPaytmDataModel) new CJRMovieHomeDataResponse());
            }
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            a("https://api.insider.in/home?city=" + lowerCase + "&filterBy=go-out&norm=1&show=today", (IJRPaytmDataModel) new OpEntertainmentResponse());
        }
    }

    public final void b() {
        c.a();
        String a2 = c.a("moviesHomePageBanner_v2", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            b(com.paytm.utility.b.s(getApplication().getApplicationContext(), a2), new CJRHomePageV2());
        }
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = getApplication().getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.GET;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = c();
        cVar.f42883g = null;
        cVar.f42884h = null;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = this;
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h(this.f75651g);
        com.paytm.network.a l = cVar.l();
        l.f42859c = false;
        l.a();
    }

    private void b(String str, IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = getApplication().getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = c();
        cVar.f42883g = null;
        cVar.f42884h = null;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = this;
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h(this.f75651g);
        com.paytm.network.a l = cVar.l();
        l.f42859c = false;
        l.a();
    }

    private static Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("ClientId", "paytm");
        return hashMap;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof OpEntertainmentResponse) {
            this.f75645a.setValue((OpEntertainmentResponse) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRHomePageV2) {
            this.f75647c.setValue((CJRHomePageV2) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRMovieHomeDataResponse) {
            this.f75648d.setValue((CJRMovieHomeDataResponse) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRCitiesResponse) {
            this.f75649e.setValue((CJRCitiesResponse) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRInsiderCityResponse) {
            this.f75650f.setValue((CJRInsiderCityResponse) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof OpConfigResponse) {
            this.f75646b.setValue((OpConfigResponse) iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof OpEntertainmentResponse) {
            this.f75645a.setValue(null);
        } else if (iJRPaytmDataModel instanceof CJRHomePageV2) {
            this.f75647c.setValue(null);
        } else if (iJRPaytmDataModel instanceof CJRMovieHomeDataResponse) {
            this.f75648d.setValue(null);
        } else if (iJRPaytmDataModel instanceof CJRCitiesResponse) {
            this.f75649e.setValue(null);
        } else if (iJRPaytmDataModel instanceof CJRInsiderCityResponse) {
            this.f75650f.setValue(null);
        } else if (iJRPaytmDataModel instanceof OpConfigResponse) {
            this.f75646b.setValue(null);
        }
    }
}
