package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.w;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.e;
import com.google.firebase.perf.internal.f;
import com.google.firebase.perf.internal.g;
import com.google.firebase.perf.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends f implements Parcelable, e {
    public static final Parcelable.Creator<Trace> CREATOR = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, Trace> f39267g = new ConcurrentHashMap();
    private static final Parcelable.Creator<Trace> n = new d();

    /* renamed from: a  reason: collision with root package name */
    final String f39268a;

    /* renamed from: b  reason: collision with root package name */
    final List<zzs> f39269b;

    /* renamed from: c  reason: collision with root package name */
    final List<Trace> f39270c;

    /* renamed from: d  reason: collision with root package name */
    final Map<String, zza> f39271d;

    /* renamed from: e  reason: collision with root package name */
    zzbg f39272e;

    /* renamed from: f  reason: collision with root package name */
    zzbg f39273f;

    /* renamed from: h  reason: collision with root package name */
    private final Trace f39274h;

    /* renamed from: i  reason: collision with root package name */
    private final GaugeManager f39275i;
    private final v j;
    private final g k;
    private final Map<String, String> l;
    private final WeakReference<e> m;

    public final void a(zzs zzs) {
        if (b() && !a()) {
            this.f39269b.add(zzs);
        }
    }

    public int describeContents() {
        return 0;
    }

    public static Trace a(String str) {
        return new Trace(str);
    }

    private Trace(String str) {
        this(str, g.a(), new v(), a.a(), GaugeManager.zzbe());
    }

    public Trace(String str, g gVar, v vVar, a aVar) {
        this(str, gVar, vVar, aVar, GaugeManager.zzbe());
    }

    private Trace(String str, g gVar, v vVar, a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.m = new WeakReference<>(this);
        this.f39274h = null;
        this.f39268a = str.trim();
        this.f39270c = new ArrayList();
        this.f39271d = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.j = vVar;
        this.k = gVar;
        this.f39269b = new ArrayList();
        this.f39275i = gaugeManager;
    }

    public void start() {
        String str;
        String str2 = this.f39268a;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() > 100) {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", new Object[]{100});
        } else {
            if (str2.startsWith("_")) {
                w[] values = w.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (values[i2].toString().equals(str2)) {
                            break;
                        }
                        i2++;
                    } else if (!str2.startsWith("_st_")) {
                        str = "Trace name must not start with '_'";
                    }
                }
            }
            str = null;
        }
        if (str != null) {
            String.format("Cannot start trace %s. Trace name is invalid.(%s)", new Object[]{this.f39268a, str});
        } else if (this.f39272e != null) {
            String.format("Trace '%s' has already started, should not start again!", new Object[]{this.f39268a});
        } else {
            zzay();
            zzs zzcm = SessionManager.zzcl().zzcm();
            SessionManager.zzcl().zzc(this.m);
            this.f39269b.add(zzcm);
            this.f39272e = new zzbg();
            String.format("Session ID - %s", new Object[]{zzcm.f39254a});
            if (zzcm.f39255b) {
                this.f39275i.zzbg();
            }
        }
    }

    public void stop() {
        g gVar;
        if (!b()) {
            String.format("Trace '%s' has not been started so unable to stop!", new Object[]{this.f39268a});
        } else if (a()) {
            String.format("Trace '%s' has already stopped, should not stop again!", new Object[]{this.f39268a});
        } else {
            SessionManager.zzcl().zzd(this.m);
            zzaz();
            this.f39273f = new zzbg();
            if (this.f39274h == null) {
                zzbg zzbg = this.f39273f;
                if (!this.f39270c.isEmpty()) {
                    Trace trace = this.f39270c.get(this.f39270c.size() - 1);
                    if (trace.f39273f == null) {
                        trace.f39273f = zzbg;
                    }
                }
                if (!this.f39268a.isEmpty() && (gVar = this.k) != null) {
                    gVar.a(new e(this).a(), zzal());
                    if (SessionManager.zzcl().zzcm().f39255b) {
                        this.f39275i.zzbg();
                    }
                }
            }
        }
    }

    private final zza b(String str) {
        zza zza = this.f39271d.get(str);
        if (zza != null) {
            return zza;
        }
        zza zza2 = new zza(str);
        this.f39271d.put(str, zza2);
        return zza2;
    }

    @Deprecated
    public void incrementCounter(String str, long j2) {
        a(str, j2, com.google.firebase.perf.internal.w.f39237a);
    }

    private final void a(String str, long j2, int i2) {
        String a2 = com.google.firebase.perf.internal.v.a(str, i2);
        if (a2 != null) {
            int i3 = c.f39276a[i2 - 1];
            if (i3 == 1) {
                String.format("Cannot increment counter %s. Counter name is invalid.(%s)", new Object[]{str, a2});
            } else if (i3 == 2) {
                String.format("Cannot increment metric %s. Metric name is invalid.(%s)", new Object[]{str, a2});
            }
        } else if (!b()) {
            int i4 = c.f39276a[i2 - 1];
            if (i4 == 1) {
                String.format("Cannot increment counter '%s' for trace '%s' because it's not started", new Object[]{str, this.f39268a});
            } else if (i4 == 2) {
                String.format("Cannot increment metric '%s' for trace '%s' because it's not started", new Object[]{str, this.f39268a});
            }
        } else if (a()) {
            int i5 = c.f39276a[i2 - 1];
            if (i5 == 1) {
                String.format("Cannot increment counter '%s' for trace '%s' because it's been stopped", new Object[]{str, this.f39268a});
            } else if (i5 == 2) {
                String.format("Cannot increment metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.f39268a});
            }
        } else {
            b(str.trim()).a(j2);
        }
    }

    @Deprecated
    public void incrementCounter(String str) {
        incrementCounter(str, 1);
    }

    public void incrementMetric(String str, long j2) {
        a(str, j2, com.google.firebase.perf.internal.w.f39238b);
    }

    public long getLongMetric(String str) {
        zza zza = str != null ? this.f39271d.get(str.trim()) : null;
        if (zza == null) {
            return 0;
        }
        return zza.f39279b.get();
    }

    public void putMetric(String str, long j2) {
        String a2 = com.google.firebase.perf.internal.v.a(str, com.google.firebase.perf.internal.w.f39238b);
        if (a2 != null) {
            String.format("Cannot set value for metric %s. Metric name is invalid.(%s)", new Object[]{str, a2});
        } else if (!b()) {
            String.format("Cannot set value for metric '%s' for trace '%s' because it's not started", new Object[]{str, this.f39268a});
        } else if (a()) {
            String.format("Cannot set value for metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.f39268a});
        } else {
            b(str.trim()).f39279b.set(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (b() && !a()) {
                String.format("Trace '%s' is started but not stopped when it is destructed!", new Object[]{this.f39268a});
                zzc(1);
            }
        } finally {
            super.finalize();
        }
    }

    private final boolean a() {
        return this.f39273f != null;
    }

    private final boolean b() {
        return this.f39272e != null;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f39274h, 0);
        parcel.writeString(this.f39268a);
        parcel.writeList(this.f39270c);
        parcel.writeMap(this.f39271d);
        parcel.writeParcelable(this.f39272e, 0);
        parcel.writeParcelable(this.f39273f, 0);
        parcel.writeList(this.f39269b);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Trace(Parcel parcel, boolean z) {
        super(z ? null : a.a());
        Class<Trace> cls = Trace.class;
        this.m = new WeakReference<>(this);
        this.f39274h = (Trace) parcel.readParcelable(cls.getClassLoader());
        this.f39268a = parcel.readString();
        this.f39270c = new ArrayList();
        parcel.readList(this.f39270c, cls.getClassLoader());
        this.f39271d = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        parcel.readMap(this.f39271d, zza.class.getClassLoader());
        this.f39272e = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.f39273f = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
        this.f39269b = new ArrayList();
        parcel.readList(this.f39269b, zzs.class.getClassLoader());
        if (z) {
            this.k = null;
            this.j = null;
            this.f39275i = null;
            return;
        }
        this.k = g.a();
        this.j = new v();
        this.f39275i = GaugeManager.zzbe();
    }

    public void putAttribute(String str, String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (!a()) {
                if (!this.l.containsKey(str)) {
                    if (this.l.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{5}));
                    }
                }
                String a2 = com.google.firebase.perf.internal.v.a(new AbstractMap.SimpleEntry(str, str2));
                if (a2 == null) {
                    z = true;
                    if (z) {
                        this.l.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(a2);
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", new Object[]{this.f39268a}));
        } catch (Exception e2) {
            String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e2.getMessage()});
        }
    }

    public void removeAttribute(String str) {
        if (!a()) {
            this.l.remove(str);
        }
    }

    public String getAttribute(String str) {
        return this.l.get(str);
    }

    public Map<String, String> getAttributes() {
        return new HashMap(this.l);
    }

    /* synthetic */ Trace(Parcel parcel, boolean z, byte b2) {
        this(parcel, z);
    }
}
