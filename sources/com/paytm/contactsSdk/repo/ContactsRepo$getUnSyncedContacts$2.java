package com.paytm.contactsSdk.repo;

import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsRepo.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.repo.ContactsRepo$getUnSyncedContacts$2")
final class ContactsRepo$getUnSyncedContacts$2 extends k implements m<CoroutineScope, d<? super HashMap<String, List<? extends ContactWithPhones>>>, Object> {
    int label;
    private CoroutineScope p$;

    ContactsRepo$getUnSyncedContacts$2(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsRepo$getUnSyncedContacts$2 contactsRepo$getUnSyncedContacts$2 = new ContactsRepo$getUnSyncedContacts$2(dVar);
        contactsRepo$getUnSyncedContacts$2.p$ = (CoroutineScope) obj;
        return contactsRepo$getUnSyncedContacts$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsRepo$getUnSyncedContacts$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            HashMap hashMap = new HashMap();
            List<ContactWithPhones> contacts = DatabaseManager.INSTANCE.getDatabase().contactsDao().getContacts(LocalContactSyncType.SYNC_ADD_UPDATE.ordinal());
            List<ContactWithPhones> contacts2 = DatabaseManager.INSTANCE.getDatabase().contactsDao().getContacts(LocalContactSyncType.SYNC_ADD_UPDATE.ordinal());
            List<ContactWithPhones> contacts3 = DatabaseManager.INSTANCE.getDatabase().contactsDao().getContacts(LocalContactSyncType.SYNC_DELETE.ordinal());
            hashMap.put(SyncContactBean.Status.STATUS_ADDED, contacts);
            hashMap.put(StringSet.updated, contacts2);
            hashMap.put(StringSet.deleted, contacts3);
            return hashMap;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
