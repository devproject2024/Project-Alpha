package net.one97.paytm.wallet.e;

import android.content.Context;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f70357a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Context f70358b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, SingleAPIResponseV2> f70359c = new HashMap<>();

    static {
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
        f70358b = context;
    }

    private a() {
    }

    public static HashMap<String, SingleAPIResponseV2> a() {
        return f70359c;
    }
}
