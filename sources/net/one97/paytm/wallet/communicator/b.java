package net.one97.paytm.wallet.communicator;

import com.paytm.utility.q;
import net.one97.paytm.wallet.d.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static c f70161a;

    /* renamed from: b  reason: collision with root package name */
    private static a f70162b;

    /* renamed from: c  reason: collision with root package name */
    private static a f70163c;

    public static c a() {
        if (f70161a == null) {
            synchronized (b.class) {
                if (f70161a == null) {
                    e();
                }
            }
        }
        return f70161a;
    }

    private static void e() {
        if (f70161a == null) {
            try {
                f70161a = (c) Class.forName("net.one97.paytm.wallet.communicator.WalletCommunicator").newInstance();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            } catch (Throwable th) {
                q.d(String.valueOf(th));
            }
        }
    }

    public static a b() {
        if (f70162b == null) {
            synchronized (b.class) {
                if (f70162b == null) {
                    f();
                }
            }
        }
        return f70162b;
    }

    private static void f() {
        if (f70162b == null) {
            try {
                f70162b = (a) Class.forName("net.one97.paytm.addmoney.AddMoneyCommunicator").newInstance();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public static a c() {
        if (f70163c == null) {
            synchronized (b.class) {
                if (f70163c == null) {
                    g();
                }
            }
        }
        return f70163c;
    }

    private static void g() {
        if (f70163c == null) {
            try {
                f70163c = (a) Class.forName("net.one97.paytm.wallet.communicator.VisaSingleClickCommunicator").newInstance();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public static void d() {
        f();
        e();
        g();
    }
}
