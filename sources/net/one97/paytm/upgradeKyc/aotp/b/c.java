package net.one97.paytm.upgradeKyc.aotp.b;

import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> f65566a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public KYCFetchTnc f65567b;

    /* renamed from: c  reason: collision with root package name */
    final net.one97.paytm.upgradeKyc.data.a.a.b f65568c;

    public c(net.one97.paytm.upgradeKyc.data.a.a.b bVar) {
        k.c(bVar, "aotpExpiryRepository");
        this.f65568c = bVar;
    }

    public final KYCFetchTnc a() {
        KYCFetchTnc kYCFetchTnc = this.f65567b;
        if (kYCFetchTnc == null) {
            k.a("aotpTncInfo");
        }
        return kYCFetchTnc;
    }

    @f(b = "KYCAOTPExitConsentViewModel.kt", c = {39}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.aotp.viewModel.KYCAOTPExitConsentViewModel$expireAOTP$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            NetworkCustomError networkCustomError;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar = this.this$0.f65566a;
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a());
                net.one97.paytm.upgradeKyc.data.a.a.b bVar = this.this$0.f65568c;
                this.label = 1;
                obj = bVar.b(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar2 = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS) {
                AOTPExpireApiResponse aOTPExpireApiResponse = (AOTPExpireApiResponse) bVar2.f66169b;
                if (aOTPExpireApiResponse != null) {
                    CharSequence responseCode = aOTPExpireApiResponse.getResponseCode();
                    boolean z = false;
                    if ((responseCode == null || responseCode.length() == 0) || !k.a((Object) aOTPExpireApiResponse.getResponseCode(), (Object) "200")) {
                        CharSequence message = aOTPExpireApiResponse.getMessage();
                        if (message == null || message.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar2 = this.this$0.f65566a;
                            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar2.setValue(b.a.a(new NetworkCustomError(aOTPExpireApiResponse.getMessage())));
                        } else {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar3 = this.this$0.f65566a;
                            b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar3.setValue(b.a.a(new NetworkCustomError("Something went wrong. \n Please try again later")));
                        }
                    } else {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this.this$0), (kotlin.d.f) null, (CoroutineStart) null, new C1297c(this.this$0, (kotlin.d.d) null), 3, (Object) null);
                    }
                }
            } else if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.ERROR && (networkCustomError = bVar2.f66170c) != null) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar4 = this.this$0.f65566a;
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar4.setValue(b.a.a(networkCustomError));
            }
            return x.f47997a;
        }
    }

    @f(b = "KYCAOTPExitConsentViewModel.kt", c = {95}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.aotp.viewModel.KYCAOTPExitConsentViewModel$fetchTNC$1")
    public static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            NetworkCustomError networkCustomError;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar = this.this$0.f65566a;
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a());
                net.one97.paytm.upgradeKyc.data.a.a.b bVar = this.this$0.f65568c;
                this.label = 1;
                obj = bVar.a((kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>>) this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar2 = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS) {
                KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) bVar2.f66169b;
                if (kYCFetchTnc != null) {
                    CharSequence status = kYCFetchTnc.getStatus();
                    boolean z = false;
                    if ((status == null || status.length() == 0) || !k.a((Object) kYCFetchTnc.getStatus(), (Object) "SUCCESS") || !k.a((Object) kYCFetchTnc.getResponseCode(), (Object) "2000")) {
                        CharSequence message = kYCFetchTnc.getMessage();
                        if (message == null || message.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar2 = this.this$0.f65566a;
                            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar2.setValue(b.a.a(new NetworkCustomError(kYCFetchTnc.getMessage())));
                        } else {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar3 = this.this$0.f65566a;
                            b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar3.setValue(b.a.a(new NetworkCustomError("")));
                        }
                    } else {
                        c cVar = this.this$0;
                        k.c(kYCFetchTnc, "<set-?>");
                        cVar.f65567b = kYCFetchTnc;
                        y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar4 = this.this$0.f65566a;
                        b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                        yVar4.setValue(b.a.a(net.one97.paytm.upgradeKyc.aotp.a.TNC_FETCHED));
                    }
                }
            } else if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.ERROR && (networkCustomError = bVar2.f66170c) != null) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar5 = this.this$0.f65566a;
                b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar5.setValue(b.a.a(networkCustomError));
            }
            return x.f47997a;
        }
    }

    @f(b = "KYCAOTPExitConsentViewModel.kt", c = {22}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.aotp.viewModel.KYCAOTPExitConsentViewModel$getKycDetails$1")
    /* renamed from: net.one97.paytm.upgradeKyc.aotp.b.c$c  reason: collision with other inner class name */
    static final class C1297c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1297c(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            C1297c cVar = new C1297c(this.this$0, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C1297c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar = this.this$0.f65566a;
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a());
                net.one97.paytm.upgradeKyc.data.a.a.b bVar = this.this$0.f65568c;
                this.label = 1;
                obj = bVar.c(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar2 = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS) {
                if (((KYCStatusV3) bVar2.f66169b) != null) {
                    y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar2 = this.this$0.f65566a;
                    b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                    yVar2.setValue(b.a.a(net.one97.paytm.upgradeKyc.aotp.a.CONSENT_GIVEN));
                }
            } else if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.ERROR) {
                NetworkCustomError networkCustomError = bVar2.f66170c;
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar3 = this.this$0.f65566a;
                b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar3.setValue(b.a.a(networkCustomError));
            }
            return x.f47997a;
        }
    }

    @f(b = "KYCAOTPExitConsentViewModel.kt", c = {65}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.aotp.viewModel.KYCAOTPExitConsentViewModel$submitConsentAotpTnc$1")
    public static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            NetworkCustomError networkCustomError;
            Integer num;
            TncData tncData;
            TncData tncData2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            boolean z = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar = this.this$0.f65566a;
                b.a aVar2 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a());
                net.one97.paytm.upgradeKyc.data.a.a.b bVar = this.this$0.f65568c;
                ArrayList<TncData> tncDataList = this.this$0.a().getTncDataList();
                String str = null;
                if (tncDataList == null || (tncData2 = tncDataList.get(0)) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(tncData2.getVersion());
                }
                if (num == null) {
                    k.a();
                }
                int intValue = num.intValue();
                ArrayList<TncData> tncDataList2 = this.this$0.a().getTncDataList();
                if (!(tncDataList2 == null || (tncData = tncDataList2.get(0)) == null)) {
                    str = tncData.getCode();
                }
                if (str == null) {
                    k.a();
                }
                this.label = 1;
                obj = bVar.a(intValue, str, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar2 = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS) {
                KYCTncAccept kYCTncAccept = (KYCTncAccept) bVar2.f66169b;
                if (kYCTncAccept != null) {
                    CharSequence status = kYCTncAccept.getStatus();
                    if ((status == null || status.length() == 0) || !kotlin.m.p.a(kYCTncAccept.getStatus(), "SUCCESS", true) || !k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                        CharSequence message = kYCTncAccept.getMessage();
                        if (message == null || message.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar2 = this.this$0.f65566a;
                            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar2.setValue(b.a.a(new NetworkCustomError(kYCTncAccept.getMessage())));
                        } else {
                            y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar3 = this.this$0.f65566a;
                            b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar3.setValue(b.a.a(new NetworkCustomError("")));
                        }
                    } else {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this.this$0), (kotlin.d.f) null, (CoroutineStart) null, new a(this.this$0, (kotlin.d.d) null), 3, (Object) null);
                    }
                }
            } else if (bVar2.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.ERROR && (networkCustomError = bVar2.f66170c) != null) {
                y<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> yVar4 = this.this$0.f65566a;
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar4.setValue(b.a.a(networkCustomError));
            }
            return x.f47997a;
        }
    }
}
