package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.Iterator;

final /* synthetic */ class bl implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final bm f10501a;

    bl(bm bmVar) {
        this.f10501a = bmVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        bm bmVar = this.f10501a;
        synchronized (bmVar.f10503a) {
            bmVar.f10504b = null;
            bd.a();
        }
        synchronized (bmVar) {
            Iterator<Object> it2 = bmVar.f10505c.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
