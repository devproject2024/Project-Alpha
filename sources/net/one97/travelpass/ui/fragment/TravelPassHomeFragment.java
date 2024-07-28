package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.utils.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.travelpass.R;
import net.one97.travelpass.b.g;
import net.one97.travelpass.b.y;
import net.one97.travelpass.d;
import net.one97.travelpass.e.b;
import net.one97.travelpass.e.h;
import net.one97.travelpass.g.a;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.ui.MyPassesActivity;
import net.one97.travelpass.ui.TravelPassAboutActivity;
import net.one97.travelpass.ui.TravelPassDetailsActivity;
import net.one97.travelpass.ui.c.j;

public final class TravelPassHomeFragment extends g implements com.one97.travelpass.a.c, com.travel.common.a.b {
    private HashMap _$_findViewCache;
    private g binding;
    private String deeplinkUrl;
    private TextView emptyHeader;
    private ImageView emptyImage;
    private ViewGroup emptyImageContainer;
    private TextView emptySubtitle;
    public net.one97.travelpass.a.c recyclerAdapter;
    private String selectedType = "";
    private TravelPass travelPass;
    private h travelPassHomeAdapterHelper = new h();
    private net.one97.travelpass.g.a travelPassViewModel;
    private ArrayList<j> viewHolderList = new ArrayList<>();

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onVisibilityGone() {
    }

    public final void onVisibleToUser(boolean z) {
    }

    static final class b<T> implements z<TravelPass> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelPassHomeFragment f30671a;

        b(TravelPassHomeFragment travelPassHomeFragment) {
            this.f30671a = travelPassHomeFragment;
        }

        /* JADX WARNING: Removed duplicated region for block: B:74:0x0135  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r10) {
            /*
                r9 = this;
                net.one97.travelpass.model.TravelPass r10 = (net.one97.travelpass.model.TravelPass) r10
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto L_0x001f
                net.one97.travelpass.e.b$a r0 = net.one97.travelpass.e.b.f30322a
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                android.content.Context r0 = r0.getContext()
                if (r0 != 0) goto L_0x0017
                kotlin.g.b.k.a()
            L_0x0017:
                java.lang.String r1 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.travelpass.e.b.a.d(r0)
            L_0x001f:
                if (r10 == 0) goto L_0x013a
                net.one97.travelpass.model.TravelPassData r0 = r10.getBody()
                r1 = 0
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r0.getStatus()
                goto L_0x002e
            L_0x002d:
                r0 = r1
            L_0x002e:
                r2 = 1
                if (r0 == 0) goto L_0x0068
                net.one97.travelpass.model.TravelPassData r0 = r10.getBody()
                if (r0 == 0) goto L_0x0048
                java.lang.String r0 = r0.getStatus()
                if (r0 == 0) goto L_0x0048
                java.lang.String r3 = "failure"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x0049
            L_0x0048:
                r0 = r1
            L_0x0049:
                if (r0 != 0) goto L_0x004e
                kotlin.g.b.k.a()
            L_0x004e:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0068
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r3 = r9.f30671a
                r4 = 0
                r5 = r10
                com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
                r6 = 0
                r7 = 5
                r8 = 0
                kotlin.o r10 = net.one97.travelpass.ui.fragment.g.processErrorState$default(r3, r4, r5, r6, r7, r8)
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                r0.setErrorEmptyView(r10)
                goto L_0x013a
            L_0x0068:
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                r0.setTravelPass(r10)
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                boolean r0 = r0.isNoPassState()
                r3 = 2
                if (r0 == 0) goto L_0x0082
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment.refreshListWithVerticaltype$default(r0, r1, r1, r3, r1)
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                r0.setComingSoonEmptyView(r10)
                goto L_0x013a
            L_0x0082:
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r0 = r9.f30671a
                r0.getTravelPassHomeAdapterHelper()
                if (r10 == 0) goto L_0x0094
                net.one97.travelpass.model.TravelPassData r4 = r10.getBody()
                if (r4 == 0) goto L_0x0094
                java.util.List r4 = r4.getVerticalPassesData()
                goto L_0x0095
            L_0x0094:
                r4 = r1
            L_0x0095:
                java.util.Collection r4 = (java.util.Collection) r4
                r5 = 0
                if (r4 == 0) goto L_0x00a3
                boolean r4 = r4.isEmpty()
                if (r4 == 0) goto L_0x00a1
                goto L_0x00a3
            L_0x00a1:
                r4 = 0
                goto L_0x00a4
            L_0x00a3:
                r4 = 1
            L_0x00a4:
                if (r4 != 0) goto L_0x00f4
                if (r10 == 0) goto L_0x00c1
                net.one97.travelpass.model.TravelPassData r4 = r10.getBody()
                if (r4 == 0) goto L_0x00c1
                java.util.List r4 = r4.getVerticalPassesData()
                if (r4 == 0) goto L_0x00c1
                java.lang.Object r4 = r4.get(r5)
                net.one97.travelpass.model.VerticalPassesData r4 = (net.one97.travelpass.model.VerticalPassesData) r4
                if (r4 == 0) goto L_0x00c1
                java.lang.String r4 = r4.getVerticalType()
                goto L_0x00c2
            L_0x00c1:
                r4 = r1
            L_0x00c2:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x00cf
                int r4 = r4.length()
                if (r4 != 0) goto L_0x00cd
                goto L_0x00cf
            L_0x00cd:
                r4 = 0
                goto L_0x00d0
            L_0x00cf:
                r4 = 1
            L_0x00d0:
                if (r4 != 0) goto L_0x00f4
                if (r10 == 0) goto L_0x00ed
                net.one97.travelpass.model.TravelPassData r10 = r10.getBody()
                if (r10 == 0) goto L_0x00ed
                java.util.List r10 = r10.getVerticalPassesData()
                if (r10 == 0) goto L_0x00ed
                java.lang.Object r10 = r10.get(r5)
                net.one97.travelpass.model.VerticalPassesData r10 = (net.one97.travelpass.model.VerticalPassesData) r10
                if (r10 == 0) goto L_0x00ed
                java.lang.String r10 = r10.getVerticalType()
                goto L_0x00ee
            L_0x00ed:
                r10 = r1
            L_0x00ee:
                if (r10 != 0) goto L_0x010e
                kotlin.g.b.k.a()
                goto L_0x010e
            L_0x00f4:
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.lang.String r4 = "Bus"
                r10.add(r4)
                java.lang.String r4 = "Flights"
                r10.add(r4)
                java.lang.Object r10 = r10.get(r5)
                java.lang.String r4 = "getDefaultVerticalTypeList().get(0)"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
                java.lang.String r10 = (java.lang.String) r10
            L_0x010e:
                r0.setSelectedType(r10)
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r10 = r9.f30671a
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment.refreshListWithVerticaltype$default(r10, r1, r1, r3, r1)
                net.one97.travelpass.e.d$a r10 = net.one97.travelpass.e.d.f30331a
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r10 = r9.f30671a
                java.lang.String r10 = r10.getSelectedType()
                net.one97.travelpass.e.d.a.a(r10)
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r10 = r9.f30671a
                java.lang.String r10 = r10.getDeeplinkUrl()
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                if (r10 == 0) goto L_0x0133
                int r10 = r10.length()
                if (r10 != 0) goto L_0x0132
                goto L_0x0133
            L_0x0132:
                r2 = 0
            L_0x0133:
                if (r2 != 0) goto L_0x013a
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r10 = r9.f30671a
                r10.handleDeepLink()
            L_0x013a:
                net.one97.travelpass.ui.fragment.TravelPassHomeFragment r10 = r9.f30671a
                r10.hideProgressbar()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TravelPassHomeFragment.b.onChanged(java.lang.Object):void");
        }
    }

    static final class c<T> implements z<net.one97.travelpass.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelPassHomeFragment f30672a;

        c(TravelPassHomeFragment travelPassHomeFragment) {
            this.f30672a = travelPassHomeFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num;
            net.one97.travelpass.e.a aVar = (net.one97.travelpass.e.a) obj;
            this.f30672a.hideProgressbar();
            TravelPassHomeFragment travelPassHomeFragment = this.f30672a;
            NetworkCustomError networkCustomError = null;
            if (aVar != null) {
                num = Integer.valueOf(aVar.f30319a);
            } else {
                num = null;
            }
            IJRPaytmDataModel iJRPaytmDataModel = aVar != null ? aVar.f30320b : null;
            if (aVar != null) {
                networkCustomError = aVar.f30321c;
            }
            this.f30672a.setErrorEmptyView(travelPassHomeFragment.processErrorState(num, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final h getTravelPassHomeAdapterHelper() {
        return this.travelPassHomeAdapterHelper;
    }

    public final void setTravelPass(TravelPass travelPass2) {
        this.travelPass = travelPass2;
    }

    public final String getSelectedType() {
        return this.selectedType;
    }

    public final void setSelectedType(String str) {
        k.c(str, "<set-?>");
        this.selectedType = str;
    }

    public final String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        q.a(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.binding = (g) f.a(layoutInflater, R.layout.fragment_travel_pass_home, viewGroup, false);
        g gVar = this.binding;
        if (gVar != null) {
            return gVar.getRoot();
        }
        return null;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        initViewModel();
        initBundleData();
        initView();
        setObservers();
        prepareTravelPassData();
        super.onViewCreated(view, bundle);
    }

    private final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        initImageViewContainer();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        g gVar = this.binding;
        if (!(gVar == null || (recyclerView2 = gVar.f30240d) == null)) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        if (this.viewHolderList != null) {
            this.recyclerAdapter = new net.one97.travelpass.a.c(getActivity(), this.viewHolderList, this);
            g gVar2 = this.binding;
            if (gVar2 != null && (recyclerView = gVar2.f30240d) != null) {
                net.one97.travelpass.a.c cVar = this.recyclerAdapter;
                if (cVar == null) {
                    k.a("recyclerAdapter");
                }
                recyclerView.setAdapter(cVar);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.f30237a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initImageViewContainer() {
        /*
            r3 = this;
            net.one97.travelpass.b.g r0 = r3.binding
            r1 = 0
            if (r0 == 0) goto L_0x0012
            android.view.View r0 = r0.f30237a
            if (r0 == 0) goto L_0x0012
            int r2 = net.one97.travelpass.R.id.empty_image_view
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            r3.emptyImageContainer = r0
            net.one97.travelpass.b.g r0 = r3.binding
            if (r0 == 0) goto L_0x0026
            android.view.View r0 = r0.f30237a
            if (r0 == 0) goto L_0x0026
            int r2 = net.one97.travelpass.R.id.empty_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            r3.emptyImage = r0
            net.one97.travelpass.b.g r0 = r3.binding
            if (r0 == 0) goto L_0x003a
            android.view.View r0 = r0.f30237a
            if (r0 == 0) goto L_0x003a
            int r2 = net.one97.travelpass.R.id.empty_header
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r3.emptyHeader = r0
            net.one97.travelpass.b.g r0 = r3.binding
            if (r0 == 0) goto L_0x004e
            android.view.View r0 = r0.f30237a
            if (r0 == 0) goto L_0x004e
            int r1 = net.one97.travelpass.R.id.empty_subtitle
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x004e:
            r3.emptySubtitle = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TravelPassHomeFragment.initImageViewContainer():void");
    }

    private final void refreshList() {
        net.one97.travelpass.a.c cVar = this.recyclerAdapter;
        if (cVar == null) {
            k.a("recyclerAdapter");
        }
        if (cVar != null && this.viewHolderList != null) {
            net.one97.travelpass.a.c cVar2 = this.recyclerAdapter;
            if (cVar2 == null) {
                k.a("recyclerAdapter");
            }
            cVar2.a(this.viewHolderList);
            net.one97.travelpass.a.c cVar3 = this.recyclerAdapter;
            if (cVar3 == null) {
                k.a("recyclerAdapter");
            }
            cVar3.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void refreshListWithVerticaltype$default(TravelPassHomeFragment travelPassHomeFragment, String str, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        travelPassHomeFragment.refreshListWithVerticaltype(str, list);
    }

    private final void refreshListWithVerticaltype(String str, List<Integer> list) {
        this.viewHolderList = populateViewHolderList$default(this, this.travelPass, str, 0, 4, (Object) null);
        refreshList();
    }

    private final void setObservers() {
        LiveData liveData;
        LiveData liveData2;
        net.one97.travelpass.g.a aVar = this.travelPassViewModel;
        if (!(aVar == null || (liveData2 = aVar.f30473c) == null)) {
            liveData2.observe(getViewLifecycleOwner(), new b(this));
        }
        net.one97.travelpass.g.a aVar2 = this.travelPassViewModel;
        if (aVar2 != null && (liveData = aVar2.f30474d) != null) {
            liveData.observe(getViewLifecycleOwner(), new c(this));
        }
    }

    private final void initBundleData() {
        Bundle arguments = getArguments();
        this.deeplinkUrl = arguments != null ? arguments.getString("deepLinkUrl") : null;
    }

    static /* synthetic */ ArrayList populateViewHolderList$default(TravelPassHomeFragment travelPassHomeFragment, TravelPass travelPass2, String str, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        return travelPassHomeFragment.populateViewHolderList(travelPass2, str, i2);
    }

    private final void initViewModel() {
        this.travelPassViewModel = (net.one97.travelpass.g.a) am.a((Fragment) this).a(net.one97.travelpass.g.a.class);
    }

    public final void prepareTravelPassData() {
        if (getContext() == null || com.paytm.utility.b.c(getContext())) {
            removeEmptyView();
            startProgressbar();
            loadTravelPassData();
            return;
        }
        setNetworkEmptyView();
    }

    public final void startProgressbar() {
        ProgressBar progressBar;
        g gVar = this.binding;
        if (gVar != null && (progressBar = gVar.f30239c) != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void hideProgressbar() {
        ProgressBar progressBar;
        g gVar = this.binding;
        if (gVar != null && (progressBar = gVar.f30239c) != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void loadTravelPassData() {
        Context context;
        com.paytm.network.b bVar;
        if (getContext() != null) {
            b.a aVar = net.one97.travelpass.e.b.f30322a;
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            k.c(context2, "context");
            b.a.a(context2, net.one97.travelpass.e.b.f30329h, net.one97.travelpass.e.b.w, (String) null, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30324c, (String) null, 376);
        }
        net.one97.travelpass.g.a aVar2 = this.travelPassViewModel;
        if (aVar2 != null && (context = getContext()) != null && aVar2.f30476f != null) {
            com.paytm.network.listener.b eVar = new a.e(aVar2);
            k.c(context, "context");
            k.c(eVar, "paytmCommonApiListener");
            k.a((Object) d.a(), "TravelPassController.getInstance()");
            String a2 = d.b().a("tpassLandingPage");
            if (TextUtils.isEmpty(a2) || context == null) {
                bVar = null;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.putAll(net.one97.travelpass.d.a.a(context));
                bVar = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.b.SILENT).c("travel_pass_home").a(a.C0715a.GET).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new TravelPass()).a(eVar);
            }
            if (bVar != null) {
                com.paytm.network.a l = bVar.l();
                if (l != null) {
                    l.b(true);
                }
                if (l != null) {
                    l.a();
                    return;
                }
                return;
            }
            eVar.handleErrorCode(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onItemClickedItem(net.one97.travelpass.ui.c.j r17, java.lang.Integer r18, java.lang.Integer r19) {
        /*
            r16 = this;
            r0 = r16
            if (r17 == 0) goto L_0x0264
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM
            r3 = 0
            if (r1 != r2) goto L_0x007d
            com.paytm.network.model.IJRPaytmDataModel r1 = r17.b()
            if (r1 == 0) goto L_0x0075
            net.one97.travelpass.model.VerticalData r1 = (net.one97.travelpass.model.VerticalData) r1
            java.lang.String r2 = r1.getType()
            java.lang.String r4 = "selectedVertical.type"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            r0.selectedType = r2
            java.lang.String r1 = r1.getType()
            net.one97.travelpass.e.h r2 = r0.travelPassHomeAdapterHelper
            if (r2 == 0) goto L_0x006a
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r2 = r0.viewHolderList
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = 0
            if (r4 == 0) goto L_0x0039
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r4 = 0
            goto L_0x003a
        L_0x0039:
            r4 = 1
        L_0x003a:
            if (r4 != 0) goto L_0x006a
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            int r4 = kotlin.a.k.a(r4)
            if (r4 < 0) goto L_0x0068
        L_0x004a:
            java.lang.Object r6 = r2.get(r5)
            net.one97.travelpass.ui.c.j r6 = (net.one97.travelpass.ui.c.j) r6
            net.one97.travelpass.ui.b.b r6 = r6.c()
            net.one97.travelpass.ui.b.b r7 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TABS
            if (r6 == r7) goto L_0x0063
            net.one97.travelpass.ui.b.b r7 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_TAB_ITEM
            if (r6 == r7) goto L_0x0063
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r3.add(r6)
        L_0x0063:
            if (r5 == r4) goto L_0x0068
            int r5 = r5 + 1
            goto L_0x004a
        L_0x0068:
            java.util.List r3 = (java.util.List) r3
        L_0x006a:
            r0.refreshListWithVerticaltype(r1, r3)
            net.one97.travelpass.e.d$a r1 = net.one97.travelpass.e.d.f30331a
            java.lang.String r1 = r0.selectedType
            net.one97.travelpass.e.d.a.a(r1)
            return
        L_0x0075:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.travelpass.model.VerticalData"
            r1.<init>(r2)
            throw r1
        L_0x007d:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_CAROUSEL_ITEM
            java.lang.String r4 = "context"
            java.lang.String r5 = "context!!"
            if (r1 != r2) goto L_0x0134
            if (r18 != 0) goto L_0x008c
            goto L_0x0093
        L_0x008c:
            int r1 = r18.intValue()
            r2 = -1
            if (r1 == r2) goto L_0x0264
        L_0x0093:
            com.paytm.network.model.IJRPaytmDataModel r1 = r17.b()
            boolean r2 = r1 instanceof net.one97.travelpass.model.PassData
            if (r2 != 0) goto L_0x009c
            r1 = r3
        L_0x009c:
            net.one97.travelpass.model.PassData r1 = (net.one97.travelpass.model.PassData) r1
            net.one97.travelpass.ui.a r2 = net.one97.travelpass.ui.a.f30575a
            int r2 = net.one97.travelpass.ui.a.c()
            if (r19 != 0) goto L_0x00a7
            goto L_0x00cf
        L_0x00a7:
            int r6 = r19.intValue()
            if (r6 != r2) goto L_0x00cf
            net.one97.travelpass.e.d$a r2 = net.one97.travelpass.e.d.f30331a
            r8 = 0
            r9 = 0
            r10 = 112(0x70, float:1.57E-43)
            java.lang.String r4 = "custom-event"
            java.lang.String r5 = "/travel-pass/home"
            java.lang.String r6 = "travel_pass_home"
            java.lang.String r7 = "passimage_scrolled"
            net.one97.travelpass.e.d.a.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (int) r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "------- Pass Id : "
            r2.<init>(r4)
            if (r1 == 0) goto L_0x00cb
            java.lang.String r3 = r1.getTravelPassId()
        L_0x00cb:
            r2.append(r3)
            return
        L_0x00cf:
            net.one97.travelpass.ui.a r2 = net.one97.travelpass.ui.a.f30575a
            int r2 = net.one97.travelpass.ui.a.b()
            if (r19 != 0) goto L_0x00d8
            return
        L_0x00d8:
            int r6 = r19.intValue()
            if (r6 != r2) goto L_0x0133
            android.content.Context r2 = r16.getContext()
            if (r2 == 0) goto L_0x0128
            if (r1 == 0) goto L_0x00eb
            java.lang.String r2 = r1.getTravelPassId()
            goto L_0x00ec
        L_0x00eb:
            r2 = r3
        L_0x00ec:
            if (r2 == 0) goto L_0x0128
            net.one97.travelpass.e.b$a r2 = net.one97.travelpass.e.b.f30322a
            android.content.Context r6 = r16.getContext()
            if (r6 != 0) goto L_0x00f9
            kotlin.g.b.k.a()
        L_0x00f9:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            java.lang.String r9 = r0.selectedType
            java.lang.String r10 = r1.getTravelPassId()
            if (r10 != 0) goto L_0x0107
            kotlin.g.b.k.a()
        L_0x0107:
            kotlin.g.b.k.c(r6, r4)
            java.lang.String r2 = "passCategory"
            kotlin.g.b.k.c(r9, r2)
            java.lang.String r2 = "passId"
            kotlin.g.b.k.c(r10, r2)
            java.lang.String r7 = net.one97.travelpass.e.b.f30329h
            java.lang.String r8 = net.one97.travelpass.e.b.n
            r11 = 0
            r12 = 0
            java.lang.String r13 = net.one97.travelpass.e.b.f30324c
            r14 = 0
            r15 = 352(0x160, float:4.93E-43)
            net.one97.travelpass.e.b.a.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x0128:
            java.lang.String r2 = r0.selectedType
            if (r1 == 0) goto L_0x0130
            java.lang.String r3 = r1.getTravelPassId()
        L_0x0130:
            r0.startDetailsActivity(r2, r3)
        L_0x0133:
            return
        L_0x0134:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_INFO
            if (r1 != r2) goto L_0x016d
            android.content.Context r1 = r16.getContext()
            if (r1 == 0) goto L_0x0169
            net.one97.travelpass.e.b$a r1 = net.one97.travelpass.e.b.f30322a
            android.content.Context r6 = r16.getContext()
            if (r6 != 0) goto L_0x014d
            kotlin.g.b.k.a()
        L_0x014d:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.c(r6, r4)
            java.lang.String r7 = net.one97.travelpass.e.b.f30329h
            java.lang.String r8 = net.one97.travelpass.e.b.m
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r13 = net.one97.travelpass.e.b.f30324c
            r14 = 0
            r15 = 376(0x178, float:5.27E-43)
            net.one97.travelpass.e.b.a.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x0169:
            r16.startAboutActivity()
            return
        L_0x016d:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_ABOUT_INFO
            if (r1 != r2) goto L_0x0179
            r16.startAboutActivity()
            return
        L_0x0179:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_USER_INFO
            if (r1 != r2) goto L_0x01b2
            android.content.Context r1 = r16.getContext()
            if (r1 == 0) goto L_0x01ae
            net.one97.travelpass.e.b$a r1 = net.one97.travelpass.e.b.f30322a
            android.content.Context r6 = r16.getContext()
            if (r6 != 0) goto L_0x0192
            kotlin.g.b.k.a()
        L_0x0192:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.c(r6, r4)
            java.lang.String r7 = net.one97.travelpass.e.b.k
            java.lang.String r8 = net.one97.travelpass.e.b.s
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r13 = net.one97.travelpass.e.b.f30327f
            r14 = 0
            r15 = 376(0x178, float:5.27E-43)
            net.one97.travelpass.e.b.a.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x01ae:
            r0.startMyPassesActivity(r3)
            return
        L_0x01b2:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS_ITEM
            if (r1 != r2) goto L_0x021b
            net.one97.travelpass.ui.a r1 = net.one97.travelpass.ui.a.f30575a
            int r1 = net.one97.travelpass.ui.a.c()
            if (r19 != 0) goto L_0x01c3
            goto L_0x01db
        L_0x01c3:
            int r2 = r19.intValue()
            if (r2 != r1) goto L_0x01db
            net.one97.travelpass.e.d$a r1 = net.one97.travelpass.e.d.f30331a
            r6 = 0
            r7 = 0
            r8 = 112(0x70, float:1.57E-43)
            java.lang.String r2 = "custom-event"
            java.lang.String r3 = "/travel-pass/home"
            java.lang.String r4 = "travel_pass_home"
            java.lang.String r5 = "offer_scrolled"
            net.one97.travelpass.e.d.a.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (int) r8)
            return
        L_0x01db:
            net.one97.travelpass.ui.a r1 = net.one97.travelpass.ui.a.f30575a
            int r1 = net.one97.travelpass.ui.a.b()
            if (r19 != 0) goto L_0x01e4
            return
        L_0x01e4:
            int r2 = r19.intValue()
            if (r2 != r1) goto L_0x021a
            com.paytm.network.model.IJRPaytmDataModel r1 = r17.b()
            boolean r2 = r1 instanceof net.one97.travelpass.model.PartnersOfferData
            if (r2 != 0) goto L_0x01f3
            r1 = r3
        L_0x01f3:
            net.one97.travelpass.model.PartnersOfferData r1 = (net.one97.travelpass.model.PartnersOfferData) r1
            android.content.Context r2 = r16.getContext()
            if (r2 == 0) goto L_0x0217
            if (r1 == 0) goto L_0x0217
            net.one97.travelpass.e.b$a r2 = net.one97.travelpass.e.b.f30322a
            android.content.Context r2 = r16.getContext()
            if (r2 != 0) goto L_0x0208
            kotlin.g.b.k.a()
        L_0x0208:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.String r1 = r1.getPartnerOfferId()
            java.lang.String r3 = "partnerOfferData.partnerOfferId"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.travelpass.e.b.a.a(r2, r1)
        L_0x0217:
            r16.handleOfferTncClickEvent(r17)
        L_0x021a:
            return
        L_0x021b:
            net.one97.travelpass.ui.b.b r1 = r17.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS_ITEM
            if (r1 != r2) goto L_0x0264
            com.paytm.network.model.IJRPaytmDataModel r1 = r17.b()
            boolean r2 = r1 instanceof net.one97.travelpass.model.InternalOfferData
            if (r2 != 0) goto L_0x022c
            r1 = r3
        L_0x022c:
            net.one97.travelpass.model.InternalOfferData r1 = (net.one97.travelpass.model.InternalOfferData) r1
            android.content.Context r2 = r16.getContext()
            if (r2 == 0) goto L_0x0250
            if (r1 == 0) goto L_0x0250
            net.one97.travelpass.e.b$a r2 = net.one97.travelpass.e.b.f30322a
            android.content.Context r2 = r16.getContext()
            if (r2 != 0) goto L_0x0241
            kotlin.g.b.k.a()
        L_0x0241:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.String r1 = r1.getInternalOfferId()
            java.lang.String r3 = "internalOfferData.internalOfferId"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.travelpass.e.b.a.a(r2, r1)
        L_0x0250:
            net.one97.travelpass.e.d$a r1 = net.one97.travelpass.e.d.f30331a
            r6 = 0
            r7 = 0
            r8 = 112(0x70, float:1.57E-43)
            java.lang.String r2 = "custom-event"
            java.lang.String r3 = "/travel-pass/home"
            java.lang.String r4 = "travel_pass_home"
            java.lang.String r5 = "internaloffer_clicked"
            net.one97.travelpass.e.d.a.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (int) r8)
            r16.handleInternalOfferTncClickEvent(r17)
        L_0x0264:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TravelPassHomeFragment.onItemClickedItem(net.one97.travelpass.ui.c.j, java.lang.Integer, java.lang.Integer):void");
    }

    public final void handleInternalOfferTncClickEvent(j jVar) {
        IJRPaytmDataModel b2 = jVar != null ? jVar.b() : null;
        if (!(b2 instanceof InternalOfferData)) {
            b2 = null;
        }
        ArrayList<String> a2 = h.a((InternalOfferData) b2, this.travelPass);
        Collection collection = a2;
        if (!(collection == null || collection.isEmpty())) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("dataList", a2);
            cVar.setArguments(bundle);
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                cVar.show(activity.getSupportFragmentManager(), cVar.getTag());
            }
        }
    }

    public final void handleOfferTncClickEvent(j jVar) {
        IJRPaytmDataModel b2 = jVar != null ? jVar.b() : null;
        if (!(b2 instanceof PartnersOfferData)) {
            b2 = null;
        }
        ArrayList<String> a2 = h.a((PartnersOfferData) b2, this.travelPass);
        Collection collection = a2;
        if (!(collection == null || collection.isEmpty())) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("dataList", a2);
            cVar.setArguments(bundle);
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                cVar.show(activity.getSupportFragmentManager(), cVar.getTag());
            }
        }
    }

    public final void startAboutActivity() {
        Intent intent = new Intent(getActivity(), TravelPassAboutActivity.class);
        intent.putExtra("travelPass", this.travelPass);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    public static /* synthetic */ void startDetailsActivity$default(TravelPassHomeFragment travelPassHomeFragment, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        travelPassHomeFragment.startDetailsActivity(str, str2);
    }

    public final void startDetailsActivity(String str, String str2) {
        Intent intent = new Intent(getActivity(), TravelPassDetailsActivity.class);
        intent.putExtra("verticalType", str);
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            intent.putExtra("passId", str2);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 1002);
        }
    }

    public final void handleDeepLink() {
        String str;
        Uri parse;
        Uri parse2;
        new net.one97.travelpass.e.k();
        String str2 = this.deeplinkUrl;
        if (str2 == null || (parse2 = Uri.parse(p.a(str2, '$', '&'))) == null || parse2 == null) {
            str = null;
        } else {
            str = parse2.getHost();
        }
        new net.one97.travelpass.e.k();
        String str3 = this.deeplinkUrl;
        HashMap hashMap = new HashMap();
        if (str3 == null || (parse = Uri.parse(p.a(str3, '$', '&'))) == null) {
            hashMap = null;
        } else {
            for (String next : parse != null ? parse.getQueryParameterNames() : null) {
                String queryParameter = parse.getQueryParameter(next);
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (queryParameter == null) {
                        k.a();
                    }
                    hashMap.put(next, queryParameter);
                }
            }
        }
        if (str != null && hashMap != null && hashMap.containsKey("scrn")) {
            Object obj = hashMap.get("scrn");
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str4 = (String) obj;
            if (p.a(str4, "about", true)) {
                startAboutActivity();
            } else if (p.a(str4, "myPass", true)) {
                handleMyPassesDeepLink(hashMap);
            } else if (p.a(str4, "passDet", true)) {
                if (getContext() != null) {
                    b.a aVar = net.one97.travelpass.e.b.f30322a;
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    k.c(context, "context");
                    b.a.a(context, net.one97.travelpass.e.b.j, net.one97.travelpass.e.b.y, (String) null, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30326e, (String) null, 376);
                }
                handlePassDetailDeepLink(hashMap);
            }
        }
    }

    public final void handlePassDetailDeepLink(HashMap<String, Object> hashMap) {
        String str;
        Map map = hashMap;
        boolean z = false;
        if (!(map == null || map.isEmpty())) {
            if (hashMap.containsKey(Constants.URL_MEDIA_SOURCE)) {
                Object obj = hashMap.get(Constants.URL_MEDIA_SOURCE);
                if (!(obj instanceof String)) {
                    obj = null;
                }
                str = (String) obj;
            } else {
                str = null;
            }
            o<String, Integer> f2 = this.travelPassHomeAdapterHelper != null ? h.f(this.travelPass, str) : null;
            CharSequence first = f2 != null ? f2.getFirst() : null;
            if (first == null || first.length() == 0) {
                z = true;
            }
            if (z || (f2 != null && f2.getSecond().intValue() == -1)) {
                startDetailsActivity$default(this, this.selectedType, (String) null, 2, (Object) null);
                return;
            }
            if (f2 == null) {
                k.a();
            }
            startDetailsActivity(f2.getFirst(), str);
            return;
        }
        startDetailsActivity$default(this, this.selectedType, (String) null, 2, (Object) null);
    }

    public final void startMyPassesActivity(HashMap<String, Object> hashMap) {
        new net.one97.travelpass.e.k();
        if (net.one97.travelpass.e.k.a((Context) getActivity())) {
            Intent intent = new Intent(getActivity(), MyPassesActivity.class);
            Map map = hashMap;
            if (!(map == null || map.isEmpty())) {
                intent.putExtra("deeplinkParams", hashMap);
            }
            startActivity(intent);
            return;
        }
        startLoginActivity();
    }

    private final void startLoginActivity() {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        k.a((Object) d.a(), "TravelPassController.getInstance()");
        d.b().a(getContext(), intent, 4);
    }

    public final void handleMyPassesDeepLink(HashMap<String, Object> hashMap) {
        startMyPassesActivity(hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r3 = (r3 = r6.getBody()).getMetadata();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setComingSoonEmptyView(net.one97.travelpass.model.TravelPass r6) {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.emptyImageContainer
            if (r0 == 0) goto L_0x0008
            r1 = 0
            r0.setVisibility(r1)
        L_0x0008:
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x005c
            com.paytm.utility.b.b$a r2 = com.paytm.utility.b.b.f43744a
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.paytm.utility.b.b$a$a r2 = com.paytm.utility.b.b.a.a(r0)
            if (r6 == 0) goto L_0x002d
            net.one97.travelpass.model.TravelPassData r3 = r6.getBody()
            if (r3 == 0) goto L_0x002d
            net.one97.travelpass.model.TravelPassMetaData r3 = r3.getMetadata()
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = r3.getNoVisiblePassesImageUrl()
            goto L_0x002e
        L_0x002d:
            r3 = r1
        L_0x002e:
            r2.f43753a = r3
            int r3 = net.one97.travelpass.R.drawable.travelpass_placeholder_default
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r0, (int) r3)
            if (r3 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            java.lang.String r4 = "ContextCompat.getDrawabl…ss_placeholder_default)!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            com.paytm.utility.b.b$a$a r2 = r2.b(r3)
            int r3 = net.one97.travelpass.R.drawable.travelpass_placeholder_default
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r3)
            if (r0 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            com.paytm.utility.b.b$a$a r0 = r2.a((java.lang.Object) r0)
            android.widget.ImageView r2 = r5.emptyImage
            r3 = 2
            com.paytm.utility.b.b.a.C0750a.a(r0, r2, r1, r3)
        L_0x005c:
            android.widget.TextView r0 = r5.emptyHeader
            if (r0 == 0) goto L_0x0079
            if (r6 == 0) goto L_0x0073
            net.one97.travelpass.model.TravelPassData r2 = r6.getBody()
            if (r2 == 0) goto L_0x0073
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0073
            java.lang.String r2 = r2.getNoVisiblePassesHeading()
            goto L_0x0074
        L_0x0073:
            r2 = r1
        L_0x0074:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0079:
            android.widget.TextView r0 = r5.emptySubtitle
            if (r0 == 0) goto L_0x0094
            if (r6 == 0) goto L_0x008f
            net.one97.travelpass.model.TravelPassData r6 = r6.getBody()
            if (r6 == 0) goto L_0x008f
            net.one97.travelpass.model.TravelPassMetaData r6 = r6.getMetadata()
            if (r6 == 0) goto L_0x008f
            java.lang.String r1 = r6.getNoVisiblePassesText()
        L_0x008f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TravelPassHomeFragment.setComingSoonEmptyView(net.one97.travelpass.model.TravelPass):void");
    }

    public final void setNetworkEmptyView() {
        String string = getString(R.string.tp_cant_connect);
        k.a((Object) string, "getString(R.string.tp_cant_connect)");
        String string2 = getString(R.string.tp_check_your_network);
        k.a((Object) string2, "getString(R.string.tp_check_your_network)");
        setEmptyView(string, string2);
    }

    public final void setErrorEmptyView(o<String, String> oVar) {
        k.c(oVar, "errorDetails");
        setEmptyView(oVar.getFirst(), oVar.getSecond());
    }

    public final void setEmptyView(String str, String str2) {
        y yVar;
        Button button;
        y yVar2;
        RoboTextView roboTextView;
        y yVar3;
        RoboTextView roboTextView2;
        y yVar4;
        LinearLayout linearLayout;
        k.c(str, "title");
        k.c(str2, "message");
        g gVar = this.binding;
        if (!(gVar == null || (yVar4 = gVar.f30238b) == null || (linearLayout = yVar4.f30306b) == null)) {
            linearLayout.setVisibility(0);
        }
        g gVar2 = this.binding;
        if (!(gVar2 == null || (yVar3 = gVar2.f30238b) == null || (roboTextView2 = yVar3.f30308d) == null)) {
            roboTextView2.setText(str);
        }
        g gVar3 = this.binding;
        if (!(gVar3 == null || (yVar2 = gVar3.f30238b) == null || (roboTextView = yVar2.f30307c) == null)) {
            roboTextView.setText(str2);
        }
        g gVar4 = this.binding;
        if (gVar4 != null && (yVar = gVar4.f30238b) != null && (button = yVar.f30305a) != null) {
            button.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelPassHomeFragment f30670a;

        a(TravelPassHomeFragment travelPassHomeFragment) {
            this.f30670a = travelPassHomeFragment;
        }

        public final void onClick(View view) {
            this.f30670a.prepareTravelPassData();
        }
    }

    public final void removeEmptyView() {
        y yVar;
        LinearLayout linearLayout;
        g gVar = this.binding;
        if (!(gVar == null || (yVar = gVar.f30238b) == null || (linearLayout = yVar.f30306b) == null)) {
            linearLayout.setVisibility(8);
        }
        ViewGroup viewGroup = this.emptyImageContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean isNoPassState() {
        return h.b(this.travelPass);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 3) {
            prepareTravelPassData();
        } else if (i2 == 1002 && intent != null && intent.hasExtra("travelPass")) {
            Serializable serializableExtra = intent.getSerializableExtra("travelPass");
            if (!(serializableExtra instanceof TravelPass)) {
                serializableExtra = null;
            }
            TravelPass travelPass2 = (TravelPass) serializableExtra;
            if (travelPass2 != null) {
                this.travelPass = travelPass2;
                refreshList();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = r2.getMetadata();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cb, code lost:
        if ((r9.length() == 0) == false) goto L_0x00d7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<net.one97.travelpass.ui.c.j> populateViewHolderList(net.one97.travelpass.model.TravelPass r8, java.lang.String r9, int r10) {
        /*
            r7 = this;
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            net.one97.travelpass.ui.c.j r0 = new net.one97.travelpass.ui.c.j
            r0.<init>()
            r1 = 0
            if (r8 == 0) goto L_0x0080
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x001e
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x001e
            net.one97.travelpass.model.TravelPassMetaData$UserPassInfo r2 = r2.getUserPassInfo()
            goto L_0x001f
        L_0x001e:
            r2 = r1
        L_0x001f:
            if (r2 == 0) goto L_0x007b
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x0038
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0038
            net.one97.travelpass.model.TravelPassMetaData$UserPassInfo r2 = r2.getUserPassInfo()
            if (r2 == 0) goto L_0x0038
            java.lang.Boolean r2 = r2.getTravelPassCustomer()
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            if (r2 == 0) goto L_0x007b
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x0052
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0052
            net.one97.travelpass.model.TravelPassMetaData$UserPassInfo r2 = r2.getUserPassInfo()
            if (r2 == 0) goto L_0x0052
            java.lang.Boolean r2 = r2.getTravelPassCustomer()
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            if (r2 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x007b
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_USER_INFO
            r0.a((net.one97.travelpass.ui.b.b) r2)
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x0074
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0074
            net.one97.travelpass.model.TravelPassMetaData$UserPassInfo r2 = r2.getUserPassInfo()
            goto L_0x0075
        L_0x0074:
            r2 = r1
        L_0x0075:
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            r0.a((com.paytm.network.model.IJRPaytmDataModel) r2)
            goto L_0x0080
        L_0x007b:
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_INFO
            r0.a((net.one97.travelpass.ui.b.b) r2)
        L_0x0080:
            r10.add(r0)
            boolean r2 = net.one97.travelpass.e.h.b((net.one97.travelpass.model.TravelPass) r8)
            if (r2 == 0) goto L_0x0096
            net.one97.travelpass.ui.b.b r8 = r0.c()
            net.one97.travelpass.ui.b.b r9 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_INFO
            if (r8 != r9) goto L_0x020c
            r10.remove(r0)
            goto L_0x020c
        L_0x0096:
            net.one97.travelpass.ui.c.j r2 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r8, (java.lang.String) r9)
            java.util.ArrayList r3 = r2.a()
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x00ad
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r3 = 0
            goto L_0x00ae
        L_0x00ad:
            r3 = 1
        L_0x00ae:
            if (r3 != 0) goto L_0x00bd
            java.util.ArrayList r3 = r2.a()
            int r3 = r3.size()
            if (r3 <= r5) goto L_0x00bd
            r10.add(r2)
        L_0x00bd:
            if (r9 == 0) goto L_0x00ce
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00ca
            r2 = 1
            goto L_0x00cb
        L_0x00ca:
            r2 = 0
        L_0x00cb:
            if (r2 != 0) goto L_0x00ce
            goto L_0x00d7
        L_0x00ce:
            java.lang.String r9 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r8)
            if (r9 != 0) goto L_0x00d7
            kotlin.g.b.k.a()
        L_0x00d7:
            net.one97.travelpass.ui.c.j r9 = net.one97.travelpass.e.h.b((net.one97.travelpass.model.TravelPass) r8, (java.lang.String) r9)
            java.util.ArrayList r2 = r9.a()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x00ec
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00ea
            goto L_0x00ec
        L_0x00ea:
            r2 = 0
            goto L_0x00ed
        L_0x00ec:
            r2 = 1
        L_0x00ed:
            if (r2 != 0) goto L_0x00f2
            r10.add(r9)
        L_0x00f2:
            net.one97.travelpass.ui.b.b r9 = r0.c()
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_INFO
            if (r9 != r2) goto L_0x0109
            net.one97.travelpass.ui.b.b r9 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_INFO
            net.one97.travelpass.ui.c.j r9 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r8, (net.one97.travelpass.ui.b.b) r9)
            com.paytm.network.model.IJRPaytmDataModel r2 = r9.b()
            if (r2 == 0) goto L_0x0109
            r10.add(r9)
        L_0x0109:
            net.one97.travelpass.ui.c.j r9 = new net.one97.travelpass.ui.c.j
            r9.<init>()
            if (r8 == 0) goto L_0x016b
            net.one97.travelpass.ui.b.b r2 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_PARTNER_OFFERS
            r9.a((net.one97.travelpass.ui.b.b) r2)
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x0126
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0126
            java.lang.String r2 = r2.getHomepagePartnerOfferHeading()
            goto L_0x0127
        L_0x0126:
            r2 = r1
        L_0x0127:
            r9.a((java.lang.String) r2)
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x013b
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x013b
            java.lang.String r2 = r2.getSelectedPassesHeading()
            goto L_0x013c
        L_0x013b:
            r2 = r1
        L_0x013c:
            r9.b((java.lang.String) r2)
            if (r8 == 0) goto L_0x0152
            net.one97.travelpass.model.TravelPassData r2 = r8.getBody()
            if (r2 == 0) goto L_0x0152
            net.one97.travelpass.model.TravelPassMetaData r2 = r2.getMetadata()
            if (r2 == 0) goto L_0x0152
            java.util.List r2 = r2.getPartnerOffers()
            goto L_0x0153
        L_0x0152:
            r2 = r1
        L_0x0153:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0161
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            r3 = 0
            goto L_0x0162
        L_0x0161:
            r3 = 1
        L_0x0162:
            if (r3 != 0) goto L_0x016b
            java.util.ArrayList r2 = net.one97.travelpass.e.h.a((java.util.List<? extends net.one97.travelpass.model.PartnersOfferData>) r2)
            r9.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r2)
        L_0x016b:
            java.util.ArrayList r2 = r9.a()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x017c
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x017a
            goto L_0x017c
        L_0x017a:
            r2 = 0
            goto L_0x017d
        L_0x017c:
            r2 = 1
        L_0x017d:
            if (r2 != 0) goto L_0x0182
            r10.add(r9)
        L_0x0182:
            net.one97.travelpass.ui.c.j r2 = new net.one97.travelpass.ui.c.j
            r2.<init>()
            net.one97.travelpass.ui.b.b r3 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_INTERNAL_OFFERS
            r2.a((net.one97.travelpass.ui.b.b) r3)
            if (r8 == 0) goto L_0x019f
            net.one97.travelpass.model.TravelPassData r3 = r8.getBody()
            if (r3 == 0) goto L_0x019f
            net.one97.travelpass.model.TravelPassMetaData r3 = r3.getMetadata()
            if (r3 == 0) goto L_0x019f
            java.util.List r3 = r3.getInternalOffers()
            goto L_0x01a0
        L_0x019f:
            r3 = r1
        L_0x01a0:
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x01ae
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x01ac
            goto L_0x01ae
        L_0x01ac:
            r6 = 0
            goto L_0x01af
        L_0x01ae:
            r6 = 1
        L_0x01af:
            if (r6 != 0) goto L_0x01b8
            java.util.ArrayList r3 = net.one97.travelpass.e.h.b((java.util.List<? extends net.one97.travelpass.model.InternalOfferData>) r3)
            r2.a((java.util.ArrayList<net.one97.travelpass.ui.c.j>) r3)
        L_0x01b8:
            java.util.ArrayList r3 = r2.a()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x01c9
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x01c7
            goto L_0x01c9
        L_0x01c7:
            r3 = 0
            goto L_0x01ca
        L_0x01c9:
            r3 = 1
        L_0x01ca:
            if (r3 != 0) goto L_0x01f5
            java.util.ArrayList r9 = r9.a()
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x01da
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01db
        L_0x01da:
            r4 = 1
        L_0x01db:
            if (r4 == 0) goto L_0x01f2
            if (r8 == 0) goto L_0x01ef
            net.one97.travelpass.model.TravelPassData r9 = r8.getBody()
            if (r9 == 0) goto L_0x01ef
            net.one97.travelpass.model.TravelPassMetaData r9 = r9.getMetadata()
            if (r9 == 0) goto L_0x01ef
            java.lang.String r1 = r9.getCardLevelPartnerOfferHeading()
        L_0x01ef:
            r2.a((java.lang.String) r1)
        L_0x01f2:
            r10.add(r2)
        L_0x01f5:
            net.one97.travelpass.ui.b.b r9 = r0.c()
            net.one97.travelpass.ui.b.b r0 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_USER_INFO
            if (r9 != r0) goto L_0x020c
            net.one97.travelpass.ui.b.b r9 = net.one97.travelpass.ui.b.b.TRAVEL_PASS_HEADER_USER_INFO
            net.one97.travelpass.ui.c.j r8 = net.one97.travelpass.e.h.a((net.one97.travelpass.model.TravelPass) r8, (net.one97.travelpass.ui.b.b) r9)
            com.paytm.network.model.IJRPaytmDataModel r9 = r8.b()
            if (r9 == 0) goto L_0x020c
            r10.add(r8)
        L_0x020c:
            r7.viewHolderList = r10
            java.util.ArrayList<net.one97.travelpass.ui.c.j> r8 = r7.viewHolderList
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TravelPassHomeFragment.populateViewHolderList(net.one97.travelpass.model.TravelPass, java.lang.String, int):java.util.ArrayList");
    }
}
