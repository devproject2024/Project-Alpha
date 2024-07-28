package com.google.android.play.core.d;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.e.p;
import java.util.ArrayList;
import java.util.List;

final class w extends y<List<d>> {
    w(z zVar, p<List<d>> pVar) {
        super(zVar, pVar);
    }

    public final void a(List<Bundle> list) throws RemoteException {
        super.a(list);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(d.a(list.get(i2)));
        }
        this.f37450a.b(arrayList);
    }
}
