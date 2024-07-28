package com.travel.train.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.activity.AJRMetroRouteSearchResultActivity;
import com.travel.train.activity.AJRTrainMetroStationSelection;
import com.travel.train.c.a;
import com.travel.train.j.v;
import com.travel.train.k.g;
import com.travel.train.model.metro.CJRDeepLinksModel;
import com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel;
import com.travel.train.model.metro.CJRMetroListModesApiModel;
import com.travel.train.model.metro.CJRMetroSelectedModelForBus;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import com.travel.utils.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.widgets.RoboButton;

public final class FJRMetroHomeFragment extends am implements com.travel.common.a.b, a.C0486a {
    public static final a Factory = new a((byte) 0);
    private HashMap _$_findViewCache;
    private RoboTextView changeCityTextview;
    private ImageView changeStationImageView;
    /* access modifiers changed from: private */
    public f cityBottomSheet;
    private boolean deeplinkHappening;
    /* access modifiers changed from: private */
    public String destinationStationCode;
    /* access modifiers changed from: private */
    public RoboTextView destinationStationCodeTextView;
    private ViewGroup destinationStationLayout;
    private RoboTextView destinationStationTextview;
    private boolean isBottomSheetShown;
    private boolean isFragmentPaused;
    /* access modifiers changed from: private */
    public boolean isStoreFrontFragmentAddPending = true;
    /* access modifiers changed from: private */
    public ArrayList<CJRMetroHomeCityBottomSheetModel> listModesDetail;
    private LottieAnimationView lottieAnimationView;
    private Animation mAnimMoveBottom;
    private Animation mAnimMoveTop;
    /* access modifiers changed from: private */
    public Fragment mEndLessFragment;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    private long mLastLoadTime;
    private Animation mRotateAnimation;
    private Animation mRotateAnimationful;
    private com.travel.train.k.d mViewModel;
    private RoboTextView metroCityNameTextview;
    private com.travel.train.f.a metroHomeFragmentPresenter;
    private RecyclerView metroHomeStripRecyclerview;
    private CJRMetroListModesApiModel metroListMode;
    private ImageView metroLogoImageView;
    private String modeIdFromDeeplink;
    /* access modifiers changed from: private */
    public NestedScrollView nestedScrollView;
    /* access modifiers changed from: private */
    public ArrayList<CJRParcelableMetroStationModel> previousSearchedList;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener scrollListener;
    private RoboButton searchRouteButton;
    /* access modifiers changed from: private */
    public String selectedCityModeId;
    /* access modifiers changed from: private */
    public String selectedCityName;
    /* access modifiers changed from: private */
    public String sourceStationCode;
    private RoboTextView sourceStationCodeTextView;
    private ViewGroup sourceStationLayout;
    /* access modifiers changed from: private */
    public RoboTextView sourceStationTextview;

    static final class f<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f26681a = new f();

        f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class h<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f26683a = new h();

        h() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

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

    static final class e<T> implements io.reactivex.rxjava3.d.g<CJRParcelableMetroStationModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26680a;

        e(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26680a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRParcelableMetroStationModel cJRParcelableMetroStationModel = (CJRParcelableMetroStationModel) obj;
            FJRMetroHomeFragment.access$getSourceStationTextview$p(this.f26680a).setText(cJRParcelableMetroStationModel.sourceStation);
            FJRMetroHomeFragment.access$getSourceStationTextview$p(this.f26680a).setTypeface(Typeface.DEFAULT_BOLD);
            this.f26680a.sourceStationCode = cJRParcelableMetroStationModel.sourceStationCode;
            FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26680a).setText(cJRParcelableMetroStationModel.destinationStation);
            FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26680a).setTypeface(Typeface.DEFAULT_BOLD);
            this.f26680a.destinationStationCode = cJRParcelableMetroStationModel.destinationStationCode;
        }
    }

    static final class g<T> implements io.reactivex.rxjava3.d.g<CJRDeepLinksModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26682a;

        g(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26682a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRDeepLinksModel cJRDeepLinksModel = (CJRDeepLinksModel) obj;
            CharSequence charSequence = cJRDeepLinksModel.deeplink_url;
            if (!(charSequence == null || charSequence.length() == 0)) {
                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26682a;
                String str = cJRDeepLinksModel.deeplink_url;
                kotlin.g.b.k.a((Object) str, "deepLinkModel.deeplink_url");
                fJRMetroHomeFragment.checkDeepLinking(str);
            }
        }
    }

    static final class n<T> implements io.reactivex.rxjava3.d.g<CJRMetroHomeCityBottomSheetModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26689a;

        n(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26689a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = (CJRMetroHomeCityBottomSheetModel) obj;
            if (this.f26689a.cityBottomSheet != null) {
                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26689a;
                v vVar = v.f27608a;
                FragmentActivity activity = this.f26689a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                Context baseContext = activity.getBaseContext();
                kotlin.g.b.k.a((Object) baseContext, "activity!!.baseContext");
                fJRMetroHomeFragment.previousSearchedList = v.a(baseContext);
                if (FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26689a) != null && FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26689a).isVisible()) {
                    FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26689a).dismiss();
                }
                if (this.f26689a.selectedCityModeId != null && (!kotlin.g.b.k.a((Object) this.f26689a.selectedCityModeId, (Object) cJRMetroHomeCityBottomSheetModel.modeid))) {
                    this.f26689a.removeAllData();
                }
                String str = cJRMetroHomeCityBottomSheetModel.name;
                this.f26689a.selectedCityName = str;
                FJRMetroHomeFragment.access$getMetroCityNameTextview$p(this.f26689a).setText(str);
                this.f26689a.selectedCityModeId = cJRMetroHomeCityBottomSheetModel.modeid;
                FJRMetroHomeFragment fJRMetroHomeFragment2 = this.f26689a;
                List<CJRDeepLinksModel> list = cJRMetroHomeCityBottomSheetModel.deeplinks;
                kotlin.g.b.k.a((Object) list, "selectedModel.deeplinks");
                fJRMetroHomeFragment2.showHomeStrip(list);
                if (FJRMetroHomeFragment.access$getMetroLogoImageView$p(this.f26689a).getVisibility() != 0) {
                    FJRMetroHomeFragment.access$getMetroLogoImageView$p(this.f26689a).setVisibility(0);
                }
                b.a aVar = com.paytm.utility.b.b.f43744a;
                Context context = this.f26689a.getContext();
                if (context == null) {
                    FragmentActivity activity2 = this.f26689a.getActivity();
                    if (activity2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity2, "activity!!");
                    context = activity2.getBaseContext();
                    kotlin.g.b.k.a((Object) context, "activity!!.baseContext");
                }
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = cJRMetroHomeCityBottomSheetModel.img_url;
                b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).b(Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).a(0, b.a.ALL), FJRMetroHomeFragment.access$getMetroLogoImageView$p(this.f26689a), (com.paytm.utility.b.b.b) null, 2);
                if (this.f26689a.previousSearchedList != null) {
                    String str2 = cJRMetroHomeCityBottomSheetModel.modeid;
                    ArrayList access$getPreviousSearchedList$p = this.f26689a.previousSearchedList;
                    if (access$getPreviousSearchedList$p == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!kotlin.g.b.k.a((Object) str2, (Object) ((CJRParcelableMetroStationModel) access$getPreviousSearchedList$p.get(0)).modeId)) {
                        v vVar2 = v.f27608a;
                        FragmentActivity activity3 = this.f26689a.getActivity();
                        if (activity3 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity3, "activity!!");
                        Context baseContext2 = activity3.getBaseContext();
                        kotlin.g.b.k.a((Object) baseContext2, "activity!!.baseContext");
                        v.b(baseContext2);
                    }
                }
            }
        }
    }

    static final class p<T> implements io.reactivex.rxjava3.d.g<CJRMetroSelectedModelForBus> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26691a;

        p(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26691a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRMetroSelectedModelForBus cJRMetroSelectedModelForBus = (CJRMetroSelectedModelForBus) obj;
            if (cJRMetroSelectedModelForBus.type == com.travel.train.j.g.F) {
                if (this.f26691a.sourceStationTextview != null) {
                    FJRMetroHomeFragment.access$getSourceStationTextview$p(this.f26691a).setText(cJRMetroSelectedModelForBus.selectedStation.name);
                    FJRMetroHomeFragment.access$getSourceStationTextview$p(this.f26691a).setTypeface(Typeface.DEFAULT_BOLD);
                    this.f26691a.sourceStationCode = cJRMetroSelectedModelForBus.selectedStation.stationid;
                    CharSequence obj2 = FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26691a).getText().toString();
                    if (((obj2 == null || obj2.length() == 0) || this.f26691a.destinationStationCode == null) && !TextUtils.isEmpty(this.f26691a.selectedCityModeId)) {
                        this.f26691a.mHandler.postDelayed(new Runnable(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ p f26692a;

                            {
                                this.f26692a = r1;
                            }

                            public final void run() {
                                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26692a.f26691a;
                                int i2 = com.travel.train.j.g.G;
                                String access$getSelectedCityModeId$p = this.f26692a.f26691a.selectedCityModeId;
                                if (access$getSelectedCityModeId$p == null) {
                                    kotlin.g.b.k.a();
                                }
                                fJRMetroHomeFragment.launchSearchStationFragment(i2, access$getSelectedCityModeId$p);
                            }
                        }, 500);
                    }
                }
            } else if (this.f26691a.destinationStationCodeTextView != null) {
                FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26691a).setText(cJRMetroSelectedModelForBus.selectedStation.name);
                FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26691a).setTypeface(Typeface.DEFAULT_BOLD);
                this.f26691a.destinationStationCode = cJRMetroSelectedModelForBus.selectedStation.stationid;
            }
        }
    }

    static final class q<T> implements z<CJRMetroListModesApiModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26693a;

        q(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26693a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRMetroListModesApiModel cJRMetroListModesApiModel = (CJRMetroListModesApiModel) obj;
            FJRMetroHomeFragment fJRMetroHomeFragment = this.f26693a;
            if (cJRMetroListModesApiModel == null) {
                kotlin.g.b.k.a();
            }
            fJRMetroHomeFragment.setMetroListModes(cJRMetroListModesApiModel);
        }
    }

    public static final /* synthetic */ f access$getCityBottomSheet$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        f fVar = fJRMetroHomeFragment.cityBottomSheet;
        if (fVar == null) {
            kotlin.g.b.k.a("cityBottomSheet");
        }
        return fVar;
    }

    public static final /* synthetic */ RoboTextView access$getDestinationStationTextview$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        RoboTextView roboTextView = fJRMetroHomeFragment.destinationStationTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("destinationStationTextview");
        }
        return roboTextView;
    }

    public static final /* synthetic */ LottieAnimationView access$getLottieAnimationView$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        LottieAnimationView lottieAnimationView2 = fJRMetroHomeFragment.lottieAnimationView;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("lottieAnimationView");
        }
        return lottieAnimationView2;
    }

    public static final /* synthetic */ RoboTextView access$getMetroCityNameTextview$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        RoboTextView roboTextView = fJRMetroHomeFragment.metroCityNameTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("metroCityNameTextview");
        }
        return roboTextView;
    }

    public static final /* synthetic */ com.travel.train.f.a access$getMetroHomeFragmentPresenter$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        com.travel.train.f.a aVar = fJRMetroHomeFragment.metroHomeFragmentPresenter;
        if (aVar == null) {
            kotlin.g.b.k.a("metroHomeFragmentPresenter");
        }
        return aVar;
    }

    public static final /* synthetic */ RecyclerView access$getMetroHomeStripRecyclerview$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        RecyclerView recyclerView = fJRMetroHomeFragment.metroHomeStripRecyclerview;
        if (recyclerView == null) {
            kotlin.g.b.k.a("metroHomeStripRecyclerview");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ImageView access$getMetroLogoImageView$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        ImageView imageView = fJRMetroHomeFragment.metroLogoImageView;
        if (imageView == null) {
            kotlin.g.b.k.a("metroLogoImageView");
        }
        return imageView;
    }

    public static final /* synthetic */ RoboTextView access$getSourceStationTextview$p(FJRMetroHomeFragment fJRMetroHomeFragment) {
        RoboTextView roboTextView = fJRMetroHomeFragment.sourceStationTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("sourceStationTextview");
        }
        return roboTextView;
    }

    public final void onAttach(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        super.onAttach(activity);
        com.google.android.play.core.splitcompat.a.a((Context) activity);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_metro_home_fragment_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        initMVVM();
        getIntentData();
        initView(view);
        observeViewModel();
        updateViewModelDataFromIntent();
        initScrollView();
        sendCustomeEvent();
        checkStoreFrontWidget();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void getIntentData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Object obj = null;
            if (arguments.containsKey(com.travel.train.j.g.A)) {
                Bundle arguments2 = getArguments();
                this.modeIdFromDeeplink = arguments2 != null ? arguments2.getString(com.travel.train.j.g.A) : null;
            }
            if (arguments.containsKey("metro_list_mode_details")) {
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    obj = arguments3.get("metro_list_mode_details");
                }
                this.metroListMode = (CJRMetroListModesApiModel) obj;
            }
        }
    }

    private final void updateViewModelDataFromIntent() {
        com.travel.train.k.d dVar;
        CJRMetroListModesApiModel cJRMetroListModesApiModel = this.metroListMode;
        if (cJRMetroListModesApiModel != null && (dVar = this.mViewModel) != null) {
            if (cJRMetroListModesApiModel == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(cJRMetroListModesApiModel, "listModes");
            dVar.k.postValue(cJRMetroListModesApiModel);
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && !this.isBottomSheetShown) {
            this.isBottomSheetShown = true;
            checkForBottomSheet();
        }
    }

    private final void initMVVM() {
        if (getActivity() != null) {
            g.a aVar = new g.a(g.b.V2_HOME);
            a.C0484a aVar2 = com.travel.train.a.a.f25797a;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            com.travel.train.k.g gVar = new com.travel.train.k.g(aVar.a(aVar2.a(new com.travel.train.a.a.a(activity))));
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            this.mViewModel = (com.travel.train.k.d) am.a(activity2, (al.b) gVar).a(com.travel.train.k.d.class);
        }
    }

    private final void observeViewModel() {
        com.travel.train.k.d dVar = this.mViewModel;
        if (dVar != null) {
            if (dVar == null) {
                kotlin.g.b.k.a();
            }
            dVar.k.observe(this, new q(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r2 = (r2 = r2.modes).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMetroListModes(com.travel.train.model.metro.CJRMetroListModesApiModel r2) {
        /*
            r1 = this;
            com.travel.train.model.metro.CJRMetroListModeBodyModel r2 = r2.getBody()
            if (r2 == 0) goto L_0x0016
            java.util.List<com.travel.train.model.metro.CJRMetroModeModel> r2 = r2.modes
            if (r2 == 0) goto L_0x0016
            r0 = 0
            java.lang.Object r2 = r2.get(r0)
            com.travel.train.model.metro.CJRMetroModeModel r2 = (com.travel.train.model.metro.CJRMetroModeModel) r2
            if (r2 == 0) goto L_0x0016
            java.util.List<com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel> r2 = r2.data
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 == 0) goto L_0x0021
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r1.listModesDetail = r2
            r1.prepareModeView()
            return
        L_0x0021:
            kotlin.u r2 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel> /* = java.util.ArrayList<com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel> */"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.FJRMetroHomeFragment.setMetroListModes(com.travel.train.model.metro.CJRMetroListModesApiModel):void");
    }

    public final void initView(View view) {
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.metro_city_name);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.metro_city_name)");
        this.metroCityNameTextview = (RoboTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.change_city_textview);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.change_city_textview)");
        this.changeCityTextview = (RoboTextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.metro_home_strip_recyclerview);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.m…_home_strip_recyclerview)");
        this.metroHomeStripRecyclerview = (RecyclerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.source_station_textview);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.source_station_textview)");
        this.sourceStationTextview = (RoboTextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.destination_station_textview);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.d…ination_station_textview)");
        this.destinationStationTextview = (RoboTextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.change_station_imageview);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.change_station_imageview)");
        this.changeStationImageView = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.search_route_btn);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.search_route_btn)");
        this.searchRouteButton = (RoboButton) findViewById7;
        View findViewById8 = view.findViewById(R.id.source_station_code);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.source_station_code)");
        this.sourceStationCodeTextView = (RoboTextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.dest_station_code);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.dest_station_code)");
        this.destinationStationCodeTextView = (RoboTextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.metro_logo_imageview);
        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById(R.id.metro_logo_imageview)");
        this.metroLogoImageView = (ImageView) findViewById10;
        ImageView imageView = this.metroLogoImageView;
        if (imageView == null) {
            kotlin.g.b.k.a("metroLogoImageView");
        }
        ResourceUtils.loadTrainImagesFromCDN(imageView, "delhi_metro_logo.png", false, false, n.a.V1);
        View findViewById11 = view.findViewById(R.id.lottie_in_metro_home_fragment);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.l…e_in_metro_home_fragment)");
        this.lottieAnimationView = (LottieAnimationView) findViewById11;
        View findViewById12 = view.findViewById(R.id.source_station);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.source_station)");
        this.sourceStationLayout = (ViewGroup) findViewById12;
        View findViewById13 = view.findViewById(R.id.destination_station);
        kotlin.g.b.k.a((Object) findViewById13, "view.findViewById(R.id.destination_station)");
        this.destinationStationLayout = (ViewGroup) findViewById13;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.train_rotate);
        kotlin.g.b.k.a((Object) loadAnimation, "AnimationUtils.loadAnima…ity, R.anim.train_rotate)");
        this.mRotateAnimation = loadAnimation;
        Animation animation = this.mRotateAnimation;
        if (animation == null) {
            kotlin.g.b.k.a("mRotateAnimation");
        }
        animation.setRepeatCount(1);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.train_rotate360);
        kotlin.g.b.k.a((Object) loadAnimation2, "AnimationUtils.loadAnima…, R.anim.train_rotate360)");
        this.mRotateAnimationful = loadAnimation2;
        Animation animation2 = this.mRotateAnimationful;
        if (animation2 == null) {
            kotlin.g.b.k.a("mRotateAnimationful");
        }
        animation2.setRepeatCount(1);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.train_top_bottom);
        kotlin.g.b.k.a((Object) loadAnimation3, "AnimationUtils.loadAnima… R.anim.train_top_bottom)");
        this.mAnimMoveBottom = loadAnimation3;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(getActivity(), R.anim.train_move_up);
        kotlin.g.b.k.a((Object) loadAnimation4, "AnimationUtils.loadAnima…    R.anim.train_move_up)");
        this.mAnimMoveTop = loadAnimation4;
        this.metroHomeFragmentPresenter = new com.travel.train.f.a(this);
        v vVar = v.f27608a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Context baseContext = activity.getBaseContext();
        kotlin.g.b.k.a((Object) baseContext, "activity!!.baseContext");
        this.previousSearchedList = v.a(baseContext);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        String str = this.modeIdFromDeeplink;
        if (str != null) {
            this.selectedCityModeId = str;
            com.travel.train.f.a aVar = this.metroHomeFragmentPresenter;
            if (aVar == null) {
                kotlin.g.b.k.a("metroHomeFragmentPresenter");
            }
            int i2 = com.travel.train.j.g.E;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            aVar.a(i2, context);
        }
        RoboTextView roboTextView = this.changeCityTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("changeCityTextview");
        }
        roboTextView.setOnClickListener(new i(this));
        RoboButton roboButton = this.searchRouteButton;
        if (roboButton == null) {
            kotlin.g.b.k.a("searchRouteButton");
        }
        roboButton.setOnClickListener(new j(this));
        ViewGroup viewGroup = this.sourceStationLayout;
        if (viewGroup == null) {
            kotlin.g.b.k.a("sourceStationLayout");
        }
        viewGroup.setOnClickListener(new k(this));
        ViewGroup viewGroup2 = this.destinationStationLayout;
        if (viewGroup2 == null) {
            kotlin.g.b.k.a("destinationStationLayout");
        }
        viewGroup2.setOnClickListener(new l(this));
        ImageView imageView2 = this.changeStationImageView;
        if (imageView2 == null) {
            kotlin.g.b.k.a("changeStationImageView");
        }
        imageView2.setOnClickListener(new m(this));
        com.travel.train.g.a aVar2 = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRMetroHomeCityBottomSheetModel.class).subscribe(new n(this), new o(this));
        com.travel.train.g.a aVar3 = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRMetroSelectedModelForBus.class).subscribe(new p(this), new d(this));
        com.travel.train.g.a aVar4 = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRParcelableMetroStationModel.class).subscribe(new e(this), f.f26681a);
        com.travel.train.g.a aVar5 = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRDeepLinksModel.class).subscribe(new g(this), h.f26683a);
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26684a;

        i(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26684a = fJRMetroHomeFragment;
        }

        public final void onClick(View view) {
            if (this.f26684a.listModesDetail != null) {
                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26684a;
                ArrayList access$getListModesDetail$p = fJRMetroHomeFragment.listModesDetail;
                if (access$getListModesDetail$p == null) {
                    kotlin.g.b.k.a();
                }
                fJRMetroHomeFragment.showBottomSheet(access$getListModesDetail$p);
            } else {
                FJRMetroHomeFragment.access$getLottieAnimationView$p(this.f26684a).setVisibility(0);
                com.travel.train.f.a access$getMetroHomeFragmentPresenter$p = FJRMetroHomeFragment.access$getMetroHomeFragmentPresenter$p(this.f26684a);
                int i2 = com.travel.train.j.g.C;
                Context context = this.f26684a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                access$getMetroHomeFragmentPresenter$p.a(i2, context);
            }
            FragmentActivity activity = this.f26684a.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            com.travel.train.j.o.a("metro_home", "", "change_city_clicked", "/trains/metro", activity.getApplicationContext());
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26685a;

        j(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26685a = fJRMetroHomeFragment;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                com.travel.train.fragment.FJRMetroHomeFragment r9 = r8.f26685a
                com.travel.train.f.a r9 = com.travel.train.fragment.FJRMetroHomeFragment.access$getMetroHomeFragmentPresenter$p(r9)
                com.travel.train.fragment.FJRMetroHomeFragment r0 = r8.f26685a
                com.paytm.utility.RoboTextView r0 = com.travel.train.fragment.FJRMetroHomeFragment.access$getSourceStationTextview$p(r0)
                java.lang.CharSequence r0 = r0.getText()
                java.lang.String r0 = r0.toString()
                com.travel.train.fragment.FJRMetroHomeFragment r1 = r8.f26685a
                java.lang.String r1 = r1.sourceStationCode
                com.travel.train.fragment.FJRMetroHomeFragment r2 = r8.f26685a
                com.paytm.utility.RoboTextView r2 = com.travel.train.fragment.FJRMetroHomeFragment.access$getDestinationStationTextview$p(r2)
                java.lang.CharSequence r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                com.travel.train.fragment.FJRMetroHomeFragment r3 = r8.f26685a
                java.lang.String r3 = r3.destinationStationCode
                if (r0 == 0) goto L_0x0091
                if (r2 == 0) goto L_0x0091
                r4 = r0
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r5 = r4.length()
                r6 = 0
                r7 = 1
                if (r5 != 0) goto L_0x003f
                r5 = 1
                goto L_0x0040
            L_0x003f:
                r5 = 0
            L_0x0040:
                if (r5 != 0) goto L_0x0077
                if (r1 != 0) goto L_0x0045
                goto L_0x0077
            L_0x0045:
                r5 = r2
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                int r5 = r5.length()
                if (r5 != 0) goto L_0x0050
                r5 = 1
                goto L_0x0051
            L_0x0050:
                r5 = 0
            L_0x0051:
                if (r5 != 0) goto L_0x0068
                if (r3 != 0) goto L_0x0056
                goto L_0x0068
            L_0x0056:
                boolean r4 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r7)
                if (r4 == 0) goto L_0x0062
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showBothMetroSameAlert()
                goto L_0x00aa
            L_0x0062:
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.launchMetroRouteActivity(r0, r1, r2, r3)
                goto L_0x00aa
            L_0x0068:
                int r0 = r4.length()
                if (r0 != 0) goto L_0x006f
                r6 = 1
            L_0x006f:
                if (r6 != 0) goto L_0x00a5
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showDestinationMetroMissingAlert()
                goto L_0x00aa
            L_0x0077:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r0 = r2.length()
                if (r0 != 0) goto L_0x0080
                r6 = 1
            L_0x0080:
                if (r6 != 0) goto L_0x008b
                if (r3 != 0) goto L_0x0085
                goto L_0x008b
            L_0x0085:
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showSourceMetroMissingAlert()
                goto L_0x00aa
            L_0x008b:
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showBothMetroMissingAlert()
                goto L_0x00aa
            L_0x0091:
                if (r0 != 0) goto L_0x009b
                if (r2 == 0) goto L_0x009b
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showSourceMetroMissingAlert()
                goto L_0x00aa
            L_0x009b:
                if (r2 != 0) goto L_0x00a5
                if (r0 == 0) goto L_0x00a5
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showDestinationMetroMissingAlert()
                goto L_0x00aa
            L_0x00a5:
                com.travel.train.c.a$a r9 = r9.f26656a
                r9.showBothMetroMissingAlert()
            L_0x00aa:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                com.travel.train.fragment.FJRMetroHomeFragment r0 = r8.f26685a
                com.paytm.utility.RoboTextView r0 = com.travel.train.fragment.FJRMetroHomeFragment.access$getSourceStationTextview$p(r0)
                java.lang.CharSequence r0 = r0.getText()
                java.lang.String r0 = r0.toString()
                r9.append(r0)
                java.lang.String r0 = "_to_"
                r9.append(r0)
                com.travel.train.fragment.FJRMetroHomeFragment r0 = r8.f26685a
                com.paytm.utility.RoboTextView r0 = com.travel.train.fragment.FJRMetroHomeFragment.access$getDestinationStationTextview$p(r0)
                java.lang.CharSequence r0 = r0.getText()
                java.lang.String r0 = r0.toString()
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                com.travel.train.fragment.FJRMetroHomeFragment r0 = r8.f26685a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 != 0) goto L_0x00e5
                kotlin.g.b.k.a()
            L_0x00e5:
                java.lang.String r1 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                android.content.Context r0 = r0.getApplicationContext()
                java.lang.String r1 = "metro_home"
                java.lang.String r2 = "source_clicked"
                java.lang.String r3 = "/trains/metro"
                com.travel.train.j.o.a(r1, r9, r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.FJRMetroHomeFragment.j.onClick(android.view.View):void");
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26686a;

        k(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26686a = fJRMetroHomeFragment;
        }

        public final void onClick(View view) {
            if (this.f26686a.selectedCityModeId != null) {
                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26686a;
                int i2 = com.travel.train.j.g.F;
                String access$getSelectedCityModeId$p = this.f26686a.selectedCityModeId;
                if (access$getSelectedCityModeId$p == null) {
                    kotlin.g.b.k.a();
                }
                fJRMetroHomeFragment.launchSearchStationFragment(i2, access$getSelectedCityModeId$p);
            }
            FragmentActivity activity = this.f26686a.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            com.travel.train.j.o.a("metro_home", "", "source_clicked", "/trains/metro", activity.getApplicationContext());
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26687a;

        l(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26687a = fJRMetroHomeFragment;
        }

        public final void onClick(View view) {
            if (this.f26687a.selectedCityModeId != null) {
                FJRMetroHomeFragment fJRMetroHomeFragment = this.f26687a;
                int i2 = com.travel.train.j.g.G;
                String access$getSelectedCityModeId$p = this.f26687a.selectedCityModeId;
                if (access$getSelectedCityModeId$p == null) {
                    kotlin.g.b.k.a();
                }
                fJRMetroHomeFragment.launchSearchStationFragment(i2, access$getSelectedCityModeId$p);
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26688a;

        m(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26688a = fJRMetroHomeFragment;
        }

        public final void onClick(View view) {
            if (this.f26688a.sourceStationCode != null && this.f26688a.destinationStationCode != null) {
                boolean z = true;
                if (FJRMetroHomeFragment.access$getSourceStationTextview$p(this.f26688a).getText().toString().length() > 0) {
                    if (FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26688a).getText().toString().length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        FJRMetroHomeFragment fJRMetroHomeFragment = this.f26688a;
                        String obj = FJRMetroHomeFragment.access$getSourceStationTextview$p(fJRMetroHomeFragment).getText().toString();
                        String access$getSourceStationCode$p = this.f26688a.sourceStationCode;
                        if (access$getSourceStationCode$p == null) {
                            kotlin.g.b.k.a();
                        }
                        String obj2 = FJRMetroHomeFragment.access$getDestinationStationTextview$p(this.f26688a).getText().toString();
                        String access$getDestinationStationCode$p = this.f26688a.destinationStationCode;
                        if (access$getDestinationStationCode$p == null) {
                            kotlin.g.b.k.a();
                        }
                        fJRMetroHomeFragment.flipEntries(obj, access$getSourceStationCode$p, obj2, access$getDestinationStationCode$p);
                        FragmentActivity activity = this.f26688a.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        com.travel.train.j.o.a("metro_ome", "", "swap_clicked", "/trains/metro", activity.getApplicationContext());
                    }
                }
            }
        }
    }

    static final class b implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26677a;

        b(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26677a = fJRMetroHomeFragment;
        }

        public final void onScrollChanged() {
            NestedScrollView access$getNestedScrollView$p = this.f26677a.nestedScrollView;
            if (access$getNestedScrollView$p == null) {
                kotlin.g.b.k.a();
            }
            NestedScrollView access$getNestedScrollView$p2 = this.f26677a.nestedScrollView;
            if (access$getNestedScrollView$p2 == null) {
                kotlin.g.b.k.a();
            }
            View childAt = access$getNestedScrollView$p.getChildAt(access$getNestedScrollView$p2.getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                NestedScrollView access$getNestedScrollView$p3 = this.f26677a.nestedScrollView;
                if (access$getNestedScrollView$p3 == null) {
                    kotlin.g.b.k.a();
                }
                int height = access$getNestedScrollView$p3.getHeight();
                NestedScrollView access$getNestedScrollView$p4 = this.f26677a.nestedScrollView;
                if (access$getNestedScrollView$p4 == null) {
                    kotlin.g.b.k.a();
                }
                if (bottom - (height + access$getNestedScrollView$p4.getScrollY()) == 0) {
                    if (this.f26677a.mEndLessFragment != null && this.f26677a.shouldRequestForLoadMore()) {
                        kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                        com.travel.train.b.b().a(this.f26677a.mEndLessFragment);
                    }
                } else if (this.f26677a.mEndLessFragment != null) {
                    kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                    com.travel.train.b.b().b(this.f26677a.mEndLessFragment);
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type android.view.View");
            }
        }
    }

    private final void initScrollView() {
        this.scrollListener = new b(this);
        NestedScrollView nestedScrollView2 = this.nestedScrollView;
        if (nestedScrollView2 == null) {
            kotlin.g.b.k.a();
        }
        nestedScrollView2.getViewTreeObserver().addOnScrollChangedListener(new c(this));
        this.mLastLoadTime = System.currentTimeMillis();
    }

    static final class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26678a;

        c(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26678a = fJRMetroHomeFragment;
        }

        public final void onScrollChanged() {
            ViewTreeObserver.OnScrollChangedListener unused = this.f26678a.scrollListener;
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.scrollListener != null) {
            NestedScrollView nestedScrollView2 = this.nestedScrollView;
            if ((nestedScrollView2 != null ? nestedScrollView2.getViewTreeObserver() : null) != null) {
                NestedScrollView nestedScrollView3 = this.nestedScrollView;
                if (nestedScrollView3 == null) {
                    kotlin.g.b.k.a();
                }
                ViewTreeObserver viewTreeObserver = nestedScrollView3.getViewTreeObserver();
                kotlin.g.b.k.a((Object) viewTreeObserver, "nestedScrollView!!.viewTreeObserver");
                if (viewTreeObserver.isAlive()) {
                    NestedScrollView nestedScrollView4 = this.nestedScrollView;
                    if (nestedScrollView4 == null) {
                        kotlin.g.b.k.a();
                    }
                    nestedScrollView4.getViewTreeObserver().removeOnDrawListener(new r(this));
                }
            }
        }
    }

    static final class r implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26694a;

        r(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26694a = fJRMetroHomeFragment;
        }

        public final void onDraw() {
            ViewTreeObserver.OnScrollChangedListener unused = this.f26694a.scrollListener;
        }
    }

    /* access modifiers changed from: private */
    public final boolean shouldRequestForLoadMore() {
        if (System.currentTimeMillis() - this.mLastLoadTime <= 1000) {
            return false;
        }
        this.mLastLoadTime = System.currentTimeMillis();
        return true;
    }

    private final void prepareModeView() {
        Object obj;
        Object obj2;
        ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList = this.listModesDetail;
        if (arrayList != null) {
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Boolean bool = ((CJRMetroHomeCityBottomSheetModel) obj).pre_selected;
                kotlin.g.b.k.a((Object) bool, "singleMode.pre_selected");
                if (bool.booleanValue()) {
                    break;
                }
            }
            CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = (CJRMetroHomeCityBottomSheetModel) obj;
            if (cJRMetroHomeCityBottomSheetModel != null) {
                this.selectedCityName = cJRMetroHomeCityBottomSheetModel.name;
                ImageView imageView = this.metroLogoImageView;
                if (imageView == null) {
                    kotlin.g.b.k.a("metroLogoImageView");
                }
                imageView.setVisibility(0);
                RoboTextView roboTextView = this.metroCityNameTextview;
                if (roboTextView == null) {
                    kotlin.g.b.k.a("metroCityNameTextview");
                }
                roboTextView.setText(this.selectedCityName);
                this.selectedCityModeId = cJRMetroHomeCityBottomSheetModel.modeid;
                ArrayList<CJRParcelableMetroStationModel> arrayList2 = this.previousSearchedList;
                if (arrayList2 != null) {
                    if (arrayList2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!arrayList2.isEmpty()) {
                        RoboTextView roboTextView2 = this.sourceStationTextview;
                        if (roboTextView2 == null) {
                            kotlin.g.b.k.a("sourceStationTextview");
                        }
                        ArrayList<CJRParcelableMetroStationModel> arrayList3 = this.previousSearchedList;
                        if (arrayList3 == null) {
                            kotlin.g.b.k.a();
                        }
                        roboTextView2.setText(arrayList3.get(0).sourceStation);
                        RoboTextView roboTextView3 = this.destinationStationTextview;
                        if (roboTextView3 == null) {
                            kotlin.g.b.k.a("destinationStationTextview");
                        }
                        ArrayList<CJRParcelableMetroStationModel> arrayList4 = this.previousSearchedList;
                        if (arrayList4 == null) {
                            kotlin.g.b.k.a();
                        }
                        roboTextView3.setText(arrayList4.get(0).destinationStation);
                        RoboTextView roboTextView4 = this.sourceStationTextview;
                        if (roboTextView4 == null) {
                            kotlin.g.b.k.a("sourceStationTextview");
                        }
                        roboTextView4.setTypeface(Typeface.DEFAULT_BOLD);
                        RoboTextView roboTextView5 = this.destinationStationTextview;
                        if (roboTextView5 == null) {
                            kotlin.g.b.k.a("destinationStationTextview");
                        }
                        roboTextView5.setTypeface(Typeface.DEFAULT_BOLD);
                        ArrayList<CJRParcelableMetroStationModel> arrayList5 = this.previousSearchedList;
                        if (arrayList5 == null) {
                            kotlin.g.b.k.a();
                        }
                        this.sourceStationCode = arrayList5.get(0).sourceStationCode;
                        ArrayList<CJRParcelableMetroStationModel> arrayList6 = this.previousSearchedList;
                        if (arrayList6 == null) {
                            kotlin.g.b.k.a();
                        }
                        this.destinationStationCode = arrayList6.get(0).destinationStationCode;
                    }
                }
                b.a aVar = com.paytm.utility.b.b.f43744a;
                Context context = getContext();
                if (context == null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity, "activity!!");
                    context = activity.getBaseContext();
                    kotlin.g.b.k.a((Object) context, "activity!!.baseContext");
                }
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = cJRMetroHomeCityBottomSheetModel.img_url;
                b.a.C0750a a3 = a2.a((Object) Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).b(Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).a(0, b.a.ALL);
                ImageView imageView2 = this.metroLogoImageView;
                if (imageView2 == null) {
                    kotlin.g.b.k.a("metroLogoImageView");
                }
                b.a.C0750a.a(a3, imageView2, (com.paytm.utility.b.b.b) null, 2);
                List<CJRDeepLinksModel> list = cJRMetroHomeCityBottomSheetModel.deeplinks;
                kotlin.g.b.k.a((Object) list, "mode.deeplinks");
                showHomeStrip(list);
                return;
            }
            ArrayList<CJRParcelableMetroStationModel> arrayList7 = this.previousSearchedList;
            if (arrayList7 != null) {
                if (arrayList7 == null) {
                    kotlin.g.b.k.a();
                }
                CJRParcelableMetroStationModel cJRParcelableMetroStationModel = arrayList7.get(0);
                kotlin.g.b.k.a((Object) cJRParcelableMetroStationModel, "previousSearchedList!![0]");
                CJRParcelableMetroStationModel cJRParcelableMetroStationModel2 = cJRParcelableMetroStationModel;
                this.selectedCityName = cJRParcelableMetroStationModel2.metroCityName;
                RoboTextView roboTextView6 = this.metroCityNameTextview;
                if (roboTextView6 == null) {
                    kotlin.g.b.k.a("metroCityNameTextview");
                }
                roboTextView6.setText(this.selectedCityName);
                this.selectedCityModeId = cJRParcelableMetroStationModel2.modeId;
                ArrayList<CJRParcelableMetroStationModel> arrayList8 = this.previousSearchedList;
                if (arrayList8 == null) {
                    kotlin.g.b.k.a();
                }
                this.sourceStationCode = arrayList8.get(0).sourceStationCode;
                ArrayList<CJRParcelableMetroStationModel> arrayList9 = this.previousSearchedList;
                if (arrayList9 == null) {
                    kotlin.g.b.k.a();
                }
                this.destinationStationCode = arrayList9.get(0).destinationStationCode;
                RoboTextView roboTextView7 = this.sourceStationTextview;
                if (roboTextView7 == null) {
                    kotlin.g.b.k.a("sourceStationTextview");
                }
                ArrayList<CJRParcelableMetroStationModel> arrayList10 = this.previousSearchedList;
                if (arrayList10 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView7.setText(arrayList10.get(0).sourceStation);
                RoboTextView roboTextView8 = this.destinationStationTextview;
                if (roboTextView8 == null) {
                    kotlin.g.b.k.a("destinationStationTextview");
                }
                ArrayList<CJRParcelableMetroStationModel> arrayList11 = this.previousSearchedList;
                if (arrayList11 == null) {
                    kotlin.g.b.k.a();
                }
                roboTextView8.setText(arrayList11.get(0).destinationStation);
                RoboTextView roboTextView9 = this.sourceStationTextview;
                if (roboTextView9 == null) {
                    kotlin.g.b.k.a("sourceStationTextview");
                }
                roboTextView9.setTypeface(Typeface.DEFAULT_BOLD);
                RoboTextView roboTextView10 = this.destinationStationTextview;
                if (roboTextView10 == null) {
                    kotlin.g.b.k.a("destinationStationTextview");
                }
                roboTextView10.setTypeface(Typeface.DEFAULT_BOLD);
                ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList12 = this.listModesDetail;
                if (arrayList12 == null) {
                    kotlin.g.b.k.a();
                }
                Iterator it3 = arrayList12.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it3.next();
                    if (kotlin.g.b.k.a((Object) ((CJRMetroHomeCityBottomSheetModel) obj2).modeid, (Object) this.selectedCityModeId)) {
                        break;
                    }
                }
                CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel2 = (CJRMetroHomeCityBottomSheetModel) obj2;
                if (cJRMetroHomeCityBottomSheetModel2 != null) {
                    ImageView imageView3 = this.metroLogoImageView;
                    if (imageView3 == null) {
                        kotlin.g.b.k.a("metroLogoImageView");
                    }
                    if (imageView3.getVisibility() != 0) {
                        ImageView imageView4 = this.metroLogoImageView;
                        if (imageView4 == null) {
                            kotlin.g.b.k.a("metroLogoImageView");
                        }
                        imageView4.setVisibility(0);
                    }
                    List<CJRDeepLinksModel> list2 = cJRMetroHomeCityBottomSheetModel2.deeplinks;
                    kotlin.g.b.k.a((Object) list2, "city.deeplinks");
                    showHomeStrip(list2);
                    return;
                }
                return;
            }
            ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList13 = this.listModesDetail;
            if (arrayList13 == null) {
                kotlin.g.b.k.a();
            }
            showBottomSheet(arrayList13);
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("lottieAnimationView");
        }
        lottieAnimationView2.setVisibility(0);
        com.travel.train.f.a aVar2 = this.metroHomeFragmentPresenter;
        if (aVar2 == null) {
            kotlin.g.b.k.a("metroHomeFragmentPresenter");
        }
        int i2 = com.travel.train.j.g.D;
        Context context2 = getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context2, "context!!");
        aVar2.a(i2, context2);
    }

    public final void checkForBottomSheet() {
        Object obj;
        ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList = this.listModesDetail;
        if (arrayList != null) {
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Boolean bool = ((CJRMetroHomeCityBottomSheetModel) obj).pre_selected;
                kotlin.g.b.k.a((Object) bool, "singleMode.pre_selected");
                if (bool.booleanValue()) {
                    break;
                }
            }
            if (((CJRMetroHomeCityBottomSheetModel) obj) == null && this.previousSearchedList == null) {
                ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList2 = this.listModesDetail;
                if (arrayList2 == null) {
                    kotlin.g.b.k.a();
                }
                showBottomSheet(arrayList2);
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        this.isFragmentPaused = true;
        super.onSaveInstanceState(bundle);
    }

    public final void onResume() {
        RecyclerView.v findViewHolderForAdapterPosition;
        View view;
        super.onResume();
        this.isFragmentPaused = false;
        kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
        com.travel.common.a b2 = com.travel.train.b.b();
        kotlin.g.b.k.a((Object) b2, "TrainController.getInstance().trainEventListener");
        com.travel.utils.q.b(b2.a());
        FJRMetroHomeFragment.class.getSimpleName();
        if (this.deeplinkHappening) {
            RecyclerView recyclerView = this.metroHomeStripRecyclerview;
            if (recyclerView == null) {
                kotlin.g.b.k.a("metroHomeStripRecyclerview");
            }
            if (!(recyclerView == null || (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0)) == null || (view = findViewHolderForAdapterPosition.itemView) == null)) {
                view.performClick();
            }
            this.deeplinkHappening = false;
        }
    }

    public final void onPause() {
        super.onPause();
        FJRMetroHomeFragment.class.getSimpleName();
    }

    /* access modifiers changed from: private */
    public final void flipEntries(String str, String str2, String str3, String str4) {
        ImageView imageView = this.changeStationImageView;
        if (imageView == null) {
            kotlin.g.b.k.a("changeStationImageView");
        }
        Animation animation = this.mRotateAnimationful;
        if (animation == null) {
            kotlin.g.b.k.a("mRotateAnimationful");
        }
        imageView.startAnimation(animation);
        Animation animation2 = this.mRotateAnimation;
        if (animation2 == null) {
            kotlin.g.b.k.a("mRotateAnimation");
        }
        animation2.setFillAfter(true);
        ViewGroup viewGroup = this.sourceStationLayout;
        if (viewGroup == null) {
            kotlin.g.b.k.a("sourceStationLayout");
        }
        Animation animation3 = this.mAnimMoveTop;
        if (animation3 == null) {
            kotlin.g.b.k.a("mAnimMoveTop");
        }
        viewGroup.startAnimation(animation3);
        ViewGroup viewGroup2 = this.destinationStationLayout;
        if (viewGroup2 == null) {
            kotlin.g.b.k.a("destinationStationLayout");
        }
        Animation animation4 = this.mAnimMoveBottom;
        if (animation4 == null) {
            kotlin.g.b.k.a("mAnimMoveBottom");
        }
        viewGroup2.startAnimation(animation4);
        RoboTextView roboTextView = this.sourceStationTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("sourceStationTextview");
        }
        roboTextView.setText(str3);
        RoboTextView roboTextView2 = this.destinationStationTextview;
        if (roboTextView2 == null) {
            kotlin.g.b.k.a("destinationStationTextview");
        }
        roboTextView2.setText(str);
        this.sourceStationCode = str4;
        this.destinationStationCode = str2;
    }

    public final void removeAllData() {
        RoboTextView roboTextView = this.sourceStationTextview;
        if (roboTextView == null) {
            kotlin.g.b.k.a("sourceStationTextview");
        }
        roboTextView.setText("");
        RoboTextView roboTextView2 = this.destinationStationTextview;
        if (roboTextView2 == null) {
            kotlin.g.b.k.a("destinationStationTextview");
        }
        roboTextView2.setText("");
        RoboTextView roboTextView3 = this.sourceStationTextview;
        if (roboTextView3 == null) {
            kotlin.g.b.k.a("sourceStationTextview");
        }
        roboTextView3.setTypeface(Typeface.create("sans-serif-light", 0));
        RoboTextView roboTextView4 = this.destinationStationTextview;
        if (roboTextView4 == null) {
            kotlin.g.b.k.a("destinationStationTextview");
        }
        roboTextView4.setTypeface(Typeface.create("sans-serif-light", 0));
        this.sourceStationCode = "";
        this.destinationStationCode = "";
    }

    public final void showHomeStrip(List<? extends CJRDeepLinksModel> list) {
        kotlin.g.b.k.c(list, "stripListCJR");
        if (this.metroHomeStripRecyclerview != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            Context baseContext = activity.getBaseContext();
            kotlin.g.b.k.a((Object) baseContext, "activity!!.baseContext");
            com.travel.train.b.g gVar = new com.travel.train.b.g(baseContext, list);
            RecyclerView recyclerView = this.metroHomeStripRecyclerview;
            if (recyclerView == null) {
                kotlin.g.b.k.a("metroHomeStripRecyclerview");
            }
            recyclerView.setAdapter(gVar);
            RecyclerView recyclerView2 = this.metroHomeStripRecyclerview;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("metroHomeStripRecyclerview");
            }
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            RecyclerView recyclerView3 = this.metroHomeStripRecyclerview;
            if (recyclerView3 == null) {
                kotlin.g.b.k.a("metroHomeStripRecyclerview");
            }
            recyclerView3.setHasFixedSize(true);
            RecyclerView recyclerView4 = this.metroHomeStripRecyclerview;
            if (recyclerView4 == null) {
                kotlin.g.b.k.a("metroHomeStripRecyclerview");
            }
            recyclerView4.getViewTreeObserver().addOnPreDrawListener(new u(this));
        }
    }

    public static final class u implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26697a;

        u(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26697a = fJRMetroHomeFragment;
        }

        public final boolean onPreDraw() {
            if (FJRMetroHomeFragment.access$getMetroHomeStripRecyclerview$p(this.f26697a) == null || FJRMetroHomeFragment.access$getMetroHomeStripRecyclerview$p(this.f26697a).findViewHolderForAdapterPosition(0) == null) {
                return false;
            }
            RecyclerView.v findViewHolderForAdapterPosition = FJRMetroHomeFragment.access$getMetroHomeStripRecyclerview$p(this.f26697a).findViewHolderForAdapterPosition(0);
            if (findViewHolderForAdapterPosition == null) {
                kotlin.g.b.k.a();
            }
            View view = findViewHolderForAdapterPosition.itemView;
            if (view != null) {
                view.performClick();
            }
            FJRMetroHomeFragment.access$getMetroHomeStripRecyclerview$p(this.f26697a).getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public final void showBothMetroMissingAlert() {
        Context activity = getActivity();
        FragmentActivity activity2 = getActivity();
        String str = null;
        String string = activity2 != null ? activity2.getString(R.string.snap) : null;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            str = activity3.getString(R.string.metro_both_missing);
        }
        com.paytm.utility.b.b(activity, string, str);
    }

    public final void showSourceMetroMissingAlert() {
        Context activity = getActivity();
        FragmentActivity activity2 = getActivity();
        String str = null;
        String string = activity2 != null ? activity2.getString(R.string.snap) : null;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            str = activity3.getString(R.string.metro_source_missing);
        }
        com.paytm.utility.b.b(activity, string, str);
    }

    public final void showDestinationMetroMissingAlert() {
        Context activity = getActivity();
        FragmentActivity activity2 = getActivity();
        String str = null;
        String string = activity2 != null ? activity2.getString(R.string.snap) : null;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            str = activity3.getString(R.string.metro_destination_missing);
        }
        com.paytm.utility.b.b(activity, string, str);
    }

    public final void showBothMetroSameAlert() {
        Context activity = getActivity();
        FragmentActivity activity2 = getActivity();
        String str = null;
        String string = activity2 != null ? activity2.getString(R.string.snap) : null;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            str = activity3.getString(R.string.both_metro_stations_same);
        }
        com.paytm.utility.b.b(activity, string, str);
    }

    public final void launchMetroRouteActivity(String str, String str2, String str3, String str4) {
        kotlin.g.b.k.c(str, "sourceStationText");
        kotlin.g.b.k.c(str2, "sourceStationCode");
        kotlin.g.b.k.c(str3, "destinationStationText");
        kotlin.g.b.k.c(str4, "destinationStationCode");
        Intent intent = new Intent(getContext(), AJRMetroRouteSearchResultActivity.class);
        String str5 = com.travel.train.j.g.K;
        String str6 = this.selectedCityModeId;
        if (str6 == null) {
            kotlin.g.b.k.a();
        }
        String str7 = this.selectedCityName;
        if (str7 == null) {
            kotlin.g.b.k.a();
        }
        startActivity(intent.putExtra(str5, new CJRParcelableMetroStationModel(str, str2, str3, str4, str6, str7)));
    }

    public final void launchSearchStationFragment(int i2, String str) {
        kotlin.g.b.k.c(str, "modeId");
        if (isAdded()) {
            Intent intent = new Intent(getActivity(), AJRTrainMetroStationSelection.class);
            Bundle bundle = new Bundle();
            bundle.putInt(com.travel.train.j.g.y, i2);
            bundle.putString(com.travel.train.j.g.z, str);
            intent.putExtra("intent_metro_station_data", bundle);
            startActivity(intent);
        }
    }

    public final void showBottomSheet(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList) {
        kotlin.g.b.k.c(arrayList, "cityList");
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing() && isAdded()) {
                LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
                if (lottieAnimationView2 == null) {
                    kotlin.g.b.k.a("lottieAnimationView");
                }
                if (lottieAnimationView2.getVisibility() == 0) {
                    LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
                    if (lottieAnimationView3 == null) {
                        kotlin.g.b.k.a("lottieAnimationView");
                    }
                    lottieAnimationView3.setVisibility(4);
                }
                this.listModesDetail = arrayList;
                this.cityBottomSheet = new f();
                Bundle bundle = new Bundle();
                bundle.putSerializable(com.travel.train.j.g.x, arrayList);
                f fVar = this.cityBottomSheet;
                if (fVar == null) {
                    kotlin.g.b.k.a("cityBottomSheet");
                }
                fVar.setArguments(bundle);
                if (getUserVisibleHint()) {
                    f fVar2 = this.cityBottomSheet;
                    if (fVar2 == null) {
                        kotlin.g.b.k.a("cityBottomSheet");
                    }
                    androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                    kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                    fVar2.show(childFragmentManager, f.class.getSimpleName());
                }
            }
        }
    }

    public final void updateUiIfNoDataPassed(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList) {
        Object obj;
        kotlin.g.b.k.c(arrayList, "cityList");
        if (isAdded()) {
            ImageView imageView = this.metroLogoImageView;
            if (imageView == null) {
                kotlin.g.b.k.a("metroLogoImageView");
            }
            if (imageView.getVisibility() != 0) {
                ImageView imageView2 = this.metroLogoImageView;
                if (imageView2 == null) {
                    kotlin.g.b.k.a("metroLogoImageView");
                }
                imageView2.setVisibility(0);
            }
            LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
            if (lottieAnimationView2 == null) {
                kotlin.g.b.k.a("lottieAnimationView");
            }
            lottieAnimationView2.setVisibility(4);
            ArrayList<CJRParcelableMetroStationModel> arrayList2 = this.previousSearchedList;
            if (arrayList2 != null) {
                if (arrayList2 == null) {
                    kotlin.g.b.k.a();
                }
                if (!arrayList2.isEmpty()) {
                    ArrayList<CJRParcelableMetroStationModel> arrayList3 = this.previousSearchedList;
                    if (arrayList3 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.selectedCityName = arrayList3.get(0).metroCityName;
                    RoboTextView roboTextView = this.metroCityNameTextview;
                    if (roboTextView == null) {
                        kotlin.g.b.k.a("metroCityNameTextview");
                    }
                    roboTextView.setText(this.selectedCityName);
                    ArrayList<CJRParcelableMetroStationModel> arrayList4 = this.previousSearchedList;
                    if (arrayList4 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.selectedCityModeId = arrayList4.get(0).modeId;
                    RoboTextView roboTextView2 = this.sourceStationTextview;
                    if (roboTextView2 == null) {
                        kotlin.g.b.k.a("sourceStationTextview");
                    }
                    ArrayList<CJRParcelableMetroStationModel> arrayList5 = this.previousSearchedList;
                    if (arrayList5 == null) {
                        kotlin.g.b.k.a();
                    }
                    roboTextView2.setText(arrayList5.get(0).sourceStation);
                    RoboTextView roboTextView3 = this.destinationStationTextview;
                    if (roboTextView3 == null) {
                        kotlin.g.b.k.a("destinationStationTextview");
                    }
                    ArrayList<CJRParcelableMetroStationModel> arrayList6 = this.previousSearchedList;
                    if (arrayList6 == null) {
                        kotlin.g.b.k.a();
                    }
                    roboTextView3.setText(arrayList6.get(0).destinationStation);
                    RoboTextView roboTextView4 = this.sourceStationTextview;
                    if (roboTextView4 == null) {
                        kotlin.g.b.k.a("sourceStationTextview");
                    }
                    roboTextView4.setTypeface(Typeface.DEFAULT_BOLD);
                    RoboTextView roboTextView5 = this.destinationStationTextview;
                    if (roboTextView5 == null) {
                        kotlin.g.b.k.a("destinationStationTextview");
                    }
                    roboTextView5.setTypeface(Typeface.DEFAULT_BOLD);
                    ArrayList<CJRParcelableMetroStationModel> arrayList7 = this.previousSearchedList;
                    if (arrayList7 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.sourceStationCode = arrayList7.get(0).sourceStationCode;
                    ArrayList<CJRParcelableMetroStationModel> arrayList8 = this.previousSearchedList;
                    if (arrayList8 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.destinationStationCode = arrayList8.get(0).destinationStationCode;
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str = ((CJRMetroHomeCityBottomSheetModel) obj).modeid;
                        ArrayList<CJRParcelableMetroStationModel> arrayList9 = this.previousSearchedList;
                        if (arrayList9 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (kotlin.g.b.k.a((Object) str, (Object) arrayList9.get(0).modeId)) {
                            break;
                        }
                    }
                    CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = (CJRMetroHomeCityBottomSheetModel) obj;
                    if (cJRMetroHomeCityBottomSheetModel != null) {
                        b.a aVar = com.paytm.utility.b.b.f43744a;
                        Context context = getContext();
                        if (context == null) {
                            FragmentActivity activity = getActivity();
                            if (activity == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) activity, "activity!!");
                            context = activity.getBaseContext();
                            kotlin.g.b.k.a((Object) context, "activity!!.baseContext");
                        }
                        b.a.C0750a a2 = b.a.a(context);
                        a2.f43753a = cJRMetroHomeCityBottomSheetModel.img_url;
                        b.a.C0750a a3 = a2.a((Object) Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).b(Integer.valueOf(R.drawable.pre_t_delhi_metro_logo)).a(0, b.a.ALL);
                        ImageView imageView3 = this.metroLogoImageView;
                        if (imageView3 == null) {
                            kotlin.g.b.k.a("metroLogoImageView");
                        }
                        b.a.C0750a.a(a3, imageView3, (com.paytm.utility.b.b.b) null, 2);
                        List<CJRDeepLinksModel> list = cJRMetroHomeCityBottomSheetModel.deeplinks;
                        kotlin.g.b.k.a((Object) list, "selectedCity.deeplinks");
                        showHomeStrip(list);
                        return;
                    }
                    return;
                }
            }
            showBottomSheet(arrayList);
        }
    }

    public final void getModeIdDetails(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList) {
        Object obj;
        kotlin.g.b.k.c(arrayList, "cityList");
        if (this.selectedCityModeId != null) {
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                obj = it2.next();
                kotlin.g.b.k.a((Object) ((CJRMetroHomeCityBottomSheetModel) obj).modeid, (Object) this.selectedCityModeId);
            } else {
                obj = null;
            }
            CJRMetroHomeCityBottomSheetModel cJRMetroHomeCityBottomSheetModel = (CJRMetroHomeCityBottomSheetModel) obj;
            if (cJRMetroHomeCityBottomSheetModel != null) {
                this.selectedCityName = cJRMetroHomeCityBottomSheetModel.name;
                RoboTextView roboTextView = this.metroCityNameTextview;
                if (roboTextView == null) {
                    kotlin.g.b.k.a("metroCityNameTextview");
                }
                roboTextView.setText(this.selectedCityName);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void checkDeepLinking(String str) {
        kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
        if (com.travel.train.b.b().a(getContext(), str, (Bundle) null)) {
            this.deeplinkHappening = true;
        } else {
            FJRMetroHomeFragment.class.getSimpleName();
        }
    }

    public final void onVisibilityGone() {
        this.isStoreFrontFragmentAddPending = false;
        new Handler().post(new s(this));
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26695a;

        s(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26695a = fJRMetroHomeFragment;
        }

        public final void run() {
            if (this.f26695a.mEndLessFragment != null && this.f26695a.isAdded() && !this.f26695a.isDetached()) {
                this.f26695a.removeStoreFrontFragment();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void removeStoreFrontFragment() {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        Fragment fragment = this.mEndLessFragment;
        if (fragment == null) {
            kotlin.g.b.k.a();
        }
        a2.a(fragment).b();
    }

    static final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26696a;

        t(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26696a = fJRMetroHomeFragment;
        }

        public final void run() {
            if (!this.f26696a.isAdded() || this.f26696a.isDetached()) {
                this.f26696a.isStoreFrontFragmentAddPending = true;
            } else {
                this.f26696a.showStoreFront();
            }
        }
    }

    public final void onVisibleToUser(boolean z) {
        new Handler().post(new t(this));
    }

    public final void checkStoreFrontWidget() {
        if (this.isStoreFrontFragmentAddPending) {
            showStoreFront();
            this.isStoreFrontFragmentAddPending = false;
        }
    }

    public final void showStoreFront() {
        if (!this.isFragmentPaused) {
            getChildFragmentManager().b();
            this.mEndLessFragment = getChildFragmentManager().c("TAG_METRO_OFFER");
            Fragment fragment = this.mEndLessFragment;
            if (fragment != null) {
                if (fragment == null) {
                    kotlin.g.b.k.a();
                }
                if (fragment.isAdded()) {
                    return;
                }
            }
            WeakReference weakReference = null;
            NestedScrollView nestedScrollView2 = this.nestedScrollView;
            if (nestedScrollView2 != null) {
                if (nestedScrollView2 != null) {
                    weakReference = new WeakReference(nestedScrollView2);
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.view.View");
                }
            }
            kotlin.g.b.k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            this.mEndLessFragment = com.travel.train.b.b().a((WeakReference<View>) weakReference);
            Bundle bundle = new Bundle();
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putString("origin", "train");
            bundle.putString("store_front_url_key", "travelMetroStoreFrontURL");
            bundle.putBoolean("trigger-impression-on-visibility", false);
            Fragment fragment2 = this.mEndLessFragment;
            if (fragment2 == null) {
                kotlin.g.b.k.a();
            }
            fragment2.setArguments(bundle);
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            int i2 = R.id.framelayout_storefront_metro;
            Fragment fragment3 = this.mEndLessFragment;
            if (fragment3 == null) {
                kotlin.g.b.k.a();
            }
            a2.b(i2, fragment3, "TAG_METRO_OFFER").b();
        }
    }

    public final void sendCustomeEvent() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            kotlin.g.b.k.a();
        }
        if (arguments.getBoolean("from")) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            com.travel.train.j.o.a("metro_home", "travel_carousel", "screen_load", "/trains/metro", activity.getApplicationContext());
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity2, "activity!!");
        com.travel.train.j.o.a("metro_home", " train_clp", "screen_load", "/trains/metro", activity2.getApplicationContext());
    }

    static final class o<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26690a;

        o(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26690a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26690a) != null && FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26690a).isVisible()) {
                FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26690a).dismiss();
            }
        }
    }

    static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRMetroHomeFragment f26679a;

        d(FJRMetroHomeFragment fJRMetroHomeFragment) {
            this.f26679a = fJRMetroHomeFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26679a) != null && FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26679a).isVisible()) {
                FJRMetroHomeFragment.access$getCityBottomSheet$p(this.f26679a).dismiss();
            }
        }
    }
}
