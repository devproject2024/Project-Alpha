package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.p002enum.ContactsErrorType;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$startReadingContactAndPublishing$1")
final class ContactsProvider$startReadingContactAndPublishing$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ ContactsQueryCallback $contactsQueryCallback;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactsProvider$startReadingContactAndPublishing$1(ContactsQueryCallback contactsQueryCallback, d dVar) {
        super(2, dVar);
        this.$contactsQueryCallback = contactsQueryCallback;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$startReadingContactAndPublishing$1 contactsProvider$startReadingContactAndPublishing$1 = new ContactsProvider$startReadingContactAndPublishing$1(this.$contactsQueryCallback, dVar);
        contactsProvider$startReadingContactAndPublishing$1.p$ = (CoroutineScope) obj;
        return contactsProvider$startReadingContactAndPublishing$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$startReadingContactAndPublishing$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            ContactsProvider.INSTANCE.sendCallback(ContactsProvider.INSTANCE.getContactsRepo().getAllContactsList(), false, ContactsErrorType.NO_ERROR, this.$contactsQueryCallback);
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
