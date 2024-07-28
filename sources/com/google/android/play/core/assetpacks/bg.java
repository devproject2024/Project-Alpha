package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.List;

final /* synthetic */ class bg implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final bo f37050a;

    /* renamed from: b  reason: collision with root package name */
    private final List f37051b;

    bg(bo boVar, List list) {
        this.f37050a = boVar;
        this.f37051b = list;
    }

    public final Object a() {
        bo boVar = this.f37050a;
        List list = this.f37051b;
        HashMap hashMap = new HashMap();
        for (bl next : boVar.f37075e.values()) {
            String str = next.f37064c.f37057a;
            if (list.contains(str)) {
                bl blVar = (bl) hashMap.get(str);
                if ((blVar != null ? blVar.f37062a : -1) < next.f37062a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }
}
