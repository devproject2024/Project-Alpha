package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import java.io.File;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class av {

    /* renamed from: a  reason: collision with root package name */
    static final b f37011a = new b("ExtractChunkTaskHandler");

    /* renamed from: b  reason: collision with root package name */
    final byte[] f37012b = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];

    /* renamed from: c  reason: collision with root package name */
    final ad f37013c;

    /* renamed from: d  reason: collision with root package name */
    final bh<dk> f37014d;

    /* renamed from: e  reason: collision with root package name */
    final bh<x> f37015e;

    /* renamed from: f  reason: collision with root package name */
    final ba f37016f;

    av(ad adVar, bh<dk> bhVar, bh<x> bhVar2, ba baVar) {
        this.f37013c = adVar;
        this.f37014d = bhVar;
        this.f37015e = bhVar2;
        this.f37016f = baVar;
    }

    /* access modifiers changed from: package-private */
    public final File a(au auVar) {
        File a2 = this.f37013c.a(auVar.k, auVar.f37002a, auVar.f37003b, auVar.f37004c);
        if (!a2.exists()) {
            a2.mkdirs();
        }
        return a2;
    }
}
