package net.one97.paytm.contacts.sync;

import android.content.Context;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.z;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.contacts.db.ContactDatabase;
import net.one97.paytm.contacts.entities.beans.PhoneInfo;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;
import net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo;
import net.one97.paytm.contacts.utils.ContactDetailReqt;
import net.one97.paytm.contacts.utils.ContactReqtInfo;
import net.one97.paytm.contacts.utils.ContactUpload;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.x;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    x.e f50204a;

    /* renamed from: b  reason: collision with root package name */
    Context f50205b;

    /* renamed from: c  reason: collision with root package name */
    int f50206c;

    /* renamed from: d  reason: collision with root package name */
    int f50207d;

    /* renamed from: e  reason: collision with root package name */
    LinkedHashSet<PayeeInfoDetails> f50208e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    int f50209f;

    /* renamed from: g  reason: collision with root package name */
    public final CoroutineExceptionHandler f50210g;

    /* renamed from: h  reason: collision with root package name */
    private final int f50211h = 30;

    public h(Context context, x.e eVar, int i2, int i3) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50204a = eVar;
        this.f50205b = context;
        this.f50207d = i2;
        this.f50209f = i3;
        this.f50210g = new a(CoroutineExceptionHandler.Key);
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(f fVar, Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    public final void a(e.h hVar, Context context) {
        k.c(hVar, "sycing");
        k.c(context, "context");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (f) null, (CoroutineStart) null, new c(this, hVar, context, (kotlin.d.d) null), 3, (Object) null);
    }

    public static final /* synthetic */ void a(h hVar) {
        if (hVar.f50206c != 0) {
            Context context = hVar.f50205b;
            e eVar = e.f50261a;
            k.c(context, "context");
            ContactUpload contactUpload = new ContactUpload();
            contactUpload.setContactType(e.b.PHONEBOOK.name());
            contactUpload.setDeviceId(UpiUtils.getDeviceId(context));
            int i2 = hVar.f50211h;
            LinkedHashSet<PayeeInfoDetails> linkedHashSet = hVar.f50208e;
            if (linkedHashSet == null) {
                k.a();
            }
            if (linkedHashSet.size() < 30) {
                LinkedHashSet<PayeeInfoDetails> linkedHashSet2 = hVar.f50208e;
                if (linkedHashSet2 == null) {
                    k.a();
                }
                i2 = linkedHashSet2.size();
            }
            List<PayeeInfoDetails> subList = new ArrayList(hVar.f50208e).subList(0, i2);
            k.a((Object) subList, "ArrayList(payeesList).subList(0, lastIndex)");
            hVar.f50208e.removeAll(subList);
            HashSet hashSet = new HashSet();
            for (PayeeInfoDetails payeeInfoDetails : subList) {
                List<PayeeMetaInfo> a2 = ContactDatabase.f50139a.a(context).a().a(payeeInfoDetails.getPayeeInfoId());
                if (!a2.isEmpty()) {
                    HashSet hashSet2 = new HashSet();
                    HashSet hashSet3 = new HashSet();
                    for (PayeeMetaInfo phoneNumber : a2) {
                        String phoneNumber2 = phoneNumber.getPhoneNumber();
                        if (phoneNumber2 == null) {
                            k.a();
                        }
                        hashSet2.add(phoneNumber2);
                    }
                    ContactDetailReqt contactDetailReqt = new ContactDetailReqt();
                    contactDetailReqt.setContactId(payeeInfoDetails.getPayeeInfoId());
                    contactDetailReqt.setName(a2.get(0).getName());
                    hashSet.add(payeeInfoDetails.getPayeeInfoId());
                    ContactReqtInfo contactReqtInfo = new ContactReqtInfo();
                    PhoneInfo phoneInfo = new PhoneInfo();
                    ArrayList arrayList = new ArrayList();
                    Iterable iterable = hashSet2;
                    for (z zVar : kotlin.a.k.g(iterable)) {
                        if (zVar.f47893a == 0) {
                            phoneInfo.setPrimaryMobile((String) kotlin.a.k.a(iterable, 0));
                        } else {
                            arrayList.add(zVar.f47894b);
                        }
                    }
                    phoneInfo.setSecondaryMobile(arrayList);
                    contactReqtInfo.getEmail().addAll(hashSet3);
                    contactReqtInfo.setPhoneInfo(phoneInfo);
                    contactDetailReqt.setContactInfo(contactReqtInfo);
                    contactUpload.getContacts().add(contactDetailReqt);
                }
            }
            o oVar = new o(contactUpload, hashSet);
            Collection collection = (HashSet) oVar.getSecond();
            boolean z = true;
            if (!(collection == null || collection.isEmpty())) {
                Context context2 = hVar.f50205b;
                ContactUpload contactUpload2 = (ContactUpload) oVar.getFirst();
                HashSet hashSet4 = (HashSet) oVar.getSecond();
                if (!com.paytm.utility.b.r(hVar.f50205b) || !com.paytm.utility.b.c(context2)) {
                    hVar.f50204a.b(e.h.ABORT, context2, hVar.f50209f);
                    return;
                }
                Collection collection2 = hashSet4;
                if (collection2 != null && !collection2.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (f) null, (CoroutineStart) null, new d(hVar, context2, contactUpload2, hashSet4, (kotlin.d.d) null), 3, (Object) null);
                    return;
                } else {
                    hVar.a(e.h.CONTACT_UPLOAD_CALL_DONE, context2);
                    return;
                }
            }
        }
        hVar.a(e.h.CONTACT_UPLOAD_CALL_DONE, hVar.f50205b);
    }

    @kotlin.d.b.a.f(b = "ContactsUploadReqt.kt", c = {29}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactsUploadReqt$handle$1")
    public static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                Collection c2 = ContactDatabase.f50139a.a(this.this$0.f50205b).f().c(this.this$0.f50207d);
                if (c2.isEmpty()) {
                    this.this$0.a(e.h.CONTACT_UPLOAD_CALL_DONE, this.this$0.f50205b);
                    return kotlin.x.f47997a;
                }
                this.this$0.f50208e = new LinkedHashSet<>(c2);
                this.this$0.f50206c = ContactDatabase.f50139a.a(this.this$0.f50205b).f().b((List<Integer>) kotlin.a.k.d(Integer.valueOf(this.this$0.f50207d)));
                h.a(this.this$0);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "ContactsUploadReqt.kt", c = {141}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactsUploadReqt$onCompleteCall$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ e.h $sycing;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar, e.h hVar2, Context context, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
            this.$sycing = hVar2;
            this.$context = context;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$sycing, this.$context, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f50204a.b(this.$sycing, this.$context, this.this$0.f50209f);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "ContactsUploadReqt.kt", c = {66}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactsUploadReqt$uploadHandler$1")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ ContactUpload $contactUpload;
        final /* synthetic */ Context $context;
        final /* synthetic */ HashSet $ids;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar, Context context, ContactUpload contactUpload, HashSet hashSet, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
            this.$context = context;
            this.$contactUpload = contactUpload;
            this.$ids = hashSet;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, this.$context, this.$contactUpload, this.$ids, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                a aVar2 = a.f50159a;
                LiveData<net.one97.paytm.network.f> a2 = a.a(this.$context, this.$contactUpload);
                if (a2 != null) {
                    a2.observeForever(new androidx.lifecycle.z<net.one97.paytm.network.f>(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ d f50212a;

                        {
                            this.f50212a = r1;
                        }

                        public final /* synthetic */ void onChanged(Object obj) {
                            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
                            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.f50212a.this$0.f50210g)), (f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                    int label;
                                    private CoroutineScope p$;
                                    final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        this.this$0 = r1;
                                    }

                                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                        k.c(dVar, "completion");
                                        AnonymousClass1 r0 = 
                                    }
