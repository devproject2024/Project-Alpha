package com.google.firebase.messaging;

import android.content.SharedPreferences;
import java.util.Iterator;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final q f39027a;

    s(q qVar) {
        this.f39027a = qVar;
    }

    public final void run() {
        q qVar = this.f39027a;
        synchronized (qVar.f39024d) {
            SharedPreferences.Editor edit = qVar.f39021a.edit();
            String str = qVar.f39022b;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it2 = qVar.f39024d.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
                sb.append(qVar.f39023c);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }
}
