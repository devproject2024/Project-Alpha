package net.one97.paytm.payments.c.a;

import android.app.Activity;
import android.app.Application;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.data.bankscope.a.a.a;
import net.one97.paytm.bankCommon.data.bankscope.a.b.a;
import net.one97.paytm.bankCommon.data.bankscope.b;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.TokenData;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import org.json.JSONObject;

public final class h extends net.one97.paytm.phoenix.core.a {
    public h() {
        super("getNewBankScopeTokenBridge");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        Application application;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity == null || (application = activity.getApplication()) == null) {
            return false;
        }
        x.e eVar = new x.e();
        b.a aVar = net.one97.paytm.bankCommon.data.bankscope.b.f16256a;
        a.C0222a aVar2 = net.one97.paytm.bankCommon.data.bankscope.a.a.a.f16246a;
        a.C0223a aVar3 = net.one97.paytm.bankCommon.data.bankscope.a.b.a.f16249a;
        eVar.element = b.a.a(a.C0222a.a(application), a.C0223a.a(application));
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new a(this, eVar, bVar, h5Event, (d) null), 3, (Object) null);
        return true;
    }

    public static final /* synthetic */ JSONObject a(boolean z, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("loginStatus", z);
        jSONObject.put("bankScopeToken", str);
        return jSONObject;
    }

    @kotlin.d.b.a.f(b = "GetNewBankScopeTokenBridge.kt", c = {23}, d = "invokeSuspend", e = "net.one97.paytm.payments.h5.bridge.GetNewBankScopeTokenBridge$handleEvent$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
        final /* synthetic */ x.e $bankScopeRepository;
        final /* synthetic */ net.one97.paytm.phoenix.api.b $bridgeContext;
        final /* synthetic */ H5Event $event;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar, x.e eVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event, d dVar) {
            super(2, dVar);
            this.this$0 = hVar;
            this.$bankScopeRepository = eVar;
            this.$bridgeContext = bVar;
            this.$event = h5Event;
        }

        public final d<kotlin.x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$bankScopeRepository, this.$bridgeContext, this.$event, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            TokenData data;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                this.label = 1;
                obj = ((net.one97.paytm.bankCommon.data.bankscope.b) this.$bankScopeRepository.element).a("BankLogin", (d<? super c<? extends Object>>) this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            c cVar = (c) obj;
            String str = null;
            if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                T t = cVar.f16217b;
                if (t != null) {
                    ValidateTokenApiResponse validateTokenApiResponse = (ValidateTokenApiResponse) t;
                    Integer responseCode = validateTokenApiResponse != null ? validateTokenApiResponse.getResponseCode() : null;
                    if (responseCode == null || responseCode.intValue() != 200) {
                        net.one97.paytm.phoenix.api.b bVar = this.$bridgeContext;
                        if (bVar != null) {
                            Boolean.valueOf(bVar.a(this.$event, h.a(false, (String) null)));
                        }
                    } else {
                        net.one97.paytm.phoenix.api.b bVar2 = this.$bridgeContext;
                        if (bVar2 != null) {
                            H5Event h5Event = this.$event;
                            if (!(validateTokenApiResponse == null || (data = validateTokenApiResponse.getData()) == null)) {
                                str = data.getAccessToken();
                            }
                            Boolean.valueOf(bVar2.a(h5Event, h.a(true, str)));
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
                }
            } else {
                net.one97.paytm.phoenix.api.b bVar3 = this.$bridgeContext;
                if (bVar3 != null) {
                    Boolean.valueOf(bVar3.a(this.$event, h.a(false, (String) null)));
                }
            }
            return kotlin.x.f47997a;
        }
    }
}
