package net.one97.paytm.contacts.sync;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
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
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    x.e f50178a;

    /* renamed from: b  reason: collision with root package name */
    Context f50179b;

    /* renamed from: c  reason: collision with root package name */
    int f50180c;

    /* renamed from: d  reason: collision with root package name */
    LinkedHashSet<PayeeInfoDetails> f50181d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    int f50182e;

    /* renamed from: f  reason: collision with root package name */
    final CoroutineExceptionHandler f50183f;

    /* renamed from: g  reason: collision with root package name */
    private int f50184g;

    /* renamed from: h  reason: collision with root package name */
    private final int f50185h = 20;

    public c(Context context, x.e eVar, int i2, int i3) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50178a = eVar;
        this.f50179b = context;
        this.f50184g = i2;
        this.f50182e = i3;
        this.f50183f = new a(CoroutineExceptionHandler.Key);
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

    public final void a() {
        if (this.f50180c == 0) {
            a(e.h.CONTACT_DELETE_CALL_DONE, this.f50179b);
            return;
        }
        Context context = this.f50179b;
        k.c(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
        jSONObject.put("contactType", e.b.PHONEBOOK);
        JSONArray jSONArray = new JSONArray();
        int i2 = this.f50185h;
        LinkedHashSet<PayeeInfoDetails> linkedHashSet = this.f50181d;
        if (linkedHashSet == null) {
            k.a();
        }
        if (linkedHashSet.size() < 20) {
            LinkedHashSet<PayeeInfoDetails> linkedHashSet2 = this.f50181d;
            if (linkedHashSet2 == null) {
                k.a();
            }
            i2 = linkedHashSet2.size();
        }
        List<PayeeInfoDetails> subList = new ArrayList(this.f50181d).subList(0, i2);
        k.a((Object) subList, "ArrayList(payeesList).subList(0, lastIndex)");
        this.f50181d.removeAll(subList);
        if (subList != null) {
            for (PayeeInfoDetails payeeInfoId : subList) {
                jSONArray.put(payeeInfoId.getPayeeInfoId());
            }
        }
        if (jSONArray.length() > 0) {
            jSONObject.put("contactId", jSONArray);
        }
        String[] strArr = new String[jSONArray.length()];
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = jSONArray.getString(i3);
        }
        o oVar = new o(jSONObject.toString(), strArr);
        String[] strArr2 = (String[]) oVar.getSecond();
        boolean z = true;
        if (strArr2 != null) {
            if (!(strArr2.length == 0)) {
                z = false;
            }
        }
        if (!z) {
            Context context2 = this.f50179b;
            String str = (String) oVar.getFirst();
            oVar.getSecond();
            if (!com.paytm.utility.b.r(this.f50179b) || !com.paytm.utility.b.c(context2)) {
                this.f50178a.b(e.h.ABORT, context2, this.f50182e);
            } else {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (f) null, (CoroutineStart) null, new b(this, context2, str, (kotlin.d.d) null), 3, (Object) null);
            }
        } else {
            a(e.h.CONTACT_DELETE_CALL_DONE, this.f50179b);
        }
    }

    public final void a(e.h hVar, Context context) {
        k.c(hVar, "sycing");
        k.c(context, "context");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (f) null, (CoroutineStart) null, new d(this, hVar, context, (kotlin.d.d) null), 3, (Object) null);
    }

    @kotlin.d.b.a.f(b = "ContactDeleteReqt.kt", c = {112}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactDeleteReqt$deleteUploadHandler$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $string;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, Context context, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$context = context;
            this.$string = str;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$context, this.$string, dVar);
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
                a aVar2 = a.f50159a;
                LiveData<net.one97.paytm.network.f> a2 = a.a(this.$context, this.$string);
                if (a2 != null) {
                    a2.observeForever(new z<net.one97.paytm.network.f>(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f50186a;

                        {
                            this.f50186a = r1;
                        }

                        public final /* synthetic */ void onChanged(Object obj) {
                            final net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
                            if (fVar.f55796a == h.SUCCESS) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.f50186a.this$0.f50183f)), (f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                    int label;
                                    private CoroutineScope p$;
                                    final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        this.this$0 = r1;
                                    }

                                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                        k.c(dVar, "completion");
                                        AnonymousClass1 r0 = 

                                        @kotlin.d.b.a.f(b = "ContactDeleteReqt.kt", c = {33}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactDeleteReqt$handle$1")
                                        /* renamed from: net.one97.paytm.contacts.sync.c$c  reason: collision with other inner class name */
                                        public static final class C0901c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                            int label;
                                            private CoroutineScope p$;
                                            final /* synthetic */ c this$0;

                                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                            public C0901c(c cVar, kotlin.d.d dVar) {
                                                super(2, dVar);
                                                this.this$0 = cVar;
                                            }

                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                k.c(dVar, "completion");
                                                C0901c cVar = new C0901c(this.this$0, dVar);
                                                cVar.p$ = (CoroutineScope) obj;
                                                return cVar;
                                            }

                                            public final Object invoke(Object obj, Object obj2) {
                                                return ((C0901c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                                if (this.label != 0) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                } else if (!(obj instanceof p.b)) {
                                                    Collection b2 = ContactDatabase.f50139a.a(this.this$0.f50179b).f().b(e.b.PHONEBOOK.getType());
                                                    if (b2.isEmpty()) {
                                                        this.this$0.a(e.h.CONTACT_DELETE_CALL_DONE, this.this$0.f50179b);
                                                        return kotlin.x.f47997a;
                                                    }
                                                    this.this$0.f50181d = new LinkedHashSet<>(b2);
                                                    this.this$0.f50180c = ContactDatabase.f50139a.a(this.this$0.f50179b).f().c((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.PHONEBOOK.getType())));
                                                    this.this$0.a();
                                                    return kotlin.x.f47997a;
                                                } else {
                                                    throw ((p.b) obj).exception;
                                                }
                                            }
                                        }

                                        @kotlin.d.b.a.f(b = "ContactDeleteReqt.kt", c = {152}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactDeleteReqt$onCompleteCall$1")
                                        static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                            final /* synthetic */ Context $context;
                                            final /* synthetic */ e.h $sycing;
                                            int label;
                                            private CoroutineScope p$;
                                            final /* synthetic */ c this$0;

                                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                            d(c cVar, e.h hVar, Context context, kotlin.d.d dVar) {
                                                super(2, dVar);
                                                this.this$0 = cVar;
                                                this.$sycing = hVar;
                                                this.$context = context;
                                            }

                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                k.c(dVar, "completion");
                                                d dVar2 = new d(this.this$0, this.$sycing, this.$context, dVar);
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
                                                    this.this$0.f50178a.b(this.$sycing, this.$context, this.this$0.f50182e);
                                                    return kotlin.x.f47997a;
                                                } else {
                                                    throw ((p.b) obj).exception;
                                                }
                                            }
                                        }
                                    }
