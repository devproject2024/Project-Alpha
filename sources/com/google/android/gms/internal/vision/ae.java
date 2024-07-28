package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;
import java.util.Iterator;

final /* synthetic */ class ae implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ac f10989a;

    ae(ac acVar) {
        this.f10989a = acVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        ac acVar = this.f10989a;
        synchronized (acVar.f10975a) {
            acVar.f10976b = null;
            z.a();
        }
        synchronized (acVar) {
            Iterator<Object> it2 = acVar.f10977c.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
