package net.one97.paytm.payments.c.a;

import android.app.Activity;
import android.app.Application;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.bankCommon.data.bankscope.a.a.a;
import net.one97.paytm.bankCommon.data.bankscope.a.b.a;
import net.one97.paytm.bankCommon.data.bankscope.b;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.TokenData;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class k extends net.one97.paytm.phoenix.core.a {
    public k() {
        super("getPaytmPassCode");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        H5Event h5Event2 = h5Event;
        net.one97.paytm.phoenix.api.b bVar2 = bVar;
        kotlin.g.b.k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        kotlin.g.b.k.c(bVar2, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        Activity activity = h5Event.getActivity();
        if (params == null || activity == null) {
            return true;
        }
        boolean z = false;
        if (params.has("bankscopetoken")) {
            z = params.getBoolean("bankscopetoken");
        }
        String string = params.getString("passCode");
        Application application = activity.getApplication();
        if (z) {
            kotlin.g.b.k.a((Object) d.b(), "PBGTMHelper.getInstance()");
            Boolean Q = d.Q();
            kotlin.g.b.k.a((Object) Q, "PBGTMHelper.getInstance(…BankScopeTokenFlowEnabled");
            if (Q.booleanValue()) {
                x.e eVar = new x.e();
                b.a aVar = net.one97.paytm.bankCommon.data.bankscope.b.f16256a;
                a.C0222a aVar2 = net.one97.paytm.bankCommon.data.bankscope.a.a.a.f16246a;
                kotlin.g.b.k.a((Object) application, "application");
                a.C0223a aVar3 = net.one97.paytm.bankCommon.data.bankscope.a.b.a.f16249a;
                eVar.element = b.a.a(a.C0222a.a(application), a.C0223a.a(application));
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new a(this, string, eVar, bVar, h5Event, application, (kotlin.d.d) null), 3, (Object) null);
                return true;
            }
        }
        g gVar = g.f16329a;
        kotlin.g.b.k.a((Object) string, "passcode");
        net.one97.paytm.bankCommon.g.f a2 = g.a(activity, string, new b(bVar2, h5Event));
        activity.getApplicationContext();
        c.a();
        c.a(a2);
        return true;
    }

    public static final class b implements net.one97.paytm.bankCommon.f.b<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f17254b;

        b(net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
            this.f17253a = bVar;
            this.f17254b = h5Event;
        }

        public final void a(int i2, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            net.one97.paytm.phoenix.api.b bVar = this.f17253a;
            H5Event h5Event = this.f17254b;
            String alertMessage = networkCustomError.getAlertMessage();
            kotlin.g.b.k.a((Object) alertMessage, "error.alertMessage");
            bVar.a(h5Event, 401, alertMessage);
        }

        public final void a(String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(StringSet.token, str);
            jSONObject.put("message", str2);
            net.one97.paytm.phoenix.api.b bVar = this.f17253a;
            if (bVar != null) {
                bVar.a(this.f17254b, jSONObject);
            }
        }
    }

    @kotlin.d.b.a.f(b = "PaytmPassCodePlugin.kt", c = {64}, d = "invokeSuspend", e = "net.one97.paytm.payments.h5.bridge.PaytmPassCodePlugin$makePassCodeApi$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ Application $application;
        final /* synthetic */ x.e $bankScopeRepository;
        final /* synthetic */ net.one97.paytm.phoenix.api.b $bridgeContext;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ String $passcode;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ k this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar, String str, x.e eVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event, Application application, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = kVar;
            this.$passcode = str;
            this.$bankScopeRepository = eVar;
            this.$bridgeContext = bVar;
            this.$event = h5Event;
            this.$application = application;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$passcode, this.$bankScopeRepository, this.$bridgeContext, this.$event, this.$application, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
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
                d.b();
                String a2 = com.paytm.e.a.b.a(d.O(), this.$passcode);
                kotlin.g.b.k.a((Object) a2, "xCode");
                this.L$0 = a2;
                this.label = 1;
                obj = ((net.one97.paytm.bankCommon.data.bankscope.b) this.$bankScopeRepository.element).b(a2, "BankLogin", this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                T t = cVar.f16217b;
                if (t != null) {
                    ValidateTokenApiResponse validateTokenApiResponse = (ValidateTokenApiResponse) t;
                    String str2 = null;
                    Integer responseCode = validateTokenApiResponse != null ? validateTokenApiResponse.getResponseCode() : null;
                    if (responseCode == null || responseCode.intValue() != 200) {
                        net.one97.paytm.phoenix.api.b bVar = this.$bridgeContext;
                        H5Event h5Event = this.$event;
                        if (validateTokenApiResponse == null || (str = validateTokenApiResponse.getMessage()) == null) {
                            str = "";
                        }
                        bVar.a(h5Event, 401, str);
                    } else {
                        net.one97.paytm.phoenix.api.b bVar2 = this.$bridgeContext;
                        if (bVar2 != null) {
                            H5Event h5Event2 = this.$event;
                            String message = validateTokenApiResponse.getMessage();
                            if (!(validateTokenApiResponse == null || (data = validateTokenApiResponse.getData()) == null)) {
                                str2 = data.getAccessToken();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("message", message);
                            jSONObject.put(StringSet.token, str2);
                            Boolean.valueOf(bVar2.a(h5Event2, jSONObject));
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
                }
            } else {
                net.one97.paytm.phoenix.api.b bVar3 = this.$bridgeContext;
                H5Event h5Event3 = this.$event;
                String string = this.$application.getString(R.string.some_went_wrong);
                kotlin.g.b.k.a((Object) string, "application.getString(R.string.some_went_wrong)");
                bVar3.a(h5Event3, 401, string);
            }
            return kotlin.x.f47997a;
        }
    }
}
