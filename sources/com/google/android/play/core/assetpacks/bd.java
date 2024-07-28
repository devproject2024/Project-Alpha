package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.b.bq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final /* synthetic */ class bd implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final bo f37042a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f37043b;

    bd(bo boVar, Bundle bundle) {
        this.f37042a = boVar;
        this.f37043b = bundle;
    }

    public final Object a() {
        bm bmVar;
        bo boVar = this.f37042a;
        Bundle bundle = this.f37043b;
        int i2 = bundle.getInt("session_id");
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        Map<Integer, bl> map = boVar.f37075e;
        Integer valueOf = Integer.valueOf(i2);
        boolean z = false;
        if (map.containsKey(valueOf)) {
            bl b2 = boVar.b(i2);
            int i3 = bundle.getInt(bq.a("status", b2.f37064c.f37057a));
            if (by.a(b2.f37064c.f37059c, i3)) {
                bo.f37071a.a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(b2.f37064c.f37059c));
                bk bkVar = b2.f37064c;
                String str = bkVar.f37057a;
                int i4 = bkVar.f37059c;
                if (i4 == 4) {
                    boVar.f37073c.a().a(i2, str);
                } else if (i4 == 5) {
                    boVar.f37073c.a().a(i2);
                } else if (i4 == 6) {
                    boVar.f37073c.a().a((List<String>) Arrays.asList(new String[]{str}));
                }
            } else {
                b2.f37064c.f37059c = i3;
                if (by.a(i3)) {
                    boVar.a(i2);
                    boVar.f37074d.a(b2.f37064c.f37057a);
                } else {
                    List<bm> list = b2.f37064c.f37061e;
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        bm bmVar2 = list.get(i5);
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(bq.a("chunk_intents", b2.f37064c.f37057a, bmVar2.f37065a));
                        if (parcelableArrayList != null) {
                            for (int i6 = 0; i6 < parcelableArrayList.size(); i6++) {
                                if (!(parcelableArrayList.get(i6) == null || ((Intent) parcelableArrayList.get(i6)).getData() == null)) {
                                    bmVar2.f37068d.get(i6).f37056a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String a2 = bo.a(bundle);
            long j = bundle.getLong(bq.a("pack_version", a2));
            int i7 = bundle.getInt(bq.a("status", a2));
            long j2 = bundle.getLong(bq.a("total_bytes_to_download", a2));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(bq.a("slice_ids", a2));
            ArrayList arrayList = new ArrayList();
            for (T t : bo.a(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(bq.a("chunk_intents", a2, (String) t));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : bo.a(parcelableArrayList2)) {
                    if (intent != null) {
                        z = true;
                    }
                    arrayList2.add(new bj(z));
                    z = false;
                }
                String string = bundle.getString(bq.a("uncompressed_hash_sha256", a2, (String) t));
                long j3 = bundle.getLong(bq.a("uncompressed_size", a2, (String) t));
                z = false;
                int i8 = bundle.getInt(bq.a("patch_format", a2, (String) t), 0);
                if (i8 == 0) {
                    bmVar = new bm(t, string, j3, arrayList2, bundle.getInt(bq.a("compression_format", a2, (String) t), 0), 0);
                } else {
                    bmVar = new bm(t, string, j3, arrayList2, 0, i8);
                }
                arrayList.add(bmVar);
            }
            boVar.f37075e.put(Integer.valueOf(i2), new bl(i2, bundle.getInt("app_version_code"), new bk(a2, j, i7, j2, arrayList)));
        }
        return Boolean.TRUE;
    }
}
