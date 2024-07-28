package com.travel.flight.flightSRPV2.view.ui.a;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.travel.flight.flightSRPV2.view.ui.b.a;
import kotlin.g.b.k;

public final class e extends o {

    /* renamed from: a  reason: collision with root package name */
    public final int f24187a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<a> f24188b = new SparseArray<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(int i2, j jVar) {
        super(jVar, 1);
        k.c(jVar, "fragManager");
        this.f24187a = i2;
    }

    public final Fragment getItem(int i2) {
        a aVar = this.f24188b.get(i2);
        if (aVar == null) {
            a.C0459a aVar2 = a.f24232a;
            boolean z = i2 == 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_ONWARD", z);
            aVar = new a();
            aVar.setArguments(bundle);
            this.f24188b.put(i2, aVar);
        }
        return aVar;
    }

    public final int getCount() {
        return this.f24187a;
    }
}
