package com.paytm.contactsSdk;

import com.paytm.contactsSdk.repo.ContactsRepo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsSdk.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.ContactsSdk$onLogout$1")
final class ContactsSdk$onLogout$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;

    ContactsSdk$onLogout$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsSdk$onLogout$1 contactsSdk$onLogout$1 = new ContactsSdk$onLogout$1(dVar);
        contactsSdk$onLogout$1.p$ = (CoroutineScope) obj;
        return contactsSdk$onLogout$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsSdk$onLogout$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            new ContactsRepo().deleteAllDataFormAllTables();
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
