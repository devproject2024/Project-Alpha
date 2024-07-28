package net.one97.paytm.hotel4.view.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.travel.customViews.CenterZoomLayoutManager;
import com.travel.customViews.GalleryLoopRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.view.a.t;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ay;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.i.h;

public final class ac extends h implements c.b, e {

    /* renamed from: a  reason: collision with root package name */
    private ay f28783a;

    /* renamed from: b  reason: collision with root package name */
    private SharedViewModel f28784b;

    /* renamed from: c  reason: collision with root package name */
    private SRPViewModel f28785c;

    /* renamed from: d  reason: collision with root package name */
    private SRPHeaderViewModel f28786d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.google.android.gms.maps.c f28787e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<com.google.android.gms.maps.model.c> f28788f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.gms.maps.model.c f28789g;

    /* renamed from: h  reason: collision with root package name */
    private final a f28790h = new a(this);

    /* renamed from: i  reason: collision with root package name */
    private final b f28791i = new b(this);

    public static final /* synthetic */ ay a(ac acVar) {
        ay ayVar = acVar.f28783a;
        if (ayVar == null) {
            k.a("fragmentMapBinding");
        }
        return ayVar;
    }

    public static final /* synthetic */ SRPViewModel d(ac acVar) {
        SRPViewModel sRPViewModel = acVar.f28785c;
        if (sRPViewModel == null) {
            k.a("srpViewModel");
        }
        return sRPViewModel;
    }

    public static final /* synthetic */ SharedViewModel e(ac acVar) {
        SharedViewModel sharedViewModel = acVar.f28784b;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        return sharedViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ay a2 = ay.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4FragmentMapBinding.inf…flater, container, false)");
        this.f28783a = a2;
        ay ayVar = this.f28783a;
        if (ayVar == null) {
            k.a("fragmentMapBinding");
        }
        return ayVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28784b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28784b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity, viewModelFactory).a(SRPViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…SRPViewModel::class.java)");
            this.f28785c = (SRPViewModel) a3;
            ai a4 = am.a(activity, viewModelFactory).a(SRPHeaderViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…derViewModel::class.java)");
            this.f28786d = (SRPHeaderViewModel) a4;
            ay ayVar = this.f28783a;
            if (ayVar == null) {
                k.a("fragmentMapBinding");
            }
            SRPViewModel sRPViewModel = this.f28785c;
            if (sRPViewModel == null) {
                k.a("srpViewModel");
            }
            ayVar.a(sRPViewModel);
            ay ayVar2 = this.f28783a;
            if (ayVar2 == null) {
                k.a("fragmentMapBinding");
            }
            SRPHeaderViewModel sRPHeaderViewModel = this.f28786d;
            if (sRPHeaderViewModel == null) {
                k.a("srpHeaderViewModel");
            }
            ayVar2.a(sRPHeaderViewModel);
            SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().c(R.id.gmap);
            if (supportMapFragment != null) {
                supportMapFragment.a(this);
            }
            ay ayVar3 = this.f28783a;
            if (ayVar3 == null) {
                k.a("fragmentMapBinding");
            }
            TextView textView = ayVar3.f29213c;
            k.a((Object) textView, "fragmentMapBinding.cityName");
            SharedViewModel sharedViewModel2 = this.f28784b;
            if (sharedViewModel2 == null) {
                k.a("sharedViewModel");
            }
            CJRHotelSearchInput searchInput = sharedViewModel2.getSearchInput();
            List<SRPDataItem> list = null;
            textView.setText(searchInput != null ? searchInput.getCity() : null);
            SharedViewModel sharedViewModel3 = this.f28784b;
            if (sharedViewModel3 == null) {
                k.a("sharedViewModel");
            }
            HotelSearchResponse searchResponse = sharedViewModel3.getSearchResponse();
            if (searchResponse != null) {
                list = searchResponse.getData();
            }
            if (list == null) {
                k.a();
            }
            t tVar = new t(list);
            t.a aVar = this.f28791i;
            k.c(aVar, "hotelClickListener");
            tVar.f28734a = aVar;
            ay ayVar4 = this.f28783a;
            if (ayVar4 == null) {
                k.a("fragmentMapBinding");
            }
            GalleryLoopRecyclerView galleryLoopRecyclerView = ayVar4.f29215e;
            k.a((Object) galleryLoopRecyclerView, "fragmentMapBinding.hotelsList");
            galleryLoopRecyclerView.setLayoutManager(new CenterZoomLayoutManager(getActivity()));
            ay ayVar5 = this.f28783a;
            if (ayVar5 == null) {
                k.a("fragmentMapBinding");
            }
            ayVar5.f29215e.addItemDecoration(new com.travel.customViews.b());
            ay ayVar6 = this.f28783a;
            if (ayVar6 == null) {
                k.a("fragmentMapBinding");
            }
            GalleryLoopRecyclerView galleryLoopRecyclerView2 = ayVar6.f29215e;
            k.a((Object) galleryLoopRecyclerView2, "fragmentMapBinding.hotelsList");
            galleryLoopRecyclerView2.setAdapter(tVar);
            ay ayVar7 = this.f28783a;
            if (ayVar7 == null) {
                k.a("fragmentMapBinding");
            }
            ayVar7.f29215e.setScrollStopListener(this.f28790h);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r0 = r0.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.gms.maps.c r11) {
        /*
            r10 = this;
            r10.f28787e = r11
            com.google.android.gms.maps.c r0 = r10.f28787e
            if (r0 == 0) goto L_0x0009
            r0.a()
        L_0x0009:
            com.google.android.gms.maps.c r0 = r10.f28787e
            if (r0 == 0) goto L_0x0010
            r0.b()
        L_0x0010:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r10.f28784b
            java.lang.String r1 = "sharedViewModel"
            if (r0 != 0) goto L_0x001a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001a:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r0 = r0.getSearchResponse()
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x002f
            java.util.List r0 = r0.getData()
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            goto L_0x0030
        L_0x002f:
            r0 = r2
        L_0x0030:
            if (r0 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double r5 = r0.getLatitude()
            double r7 = r0.getLongitude()
            r4.<init>(r5, r7)
            r10.a((com.google.android.gms.maps.model.LatLng) r4)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r10.f28784b
            if (r0 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x004c:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r0 = r0.getSearchResponse()
            if (r0 == 0) goto L_0x00e5
            java.util.List r0 = r0.getData()
            if (r0 == 0) goto L_0x00e5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x005e:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00e5
            java.lang.Object r4 = r0.next()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r4 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r4
            com.google.android.gms.maps.model.LatLng r5 = new com.google.android.gms.maps.model.LatLng
            double r6 = r4.getLatitude()
            double r8 = r4.getLongitude()
            r5.<init>(r6, r8)
            com.google.android.gms.maps.model.MarkerOptions r6 = new com.google.android.gms.maps.model.MarkerOptions
            r6.<init>()
            com.google.android.gms.maps.model.MarkerOptions r5 = r6.a((com.google.android.gms.maps.model.LatLng) r5)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.PriceData r6 = r4.getPriceData()
            double r6 = r6.getFinalPrice()
            android.graphics.Bitmap r6 = r10.a((double) r6, (boolean) r3)
            com.google.android.gms.maps.model.a r6 = com.google.android.gms.maps.model.b.a(r6)
            com.google.android.gms.maps.model.MarkerOptions r5 = r5.a((com.google.android.gms.maps.model.a) r6)
            java.lang.String r6 = r4.getName()
            com.google.android.gms.maps.model.MarkerOptions r5 = r5.a((java.lang.String) r6)
            java.lang.String r6 = r4.getLocality()
            com.google.android.gms.maps.model.MarkerOptions r5 = r5.b(r6)
            com.google.android.gms.maps.model.c r5 = r11.a((com.google.android.gms.maps.model.MarkerOptions) r5)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r6 = r10.f28784b
            if (r6 != 0) goto L_0x00af
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00af:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r6 = r6.getSearchResponse()
            if (r6 == 0) goto L_0x00c4
            java.util.List r6 = r6.getData()
            if (r6 == 0) goto L_0x00c4
            int r4 = r6.indexOf(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00c5
        L_0x00c4:
            r4 = r2
        L_0x00c5:
            if (r4 == 0) goto L_0x005e
            r6 = r4
            java.lang.Number r6 = (java.lang.Number) r6
            r6.intValue()
            java.lang.String r6 = "marker"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 1065353216(0x3f800000, float:1.0)
            r5.a((float) r6)
            r5.a((java.lang.Object) r4)
            java.util.List<com.google.android.gms.maps.model.c> r6 = r10.f28788f
            int r4 = r4.intValue()
            r6.add(r4, r5)
            goto L_0x005e
        L_0x00e5:
            com.google.android.gms.maps.c r11 = r10.f28787e
            if (r11 == 0) goto L_0x00ef
            r0 = r10
            com.google.android.gms.maps.c$b r0 = (com.google.android.gms.maps.c.b) r0
            r11.a((com.google.android.gms.maps.c.b) r0)
        L_0x00ef:
            kotlin.g.b.x$c r11 = new kotlin.g.b.x$c
            r11.<init>()
            r11.element = r3
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r0 = r10.f28785c
            if (r0 != 0) goto L_0x0100
            java.lang.String r4 = "srpViewModel"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0100:
            androidx.lifecycle.y r0 = r0.getSelectedData()
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            if (r0 == 0) goto L_0x012f
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r10.f28784b
            if (r4 != 0) goto L_0x0113
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0113:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r4 = r4.getSearchResponse()
            if (r4 == 0) goto L_0x011d
            java.util.List r2 = r4.getData()
        L_0x011d:
            if (r2 != 0) goto L_0x0122
            kotlin.g.b.k.a()
        L_0x0122:
            int r0 = r2.indexOf(r0)
            r11.element = r0
            int r0 = r11.element
            r2 = -1
            if (r0 != r2) goto L_0x012f
            r11.element = r3
        L_0x012f:
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r2 = r10.f28784b
            if (r2 != 0) goto L_0x0138
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0138:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r2 = r2.getSearchResponse()
            if (r2 != 0) goto L_0x0141
            kotlin.g.b.k.a()
        L_0x0141:
            java.util.List r2 = r2.getData()
            if (r2 != 0) goto L_0x014a
            kotlin.g.b.k.a()
        L_0x014a:
            int r3 = r11.element
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r2 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r2
            double r2 = r2.getLatitude()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r4 = r10.f28784b
            if (r4 != 0) goto L_0x015d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x015d:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r1 = r4.getSearchResponse()
            if (r1 != 0) goto L_0x0166
            kotlin.g.b.k.a()
        L_0x0166:
            java.util.List r1 = r1.getData()
            if (r1 != 0) goto L_0x016f
            kotlin.g.b.k.a()
        L_0x016f:
            int r4 = r11.element
            java.lang.Object r1 = r1.get(r4)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r1 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r1
            double r4 = r1.getLongitude()
            r0.<init>(r2, r4)
            com.google.android.gms.maps.c r1 = r10.f28787e
            if (r1 == 0) goto L_0x018b
            r2 = 1096810496(0x41600000, float:14.0)
            com.google.android.gms.maps.a r0 = com.google.android.gms.maps.b.a(r0, r2)
            r1.a((com.google.android.gms.maps.a) r0)
        L_0x018b:
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.hotel4.view.ui.a.ac$c r1 = new net.one97.paytm.hotel4.view.ui.a.ac$c
            r1.<init>(r10, r11)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 750(0x2ee, double:3.705E-321)
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.ac.a(com.google.android.gms.maps.c):void");
    }

    public final boolean a(com.google.android.gms.maps.model.c cVar) {
        Object d2 = cVar.d();
        if (d2 == null) {
            return false;
        }
        new Handler().post(new d(d2, this));
        return false;
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f28796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ac f28797b;

        d(Object obj, ac acVar) {
            this.f28796a = obj;
            this.f28797b = acVar;
        }

        public final void run() {
            GalleryLoopRecyclerView galleryLoopRecyclerView = ac.a(this.f28797b).f29215e;
            Object obj = this.f28796a;
            if (obj != null) {
                galleryLoopRecyclerView.smoothScrollToPosition(((Integer) obj).intValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class a implements GalleryLoopRecyclerView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f28792a;

        a(ac acVar) {
            this.f28792a = acVar;
        }

        public final void a(int i2) {
            if (i2 >= 0 && this.f28792a.f28787e != null) {
                ac acVar = this.f28792a;
                ac.a(acVar, (com.google.android.gms.maps.model.c) acVar.f28788f.get(i2));
                ac acVar2 = this.f28792a;
                LatLng a2 = ((com.google.android.gms.maps.model.c) acVar2.f28788f.get(i2)).a();
                k.a((Object) a2, "markerList[position].position");
                acVar2.a(a2);
            }
        }
    }

    public static final class b implements t.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f28793a;

        b(ac acVar) {
            this.f28793a = acVar;
        }

        public final void a(SRPDataItem sRPDataItem) {
            k.c(sRPDataItem, "hotel");
            ac.d(this.f28793a).getSelectedData().setValue(sRPDataItem);
            ac.e(this.f28793a).postScreenNavigationEvent("4", "5");
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f28794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.c f28795b;

        c(ac acVar, x.c cVar) {
            this.f28794a = acVar;
            this.f28795b = cVar;
        }

        public final void run() {
            ac.a(this.f28794a).f29215e.smoothScrollToPosition(this.f28795b.element);
        }
    }

    /* access modifiers changed from: private */
    public final void a(LatLng latLng) {
        CameraPosition d2 = new CameraPosition.a().a(latLng).a().c().b().d();
        com.google.android.gms.maps.c cVar = this.f28787e;
        if (cVar != null) {
            cVar.b(com.google.android.gms.maps.b.a(d2));
        }
    }

    private final Bitmap a(double d2, boolean z) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Context context = getContext();
        Drawable drawable = null;
        Object systemService = context != null ? context.getSystemService("layout_inflater") : null;
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.h4_custom_marker_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.priceText);
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.backgroundLayout);
            a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
            a.C0498a.a(textView, d2);
            if (z) {
                Context context2 = getContext();
                if (!(context2 == null || (resources4 = context2.getResources()) == null)) {
                    textView.setTextColor(resources4.getColor(R.color.white));
                }
                k.a((Object) constraintLayout, "markerLayout");
                Context context3 = getContext();
                if (!(context3 == null || (resources3 = context3.getResources()) == null)) {
                    drawable = resources3.getDrawable(R.drawable.h4_ic_blue_map_marker);
                }
                constraintLayout.setBackground(drawable);
            } else {
                Context context4 = getContext();
                if (!(context4 == null || (resources2 = context4.getResources()) == null)) {
                    textView.setTextColor(resources2.getColor(R.color.color_4a4a4a));
                }
                k.a((Object) constraintLayout, "markerLayout");
                Context context5 = getContext();
                if (!(context5 == null || (resources = context5.getResources()) == null)) {
                    drawable = resources.getDrawable(R.drawable.h4_ic_white_map_marker);
                }
                constraintLayout.setBackground(drawable);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Context context6 = getContext();
            if (context6 != null) {
                WindowManager windowManager = ((Activity) context6).getWindowManager();
                k.a((Object) windowManager, "(context as Activity).windowManager");
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                k.a((Object) inflate, "marker");
                inflate.setLayoutParams(new ViewGroup.LayoutParams(52, -2));
                inflate.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
                inflate.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                Bitmap createBitmap = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                inflate.draw(new Canvas(createBitmap));
                k.a((Object) createBitmap, "bitmap");
                return createBitmap;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public static final /* synthetic */ void a(ac acVar, com.google.android.gms.maps.model.c cVar) {
        Object d2;
        if (!k.a((Object) cVar, (Object) acVar.f28789g)) {
            cVar.b();
            cVar.a(2.0f);
            Object d3 = cVar.d();
            if (d3 != null) {
                SharedViewModel sharedViewModel = acVar.f28784b;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                HotelSearchResponse searchResponse = sharedViewModel.getSearchResponse();
                if (searchResponse == null) {
                    k.a();
                }
                List<SRPDataItem> data = searchResponse.getData();
                if (data == null) {
                    k.a();
                }
                if (d3 != null) {
                    cVar.a(com.google.android.gms.maps.model.b.a(acVar.a(data.get(((Integer) d3).intValue()).getPriceData().getFinalPrice(), true)));
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Int");
                }
            }
            com.google.android.gms.maps.model.c cVar2 = acVar.f28789g;
            if (cVar2 != null) {
                cVar2.c();
            }
            com.google.android.gms.maps.model.c cVar3 = acVar.f28789g;
            if (cVar3 != null) {
                cVar3.a(1.0f);
            }
            com.google.android.gms.maps.model.c cVar4 = acVar.f28789g;
            if (!(cVar4 == null || (d2 = cVar4.d()) == null)) {
                SharedViewModel sharedViewModel2 = acVar.f28784b;
                if (sharedViewModel2 == null) {
                    k.a("sharedViewModel");
                }
                HotelSearchResponse searchResponse2 = sharedViewModel2.getSearchResponse();
                if (searchResponse2 == null) {
                    k.a();
                }
                List<SRPDataItem> data2 = searchResponse2.getData();
                if (data2 == null) {
                    k.a();
                }
                if (d2 != null) {
                    double finalPrice = data2.get(((Integer) d2).intValue()).getPriceData().getFinalPrice();
                    com.google.android.gms.maps.model.c cVar5 = acVar.f28789g;
                    if (cVar5 != null) {
                        cVar5.a(com.google.android.gms.maps.model.b.a(acVar.a(finalPrice, false)));
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Int");
                }
            }
            acVar.f28789g = cVar;
        }
    }
}
