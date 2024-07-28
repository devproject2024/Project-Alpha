package com.google.firebase.ml.vision.barcode.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.b.b;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_ml.bg;
import com.google.android.gms.internal.firebase_ml.bq;
import com.google.android.gms.internal.firebase_ml.br;
import com.google.android.gms.internal.firebase_ml.di;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.dt;
import com.google.android.gms.internal.firebase_ml.ea;
import com.google.android.gms.internal.firebase_ml.eh;
import com.google.android.gms.internal.firebase_ml.ej;
import com.google.android.gms.internal.firebase_ml.en;
import com.google.android.gms.internal.firebase_ml.zzsb;
import com.google.android.gms.vision.b;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.firebase.ml.vision.barcode.a;
import com.google.firebase.ml.vision.barcode.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class d implements di<List<a>, en>, ea {

    /* renamed from: a  reason: collision with root package name */
    static boolean f39124a = true;

    /* renamed from: b  reason: collision with root package name */
    final c f39125b;

    /* renamed from: c  reason: collision with root package name */
    a f39126c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f39127d;

    /* renamed from: e  reason: collision with root package name */
    private final dt f39128e;

    /* renamed from: f  reason: collision with root package name */
    private final eh f39129f = new eh();

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.gms.vision.barcode.a f39130g;

    public d(ds dsVar, c cVar) {
        s.a(dsVar, (Object) "MlKitContext can not be null");
        s.a(cVar, (Object) "FirebaseVisionBarcodeDetectorOptions can not be null");
        this.f39127d = dsVar.f9817b.a();
        this.f39125b = cVar;
        this.f39128e = dt.a(dsVar);
    }

    public final ea a() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() throws com.google.firebase.ml.common.a {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.firebase.ml.vision.barcode.internal.a r0 = r4.f39126c     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000b
            com.google.firebase.ml.vision.barcode.internal.a r0 = r4.d()     // Catch:{ all -> 0x003c }
            r4.f39126c = r0     // Catch:{ all -> 0x003c }
        L_0x000b:
            com.google.firebase.ml.vision.barcode.internal.a r0 = r4.f39126c     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0021
            com.google.firebase.ml.vision.barcode.internal.a r0 = r4.f39126c     // Catch:{ RemoteException -> 0x0016 }
            r0.Q_()     // Catch:{ RemoteException -> 0x0016 }
            monitor-exit(r4)
            return
        L_0x0016:
            r0 = move-exception
            com.google.firebase.ml.common.a r1 = new com.google.firebase.ml.common.a     // Catch:{ all -> 0x003c }
            java.lang.String r2 = "Failed to start barcode detector pipeline."
            r3 = 14
            r1.<init>(r2, r3, r0)     // Catch:{ all -> 0x003c }
            throw r1     // Catch:{ all -> 0x003c }
        L_0x0021:
            com.google.android.gms.vision.barcode.a r0 = r4.f39130g     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x003a
            com.google.android.gms.vision.barcode.a$a r0 = new com.google.android.gms.vision.barcode.a$a     // Catch:{ all -> 0x003c }
            android.content.Context r1 = r4.f39127d     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            com.google.firebase.ml.vision.barcode.c r1 = r4.f39125b     // Catch:{ all -> 0x003c }
            int r1 = r1.f39115a     // Catch:{ all -> 0x003c }
            com.google.android.gms.vision.barcode.a$a r0 = r0.a(r1)     // Catch:{ all -> 0x003c }
            com.google.android.gms.vision.barcode.a r0 = r0.a()     // Catch:{ all -> 0x003c }
            r4.f39130g = r0     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r4)
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.barcode.internal.d.b():void");
    }

    private final a d() throws com.google.firebase.ml.common.a {
        if (DynamiteModule.a(this.f39127d, "com.google.firebase.ml.vision.dynamite.barcode") <= 0) {
            return null;
        }
        try {
            return i.a(DynamiteModule.a(this.f39127d, DynamiteModule.f9009b, "com.google.firebase.ml.vision.dynamite.barcode").a("com.google.firebase.ml.vision.barcode.BarcodeDetectorCreator")).a(new BarcodeDetectorOptionsParcel(this.f39125b.f39115a));
        } catch (RemoteException | DynamiteModule.a e2) {
            throw new com.google.firebase.ml.common.a("Failed to load barcode detector module.", 14, e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.firebase.ml.vision.barcode.internal.a r0 = r2.f39126c     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            com.google.firebase.ml.vision.barcode.internal.a r0 = r2.f39126c     // Catch:{ RemoteException -> 0x000b }
            r0.b()     // Catch:{ RemoteException -> 0x000b }
        L_0x000b:
            r2.f39126c = r1     // Catch:{ all -> 0x001d }
        L_0x000d:
            com.google.android.gms.vision.barcode.a r0 = r2.f39130g     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0018
            com.google.android.gms.vision.barcode.a r0 = r2.f39130g     // Catch:{ all -> 0x001d }
            r0.a()     // Catch:{ all -> 0x001d }
            r2.f39130g = r1     // Catch:{ all -> 0x001d }
        L_0x0018:
            r0 = 1
            f39124a = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            return
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.barcode.internal.d.c():void");
    }

    /* access modifiers changed from: private */
    public final synchronized List<a> a(en enVar) throws com.google.firebase.ml.common.a {
        ArrayList arrayList;
        en enVar2 = enVar;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            eh ehVar = this.f39129f;
            if (enVar2.f9869b.f12544c != null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                ehVar.f9861b.add(Long.valueOf(elapsedRealtime2));
                if (ehVar.f9861b.size() > 5) {
                    ehVar.f9861b.removeFirst();
                }
                if (ehVar.f9861b.size() == 5 && elapsedRealtime2 - ehVar.f9861b.peekFirst().longValue() < 5000 && (ehVar.f9862c == -1 || elapsedRealtime2 - ehVar.f9862c >= TimeUnit.SECONDS.toMillis(5))) {
                    ehVar.f9862c = elapsedRealtime2;
                    j jVar = eh.f9860a;
                    if (jVar.a(5)) {
                        jVar.e("ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                    }
                }
            }
            arrayList = new ArrayList();
            if (this.f39126c != null) {
                try {
                    b a2 = com.google.android.gms.b.d.a(enVar2.f9869b);
                    b.C0164b bVar = enVar2.f9869b.f12542a;
                    for (e aVar : (List) com.google.android.gms.b.d.a(this.f39126c.a(a2, new zzsb(bVar.f12546a, bVar.f12547b, bVar.f12548c, bVar.f12549d, bVar.f12550e)))) {
                        arrayList.add(new a(aVar));
                    }
                } catch (RemoteException e2) {
                    throw new com.google.firebase.ml.common.a("Failed to run barcode detector.", 14, e2);
                }
            } else if (this.f39130g == null) {
                a(bq.UNKNOWN_ERROR, elapsedRealtime, enVar, (List<a>) null);
                throw new com.google.firebase.ml.common.a("Model source is unavailable. Please load the model resource first.", 14);
            } else if (this.f39130g.f12616a.b()) {
                SparseArray<Barcode> a3 = this.f39130g.a(enVar2.f9869b);
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    arrayList.add(new a(new g(a3.get(a3.keyAt(i2)))));
                }
            } else {
                a(bq.MODEL_NOT_DOWNLOADED, elapsedRealtime, enVar, (List<a>) null);
                throw new com.google.firebase.ml.common.a("Waiting for the barcode detection model to be downloaded. Please wait.", 14);
            }
            a(bq.NO_ERROR, elapsedRealtime, enVar, arrayList);
            f39124a = false;
        }
        return arrayList;
    }

    private final void a(bq bqVar, long j, en enVar, List<a> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (a next : list) {
                SparseArray<bg.n.a> sparseArray = a.f39110a;
                int b2 = next.f39112c.b();
                if (b2 > 4096 || b2 == 0) {
                    b2 = -1;
                }
                bg.n.a aVar = sparseArray.get(b2);
                if (aVar == null) {
                    aVar = bg.n.a.FORMAT_UNKNOWN;
                }
                arrayList.add(aVar);
                bg.n.b bVar = a.f39111b.get(next.f39112c.c());
                if (bVar == null) {
                    bVar = bg.n.b.TYPE_UNKNOWN;
                }
                arrayList2.add(bVar);
            }
        }
        c cVar = new c(this, SystemClock.elapsedRealtime() - j, bqVar, arrayList, arrayList2, enVar);
        dt dtVar = this.f39128e;
        br brVar = br.ON_DEVICE_BARCODE_DETECT;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = true;
        if (!dtVar.a() || (dtVar.f9826i.get(brVar) != null && elapsedRealtime - dtVar.f9826i.get(brVar).longValue() <= TimeUnit.SECONDS.toMillis(30))) {
            z = false;
        }
        if (z) {
            dtVar.f9826i.put(brVar, Long.valueOf(elapsedRealtime));
            dtVar.a(cVar.a(), brVar);
        }
        bg.ag.b.a().a(bqVar).a(f39124a).a(ej.a(enVar)).a(this.f39125b.a()).a((Iterable<? extends bg.n.a>) arrayList).b(arrayList2).i();
        new f(this);
        dt dtVar2 = this.f39128e;
        br brVar2 = br.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        dtVar2.a();
    }
}
