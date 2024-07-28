package com.google.android.gms.internal.icing;

import android.content.SharedPreferences;
import java.util.Iterator;

final /* synthetic */ class aa implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ab f10048a;

    aa(ab abVar) {
        this.f10048a = abVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        ab abVar = this.f10048a;
        synchronized (abVar.f10050b) {
            abVar.f10051c = null;
            x.a();
        }
        synchronized (abVar) {
            Iterator<Object> it2 = abVar.f10052d.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
