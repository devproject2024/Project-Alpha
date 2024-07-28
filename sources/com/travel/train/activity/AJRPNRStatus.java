package com.travel.train.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.j.i;
import com.travel.train.j.l;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.k.g;
import com.travel.train.l.a;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.CJRPNRStatusMeta;
import com.travel.train.model.trainticket.CJRTrainPNRStatus;
import com.travel.train.model.trainticket.h;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRPNRStatus extends CJRTrainBaseActivity implements View.OnClickListener {
    private String LOG_TAG = "AJRPNRStatus";
    private String PNRfrom;
    private String TAG_TRAIN_PNR_STATUS = "TAG_TRAIN_PNR_STATUS";
    private ImageView mBackArrow;
    private int mBaseDayCount;
    private ArrayList<CJRBookings> mBookingList;
    private CJRTrainPNRStatus mCJRTrainPNRStatus;
    private RoboTextView mChartingText;
    private TextView mCheckStatus;
    private RoboTextView mChildFareHintText;
    private RelativeLayout mChildFareInstructionView;
    private RoboTextView mClass;
    private TextView mDestStat;
    private Fragment mEndLessFragment;
    private String mEnteredPNRNumber;
    private long mLastLoadTime;
    private LottieAnimationView mLottieAnimView;
    private String mOrderId;
    private RelativeLayout mParentContainer;
    private RoboTextView mPnrNumberText;
    private RoboTextView mQuota;
    private ImageView mRefreshIcon;
    /* access modifiers changed from: private */
    public RoboTextView mRefreshTxt;
    private ImageView mRouteIconView;
    private RoboTextView mRouteTxt;
    private ScrollView mScrollView;
    private ImageView mShareIcon;
    private TextView mSorceStat;
    private RelativeLayout mStatusInfoContainer;
    private RoboTextView mTextViewArrivalDate;
    private RoboTextView mTextViewArrivalTime;
    private RoboTextView mTextViewDepartureDate;
    private RoboTextView mTextViewDepatureTime;
    private TextView mTextViewTarinNoandName;
    private RoboTextView mTicketStatusInfoTxt;
    private TextView mTotalDay;
    private LinearLayout mTravellerContainer;
    private a mViewModel = null;
    private RoboTextView mViewMoreLayout;
    private h pnrRecentSearchItemModel;
    /* access modifiers changed from: private */
    public Handler refreshHandler;
    private ViewTreeObserver.OnScrollChangedListener scrollListener;
    /* access modifiers changed from: private */
    public int timeCounter = 0;

    private void handleShareClick() {
    }

    static /* synthetic */ int access$008(AJRPNRStatus aJRPNRStatus) {
        int i2 = aJRPNRStatus.timeCounter;
        aJRPNRStatus.timeCounter = i2 + 1;
        return i2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_pnr_status);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().c(false);
        b.a();
        b.b().a("/trains/pnr-status", "Trains", (Context) this);
        getIntentData();
        initUI();
        initMVVM();
        observeViewModel();
        setPNRNumber();
        addStoreFrontFragment();
        initScrollView();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        if (intent.hasExtra("intent_extra_pnr_list")) {
            this.mBookingList = (ArrayList) intent.getSerializableExtra("intent_extra_pnr_list");
        }
        if (intent.hasExtra("pnr_number")) {
            this.mEnteredPNRNumber = intent.getStringExtra("pnr_number");
        }
        if (intent.hasExtra("pnr_item_model")) {
            this.pnrRecentSearchItemModel = (h) intent.getSerializableExtra("pnr_item_model");
        }
        if (intent.getExtras().containsKey("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getExtras().getSerializable("extra_home_data");
            if (!TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
                getDetailsFromURL(cJRHomePageItem.getDeeplink());
            } else if (!TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                getDetailsFromURL(cJRHomePageItem.getURL());
            }
        }
        if (intent.hasExtra("pnr_from_page")) {
            this.PNRfrom = intent.getStringExtra("pnr_from_page");
        }
    }

    private void initMVVM() {
        if (!isFinishing()) {
            this.mViewModel = (a) am.a((FragmentActivity) this, (al.b) new g(new g.a(g.b.PNR_STATUS).a(com.travel.train.a.a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(this))))).a(a.class);
        }
    }

    private void observeViewModel() {
        a aVar = this.mViewModel;
        if (aVar != null) {
            aVar.f27676b.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRPNRStatus.this.showProgressDialog(((Boolean) obj).booleanValue());
                }
            });
            this.mViewModel.f27675a.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRPNRStatus.this.handleAPIResponse((CJRTrainPNRStatus) obj);
                }
            });
            this.mViewModel.f27677c.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRPNRStatus.this.showMaintenanceErrorAlert((NetworkCustomError) obj);
                }
            });
            this.mViewModel.f27678d.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRPNRStatus.this.showParseError((NetworkCustomError) obj);
                }
            });
            this.mViewModel.f27679e.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRPNRStatus.this.showErrorMessageDialog((Pair) obj);
                }
            });
        }
    }

    private void getDetailsFromURL(String str) {
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getQueryParameter("pnr"))) {
            this.mEnteredPNRNumber = parse.getQueryParameter("pnr");
        }
    }

    private void initUI() {
        this.mParentContainer = (RelativeLayout) findViewById(R.id.layout_pnrdetails);
        this.mLottieAnimView = (LottieAnimationView) findViewById(R.id.lottieAnim);
        this.mScrollView = (ScrollView) findViewById(R.id.scroll_view);
        this.mBackArrow = (ImageView) findViewById(R.id.back_arrow);
        this.mShareIcon = (ImageView) findViewById(R.id.share_icon);
        this.mShareIcon.setOnClickListener(this);
        this.mBackArrow.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.mBackArrow.setRotation(180.0f);
        this.mBackArrow.setOnClickListener(this);
        this.mPnrNumberText = (RoboTextView) findViewById(R.id.pnr_status_no);
        this.mCheckStatus = (TextView) findViewById(R.id.check_status_btn);
        this.mCheckStatus.setOnClickListener(this);
        this.mTextViewTarinNoandName = (TextView) findViewById(R.id.txt_trainNameAndNo);
        this.mRouteIconView = (ImageView) findViewById(R.id.iv_route_icon);
        this.mRouteTxt = (RoboTextView) findViewById(R.id.tv_route);
        this.mSorceStat = (TextView) findViewById(R.id.txt_sourceStation);
        this.mDestStat = (TextView) findViewById(R.id.txt_destinationStation);
        this.mTextViewArrivalTime = (RoboTextView) findViewById(R.id.txt_arrivalTime);
        this.mTextViewArrivalDate = (RoboTextView) findViewById(R.id.txt_arrivalDate);
        this.mTextViewDepatureTime = (RoboTextView) findViewById(R.id.txt_departureTime);
        this.mTextViewDepartureDate = (RoboTextView) findViewById(R.id.txt_departureDate);
        this.mTotalDay = (TextView) findViewById(R.id.txt_totalDay);
        this.mClass = (RoboTextView) findViewById(R.id.class_text);
        this.mQuota = (RoboTextView) findViewById(R.id.quota_text);
        this.mTextViewTarinNoandName.setOnClickListener(this);
        this.mRouteIconView.setOnClickListener(this);
        this.mRouteTxt.setOnClickListener(this);
        this.mChartingText = (RoboTextView) findViewById(R.id.tv_chart_title);
        this.mRefreshTxt = (RoboTextView) findViewById(R.id.tv_refresh_text);
        this.mRefreshIcon = (ImageView) findViewById(R.id.iv_refresh_icon);
        this.mTravellerContainer = (LinearLayout) findViewById(R.id.lv_traveller_container);
        this.mRefreshIcon.setOnClickListener(this);
        this.mStatusInfoContainer = (RelativeLayout) findViewById(R.id.rv_ticket_status_info_container);
        this.mTicketStatusInfoTxt = (RoboTextView) findViewById(R.id.tv_status_info_title);
        this.mStatusInfoContainer.setOnClickListener(this);
        this.mChildFareInstructionView = (RelativeLayout) findViewById(R.id.lyt_child_fare_instruction);
        this.mChildFareHintText = (RoboTextView) findViewById(R.id.tv_child_fare_info);
        this.mViewMoreLayout = (RoboTextView) findViewById(R.id.txt_view_more_details);
        this.mViewMoreLayout.setOnClickListener(this);
        this.mParentContainer.setVisibility(8);
        this.refreshHandler = new Handler();
    }

    private void setPNRNumber() {
        if (!TextUtils.isEmpty(this.mEnteredPNRNumber)) {
            this.mPnrNumberText.setText(this.mEnteredPNRNumber);
            callStatusAPI(this.mEnteredPNRNumber);
        }
    }

    private void callStatusAPI(String str) {
        this.mParentContainer.setVisibility(8);
        this.mChildFareInstructionView.setVisibility(8);
        a aVar = this.mViewModel;
        HashMap<String, String> e2 = n.e(getBaseContext());
        HashMap<String, String> d2 = n.d(str);
        k.c(e2, "headers");
        k.c(d2, "urlParams");
        aVar.f27676b.postValue(Boolean.TRUE);
        com.travel.train.a.a aVar2 = aVar.f27680f;
        com.paytm.network.listener.b bVar = aVar;
        aVar2.f(bVar, bVar, e2, d2);
        o.a((Activity) this);
    }

    public void showProgressDialog(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(this.mLottieAnimView);
        } else {
            net.one97.paytm.common.widgets.a.b(this.mLottieAnimView);
        }
    }

    /* access modifiers changed from: private */
    public void handleAPIResponse(CJRTrainPNRStatus cJRTrainPNRStatus) {
        this.mCJRTrainPNRStatus = cJRTrainPNRStatus;
        this.timeCounter = 0;
        updateRefreshTime();
        if (this.mCJRTrainPNRStatus.getPNRStatusDetails() != null && this.mCJRTrainPNRStatus.getPNRStatusDetails().isTipEnabled()) {
            enableTicketStatusGuideLyt(this.mCJRTrainPNRStatus.getPNRStatusDetails().getTipText());
        }
        if (this.mCJRTrainPNRStatus.getPNRStatusDetails() == null || this.mCJRTrainPNRStatus.getPNRStatusDetails().getOrderId() == null || TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getOrderId())) {
            this.mViewMoreLayout.setVisibility(8);
        } else {
            this.mOrderId = this.mCJRTrainPNRStatus.getPNRStatusDetails().getOrderId();
            this.mViewMoreLayout.setVisibility(0);
        }
        displayPnrDetails(this.mCJRTrainPNRStatus);
        if (this.pnrRecentSearchItemModel == null) {
            setPNRRecentSearchDataAfterResponse();
        }
    }

    private void updateRefreshTime() {
        RoboTextView roboTextView = this.mRefreshTxt;
        Resources resources = getResources();
        int i2 = R.string.last_updated_time;
        StringBuilder sb = new StringBuilder();
        sb.append(this.timeCounter);
        roboTextView.setText(resources.getString(i2, new Object[]{sb.toString()}));
        this.refreshHandler.postDelayed(new Runnable() {
            public final void run() {
                AJRPNRStatus.access$008(AJRPNRStatus.this);
                RoboTextView access$100 = AJRPNRStatus.this.mRefreshTxt;
                Resources resources = AJRPNRStatus.this.getResources();
                int i2 = R.string.last_updated_time;
                StringBuilder sb = new StringBuilder();
                sb.append(AJRPNRStatus.this.timeCounter);
                access$100.setText(resources.getString(i2, new Object[]{sb.toString()}));
                AJRPNRStatus.this.refreshHandler.postDelayed(this, 60000);
            }
        }, 60000);
    }

    /* access modifiers changed from: private */
    public void showMaintenanceErrorAlert(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            String string = getResources().getString(R.string.bus_maintenance_error_title);
            String string2 = getResources().getString(R.string.bus_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    AJRPNRStatus.this.startHomePage();
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public void showParseError(NetworkCustomError networkCustomError) {
        com.paytm.utility.b.f((Context) this, networkCustomError.getUrl());
    }

    /* access modifiers changed from: private */
    public void showErrorMessageDialog(Pair<String, String> pair) {
        com.paytm.utility.b.b((Context) this, TextUtils.isEmpty((CharSequence) pair.first) ? getResources().getString(R.string.network_error_heading) : (String) pair.first, TextUtils.isEmpty((CharSequence) pair.second) ? getResources().getString(R.string.network_error_message_train) : (String) pair.second);
    }

    private void setInfantMessage() {
        this.mChildFareHintText.setText(getString(R.string.infant_message_pnr));
        this.mChildFareInstructionView.setVisibility(0);
        CJRTrainPNRStatus cJRTrainPNRStatus = this.mCJRTrainPNRStatus;
        if (cJRTrainPNRStatus != null && cJRTrainPNRStatus.getPNRStatusDetails() != null && !TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getPnrMessage())) {
            this.mChildFareHintText.setText(this.mCJRTrainPNRStatus.getPNRStatusDetails().getPnrMessage());
            this.mChildFareInstructionView.setVisibility(0);
        } else if (com.travel.train.j.g.f27551a != null && com.travel.train.j.g.f27551a.getInfantMessage() != null && !TextUtils.isEmpty(com.travel.train.j.g.f27551a.getInfantMessage())) {
            this.mChildFareHintText.setText(com.travel.train.j.g.f27551a.getInfantMessage());
            this.mChildFareInstructionView.setVisibility(0);
        }
    }

    private void displayPnrDetails(CJRTrainPNRStatus cJRTrainPNRStatus) {
        this.mParentContainer.setVisibility(0);
        if (cJRTrainPNRStatus != null) {
            String str = (cJRTrainPNRStatus.getPNRStatusDetails() == null || TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmDate())) ? "" : cJRTrainPNRStatus.getPNRStatusDetails().getmDate();
            setInfantMessage();
            setTrainNameNumber(cJRTrainPNRStatus);
            setClassQuota(cJRTrainPNRStatus);
            setSourceDetails(cJRTrainPNRStatus, str);
            setDestinationDetails(cJRTrainPNRStatus, str);
            setDuration(cJRTrainPNRStatus);
            setTravellers(cJRTrainPNRStatus);
            setChartPreparedStatusLayout(cJRTrainPNRStatus);
        }
    }

    private void setTravellers(CJRTrainPNRStatus cJRTrainPNRStatus) {
        if (cJRTrainPNRStatus.getPNRStatusDetails().getmPAXInfoList() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmPAXInfoList().size() != 0) {
            this.mTravellerContainer.removeAllViews();
            com.travel.train.b.k kVar = new com.travel.train.b.k(this, cJRTrainPNRStatus.getPNRStatusDetails(), cJRTrainPNRStatus.getmMeta());
            for (int i2 = 0; i2 < kVar.getCount(); i2++) {
                this.mTravellerContainer.addView(kVar.getView(i2, (View) null, (ViewGroup) null));
            }
        }
    }

    private void setDuration(CJRTrainPNRStatus cJRTrainPNRStatus) {
        if (cJRTrainPNRStatus.getPNRStatusDetails() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmDayCount()) && cJRTrainPNRStatus.getPNRStatusDetails().getSourceStation() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDayCount())) {
            this.mTotalDay.setText(i.a(cJRTrainPNRStatus.getPNRStatusDetails().getmDate(), cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDepartureTime(), cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime(), Integer.parseInt(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmDayCount()) - Integer.valueOf(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDayCount()).intValue()));
        }
    }

    private void setDestinationDetails(CJRTrainPNRStatus cJRTrainPNRStatus, String str) {
        if (!(cJRTrainPNRStatus.getPNRStatusDetails() == null || cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo() == null || cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationName() == null || TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationName()))) {
            this.mDestStat.setText(o.a(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationName()) + " - " + cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationCode());
        }
        if (cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime())) {
            int parseInt = Integer.parseInt(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmDayCount()) - this.mBaseDayCount;
            if (parseInt == 0) {
                this.mTextViewDepatureTime.setText(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime());
                this.mTextViewDepartureDate.setText(i.d(str, "yyyy-MM-dd", "EEE, dd MMM"));
            } else if (parseInt > 0) {
                this.mTextViewDepatureTime.setText(cJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmArrivalTime());
                this.mTextViewDepartureDate.setText(o.a(parseInt, str));
            }
        }
    }

    private void setSourceDetails(CJRTrainPNRStatus cJRTrainPNRStatus, String str) {
        if (!(cJRTrainPNRStatus.getPNRStatusDetails() == null || cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation() == null || cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationName() == null || TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationName()))) {
            this.mBaseDayCount = cJRTrainPNRStatus.getPNRStatusDetails().getSourceStation().getDayCount();
            this.mSorceStat.setText(o.a(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationName()) + "-" + cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationCode());
        }
        if (cJRTrainPNRStatus.getPNRStatusDetails() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDepartureTime() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDepartureTime()) && cJRTrainPNRStatus.getPNRStatusDetails().getmDate() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmDate())) {
            this.mTextViewArrivalTime.setText(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDepartureTime());
            this.mTextViewArrivalDate.setText(i.d(calculateBoardingStationTime(Integer.valueOf(cJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmDayCount()).intValue() - this.mBaseDayCount, str), "yyyy-MM-dd", "EEE, dd MMM"));
        }
    }

    private void setClassQuota(CJRTrainPNRStatus cJRTrainPNRStatus) {
        String str;
        if (cJRTrainPNRStatus.getPNRStatusDetails() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmClass())) {
            if (cJRTrainPNRStatus.getmMeta() != null) {
                str = getClazzName(cJRTrainPNRStatus.getmMeta(), cJRTrainPNRStatus.getPNRStatusDetails().getmClass());
            } else {
                str = cJRTrainPNRStatus.getPNRStatusDetails().getmClass();
            }
            this.mClass.setText(str);
        }
        if (cJRTrainPNRStatus.getPNRStatusDetails() != null && cJRTrainPNRStatus.getPNRStatusDetails().getmQuota() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmQuota().trim())) {
            this.mQuota.setText(cJRTrainPNRStatus.getPNRStatusDetails().getmQuota());
        }
    }

    private void setTrainNameNumber(CJRTrainPNRStatus cJRTrainPNRStatus) {
        if (cJRTrainPNRStatus.getPNRStatusDetails() != null && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmTrainName()) && !TextUtils.isEmpty(cJRTrainPNRStatus.getPNRStatusDetails().getmTrainNumber())) {
            TextView textView = this.mTextViewTarinNoandName;
            textView.setText(o.a(cJRTrainPNRStatus.getPNRStatusDetails().getmTrainName()) + " (" + cJRTrainPNRStatus.getPNRStatusDetails().getmTrainNumber() + ")");
        }
    }

    private void savePNRNoInSharedPreferences() {
        boolean z;
        h hVar = new h();
        SharedPreferences.Editor edit = getSharedPreferences("train_home_pnr_no_pref", 0).edit();
        h hVar2 = this.pnrRecentSearchItemModel;
        if (hVar2 != null) {
            if (!TextUtils.isEmpty(hVar2.getPNRNumber())) {
                edit.putString("pnr", this.pnrRecentSearchItemModel.getPNRNumber());
                hVar.setPNRNumber(this.pnrRecentSearchItemModel.getPNRNumber());
            }
            if (!TextUtils.isEmpty(this.pnrRecentSearchItemModel.getFrom())) {
                edit.putString("from_pnr", this.pnrRecentSearchItemModel.getFrom());
                hVar.setFrom(this.pnrRecentSearchItemModel.getFrom());
            }
            if (!TextUtils.isEmpty(this.pnrRecentSearchItemModel.getTo())) {
                edit.putString("to_pnr", this.pnrRecentSearchItemModel.getTo());
                hVar.setTo(this.pnrRecentSearchItemModel.getTo());
            }
            if (!TextUtils.isEmpty(this.pnrRecentSearchItemModel.getDate())) {
                edit.putString("date_pnr", this.pnrRecentSearchItemModel.getDate());
                hVar.setDate(this.pnrRecentSearchItemModel.getDate());
            }
            l a2 = l.a();
            int i2 = 0;
            while (true) {
                if (i2 >= a2.f27576a.size()) {
                    z = false;
                    break;
                } else if (a2.f27576a.get(i2).getPNRNumber().equalsIgnoreCase(hVar.getPNRNumber())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                if (a2.f27576a.size() == 3) {
                    a2.f27576a.remove(2);
                }
                a2.f27576a.add(0, hVar);
            }
            SharedPreferences.Editor edit2 = getSharedPreferences("train_pnr_recent_searched_pref", 0).edit();
            edit2.putString("recentSearchedList", new f().a((Object) a2.f27576a));
            edit2.apply();
            edit.apply();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_view_more_details) {
            o.a("train_pnr", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "view_more_details", "/trains", this, (Map<String, Object>) null);
            launchViewMoreDetailScreen();
        } else if (id == R.id.back_arrow) {
            finish();
        } else if (id == R.id.check_status_btn) {
            o.a("train_pnr", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "action_performed", "/trains", this, (Map<String, Object>) null);
            if (TextUtils.isEmpty(this.PNRfrom)) {
                finish();
            } else if (this.PNRfrom.equalsIgnoreCase("pnr_search")) {
                setResult(-1);
                finish();
            } else if (this.PNRfrom.equalsIgnoreCase("pnr_home")) {
                Intent intent = new Intent(this, AJRPNRSearch.class);
                intent.putExtra("intent_extra_train_upcoming_trips", this.mBookingList);
                startActivity(intent);
                finish();
            }
        } else if (id == R.id.iv_route_icon || id == R.id.tv_route || id == R.id.txt_trainNameAndNo) {
            handleViewRouteClick();
        } else if (id == R.id.share_icon) {
            handleShareClick();
        } else if (id == R.id.rv_ticket_status_info_container) {
            launchTicketStatusInfoScreen();
        } else if (id == R.id.iv_refresh_icon) {
            callStatusAPI(this.mEnteredPNRNumber);
        }
    }

    private void launchViewMoreDetailScreen() {
        Intent a2 = o.a((Context) this);
        a2.putExtra("order_id", this.mOrderId);
        a2.putExtra(UpiConstants.FROM, "Order_history");
        startActivity(a2);
    }

    private void launchTicketStatusInfoScreen() {
        o.a("train_pnr", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "booking_guide_clicked", "/trains/pnr-status", this, (Map<String, Object>) null);
        startActivity(new Intent(this, AJRTrainTicketStatusGuide.class));
    }

    private void handleViewRouteClick() {
        CJRTrainPNRStatus cJRTrainPNRStatus = this.mCJRTrainPNRStatus;
        if (cJRTrainPNRStatus != null && cJRTrainPNRStatus.getPNRStatusDetails() != null) {
            o.a((Activity) this);
            Intent intent = new Intent(this, AJRTrainViewRoute.class);
            intent.putExtra("flag", true);
            intent.putExtra("train_detail", this.mCJRTrainPNRStatus.getPNRStatusDetails());
            startActivity(intent);
        }
    }

    private void setPNRRecentSearchDataAfterResponse() {
        CJRTrainPNRStatus cJRTrainPNRStatus = this.mCJRTrainPNRStatus;
        if (cJRTrainPNRStatus != null && cJRTrainPNRStatus.getPNRStatusDetails() != null) {
            this.pnrRecentSearchItemModel = new h();
            if (!TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmPNRNumber())) {
                this.pnrRecentSearchItemModel.setPNRNumber(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmPNRNumber());
            }
            if (this.mCJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation() != null && !TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationName())) {
                this.pnrRecentSearchItemModel.setFrom(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmBoardingStation().getmStationName());
            }
            if (this.mCJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo() != null && !TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationName())) {
                this.pnrRecentSearchItemModel.setTo(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmReservationUpTo().getmStationName());
            }
            if (!TextUtils.isEmpty(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmDate())) {
                this.pnrRecentSearchItemModel.setDate(this.mCJRTrainPNRStatus.getPNRStatusDetails().getmDate());
            }
            savePNRNoInSharedPreferences();
        }
    }

    private void enableTicketStatusGuideLyt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mStatusInfoContainer.setVisibility(8);
        } else {
            this.mStatusInfoContainer.setVisibility(0);
        }
        this.mTicketStatusInfoTxt.setText(str);
        this.mShareIcon.setVisibility(8);
    }

    public void setChartPreparedStatusLayout(CJRTrainPNRStatus cJRTrainPNRStatus) {
        if (cJRTrainPNRStatus.getPNRStatusDetails().getmChartingStatus() == null) {
            this.mChartingText.setText(R.string.chart_not_prepared);
        } else if (cJRTrainPNRStatus.getPNRStatusDetails().getmChartingStatus().booleanValue()) {
            this.mChartingText.setText(R.string.chart_prepared);
        } else {
            this.mChartingText.setText(R.string.chart_not_prepared);
        }
    }

    private String getClazzName(CJRPNRStatusMeta cJRPNRStatusMeta, String str) {
        String str2 = "";
        if (!(cJRPNRStatusMeta == null || cJRPNRStatusMeta.getmClasses() == null)) {
            for (Map.Entry next : cJRPNRStatusMeta.getmClasses().entrySet()) {
                if (str.equalsIgnoreCase((String) next.getKey())) {
                    str2 = (String) next.getValue();
                }
            }
        }
        return str2;
    }

    private String calculateBoardingStationTime(int i2, String str) {
        if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                long time = simpleDateFormat.parse(str).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                return simpleDateFormat.format(new Date(time));
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void startHomePage() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        b.a();
        b.b().a((Context) this, intent);
    }

    public void onDestroy() {
        this.refreshHandler.removeCallbacksAndMessages((Object) null);
        this.refreshHandler = null;
        removeStoreFrontFragment();
        if (!(this.scrollListener == null || this.mScrollView.getViewTreeObserver() == null || !this.mScrollView.getViewTreeObserver().isAlive())) {
            this.mScrollView.getViewTreeObserver().removeOnScrollChangedListener(this.scrollListener);
        }
        super.onDestroy();
    }

    private void addStoreFrontFragment() {
        if (!isFinishing()) {
            j supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.b();
            this.mEndLessFragment = supportFragmentManager.c(this.TAG_TRAIN_PNR_STATUS);
            Fragment fragment = this.mEndLessFragment;
            if (fragment == null || !fragment.isAdded()) {
                b.a();
                this.mEndLessFragment = b.b().a((WeakReference<View>) new WeakReference(this.mScrollView));
                Bundle bundle = new Bundle();
                bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
                bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                bundle.putString("origin", "train");
                bundle.putString("store_front_url_key", "trainPNRStatusStoreFrontURL");
                this.mEndLessFragment.setArguments(bundle);
                getSupportFragmentManager().a().b(R.id.framelayout_storefront_train_home, this.mEndLessFragment, this.TAG_TRAIN_PNR_STATUS).b();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeStoreFrontFragment() {
        /*
            r2 = this;
            boolean r0 = r2.isFinishing()
            if (r0 != 0) goto L_0x0019
            androidx.fragment.app.j r0 = r2.getSupportFragmentManager()
            java.lang.String r1 = r2.TAG_TRAIN_PNR_STATUS
            androidx.fragment.app.Fragment r1 = r0.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.q r0 = r0.a()
            r0.a((androidx.fragment.app.Fragment) r1)
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRPNRStatus.removeStoreFrontFragment():void");
    }

    private void initScrollView() {
        this.scrollListener = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                AJRPNRStatus.this.lambda$initScrollView$0$AJRPNRStatus();
            }
        };
        this.mScrollView.getViewTreeObserver().addOnScrollChangedListener(this.scrollListener);
        this.mLastLoadTime = System.currentTimeMillis();
    }

    public /* synthetic */ void lambda$initScrollView$0$AJRPNRStatus() {
        ScrollView scrollView = this.mScrollView;
        if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (this.mScrollView.getHeight() + this.mScrollView.getScrollY()) == 0 && this.mEndLessFragment != null && shouldRequestForLoadMore()) {
            b.a();
            b.b().a(this.mEndLessFragment);
        }
    }

    private boolean shouldRequestForLoadMore() {
        if (System.currentTimeMillis() - this.mLastLoadTime <= 1000) {
            return false;
        }
        this.mLastLoadTime = System.currentTimeMillis();
        return true;
    }
}
