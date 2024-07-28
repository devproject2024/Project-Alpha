package net.one97.paytm.acceptPayment.home;

import android.app.Application;
import androidx.lifecycle.aj;
import androidx.lifecycle.q;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;
import com.business.merchant_payments.newhome.CustomCardEndMarker;
import com.business.merchant_payments.newhome.CustomCardStartMarker;
import com.business.merchant_payments.newhome.StorefrontRepo;
import com.business.merchant_payments.newhome.TabsEndMarker;
import com.business.merchant_payments.newhome.TabsStartMarker;
import com.business.merchant_payments.payment.model.GridItem;
import com.business.merchant_payments.payment.model.HomeTabsModel;
import com.business.merchant_payments.payment.model.QRGridModel;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

public final class a extends AcceptPaymentViewModel {

    /* renamed from: a  reason: collision with root package name */
    public static final C0930a f52086a = new C0930a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    final CustomCardStartMarker f52087b = new CustomCardStartMarker();

    /* renamed from: c  reason: collision with root package name */
    final CustomCardEndMarker f52088c = new CustomCardEndMarker();

    /* renamed from: d  reason: collision with root package name */
    final TabsStartMarker f52089d = new TabsStartMarker();

    /* renamed from: e  reason: collision with root package name */
    final TabsEndMarker f52090e = new TabsEndMarker();

    /* renamed from: f  reason: collision with root package name */
    final MerchantAccountStateManager f52091f = new MerchantAccountStateManager((q) null, 1, (g) null);

    /* renamed from: g  reason: collision with root package name */
    private final HomeTabsModel f52092g = new HomeTabsModel();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final void callStoreFrontAPI() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), Dispatchers.getIO(), (CoroutineStart) null, new b(this, (d) null), 2, (Object) null);
    }

    public final ArrayList<Object> a(List<? extends View> list) {
        k.d(list, "storefrontWidgets");
        ArrayList arrayList = new ArrayList();
        try {
            if (!list.isEmpty()) {
                int i2 = 0;
                for (T next : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    View view = (View) next;
                    if (view.getType() != null && p.a(view.getType(), ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID, true)) {
                        arrayList.add(a(view));
                    } else if (view.getType() != null && p.a(view.getType(), ViewHolderFactory.TYPE_P4B_ANNOUNCEMENT, true)) {
                        arrayList.add(this.f52087b);
                        arrayList.add(this.f52088c);
                    } else if (view.getType() == null || !p.a(view.getType(), ViewHolderFactory.TYPE_P4B_HOMETABS, true)) {
                        arrayList.add(view);
                    } else {
                        arrayList.add(this.f52092g);
                        arrayList.add(this.f52089d);
                        arrayList.add(this.f52090e);
                    }
                    i2 = i3;
                }
            }
            return a((ArrayList<Object>) arrayList);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return a((ArrayList<Object>) arrayList);
        }
    }

    private static QRGridModel a(View view) {
        ArrayList arrayList = new ArrayList();
        List<Item> items = view.getItems();
        k.b(items, "widget.items");
        for (Item item : items) {
            k.b(item, "it");
            GridItem gridItem = new GridItem((String) null, (String) null, (String) null, 7, (g) null);
            String name = item.getName();
            k.b(name, "item.name");
            gridItem.setContent(name);
            String imageUrl = item.getImageUrl();
            k.b(imageUrl, "item.imageUrl");
            gridItem.setIconSrc(imageUrl);
            String url = item.getUrl();
            k.b(url, "item.url");
            gridItem.setDeeplink(url);
            arrayList.add(gridItem);
        }
        return new QRGridModel(arrayList);
    }

    private final ArrayList<Object> a(ArrayList<Object> arrayList) {
        int indexOf = arrayList.indexOf(this.f52087b);
        if (arrayList.indexOf(this.f52092g) == -1) {
            arrayList.add(0, this.f52090e);
            arrayList.add(0, this.f52089d);
            arrayList.add(0, this.f52092g);
        }
        if (indexOf == -1) {
            arrayList.add(0, this.f52088c);
            arrayList.add(0, this.f52087b);
        }
        return arrayList;
    }

    /* renamed from: net.one97.paytm.acceptPayment.home.a$a  reason: collision with other inner class name */
    public static final class C0930a {
        private C0930a() {
        }

        public /* synthetic */ C0930a(byte b2) {
            this();
        }
    }

    @f(b = "APViewModel.kt", c = {37, 38}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.home.APViewModel$callStoreFrontAPI$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.d(dVar, "completion");
            b bVar = new b(this.this$0, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        @f(b = "APViewModel.kt", c = {35}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.home.APViewModel$callStoreFrontAPI$1$storeFrontApiCall$1")
        /* renamed from: net.one97.paytm.acceptPayment.home.a$b$a  reason: collision with other inner class name */
        static final class C0931a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super HomeResponse>, Object> {
            Object L$0;
            int label;
            private CoroutineScope p$;

            C0931a(d dVar) {
                super(2, dVar);
            }

            public final d<x> create(Object obj, d<?> dVar) {
                k.d(dVar, "completion");
                C0931a aVar = new C0931a(dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0931a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    CoroutineScope coroutineScope = this.p$;
                    StorefrontRepo storefrontRepo = StorefrontRepo.INSTANCE;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = storefrontRepo.makeStorefrontCall(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        public final Object invokeSuspend(T t) {
            CoroutineScope coroutineScope;
            Deferred deferred;
            final x.e eVar;
            x.e eVar2;
            T t2 = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(t);
                CoroutineScope coroutineScope2 = this.p$;
                deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope2, (kotlin.d.f) null, (CoroutineStart) null, new C0931a((d) null), 3, (Object) null);
                eVar2 = new x.e();
                this.L$0 = coroutineScope2;
                this.L$1 = deferred;
                this.L$2 = eVar2;
                this.L$3 = eVar2;
                this.label = 1;
                T await = deferred.await(this);
                if (await == t2) {
                    return t2;
                }
                coroutineScope = coroutineScope2;
                t = await;
                eVar = eVar2;
            } else if (i2 == 1) {
                eVar2 = (x.e) this.L$3;
                eVar = (x.e) this.L$2;
                deferred = (Deferred) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.a(t);
            } else if (i2 == 2) {
                ResultKt.a(t);
                return kotlin.x.f47997a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2.element = (HomeResponse) t;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 r1 = new m<CoroutineScope, d<? super kotlin.x>, Object>(this, (d) null) {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ b this$0;

                {
                    this.this$0 = r1;
                }

                public final d<kotlin.x> create(Object obj, d<?> dVar) {
                    k.d(dVar, "completion");
                    AnonymousClass1 r0 = 
                }
