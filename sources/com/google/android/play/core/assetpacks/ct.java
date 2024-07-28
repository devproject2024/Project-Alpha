package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

final /* synthetic */ class ct implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final cw f37164a;

    ct(cw cwVar) {
        this.f37164a = cwVar;
    }

    public final void run() {
        cw cwVar = this.f37164a;
        dk a2 = cwVar.f37169b.a();
        ad adVar = cwVar.f37168a;
        HashMap hashMap = new HashMap();
        for (String next : adVar.a().keySet()) {
            hashMap.put(next, Long.valueOf(adVar.c(next)));
        }
        ad adVar2 = cwVar.f37168a;
        adVar2.getClass();
        a2.a((Map<String, Long>) hashMap).a(cwVar.f37170c.a(), cu.a(adVar2)).a(cwVar.f37170c.a(), cv.f37166a);
    }
}
