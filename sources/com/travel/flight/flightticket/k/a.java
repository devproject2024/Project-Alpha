package com.travel.flight.flightticket.k;

import android.util.Pair;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;

public final class a extends w<Pair<Boolean, String>> {
    public final void a(final Boolean bool, final String str) {
        y yVar = new y();
        yVar.setValue(bool);
        y yVar2 = new y();
        yVar2.setValue(str);
        addSource(yVar, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                a.this.setValue(Pair.create((Boolean) obj, str));
            }
        });
        addSource(yVar2, new z<String>() {
            public final /* synthetic */ void onChanged(Object obj) {
                a.this.setValue(Pair.create(bool, (String) obj));
            }
        });
    }
}
