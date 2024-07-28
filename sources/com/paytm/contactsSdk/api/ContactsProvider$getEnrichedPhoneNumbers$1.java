package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.EnrichedPhoneNumbersCallback;
import com.paytm.contactsSdk.api.query.EnrichmentQuery;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$getEnrichedPhoneNumbers$1")
final class ContactsProvider$getEnrichedPhoneNumbers$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ EnrichedPhoneNumbersCallback $callback;
    final /* synthetic */ EnrichmentQuery $enrichmentQuery;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactsProvider$getEnrichedPhoneNumbers$1(EnrichmentQuery enrichmentQuery, EnrichedPhoneNumbersCallback enrichedPhoneNumbersCallback, d dVar) {
        super(2, dVar);
        this.$enrichmentQuery = enrichmentQuery;
        this.$callback = enrichedPhoneNumbersCallback;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$getEnrichedPhoneNumbers$1 contactsProvider$getEnrichedPhoneNumbers$1 = new ContactsProvider$getEnrichedPhoneNumbers$1(this.$enrichmentQuery, this.$callback, dVar);
        contactsProvider$getEnrichedPhoneNumbers$1.p$ = (CoroutineScope) obj;
        return contactsProvider$getEnrichedPhoneNumbers$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$getEnrichedPhoneNumbers$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            this.$callback.onEnrichedPhoneNumbersReady(ContactsProvider.INSTANCE.getEnrichmentRepo().getEnrichmentData(this.$enrichmentQuery));
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
