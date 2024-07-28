package net.one97.paytm.n;

import android.content.Context;
import com.paytm.utility.j;
import kotlin.g.b.k;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f55762a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final String f55763b = f55763b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f55764c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f55765d = f55765d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f55766e = f55766e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f55767f = b.a().getIntegerFromGTM(f55764c, "deviceBindingVersionCode");

    static {
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        f55764c = a2.getContext();
    }

    private e() {
    }

    public static String a() {
        return f55763b;
    }

    public static String b() {
        return f55765d;
    }

    public static String c() {
        j jVar = j.f43829a;
        Context context = f55764c;
        k.a((Object) context, "mContext");
        return k.a(j.b(context), (Object) "");
    }

    public static boolean a(String str) {
        k.c(str, "key");
        return b.a().getBooleanFromGTM(f55764c, str, true);
    }

    public static boolean d() {
        return WalletSharedPrefs.getBoolean(f55766e, false);
    }

    public static void e() {
        WalletSharedPrefs.setBoolean(f55766e, true);
    }

    public static boolean f() {
        int kYCExpriy = b.a().getKYCExpriy(f55764c);
        if (b.a().getKYCUserStatus(f55764c) == 1 && kYCExpriy == 0) {
            return true;
        }
        if (b.a().getKYCUserStatus(f55764c) != 1 || kYCExpriy - ((int) System.currentTimeMillis()) <= 0) {
            return false;
        }
        return true;
    }

    public static void g() {
        WalletSharedPrefs.setBoolean(f55766e, false);
    }

    public static boolean h() {
        return k.a((Object) WalletSharedPrefs.INSTANCE.getOauthLoginMethod(), (Object) "device_binding");
    }

    public static boolean i() {
        return b.a().getBooleanFromGTM(f55764c, f55763b, true);
    }
}
