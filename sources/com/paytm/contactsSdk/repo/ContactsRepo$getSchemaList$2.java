package com.paytm.contactsSdk.repo;

import android.content.Context;
import com.paytm.contactsSdk.models.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "ContactsRepo.kt", c = {}, d = "invokeSuspend", e = "com.paytm.contactsSdk.repo.ContactsRepo$getSchemaList$2")
final class ContactsRepo$getSchemaList$2 extends k implements m<CoroutineScope, d<? super ArrayList<Schema>>, Object> {
    final /* synthetic */ Context $context;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ContactsRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactsRepo$getSchemaList$2(ContactsRepo contactsRepo, Context context, d dVar) {
        super(2, dVar);
        this.this$0 = contactsRepo;
        this.$context = context;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        ContactsRepo$getSchemaList$2 contactsRepo$getSchemaList$2 = new ContactsRepo$getSchemaList$2(this.this$0, this.$context, dVar);
        contactsRepo$getSchemaList$2.p$ = (CoroutineScope) obj;
        return contactsRepo$getSchemaList$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContactsRepo$getSchemaList$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            Integer[] numArr = {1838, 1739, 1341};
            HashMap access$getSchemaMap = this.this$0.getSchemaMap(this.$context);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : access$getSchemaMap.entrySet()) {
                Object key = entry.getKey();
                kotlin.g.b.k.a(key, "entry.key");
                Object value = entry.getValue();
                kotlin.g.b.k.a(value, "entry.value");
                arrayList.add(new Schema((String) key, (List) value));
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
