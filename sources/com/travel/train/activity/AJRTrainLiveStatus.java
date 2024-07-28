package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.ab;
import androidx.core.h.u;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.ai;
import com.travel.train.i.a;
import com.travel.train.j.g;
import com.travel.train.j.m;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.j.w;
import com.travel.train.model.CJROfferItems;
import com.travel.train.model.trainticket.CJRStoreFrontBanners;
import com.travel.train.model.trainticket.CJRStoreFrontItem;
import com.travel.train.model.trainticket.CJRTrainBannerDetails;
import com.travel.train.model.trainticket.CJRTrainLSModel;
import com.travel.train.model.trainticket.CJRTrainLSStation;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.widget.TrainHorizontalProgress;
import com.travel.utils.n;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CJRFlowLayout;

public class AJRTrainLiveStatus extends CJRTrainBaseActivity implements b, a {
    private String LOG_TAG = "AJRTrainLiveStatus";
    private View actionBarDivider;
    private AppBarLayout appBar;
    private ImageView bannerImageView;
    private CJRStoreFrontBanners bannersInfo;
    private int boardingointIndex;
    private ViewGroup bottomBannerLayout;
    private ImageView closeBannerImageView;
    private int currentDistance;
    /* access modifiers changed from: private */
    public int currentStationIndex;
    private ImageView disclaimerIcon;
    private int endDistance;
    private boolean isDestinationReached = false;
    private boolean isTrainLeftOriginStn;
    private boolean isUpcomingTripItem;
    private LinearLayout mAlreadyStartedLyt;
    private String mCurrentStnActualArrivalDate;
    private String mCurrentStnActualArrivalTime;
    private String mCurrentStnCode;
    /* access modifiers changed from: private */
    public TextView mCurrentStnDateTxt;
    private String mCurrentStnName;
    private RelativeLayout mDateLyt;
    private String mDestStnActualArrivalDate;
    private String mDestStnActualArrivalTime;
    private String mDestStnCode;
    private String mDestStnName;
    private TextView mDistLytTimeLeftTxtValue;
    private ImageView mDistMapIcon;
    private RelativeLayout mEntireLyt;
    private TextView mFromAndToTxt;
    private FrameLayout mGenericErrorLayout;
    private TrainHorizontalProgress mHoriZontalDistanceBar;
    private LottieAnimationView mLottieAnimView;
    private String mNextStnCode;
    private TextView mNextStnDepartureTxt;
    private String mNextStnExpectedArrivaltime;
    private String mNextStnName;
    private TextView mNextStnNameTxt;
    private LinearLayout mNotYetStartedLyt;
    private TextView mNotYetStartedLytTxt1;
    private TextView mNotYetStartedLytTxt2;
    private String mOriginStnActualDepartureDate;
    private String mOriginStnActualDepartureTime;
    private String mOriginStnCode;
    private String mOriginStnName;
    private String mPrevStnActualDepartureTime;
    private String mPreviousStnCode;
    private TextView mPreviousStnDepartureTxt;
    private String mPreviousStnName;
    private TextView mPreviousStnNameTxt;
    /* access modifiers changed from: private */
    public RecyclerView mRecyler;
    private ai mRecylerAdapter;
    private ImageView mRemoveTentative;
    private String mSelectedBoardingPointStnCode;
    private String mSelectedBoardingPointStnName;
    private String mSelectedJourneyDate;
    private String mSelectedTrainName;
    private String mSelectedTrainNumber;
    private String mServerTimeIst;
    /* access modifiers changed from: private */
    public List<CJRTrainLSStation> mStations;
    /* access modifiers changed from: private */
    public CJRFlowLayout mTentativeLayout;
    private String mTimeOfAvailability;
    private String mUpcomingTripDestCode;
    private View mView3;
    /* access modifiers changed from: private */
    public com.paytm.b.a.a prefs;
    private LinearLayout promoContainer;
    private ImageView refreshIcon;
    private ImageView shareIconImageView;
    private boolean showDisclaimer = false;
    /* access modifiers changed from: private */
    public Toolbar toolbar;

    private void onShareButtonClicked() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_live_status);
        getIntentData();
        initUI();
        saveDataInSharedPreferences();
        fetchLiveStatusData();
        fireStoreFrontAPI();
    }

    private void fireStoreFrontAPI() {
        if (com.paytm.utility.b.c((Context) this)) {
            com.travel.train.b.a();
            String ad = com.travel.train.b.b().ad();
            if (!TextUtils.isEmpty(ad) && URLUtil.isValidUrl(ad)) {
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                hashMap.put("Content-Type", "application/json");
                if (com.paytm.utility.b.r((Context) this)) {
                    hashMap.put("user_account_user_id", com.paytm.utility.b.n((Context) this));
                }
                String b2 = o.b((Context) this, com.paytm.utility.b.s(this, v.a(ad, "?", "channel", "=", "android")));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.TRAIN;
                bVar.n = a.b.SILENT;
                bVar.o = g.f27557g;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = b2;
                bVar.f42882f = hashMap;
                bVar.f42884h = null;
                bVar.f42885i = new CJRStoreFrontBanners();
                bVar.j = this;
                bVar.k = false;
                bVar.l().a();
            }
        }
    }

    private void fetchLiveStatusData() {
        com.travel.train.b.a();
        String m = com.travel.train.b.b().m();
        if (!TextUtils.isEmpty(m)) {
            String s = com.paytm.utility.b.s(this, m + "?departure_date=" + this.mSelectedJourneyDate + "&train_number=" + this.mSelectedTrainNumber + "&boarding=" + this.mSelectedBoardingPointStnCode);
            try {
                if (!isFinishing()) {
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this;
                    bVar.f42878b = a.c.TRAIN;
                    bVar.n = a.b.SILENT;
                    bVar.o = g.f27557g;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = s;
                    bVar.f42882f = n.b((Context) this);
                    bVar.f42885i = new CJRTrainLSModel();
                    bVar.j = this;
                    com.paytm.network.a l = bVar.l();
                    l.f42859c = false;
                    if (com.paytm.utility.b.c((Context) this)) {
                        showProgressDialog();
                        l.a();
                        return;
                    }
                    showNetworkDialog(l, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("intent_extra_train_selected_number")) {
                this.mSelectedTrainNumber = intent.getStringExtra("intent_extra_train_selected_number");
            }
            if (intent.hasExtra("intent_extra_train_selected_name")) {
                this.mSelectedTrainName = intent.getStringExtra("intent_extra_train_selected_name");
            }
            if (intent.hasExtra("intent_extra_bp_selected_stn_name")) {
                this.mSelectedBoardingPointStnName = intent.getStringExtra("intent_extra_bp_selected_stn_name");
            }
            if (intent.hasExtra("intent_extra_bp_selected_stn_code")) {
                this.mSelectedBoardingPointStnCode = intent.getStringExtra("intent_extra_bp_selected_stn_code");
            }
            if (intent.hasExtra("intent_extra_selected_ls_date")) {
                this.mSelectedJourneyDate = intent.getStringExtra("intent_extra_selected_ls_date");
            }
            if (intent.hasExtra("intent_extra_is_upcoming_trip")) {
                this.isUpcomingTripItem = intent.getBooleanExtra("intent_extra_is_upcoming_trip", false);
            }
            if (intent.hasExtra("intent_extra_ls_destination_code")) {
                this.mUpcomingTripDestCode = intent.getStringExtra("intent_extra_ls_destination_code");
            }
            if (getIntent().hasExtra("extra_home_data")) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getExtras().getSerializable("extra_home_data");
                if (!TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                    String queryParameter = Uri.parse(cJRHomePageItem.getURL()).buildUpon().build().getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        cJRHomePageItem.setUrl(queryParameter);
                    }
                } else if (cJRHomePageItem instanceof CJRHomePageItem) {
                    String deeplink = cJRHomePageItem.getDeeplink();
                    if (!TextUtils.isEmpty(deeplink)) {
                        cJRHomePageItem.setUrl(deeplink);
                    }
                }
                if (!TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                    getDetailsFromDeeplink(cJRHomePageItem.getURL());
                }
            }
        }
    }

    public void getDetailsFromDeeplink(String str) {
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getQueryParameter("trainnumber"))) {
            this.mSelectedTrainNumber = parse.getQueryParameter("trainnumber");
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("boarding"))) {
            this.mSelectedBoardingPointStnCode = parse.getQueryParameter("boarding");
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR))) {
            this.mSelectedJourneyDate = parse.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        }
        if (!TextUtils.isEmpty(parse.getQueryParameter("name"))) {
            this.mSelectedTrainName = parse.getQueryParameter("name");
        }
    }

    private void saveDataInSharedPreferences() {
        SharedPreferences.Editor edit = getSharedPreferences("train_ls_home_recent_searched_pref", 0).edit();
        edit.putString("trainName", this.mSelectedTrainName);
        edit.putString("trainNumber", this.mSelectedTrainNumber);
        edit.putString("boardingPointStnName", this.mSelectedBoardingPointStnName);
        edit.putString("boardingPointStnCode", this.mSelectedBoardingPointStnCode);
        edit.apply();
        CJRTrainRecentsItemModel cJRTrainRecentsItemModel = new CJRTrainRecentsItemModel();
        cJRTrainRecentsItemModel.setTrainName(this.mSelectedTrainName);
        cJRTrainRecentsItemModel.setTrainNumber(this.mSelectedTrainNumber);
        m.a aVar = m.f27577a;
        m.a.a(cJRTrainRecentsItemModel, "train_ls_recent_searched_pref", 3, this);
    }

    private void initUI() {
        this.prefs = w.a(getApplicationContext());
        this.showDisclaimer = this.prefs.b("tentative_disclaimer", true, false);
        this.appBar = (AppBarLayout) findViewById(R.id.appbar);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.refreshIcon = (ImageView) findViewById(R.id.refresh_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.refreshIcon, "ic_refresh.png", false, false, n.a.V1);
        this.shareIconImageView = (ImageView) findViewById(R.id.share_icon);
        this.actionBarDivider = findViewById(R.id.title_divider);
        setToolbar();
        this.mEntireLyt = (RelativeLayout) findViewById(R.id.entire_lyt);
        this.mFromAndToTxt = (TextView) findViewById(R.id.from_and_to_txt);
        this.mDistLytTimeLeftTxtValue = (TextView) findViewById(R.id.distance_lyt_time_txt);
        this.mHoriZontalDistanceBar = (TrainHorizontalProgress) findViewById(R.id.distance_bar);
        this.mNotYetStartedLyt = (LinearLayout) findViewById(R.id.not_yet_started_lyt);
        this.mAlreadyStartedLyt = (LinearLayout) findViewById(R.id.already_started_lyt);
        this.mPreviousStnNameTxt = (TextView) findViewById(R.id.previous_stn_name_txt);
        this.mPreviousStnDepartureTxt = (TextView) findViewById(R.id.previous_stn_departure_txt);
        this.mNextStnNameTxt = (TextView) findViewById(R.id.next_stn_name_txt);
        this.mNextStnDepartureTxt = (TextView) findViewById(R.id.next_stn_departure_txt);
        this.mNotYetStartedLytTxt1 = (TextView) findViewById(R.id.not_yet_started_lyt_txt_1);
        this.mNotYetStartedLytTxt2 = (TextView) findViewById(R.id.not_yet_started_lyt_txt_2);
        this.mDateLyt = (RelativeLayout) findViewById(R.id.date_lyt);
        this.mView3 = findViewById(R.id.view3);
        this.mCurrentStnDateTxt = (TextView) findViewById(R.id.current_stn_date_txt);
        this.mRecyler = (RecyclerView) findViewById(R.id.recyler_view);
        this.mDistMapIcon = (ImageView) findViewById(R.id.dist_map_icon);
        setMainLytVisibility(false);
        this.mTentativeLayout = (CJRFlowLayout) findViewById(R.id.tentative_disclaimer_layout);
        this.mRemoveTentative = (ImageView) this.mTentativeLayout.findViewById(R.id.remove_tentative);
        this.disclaimerIcon = (ImageView) this.mTentativeLayout.findViewById(R.id.disclaimer_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.disclaimerIcon, "speaker_icon.png", false, false, n.a.V1);
        this.mTentativeLayout.setVisibility(8);
        this.promoContainer = (LinearLayout) findViewById(R.id.promo_container);
        this.mGenericErrorLayout = (FrameLayout) findViewById(R.id.generic_error_layout);
        this.mRemoveTentative.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainLiveStatus.this.mTentativeLayout.setVisibility(8);
                AJRTrainLiveStatus.this.prefs.a("tentative_disclaimer", false, false);
            }
        });
        this.bottomBannerLayout = (ViewGroup) findViewById(R.id.layout_bottom_banner);
        this.bannerImageView = (ImageView) findViewById(R.id.image_view_banner_logo);
        this.closeBannerImageView = (ImageView) findViewById(R.id.image_view_close);
        this.mLottieAnimView = (LottieAnimationView) findViewById(R.id.lottieAnim);
        this.bottomBannerLayout.setVisibility(8);
        u.a((View) this.appBar, (androidx.core.h.q) new androidx.core.h.q() {
            public final ab a(View view, ab abVar) {
                if (Build.VERSION.SDK_INT >= 17) {
                    AJRTrainLiveStatus.this.toolbar.setPadding(0, abVar.b(), 0, 0);
                }
                abVar.f3061b.c();
                return abVar;
            }
        });
        setTitle();
    }

    private void setTitle() {
        if (!TextUtils.isEmpty(this.mSelectedTrainName)) {
            ((TextView) findViewById(R.id.toolbar_title)).setText(this.mSelectedTrainName);
        } else {
            ((TextView) findViewById(R.id.toolbar_title)).setText(getResources().getString(R.string.train_ls_train) + " " + this.mSelectedTrainNumber);
        }
        ((TextView) findViewById(R.id.toolbar_sub_title)).setText(getFormattedDateForTitle(this.mSelectedJourneyDate));
    }

    private void setToolbar() {
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainLiveStatus.this.lambda$setToolbar$0$AJRTrainLiveStatus(view);
            }
        });
        this.refreshIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainLiveStatus.this.lambda$setToolbar$1$AJRTrainLiveStatus(view);
            }
        });
        this.shareIconImageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainLiveStatus.this.lambda$setToolbar$2$AJRTrainLiveStatus(view);
            }
        });
        setSupportActionBar(this.toolbar);
    }

    public /* synthetic */ void lambda$setToolbar$0$AJRTrainLiveStatus(View view) {
        finish();
    }

    public /* synthetic */ void lambda$setToolbar$1$AJRTrainLiveStatus(View view) {
        refreshData();
    }

    public /* synthetic */ void lambda$setToolbar$2$AJRTrainLiveStatus(View view) {
        onShareButtonClicked();
    }

    private void refreshData() {
        this.mDateLyt.setVisibility(8);
        this.mView3.setVisibility(8);
        this.actionBarDivider.setVisibility(8);
        this.mRecyler.removeAllViews();
        this.mRecyler.clearOnScrollListeners();
        this.mRecyler.setVisibility(8);
        this.mTentativeLayout.setVisibility(8);
        this.bottomBannerLayout.setVisibility(8);
        List<CJRTrainLSStation> list = this.mStations;
        if (list != null) {
            list.clear();
        }
        setMainLytVisibility(false);
        fetchLiveStatusData();
    }

    private void initPromotionalViews(String str) {
        if (!TextUtils.isEmpty(str)) {
            updatePromoContainerVisibility(0);
            this.promoContainer.setBackgroundColor(getResources().getColor(R.color.color_ffa400));
            TextView textView = (TextView) this.promoContainer.findViewById(R.id.tv_promo_text);
            ImageView imageView = (ImageView) this.promoContainer.findViewById(R.id.iv_close_icon);
            if (textView != null) {
                textView.setText(str);
            }
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRTrainLiveStatus.this.lambda$initPromotionalViews$3$AJRTrainLiveStatus(view);
                }
            });
            return;
        }
        updatePromoContainerVisibility(8);
    }

    public /* synthetic */ void lambda$initPromotionalViews$3$AJRTrainLiveStatus(View view) {
        updatePromoContainerVisibility(8);
    }

    private void updatePromoContainerVisibility(int i2) {
        this.promoContainer.setVisibility(i2);
        if (i2 == 0) {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) this.mEntireLyt.getLayoutParams();
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.dimen_105dp);
            this.mEntireLyt.setLayoutParams(layoutParams);
            ((Toolbar) findViewById(R.id.toolbar)).setMinimumHeight((int) getResources().getDimension(R.dimen.dimen_105dp));
            return;
        }
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) this.mEntireLyt.getLayoutParams();
        layoutParams2.topMargin = (int) getResources().getDimension(R.dimen.dimen_65dp);
        this.mEntireLyt.setLayoutParams(layoutParams2);
        ((Toolbar) findViewById(R.id.toolbar)).setMinimumHeight((int) getResources().getDimension(R.dimen.dimen_65dp));
    }

    private void setRecyclerAdapter() {
        this.mRecyler.setVisibility(0);
        ai aiVar = r0;
        ai aiVar2 = new ai(this, this.mStations, this.mOriginStnCode, this.mCurrentStnCode, this.mDestStnCode, this.mSelectedBoardingPointStnCode, this.currentStationIndex, this.mSelectedJourneyDate, this.mTimeOfAvailability, this.isUpcomingTripItem, this.mUpcomingTripDestCode, this.mNextStnCode, this);
        this.mRecylerAdapter = aiVar;
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        this.mRecyler.setLayoutManager(linearLayoutManager);
        this.mRecyler.setAdapter(this.mRecylerAdapter);
        this.shareIconImageView.setVisibility(8);
        this.closeBannerImageView.setVisibility(0);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (AJRTrainLiveStatus.this.currentStationIndex <= 0) {
                    return;
                }
                if (AJRTrainLiveStatus.this.currentStationIndex < AJRTrainLiveStatus.this.mStations.size() - 2) {
                    AJRTrainLiveStatus.this.mRecyler.scrollToPosition(AJRTrainLiveStatus.this.currentStationIndex + 1);
                } else {
                    AJRTrainLiveStatus.this.mRecyler.scrollToPosition(AJRTrainLiveStatus.this.currentStationIndex);
                }
            }
        }, 100);
        this.mRecyler.addOnScrollListener(new RecyclerView.l() {
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition != -1) {
                    final CJRTrainLSStation cJRTrainLSStation = (CJRTrainLSStation) AJRTrainLiveStatus.this.mStations.get(findFirstVisibleItemPosition);
                    new Handler().post(new Runnable() {
                        public final void run() {
                            AJRTrainLiveStatus.this.mCurrentStnDateTxt.setText(AJRTrainLiveStatus.this.getFormattedDate(cJRTrainLSStation.getActualArrivalDate()));
                        }
                    });
                }
            }
        });
    }

    private void setDistanceLayout() {
        TextView textView = this.mFromAndToTxt;
        textView.setText(this.mOriginStnName + " - " + this.mDestStnName);
        this.mHoriZontalDistanceBar.setmBackgroundColor(androidx.core.content.b.c(this, R.color.color_ebebeb));
        this.mHoriZontalDistanceBar.setmPrimaryProgressColor(androidx.core.content.b.c(this, R.color.color_21c17a));
        com.travel.train.widget.a aVar = new com.travel.train.widget.a(this.mHoriZontalDistanceBar, (float) calculateProgressRate());
        aVar.setDuration(800);
        this.mHoriZontalDistanceBar.startAnimation(aVar);
        if (this.currentStationIndex <= this.boardingointIndex) {
            this.mNextStnDepartureTxt.setText(getResources().getString(R.string.train_ls_duration));
            this.mDistLytTimeLeftTxtValue.setText(getTimeLeftOrDuration("origin"));
        } else {
            this.mNextStnDepartureTxt.setText(getResources().getString(R.string.train_ls_time_left));
            this.mDistLytTimeLeftTxtValue.setText(getTimeLeftOrDuration("current"));
        }
        if (!TextUtils.isEmpty(this.mCurrentStnCode) && this.mCurrentStnCode.equalsIgnoreCase(this.mDestStnCode)) {
            this.mDistMapIcon.setImageDrawable(getResources().getDrawable(R.drawable.pre_t_green_current_location_icon));
            this.isDestinationReached = true;
        }
    }

    private String getTimeLeftOrDuration(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HH:mm", Locale.ENGLISH);
        try {
            Date parse = simpleDateFormat.parse(this.mDestStnActualArrivalDate + "T" + this.mDestStnActualArrivalTime);
            if (str.equals("origin")) {
                date = simpleDateFormat.parse(this.mOriginStnActualDepartureDate + "T" + this.mOriginStnActualDepartureTime);
            } else if (str.equals("current")) {
                date = simpleDateFormat.parse(this.mCurrentStnActualArrivalDate + "T" + this.mCurrentStnActualArrivalTime);
            } else {
                date = null;
            }
            long abs = Math.abs(parse.getTime() - date.getTime());
            int i2 = (int) (abs / 86400000);
            long j = abs - ((long) (86400000 * i2));
            int i3 = (int) (j / 3600000);
            int i4 = ((int) (j - ((long) (3600000 * i3)))) / 60000;
            if (i2 > 0) {
                return i2 + " day " + i3 + " hour " + i4 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.MINUT;
            }
            return i3 + " hour " + i4 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.MINUT;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    private int calculateProgressRate() {
        int i2 = this.endDistance;
        if (i2 == 0) {
            return 0;
        }
        return (this.currentDistance * 100) / i2;
    }

    private void setPrevAndNextStns() {
        this.isTrainLeftOriginStn = TextUtils.isEmpty(this.mCurrentStnCode) || !this.mCurrentStnCode.equalsIgnoreCase(this.mOriginStnCode);
        if (!this.isTrainLeftOriginStn) {
            this.mNotYetStartedLyt.setVisibility(0);
            this.mAlreadyStartedLyt.setVisibility(8);
            TextView textView = this.mNotYetStartedLytTxt1;
            textView.setText(getResources().getString(R.string.train_ls_yet_to_start_from_origin) + " " + this.mOriginStnName);
            TextView textView2 = this.mNotYetStartedLytTxt2;
            textView2.setText(getResources().getString(R.string.train_ls_expected_departure) + " " + this.mOriginStnActualDepartureTime + ", " + getFormattedDate(this.mOriginStnActualDepartureDate));
        } else if (this.isDestinationReached) {
            this.mTentativeLayout.setVisibility(8);
            this.mNotYetStartedLyt.setVisibility(0);
            this.mAlreadyStartedLyt.setVisibility(8);
            TextView textView3 = this.mNotYetStartedLytTxt1;
            textView3.setText(getResources().getString(R.string.train_ls_reached_train_destination) + " " + this.mDestStnName);
            TextView textView4 = this.mNotYetStartedLytTxt2;
            textView4.setText(getResources().getString(R.string.train_ls_arrived_at) + " " + this.mDestStnActualArrivalTime + ", " + getFormattedDate(this.mDestStnActualArrivalDate));
        } else {
            this.mAlreadyStartedLyt.setVisibility(0);
            this.mNotYetStartedLyt.setVisibility(8);
            if (!TextUtils.isEmpty(this.mPreviousStnName)) {
                this.mPreviousStnNameTxt.setText(this.mPreviousStnName);
                TextView textView5 = this.mPreviousStnDepartureTxt;
                textView5.setText(getResources().getString(R.string.train_ls_actual_departure) + " " + this.mPrevStnActualDepartureTime);
            }
            if (!TextUtils.isEmpty(this.mNextStnName)) {
                this.mNextStnNameTxt.setText(this.mNextStnName);
                TextView textView6 = this.mNextStnDepartureTxt;
                textView6.setText(getResources().getString(R.string.train_ls_expected_arrival) + " " + this.mNextStnExpectedArrivaltime);
            }
        }
    }

    private void setCurrentStationDate() {
        if (!TextUtils.isEmpty(this.mCurrentStnActualArrivalDate)) {
            this.mDateLyt.setVisibility(0);
            this.mView3.setVisibility(0);
            this.mCurrentStnDateTxt.setText(getFormattedDate(this.mCurrentStnActualArrivalDate));
            return;
        }
        this.mDateLyt.setVisibility(8);
        this.mView3.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public String getFormattedDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.setTime(parse);
            int i2 = instance.get(5);
            String displayName = instance.getDisplayName(7, 1, Locale.ENGLISH);
            String displayName2 = instance.getDisplayName(2, 1, Locale.ENGLISH);
            return displayName + ", " + i2 + " " + displayName2;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    private String getFormattedDateForTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.setTime(parse);
            int i2 = instance.get(5);
            int i3 = instance.get(1);
            String displayName = instance.getDisplayName(2, 2, Locale.ENGLISH);
            return i2 + " " + displayName + " " + i3;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    private void showProgressDialog() {
        this.refreshIcon.setVisibility(8);
        this.shareIconImageView.setVisibility(8);
        net.one97.paytm.common.widgets.a.a(this.mLottieAnimView);
    }

    public void removeProgressDialog() {
        this.refreshIcon.setVisibility(0);
        this.shareIconImageView.setVisibility(8);
        net.one97.paytm.common.widgets.a.b(this.mLottieAnimView);
    }

    private void logicToGetStationsData() {
        for (int i2 = 0; i2 < this.mStations.size(); i2++) {
            CJRTrainLSStation cJRTrainLSStation = this.mStations.get(i2);
            if (i2 < this.mStations.size() - 1) {
                int i3 = i2 + 1;
                if (Integer.parseInt(this.mStations.get(i2).getDayCount()) < Integer.parseInt(this.mStations.get(i3).getDayCount())) {
                    this.mStations.get(i3).setIsChanged(true);
                }
            }
            if (i2 == 0) {
                this.mOriginStnName = cJRTrainLSStation.getStationName();
                this.mOriginStnCode = cJRTrainLSStation.getStationCode();
                this.mOriginStnActualDepartureDate = cJRTrainLSStation.getActualDepartureDate();
                this.mOriginStnActualDepartureTime = cJRTrainLSStation.getActualDepartureTime();
            } else if (i2 == this.mStations.size() - 1) {
                this.mDestStnName = cJRTrainLSStation.getStationName();
                this.mDestStnCode = cJRTrainLSStation.getStationCode();
                this.endDistance = Integer.parseInt(cJRTrainLSStation.getDistance());
                this.mDestStnActualArrivalDate = cJRTrainLSStation.getActualArrivalDate();
                this.mDestStnActualArrivalTime = cJRTrainLSStation.getActualArrivalTime();
            }
            if (cJRTrainLSStation.getStationCode() != null && cJRTrainLSStation.getStationCode().equalsIgnoreCase(this.mCurrentStnCode)) {
                this.currentStationIndex = i2;
                this.mCurrentStnName = cJRTrainLSStation.getStationName();
                this.currentDistance = Integer.parseInt(cJRTrainLSStation.getDistance());
                this.mCurrentStnActualArrivalDate = cJRTrainLSStation.getActualArrivalDate();
                this.mCurrentStnActualArrivalTime = cJRTrainLSStation.getActualArrivalTime();
                if (i2 != 0) {
                    CJRTrainLSStation cJRTrainLSStation2 = this.mStations.get(i2 - 1);
                    this.mPreviousStnCode = cJRTrainLSStation2.getStationCode();
                    this.mPreviousStnName = cJRTrainLSStation2.getStationName();
                    this.mPrevStnActualDepartureTime = cJRTrainLSStation2.getActualDepartureTime();
                }
                if (i2 < this.mStations.size() - 1) {
                    CJRTrainLSStation cJRTrainLSStation3 = this.mStations.get(i2 + 1);
                    this.mNextStnCode = cJRTrainLSStation3.getStationCode();
                    this.mNextStnName = cJRTrainLSStation3.getStationName();
                    this.mNextStnExpectedArrivaltime = cJRTrainLSStation3.getActualArrivalTime();
                }
            }
            if (cJRTrainLSStation.getStationCode() != null && cJRTrainLSStation.getStationCode().equalsIgnoreCase(this.mSelectedBoardingPointStnCode)) {
                this.boardingointIndex = i2;
            }
        }
    }

    private void factorTheStationsData(CJRTrainLSModel cJRTrainLSModel) {
        if (cJRTrainLSModel != null && cJRTrainLSModel.getBody() != null) {
            this.mServerTimeIst = cJRTrainLSModel.getBody().getServer_timestamp();
            this.mCurrentStnCode = cJRTrainLSModel.getBody().getCurrent_station();
            this.mTimeOfAvailability = cJRTrainLSModel.getBody().getTime_of_availability();
            this.actionBarDivider.setVisibility(0);
            this.mStations = cJRTrainLSModel.getBody().getStations();
            List<CJRTrainLSStation> list = this.mStations;
            if (list != null && list.size() > 0) {
                logicToGetStationsData();
                setMainLytVisibility(true);
                setDistanceLayout();
                setPrevAndNextStns();
                setCurrentStationDate();
                setRecyclerAdapter();
            }
            if (!TextUtils.isEmpty(cJRTrainLSModel.getBody().getInfoMessage())) {
                initPromotionalViews(cJRTrainLSModel.getBody().getInfoMessage());
            }
        }
    }

    private void setMainLytVisibility(boolean z) {
        if (z) {
            removeProgressDialog();
            this.mEntireLyt.setVisibility(0);
            return;
        }
        this.mEntireLyt.setVisibility(8);
        showProgressDialog();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRTrainLSModel) {
            removeProgressDialog();
            showDisclaimerView();
            factorTheStationsData((CJRTrainLSModel) iJRPaytmDataModel);
            CJRStoreFrontBanners cJRStoreFrontBanners = this.bannersInfo;
            if (cJRStoreFrontBanners != null) {
                showBottomBanner(cJRStoreFrontBanners);
            }
        } else if (iJRPaytmDataModel instanceof CJRStoreFrontBanners) {
            this.bannersInfo = (CJRStoreFrontBanners) iJRPaytmDataModel;
            showBottomBanner(this.bannersInfo);
        }
    }

    private void showDisclaimerView() {
        if (this.showDisclaimer) {
            this.mTentativeLayout.setVisibility(0);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRTrainLiveStatus.this.mTentativeLayout.setVisibility(8);
                }
            }, 5000);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            if (isFinishing()) {
                return;
            }
            if (!(iJRPaytmDataModel instanceof CJRStoreFrontBanners)) {
                removeProgressDialog();
                com.travel.train.model.a aVar = new com.travel.train.model.a();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            aVar = (com.travel.train.model.a) new f().a(new String(networkResponse.data), aVar.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (i2 == 503) {
                    showGenericError(getResources().getString(R.string.train_maintenance_error_title), getResources().getString(R.string.train_maintenance_error_description));
                } else if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    String string = getResources().getString(R.string.error_data_display);
                    String string2 = getResources().getString(R.string.trains_message_error_data_display);
                    if (!TextUtils.isEmpty(networkCustomError.getUrl())) {
                        string2 = string2 + "(" + networkCustomError.getUrl() + ")";
                    }
                    showGenericError(string, string2);
                } else if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                    showGenericError(aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                    showGenericError(getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train));
                } else {
                    showGenericError(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    private void showGenericError(String str, String str2) {
        this.mGenericErrorLayout.setVisibility(0);
        ((RoboTextView) this.mGenericErrorLayout.findViewById(R.id.no_result_label)).setText(str);
        ((TextView) this.mGenericErrorLayout.findViewById(R.id.no_trains_text)).setText(str2);
    }

    private void showBottomBanner(CJRStoreFrontBanners cJRStoreFrontBanners) {
        ArrayList<CJRTrainBannerDetails> arrayList;
        List<CJROfferItems> list;
        List<CJRStoreFrontItem> page = cJRStoreFrontBanners.getPage();
        if (page != null && page.size() != 0 && (arrayList = page.get(0).getmBannerDetails()) != null && arrayList.size() != 0 && (list = arrayList.get(0).getmBannerItems()) != null && list.size() != 0) {
            final CJROfferItems cJROfferItems = list.get(0);
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
            a2.f43753a = cJROfferItems.getmImageUrl();
            a2.m = true;
            b.a.C0750a.a(a2.b(androidx.core.content.b.a((Context) this, R.drawable.homepage_default_icon)).a((Object) androidx.core.content.b.a((Context) this, R.drawable.homepage_default_icon)), this.bannerImageView, (com.paytm.utility.b.b.b) null, 2);
            this.bottomBannerLayout.setVisibility(8);
            ai aiVar = this.mRecylerAdapter;
            if (aiVar != null) {
                aiVar.f26214a.add(new com.travel.train.model.g(cJROfferItems));
                aiVar.notifyDataSetChanged();
                this.mRecylerAdapter.notifyDataSetChanged();
            }
            this.bottomBannerLayout.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRTrainLiveStatus.this.onBannerClick(cJROfferItems, 0);
                }
            });
        }
    }

    public void onBannerClick(CJROfferItems cJROfferItems, int i2) {
        String uRLType = cJROfferItems.getURLType();
        if (TextUtils.isEmpty("native") || uRLType == null || !uRLType.equalsIgnoreCase("native")) {
            String url = cJROfferItems.getURL();
            if (TextUtils.isEmpty(url) || !url.startsWith("paytmmp://")) {
                String uRLType2 = cJROfferItems.getURLType();
                if (uRLType2 != null && !TextUtils.isEmpty(uRLType2) && uRLType2.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED) && url != null && !TextUtils.isEmpty(url)) {
                    loadPage(cJROfferItems.getURLType(), cJROfferItems, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, CLPConstants.GA_CHANNEL_NAME);
                    return;
                }
                return;
            }
            loadPage(cJROfferItems.getURLType(), cJROfferItems, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, "");
            return;
        }
        startTrainBannerActivity(cJROfferItems);
    }

    public void loadPage(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        if (!TextUtils.isEmpty(str)) {
            String str4 = str;
            if (str.equalsIgnoreCase("nolink")) {
                return;
            }
        } else {
            String str5 = str;
        }
        showProgressDialog();
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) this, str, iJRDataModel, str2, i2, arrayList, z, str3);
    }

    private void startTrainBannerActivity(CJROfferItems cJROfferItems) {
        Intent intent = new Intent(this, AJRTrainBannerActivity.class);
        intent.putExtra("TrainCarousel", cJROfferItems);
        startActivityForResult(intent, 100);
    }
}
