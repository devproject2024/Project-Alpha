package net.one97.paytm.hotel4.view.ui.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.paytm.utility.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.HotelAutosuggestSearchResponse;
import net.one97.paytm.hotel4.service.model.HotelSuggestionDataItem;
import net.one97.paytm.hotel4.service.model.PopularRecentDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.location.CJRUtilityLocationModel;
import net.one97.paytm.hotel4.utils.location.GPSChangeReceiver;
import net.one97.paytm.hotel4.utils.location.a;
import net.one97.paytm.hotel4.view.a.j;
import net.one97.paytm.hotel4.view.a.v;
import net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ga;

public final class o extends net.one97.paytm.i.h {

    /* renamed from: d  reason: collision with root package name */
    public static final a f28911d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public View f28912a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.hotel4.view.a.j f28913b;

    /* renamed from: c  reason: collision with root package name */
    public v f28914c;

    /* renamed from: e  reason: collision with root package name */
    private HotelSearchViewModel f28915e;

    /* renamed from: f  reason: collision with root package name */
    private ga f28916f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f28917g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRUtilityLocationModel f28918h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.hotel4.utils.location.a f28919i;
    private GPSChangeReceiver j;

    static final class e<T> implements z<List<? extends PopularRecentDataItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28923a;

        e(o oVar) {
            this.f28923a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o.a(this.f28923a, (List) obj);
        }
    }

    static final class f<T> implements z<HotelAutosuggestSearchResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28924a;

        f(o oVar) {
            this.f28924a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o.a(this.f28924a, (HotelAutosuggestSearchResponse) obj);
        }
    }

    static final class g<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28925a;

        g(o oVar) {
            this.f28925a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null) {
                o.a(this.f28925a, num.intValue());
            }
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28926a;

        h(o oVar) {
            this.f28926a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                bool.booleanValue();
                o.d(this.f28926a);
            }
        }
    }

    static final class i<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28927a;

        i(o oVar) {
            this.f28927a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                bool.booleanValue();
                o.e(this.f28927a);
            }
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28928a;

        j(o oVar) {
            this.f28928a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                this.f28928a.a(bool.booleanValue());
            }
        }
    }

    static final class k<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28929a;

        k(o oVar) {
            this.f28929a = oVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                bool.booleanValue();
                o.f(this.f28929a);
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

    public static final /* synthetic */ HotelSearchViewModel c(o oVar) {
        HotelSearchViewModel hotelSearchViewModel = oVar.f28915e;
        if (hotelSearchViewModel == null) {
            kotlin.g.b.k.a("searchViewModel");
        }
        return hotelSearchViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        ga a2 = ga.a(getLayoutInflater(), viewGroup);
        kotlin.g.b.k.a((Object) a2, "Hotel4SearchFragmentBind…flater, container, false)");
        this.f28916f = a2;
        ga gaVar = this.f28916f;
        if (gaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        View root = gaVar.getRoot();
        kotlin.g.b.k.a((Object) root, "this.dataBinding.root");
        this.f28912a = root;
        ga gaVar2 = this.f28916f;
        if (gaVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        this.f28917g = (LottieAnimationView) gaVar2.getRoot().findViewById(R.id.lottieAnim);
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        ga gaVar3 = this.f28916f;
        if (gaVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        a.C0498a.a(gaVar3.f29800e.f29850a, net.one97.paytm.hotel4.utils.f.c("gps"), com.paytm.utility.b.b.e.HIGH);
        View view = this.f28912a;
        if (view == null) {
            kotlin.g.b.k.a("searchView");
        }
        return view;
    }

    public final void onActivityCreated(Bundle bundle) {
        net.one97.paytm.hotel4.view.a.j jVar;
        LocationSettingsRequest locationSettingsRequest;
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(HotelSearchViewModel.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…rchViewModel::class.java)");
        this.f28915e = (HotelSearchViewModel) a2;
        ga gaVar = this.f28916f;
        if (gaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        HotelSearchViewModel hotelSearchViewModel = this.f28915e;
        if (hotelSearchViewModel == null) {
            kotlin.g.b.k.a("searchViewModel");
        }
        gaVar.a(hotelSearchViewModel);
        ga gaVar2 = this.f28916f;
        if (gaVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        q qVar = this;
        gaVar2.setLifecycleOwner(qVar);
        Context context = getContext();
        Application application = null;
        if (context != null) {
            kotlin.g.b.k.a((Object) context, "it");
            jVar = new net.one97.paytm.hotel4.view.a.j((j.a) getActivity(), context);
        } else {
            jVar = null;
        }
        if (jVar == null) {
            kotlin.g.b.k.a();
        }
        this.f28913b = jVar;
        ga gaVar3 = this.f28916f;
        if (gaVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView = gaVar3.f29804i;
        kotlin.g.b.k.a((Object) recyclerView, "this.dataBinding.recycleviewPopularSearch");
        net.one97.paytm.hotel4.view.a.j jVar2 = this.f28913b;
        if (jVar2 == null) {
            kotlin.g.b.k.a("popularAdapter");
        }
        recyclerView.setAdapter(jVar2);
        net.one97.paytm.hotels2.utils.d b2 = net.one97.paytm.hotels2.utils.c.b();
        kotlin.g.b.k.a((Object) b2, "HotelController.getHotelEventListener()");
        Context a3 = b2.a();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            kotlin.g.b.k.a((Object) a3, "context");
            net.one97.paytm.hotel4.utils.location.a aVar = new net.one97.paytm.hotel4.utils.location.a(a3, activity);
            aVar.f28651a = false;
            a.b bVar = new b(this);
            kotlin.g.b.k.c(bVar, "locationListener");
            aVar.f28658h = bVar;
            a.C0500a cVar = new c(this);
            kotlin.g.b.k.c(cVar, "addressListListener");
            aVar.f28659i = cVar;
            aVar.f28655e = LocationRequest.a().a(aVar.f28652b).a(aVar.f28653c).b(aVar.f28654d);
            LocationRequest locationRequest = aVar.f28655e;
            if (locationRequest != null) {
                LocationSettingsRequest.a aVar2 = new LocationSettingsRequest.a();
                aVar2.a(locationRequest);
                locationSettingsRequest = aVar2.b();
            } else {
                locationSettingsRequest = null;
            }
            aVar.f28656f = locationSettingsRequest;
            aVar.f28657g = com.google.android.gms.location.f.b(aVar.k);
            this.f28919i = aVar;
            Context context2 = getContext();
            Object systemService = context2 != null ? context2.getSystemService("location") : null;
            if (systemService != null) {
                if (((LocationManager) systemService).isProviderEnabled("gps")) {
                    this.f28918h = new CJRUtilityLocationModel();
                    net.one97.paytm.hotel4.utils.location.a aVar3 = this.f28919i;
                    if (aVar3 != null) {
                        aVar3.a();
                    }
                }
                this.j = new GPSChangeReceiver(new d(this));
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.registerReceiver(this.j, new IntentFilter("android.location.PROVIDERS_CHANGED"));
                }
                HotelSearchViewModel hotelSearchViewModel2 = this.f28915e;
                if (hotelSearchViewModel2 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel2.getTrendingApiCallSuccess().observe(qVar, new e(this));
                HotelSearchViewModel hotelSearchViewModel3 = this.f28915e;
                if (hotelSearchViewModel3 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel3.getAutosuggestApiCallSuccess().observe(qVar, new f(this));
                HotelSearchViewModel hotelSearchViewModel4 = this.f28915e;
                if (hotelSearchViewModel4 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel4.getShowRecentPopularList().observe(qVar, new g(this));
                HotelSearchViewModel hotelSearchViewModel5 = this.f28915e;
                if (hotelSearchViewModel5 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel5.getFetchCurrentLocation().observe(qVar, new h(this));
                HotelSearchViewModel hotelSearchViewModel6 = this.f28915e;
                if (hotelSearchViewModel6 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel6.getBackClicked().observe(qVar, new i(this));
                HotelSearchViewModel hotelSearchViewModel7 = this.f28915e;
                if (hotelSearchViewModel7 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel7.getShowProgressBar().observe(qVar, new j(this));
                HotelSearchViewModel hotelSearchViewModel8 = this.f28915e;
                if (hotelSearchViewModel8 == null) {
                    kotlin.g.b.k.a("searchViewModel");
                }
                hotelSearchViewModel8.getClearAutoSearch().observe(qVar, new k(this));
                if (getActivity() != null) {
                    a(true);
                    HotelSearchViewModel hotelSearchViewModel9 = this.f28915e;
                    if (hotelSearchViewModel9 == null) {
                        kotlin.g.b.k.a("searchViewModel");
                    }
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        application = activity3.getApplication();
                    }
                    hotelSearchViewModel9.initPopularSearchRepository(new net.one97.paytm.hotel4.service.a.g(application));
                    HotelSearchViewModel hotelSearchViewModel10 = this.f28915e;
                    if (hotelSearchViewModel10 == null) {
                        kotlin.g.b.k.a("searchViewModel");
                    }
                    hotelSearchViewModel10.fetchTrendingSearchData();
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.location.LocationManager");
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    public final void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.j);
        }
    }

    public static final class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28920a;

        b(o oVar) {
            this.f28920a = oVar;
        }

        public final void a(Location location) {
            kotlin.g.b.k.c(location, "location");
            CJRUtilityLocationModel a2 = this.f28920a.f28918h;
            if (a2 != null) {
                a2.setLatitude(String.valueOf(location.getLatitude()));
            }
            CJRUtilityLocationModel a3 = this.f28920a.f28918h;
            if (a3 != null) {
                a3.setLongitude(String.valueOf(location.getLongitude()));
            }
            net.one97.paytm.hotel4.utils.location.a b2 = this.f28920a.f28919i;
            if (b2 != null) {
                kotlin.g.b.k.c(location, "location");
                new Handler().post(new a.e(b2, location));
            }
        }
    }

    public static final class c implements a.C0500a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28921a;

        c(o oVar) {
            this.f28921a = oVar;
        }

        public final void a(List<Address> list) {
            kotlin.g.b.k.c(list, "addressList");
            Address address = list.get(0);
            if (address.getLocality() != null && address.getAdminArea() != null) {
                CJRUtilityLocationModel a2 = this.f28921a.f28918h;
                if (a2 != null) {
                    a2.setCity(address.getLocality());
                }
                CJRUtilityLocationModel a3 = this.f28921a.f28918h;
                if (a3 != null) {
                    a3.setState(address.getAdminArea());
                }
                CJRUtilityLocationModel a4 = this.f28921a.f28918h;
                if (a4 != null) {
                    a4.setLocality(address.getSubLocality());
                }
                y<String> currentCityName = o.c(this.f28921a).getCurrentCityName();
                StringBuilder sb = new StringBuilder();
                CJRUtilityLocationModel a5 = this.f28921a.f28918h;
                String str = null;
                sb.append(a5 != null ? a5.getLocality() : null);
                sb.append(", ");
                CJRUtilityLocationModel a6 = this.f28921a.f28918h;
                if (a6 != null) {
                    str = a6.getCity();
                }
                sb.append(str);
                currentCityName.postValue(sb.toString());
            }
        }
    }

    public static final class d implements GPSChangeReceiver.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28922a;

        d(o oVar) {
            this.f28922a = oVar;
        }

        public final void a(boolean z) {
            if (z) {
                this.f28922a.f28918h = new CJRUtilityLocationModel();
                net.one97.paytm.hotel4.utils.location.a b2 = this.f28922a.f28919i;
                if (b2 != null) {
                    b2.a();
                }
            } else if (!z) {
                this.f28922a.f28918h = null;
                o.c(this.f28922a).getCurrentCityName().postValue("");
            }
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.hotel4.utils.location.a aVar;
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 57) {
            if (!s.a(iArr) || (aVar = this.f28919i) == null) {
                if (isAdded()) {
                    Toast.makeText(getActivity(), "Please provide Location permission to use this feature.", 1).show();
                }
            } else if (aVar != null) {
                aVar.b();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.hotel4.utils.location.a aVar;
        if (i2 == 115 && i3 == -1 && (aVar = this.f28919i) != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(this.f28917g);
        } else {
            net.one97.paytm.common.widgets.a.b(this.f28917g);
        }
    }

    public static final /* synthetic */ void a(o oVar, List list) {
        new net.one97.paytm.hotel4.service.a.b();
        oVar.getContext();
        ArrayList<AutoSearchDataItem> a2 = net.one97.paytm.hotel4.service.a.b.a();
        net.one97.paytm.hotel4.view.a.j jVar = oVar.f28913b;
        if (jVar == null) {
            kotlin.g.b.k.a("popularAdapter");
        }
        List<AutoSearchDataItem> list2 = a2;
        HotelSearchViewModel hotelSearchViewModel = oVar.f28915e;
        if (hotelSearchViewModel == null) {
            kotlin.g.b.k.a("searchViewModel");
        }
        String searchText = hotelSearchViewModel.getSearchText();
        jVar.f28694b = list2;
        jVar.f28695c = searchText;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(a2);
        arrayList2.addAll(arrayList);
        net.one97.paytm.hotel4.view.a.j jVar2 = oVar.f28913b;
        if (jVar2 == null) {
            kotlin.g.b.k.a("popularAdapter");
        }
        jVar2.a(arrayList2);
    }

    public static final /* synthetic */ void a(o oVar, HotelAutosuggestSearchResponse hotelAutosuggestSearchResponse) {
        v vVar;
        Context context = oVar.getContext();
        if (context != null) {
            kotlin.g.b.k.a((Object) context, "it");
            vVar = new v((v.a) oVar.getActivity(), context);
        } else {
            vVar = null;
        }
        if (vVar == null) {
            kotlin.g.b.k.a();
        }
        oVar.f28914c = vVar;
        ga gaVar = oVar.f28916f;
        if (gaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView = gaVar.f29803h;
        kotlin.g.b.k.a((Object) recyclerView, "this.dataBinding.recycleviewAutoSuggestSearch");
        v vVar2 = oVar.f28914c;
        if (vVar2 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        recyclerView.setAdapter(vVar2);
        ArrayList arrayList = new ArrayList();
        if (hotelAutosuggestSearchResponse == null) {
            kotlin.g.b.k.a();
        }
        HotelSuggestionDataItem suggestions = hotelAutosuggestSearchResponse.getSuggestions();
        if (suggestions == null) {
            kotlin.g.b.k.a();
        }
        List<AutoSearchDataItem> city = suggestions.getCity();
        if (city != null) {
            arrayList.addAll(city);
        }
        Collection collection = arrayList;
        int size = collection.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ((AutoSearchDataItem) arrayList.get(i3)).setViewType(0);
            ((AutoSearchDataItem) arrayList.get(i3)).setType("Cities");
            ((AutoSearchDataItem) arrayList.get(i3)).setViewTypeCount(Integer.valueOf(i2));
            i2++;
        }
        v vVar3 = oVar.f28914c;
        if (vVar3 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        vVar3.f28746d = arrayList;
        ArrayList arrayList2 = new ArrayList();
        HotelSuggestionDataItem suggestions2 = hotelAutosuggestSearchResponse.getSuggestions();
        if (suggestions2 == null) {
            kotlin.g.b.k.a();
        }
        List<AutoSearchDataItem> localities = suggestions2.getLocalities();
        if (localities != null) {
            arrayList2.addAll(localities);
        }
        Collection collection2 = arrayList2;
        int size2 = collection2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size2; i5++) {
            ((AutoSearchDataItem) arrayList2.get(i5)).setViewType(1);
            ((AutoSearchDataItem) arrayList2.get(i5)).setType("Localities");
            ((AutoSearchDataItem) arrayList2.get(i5)).setViewTypeCount(Integer.valueOf(i4));
            i4++;
        }
        v vVar4 = oVar.f28914c;
        if (vVar4 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        vVar4.f28747e = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        HotelSuggestionDataItem suggestions3 = hotelAutosuggestSearchResponse.getSuggestions();
        if (suggestions3 == null) {
            kotlin.g.b.k.a();
        }
        List<AutoSearchDataItem> hotels = suggestions3.getHotels();
        if (hotels != null) {
            arrayList3.addAll(hotels);
        }
        Collection collection3 = arrayList3;
        int size3 = collection3.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size3; i7++) {
            ((AutoSearchDataItem) arrayList3.get(i7)).setViewType(2);
            ((AutoSearchDataItem) arrayList3.get(i7)).setType("Hotels");
            ((AutoSearchDataItem) arrayList3.get(i7)).setViewTypeCount(Integer.valueOf(i6));
            i6++;
        }
        v vVar5 = oVar.f28914c;
        if (vVar5 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        vVar5.f28748f = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(collection);
        arrayList4.addAll(collection2);
        arrayList4.addAll(collection3);
        v vVar6 = oVar.f28914c;
        if (vVar6 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        HotelSearchViewModel hotelSearchViewModel = oVar.f28915e;
        if (hotelSearchViewModel == null) {
            kotlin.g.b.k.a("searchViewModel");
        }
        vVar6.f28744b = hotelSearchViewModel.getSearchText();
        vVar6.notifyDataSetChanged();
        v vVar7 = oVar.f28914c;
        if (vVar7 == null) {
            kotlin.g.b.k.a("autoSuggestAdapter");
        }
        vVar7.a(arrayList4);
    }

    public static final /* synthetic */ void a(o oVar, int i2) {
        ga gaVar = oVar.f28916f;
        if (gaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView = gaVar.f29804i;
        kotlin.g.b.k.a((Object) recyclerView, "this.dataBinding.recycleviewPopularSearch");
        recyclerView.setVisibility(i2 == 0 ? 0 : 8);
        if (i2 == 0) {
            ga gaVar2 = oVar.f28916f;
            if (gaVar2 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            LinearLayout linearLayout = gaVar2.f29802g;
            kotlin.g.b.k.a((Object) linearLayout, "this.dataBinding.noResult");
            linearLayout.setVisibility(8);
        }
        if (i2 == 8) {
            ga gaVar3 = oVar.f28916f;
            if (gaVar3 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            RecyclerView recyclerView2 = gaVar3.f29803h;
            kotlin.g.b.k.a((Object) recyclerView2, "this.dataBinding.recycleviewAutoSuggestSearch");
            recyclerView2.setVisibility(0);
            return;
        }
        ga gaVar4 = oVar.f28916f;
        if (gaVar4 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView3 = gaVar4.f29803h;
        kotlin.g.b.k.a((Object) recyclerView3, "this.dataBinding.recycleviewAutoSuggestSearch");
        recyclerView3.setVisibility(8);
    }

    public static final /* synthetic */ void d(o oVar) {
        CJRUtilityLocationModel cJRUtilityLocationModel = oVar.f28918h;
        if (cJRUtilityLocationModel != null) {
            String str = null;
            if ((cJRUtilityLocationModel != null ? cJRUtilityLocationModel.getLocality() : null) != null) {
                CJRUtilityLocationModel cJRUtilityLocationModel2 = oVar.f28918h;
                if (cJRUtilityLocationModel2 != null) {
                    str = cJRUtilityLocationModel2.getCity();
                }
                if (str != null) {
                    CJRUtilityLocationModel cJRUtilityLocationModel3 = oVar.f28918h;
                    if (cJRUtilityLocationModel3 == null) {
                        kotlin.g.b.k.a();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("lat", cJRUtilityLocationModel3.getLatitude());
                    intent.putExtra("lon", cJRUtilityLocationModel3.getLongitude());
                    intent.putExtra("cityName", cJRUtilityLocationModel3.getCity());
                    intent.putExtra("locality", cJRUtilityLocationModel3.getLocality());
                    intent.putExtra("localitySearchType", "userLocation");
                    FragmentActivity activity = oVar.getActivity();
                    if (activity != null) {
                        activity.setResult(-1, intent);
                    }
                    FragmentActivity activity2 = oVar.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
            }
        }
        oVar.f28918h = new CJRUtilityLocationModel();
        net.one97.paytm.hotel4.utils.location.a aVar = oVar.f28919i;
        if (aVar != null && aVar.f28655e != null) {
            com.google.android.gms.location.f.a(aVar.l).a(aVar.f28656f).a(new a.c(aVar)).a((OnFailureListener) new a.d(aVar));
        }
    }

    public static final /* synthetic */ void e(o oVar) {
        FragmentActivity activity = oVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static final /* synthetic */ void f(o oVar) {
        ga gaVar = oVar.f28916f;
        if (gaVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        ((EditText) gaVar.getRoot().findViewById(R.id.et_search)).setText("");
    }
}
