package com.travel.bus.pojo.busticket;

import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.a.a;
import com.google.gson.a.c;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusOrderSummaryRating extends IJRPaytmDataModel {
    @c(a = "body")
    @a
    private CJRBusOrderSummaryRatingBody body;

    public CJRBusOrderSummaryRatingBody getBody() {
        return this.body;
    }

    public void setBody(CJRBusOrderSummaryRatingBody cJRBusOrderSummaryRatingBody) {
        this.body = cJRBusOrderSummaryRatingBody;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusOrderSummaryRating cJRBusOrderSummaryRating = new CJRBusOrderSummaryRating();
        cJRBusOrderSummaryRating.parseJson(str, cJRBusOrderSummaryRating);
        return cJRBusOrderSummaryRating;
    }

    /* access modifiers changed from: package-private */
    public void parseJson(String str, CJRBusOrderSummaryRating cJRBusOrderSummaryRating) throws JSONException {
        JSONObject jSONObject = new JSONObject(str).getJSONObject("body");
        if (jSONObject != null) {
            CJRBusOrderSummaryRatingBody cJRBusOrderSummaryRatingBody = new CJRBusOrderSummaryRatingBody();
            if (!jSONObject.isNull("is_editable")) {
                cJRBusOrderSummaryRatingBody.setIsEditable(Boolean.valueOf(jSONObject.getBoolean("is_editable")));
            }
            if (!jSONObject.isNull("is_photo_post_enabled")) {
                cJRBusOrderSummaryRatingBody.setIsPhotoPostEnabled(Boolean.valueOf(jSONObject.getBoolean("is_photo_post_enabled")));
            }
            if (!jSONObject.isNull("is_trip_completed")) {
                cJRBusOrderSummaryRatingBody.setIsTripCompleted(Boolean.valueOf(jSONObject.getBoolean("is_trip_completed")));
            }
            if (!jSONObject.isNull("secret")) {
                cJRBusOrderSummaryRatingBody.setmSecret(jSONObject.getString("secret"));
            }
            if (!jSONObject.isNull("user_rating")) {
                cJRBusOrderSummaryRatingBody.setRatingCount(Integer.valueOf(jSONObject.getInt("user_rating")));
            }
            if (!jSONObject.isNull("channel")) {
                cJRBusOrderSummaryRatingBody.setmChannel(jSONObject.getString("channel"));
            }
            if (!jSONObject.isNull(H5Logger.HEADER)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(H5Logger.HEADER);
                CJRBusOrderSummaryRatingHeader cJRBusOrderSummaryRatingHeader = new CJRBusOrderSummaryRatingHeader();
                if (jSONObject2 != null && !jSONObject2.isNull("title")) {
                    cJRBusOrderSummaryRatingHeader.setTitle(jSONObject2.getString("title"));
                }
                cJRBusOrderSummaryRatingBody.setHeader(cJRBusOrderSummaryRatingHeader);
            }
            if (!jSONObject.isNull(ViewHolderFactory.TYPE_SEAL_TRUST)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(ViewHolderFactory.TYPE_SEAL_TRUST);
                CJRBusOrderSummaryRatingFooter cJRBusOrderSummaryRatingFooter = new CJRBusOrderSummaryRatingFooter();
                if (jSONObject3 != null) {
                    if (!jSONObject3.isNull("link_text")) {
                        cJRBusOrderSummaryRatingFooter.setLinkText(jSONObject3.getString("link_text"));
                    }
                    if (!jSONObject3.isNull("message")) {
                        cJRBusOrderSummaryRatingFooter.setMessage(jSONObject3.getString("message"));
                    }
                    if (!jSONObject3.isNull("link_target")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("link_target");
                        CJRBusOrderSummaryRatingLink cJRBusOrderSummaryRatingLink = new CJRBusOrderSummaryRatingLink();
                        if (jSONObject4 != null) {
                            if (!jSONObject4.isNull("type")) {
                                cJRBusOrderSummaryRatingLink.setType(jSONObject4.getString("type"));
                            }
                            if (!jSONObject4.isNull("url")) {
                                cJRBusOrderSummaryRatingLink.setUrl(jSONObject4.getString("url"));
                            }
                        }
                        cJRBusOrderSummaryRatingFooter.setLinkTarget(cJRBusOrderSummaryRatingLink);
                    }
                }
                cJRBusOrderSummaryRatingBody.setFooter(cJRBusOrderSummaryRatingFooter);
            }
            if (!jSONObject.isNull("rating")) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("rating");
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        CJRBusOrderSummaryRatingItem cJRBusOrderSummaryRatingItem = new CJRBusOrderSummaryRatingItem();
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (!jSONObject5.isNull("target_url")) {
                            cJRBusOrderSummaryRatingItem.setTargetUrl(jSONObject5.getString("target_url"));
                        }
                        if (!jSONObject5.isNull(AppConstants.ICON_URL)) {
                            cJRBusOrderSummaryRatingItem.setIconUrl(jSONObject5.getString(AppConstants.ICON_URL));
                        }
                        arrayList.add(cJRBusOrderSummaryRatingItem);
                    }
                }
                cJRBusOrderSummaryRatingBody.setRating(arrayList);
            }
            cJRBusOrderSummaryRating.setBody(cJRBusOrderSummaryRatingBody);
        }
    }
}
