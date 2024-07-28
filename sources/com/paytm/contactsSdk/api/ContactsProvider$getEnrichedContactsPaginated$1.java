package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.EnrichedContactsCallback;
import com.paytm.contactsSdk.api.query.EnrichmentQuery;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$getEnrichedContactsPaginated$1")
final class ContactsProvider$getEnrichedContactsPaginated$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ EnrichedContactsCallback $callback;
    final /* synthetic */ EnrichmentQuery $enrichmentQuery;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactsProvider$getEnrichedContactsPaginated$1(EnrichmentQuery enrichmentQuery, EnrichedContactsCallback enrichedContactsCallback, d dVar) {
        super(2, dVar);
        this.$enrichmentQuery = enrichmentQuery;
        this.$callback = enrichedContactsCallback;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$getEnrichedContactsPaginated$1 contactsProvider$getEnrichedContactsPaginated$1 = new ContactsProvider$getEnrichedContactsPaginated$1(this.$enrichmentQuery, this.$callback, dVar);
        contactsProvider$getEnrichedContactsPaginated$1.p$ = (CoroutineScope) obj;
        return contactsProvider$getEnrichedContactsPaginated$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$getEnrichedContactsPaginated$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            this.$callback.onEnrichedContactsReady(ContactsProvider.INSTANCE.getEnrichmentRepo().getEnrichedContactsPaginated(this.$enrichmentQuery));
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
