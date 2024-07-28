package com.travel.flight.pojo.flightticket;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class CJRFlightCalendarPriceModel extends IJRPaytmDataModel {
    @b(a = "body")
    private String body;
    @b(a = "code")
    private int code;
    @b(a = "extra")
    private String extra;
    private boolean isForHorizontalList;
    private ArrayList<CJRFlightDatePriceInfo> mDatePriceInfoOnward;
    private ArrayList<CJRFlightDatePriceInfo> mDatePriceInfoReturn;
    @b(a = "message")
    private String message;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRFlightCalendarPriceModel cJRFlightCalendarPriceModel = new CJRFlightCalendarPriceModel();
        cJRFlightCalendarPriceModel.parse(str);
        return cJRFlightCalendarPriceModel;
    }

    public void parse(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDatePriceInfoOnward = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.message = jSONObject.getString("message");
                this.code = jSONObject.getInt("code");
                this.extra = jSONObject.getString("extra");
                JSONObject jSONObject2 = jSONObject.getJSONObject("body").getJSONObject("fares");
                if (!jSONObject2.has("onward") || !jSONObject2.has("return")) {
                    this.mDatePriceInfoOnward = new ArrayList<>();
                    fillTheArray(jSONObject2, jSONObject2.keys(), false);
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("onward");
                JSONObject jSONObject4 = jSONObject2.getJSONObject("return");
                this.mDatePriceInfoOnward = new ArrayList<>();
                this.mDatePriceInfoReturn = new ArrayList<>();
                fillTheArray(jSONObject3, jSONObject3.keys(), false);
                fillTheArray(jSONObject4, jSONObject4.keys(), true);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void fillTheArray(JSONObject jSONObject, Iterator<String> it2, boolean z) {
        while (it2.hasNext()) {
            String next = it2.next();
            CJRFlightDatePriceInfo cJRFlightDatePriceInfo = new CJRFlightDatePriceInfo();
            cJRFlightDatePriceInfo.setDate(next);
            try {
                if (!jSONObject.isNull(next)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    cJRFlightDatePriceInfo.setFare(jSONObject2.getInt("fare"));
                    cJRFlightDatePriceInfo.setColorCode(jSONObject2.getString(CLConstants.FIELD_FONT_COLOR));
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
                cJRFlightDatePriceInfo.setFare(-1);
                cJRFlightDatePriceInfo.setColorCode("");
            }
            if (z) {
                this.mDatePriceInfoReturn.add(cJRFlightDatePriceInfo);
            } else {
                this.mDatePriceInfoOnward.add(cJRFlightDatePriceInfo);
            }
        }
        if (z) {
            Collections.sort(this.mDatePriceInfoReturn, new a(this, (byte) 0));
        } else {
            Collections.sort(this.mDatePriceInfoOnward, new a(this, (byte) 0));
        }
    }

    public ArrayList<CJRFlightDatePriceInfo> getOnwardDatePriceInfo() {
        return this.mDatePriceInfoOnward;
    }

    public ArrayList<CJRFlightDatePriceInfo> getReturnDatePriceInfo() {
        return this.mDatePriceInfoReturn;
    }

    public boolean isForHorizontalList() {
        return this.isForHorizontalList;
    }

    public void setForHorizontalList(boolean z) {
        this.isForHorizontalList = z;
    }

    class a implements Comparator<CJRFlightDatePriceInfo> {
        private a() {
        }

        /* synthetic */ a(CJRFlightCalendarPriceModel cJRFlightCalendarPriceModel, byte b2) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRFlightDatePriceInfo) obj, (CJRFlightDatePriceInfo) obj2);
        }

        private static int a(CJRFlightDatePriceInfo cJRFlightDatePriceInfo, CJRFlightDatePriceInfo cJRFlightDatePriceInfo2) {
            if (!(cJRFlightDatePriceInfo == null || cJRFlightDatePriceInfo2 == null)) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = simpleDateFormat.parse(cJRFlightDatePriceInfo.getDate());
                    Date parse2 = simpleDateFormat.parse(cJRFlightDatePriceInfo2.getDate());
                    if (parse.compareTo(parse2) < 0) {
                        return -1;
                    }
                    if (parse.compareTo(parse2) > 0) {
                        return 1;
                    }
                    return 0;
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            return 0;
        }
    }
}
