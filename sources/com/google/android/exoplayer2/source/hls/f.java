package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ab;
import java.io.IOException;
import java.util.List;

public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f33162a = new c();

    a a(g gVar, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, ab abVar, h hVar) throws InterruptedException, IOException;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final g f33163a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33164b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f33165c;

        public a(g gVar, boolean z, boolean z2) {
            this.f33163a = gVar;
            this.f33164b = z;
            this.f33165c = z2;
        }
    }
}
