package net.one97.paytm.hotel4.service.model.datamodel.search;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class Locations extends IJRPaytmDataModel {
    private String cityName;
    private String lat;
    private String lon;

    public Locations() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public final String getLat() {
        return this.lat;
    }

    public final void setLat(String str) {
        k.c(str, "<set-?>");
        this.lat = str;
    }

    public final String getLon() {
        return this.lon;
    }

    public final void setLon(String str) {
        k.c(str, "<set-?>");
        this.lon = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Locations(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final void setCityName(String str) {
        k.c(str, "<set-?>");
        this.cityName = str;
    }

    public Locations(String str, String str2, String str3) {
        k.c(str, "lat");
        k.c(str2, "lon");
        k.c(str3, "cityName");
        this.lat = str;
        this.lon = str2;
        this.cityName = str3;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.lat)) {
            jSONObject.put("lat", this.lat);
        }
        if (!TextUtils.isEmpty(this.lon)) {
            jSONObject.put("lon", this.lon);
        }
        return jSONObject;
    }
}
