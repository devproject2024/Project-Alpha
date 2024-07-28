package com.paytm.contactsSdk.api;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$forceSync$1")
final class ContactsProvider$forceSync$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;

    ContactsProvider$forceSync$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$forceSync$1 contactsProvider$forceSync$1 = new ContactsProvider$forceSync$1(dVar);
        contactsProvider$forceSync$1.p$ = (CoroutineScope) obj;
        return contactsProvider$forceSync$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$forceSync$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            ContactsProvider.INSTANCE.syncContacts$contacts_sdk_release();
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
