package com.google.android.play.core.assetpacks;

import java.util.Arrays;
import java.util.Map;

final /* synthetic */ class bf implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final bo f37046a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37047b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37048c;

    /* renamed from: d  reason: collision with root package name */
    private final long f37049d;

    bf(bo boVar, String str, int i2, long j) {
        this.f37046a = boVar;
        this.f37047b = str;
        this.f37048c = i2;
        this.f37049d = j;
    }

    public final Object a() {
        bo boVar = this.f37046a;
        String str = this.f37047b;
        int i2 = this.f37048c;
        long j = this.f37049d;
        bl blVar = (bl) ((Map) boVar.a(new bg(boVar, Arrays.asList(new String[]{str})))).get(str);
        if (blVar == null || by.a(blVar.f37064c.f37059c)) {
            bo.f37071a.b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        boVar.f37072b.g(str, i2, j);
        blVar.f37064c.f37059c = 4;
        return null;
    }
}
