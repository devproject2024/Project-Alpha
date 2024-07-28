package com.travel.model;

import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
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
import kotlin.g.b.k;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class CalendarPriceModel extends IJRPaytmDataModel {
    private String LOG_TAG = "CalendarPriceModel";
    @b(a = "body")
    private final String body;
    @b(a = "code")
    private int code;
    @b(a = "extra")
    private String extra;
    private boolean isForHorizontalList;
    @b(a = "message")
    private String message;
    private ArrayList<CalendarDatePriceInfo> onwardDatePriceInfo;
    private ArrayList<CalendarDatePriceInfo> returnDatePriceInfo;

    public final String getLOG_TAG() {
        return this.LOG_TAG;
    }

    public final void setLOG_TAG(String str) {
        k.c(str, "<set-?>");
        this.LOG_TAG = str;
    }

    public final boolean isForHorizontalList() {
        return this.isForHorizontalList;
    }

    public final void setForHorizontalList(boolean z) {
        this.isForHorizontalList = z;
    }

    public final ArrayList<CalendarDatePriceInfo> getOnwardDatePriceInfo() {
        return this.onwardDatePriceInfo;
    }

    public final ArrayList<CalendarDatePriceInfo> getReturnDatePriceInfo() {
        return this.returnDatePriceInfo;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        k.c(str, Payload.RESPONSE);
        k.c(fVar, "gson");
        CalendarPriceModel calendarPriceModel = new CalendarPriceModel();
        calendarPriceModel.parse(str);
        return calendarPriceModel;
    }

    public final void parse(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.onwardDatePriceInfo = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.message = jSONObject.getString("message");
                this.code = jSONObject.getInt("code");
                this.extra = jSONObject.getString("extra");
                JSONObject jSONObject2 = jSONObject.getJSONObject("body").getJSONObject("fares");
                if (!jSONObject2.has("onward") || !jSONObject2.has("return")) {
                    this.onwardDatePriceInfo = new ArrayList<>();
                    Iterator<String> keys = jSONObject2.keys();
                    k.a((Object) jSONObject2, "faresObject");
                    fillTheArray(jSONObject2, keys, false);
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("onward");
                JSONObject jSONObject4 = jSONObject2.getJSONObject("return");
                this.onwardDatePriceInfo = new ArrayList<>();
                this.returnDatePriceInfo = new ArrayList<>();
                Iterator<String> keys2 = jSONObject3.keys();
                k.a((Object) jSONObject3, "onwardObject");
                fillTheArray(jSONObject3, keys2, false);
                Iterator<String> keys3 = jSONObject4.keys();
                k.a((Object) jSONObject4, "returnObject");
                fillTheArray(jSONObject4, keys3, true);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    private final void fillTheArray(JSONObject jSONObject, Iterator<String> it2, boolean z) {
        while (true) {
            if (it2 == null) {
                k.a();
            }
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            CalendarDatePriceInfo calendarDatePriceInfo = new CalendarDatePriceInfo();
            calendarDatePriceInfo.setDate(next);
            if (!jSONObject.isNull(next)) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    calendarDatePriceInfo.setFare(jSONObject2.getInt("fare"));
                    calendarDatePriceInfo.setColorCode(jSONObject2.getString(CLConstants.FIELD_FONT_COLOR));
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                    calendarDatePriceInfo.setFare(-1);
                    calendarDatePriceInfo.setColorCode("");
                }
                if (z) {
                    ArrayList<CalendarDatePriceInfo> arrayList = this.returnDatePriceInfo;
                    if (arrayList == null) {
                        k.a();
                    }
                    arrayList.add(calendarDatePriceInfo);
                } else {
                    ArrayList<CalendarDatePriceInfo> arrayList2 = this.onwardDatePriceInfo;
                    if (arrayList2 == null) {
                        k.a();
                    }
                    arrayList2.add(calendarDatePriceInfo);
                }
            }
        }
        if (z) {
            Collections.sort(this.returnDatePriceInfo, new a());
        } else {
            Collections.sort(this.onwardDatePriceInfo, new a());
        }
    }

    final class a implements Comparator<CalendarDatePriceInfo> {
        public a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int compare(CalendarDatePriceInfo calendarDatePriceInfo, CalendarDatePriceInfo calendarDatePriceInfo2) {
            if (!(calendarDatePriceInfo == null || calendarDatePriceInfo2 == null)) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = simpleDateFormat.parse(calendarDatePriceInfo.getDate());
                    Date parse2 = simpleDateFormat.parse(calendarDatePriceInfo2.getDate());
                    if (parse.compareTo(parse2) < 0) {
                        return -1;
                    }
                    if (parse.compareTo(parse2) > 0) {
                        return 1;
                    }
                    return 0;
                } catch (Exception e2) {
                    CalendarPriceModel.this.getLOG_TAG();
                    q.c(e2.getMessage());
                }
            }
            return 0;
        }
    }
}
