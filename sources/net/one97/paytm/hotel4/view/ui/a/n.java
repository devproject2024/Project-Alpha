package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.view.a.r;
import net.one97.paytm.hotel4.view.a.w;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.b.gk;

public final class n extends b {

    /* renamed from: a  reason: collision with root package name */
    public SRPViewModel f28895a;

    /* renamed from: b  reason: collision with root package name */
    public SRPHeaderViewModel f28896b;

    /* renamed from: c  reason: collision with root package name */
    public r f28897c;

    /* renamed from: d  reason: collision with root package name */
    public SharedViewModel f28898d;

    /* renamed from: e  reason: collision with root package name */
    private w f28899e;

    /* renamed from: f  reason: collision with root package name */
    private gk f28900f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f28901g = 5;

    static final class e<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f28910a = new e();

        e() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static final class c<T> implements z<HotelSearchResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SRPViewModel f28907a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f28908b;

        c(SRPViewModel sRPViewModel, n nVar) {
            this.f28907a = sRPViewModel;
            this.f28908b = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f28907a.onPageResponseSuccess((HotelSearchResponse) obj);
        }
    }

    static final class d<T> implements z<HotelSearchResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f28909a;

        d(n nVar) {
            this.f28909a = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ShimmerFrameLayout shimmerFrameLayout = n.b(this.f28909a).f29846f;
            k.a((Object) shimmerFrameLayout, "dataBinding.shimmerFrameLayout");
            shimmerFrameLayout.setVisibility(8);
            n.b(this.f28909a).f29846f.b();
            n.a(this.f28909a, (HotelSearchResponse) obj);
        }
    }

    public static final /* synthetic */ gk b(n nVar) {
        gk gkVar = nVar.f28900f;
        if (gkVar == null) {
            k.a("dataBinding");
        }
        return gkVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28898d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28898d;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity, viewModelFactory).a(SRPViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…SRPViewModel::class.java)");
            this.f28895a = (SRPViewModel) a3;
            ai a4 = am.a((Fragment) this, viewModelFactory).a(SRPHeaderViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(th…derViewModel::class.java)");
            this.f28896b = (SRPHeaderViewModel) a4;
        }
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        gk a2 = gk.a(getLayoutInflater(), viewGroup);
        k.a((Object) a2, "Hotel4SrpViewBinding.inf…flater, container, false)");
        this.f28900f = a2;
        gk gkVar = this.f28900f;
        if (gkVar == null) {
            k.a("dataBinding");
        }
        SRPViewModel sRPViewModel = this.f28895a;
        if (sRPViewModel == null) {
            k.a("srpViewModel");
        }
        gkVar.a(sRPViewModel);
        gk gkVar2 = this.f28900f;
        if (gkVar2 == null) {
            k.a("dataBinding");
        }
        SRPHeaderViewModel sRPHeaderViewModel = this.f28896b;
        if (sRPHeaderViewModel == null) {
            k.a("srpHeaderViewModel");
        }
        gkVar2.a(sRPHeaderViewModel);
        gk gkVar3 = this.f28900f;
        if (gkVar3 == null) {
            k.a("dataBinding");
        }
        gkVar3.setLifecycleOwner(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        gk gkVar4 = this.f28900f;
        if (gkVar4 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = gkVar4.f29845e;
        k.a((Object) recyclerView, "this.dataBinding.recyclerviewSrp");
        recyclerView.setLayoutManager(linearLayoutManager);
        SRPViewModel sRPViewModel2 = this.f28895a;
        if (sRPViewModel2 == null) {
            k.a("srpViewModel");
        }
        this.f28897c = new r(sRPViewModel2);
        gk gkVar5 = this.f28900f;
        if (gkVar5 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = gkVar5.f29845e;
        k.a((Object) recyclerView2, "this.dataBinding.recyclerviewSrp");
        r rVar = this.f28897c;
        if (rVar == null) {
            k.a("listAdapter");
        }
        recyclerView2.setAdapter(rVar);
        SRPViewModel sRPViewModel3 = this.f28895a;
        if (sRPViewModel3 == null) {
            k.a("srpViewModel");
        }
        this.f28899e = new w(sRPViewModel3);
        gk gkVar6 = this.f28900f;
        if (gkVar6 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView3 = gkVar6.f29844d;
        k.a((Object) recyclerView3, "dataBinding.recyclerviewSelectedLocation");
        recyclerView3.setAdapter(this.f28899e);
        List arrayList = new ArrayList();
        arrayList.addAll(kotlin.a.k.b((T[]) new String[]{"Koramangala", "Silkboard", "Marathahalli"}));
        w wVar = this.f28899e;
        if (wVar == null) {
            k.a();
        }
        wVar.a(arrayList);
        gk gkVar7 = this.f28900f;
        if (gkVar7 == null) {
            k.a("dataBinding");
        }
        u.c((View) gkVar7.f29845e, true);
        gk gkVar8 = this.f28900f;
        if (gkVar8 == null) {
            k.a("dataBinding");
        }
        gkVar8.f29845e.addOnScrollListener(new b(this, linearLayoutManager));
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        gk gkVar9 = this.f28900f;
        if (gkVar9 == null) {
            k.a("dataBinding");
        }
        a.C0498a.a(gkVar9.f29843c.f29672c, f.c("searchemptyresult"), com.paytm.utility.b.b.e.HIGH);
        gk gkVar10 = this.f28900f;
        if (gkVar10 == null) {
            k.a("dataBinding");
        }
        return gkVar10.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        List<SRPDataItem> data;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        gk gkVar = this.f28900f;
        if (gkVar == null) {
            k.a("dataBinding");
        }
        gkVar.f29846f.a();
        SRPViewModel sRPViewModel = this.f28895a;
        if (sRPViewModel == null) {
            k.a("srpViewModel");
        }
        q qVar = this;
        sRPViewModel.getSrpData().observe(qVar, new d(this));
        SRPViewModel sRPViewModel2 = this.f28895a;
        if (sRPViewModel2 == null) {
            k.a("srpViewModel");
        }
        sRPViewModel2.getApiCallSuccess().observe(qVar, new c(sRPViewModel2, this));
        sRPViewModel2.getApiCallFailure().observe(qVar, e.f28910a);
        SRPViewModel sRPViewModel3 = this.f28895a;
        if (sRPViewModel3 == null) {
            k.a("srpViewModel");
        }
        sRPViewModel3.reFetchSearchDta();
        if (getActivity() != null) {
            SRPHeaderViewModel sRPHeaderViewModel = this.f28896b;
            if (sRPHeaderViewModel == null) {
                k.a("srpHeaderViewModel");
            }
            sRPHeaderViewModel.updateData();
        }
        SRPViewModel sRPViewModel4 = this.f28895a;
        if (sRPViewModel4 == null) {
            k.a("srpViewModel");
        }
        SRPDataItem value = sRPViewModel4.getSelectedData().getValue();
        if (value != null) {
            SRPViewModel sRPViewModel5 = this.f28895a;
            if (sRPViewModel5 == null) {
                k.a("srpViewModel");
            }
            HotelSearchResponse value2 = sRPViewModel5.getSrpData().getValue();
            if (!(value2 == null || (data = value2.getData()) == null || !data.contains(value))) {
                new Handler().postDelayed(new a(data.indexOf(value), value, this), 500);
            }
        }
        a();
    }

    public static final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f28905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f28906b;

        b(n nVar, LinearLayoutManager linearLayoutManager) {
            this.f28905a = nVar;
            this.f28906b = linearLayoutManager;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            int childCount = this.f28906b.getChildCount();
            int itemCount = this.f28906b.getItemCount();
            int findFirstVisibleItemPosition = this.f28906b.findFirstVisibleItemPosition();
            if (itemCount > 0 && findFirstVisibleItemPosition >= 0 && itemCount - (findFirstVisibleItemPosition + childCount) <= this.f28905a.f28901g) {
                SRPViewModel sRPViewModel = this.f28905a.f28895a;
                if (sRPViewModel == null) {
                    k.a("srpViewModel");
                }
                sRPViewModel.handlePageRequest(itemCount);
            }
        }
    }

    private final void a() {
        SRPViewModel sRPViewModel = this.f28895a;
        if (sRPViewModel == null) {
            k.a("srpViewModel");
        }
        sRPViewModel.getSelectedData().setValue(null);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f28902a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SRPDataItem f28903b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f28904c;

        a(int i2, SRPDataItem sRPDataItem, n nVar) {
            this.f28902a = i2;
            this.f28903b = sRPDataItem;
            this.f28904c = nVar;
        }

        public final void run() {
            n.b(this.f28904c).f29845e.smoothScrollToPosition(this.f28902a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.hotel4.view.ui.a.n r8, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r9) {
        /*
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            java.lang.String r1 = "srpViewModel"
            if (r0 != 0) goto L_0x000a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x000a:
            androidx.lifecycle.y r0 = r0.isHotelSoldOut()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.setValue(r2)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            java.lang.String r2 = "sharedViewModel"
            if (r0 != 0) goto L_0x001d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001d:
            r3 = 0
            r0.setSRPReload(r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0028
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0028:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            r4 = 0
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = r0.getHotelId()
            goto L_0x0035
        L_0x0034:
            r0 = r4
        L_0x0035:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "listAdapter"
            if (r0 != 0) goto L_0x0210
            if (r9 == 0) goto L_0x0210
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0048
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0048:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            if (r0 != 0) goto L_0x0051
            kotlin.g.b.k.a()
        L_0x0051:
            boolean r0 = r0.isFromDeeplink()
            if (r0 == 0) goto L_0x00c8
            java.util.List r0 = r9.getData()
            if (r0 == 0) goto L_0x023e
            java.util.List r0 = r9.getData()
            if (r0 != 0) goto L_0x0066
            kotlin.g.b.k.a()
        L_0x0066:
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x023e
            java.util.List r9 = r9.getData()
            java.util.Iterator r9 = r9.iterator()
        L_0x0074:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x023e
            java.lang.Object r0 = r9.next()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            java.lang.String r3 = r0.getPaytmId()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0074
            java.lang.String r3 = r0.getPaytmId()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r8.f28898d
            if (r4 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0097:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r4.getSearchInput()
            if (r4 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            java.lang.String r4 = r4.getHotelId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0074
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r9 = r8.f28895a
            if (r9 != 0) goto L_0x00b1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b1:
            r9.setSelectedHotel(r0)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r8 = r8.f28898d
            if (r8 != 0) goto L_0x00bb
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00bb:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r8 = r8.getSearchInput()
            if (r8 != 0) goto L_0x00c4
            kotlin.g.b.k.a()
        L_0x00c4:
            r8.markDeeplinkProcessed()
            return
        L_0x00c8:
            java.util.List r0 = r9.getData()
            r6 = 1
            if (r0 == 0) goto L_0x0165
            java.util.List r0 = r9.getData()
            if (r0 == 0) goto L_0x00de
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00df
        L_0x00de:
            r0 = r4
        L_0x00df:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0165
            java.util.List r0 = r9.getData()
            if (r0 == 0) goto L_0x00f8
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = r0.getId()
            goto L_0x00f9
        L_0x00f8:
            r0 = r4
        L_0x00f9:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r8.f28898d
            if (r7 != 0) goto L_0x0100
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0100:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r7 = r7.getSearchInput()
            if (r7 == 0) goto L_0x010b
            java.lang.String r7 = r7.getHotelId()
            goto L_0x010c
        L_0x010b:
            r7 = r4
        L_0x010c:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0165
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x0119
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0119:
            java.util.List r9 = r9.getData()
            if (r9 == 0) goto L_0x0126
            java.lang.Object r9 = r9.get(r3)
            r4 = r9
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r4 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r4
        L_0x0126:
            if (r4 != 0) goto L_0x012b
            kotlin.g.b.k.a()
        L_0x012b:
            r0.setSelectedHotel(r4)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r9 = r8.f28898d
            if (r9 != 0) goto L_0x0135
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0135:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r9 = r9.getSearchInput()
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x0140
            r9.setHotelId(r0)
        L_0x0140:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r9 = r8.f28898d
            if (r9 != 0) goto L_0x0147
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0147:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r9 = r9.getSearchInput()
            if (r9 == 0) goto L_0x0150
            r9.setPoi(r0)
        L_0x0150:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r9 = r8.f28898d
            if (r9 != 0) goto L_0x0157
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0157:
            r9.setSRPReload(r6)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r8 = r8.f28898d
            if (r8 != 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0161:
            r8.setHotelSoldOut(r3)
            return
        L_0x0165:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x016c
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x016c:
            r0.setSRPReload(r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0176
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0176:
            r0.setHotelSoldOut(r6)
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x0180
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0180:
            androidx.lifecycle.y r0 = r0.isHotelSoldOut()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.setValue(r3)
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x0190
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0190:
            int r0 = r0.getLastTotalItemCount()
            if (r0 != 0) goto L_0x01a6
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x019d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x019d:
            com.travel.utils.l r0 = r0.isHotelSoldOutMessageVisible()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.setValue(r3)
        L_0x01a6:
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x01ad
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01ad:
            com.travel.utils.l r0 = r0.getSoldOutHotelName()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r8.f28898d
            if (r3 != 0) goto L_0x01b8
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01b8:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 == 0) goto L_0x01c3
            java.lang.String r3 = r3.getPoi()
            goto L_0x01c4
        L_0x01c3:
            r3 = r4
        L_0x01c4:
            r0.setValue(r3)
            java.lang.String r0 = "hotelsoldout"
            java.lang.String r0 = net.one97.paytm.hotel4.utils.f.c(r0)
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r3 = r8.f28895a
            if (r3 != 0) goto L_0x01d4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01d4:
            com.travel.utils.l r3 = r3.getSoldOutImageUrl()
            r3.postValue(r0)
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r8.f28895a
            if (r0 != 0) goto L_0x01e2
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01e2:
            com.travel.utils.l r0 = r0.getSoldOutLocality()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r8.f28898d
            if (r1 != 0) goto L_0x01ed
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01ed:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 == 0) goto L_0x01f7
            java.lang.String r4 = r1.getCity()
        L_0x01f7:
            r0.setValue(r4)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0201
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0201:
            r0.updateSearchResponse(r9)
            net.one97.paytm.hotel4.view.a.r r8 = r8.f28897c
            if (r8 != 0) goto L_0x020b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x020b:
            java.util.List r4 = r9.getData()
            goto L_0x023b
        L_0x0210:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0217
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0217:
            r0.setSRPReload(r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x0221
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0221:
            r0.setHotelSoldOut(r3)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.f28898d
            if (r0 != 0) goto L_0x022b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x022b:
            r0.updateSearchResponse(r9)
            net.one97.paytm.hotel4.view.a.r r8 = r8.f28897c
            if (r8 != 0) goto L_0x0235
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0235:
            if (r9 == 0) goto L_0x023b
            java.util.List r4 = r9.getData()
        L_0x023b:
            r8.a(r4)
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.n.a(net.one97.paytm.hotel4.view.ui.a.n, net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse):void");
    }
}
