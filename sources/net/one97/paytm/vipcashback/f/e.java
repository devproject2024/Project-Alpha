package net.one97.paytm.vipcashback.f;

import com.paytm.utility.q;
import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f20889a = new e();

    private e() {
    }

    public static void a() {
        try {
            Class.forName("net.one97.paytm.dynamic.module.cashback.CashbackJarvisHelper").getMethod("init", (Class[]) Arrays.copyOf(new Class[0], 0)).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            q.b("Exception occur while initializing data provider");
        }
    }
}
