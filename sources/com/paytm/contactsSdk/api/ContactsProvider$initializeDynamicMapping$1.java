package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.models.DynamicMapping;
import com.paytm.contactsSdk.models.MappingInfo;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$initializeDynamicMapping$1")
final class ContactsProvider$initializeDynamicMapping$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;

    ContactsProvider$initializeDynamicMapping$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$initializeDynamicMapping$1 contactsProvider$initializeDynamicMapping$1 = new ContactsProvider$initializeDynamicMapping$1(dVar);
        contactsProvider$initializeDynamicMapping$1.p$ = (CoroutineScope) obj;
        return contactsProvider$initializeDynamicMapping$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$initializeDynamicMapping$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            DatabaseManager.INSTANCE.initDatabase(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getApplicationContext());
            for (DynamicMapping next : ContactsProvider.INSTANCE.getEnrichmentRepo().getDynamicMapping()) {
                ContactsProvider.INSTANCE.getDynamicMapping().put(next.getFeature(), new MappingInfo(next.getColumnNumber(), next.getBitCode()));
            }
            coroutineScope.getClass().getName();
            StringBuilder sb = new StringBuilder("map=");
            sb.append(ContactsProvider.INSTANCE.getDynamicMapping());
            sb.append(" | map.size=");
            sb.append(ContactsProvider.INSTANCE.getDynamicMapping().size());
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
