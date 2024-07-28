package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.c;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, c> f37950a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f37951b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.analytics.connector.a f37952c;

    protected a(Context context, com.google.firebase.analytics.connector.a aVar) {
        this.f37951b = context;
        this.f37952c = aVar;
    }

    public final synchronized c a(String str) {
        if (!this.f37950a.containsKey(str)) {
            this.f37950a.put(str, new c(this.f37952c, str));
        }
        return this.f37950a.get(str);
    }
}
