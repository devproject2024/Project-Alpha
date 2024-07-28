package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.youtube.player.internal.g;
import com.google.android.youtube.player.internal.v;
import com.google.android.youtube.player.internal.y;

public final class d extends b {
    public final e a(Context context, String str, v.a aVar, v.b bVar) {
        return new r(context, str, context.getPackageName(), aa.d(context), aVar, bVar);
    }

    public final g a(Activity activity, e eVar, boolean z) throws y.a {
        IBinder a2 = eVar.a();
        c.a(activity);
        c.a(a2);
        Context b2 = aa.b((Context) activity);
        if (b2 != null) {
            return g.a.a(y.a(b2.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", x.a(b2).asBinder(), x.a(activity).asBinder(), a2, z));
        }
        throw new y.a("Could not create remote context");
    }
}
