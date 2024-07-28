package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.g.a;
import com.google.android.exoplayer2.extractor.g.e;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.source.hls.f;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class c implements f {

    /* renamed from: b  reason: collision with root package name */
    private final int f33144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33145c;

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        this.f33144b = 0;
        this.f33145c = true;
    }

    public final f.a a(g gVar, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, ab abVar, h hVar) throws InterruptedException, IOException {
        g gVar2;
        f.a aVar;
        if (gVar != null) {
            if (b(gVar)) {
                return a(gVar);
            }
            if (gVar instanceof n) {
                aVar = a(new n(format.A, abVar));
            } else if (gVar instanceof e) {
                aVar = a(new e());
            } else if (gVar instanceof a) {
                aVar = a(new a());
            } else if (gVar instanceof com.google.android.exoplayer2.extractor.g.c) {
                aVar = a(new com.google.android.exoplayer2.extractor.g.c());
            } else {
                aVar = gVar instanceof com.google.android.exoplayer2.extractor.d.c ? a(new com.google.android.exoplayer2.extractor.d.c()) : null;
            }
            if (aVar == null) {
                throw new IllegalArgumentException("Unexpected previousExtractor type: " + gVar.getClass().getSimpleName());
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        if ("text/vtt".equals(format.f31069i) || lastPathSegment.endsWith(".webvtt") || lastPathSegment.endsWith(".vtt")) {
            gVar2 = new n(format.A, abVar);
        } else if (lastPathSegment.endsWith(".aac")) {
            gVar2 = new e();
        } else if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            gVar2 = new a();
        } else if (lastPathSegment.endsWith(".ac4")) {
            gVar2 = new com.google.android.exoplayer2.extractor.g.c();
        } else if (lastPathSegment.endsWith(".mp3")) {
            gVar2 = new com.google.android.exoplayer2.extractor.d.c(0, 0);
        } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            gVar2 = a(abVar, drmInitData, list);
        } else {
            gVar2 = a(this.f33144b, this.f33145c, format, list, abVar);
        }
        hVar.a();
        if (a(gVar2, hVar)) {
            return a(gVar2);
        }
        if (!(gVar2 instanceof n)) {
            n nVar = new n(format.A, abVar);
            if (a(nVar, hVar)) {
                return a(nVar);
            }
        }
        if (!(gVar2 instanceof e)) {
            e eVar = new e();
            if (a(eVar, hVar)) {
                return a(eVar);
            }
        }
        if (!(gVar2 instanceof a)) {
            a aVar2 = new a();
            if (a(aVar2, hVar)) {
                return a(aVar2);
            }
        }
        if (!(gVar2 instanceof com.google.android.exoplayer2.extractor.g.c)) {
            com.google.android.exoplayer2.extractor.g.c cVar = new com.google.android.exoplayer2.extractor.g.c();
            if (a(cVar, hVar)) {
                return a(cVar);
            }
        }
        if (!(gVar2 instanceof com.google.android.exoplayer2.extractor.d.c)) {
            com.google.android.exoplayer2.extractor.d.c cVar2 = new com.google.android.exoplayer2.extractor.d.c(0, 0);
            if (a(cVar2, hVar)) {
                return a(cVar2);
            }
        }
        if (!(gVar2 instanceof com.google.android.exoplayer2.extractor.mp4.e)) {
            com.google.android.exoplayer2.extractor.mp4.e a2 = a(abVar, drmInitData, list);
            if (a(a2, hVar)) {
                return a(a2);
            }
        }
        if (!(gVar2 instanceof com.google.android.exoplayer2.extractor.g.ab)) {
            com.google.android.exoplayer2.extractor.g.ab a3 = a(this.f33144b, this.f33145c, format, list, abVar);
            if (a(a3, hVar)) {
                return a(a3);
            }
        }
        return a(gVar2);
    }

    private static com.google.android.exoplayer2.extractor.g.ab a(int i2, boolean z, Format format, List<Format> list, ab abVar) {
        int i3 = i2 | 16;
        if (list != null) {
            i3 |= 32;
        } else if (z) {
            list = Collections.singletonList(Format.a("application/cea-608"));
        } else {
            list = Collections.emptyList();
        }
        String str = format.f31066f;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(o.e(str))) {
                i3 |= 2;
            }
            if (!"video/avc".equals(o.d(str))) {
                i3 |= 4;
            }
        }
        return new com.google.android.exoplayer2.extractor.g.ab(2, abVar, new com.google.android.exoplayer2.extractor.g.g(i3, list));
    }

    private static com.google.android.exoplayer2.extractor.mp4.e a(ab abVar, DrmInitData drmInitData, List<Format> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        return new com.google.android.exoplayer2.extractor.mp4.e(0, abVar, (j) null, drmInitData, list);
    }

    private static f.a a(g gVar) {
        return new f.a(gVar, (gVar instanceof e) || (gVar instanceof a) || (gVar instanceof com.google.android.exoplayer2.extractor.g.c) || (gVar instanceof com.google.android.exoplayer2.extractor.d.c), b(gVar));
    }

    /* JADX INFO: finally extract failed */
    private static boolean a(g gVar, h hVar) throws InterruptedException, IOException {
        try {
            boolean a2 = gVar.a(hVar);
            hVar.a();
            return a2;
        } catch (EOFException unused) {
            hVar.a();
            return false;
        } catch (Throwable th) {
            hVar.a();
            throw th;
        }
    }

    private static boolean b(g gVar) {
        return (gVar instanceof com.google.android.exoplayer2.extractor.g.ab) || (gVar instanceof com.google.android.exoplayer2.extractor.mp4.e);
    }
}
