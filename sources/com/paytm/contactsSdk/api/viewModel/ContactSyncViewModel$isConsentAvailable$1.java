package com.paytm.contactsSdk.api.viewModel;

import com.paytm.contactsSdk.api.ContactsConsent;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactSyncViewModel.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.viewModel.ContactSyncViewModel$isConsentAvailable$1")
final class ContactSyncViewModel$isConsentAvailable$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ContactSyncViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactSyncViewModel$isConsentAvailable$1(ContactSyncViewModel contactSyncViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = contactSyncViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactSyncViewModel$isConsentAvailable$1 contactSyncViewModel$isConsentAvailable$1 = new ContactSyncViewModel$isConsentAvailable$1(this.this$0, dVar);
        contactSyncViewModel$isConsentAvailable$1.p$ = (CoroutineScope) obj;
        return contactSyncViewModel$isConsentAvailable$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactSyncViewModel$isConsentAvailable$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            this.this$0.getLocalConsent().postValue(Boolean.valueOf(ContactsConsent.INSTANCE.checkLocalConsent()));
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
