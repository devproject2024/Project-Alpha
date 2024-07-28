package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.g;
import com.google.android.gms.internal.p001firebaseperf.z;
import java.util.concurrent.TimeUnit;

public class FeatureControl {
    private static final FeatureControl zzce = new FeatureControl();
    private static final long zzch = TimeUnit.HOURS.toMinutes(4);
    private final RemoteConfigManager zzcf;
    private z zzcg;

    private FeatureControl() {
        this(RemoteConfigManager.zzbz(), (z) null);
    }

    public final void zza(z zVar) {
        this.zzcg = zVar;
    }

    private FeatureControl(RemoteConfigManager remoteConfigManager, z zVar) {
        this.zzcf = remoteConfigManager;
        this.zzcg = new z();
    }

    public static synchronized FeatureControl zzao() {
        FeatureControl featureControl;
        synchronized (FeatureControl.class) {
            featureControl = zzce;
        }
        return featureControl;
    }

    public final boolean zzap() {
        return zzb("sessions_feature_enabled", 1) != 0;
    }

    public final boolean zzaq() {
        return zzb("sessions_cpu_capture_enabled", 1) != 0;
    }

    public final boolean zzar() {
        return zzb("sessions_memory_capture_enabled", 1) != 0;
    }

    public final float zzas() {
        return this.zzcg.f9735a.getFloat("sessions_sampling_percentage", this.zzcf.zza("sessions_sampling_percentage", 1.0f));
    }

    public final long zzat() {
        return zzb("sessions_cpu_capture_frequency_fg_ms", 100);
    }

    public final long zzau() {
        return zzb("sessions_memory_capture_frequency_fg_ms", 100);
    }

    public final long zzav() {
        return zzb("sessions_cpu_capture_frequency_bg_ms", 0);
    }

    public final long zzaw() {
        return zzb("sessions_memory_capture_frequency_bg_ms", 0);
    }

    public final long zzax() {
        return zzb("sessions_max_length_minutes", zzch);
    }

    private final long zzb(String str, long j) {
        int i2 = this.zzcg.f9735a.getInt(str, g.a(this.zzcf.zzc(str, j)));
        return (i2 == Integer.MAX_VALUE || i2 == Integer.MIN_VALUE) ? j : (long) i2;
    }
}
