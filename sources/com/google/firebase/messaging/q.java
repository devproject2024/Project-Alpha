package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class q {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f39021a;

    /* renamed from: b  reason: collision with root package name */
    final String f39022b;

    /* renamed from: c  reason: collision with root package name */
    final String f39023c;

    /* renamed from: d  reason: collision with root package name */
    final ArrayDeque<String> f39024d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final Executor f39025e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f39026f = false;

    private q(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f39021a = sharedPreferences;
        this.f39022b = str;
        this.f39023c = str2;
        this.f39025e = executor;
    }

    static q a(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        q qVar = new q(sharedPreferences, str, str2, executor);
        synchronized (qVar.f39024d) {
            qVar.f39024d.clear();
            String string = qVar.f39021a.getString(qVar.f39022b, "");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains(qVar.f39023c)) {
                    for (String str3 : string.split(qVar.f39023c, -1)) {
                        if (!TextUtils.isEmpty(str3)) {
                            qVar.f39024d.add(str3);
                        }
                    }
                }
            }
        }
        return qVar;
    }

    public final boolean a(Object obj) {
        boolean remove;
        synchronized (this.f39024d) {
            remove = this.f39024d.remove(obj);
            if (remove && !this.f39026f) {
                this.f39025e.execute(new s(this));
            }
        }
        return remove;
    }

    public final String a() {
        String peek;
        synchronized (this.f39024d) {
            peek = this.f39024d.peek();
        }
        return peek;
    }
}
