package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.internal.v;
import com.google.android.youtube.player.internal.y;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37563a = b();

    public static b a() {
        return f37563a;
    }

    private static b b() {
        try {
            return (b) Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(b.class).newInstance();
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (ClassNotFoundException unused) {
            return new d();
        }
    }

    public abstract e a(Context context, String str, v.a aVar, v.b bVar);

    public abstract g a(Activity activity, e eVar, boolean z) throws y.a;
}
