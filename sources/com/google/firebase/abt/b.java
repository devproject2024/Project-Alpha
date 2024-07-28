package com.google.firebase.abt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final DateFormat f37939a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f37940h = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: b  reason: collision with root package name */
    final String f37941b;

    /* renamed from: c  reason: collision with root package name */
    final String f37942c;

    /* renamed from: d  reason: collision with root package name */
    final String f37943d;

    /* renamed from: e  reason: collision with root package name */
    final Date f37944e;

    /* renamed from: f  reason: collision with root package name */
    final long f37945f;

    /* renamed from: g  reason: collision with root package name */
    final long f37946g;

    private b(String str, String str2, String str3, Date date, long j, long j2) {
        this.f37941b = str;
        this.f37942c = str2;
        this.f37943d = str3;
        this.f37944e = date;
        this.f37945f = j;
        this.f37946g = j2;
    }

    static b a(Map<String, String> map) throws a {
        ArrayList arrayList = new ArrayList();
        for (String str : f37940h) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            try {
                return new b(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", f37939a.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
            } catch (ParseException e2) {
                throw new a("Could not process experiment: parsing experiment start time failed.", e2);
            } catch (NumberFormatException e3) {
                throw new a("Could not process experiment: one of the durations could not be converted into a long.", e3);
            }
        } else {
            throw new a(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }
}
