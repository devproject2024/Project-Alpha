package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.measurement.internal.fc;
import com.google.android.gms.measurement.internal.fx;
import com.google.android.gms.measurement.internal.fy;
import com.google.android.gms.measurement.internal.fz;
import com.google.android.gms.measurement.internal.gb;
import com.google.android.gms.measurement.internal.ge;
import com.google.android.gms.measurement.internal.hd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {

    /* renamed from: d  reason: collision with root package name */
    private static volatile AppMeasurement f11671d;

    /* renamed from: a  reason: collision with root package name */
    public final fc f11672a;

    /* renamed from: b  reason: collision with root package name */
    public final hd f11673b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11674c;

    public static final class a extends fx {
    }

    public interface b extends gb {
    }

    public static final class c extends fz {
    }

    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return a(context);
    }

    private static AppMeasurement a(Context context) {
        if (f11671d == null) {
            synchronized (AppMeasurement.class) {
                if (f11671d == null) {
                    hd b2 = b(context, (Bundle) null);
                    if (b2 != null) {
                        f11671d = new AppMeasurement(b2);
                    } else {
                        f11671d = new AppMeasurement(fc.a(context, (Bundle) null));
                    }
                }
            }
        }
        return f11671d;
    }

    public static AppMeasurement a(Context context, Bundle bundle) {
        if (f11671d == null) {
            synchronized (AppMeasurement.class) {
                if (f11671d == null) {
                    hd b2 = b(context, bundle);
                    if (b2 != null) {
                        f11671d = new AppMeasurement(b2);
                    } else {
                        f11671d = new AppMeasurement(fc.a(context, bundle));
                    }
                }
            }
        }
        return f11671d;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.measurement.internal.hd b(android.content.Context r8, android.os.Bundle r9) {
        /*
            r0 = 0
            java.lang.String r1 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0027 }
            java.lang.String r2 = "getScionFrontendApiImplementation"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.Class<android.os.Bundle> r5 = android.os.Bundle.class
            r7 = 1
            r4[r7] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{  }
            r2[r6] = r8     // Catch:{  }
            r2[r7] = r9     // Catch:{  }
            java.lang.Object r8 = r1.invoke(r0, r2)     // Catch:{  }
            com.google.android.gms.measurement.internal.hd r8 = (com.google.android.gms.measurement.internal.hd) r8     // Catch:{  }
            return r8
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.b(android.content.Context, android.os.Bundle):com.google.android.gms.measurement.internal.hd");
    }

    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        public ConditionalUserProperty() {
        }

        private ConditionalUserProperty(Bundle bundle) {
            s.a(bundle);
            this.mAppId = (String) fy.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) fy.a(bundle, "origin", String.class, null);
            this.mName = (String) fy.a(bundle, "name", String.class, null);
            this.mValue = fy.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) fy.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) fy.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) fy.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) fy.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) fy.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) fy.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) fy.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) fy.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) fy.a(bundle, "expired_event_params", Bundle.class, null);
        }

        /* synthetic */ ConditionalUserProperty(Bundle bundle, byte b2) {
            this(bundle);
        }

        static /* synthetic */ Bundle a(ConditionalUserProperty conditionalUserProperty) {
            Bundle bundle = new Bundle();
            String str = conditionalUserProperty.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = conditionalUserProperty.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = conditionalUserProperty.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                fy.a(bundle, obj);
            }
            String str4 = conditionalUserProperty.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
            String str5 = conditionalUserProperty.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = conditionalUserProperty.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
            String str7 = conditionalUserProperty.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
            bundle.putBoolean("active", conditionalUserProperty.mActive);
            bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
            return bundle;
        }
    }

    private AppMeasurement(fc fcVar) {
        s.a(fcVar);
        this.f11672a = fcVar;
        this.f11673b = null;
        this.f11674c = false;
    }

    private AppMeasurement(hd hdVar) {
        s.a(hdVar);
        this.f11673b = hdVar;
        this.f11672a = null;
        this.f11674c = true;
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f11674c) {
            this.f11673b.a(str, str2, bundle);
        } else {
            this.f11672a.d().a(str, str2, bundle);
        }
    }

    public final void a(b bVar) {
        if (this.f11674c) {
            this.f11673b.a((gb) bVar);
        } else {
            this.f11672a.d().a((gb) bVar);
        }
    }

    public String getCurrentScreenName() {
        if (this.f11674c) {
            return this.f11673b.a();
        }
        return this.f11672a.d().D();
    }

    public String getCurrentScreenClass() {
        if (this.f11674c) {
            return this.f11673b.b();
        }
        return this.f11672a.d().E();
    }

    public String getAppInstanceId() {
        if (this.f11674c) {
            return this.f11673b.c();
        }
        return this.f11672a.d().B();
    }

    public String getGmpAppId() {
        if (this.f11674c) {
            return this.f11673b.d();
        }
        return this.f11672a.d().F();
    }

    public long generateEventId() {
        if (this.f11674c) {
            return this.f11673b.e();
        }
        return this.f11672a.e().c();
    }

    public void beginAdUnitExposure(String str) {
        if (this.f11674c) {
            this.f11673b.a(str);
        } else {
            this.f11672a.p().a(str, this.f11672a.j().b());
        }
    }

    public void endAdUnitExposure(String str) {
        if (this.f11674c) {
            this.f11673b.b(str);
        } else {
            this.f11672a.p().b(str, this.f11672a.j().b());
        }
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        s.a(conditionalUserProperty);
        if (this.f11674c) {
            this.f11673b.a(ConditionalUserProperty.a(conditionalUserProperty));
            return;
        }
        ge d2 = this.f11672a.d();
        d2.a(ConditionalUserProperty.a(conditionalUserProperty), d2.j().a());
    }

    /* access modifiers changed from: protected */
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        s.a(conditionalUserProperty);
        if (!this.f11674c) {
            ge d2 = this.f11672a.d();
            Bundle a2 = ConditionalUserProperty.a(conditionalUserProperty);
            s.a(a2);
            s.a(a2.getString("app_id"));
            d2.M_();
            d2.b(new Bundle(a2), d2.j().a());
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f11674c) {
            this.f11673b.b(str, str2, bundle);
        } else {
            this.f11672a.d().c(str, str2, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (!this.f11674c) {
            ge d2 = this.f11672a.d();
            s.a(str);
            d2.M_();
            d2.a(str, str2, str3, bundle);
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        if (this.f11674c) {
            return this.f11673b.a(str, str2, z);
        }
        return this.f11672a.d().a((String) null, str, str2, z);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (!this.f11674c) {
            ge d2 = this.f11672a.d();
            s.a(str);
            d2.M_();
            return d2.a(str, str2, str3, z);
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> list;
        int i2;
        if (this.f11674c) {
            list = this.f11673b.a(str, str2);
        } else {
            list = this.f11672a.d().a((String) null, str, str2);
        }
        if (list == null) {
            i2 = 0;
        } else {
            i2 = list.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty, (byte) 0));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        int i2;
        if (!this.f11674c) {
            ge d2 = this.f11672a.d();
            s.a(str);
            d2.M_();
            ArrayList<Bundle> a2 = d2.a(str, str2, str3);
            if (a2 == null) {
                i2 = 0;
            } else {
                i2 = a2.size();
            }
            ArrayList arrayList = new ArrayList(i2);
            ArrayList arrayList2 = a2;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                arrayList.add(new ConditionalUserProperty((Bundle) obj, (byte) 0));
            }
            return arrayList;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    public int getMaxUserProperties(String str) {
        if (this.f11674c) {
            return this.f11673b.c(str);
        }
        this.f11672a.d();
        s.a(str);
        return 25;
    }
}
