package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.ups.repository.UpsConsentRepository;

@f(b = "ContactsConsent.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsConsent$getConsentFromLocalDBThenServer$1")
final class ContactsConsent$getConsentFromLocalDBThenServer$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ ContactsQuery $contactsQuery;
    final /* synthetic */ ContactsQueryCallback $contactsQueryCallback;
    final /* synthetic */ q $onConsentResultAvailable;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactsConsent$getConsentFromLocalDBThenServer$1(q qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery, d dVar) {
        super(2, dVar);
        this.$onConsentResultAvailable = qVar;
        this.$contactsQueryCallback = contactsQueryCallback;
        this.$contactsQuery = contactsQuery;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsConsent$getConsentFromLocalDBThenServer$1 contactsConsent$getConsentFromLocalDBThenServer$1 = new ContactsConsent$getConsentFromLocalDBThenServer$1(this.$onConsentResultAvailable, this.$contactsQueryCallback, this.$contactsQuery, dVar);
        contactsConsent$getConsentFromLocalDBThenServer$1.p$ = (CoroutineScope) obj;
        return contactsConsent$getConsentFromLocalDBThenServer$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsConsent$getConsentFromLocalDBThenServer$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            Map<String, Boolean> checkConsentsAvailable = UpsConsentRepository.INSTANCE.checkConsentsAvailable(ContactsConstant.INSTANCE.getGET_CONTACT_CONSENT_KEY_LIST());
            if (!checkConsentsAvailable.isEmpty()) {
                q qVar = this.$onConsentResultAvailable;
                Boolean bool = checkConsentsAvailable.get(ContactsConstant.CONTACTS_CONSENT_KEY);
                if (bool != null) {
                    qVar.invoke(Boolean.valueOf(bool.booleanValue()), this.$contactsQueryCallback, this.$contactsQuery);
                } else {
                    throw new IllegalStateException("".toString());
                }
            } else {
                ContactsConsent.INSTANCE.getConsentFromServer(this.$onConsentResultAvailable, this.$contactsQueryCallback, this.$contactsQuery);
            }
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
