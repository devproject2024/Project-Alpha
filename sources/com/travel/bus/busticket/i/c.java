package com.travel.bus.busticket.i;

import android.content.Context;
import android.content.Intent;
import com.travel.bus.b.a;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22421a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void a(Context context) {
        k.c(context, "context");
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        k.a((Object) com.travel.bus.a.a(), "BusController.getInstance()");
        com.travel.bus.a.b().a(context, intent, 1);
    }

    public static final boolean b(Context context) {
        k.c(context, "context");
        a.C0430a aVar = com.travel.bus.b.a.f21520a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        if (a.C0430a.a(applicationContext).b("sso_token=", "", true).length() > 0) {
            return true;
        }
        return false;
    }
}
