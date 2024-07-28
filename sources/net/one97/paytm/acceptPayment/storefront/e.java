package net.one97.paytm.acceptPayment.storefront;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.SFUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.acceptPayment.model.GAEvent;
import net.one97.paytm.acceptPayment.model.NetworkRequest;
import net.one97.paytm.acceptPayment.model.RequestData;
import net.one97.paytm.acceptPayment.storefront.c;
import net.one97.paytm.acceptPayment.viewModel.d;

public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public String f52133a;

    /* renamed from: b  reason: collision with root package name */
    final y<List<View>> f52134b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    final c f52135c = new c();

    /* renamed from: d  reason: collision with root package name */
    public String f52136d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Job f52137e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Set<GAEvent> f52138f = new LinkedHashSet();

    /* renamed from: g  reason: collision with root package name */
    private final d.a f52139g;

    public e() {
        d.a a2 = a((kotlin.g.a.a<? extends LiveData<NetworkRequest>>) new c(this));
        this.f52139g = a2;
        a2.b();
        this.f52189i.addSource(this.f52134b, new z<List<? extends View>>(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f52140a;

            {
                this.f52140a = r1;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                this.f52140a.f52189i.postValue(f.f52141a);
            }
        });
    }

    public final String a() {
        String str = this.f52133a;
        if (str == null) {
            k.a("gaCategory");
        }
        return str;
    }

    static final class c extends l implements kotlin.g.a.a<LiveData<NetworkRequest>> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(0);
            this.this$0 = eVar;
        }

        public final LiveData<NetworkRequest> invoke() {
            String str = this.this$0.f52188h;
            String str2 = this.this$0.f52136d;
            if (str2 == null) {
                k.a("storefrontUrl");
            }
            RequestData requestData = new RequestData(str, str2, (Object) null, 4, (g) null);
            AnonymousClass1 r0 = new kotlin.g.a.b<NetworkRequest, x>(this) {
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((NetworkRequest) obj);
                    return x.f47997a;
                }

                public final void invoke(NetworkRequest networkRequest) {
                    k.d(networkRequest, "request");
                    IJRPaytmDataModel ijrPaytmDataModel = networkRequest.getIjrPaytmDataModel();
                    if (!(ijrPaytmDataModel instanceof SFData)) {
                        ijrPaytmDataModel = null;
                    }
                    SFData sFData = (SFData) ijrPaytmDataModel;
                    if (sFData != null) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new b(this.this$0.this$0, sFData, (kotlin.d.d) null), 3, (Object) null);
                    } else {
                        this.this$0.this$0.f52134b.setValue(null);
                    }
                }
            };
            AnonymousClass2 r1 = new kotlin.g.a.a<x>(this) {
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.this$0.f52134b.setValue(null);
                }
            };
            k.d(requestData, H5RpcPlugin.RpcRequest.RpcParam.REQUEST_DATA);
            return net.one97.paytm.acceptPayment.f.b.a(new c.a(net.one97.paytm.acceptPayment.utils.d.f52163a), r0, r1, requestData);
        }
    }

    @kotlin.d.b.a.f(b = "StoreFrontViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.storefront.StoreFrontViewModel$addGAEvent$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ GAEvent $gaEvent;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, GAEvent gAEvent, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = eVar;
            this.$gaEvent = gAEvent;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.d(dVar, "completion");
            a aVar = new a(this.this$0, this.$gaEvent, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                this.this$0.f52138f.add(this.$gaEvent);
                Job b2 = this.this$0.f52137e;
                if (b2 != null) {
                    Job.DefaultImpls.cancel$default(b2, (CancellationException) null, 1, (Object) null);
                }
                this.this$0.f52137e = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                    Object L$0;
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ a this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.d(dVar, "completion");
                        AnonymousClass1 r0 = 

                        @kotlin.d.b.a.f(b = "StoreFrontViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.storefront.StoreFrontViewModel$handleSFResponse$1")
                        static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                            final /* synthetic */ SFData $data;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ e this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            b(e eVar, SFData sFData, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.this$0 = eVar;
                                this.$data = sFData;
                            }

                            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.d(dVar, "completion");
                                b bVar = new b(this.this$0, this.$data, dVar);
                                bVar.p$ = (CoroutineScope) obj;
                                return bVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label == 0) {
                                    ResultKt.a(obj);
                                    HomeResponse homeResponse = (HomeResponse) this.this$0.j.a(this.$data.getRawResponse(), HomeResponse.class);
                                    SFUtils sFUtils = SFUtils.INSTANCE;
                                    k.b(homeResponse, Payload.RESPONSE);
                                    this.this$0.f52134b.postValue(SFUtils.getSanitizedResponse$default(sFUtils, homeResponse, false, 2, (Object) null).getRvWidgets());
                                    return x.f47997a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
