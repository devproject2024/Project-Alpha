package net.one97.paytm.cashback.posttxn;

import com.paytm.utility.q;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f49535a = "net.one97.paytm.vipcashback.fragment.PostTxnHelperFragment";

    /* renamed from: b  reason: collision with root package name */
    private static String f49536b = "net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2";

    public static e a() {
        try {
            return (e) Class.forName(f49535a).newInstance();
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
        } catch (InstantiationException e3) {
            q.b(e3.getMessage());
        } catch (IllegalAccessException e4) {
            q.b(e4.getMessage());
        }
        return null;
    }
}
