package net.one97.paytm.recharge.mobile.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.a.s;
import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.utils.aq;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.utils.n;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile.widget.CJRMobileInputFieldWidgetV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class e extends d implements View.OnClickListener, h.c, p.a, p.b, e.a, CJRMobileInputFieldWidgetV8.a {
    public static final a A = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String D;
    private net.one97.paytm.recharge.common.utils.e B;
    private CJRFrequentOrder C;
    private HashMap E;

    /* renamed from: f  reason: collision with root package name */
    private s f63603f;
    CJRInputFieldsItem n;
    CJRInputFieldWithActionWidgetV8 o;
    String p;
    boolean q = true;
    boolean r;
    boolean s;
    z<Boolean> t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    final View.OnClickListener z = new d(this);

    public void an_() {
    }

    public void ap_() {
    }

    public final void ar_() {
    }

    public View b(int i2) {
        if (this.E == null) {
            this.E = new HashMap();
        }
        View view = (View) this.E.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.E.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
    }

    public void u() {
        HashMap hashMap = this.E;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class b extends l implements kotlin.g.a.b<List<? extends CJRFrequentOrder>, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends CJRFrequentOrder>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends CJRFrequentOrder> list) {
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                this.this$0.a((List<? extends CJRFrequentOrder>) (List) collection);
            }
        }
    }

    static final class c extends l implements kotlin.g.a.b<List<? extends ContactItemModel>, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends ContactItemModel>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends ContactItemModel> list) {
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                List list2 = (List) collection;
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(com.paytm.utility.b.l(this.this$0.getContext()))) {
                    Context context = this.this$0.getContext();
                    if (context == null) {
                        k.a();
                    }
                    arrayList.add(new ContactItemModel(context.getString(R.string.my_number), com.paytm.utility.b.l(this.this$0.getContext()), com.paytm.utility.b.al(this.this$0.getContext()), false));
                }
                arrayList.addAll(list2);
                this.this$0.b((List<? extends ContactItemModel>) arrayList);
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.e$e  reason: collision with other inner class name */
    static final class C1236e extends l implements kotlin.g.a.b<CJRCategoryData, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1236e(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCategoryData) obj);
            return x.f47997a;
        }

        public final void invoke(CJRCategoryData cJRCategoryData) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.this$0.f63600h;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    static final class f extends l implements kotlin.g.a.b<LinkedList<CJRSelectedGroupItem>, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LinkedList<CJRSelectedGroupItem>) (LinkedList) obj);
            return x.f47997a;
        }

        public final void invoke(LinkedList<CJRSelectedGroupItem> linkedList) {
            if (linkedList != null && this.this$0.r) {
                this.this$0.a(linkedList);
            }
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63605a;

        g(e eVar) {
            this.f63605a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            LiveData<List<ContactItemModel>> liveData;
            if (k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                e eVar = this.f63605a;
                if (eVar.f63600h != null) {
                    androidx.loader.a.a a2 = androidx.loader.a.a.a(this.f63605a);
                    k.a((Object) a2, "LoaderManager.getInstanc…erMobileNumberFragmentV8)");
                    liveData = net.one97.paytm.recharge.mobile.d.a.a(a2);
                } else {
                    liveData = null;
                }
                net.one97.paytm.recharge.common.utils.g.a(eVar, liveData, new kotlin.g.a.b<List<? extends ContactItemModel>, x>(this) {
                    final /* synthetic */ g this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((List<? extends ContactItemModel>) (List) obj);
                        return x.f47997a;
                    }

                    public final void invoke(List<? extends ContactItemModel> list) {
                        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8;
                        if (list != null && !list.isEmpty() && (cJRInputFieldWithActionWidgetV8 = this.this$0.f63605a.o) != null) {
                            cJRInputFieldWithActionWidgetV8.b(R.drawable.ic_contacts_v8, this.this$0.f63605a.z);
                        }
                    }
                });
                return;
            }
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.f63605a.o;
            if (cJRInputFieldWithActionWidgetV8 != null) {
                cJRInputFieldWithActionWidgetV8.b(R.drawable.ic_contacts_v8, this.f63605a.z);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = e.class.getSimpleName();
        k.a((Object) simpleName, "FJREnterMobileNumberFrag…V8::class.java.simpleName");
        D = simpleName;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.u = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_enter_mobile_number, viewGroup, false);
    }

    public final void A() {
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        k.a((Object) toolbar, "toolbar");
        toolbar.setVisibility(8);
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        k.a((Object) subtitleCollapsingToolbarLayout, "toolbar_layout");
        subtitleCollapsingToolbarLayout.setVisibility(8);
        AppBarLayout appBarLayout = (AppBarLayout) b(R.id.appbar_layout);
        k.a((Object) appBarLayout, "appbar_layout");
        appBarLayout.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r4 = r4.f61409b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r5 = "view"
            kotlin.g.b.k.c(r4, r5)
            int r4 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r4 = r3.b((int) r4)
            androidx.appcompat.widget.Toolbar r4 = (androidx.appcompat.widget.Toolbar) r4
            r3.a((androidx.appcompat.widget.Toolbar) r4)
            net.one97.paytm.recharge.common.utils.ba r4 = new net.one97.paytm.recharge.common.utils.ba
            r5 = r3
            net.one97.paytm.recharge.common.utils.ba$a r5 = (net.one97.paytm.recharge.common.utils.ba.a) r5
            r4.<init>(r5)
            r3.k = r4
            net.one97.paytm.recharge.common.b.a r4 = r3.f63601i
            if (r4 == 0) goto L_0x003b
            android.content.Context r5 = r3.getContext()
            if (r5 != 0) goto L_0x0027
            kotlin.g.b.k.a()
        L_0x0027:
            java.lang.String r0 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            android.view.View r4 = r4.b((android.content.Context) r5)
            if (r4 == 0) goto L_0x003b
            boolean r5 = r4 instanceof net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8
            if (r5 == 0) goto L_0x003b
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r4 = (net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r4
            r3.a((net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r4)
        L_0x003b:
            net.one97.paytm.recharge.mobile.d.a r4 = r3.f63600h
            r5 = 0
            if (r4 == 0) goto L_0x0049
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r4.f61409b
            if (r4 == 0) goto L_0x0049
            androidx.lifecycle.LiveData r4 = r4.getCategoryLiveData()
            goto L_0x004a
        L_0x0049:
            r4 = r5
        L_0x004a:
            net.one97.paytm.recharge.mobile.a.e$e r0 = new net.one97.paytm.recharge.mobile.a.e$e
            r0.<init>(r3)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r3, r4, r0)
            int r4 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r4 = r3.b((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r0 = "recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r3.getContext()
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r4.setLayoutManager(r1)
            net.one97.paytm.recharge.common.a.s r4 = new net.one97.paytm.recharge.common.a.s
            r4.<init>()
            r3.f63603f = r4
            net.one97.paytm.recharge.common.a.s r4 = r3.f63603f
            if (r4 == 0) goto L_0x007d
            r1 = 1
            r4.f60674e = r1
        L_0x007d:
            int r4 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r4 = r3.b((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.paytm.recharge.common.a.s r0 = r3.f63603f
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r4.setAdapter(r0)
            r3.v()
            r3.B()
            net.one97.paytm.recharge.mobile.d.a r4 = r3.f63600h
            if (r4 == 0) goto L_0x009e
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r4 = r4.F
            r5 = r4
            androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
        L_0x009e:
            net.one97.paytm.recharge.mobile.a.e$f r4 = new net.one97.paytm.recharge.mobile.a.e$f
            r4.<init>(r3)
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4
            net.one97.paytm.recharge.common.utils.g.a(r3, r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void a(List<? extends CJRFrequentOrder> list) {
        k.c(list, "recents");
        s sVar = this.f63603f;
        if (sVar != null) {
            CJRRecentOrderV8.a a2 = new CJRRecentOrderV8.a().a(list).a(CJRRecentOrderV8.b.MOBILE.ordinal());
            a2.f61927e = this;
            a2.f61929g = this;
            k.c(list, "recents");
            k.c(a2, "options");
            sVar.f60670a = list;
            if (sVar.f60672c == null) {
                sVar.f60672c = new ArrayList<>();
            }
            if (sVar.f60673d == null) {
                sVar.f60673d = new ArrayList<>();
            }
            List<CJRFrequentOrder> list2 = a2.f61931i;
            if (list2 != null) {
                ArrayList<Object> arrayList = sVar.f60672c;
                if (arrayList == null) {
                    k.a();
                }
                Collection collection = list2;
                arrayList.addAll(collection);
                ArrayList<Object> arrayList2 = sVar.f60673d;
                if (arrayList2 == null) {
                    k.a();
                }
                arrayList2.addAll(collection);
                ArrayList<Object> arrayList3 = sVar.f60672c;
                if (arrayList3 == null) {
                    k.a();
                }
                sVar.notifyItemRangeChanged(arrayList3.size() - 1, list2.size());
            }
            sVar.f60671b = new p(a2);
        }
    }

    public void b(List<? extends ContactItemModel> list) {
        k.c(list, Tables.CONTACTS);
        s sVar = this.f63603f;
        if (sVar != null) {
            CJRContactListV8.a aVar = new CJRContactListV8.a();
            String string = getString(R.string.from_your_contacts);
            k.a((Object) string, "getString(R.string.from_your_contacts)");
            CJRContactListV8.a a2 = aVar.a(string).a(list);
            a2.f61862c = this;
            sVar.a(list, a2);
        }
    }

    public void a(LinkedList<CJRSelectedGroupItem> linkedList) {
        CJRInputFieldsItem cJRInputFieldsItem;
        if (linkedList == null || linkedList.isEmpty()) {
            e("");
            return;
        }
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
        Iterator it2 = linkedList.iterator();
        while (true) {
            String str = null;
            if (!it2.hasNext()) {
                break;
            }
            CJRSelectedGroupItem cJRSelectedGroupItem = (CJRSelectedGroupItem) it2.next();
            CJRAggsItem item = cJRSelectedGroupItem.getItem();
            if (item != null) {
                str = item.getRegEx();
            }
            if (net.one97.paytm.recharge.common.utils.g.c(str) && (cJRInputFieldsItem = this.n) != null) {
                CJRAggsItem item2 = cJRSelectedGroupItem.getItem();
                if (item2 == null) {
                    k.a();
                }
                cJRInputFieldsItem.setRegex(item2.getRegEx());
            }
        }
        this.r = false;
        if (this.f63601i != null) {
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
            if (cJRInputFieldWithActionWidgetV82 == null) {
                k.a();
            }
            View view = cJRInputFieldWithActionWidgetV82;
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV83 = this.o;
            if (cJRInputFieldWithActionWidgetV83 == null) {
                k.a();
            }
            if (net.one97.paytm.recharge.common.b.a.a(view, cJRInputFieldWithActionWidgetV83.getInputText(), true)) {
                w();
                return;
            }
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.k();
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a((LinkedList<CJRSelectedGroupItem>) null);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63604a;

        d(e eVar) {
            this.f63604a = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
            r0 = r0.K;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
                r6 = this;
                net.one97.paytm.recharge.mobile.a.e r7 = r6.f63604a
                r7.j()
                net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r7.o
                if (r0 == 0) goto L_0x000c
                r0.clearFocus()
            L_0x000c:
                net.one97.paytm.recharge.mobile.d.a r0 = r7.f63600h
                r1 = 0
                if (r0 == 0) goto L_0x001e
                androidx.lifecycle.y<java.lang.Boolean> r0 = r0.K
                androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
                if (r0 == 0) goto L_0x001e
                java.lang.Object r0 = r0.getValue()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                goto L_0x001f
            L_0x001e:
                r0 = r1
            L_0x001f:
                java.lang.Boolean r2 = java.lang.Boolean.TRUE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
                if (r0 == 0) goto L_0x0071
                r0 = 1
                r7.s = r0
                net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r1 = r7.o
                if (r1 != 0) goto L_0x0031
                kotlin.g.b.k.a()
            L_0x0031:
                android.view.View r1 = (android.view.View) r1
                java.lang.String r2 = "view"
                kotlin.g.b.k.c(r1, r2)
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>(r0)
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 21
                if (r3 < r4) goto L_0x005a
                r3 = r2
                java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0059 }
                java.lang.String r4 = androidx.core.h.u.x(r1)     // Catch:{ Exception -> 0x0059 }
                if (r4 != 0) goto L_0x0050
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0059 }
            L_0x0050:
                java.lang.String r5 = "ViewCompat.getTransitionName(view)!!"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0059 }
                r3.put(r4, r1)     // Catch:{ Exception -> 0x0059 }
                goto L_0x005a
            L_0x0059:
            L_0x005a:
                net.one97.paytm.recharge.mobile.d r1 = r7.f63599g
                if (r1 == 0) goto L_0x00b9
                java.util.Map r2 = (java.util.Map) r2
                r3 = r7
                net.one97.paytm.recharge.common.a.h$c r3 = (net.one97.paytm.recharge.common.a.h.c) r3
                boolean r4 = r7.v
                if (r4 != 0) goto L_0x006c
                boolean r7 = r7.u
                if (r7 == 0) goto L_0x006c
                goto L_0x006d
            L_0x006c:
                r0 = 0
            L_0x006d:
                r1.a(r2, r3, r0)
                goto L_0x00b9
            L_0x0071:
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ ActivityNotFoundException -> 0x0088 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0088 }
                java.lang.String r2 = "android.intent.action.PICK"
                android.net.Uri r3 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch:{ ActivityNotFoundException -> 0x0088 }
                r0.<init>(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x0088 }
                java.lang.String r2 = "vnd.android.cursor.dir/phone_v2"
                r0.setType(r2)     // Catch:{ ActivityNotFoundException -> 0x0088 }
                r2 = 100
                r7.startActivityForResult(r0, r2, r1)     // Catch:{ ActivityNotFoundException -> 0x0088 }
                goto L_0x00b9
            L_0x0088:
                r7 = move-exception
                net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
                java.lang.String r1 = "Contact permission not granted NOR System Phone Contact activity started"
                r0.setErrorMsg(r1)
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x00a3
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
                java.lang.String r2 = r2.name()
                r1.setErrorType(r2)
            L_0x00a3:
                net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
                if (r1 == 0) goto L_0x00b2
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CTA_CONTACT
                java.lang.String r2 = r2.name()
                r1.setActionType(r2)
            L_0x00b2:
                net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0, (java.lang.Throwable) r7)
            L_0x00b9:
                net.one97.paytm.recharge.mobile.a.e r7 = r6.f63604a     // Catch:{ Exception -> 0x00c0 }
                java.lang.String r0 = "default_flow"
                r7.g(r0)     // Catch:{ Exception -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.e.d.onClick(android.view.View):void");
        }
    }

    public void a(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
        k.c(cJRInputFieldWithActionWidgetV8, "view");
        this.o = cJRInputFieldWithActionWidgetV8;
        cJRInputFieldWithActionWidgetV8.requestFocus();
        t tVar = this.f61110b;
        if (tVar != null) {
            tVar.b();
        }
        CJRMobileInputFieldWidgetV8 cJRMobileInputFieldWidgetV8 = (CJRMobileInputFieldWidgetV8) cJRInputFieldWithActionWidgetV8;
        cJRMobileInputFieldWidgetV8.setMInputFieldTextChangeListener(this);
        if (cJRMobileInputFieldWidgetV8.getTag() instanceof a.C1172a) {
            Object tag = cJRMobileInputFieldWidgetV8.getTag();
            if (tag != null) {
                a.C1172a aVar = (a.C1172a) tag;
                if (aVar.f60877c instanceof CJRInputFieldsItem) {
                    this.n = (CJRInputFieldsItem) aVar.f60877c;
                    CJRInputFieldsItem cJRInputFieldsItem = this.n;
                    if (cJRInputFieldsItem != null && cJRInputFieldsItem.isShowPhoneBook()) {
                        C();
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            cJRMobileInputFieldWidgetV8.setTransitionName(getString(R.string.transition_name_input_field_with_action));
        }
        ((AppBarLayout) b(R.id.appbar_layout)).addView(cJRInputFieldWithActionWidgetV8);
        ViewGroup.LayoutParams layoutParams = cJRMobileInputFieldWidgetV8.getLayoutParams();
        if (layoutParams != null) {
            ((AppBarLayout.LayoutParams) layoutParams).setMargins(com.paytm.utility.b.c(21), 0, com.paytm.utility.b.c(21), 0);
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    public final void C() {
        LiveData liveData;
        if (this.t == null) {
            this.t = new g(this);
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (!(aVar == null || (liveData = aVar.K) == null)) {
            q qVar = this;
            z<Boolean> zVar = this.t;
            if (zVar == null) {
                k.a();
            }
            liveData.observe(qVar, zVar);
        }
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        ViewGroup.LayoutParams layoutParams = null;
        ImageView actionPrimaryIcon = cJRInputFieldWithActionWidgetV8 != null ? cJRInputFieldWithActionWidgetV8.getActionPrimaryIcon() : null;
        if (actionPrimaryIcon != null) {
            layoutParams = actionPrimaryIcon.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = com.paytm.utility.b.c(18);
        }
        if (layoutParams != null) {
            layoutParams.height = com.paytm.utility.b.c(17);
        }
        if (actionPrimaryIcon != null) {
            actionPrimaryIcon.setLayoutParams(layoutParams);
        }
    }

    public boolean a(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        Object obj;
        if (i2 == 100) {
            int i4 = -1;
            if (i3 == -1) {
                n nVar = n.f61679a;
                List<ContactItemModel> a2 = n.a((Context) getActivity(), intent);
                if (!(a2 != null ? a2.isEmpty() : true)) {
                    if (a2 == null) {
                        k.a();
                    }
                    ContactItemModel contactItemModel = a2.get(0);
                    if (intent != null) {
                        i4 = intent.getIntExtra("contactPos", -1);
                    }
                    a(contactItemModel, i4, true);
                } else if (getContext() != null) {
                    az azVar = az.f61525a;
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    az.a(context, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CTA_CONTACT, (String) null, getString(R.string.invalid_mobileno_msg), 8);
                }
            } else if (!(i3 != 0 || (aVar = this.f63600h) == null || (dVar = aVar.v) == null)) {
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                if (aVar2 != null) {
                    obj = aVar2.e();
                } else {
                    obj = null;
                }
                Object obj2 = obj;
                if (obj2 == null) {
                    k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "phonebook_back_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        } else if (i2 == 607) {
            if (!super.a(i2, i3, intent)) {
                D();
            }
            return true;
        }
        return super.a(i2, i3, intent);
    }

    public void onResume() {
        super.onResume();
        if (this.s) {
            this.s = false;
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
            if (cJRInputFieldWithActionWidgetV8 != null) {
                cJRInputFieldWithActionWidgetV8.requestFocus();
            }
        }
        E();
    }

    public void E() {
        a((Toolbar) b(R.id.toolbar));
        if (this.u && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((y) activity2).i();
                    this.v = true;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void w() {
        HashMap hashMap = new HashMap(1);
        int i2 = Build.VERSION.SDK_INT;
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((Map<String, ? extends View>) hashMap);
        }
    }

    public void a(String str, String str2) {
        k.c(str, "mobileNumber");
        this.r = true;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(true);
        }
        super.a(str, str2);
    }

    public void a(CharSequence charSequence, int i2, int i3, int i4) {
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null && cJRInputFieldWithActionWidgetV8.f61894e) {
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
            if (cJRInputFieldWithActionWidgetV82 != null) {
                cJRInputFieldWithActionWidgetV82.c(false);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                aVar.n();
            }
        }
    }

    public void F() {
        Filter filter;
        String str;
        String str2;
        CJRFrequentOrder cJRFrequentOrder;
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        Object obj;
        Object e2;
        LiveData liveData;
        CJRFrequentOrder cJRFrequentOrder2;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        Object obj2;
        Object e3;
        LiveData liveData2;
        Filter filter2;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        List list = null;
        String inputText = cJRInputFieldWithActionWidgetV8 != null ? cJRInputFieldWithActionWidgetV8.getInputText() : null;
        CharSequence charSequence = inputText;
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.w) {
                str = "phonebook";
            } else {
                str = this.x ? "contact screen" : "manual entry";
            }
            String str3 = str;
            String str4 = this.p;
            if (!(str4 != null ? str4.equals(inputText) : false)) {
                s sVar = this.f63603f;
                if (!(sVar == null || (filter2 = sVar.getFilter()) == null)) {
                    filter2.filter(charSequence);
                }
                b(inputText, str3);
                if (!this.y) {
                    net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                    if (aVar3 != null) {
                        cJRFrequentOrder2 = aVar3.j();
                    } else {
                        cJRFrequentOrder2 = null;
                    }
                    if (cJRFrequentOrder2 == null) {
                        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                        if (!(aVar4 == null || (liveData2 = aVar4.f61414g) == null)) {
                            list = (List) liveData2.getValue();
                        }
                        if (!(!az.a(inputText, (List<? extends CJRFrequentOrder>) list) || (aVar2 = this.f63600h) == null || (dVar2 = aVar2.v) == null)) {
                            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                            if (aVar5 == null || (e3 = aVar5.e()) == null) {
                                obj2 = "";
                            } else {
                                obj2 = e3;
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, obj2, "repeat_user_entering_mobile_number", (Object) null, str3, (Object) null, (Object) null, (Object) null, 116);
                        }
                    }
                }
            } else {
                if (this.f63601i != null) {
                    if (inputText == null) {
                        k.a();
                    }
                    str2 = net.one97.paytm.recharge.common.b.a.a(inputText);
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (str2 == null) {
                        k.a();
                    }
                    a(str2, str3);
                    if (!this.y) {
                        net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                        if (aVar6 != null) {
                            cJRFrequentOrder = aVar6.j();
                        } else {
                            cJRFrequentOrder = null;
                        }
                        if (cJRFrequentOrder == null) {
                            net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                            if (!(aVar7 == null || (liveData = aVar7.f61414g) == null)) {
                                list = (List) liveData.getValue();
                            }
                            if (!(!az.a(str2, (List<? extends CJRFrequentOrder>) list) || (aVar = this.f63600h) == null || (dVar = aVar.v) == null)) {
                                net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
                                if (aVar8 == null || (e2 = aVar8.e()) == null) {
                                    obj = "";
                                } else {
                                    obj = e2;
                                }
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "repeat_user_entering_mobile_number", (Object) null, str3, (Object) null, (Object) null, (Object) null, 116);
                            }
                        }
                    }
                }
            }
            this.x = false;
            this.w = false;
            return;
        }
        s sVar2 = this.f63603f;
        if (sVar2 != null && (filter = sVar2.getFilter()) != null) {
            filter.filter("");
        }
    }

    public final void a(ContactItemModel contactItemModel, int i2, boolean z2) {
        k.c(contactItemModel, "contact");
        this.p = contactItemModel.getPhnNo();
        if (z2) {
            this.w = true;
            this.x = false;
        } else {
            this.x = true;
            this.w = false;
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        Object obj = null;
        if (aVar != null) {
            aVar.a((CJRProductsItem) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a((CJRFrequentOrder) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            aVar3.C = contactItemModel;
        }
        this.q = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.setInputText("");
        }
        this.q = true;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
        if (cJRInputFieldWithActionWidgetV82 != null) {
            cJRInputFieldWithActionWidgetV82.a(this.p);
        }
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        if (aVar4 != null) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = aVar4.v;
            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
            if (aVar5 != null) {
                obj = aVar5.e();
            }
            Object obj2 = obj;
            if (obj2 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "phonebook_contact_selected", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            if (!TextUtils.isEmpty(com.paytm.utility.b.l(getContext())) && kotlin.m.p.a(this.p, com.paytm.utility.b.l(getContext()), true)) {
                h("default_flow");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "item"
            kotlin.g.b.k.c(r11, r0)
            r10.C = r11
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            if (r0 == 0) goto L_0x001d
            net.one97.paytm.recharge.ordersummary.h.d r1 = r0.v
            java.lang.Object r2 = r0.e()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 124(0x7c, float:1.74E-43)
            java.lang.String r3 = "setup_autopay_clicked"
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x001d:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0082
            net.one97.paytm.recharge.common.utils.e r0 = new net.one97.paytm.recharge.common.utils.e
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            if (r2 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            java.lang.String r3 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = r2
            android.app.Activity r3 = (android.app.Activity) r3
            java.util.Map r2 = r11.getConfiguration()
            if (r2 == 0) goto L_0x004d
            java.lang.String r11 = r11.TAG_RECHARGE_NUMBER
            java.lang.Object r11 = r2.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = r11
            goto L_0x004e
        L_0x004d:
            r4 = r1
        L_0x004e:
            if (r4 != 0) goto L_0x0053
            kotlin.g.b.k.a()
        L_0x0053:
            androidx.fragment.app.j r5 = r10.getChildFragmentManager()
            java.lang.String r11 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x006e
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r11 = r11.f61409b
            if (r11 == 0) goto L_0x006e
            net.one97.paytm.recharge.model.v4.CJRCategoryData r11 = r11.getCategoryData()
            if (r11 == 0) goto L_0x006e
            java.lang.Long r1 = r11.getCategoryId()
        L_0x006e:
            r6 = r1
            r7 = r10
            net.one97.paytm.recharge.common.utils.e$a r7 = (net.one97.paytm.recharge.common.utils.e.a) r7
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r10.B = r0
            net.one97.paytm.recharge.common.utils.e r11 = r10.B
            if (r11 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            r11.f61622g = r12
            return
        L_0x0082:
            android.content.Context r11 = r10.getContext()
            android.content.Context r12 = r10.getContext()
            if (r12 == 0) goto L_0x0099
            android.content.res.Resources r12 = r12.getResources()
            if (r12 == 0) goto L_0x0099
            int r0 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r12 = r12.getString(r0)
            goto L_0x009a
        L_0x0099:
            r12 = r1
        L_0x009a:
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L_0x00ac
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x00ac
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r0.getString(r1)
        L_0x00ac:
            com.paytm.utility.g.c(r11, r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.e.b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder, int):void");
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2) {
        k.c(cJRFrequentOrder, "item");
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        Bundle bundle = new Bundle();
        bundle.putInt("key_position", i2);
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            if (az.c(activity)) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                az.a((Context) activity2, cJRAutomaticSubscriptionItemModel.getSubscriptionId());
                return;
            }
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a((Fragment) this, cJRFrequentOrder, cJRAutomaticSubscriptionItemModel, bundle);
        }
    }

    public final void c(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        if (getActivity() instanceof y) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).j();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
        this.p = cJRFrequentOrder.getRechargeNumber();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a((CJRProductsItem) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a(cJRFrequentOrder);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            aVar3.C = null;
        }
        this.q = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.setInputText("");
        }
        this.q = true;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
        if (cJRInputFieldWithActionWidgetV82 != null) {
            cJRInputFieldWithActionWidgetV82.a(this.p);
        }
        f("default_flow");
    }

    public final void b_(String str) {
        super.b_(str);
        this.p = str;
        this.q = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.setInputText("");
        }
        this.q = true;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
        if (cJRInputFieldWithActionWidgetV82 != null) {
            cJRInputFieldWithActionWidgetV82.a(str);
        }
    }

    public final void as_() {
        super.as_();
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (net.one97.paytm.recharge.common.utils.g.c(cJRInputFieldWithActionWidgetV8 != null ? cJRInputFieldWithActionWidgetV8.getInputText() : null)) {
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
            if (cJRInputFieldWithActionWidgetV82 == null) {
                k.a();
            }
            a(cJRInputFieldWithActionWidgetV82.getInputText(), "manual entry");
        }
    }

    public final void g() {
        if (this.u && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).g();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public final void h() {
        if (this.u && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).h();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void onClick(View view) {
        if (view != null) {
            Integer.valueOf(view.getId());
        }
    }

    public void l() {
        super.l();
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
    }

    public void a(String str, NetworkCustomError networkCustomError, Object obj) {
        Fragment c2;
        if (getActivity() != null && isAdded()) {
            if (networkCustomError instanceof aq) {
                net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
                if (dVar != null && (c2 = dVar.c()) != null) {
                    if (c2 instanceof j) {
                        j jVar = (j) c2;
                        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = jVar.o;
                        if (cJRInputFieldWithActionWidgetV8 != null) {
                            cJRInputFieldWithActionWidgetV8.c(false);
                        }
                        jVar.e("");
                    } else if (c2 instanceof e) {
                        e eVar = (e) c2;
                        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = eVar.o;
                        if (cJRInputFieldWithActionWidgetV82 != null) {
                            cJRInputFieldWithActionWidgetV82.c(false);
                        }
                        eVar.e("");
                    }
                }
            } else {
                super.a(str, networkCustomError, obj);
            }
        }
    }

    public void onStop() {
        Boolean bool;
        LiveData liveData;
        super.onStop();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData = aVar.H) == null || (bool = (Boolean) liveData.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        if (k.a((Object) bool, (Object) Boolean.FALSE) && this.o != null) {
            FragmentActivity activity = getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
                if (cJRInputFieldWithActionWidgetV8 == null) {
                    k.a();
                }
                inputMethodManager.hideSoftInputFromWindow(cJRInputFieldWithActionWidgetV8.getWindowToken(), 0);
            }
        }
    }

    public void onDestroyView() {
        j();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.n();
        }
        if (this.u && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                y yVar = (y) activity;
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    yVar.b(activity2.getResources().getString(R.string.recharge_tabs_toolbar_title));
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        ((y) activity3).az_();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.content.Context");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
        super.onDestroyView();
        u();
    }

    public void aq_() {
        net.one97.paytm.recharge.common.utils.e eVar;
        String str;
        int i2;
        String rechargeNumber;
        if (this.C != null && (eVar = this.B) != null && (str = eVar.f61619d) != null) {
            CJRFrequentOrder cJRFrequentOrder = this.C;
            if (kotlin.m.p.a(str, cJRFrequentOrder != null ? cJRFrequentOrder.getRechargeNumber() : null, true) && this.f63600h != null) {
                Bundle bundle = new Bundle();
                net.one97.paytm.recharge.common.utils.e eVar2 = this.B;
                if (eVar2 != null) {
                    i2 = eVar2.f61622g;
                } else {
                    i2 = -1;
                }
                bundle.putInt("key_position", i2);
                if (getActivity() != null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    if (az.c(activity)) {
                        CJRFrequentOrder cJRFrequentOrder2 = this.C;
                        if (cJRFrequentOrder2 != null && (rechargeNumber = cJRFrequentOrder2.getRechargeNumber()) != null) {
                            FragmentActivity activity2 = getActivity();
                            if (activity2 == null) {
                                k.a();
                            }
                            k.a((Object) activity2, "activity!!");
                            az.g(activity2, rechargeNumber);
                            return;
                        }
                        return;
                    }
                }
                net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                if (aVar == null) {
                    k.a();
                }
                Fragment fragment = this;
                CJRFrequentOrder cJRFrequentOrder3 = this.C;
                if (cJRFrequentOrder3 == null) {
                    k.a();
                }
                aVar.a(fragment, cJRFrequentOrder3, bundle);
            }
        }
    }

    public void onPause() {
        boolean z2;
        if (!this.u || !(getParentFragment() instanceof i)) {
            z2 = true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                z2 = ((i) parentFragment).f63651a;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile.fragment.FJRMobileLandingFragment");
            }
        }
        if (z2) {
            j();
        }
        super.onPause();
    }

    public void i(String str) {
        if (str == null) {
            str = "via_edit";
        }
        super.i(str);
    }

    public final void B() {
        LiveData<List<ContactItemModel>> liveData;
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            if (androidx.core.content.b.a((Context) activity, "android.permission.READ_CONTACTS") != 0) {
                net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                if (aVar != null) {
                    aVar.a(false);
                    return;
                }
                return;
            }
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a(true);
        }
        if (this.f63600h != null) {
            androidx.loader.a.a a2 = androidx.loader.a.a.a(this);
            k.a((Object) a2, "LoaderManager.getInstanc…erMobileNumberFragmentV8)");
            liveData = net.one97.paytm.recharge.mobile.d.a.a(a2);
        } else {
            liveData = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new c(this));
    }

    /* access modifiers changed from: protected */
    public void v() {
        LiveData liveData;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            liveData = aVar.f61414g;
        } else {
            liveData = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new b(this));
    }

    public void D() {
        j g2;
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (!(dVar == null || (g2 = dVar.g()) == null)) {
            g2.d();
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.DELETE_RECENT.name());
            }
            aVar.a("delete_recents", cJRFrequentOrder, (Object) a2);
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "clear_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }

    public final void f() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }

    public final void e() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "phonebook_back_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }
}
