package net.one97.paytm.hotel4.service.model.datamodel;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.json.JSONArray;
import org.json.JSONObject;

public final class HotelConfig extends IJRPaytmDataModel {
    private int maxStayRange;
    private String response = "";
    private String today = "";
    private String tomorrow = "";

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }

    public final String getToday() {
        return this.today;
    }

    public final void setToday(String str) {
        this.today = str;
    }

    public final String getTomorrow() {
        return this.tomorrow;
    }

    public final void setTomorrow(String str) {
        this.tomorrow = str;
    }

    public final int getMaxStayRange() {
        return this.maxStayRange;
    }

    public final void setMaxStayRange(int i2) {
        this.maxStayRange = i2;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        this.response = str;
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("bookingWindows");
        k.a((Object) jSONArray, "jsonObject.getJSONArray(\"bookingWindows\")");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            k.a((Object) jSONObject2, "jsonArray.getJSONObject(index)");
            if (jSONObject2.getString("name").equals("Today")) {
                this.today = jSONObject2.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            } else if (jSONObject2.getString("name").equals("Tomorrow")) {
                this.tomorrow = jSONObject2.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            }
        }
        this.maxStayRange = jSONObject.optInt("maxStayRange", 0);
        return this;
    }
}
