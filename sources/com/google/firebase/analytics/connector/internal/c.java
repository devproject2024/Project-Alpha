package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.common.util.b;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.hj;
import com.google.firebase.analytics.connector.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f37981a = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f37982b = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open"});

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f37983c = Arrays.asList(new String[]{"auto", AppManagerUtil.EXTEND_PREFIX_DEFAULT, "am"});

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f37984d = Arrays.asList(new String[]{"_r", "_dbg"});

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f37985e = Arrays.asList((String[]) b.a(AppMeasurement.c.f12004a, AppMeasurement.c.f12005b));

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f37986f = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static boolean a(String str) {
        return !f37983c.contains(str);
    }

    public static boolean a(String str, Bundle bundle) {
        if (f37982b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String containsKey : f37984d) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        return !f37981a.contains(str);
    }

    public static boolean a(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f37985e.contains(str2)) {
            return false;
        }
        for (String matches : f37986f) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(a.c cVar) {
        String str;
        if (cVar == null || (str = cVar.f37960a) == null || str.isEmpty()) {
            return false;
        }
        if ((cVar.f37962c != null && hj.a(cVar.f37962c) == null) || !a(str) || !a(str, cVar.f37961b)) {
            return false;
        }
        if (cVar.k != null && (!a(cVar.k, cVar.l) || !a(str, cVar.k, cVar.l))) {
            return false;
        }
        if (cVar.f37967h != null && (!a(cVar.f37967h, cVar.f37968i) || !a(str, cVar.f37967h, cVar.f37968i))) {
            return false;
        }
        if (cVar.f37965f == null) {
            return true;
        }
        if (a(cVar.f37965f, cVar.f37966g) && a(str, cVar.f37965f, cVar.f37966g)) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        for (String containsKey : f37984d) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c2 = 2;
                }
            } else if (str.equals("fdl")) {
                c2 = 1;
            }
        } else if (str.equals("fcm")) {
            c2 = 0;
        }
        if (c2 == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        } else if (c2 == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        } else if (c2 != 2) {
            return false;
        } else {
            bundle.putString("_cis", "fiam_integration");
            return true;
        }
    }

    public static AppMeasurement.ConditionalUserProperty b(a.c cVar) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mOrigin = cVar.f37960a;
        conditionalUserProperty.mActive = cVar.n;
        conditionalUserProperty.mCreationTimestamp = cVar.m;
        conditionalUserProperty.mExpiredEventName = cVar.k;
        if (cVar.l != null) {
            conditionalUserProperty.mExpiredEventParams = new Bundle(cVar.l);
        }
        conditionalUserProperty.mName = cVar.f37961b;
        conditionalUserProperty.mTimedOutEventName = cVar.f37965f;
        if (cVar.f37966g != null) {
            conditionalUserProperty.mTimedOutEventParams = new Bundle(cVar.f37966g);
        }
        conditionalUserProperty.mTimeToLive = cVar.j;
        conditionalUserProperty.mTriggeredEventName = cVar.f37967h;
        if (cVar.f37968i != null) {
            conditionalUserProperty.mTriggeredEventParams = new Bundle(cVar.f37968i);
        }
        conditionalUserProperty.mTriggeredTimestamp = cVar.o;
        conditionalUserProperty.mTriggerEventName = cVar.f37963d;
        conditionalUserProperty.mTriggerTimeout = cVar.f37964e;
        if (cVar.f37962c != null) {
            conditionalUserProperty.mValue = hj.a(cVar.f37962c);
        }
        return conditionalUserProperty;
    }

    public static a.c a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        a.c cVar = new a.c();
        cVar.f37960a = conditionalUserProperty.mOrigin;
        cVar.n = conditionalUserProperty.mActive;
        cVar.m = conditionalUserProperty.mCreationTimestamp;
        cVar.k = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            cVar.l = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        cVar.f37961b = conditionalUserProperty.mName;
        cVar.f37965f = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            cVar.f37966g = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        cVar.j = conditionalUserProperty.mTimeToLive;
        cVar.f37967h = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            cVar.f37968i = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        cVar.o = conditionalUserProperty.mTriggeredTimestamp;
        cVar.f37963d = conditionalUserProperty.mTriggerEventName;
        cVar.f37964e = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            cVar.f37962c = hj.a(conditionalUserProperty.mValue);
        }
        return cVar;
    }

    public static String c(String str) {
        String a2 = AppMeasurement.a.a(str);
        return a2 != null ? a2 : str;
    }
}
