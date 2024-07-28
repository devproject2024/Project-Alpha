package net.one97.paytm.moneytransferv4.a.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.passbook.b.a.a;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    final LiveData<net.one97.paytm.moneytransfer.model.c<List<UpiTransactionModelV2>>> f54806a = this.f54808c;

    /* renamed from: b  reason: collision with root package name */
    final y<String> f54807b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final y<net.one97.paytm.moneytransfer.model.c<List<UpiTransactionModelV2>>> f54808c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f54809d = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f54810e = 20;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f54811f;

    /* renamed from: g  reason: collision with root package name */
    private final a f54812g;

    public c(a aVar) {
        k.c(aVar, "upiPassbookDataSource");
        this.f54812g = aVar;
    }

    public final boolean a() {
        if (this.f54811f == null) {
            c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
            this.f54811f = Boolean.valueOf(net.one97.paytm.moneytransfer.d.c.b(c.a.a().t) != 0);
        }
        Boolean bool = this.f54811f;
        if (bool == null) {
            k.a();
        }
        return bool.booleanValue();
    }
}
