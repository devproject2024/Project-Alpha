package net.one97.paytm.wallet.newdesign.d;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.SFUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;

public final class c extends Fragment implements com.paytm.network.listener.b, IGAHandlerListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f70867a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f70868b = 1005;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f70869c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f70870d;

    /* renamed from: e  reason: collision with root package name */
    private View f70871e;

    /* renamed from: f  reason: collision with root package name */
    private b f70872f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f70873g;

    /* renamed from: h  reason: collision with root package name */
    private String f70874h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a.c f70875i = a.c.HOME;
    /* access modifiers changed from: private */
    public String j;
    private HashMap k;

    public final boolean IsClickEnable() {
        return true;
    }

    public /* synthetic */ void OnItemClick(Item item, int i2) {
        IGAClickListener.CC.$default$OnItemClick(this, item, i2);
    }

    public final void OnItemClick(Item item, int i2, boolean z) {
        k.c(item, "item");
    }

    public final void fireImpression(Item item, int i2) {
        k.c(item, "item");
    }

    public final void fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        k.c(view, "view");
    }

    public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
    }

    public final int getClient() {
        return 1002;
    }

    public /* synthetic */ String getClientRequestID() {
        return IAdListener.CC.$default$getClientRequestID(this);
    }

    public static final /* synthetic */ String a(c cVar) {
        String str = cVar.j;
        if (str == null) {
            k.a("mScreenName");
        }
        return str;
    }

    public c() {
    }

    public c(Activity activity, View view, String str, a.c cVar) {
        k.c(activity, "activity");
        k.c(cVar, "verticalId");
        this.f70873g = view;
        if (str != null) {
            this.f70874h = str;
        }
        this.f70875i = cVar;
    }

    public c(Activity activity, View view, String str, a.c cVar, String str2) {
        k.c(activity, "activity");
        k.c(cVar, "verticalId");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f70873g = view;
        if (str != null) {
            this.f70874h = str;
        }
        this.f70875i = cVar;
        this.j = str2;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f70872f = activity != null ? (b) am.a(activity).a(b.class) : null;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && this.f70872f != null) {
            k.a((Object) activity2, "it");
            b.a(activity2, this, this.f70875i, this.f70874h);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(Activity activity, View view, String str, a.c cVar) {
            k.c(activity, "activity");
            k.c(cVar, "verticalId");
            return new c(activity, view, str, cVar);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_sf_common, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…common, container, false)");
        this.f70871e = inflate;
        View view = this.f70871e;
        if (view == null) {
            k.a("rootView");
        }
        View findViewById = view.findViewById(R.id.sfrv);
        k.a((Object) findViewById, "rootView.findViewById(R.id.sfrv)");
        this.f70870d = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.f70870d;
        if (recyclerView == null) {
            k.a("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f70869c = new a(this);
        RecyclerView recyclerView2 = this.f70870d;
        if (recyclerView2 == null) {
            k.a("recyclerView");
        }
        recyclerView2.setAdapter(this.f70869c);
        View view2 = this.f70871e;
        if (view2 == null) {
            k.a("rootView");
        }
        return view2;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        View view = this.f70873g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @f(b = "SfWalletFragment.kt", c = {136}, d = "invokeSuspend", e = "net.one97.paytm.wallet.newdesign.sf_sdk.SfWalletFragment$handleApiResponse$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ IJRPaytmDataModel $dataModel;
        final /* synthetic */ x.e $response;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, x.e eVar, IJRPaytmDataModel iJRPaytmDataModel, d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$response = eVar;
            this.$dataModel = iJRPaytmDataModel;
        }

        public final d<kotlin.x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$response, this.$dataModel, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                this.L$0 = this.p$;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getDefault(), new m<CoroutineScope, d<? super kotlin.x>, Object>(this, (d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ b this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final d<kotlin.x> create(Object obj, d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        /* renamed from: net.one97.paytm.wallet.newdesign.d.c$c  reason: collision with other inner class name */
                        static final class C1431c extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
                            final /* synthetic */ HomeResponse $response$inlined;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ c this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            C1431c(d dVar, c cVar, HomeResponse homeResponse) {
                                super(2, dVar);
                                this.this$0 = cVar;
                                this.$response$inlined = homeResponse;
                            }

                            public final d<kotlin.x> create(Object obj, d<?> dVar) {
                                k.c(dVar, "completion");
                                C1431c cVar = new C1431c(dVar, this.this$0, this.$response$inlined);
                                cVar.p$ = (CoroutineScope) obj;
                                return cVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((C1431c) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                String str;
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label == 0) {
                                    ResultKt.a(obj);
                                    if (this.this$0.j != null) {
                                        str = c.a(this.this$0);
                                    } else {
                                        str = this.this$0.f70875i.name();
                                    }
                                    SanitizedResponseModel sanitizedResponse = SFUtils.INSTANCE.getSanitizedResponse(this.$response$inlined, false, str, 1004, new IGAEnableListener() {
                                        public final boolean isGAEnabled() {
                                            return true;
                                        }
                                    });
                                    a d2 = this.this$0.f70869c;
                                    if (d2 != null) {
                                        d2.f70866b = sanitizedResponse.getGaListener();
                                    }
                                    a d3 = this.this$0.f70869c;
                                    if (d3 != null) {
                                        List rvWidgets = sanitizedResponse.getRvWidgets();
                                        if (rvWidgets == null) {
                                            rvWidgets = d3.f70865a;
                                        }
                                        d3.f70865a = rvWidgets;
                                        d3.notifyDataSetChanged();
                                    }
                                    View e2 = this.this$0.f70873g;
                                    if (e2 != null) {
                                        e2.setVisibility(0);
                                    }
                                    return kotlin.x.f47997a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }

                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            List<Page> page;
                            x.e eVar = new x.e();
                            eVar.element = null;
                            Object unused = BuildersKt__BuildersKt.runBlocking$default((kotlin.d.f) null, new b(this, eVar, iJRPaytmDataModel, (d) null), 1, (Object) null);
                            HomeResponse homeResponse = (HomeResponse) eVar.element;
                            if (homeResponse == null || (page = homeResponse.getPage()) == null) {
                                View view = this.f70873g;
                                if (view != null) {
                                    view.setVisibility(8);
                                }
                            } else if (page.size() > 0) {
                                View view2 = this.f70873g;
                                if (view2 != null) {
                                    view2.setVisibility(0);
                                }
                                Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new C1431c((d) null, this, homeResponse), 3, (Object) null);
                            } else {
                                View view3 = this.f70873g;
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                }
                            }
                        }

                        public static final /* synthetic */ HomeResponse a(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof StringResponseModel) {
                                return (HomeResponse) new com.google.gson.f().a(((StringResponseModel) iJRPaytmDataModel).getRawResponse(), HomeResponse.class);
                            }
                            return (HomeResponse) new com.google.gson.f().a(String.valueOf(iJRPaytmDataModel), HomeResponse.class);
                        }

                        public final /* synthetic */ void onDestroyView() {
                            super.onDestroyView();
                            HashMap hashMap = this.k;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                        }
                    }
