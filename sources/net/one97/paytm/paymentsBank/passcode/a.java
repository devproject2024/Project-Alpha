package net.one97.paytm.paymentsBank.passcode;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.b.d;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.TokenData;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.model.BankToken;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    final LiveData<c<Object>> f18599a = this.f18601c;

    /* renamed from: b  reason: collision with root package name */
    String f18600b = new String();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final y<c<Object>> f18601c = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final net.one97.paytm.bankCommon.data.bankscope.b f18602d;

    public a(net.one97.paytm.bankCommon.data.bankscope.b bVar) {
        k.c(bVar, "bankScopeTokenRepository");
        this.f18602d = bVar;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f18600b = str;
    }

    public static y<c<IJRPaytmDataModel>> a(Context context, String str) {
        k.c(context, "ctx");
        k.c(str, "passcode");
        y<c<IJRPaytmDataModel>> yVar = new y<>();
        c.a aVar = c.f16215d;
        yVar.setValue(new c(d.PROGRESS, null, (Throwable) null));
        String name = BankPasscodeActivity.class.getName();
        k.a((Object) name, "BankPasscodeActivity::class.java.name");
        new HashMap().put("screen_name", name);
        g gVar = g.f16329a;
        f a2 = g.a(context, str, new C0320a(yVar));
        context.getApplicationContext();
        net.one97.paytm.bankCommon.g.c.a();
        net.one97.paytm.bankCommon.g.c.a(a2);
        return yVar;
    }

    /* renamed from: net.one97.paytm.paymentsBank.passcode.a$a  reason: collision with other inner class name */
    public static final class C0320a implements net.one97.paytm.bankCommon.f.b<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f18603a;

        C0320a(y yVar) {
            this.f18603a = yVar;
        }

        public final void a(int i2, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            y yVar = this.f18603a;
            c.a aVar = c.f16215d;
            yVar.setValue(c.a.a((Throwable) networkCustomError));
        }

        public final void a(String str, String str2) {
            BankToken bankToken = new BankToken();
            bankToken.setAccessToken(str);
            bankToken.setmMessage(str2);
            y yVar = this.f18603a;
            c.a aVar = c.f16215d;
            yVar.setValue(c.a.a(bankToken));
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "passcode");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (kotlin.d.f) null, (CoroutineStart) null, new b(this, str, str2, (kotlin.d.d) null), 3, (Object) null);
    }

    @kotlin.d.b.a.f(b = "PasscodeVM.kt", c = {69}, d = "invokeSuspend", e = "net.one97.paytm.paymentsBank.passcode.PasscodeVM$verifyPassCodeAndGetSingleUseBankToken$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $passcode;
        final /* synthetic */ String $screenName;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$passcode = str;
            this.$screenName = str2;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$passcode, this.$screenName, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            Integer responseCode;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                net.one97.paytm.bankCommon.data.bankscope.b a2 = this.this$0.f18602d;
                String str = this.$passcode;
                String str2 = this.$screenName;
                this.label = 1;
                obj = a2.b(str, str2, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            c cVar = (c) obj;
            if (cVar.f16216a == d.SUCCESS) {
                T t = cVar.f16217b;
                if (t != null) {
                    ValidateTokenApiResponse validateTokenApiResponse = (ValidateTokenApiResponse) t;
                    if (validateTokenApiResponse.getResponseCode() == null || (responseCode = validateTokenApiResponse.getResponseCode()) == null || responseCode.intValue() != 200) {
                        String message = validateTokenApiResponse.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        NetworkCustomError networkCustomError = new NetworkCustomError("");
                        networkCustomError.setAlertMessage(message);
                        y b2 = this.this$0.f18601c;
                        c.a aVar2 = c.f16215d;
                        b2.setValue(c.a.a((Throwable) networkCustomError));
                    } else {
                        y b3 = this.this$0.f18601c;
                        c.a aVar3 = c.f16215d;
                        TokenData data = validateTokenApiResponse.getData();
                        b3.setValue(c.a.a(data != null ? data.getAccessToken() : null));
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
                }
            } else {
                y b4 = this.this$0.f18601c;
                c.a aVar4 = c.f16215d;
                Throwable th = cVar.f16218c;
                if (th != null) {
                    b4.setValue(c.a.a((Throwable) (NetworkCustomError) th));
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
            return x.f47997a;
        }
    }
}
