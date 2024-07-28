package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;
import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import java.lang.ref.WeakReference;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@f(b = "ContactsProvider.kt", c = {144}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$registerContactSyncMetaInfoCallback$1")
final class ContactsProvider$registerContactSyncMetaInfoCallback$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;

    ContactsProvider$registerContactSyncMetaInfoCallback$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsProvider$registerContactSyncMetaInfoCallback$1 contactsProvider$registerContactSyncMetaInfoCallback$1 = new ContactsProvider$registerContactSyncMetaInfoCallback$1(dVar);
        contactsProvider$registerContactSyncMetaInfoCallback$1.p$ = (CoroutineScope) obj;
        return contactsProvider$registerContactSyncMetaInfoCallback$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsProvider$registerContactSyncMetaInfoCallback$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    @f(b = "ContactsProvider.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.api.ContactsProvider$registerContactSyncMetaInfoCallback$1$1")
    /* renamed from: com.paytm.contactsSdk.api.ContactsProvider$registerContactSyncMetaInfoCallback$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback;
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                WeakReference access$getSyncCallback$p = ContactsProvider.syncCallback;
                if (access$getSyncCallback$p == null || (contactsSDKMetaInfoCallback = (ContactsSDKMetaInfoCallback) access$getSyncCallback$p.get()) == null) {
                    return null;
                }
                ContactsSDKMetaInfo access$getContactSDKMetaInfo$p = ContactsProvider.contactSDKMetaInfo;
                if (access$getContactSDKMetaInfo$p == null) {
                    kotlin.g.b.k.a();
                }
                contactsSDKMetaInfoCallback.onMetaInfoAvailable(access$getContactSDKMetaInfo$p);
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            if (ContactsProvider.contactSDKMetaInfo == null) {
                ContactsProvider.contactSDKMetaInfo = new ContactsSDKMetaInfo(ContactsConsent.INSTANCE.checkLocalConsent(), SyncStage.NONE, 0.0d, 0);
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((d) null), this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return x.f47997a;
    }
}
