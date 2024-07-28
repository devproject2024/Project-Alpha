package com.google.android.play.core.d;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f37426a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f37427b;

    j(l lVar, c cVar) {
        this.f37427b = lVar;
        this.f37426a = cVar;
    }

    public final void run() {
        i iVar = this.f37427b.f37429a;
        List<String> list = this.f37426a.f37402a;
        List<String> c2 = l.c(this.f37426a.f37403b);
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!list.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(list));
        }
        if (!c2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(c2));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        iVar.a(d.a(bundle));
    }
}
