package net.one97.paytm.chat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.e;
import com.paytm.android.chat.e.b;
import net.one97.paytm.j.c;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public final class a implements b {

    /* renamed from: d  reason: collision with root package name */
    private static a f49574d;

    /* renamed from: a  reason: collision with root package name */
    private final String f49575a = "sendbird_contacts_sync_buffer";

    /* renamed from: b  reason: collision with root package name */
    private final String f49576b = "new_tag_time_window";

    /* renamed from: c  reason: collision with root package name */
    private final long f49577c = FileCache.EXPIRE_TIME;

    public final String a() {
        return "release";
    }

    private a() {
    }

    public static void d() {
        if (f49574d == null) {
            f49574d = new a();
        }
        e.a(f49574d);
    }

    public final void a(Activity activity, String str, boolean z, boolean z2) {
        ChatManager.b().c();
        ChatManager.b();
        ChatManager.e();
        r.a(activity, str, (Bundle) null, z, z2);
    }

    public final String a(Context context) {
        return t.b(context);
    }

    public final String a(String str, String str2) {
        c.a();
        return c.a(str, str2);
    }

    public final long b() {
        c.a();
        return c.a("sendbird_contacts_sync_buffer", (long) FileCache.EXPIRE_TIME);
    }

    public final long c() {
        c.a();
        return c.a("new_tag_time_window", (long) FileCache.EXPIRE_TIME);
    }
}
