package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusReviewsRatingData extends IJRPaytmDataModel {
    private String LOG_TAG = "CJRBusReviewsRatingData";
    @b(a = "body")
    private c busReviewRatingBody;
    @b(a = "code")
    private int code;
    @b(a = "error")
    private String error;
    @b(a = "status")
    private String status;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public c getBusReviewRatingBody() {
        return this.busReviewRatingBody;
    }

    public void setBusReviewRatingBody(c cVar) {
        this.busReviewRatingBody = cVar;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusReviewsRatingData cJRBusReviewsRatingData = new CJRBusReviewsRatingData();
        cJRBusReviewsRatingData.parseJson(str, cJRBusReviewsRatingData);
        return cJRBusReviewsRatingData;
    }

    /* access modifiers changed from: package-private */
    public void parseJson(String str, CJRBusReviewsRatingData cJRBusReviewsRatingData) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
        if (!jSONObject.isNull("code")) {
            cJRBusReviewsRatingData.setCode(jSONObject.getInt("code"));
        }
        if (!jSONObject.isNull("status")) {
            cJRBusReviewsRatingData.setStatus(jSONObject.getString("status"));
        }
        if (!jSONObject.isNull("error")) {
            cJRBusReviewsRatingData.setError(jSONObject.getString("error"));
        }
        if (jSONObject2 != null) {
            c cVar = new c();
            if (!jSONObject2.isNull("count_reviews_in_page")) {
                cVar.f22802a = jSONObject2.getInt("count_reviews_in_page");
            }
            if (!jSONObject2.isNull("num_pages")) {
                cVar.f22806e = jSONObject2.getInt("num_pages");
            }
            if (!jSONObject2.isNull("ratings_breakup")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("ratings_breakup");
                a aVar = new a();
                if (jSONObject3 != null) {
                    try {
                        if (!jSONObject3.isNull("1")) {
                            aVar.f22788a = jSONObject3.getInt("1");
                        }
                        if (!jSONObject3.isNull("2")) {
                            aVar.f22789b = jSONObject3.getInt("2");
                        }
                        if (!jSONObject3.isNull("3")) {
                            aVar.f22790c = jSONObject3.getInt("3");
                        }
                        if (!jSONObject3.isNull("4")) {
                            aVar.f22791d = jSONObject3.getInt("4");
                        }
                        if (!jSONObject3.isNull("5")) {
                            aVar.f22792e = jSONObject3.getInt("5");
                        }
                    } catch (JSONException e2) {
                        q.c(e2.getMessage());
                    }
                }
                cVar.f22804c = aVar;
            }
            if (!jSONObject2.isNull("reviews")) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject2.getJSONArray("reviews");
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        b bVar = new b();
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                        if (!jSONObject4.isNull("review")) {
                            bVar.f22793a = jSONObject4.getString("review");
                        }
                        if (!jSONObject4.isNull("color_code")) {
                            bVar.f22794b = jSONObject4.getString("color_code");
                        }
                        if (!jSONObject4.isNull("rating")) {
                            bVar.f22795c = jSONObject4.getString("rating");
                        }
                        if (!jSONObject4.isNull("reviewer_name")) {
                            bVar.f22796d = jSONObject4.getString("reviewer_name");
                        }
                        if (!jSONObject4.isNull("review_date")) {
                            bVar.f22797e = jSONObject4.getString("review_date");
                        }
                        if (!jSONObject4.isNull("travel_date")) {
                            bVar.f22798f = jSONObject4.getString("travel_date");
                        }
                        if (!jSONObject4.isNull("reviewer_age")) {
                            bVar.f22799g = jSONObject4.getString("reviewer_age");
                        }
                        if (!jSONObject4.isNull("traveller_type")) {
                            bVar.f22800h = jSONObject4.getString("traveller_type");
                        }
                        if (!jSONObject4.isNull("user_gender")) {
                            bVar.f22801i = jSONObject4.getString("user_gender");
                        }
                        arrayList.add(bVar);
                    }
                }
                cVar.f22803b = arrayList;
            }
            if (!jSONObject2.isNull("top_issues")) {
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = jSONObject2.getJSONArray("top_issues");
                if (jSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        d dVar = new d();
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i3);
                        if (!jSONObject5.isNull("name")) {
                            dVar.f22807a = jSONObject5.getString("name");
                        }
                        if (!jSONObject5.isNull("count")) {
                            dVar.f22808b = jSONObject5.getInt("count");
                        }
                        if (!jSONObject5.isNull("positive")) {
                            dVar.f22809c = jSONObject5.getBoolean("positive");
                        }
                        arrayList2.add(dVar);
                    }
                }
                cVar.f22805d = arrayList2;
            }
            cJRBusReviewsRatingData.setBusReviewRatingBody(cVar);
        }
    }
}
