package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.p001firebaseperf.ec;
import com.google.android.gms.internal.p001firebaseperf.hh;
import com.google.android.gms.internal.p001firebaseperf.hm;
import com.google.android.gms.internal.p001firebaseperf.hp;
import com.google.android.gms.internal.p001firebaseperf.hq;
import com.google.android.gms.internal.p001firebaseperf.y;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.c;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.remoteconfig.a;
import com.google.firebase.remoteconfig.d;
import com.google.firebase.remoteconfig.internal.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RemoteConfigManager {
    private static final RemoteConfigManager zzfe = new RemoteConfigManager();
    private static final long zzff = TimeUnit.SECONDS.toMicros(30);
    private static final long zzfg = TimeUnit.HOURS.toMillis(12);
    private final Executor executor;
    private c zzco;
    private boolean zzfh;
    private boolean zzfi;
    private long zzfj;
    private ec<hq<String, Long>> zzfk;
    private hq<String, Long> zzfl;
    private a zzfm;
    private final zzbg zzfn;

    private RemoteConfigManager() {
        this(new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue()), (a) null, FirebasePerfProvider.zzcw(), (c) null);
    }

    private RemoteConfigManager(Executor executor2, a aVar, zzbg zzbg, c cVar) {
        this.zzfh = false;
        this.zzfi = false;
        this.zzfj = 0;
        this.zzfk = new hh(new ab(this));
        this.zzfl = hq.zzj();
        this.executor = executor2;
        this.zzfm = null;
        this.zzco = null;
        this.zzfn = zzbg;
    }

    public static RemoteConfigManager zzbz() {
        return zzfe;
    }

    public final void zza(a aVar) {
        this.zzfm = aVar;
    }

    public final void zza(c cVar) {
        this.zzco = cVar;
    }

    @Deprecated
    private final hq<String, Long> zzca() {
        if (this.zzco == null) {
            return hq.zzj();
        }
        this.zzfl = this.zzfk.a();
        this.zzfh = true;
        return this.zzfl;
    }

    public final long zzc(String str, long j) {
        zzcc();
        long longValue = this.zzfl.getOrDefault(y.a(str), Long.valueOf(j)).longValue();
        if (!zzcf()) {
            return longValue;
        }
        String a2 = this.zzfm.a(y.b(str));
        try {
            longValue = (long) (((float) Long.parseLong(a2)) * 100.0f);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Fetched value: ");
            sb.append(longValue);
            sb.append(" for key: ");
            sb.append(str);
            sb.append(" from firebase remote config.");
            return longValue;
        } catch (NumberFormatException unused) {
            if (a2.isEmpty()) {
                return longValue;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(a2).length() + 45 + String.valueOf(str).length());
            sb2.append("Could not parse value: ");
            sb2.append(a2);
            sb2.append(" for key: ");
            sb2.append(str);
            sb2.append(" into a long");
            return longValue;
        }
    }

    public final float zza(String str, float f2) {
        zzcc();
        Long l = this.zzfl.get(y.a(str));
        if (l != null) {
            f2 = (float) l.longValue();
        }
        if (!zzcf()) {
            return f2;
        }
        String a2 = this.zzfm.a(y.b(str));
        try {
            return 100.0f * Float.parseFloat(a2);
        } catch (NumberFormatException unused) {
            if (a2.isEmpty()) {
                return f2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 46 + String.valueOf(str).length());
            sb.append("Could not parse value: ");
            sb.append(a2);
            sb.append(" for key: ");
            sb.append(str);
            sb.append(" into a float");
            return f2;
        }
    }

    public final void zzcb() {
        zzca();
        if (zzcf()) {
            zzck();
        }
    }

    private final void zzcc() {
        if (this.zzfh) {
            zzcd();
        } else {
            this.executor.execute(new b(this));
        }
    }

    private final void zzcd() {
        if (zzcf()) {
            int a2 = this.zzfm.f39310f.d().a();
            boolean z = true;
            if ((a2 == 1 || a2 == 0) && zzch()) {
                if (this.zzfn.b() <= zzff) {
                    z = false;
                }
                if (z) {
                    zzce();
                }
            } else if (a2 != -1 && a2 != 2) {
            } else {
                if (!this.zzfi) {
                    this.zzfj = System.currentTimeMillis();
                    this.zzfi = true;
                    this.executor.execute(new ac(this));
                } else if (zzch()) {
                    zzce();
                }
            }
        }
    }

    private final void zzce() {
        this.zzfj = System.currentTimeMillis();
        this.zzfm.b().a(this.executor, new d(this)).a(this.executor, (OnFailureListener) new c(this));
    }

    private final boolean zzcf() {
        return this.zzfm != null && this.zzfl.getOrDefault(y.a("firebase_remote_config_enabled"), 1L).longValue() == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcg */
    public final void zzck() {
        a aVar = this.zzfm;
        f a2 = aVar.f39307c.a();
        if (a2 != null && a.a(a2, aVar.f39308d.a())) {
            com.google.firebase.remoteconfig.internal.a aVar2 = aVar.f39308d;
            aVar2.a(a2);
            aVar2.a(a2, false).a(aVar.f39306b, d.a(aVar));
        }
    }

    private static hm<String> zza(Context context, String str) {
        hp zzh = hm.zzh();
        int zzf = zzf(context);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append(AppConstants.COLON);
        sb.append(zzf);
        String[] strArr = {sb.toString(), str, "1.0.0.240228580"};
        for (int i2 = 0; i2 < 3; i2++) {
            String valueOf = String.valueOf(strArr[i2]);
            String zzh2 = zzh(valueOf.length() != 0 ? "_fireperf1:".concat(valueOf) : new String("_fireperf1:"));
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzh2).length() + 16);
            sb2.append("fireperf:");
            sb2.append(zzh2);
            sb2.append("_limits");
            String str2 = null;
            try {
                str2 = com.google.android.gms.internal.p001firebaseperf.a.a(context.getContentResolver(), sb2.toString());
            } catch (SecurityException e2) {
                String valueOf2 = String.valueOf(e2.getMessage());
                if (valueOf2.length() != 0) {
                    "Failed to fetch Gservices flag. SecurityException: ".concat(valueOf2);
                } else {
                    new String("Failed to fetch Gservices flag. SecurityException: ");
                }
            }
            if (str2 != null) {
                zzh.a(str2);
            }
        }
        zzh.f9697c = true;
        return hm.zzb(zzh.f9695a, zzh.f9696b);
    }

    private static String zzh(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i2])}));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static hq<String, Long> zzc(List<String> list) {
        if (list == null) {
            return hq.zzj();
        }
        HashMap hashMap = new HashMap();
        for (String split : list) {
            for (String split2 : split.split(AppConstants.COMMA)) {
                String[] split3 = split2.split(AppConstants.COLON);
                if (split3.length >= 2) {
                    String trim = split3[0].trim();
                    if (!trim.isEmpty() && !hashMap.containsKey(trim)) {
                        try {
                            long parseLong = Long.parseLong(split3[1].trim());
                            if (parseLong >= 0) {
                                hashMap.put(trim, Long.valueOf(parseLong));
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        return hq.zza(hashMap);
    }

    private final boolean zzch() {
        return System.currentTimeMillis() - this.zzfj > zzfg;
    }

    private static int zzf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Exception exc) {
        this.zzfj = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Task task) {
        if (task.b()) {
            zzck();
            this.zzfi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzci() {
        zzca();
        zzcd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ hq zzcj() {
        return zzc(zza(this.zzco.a(), this.zzco.c().f38755b));
    }
}
