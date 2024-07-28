package net.one97.paytm.deeplink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytm.utility.b;
import com.paytm.utility.q;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.deeplink.f;

public final class ChatDeepLinkHandler$registerBroadcast$1 extends BroadcastReceiver {
    ChatDeepLinkHandler$registerBroadcast$1() {
    }

    public final void onReceive(Context context, Intent intent) {
        q.d("BROADCAST_ACTION_UPDATE_LOGIN_STATUS");
        boolean r = b.r(context);
        q.d(String.valueOf(r));
        if (r) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new a(context, (d) null), 2, (Object) null);
        }
    }

    @f(b = "ChatDeepLinkHandler.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.deeplink.ChatDeepLinkHandler$registerBroadcast$1$onReceive$1")
    static final class a extends k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, d dVar) {
            super(2, dVar);
            this.$context = context;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            a aVar = new a(this.$context, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                f fVar = f.f50341a;
                f.f(this.$context);
                f fVar2 = f.f50341a;
                f.b a2 = f.a();
                if (a2 != null) {
                    a2.f();
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
