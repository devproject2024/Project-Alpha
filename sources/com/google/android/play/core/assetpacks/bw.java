package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import com.google.android.play.core.b.r;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.g;
import com.google.android.play.core.e.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

final class bw implements dk {

    /* renamed from: a  reason: collision with root package name */
    static final b f37095a = new b("FakeAssetPackService");

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f37096i = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    final x f37097b;

    /* renamed from: c  reason: collision with root package name */
    final Context f37098c;

    /* renamed from: d  reason: collision with root package name */
    final cg f37099d;

    /* renamed from: e  reason: collision with root package name */
    final Handler f37100e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    private final String f37101f;

    /* renamed from: g  reason: collision with root package name */
    private final ba f37102g;

    /* renamed from: h  reason: collision with root package name */
    private final bh<Executor> f37103h;

    bw(File file, x xVar, ba baVar, Context context, cg cgVar, bh<Executor> bhVar) {
        this.f37101f = file.getAbsolutePath();
        this.f37097b = xVar;
        this.f37102g = baVar;
        this.f37098c = context;
        this.f37099d = cgVar;
        this.f37103h = bhVar;
    }

    static long a(long j) {
        return j;
    }

    static String a(File file) throws com.google.android.play.core.common.b {
        try {
            return by.a((List<File>) Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e2) {
            throw new com.google.android.play.core.common.b("SHA256 algorithm not supported.", e2);
        } catch (IOException e3) {
            throw new com.google.android.play.core.common.b(String.format("Could not digest file: %s.", new Object[]{file}), e3);
        }
    }

    public final e<List<String>> a(Map<String, Long> map) {
        f37095a.d("syncPacks()", new Object[0]);
        return g.a(new ArrayList());
    }

    public final void a() {
        f37095a.d("keepAlive", new Object[0]);
    }

    public final void a(int i2) {
        f37095a.d("notifySessionFailed", new Object[0]);
    }

    public final void a(int i2, String str) {
        f37095a.d("notifyModuleCompleted", new Object[0]);
        this.f37103h.a().execute(new bt(this, i2, str));
    }

    public final void a(int i2, String str, String str2, int i3) {
        f37095a.d("notifyChunkTransferred", new Object[0]);
    }

    public final void a(List<String> list) {
        f37095a.d("cancelDownload(%s)", list);
    }

    /* access modifiers changed from: package-private */
    public final File[] a(String str) throws com.google.android.play.core.common.b {
        File file = new File(this.f37101f);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new bu(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a2 : listFiles) {
                        if (r.a(a2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new com.google.android.play.core.common.b(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new com.google.android.play.core.common.b(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new com.google.android.play.core.common.b(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new com.google.android.play.core.common.b(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    public final e<ParcelFileDescriptor> b(int i2, String str, String str2, int i3) {
        f37095a.d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        p pVar = new p();
        try {
            File[] a2 = a(str);
            int length = a2.length;
            int i4 = 0;
            while (i4 < length) {
                File file = a2[i4];
                if (!r.a(file).equals(str2)) {
                    i4++;
                } else {
                    pVar.a(ParcelFileDescriptor.open(file, 268435456));
                    return pVar.f37476a;
                }
            }
            throw new com.google.android.play.core.common.b(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e2) {
            f37095a.e("getChunkFileDescriptor failed", e2);
            pVar.a((Exception) new com.google.android.play.core.common.b("Asset Slice file not found.", e2));
        } catch (com.google.android.play.core.common.b e3) {
            f37095a.e("getChunkFileDescriptor failed", e3);
            pVar.a((Exception) e3);
        }
    }
}
