package net.one97.paytm.upgradeKyc.minkycotp;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.upgradeKyc.data.models.requestotp.OtpResponse;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    final y<net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> f66276a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    final y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> f66277b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    final y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> f66278c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    String f66279d = new String();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final net.one97.paytm.upgradeKyc.data.a.b f66280e;

    public a(net.one97.paytm.upgradeKyc.data.a.b bVar) {
        k.c(bVar, "kycOtpRepository");
        this.f66280e = bVar;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f66279d = str;
    }

    @f(b = "KycOtpViewModel.kt", c = {23}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.minkycotp.KycOtpViewModel$requestOtp$1")
    /* renamed from: net.one97.paytm.upgradeKyc.minkycotp.a$a  reason: collision with other inner class name */
    static final class C1328a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $phoneNo;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1328a(a aVar, String str, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$phoneNo = str;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            C1328a aVar = new C1328a(this.this$0, this.$phoneNo, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C1328a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            y<net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> yVar;
            RequestOtpResponse requestOtpResponse;
            ArrayList<OtpResponse> otpResponse;
            OtpResponse otpResponse2;
            String state;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    yVar = (y) this.L$0;
                    if (obj instanceof p.b) {
                        throw ((p.b) obj).exception;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> yVar2 = this.this$0.f66276a;
                net.one97.paytm.upgradeKyc.data.a.b a2 = this.this$0.f66280e;
                String str = this.$phoneNo;
                this.L$0 = yVar2;
                this.label = 1;
                Object a3 = a2.a(str, "", this);
                if (a3 == aVar) {
                    return aVar;
                }
                yVar = yVar2;
                obj = a3;
            } else {
                throw ((p.b) obj).exception;
            }
            yVar.setValue(obj);
            net.one97.paytm.upgradeKyc.kycV3.b.b value = this.this$0.f66276a.getValue();
            if (!(value == null || (requestOtpResponse = (RequestOtpResponse) value.f66169b) == null || (otpResponse = requestOtpResponse.getOtpResponse()) == null || (otpResponse2 = otpResponse.get(0)) == null || (state = otpResponse2.getState()) == null)) {
                this.this$0.a(state);
            }
            return x.f47997a;
        }
    }

    @f(b = "KycOtpViewModel.kt", c = {32}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.minkycotp.KycOtpViewModel$resendOtp$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $state;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$state = str;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$state, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> yVar;
            KycResendOtpResponse kycResendOtpResponse;
            ArrayList<net.one97.paytm.upgradeKyc.data.models.resendotp.OtpResponse> otpResponse;
            net.one97.paytm.upgradeKyc.data.models.resendotp.OtpResponse otpResponse2;
            String state;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    yVar = (y) this.L$0;
                    if (obj instanceof p.b) {
                        throw ((p.b) obj).exception;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> yVar2 = this.this$0.f66277b;
                net.one97.paytm.upgradeKyc.data.a.b a2 = this.this$0.f66280e;
                String str = this.$state;
                this.L$0 = yVar2;
                this.label = 1;
                Object a3 = a2.a(str, this);
                if (a3 == aVar) {
                    return aVar;
                }
                yVar = yVar2;
                obj = a3;
            } else {
                throw ((p.b) obj).exception;
            }
            yVar.setValue(obj);
            net.one97.paytm.upgradeKyc.kycV3.b.b value = this.this$0.f66277b.getValue();
            if (!(value == null || (kycResendOtpResponse = (KycResendOtpResponse) value.f66169b) == null || (otpResponse = kycResendOtpResponse.getOtpResponse()) == null || (otpResponse2 = otpResponse.get(0)) == null || (state = otpResponse2.getState()) == null)) {
                this.this$0.a(state);
            }
            return x.f47997a;
        }
    }

    @f(b = "KycOtpViewModel.kt", c = {41}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.minkycotp.KycOtpViewModel$verifyOtp$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $otp;
        final /* synthetic */ String $state;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$state = str;
            this.$otp = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$state, this.$otp, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> yVar;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    yVar = (y) this.L$0;
                    if (obj instanceof p.b) {
                        throw ((p.b) obj).exception;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> yVar2 = this.this$0.f66278c;
                net.one97.paytm.upgradeKyc.data.a.b a2 = this.this$0.f66280e;
                String str = this.$state;
                String str2 = this.$otp;
                this.L$0 = yVar2;
                this.label = 1;
                Object b2 = a2.b(str, str2, this);
                if (b2 == aVar) {
                    return aVar;
                }
                yVar = yVar2;
                obj = b2;
            } else {
                throw ((p.b) obj).exception;
            }
            yVar.setValue(obj);
            return x.f47997a;
        }
    }
}
