package net.one97.paytm.ups.repository;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.listener.UpdateConsentListener;
import net.one97.paytm.ups.manager.DatabaseManager;

public final class UpsConsentRepository$updateConsent$$inlined$let$lambda$1 implements b {
    final /* synthetic */ String $consentKey$inlined;
    final /* synthetic */ boolean $isConsentOn$inlined;
    final /* synthetic */ UpdateConsentListener $listener$inlined;

    UpsConsentRepository$updateConsent$$inlined$let$lambda$1(String str, boolean z, UpdateConsentListener updateConsentListener) {
        this.$consentKey$inlined = str;
        this.$isConsentOn$inlined = z;
        this.$listener$inlined = updateConsentListener;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new AnonymousClass1(this, (d) null), 2, (Object) null);
        this.$listener$inlined.onConsentUpdated(true, this.$consentKey$inlined, this.$isConsentOn$inlined);
        q.d("consent update failed status code =  ".concat(String.valueOf(i2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r1 = r1.getPreference();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof net.one97.paytm.ups.network.model.consent.ConsentUpdateResponse
            if (r0 == 0) goto L_0x00d1
            net.one97.paytm.ups.network.model.consent.ConsentUpdateResponse r13 = (net.one97.paytm.ups.network.model.consent.ConsentUpdateResponse) r13
            com.paytm.network.model.NetworkResponse r0 = r13.getNetworkResponse()
            int r0 = r0.statusCode
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x00d1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "consent updated successfully "
            r0.<init>(r1)
            net.one97.paytm.ups.network.model.consent.Response r1 = r13.getResponse()
            r2 = 0
            if (r1 == 0) goto L_0x0029
            net.one97.paytm.ups.network.model.consent.ConsentUpdatePreference r1 = r1.getPreference()
            if (r1 == 0) goto L_0x0029
            java.lang.String r1 = r1.getKey()
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            r0.append(r1)
            java.lang.String r1 = " response = "
            r0.append(r1)
            com.paytm.network.model.NetworkResponse r1 = r13.getNetworkResponse()
            byte[] r1 = r1.data
            java.lang.String r3 = "response.networkResponse.data"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)
            java.lang.String r4 = "Charset.forName(\"UTF-8\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1, r3)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.d(r0)
            net.one97.paytm.ups.db.ConsentItem r0 = new net.one97.paytm.ups.db.ConsentItem
            net.one97.paytm.ups.network.model.consent.Response r1 = r13.getResponse()
            if (r1 == 0) goto L_0x006b
            net.one97.paytm.ups.network.model.consent.ConsentUpdatePreference r1 = r1.getPreference()
            if (r1 == 0) goto L_0x006b
            java.lang.String r1 = r1.getKey()
            r4 = r1
            goto L_0x006c
        L_0x006b:
            r4 = r2
        L_0x006c:
            if (r4 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            net.one97.paytm.ups.network.model.consent.Response r13 = r13.getResponse()
            if (r13 == 0) goto L_0x0085
            net.one97.paytm.ups.network.model.consent.ConsentUpdatePreference r13 = r13.getPreference()
            if (r13 == 0) goto L_0x0085
            boolean r13 = r13.getValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r13)
        L_0x0085:
            java.lang.String r5 = java.lang.String.valueOf(r2)
            r6 = 1
            r7 = 0
            r8 = 0
            r10 = 24
            r11 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r10, r11)
            net.one97.paytm.ups.manager.DatabaseManager r13 = net.one97.paytm.ups.manager.DatabaseManager.INSTANCE
            net.one97.paytm.ups.db.UpsDb r13 = r13.getDatabase()
            net.one97.paytm.ups.db.UpsDao r13 = r13.getUpsDao()
            r13.insertConsent(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Post Consent Update DB -> "
            r1.<init>(r2)
            java.util.List r13 = r13.getAllAvailableConsent()
            java.lang.String r13 = r13.toString()
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            com.paytm.utility.q.d(r13)
            net.one97.paytm.ups.listener.UpdateConsentListener r13 = r12.$listener$inlined
            java.lang.String r1 = r0.getConsentKey()
            java.lang.String r0 = r0.getConsentValue()
            if (r0 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r2 = 0
            r13.onConsentUpdated(r2, r1, r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.ups.repository.UpsConsentRepository$updateConsent$$inlined$let$lambda$1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* renamed from: net.one97.paytm.ups.repository.UpsConsentRepository$updateConsent$$inlined$let$lambda$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ UpsConsentRepository$updateConsent$$inlined$let$lambda$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                new ConsentItem(this.this$0.$consentKey$inlined, String.valueOf(this.this$0.$isConsentOn$inlined), false, (String) null, 0, 24, (g) null);
                DatabaseManager.INSTANCE.getDatabase().getUpsDao();
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
