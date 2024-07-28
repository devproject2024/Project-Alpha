package com.travel.flight.flightSRPV2.b;

import android.os.Bundle;
import kotlin.g.b.k;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    final int f24142a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f24143b;

    /* renamed from: c  reason: collision with root package name */
    final String f24144c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, int i2, String str2, int i3) {
        this(str, (e) null, i2, false, (i3 & 32) != 0 ? "" : str2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(String str, e eVar, int i2, boolean z, String str2) {
        super(str, (Bundle) null, eVar);
        k.c(str, "target");
        k.c(str2, "backStackTag");
        this.f24142a = i2;
        this.f24143b = z;
        this.f24144c = str2;
    }
}
