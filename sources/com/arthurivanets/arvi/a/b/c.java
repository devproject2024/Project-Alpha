package com.arthurivanets.arvi.a.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.arthurivanets.arvi.b.b.b;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.f;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;

public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f30986a = new c() {
        public final o a(Context context, Uri uri, String str, Handler handler, i.a aVar, i.a aVar2, p pVar) {
            Uri uri2 = uri;
            Handler handler2 = handler;
            i.a aVar3 = aVar;
            i.a aVar4 = aVar2;
            p pVar2 = pVar;
            int b2 = TextUtils.isEmpty(str) ? ae.b(uri) : ae.k(AppUtility.CENTER_DOT.concat(String.valueOf(str)));
            if (b2 == 0) {
                DashMediaSource createMediaSource = new DashMediaSource.Factory(new f.a(aVar4), aVar3).createMediaSource(uri);
                b.a(createMediaSource, handler2, pVar2);
                return createMediaSource;
            } else if (b2 == 1) {
                SsMediaSource createMediaSource2 = new SsMediaSource.Factory(new a.C0550a(aVar4), aVar3).createMediaSource(uri);
                b.a(createMediaSource2, handler2, pVar2);
                return createMediaSource2;
            } else if (b2 == 2) {
                HlsMediaSource createMediaSource3 = new HlsMediaSource.Factory(aVar4).createMediaSource(uri);
                b.a(createMediaSource3, handler2, pVar2);
                return createMediaSource3;
            } else if (b2 == 3) {
                j.a aVar5 = new j.a(aVar4);
                aVar5.f33209g = true;
                if (aVar5.f33204b == null) {
                    aVar5.f33204b = new e();
                }
                j jVar = new j(uri, aVar5.f33203a, aVar5.f33204b, aVar5.f33207e, aVar5.f33205c, aVar5.f33208f, aVar5.f33206d, (byte) 0);
                b.a(jVar, handler2, pVar2);
                return jVar;
            } else {
                throw new IllegalStateException("Unsupported type: ".concat(String.valueOf(b2)));
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final c f30987b = new c() {
        public final o a(Context context, Uri uri, String str, Handler handler, i.a aVar, i.a aVar2, p pVar) {
            return new m(f30986a.a(context, uri, str, handler, aVar, aVar2, pVar));
        }
    };

    o a(Context context, Uri uri, String str, Handler handler, i.a aVar, i.a aVar2, p pVar);
}
