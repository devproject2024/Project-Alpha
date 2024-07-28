package net.one97.paytm.wallet.newdesign.fastscan;

import kotlin.g.b.k;
import net.one97.paytm.wallet.communicator.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f70946a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f70947b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f70948c;

    private b() {
    }

    public static void a(boolean z) {
        f70947b = z;
    }

    public static boolean a() {
        return f70947b;
    }

    public static void b(boolean z) {
        f70948c = z;
    }

    public static long b() {
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        c a3 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        long integerFromGTM = (long) a2.getIntegerFromGTM(a3.getContext(), "scan_duration_ms");
        if (integerFromGTM <= 0) {
            return 500;
        }
        return integerFromGTM;
    }

    public static long c() {
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        c a3 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        long integerFromGTM = (long) a2.getIntegerFromGTM(a3.getContext(), "gallery_qr_waiting_time");
        if (integerFromGTM <= 0) {
            return 2000;
        }
        return integerFromGTM;
    }
}
