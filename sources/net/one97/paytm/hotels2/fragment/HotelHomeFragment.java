package net.one97.paytm.hotels2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.common.a.b;
import com.travel.utils.s;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.PopularRecentDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.HotelConfig;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams;
import net.one97.paytm.hotel4.service.model.datamodel.search.Locations;
import net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.c;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.view.ui.activity.AJRHotelActivity;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.d;
import net.one97.paytm.hotels2.utils.e;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class HotelHomeFragment extends h implements b, AllCitySelectedCityListener {
    private String LOG_TAG = "HotelHomeFragment";
    private com.travel.utils.h debounceClick = new com.travel.utils.h(3000);
    private ErrorDialogViewModel errorDialogViewModel;
    /* access modifiers changed from: private */
    public HotelConfig hotelConfig;
    /* access modifiers changed from: private */
    public boolean isCheckingDate;
    private boolean isFragmentPaused;
    /* access modifiers changed from: private */
    public boolean isStoreFrontFragmentAddPending;
    private AutoSearchDataItem mAutoSearchDataItem = new AutoSearchDataItem((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
    private TextView mCheckInDateTextView;
    private TextView mCheckInMonthTextView;
    private TextView mCheckInWeekTextView;
    private TextView mCheckOutDateTextView;
    private TextView mCheckOutMonthTextView;
    private TextView mCheckOutWeekTextView;
    /* access modifiers changed from: private */
    public Fragment mEndlessScrollFragment;
    /* access modifiers changed from: private */
    public CJRHotelSearchInput mHotelSearchInput;
    private TextView mHotelSearchTextView;
    private long mLastLoadTime;
    private Locations mLocationDetails;
    private LottieAnimationView mLottieAnimView;
    private TextView mNightCount;
    private TextView mNightCountText;
    private View mSourceCityLayout;
    private EditText mSourceCityTextView;
    private String msearchType = "";
    public NestedScrollView nestedView;
    private ViewTreeObserver.OnScrollChangedListener scrollListener = HotelHomeFragment$scrollListener$1.INSTANCE;

    public static final /* synthetic */ CJRHotelSearchInput access$getMHotelSearchInput$p(HotelHomeFragment hotelHomeFragment) {
        CJRHotelSearchInput cJRHotelSearchInput = hotelHomeFragment.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        return cJRHotelSearchInput;
    }

    public final String getLOG_TAG() {
        return this.LOG_TAG;
    }

    public final void setLOG_TAG(String str) {
        k.c(str, "<set-?>");
        this.LOG_TAG = str;
    }

    public final NestedScrollView getNestedView() {
        NestedScrollView nestedScrollView = this.nestedView;
        if (nestedScrollView == null) {
            k.a("nestedView");
        }
        return nestedScrollView;
    }

    public final void setNestedView(NestedScrollView nestedScrollView) {
        k.c(nestedScrollView, "<set-?>");
        this.nestedView = nestedScrollView;
    }

    public final ViewTreeObserver.OnScrollChangedListener getScrollListener() {
        return this.scrollListener;
    }

    public final void setScrollListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        k.c(onScrollChangedListener, "<set-?>");
        this.scrollListener = onScrollChangedListener;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.hotel_home_layout, viewGroup, false);
        a.C0498a aVar = a.f28631a;
        e.a();
        a.C0498a.a((ImageView) inflate.findViewById(R.id.hero_img), e.a("HotelHeroImageURL"), com.paytm.utility.b.b.e.HIGH);
        this.mLottieAnimView = (LottieAnimationView) inflate.findViewById(R.id.lottieAnim);
        downalodSrpLoaderAnimationJson((LottieAnimationView) inflate.findViewById(R.id.lottieAnim_dumy));
        View findViewById = inflate.findViewById(R.id.app_bar);
        k.a((Object) findViewById, "view.findViewById(R.id.app_bar)");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.h4_hero_textview);
        k.a((Object) findViewById2, "view.findViewById(R.id.h4_hero_textview)");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.hotel_search);
        Resources resources = getResources();
        k.a((Object) resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        double d2 = (double) (((float) appBarLayout.getLayoutParams().height) - (displayMetrics.density * 100.0f));
        double d3 = 0.9d * d2;
        double d4 = d2 - d3;
        float f2 = displayMetrics.density * 5.0f;
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.constraint_1);
        k.a((Object) constraintLayout, "calendar1");
        net.one97.paytm.hotel4.utils.h.a(constraintLayout, new HotelHomeFragment$onCreateView$1(this));
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.constraint_3);
        k.a((Object) constraintLayout2, "calendar2");
        net.one97.paytm.hotel4.utils.h.a(constraintLayout2, new HotelHomeFragment$onCreateView$2(this));
        View findViewById3 = inflate.findViewById(R.id.nested_scroll);
        k.a((Object) findViewById3, "view.findViewById(R.id.nested_scroll)");
        this.nestedView = (NestedScrollView) findViewById3;
        appBarLayout.a((AppBarLayout.b) new HotelHomeFragment$onCreateView$3(d3, f2, d4, (CardView) inflate.findViewById(R.id.card_view_2), imageView, findViewById2));
        this.scrollListener = new HotelHomeFragment$onCreateView$4(this);
        NestedScrollView nestedScrollView = this.nestedView;
        if (nestedScrollView == null) {
            k.a("nestedView");
        }
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(this.scrollListener);
        this.mLastLoadTime = System.currentTimeMillis();
        View findViewById4 = inflate.findViewById(R.id.checkin_day);
        k.a((Object) findViewById4, "view.findViewById(R.id.checkin_day)");
        this.mCheckInDateTextView = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.checkin_month);
        k.a((Object) findViewById5, "view.findViewById(R.id.checkin_month)");
        this.mCheckInMonthTextView = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.checkin_week);
        k.a((Object) findViewById6, "view.findViewById(R.id.checkin_week)");
        this.mCheckInWeekTextView = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.night_count);
        k.a((Object) findViewById7, "view.findViewById(R.id.night_count)");
        this.mNightCount = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.night_count_text);
        k.a((Object) findViewById8, "view.findViewById(R.id.night_count_text)");
        this.mNightCountText = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.checkout_day);
        k.a((Object) findViewById9, "view.findViewById(R.id.checkout_day)");
        this.mCheckOutDateTextView = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.checkout_month);
        k.a((Object) findViewById10, "view.findViewById(R.id.checkout_month)");
        this.mCheckOutMonthTextView = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.checkout_week);
        k.a((Object) findViewById11, "view.findViewById(R.id.checkout_week)");
        this.mCheckOutWeekTextView = (TextView) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.city_layout);
        k.a((Object) findViewById12, "view.findViewById(R.id.city_layout)");
        this.mSourceCityLayout = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.hotel_city_name);
        k.a((Object) findViewById13, "view.findViewById(R.id.hotel_city_name)");
        this.mSourceCityTextView = (EditText) findViewById13;
        EditText editText = this.mSourceCityTextView;
        if (editText == null) {
            k.a("mSourceCityTextView");
        }
        net.one97.paytm.hotel4.utils.h.a(editText, new HotelHomeFragment$onCreateView$5(this));
        View findViewById14 = inflate.findViewById(R.id.hotel_search_button);
        k.a((Object) findViewById14, "view.findViewById(R.id.hotel_search_button)");
        this.mHotelSearchTextView = (TextView) findViewById14;
        TextView textView = this.mHotelSearchTextView;
        if (textView == null) {
            k.a("mHotelSearchTextView");
        }
        net.one97.paytm.hotel4.utils.h.a(textView, new HotelHomeFragment$onCreateView$6(this));
        this.mHotelSearchInput = new CJRHotelSearchInput();
        setDefaultRoomDetails();
        createHotelConfig();
        getHotelConfig();
        k.a((Object) imageView, "hotelSearchImage");
        net.one97.paytm.hotel4.utils.h.a(imageView, new HotelHomeFragment$onCreateView$7(this));
        a.C0498a aVar2 = a.f28631a;
        a.C0498a.a(imageView, f.c("circularsearch"), com.paytm.utility.b.b.e.HIGH);
        handelDeeplink();
        return inflate;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.isFragmentPaused = true;
    }

    public final void onResume() {
        super.onResume();
        this.isFragmentPaused = false;
    }

    /* access modifiers changed from: private */
    public final boolean shouldRequestForLoadMore() {
        if (System.currentTimeMillis() - this.mLastLoadTime <= 1000) {
            return false;
        }
        this.mLastLoadTime = System.currentTimeMillis();
        return true;
    }

    private final void handelDeeplink() {
        String str;
        int numberOfNights;
        try {
            Bundle arguments = getArguments();
            String str2 = null;
            if (arguments != null) {
                c.a aVar = c.f28638a;
                str = arguments.getString(c.f28639b);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                c.a aVar2 = c.f28638a;
                Uri parse = Uri.parse(arguments2.getString(c.f28639b));
                String queryParameter = parse.getQueryParameter("city");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = parse.getQueryParameter("cityName");
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!TextUtils.isEmpty(parse.getQueryParameter("hotelId"))) {
                        String queryParameter2 = parse.getQueryParameter("hotelId");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            this.msearchType = "searched";
                            AutoSearchDataItem autoSearchDataItem = new AutoSearchDataItem((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
                            SearchParamsDataItem searchParamsDataItem = new SearchParamsDataItem((String) null, (String) null, (String) null, false, false, (FilterParams) null, 63, (g) null);
                            searchParamsDataItem.setCity(queryParameter);
                            if (!TextUtils.isEmpty(parse.getQueryParameter("hotelName"))) {
                                searchParamsDataItem.setPoi(parse.getQueryParameter("hotelName"));
                            } else {
                                searchParamsDataItem.setPoi("");
                            }
                            FilterParams filterParams = new FilterParams((String) null, (Locations) null, 3, (g) null);
                            if (queryParameter2 == null) {
                                k.a();
                            }
                            filterParams.setHotelId(queryParameter2);
                            searchParamsDataItem.setFilter_params(filterParams);
                            autoSearchDataItem.setSearchParams(searchParamsDataItem);
                            this.mAutoSearchDataItem = autoSearchDataItem;
                            if (autoSearchDataItem.getSearchParams() != null) {
                                SearchParamsDataItem searchParams = autoSearchDataItem.getSearchParams();
                                if (searchParams != null) {
                                    str2 = searchParams.getPoi();
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    EditText editText = this.mSourceCityTextView;
                                    if (editText == null) {
                                        k.a("mSourceCityTextView");
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    SearchParamsDataItem searchParams2 = autoSearchDataItem.getSearchParams();
                                    if (searchParams2 == null) {
                                        k.a();
                                    }
                                    sb.append(searchParams2.getPoi());
                                    sb.append(", ");
                                    SearchParamsDataItem searchParams3 = autoSearchDataItem.getSearchParams();
                                    if (searchParams3 == null) {
                                        k.a();
                                    }
                                    sb.append(searchParams3.getCity());
                                    editText.setText(sb.toString());
                                }
                            }
                            EditText editText2 = this.mSourceCityTextView;
                            if (editText2 == null) {
                                k.a("mSourceCityTextView");
                            }
                            SearchParamsDataItem searchParams4 = autoSearchDataItem.getSearchParams();
                            if (searchParams4 == null) {
                                k.a();
                            }
                            editText2.setText(searchParams4.getCity());
                        }
                    } else {
                        this.msearchType = "trendingSearch";
                        this.mAutoSearchDataItem = new AutoSearchDataItem((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
                        ArrayList arrayList = new ArrayList();
                        if (TextUtils.isEmpty(queryParameter)) {
                            queryParameter = "";
                        }
                        if (queryParameter == null) {
                            k.a();
                        }
                        arrayList.add(queryParameter);
                        this.mAutoSearchDataItem.setDisplay(arrayList);
                        SearchParamsDataItem searchParamsDataItem2 = new SearchParamsDataItem((String) null, (String) null, (String) null, false, false, (FilterParams) null, 63, (g) null);
                        searchParamsDataItem2.setCity(queryParameter);
                        this.mAutoSearchDataItem.setSearchParams(searchParamsDataItem2);
                        EditText editText3 = this.mSourceCityTextView;
                        if (editText3 == null) {
                            k.a("mSourceCityTextView");
                        }
                        editText3.setText(queryParameter);
                        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
                        if (cJRHotelSearchInput == null) {
                            k.a("mHotelSearchInput");
                        }
                        cJRHotelSearchInput.setCity(queryParameter);
                    }
                    String queryParameter3 = parse.getQueryParameter("check_in_date");
                    String queryParameter4 = parse.getQueryParameter("check_out_date");
                    if (!TextUtils.isEmpty(queryParameter3) && !TextUtils.isEmpty(queryParameter4) && com.paytm.utility.b.c(queryParameter3, "yyyy-MM-dd") && com.paytm.utility.b.c(queryParameter4, "yyyy-MM-dd")) {
                        s sVar = s.f28553a;
                        if (s.a(queryParameter3, queryParameter4) && (numberOfNights = getNumberOfNights(queryParameter3, queryParameter4)) > 0) {
                            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
                            if (cJRHotelSearchInput2 == null) {
                                k.a("mHotelSearchInput");
                            }
                            cJRHotelSearchInput2.setCheckInDate(queryParameter3);
                            CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
                            if (cJRHotelSearchInput3 == null) {
                                k.a("mHotelSearchInput");
                            }
                            cJRHotelSearchInput3.setCheckOutDate(queryParameter4);
                            CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
                            if (cJRHotelSearchInput4 == null) {
                                k.a("mHotelSearchInput");
                            }
                            cJRHotelSearchInput4.setNumOfNights(numberOfNights);
                            CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
                            if (cJRHotelSearchInput5 == null) {
                                k.a("mHotelSearchInput");
                            }
                            updateUIOnDateSelection(cJRHotelSearchInput5);
                        }
                    }
                    openSRPPage(true);
                    return;
                }
                populateRecentSearch();
                return;
            }
            populateRecentSearch();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void onHotelSearchClick() {
        if (this.mHotelSearchInput != null) {
            validateInput(false);
        }
    }

    public final void openCitySearchActivity() {
        sendPulseEventHotelAutoSearchTapped();
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), HotelCitySearchActivity.class);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 6);
            }
        }
    }

    private final void sendPulseEventHotelAutoSearchTapped() {
        Map hashMap = new HashMap();
        hashMap.put("event_label", "");
        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "HomePage", "hotels_home", "search_initiated", hashMap);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.isStoreFrontFragmentAddPending) {
            createEndlessScroll();
            this.isStoreFrontFragmentAddPending = false;
        }
    }

    public final void onVisibilityGone() {
        this.isStoreFrontFragmentAddPending = false;
        new Handler().post(new HotelHomeFragment$onVisibilityGone$1(this));
    }

    public final void onVisibleToUser(boolean z) {
        new Handler().post(new HotelHomeFragment$onVisibleToUser$1(this));
    }

    /* access modifiers changed from: private */
    public final void createEndlessScroll() {
        if (!this.isFragmentPaused) {
            WeakReference weakReference = null;
            if (this.nestedView != null) {
                NestedScrollView nestedScrollView = this.nestedView;
                if (nestedScrollView == null) {
                    k.a("nestedView");
                }
                weakReference = new WeakReference(nestedScrollView);
            }
            this.mEndlessScrollFragment = net.one97.paytm.hotels2.utils.c.b().a((WeakReference<View>) weakReference);
            e.a();
            String a2 = e.a("hotelStoreFrontURL", "");
            Bundle bundle = new Bundle();
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putString("origin", "hotel");
            bundle.putString("store_front_url_key", "bus");
            bundle.putString("EXTRA_STORE_FRONT_ALTERNATE_URL", a2);
            bundle.putBoolean("trigger-impression-on-visibility", true);
            Fragment fragment = this.mEndlessScrollFragment;
            if (fragment == null) {
                k.a();
            }
            fragment.setArguments(bundle);
            q a3 = getChildFragmentManager().a();
            int i2 = R.id.store_front_container;
            Fragment fragment2 = this.mEndlessScrollFragment;
            if (fragment2 == null) {
                k.a();
            }
            a3.b(i2, fragment2, "hotel-endless-storefront").c();
        }
    }

    /* access modifiers changed from: private */
    public final void openCalendar(HashMap<String, Object> hashMap) {
        CharSequence text;
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        if (cJRHotelSearchInput != null && !this.debounceClick.a("openCalendar") && hashMap != null && isAdded()) {
            sendPulseCalender("check_in_selected");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd");
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            String checkInDate = cJRHotelSearchInput2.getCheckInDate();
            if (checkInDate == null) {
                k.a();
            }
            boolean z = false;
            String format = simpleDateFormat.format(simpleDateFormat.parse(p.a(checkInDate, "-", " ", false)));
            CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
            if (cJRHotelSearchInput3 == null) {
                k.a("mHotelSearchInput");
            }
            String checkOutDate = cJRHotelSearchInput3.getCheckOutDate();
            if (checkOutDate == null) {
                k.a();
            }
            String format2 = simpleDateFormat.format(simpleDateFormat.parse(p.a(checkOutDate, "-", " ", false)));
            getContext();
            HotelConfig hotelConfig2 = this.hotelConfig;
            String b2 = com.paytm.utility.b.b(hotelConfig2 != null ? hotelConfig2.getToday() : null, "dd/MM/yyyy", "yyyy-MM-dd");
            k.a((Object) b2, "CJRAppCommonUtility.form…d/MM/yyyy\", \"yyyy-MM-dd\")");
            p.a(b2, "-", " ", false);
            EditText editText = this.mSourceCityTextView;
            if (editText == null) {
                k.a("mSourceCityTextView");
            }
            Editable text2 = editText.getText();
            k.a((Object) text2, "mSourceCityTextView.text");
            if (text2.length() == 0) {
                z = true;
            }
            if (z) {
                text = "";
            } else {
                EditText editText2 = this.mSourceCityTextView;
                if (editText2 == null) {
                    k.a("mSourceCityTextView");
                }
                text = editText2.getText();
            }
            CharSequence charSequence = text;
            d b3 = net.one97.paytm.hotels2.utils.c.b();
            Context activity = getActivity();
            String obj = charSequence.toString();
            d b4 = net.one97.paytm.hotels2.utils.c.b();
            k.a((Object) b4, "HotelController.getHotelEventListener()");
            String d2 = b4.d();
            HotelConfig hotelConfig3 = this.hotelConfig;
            if (hotelConfig3 == null) {
                k.a();
            }
            startActivityForResult(b3.a(activity, format, format2, "Select Dates", obj, d2, hotelConfig3.getMaxStayRange()), 99);
        }
    }

    private final void sendPulseCalender(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event_label", "");
        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "HomePage", "hotels_home", str, hashMap);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 6) {
                super.onActivityResult(i2, i3, intent);
                if (intent != null && intent.hasExtra("localitySearchType")) {
                    String stringExtra = intent.getStringExtra("localitySearchType");
                    k.a((Object) stringExtra, "data.getStringExtra(CJRH…ENT_LOCALITY_RESULT_TYPE)");
                    this.msearchType = stringExtra;
                    String str = this.msearchType;
                    int hashCode = str.hashCode();
                    if (hashCode != 888645703) {
                        if (hashCode != 1133114528) {
                            if (hashCode == 1303869229 && str.equals("trendingSearch")) {
                                setTrendingSearchData(intent);
                            }
                        } else if (str.equals("userLocation")) {
                            setLocationSearchData(intent);
                        }
                    } else if (str.equals("searched")) {
                        setSearchedTypeData(intent);
                    }
                }
            } else if (i2 == 99 && intent != null && intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
                String stringExtra2 = intent.getStringExtra("intent_extra_selected_depart_date");
                k.a((Object) stringExtra2, "data.getStringExtra(CJRC…TRA_SELECTED_DEPART_DATE)");
                String stringExtra3 = intent.getStringExtra("intent_extra_selected_return_date");
                k.a((Object) stringExtra3, "data.getStringExtra(CJRC…TRA_SELECTED_RETURN_DATE)");
                CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
                if (cJRHotelSearchInput == null) {
                    k.a("mHotelSearchInput");
                }
                if (cJRHotelSearchInput == null) {
                    this.mHotelSearchInput = new CJRHotelSearchInput();
                }
                int intExtra = intent.getIntExtra("DAYS_SELECTED", 0);
                Locale locale = new Locale(n.a());
                CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
                if (cJRHotelSearchInput2 == null) {
                    k.a("mHotelSearchInput");
                }
                cJRHotelSearchInput2.setCheckInDate(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new SimpleDateFormat("dd MMM yy", locale).parse(stringExtra2)));
                CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
                if (cJRHotelSearchInput3 == null) {
                    k.a("mHotelSearchInput");
                }
                cJRHotelSearchInput3.setCheckOutDate(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new SimpleDateFormat("dd MMM yy", locale).parse(stringExtra3)));
                CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
                if (cJRHotelSearchInput4 == null) {
                    k.a("mHotelSearchInput");
                }
                cJRHotelSearchInput4.setNumOfNights(intExtra);
                CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
                if (cJRHotelSearchInput5 == null) {
                    k.a("mHotelSearchInput");
                }
                updateUIOnDateSelection(cJRHotelSearchInput5);
                sendPulseCalender("date_selected");
            }
        } else if (i3 == 111 && intent != null) {
            String stringExtra4 = intent.getStringExtra("city");
            k.a((Object) stringExtra4, "data.getStringExtra(\"city\")");
            String stringExtra5 = intent.getStringExtra("poi");
            k.a((Object) stringExtra5, "data.getStringExtra(\"poi\")");
            String stringExtra6 = intent.getStringExtra("hotelId");
            k.a((Object) stringExtra6, "data.getStringExtra(\"hotelId\")");
            String stringExtra7 = intent.getStringExtra("checkInDate");
            k.a((Object) stringExtra7, "data.getStringExtra(\"checkInDate\")");
            String stringExtra8 = intent.getStringExtra("checkOutDate");
            k.a((Object) stringExtra8, "data.getStringExtra(\"checkOutDate\")");
            prePopulateCityAndDate(stringExtra4, stringExtra5, stringExtra6, stringExtra7, stringExtra8);
        }
    }

    private final void setLocationSearchData(Intent intent) {
        this.mLocationDetails = new Locations((String) null, (String) null, (String) null, 7, (g) null);
        Locations locations = this.mLocationDetails;
        if (locations == null) {
            k.a("mLocationDetails");
        }
        String stringExtra = intent.getStringExtra("lat");
        k.a((Object) stringExtra, "data.getStringExtra(\"lat\")");
        locations.setLat(stringExtra);
        Locations locations2 = this.mLocationDetails;
        if (locations2 == null) {
            k.a("mLocationDetails");
        }
        String stringExtra2 = intent.getStringExtra("lon");
        k.a((Object) stringExtra2, "data.getStringExtra(\"lon\")");
        locations2.setLon(stringExtra2);
        Locations locations3 = this.mLocationDetails;
        if (locations3 == null) {
            k.a("mLocationDetails");
        }
        String stringExtra3 = intent.getStringExtra("cityName");
        k.a((Object) stringExtra3, "data.getStringExtra(\"cityName\")");
        locations3.setCityName(stringExtra3);
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput.setCity(intent.getStringExtra("cityName"));
        CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
        if (cJRHotelSearchInput2 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput2.setPoi(intent.getStringExtra("locality"));
        CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
        if (cJRHotelSearchInput3 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput3.setNearBySearch(true);
        EditText editText = this.mSourceCityTextView;
        if (editText == null) {
            k.a("mSourceCityTextView");
        }
        StringBuilder sb = new StringBuilder();
        CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
        if (cJRHotelSearchInput4 == null) {
            k.a("mHotelSearchInput");
        }
        sb.append(cJRHotelSearchInput4.getPoi());
        sb.append(", ");
        CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
        if (cJRHotelSearchInput5 == null) {
            k.a("mHotelSearchInput");
        }
        sb.append(cJRHotelSearchInput5.getCity());
        editText.setText(sb.toString());
    }

    private final void setTrendingSearchData(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("selected_data_popular");
        if (serializableExtra != null) {
            PopularRecentDataItem popularRecentDataItem = (PopularRecentDataItem) serializableExtra;
            createHotelAutoSearchObject(popularRecentDataItem.getCity(), "");
            EditText editText = this.mSourceCityTextView;
            if (editText == null) {
                k.a("mSourceCityTextView");
            }
            editText.setText(popularRecentDataItem.getCity());
            CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
            if (cJRHotelSearchInput == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput.setCity(popularRecentDataItem.getCity());
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput2.setNearBySearch(false);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.PopularRecentDataItem");
    }

    private final void setSearchedTypeData(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("selected_data_autoSuggest");
        if (serializableExtra != null) {
            this.mAutoSearchDataItem = (AutoSearchDataItem) serializableExtra;
            CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
            if (cJRHotelSearchInput == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput.setNearBySearch(false);
            setCityHotelDetailsUI(this.mAutoSearchDataItem);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem");
    }

    public final void setCityHotelDetailsUI(AutoSearchDataItem autoSearchDataItem) {
        EditText editText;
        k.c(autoSearchDataItem, "autoSearch");
        String str = null;
        if (autoSearchDataItem.getSearchParams() != null) {
            SearchParamsDataItem searchParams = autoSearchDataItem.getSearchParams();
            if (!TextUtils.isEmpty(searchParams != null ? searchParams.getPoi() : null)) {
                editText = this.mSourceCityTextView;
                if (editText == null) {
                    k.a("mSourceCityTextView");
                }
                StringBuilder sb = new StringBuilder();
                SearchParamsDataItem searchParams2 = autoSearchDataItem.getSearchParams();
                if (searchParams2 == null) {
                    k.a();
                }
                sb.append(searchParams2.getPoi());
                sb.append(", ");
                SearchParamsDataItem searchParams3 = autoSearchDataItem.getSearchParams();
                if (searchParams3 == null) {
                    k.a();
                }
                sb.append(searchParams3.getCity());
                str = sb.toString();
                editText.setText(str);
            }
        }
        if (autoSearchDataItem.getDisplay() != null) {
            List<String> display = autoSearchDataItem.getDisplay();
            Integer valueOf = display != null ? Integer.valueOf(display.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 1) {
                List<String> display2 = autoSearchDataItem.getDisplay();
                if (!TextUtils.isEmpty(display2 != null ? display2.get(1) : null)) {
                    editText = this.mSourceCityTextView;
                    if (editText == null) {
                        k.a("mSourceCityTextView");
                    }
                    StringBuilder sb2 = new StringBuilder();
                    List<String> display3 = autoSearchDataItem.getDisplay();
                    sb2.append(display3 != null ? display3.get(0) : null);
                    sb2.append(", ");
                    List<String> display4 = autoSearchDataItem.getDisplay();
                    if (display4 != null) {
                        str = display4.get(1);
                    }
                    sb2.append(str);
                    str = sb2.toString();
                }
            }
            List<String> display5 = autoSearchDataItem.getDisplay();
            Integer valueOf2 = display5 != null ? Integer.valueOf(display5.size()) : null;
            if (valueOf2 == null) {
                k.a();
            }
            if (valueOf2.intValue() > 0) {
                EditText editText2 = this.mSourceCityTextView;
                if (editText2 == null) {
                    k.a("mSourceCityTextView");
                }
                List<String> display6 = autoSearchDataItem.getDisplay();
                if (display6 != null) {
                    str = display6.get(0);
                }
                editText2.setText(str);
                return;
            }
            return;
        }
        editText = this.mSourceCityTextView;
        if (editText == null) {
            k.a("mSourceCityTextView");
        }
        SearchParamsDataItem searchParams4 = autoSearchDataItem.getSearchParams();
        if (searchParams4 != null) {
            str = searchParams4.getCity();
        }
        editText.setText(str);
    }

    private final void setDefaultDate() {
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        String str = null;
        if (TextUtils.isEmpty(cJRHotelSearchInput.getCheckInDate())) {
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            getContext();
            HotelConfig hotelConfig2 = this.hotelConfig;
            cJRHotelSearchInput2.setCheckInDate(com.paytm.utility.b.b(hotelConfig2 != null ? hotelConfig2.getToday() : null, "dd/MM/yyyy", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
        if (cJRHotelSearchInput3 == null) {
            k.a("mHotelSearchInput");
        }
        if (TextUtils.isEmpty(cJRHotelSearchInput3.getCheckOutDate())) {
            CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
            if (cJRHotelSearchInput4 == null) {
                k.a("mHotelSearchInput");
            }
            getContext();
            HotelConfig hotelConfig3 = this.hotelConfig;
            if (hotelConfig3 != null) {
                str = hotelConfig3.getTomorrow();
            }
            cJRHotelSearchInput4.setCheckOutDate(com.paytm.utility.b.b(str, "dd/MM/yyyy", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
        if (cJRHotelSearchInput5 == null) {
            k.a("mHotelSearchInput");
        }
        CJRHotelSearchInput cJRHotelSearchInput6 = this.mHotelSearchInput;
        if (cJRHotelSearchInput6 == null) {
            k.a("mHotelSearchInput");
        }
        String checkInDate = cJRHotelSearchInput6.getCheckInDate();
        CJRHotelSearchInput cJRHotelSearchInput7 = this.mHotelSearchInput;
        if (cJRHotelSearchInput7 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput5.setNumOfNights(getNumberOfNights(checkInDate, cJRHotelSearchInput7.getCheckOutDate()));
        CJRHotelSearchInput cJRHotelSearchInput8 = this.mHotelSearchInput;
        if (cJRHotelSearchInput8 == null) {
            k.a("mHotelSearchInput");
        }
        updateUIOnDateSelection(cJRHotelSearchInput8);
    }

    private final void updateUIOnDateSelection(CJRHotelSearchInput cJRHotelSearchInput) {
        Object obj;
        Object obj2;
        if (cJRHotelSearchInput != null) {
            this.mHotelSearchInput = cJRHotelSearchInput;
            String checkInDate = cJRHotelSearchInput.getCheckInDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(checkInDate);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE,MMMM,dd");
            String format = simpleDateFormat2.format(parse);
            k.a((Object) format, "checkInStr");
            List b2 = p.a((CharSequence) format, new String[]{AppConstants.COMMA});
            Date parse2 = simpleDateFormat.parse(cJRHotelSearchInput.getCheckOutDate());
            TextView textView = this.mCheckInDateTextView;
            if (textView == null) {
                k.a("mCheckInDateTextView");
            }
            if (p.b((String) b2.get(2), "0", false)) {
                obj = p.a((String) b2.get(2), "0", "", false);
            } else {
                obj = b2.get(2);
            }
            textView.setText((CharSequence) obj);
            TextView textView2 = this.mCheckInMonthTextView;
            if (textView2 == null) {
                k.a("mCheckInMonthTextView");
            }
            textView2.setText((CharSequence) b2.get(1));
            TextView textView3 = this.mCheckInWeekTextView;
            if (textView3 == null) {
                k.a("mCheckInWeekTextView");
            }
            textView3.setText((CharSequence) b2.get(0));
            String format2 = simpleDateFormat2.format(parse2);
            k.a((Object) format2, "checkOutStr");
            List b3 = p.a((CharSequence) format2, new String[]{AppConstants.COMMA});
            TextView textView4 = this.mCheckOutDateTextView;
            if (textView4 == null) {
                k.a("mCheckOutDateTextView");
            }
            if (p.b((String) b3.get(2), "0", false)) {
                obj2 = p.a((String) b3.get(2), "0", "", false);
            } else {
                obj2 = b3.get(2);
            }
            textView4.setText((CharSequence) obj2);
            TextView textView5 = this.mCheckOutMonthTextView;
            if (textView5 == null) {
                k.a("mCheckOutMonthTextView");
            }
            textView5.setText((CharSequence) b3.get(1));
            TextView textView6 = this.mCheckOutWeekTextView;
            if (textView6 == null) {
                k.a("mCheckOutWeekTextView");
            }
            textView6.setText((CharSequence) b3.get(0));
            TextView textView7 = this.mNightCount;
            if (textView7 == null) {
                k.a("mNightCount");
            }
            textView7.setText(String.valueOf(cJRHotelSearchInput.getNumOfNights()));
            TextView textView8 = this.mNightCountText;
            if (textView8 == null) {
                k.a("mNightCountText");
            }
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            textView8.setText(net.one97.paytm.hotel4.utils.e.a("Night", "", Integer.valueOf(cJRHotelSearchInput.getNumOfNights())));
        }
    }

    private final void validateInput(boolean z) {
        EditText editText = this.mSourceCityTextView;
        if (editText == null) {
            k.a("mSourceCityTextView");
        }
        if (!TextUtils.isEmpty(editText.getText())) {
            if (z) {
                CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
                if (cJRHotelSearchInput == null) {
                    k.a("mHotelSearchInput");
                }
                cJRHotelSearchInput.markIsFromDeeplink();
            }
            if (com.paytm.utility.b.c((Context) getActivity())) {
                openSRPPage(false);
            } else {
                com.paytm.utility.b.a((Context) getActivity(), getResources().getString(R.string.hotels_hotel_no_internet_title), getResources().getString(R.string.hotels_hotel_no_internet_message));
            }
        } else {
            showLocationErrorFragment();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void openSRPPage(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r1 = r0.msearchType
            int r2 = r1.hashCode()
            r3 = 888645703(0x34f7a847, float:4.6129773E-7)
            java.lang.String r4 = "mSourceCityTextView"
            java.lang.String r5 = "userLocation"
            r6 = 1
            r7 = 0
            java.lang.String r8 = "mHotelSearchInput"
            if (r2 == r3) goto L_0x00ff
            r3 = 1133114528(0x4389f4a0, float:275.91113)
            java.lang.String r9 = ""
            if (r2 == r3) goto L_0x0091
            r3 = 1303869229(0x4db7772d, float:3.84755104E8)
            if (r2 == r3) goto L_0x0029
            goto L_0x01fc
        L_0x0029:
            java.lang.String r2 = "trendingSearch"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01fc
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0039
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0039:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x0046
            java.lang.String r2 = r2.getCity()
            goto L_0x0047
        L_0x0046:
            r2 = r7
        L_0x0047:
            r1.setPlaceDetail(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0051
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0051:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x005e
            java.lang.String r2 = r2.getCity()
            goto L_0x005f
        L_0x005e:
            r2 = r7
        L_0x005f:
            r1.setCity(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0069
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0069:
            if (r1 == 0) goto L_0x006e
            r1.setHotelId(r9)
        L_0x006e:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0075
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0075:
            r1.setPoi(r9)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x007f
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.setSortBy(r7)
        L_0x0084:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x008b
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x008b:
            android.content.Intent r1 = r0.getSearchIntent(r1)
            goto L_0x01fd
        L_0x0091:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x01fc
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x009e:
            android.widget.EditText r2 = r0.mSourceCityTextView
            if (r2 != 0) goto L_0x00a5
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00a5:
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r1.setPlaceDetail(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x00b7
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00b7:
            net.one97.paytm.hotel4.service.model.datamodel.search.Locations r2 = r0.mLocationDetails
            java.lang.String r3 = "mLocationDetails"
            if (r2 != 0) goto L_0x00c0
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00c0:
            java.lang.String r2 = r2.getCityName()
            r1.setCity(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x00ce
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00ce:
            net.one97.paytm.hotel4.service.model.datamodel.search.Locations r2 = r0.mLocationDetails
            if (r2 != 0) goto L_0x00d5
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00d5:
            r1.setLocationDetails(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x00df
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00df:
            if (r1 == 0) goto L_0x00e4
            r1.setHotelId(r9)
        L_0x00e4:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x00eb
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00eb:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r2 = r16.getSortObj()
            r1.setSortBy(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x00f9
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00f9:
            android.content.Intent r1 = r0.getSearchIntent(r1)
            goto L_0x01fd
        L_0x00ff:
            java.lang.String r2 = "searched"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01fc
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x010f
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x010f:
            android.widget.EditText r2 = r0.mSourceCityTextView
            if (r2 != 0) goto L_0x0116
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0116:
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r1.setPlaceDetail(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0128
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0128:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x0135
            java.lang.String r2 = r2.getCity()
            goto L_0x0136
        L_0x0135:
            r2 = r7
        L_0x0136:
            r1.setCity(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0140
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0140:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x0153
            net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams r2 = r2.getFilter_params()
            if (r2 == 0) goto L_0x0153
            net.one97.paytm.hotel4.service.model.datamodel.search.Locations r2 = r2.getLocation()
            goto L_0x0154
        L_0x0153:
            r2 = r7
        L_0x0154:
            r1.setLocationDetails(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x015e
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x015e:
            if (r1 == 0) goto L_0x0177
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x0173
            net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams r2 = r2.getFilter_params()
            if (r2 == 0) goto L_0x0173
            java.lang.String r2 = r2.getHotelId()
            goto L_0x0174
        L_0x0173:
            r2 = r7
        L_0x0174:
            r1.setHotelId(r2)
        L_0x0177:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x017e
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x017e:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 == 0) goto L_0x018b
            java.lang.String r2 = r2.getPoi()
            goto L_0x018c
        L_0x018b:
            r2 = r7
        L_0x018c:
            r1.setPoi(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x0196
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0196:
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 != 0) goto L_0x01a1
            kotlin.g.b.k.a()
        L_0x01a1:
            boolean r2 = r2.is_locality_search()
            r1.setLocalitySearch(r2)
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r1 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r1 = r1.getSearchParams()
            if (r1 == 0) goto L_0x01b5
            java.lang.String r1 = r1.getSort_by()
            goto L_0x01b6
        L_0x01b5:
            r1 = r7
        L_0x01b6:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01f0
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r1 = new net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 15
            r15 = 0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15)
            java.lang.String r2 = "sort_by"
            r1.setUrlParams(r2)
            r1.setSelected(r6)
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r2 = r2.getSearchParams()
            if (r2 != 0) goto L_0x01df
            kotlin.g.b.k.a()
        L_0x01df:
            java.lang.String r2 = r2.getSort_by()
            r1.setDefault(r2)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = r0.mHotelSearchInput
            if (r2 != 0) goto L_0x01ed
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01ed:
            r2.setSortBy(r1)
        L_0x01f0:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r0.mHotelSearchInput
            if (r1 != 0) goto L_0x01f7
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01f7:
            android.content.Intent r1 = r0.getSearchIntent(r1)
            goto L_0x01fd
        L_0x01fc:
            r1 = r7
        L_0x01fd:
            if (r17 != 0) goto L_0x024f
            java.lang.String r2 = r0.msearchType
            if (r2 == 0) goto L_0x020b
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
        L_0x020b:
            boolean r2 = r7.booleanValue()
            if (r2 != 0) goto L_0x024f
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            r2.setRecentSearch(r6)
            net.one97.paytm.hotel4.service.a.b r2 = new net.one97.paytm.hotel4.service.a.b
            r2.<init>()
            android.content.Context r2 = r16.getContext()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r0.mHotelSearchInput
            if (r3 != 0) goto L_0x0226
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0226:
            java.lang.String r3 = r3.getCheckInDate()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r0.mHotelSearchInput
            if (r4 != 0) goto L_0x0231
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0231:
            java.lang.String r4 = r4.getCheckOutDate()
            net.one97.paytm.hotel4.service.a.b.a(r2, r3, r4)
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            if (r2 == 0) goto L_0x024f
            java.util.List r2 = r2.getDisplay()
            if (r2 == 0) goto L_0x024f
            net.one97.paytm.hotel4.service.a.b r2 = new net.one97.paytm.hotel4.service.a.b
            r2.<init>()
            r16.getContext()
            net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem r2 = r0.mAutoSearchDataItem
            net.one97.paytm.hotel4.service.a.b.a(r2)
        L_0x024f:
            if (r1 == 0) goto L_0x0259
            r16.sendPulseEventHotelSearchTapped()
            r2 = 1001(0x3e9, float:1.403E-42)
            r0.startActivityForResult(r1, r2)
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.fragment.HotelHomeFragment.openSRPPage(boolean):void");
    }

    private final void setDefaultRoomDetails() {
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        if (cJRHotelSearchInput != null) {
            CJRRoom cJRRoom = new CJRRoom(0, 0, 0, (ArrayList) null, (String) null, (String) null, (String) null, 127, (g) null);
            cJRRoom.setAdultCount(1);
            cJRRoom.setChildrenCount(0);
            cJRRoom.setChildrenAges(new ArrayList());
            ArrayList arrayList = new ArrayList();
            arrayList.add(cJRRoom);
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput2.setAdultCount(1);
            CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
            if (cJRHotelSearchInput3 == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput3.setChildCount(0);
            CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
            if (cJRHotelSearchInput4 == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput4.setRooms(arrayList);
            CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
            if (cJRHotelSearchInput5 == null) {
                k.a("mHotelSearchInput");
            }
            cJRHotelSearchInput5.setNumOfNights(1);
        }
    }

    private final void sendPulseEventHotelSearchTapped() {
        int i2;
        int i3;
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        if (cJRHotelSearchInput != null) {
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            ArrayList<CJRRoom> rooms = cJRHotelSearchInput2.getRooms();
            int i4 = 0;
            if (rooms == null || rooms.size() <= 0) {
                i3 = 0;
                i2 = 0;
            } else {
                i3 = rooms.size();
                Iterator<CJRRoom> it2 = rooms.iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    CJRRoom next = it2.next();
                    i4 += next.getAdultCount();
                    i2 += next.getChildrenCount();
                }
            }
            Map hashMap = new HashMap();
            CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
            if (cJRHotelSearchInput3 == null) {
                k.a("mHotelSearchInput");
            }
            String city = cJRHotelSearchInput3.getCity();
            if (city != null) {
                hashMap.put("event_label", city);
                CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
                if (cJRHotelSearchInput4 == null) {
                    k.a("mHotelSearchInput");
                }
                String checkInDate = cJRHotelSearchInput4.getCheckInDate();
                if (checkInDate != null) {
                    hashMap.put("event_label2", checkInDate);
                    CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
                    if (cJRHotelSearchInput5 == null) {
                        k.a("mHotelSearchInput");
                    }
                    String checkOutDate = cJRHotelSearchInput5.getCheckOutDate();
                    if (checkOutDate != null) {
                        hashMap.put("event_label3", checkOutDate);
                        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Integer.valueOf(i4));
                        hashMap.put("event_label5", Integer.valueOf(i2));
                        hashMap.put("event_label6", Integer.valueOf(i3));
                        net.one97.paytm.hotels2.utils.c.b().a("customEvent", "HomePage", "hotels_home", "search_tapped", hashMap);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
    }

    private final void getHotelConfig() {
        new net.one97.paytm.hotel4.service.a.b();
        com.paytm.network.listener.b apiListener = new ApiListener();
        Context context = getContext();
        k.c(apiListener, "listener");
        HashMap hashMap = new HashMap();
        e.a();
        com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.b.SILENT).c("1").a(a.c.HOTELS).a(a.C0715a.GET).a(e.b()).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new HotelConfig()).a(apiListener).a(true).l();
        k.a((Object) l, "networking");
        l.a(true);
        l.a();
    }

    private final void showProgressDialog() {
        net.one97.paytm.common.widgets.a.a(this.mLottieAnimView);
    }

    /* access modifiers changed from: private */
    public final void removeProgressDialog() {
        net.one97.paytm.common.widgets.a.b(this.mLottieAnimView);
    }

    private final Intent getSearchIntent(CJRHotelSearchInput cJRHotelSearchInput) {
        cJRHotelSearchInput.markDeeplinkProcessed();
        Intent intent = new Intent(getActivity(), AJRHotelActivity.class);
        HotelConfig hotelConfig2 = this.hotelConfig;
        if (hotelConfig2 != null) {
            if ((hotelConfig2 != null ? hotelConfig2.getResponse() : null) != null) {
                intent.putExtra("hotel-checkin-config", this.hotelConfig);
                HotelConfig hotelConfig3 = this.hotelConfig;
                if (hotelConfig3 == null) {
                    k.a();
                }
                cJRHotelSearchInput.setMaxStayNoightCount(hotelConfig3.getMaxStayRange());
            }
        }
        intent.putExtra("hotels_search_input", cJRHotelSearchInput);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("deeplink-data")) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                String string = arguments2.getString("deeplink-data");
                if (string == null) {
                    k.a();
                }
                k.a((Object) string, "arguments!!.getString(\"deeplink-data\")!!");
                if (string.length() > 0) {
                    c.a aVar = c.f28638a;
                    String a2 = c.f28639b;
                    Bundle arguments3 = getArguments();
                    if (arguments3 == null) {
                        k.a();
                    }
                    intent.putExtra(a2, arguments3.getString("deeplink-data"));
                    Bundle arguments4 = getArguments();
                    if (arguments4 == null) {
                        k.a();
                    }
                    arguments4.putString("deeplink-data", "");
                }
            }
        }
        intent.addFlags(67108864);
        return intent;
    }

    public final class ApiListener implements com.paytm.network.listener.b {
        public ApiListener() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            HotelHomeFragment hotelHomeFragment = HotelHomeFragment.this;
            if (iJRPaytmDataModel != null) {
                hotelHomeFragment.hotelConfig = (HotelConfig) iJRPaytmDataModel;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.datamodel.HotelConfig");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            HotelHomeFragment.this.removeProgressDialog();
        }
    }

    public final int getNumberOfNights(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return (int) TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException e2) {
            com.paytm.utility.q.c(e2.getMessage());
            return 0;
        }
    }

    public final void onToolbarcClick(View view) {
        k.c(view, "view");
        NestedScrollView nestedScrollView = this.nestedView;
        if (nestedScrollView == null) {
            k.a("nestedView");
        }
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, 0);
        }
    }

    private final void downalodSrpLoaderAnimationJson(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            try {
                lottieAnimationView.setVisibility(8);
                lottieAnimationView.setImageAssetsFolder("images/");
                lottieAnimationView.setAnimationFromUrl(f.b());
                lottieAnimationView.setFailureListener(new HotelHomeFragment$downalodSrpLoaderAnimationJson$1(this));
                lottieAnimationView.playAnimation();
                lottieAnimationView.setFailureListener(HotelHomeFragment$downalodSrpLoaderAnimationJson$2.INSTANCE);
                lottieAnimationView.loop(true);
            } catch (Exception e2) {
                e2.getStackTrace();
            }
        }
    }

    public final void urlAnimationError(Throwable th) {
        k.c(th, "result");
        com.paytm.utility.q.b("urlAnimationError");
    }

    public final void createHotelConfig() {
        this.hotelConfig = new HotelConfig();
        HotelConfig hotelConfig2 = this.hotelConfig;
        if (hotelConfig2 != null) {
            hotelConfig2.setResponse("");
        }
        HotelConfig hotelConfig3 = this.hotelConfig;
        if (hotelConfig3 != null) {
            s sVar = s.f28553a;
            hotelConfig3.setToday(s.b("dd/MM/yyyy"));
        }
        HotelConfig hotelConfig4 = this.hotelConfig;
        if (hotelConfig4 != null) {
            s sVar2 = s.f28553a;
            hotelConfig4.setTomorrow(s.c("dd/MM/yyyy"));
        }
        HotelConfig hotelConfig5 = this.hotelConfig;
        if (hotelConfig5 != null) {
            hotelConfig5.setMaxStayRange(30);
        }
        setDefaultDate();
    }

    public final void createHotelAutoSearchObject(String str, String str2) {
        k.c(str, "city");
        k.c(str2, "poi");
        this.mAutoSearchDataItem = new AutoSearchDataItem((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.mAutoSearchDataItem.setDisplay(arrayList);
        SearchParamsDataItem searchParamsDataItem = new SearchParamsDataItem((String) null, (String) null, (String) null, false, false, (FilterParams) null, 63, (g) null);
        searchParamsDataItem.setCity(str);
        if (!TextUtils.isEmpty(str2)) {
            searchParamsDataItem.setPoi(str2);
        }
        this.mAutoSearchDataItem.setSearchParams(searchParamsDataItem);
    }

    public final void prePopulateCityAndDate(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "city");
        k.c(str2, "poi");
        k.c(str3, "hotelId");
        k.c(str4, "checkInDtae");
        k.c(str5, "checkOutDate");
        createHotelAutoSearchObject(str, str2);
        CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
        if (cJRHotelSearchInput == null) {
            k.a("mHotelSearchInput");
        }
        if (cJRHotelSearchInput == null) {
            this.mHotelSearchInput = new CJRHotelSearchInput();
        }
        CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
        if (cJRHotelSearchInput2 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput2.setCity(str);
        CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
        if (cJRHotelSearchInput3 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput3.setPoi(str2);
        CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
        if (cJRHotelSearchInput4 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput4.setHotelId(str3);
        CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
        if (cJRHotelSearchInput5 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput5.setCheckInDate(str4);
        CJRHotelSearchInput cJRHotelSearchInput6 = this.mHotelSearchInput;
        if (cJRHotelSearchInput6 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput6.setCheckOutDate(str5);
        CJRHotelSearchInput cJRHotelSearchInput7 = this.mHotelSearchInput;
        if (cJRHotelSearchInput7 == null) {
            k.a("mHotelSearchInput");
        }
        cJRHotelSearchInput7.setNumOfNights(getNumberOfNights(str4, str5));
        setCityHotelDetailsUI(this.mAutoSearchDataItem);
        CJRHotelSearchInput cJRHotelSearchInput8 = this.mHotelSearchInput;
        if (cJRHotelSearchInput8 == null) {
            k.a("mHotelSearchInput");
        }
        updateUIOnDateSelection(cJRHotelSearchInput8);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        initHotelLib(context);
    }

    public final void initHotelLib(Context context) {
        k.c(context, "context");
        try {
            Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.hotels.HotelJarvisHelper");
            k.a((Object) cls, "Class.forName(\"net.one97…otels.HotelJarvisHelper\")");
            Method declaredMethod = cls.getDeclaredMethod("initHotelLib", new Class[]{Context.class});
            k.a((Object) declaredMethod, "c.getDeclaredMethod(\"ini…ib\", Context::class.java)");
            declaredMethod.invoke((Object) null, new Object[]{context});
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    public final void populateRecentSearch() {
        FilterParams filter_params;
        new net.one97.paytm.hotel4.service.a.b();
        getContext();
        ArrayList<AutoSearchDataItem> a2 = net.one97.paytm.hotel4.service.a.b.a();
        String str = null;
        AutoSearchDataItem autoSearchDataItem = a2 != null ? a2.get(0) : null;
        k.a((Object) autoSearchDataItem, "getRecentSearchList(context)?.get(0)");
        if (autoSearchDataItem != null) {
            this.mAutoSearchDataItem = autoSearchDataItem;
            CJRHotelSearchInput cJRHotelSearchInput = this.mHotelSearchInput;
            if (cJRHotelSearchInput == null) {
                k.a("mHotelSearchInput");
            }
            if (cJRHotelSearchInput == null) {
                this.mHotelSearchInput = new CJRHotelSearchInput();
            }
            CJRHotelSearchInput cJRHotelSearchInput2 = this.mHotelSearchInput;
            if (cJRHotelSearchInput2 == null) {
                k.a("mHotelSearchInput");
            }
            SearchParamsDataItem searchParams = this.mAutoSearchDataItem.getSearchParams();
            cJRHotelSearchInput2.setCity(searchParams != null ? searchParams.getCity() : null);
            CJRHotelSearchInput cJRHotelSearchInput3 = this.mHotelSearchInput;
            if (cJRHotelSearchInput3 == null) {
                k.a("mHotelSearchInput");
            }
            SearchParamsDataItem searchParams2 = this.mAutoSearchDataItem.getSearchParams();
            cJRHotelSearchInput3.setPoi(searchParams2 != null ? searchParams2.getPoi() : null);
            CJRHotelSearchInput cJRHotelSearchInput4 = this.mHotelSearchInput;
            if (cJRHotelSearchInput4 == null) {
                k.a("mHotelSearchInput");
            }
            SearchParamsDataItem searchParams3 = this.mAutoSearchDataItem.getSearchParams();
            if (!(searchParams3 == null || (filter_params = searchParams3.getFilter_params()) == null)) {
                str = filter_params.getHotelId();
            }
            cJRHotelSearchInput4.setHotelId(str);
            new net.one97.paytm.hotel4.service.a.b();
            getContext();
            String c2 = net.one97.paytm.hotel4.service.a.b.c();
            new net.one97.paytm.hotel4.service.a.b();
            getContext();
            String b2 = net.one97.paytm.hotel4.service.a.b.b();
            s sVar = s.f28553a;
            if (s.a(c2, b2)) {
                CJRHotelSearchInput cJRHotelSearchInput5 = this.mHotelSearchInput;
                if (cJRHotelSearchInput5 == null) {
                    k.a("mHotelSearchInput");
                }
                new net.one97.paytm.hotel4.service.a.b();
                getContext();
                cJRHotelSearchInput5.setCheckInDate(net.one97.paytm.hotel4.service.a.b.c());
                CJRHotelSearchInput cJRHotelSearchInput6 = this.mHotelSearchInput;
                if (cJRHotelSearchInput6 == null) {
                    k.a("mHotelSearchInput");
                }
                new net.one97.paytm.hotel4.service.a.b();
                getContext();
                cJRHotelSearchInput6.setCheckOutDate(net.one97.paytm.hotel4.service.a.b.b());
                CJRHotelSearchInput cJRHotelSearchInput7 = this.mHotelSearchInput;
                if (cJRHotelSearchInput7 == null) {
                    k.a("mHotelSearchInput");
                }
                new net.one97.paytm.hotel4.service.a.b();
                getContext();
                String c3 = net.one97.paytm.hotel4.service.a.b.c();
                new net.one97.paytm.hotel4.service.a.b();
                getContext();
                cJRHotelSearchInput7.setNumOfNights(getNumberOfNights(c3, net.one97.paytm.hotel4.service.a.b.b()));
                CJRHotelSearchInput cJRHotelSearchInput8 = this.mHotelSearchInput;
                if (cJRHotelSearchInput8 == null) {
                    k.a("mHotelSearchInput");
                }
                updateUIOnDateSelection(cJRHotelSearchInput8);
            }
            setCityHotelDetailsUI(this.mAutoSearchDataItem);
            this.msearchType = "searched";
        }
    }

    public final void onDestroyView() {
        ViewTreeObserver viewTreeObserver;
        super.onDestroyView();
        if (this.scrollListener != null) {
            NestedScrollView nestedScrollView = this.nestedView;
            if (nestedScrollView == null) {
                k.a("nestedView");
            }
            if (nestedScrollView != null && (viewTreeObserver = nestedScrollView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.scrollListener);
            }
        }
    }

    public final SortKeysItem getSortObj() {
        SortKeysItem sortKeysItem = new SortKeysItem((String) null, (String) null, (String) null, false, 15, (g) null);
        sortKeysItem.setUrlParams("sort_by");
        sortKeysItem.setSelected(true);
        sortKeysItem.setDefault("distance_asc");
        sortKeysItem.setName("Closest");
        return sortKeysItem;
    }

    private final void showLocationErrorFragment() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(ErrorDialogViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…logViewModel::class.java]");
            this.errorDialogViewModel = (ErrorDialogViewModel) a2;
            ErrorDialogViewModel errorDialogViewModel2 = this.errorDialogViewModel;
            if (errorDialogViewModel2 == null) {
                k.a("errorDialogViewModel");
            }
            errorDialogViewModel2.getTag().postValue("8");
            ErrorDialogViewModel errorDialogViewModel3 = this.errorDialogViewModel;
            if (errorDialogViewModel3 == null) {
                k.a("errorDialogViewModel");
            }
            errorDialogViewModel3.getErrorObject().postValue(new net.one97.paytm.hotel4.utils.b(getContext()).a("8"));
        }
        net.one97.paytm.hotel4.view.ui.a.f fVar = new net.one97.paytm.hotel4.view.ui.a.f();
        fVar.a((Fragment) this);
        FragmentActivity activity2 = getActivity();
        q qVar = null;
        j supportFragmentManager = activity2 != null ? activity2.getSupportFragmentManager() : null;
        if (supportFragmentManager != null) {
            qVar = supportFragmentManager.a();
        }
        if (qVar != null) {
            fVar.show(qVar, "Location Error");
        }
    }

    public final void selectedCityForDeeplinkProcess(String str) {
        if (!TextUtils.isEmpty(str)) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            c.a aVar = c.f28638a;
            arguments.putString(c.f28639b, str);
            handelDeeplink();
        }
    }
}
