package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRMovieOffers extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "codes")
    public ArrayList<CJRMovieOfferCode> mOfferCodes;

    public ArrayList<CJRMovieOfferCode> getOfferCodes() {
        return this.mOfferCodes;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("codes")) {
            this.mOfferCodes = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("codes");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                CJRMovieOfferCode cJRMovieOfferCode = (CJRMovieOfferCode) new CJRMovieOfferCode().parseResponse(jSONObject2.toString(), new f());
                if (jSONObject2.has("paymentFilters")) {
                    cJRMovieOfferCode.filters = jSONObject2.getJSONObject("paymentFilters").toString();
                }
                this.mOfferCodes.add(cJRMovieOfferCode);
            }
        }
        return this;
    }
}
