package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.b.bq;
import com.google.android.play.core.b.r;
import com.google.android.play.core.common.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

final /* synthetic */ class bt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bw f37089a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37090b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37091c;

    bt(bw bwVar, int i2, String str) {
        this.f37089a = bwVar;
        this.f37090b = i2;
        this.f37091c = str;
    }

    public final void run() {
        bw bwVar = this.f37089a;
        int i2 = this.f37090b;
        String str = this.f37091c;
        int i3 = 1;
        int i4 = 0;
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_version_code", bwVar.f37099d.a());
            bundle.putInt("session_id", i2);
            File[] a2 = bwVar.a(str);
            ArrayList arrayList = new ArrayList();
            int length = a2.length;
            long j = 0;
            int i5 = 0;
            while (i5 < length) {
                File file = a2[i5];
                j += file.length();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add((Object) null);
                String a3 = r.a(file);
                bundle.putParcelableArrayList(bq.a("chunk_intents", str, a3), arrayList2);
                bundle.putString(bq.a("uncompressed_hash_sha256", str, a3), bw.a(file));
                bundle.putLong(bq.a("uncompressed_size", str, a3), file.length());
                arrayList.add(a3);
                i5++;
                i3 = 1;
                i4 = 0;
            }
            bundle.putStringArrayList(bq.a("slice_ids", str), arrayList);
            bundle.putLong(bq.a("pack_version", str), (long) bwVar.f37099d.a());
            bundle.putInt(bq.a("status", str), 4);
            bundle.putInt(bq.a("error_code", str), i4);
            bundle.putLong(bq.a("bytes_downloaded", str), bw.a(j));
            bundle.putLong(bq.a("total_bytes_to_download", str), j);
            String[] strArr = new String[i3];
            strArr[i4] = str;
            bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(strArr)));
            bundle.putLong("bytes_downloaded", bw.a(j));
            bundle.putLong("total_bytes_to_download", j);
            bwVar.f37100e.post(new bv(bwVar, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
        } catch (b e2) {
            bw.f37095a.e("notifyModuleCompleted failed", e2);
        }
    }
}
