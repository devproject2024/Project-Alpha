package net.one97.paytm.hotel4.view.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.details.HotelDetails;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.view.a.x;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.aa;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public DetailsViewModel f28799a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28800b;

    /* renamed from: c  reason: collision with root package name */
    public SRPViewModel f28801c;

    /* renamed from: d  reason: collision with root package name */
    public SRPHeaderViewModel f28802d;

    /* renamed from: e  reason: collision with root package name */
    public GalleryViewModel f28803e;

    /* renamed from: f  reason: collision with root package name */
    private aa f28804f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.hotel4.view.a.b f28805g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.hotel4.view.a.h f28806h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.hotel4.view.a.h f28807i;
    private boolean j;

    static final class c<T> implements z<HotelDetails> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28812a;

        c(d dVar) {
            this.f28812a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d.a(this.f28812a, (HotelDetails) obj);
        }
    }

    static final class f<T> implements z<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28815a;

        f(d dVar) {
            this.f28815a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                d.a(this.f28815a, list);
            }
        }
    }

    static final class g<T> implements z<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28816a;

        g(d dVar) {
            this.f28816a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                d.b(this.f28816a, list);
            }
        }
    }

    static final class h<T> implements z<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28817a;

        h(d dVar) {
            this.f28817a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                d.c(this.f28817a, list);
            }
        }
    }

    static final class i<T> implements z<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28818a;

        i(d dVar) {
            this.f28818a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Map map = (Map) obj;
            if (map != null) {
                d.a(this.f28818a, map);
            }
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28819a;

        j(d dVar) {
            this.f28819a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                bool.booleanValue();
                Toast.makeText(this.f28819a.getContext(), "Fav pressed", 0).show();
            }
        }
    }

    public static final /* synthetic */ aa a(d dVar) {
        aa aaVar = dVar.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return aaVar;
    }

    public final DetailsViewModel a() {
        DetailsViewModel detailsViewModel = this.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        return detailsViewModel;
    }

    public final SharedViewModel b() {
        SharedViewModel sharedViewModel = this.f28800b;
        if (sharedViewModel == null) {
            kotlin.g.b.k.a("sharedViewModel");
        }
        return sharedViewModel;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28800b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28800b;
            if (sharedViewModel == null) {
                kotlin.g.b.k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity, viewModelFactory).a(SRPHeaderViewModel.class);
            kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(it…derViewModel::class.java)");
            this.f28802d = (SRPHeaderViewModel) a3;
            ai a4 = am.a(activity, viewModelFactory).a(SRPViewModel.class);
            kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(it…SRPViewModel::class.java)");
            this.f28801c = (SRPViewModel) a4;
            ai a5 = am.a(activity, viewModelFactory).a(DetailsViewModel.class);
            kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(it…ilsViewModel::class.java)");
            this.f28799a = (DetailsViewModel) a5;
            ai a6 = am.a(activity, viewModelFactory).a(GalleryViewModel.class);
            kotlin.g.b.k.a((Object) a6, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28803e = (GalleryViewModel) a6;
        }
        d();
        this.j = true;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        aa a2 = aa.a(layoutInflater, viewGroup);
        kotlin.g.b.k.a((Object) a2, "H4DetailsScreenBinding.i…flater, container, false)");
        this.f28804f = a2;
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return aaVar.f29110g;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        c();
        if (this.j) {
            e();
        }
        this.f28805g = new net.one97.paytm.hotel4.view.a.b();
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView = aaVar.n.f29924a;
        kotlin.g.b.k.a((Object) recyclerView, "this.dataBinding.viewAmenities.rvAmnts");
        recyclerView.setAdapter(this.f28805g);
        this.f28806h = new net.one97.paytm.hotel4.view.a.h(true, false);
        aa aaVar2 = this.f28804f;
        if (aaVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView2 = aaVar2.o.f29933a;
        kotlin.g.b.k.a((Object) recyclerView2, "this.dataBinding.viewCinCout.rvBulletList");
        recyclerView2.setAdapter(this.f28806h);
        this.f28807i = new net.one97.paytm.hotel4.view.a.h(true, false);
        aa aaVar3 = this.f28804f;
        if (aaVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView3 = aaVar3.r.f29960a;
        kotlin.g.b.k.a((Object) recyclerView3, "this.dataBinding.viewPolicies.rvBulletPoliciesList");
        recyclerView3.setAdapter(this.f28807i);
        g();
        DetailsViewModel detailsViewModel = this.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        q qVar = this;
        detailsViewModel.getApiCallSuccess().observe(qVar, new c(this));
        DetailsViewModel detailsViewModel2 = this.f28799a;
        if (detailsViewModel2 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel2.getApiCallFailure().observe(qVar, new e(this));
        DetailsViewModel detailsViewModel3 = this.f28799a;
        if (detailsViewModel3 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel3.getAmenitiesBasic().observe(qVar, new f(this));
        DetailsViewModel detailsViewModel4 = this.f28799a;
        if (detailsViewModel4 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel4.get_tnc().observe(qVar, new g(this));
        DetailsViewModel detailsViewModel5 = this.f28799a;
        if (detailsViewModel5 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel5.get_policy().observe(qVar, new h(this));
        DetailsViewModel detailsViewModel6 = this.f28799a;
        if (detailsViewModel6 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel6.getSharePressed().observe(qVar, new i(this));
        DetailsViewModel detailsViewModel7 = this.f28799a;
        if (detailsViewModel7 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel7.getFavPressed().observe(qVar, new j(this));
        DetailsViewModel detailsViewModel8 = this.f28799a;
        if (detailsViewModel8 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel8.getAllAmenitiesOpenDialogListener().observe(qVar, new k(this));
        DetailsViewModel detailsViewModel9 = this.f28799a;
        if (detailsViewModel9 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel9.getHotelPolicyViewAllDialogListener().observe(qVar, new l(this));
        DetailsViewModel detailsViewModel10 = this.f28799a;
        if (detailsViewModel10 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel10.getAboutHotelReadMoreDialogListener().observe(qVar, new C0506d(this));
        aa aaVar4 = this.f28804f;
        if (aaVar4 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar4.m.f29916b.setOnClickListener(new n(this));
        DetailsViewModel detailsViewModel11 = this.f28799a;
        if (detailsViewModel11 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        if (detailsViewModel11.isFromMap() != null) {
            DetailsViewModel detailsViewModel12 = this.f28799a;
            if (detailsViewModel12 == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            if (detailsViewModel12.isFromMap().getValue() != null) {
                DetailsViewModel detailsViewModel13 = this.f28799a;
                if (detailsViewModel13 == null) {
                    kotlin.g.b.k.a("detailsViewModel");
                }
                Boolean value = detailsViewModel13.isFromMap().getValue();
                if (value == null) {
                    kotlin.g.b.k.a();
                }
                if (value.booleanValue()) {
                    DetailsViewModel detailsViewModel14 = this.f28799a;
                    if (detailsViewModel14 == null) {
                        kotlin.g.b.k.a("detailsViewModel");
                    }
                    detailsViewModel14.isFromMap().postValue(Boolean.FALSE);
                    aa aaVar5 = this.f28804f;
                    if (aaVar5 == null) {
                        kotlin.g.b.k.a("dataBinding");
                    }
                    aaVar5.f29104a.setExpanded(false);
                    aa aaVar6 = this.f28804f;
                    if (aaVar6 == null) {
                        kotlin.g.b.k.a("dataBinding");
                    }
                    aaVar6.f29111h.post(new a(this, view));
                    this.j = false;
                }
            }
        }
        aa aaVar7 = this.f28804f;
        if (aaVar7 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar7.f29111h.post(new b(this, view));
        this.j = false;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28808a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f28809b;

        a(d dVar, View view) {
            this.f28808a = dVar;
            this.f28809b = view;
        }

        public final void run() {
            NestedScrollView nestedScrollView = d.a(this.f28808a).f29111h;
            View view = this.f28809b;
            if (view == null) {
                kotlin.g.b.k.a();
            }
            View findViewById = view.findViewById(R.id.view_address);
            kotlin.g.b.k.a((Object) findViewById, "view!!.findViewById<View>(R.id.view_address)");
            nestedScrollView.scrollTo(0, findViewById.getTop());
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f28811b;

        b(d dVar, View view) {
            this.f28810a = dVar;
            this.f28811b = view;
        }

        public final void run() {
            NestedScrollView nestedScrollView = d.a(this.f28810a).f29111h;
            View view = this.f28811b;
            if (view == null) {
                kotlin.g.b.k.a();
            }
            View findViewById = view.findViewById(R.id.appBar);
            kotlin.g.b.k.a((Object) findViewById, "view!!.findViewById<View>(R.id.appBar)");
            nestedScrollView.scrollTo(0, findViewById.getTop());
        }
    }

    private final void c() {
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar.invalidateAll();
        aa aaVar2 = this.f28804f;
        if (aaVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        DetailsViewModel detailsViewModel = this.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        aaVar2.a(detailsViewModel);
        aa aaVar3 = this.f28804f;
        if (aaVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar3.setLifecycleOwner(this);
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28826a;

        n(d dVar) {
            this.f28826a = dVar;
        }

        public final void onClick(View view) {
            this.f28826a.a().isFromMap().postValue(Boolean.TRUE);
            this.f28826a.a().openFullMapFragment();
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            com.paytm.utility.b.a((Context) getActivity(), getResources().getString(R.string.hotels_hotel_no_internet_title), getResources().getString(R.string.hotels_hotel_no_internet_message));
        } else if (getActivity() != null) {
            DetailsViewModel detailsViewModel = this.f28799a;
            if (detailsViewModel == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            FragmentActivity activity = getActivity();
            String str = null;
            detailsViewModel.initDetailsRepository(new net.one97.paytm.hotel4.service.a.a(activity != null ? activity.getApplication() : null));
            DetailsViewModel detailsViewModel2 = this.f28799a;
            if (detailsViewModel2 == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            SRPHeaderViewModel sRPHeaderViewModel = this.f28802d;
            if (sRPHeaderViewModel == null) {
                kotlin.g.b.k.a("headerViewModel");
            }
            CJRHotelSearchInput searchInputData = sRPHeaderViewModel.getSearchInputData();
            SRPViewModel sRPViewModel = this.f28801c;
            if (sRPViewModel == null) {
                kotlin.g.b.k.a("srpViewModel");
            }
            SRPDataItem value = sRPViewModel.getSelectedData().getValue();
            SRPViewModel sRPViewModel2 = this.f28801c;
            if (sRPViewModel2 == null) {
                kotlin.g.b.k.a("srpViewModel");
            }
            HotelSearchResponse value2 = sRPViewModel2.getSrpData().getValue();
            if (value2 != null) {
                str = value2.getRequestId();
            }
            detailsViewModel2.setSelectedHotel(searchInputData, value, str);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f28804f != null) {
            aa aaVar = this.f28804f;
            if (aaVar == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            ConstraintLayout constraintLayout = aaVar.f29110g;
            kotlin.g.b.k.a((Object) constraintLayout, "dataBinding.root");
            constraintLayout.setClickable(false);
            aa aaVar2 = this.f28804f;
            if (aaVar2 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            ConstraintLayout constraintLayout2 = aaVar2.f29110g;
            kotlin.g.b.k.a((Object) constraintLayout2, "dataBinding.root");
            constraintLayout2.setEnabled(false);
            aa aaVar3 = this.f28804f;
            if (aaVar3 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            Button button = aaVar3.f29106c;
            kotlin.g.b.k.a((Object) button, "dataBinding.btnSelectRoom");
            button.setVisibility(8);
            aa aaVar4 = this.f28804f;
            if (aaVar4 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            ShimmerFrameLayout shimmerFrameLayout = aaVar4.f29112i;
            kotlin.g.b.k.a((Object) shimmerFrameLayout, "dataBinding.shimmerFrameLayout");
            shimmerFrameLayout.setVisibility(0);
            aa aaVar5 = this.f28804f;
            if (aaVar5 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            aaVar5.f29112i.a();
        }
    }

    private final void f() {
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        ConstraintLayout constraintLayout = aaVar.f29110g;
        kotlin.g.b.k.a((Object) constraintLayout, "dataBinding.root");
        constraintLayout.setClickable(true);
        aa aaVar2 = this.f28804f;
        if (aaVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        ConstraintLayout constraintLayout2 = aaVar2.f29110g;
        kotlin.g.b.k.a((Object) constraintLayout2, "dataBinding.root");
        constraintLayout2.setEnabled(true);
        aa aaVar3 = this.f28804f;
        if (aaVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar3.f29112i.b();
        aa aaVar4 = this.f28804f;
        if (aaVar4 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        ShimmerFrameLayout shimmerFrameLayout = aaVar4.f29112i;
        kotlin.g.b.k.a((Object) shimmerFrameLayout, "dataBinding.shimmerFrameLayout");
        shimmerFrameLayout.setVisibility(8);
        aa aaVar5 = this.f28804f;
        if (aaVar5 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        Button button = aaVar5.f29106c;
        kotlin.g.b.k.a((Object) button, "dataBinding.btnSelectRoom");
        button.setVisibility(0);
    }

    private final void g() {
        h();
        i();
        j();
        k();
        l();
    }

    private final void h() {
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        aaVar.f29111h.scrollTo(0, 0);
    }

    private final void i() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (activity != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            aa aaVar = this.f28804f;
            if (aaVar == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            appCompatActivity.setSupportActionBar(aaVar.j);
            appCompatActivity.setTitle("");
            Resources resources = getResources();
            kotlin.g.b.k.a((Object) resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            aa aaVar2 = this.f28804f;
            if (aaVar2 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            AppBarLayout appBarLayout = aaVar2.f29104a;
            kotlin.g.b.k.a((Object) appBarLayout, "dataBinding.appBar");
            double d2 = (double) (((float) appBarLayout.getLayoutParams().height) - (displayMetrics.density * 100.0f));
            double d3 = d2 * 0.9d;
            double d4 = d2 - d3;
            float f2 = displayMetrics.density * 5.0f;
            aa aaVar3 = this.f28804f;
            if (aaVar3 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            aaVar3.f29104a.a((AppBarLayout.b) new m(d3, f2, d4, this));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    static final class m implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double f28822a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f28823b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double f28824c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f28825d;

        m(double d2, float f2, double d3, d dVar) {
            this.f28822a = d2;
            this.f28823b = f2;
            this.f28824c = d3;
            this.f28825d = dVar;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            TextView textView = d.a(this.f28825d).k;
            kotlin.g.b.k.a((Object) textView, "dataBinding.tvTitle");
            SRPDataItem value = this.f28825d.a().getSelectedData().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            textView.setText(value.getName());
            double abs = (double) Math.abs(i2);
            double d2 = this.f28822a;
            if (abs > d2) {
                double d3 = (abs - d2) + ((double) this.f28823b);
                double abs2 = Math.abs(d3 - this.f28824c);
                double d4 = this.f28824c;
                double d5 = abs2 / d4;
                if (d3 - d4 >= 0.0d) {
                    d5 = 0.0d;
                }
                ImageView imageView = d.a(this.f28825d).f29105b;
                kotlin.g.b.k.a((Object) imageView, "dataBinding.backButton");
                imageView.setAlpha(1.0f - ((float) d5));
                if (Double.valueOf(d5).equals(Double.valueOf(0.0d))) {
                    ImageView imageView2 = d.a(this.f28825d).f29105b;
                    kotlin.g.b.k.a((Object) imageView2, "dataBinding.backButton");
                    imageView2.setVisibility(0);
                    Toolbar toolbar = d.a(this.f28825d).j;
                    kotlin.g.b.k.a((Object) toolbar, "dataBinding.toolbar");
                    toolbar.setVisibility(0);
                    ImageView imageView3 = d.a(this.f28825d).f29109f;
                    kotlin.g.b.k.a((Object) imageView3, "dataBinding.ivShare");
                    imageView3.setClickable(true);
                    return;
                }
                return;
            }
            ImageView imageView4 = d.a(this.f28825d).f29105b;
            kotlin.g.b.k.a((Object) imageView4, "dataBinding.backButton");
            imageView4.setAlpha(0.0f);
            ImageView imageView5 = d.a(this.f28825d).f29105b;
            kotlin.g.b.k.a((Object) imageView5, "dataBinding.backButton");
            imageView5.setVisibility(8);
            Toolbar toolbar2 = d.a(this.f28825d).j;
            kotlin.g.b.k.a((Object) toolbar2, "dataBinding.toolbar");
            toolbar2.setVisibility(4);
            ImageView imageView6 = d.a(this.f28825d).f29109f;
            kotlin.g.b.k.a((Object) imageView6, "dataBinding.ivShare");
            imageView6.setClickable(false);
        }
    }

    private final void j() {
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        a.C0498a.a(aaVar.p.f29942a, net.one97.paytm.hotel4.utils.f.c("circularmap"));
    }

    private final void k() {
        StringBuilder sb = new StringBuilder();
        DetailsViewModel detailsViewModel = this.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        SRPDataItem value = detailsViewModel.getSelectedData().getValue();
        if (value == null) {
            kotlin.g.b.k.a();
        }
        sb.append(String.valueOf(value.getLatitude()));
        sb.append(AppConstants.COMMA);
        DetailsViewModel detailsViewModel2 = this.f28799a;
        if (detailsViewModel2 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        SRPDataItem value2 = detailsViewModel2.getSelectedData().getValue();
        if (value2 == null) {
            kotlin.g.b.k.a();
        }
        sb.append(String.valueOf(value2.getLongitude()));
        String sb2 = sb.toString();
        net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
        kotlin.g.b.k.a((Object) b2, "HotelController.getHotelEventListener()");
        String str = "https://apis.mapmyindia.com/advancedmaps/v1/" + b2.e() + "/still_image?center=" + sb2 + "&+zoom=16&size=" + com.travel.customViews.c.a() + "x" + com.travel.customViews.c.a(160) + "&ssf=1&markers=" + sb2;
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        aa aaVar = this.f28804f;
        if (aaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        a.C0498a.a(aaVar.m.f29916b, str);
    }

    private final void l() {
        ArrayList arrayList = new ArrayList();
        SharedViewModel sharedViewModel = this.f28800b;
        if (sharedViewModel == null) {
            kotlin.g.b.k.a("sharedViewModel");
        }
        if (sharedViewModel.getSearchResponse() != null) {
            SharedViewModel sharedViewModel2 = this.f28800b;
            if (sharedViewModel2 == null) {
                kotlin.g.b.k.a("sharedViewModel");
            }
            HotelSearchResponse searchResponse = sharedViewModel2.getSearchResponse();
            if ((searchResponse != null ? searchResponse.getData() : null) != null) {
                SharedViewModel sharedViewModel3 = this.f28800b;
                if (sharedViewModel3 == null) {
                    kotlin.g.b.k.a("sharedViewModel");
                }
                HotelSearchResponse searchResponse2 = sharedViewModel3.getSearchResponse();
                if (searchResponse2 == null) {
                    kotlin.g.b.k.a();
                }
                List<SRPDataItem> data = searchResponse2.getData();
                if (data != null) {
                    boolean z = false;
                    for (SRPDataItem sRPDataItem : data) {
                        if (z) {
                            arrayList.add(sRPDataItem);
                        }
                        String id = sRPDataItem.getId();
                        DetailsViewModel detailsViewModel = this.f28799a;
                        if (detailsViewModel == null) {
                            kotlin.g.b.k.a("detailsViewModel");
                        }
                        SRPDataItem value = detailsViewModel.getSelectedData().getValue();
                        if (value == null) {
                            kotlin.g.b.k.a();
                        }
                        if (kotlin.g.b.k.a((Object) id, (Object) value.getId())) {
                            z = true;
                        }
                    }
                }
                x xVar = new x(arrayList);
                xVar.a(new o(this));
                aa aaVar = this.f28804f;
                if (aaVar == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                RecyclerView recyclerView = aaVar.s.f29334b;
                kotlin.g.b.k.a((Object) recyclerView, "dataBinding.viewSimilarHotels.similarHotelsList");
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
                aa aaVar2 = this.f28804f;
                if (aaVar2 == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                RecyclerView recyclerView2 = aaVar2.s.f29334b;
                kotlin.g.b.k.a((Object) recyclerView2, "dataBinding.viewSimilarHotels.similarHotelsList");
                recyclerView2.setAdapter(xVar);
                if (arrayList.size() == 0) {
                    aa aaVar3 = this.f28804f;
                    if (aaVar3 == null) {
                        kotlin.g.b.k.a("dataBinding");
                    }
                    ConstraintLayout constraintLayout = aaVar3.s.f29333a;
                    kotlin.g.b.k.a((Object) constraintLayout, "dataBinding.viewSimilarHotels.root");
                    constraintLayout.setVisibility(8);
                    return;
                }
                aa aaVar4 = this.f28804f;
                if (aaVar4 == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                ConstraintLayout constraintLayout2 = aaVar4.s.f29333a;
                kotlin.g.b.k.a((Object) constraintLayout2, "dataBinding.viewSimilarHotels.root");
                constraintLayout2.setVisibility(0);
                return;
            }
        }
        aa aaVar5 = this.f28804f;
        if (aaVar5 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        ConstraintLayout constraintLayout3 = aaVar5.s.f29333a;
        kotlin.g.b.k.a((Object) constraintLayout3, "dataBinding.viewSimilarHotels.root");
        constraintLayout3.setVisibility(8);
    }

    public static final class o implements x.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28827a;

        o(d dVar) {
            this.f28827a = dVar;
        }

        public final void a(SRPDataItem sRPDataItem, int i2) {
            kotlin.g.b.k.c(sRPDataItem, "hotel");
            SRPViewModel sRPViewModel = this.f28827a.f28801c;
            if (sRPViewModel == null) {
                kotlin.g.b.k.a("srpViewModel");
            }
            sRPViewModel.getSelectedData().setValue(sRPDataItem);
            d.a(this.f28827a, sRPDataItem, i2);
            this.f28827a.e();
            this.f28827a.d();
            d.a(this.f28827a).f29104a.setExpanded(true);
        }
    }

    static final class e<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28814a;

        e(d dVar) {
            this.f28814a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d.b(this.f28814a);
        }
    }

    static final class k<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28820a;

        k(d dVar) {
            this.f28820a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28820a.getActivity(), this.f28820a.a().getAmenitiesAllBasic().getValue(), this.f28820a.getString(R.string.h4_amenities), this.f28820a.b());
        }
    }

    static final class l<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28821a;

        l(d dVar) {
            this.f28821a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28821a.getActivity(), this.f28821a.a().get_tnc().getValue(), this.f28821a.getString(R.string.h4_hotel_polices), false, false, this.f28821a.b());
        }
    }

    /* renamed from: net.one97.paytm.hotel4.view.ui.a.d$d  reason: collision with other inner class name */
    static final class C0506d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28813a;

        C0506d(d dVar) {
            this.f28813a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = new ArrayList();
            String value = this.f28813a.a().get_about().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            arrayList.add(value);
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28813a.getActivity(), arrayList, this.f28813a.getString(R.string.h4_about_hotel), true, false, this.f28813a.b());
        }
    }

    public static final /* synthetic */ void a(d dVar, HotelDetails hotelDetails) {
        if (hotelDetails != null) {
            DetailsViewModel detailsViewModel = dVar.f28799a;
            if (detailsViewModel == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            detailsViewModel.setDetailsDta(hotelDetails);
            DetailsViewModel detailsViewModel2 = dVar.f28799a;
            if (detailsViewModel2 == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            detailsViewModel2.sendHotelDetailslOpenPulseEvent(true);
            dVar.c();
            dVar.g();
            GalleryViewModel galleryViewModel = dVar.f28803e;
            if (galleryViewModel == null) {
                kotlin.g.b.k.a("galleryViewModel");
            }
            galleryViewModel.getStatePageIndex().postValue(0);
            GalleryViewModel galleryViewModel2 = dVar.f28803e;
            if (galleryViewModel2 == null) {
                kotlin.g.b.k.a("galleryViewModel");
            }
            galleryViewModel2.getStateImageIndex().postValue(0);
            dVar.f();
            return;
        }
        dVar.f();
        DetailsViewModel detailsViewModel3 = dVar.f28799a;
        if (detailsViewModel3 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel3.loadDetailErrorView();
    }

    public static final /* synthetic */ void b(d dVar) {
        dVar.f();
        DetailsViewModel detailsViewModel = dVar.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        detailsViewModel.loadDetailErrorView();
    }

    public static final /* synthetic */ void a(d dVar, List list) {
        net.one97.paytm.hotel4.view.a.b bVar = dVar.f28805g;
        if (bVar != null) {
            bVar.a(list);
        }
    }

    public static final /* synthetic */ void b(d dVar, List list) {
        if (list.size() >= 3) {
            net.one97.paytm.hotel4.view.a.h hVar = dVar.f28807i;
            if (hVar != null) {
                hVar.a(list.subList(0, 3));
                return;
            }
            return;
        }
        net.one97.paytm.hotel4.view.a.h hVar2 = dVar.f28807i;
        if (hVar2 != null) {
            hVar2.a(list);
        }
    }

    public static final /* synthetic */ void c(d dVar, List list) {
        net.one97.paytm.hotel4.view.a.h hVar = dVar.f28806h;
        if (hVar != null) {
            hVar.a(list);
        }
    }

    public static final /* synthetic */ void a(d dVar, Map map) {
        String string = dVar.getResources().getString(R.string.h4_sharing_message);
        kotlin.g.b.k.a((Object) string, "resources.getString(R.string.h4_sharing_message)");
        net.one97.paytm.hotels2.utils.c.b().a((Context) dVar.getActivity(), (Map<String, String>) map, string);
    }

    public static final /* synthetic */ void a(d dVar, SRPDataItem sRPDataItem, int i2) {
        HashMap hashMap = new HashMap();
        DetailsViewModel detailsViewModel = dVar.f28799a;
        if (detailsViewModel == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        if (detailsViewModel.getParent().getSearchInput() != null) {
            Map map = hashMap;
            DetailsViewModel detailsViewModel2 = dVar.f28799a;
            if (detailsViewModel2 == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            CJRHotelSearchInput searchInput = detailsViewModel2.getParent().getSearchInput();
            if (searchInput == null) {
                kotlin.g.b.k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        DetailsViewModel detailsViewModel3 = dVar.f28799a;
        if (detailsViewModel3 == null) {
            kotlin.g.b.k.a("detailsViewModel");
        }
        SRPDataItem value = detailsViewModel3.getSelectedData().getValue();
        if (value == null) {
            kotlin.g.b.k.a();
        }
        String name = value.getName();
        if (name != null) {
            map2.put("event_label2", name);
            map2.put("event_label3", Double.valueOf(sRPDataItem.getPriceData().getFinalPrice()));
            DetailsViewModel detailsViewModel4 = dVar.f28799a;
            if (detailsViewModel4 == null) {
                kotlin.g.b.k.a("detailsViewModel");
            }
            SRPDataItem value2 = detailsViewModel4.getSelectedData().getValue();
            if (value2 == null) {
                kotlin.g.b.k.a();
            }
            map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Double.valueOf(value2.getPriceData().getFinalPrice()));
            map2.put("event_label5", Integer.valueOf(i2 + 1));
            net.one97.paytm.hotels2.utils.c.b().a("customEvent", "Hotel Details", "hotels_details", "similar_selected", map2);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }
}
