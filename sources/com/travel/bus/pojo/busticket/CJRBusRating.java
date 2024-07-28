package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusRating extends IJRPaytmDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private Object error;
    @b(a = "message")
    private String message;
    @b(a = "body")
    private CJRBusRatingInfo ratingInfo;
    @b(a = "status")
    private String status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public Object getError() {
        return this.error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }

    public CJRBusRatingInfo getBody() {
        return this.ratingInfo;
    }

    public void setBody(CJRBusRatingInfo cJRBusRatingInfo) {
        this.ratingInfo = cJRBusRatingInfo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusRating cJRBusRating = new CJRBusRating();
        cJRBusRating.parseJson(str, cJRBusRating);
        return cJRBusRating;
    }

    /* access modifiers changed from: package-private */
    public void parseJson(String str, CJRBusRating cJRBusRating) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
        CJRBusRatingInfo cJRBusRatingInfo = new CJRBusRatingInfo();
        if (!jSONObject.isNull("code")) {
            cJRBusRating.setCode(Integer.valueOf(jSONObject.getInt("code")));
        }
        if (!jSONObject.isNull("status")) {
            cJRBusRating.setStatus(jSONObject.getString("status"));
        }
        if (!jSONObject.isNull("error")) {
            cJRBusRating.setError(jSONObject.getString("error"));
        }
        if (!jSONObject.isNull("message")) {
            cJRBusRating.setMessage(jSONObject.getString("message"));
        }
        if (!jSONObject2.isNull("questions")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("questions");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    CJRBusRatingQuestions cJRBusRatingQuestions = new CJRBusRatingQuestions();
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    if (!jSONObject3.isNull("category_id")) {
                        cJRBusRatingQuestions.setCategoryId(jSONObject3.getString("category_id"));
                    }
                    if (!jSONObject3.isNull("mandatory")) {
                        cJRBusRatingQuestions.setMandatory(Integer.valueOf(jSONObject3.getInt("mandatory")));
                    }
                    if (!jSONObject3.isNull("category")) {
                        cJRBusRatingQuestions.setCategory(jSONObject3.getString("category"));
                    }
                    if (!jSONObject3.isNull("options")) {
                        ArrayList arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("options");
                        if (jSONArray2 != null) {
                            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                CJRBusJourneyIssues cJRBusJourneyIssues = new CJRBusJourneyIssues();
                                JSONObject jSONObject4 = jSONArray2.getJSONObject(i3);
                                if (!jSONObject4.isNull("id")) {
                                    cJRBusJourneyIssues.setId(jSONObject4.getString("id"));
                                }
                                if (!jSONObject4.isNull("name")) {
                                    cJRBusJourneyIssues.setName(jSONObject4.getString("name"));
                                }
                                arrayList2.add(cJRBusJourneyIssues);
                            }
                            cJRBusRatingQuestions.setIssueOptions(arrayList2);
                        }
                    }
                    arrayList.add(cJRBusRatingQuestions);
                }
                cJRBusRatingInfo.setQuestions(arrayList);
            }
        }
        if (jSONObject2 != null) {
            cJRBusRating.setBody(cJRBusRatingInfo);
        }
    }
}
