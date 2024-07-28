package net.one97.paytm.oauth.asynctask;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.asynctask.EncryptedTokenWorker;
import net.one97.paytm.oauth.models.TokenV3ResModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.q;

public final class TokenUpgradeWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    private Context f52569a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenUpgradeWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f52569a = context;
    }

    public final ListenableWorker.a doWork() {
        o oVar = o.f56791a;
        if (o.a() && com.paytm.utility.b.c(this.f52569a) && com.paytm.utility.b.r(this.f52569a)) {
            q qVar = q.f56798a;
            if (TextUtils.isEmpty(q.s())) {
                String ab = com.paytm.utility.b.ab(this.f52569a);
                k.a((Object) ab, "CJRAppCommonUtility.getE…dMobileNumber(appContext)");
                o oVar2 = o.f56791a;
                o.a(ab);
                net.one97.paytm.oauth.b b2 = OauthModule.b();
                k.a((Object) b2, "OauthModule.getOathDataProvider()");
                String walletScopeToken = b2.getWalletScopeToken();
                net.one97.paytm.oauth.b.b.c(walletScopeToken, (com.paytm.network.listener.b) new a(this, walletScopeToken));
            }
        }
        ListenableWorker.a a2 = ListenableWorker.a.a();
        k.a((Object) a2, "Result.success()");
        return a2;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TokenUpgradeWorker f52570a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f52571b;

        a(TokenUpgradeWorker tokenUpgradeWorker, String str) {
            this.f52570a = tokenUpgradeWorker;
            this.f52571b = str;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new C0939a(this, iJRPaytmDataModel, (d) null), 2, (Object) null);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String.valueOf(i2);
        }

        @f(b = "TokenUpgradeWorker.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.oauth.asynctask.TokenUpgradeWorker$execDeviceUpgradeApi$1$onApiSuccess$1")
        /* renamed from: net.one97.paytm.oauth.asynctask.TokenUpgradeWorker$a$a  reason: collision with other inner class name */
        static final class C0939a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
            final /* synthetic */ IJRPaytmDataModel $model;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ a this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0939a(a aVar, IJRPaytmDataModel iJRPaytmDataModel, d dVar) {
                super(2, dVar);
                this.this$0 = aVar;
                this.$model = iJRPaytmDataModel;
            }

            public final d<x> create(Object obj, d<?> dVar) {
                k.c(dVar, "completion");
                C0939a aVar = new C0939a(this.this$0, this.$model, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0939a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (!(obj instanceof p.b)) {
                    IJRPaytmDataModel iJRPaytmDataModel = this.$model;
                    if ((iJRPaytmDataModel instanceof UpdatePhoneResModel) && k.a((Object) "200", (Object) ((UpdatePhoneResModel) iJRPaytmDataModel).getResponseCode())) {
                        net.one97.paytm.oauth.b.b.d(this.this$0.f52571b, (com.paytm.network.listener.b) new b());
                    }
                    return x.f47997a;
                } else {
                    throw ((p.b) obj).exception;
                }
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {
        b() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new a(iJRPaytmDataModel, (d) null), 2, (Object) null);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String.valueOf(i2);
        }

        @f(b = "TokenUpgradeWorker.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.oauth.asynctask.TokenUpgradeWorker$execTokenUpgradeApi$1$onApiSuccess$1")
        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
            final /* synthetic */ IJRPaytmDataModel $resModel;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(IJRPaytmDataModel iJRPaytmDataModel, d dVar) {
                super(2, dVar);
                this.$resModel = iJRPaytmDataModel;
            }

            public final d<x> create(Object obj, d<?> dVar) {
                k.c(dVar, "completion");
                a aVar = new a(this.$resModel, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (!(obj instanceof p.b)) {
                    IJRPaytmDataModel iJRPaytmDataModel = this.$resModel;
                    if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                        l.a((TokenV3ResModel) iJRPaytmDataModel);
                        EncryptedTokenWorker.a aVar2 = EncryptedTokenWorker.f52567a;
                        EncryptedTokenWorker.a.a();
                    }
                    return x.f47997a;
                } else {
                    throw ((p.b) obj).exception;
                }
            }
        }
    }
}
