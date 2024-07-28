package com.google.firebase.components;

import com.google.firebase.a.a;
import com.google.firebase.a.b;
import java.util.Map;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Map.Entry f38121a;

    /* renamed from: b  reason: collision with root package name */
    private final a f38122b;

    private s(Map.Entry entry, a aVar) {
        this.f38121a = entry;
        this.f38122b = aVar;
    }

    public static Runnable a(Map.Entry entry, a aVar) {
        return new s(entry, aVar);
    }

    public final void run() {
        ((b) this.f38121a.getKey()).a(this.f38122b);
    }
}
