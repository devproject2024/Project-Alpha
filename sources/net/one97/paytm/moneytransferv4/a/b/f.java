package net.one97.paytm.moneytransferv4.a.b;

import java.util.ArrayList;
import kotlin.d.d;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f54828a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final a f54829b;

    /* renamed from: c  reason: collision with root package name */
    private final a f54830c;

    public f(a aVar, a aVar2) {
        k.c(aVar, "beneficiaryLocalDataSource");
        k.c(aVar2, "beneficiaryRemoteDataSource");
        this.f54829b = aVar;
        this.f54830c = aVar2;
    }

    public final Object a(d<? super ArrayList<ContactsResponse>> dVar) {
        return this.f54830c.a(dVar);
    }
}
