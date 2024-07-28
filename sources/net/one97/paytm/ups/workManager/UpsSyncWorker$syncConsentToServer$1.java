package net.one97.paytm.ups.workManager;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.repository.UpsConsentRepository;

@f(b = "UpsSyncWorker.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.ups.workManager.UpsSyncWorker$syncConsentToServer$1")
final class UpsSyncWorker$syncConsentToServer$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ ConsentItem $consentItem;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ UpsSyncWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpsSyncWorker$syncConsentToServer$1(UpsSyncWorker upsSyncWorker, ConsentItem consentItem, d dVar) {
        super(2, dVar);
        this.this$0 = upsSyncWorker;
        this.$consentItem = consentItem;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        UpsSyncWorker$syncConsentToServer$1 upsSyncWorker$syncConsentToServer$1 = new UpsSyncWorker$syncConsentToServer$1(this.this$0, this.$consentItem, dVar);
        upsSyncWorker$syncConsentToServer$1.p$ = (CoroutineScope) obj;
        return upsSyncWorker$syncConsentToServer$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UpsSyncWorker$syncConsentToServer$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            UpsConsentRepository upsConsentRepository = UpsConsentRepository.INSTANCE;
            String consentKey = this.$consentItem.getConsentKey();
            String consentValue = this.$consentItem.getConsentValue();
            if (consentValue == null) {
                kotlin.g.b.k.a();
            }
            upsConsentRepository.updateConsent(consentKey, Boolean.parseBoolean(consentValue), this.this$0.consentUpdateListener);
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
