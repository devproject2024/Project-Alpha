package net.one97.paytm.o2o.movies.e;

import android.content.Context;
import android.text.TextUtils;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel;
import net.one97.paytm.o2o.movies.entity.CJRHomePageResponse;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public CJRHomePageItem f75231a;

    /* renamed from: b  reason: collision with root package name */
    public String f75232b;

    /* renamed from: c  reason: collision with root package name */
    public String f75233c;

    /* renamed from: d  reason: collision with root package name */
    public CJRSelectCityModel f75234d = d.c(this.f75237g, "movies");

    /* renamed from: e  reason: collision with root package name */
    public CJRHomePageResponse.Language f75235e;

    /* renamed from: f  reason: collision with root package name */
    public CJRMoviePassHomeModel f75236f;

    /* renamed from: g  reason: collision with root package name */
    public Context f75237g;

    public a(Context context) {
        k.c(context, "mContext");
        this.f75237g = context;
    }

    public final void a(CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem != null) {
            this.f75231a = cJRHomePageItem;
            this.f75232b = cJRHomePageItem.mUrlType;
            if (cJRHomePageItem.getPushCity() != null) {
                String pushCity = cJRHomePageItem.getPushCity();
                k.a((Object) pushCity, "homePageItem.pushCity");
                String pushCity2 = cJRHomePageItem.getPushCity();
                k.a((Object) pushCity2, "homePageItem.pushCity");
                if (this.f75234d == null) {
                    this.f75234d = new CJRSelectCityModel();
                }
                if (!TextUtils.isEmpty(pushCity) && !TextUtils.isEmpty(pushCity2)) {
                    CJRSelectCityModel cJRSelectCityModel = this.f75234d;
                    if (cJRSelectCityModel != null) {
                        cJRSelectCityModel.setlabel(pushCity);
                    }
                    CJRSelectCityModel cJRSelectCityModel2 = this.f75234d;
                    if (cJRSelectCityModel2 != null) {
                        cJRSelectCityModel2.setValue(pushCity2);
                    }
                    CJRSelectCityModel cJRSelectCityModel3 = this.f75234d;
                    if (cJRSelectCityModel3 != null) {
                        cJRSelectCityModel3.setLatitude("");
                    }
                    CJRSelectCityModel cJRSelectCityModel4 = this.f75234d;
                    if (cJRSelectCityModel4 != null) {
                        cJRSelectCityModel4.setLongitude("");
                    }
                }
            }
        }
    }
}
