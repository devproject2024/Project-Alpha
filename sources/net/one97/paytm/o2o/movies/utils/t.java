package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.entity.CJRCitiesResponse;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRSelectCityModel f75986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f75987b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f75988c;

        public a(CJRSelectCityModel cJRSelectCityModel, Context context, y yVar) {
            this.f75986a = cJRSelectCityModel;
            this.f75987b = context;
            this.f75988c = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CJRCitiesResponse) {
                ArrayList<CJRSelectCityModel> arrayList = null;
                IJRPaytmDataModel a2 = n.a((CJRCitiesResponse) iJRPaytmDataModel);
                if (a2 != null) {
                    arrayList = ((CJRSelectCitiesModel) a2).getCities();
                }
                if (arrayList != null && this.f75986a != null) {
                    n.c(arrayList);
                    Iterator<CJRSelectCityModel> it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CJRSelectCityModel next = it2.next();
                            if (next != null && next.getmSeachKeys() != null && next.getmSeachKeys().contains(this.f75986a.getLabel())) {
                                this.f75986a.setValue(next.getValue());
                                d.a(this.f75987b, this.f75986a.getValue(), "movietickets");
                                d.d(this.f75987b);
                                d.a(this.f75987b, this.f75986a, "movies");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            this.f75988c.postValue(Boolean.TRUE);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f75988c.postValue(Boolean.TRUE);
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AJRMoviesSelectCityActivity");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
