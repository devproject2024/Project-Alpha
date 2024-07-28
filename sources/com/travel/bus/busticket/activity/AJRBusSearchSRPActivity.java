package com.travel.bus.busticket.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.a.w;
import com.travel.bus.busticket.a.y;
import com.travel.bus.busticket.b.a;
import com.travel.bus.busticket.b.d;
import com.travel.bus.busticket.busfilter.BusFilterSortActivity;
import com.travel.bus.busticket.c.b;
import com.travel.bus.busticket.d.f;
import com.travel.bus.busticket.e.n;
import com.travel.bus.busticket.h.g;
import com.travel.bus.busticket.i.l;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.z;
import com.travel.bus.pojo.bussearch.CJRDictionaryItem;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import com.travel.bus.pojo.busticket.CJRBusFilterContainer;
import com.travel.bus.pojo.busticket.CJRBusOriginCityItem;
import com.travel.bus.pojo.busticket.CJRBusSearch;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import com.travel.bus.pojo.busticket.e;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import io.reactivex.rxjava3.b.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONObject;

public class AJRBusSearchSRPActivity extends PaytmActivity implements View.OnClickListener, AbsListView.OnScrollListener, CompoundButton.OnCheckedChangeListener, Response.ErrorListener, Response.Listener<IJRDataModel>, w.c, w.d, a, d, b.a, g {
    private RecyclerView alternateRecyclerView;
    private List<List<CJRSuggestionZeroSearch>> alternateRouteList = new ArrayList();
    private com.travel.bus.busticket.a.a alternateRoutesAdapter;
    private Locale appLocale;
    private ImageView backButtonImageView;
    private String busPopularChoiceID = "";
    private com.travel.bus.busticket.d.a busProgressBarAnimation;
    private RoboTextView cheapestFirstSortView;
    private l cjrBusGtmHelper;
    private View closeBusSearchView;
    io.reactivex.rxjava3.b.b compositeDisposable;
    private TextView dateDayAfterTomorrowTextView;
    private TextView dateTodayTextView;
    private TextView dateTomorowTextView;
    private TextView dayOfWeekDayAfterTomorrowTextView;
    private TextView dayOfWeekTodayTextView;
    private TextView dayOfWeekTomorrowTextView;
    private View daySelectDayAfterTomorrowView;
    private View daySelectTodayView;
    private View daySelectTomorrowView;
    private RoboTextView departureAscendingSortView;
    private View departureDateSelectView;
    private TextView departureDateTextView;
    private RoboTextView departureDescendingSortView;
    private TextView departureMonthTextView;
    private TextView departureWeekTextView;
    private TextView destTextView;
    private TextView destinationCitySelectTextView;
    private RoboTextView durationShortestFirstView;
    private boolean extraBpDpRequired = false;
    private TextView filterbusNoFooter;
    private ArrayList<CJRBusSearchItem> filteredBusList = new ArrayList<>();
    private DateFormat fullDateFormat = new SimpleDateFormat("EEEE, d MMMM");
    /* access modifiers changed from: private */
    public com.travel.bus.busticket.i.b headerDataModel;
    /* access modifiers changed from: private */
    public n headerViewHolder;
    private DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private boolean isBusSearchLayoutOpened = false;
    boolean isDealsAvailable = false;
    private String isDealsFilter = "";
    private boolean isExpanded = false;
    private boolean isOnNoBus = false;
    private boolean isSortViewOpened = false;
    private View mAcBusesFilterToggleView;
    private float mAllowedMaxFare;
    private float mAllowedMinFare;
    private HashMap<String, CJRBusSearchAmenitiesInfo> mAmenityInfo;
    private Animation mAnimMoveDown;
    private Animation mAnimMoveUp;
    private ViewGroup mBottomActionBar;
    private TextView mBusCountTextView;
    private CJRBusFilterContainer mBusFilterContainer;
    private CJRBusSearch mBusSearch;
    private com.travel.bus.busticket.i.d mBusSearchDataUtils;
    private CJRBusSearchInput mBusSearchInput;
    ArrayList<CJRBusSearchItem> mBusSearchItems;
    /* access modifiers changed from: private */
    public w mBusSearchListAdapter;
    private View mBusSearchOptionsFrame;
    private View mBusSearchOptionsLayout;
    private com.travel.bus.busticket.g.d mBusSearchPresenter;
    /* access modifiers changed from: private */
    public CJRBusTicketFilters mBusTicketFilters;
    String mCalendarSelectedDayValue;
    private TextView mCancelLoadingScreenBtn;
    private ImageView mCloseSortOptionsImageView;
    private ArrayList<CJRBusSearchItem> mCompleteBusList;
    private View mCovidBusesFilterToggleView;
    private ArrayList<CJRBusSearchAmenitiesInfo> mCurrentSelectedAmenityList = new ArrayList<>();
    private View mDealsBusesFilterToggleView;
    private View mDealsViewLine;
    private View mFilterView;
    private ImageView mGroupLogo;
    private TextView mGroupNameTextView;
    private Handler mHandler;
    private long mHomePageSelectedDateValue;
    private ImageView mImageFilterSelected;
    private LinearLayout mLinResetYourFilter;
    private LinearLayout mLinearClearView;
    private RecyclerView mListView;
    private LinearLayout mLytLoadingScreen;
    private RelativeLayout mLytProgressBar;
    private TextView mMinimumFareTextView;
    private View mNightBusesFilterToggleView;
    private LinearLayout mNoSearchResultFound;
    private String mOperatorId;
    private HashMap<String, CJRBusSearchOperatorTagInfo> mOperatorTagInfo;
    private RelativeLayout mRelSrpFilterView;
    private View mReviewContainer;
    private View mReviewLayout;
    private RecyclerView mReviewList;
    private Animation mRotateAnimation;
    private ViewGroup mRtcHeaderCardView;
    private Switch mShowAcBusesSwitch;
    private ImageView mShowBusesToggleImageView;
    private Switch mShowCovidBusesSwitch;
    private Switch mShowDealsBusesSwitch;
    private Switch mShowNightBusesSwitch;
    private ViewGroup mSortOptionsFrame;
    private ViewGroup mSortOptionsLayout;
    private TextView mSortSubTextView;
    private View mSortView;
    private y mSrpFilterAdapter;
    private RecyclerView mSrpFiltersRecyclerView;
    private TextView mStartingFromTime;
    private TextView mTextCovidBusesFilter;
    private TextView mTextDealsBusesFilter;
    private TextView mTextNightBusesFilter;
    private TextView mTextResetYourFilter;
    private Toolbar mToolbar;
    private TextView mTravelsName;
    private Button mTryAnotherSearch;
    private TextView mTryAnotherSearchMessage;
    private TextView mTvSortText;
    private long modifyLayoutSelectedDateValue;
    private ViewGroup notificationLayout;
    private HashMap<String, ArrayList<Integer>> operatorGroupListMap;
    private HashMap<String, Object> operatorGroupLogoListMap;
    private int orderBy = 0;
    private ImageView removeNotificationTextView;
    private boolean resultsLoadedGtmEventSent = false;
    private CJRTravelRoutesZeroSearch routesZeroSearch;
    private int rtcCount = 0;
    private Button searchBusesButton;
    private String selectedSortBy = "";
    private DateFormat shortDateFormat = new SimpleDateFormat("dd MMM");
    private DateFormat shortDayFormat = new SimpleDateFormat("E");
    private boolean shouldCreateFilterData = true;
    private TextView showAcBusesLabelTextView;
    private String sortBy = "key_bus_search_sort_by_none";
    private TextView sourceCitySelectTextView;
    private TextView sourceTextView;
    private RelativeLayout stickyHeaderLayout;
    /* access modifiers changed from: private */
    public String storedTripIdForRemoval;
    private View switchCityView;
    private TextView toolbarDateTextView;
    private ImageView toolbarExpandIndicatorImageview;
    private RoboTextView topRatedFirstSortView;
    private int totalFilteredNoOfBuses;
    private boolean zeroResultFound = false;

    static /* synthetic */ void lambda$initialiseReviewLayout$5(View view) {
    }

    public void hideBottomTab() {
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void showBottomTab() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_bus_srp);
        this.appLocale = new Locale(com.paytm.utility.n.a());
        this.compositeDisposable = new io.reactivex.rxjava3.b.b();
        this.mBusSearchPresenter = new com.travel.bus.busticket.g.d(this, this);
        this.cjrBusGtmHelper = new l();
        try {
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("/bus-tickets/search-results", "BusTicket", (Context) this);
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("/bus-tickets-search", "BusTicket", (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
        this.mBusSearchDataUtils = com.travel.bus.busticket.i.d.a();
        initData();
        initView();
        initFilterAdapter();
    }

    public void initData() {
        this.mBusTicketFilters = new CJRBusTicketFilters();
        this.mHandler = new Handler();
        this.mBusTicketFilters.setBusTicketFilterItems(new ArrayList());
        Intent intent = getIntent();
        CJRBusSearchInput cJRBusSearchInput = new CJRBusSearchInput();
        if (intent != null) {
            if (intent.hasExtra("intent_extra_bus_search_from") && intent.hasExtra("intent_extra_bus_search_to") && intent.hasExtra("intent_extra_bus_search_date")) {
                cJRBusSearchInput.setSource((CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_bus_search_from"));
                cJRBusSearchInput.setDestination((CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_bus_search_to"));
                cJRBusSearchInput.setDate(intent.getStringExtra("intent_extra_bus_search_date"));
            } else if (intent.hasExtra("extra_home_data")) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data");
                CJRBusOriginCityItem cJRBusOriginCityItem = new CJRBusOriginCityItem();
                cJRBusOriginCityItem.setName(cJRHomePageItem.getPushSourceCityName());
                cJRBusOriginCityItem.setShortCityName(cJRHomePageItem.getPushSourceCityShortName());
                cJRBusSearchInput.setSource(cJRBusOriginCityItem);
                CJRBusOriginCityItem cJRBusOriginCityItem2 = new CJRBusOriginCityItem();
                cJRBusOriginCityItem2.setName(cJRHomePageItem.getPushDestinationCityName());
                cJRBusOriginCityItem2.setShortCityName(cJRHomePageItem.getPushDestinationCityShortName());
                cJRBusSearchInput.setDestination(cJRBusOriginCityItem2);
                cJRBusSearchInput.setDate(cJRHomePageItem.getPushDate());
            }
        }
        this.mBusSearchInput = cJRBusSearchInput;
        com.travel.bus.busticket.i.y yVar = com.travel.bus.busticket.i.y.f22482a;
        com.travel.bus.busticket.i.y.a((Object) this.mBusSearchInput);
        if (getIntent() != null) {
            if (getIntent().hasExtra("deals_filter")) {
                this.isDealsFilter = getIntent().getStringExtra("deals_filter");
            }
            if (getIntent().hasExtra("popular_choice_filter_id")) {
                this.busPopularChoiceID = getIntent().getStringExtra("popular_choice_filter_id");
            }
            if (getIntent().hasExtra("operatorId")) {
                this.mOperatorId = getIntent().getStringExtra("operatorId");
            }
        }
    }

    public void initView() {
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mLinearClearView = (LinearLayout) findViewById(R.id.linear_clear_view);
        this.mLinearClearView.setOnClickListener(this);
        setSupportActionBar(this.mToolbar);
        setActionbarView();
        this.mToolbar.setVisibility(8);
        this.mBusSearchOptionsFrame = findViewById(R.id.frame_bus_search_background);
        this.mBusSearchOptionsLayout = findViewById(R.id.layout_bus_search);
        this.closeBusSearchView = findViewById(R.id.toolbar_btn_search_close);
        this.mImageFilterSelected = (ImageView) findViewById(R.id.card_filter_selected);
        this.mTvSortText = (TextView) findViewById(R.id.tv_sortby_text);
        this.alternateRecyclerView = (RecyclerView) findViewById(R.id.recycler_alternate_routes);
        this.closeBusSearchView.setOnClickListener(this);
        this.mLytLoadingScreen = (LinearLayout) findViewById(R.id.lyt_loading);
        this.busProgressBarAnimation = new com.travel.bus.busticket.d.a(this, this.mLytLoadingScreen);
        this.busProgressBarAnimation.a();
        this.mCancelLoadingScreenBtn = (TextView) findViewById(R.id.cancel_button_loading_screen);
        this.mCancelLoadingScreenBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusSearchSRPActivity.this.lambda$initView$0$AJRBusSearchSRPActivity(view);
            }
        });
        this.mSrpFiltersRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_srp_filters);
        this.mRelSrpFilterView = (RelativeLayout) findViewById(R.id.rel_srp_filter);
        this.mLytProgressBar = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        this.mNoSearchResultFound = (LinearLayout) findViewById(R.id.no_result_found_layout);
        this.mTryAnotherSearch = (Button) findViewById(R.id.search_another_route);
        this.mTryAnotherSearchMessage = (TextView) findViewById(R.id.des_message_no_bus);
        this.filterbusNoFooter = (TextView) findViewById(R.id.text_view_filter_sub_text);
        this.sourceCitySelectTextView = (TextView) findViewById(R.id.text_view_select_source_city);
        this.destinationCitySelectTextView = (TextView) findViewById(R.id.text_view_select_destination_city);
        this.departureDateTextView = (TextView) findViewById(R.id.departure_date_text_view);
        this.departureWeekTextView = (TextView) findViewById(R.id.departure_week_text_view);
        this.departureMonthTextView = (TextView) findViewById(R.id.departure_month_text_view);
        this.departureDateSelectView = findViewById(R.id.layout_select_departure_date);
        this.mLinResetYourFilter = (LinearLayout) findViewById(R.id.lin_reset_your_filter);
        this.mTextResetYourFilter = (TextView) findViewById(R.id.reset_your_filter);
        this.mTextResetYourFilter.setOnClickListener(this);
        this.dateTodayTextView = (TextView) findViewById(R.id.text_view_date_today);
        this.dateTomorowTextView = (TextView) findViewById(R.id.text_view_date_tomorrow);
        this.dateDayAfterTomorrowTextView = (TextView) findViewById(R.id.text_view_date_day_after_tomorrow);
        this.daySelectTodayView = findViewById(R.id.layout_select_day_today);
        this.daySelectTomorrowView = findViewById(R.id.layout_select_day_tomorrow);
        this.daySelectDayAfterTomorrowView = findViewById(R.id.layout_select_day_after_tomorrow);
        this.dayOfWeekTodayTextView = (TextView) findViewById(R.id.text_view_day_of_week_today);
        this.dayOfWeekTomorrowTextView = (TextView) findViewById(R.id.text_view_day_of_week_tomorrow);
        this.dayOfWeekDayAfterTomorrowTextView = (TextView) findViewById(R.id.text_view_day_of_week_day_after_tomorrow);
        this.sourceCitySelectTextView.setOnClickListener(this);
        this.destinationCitySelectTextView.setOnClickListener(this);
        this.departureDateSelectView.setOnClickListener(this);
        this.daySelectTodayView.setOnClickListener(this);
        this.daySelectTomorrowView.setOnClickListener(this);
        this.daySelectDayAfterTomorrowView.setOnClickListener(this);
        this.notificationLayout = (ViewGroup) findViewById(R.id.layout_notification);
        this.removeNotificationTextView = (ImageView) findViewById(R.id.image_view_remove_notification);
        this.removeNotificationTextView.setOnClickListener(this);
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        instance.add(5, 1);
        Date time2 = instance.getTime();
        instance.add(5, 1);
        Date time3 = instance.getTime();
        this.dateTodayTextView.setText(this.shortDateFormat.format(time));
        this.dateTomorowTextView.setText(this.shortDateFormat.format(time2));
        this.dateDayAfterTomorrowTextView.setText(this.shortDateFormat.format(time3));
        this.dayOfWeekTomorrowTextView.setText(this.shortDayFormat.format(time2));
        this.dayOfWeekDayAfterTomorrowTextView.setText(this.shortDayFormat.format(time3));
        this.sourceCitySelectTextView.setText(this.mBusSearchInput.getSource().getDisplayCityName());
        this.destinationCitySelectTextView.setText(this.mBusSearchInput.getDestination().getDisplayCityName());
        this.sourceCitySelectTextView.setTag(this.mBusSearchInput.getSource());
        this.destinationCitySelectTextView.setTag(this.mBusSearchInput.getDestination());
        try {
            Date parse = this.inputDateFormat.parse(this.mBusSearchInput.getDate());
            setDateToSearchLayout(this.fullDateFormat.format(parse), com.paytm.utility.b.a(Long.valueOf(parse.getTime())));
            this.mHomePageSelectedDateValue = parse.getTime();
            this.modifyLayoutSelectedDateValue = this.mHomePageSelectedDateValue;
            updateDayUI(getDateDiff(new Date(), new Date(this.mHomePageSelectedDateValue)));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        this.mRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.pre_b_rotate360);
        this.mRotateAnimation.setRepeatCount(1);
        this.mAnimMoveUp = AnimationUtils.loadAnimation(this, R.anim.pre_b_move_up);
        this.mAnimMoveDown = AnimationUtils.loadAnimation(this, R.anim.pre_b_move_down);
        this.switchCityView = findViewById(R.id.sep_route);
        this.switchCityView.setOnClickListener(this);
        this.searchBusesButton = (Button) findViewById(R.id.button_search_buses);
        this.searchBusesButton.setOnClickListener(this);
        this.showAcBusesLabelTextView = (TextView) findViewById(R.id.text_view_show_ac_buses_label);
        this.mListView = (RecyclerView) findViewById(R.id.list_bus_search);
        this.stickyHeaderLayout = (RelativeLayout) findViewById(R.id.sticky_header_group_layout);
        this.stickyHeaderLayout.setVisibility(8);
        this.mGroupLogo = (ImageView) findViewById(R.id.image_view_bus_group_logo_in_header_card);
        this.mGroupNameTextView = (TextView) findViewById(R.id.text_view_bus_group_name_in_header_card);
        this.mMinimumFareTextView = (TextView) findViewById(R.id.text_view_bus_group_minimum_price_in_header_card);
        this.mBusCountTextView = (TextView) findViewById(R.id.text_view_show_buses_toggle_in_header_card);
        this.mStartingFromTime = (TextView) findViewById(R.id.text_start_time_in_header_card);
        this.mRtcHeaderCardView = (ViewGroup) findViewById(R.id.card_view_rtc_header_in_header_card);
        this.mRtcHeaderCardView.setBackgroundResource(R.drawable.travel_res_bus_uniform_shadow_header);
        this.mShowBusesToggleImageView = (ImageView) findViewById(R.id.image_view_show_buses_arrow_toggle_in_header_card);
        com.paytm.utility.b.d(this.mGroupNameTextView);
        this.mRtcHeaderCardView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusSearchSRPActivity.this.lambda$initView$1$AJRBusSearchSRPActivity(view);
            }
        });
        initSearchResultListFrament();
        initBottomActionBarLayout();
        com.travel.bus.busticket.i.y yVar = com.travel.bus.busticket.i.y.f22482a;
        com.travel.bus.busticket.i.y.a(com.travel.bus.busticket.i.b.class).subscribe(new io.reactivex.rxjava3.a.w<com.travel.bus.busticket.i.b>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                com.travel.bus.busticket.i.b bVar = (com.travel.bus.busticket.i.b) obj;
                n unused = AJRBusSearchSRPActivity.this.headerViewHolder = bVar.f22418a;
                com.travel.bus.busticket.i.b unused2 = AJRBusSearchSRPActivity.this.headerDataModel = bVar;
            }

            public final void onSubscribe(c cVar) {
                AJRBusSearchSRPActivity.this.compositeDisposable.a(cVar);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$AJRBusSearchSRPActivity(View view) {
        CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
        CharSequence text = this.toolbarDateTextView.getText();
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "cancel_clicked");
        hashMap.put("event_label", cJRBusSearchInput.getSource().getName() + AppConstants.AND_SIGN + cJRBusSearchInput.getDestination().getName() + AppConstants.AND_SIGN + text);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        isReviewVisible();
    }

    public /* synthetic */ void lambda$initView$1$AJRBusSearchSRPActivity(View view) {
        n nVar;
        ViewGroup viewGroup = this.mRtcHeaderCardView;
        if (viewGroup != null && viewGroup.getVisibility() == 0 && (nVar = this.headerViewHolder) != null) {
            onGroupViewClicked(nVar.j, 0);
            this.headerViewHolder.a();
        }
    }

    public void initFilterAdapter() {
        this.mSrpFilterAdapter = new y(getLayoutInflater(), this, this.mRelSrpFilterView);
        this.mSrpFiltersRecyclerView.addItemDecoration(new com.travel.bus.busticket.a());
        this.mSrpFiltersRecyclerView.setAdapter(this.mSrpFilterAdapter);
    }

    private void initBottomActionBarLayout() {
        this.mBottomActionBar = (ViewGroup) findViewById(R.id.layout_bottom_srp_action_bar);
        this.mSortView = findViewById(R.id.layout_sort);
        this.mFilterView = findViewById(R.id.layout_filter);
        this.mAcBusesFilterToggleView = findViewById(R.id.layout_ac_buses_filter_toggle_view);
        this.mShowAcBusesSwitch = (Switch) findViewById(R.id.switch_show_ac_buses_toggle);
        this.mNightBusesFilterToggleView = findViewById(R.id.layout_night_buses_toggle_view);
        this.mCovidBusesFilterToggleView = findViewById(R.id.layout_covid_buses_toggle_view);
        this.mTextNightBusesFilter = (TextView) findViewById(R.id.txt_night_buses_toggle_view);
        this.mTextCovidBusesFilter = (TextView) findViewById(R.id.txt_covid_buses_toggle_view);
        this.mShowNightBusesSwitch = (Switch) findViewById(R.id.switch_show_night_buses_toggle);
        this.mShowCovidBusesSwitch = (Switch) findViewById(R.id.switch_show_covid_buses_toggle);
        this.mDealsBusesFilterToggleView = findViewById(R.id.layout_deals_buses_toggle_view);
        this.mTextDealsBusesFilter = (TextView) findViewById(R.id.txt_deals_buses_toggle_view);
        this.mShowDealsBusesSwitch = (Switch) findViewById(R.id.switch_show_deals_buses_toggle);
        this.mDealsViewLine = findViewById(R.id.view_deals_line);
        this.mSortSubTextView = (TextView) findViewById(R.id.text_view_sort_sub_text);
        this.mSortOptionsFrame = (ViewGroup) findViewById(R.id.frame_sort_options);
        this.mSortOptionsLayout = (ViewGroup) findViewById(R.id.layout_sort_options);
        this.mCloseSortOptionsImageView = (ImageView) findViewById(R.id.image_view_close_sort_options);
        this.topRatedFirstSortView = (RoboTextView) findViewById(R.id.text_view_sort_option_top_rated_first);
        this.cheapestFirstSortView = (RoboTextView) findViewById(R.id.text_view_sort_option_cheapest_first);
        this.durationShortestFirstView = (RoboTextView) findViewById(R.id.text_view_sort_option_duration_shortest_first);
        this.departureAscendingSortView = (RoboTextView) findViewById(R.id.text_view_sort_option_departure_morning_to_evening);
        this.departureDescendingSortView = (RoboTextView) findViewById(R.id.text_view_sort_option_departure_evening_to_morning);
        this.mSortView.setOnClickListener(this);
        this.mFilterView.setOnClickListener(this);
        this.mCloseSortOptionsImageView.setOnClickListener(this);
        this.mShowAcBusesSwitch.setOnCheckedChangeListener(this);
        this.mAcBusesFilterToggleView.setOnClickListener(this);
        this.mNightBusesFilterToggleView.setOnClickListener(this);
        this.mCovidBusesFilterToggleView.setOnClickListener(this);
        this.mTextNightBusesFilter.setOnClickListener(this);
        this.mTextCovidBusesFilter.setOnClickListener(this);
        this.mDealsBusesFilterToggleView.setOnClickListener(this);
        this.mTextDealsBusesFilter.setOnClickListener(this);
        this.topRatedFirstSortView.setOnClickListener(this);
        this.cheapestFirstSortView.setOnClickListener(this);
        this.durationShortestFirstView.setOnClickListener(this);
        this.departureAscendingSortView.setOnClickListener(this);
        this.departureDescendingSortView.setOnClickListener(this);
        this.mSortOptionsFrame.setOnClickListener(this);
        this.mBusSearchOptionsFrame.setOnClickListener(this);
        this.topRatedFirstSortView.setTag(Boolean.FALSE);
        this.cheapestFirstSortView.setTag(Boolean.FALSE);
        this.durationShortestFirstView.setTag(Boolean.FALSE);
        this.departureAscendingSortView.setTag(Boolean.FALSE);
        this.departureDescendingSortView.setTag(Boolean.FALSE);
        this.mDealsBusesFilterToggleView.setVisibility(8);
        this.mDealsViewLine.setVisibility(8);
        this.mCovidBusesFilterToggleView.setVisibility(8);
    }

    public boolean isSocialEnabledAppManager() {
        com.travel.bus.a.a();
        return com.travel.bus.a.b().a("isBusSocialDistancingFilterEnable", false);
    }

    public void setActionbarView() {
        this.sourceTextView = (TextView) findViewById(R.id.source_text_view);
        CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
        if (cJRBusSearchInput == null || cJRBusSearchInput.getSource() == null || this.mBusSearchInput.getSource().getDisplayCityName() == null || this.mBusSearchInput.getSource().getDisplayCityName().isEmpty()) {
            CJRBusSearchInput cJRBusSearchInput2 = this.mBusSearchInput;
            if (!(cJRBusSearchInput2 == null || cJRBusSearchInput2.getSource() == null)) {
                this.sourceTextView.setText(this.mBusSearchInput.getSource().getName());
            }
        } else {
            this.sourceTextView.setText(this.mBusSearchInput.getSource().getDisplayCityName());
        }
        this.destTextView = (TextView) findViewById(R.id.dest_text_view);
        CJRBusSearchInput cJRBusSearchInput3 = this.mBusSearchInput;
        if (cJRBusSearchInput3 == null || cJRBusSearchInput3.getDestination() == null || this.mBusSearchInput.getDestination().getDisplayCityName() == null || this.mBusSearchInput.getDestination().getDisplayCityName().isEmpty()) {
            CJRBusSearchInput cJRBusSearchInput4 = this.mBusSearchInput;
            if (!(cJRBusSearchInput4 == null || cJRBusSearchInput4.getDestination() == null)) {
                this.destTextView.setText(this.mBusSearchInput.getDestination().getName());
            }
        } else {
            this.destTextView.setText(this.mBusSearchInput.getDestination().getDisplayCityName());
        }
        this.toolbarDateTextView = (TextView) findViewById(R.id.date_text_view);
        this.toolbarExpandIndicatorImageview = (ImageView) findViewById(R.id.image_view_toolbar_expand_toggle);
        setDateInActionBar(this.mBusSearchInput.getDate());
        this.backButtonImageView = (ImageView) findViewById(R.id.toolbar_btn_back);
        this.backButtonImageView.setOnClickListener(this);
        this.mToolbar.setOnClickListener(this);
    }

    private void initSearchResultListFrament() {
        if (this.mBusSearchInput != null) {
            updateBpDpRequired();
            io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable() {
                public final Object call() {
                    return AJRBusSearchSRPActivity.this.lambda$initSearchResultListFrament$2$AJRBusSearchSRPActivity();
                }
            }).b(io.reactivex.rxjava3.i.a.b()).c();
            initialiseReviewLayout();
        }
    }

    public /* synthetic */ Object lambda$initSearchResultListFrament$2$AJRBusSearchSRPActivity() throws Exception {
        AJRBusSearchSRPActivity.class.getSimpleName();
        new StringBuilder("thread -> ").append(Thread.currentThread().getName());
        this.mBusSearchPresenter.a(this.mBusTicketFilters, this.mBusSearchInput);
        return io.reactivex.rxjava3.a.b.a();
    }

    private void updateBpDpRequired() {
        if ("CITY_BP".equalsIgnoreCase(this.mBusSearchInput.getSource().getAliasType()) || "CITY_BP".equalsIgnoreCase(this.mBusSearchInput.getDestination().getAliasType())) {
            this.extraBpDpRequired = true;
        }
    }

    private void sendBusDataToFragment(int i2) {
        new Thread() {
            public final void run() {
                try {
                    AJRBusSearchSRPActivity.this.loadData(AJRBusSearchSRPActivity.this.getBusSearchResultData(), AJRBusSearchSRPActivity.this.storedTripIdForRemoval);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }.start();
    }

    public void onDataLoaded(CJRBusSearch cJRBusSearch) {
        ArrayList<CJRBusSearchItem> trips = cJRBusSearch.getBody().getTrips();
        if (this.shouldCreateFilterData && trips != null && trips.size() > 0) {
            this.shouldCreateFilterData = false;
            com.travel.bus.pojo.busticket.g a2 = com.travel.bus.busticket.g.d.a(trips, this.mOperatorId);
            this.mAllowedMaxFare = a2.f22812a;
            this.mAllowedMinFare = a2.f22813b;
            setBusFilterContainer(a2.f22814c);
            this.mBusSearchItems = new ArrayList<>();
            this.mBusSearchItems.addAll(trips);
        }
        this.mLytLoadingScreen.setVisibility(8);
        this.busProgressBarAnimation.b();
        this.mToolbar.setVisibility(0);
        this.mBottomActionBar.setVisibility(0);
        if (!this.resultsLoadedGtmEventSent) {
            try {
                com.travel.bus.a.a();
                com.travel.bus.a.b().b("screen_loaded_bus_selection", "/bus-tickets/search-results", this);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            this.resultsLoadedGtmEventSent = true;
        }
        if (cJRBusSearch.getBody().getDictionary().getAmenitiesInfo() != null) {
            this.mAmenityInfo = cJRBusSearch.getBody().getDictionary().getAmenitiesInfo();
            setAmenityList(cJRBusSearch);
        }
        if (cJRBusSearch.getBody().getDictionary().getOperatorTags() != null) {
            this.mOperatorTagInfo = cJRBusSearch.getBody().getDictionary().getOperatorTags();
            setOperatorTagList(cJRBusSearch);
        }
    }

    private void setOperatorTagList(CJRBusSearch cJRBusSearch) {
        Set<Integer> keySet = cJRBusSearch.getmOperatorTagCount().keySet();
        HashMap hashMap = new HashMap(this.mOperatorTagInfo);
        for (CJRBusSearchOperatorTagInfo next : this.mOperatorTagInfo.values()) {
            if (!keySet.contains(Integer.valueOf(next.getTagId()))) {
                hashMap.remove(next.getTagId());
            }
        }
        this.mOperatorTagInfo.clear();
        this.mOperatorTagInfo.putAll(hashMap);
        for (Integer intValue : keySet) {
            int intValue2 = intValue.intValue();
            CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.mOperatorTagInfo.get(String.valueOf(intValue2));
            if (!(cJRBusSearch.getmOperatorTagCount().get(Integer.valueOf(intValue2)) == null || cJRBusSearchOperatorTagInfo == null)) {
                this.mOperatorTagInfo.get(String.valueOf(intValue2)).setCount(cJRBusSearch.getmOperatorTagCount().get(Integer.valueOf(intValue2)).intValue());
            }
        }
    }

    private void setAmenityList(CJRBusSearch cJRBusSearch) {
        Set<Integer> keySet = cJRBusSearch.getmAmenityCount().keySet();
        HashMap hashMap = new HashMap(this.mAmenityInfo);
        for (CJRBusSearchAmenitiesInfo next : this.mAmenityInfo.values()) {
            if (!keySet.contains(Integer.valueOf(next.getId()))) {
                hashMap.remove(next.getId());
            }
        }
        this.mAmenityInfo.clear();
        this.mAmenityInfo.putAll(hashMap);
        for (Integer intValue : keySet) {
            int intValue2 = intValue.intValue();
            CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = this.mAmenityInfo.get(String.valueOf(intValue2));
            if (!(cJRBusSearch.getmAmenityCount().get(Integer.valueOf(intValue2)) == null || cJRBusSearchAmenitiesInfo == null)) {
                this.mAmenityInfo.get(String.valueOf(intValue2)).setCount(cJRBusSearch.getmAmenityCount().get(Integer.valueOf(intValue2)).intValue());
            }
        }
    }

    public void onBusSearchListItemClick(CJRBusSearchItem cJRBusSearchItem, int i2) {
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() != 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            showProgressBarLyt();
            startSeatSelectionActivity(cJRBusSearchItem);
            this.mBusSearchPresenter.a(cJRBusSearchItem, i2, this.mBusSearchItems, this.mOperatorTagInfo, this.mAmenityInfo);
            if (cJRBusSearchItem != null) {
                try {
                    if (cJRBusSearchItem.getTripId() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Search Screen");
                        hashMap.put("bus_merchant_name", cJRBusSearchItem.getTravelsName());
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a("bus_search_merchant_selected", (Map<String, Object>) hashMap, (Context) this);
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.c(e2.getMessage());
                    }
                }
            }
            if (cJRBusSearchItem != null) {
                try {
                    if (cJRBusSearchItem.getTripId() != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("bus_merchant_name", cJRBusSearchItem.getTravelsName());
                        hashMap2.put("rating", cJRBusSearchItem.getBusRating());
                        hashMap2.put("position_of_selection", Integer.valueOf(i2));
                        hashMap2.put("selling_out_fast_tag", Boolean.valueOf(cJRBusSearchItem.getFlag().getSellingFast()));
                        hashMap2.put("bus_price", cJRBusSearchItem.getFare());
                        hashMap2.put("bus_duration", cJRBusSearchItem.getDuration());
                        hashMap2.put("bus_seat_left", cJRBusSearchItem.getAvalableSeats());
                        hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
                        com.travel.bus.a.a();
                        com.travel.bus.a.b().a("bus_search_merchant_bus_clicked", (Map<String, Object>) hashMap2, (Context) this);
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.c(e3.getMessage());
                    }
                }
            }
            l.a((Context) this, cJRBusSearchItem, i2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event_label", Integer.valueOf(i2));
            hashMap3.put("event_label2", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
            try {
                hashMap3.put("event_label3", new SimpleDateFormat("dd-MMM-yy".replace("-", " ")).format(new SimpleDateFormat("yyyy-MM-dd").parse(this.mBusSearchInput.getDate())));
            } catch (Exception e4) {
                q.c(e4.getMessage());
            }
            hashMap3.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "merchant_selected", hashMap3);
        }
    }

    public void onNoResultFound(boolean z, String str, boolean z2, boolean z3) {
        int i2;
        TextView textView;
        TextView textView2;
        String str2 = str;
        if (!isFinishing()) {
            if (z) {
                HashMap hashMap = new HashMap();
                hashMap.put("event_label", this.sourceTextView.getText().toString() + "/" + this.destTextView.getText().toString());
                if (Build.VERSION.SDK_INT >= 24) {
                    hashMap.put("event_label2", getResources().getConfiguration().getLocales().get(0).getDisplayLanguage());
                } else {
                    hashMap.put("event_label2", getResources().getConfiguration().locale);
                }
                hashMap.put("userid", com.paytm.utility.b.n((Context) this));
                com.travel.bus.a.a();
                com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "city_search_no_result_found", hashMap);
                this.mImageFilterSelected.setVisibility(4);
                this.filterbusNoFooter.setVisibility(4);
                this.mLinResetYourFilter.setVisibility(8);
                this.mNoSearchResultFound.setVisibility(0);
                CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event_category", "bus_search");
                hashMap2.put("event_action", "bus_no_route_found");
                String str3 = "";
                String name = (cJRBusSearchInput == null || cJRBusSearchInput.getSource() == null || cJRBusSearchInput.getSource().getName() == null) ? str3 : cJRBusSearchInput.getSource().getName();
                String name2 = (cJRBusSearchInput == null || cJRBusSearchInput.getDestination() == null || cJRBusSearchInput.getDestination().getName() == null) ? str3 : cJRBusSearchInput.getDestination().getName();
                if (!(cJRBusSearchInput == null || cJRBusSearchInput.getDate() == null)) {
                    str3 = cJRBusSearchInput.getDate();
                }
                hashMap2.put("event_label", name + AppConstants.AND_SIGN + name2 + AppConstants.AND_SIGN + str3);
                hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                hashMap2.put("vertical_name", "bus");
                hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) this);
                this.mToolbar.setVisibility(0);
                this.mBottomActionBar.setVisibility(8);
                if (z2) {
                    this.mImageFilterSelected.setVisibility(0);
                    this.mBottomActionBar.setVisibility(0);
                }
                findViewById(R.id.bus_error_message).setVisibility(8);
                this.mTryAnotherSearchMessage.setVisibility(0);
                TextView textView3 = (TextView) findViewById(R.id.search_clear_filter);
                textView3.setOnClickListener(this);
                ImageView imageView = (ImageView) findViewById(R.id.bus_error_image_view);
                TextView textView4 = (TextView) findViewById(R.id.bus_error_title);
                if (z2) {
                    textView4.setVisibility(8);
                    textView = textView3;
                    this.mTryAnotherSearchMessage.setTextColor(getResources().getColor(R.color.color_000000));
                    ResourceUtils.loadBusImagesFromCDN(imageView, "no_routes_image_revamp.png", false, false, n.a.V1);
                } else {
                    textView = textView3;
                    if (z3) {
                        textView4.setVisibility(0);
                        textView4.setText(getString(R.string.no_buses_found_on_this_route));
                        this.mTryAnotherSearchMessage.setTextColor(getResources().getColor(R.color.color_FF666666));
                        ResourceUtils.loadBusImagesFromCDN(imageView, "no_buses_new_image_revamp.png", false, false, n.a.V1);
                    } else {
                        textView4.setVisibility(0);
                        textView4.setText(getString(R.string.buses_not_running_on_this_route));
                        this.mTryAnotherSearchMessage.setTextColor(getResources().getColor(R.color.color_FF666666));
                        ResourceUtils.loadBusImagesFromCDN(imageView, "no_routes_new_image_revamp.png", false, false, n.a.V1);
                    }
                }
                if (str2 != null && !str2.equalsIgnoreCase("410")) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("event_category", "bus_search");
                    hashMap3.put("event_action", "error_popup");
                    hashMap3.put("event_label", str2);
                    hashMap3.put("event_label2", " ");
                    hashMap3.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                    hashMap3.put("vertical_name", "bus");
                    hashMap3.put("user_id", com.paytm.utility.b.n((Context) this));
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap3, (Context) this);
                    if (str2.contains(this.toolbarDateTextView.getText().toString())) {
                        TextView textView5 = this.mTryAnotherSearchMessage;
                        com.travel.bus.busticket.g.d dVar = this.mBusSearchPresenter;
                        String charSequence = this.toolbarDateTextView.getText().toString();
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                        spannableStringBuilder.setSpan(new StyleSpan(1), str2.indexOf(charSequence), str2.indexOf(charSequence) + charSequence.length(), 33);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.f22363a.getResources().getColor(R.color.color_000000)), str2.indexOf(charSequence), str2.indexOf(charSequence) + charSequence.length(), 33);
                        textView5.setText(spannableStringBuilder);
                    } else {
                        this.mTryAnotherSearchMessage.setText(str2);
                    }
                }
                TextView textView6 = this.mTryAnotherSearchMessage;
                if ((textView6 == null || textView6.getText() == null || !this.mTryAnotherSearchMessage.getText().toString().contains("alternative route")) && ((textView2 = this.mTryAnotherSearchMessage) == null || textView2.getText() == null || !this.mTryAnotherSearchMessage.getText().toString().contains("alternate route"))) {
                    this.mTryAnotherSearch.setText(getString(R.string.bus_search_for_next_day));
                } else {
                    this.mTryAnotherSearch.setText(getString(R.string.bus_search_for_another_route));
                }
                if (z2) {
                    textView.setVisibility(0);
                    i2 = 8;
                    this.mTryAnotherSearch.setVisibility(8);
                } else {
                    i2 = 8;
                    textView.setVisibility(8);
                    this.mTryAnotherSearch.setVisibility(0);
                }
                this.mTryAnotherSearch.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJRBusSearchSRPActivity.this.lambda$onNoResultFound$3$AJRBusSearchSRPActivity(view);
                    }
                });
            } else {
                i2 = 8;
                this.mNoSearchResultFound.setVisibility(8);
                this.mBottomActionBar.setVisibility(0);
            }
            this.mLytLoadingScreen.setVisibility(i2);
        }
    }

    public /* synthetic */ void lambda$onNoResultFound$3$AJRBusSearchSRPActivity(View view) {
        openModificationScreen();
    }

    public void showMaintenanceErrorAlert(String str, String str2) {
        this.stickyHeaderLayout.setVisibility(8);
        this.mLinearClearView.setVisibility(8);
        this.mNoSearchResultFound.setVisibility(0);
        this.mToolbar.setVisibility(0);
        this.mBottomActionBar.setVisibility(8);
        this.mTryAnotherSearchMessage.setVisibility(8);
        this.mTryAnotherSearch.setVisibility(8);
        findViewById(R.id.bus_error_title).setVisibility(0);
        findViewById(R.id.bus_error_message).setVisibility(8);
        findViewById(R.id.search_clear_filter).setVisibility(8);
        ((TextView) findViewById(R.id.bus_error_title)).setText(str2);
        ResourceUtils.loadBusImagesFromCDN((ImageView) findViewById(R.id.bus_error_image_view), "snap_error_image_revamp.png", false, false, n.a.V1);
    }

    public void onClearAllFilter() {
        this.mImageFilterSelected.setVisibility(4);
        this.filterbusNoFooter.setVisibility(4);
        this.mLinResetYourFilter.setVisibility(8);
        CJRBusTicketFilters cJRBusTicketFilters = this.mBusTicketFilters;
        if (cJRBusTicketFilters != null) {
            cJRBusTicketFilters.setmNightBusesFlag(false);
            toggleNightBuses(false);
            toggleCovidBuses();
            toggleDealsBuses();
            this.mShowAcBusesSwitch.setChecked(false);
            this.showAcBusesLabelTextView.setTextColor(getResources().getColor(R.color.color_222222));
            if (this.mBusTicketFilters.getBusTicketFilterItems() != null && this.mBusTicketFilters.getBusTicketFilterItems().size() > 0) {
                this.mBusTicketFilters.getBusTicketFilterItems().clear();
            }
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.mCurrentSelectedAmenityList;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    private void toggleNightBuses(boolean z) {
        this.mBusTicketFilters.setmNightBusesFlag(z);
        this.mTextNightBusesFilter.setTextColor(getResources().getColor(z ? R.color.color_00b9f5 : R.color.color_222222));
    }

    public void startSeatSelectionActivity(CJRBusSearchItem cJRBusSearchItem) {
        if (cJRBusSearchItem == null) {
            return;
        }
        if (cJRBusSearchItem.getFeature().getCollectLocationPoints() == null || !cJRBusSearchItem.getFeature().getCollectLocationPoints().booleanValue()) {
            Intent intent = new Intent(this, AJRBusSelectSeatsActivity.class);
            intent.putExtra("intent_extra_bus_search_result_item", cJRBusSearchItem);
            intent.putExtra("intent_extra_bus_search", com.travel.bus.busticket.i.d.a().f22430h);
            CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
            if (cJRBusSearchInput != null) {
                intent.putExtra("intent_extra_bus_search_input", cJRBusSearchInput);
            }
            CJRBusSearch cJRBusSearch = this.mBusSearch;
            if (!(cJRBusSearch == null || cJRBusSearch.getBody() == null || this.mBusSearch.getBody().getDictionary().getAmenitiesInfo() == null)) {
                intent.putExtra("amenity_info", this.mBusSearch.getBody().getDictionary().getAmenitiesInfo());
            }
            intent.putExtra("intent_extra_bus_search_load_data", this.mBusSearch.getBody().getDictionary().getOperatorTags());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            startActivityForResult(intent, 2);
            hideProgressBarLyt();
            return;
        }
        startReviewRouteandCancellationActivity(cJRBusSearchItem, "route", 1);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        CJRBusOriginCityItem cJRBusOriginCityItem;
        super.onActivityResult(i2, i3, intent);
        com.google.android.play.core.splitcompat.a.b((Context) this);
        if (i2 != 201) {
            this.mLinearClearView.setVisibility(0);
            this.mNoSearchResultFound.setVisibility(8);
            this.mBottomActionBar.setVisibility(0);
        }
        if (i2 == 1) {
            if (i3 == -1) {
                if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_items")) {
                    this.mBusTicketFilters = (CJRBusTicketFilters) intent.getSerializableExtra("intent_extra_bus_search_filter_items");
                    onFiltersChanged(true);
                }
                if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_amenity_items")) {
                    this.mCurrentSelectedAmenityList = (ArrayList) intent.getSerializableExtra("intent_extra_bus_search_filter_amenity_items");
                }
                if (intent != null && intent.hasExtra("intent_extra_extra_bp_dp_required")) {
                    this.extraBpDpRequired = intent.getBooleanExtra("intent_extra_extra_bp_dp_required", false);
                    return;
                }
                return;
            }
            checkFilter(this.mBusTicketFilters);
        } else if (i2 == 2) {
            if (intent != null && intent.hasExtra("trip_id")) {
                this.storedTripIdForRemoval = intent.getStringExtra("trip_id");
                updateListItemsInFragment(this.storedTripIdForRemoval);
            }
        } else if (i2 == 4) {
            if (intent != null && intent.hasExtra("trip_id")) {
                this.storedTripIdForRemoval = intent.getStringExtra("trip_id");
                updateListItemsInFragment(this.storedTripIdForRemoval);
            }
        } else if (i2 == 200) {
            onDepartureDateSelectResult(intent);
        } else if (i2 == 201) {
            if (intent != null && intent.hasExtra("intent_extra_selected_city_source_item")) {
                String stringExtra = intent.getStringExtra("intent_extra_selected_source_city_name");
                String stringExtra2 = intent.getStringExtra("intent_extra_selected_destination_city_name");
                CJRBusOriginCityItem cJRBusOriginCityItem2 = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_source_item");
                CJRBusOriginCityItem cJRBusOriginCityItem3 = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_destination_item");
                if (!((cJRBusOriginCityItem2 == null || cJRBusOriginCityItem2.getAliasType() == null || !cJRBusOriginCityItem2.getAliasType().equalsIgnoreCase("CITY_BP")) && (cJRBusOriginCityItem3 == null || cJRBusOriginCityItem3.getAliasType() == null || !cJRBusOriginCityItem3.getAliasType().equalsIgnoreCase("CITY_BP")))) {
                    this.extraBpDpRequired = true;
                }
                if (cJRBusOriginCityItem2 != null) {
                    this.sourceCitySelectTextView.setTag(cJRBusOriginCityItem2);
                }
                if (cJRBusOriginCityItem3 != null) {
                    this.destinationCitySelectTextView.setTag(cJRBusOriginCityItem3);
                }
                CJRBusSearchInput cJRBusSearchInput = new CJRBusSearchInput();
                cJRBusSearchInput.setSource(cJRBusOriginCityItem2);
                cJRBusSearchInput.setDestination(cJRBusOriginCityItem3);
                cJRBusSearchInput.setDate(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(this.modifyLayoutSelectedDateValue)));
                com.travel.bus.busticket.i.y yVar = com.travel.bus.busticket.i.y.f22482a;
                com.travel.bus.busticket.i.y.a((Object) cJRBusSearchInput);
                if (stringExtra != null) {
                    this.sourceCitySelectTextView.setText(stringExtra);
                    this.sourceCitySelectTextView.setTextColor(getResources().getColor(R.color.color_000000));
                }
                if (cJRBusOriginCityItem2 != null) {
                    l.a(this, "source", this.sourceTextView.getText().toString(), cJRBusOriginCityItem2.getDisplayCityName() != null ? cJRBusOriginCityItem2.getDisplayCityName() : cJRBusOriginCityItem2.getName());
                }
                if (cJRBusOriginCityItem3 != null) {
                    l.a(this, "destination", this.destTextView.getText().toString(), cJRBusOriginCityItem3.getDisplayCityName() != null ? cJRBusOriginCityItem3.getDisplayCityName() : cJRBusOriginCityItem3.getName());
                }
                if (stringExtra2 != null) {
                    this.destinationCitySelectTextView.setText(stringExtra2);
                    this.destinationCitySelectTextView.setTextColor(getResources().getColor(R.color.color_000000));
                }
            }
        } else if (i2 == 202 && intent != null && intent.hasExtra("intent_extra_selected_city_name") && (cJRBusOriginCityItem = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_name")) != null) {
            String displayCityName = cJRBusOriginCityItem.getDisplayCityName() != null ? cJRBusOriginCityItem.getDisplayCityName() : cJRBusOriginCityItem.getName();
            l.a(this, "destination", this.destTextView.getText().toString(), displayCityName);
            if (displayCityName != null) {
                this.destinationCitySelectTextView.setText(displayCityName);
                this.destinationCitySelectTextView.setTag(cJRBusOriginCityItem);
                this.destinationCitySelectTextView.setTextColor(getResources().getColor(R.color.color_000000));
            }
        }
    }

    private void checkFilter(CJRBusTicketFilters cJRBusTicketFilters) {
        if (this.mBusSearch != null) {
            w wVar = this.mBusSearchListAdapter;
            if (wVar != null) {
                wVar.f21786h = true;
            }
            ArrayList<CJRBusSearchItem> a2 = com.travel.bus.busticket.g.d.a(this.mBusSearchPresenter.a(this.mCompleteBusList, cJRBusTicketFilters));
            this.operatorGroupListMap = this.mBusSearch.getOperator_groups();
            ArrayList<CJRBusSearchItem> a3 = this.mBusSearchPresenter.a(a2, this.operatorGroupListMap);
            if (this.mBusSearchListAdapter != null) {
                if (a3.size() == 0) {
                    this.mLinearClearView.setVisibility(8);
                    this.mNoSearchResultFound.setVisibility(0);
                } else {
                    this.mLinearClearView.setVisibility(0);
                    this.mNoSearchResultFound.setVisibility(8);
                }
                if (cJRBusTicketFilters != null && cJRBusTicketFilters.getBusTicketFilterItems() != null && cJRBusTicketFilters.getBusTicketFilterItems().size() > 0) {
                    this.mLinearClearView.setVisibility(0);
                }
            }
        }
    }

    public void setBusFilterContainer(CJRBusFilterContainer cJRBusFilterContainer) {
        this.mBusFilterContainer = cJRBusFilterContainer;
        if (cJRBusFilterContainer != null && cJRBusFilterContainer.getmBusTicketFilters() != null && cJRBusFilterContainer.getmBusTicketFilters().getBusTicketFilterItems() != null && cJRBusFilterContainer.getmBusTicketFilters().getBusTicketFilterItems().size() > 0) {
            this.mSrpFilterAdapter.a(cJRBusFilterContainer.getmBusTicketFilters().getBusTicketFilterItems());
            setData(this.mBusSearchInput, cJRBusFilterContainer.getmBusTicketFilters());
            sendBusDataToFragment(0);
        }
    }

    public CJRBusSearch getBusSearchResultData() {
        return this.mBusSearch;
    }

    private void reloadData() {
        setData(this.mBusSearchInput, this.mBusTicketFilters);
        sendBusDataToFragment(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCheckedChanged(android.widget.CompoundButton r7, boolean r8) {
        /*
            r6 = this;
            r7 = 0
            r6.toggleSortOptionsLayoutVisibility(r7)
            r6.toggleBusSearchLayoutVisibility(r7)
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r0 = r6.mBusTicketFilters
            java.lang.String r1 = "AC"
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r0 = r0.getBusFilterItemByTitle(r1)
            r2 = 1
            if (r0 == 0) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            if (r8 == 0) goto L_0x0056
            if (r3 != 0) goto L_0x0063
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r0 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
            r0.<init>()
            com.travel.bus.pojo.busticket.e r3 = com.travel.bus.pojo.busticket.e.BUS_TYPE
            r0.setFilterCategory(r3)
            r0.setTitle(r1)
            java.lang.String r3 = "boolean"
            r0.setType(r3)
            r0.setToggleChecked(r2)
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r4 = r6.mBusTicketFilters
            java.util.ArrayList r4 = r4.getBusTicketFilterItems()
            r4.add(r0)
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r0 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
            r0.<init>()
            com.travel.bus.pojo.busticket.e r4 = com.travel.bus.pojo.busticket.e.BUS_TYPE
            r0.setFilterCategory(r4)
            java.lang.String r4 = "Non AC"
            r0.setTitle(r4)
            r0.setType(r3)
            r0.setToggleChecked(r2)
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r3 = r6.mBusTicketFilters
            java.util.ArrayList r3 = r3.getBusTicketFilterItems()
            r3.remove(r0)
            goto L_0x0061
        L_0x0056:
            if (r3 == 0) goto L_0x0063
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r3 = r6.mBusTicketFilters
            java.util.ArrayList r3 = r3.getBusTicketFilterItems()
            r3.remove(r0)
        L_0x0061:
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 == 0) goto L_0x0069
            r6.onFiltersChanged(r2)
        L_0x0069:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.travel.bus.pojo.busticket.CJRBusSearchInput r4 = r6.mBusSearchInput
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r4 = r4.getSource()
            java.lang.String r4 = r4.getDisplayCityName()
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r4 = r6.mBusSearchInput
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r4 = r4.getDestination()
            java.lang.String r4 = r4.getDisplayCityName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "event_label"
            r0.put(r4, r3)
            java.lang.String r3 = "event_label2"
            r0.put(r3, r1)
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r6)
            java.lang.String r4 = "userid"
            r0.put(r4, r3)
            java.lang.String r3 = "bus_search"
            java.lang.String r4 = "/bus-tickets-search"
            java.lang.String r5 = "customEvent"
            if (r8 == 0) goto L_0x00cd
            com.travel.bus.busticket.i.l.a((android.content.Context) r6, (java.lang.String) r1, (boolean) r2)
            android.widget.TextView r7 = r6.showAcBusesLabelTextView
            android.content.res.Resources r8 = r6.getResources()
            int r1 = com.travel.bus.R.color.color_00b9f5
            int r8 = r8.getColor(r1)
            r7.setTextColor(r8)
            com.travel.bus.a.a()
            java.lang.String r7 = "quick_filter_selected"
            com.travel.bus.a.a(r5, r4, r3, r7, r0)
            return
        L_0x00cd:
            com.travel.bus.busticket.i.l.a((android.content.Context) r6, (java.lang.String) r1, (boolean) r7)
            android.widget.TextView r7 = r6.showAcBusesLabelTextView
            android.content.res.Resources r8 = r6.getResources()
            int r1 = com.travel.bus.R.color.color_222222
            int r8 = r8.getColor(r1)
            r7.setTextColor(r8)
            com.travel.bus.a.a()
            java.lang.String r7 = "quick_filter_deselected"
            com.travel.bus.a.a(r5, r4, r3, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSearchSRPActivity.onCheckedChanged(android.widget.CompoundButton, boolean):void");
    }

    private void resetSearchPopupLayout() {
        if (this.mBusSearchInput.getSource().getDisplayCityName() == null || this.mBusSearchInput.getSource().getDisplayCityName().isEmpty()) {
            this.sourceCitySelectTextView.setText(this.mBusSearchInput.getSource().getName());
            this.sourceCitySelectTextView.setTag(this.mBusSearchInput.getSource());
        } else {
            this.sourceCitySelectTextView.setText(this.mBusSearchInput.getSource().getDisplayCityName());
            this.sourceCitySelectTextView.setTag(this.mBusSearchInput.getSource());
        }
        if (this.mBusSearchInput.getDestination().getDisplayCityName() == null || this.mBusSearchInput.getDestination().getDisplayCityName().isEmpty()) {
            this.destinationCitySelectTextView.setText(this.mBusSearchInput.getDestination().getName());
            this.destinationCitySelectTextView.setTag(this.mBusSearchInput.getDestination());
        } else {
            this.destinationCitySelectTextView.setText(this.mBusSearchInput.getDestination().getDisplayCityName());
            this.destinationCitySelectTextView.setTag(this.mBusSearchInput.getDestination());
        }
        try {
            Date parse = this.inputDateFormat.parse(this.mBusSearchInput.getDate());
            setDateToSearchLayout(this.fullDateFormat.format(parse), com.paytm.utility.b.a(Long.valueOf(parse.getTime())));
            updateDayUI(getDateDiff(new Date(), new Date(this.mHomePageSelectedDateValue)));
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.toolbar_btn_back) {
            onBackPressed();
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "back_clicked");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } else if (id == R.id.layout_filter) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_category", "bus_search");
            hashMap2.put("event_action", "filter_icon_clicked");
            hashMap2.put("vertical_name", "bus");
            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) this);
            launchBusFilterActivity();
            toggleSortOptionsLayoutVisibility(false);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event_label", Integer.valueOf(this.mCompleteBusList.size()));
            hashMap3.put("event_label2", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
            hashMap3.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "filter_icon_clicked", hashMap3);
        } else if (id == R.id.layout_sort) {
            toggleSortOptionsLayoutVisibility(!this.isSortViewOpened);
        } else if (id == R.id.image_view_close_sort_options) {
            toggleSortOptionsLayoutVisibility(false);
        } else if (id == R.id.toolbar) {
            openModificationScreen();
        } else if (id == R.id.toolbar_btn_search_close) {
            toggleBusSearchLayoutVisibility(false);
        } else if (id == R.id.text_view_select_source_city) {
            sendCustomGAEvents("from_clicked");
            launchOriginCityActivity(201, "source");
        } else if (id == R.id.text_view_select_destination_city) {
            sendCustomGAEvents("to_clicked");
            launchOriginCityActivity(201, "destination");
        } else if (id == R.id.layout_select_departure_date) {
            launchCalenderActivity(200, this.departureDateTextView.getTag().toString());
        } else if (id == R.id.sep_route) {
            onExchangePressed();
        } else if (id == R.id.layout_select_day_today) {
            onQuickSelectDay(0);
        } else if (id == R.id.layout_select_day_tomorrow) {
            onQuickSelectDay(1);
        } else if (id == R.id.layout_select_day_after_tomorrow) {
            onQuickSelectDay(2);
        } else if (id == R.id.layout_ac_buses_filter_toggle_view) {
            toggleSortOptionsLayoutVisibility(false);
            toggleBusSearchLayoutVisibility(false);
            Switch switchR = this.mShowAcBusesSwitch;
            onCheckedChanged(switchR, !switchR.isChecked());
        } else if (id == R.id.layout_night_buses_toggle_view || id == R.id.txt_night_buses_toggle_view) {
            applyFilterForNightBuses();
        } else if (id == R.id.layout_covid_buses_toggle_view || id == R.id.txt_covid_buses_toggle_view) {
            applyFilterForCovidBuses();
        } else if (id == R.id.layout_deals_buses_toggle_view || id == R.id.txt_deals_buses_toggle_view) {
            applyFilterForDealsBuses();
        } else if (id == R.id.button_search_buses) {
            onSearchBusesClicked();
        } else if (id == R.id.frame_bus_search_background) {
            toggleBusSearchLayoutVisibility(false);
        } else if (id == R.id.frame_sort_options) {
            toggleSortOptionsLayoutVisibility(false);
        } else if (id == R.id.image_view_remove_notification) {
            this.notificationLayout.setVisibility(8);
        } else if (id == R.id.linear_clear_view || id == R.id.search_clear_filter || id == R.id.reset_your_filter) {
            onClearAllFilter();
            this.isOnNoBus = true;
            updateFragmentData(new CJRBusSearchInput(this.mBusSearchInput), this.mBusTicketFilters);
            this.mSrpFilterAdapter.a(this.mBusTicketFilters.getBusTicketFilterItems());
        }
    }

    private void applyFilterForDealsBuses() {
        boolean z = !this.mShowDealsBusesSwitch.isChecked();
        CJRBusTicketFilterItem busFilterItemByTitle = this.mBusTicketFilters.getBusFilterItemByTitle("Deals");
        if (busFilterItemByTitle != null) {
            this.mBusTicketFilters.getBusTicketFilterItems().remove(busFilterItemByTitle);
        }
        if (z) {
            CJRBusTicketFilterItem cJRBusTicketFilterItem = new CJRBusTicketFilterItem();
            cJRBusTicketFilterItem.setFilterCategory(e.BUS_DEALS);
            cJRBusTicketFilterItem.setTitle("Deals");
            cJRBusTicketFilterItem.setType("boolean");
            cJRBusTicketFilterItem.setToggleChecked(true);
            this.mBusTicketFilters.getBusTicketFilterItems().add(cJRBusTicketFilterItem);
        }
        this.mShowDealsBusesSwitch.setChecked(z);
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
        hashMap.put("event_label2", "Deals");
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        if (z) {
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "quick_filter_selected", hashMap);
        } else {
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "quick_filter_deselected", hashMap);
        }
        toggleDealsBuses();
        onFiltersChanged(true);
    }

    private void toggleDealsBuses() {
        if (this.mBusTicketFilters.getBusFilterItemByTitle("Deals") != null) {
            setDealsStatus(true);
        } else {
            setDealsStatus(false);
        }
    }

    private void setDealsStatus(boolean z) {
        this.mShowDealsBusesSwitch.setChecked(z);
        this.mTextDealsBusesFilter.setTextColor(getResources().getColor(z ? R.color.color_00b9f5 : R.color.color_222222));
    }

    private void applyFilterForCovidBuses() {
        boolean z = !this.mShowCovidBusesSwitch.isChecked();
        CJRBusTicketFilterItem busFilterItemByTitle = this.mBusTicketFilters.getBusFilterItemByTitle("Social Distancing");
        if (busFilterItemByTitle != null) {
            this.mBusTicketFilters.getBusTicketFilterItems().remove(busFilterItemByTitle);
        }
        if (z) {
            CJRBusTicketFilterItem cJRBusTicketFilterItem = new CJRBusTicketFilterItem();
            cJRBusTicketFilterItem.setFilterCategory(e.BUS_COVID);
            cJRBusTicketFilterItem.setTitle("Social Distancing");
            cJRBusTicketFilterItem.setType("boolean");
            cJRBusTicketFilterItem.setToggleChecked(true);
            this.mBusTicketFilters.getBusTicketFilterItems().add(cJRBusTicketFilterItem);
        }
        this.mShowCovidBusesSwitch.setChecked(z);
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
        hashMap.put("event_label2", "Social Distance");
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        if (z) {
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "quick_filter_selected", hashMap);
        } else {
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "quick_filter_deselected", hashMap);
        }
        toggleCovidBuses();
        onFiltersChanged(true);
    }

    private void toggleCovidBuses() {
        if (this.mBusTicketFilters.getBusFilterItemByTitle("Social Distancing") != null) {
            setCovidStatus(true);
        } else {
            setCovidStatus(false);
        }
    }

    private void setCovidStatus(boolean z) {
        this.mShowCovidBusesSwitch.setChecked(z);
        this.mTextCovidBusesFilter.setTextColor(getResources().getColor(z ? R.color.color_00b9f5 : R.color.color_222222));
    }

    private void applyFilterForNightBuses() {
        boolean z = !this.mShowNightBusesSwitch.isChecked();
        CJRBusTicketFilterItem busFilterItemByTitle = this.mBusTicketFilters.getBusFilterItemByTitle("Deprture Time");
        if (busFilterItemByTitle != null) {
            this.mBusTicketFilters.getBusTicketFilterItems().remove(busFilterItemByTitle);
        }
        if (z) {
            CJRBusTicketFilterItem cJRBusTicketFilterItem = new CJRBusTicketFilterItem();
            cJRBusTicketFilterItem.setFilterCategory(e.BUS_DEPARTURE_TIME);
            cJRBusTicketFilterItem.setTitle("Deprture Time");
            cJRBusTicketFilterItem.setType("time_range_slider");
            cJRBusTicketFilterItem.setTimeMinValue("1800");
            cJRBusTicketFilterItem.setTimeMaxValue("2400");
            this.mBusTicketFilters.getBusTicketFilterItems().add(cJRBusTicketFilterItem);
        }
        this.mShowNightBusesSwitch.setChecked(z);
        toggleNightBuses(z);
        onFiltersChanged(true);
    }

    private void openModificationScreen() {
        toggleBusSearchLayoutVisibility(!this.isBusSearchLayoutOpened);
        resetSearchPopupLayout();
        if (this.isBusSearchLayoutOpened) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "modify_clicked");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        }
    }

    private void onFiltersChanged(boolean z) {
        updateUIForFilters(z);
        reloadData();
    }

    private void updateUIForFilters(boolean z) {
        boolean z2 = this.mBusTicketFilters.getBusFilterItemByTitle("AC") != null;
        this.mShowAcBusesSwitch.setChecked(z2);
        this.showAcBusesLabelTextView.setTextColor(getResources().getColor(z2 ? R.color.color_00b9f5 : R.color.color_222222));
        toggleCovidBuses();
        toggleDealsBuses();
        if (z) {
            this.mSrpFilterAdapter.a(this.mBusTicketFilters.getBusTicketFilterItems());
        }
    }

    private void launchBusFilterActivity() {
        toggleBusSearchLayoutVisibility(false);
        toggleSortOptionsLayoutVisibility(false);
        if (com.travel.bus.busticket.i.d.a().f22429g) {
            com.travel.bus.busticket.i.d.a().f22426d = null;
            com.travel.bus.busticket.i.d.a().f22427e = null;
        }
        com.travel.bus.busticket.i.d dVar = this.mBusSearchDataUtils;
        dVar.f22423a = this.mBusFilterContainer;
        dVar.f22424b = this.mBusSearchItems;
        dVar.f22425c = this.mBusSearch.getBody().getDictionary();
        Intent intent = new Intent(this, BusFilterSortActivity.class);
        intent.putExtra("intent_extra_bus_search_max_fare", this.mAllowedMaxFare);
        intent.putExtra("intent_extra_bus_search_min_fare", this.mAllowedMinFare);
        intent.putExtra("intent_extra_bus_search_filter_items", this.mBusTicketFilters);
        intent.putExtra("intent_extra_flag_bp_dp_required", this.extraBpDpRequired);
        intent.putExtra("intent_extra_bus_search_filter_on_no_bus", this.isOnNoBus);
        intent.putExtra("intent_extra_bus_search_filter_amenity_items", this.mCurrentSelectedAmenityList);
        intent.putExtra("intent_extra_bus_search_filter_is_deals_available", this.isDealsAvailable);
        intent.putExtra("intent_extra_bus_search_filter_is_popular_choice", this.busPopularChoiceID);
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap = this.mAmenityInfo;
        if (hashMap != null) {
            intent.putExtra("amenity_info", hashMap);
        }
        HashMap<String, CJRBusSearchOperatorTagInfo> hashMap2 = this.mOperatorTagInfo;
        if (hashMap2 != null) {
            intent.putExtra("operatortag_info", hashMap2);
        }
        CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
        if (!(cJRBusSearchInput == null || cJRBusSearchInput.getSource() == null || this.mBusSearchInput.getDestination() == null || this.mBusSearchInput.getSource().getName() == null || this.mBusSearchInput.getDestination().getName() == null)) {
            intent.putExtra("intent_extra_bus_start_city", this.mBusSearchInput.getSource().getName());
            intent.putExtra("intent_extra_bus_dest_city", this.mBusSearchInput.getDestination().getName());
        }
        startActivityForResult(intent, 1);
    }

    private void resetSortUI() {
        this.topRatedFirstSortView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.cheapestFirstSortView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.durationShortestFirstView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.departureAscendingSortView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.departureDescendingSortView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.topRatedFirstSortView.setFontType(2);
        this.cheapestFirstSortView.setFontType(2);
        this.durationShortestFirstView.setFontType(2);
        this.departureAscendingSortView.setFontType(2);
        this.departureDescendingSortView.setFontType(2);
        this.topRatedFirstSortView.setTextColor(getResources().getColor(R.color.color_999999));
        this.cheapestFirstSortView.setTextColor(getResources().getColor(R.color.color_999999));
        this.durationShortestFirstView.setTextColor(getResources().getColor(R.color.color_999999));
        this.departureAscendingSortView.setTextColor(getResources().getColor(R.color.color_999999));
        this.departureDescendingSortView.setTextColor(getResources().getColor(R.color.color_999999));
        this.topRatedFirstSortView.setTag(Boolean.FALSE);
        this.cheapestFirstSortView.setTag(Boolean.FALSE);
        this.durationShortestFirstView.setTag(Boolean.FALSE);
        this.departureAscendingSortView.setTag(Boolean.FALSE);
        this.departureDescendingSortView.setTag(Boolean.FALSE);
    }

    private void sortDataByLayoutSelected(CJRBusTicketFilters cJRBusTicketFilters) {
        this.sortBy = "key_bus_search_sort_by_none";
        this.orderBy = 0;
        if (cJRBusTicketFilters != null && !TextUtils.isEmpty(cJRBusTicketFilters.getSortBy())) {
            this.sortBy = cJRBusTicketFilters.getSortBy();
            this.orderBy = cJRBusTicketFilters.getOrderBy();
            String str = this.sortBy;
            String str2 = this.orderBy == 0 ? "Ascending" : "Descending";
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "sort_clicked");
            hashMap.put("event_label", str + AppConstants.AND_SIGN + str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            this.mBusSearchInput.setSortBy(this.sortBy);
            this.mBusSearchInput.setOrderBy(this.orderBy);
            this.selectedSortBy = "";
            if ("topRated".equalsIgnoreCase(this.sortBy) && 1 == this.orderBy) {
                this.selectedSortBy = getResources().getString(R.string.top_rated);
            } else if ("fare".equalsIgnoreCase(this.sortBy) && this.orderBy == 0) {
                this.selectedSortBy = getResources().getString(R.string.cheapest);
            } else if ("departureTime".equalsIgnoreCase(this.sortBy) && 1 == this.orderBy) {
                this.selectedSortBy = getResources().getString(R.string.late_baording);
            } else if ("departureTime".equalsIgnoreCase(this.sortBy) && this.orderBy == 0) {
                this.selectedSortBy = getResources().getString(R.string.early_baording);
            }
            if (!TextUtils.isEmpty(this.selectedSortBy)) {
                this.mTvSortText.setText(this.selectedSortBy);
                findViewById(R.id.rel_sortby_view).setVisibility(0);
                this.mImageFilterSelected.setVisibility(0);
                return;
            }
            findViewById(R.id.rel_sortby_view).setVisibility(8);
            this.mImageFilterSelected.setVisibility(4);
        }
    }

    public void onBackPressed() {
        if (this.isSortViewOpened) {
            toggleSortOptionsLayoutVisibility(false);
        } else if (this.isBusSearchLayoutOpened) {
            toggleBusSearchLayoutVisibility(false);
        } else {
            isReviewVisible();
        }
    }

    public void setDateInActionBar(String str) {
        this.toolbarDateTextView.setText(com.paytm.utility.b.d(str, "yyyy-MM-dd", "EEE, d MMM"));
    }

    public void onDestroy() {
        io.reactivex.rxjava3.b.b bVar = this.compositeDisposable;
        if (bVar != null) {
            bVar.a();
            this.compositeDisposable.dispose();
        }
        super.onDestroy();
        if (this.mBusSearchDataUtils != null) {
            com.travel.bus.busticket.i.d.b();
            this.mBusSearchDataUtils = null;
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
        this.isOnNoBus = false;
    }

    public void showProgressBarLyt() {
        RelativeLayout relativeLayout = this.mLytProgressBar;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public void hideProgressBarLyt() {
        RelativeLayout relativeLayout = this.mLytProgressBar;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void setData(CJRBusSearchInput cJRBusSearchInput, CJRBusTicketFilters cJRBusTicketFilters) {
        if (hasBasicSearchCriteriaChanged(this.mBusSearchInput, cJRBusSearchInput)) {
            this.mBusSearch = null;
        }
        this.mBusSearchInput = new CJRBusSearchInput(cJRBusSearchInput);
        this.mBusTicketFilters = cJRBusTicketFilters;
        updateFragmentData(this.mBusSearchInput, this.mBusTicketFilters);
    }

    private boolean hasBasicSearchCriteriaChanged(CJRBusSearchInput cJRBusSearchInput, CJRBusSearchInput cJRBusSearchInput2) {
        if (cJRBusSearchInput == null || cJRBusSearchInput2 == null || !cJRBusSearchInput.getSource().getName().equalsIgnoreCase(cJRBusSearchInput2.getSource().getName()) || !cJRBusSearchInput.getDestination().getName().equalsIgnoreCase(cJRBusSearchInput2.getDestination().getName()) || !cJRBusSearchInput.getDate().equalsIgnoreCase(cJRBusSearchInput2.getDate()) || cJRBusSearchInput.getCount() != cJRBusSearchInput2.getCount()) {
            return true;
        }
        return false;
    }

    public void updateFragmentListViewData(CJRBusSearch cJRBusSearch) {
        this.mBusSearch = cJRBusSearch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[EDGE_INSN: B:20:0x0057->B:15:0x0057 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFilterRemoved(com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x001e
            java.lang.String r1 = r7.getTimeMinValue()
            java.lang.String r2 = "1800"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r7.getTimeMaxValue()
            java.lang.String r2 = "2400"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x001e
            r6.toggleNightBuses(r0)
        L_0x001e:
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r6.mBusTicketFilters
            java.util.ArrayList r1 = r1.getBusTicketFilterItems()
            r1.remove(r7)
            r1 = 1
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r2 = r6.mBusTicketFilters
            java.util.ArrayList r2 = r2.getBusTicketFilterItems()
            java.util.Iterator r2 = r2.iterator()
        L_0x0032:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = r2.next()
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r3 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r3
            java.lang.String r4 = r3.getTitle()
            java.lang.String r5 = "B.Pt"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x0056
            java.lang.String r3 = r3.getTitle()
            java.lang.String r4 = "D.Pt"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0032
        L_0x0056:
            r1 = 0
        L_0x0057:
            if (r1 == 0) goto L_0x005b
            r6.extraBpDpRequired = r0
        L_0x005b:
            r6.onFiltersChanged(r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event_category"
            java.lang.String r2 = "bus_search"
            r0.put(r1, r2)
            java.lang.String r1 = "event_action"
            java.lang.String r2 = "filter_removed"
            r0.put(r1, r2)
            com.travel.bus.pojo.busticket.e r1 = r7.getFilterCategory()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "event_label"
            r0.put(r2, r1)
            java.lang.String r7 = com.travel.bus.busticket.i.o.a((com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r7)
            java.lang.String r1 = "event_label2"
            r0.put(r1, r7)
            java.lang.String r7 = "vertical_name"
            java.lang.String r1 = "bus"
            r0.put(r7, r1)
            java.lang.String r7 = "screenName"
            java.lang.String r1 = "/bus-tickets-search"
            r0.put(r7, r1)
            java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r6)
            java.lang.String r1 = "user_id"
            r0.put(r1, r7)
            com.travel.bus.a.a()
            com.travel.g.a r7 = com.travel.bus.a.b()
            java.lang.String r1 = "custom_event"
            r7.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r0, (android.content.Context) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSearchSRPActivity.onFilterRemoved(com.travel.bus.pojo.busticket.CJRBusTicketFilterItem):void");
    }

    private void toggleSortOptionsLayoutVisibility(boolean z) {
        if (z != this.isSortViewOpened) {
            this.isSortViewOpened = z;
            if (z) {
                toggleBusSearchLayoutVisibility(false);
                ViewGroup viewGroup = this.mSortOptionsFrame;
                ViewGroup viewGroup2 = this.mSortOptionsLayout;
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setPropertyName("visibility");
                objectAnimator.setObjectValues(new Object[]{8, 0});
                objectAnimator.setDuration(0);
                objectAnimator.setEvaluator(new f.a());
                objectAnimator.setTarget(viewGroup);
                viewGroup2.measure(0, 0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup2, "translationY", new float[]{(float) viewGroup2.getMeasuredHeight(), 0.0f});
                ofFloat.setDuration(350);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator).before(ofFloat);
                animatorSet.start();
                return;
            }
            ViewGroup viewGroup3 = this.mSortOptionsFrame;
            ViewGroup viewGroup4 = this.mSortOptionsLayout;
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setPropertyName("visibility");
            objectAnimator2.setObjectValues(new Object[]{0, 8});
            objectAnimator2.setDuration(0);
            objectAnimator2.setEvaluator(new f.a());
            objectAnimator2.setTarget(viewGroup3);
            viewGroup4.measure(0, 0);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup4, "translationY", new float[]{0.0f, (float) viewGroup4.getMeasuredHeight()});
            ofFloat2.setDuration(350);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(ofFloat2).before(objectAnimator2);
            animatorSet2.start();
        }
    }

    private void toggleBusSearchLayoutVisibility(boolean z) {
        boolean z2 = z;
        if (this.isBusSearchLayoutOpened != z2) {
            this.toolbarExpandIndicatorImageview.setRotation(z2 ? 180.0f : 0.0f);
            this.isBusSearchLayoutOpened = z2;
            int i2 = 0;
            this.closeBusSearchView.setVisibility(z2 ? 0 : 8);
            if (z2) {
                toggleSortOptionsLayoutVisibility(false);
                View view = this.mBusSearchOptionsFrame;
                View view2 = this.mBusSearchOptionsLayout;
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setPropertyName("visibility");
                objectAnimator.setObjectValues(new Object[]{8, 0});
                objectAnimator.setDuration(0);
                objectAnimator.setEvaluator(new f.a());
                objectAnimator.setTarget(view);
                view2.measure(0, 0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", new float[]{(float) (-view2.getMeasuredHeight()), 0.0f});
                ofFloat.setDuration(350);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator).before(ofFloat);
                animatorSet.start();
            } else {
                View view3 = this.mBusSearchOptionsFrame;
                View view4 = this.mBusSearchOptionsLayout;
                ObjectAnimator objectAnimator2 = new ObjectAnimator();
                objectAnimator2.setPropertyName("visibility");
                objectAnimator2.setObjectValues(new Object[]{0, 8});
                objectAnimator2.setDuration(0);
                objectAnimator2.setEvaluator(new f.a());
                objectAnimator2.setTarget(view3);
                view4.measure(0, 0);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view4, "translationY", new float[]{0.0f, (float) (-view4.getMeasuredHeight())});
                ofFloat2.setDuration(350);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(ofFloat2).before(objectAnimator2);
                animatorSet2.start();
            }
            ImageView imageView = this.backButtonImageView;
            if (z2) {
                i2 = 4;
            }
            imageView.setVisibility(i2);
        }
    }

    private void sendCustomGAEvents(String str) {
        if (!TextUtils.isEmpty(str)) {
            o.a((Context) this, "/bus-tickets", "bus_home", str);
        }
    }

    private void launchOriginCityActivity(int i2, String str) {
        try {
            Intent intent = new Intent(this, AJRBusSelectCityActivity.class);
            intent.putExtra("activity_name", str);
            if (this.sourceCitySelectTextView.getText().length() != 0) {
                intent.putExtra("city_source_name", this.sourceCitySelectTextView.getText());
                intent.putExtra("intent_extra_selected_city_source_item", (CJRBusOriginCityItem) this.sourceCitySelectTextView.getTag());
            }
            if (this.destinationCitySelectTextView.getText().length() != 0) {
                intent.putExtra("city_destination_name", this.destinationCitySelectTextView.getText());
                intent.putExtra("intent_extra_selected_city_destination_item", (CJRBusOriginCityItem) this.destinationCitySelectTextView.getTag());
            }
            startActivityForResult(intent, i2);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void launchCalenderActivity(int i2, String str) {
        com.travel.bus.a.a();
        startActivityForResult(com.travel.bus.a.b().a((Activity) this, getResources().getString(R.string.bus_departure), str, this.modifyLayoutSelectedDateValue, z.a()), i2);
    }

    private void pulseEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        try {
            hashMap.put("event_label2", new SimpleDateFormat("dd-MMM-yy".replace("-", " ")).format(new SimpleDateFormat("yyyy-MM-dd").parse(this.mBusSearchInput.getDate())));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", str2, hashMap);
    }

    private void savePrefillFromData(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            com.travel.bus.b.a.a(getApplicationContext()).a("prefill-from-data", new com.google.gsonhtcfix.f().a((Object) cJRBusOriginCityItem), false);
        }
    }

    private void savePrefillToData(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            com.travel.bus.b.a.a(getApplicationContext()).a("prefill-to-data", new com.google.gsonhtcfix.f().a((Object) cJRBusOriginCityItem), false);
        }
    }

    private void onExchangePressed() {
        String charSequence = this.sourceCitySelectTextView.getText().toString();
        String charSequence2 = this.destinationCitySelectTextView.getText().toString();
        Object tag = this.sourceCitySelectTextView.getTag();
        Object tag2 = this.destinationCitySelectTextView.getTag();
        getResources().getString(R.string.bus_origin_txt);
        com.paytm.utility.b.j();
        getResources().getString(R.string.bus_destination_txt);
        com.paytm.utility.b.j();
        "origin: ".concat(String.valueOf(charSequence));
        com.paytm.utility.b.j();
        "destString: ".concat(String.valueOf(charSequence2));
        com.paytm.utility.b.j();
        if (!charSequence.equalsIgnoreCase(getResources().getString(R.string.bus_origin_txt)) && !charSequence2.equalsIgnoreCase(getResources().getString(R.string.bus_destination_txt))) {
            l.a(this, "source", charSequence, charSequence2);
            l.a(this, "destination", charSequence2, charSequence);
            this.sourceCitySelectTextView.startAnimation(this.mAnimMoveDown);
            this.destinationCitySelectTextView.startAnimation(this.mAnimMoveUp);
            this.sourceCitySelectTextView.setText(charSequence2);
            this.destinationCitySelectTextView.setText(charSequence);
            this.sourceCitySelectTextView.setTag(tag2);
            this.destinationCitySelectTextView.setTag(tag);
            this.sourceCitySelectTextView.startAnimation(this.mAnimMoveUp);
            this.destinationCitySelectTextView.startAnimation(this.mAnimMoveDown);
            this.mRotateAnimation.setFillAfter(true);
        }
    }

    private void onDepartureDateSelectResult(Intent intent) {
        if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
            long j = this.modifyLayoutSelectedDateValue;
            if (intent != null && intent.hasExtra("intent_extra_selected_date_time")) {
                this.modifyLayoutSelectedDateValue = intent.getLongExtra("intent_extra_selected_date_time", 0);
            }
            l.a(this, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, com.paytm.utility.b.a(Long.valueOf(j)), com.paytm.utility.b.a(Long.valueOf(this.modifyLayoutSelectedDateValue)));
            this.mCalendarSelectedDayValue = intent.getStringExtra("date_value");
            updateDayUI(getDateDiff(new Date(), new Date(this.modifyLayoutSelectedDateValue)));
            setDepartureDateToTextViewAndFireGtmEvent(this.modifyLayoutSelectedDateValue);
            pulseEvent("Calendar", "date_selected");
        }
    }

    private void savePreFillDateValue(CharSequence charSequence, String str) {
        if (charSequence != null) {
            com.travel.bus.b.a.a(getApplicationContext()).a("prefill-date-value", String.valueOf(charSequence), false);
            com.travel.bus.b.a.a(getApplicationContext()).a("prefill-date-value-tag", str, false);
        }
    }

    private void updateDayUI(int i2) {
        this.daySelectTodayView.setBackgroundResource(R.drawable.travel_res_bus_bg_white_grey_border);
        this.daySelectTomorrowView.setBackgroundResource(R.drawable.travel_res_bus_bg_white_grey_border);
        this.daySelectDayAfterTomorrowView.setBackgroundResource(R.drawable.travel_res_bus_bg_white_grey_border);
        this.dateTodayTextView.setTextColor(getResources().getColor(R.color.color_979797));
        this.dateTomorowTextView.setTextColor(getResources().getColor(R.color.color_979797));
        this.dateDayAfterTomorrowTextView.setTextColor(getResources().getColor(R.color.color_979797));
        this.dayOfWeekTodayTextView.setTextColor(getResources().getColor(R.color.color_979797));
        this.dayOfWeekTomorrowTextView.setTextColor(getResources().getColor(R.color.color_979797));
        this.dayOfWeekDayAfterTomorrowTextView.setTextColor(getResources().getColor(R.color.color_979797));
        if (i2 == 0) {
            this.daySelectTodayView.setBackgroundResource(R.drawable.travel_res_bus_bg_blue_border);
            this.dateTodayTextView.setTextColor(getResources().getColor(R.color.color_222222));
            this.dayOfWeekTodayTextView.setTextColor(getResources().getColor(R.color.color_222222));
        } else if (i2 == 1) {
            this.daySelectTomorrowView.setBackgroundResource(R.drawable.travel_res_bus_bg_blue_border);
            this.dateTomorowTextView.setTextColor(getResources().getColor(R.color.color_222222));
            this.dayOfWeekTomorrowTextView.setTextColor(getResources().getColor(R.color.color_222222));
        } else if (i2 == 2) {
            this.daySelectDayAfterTomorrowView.setBackgroundResource(R.drawable.travel_res_bus_bg_blue_border);
            this.dateDayAfterTomorrowTextView.setTextColor(getResources().getColor(R.color.color_222222));
            this.dayOfWeekDayAfterTomorrowTextView.setTextColor(getResources().getColor(R.color.color_222222));
        }
    }

    private void onQuickSelectDay(int i2) {
        updateDayUI(i2);
        Calendar instance = Calendar.getInstance();
        instance.add(5, i2);
        Date time = instance.getTime();
        long j = this.modifyLayoutSelectedDateValue;
        this.modifyLayoutSelectedDateValue = time.getTime();
        l.a(this, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, com.paytm.utility.b.a(Long.valueOf(j)), com.paytm.utility.b.a(Long.valueOf(this.modifyLayoutSelectedDateValue)));
        if (i2 == 0) {
            pulseEvent("Today", "date_selected");
            pulseEvent("Today", "today_tomorrow_clicked");
        } else if (i2 == 1) {
            pulseEvent("Tomorrow", "date_selected");
            pulseEvent("Tomorrow", "today_tomorrow_clicked");
        }
        setDepartureDateToTextViewAndFireGtmEvent(this.modifyLayoutSelectedDateValue);
    }

    private static int getDateDiff(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Date time = instance.getTime();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        return (int) ((instance2.getTime().getTime() / 86400000) - (time.getTime() / 86400000));
    }

    private void setDepartureDateToTextViewAndFireGtmEvent(long j) {
        String str;
        String str2;
        try {
            str = new SimpleDateFormat("dd MMM yy").format(new Date(j));
        } catch (Exception e2) {
            q.c(e2.getMessage());
            str = null;
        }
        if (com.paytm.utility.n.a().equalsIgnoreCase("hi") || com.paytm.utility.n.a().equalsIgnoreCase("ta") || com.paytm.utility.n.a().equalsIgnoreCase("te") || com.paytm.utility.n.a().equalsIgnoreCase("kn") || com.paytm.utility.n.a().equalsIgnoreCase("pa") || com.paytm.utility.n.a().equalsIgnoreCase("mr") || com.paytm.utility.n.a().equalsIgnoreCase("gu") || com.paytm.utility.n.a().equalsIgnoreCase("bn") || com.paytm.utility.n.a().equalsIgnoreCase("or") || com.paytm.utility.n.a().equalsIgnoreCase("ml")) {
            str2 = com.paytm.utility.b.a("EEEE, d MMMM", j);
        } else {
            com.travel.bus.a.a();
            str2 = com.paytm.utility.b.a((Activity) this, str, "dd MMM yy", "EEEE, d MMMM", com.travel.bus.a.b().b());
        }
        String a2 = com.paytm.utility.b.a(Long.valueOf(this.modifyLayoutSelectedDateValue));
        setDateToSearchLayout(str2, a2);
        String str3 = this.mCalendarSelectedDayValue;
        if (a2 != null && str3 != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Search Screen");
                hashMap.put("bus_travel_date", str3);
                hashMap.put("bus_date_source", "Calender");
                com.travel.bus.a.a();
                com.travel.bus.a.b().a("bus_home_date_selected", (Map<String, Object>) hashMap, (Context) this);
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.c(e3.getMessage());
                }
            }
        }
    }

    private void setDateToSearchLayout(String str, String str2) {
        String[] split = str.split(",|\\s");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.size() > 0) {
            this.departureWeekTextView.setText((CharSequence) arrayList.get(0));
            if (arrayList.size() > 1) {
                this.departureDateTextView.setText((CharSequence) arrayList.get(1));
            }
            if (arrayList.size() > 2) {
                this.departureMonthTextView.setText((CharSequence) arrayList.get(2));
            }
        }
        this.departureDateTextView.setTag(str2);
    }

    private void onSearchBusesClicked() {
        this.filteredBusList.clear();
        try {
            onClearAllFilter();
            this.selectedSortBy = "";
            findViewById(R.id.rel_sortby_view).setVisibility(8);
            this.mBusTicketFilters = new CJRBusTicketFilters();
            this.mBusTicketFilters.setBusTicketFilterItems(new ArrayList());
            this.sortBy = "key_bus_search_sort_by_none";
            this.orderBy = 0;
            this.mBusSearchInput.setSortBy(this.sortBy);
            this.mBusSearchInput.setOrderBy(this.orderBy);
            resetSortUI();
            this.mSortSubTextView.setText("");
            this.mSortSubTextView.setVisibility(8);
            y yVar = this.mSrpFilterAdapter;
            yVar.f21804a.clear();
            yVar.notifyDataSetChanged();
            yVar.a();
            this.mShowAcBusesSwitch.setChecked(false);
            this.showAcBusesLabelTextView.setTextColor(getResources().getColor(R.color.color_222222));
            this.mHomePageSelectedDateValue = this.modifyLayoutSelectedDateValue;
            CJRBusOriginCityItem cJRBusOriginCityItem = (CJRBusOriginCityItem) this.sourceCitySelectTextView.getTag();
            CJRBusOriginCityItem cJRBusOriginCityItem2 = (CJRBusOriginCityItem) this.destinationCitySelectTextView.getTag();
            String format = this.inputDateFormat.format(new Date(this.mHomePageSelectedDateValue));
            o.a((Context) this, cJRBusOriginCityItem, true, o.a());
            o.a((Context) this, cJRBusOriginCityItem2, false, o.a());
            CJRBusOriginCityItem source = this.mBusSearchInput.getSource();
            CJRBusOriginCityItem destination = this.mBusSearchInput.getDestination();
            String date = this.mBusSearchInput.getDate();
            if (cJRBusOriginCityItem.getCityId() == cJRBusOriginCityItem2.getCityId()) {
                com.paytm.utility.b.b((Context) this, getString(R.string.bus_travel_same_from_to_title), getString(R.string.bus_travel_same_from_to_desc));
                return;
            }
            if (!(cJRBusOriginCityItem.getCityId() == source.getCityId() && cJRBusOriginCityItem2.getCityId() == destination.getCityId() && date.equalsIgnoreCase(format))) {
                this.shouldCreateFilterData = true;
            }
            this.mBusSearchInput.setDate(format);
            this.mBusSearchInput.setSource(cJRBusOriginCityItem);
            this.mBusSearchInput.setDestination(cJRBusOriginCityItem2);
            CJRBusSearchInput cJRBusSearchInput = new CJRBusSearchInput();
            cJRBusSearchInput.setSource(cJRBusOriginCityItem);
            cJRBusSearchInput.setDestination(cJRBusOriginCityItem2);
            cJRBusSearchInput.setDate(format);
            com.travel.bus.busticket.i.y yVar2 = com.travel.bus.busticket.i.y.f22482a;
            com.travel.bus.busticket.i.y.a((Object) cJRBusSearchInput);
            String displayCityName = this.mBusSearchInput.getSource().getDisplayCityName();
            String displayCityName2 = this.mBusSearchInput.getDestination().getDisplayCityName();
            if (TextUtils.isEmpty(displayCityName)) {
                displayCityName = this.mBusSearchInput.getSource().getName();
            }
            if (TextUtils.isEmpty(displayCityName2)) {
                displayCityName2 = this.mBusSearchInput.getDestination().getName();
            }
            this.sourceTextView.setText(displayCityName);
            this.destTextView.setText(displayCityName2);
            setDateInActionBar(this.mBusSearchInput.getDate());
            this.mLinearClearView.setVisibility(0);
            this.mNoSearchResultFound.setVisibility(8);
            this.mToolbar.setVisibility(8);
            toggleBusSearchLayoutVisibility(false);
            toggleSortOptionsLayoutVisibility(false);
            this.mBottomActionBar.setVisibility(8);
            this.busProgressBarAnimation.a();
            initSearchResultListFrament();
            saveIntoRecentItem(cJRBusOriginCityItem, cJRBusOriginCityItem2);
            String format2 = String.format("%s/%s/%s", new Object[]{this.sourceCitySelectTextView.getText().toString(), this.destinationCitySelectTextView.getText().toString(), com.paytm.utility.b.a(Long.valueOf(this.mHomePageSelectedDateValue))});
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "modify_search_bus_clicked");
            hashMap.put("event_label", format2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_label", this.mBusSearchInput.getSource().getName() + "/" + this.mBusSearchInput.getDestination().getName());
            try {
                hashMap2.put("event_label2", new SimpleDateFormat("dd-MMM-yy".replace("-", " ")).format(new SimpleDateFormat("yyyy-MM-dd").parse(this.mBusSearchInput.getDate())));
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            hashMap2.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "search_bus_clicked", hashMap2);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    private void saveIntoRecentItem(CJRBusOriginCityItem cJRBusOriginCityItem, CJRBusOriginCityItem cJRBusOriginCityItem2) {
        try {
            String a2 = com.paytm.utility.b.a(Long.valueOf(this.modifyLayoutSelectedDateValue));
            String localLanguageFormateString = getLocalLanguageFormateString();
            savePrefillFromData(cJRBusOriginCityItem);
            savePrefillToData(cJRBusOriginCityItem2);
            savePreFillDateValue(localLanguageFormateString, a2);
            o.a(this, cJRBusOriginCityItem, cJRBusOriginCityItem2, a2, o.a());
        } catch (Exception unused) {
        }
    }

    private String getLocalLanguageFormateString() {
        try {
            String format = new SimpleDateFormat("dd MMM yy").format(new Date(this.mHomePageSelectedDateValue));
            if (!com.paytm.utility.n.a().equalsIgnoreCase("hi")) {
                if (!com.paytm.utility.n.a().equalsIgnoreCase("ta") && !com.paytm.utility.n.a().equalsIgnoreCase("te") && !com.paytm.utility.n.a().equalsIgnoreCase("kn") && !com.paytm.utility.n.a().equalsIgnoreCase("pa") && !com.paytm.utility.n.a().equalsIgnoreCase("mr") && !com.paytm.utility.n.a().equalsIgnoreCase("gu") && !com.paytm.utility.n.a().equalsIgnoreCase("bn") && !com.paytm.utility.n.a().equalsIgnoreCase("or")) {
                    if (!com.paytm.utility.n.a().equalsIgnoreCase("ml")) {
                        com.travel.bus.a.a();
                        return com.paytm.utility.b.a((Activity) this, format, "dd MMM yy", "EEE, dd MMM", com.travel.bus.a.b().b());
                    }
                }
            }
            return com.paytm.utility.b.a("EEE, dd MMM", this.mHomePageSelectedDateValue);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    public void onExpandAmenityClick(ArrayList<Integer> arrayList, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        com.travel.bus.busticket.fragment.a aVar = new com.travel.bus.busticket.fragment.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyList", arrayList);
        bundle.putSerializable("amenity_info", hashMap);
        aVar.setArguments(bundle);
        aVar.show(getSupportFragmentManager(), "busAmenitiesListBottomDialogFragment");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event_label2", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
        hashMap2.put("userid", "");
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "amenity_expansion_clicked", hashMap2);
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void initialiseReviewLayout() {
        this.mReviewContainer = findViewById(R.id.review_fragment_container);
        this.mReviewList = (RecyclerView) findViewById(R.id.bus_review_list);
        this.mReviewList.setLayoutManager(new LinearLayoutManager(this));
        this.mTravelsName = (TextView) findViewById(R.id.travels_name);
        this.mReviewContainer.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusSearchSRPActivity.this.lambda$initialiseReviewLayout$4$AJRBusSearchSRPActivity(view);
            }
        });
        this.mReviewLayout = findViewById(R.id.review_container);
        this.mReviewLayout.setOnClickListener($$Lambda$AJRBusSearchSRPActivity$bcaGXK0SHSrNbfpt1vPdq8IGdA.INSTANCE);
        ((RelativeLayout.LayoutParams) this.mReviewLayout.getLayoutParams()).height = com.paytm.utility.b.b((Activity) this) / 2;
    }

    public /* synthetic */ void lambda$initialiseReviewLayout$4$AJRBusSearchSRPActivity(View view) {
        this.mReviewContainer.setVisibility(8);
    }

    public void onUpdateApiResult(CJRBusSearch cJRBusSearch) {
        this.alternateRouteList = new ArrayList();
        this.alternateRecyclerView.setVisibility(8);
        boolean z = false;
        toggleActivityProgressBar(false);
        RelativeLayout relativeLayout = this.stickyHeaderLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (cJRBusSearch != null && cJRBusSearch.getBody() != null && cJRBusSearch.getBody().getTrips().size() > 0) {
            updateFragmentListViewData(cJRBusSearch);
            int size = cJRBusSearch.getBody().getTrips().size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    CJRBusSearchItem cJRBusSearchItem = cJRBusSearch.getBody().getTrips().get(i2);
                    if (cJRBusSearchItem != null && cJRBusSearchItem.getDetailedFare() != null && cJRBusSearchItem.getDetailedFare().size() > 0 && cJRBusSearchItem.getDetailedFare().get(0) != null && cJRBusSearchItem.getDetailedFare().get(0).getDeal() != null) {
                        this.isDealsAvailable = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        } else if (!(cJRBusSearch == null || cJRBusSearch.getMeta() == null || cJRBusSearch.getMeta().getTravelRoutes() == null)) {
            updateResponseFromNetwork(cJRBusSearch);
            displayAlternateRouts(cJRBusSearch.getMeta().getTravelRoutes());
            z = true;
        }
        if (!z) {
            updateResponseFromNetwork(cJRBusSearch);
        }
    }

    public void onUpdateApiError(int i2, NetworkCustomError networkCustomError, IJRPaytmDataModel iJRPaytmDataModel) {
        this.alternateRouteList = new ArrayList();
        this.alternateRecyclerView.setVisibility(8);
        this.mLinResetYourFilter.setVisibility(8);
        l.a((Context) this, i2, networkCustomError);
        CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
        this.busProgressBarAnimation.b();
        if (networkCustomError.networkResponse != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    cJRNewErrorFormat = (CJRNewErrorFormat) new com.google.gsonhtcfix.f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                } catch (Exception e2) {
                    CJRNewErrorFormat cJRNewErrorFormat2 = new CJRNewErrorFormat();
                    e2.getMessage();
                    cJRNewErrorFormat = cJRNewErrorFormat2;
                }
            }
        }
        String str = null;
        if (i2 == 410 || i2 == 422) {
            if (cJRNewErrorFormat.getStatus() == null || cJRNewErrorFormat.getStatus().getMessage() == null || cJRNewErrorFormat.getStatus().getMessage().f22820c == null) {
                onNoResultFound(true, getResources().getString(R.string.bus_no_result_found, new Object[]{this.toolbarDateTextView.getText().toString()}), false, true);
            } else {
                onNoResultFound(true, cJRNewErrorFormat.getStatus().getMessage().f22820c, false, true);
            }
            CJRBusTicketFilters cJRBusTicketFilters = this.mBusTicketFilters;
            CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
            if (cJRBusTicketFilters.getBusTicketFilterItems().size() == 0) {
                if (cJRBusSearchInput != null) {
                    str = cJRBusSearchInput.getSource().getName() + AppConstants.AND_SIGN + cJRBusSearchInput.getDestination().getName() + AppConstants.AND_SIGN + cJRBusSearchInput.getDate();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "bus_search");
                hashMap.put("event_action", "trips_count");
                hashMap.put("event_label", "0");
                hashMap.put("event_label2", str);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                hashMap.put("vertical_name", "bus");
                hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            }
        } else if (i2 == 503) {
            showMaintenanceErrorAlert(getResources().getString(R.string.bus_maintenance_error_title), getResources().getString(R.string.bus_maintenance_error_description));
        } else if (iJRPaytmDataModel instanceof CJRBusSearch) {
            if (cJRNewErrorFormat.getStatus() == null || cJRNewErrorFormat.getStatus().getMessage() == null || cJRNewErrorFormat.getStatus().getMessage().f22820c == null) {
                showMaintenanceErrorAlert((String) null, networkCustomError.getAlertMessage());
            } else {
                onNoResultFound(true, cJRNewErrorFormat.getStatus().getMessage().f22820c, false, true);
            }
        }
        toggleActivityProgressBar(false);
        if (cJRNewErrorFormat != null && cJRNewErrorFormat.getMeta() != null && cJRNewErrorFormat.getMeta().getTravelRoutes() != null) {
            displayAlternateRouts(cJRNewErrorFormat.getMeta().getTravelRoutes());
        }
    }

    private void displayAlternateRouts(CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch) {
        if (cJRTravelRoutesZeroSearch != null) {
            try {
                this.alternateRouteList = new ArrayList();
                if (!(cJRTravelRoutesZeroSearch.getNearby() == null || cJRTravelRoutesZeroSearch.getNearby().getSuggestions() == null || cJRTravelRoutesZeroSearch.getNearby().getSuggestions().size() <= 0)) {
                    List<List<CJRSuggestionZeroSearch>> suggestions = cJRTravelRoutesZeroSearch.getNearby().getSuggestions();
                    int size = suggestions.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList arrayList = new ArrayList();
                        if (suggestions.get(i2) != null && suggestions.get(i2).size() == 2) {
                            int size2 = suggestions.get(i2).size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                CJRSuggestionZeroSearch cJRSuggestionZeroSearch = (CJRSuggestionZeroSearch) suggestions.get(i2).get(i3);
                                cJRSuggestionZeroSearch.setLayoutType(com.travel.bus.busticket.h.b.NEAR_BY_ZERO_SEARCH);
                                arrayList.add(cJRSuggestionZeroSearch);
                            }
                            this.alternateRouteList.add(arrayList);
                        }
                    }
                }
                if (!(cJRTravelRoutesZeroSearch.getNhop() == null || cJRTravelRoutesZeroSearch.getNhop().getSuggestions() == null || cJRTravelRoutesZeroSearch.getNhop().getSuggestions().size() <= 0)) {
                    List<List<CJRSuggestionZeroSearch>> suggestions2 = cJRTravelRoutesZeroSearch.getNhop().getSuggestions();
                    int size3 = suggestions2.size();
                    if (size3 > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        CJRSuggestionZeroSearch cJRSuggestionZeroSearch2 = new CJRSuggestionZeroSearch();
                        cJRSuggestionZeroSearch2.setLayoutType(com.travel.bus.busticket.h.b.N_HOP_ZERO_SEARCH_TITLE);
                        cJRSuggestionZeroSearch2.setStart(this.mBusSearchInput.getDestination().getName());
                        arrayList2.add(cJRSuggestionZeroSearch2);
                        this.alternateRouteList.add(arrayList2);
                    }
                    for (int i4 = 0; i4 < size3; i4++) {
                        ArrayList arrayList3 = new ArrayList();
                        if (suggestions2.get(i4) != null && suggestions2.get(i4).size() > 0) {
                            int size4 = suggestions2.get(i4).size();
                            for (int i5 = 0; i5 < size4; i5++) {
                                CJRSuggestionZeroSearch cJRSuggestionZeroSearch3 = (CJRSuggestionZeroSearch) suggestions2.get(i4).get(i5);
                                cJRSuggestionZeroSearch3.setLayoutType(com.travel.bus.busticket.h.b.N_HOP_ZERO_SEARCH);
                                arrayList3.add(cJRSuggestionZeroSearch3);
                            }
                        }
                        this.alternateRouteList.add(arrayList3);
                    }
                }
                if (this.alternateRouteList != null && this.alternateRouteList.size() > 0) {
                    this.mTryAnotherSearchMessage.setText(R.string.alternate_error_message);
                    ((TextView) findViewById(R.id.bus_error_title)).setText(getString(R.string.bus_alternate_route_no_buses, new Object[]{this.sourceTextView.getText().toString()}));
                    ResourceUtils.loadBusImagesFromCDN((ImageView) findViewById(R.id.bus_error_image_view), "no_routes_new_image_revamp.png", false, false, n.a.V1);
                    this.routesZeroSearch = cJRTravelRoutesZeroSearch;
                    this.mTryAnotherSearch.setVisibility(8);
                    findViewById(R.id.search_clear_filter).setVisibility(8);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    linearLayoutManager.setOrientation(1);
                    this.alternateRecyclerView.setLayoutManager(linearLayoutManager);
                    this.alternateRecyclerView.setVisibility(0);
                    this.alternateRoutesAdapter = new com.travel.bus.busticket.a.a(this, cJRTravelRoutesZeroSearch, this.alternateRouteList);
                    this.alternateRecyclerView.setAdapter(this.alternateRoutesAdapter);
                }
            } catch (Exception unused) {
            }
        } else {
            this.alternateRecyclerView.setVisibility(8);
        }
    }

    public void clearAdapter() {
        io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable() {
            public final Object call() {
                return AJRBusSearchSRPActivity.this.lambda$clearAdapter$6$AJRBusSearchSRPActivity();
            }
        }).b(io.reactivex.rxjava3.android.b.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).c();
    }

    public /* synthetic */ Object lambda$clearAdapter$6$AJRBusSearchSRPActivity() throws Exception {
        this.mListView.setVisibility(8);
        try {
            if (this.mBusSearchListAdapter != null) {
                w wVar = this.mBusSearchListAdapter;
                if (wVar.f21782d != null) {
                    wVar.f21782d.clear();
                    wVar.notifyDataSetChanged();
                }
                if (wVar.f21784f != null) {
                    wVar.f21784f.clear();
                    wVar.notifyDataSetChanged();
                }
                if (wVar.f21783e != null) {
                    wVar.f21783e.clear();
                    wVar.notifyDataSetChanged();
                }
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        return io.reactivex.rxjava3.a.b.a();
    }

    public void showApiResponseErrorAlert() {
        com.paytm.utility.b.b((Context) this, getString(R.string.no_resonse_from_api_title), getString(R.string.no_resonse_from_api_msg));
    }

    public void showTimeOutError(boolean z) {
        if (!isFinishing()) {
            String string = getString(R.string.no_resonse_from_api_title);
            String string2 = getString(R.string.no_resonse_from_api_msg);
            String string3 = getString(R.string.network_retry_yes);
            String string4 = getString(R.string.cancel);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(string3, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRBusSearchSRPActivity.this.lambda$showTimeOutError$7$AJRBusSearchSRPActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(string4, $$Lambda$AJRBusSearchSRPActivity$yYECLvz92j1VkzhGkTmir8Hvxo.INSTANCE);
            builder.show();
            new Handler().postDelayed(new Runnable(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AJRBusSearchSRPActivity.this.lambda$showTimeOutError$9$AJRBusSearchSRPActivity(this.f$1);
                }
            }, 30000);
        }
    }

    public /* synthetic */ void lambda$showTimeOutError$7$AJRBusSearchSRPActivity(DialogInterface dialogInterface, int i2) {
        com.travel.bus.busticket.g.d dVar = this.mBusSearchPresenter;
        dVar.f22367e = true;
        com.paytm.utility.b.c((Context) this);
        dVar.a(dVar.f22365c, dVar.f22364b);
        dialogInterface.cancel();
    }

    public /* synthetic */ void lambda$showTimeOutError$9$AJRBusSearchSRPActivity(boolean z) {
        com.travel.bus.busticket.g.d dVar = this.mBusSearchPresenter;
        if (!z) {
            dVar.f22366d.showApiResponseErrorAlert();
        }
    }

    public void showSearchApiNoNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRBusSearchSRPActivity.this.lambda$showSearchApiNoNetworkDialog$11$AJRBusSearchSRPActivity(dialogInterface, i2);
            }
        });
        io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable(builder) {
            private final /* synthetic */ AlertDialog.Builder f$0;

            {
                this.f$0 = r1;
            }

            public final Object call() {
                return AJRBusSearchSRPActivity.lambda$showSearchApiNoNetworkDialog$12(this.f$0);
            }
        }).b(io.reactivex.rxjava3.android.b.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).c();
    }

    public /* synthetic */ void lambda$showSearchApiNoNetworkDialog$11$AJRBusSearchSRPActivity(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable() {
            public final Object call() {
                return AJRBusSearchSRPActivity.this.lambda$null$10$AJRBusSearchSRPActivity();
            }
        }).b(io.reactivex.rxjava3.i.a.e()).c();
    }

    public /* synthetic */ Object lambda$null$10$AJRBusSearchSRPActivity() throws Exception {
        AJRBusSearchSRPActivity.class.getSimpleName();
        new StringBuilder("thread -> ").append(Thread.currentThread().getName());
        this.mBusSearchPresenter.a(this.mBusTicketFilters, this.mBusSearchInput);
        return io.reactivex.rxjava3.a.b.a();
    }

    static /* synthetic */ Object lambda$showSearchApiNoNetworkDialog$12(AlertDialog.Builder builder) throws Exception {
        AJRBusSearchSRPActivity.class.getSimpleName();
        new StringBuilder("thread -> ").append(Thread.currentThread().getName());
        builder.show();
        return io.reactivex.rxjava3.a.b.a();
    }

    public void isReviewVisible() {
        View view = this.mReviewContainer;
        if (view == null || view.getVisibility() != 0) {
            finish();
        } else {
            this.mReviewContainer.setVisibility(8);
        }
    }

    public void updateResponseFromNetwork(CJRBusSearch cJRBusSearch) {
        if (cJRBusSearch.getBody() == null || cJRBusSearch.getBody().getTrips().size() <= 0) {
            String string = getResources().getString(R.string.bus_no_result_found, new Object[]{this.toolbarDateTextView.getText().toString()});
            if (!(cJRBusSearch == null || cJRBusSearch.getMeta() == null || TextUtils.isEmpty(cJRBusSearch.getMeta().getMessage()))) {
                string = cJRBusSearch.getMeta().getMessage();
            }
            displayDialogOnNoBusFound(string, false);
            toggleActivityProgressBar(false);
            return;
        }
        this.zeroResultFound = false;
        onNoResultFound(false, (String) null, false, false);
        this.mCompleteBusList = cJRBusSearch.getBody().getTrips();
        setListViewData(cJRBusSearch);
        updateListViewData(this.mBusTicketFilters);
        if (this.mBusSearchPresenter.a(this.mCompleteBusList, this.mBusTicketFilters).isEmpty() && this.extraBpDpRequired) {
            this.mBusTicketFilters.getBusTicketFilterItems().clear();
            onFiltersChanged(true);
        }
        if (isSocialEnabledAppManager()) {
            this.mCovidBusesFilterToggleView.setVisibility(0);
        } else {
            this.mDealsBusesFilterToggleView.setVisibility(0);
            this.mDealsViewLine.setVisibility(0);
        }
        onDataLoaded(cJRBusSearch);
    }

    public void setListViewData(CJRBusSearch cJRBusSearch) {
        boolean z;
        CJRBusSearch cJRBusSearch2 = cJRBusSearch;
        if (cJRBusSearch2 != null && cJRBusSearch.getBody() != null && cJRBusSearch.getBody().getTrips().size() > 0) {
            com.travel.bus.busticket.i.y yVar = com.travel.bus.busticket.i.y.f22482a;
            com.travel.bus.busticket.i.y.a((Object) cJRBusSearch);
            this.mListView.setVisibility(0);
            if (this.mBusSearch == null) {
                this.mBusSearch = cJRBusSearch2;
            }
            w wVar = this.mBusSearchListAdapter;
            if (wVar == null) {
                ArrayList<CJRBusSearchItem> a2 = com.travel.bus.busticket.g.d.a(cJRBusSearch.getBody().getTrips());
                this.operatorGroupListMap = cJRBusSearch.getOperator_groups();
                this.operatorGroupLogoListMap = null;
                ArrayList<CJRBusSearchItem> a3 = this.mBusSearchPresenter.a(a2, this.operatorGroupListMap);
                this.mListView.setLayoutManager(new LinearLayoutManager(this));
                w wVar2 = r0;
                ArrayList<CJRBusSearchItem> arrayList = a2;
                w wVar3 = new w(this, a3, this.operatorGroupListMap, this.operatorGroupLogoListMap, a2, this, this, cJRBusSearch.getBody().getDictionary().getAmenitiesInfo(), cJRBusSearch.getBody().getDictionary().getOperatorTags(), cJRBusSearch.getBody().getDictionary().getEcosystemOffers(), this);
                this.mBusSearchListAdapter = wVar2;
                if (this.mBusTicketFilters.getBusTicketFilterItems().size() == 0) {
                    l.a(cJRBusSearch2, this.operatorGroupListMap, (Context) this);
                }
                Iterator<CJRBusSearchItem> it2 = a3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    CJRBusSearchItem next = it2.next();
                    if (next.getmItemType() != null && next.getmItemType().equals("bus_item_type_list")) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    new Handler().post(new Runnable() {
                        public final void run() {
                            if (AJRBusSearchSRPActivity.this.headerViewHolder != null && AJRBusSearchSRPActivity.this.mBusSearchListAdapter != null) {
                                AJRBusSearchSRPActivity.this.mBusSearchListAdapter.f21786h = false;
                                AJRBusSearchSRPActivity aJRBusSearchSRPActivity = AJRBusSearchSRPActivity.this;
                                aJRBusSearchSRPActivity.onGroupViewClicked(aJRBusSearchSRPActivity.headerViewHolder.j, 0);
                                AJRBusSearchSRPActivity.this.headerViewHolder.a();
                            }
                        }
                    });
                }
                this.mListView.setAdapter(this.mBusSearchListAdapter);
                pulseEventAmenitiesCount(arrayList);
            } else {
                wVar.f21785g = cJRBusSearch.getBody().getDictionary().getOperatorTags();
                this.operatorGroupListMap = cJRBusSearch.getOperator_groups();
                ArrayList<CJRBusSearchItem> arrayList2 = this.filteredBusList;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.mCompleteBusList = com.travel.bus.busticket.g.d.a(cJRBusSearch.getBody().getTrips());
                } else {
                    this.mCompleteBusList = com.travel.bus.busticket.g.d.a(this.filteredBusList);
                }
                if (this.mBusTicketFilters.getBusTicketFilterItems().size() == 0) {
                    l.a(cJRBusSearch2, this.operatorGroupListMap, (Context) this);
                }
                this.mBusSearchListAdapter.b(this.mCompleteBusList);
                pulseEventAmenitiesCount(this.mCompleteBusList);
            }
            CJRBusTicketFilters cJRBusTicketFilters = new CJRBusTicketFilters();
            ArrayList arrayList3 = new ArrayList();
            if (!TextUtils.isEmpty(this.isDealsFilter) && this.isDealsFilter.equalsIgnoreCase("true")) {
                CJRBusTicketFilterItem cJRBusTicketFilterItem = new CJRBusTicketFilterItem();
                cJRBusTicketFilterItem.setFilterCategory(e.BUS_DEALS);
                cJRBusTicketFilterItem.setTitle("Deals");
                cJRBusTicketFilterItem.setType("boolean");
                cJRBusTicketFilterItem.setToggleChecked(true);
                arrayList3.add(cJRBusTicketFilterItem);
            }
            if (!TextUtils.isEmpty(this.busPopularChoiceID)) {
                CJRBusTicketFilterItem cJRBusTicketFilterItem2 = new CJRBusTicketFilterItem();
                cJRBusTicketFilterItem2.setFilterCategory(e.BUS_POPULAR_CHOICE);
                cJRBusTicketFilterItem2.setTitle("Popular Choice");
                cJRBusTicketFilterItem2.setType("boolean");
                cJRBusTicketFilterItem2.setFilterValue(this.busPopularChoiceID);
                cJRBusTicketFilterItem2.setToggleChecked(true);
                arrayList3.add(cJRBusTicketFilterItem2);
            }
            if (!this.zeroResultFound && this.extraBpDpRequired && this.mBusTicketFilters.getBusTicketFilterItems().isEmpty()) {
                if (this.mBusSearchInput.getSource().getAliasType() != null && this.mBusSearchInput.getSource().getAliasType().equalsIgnoreCase(getString(R.string.city_bp))) {
                    CJRBusTicketFilterItem cJRBusTicketFilterItem3 = new CJRBusTicketFilterItem();
                    cJRBusTicketFilterItem3.setTitle("B.Pt");
                    cJRBusTicketFilterItem3.setType("list");
                    cJRBusTicketFilterItem3.setDisplayValue(this.mBusSearchInput.getSource().getName());
                    cJRBusTicketFilterItem3.setFilterValue(this.mBusSearchInput.getSource().getName());
                    cJRBusTicketFilterItem3.setBPDP(true);
                    cJRBusTicketFilterItem3.setFilterCategory(e.BOARDING_POINT);
                    arrayList3.add(cJRBusTicketFilterItem3);
                }
                if (this.mBusSearchInput.getDestination().getAliasType() != null && this.mBusSearchInput.getDestination().getAliasType().equalsIgnoreCase(getString(R.string.city_bp))) {
                    CJRBusTicketFilterItem cJRBusTicketFilterItem4 = new CJRBusTicketFilterItem();
                    cJRBusTicketFilterItem4.setTitle("D.Pt");
                    cJRBusTicketFilterItem4.setType("list");
                    cJRBusTicketFilterItem4.setDisplayValue(this.mBusSearchInput.getDestination().getName());
                    cJRBusTicketFilterItem4.setFilterValue(this.mBusSearchInput.getDestination().getName());
                    cJRBusTicketFilterItem4.setBPDP(true);
                    cJRBusTicketFilterItem4.setFilterCategory(e.DROPPING_POINT);
                    arrayList3.add(cJRBusTicketFilterItem4);
                }
            }
            if (!arrayList3.isEmpty()) {
                cJRBusTicketFilters.setBusTicketFilterItems(arrayList3);
                this.mBusTicketFilters.setBusTicketFilterItems(arrayList3);
                this.mSrpFilterAdapter.a(this.mBusTicketFilters.getBusTicketFilterItems());
                updateListViewData(cJRBusTicketFilters);
            }
            toggleActivityProgressBar(false);
        }
    }

    private void pulseEventAmenitiesCount(ArrayList<CJRBusSearchItem> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).getAmenities() != null && arrayList.get(i3).getAmenities().size() > 1) {
                    i2++;
                }
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder("trips_count");
            sb.append("=");
            sb.append(arrayList.size());
            sb.append(";amenities_count=");
            sb.append(i2);
            hashMap.put("event_label", sb);
            hashMap.put("event_label2", this.mBusSearchInput.getSource().getDisplayCityName() + "/" + this.mBusSearchInput.getDestination().getDisplayCityName());
            try {
                hashMap.put("event_label3", new SimpleDateFormat("dd-MMM-yy".replace("-", " ")).format(new SimpleDateFormat("yyyy-MM-dd").parse(this.mBusSearchInput.getDate())));
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            hashMap.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "amenity_bus_count", hashMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setDataToHeaderView(com.travel.bus.busticket.e.n r9, java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r10, java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r11, int r12) {
        /*
            r8 = this;
            java.lang.Object r0 = r10.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r0
            java.lang.String r0 = r0.getOperatorGroupName()
            java.lang.Object r1 = r10.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r1
            com.travel.bus.pojo.CJRBusSearchOperatorInfo r1 = r1.getOperatorObj()
            java.lang.String r1 = r1.getLogoUrl()
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r8.operatorGroupLogoListMap
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0043
            if (r0 == 0) goto L_0x0043
            boolean r2 = r0.equals(r3)
            if (r2 != 0) goto L_0x0043
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r8.operatorGroupLogoListMap
            java.lang.Object r2 = r2.get(r0)
            java.util.HashMap r2 = (java.util.HashMap) r2
            if (r2 == 0) goto L_0x0043
            int r4 = r2.size()
            if (r4 <= 0) goto L_0x0043
            java.lang.String r1 = "logo_url"
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x0043:
            java.lang.Object r2 = r10.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r2
            java.lang.String r2 = r2.getOperatorGroupName()
            java.lang.Object r2 = r11.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.String r4 = "###,###,###.##"
            r5 = 0
            if (r9 == 0) goto L_0x00ac
            android.view.View r6 = r9.itemView
            if (r6 == 0) goto L_0x00ac
            android.view.View r6 = r9.itemView
            int r7 = com.travel.bus.R.id.text_view_bus_group_minimum_price
            android.view.View r6 = r6.findViewById(r7)
            if (r6 == 0) goto L_0x00ac
            android.view.View r6 = r9.itemView
            int r7 = com.travel.bus.R.id.text_view_bus_group_minimum_price
            android.view.View r6 = r6.findViewById(r7)
            boolean r6 = r6 instanceof android.widget.TextView
            if (r6 == 0) goto L_0x00ac
            android.view.View r6 = r9.itemView
            int r7 = com.travel.bus.R.id.text_view_bus_group_minimum_price
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0091
            java.lang.CharSequence r7 = r6.getText()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0091
            java.lang.CharSequence r4 = r6.getText()
            java.lang.String r4 = r4.toString()
            goto L_0x00c8
        L_0x0091:
            java.util.ArrayList r6 = r8.getChildListLowestPrice(r10, r12, r11)
            if (r6 == 0) goto L_0x00c7
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x00c7
            java.lang.Object r6 = r6.get(r5)
            java.lang.Double r6 = (java.lang.Double) r6
            double r6 = r6.doubleValue()
            java.lang.String r4 = com.paytm.utility.b.a((double) r6, (java.lang.String) r4)
            goto L_0x00c8
        L_0x00ac:
            java.util.ArrayList r6 = r8.getChildListLowestPrice(r10, r12, r11)
            if (r6 == 0) goto L_0x00c7
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x00c7
            java.lang.Object r6 = r6.get(r5)
            java.lang.Double r6 = (java.lang.Double) r6
            double r6 = r6.doubleValue()
            java.lang.String r4 = com.paytm.utility.b.a((double) r6, (java.lang.String) r4)
            goto L_0x00c8
        L_0x00c7:
            r4 = r3
        L_0x00c8:
            java.lang.String r10 = r8.sortedTimeOfChildItem(r10, r12, r11)
            if (r0 == 0) goto L_0x00d3
            android.widget.TextView r11 = r8.mGroupNameTextView
            r11.setText(r0)
        L_0x00d3:
            if (r1 == 0) goto L_0x010a
            boolean r11 = r1.equals(r3)
            if (r11 != 0) goto L_0x010a
            android.widget.ImageView r11 = r8.mGroupLogo
            r11.setVisibility(r5)
            android.widget.ImageView r11 = r8.mGroupLogo
            android.content.Context r11 = r11.getContext()
            com.paytm.utility.b.b$a$a r11 = com.paytm.utility.b.b.a(r11)
            r11.f43753a = r1
            int r12 = com.travel.bus.R.drawable.travel_res_bus_placeholder_icon
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.paytm.utility.b.b$a$a r11 = r11.a((java.lang.Object) r12)
            int r12 = com.travel.bus.R.drawable.travel_res_bus_placeholder_icon
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.paytm.utility.b.b$a$a r11 = r11.b(r12)
            r12 = 1
            r11.m = r12
            r11.o = r12
            android.widget.ImageView r12 = r8.mGroupLogo
            r11.a((android.widget.ImageView) r12)
        L_0x010a:
            if (r2 == 0) goto L_0x0123
            int r11 = r2.size()
            if (r11 <= 0) goto L_0x0123
            android.widget.TextView r11 = r8.mBusCountTextView
            if (r11 == 0) goto L_0x0123
            int r11 = r2.size()
            java.lang.String r11 = com.travel.bus.busticket.g.d.a((java.lang.String) r0, (int) r11)
            android.widget.TextView r12 = r8.mBusCountTextView
            r12.setText(r11)
        L_0x0123:
            if (r4 == 0) goto L_0x012a
            android.widget.TextView r11 = r8.mMinimumFareTextView
            r11.setText(r4)
        L_0x012a:
            if (r10 == 0) goto L_0x014b
            android.widget.TextView r11 = r8.mStartingFromTime
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r1 = com.travel.bus.R.string.starting_from
            java.lang.String r1 = r8.getString(r1)
            r12.append(r1)
            java.lang.String r1 = " "
            r12.append(r1)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.setText(r10)
        L_0x014b:
            androidx.recyclerview.widget.RecyclerView r10 = r8.mListView
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            boolean r9 = r9.j
            r11 = 10
            if (r9 == 0) goto L_0x01a8
            android.widget.TextView r9 = r8.mBusCountTextView
            if (r9 == 0) goto L_0x01ec
            if (r2 == 0) goto L_0x01ec
            int r9 = r2.size()
            if (r9 <= 0) goto L_0x01ec
            android.widget.TextView r9 = r8.mBusCountTextView
            int r12 = com.travel.bus.R.string.show_less
            java.lang.String r12 = r8.getString(r12)
            r9.setText(r12)
            android.widget.TextView r9 = r8.mStartingFromTime
            r12 = 8
            r9.setVisibility(r12)
            android.content.res.Resources r9 = r8.getResources()
            int r12 = com.travel.bus.R.dimen.dimen_12dp
            float r9 = r9.getDimension(r12)
            int r9 = (int) r9
            android.content.res.Resources r12 = r8.getResources()
            int r0 = com.travel.bus.R.dimen.dimen_negative_5dp
            float r12 = r12.getDimension(r0)
            int r12 = (int) r12
            android.view.ViewGroup r0 = r8.mRtcHeaderCardView
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r0.setMargins(r12, r12, r12, r9)
            android.view.ViewGroup r9 = r8.mRtcHeaderCardView
            r9.setLayoutParams(r0)
            android.widget.ImageView r9 = r8.mShowBusesToggleImageView
            r12 = 1127481344(0x43340000, float:180.0)
            r9.setRotation(r12)
            r10.setMargins(r5, r5, r5, r11)
            goto L_0x01ec
        L_0x01a8:
            android.widget.TextView r9 = r8.mBusCountTextView
            if (r9 == 0) goto L_0x01ec
            if (r2 == 0) goto L_0x01ec
            int r9 = r2.size()
            if (r9 <= 0) goto L_0x01ec
            int r9 = r2.size()
            java.lang.String r9 = com.travel.bus.busticket.g.d.a((java.lang.String) r0, (int) r9)
            android.widget.TextView r12 = r8.mBusCountTextView
            r12.setText(r9)
            android.widget.TextView r9 = r8.mStartingFromTime
            r9.setVisibility(r5)
            android.content.res.Resources r9 = r8.getResources()
            int r12 = com.travel.bus.R.dimen.dimen_12dp
            float r9 = r9.getDimension(r12)
            int r9 = (int) r9
            android.view.ViewGroup r12 = r8.mRtcHeaderCardView
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r12 = (android.widget.FrameLayout.LayoutParams) r12
            r12.setMargins(r5, r5, r5, r9)
            android.view.ViewGroup r9 = r8.mRtcHeaderCardView
            r9.setLayoutParams(r12)
            android.widget.ImageView r9 = r8.mShowBusesToggleImageView
            r12 = 0
            r9.setRotation(r12)
            r9 = 40
            r10.setMargins(r5, r9, r5, r11)
        L_0x01ec:
            androidx.recyclerview.widget.RecyclerView r9 = r8.mListView
            r9.setLayoutParams(r10)
            androidx.recyclerview.widget.RecyclerView r9 = r8.mListView
            r9.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSearchSRPActivity.setDataToHeaderView(com.travel.bus.busticket.e.n, java.util.ArrayList, java.util.HashMap, int):void");
    }

    private ArrayList<Double> getChildListLowestPrice(ArrayList<CJRBusSearchItem> arrayList, int i2, HashMap<String, ArrayList<Integer>> hashMap) {
        ArrayList<Double> arrayList2 = new ArrayList<>();
        ArrayList<CJRBusSearchItem> childItemList = getChildItemList(arrayList, i2, hashMap);
        if (childItemList != null && childItemList.size() > 0) {
            for (int i3 = 0; i3 < childItemList.size(); i3++) {
                if (!(childItemList == null || childItemList.size() <= 0 || childItemList.get(i3).getFare() == null)) {
                    double[] prices = childItemList.get(i3).getFare().getPrices();
                    for (double valueOf : prices) {
                        arrayList2.add(Double.valueOf(valueOf));
                    }
                }
            }
            if (arrayList2.size() > 0) {
                Collections.sort(arrayList2);
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r1 = r1.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String sortedTimeOfChildItem(java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r1, int r2, java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r3) {
        /*
            r0 = this;
            java.util.ArrayList r1 = r0.getChildItemList(r1, r2, r3)
            com.travel.bus.busticket.activity.-$$Lambda$AJRBusSearchSRPActivity$kcYJlOzkMiEv_L3UQ4Sx9GEKmdk r2 = com.travel.bus.busticket.activity.$$Lambda$AJRBusSearchSRPActivity$kcYJlOzkMiEv_L3UQ4Sx9GEKmdk.INSTANCE
            java.util.Collections.sort(r1, r2)
            if (r1 == 0) goto L_0x002e
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x002e
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r1
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = r1.getDepartureDatetime()
            if (r2 == 0) goto L_0x002e
            java.lang.String r1 = r1.getDepartureDatetime()
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r3 = "h:mm a"
            java.lang.String r1 = com.paytm.utility.b.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
            goto L_0x0030
        L_0x002e:
            java.lang.String r1 = ""
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSearchSRPActivity.sortedTimeOfChildItem(java.util.ArrayList, int, java.util.HashMap):java.lang.String");
    }

    static /* synthetic */ int lambda$sortedTimeOfChildItem$13(CJRBusSearchItem cJRBusSearchItem, CJRBusSearchItem cJRBusSearchItem2) {
        if (cJRBusSearchItem.getDepartureDatetime() == null || cJRBusSearchItem2.getDepartureDatetime() == null) {
            return 0;
        }
        return cJRBusSearchItem.getDepartureDatetime().compareTo(cJRBusSearchItem2.getDepartureDatetime());
    }

    public ArrayList<CJRBusSearchItem> getChildItemList(ArrayList<CJRBusSearchItem> arrayList, int i2, HashMap<String, ArrayList<Integer>> hashMap) {
        ArrayList<CJRBusSearchItem> arrayList2 = new ArrayList<>();
        if (!(arrayList == null || arrayList.get(i2).getOperatorGroupName() == null)) {
            ArrayList arrayList3 = hashMap.get(arrayList.get(i2).getOperatorGroupName());
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                ArrayList<CJRBusSearchItem> arrayList4 = this.mCompleteBusList;
                if (arrayList4 != null && arrayList4.size() > 0 && ((Integer) arrayList3.get(i3)).intValue() < this.mCompleteBusList.size()) {
                    arrayList2.add(this.mCompleteBusList.get(((Integer) arrayList3.get(i3)).intValue()));
                }
            }
        }
        return arrayList2;
    }

    public void updateListViewData(CJRBusTicketFilters cJRBusTicketFilters) {
        w wVar;
        w wVar2 = this.mBusSearchListAdapter;
        if (wVar2 != null) {
            this.mBusSearchListAdapter.c(this.mBusSearchPresenter.a(wVar2.f21784f, this.operatorGroupListMap));
            this.totalFilteredNoOfBuses = this.mBusSearchListAdapter.f21784f.size();
            updateFragmentData(this.mBusSearchInput, cJRBusTicketFilters);
            int i2 = 0;
            if (this.mBusSearchListAdapter.f21784f.size() == 0) {
                displayDialogOnNoBusFound(getResources().getString(R.string.bus_filter_message_revamp, new Object[]{Integer.valueOf(this.mCompleteBusList.size())}), true);
            }
            setFiltertedBusFooter();
            if (this.isExpanded && (wVar = this.mBusSearchListAdapter) != null && wVar.f21784f != null && this.mBusSearchListAdapter.f21784f.size() > 0) {
                while (i2 < this.mBusSearchListAdapter.f21784f.size() && this.mBusSearchListAdapter.f21784f.get(i2).getOperatorGroupName() == null) {
                    i2++;
                }
            }
        }
    }

    public void setFiltertedBusFooter() {
        boolean z;
        this.filterbusNoFooter.setVisibility(0);
        if (this.mCompleteBusList != null) {
            String str = "Showing " + this.totalFilteredNoOfBuses + " out of " + this.mCompleteBusList.size() + " buses";
            if (this.totalFilteredNoOfBuses == this.mCompleteBusList.size()) {
                str = "Showing all " + this.mCompleteBusList.size() + " buses";
            }
            if (this.totalFilteredNoOfBuses == 0) {
                this.filterbusNoFooter.setVisibility(4);
            }
            this.mLinResetYourFilter.setVisibility(8);
            this.mImageFilterSelected.setVisibility(4);
            CJRBusTicketFilters cJRBusTicketFilters = this.mBusTicketFilters;
            if (cJRBusTicketFilters == null || cJRBusTicketFilters.getBusTicketFilterItems() == null || this.mBusTicketFilters.getBusTicketFilterItems().size() <= 0) {
                z = false;
            } else {
                this.mImageFilterSelected.setVisibility(0);
                z = true;
            }
            w wVar = this.mBusSearchListAdapter;
            if (wVar != null && wVar.f21784f != null && this.mBusSearchListAdapter.f21784f.size() < 3 && this.mBusSearchListAdapter.f21784f.size() > 0 && z) {
                this.mLinResetYourFilter.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.selectedSortBy)) {
                this.mImageFilterSelected.setVisibility(0);
            }
            this.filterbusNoFooter.setText(str);
        }
    }

    public void toggleActivityProgressBar(boolean z) {
        if (z) {
            showProgressBarLyt();
        } else {
            hideProgressBarLyt();
        }
    }

    public void filterData(CJRBusTicketFilters cJRBusTicketFilters) {
        w wVar = this.mBusSearchListAdapter;
        if (wVar != null) {
            wVar.f21786h = true;
        }
        if (getBusSearchResultData() != null && getBusSearchResultData().getBody() != null && getBusSearchResultData().getBody().getTrips() != null) {
            w wVar2 = this.mBusSearchListAdapter;
            ArrayList<CJRBusSearchItem> arrayList = new ArrayList<>(getBusSearchResultData().getBody().getTrips());
            CJRBusSearchInput cJRBusSearchInput = this.mBusSearchInput;
            if (!(cJRBusSearchInput == null || cJRBusSearchInput.getSortBy() == null)) {
                if (cJRBusSearchInput.getSortBy().equalsIgnoreCase("topRated")) {
                    arrayList = wVar2.a(arrayList, cJRBusSearchInput.getOrderBy());
                } else {
                    Collections.sort(arrayList, new w.a(cJRBusSearchInput.getSortBy(), cJRBusSearchInput.getOrderBy(), arrayList));
                }
            }
            this.mCompleteBusList = arrayList;
            ArrayList<CJRBusSearchItem> a2 = com.travel.bus.busticket.g.d.a(this.mBusSearchPresenter.a(this.mCompleteBusList, this.mBusTicketFilters));
            this.filteredBusList.clear();
            this.filteredBusList.addAll(a2);
            this.operatorGroupListMap = this.mBusSearch.getOperator_groups();
            ArrayList<CJRBusSearchItem> a3 = this.mBusSearchPresenter.a(a2, this.operatorGroupListMap);
            w wVar3 = this.mBusSearchListAdapter;
            if (wVar3 != null) {
                wVar3.f21786h = true;
                wVar3.f21784f.clear();
                wVar3.f21784f.addAll(a2);
                w wVar4 = this.mBusSearchListAdapter;
                wVar4.f21782d = a3;
                wVar4.notifyDataSetChanged();
                if (this.stickyHeaderLayout.getVisibility() == 0) {
                    this.stickyHeaderLayout.setVisibility(8);
                }
                if (a3.size() == 0) {
                    this.zeroResultFound = true;
                    displayDialogOnNoBusFound(getResources().getString(R.string.bus_filter_message_revamp, new Object[]{Integer.valueOf(this.mCompleteBusList.size())}), true);
                    return;
                }
                this.mLinearClearView.setVisibility(0);
                this.mNoSearchResultFound.setVisibility(8);
                this.mBottomActionBar.setVisibility(0);
                this.totalFilteredNoOfBuses = a2.size();
                setFiltertedBusFooter();
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            showBottomTab();
        } else {
            hideBottomTab();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        try {
            NetworkCustomError networkCustomError = new NetworkCustomError(volleyError.getMessage());
            l.a((Context) this, networkCustomError.networkResponse.statusCode, networkCustomError);
            toggleActivityProgressBar(false);
            String message = networkCustomError.getMessage();
            if (message != null && message.equalsIgnoreCase("503")) {
                showMaintenanceErrorAlert(getResources().getString(R.string.bus_maintenance_error_title), getResources().getString(R.string.bus_maintenance_error_description));
            } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), "");
            } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                onNoResultFound(true, networkCustomError.getAlertMessage(), false, true);
                showMaintenanceErrorAlert(getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            } else {
                onNoResultFound(true, networkCustomError.getAlertMessage(), false, true);
            }
            if (networkCustomError.getMessage() != null) {
                String message2 = networkCustomError.getMessage();
                if (message2.equalsIgnoreCase("410")) {
                    onNoResultFound(true, message2, false, true);
                }
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public void onResponse(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRBusSearch) {
            toggleActivityProgressBar(false);
            updateResponseFromNetwork((CJRBusSearch) iJRDataModel);
        }
    }

    public void onRatingsClick(CJRBusSearchItem cJRBusSearchItem, int i2, int i3) {
        toggleActivityProgressBar(true);
        if (i2 == 0) {
            l.a((Context) this, "ratings", cJRBusSearchItem);
            startReviewRouteandCancellationActivity(cJRBusSearchItem, "ratings", i3);
        } else if (i2 == 1) {
            l.a((Context) this, "route", cJRBusSearchItem);
            startReviewRouteandCancellationActivity(cJRBusSearchItem, "route", i3);
        } else if (i2 == 2) {
            l.a((Context) this, "cancellation_policy", cJRBusSearchItem);
            startReviewRouteandCancellationActivity(cJRBusSearchItem, "cancellation_policy", i3);
        }
    }

    public void onHorizontalScrollClicked(CJRBusSearchItem cJRBusSearchItem, int i2) {
        if (this.mBusSearchListAdapter != null) {
            onBusSearchListItemClick(cJRBusSearchItem, i2);
        }
    }

    public void onGroupViewClicked(boolean z, int i2) {
        try {
            if (this.mBusSearchListAdapter != null) {
                this.rtcCount = 0;
                ArrayList<CJRBusSearchItem> arrayList = this.mBusSearchListAdapter.f21782d;
                if (!z) {
                    ArrayList<CJRBusSearchItem> a2 = this.mBusSearchListAdapter.a(i2);
                    if (a2.size() > 0) {
                        arrayList.addAll(i2 + 1, a2);
                        this.mBusSearchListAdapter.a(arrayList);
                    }
                } else {
                    Iterator<CJRBusSearchItem> it2 = this.mBusSearchListAdapter.a(i2).iterator();
                    while (it2.hasNext()) {
                        CJRBusSearchItem next = it2.next();
                        if (arrayList.contains(next)) {
                            arrayList.remove(next);
                        }
                    }
                    this.mBusSearchListAdapter.a(arrayList);
                }
                this.mBusSearchListAdapter.notifyDataSetChanged();
                if (this.stickyHeaderLayout != null && this.headerDataModel != null) {
                    for (int i3 = 0; i3 < this.headerDataModel.f22419b.size(); i3++) {
                        if (!(this.headerDataModel.f22419b.get(i3) == null || this.headerDataModel.f22419b.get(i3).getmItemType() == null || !arrayList.get(i3).getmItemType().equals("bus_item_type_header"))) {
                            this.rtcCount++;
                        }
                    }
                    if (this.rtcCount == 1) {
                        setDataToHeaderView(this.headerDataModel.f22418a, this.headerDataModel.f22419b, this.headerDataModel.f22420c, i2);
                        if (!z) {
                            this.mBusCountTextView.setText(getString(R.string.show_less));
                            this.stickyHeaderLayout.setVisibility(0);
                            return;
                        }
                        this.mListView.scrollToPosition(i2);
                        this.stickyHeaderLayout.setVisibility(8);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onChildClicked(CJRBusSearchItem cJRBusSearchItem, int i2) {
        if (this.mBusSearchListAdapter != null) {
            onBusSearchListItemClick(cJRBusSearchItem, i2);
        }
    }

    public void startReviewRouteandCancellationActivity(CJRBusSearchItem cJRBusSearchItem, String str, int i2) {
        if (cJRBusSearchItem != null) {
            this.mBusSearchPresenter.a(cJRBusSearchItem, i2, this.mBusSearchItems, this.mOperatorTagInfo, this.mAmenityInfo);
            Intent intent = new Intent(this, AJRBusSelectSeatsActivity.class);
            intent.putExtra("intent_extra_bus_search_result_item", cJRBusSearchItem);
            intent.putExtra("intent_extra_bus_search_ratings_key", str);
            intent.putExtra("intent_extra_bus_search_position", i2);
            intent.putExtra("intent_extra_bus_search_input", this.mBusSearchInput);
            if (cJRBusSearchItem.getFeature().getCollectLocationPoints() != null && cJRBusSearchItem.getFeature().getCollectLocationPoints().booleanValue()) {
                intent.putExtra("intent_extra_flag_bp_dp_required", true);
            }
            intent.putExtra("amenity_info", this.mBusSearch.getBody().getDictionary().getAmenitiesInfo());
            if (!(getBusSearchResultData() == null || getBusSearchResultData().getMeta().getRequestid() == null)) {
                intent.putExtra("intent_extra_bus_search", getBusSearchResultData().getMeta().getRequestid());
            }
            intent.putExtra("intent_extra_bus_search_load_data", this.mBusSearch.getBody().getDictionary().getOperatorTags());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            startActivityForResult(intent, 4);
            toggleActivityProgressBar(false);
        }
    }

    public void loadData(final CJRBusSearch cJRBusSearch, String str) {
        if (this.mBusSearch == null) {
            if (cJRBusSearch == null) {
                this.mBusSearchPresenter.a(this.mBusTicketFilters, this.mBusSearchInput);
                return;
            }
            if (str != null && !str.isEmpty()) {
                deleteItemFromListIfExist(cJRBusSearch, str);
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AJRBusSearchSRPActivity.this.updateResponseFromNetwork(cJRBusSearch);
                    AJRBusSearchSRPActivity aJRBusSearchSRPActivity = AJRBusSearchSRPActivity.this;
                    aJRBusSearchSRPActivity.updateListViewData(aJRBusSearchSRPActivity.mBusTicketFilters);
                }
            });
        }
    }

    public void deleteItemFromListIfExist(CJRBusSearch cJRBusSearch, String str) {
        if (cJRBusSearch != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= cJRBusSearch.getBody().getTrips().size()) {
                    break;
                } else if (cJRBusSearch.getBody().getTrips().get(i2).getTripId().equalsIgnoreCase(str)) {
                    cJRBusSearch.getBody().getTrips().remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.mBusSearch = cJRBusSearch;
        updateListViewData(this.mBusTicketFilters);
    }

    public void updateListItemsInFragment(String str) {
        deleteItemFromListIfExist(this.mBusSearch, str);
        if (this.mBusSearch.getBody() == null || this.mBusSearch.getBody().getTrips().size() <= 0) {
            showMaintenanceErrorAlert(getResources().getString(R.string.error), getResources().getString(R.string.no_buses_found));
            return;
        }
        onDataLoaded(this.mBusSearch);
        setListViewData(this.mBusSearch);
        updateFragmentListViewData(this.mBusSearch);
    }

    public void updateFragmentData(CJRBusSearchInput cJRBusSearchInput, CJRBusTicketFilters cJRBusTicketFilters) {
        if (cJRBusTicketFilters != null) {
            toggleNightBuses(cJRBusTicketFilters.ismNightBusesFlag());
            toggleCovidBuses();
            toggleDealsBuses();
            this.mShowNightBusesSwitch.setChecked(cJRBusTicketFilters.ismNightBusesFlag());
        }
        this.mBusSearchInput = cJRBusSearchInput;
        this.mBusTicketFilters = cJRBusTicketFilters;
        sortDataByLayoutSelected(this.mBusTicketFilters);
        filterData(this.mBusTicketFilters);
    }

    public void onZeroSearchItemClick(int i2) {
        List<List<CJRSuggestionZeroSearch>> list = this.alternateRouteList;
        if (list != null && list.size() > i2 && this.alternateRouteList.get(i2) != null) {
            if (((CJRSuggestionZeroSearch) this.alternateRouteList.get(i2).get(0)).getLayoutType() == com.travel.bus.busticket.h.b.N_HOP_ZERO_SEARCH) {
                ((CJRSuggestionZeroSearch) this.alternateRouteList.get(i2).get(0)).setExpanded(!((CJRSuggestionZeroSearch) this.alternateRouteList.get(i2).get(0)).isExpanded());
                this.alternateRoutesAdapter.notifyDataSetChanged();
                return;
            }
            callNearBySearch(i2);
        }
    }

    private void callNearBySearch(int i2) {
        CJRSuggestionZeroSearch cJRSuggestionZeroSearch;
        this.mNoSearchResultFound.setVisibility(8);
        this.busProgressBarAnimation.a();
        List list = this.alternateRouteList.get(i2);
        int size = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                cJRSuggestionZeroSearch = null;
                break;
            } else if (((CJRSuggestionZeroSearch) list.get(i3)).getEdge().startsWith("routes")) {
                cJRSuggestionZeroSearch = (CJRSuggestionZeroSearch) list.get(i3);
                break;
            } else {
                i3++;
            }
        }
        if (cJRSuggestionZeroSearch != null) {
            CJRDictionaryItem cJRDictionaryItem = this.routesZeroSearch.getDictionary().get(cJRSuggestionZeroSearch.getStart());
            CJRDictionaryItem cJRDictionaryItem2 = this.routesZeroSearch.getDictionary().get(cJRSuggestionZeroSearch.getEnd());
            int stringToInt = getStringToInt(cJRDictionaryItem.getBusCityId());
            int stringToInt2 = getStringToInt(cJRDictionaryItem2.getBusCityId());
            JSONObject jSONConstruction = getJSONConstruction(stringToInt, stringToInt2);
            if (jSONConstruction != null) {
                CJRBusOriginCityItem cJRBusOriginCityItem = new CJRBusOriginCityItem();
                cJRBusOriginCityItem.setCityName(cJRDictionaryItem.getName());
                cJRBusOriginCityItem.setDisplayCityName(cJRDictionaryItem.getName());
                cJRBusOriginCityItem.setHeadingCityName(cJRDictionaryItem.getName());
                cJRBusOriginCityItem.setName(cJRDictionaryItem.getName());
                cJRBusOriginCityItem.setShortCityName(cJRDictionaryItem.getName());
                cJRBusOriginCityItem.setCityId((long) stringToInt);
                CJRBusOriginCityItem cJRBusOriginCityItem2 = new CJRBusOriginCityItem();
                cJRBusOriginCityItem2.setCityName(cJRDictionaryItem2.getName());
                cJRBusOriginCityItem2.setDisplayCityName(cJRDictionaryItem2.getName());
                cJRBusOriginCityItem2.setHeadingCityName(cJRDictionaryItem2.getName());
                cJRBusOriginCityItem2.setName(cJRDictionaryItem2.getName());
                cJRBusOriginCityItem2.setShortCityName(cJRDictionaryItem2.getName());
                cJRBusOriginCityItem2.setCityId((long) stringToInt2);
                this.mBusSearchInput.setSource(cJRBusOriginCityItem);
                this.mBusSearchInput.setDestination(cJRBusOriginCityItem2);
                this.sourceTextView.setText(cJRDictionaryItem.getName());
                this.destTextView.setText(cJRDictionaryItem2.getName());
                saveIntoRecentItem(cJRBusOriginCityItem, cJRBusOriginCityItem2);
                this.mBusSearchPresenter.a(jSONConstruction);
            }
        }
    }

    private int getStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private JSONObject getJSONConstruction(int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_doc_id", i2);
            jSONObject.put("destination_doc_id", i3);
            if (this.mBusSearchInput.getDate() != null) {
                jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, this.mBusSearchInput.getDate());
            }
            if (this.mBusSearchInput.isDealApplicable()) {
                com.travel.bus.a.a();
                jSONObject.put("is_deal_applicable", com.travel.bus.a.b().a("isBusDealsApplicable", true));
            }
            jSONObject.put("is_departed", true);
            jSONObject.put("is_sold_out", 1);
            jSONObject.put("request_type", "nearby");
            jSONObject.put("leg_number", 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void displayDialogOnNoBusFound(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "error_popup");
        hashMap.put("event_label", str);
        hashMap.put("event_label2", " ");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        onNoResultFound(true, str, z, false);
    }
}
