package net.one97.paytm.wallet.newdesign.fastscan.a;

import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.wallet.a.d;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class a implements z<d> {

    /* renamed from: a  reason: collision with root package name */
    public static y<d> f70917a;

    /* renamed from: b  reason: collision with root package name */
    public static final y<d> f70918b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a f70919c = new a();

    private a() {
    }

    public final /* synthetic */ void onChanged(Object obj) {
        d dVar = (d) obj;
        if (dVar == null) {
            return;
        }
        if (dVar instanceof d.e) {
            f70918b.postValue((d.e) dVar);
        } else if (dVar instanceof d.h) {
            f70918b.postValue((d.h) dVar);
        } else if (dVar instanceof d.j) {
            f70918b.postValue((d.j) dVar);
        } else if (dVar instanceof d.g) {
            f70918b.postValue((d.g) dVar);
        } else if (dVar instanceof d.i) {
            f70918b.postValue((d.i) dVar);
        } else {
            f70918b.postValue(dVar);
        }
    }

    public static y<d> a() {
        return f70918b;
    }

    public final void a(String str, boolean z) {
        k.c(str, "qrData");
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        y<d> a3 = new net.one97.paytm.wallet.a.b(a2.getContext(), b.a()).a(str, z);
        f70917a = a3;
        if (a3 != null) {
            a3.observeForever(this);
        }
    }
}
