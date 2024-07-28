package com.travel.flight.flightticket.k;

import android.util.Pair;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;

public final class d extends w<Pair<String, String>> {
    public final void a(final String str, final String str2) {
        y yVar = new y();
        yVar.setValue(str);
        y yVar2 = new y();
        yVar2.setValue(str2);
        addSource(yVar, new z<String>() {
            public final /* synthetic */ void onChanged(Object obj) {
                d.this.setValue(Pair.create((String) obj, str2));
            }
        });
        addSource(yVar2, new z<String>() {
            public final /* synthetic */ void onChanged(Object obj) {
                d.this.setValue(Pair.create(str, (String) obj));
            }
        });
    }
}
