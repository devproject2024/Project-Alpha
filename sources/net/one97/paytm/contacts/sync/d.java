package net.one97.paytm.contacts.sync;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.contacts.entities.beans.Contacts;
import net.one97.paytm.contacts.utils.c;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.utils.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    int f50187a;

    /* renamed from: b  reason: collision with root package name */
    private Context f50188b;

    /* renamed from: c  reason: collision with root package name */
    private x.e f50189c;

    /* renamed from: d  reason: collision with root package name */
    private int f50190d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f50191e;

    public d(Context context, x.e eVar, int i2, boolean z, int i3) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50188b = context;
        this.f50189c = eVar;
        this.f50190d = i2;
        this.f50191e = z;
        this.f50187a = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r8 = this;
            android.content.Context r0 = r8.f50188b
            java.lang.String r1 = "context"
            kotlin.g.b.k.c(r0, r1)
            int r1 = r8.f50187a
            net.one97.paytm.contacts.utils.e$b r2 = net.one97.paytm.contacts.utils.e.b.TRANSFER_BENEFICIARY
            int r2 = r2.getType()
            if (r1 != r2) goto L_0x001c
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "benfHealthSyncTimeHR_V2"
            int r1 = r1.getIntegerFromGTM((android.content.Context) r0, (java.lang.String) r2)
            goto L_0x0026
        L_0x001c:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "contactHealthSyncTimeHR_V2"
            int r1 = r1.getIntegerFromGTM((android.content.Context) r0, (java.lang.String) r2)
        L_0x0026:
            int r1 = r1 * 60
            int r1 = r1 * 60
            int r1 = r1 * 1000
            net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs r2 = net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs.INSTANCE
            long r2 = r2.getHealthSyncTime(r0)
            r4 = 0
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x0047
            net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs r1 = net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs.INSTANCE
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.setHealthSyncTime(r0, r2)
            goto L_0x004f
        L_0x0047:
            long r0 = (long) r1
            long r0 = r0 + r2
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 == 0) goto L_0x0080
            android.content.Context r0 = r8.f50188b
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r1 != 0) goto L_0x0071
            boolean r1 = r8.f50191e
            if (r1 == 0) goto L_0x0068
            net.one97.paytm.utils.x$e r1 = r8.f50189c
            net.one97.paytm.contacts.utils.e$h r2 = net.one97.paytm.contacts.utils.e.h.ABORT
            int r3 = r8.f50190d
            r1.a(r2, r0, r3, r6)
            goto L_0x0071
        L_0x0068:
            net.one97.paytm.utils.x$e r1 = r8.f50189c
            net.one97.paytm.contacts.utils.e$h r2 = net.one97.paytm.contacts.utils.e.h.ABORT
            int r3 = r8.f50190d
            r1.b(r2, r0, r3)
        L_0x0071:
            net.one97.paytm.contacts.utils.a r1 = net.one97.paytm.contacts.utils.a.f50219b
            net.one97.paytm.contacts.sync.d$a r1 = new net.one97.paytm.contacts.sync.d$a
            r1.<init>(r8, r0)
            net.one97.paytm.utils.x$c r1 = (net.one97.paytm.utils.x.c) r1
            int r2 = r8.f50187a
            net.one97.paytm.contacts.utils.a.a((android.content.Context) r0, (net.one97.paytm.utils.x.c) r1, (int) r2)
            return
        L_0x0080:
            r8.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.sync.d.a():void");
    }

    public static final class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f50192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f50193b;

        /* renamed from: net.one97.paytm.contacts.sync.d$a$a  reason: collision with other inner class name */
        static final class C0902a<T> implements z<f> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f50194a;

            C0902a(a aVar) {
                this.f50194a = aVar;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                final f fVar = (f) obj;
                if (fVar.f55796a == h.SUCCESS) {
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    c cVar = c.f50249c;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(io2.plus(c.c())), (kotlin.d.f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                        int label;
                        private CoroutineScope p$;
                        final /* synthetic */ C0902a this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                            k.c(dVar, "completion");
                            AnonymousClass1 r0 = 

                            a(d dVar, Context context) {
                                this.f50192a = dVar;
                                this.f50193b = context;
                            }

                            public final void a(ArrayList<Contacts> arrayList) {
                                k.c(arrayList, Tables.CONTACTS);
                                if (arrayList.isEmpty()) {
                                    this.f50192a.b();
                                    return;
                                }
                                a aVar = a.f50159a;
                                LiveData<f> a2 = a.a(this.f50193b, arrayList, this.f50192a.f50187a);
                                if (a2 != null) {
                                    a2.observeForever(new C0902a(this));
                                }
                            }
                        }

                        public final void b() {
                            if (this.f50187a == e.b.TRANSFER_BENEFICIARY.getType()) {
                                if (this.f50191e) {
                                    this.f50189c.a(e.h.BENEFICIARY_HEALTH_DONE, this.f50188b, this.f50190d, false);
                                } else {
                                    this.f50189c.b(e.h.BENEFICIARY_HEALTH_DONE, this.f50188b, this.f50190d);
                                }
                            } else if (this.f50191e) {
                                this.f50189c.a(e.h.NONE, this.f50188b, this.f50190d, false);
                            } else {
                                this.f50189c.b(e.h.NONE, this.f50188b, this.f50190d);
                            }
                        }
                    }
