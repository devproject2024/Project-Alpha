package com.travel.flight.flightticket.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.d.b;
import com.travel.flight.f.a;
import com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity;
import com.travel.flight.flightticket.activity.AJRAddTravellerActivity;
import com.travel.flight.flightticket.activity.AJRSelectAirportActivity;
import com.travel.flight.flightticket.c.d;
import com.travel.flight.flightticket.f.c;
import com.travel.flight.pojo.CJRBusHolidayList;
import com.travel.flight.pojo.CJRStoreFrontBannersFlight;
import com.travel.flight.pojo.f;
import com.travel.flight.pojo.flightticket.CJRAirportCity;
import com.travel.flight.pojo.flightticket.CJRFareAlertHomeAnalyticsModel;
import com.travel.flight.pojo.flightticket.CJRFlightClientLoginPayload;
import com.travel.flight.pojo.flightticket.flighthomepage.CJRFlightHomepageRequestFilterResponse;
import com.travel.flight.utils.h;
import com.travel.flight.utils.i;
import com.travel.flight.utils.j;
import com.travel.utils.m;
import com.travel.utils.n;
import com.travel.utils.q;
import easypay.manager.Constants;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.visascp.util.TokenStatus;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytmflight.common.entity.shopping.CJRRechargeOrderListFlight;
import org.json.JSONException;
import org.json.JSONObject;

public class FJRFlightTicketFragment extends b implements View.OnClickListener, com.paytm.network.listener.b, com.travel.common.a.b, c {
    private Locale appLocale;
    private int autoSuggestDestinationPos;
    private int autoSuggestOriginPos;
    private String deeplinkString;
    private com.travel.flight.pojo.flightticket.b destRecentCityItem;
    private CJRHomePageItem homePageItem;
    private boolean isClickedFromRecentSearch = false;
    private boolean isDeepLinkDataPopulated = false;
    private boolean isFragmentPaused;
    private boolean isFromRetry;
    private boolean isInternationalFlightFragment = false;
    /* access modifiers changed from: private */
    public boolean isNonstopSelected = false;
    private boolean isPageLoaded = false;
    private boolean isResetAllFields = false;
    private boolean isStoreFrontFragmentAddPending;
    private boolean isTravelOfferFragmentLoaded = false;
    private int mAdults = 1;
    private Animation mAnimMoveLeft;
    private Animation mAnimMoveRight;
    private Animation mAnimationShake;
    private String mCheckInDateWithYear;
    private String mCheckOutDateWithYear;
    private int mChildren = 0;
    private TextView mClassLevelText;
    private String mClassTypevalue;
    private SimpleDateFormat mDateFormat;
    private String mDeepLinkDestination;
    private String mDeepLinkSource;
    private String mDeeplinkFilterAirlineCodes;
    private LinearLayout mDepartDateRelLyt;
    private TextView mDepartOn;
    private TextView mDepartureDateTextview;
    private TextView mDepartureMonthTextview;
    private TextView mDepartureWeekTextview;
    private TextView mDestCityCode;
    private TextView mDestinationCity;
    private RelativeLayout mDestinationCityLyt;
    private TextView mDestinationDateText;
    private String mDestinationIataCode;
    private String mDestinationShortName;
    private RelativeLayout mDetailedDepartureLyt;
    private RelativeLayout mDetailedReturnLyt;
    private TextView mDomesticOneway;
    private TextView mDomesticRoundTrip;
    private TextView mEconomyText;
    private Fragment mEndLessFragment;
    private CJRBusHolidayList mFlightHolidayList;
    /* access modifiers changed from: private */
    public CJRFlightHomepageRequestFilterResponse mFlightOptionResponse;
    private NestedScrollView mHomeScrollView;
    private ImageView mImgExchange;
    private int mInfants = 0;
    /* access modifiers changed from: private */
    public boolean mIsRoundTripSelected;
    /* access modifiers changed from: private */
    public boolean mIsSearchNotInitiated = false;
    private long mLastLoadTime;
    private RelativeLayout mLytProgressBar;
    private ArrayList<CJROrderList> mMyTripOrderList = null;
    private CheckBox mNonStopFlight;
    private TextView mNonStopFlightOptionCBLabel;
    private LinearLayout mNonstopFlightLayout;
    private String mOriginShortName;
    private LinearLayout mPassengerClassDetail;
    private Button mProceedButton;
    private f mRecentSearchData;
    private String mReferral = null;
    private TextView mReturnDate;
    private LinearLayout mReturnDateRelLyt;
    private TextView mReturnDateTextview;
    private TextView mReturnMonthTextview;
    private TextView mReturnOn;
    private TextView mReturnWeekTextview;
    private Animation mRotateAnimation;
    private Animation mRotateAnimationful;
    /* access modifiers changed from: private */
    public CJRFlightHomepageRequestFilterResponse mRoundTripFlightOptionResponse;
    private String mSRPBannerURL = "";
    private TextView mSourceCity;
    private TextView mSourceCityCode;
    private RelativeLayout mSourceCityLyt;
    private TextView mSourceDate;
    private String mSourceIataCode;
    private TextView mTravellersLabel;
    private TextView mTravellersString;
    /* access modifiers changed from: private */
    public CJRFlightHomepageRequestFilterResponse.IJROnward onewaySelectedOption;
    /* access modifiers changed from: private */
    public CJRFlightHomepageRequestFilterResponse.IJROnward roundtripSelectedOption;
    private ViewTreeObserver.OnScrollChangedListener scrollObserver;
    private String searchKeyDestinationSaved;
    private String searchKeyOriginSaved;
    private com.travel.flight.pojo.flightticket.b sourceRecentCityItem;
    private View view;

    public void onEditViewClick(View view2) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        q.c(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("isPageLoaded")) {
            this.isPageLoaded = bundle.getBoolean("isPageLoaded", false);
        }
        this.mClassTypevalue = getResources().getString(R.string.economy_flight);
        this.appLocale = new Locale(n.a());
        if (getArguments() != null && getArguments().containsKey("origin")) {
            this.deeplinkString = getArguments().getString("origin");
        }
        this.mReferral = getReferralString();
        d.a.a.c.a().a((Object) this, false);
        this.isFromRetry = isFromRetry();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (getActivity() instanceof a) {
                getActivity();
            }
            loadEndlessScrollFragmentIfNotAdded();
        }
    }

    private void loadEndlessScrollFragmentIfNotAdded() {
        if (!this.isTravelOfferFragmentLoaded && isResumed() && getUserVisibleHint()) {
            this.isTravelOfferFragmentLoaded = true;
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" - Loaded");
        }
    }

    public void onVisibilityGone() {
        this.isStoreFrontFragmentAddPending = false;
        new Handler().post(new Runnable() {
            public final void run() {
                FJRFlightTicketFragment.this.lambda$onVisibilityGone$0$FJRFlightTicketFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onVisibilityGone$0$FJRFlightTicketFragment() {
        if (this.mEndLessFragment != null && isAdded() && !isDetached()) {
            removeStoreFrontFragment();
        }
    }

    public void onVisibleToUser(boolean z) {
        new Handler().post(new Runnable() {
            public final void run() {
                FJRFlightTicketFragment.this.lambda$onVisibleToUser$1$FJRFlightTicketFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onVisibleToUser$1$FJRFlightTicketFragment() {
        if (!isAdded() || isDetached()) {
            this.isStoreFrontFragmentAddPending = true;
        } else {
            setupStoreFrontFragment();
        }
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        initUI(view2);
        createDefaultFlightOption((CJRFlightHomepageRequestFilterResponse.IJROnward) null);
        updateUIWithApiCall(this.deeplinkString);
        callHolidayAPI();
        if (!this.isFromRetry) {
            setRecentSearch();
        }
        if (this.isStoreFrontFragmentAddPending) {
            setupStoreFrontFragment();
            this.isStoreFrontFragmentAddPending = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) getArguments().getSerializable("extra_home_data");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isFromRetry() {
        /*
            r2 = this;
            android.os.Bundle r0 = r2.getArguments()
            if (r0 == 0) goto L_0x0036
            android.os.Bundle r0 = r2.getArguments()
            java.lang.String r1 = "extra_home_data"
            java.io.Serializable r0 = r0.getSerializable(r1)
            if (r0 == 0) goto L_0x0036
            android.os.Bundle r0 = r2.getArguments()
            java.io.Serializable r0 = r0.getSerializable(r1)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            if (r0 == 0) goto L_0x0036
            java.lang.String r1 = r0.getURL()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0036
            java.lang.String r0 = r0.getURL()
            java.lang.String r1 = "isRetry"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.FJRFlightTicketFragment.isFromRetry():boolean");
    }

    private void setupStoreFrontFragment() {
        if (!this.isPageLoaded) {
            sendCustomPulseEvent("flights_home_page_load", getMapForPrefilledDetails(true));
            this.isPageLoaded = true;
        }
        if (this.isFragmentPaused) {
            return;
        }
        if (isInternationalFlightFragment()) {
            addInternationalFlightStoreFrontFragment();
        } else {
            addStoreFrontFragment();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("isPageLoaded", this.isPageLoaded);
        this.isFragmentPaused = true;
        super.onSaveInstanceState(bundle);
    }

    private void removeStoreFrontFragment() {
        if (!this.isFragmentPaused) {
            getChildFragmentManager().a().a(this.mEndLessFragment).b();
        }
    }

    private boolean isInternationalFlightFragment() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("isInternational") && arguments.getBoolean("isInternational")) {
            this.isInternationalFlightFragment = true;
        }
        return this.isInternationalFlightFragment;
    }

    private void setRecentSearch() {
        if (isRecentSearchAvilable() && !this.isDeepLinkDataPopulated && !this.isResetAllFields) {
            f fVar = com.travel.flight.utils.c.a((Context) getActivity(), "flight_recent_search_details").get(0);
            String str = null;
            if (fVar.isRoundTrip()) {
                String[] split = fVar.getDateDetail().split("-");
                if (split != null && split.length > 1) {
                    getActivity();
                    str = com.paytm.utility.b.d(split[0].trim(), "E, dd MMM yy", "dd MMM yy");
                }
            } else {
                getActivity();
                str = com.paytm.utility.b.d(fVar.getDateDetail(), "E, dd MMM yy", "dd MMM yy");
            }
            if (isValidDate(str)) {
                this.mIsSearchNotInitiated = true;
                setDataToView(fVar);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.pre_f_flight_ticket_home, (ViewGroup) null);
        return this.view;
    }

    private void callHolidayAPI() {
        String str;
        if (getActivity() != null) {
            com.travel.flight.b.a();
            str = com.paytm.utility.b.s(getActivity(), com.travel.flight.b.b().g());
        } else {
            str = "";
        }
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getContext();
                bVar.n = a.b.SILENT;
                bVar.o = FJRFlightTicketFragment.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = str;
                bVar.f42881e = null;
                bVar.f42882f = null;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRBusHolidayList();
                bVar.j = this;
                bVar.t = createDisplayErrorJsonObject();
                bVar.l().a();
            }
        } catch (Exception unused) {
        }
    }

    public void updateUIWithApiCall(String str) {
        this.deeplinkString = str;
        getMytrips();
        if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
            this.homePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
            CJRHomePageItem cJRHomePageItem = this.homePageItem;
            if (cJRHomePageItem != null) {
                if (!TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityShortName()) || !TextUtils.isEmpty(this.homePageItem.getPushDestinationCityShortName())) {
                    this.mDestinationShortName = this.homePageItem.getPushDestinationCityShortName();
                    this.mOriginShortName = this.homePageItem.getPushSourceCityShortName();
                } else {
                    this.mDeepLinkDestination = this.homePageItem.getPushDestinationCityName();
                    this.mDeepLinkSource = this.homePageItem.getPushSourceCityName();
                    onSearchTextChanged(this.homePageItem.getPushSourceCityName());
                    onSearchTextChanged(this.homePageItem.getPushDestinationCityName());
                }
                prefillFlightDetails();
            }
        }
    }

    public void onSearchTextChanged(String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.length() >= 2) {
            com.travel.flight.b.a();
            String str2 = com.travel.flight.b.b().h() + str.trim().replace(" ", "%20");
            if (URLUtil.isValidUrl(str2)) {
                String s = com.paytm.utility.b.s(getContext(), str2);
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getContext()));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getContext().getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = FJRFlightTicketFragment.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = s + appendInternationalParams();
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRAirportCity();
                bVar.j = this;
                com.paytm.network.a l = bVar.l();
                if (com.paytm.utility.b.c(getContext())) {
                    l.a();
                } else {
                    showNetworkDialogNew(l);
                }
            }
        }
    }

    private String appendInternationalParams() {
        return com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN.concat("international=true");
    }

    private JSONObject createDisplayErrorJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightHomeScreen");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void initUI(View view2) {
        try {
            ((LinearLayout) view2.findViewById(R.id.trip_type)).setVisibility(0);
            this.mDateFormat = new SimpleDateFormat("dd MMM yy");
            this.mLytProgressBar = (RelativeLayout) view2.findViewById(R.id.lyt_progress_bar_flight_home);
            com.paytm.utility.b.g((Context) getActivity());
            this.mDomesticOneway = (TextView) view2.findViewById(R.id.radio_domestic_one_way);
            this.mDomesticOneway.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FJRFlightTicketFragment.this.sendTripTypePulseEvent("Oneway");
                    FJRFlightTicketFragment.this.radioOneWayClicked();
                }
            });
            this.mDomesticRoundTrip = (TextView) view2.findViewById(R.id.radio_domestic_round_trip);
            this.mDomesticRoundTrip.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FJRFlightTicketFragment.this.sendTripTypePulseEvent("RoundTrip");
                    FJRFlightTicketFragment.this.radioRoundtripSelected();
                }
            });
            this.mNonstopFlightLayout = (LinearLayout) view2.findViewById(R.id.show_non_stop_flight);
            this.mNonStopFlight = (CheckBox) view2.findViewById(R.id.flight_non_stop_checkbox);
            this.mNonStopFlightOptionCBLabel = (TextView) view2.findViewById(R.id.seat_type_text);
            this.mSourceCity = (TextView) view2.findViewById(R.id.source);
            this.mSourceCityCode = (TextView) view2.findViewById(R.id.source_city_code);
            this.mDestCityCode = (TextView) view2.findViewById(R.id.dest_city_code);
            this.mDepartOn = (TextView) view2.findViewById(R.id.label_depart_on);
            this.mReturnOn = (TextView) view2.findViewById(R.id.label_return_on);
            this.mSourceCityLyt = (RelativeLayout) view2.findViewById(R.id.source_city);
            this.mSourceCityLyt.setOnClickListener(this);
            this.mDestinationCity = (TextView) view2.findViewById(R.id.destination);
            this.mDestinationCityLyt = (RelativeLayout) view2.findViewById(R.id.destination_city);
            this.mDestinationCityLyt.setOnClickListener(this);
            this.mDepartDateRelLyt = (LinearLayout) view2.findViewById(R.id.departure_date_lyt);
            this.mSourceDate = (TextView) view2.findViewById(R.id.source_date);
            this.mDepartDateRelLyt.setOnClickListener(this);
            this.mReturnDateRelLyt = (LinearLayout) view2.findViewById(R.id.return_date_container);
            this.mDetailedDepartureLyt = (RelativeLayout) view2.findViewById(R.id.departure_lyt);
            this.mDetailedReturnLyt = (RelativeLayout) view2.findViewById(R.id.return_lyt);
            this.mDepartureDateTextview = (TextView) view2.findViewById(R.id.departure_date_textview);
            this.mDepartureWeekTextview = (TextView) view2.findViewById(R.id.departure_week_textview);
            this.mDepartureMonthTextview = (TextView) view2.findViewById(R.id.departure_month_textview);
            this.mReturnDateTextview = (TextView) view2.findViewById(R.id.return_date_textview);
            this.mReturnWeekTextview = (TextView) view2.findViewById(R.id.return_week_textview);
            this.mReturnMonthTextview = (TextView) view2.findViewById(R.id.return_month_textview);
            this.mDestinationDateText = (TextView) view2.findViewById(R.id.destination_date);
            this.mEconomyText = (TextView) view2.findViewById(R.id.economy_text);
            this.mClassLevelText = (TextView) view2.findViewById(R.id.label_class);
            this.mClassLevelText.setVisibility(0);
            this.mEconomyText.setText(this.mClassTypevalue);
            this.mPassengerClassDetail = (LinearLayout) view2.findViewById(R.id.no_of_passengers_class_detail);
            this.mPassengerClassDetail.setOnClickListener(this);
            CJRFlightClientLoginPayload.getInstance().setEvent("is_roundtrip", getString(R.string.flight_oneway_text));
            this.mReturnDate = (TextView) view2.findViewById(R.id.return_date);
            this.mReturnDateRelLyt.setOnClickListener(this);
            this.mTravellersString = (TextView) view2.findViewById(R.id.travellers_string);
            this.mTravellersLabel = (TextView) view2.findViewById(R.id.label_travellers);
            this.mTravellersLabel.setVisibility(0);
            this.mTravellersString.setText(createTravellersString(this.mAdults, this.mChildren, this.mInfants));
            if (this.mAdults == 0 || this.mChildren == 0 || this.mInfants == 0) {
                this.mTravellersString.setTextSize(0, this.mTravellersString.getResources().getDimension(R.dimen.flight_spi_14));
            } else {
                this.mTravellersString.setTextSize(0, this.mTravellersString.getResources().getDimension(R.dimen.flight_spi_11));
            }
            this.mAnimationShake = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_f_shake);
            this.mProceedButton = (Button) view2.findViewById(R.id.proceed_btn);
            this.mProceedButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = FJRFlightTicketFragment.this.mIsSearchNotInitiated = false;
                    FJRFlightTicketFragment.this.validateEntries(false);
                }
            });
            this.mRotateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
            this.mRotateAnimation.setRepeatCount(1);
            this.mRotateAnimationful = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate360);
            this.mRotateAnimationful.setRepeatCount(1);
            this.mImgExchange = (ImageView) view2.findViewById(R.id.sep_route);
            initializeViewForDomesticOneWay();
            this.mAnimMoveRight = AnimationUtils.loadAnimation(getActivity(), R.anim.move_right);
            this.mAnimMoveLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.move_left);
            this.mAnimationShake = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_f_shake);
            view2.findViewById(R.id.rel_sep_route).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FJRFlightTicketFragment.this.onExchangePressed();
                }
            });
            this.mCheckOutDateWithYear = getResources().getString(R.string.flight_select_return_date);
            this.mCheckInDateWithYear = this.mSourceDate.getTag().toString();
            if (this.mIsRoundTripSelected) {
                initializeViewForDomesticRoundTrip();
            }
            defaultNonFlightLogic(this.mNonStopFlight, this.mNonstopFlightLayout);
            this.mHomeScrollView = (NestedScrollView) view2.findViewById(R.id.scroll_view_flight_home);
            this.scrollObserver = new ViewTreeObserver.OnScrollChangedListener() {
                public final void onScrollChanged() {
                    FJRFlightTicketFragment.this.lambda$initUI$2$FJRFlightTicketFragment();
                }
            };
            this.mHomeScrollView.getViewTreeObserver().addOnScrollChangedListener(this.scrollObserver);
            this.mLastLoadTime = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void lambda$initUI$2$FJRFlightTicketFragment() {
        NestedScrollView nestedScrollView = this.mHomeScrollView;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.mHomeScrollView.getHeight() + this.mHomeScrollView.getScrollY()) == 0) {
            if (this.mEndLessFragment != null && shouldRequestForLoadMore()) {
                com.travel.flight.b.a();
                com.travel.flight.b.b().a(this.mEndLessFragment);
            }
        } else if (this.mEndLessFragment != null) {
            com.travel.flight.b.a();
            com.travel.flight.b.b().b(this.mEndLessFragment);
        }
    }

    private boolean shouldRequestForLoadMore() {
        if (System.currentTimeMillis() - this.mLastLoadTime <= 1000) {
            return false;
        }
        this.mLastLoadTime = System.currentTimeMillis();
        return true;
    }

    private void setNonFlightFlagFromSharedPreferences() {
        if (com.travel.flight.utils.c.a((Context) getActivity(), this.mIsRoundTripSelected)) {
            boolean b2 = com.travel.flight.utils.c.b((Context) getActivity(), this.mIsRoundTripSelected);
            this.mNonStopFlight.setChecked(b2);
            if (b2) {
                if (this.mIsRoundTripSelected) {
                    createDefaultRoundTripFlightOption();
                } else {
                    createDefaultOnewayFlightOption();
                }
            } else if (this.mIsRoundTripSelected) {
                resetRoundTripFilter();
            } else {
                resetOnewayFilter();
            }
        }
    }

    private void defaultNonFlightLogic(final CheckBox checkBox, View view2) {
        setNonFlightFlagFromSharedPreferences();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = FJRFlightTicketFragment.this.isNonstopSelected = z;
                HashMap hashMap = new HashMap();
                hashMap.put("event_label", z ? "Selected" : TokenStatus.REMOVED);
                FJRFlightTicketFragment.this.sendCustomPulseEvent("show_non_stop_flights_only_checked", hashMap);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FJRFlightTicketFragment.this.mIsRoundTripSelected) {
                    if (FJRFlightTicketFragment.this.mRoundTripFlightOptionResponse == null || FJRFlightTicketFragment.this.mRoundTripFlightOptionResponse.getBody() == null || !FJRFlightTicketFragment.this.mRoundTripFlightOptionResponse.getBody().isNonStopChecked()) {
                        CheckBox checkBox = checkBox;
                        checkBox.setChecked(!checkBox.isChecked());
                        if (checkBox.isChecked()) {
                            FJRFlightTicketFragment.this.createDefaultRoundTripFlightOption();
                        } else {
                            FJRFlightTicketFragment.this.resetRoundTripFilter();
                        }
                    } else {
                        FJRFlightTicketFragment fJRFlightTicketFragment = FJRFlightTicketFragment.this;
                        fJRFlightTicketFragment.showFlightOptionDialog(fJRFlightTicketFragment.mRoundTripFlightOptionResponse, FJRFlightTicketFragment.this.roundtripSelectedOption);
                    }
                } else if (FJRFlightTicketFragment.this.mFlightOptionResponse == null || FJRFlightTicketFragment.this.mFlightOptionResponse.getBody() == null || !FJRFlightTicketFragment.this.mFlightOptionResponse.getBody().isNonStopChecked()) {
                    CheckBox checkBox2 = checkBox;
                    checkBox2.setChecked(!checkBox2.isChecked());
                    if (checkBox.isChecked()) {
                        FJRFlightTicketFragment.this.createDefaultOnewayFlightOption();
                    } else {
                        FJRFlightTicketFragment.this.resetOnewayFilter();
                    }
                } else {
                    FJRFlightTicketFragment fJRFlightTicketFragment2 = FJRFlightTicketFragment.this;
                    fJRFlightTicketFragment2.showFlightOptionDialog(fJRFlightTicketFragment2.mFlightOptionResponse, FJRFlightTicketFragment.this.onewaySelectedOption);
                }
                FragmentActivity activity = FJRFlightTicketFragment.this.getActivity();
                boolean isChecked = checkBox.isChecked();
                boolean access$800 = FJRFlightTicketFragment.this.mIsRoundTripSelected;
                if (activity != null) {
                    i.a(activity.getApplicationContext()).a(access$800 ? "FLIGHT_NON_STOP_CHECK_ROUND_TRIP" : "FLIGHT_NON_STOP_CHECK_ONE_WAY", String.valueOf(isChecked), false);
                }
            }
        });
    }

    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.departure_date_lyt) {
            showProgressDialog(getActivity(), getResources().getString(R.string.pre_f_please_wait_progress_msg));
            this.mIsSearchNotInitiated = false;
            launchDepartCalender();
        } else if (id == R.id.return_date_container) {
            showProgressDialog(getActivity(), getResources().getString(R.string.pre_f_please_wait_progress_msg));
            launchReturnCalender();
        } else if (id == R.id.source_city) {
            launchOriginCityActivity(201, "source");
        } else if (id == R.id.destination_city) {
            launchOriginCityActivity(202, "destination");
        } else if (id == R.id.no_of_passengers_class_detail) {
            launchPassengerDetailsActivity(205, true);
        }
    }

    /* access modifiers changed from: private */
    public void radioRoundtripSelected() {
        this.mIsRoundTripSelected = true;
        this.mDestinationDateText.setText(getString(R.string.flight_select_return_date));
        this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
        this.mDestinationDateText.setVisibility(0);
        this.mDetailedReturnLyt.setVisibility(4);
        setNonFlightFlagFromSharedPreferences();
        flightOnewaySelected(false);
        getFilterFromServer(this.mSourceCity.getText().toString(), this.mDestinationCity.getText().toString(), "roundtrip");
        setRoundTripView();
        this.mNonStopFlight.setClickable(false);
        CJRFlightClientLoginPayload.getInstance().setEvent("is_roundtrip", getString(R.string.flight_oneway_text));
    }

    /* access modifiers changed from: private */
    public void radioOneWayClicked() {
        this.mIsRoundTripSelected = false;
        this.mReturnOn.setVisibility(4);
        this.mDestinationDateText.setText(getString(R.string.select_add_return_date));
        this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_689b9b9b));
        this.mDestinationDateText.setVisibility(0);
        this.mDetailedReturnLyt.setVisibility(4);
        setNonFlightFlagFromSharedPreferences();
        flightOnewaySelected(true);
        getFilterFromServer(this.mSourceCity.getText().toString(), this.mDestinationCity.getText().toString(), "oneway");
        setOneWayView();
        this.mNonStopFlight.setClickable(false);
        CJRFlightClientLoginPayload.getInstance().setEvent("is_roundtrip", getString(R.string.flight_oneway_text));
    }

    private void setExchangeImage() {
        if (!this.mSourceCity.getText().toString().equals(getString(R.string.enter_origin_city)) || !this.mDestinationCity.getText().toString().equals(getString(R.string.enter_destination_city))) {
            if (!this.mIsRoundTripSelected) {
                this.mImgExchange.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
            } else {
                ResourceUtils.loadFlightImagesFromCDN(this.mImgExchange, "rounded_trip_icon.png", false, false, n.a.V1);
            }
        } else if (!this.mIsRoundTripSelected) {
            this.mImgExchange.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(this.mImgExchange, "rounded_trip_icon.png", false, false, n.a.V1);
        }
    }

    /* access modifiers changed from: private */
    public void launchOriginCityActivity(int i2, String str) {
        try {
            if (getActivity() != null) {
                if (str != null) {
                    if (str.equalsIgnoreCase("source")) {
                        this.mSourceIataCode = null;
                    } else if (str.equalsIgnoreCase("destination")) {
                        this.mDestinationIataCode = null;
                    }
                }
                Intent intent = new Intent(getActivity(), AJRSelectAirportActivity.class);
                intent.putExtra("option", str);
                if (this.sourceRecentCityItem != null && !TextUtils.isEmpty(this.sourceRecentCityItem.getCityName())) {
                    intent.putExtra("source", this.sourceRecentCityItem.getCityName());
                }
                if (this.destRecentCityItem != null && !TextUtils.isEmpty(this.destRecentCityItem.getCityName())) {
                    intent.putExtra("destination", this.destRecentCityItem.getCityName());
                }
                if (!TextUtils.isEmpty(this.mSourceIataCode)) {
                    intent.putExtra("source_iata_code", this.mSourceIataCode);
                }
                if (!TextUtils.isEmpty(this.mDestinationIataCode)) {
                    intent.putExtra("dest_iata_code", this.mDestinationIataCode);
                }
                intent.putExtra("isRoundTrip", this.mIsRoundTripSelected);
                getActivity().startActivityForResult(intent, i2);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void launchDepartCalender() {
        String str;
        String str2;
        if (this.mSourceDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_dept_date))) {
            this.mCheckInDateWithYear = getTodaysDate();
        } else {
            this.mCheckInDateWithYear = this.mSourceDate.getText().toString();
            getActivity();
            this.mCheckInDateWithYear = com.paytm.utility.b.d(this.mCheckInDateWithYear, "E, dd MMM yy", "dd MMMM yy");
        }
        if (!this.mIsRoundTripSelected) {
            boolean equalsIgnoreCase = this.mCheckInDateWithYear.equalsIgnoreCase("Depart Date");
        } else {
            String str3 = this.mCheckInDateWithYear;
            if (str3 != null) {
                str3.equalsIgnoreCase(getResources().getString(R.string.select_dept_date));
            }
            String str4 = this.mCheckInDateWithYear;
            if (!(str4 == null || str4.equalsIgnoreCase(getResources().getString(R.string.select_dept_date)) || (str2 = this.mCheckOutDateWithYear) == null)) {
                str2.equalsIgnoreCase(getResources().getString(R.string.flight_select_return_date));
            }
            String str5 = this.mCheckInDateWithYear;
            if (!(str5 == null || str5.equalsIgnoreCase(getResources().getString(R.string.select_dept_date)) || (str = this.mCheckOutDateWithYear) == null)) {
                str.equalsIgnoreCase(getResources().getString(R.string.flight_select_return_date));
            }
        }
        makeCalendarFaresApiCall();
        String a2 = com.travel.flight.flightorder.i.c.a(getActivity());
        String a3 = com.travel.flight.utils.c.a((Context) getActivity());
        if (!this.mIsRoundTripSelected) {
            com.travel.flight.b.a();
            getActivity().startActivityForResult(com.travel.flight.b.b().a((Activity) getActivity(), this.appLocale, this.mCheckInDateWithYear, 0, a2, a3), 1);
            return;
        }
        com.travel.flight.b.a();
        getActivity().startActivityForResult(com.travel.flight.b.b().a((Activity) getActivity(), m.DEPART, this.appLocale, this.mCheckInDateWithYear, 0, this.mCheckOutDateWithYear, a2, a3), 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void makeCalendarFaresApiCall() {
        /*
            r7 = this;
            android.widget.TextView r0 = r7.mSourceCityCode
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x013c
            android.widget.TextView r0 = r7.mDestCityCode
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x013c
        L_0x0022:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x004f }
            java.lang.String r2 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ ParseException -> 0x004f }
            r1.<init>(r2, r3)     // Catch:{ ParseException -> 0x004f }
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ ParseException -> 0x004f }
            java.util.Date r3 = r2.getTime()     // Catch:{ ParseException -> 0x004f }
            java.lang.String r3 = r1.format(r3)     // Catch:{ ParseException -> 0x004f }
            java.util.Date r4 = r1.parse(r3)     // Catch:{ ParseException -> 0x0050 }
            r2.setTime(r4)     // Catch:{ ParseException -> 0x0050 }
            r4 = 5
            r5 = 365(0x16d, float:5.11E-43)
            r2.add(r4, r5)     // Catch:{ ParseException -> 0x0050 }
            java.util.Date r2 = r2.getTime()     // Catch:{ ParseException -> 0x0050 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ ParseException -> 0x0050 }
            goto L_0x0051
        L_0x004f:
            r3 = r0
        L_0x0050:
            r1 = r0
        L_0x0051:
            boolean r2 = r7.mIsRoundTripSelected
            if (r2 != 0) goto L_0x0061
            com.travel.flight.b.a()
            com.travel.flight.c r2 = com.travel.flight.b.b()
            java.lang.String r2 = r2.i()
            goto L_0x006c
        L_0x0061:
            com.travel.flight.b.a()
            com.travel.flight.c r2 = com.travel.flight.b.b()
            java.lang.String r2 = r2.j()
        L_0x006c:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0073
            return
        L_0x0073:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            android.widget.TextView r5 = r7.mSourceCityCode
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "source"
            r4.put(r6, r5)
            android.widget.TextView r5 = r7.mDestCityCode
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "destination"
            r4.put(r6, r5)
            java.lang.String r5 = "start_date"
            r4.put(r5, r3)
            java.lang.String r3 = "end_date"
            r4.put(r3, r1)
            java.lang.String r1 = "opened_from"
            java.lang.String r3 = "homepage"
            r4.put(r1, r3)
            android.widget.TextView r1 = r7.mEconomyText
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d2
            com.travel.flight.utils.j$a r1 = com.travel.flight.utils.j.f25593a
            android.widget.TextView r1 = r7.mEconomyText
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            androidx.fragment.app.FragmentActivity r3 = r7.getActivity()
            java.lang.String r1 = com.travel.flight.utils.j.a.b(r1, r3)
            java.lang.String r3 = "class"
            r4.put(r3, r1)
        L_0x00d2:
            int r1 = r7.mAdults     // Catch:{ Exception -> 0x00de }
            if (r1 <= 0) goto L_0x00df
            java.lang.String r1 = "adults"
            java.lang.String r3 = "1"
            r4.put(r1, r3)     // Catch:{ Exception -> 0x00de }
            goto L_0x00df
        L_0x00de:
        L_0x00df:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x013c
            com.travel.model.CalendarPriceModel r1 = new com.travel.model.CalendarPriceModel
            r1.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            androidx.fragment.app.FragmentActivity r5 = r7.getActivity()
            android.content.Context r5 = r5.getApplicationContext()
            com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r3, (android.content.Context) r5)
            com.paytm.network.b r5 = new com.paytm.network.b
            r5.<init>()
            android.content.Context r6 = r7.getContext()
            r5.f42877a = r6
            com.paytm.network.a$b r6 = com.paytm.network.a.b.SILENT
            r5.n = r6
            java.lang.Class<com.travel.flight.flightticket.fragment.FJRFlightTicketFragment> r6 = com.travel.flight.flightticket.fragment.FJRFlightTicketFragment.class
            java.lang.String r6 = r6.getSimpleName()
            r5.o = r6
            com.paytm.network.a$c r6 = com.paytm.network.a.c.FLIGHT
            r5.f42878b = r6
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET
            r5.f42879c = r6
            r5.f42880d = r2
            r5.f42881e = r0
            r5.f42882f = r3
            r5.f42883g = r4
            r5.f42884h = r0
            r5.f42885i = r1
            com.travel.flight.flightticket.fragment.FJRFlightTicketFragment$9 r0 = new com.travel.flight.flightticket.fragment.FJRFlightTicketFragment$9
            r0.<init>()
            r5.j = r0
            org.json.JSONObject r0 = r7.createDisplayErrorJsonObject()
            r5.t = r0
            com.paytm.network.a r0 = r5.l()
            r1 = 1
            r0.f42860d = r1
            r0.a()
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.FJRFlightTicketFragment.makeCalendarFaresApiCall():void");
    }

    private void launchReturnCalender() {
        String str;
        setRoundTripView();
        if (this.mSourceDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_dept_date))) {
            this.mIsSearchNotInitiated = false;
            launchDepartCalender();
            return;
        }
        String str2 = this.mCheckInDateWithYear;
        if (!(str2 == null || str2.equalsIgnoreCase("Depart Date") || (str = this.mCheckOutDateWithYear) == null || str == null || !str.equalsIgnoreCase(getResources().getString(R.string.flight_select_return_date)))) {
            this.mCheckOutDateWithYear = null;
        }
        makeCalendarFaresApiCall();
        String a2 = com.travel.flight.flightorder.i.c.a(getActivity());
        String a3 = com.travel.flight.utils.c.a((Context) getActivity());
        com.travel.flight.b.a();
        getActivity().startActivityForResult(com.travel.flight.b.b().a((Activity) getActivity(), m.RETURN, this.appLocale, this.mCheckInDateWithYear, 0, this.mCheckOutDateWithYear, a2, a3), 2);
    }

    private void navigateToSearchListActivity(String str, String str2) {
        Intent intent = new Intent(getActivity(), FlightSRPV2Activity.class);
        intent.putExtra("intent_extra_is_round_trip", this.mIsRoundTripSelected);
        if (!this.mIsRoundTripSelected) {
            CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse = this.mFlightOptionResponse;
            if (cJRFlightHomepageRequestFilterResponse != null && cJRFlightHomepageRequestFilterResponse.getBody() != null && this.mFlightOptionResponse.getBody().getOnward() != null) {
                intent.putExtra("one_way_filters", this.mFlightOptionResponse);
                intent.putExtra("one_way_selectyed_filters", this.onewaySelectedOption);
            } else if (this.mNonStopFlight.isChecked()) {
                intent.putExtra("one_way_selectyed_filters", this.roundtripSelectedOption);
            }
        } else {
            intent.putExtra("intent_extra_flight_return_date", getFormatedDate(this.mReturnDate.getTag().toString()));
            intent.putExtra("is_from_home_screen_for_load_more", true);
            CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse2 = this.mRoundTripFlightOptionResponse;
            if (cJRFlightHomepageRequestFilterResponse2 != null && cJRFlightHomepageRequestFilterResponse2.getBody() != null && this.mRoundTripFlightOptionResponse.getBody().getReturnJourny() != null) {
                intent.putExtra("one_way_filters", this.mRoundTripFlightOptionResponse);
                if (this.mNonStopFlight.isChecked()) {
                    intent.putExtra("one_way_selectyed_filters", this.roundtripSelectedOption);
                }
            } else if (this.mNonStopFlight.isChecked()) {
                intent.putExtra("one_way_selectyed_filters", this.roundtripSelectedOption);
            }
        }
        CJRBusHolidayList cJRBusHolidayList = this.mFlightHolidayList;
        if (cJRBusHolidayList != null) {
            intent.putExtra("extra_intent_holiday_list", cJRBusHolidayList);
        }
        if (!TextUtils.isEmpty(this.mEconomyText.getText().toString())) {
            j.a aVar = j.f25593a;
            intent.putExtra("intent_extra_flight_class_type", j.a.b(this.mEconomyText.getText().toString(), getActivity()));
        }
        if (this.mSourceCity.getTag() != null) {
            intent.putExtra("intent_extra_flight_search_from", (com.travel.flight.pojo.flightticket.b) this.mSourceCity.getTag());
        }
        if (this.mDestinationCity.getTag() != null) {
            intent.putExtra("intent_extra_flight_search_to", (com.travel.flight.pojo.flightticket.b) this.mDestinationCity.getTag());
        }
        if (URLUtil.isValidUrl(this.mSRPBannerURL)) {
            intent.putExtra("FlightSRPBannerURL", this.mSRPBannerURL);
        }
        intent.putExtra("intent_extra_flight_search_from_key", this.searchKeyOriginSaved);
        intent.putExtra("intent_extra_flight_search_to_key", this.searchKeyDestinationSaved);
        intent.putExtra("intent_extra_flight_search_from_pos", this.autoSuggestOriginPos);
        intent.putExtra("intent_extra_flight_search_to_pos", this.autoSuggestDestinationPos);
        intent.putExtra("intent_extra_flight_search_date", getFormatedDate(this.mSourceDate.getTag().toString()));
        intent.putExtra("intent_extra_flight_search_no_of_adult_passengers", this.mAdults);
        intent.putExtra("intent_extra_flight_search_no_of_child_passengers", this.mChildren);
        intent.putExtra("intent_extra_flight_search_no_of_infants_passengers", this.mInfants);
        intent.putExtra("intent_extra_flight_destination_city_code", this.mDestCityCode.getText().toString());
        intent.putExtra("intent_extra_flight_source_city_code", this.mSourceCityCode.getText().toString());
        com.travel.flight.pojo.flightticket.b bVar = this.sourceRecentCityItem;
        if (!(bVar == null || this.destRecentCityItem == null)) {
            this.mRecentSearchData.setSourceCityName(bVar.getCityName());
            this.mRecentSearchData.setSourceShortCityName(this.sourceRecentCityItem.getShortCityName());
            this.mRecentSearchData.setSourceCountryName(this.sourceRecentCityItem.getCountryName());
            this.mRecentSearchData.setSourceAirportName(this.sourceRecentCityItem.getAirPortName());
            this.mRecentSearchData.setSourceCountryCode(this.sourceRecentCityItem.getCountryCode());
            this.mRecentSearchData.setDestCityName(this.destRecentCityItem.getCityName());
            this.mRecentSearchData.setDestShortCityName(this.destRecentCityItem.getShortCityName());
            this.mRecentSearchData.setDestCountryName(this.destRecentCityItem.getCountryName());
            this.mRecentSearchData.setDestCountryCode(this.destRecentCityItem.getCountryCode());
            this.mRecentSearchData.setDestAirportName(this.destRecentCityItem.getAirPortName());
            this.mRecentSearchData.setAdult(this.mAdults);
            this.mRecentSearchData.setChild(this.mChildren);
            this.mRecentSearchData.setInfant(this.mInfants);
            this.mRecentSearchData.setTravellerclass(this.mClassTypevalue);
            this.mRecentSearchData.setNonstopSelected(this.isNonstopSelected);
            com.travel.flight.utils.c.a((Context) getActivity(), this.mRecentSearchData);
            com.travel.flight.utils.c.a((Context) getActivity(), this.sourceRecentCityItem, this.destRecentCityItem);
        }
        intent.putExtra("opened_from", this.deeplinkString);
        intent.putExtra("referral", this.mReferral);
        intent.putExtra("nonstop", this.isNonstopSelected);
        CJRBusHolidayList cJRBusHolidayList2 = this.mFlightHolidayList;
        if (cJRBusHolidayList2 != null) {
            intent.putExtra("flight_holiday_list", cJRBusHolidayList2);
        }
        intent.putExtra("flight_source_item", this.sourceRecentCityItem);
        intent.putExtra("flight_dest_detai_item", this.destRecentCityItem);
        if (!TextUtils.isEmpty(this.mSourceIataCode)) {
            intent.putExtra("source_iata_code", this.mSourceIataCode);
        }
        if (!TextUtils.isEmpty(this.mDestinationIataCode)) {
            intent.putExtra("dest_iata_code", this.mDestinationIataCode);
        }
        intent.addFlags(67239936);
        if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
            intent.putExtra("intent_extra_airline_codes", this.mDeeplinkFilterAirlineCodes);
        }
        intent.putExtra("booking_segment", com.travel.flight.flightticket.d.b.Regular);
        sendCustomPulseEvent("search_flights_clicked", getMapForPrefilledDetails(false));
        getActivity().startActivityForResult(intent, Constants.EASY_PAY_MAXIMIZE_ASSIST);
    }

    private String getTodaysDate() {
        return this.mDateFormat.format(Calendar.getInstance().getTime());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, intent);
        if (i3 == -1) {
            if (i2 == 1) {
                if (intent != null && intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
                    String stringExtra = intent.getStringExtra("intent_extra_selected_depart_date");
                    setCheckInLyt(stringExtra, false);
                    String stringExtra2 = intent.getStringExtra("intent_extra_selected_return_date");
                    setCheckOutLyt(stringExtra2, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("departureDate", stringExtra);
                    CJRFlightClientLoginPayload.getInstance().setEvent("returnDate", stringExtra2);
                } else if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
                    String stringExtra3 = intent.getStringExtra("intent_extra_selected_depart_date");
                    setCheckInLyt(stringExtra3, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("departureDate", stringExtra3);
                } else if (intent != null && intent.hasExtra("intent_extra_selected_return_date")) {
                    String stringExtra4 = intent.getStringExtra("intent_extra_selected_return_date");
                    setCheckOutLyt(stringExtra4, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("returnDate", stringExtra4);
                }
                if (intent != null && this.isClickedFromRecentSearch) {
                    this.isClickedFromRecentSearch = false;
                    this.mIsSearchNotInitiated = false;
                    validateEntries(false);
                }
            } else if (i2 == 2) {
                if (intent != null && intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
                    String stringExtra5 = intent.getStringExtra("intent_extra_selected_depart_date");
                    setCheckInLyt(stringExtra5, false);
                    String stringExtra6 = intent.getStringExtra("intent_extra_selected_return_date");
                    setCheckOutLyt(stringExtra6, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("departureDate", stringExtra5);
                    CJRFlightClientLoginPayload.getInstance().setEvent("returnDate", stringExtra6);
                } else if (intent != null && intent.hasExtra("intent_extra_selected_return_date")) {
                    String stringExtra7 = intent.getStringExtra("intent_extra_selected_return_date");
                    setCheckOutLyt(stringExtra7, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("departureDate", stringExtra7);
                } else if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
                    String stringExtra8 = intent.getStringExtra("intent_extra_selected_depart_date");
                    setCheckInLyt(stringExtra8, false);
                    CJRFlightClientLoginPayload.getInstance().setEvent("departureDate", stringExtra8);
                }
                if (intent != null && this.isClickedFromRecentSearch) {
                    this.isClickedFromRecentSearch = false;
                    validateEntries(false);
                }
            } else if (i2 != 204) {
                if (i2 != 205) {
                    if (i2 != 222) {
                        switch (i2) {
                            case 200:
                                if (intent != null && intent.hasExtra("intent_extra_selected_journey_date")) {
                                    String stringExtra9 = intent.getStringExtra("intent_extra_selected_journey_date");
                                    intent.getStringExtra("date_value");
                                    this.mCheckInDateWithYear = stringExtra9;
                                    this.mSourceDate.setText(stringExtra9);
                                    getContext();
                                    String d2 = com.paytm.utility.b.d(stringExtra9, "EEE, dd MMM yy", "dd MMMM EEEE");
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("event_label", d2);
                                    sendCustomPulseEvent("from_selected", hashMap);
                                    setFlightJourneyDates(this.mDepartureDateTextview, this.mDepartureWeekTextview, this.mDepartureMonthTextview, d2);
                                    this.mDepartOn.setVisibility(0);
                                    this.mSourceDate.setVisibility(8);
                                    this.mDetailedDepartureLyt.setVisibility(0);
                                    return;
                                }
                                return;
                            case 201:
                                if (intent != null && intent.getBooleanExtra("is_recent_search_selected", false)) {
                                    sendCustomPulseEvent("recent_searches_list_clicked", (HashMap<String, Object>) null);
                                    setSourceAndDestination((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_source_recent_search_selected"), (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_dest_recent_search_selected"), intent.getBooleanExtra("INTENT_EXTRA_FLIGHT_SEARCH_IS_ROUND_TRIP", false));
                                } else if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
                                    com.travel.flight.pojo.flightticket.b bVar = (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("intent_extra_selected_city_name");
                                    this.autoSuggestOriginPos = intent.getIntExtra("intent_extra_selected_city_position", 1);
                                    this.searchKeyOriginSaved = intent.getStringExtra("search_key");
                                    if (!(bVar == null || bVar.getCityName() == null)) {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("event_label", bVar.getCityName());
                                        sendCustomPulseEvent("from_selected", hashMap2);
                                        setSourceCity(bVar);
                                        setExchangeImage();
                                    }
                                }
                                if (intent == null || !intent.hasExtra("source_iata_code")) {
                                    this.mSourceIataCode = null;
                                } else {
                                    this.mSourceIataCode = intent.getStringExtra("source_iata_code");
                                }
                                if (this.mDestinationCity.getText().toString().equals(getResources().getString(R.string.enter_destination_city)) && !this.mSourceCityCode.getText().toString().equalsIgnoreCase(UpiConstants.FROM)) {
                                    new Handler().post(new Runnable() {
                                        public final void run() {
                                            FJRFlightTicketFragment.this.launchOriginCityActivity(202, "destination");
                                        }
                                    });
                                    return;
                                }
                                return;
                            case 202:
                                if (intent != null && intent.getBooleanExtra("is_recent_search_selected", false)) {
                                    sendCustomPulseEvent("recent_searches_list_clicked", (HashMap<String, Object>) null);
                                    setSourceAndDestination((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_source_recent_search_selected"), (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_dest_recent_search_selected"), intent.getBooleanExtra("INTENT_EXTRA_FLIGHT_SEARCH_IS_ROUND_TRIP", false));
                                } else if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
                                    com.travel.flight.pojo.flightticket.b bVar2 = (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("intent_extra_selected_city_name");
                                    this.autoSuggestDestinationPos = intent.getIntExtra("intent_extra_selected_city_position", 1);
                                    this.searchKeyDestinationSaved = intent.getStringExtra("search_key");
                                    if (!(bVar2 == null || bVar2.getCityName() == null)) {
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("event_label", bVar2.getCityName());
                                        sendCustomPulseEvent("to_selected", hashMap3);
                                        setDestinationCity(bVar2);
                                        setExchangeImage();
                                    }
                                }
                                if (intent == null || !intent.hasExtra("dest_iata_code")) {
                                    this.mDestinationIataCode = null;
                                } else {
                                    this.mDestinationIataCode = intent.getStringExtra("dest_iata_code");
                                }
                                if (this.mSourceCity.getText().toString().equalsIgnoreCase(getResources().getString(R.string.enter_origin_city)) && !this.mDestCityCode.getText().toString().equalsIgnoreCase("To")) {
                                    new Handler().post(new Runnable() {
                                        public final void run() {
                                            FJRFlightTicketFragment.this.launchOriginCityActivity(201, "source");
                                        }
                                    });
                                }
                                if (this.mSourceDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_dept_date)) && !this.mDestCityCode.getText().toString().equalsIgnoreCase("To")) {
                                    new Handler().postDelayed(new Runnable() {
                                        public final void run() {
                                            if (FJRFlightTicketFragment.this.getActivity() != null && FJRFlightTicketFragment.this.isAdded()) {
                                                FJRFlightTicketFragment fJRFlightTicketFragment = FJRFlightTicketFragment.this;
                                                fJRFlightTicketFragment.showProgressDialog(fJRFlightTicketFragment.getActivity(), FJRFlightTicketFragment.this.getResources().getString(R.string.pre_f_please_wait_progress_msg));
                                                boolean unused = FJRFlightTicketFragment.this.mIsSearchNotInitiated = false;
                                                FJRFlightTicketFragment.this.launchDepartCalender();
                                            }
                                        }
                                    }, 200);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else if (intent != null && intent.hasExtra("deeplink_filter_airlines_clear") && intent.getBooleanExtra("deeplink_filter_airlines_clear", false)) {
                        this.mDeeplinkFilterAirlineCodes = null;
                    }
                } else if (intent != null) {
                    this.mAdults = Integer.parseInt(intent.getStringExtra("intent_extra_adult_passenger"));
                    this.mChildren = Integer.parseInt(intent.getStringExtra("intent_extra_children_passenger"));
                    this.mInfants = Integer.parseInt(intent.getStringExtra("intent_extra_infant_passenger"));
                    this.mClassTypevalue = intent.getStringExtra("intent_extra_trip_type");
                    this.mTravellersLabel.setVisibility(0);
                    this.mTravellersString.setText(createTravellersString(this.mAdults, this.mChildren, this.mInfants));
                    if (this.mAdults == 0 || this.mChildren == 0 || this.mInfants == 0) {
                        TextView textView = this.mTravellersString;
                        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.flight_spi_14));
                    } else {
                        TextView textView2 = this.mTravellersString;
                        textView2.setTextSize(0, textView2.getResources().getDimension(R.dimen.flight_spi_11));
                    }
                    this.mClassLevelText.setVisibility(0);
                    this.mEconomyText.setText(this.mClassTypevalue);
                }
            } else if (intent != null && intent.hasExtra("intent_extra_selected_journey_date")) {
                String stringExtra10 = intent.getStringExtra("intent_extra_selected_journey_date");
                "--------------------".concat(String.valueOf(stringExtra10));
                com.paytm.utility.b.j();
                this.mReturnDate.setText(stringExtra10);
                getContext();
                setFlightJourneyDates(this.mReturnDateTextview, this.mReturnWeekTextview, this.mReturnMonthTextview, com.paytm.utility.b.d(stringExtra10, "EEE, dd MMM yy", "dd MMMM EEEE"));
                this.mReturnOn.setVisibility(0);
                this.mDestinationDateText.setVisibility(8);
                this.mDetailedReturnLyt.setVisibility(0);
            }
        }
    }

    private void setFlightJourneyDates(TextView textView, TextView textView2, TextView textView3, String str) {
        if (textView != null && textView2 != null && textView3 != null && str != null) {
            String[] split = str.split(" ");
            if (split.length >= 3) {
                if (!TextUtils.isEmpty(split[0])) {
                    getActivity();
                    textView.setText(com.travel.flight.utils.c.a(split[0], "dd", "dd"));
                }
                textView3.setText(split[1]);
                textView2.setText(split[2]);
            }
        }
    }

    private void setCheckOutLyt(String str, boolean z) {
        TextView textView = this.mReturnDate;
        getActivity();
        textView.setTag(com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM yy"));
        TextView textView2 = this.mReturnDate;
        getActivity();
        textView2.setText(com.paytm.utility.b.d(str, "dd MMM yy", "E, dd MMM yy"));
        getContext();
        setFlightJourneyDates(this.mReturnDateTextview, this.mReturnWeekTextview, this.mReturnMonthTextview, com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM EEEE"));
        this.mReturnOn.setVisibility(0);
        this.mDestinationDateText.setVisibility(8);
        this.mDetailedReturnLyt.setVisibility(0);
        this.mCheckOutDateWithYear = str;
        this.mHomeScrollView.a(this.mReturnDate.getBottom(), false);
    }

    private String createTravellersString(int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        if (i2 > 1) {
            sb.append(i2 + " " + getResources().getString(R.string.adults));
        } else if (i2 == 1) {
            sb.append(i2 + " " + getResources().getString(R.string.adult));
        }
        if (i3 > 1) {
            sb.append(", " + i3 + " " + getResources().getString(R.string.childrens));
        } else if (i3 == 1) {
            sb.append(", " + i3 + " " + getResources().getString(R.string.child));
        }
        if (i4 > 1) {
            if (i2 == 0 || i3 == 0 || i4 == 0) {
                sb.append(", " + i4 + " " + getResources().getString(R.string.infants));
            } else {
                sb.append(", \n" + i4 + " " + getResources().getString(R.string.infants));
            }
        } else if (i4 == 1) {
            if (i2 == 0 || i3 == 0 || i4 == 0) {
                sb.append(", " + i4 + " " + getResources().getString(R.string.infant));
            } else {
                sb.append(", \n" + i4 + " " + getResources().getString(R.string.infant));
            }
        }
        return sb.toString();
    }

    private void setCheckInLyt(String str, boolean z) {
        resetCheckOutDate();
        TextView textView = this.mSourceDate;
        getActivity();
        textView.setTag(com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM yy"));
        TextView textView2 = this.mSourceDate;
        getActivity();
        textView2.setText(com.paytm.utility.b.d(str, "dd MMM yy", "E, dd MMM yy"));
        getContext();
        setFlightJourneyDates(this.mDepartureDateTextview, this.mDepartureWeekTextview, this.mDepartureMonthTextview, com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM EEEE"));
        getActivity();
        com.paytm.utility.b.a(this.mSourceDate);
        this.mDepartOn.setVisibility(0);
        this.mSourceDate.setVisibility(8);
        this.mDetailedDepartureLyt.setVisibility(0);
        this.mCheckInDateWithYear = str;
        this.mHomeScrollView.a(this.mSourceDate.getBottom(), false);
    }

    private void resetCheckOutDate() {
        try {
            if (!this.mReturnDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.flight_select_return_date))) {
                this.mReturnDate.setText(getResources().getString(R.string.flight_select_return_date));
                this.mDestinationDateText.setText(getResources().getString(R.string.flight_select_return_date));
                this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
                this.mReturnOn.setVisibility(4);
                this.mDestinationDateText.setVisibility(0);
                this.mDetailedReturnLyt.setVisibility(4);
                this.mCheckOutDateWithYear = getResources().getString(R.string.flight_select_return_date);
            }
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    public void onResume() {
        super.onResume();
        this.isFragmentPaused = false;
        q.c(getActivity());
        removeProgressDialog();
        if (this.mIsRoundTripSelected) {
            initializeViewForDomesticRoundTrip();
        }
        loadEndlessScrollFragmentIfNotAdded();
    }

    /* access modifiers changed from: private */
    public void validateEntries(boolean z) {
        Class<FJRFlightTicketFragment> cls = FJRFlightTicketFragment.class;
        this.mRecentSearchData = new f();
        String charSequence = this.mSourceCity.getText().toString();
        String charSequence2 = this.mDestinationCity.getText().toString();
        String charSequence3 = this.mEconomyText.getText().toString();
        String string = this.mSourceCity.getContext().getResources().getString(R.string.economy_flight);
        String string2 = this.mSourceCity.getContext().getResources().getString(R.string.premium_economy);
        String string3 = this.mSourceCity.getContext().getResources().getString(R.string.business);
        Resources resources = this.mSourceCity.getContext().getResources();
        if (charSequence.equalsIgnoreCase(resources.getString(R.string.enter_origin_city))) {
            this.mSourceCityCode.startAnimation(this.mAnimationShake);
            if (!this.isFromRetry) {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_origin));
            }
            this.isFromRetry = false;
        } else if (!string.equalsIgnoreCase(charSequence3) && !string2.equalsIgnoreCase(charSequence3) && !string3.equalsIgnoreCase(charSequence3)) {
            if (!this.isFromRetry) {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_class));
            }
            this.isFromRetry = false;
        } else if (charSequence2.equalsIgnoreCase(resources.getString(R.string.enter_destination_city))) {
            this.mDestCityCode.startAnimation(this.mAnimationShake);
            if (!this.isFromRetry) {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_destination));
            }
            this.isFromRetry = false;
        } else if (charSequence.equalsIgnoreCase(charSequence2)) {
            if (!this.isFromRetry) {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.passenger_same_city_header), String.format(resources.getString(R.string.flight_msg_source_destination_same), new Object[]{charSequence, charSequence}));
            }
            this.isFromRetry = false;
        } else if (this.mSourceDate.getText().toString().equalsIgnoreCase(resources.getString(R.string.select_dept_date))) {
            if (!this.isFromRetry) {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_date));
            }
            this.isFromRetry = false;
        } else if (TextUtils.isEmpty(this.mSourceDate.getText().toString())) {
            com.paytm.utility.b.a((Activity) getActivity(), cls.getName());
        } else {
            this.mRecentSearchData.setDateDetail(this.mSourceDate.getText().toString());
            if (this.mIsRoundTripSelected) {
                if (this.mReturnDate.getText().toString().equalsIgnoreCase(resources.getString(R.string.flight_select_return_date))) {
                    if (!this.isFromRetry) {
                        com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_return_date));
                    }
                    this.isFromRetry = false;
                    return;
                } else if (TextUtils.isEmpty(this.mReturnDate.getText().toString())) {
                    com.paytm.utility.b.a((Activity) getActivity(), cls.getName());
                    return;
                } else {
                    this.mRecentSearchData.setRoundTrip(true);
                    f fVar = this.mRecentSearchData;
                    fVar.setDateDetail(this.mSourceDate.getText().toString() + " - " + this.mReturnDate.getText().toString());
                }
            }
            if (this.mTravellersString.getText().equals(resources.getString(R.string.travellers))) {
                if (!this.isFromRetry) {
                    com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.special_characters_title), resources.getString(R.string.msg_invalid_traveller_class));
                }
                this.isFromRetry = false;
                return;
            }
            this.mRecentSearchData.setTravellerDetails(this.mTravellersString.getText().toString());
            if (this.mIsSearchNotInitiated) {
                return;
            }
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                showNoNetworkDialog();
            } else if (!z) {
                navigateToSearchListActivity(charSequence, charSequence2);
            }
        }
    }

    private void showNoNetworkDialog() {
        if (getActivity() != null && !isDetached()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = FJRFlightTicketFragment.this.mIsSearchNotInitiated = false;
                    FJRFlightTicketFragment.this.validateEntries(false);
                }
            });
            builder.show();
        }
    }

    private String getFormatedDate(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.trim().length() <= 0) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new SimpleDateFormat("dd MMM yy", this.appLocale).parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    public void initializeViewForDomesticOneWay() {
        Resources resources = getResources();
        if (this.mDomesticOneway != null) {
            this.mIsRoundTripSelected = false;
            flightOnewaySelected(true);
        }
        setExchangeImage();
        TextView textView = this.mSourceDate;
        if (textView == null) {
            return;
        }
        if (textView.getText().toString().equalsIgnoreCase(resources.getString(R.string.select_dept_date))) {
            TextView textView2 = this.mDepartOn;
            if (textView2 != null && this.mSourceDate != null && this.mDetailedDepartureLyt != null) {
                textView2.setVisibility(4);
                this.mSourceDate.setVisibility(0);
                this.mDetailedDepartureLyt.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView3 = this.mDepartOn;
        if (textView3 != null && this.mSourceDate != null && this.mDetailedDepartureLyt != null) {
            textView3.setVisibility(0);
            this.mSourceDate.setVisibility(8);
            this.mDetailedDepartureLyt.setVisibility(0);
        }
    }

    public void initializeViewForDomesticRoundTrip() {
        Resources resources = getResources();
        com.paytm.utility.b.j();
        this.mIsRoundTripSelected = true;
        flightOnewaySelected(false);
        setExchangeImage();
        if (this.mReturnDate.getText().toString().equalsIgnoreCase(resources.getString(R.string.flight_select_return_date))) {
            TextView textView = this.mReturnOn;
            if (textView != null && this.mDestinationDateText != null && this.mDetailedReturnLyt != null) {
                textView.setVisibility(4);
                this.mDestinationDateText.setVisibility(0);
                this.mDetailedReturnLyt.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.mReturnOn;
        if (textView2 != null && this.mDestinationDateText != null && this.mDetailedReturnLyt != null) {
            textView2.setVisibility(0);
            this.mDestinationDateText.setVisibility(8);
            this.mDetailedReturnLyt.setVisibility(0);
        }
    }

    private void launchPassengerDetailsActivity(int i2, boolean z) {
        try {
            if (getActivity() != null) {
                Intent intent = new Intent(getActivity(), AJRAddTravellerActivity.class);
                intent.putExtra("intent_extra_flight_search_no_of_adult_passengers", this.mAdults);
                intent.putExtra("intent_extra_flight_search_no_of_child_passengers", this.mChildren);
                intent.putExtra("intent_extra_flight_search_no_of_infants_passengers", this.mInfants);
                intent.putExtra("intent_extra_trip_type", this.mClassTypevalue);
                intent.putExtra("screen_type", z);
                getActivity().startActivityForResult(intent, i2);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void onExchangePressed() {
        String charSequence = this.mSourceCity.getText().toString();
        String charSequence2 = this.mDestinationCity.getText().toString();
        String charSequence3 = this.mSourceCityCode.getText().toString();
        String charSequence4 = this.mDestCityCode.getText().toString();
        com.travel.flight.pojo.flightticket.b bVar = this.sourceRecentCityItem;
        this.sourceRecentCityItem = this.destRecentCityItem;
        this.destRecentCityItem = bVar;
        String str = this.mSourceIataCode;
        String str2 = this.mDestinationIataCode;
        Object tag = this.mSourceCity.getTag();
        Object tag2 = this.mDestinationCity.getTag();
        if (!charSequence.equalsIgnoreCase(getResources().getString(R.string.enter_origin_city)) && !charSequence2.equalsIgnoreCase(getResources().getString(R.string.enter_destination_city))) {
            this.mSourceCity.setText(charSequence2);
            this.mDestinationCity.setText(charSequence);
            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mSourceCityCode.setText(charSequence4);
            this.mDestCityCode.setText(charSequence3);
            this.mSourceCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            this.mDestCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            TextView textView = this.mSourceCityCode;
            textView.setTypeface(textView.getTypeface(), 1);
            TextView textView2 = this.mDestCityCode;
            textView2.setTypeface(textView2.getTypeface(), 1);
            this.mSourceCity.setTag(tag2);
            this.mDestinationCity.setTag(tag);
            this.mSourceCity.startAnimation(this.mAnimMoveLeft);
            this.mSourceCityCode.startAnimation(this.mAnimMoveLeft);
            this.mDestinationCity.startAnimation(this.mAnimMoveRight);
            this.mDestCityCode.startAnimation(this.mAnimMoveRight);
            this.mImgExchange.startAnimation(this.mRotateAnimationful);
            this.mRotateAnimation.setFillAfter(true);
            this.mSourceIataCode = str2;
            this.mDestinationIataCode = str;
            sendCustomPulseEvent("swap_arrow_clicked", (HashMap<String, Object>) null);
        }
    }

    private void prefillFlightDetails() {
        CJRHomePageItem cJRHomePageItem;
        boolean z;
        boolean z2;
        try {
            this.isResetAllFields = false;
            if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem) && (cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data")) != null) {
                if (cJRHomePageItem.getURLType() == null || cJRHomePageItem.getURLType().equalsIgnoreCase("flightticket")) {
                    this.mReferral = cJRHomePageItem.getmFlightReferral();
                    Uri parse = Uri.parse(cJRHomePageItem.getURL());
                    if (!TextUtils.isEmpty(parse.getQueryParameter("airline_code"))) {
                        this.mDeeplinkFilterAirlineCodes = parse.getQueryParameter("airline_code");
                    }
                    if (TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityName()) || TextUtils.isEmpty(this.mOriginShortName)) {
                        if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                            this.mSourceCity.setTextColor(getResources().getColor(R.color.flight_tab_divider_color));
                            this.isResetAllFields = true;
                            com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
                            bVar.setCityName(this.mSourceCity.getResources().getString(R.string.enter_origin_city));
                            bVar.setShortCityName(this.mSourceCity.getResources().getString(R.string.enter_origin));
                            setSourceCity(bVar);
                        }
                        z2 = true;
                        z = false;
                    } else {
                        com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
                        bVar2.setCityName(cJRHomePageItem.getPushSourceCityName());
                        if (!TextUtils.isEmpty(this.mOriginShortName)) {
                            bVar2.setShortCityName(this.mOriginShortName);
                        }
                        setSourceCity(bVar2);
                        z2 = false;
                        z = true;
                    }
                    if (TextUtils.isEmpty(cJRHomePageItem.getPushDestinationCityName()) || TextUtils.isEmpty(this.mDestinationShortName)) {
                        if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                            this.isResetAllFields = true;
                            com.travel.flight.pojo.flightticket.b bVar3 = new com.travel.flight.pojo.flightticket.b();
                            this.mDestinationCity.setTextColor(getResources().getColor(R.color.flight_tab_divider_color));
                            bVar3.setCityName(this.mDestinationCity.getResources().getString(R.string.enter_destination_city));
                            bVar3.setShortCityName(this.mDestinationCity.getResources().getString(R.string.enter_destination));
                            setDestinationCity(bVar3);
                        }
                        z = false;
                    } else {
                        com.travel.flight.pojo.flightticket.b bVar4 = new com.travel.flight.pojo.flightticket.b();
                        bVar4.setCityName(cJRHomePageItem.getPushDestinationCityName());
                        if (!TextUtils.isEmpty(this.mDestinationShortName)) {
                            bVar4.setShortCityName(this.mDestinationShortName);
                        }
                        setDestinationCity(bVar4);
                        z2 = false;
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("adults"))) {
                        this.mAdults = Integer.parseInt(parse.getQueryParameter("adults"));
                        z2 = false;
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("children"))) {
                        this.mChildren = Integer.parseInt(parse.getQueryParameter("children"));
                        z2 = false;
                    }
                    if (!TextUtils.isEmpty(parse.getQueryParameter("infants"))) {
                        this.mInfants = Integer.parseInt(parse.getQueryParameter("infants"));
                        z2 = false;
                    }
                    this.mTravellersString.setText(createTravellersString(this.mAdults, this.mChildren, this.mInfants));
                    boolean equalsIgnoreCase = !TextUtils.isEmpty(parse.getQueryParameter("isShare")) ? "false".equalsIgnoreCase(parse.getQueryParameter("isShare")) : z;
                    if (!TextUtils.isEmpty(cJRHomePageItem.getPushFlightClass())) {
                        setFlightClass(cJRHomePageItem.getPushFlightClass());
                        z2 = false;
                    } else if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                        setFlightClass("Economy");
                    }
                    if (!TextUtils.isEmpty(cJRHomePageItem.getPushFlightTripType())) {
                        setFlightTrip(cJRHomePageItem.getPushFlightTripType(), (View) null);
                        z2 = false;
                    } else if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                        setFlightTrip("one_way", (View) null);
                    }
                    if (!TextUtils.isEmpty(cJRHomePageItem.getPushFlightDepartDate())) {
                        setFlightDepartDate(cJRHomePageItem.getPushFlightDepartDate());
                        z2 = false;
                    } else {
                        if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                            this.isResetAllFields = true;
                            this.mSourceDate.setText(this.mSourceDate.getResources().getString(R.string.select_dept_date));
                            this.mSourceDate.setTag(this.mSourceDate.getResources().getString(R.string.select_dept_date));
                            this.mCheckInDateWithYear = this.mSourceDate.getTag().toString();
                        }
                        equalsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(cJRHomePageItem.getPushFlightReturnDate())) {
                        setFlightReturnDate(cJRHomePageItem.getPushFlightReturnDate());
                        z2 = false;
                    } else {
                        if (!TextUtils.isEmpty(cJRHomePageItem.getPushFlightTripType()) && cJRHomePageItem.getPushFlightTripType().equalsIgnoreCase("round_trip")) {
                            equalsIgnoreCase = false;
                        }
                        if (!TextUtils.isEmpty(this.mDeeplinkFilterAirlineCodes)) {
                            resetCheckOutDate();
                        }
                    }
                    if (z2) {
                        this.isDeepLinkDataPopulated = false;
                    } else {
                        this.isDeepLinkDataPopulated = true;
                    }
                    if (equalsIgnoreCase) {
                        this.mIsSearchNotInitiated = false;
                        validateEntries(cJRHomePageItem.isAppLink());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void setFlightClass(String str) {
        if (str.equalsIgnoreCase(getString(R.string.business))) {
            this.mEconomyText.setText(getString(R.string.business));
            this.mClassTypevalue = getString(R.string.business);
        } else if (str.equalsIgnoreCase(getResources().getString(R.string.premium_economy))) {
            this.mEconomyText.setText(getString(R.string.premium_economy));
            this.mClassTypevalue = getString(R.string.premium_economy);
        } else {
            this.mEconomyText.setText(getString(R.string.economy_flight));
            this.mClassTypevalue = getString(R.string.economy_flight);
        }
    }

    private void setSourceAndDestination(com.travel.flight.pojo.flightticket.b bVar, com.travel.flight.pojo.flightticket.b bVar2, boolean z) {
        String str;
        if (bVar != null && bVar2 != null) {
            this.mIsRoundTripSelected = z;
            if (z) {
                flightOnewaySelected(false);
                this.mDestinationDateText.setText(getString(R.string.flight_select_return_date));
                this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
                this.mDestinationDateText.setVisibility(0);
                this.mDetailedReturnLyt.setVisibility(4);
                setRoundTripView();
            } else {
                this.mReturnOn.setVisibility(4);
                this.mDestinationDateText.setText(getString(R.string.select_add_return_date));
                this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_689b9b9b));
                this.mDestinationDateText.setVisibility(0);
                this.mDetailedReturnLyt.setVisibility(4);
                flightOnewaySelected(true);
                setOneWayView();
            }
            this.mSourceCity.setText(bVar.getCityName());
            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mSourceCity.setTag(bVar);
            this.mSourceCity.setVisibility(0);
            String shortCityName = bVar.getShortCityName();
            this.mSourceCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            TextView textView = this.mSourceCityCode;
            textView.setTypeface(textView.getTypeface(), 1);
            String str2 = "";
            if (bVar.getShortCityName() == null) {
                this.mSourceCityCode.setText(str2);
            } else if (!TextUtils.isEmpty(shortCityName)) {
                this.mSourceCityCode.setText(shortCityName.toUpperCase());
            }
            if (this.sourceRecentCityItem == null) {
                this.sourceRecentCityItem = new com.travel.flight.pojo.flightticket.b();
            }
            this.sourceRecentCityItem.setCityName(bVar.getCityName());
            this.sourceRecentCityItem.setAirPortName(bVar.getAirPortName());
            com.travel.flight.pojo.flightticket.b bVar3 = this.sourceRecentCityItem;
            if (bVar.getShortCityName() == null) {
                str = str2;
            } else {
                str = bVar.getShortCityName();
            }
            bVar3.setShortCityName(str);
            this.sourceRecentCityItem.setCountryName(bVar.getCountryName());
            this.sourceRecentCityItem.setCountryCode(bVar.getCountryCode());
            this.mDestinationCity.setText(bVar2.getCityName());
            this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mDestinationCity.setTag(bVar2);
            this.mDestinationCity.setVisibility(0);
            String shortCityName2 = bVar2.getShortCityName();
            this.mDestCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            TextView textView2 = this.mDestCityCode;
            textView2.setTypeface(textView2.getTypeface(), 1);
            if (bVar2.getShortCityName() == null) {
                this.mDestCityCode.setText(str2);
            } else if (!TextUtils.isEmpty(shortCityName2)) {
                this.mDestCityCode.setText(shortCityName2.toUpperCase());
            }
            if (this.destRecentCityItem == null) {
                this.destRecentCityItem = new com.travel.flight.pojo.flightticket.b();
            }
            this.destRecentCityItem.setCityName(bVar2.getCityName());
            this.destRecentCityItem.setAirPortName(bVar2.getAirPortName());
            com.travel.flight.pojo.flightticket.b bVar4 = this.destRecentCityItem;
            if (bVar2.getShortCityName() != null) {
                str2 = bVar2.getShortCityName();
            }
            bVar4.setShortCityName(str2);
            this.destRecentCityItem.setCountryName(bVar2.getCountryName());
            this.destRecentCityItem.setCountryCode(bVar2.getCountryCode());
        }
    }

    private void setSourceCity(com.travel.flight.pojo.flightticket.b bVar) {
        String shortCityName = bVar.getShortCityName();
        String str = "";
        if (!bVar.getCityName().equalsIgnoreCase(this.mSourceCity.getResources().getString(R.string.enter_origin_city))) {
            TextView textView = this.mSourceCityCode;
            textView.setTypeface(textView.getTypeface(), 1);
            this.mSourceCity.setText(bVar.getCityName());
            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mSourceCity.setTag(bVar);
            this.mSourceCity.setVisibility(0);
            this.mSourceCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            if (bVar.getShortCityName() == null) {
                this.mSourceCityCode.setText(str);
            } else if (!TextUtils.isEmpty(shortCityName)) {
                this.mSourceCityCode.setText(shortCityName.toUpperCase());
            }
        }
        if (this.sourceRecentCityItem == null) {
            this.sourceRecentCityItem = new com.travel.flight.pojo.flightticket.b();
        }
        this.sourceRecentCityItem.setCityName(bVar.getCityName());
        this.sourceRecentCityItem.setAirPortName(bVar.getAirPortName());
        com.travel.flight.pojo.flightticket.b bVar2 = this.sourceRecentCityItem;
        if (bVar.getShortCityName() != null) {
            str = bVar.getShortCityName();
        }
        bVar2.setShortCityName(str);
        this.sourceRecentCityItem.setCountryName(bVar.getCountryName());
        this.sourceRecentCityItem.setCountryCode(bVar.getCountryCode());
    }

    private void setDestinationCity(com.travel.flight.pojo.flightticket.b bVar) {
        this.mDestinationCity.setText(bVar.getCityName());
        this.mDestinationCity.setTag(bVar);
        String str = "";
        if (!bVar.getCityName().equalsIgnoreCase(this.mDestinationCity.getResources().getString(R.string.enter_destination_city))) {
            TextView textView = this.mDestCityCode;
            textView.setTypeface(textView.getTypeface(), 1);
            this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_222222));
            this.mDestinationCity.setVisibility(0);
            String shortCityName = bVar.getShortCityName();
            this.mDestCityCode.setTextColor(getResources().getColor(R.color.color_323232));
            if (bVar.getShortCityName() == null) {
                this.mDestCityCode.setText(str);
            } else if (!TextUtils.isEmpty(shortCityName)) {
                this.mDestCityCode.setText(shortCityName.toUpperCase());
            }
        }
        if (this.destRecentCityItem == null) {
            this.destRecentCityItem = new com.travel.flight.pojo.flightticket.b();
        }
        this.destRecentCityItem.setCityName(bVar.getCityName());
        this.destRecentCityItem.setAirPortName(bVar.getAirPortName());
        com.travel.flight.pojo.flightticket.b bVar2 = this.destRecentCityItem;
        if (bVar.getShortCityName() != null) {
            str = bVar.getShortCityName();
        }
        bVar2.setShortCityName(str);
        this.destRecentCityItem.setCountryName(bVar.getCountryName());
        this.destRecentCityItem.setCountryCode(bVar.getCountryCode());
    }

    private void setFlightTrip(String str, View view2) {
        if (str.equalsIgnoreCase("round_trip")) {
            initializeViewForDomesticRoundTrip();
        } else {
            initializeViewForDomesticOneWay();
        }
    }

    private void setFlightDepartDate(String str) {
        try {
            this.appLocale = new Locale(com.paytm.utility.n.a());
            com.paytm.utility.n.a((Context) getActivity(), com.paytm.utility.n.a());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.appLocale);
            if (simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()))) >= 0) {
                setCheckInLyt(str, false);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void setFlightReturnDate(String str) {
        try {
            this.appLocale = new Locale(com.paytm.utility.n.a());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.appLocale);
            if (simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()))) >= 0) {
                setCheckOutLyt(str, false);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        removeProgressDialog();
        if (this.scrollObserver != null) {
            this.mHomeScrollView.getViewTreeObserver().removeOnScrollChangedListener(this.scrollObserver);
            this.scrollObserver = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d.a.a.c.a().b(this);
        removeProgressDialog();
    }

    public void onStop() {
        super.onStop();
        removeProgressDialog();
    }

    private boolean isRecentSearchAvilable() {
        ArrayList<f> a2 = com.travel.flight.utils.c.a((Context) getActivity(), "flight_recent_search_details");
        return a2 != null && a2.size() > 0;
    }

    public void onFareAlertOnClick(CJRFareAlertHomeAnalyticsModel.a aVar) {
        if (aVar != null) {
            this.mIsSearchNotInitiated = false;
            setFareAlertDataToView(aVar);
        }
    }

    private void setFareAlertDataToView(CJRFareAlertHomeAnalyticsModel.a aVar) {
        this.mIsRoundTripSelected = false;
        flightOnewaySelected(true);
        radioOneWayClicked();
        setExchangeImage();
        com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
        bVar.setCityName(aVar.f25426b);
        bVar.setShortCityName(aVar.f25427c);
        setSourceCity(bVar);
        com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
        bVar2.setCityName(aVar.f25430f);
        bVar2.setShortCityName(aVar.f25428d);
        setDestinationCity(bVar2);
        Intent intent = new Intent();
        intent.putExtra("intent_extra_adult_passenger", "1");
        intent.putExtra("intent_extra_children_passenger", "0");
        intent.putExtra("intent_extra_infant_passenger", "0");
        intent.putExtra("intent_extra_trip_type", getString(R.string.economy_flight));
        onActivityResult(205, -1, intent);
        Intent intent2 = new Intent();
        getActivity();
        String d2 = com.paytm.utility.b.d(aVar.f25429e, "dd MMM yyyy", "dd MMM yy");
        if (isValidDate(d2)) {
            this.isClickedFromRecentSearch = false;
            intent2.putExtra("intent_extra_selected_depart_date", d2);
            onActivityResult(1, -1, intent2);
            validateEntries(false);
            return;
        }
        this.isClickedFromRecentSearch = true;
        this.mSourceDate.setText(getResources().getString(R.string.select_dept_date));
        this.mDepartOn.setVisibility(4);
        this.mSourceDate.setVisibility(0);
        this.mDetailedDepartureLyt.setVisibility(4);
        this.mReturnDate.setText(getResources().getString(R.string.flight_select_return_date));
        this.mDestinationDateText.setText(getResources().getString(R.string.flight_select_return_date));
        this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
        this.mReturnOn.setVisibility(4);
        this.mDestinationDateText.setVisibility(0);
        this.mDetailedReturnLyt.setVisibility(4);
        launchDepartCalender();
    }

    public void setDataToView(f fVar) {
        if (fVar.isRoundTrip()) {
            this.mIsRoundTripSelected = true;
            flightOnewaySelected(false);
            radioRoundtripSelected();
        } else {
            this.mIsRoundTripSelected = false;
            flightOnewaySelected(true);
            radioOneWayClicked();
        }
        setExchangeImage();
        com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
        bVar.setCityName(fVar.getSourceCityName());
        bVar.setShortCityName(fVar.getSourceShortCityName());
        bVar.setCountryName(fVar.getSourceCountryName());
        bVar.setAirPortName(fVar.getSourceAirportName());
        bVar.setCountryCode(fVar.getSourceCountryCode());
        setSourceCity(bVar);
        com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
        bVar2.setCityName(fVar.getDestCityName());
        bVar2.setShortCityName(fVar.getDestShortCityName());
        bVar2.setCountryName(fVar.getDestCountryName());
        bVar2.setAirPortName(fVar.getDestAirportName());
        bVar2.setCountryCode(fVar.getDestCountryCode());
        setDestinationCity(bVar2);
        setExchangeImage();
        Intent intent = new Intent();
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.getAdult());
        intent.putExtra("intent_extra_adult_passenger", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fVar.getChild());
        intent.putExtra("intent_extra_children_passenger", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(fVar.getInfant());
        intent.putExtra("intent_extra_infant_passenger", sb3.toString());
        intent.putExtra("intent_extra_trip_type", fVar.getTravellerclass());
        onActivityResult(205, -1, intent);
        this.isNonstopSelected = fVar.isNonstopSelected();
        this.mNonStopFlight.setChecked(this.isNonstopSelected);
        Intent intent2 = new Intent();
        if (fVar.isRoundTrip()) {
            String[] split = fVar.getDateDetail().split("-");
            if (split != null && split.length > 1) {
                getActivity();
                String d2 = com.paytm.utility.b.d(split[0].trim(), "E, dd MMM yy", "dd MMM yy");
                if (isValidDate(d2)) {
                    this.isClickedFromRecentSearch = false;
                    intent2.putExtra("intent_extra_selected_depart_date", d2);
                    getActivity();
                    intent2.putExtra("intent_extra_selected_return_date", com.paytm.utility.b.d(split[1].trim(), "E, dd MMM yy", "dd MMM yy"));
                    onActivityResult(1, -1, intent2);
                } else {
                    this.isClickedFromRecentSearch = true;
                    this.mSourceDate.setText(getResources().getString(R.string.select_dept_date));
                    this.mDepartOn.setVisibility(4);
                    this.mSourceDate.setVisibility(0);
                    this.mDetailedDepartureLyt.setVisibility(4);
                    this.mReturnDate.setText(getResources().getString(R.string.flight_select_return_date));
                    this.mDestinationDateText.setText(getResources().getString(R.string.flight_select_return_date));
                    this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
                    this.mReturnOn.setVisibility(4);
                    this.mDestinationDateText.setVisibility(0);
                    this.mDetailedReturnLyt.setVisibility(4);
                    launchDepartCalender();
                    return;
                }
            }
        } else {
            getActivity();
            String d3 = com.paytm.utility.b.d(fVar.getDateDetail(), "E, dd MMM yy", "dd MMM yy");
            if (isValidDate(d3)) {
                this.isClickedFromRecentSearch = false;
                intent2.putExtra("intent_extra_selected_depart_date", d3);
                onActivityResult(1, -1, intent2);
            } else {
                this.isClickedFromRecentSearch = true;
                this.mSourceDate.setText(getResources().getString(R.string.select_dept_date));
                this.mDepartOn.setVisibility(4);
                this.mSourceDate.setVisibility(0);
                this.mDetailedDepartureLyt.setVisibility(4);
                this.mReturnDate.setText(getResources().getString(R.string.flight_select_return_date));
                this.mDestinationDateText.setText(getResources().getString(R.string.flight_select_return_date));
                this.mDestinationDateText.setTextColor(getResources().getColor(R.color.color_4d4d4d));
                this.mReturnOn.setVisibility(4);
                this.mDestinationDateText.setVisibility(0);
                this.mDetailedReturnLyt.setVisibility(4);
                launchDepartCalender();
                return;
            }
        }
        validateEntries(false);
    }

    private void getMytrips() {
        com.travel.flight.b.a();
        com.travel.flight.c b2 = com.travel.flight.b.b();
        com.travel.flight.b.a();
        if (!TextUtils.isEmpty(b2.a(com.travel.flight.b.b().a()))) {
            com.travel.flight.b.a();
            String b3 = com.paytm.utility.c.b(com.travel.flight.b.b().v(), getContext());
            String str = this.deeplinkString;
            String str2 = this.mReferral;
            if (URLUtil.isValidUrl(b3) && !TextUtils.isEmpty(str)) {
                Uri.Builder buildUpon = Uri.parse(b3).buildUpon();
                if (!TextUtils.isEmpty(str)) {
                    buildUpon.appendQueryParameter("opened_from", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    buildUpon.appendQueryParameter("referral", str2);
                }
                b3 = buildUpon.build().toString();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getContext()));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getContext().getApplicationContext();
            bVar.n = a.b.SILENT;
            bVar.o = FJRFlightTicketFragment.class.getSimpleName();
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b3 + "&type=flight&pagesize=10";
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJRRechargeOrderListFlight();
            bVar.j = this;
            bVar.l().a();
        }
    }

    private void handelMytripResponse(CJRRechargeOrderListFlight cJRRechargeOrderListFlight) {
        if (cJRRechargeOrderListFlight != null && cJRRechargeOrderListFlight.getOrderList() != null && cJRRechargeOrderListFlight.getOrderList().size() > 0) {
            this.mMyTripOrderList = new ArrayList<>();
            Iterator<CJROrderList> it2 = cJRRechargeOrderListFlight.getOrderList().iterator();
            while (it2.hasNext()) {
                CJROrderList next = it2.next();
                if (!next.getStatus().equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED)) {
                    this.mMyTripOrderList.add(next);
                }
            }
        }
    }

    private String getReferralString() {
        CJRHomePageItem cJRHomePageItem;
        if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem) && (cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data")) != null) {
            if (cJRHomePageItem.getmFlightReferral() != null) {
                return cJRHomePageItem.getmFlightReferral();
            }
            if (TextUtils.isEmpty(cJRHomePageItem.getURLType()) || TextUtils.isEmpty(cJRHomePageItem.getURLType()) || !cJRHomePageItem.getURLType().equalsIgnoreCase("flightticket")) {
            }
        }
        return null;
    }

    private void setOneWayView() {
        setExchangeImage();
        initializeViewForDomesticOneWay();
    }

    private void setRoundTripView() {
        setExchangeImage();
        initializeViewForDomesticRoundTrip();
    }

    private boolean isValidDate(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.appLocale);
            if (simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()))) >= 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private void flightOnewaySelected(boolean z) {
        if (z) {
            this.mDomesticOneway.setTextColor(getResources().getColor(R.color.white));
            this.mDomesticRoundTrip.setTextColor(getResources().getColor(R.color.color_c4c4c4));
            this.mDomesticOneway.setBackground(getResources().getDrawable(R.drawable.pre_f_flight_custom_radio_button_state_pressed));
            this.mDomesticRoundTrip.setBackground(getResources().getDrawable(R.drawable.pre_f_flight_custom_radio_button_state_unselected));
            return;
        }
        this.mDomesticOneway.setTextColor(getResources().getColor(R.color.color_c4c4c4));
        this.mDomesticRoundTrip.setTextColor(getResources().getColor(R.color.white));
        this.mDomesticOneway.setBackground(getResources().getDrawable(R.drawable.pre_f_flight_custom_radio_button_state_unselected));
        this.mDomesticRoundTrip.setBackground(getResources().getDrawable(R.drawable.pre_f_flight_custom_radio_button_state_pressed));
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() == null) {
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRBusHolidayList cJRBusHolidayList;
        if (iJRPaytmDataModel instanceof CJRFlightHomepageRequestFilterResponse) {
            if (this.mIsRoundTripSelected) {
                this.mRoundTripFlightOptionResponse = (CJRFlightHomepageRequestFilterResponse) iJRPaytmDataModel;
                if (!com.travel.flight.utils.c.a((Context) getActivity(), true)) {
                    CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse = this.mRoundTripFlightOptionResponse;
                    if (cJRFlightHomepageRequestFilterResponse == null || cJRFlightHomepageRequestFilterResponse.getBody() == null || !this.mRoundTripFlightOptionResponse.getBody().isNonStopChecked()) {
                        resetRoundTripFilter();
                    } else {
                        createDefaultRoundTripFlightOption();
                    }
                    resetFlightOptionCheckboxLabel(this.mRoundTripFlightOptionResponse.getBody().isNonStopChecked());
                }
                this.mSRPBannerURL = getBannerUrl(this.mRoundTripFlightOptionResponse);
            } else {
                this.mFlightOptionResponse = (CJRFlightHomepageRequestFilterResponse) iJRPaytmDataModel;
                if (getActivity() != null && !com.travel.flight.utils.c.a((Context) getActivity(), false)) {
                    CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse2 = this.mFlightOptionResponse;
                    if (cJRFlightHomepageRequestFilterResponse2 == null || cJRFlightHomepageRequestFilterResponse2.getBody() == null || !this.mFlightOptionResponse.getBody().isNonStopChecked()) {
                        resetOnewayFilter();
                    } else {
                        createDefaultOnewayFlightOption();
                    }
                    resetFlightOptionCheckboxLabel(this.mFlightOptionResponse.getBody().isNonStopChecked());
                }
                this.mSRPBannerURL = getBannerUrl(this.mFlightOptionResponse);
            }
            this.mSRPBannerURL = getBannerUrl(this.mFlightOptionResponse);
        } else if (iJRPaytmDataModel instanceof CJRRechargeOrderListFlight) {
            handelMytripResponse((CJRRechargeOrderListFlight) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRAirportCity) {
            CJRAirportCity cJRAirportCity = (CJRAirportCity) iJRPaytmDataModel;
            if (cJRAirportCity != null && cJRAirportCity.getCjrAirportCityItemBody() != null && cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems() != null && cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().size() > 0) {
                if (!TextUtils.isEmpty(this.deeplinkString)) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (i2 < cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().size()) {
                                if (!TextUtils.isEmpty(cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i2).getCityName()) && cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i2).getCityName().contains(this.mDeepLinkSource)) {
                                    this.mOriginShortName = cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i2).getShortCityName();
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        } catch (Exception unused) {
                            logHawkeyeEvent(new com.travel.flight.flightSRPV2.a.m("airport on api success check ", cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().toString(), "NA", "NA", "NA", "NA", "NA"));
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 < cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().size()) {
                            if (!TextUtils.isEmpty(cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i3).getCityName()) && cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i3).getCityName().contains(this.mDeepLinkDestination)) {
                                this.mDestinationShortName = cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems().get(i3).getShortCityName();
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(this.mOriginShortName) && !TextUtils.isEmpty(this.mDestinationShortName)) {
                        prefillFlightDetails();
                    }
                }
                new com.travel.flight.utils.b(getActivity(), cJRAirportCity, "flight_city_url_type").execute(new Void[0]);
            }
        } else if (!(iJRPaytmDataModel instanceof CJRStoreFrontBannersFlight) && (iJRPaytmDataModel instanceof CJRBusHolidayList) && (cJRBusHolidayList = (CJRBusHolidayList) iJRPaytmDataModel) != null && cJRBusHolidayList.getHolidayList() != null && cJRBusHolidayList.getHolidayList().size() > 0) {
            this.mFlightHolidayList = cJRBusHolidayList;
        }
    }

    public static void logHawkeyeEvent(com.travel.flight.flightSRPV2.a.m mVar) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(mVar);
    }

    private void resetFlightOptionCheckboxLabel(CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward) {
        this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{iJROnward.getHeader().toLowerCase()}));
    }

    private void resetFlightOptionCheckboxLabel(boolean z) {
        this.mNonStopFlight.setChecked(z);
    }

    private String getBannerUrl(CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse) {
        return (cJRFlightHomepageRequestFilterResponse == null || cJRFlightHomepageRequestFilterResponse.getBody() == null || TextUtils.isEmpty(cJRFlightHomepageRequestFilterResponse.getBody().getBannerurl())) ? "" : cJRFlightHomepageRequestFilterResponse.getBody().getBannerurl();
    }

    private void getFilterFromServer(String str, String str2, String str3) {
        try {
            String completeUrl = getCompleteUrl(str, str2, str3);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            if (!TextUtils.isEmpty(completeUrl)) {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = getContext().getApplicationContext();
                    bVar.n = a.b.SILENT;
                    bVar.o = FJRFlightTicketFragment.class.getSimpleName();
                    bVar.f42878b = a.c.FLIGHT;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = completeUrl;
                    bVar.f42881e = null;
                    bVar.f42882f = null;
                    bVar.f42883g = null;
                    bVar.f42884h = null;
                    bVar.f42885i = new CJRFlightHomepageRequestFilterResponse();
                    bVar.j = this;
                    bVar.l().a();
                }
            }
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    private String getCompleteUrl(String str, String str2, String str3) {
        com.travel.flight.b.a();
        Uri.Builder buildUpon = Uri.parse(com.travel.flight.b.b().k()).buildUpon();
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter("origin", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter("destination", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            buildUpon.appendQueryParameter("trip_type", str3);
        }
        return com.paytm.utility.c.b(buildUpon.build().toString(), getContext());
    }

    /* access modifiers changed from: private */
    public void showFlightOptionDialog(CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse, CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward) {
        d.a(cJRFlightHomepageRequestFilterResponse, iJROnward).show(getChildFragmentManager(), "Alert Dialog Fragment");
    }

    public void onEvent(h.b bVar) {
        if (bVar != null) {
            if (!bVar.f25587a) {
                if (!bVar.f25588b) {
                    this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getString(R.string.non_stop_flight_only)}));
                    resetRoundTripFilter();
                    this.mNonStopFlight.setChecked(false);
                } else if (bVar.f25589c == null) {
                    this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getString(R.string.non_stop_flight_only)}));
                    resetRoundTripFilter();
                    this.mNonStopFlight.setChecked(false);
                } else {
                    this.roundtripSelectedOption = bVar.f25589c;
                    this.mNonStopFlight.setChecked(true);
                    this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{bVar.f25589c.getHeader()}));
                }
                if (bVar.f25590d) {
                    setRecentSearch();
                }
            } else if (bVar.f25589c == null) {
                this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getString(R.string.non_stop_flight_only).toLowerCase()}));
                resetOnewayFilter();
                this.mNonStopFlight.setChecked(false);
            } else {
                this.onewaySelectedOption = bVar.f25589c;
                this.mNonStopFlight.setChecked(true);
                this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{bVar.f25589c.getHeader().toLowerCase()}));
            }
        }
    }

    private void createDefaultFlightOption(CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward) {
        createDefaultRoundTripFlightOption();
        createDefaultOnewayFlightOption();
        if (iJROnward != null) {
            resetFlightOptionCheckboxLabel(iJROnward);
        }
    }

    /* access modifiers changed from: private */
    public void createDefaultOnewayFlightOption() {
        this.onewaySelectedOption = new CJRFlightHomepageRequestFilterResponse.IJROnward();
        this.onewaySelectedOption.setHeader("Non-stop flights only");
        this.onewaySelectedOption.setMessage("Hide all flights with stopovers");
        if (this.mNonStopFlightOptionCBLabel != null && getContext() != null) {
            this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getResources().getString(R.string.non_stop_flight_only).toLowerCase()}));
        }
    }

    /* access modifiers changed from: private */
    public void resetOnewayFilter() {
        this.onewaySelectedOption = null;
        this.onewaySelectedOption = new CJRFlightHomepageRequestFilterResponse.IJROnward();
        this.onewaySelectedOption.setHeader("All flights");
        if (this.mNonStopFlightOptionCBLabel != null && getContext() != null) {
            this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getResources().getString(R.string.non_stop_flight_only).toLowerCase()}));
        }
    }

    /* access modifiers changed from: private */
    public void createDefaultRoundTripFlightOption() {
        this.roundtripSelectedOption = new CJRFlightHomepageRequestFilterResponse.IJROnward();
        this.roundtripSelectedOption.setHeader("Non-stop flights only");
        this.roundtripSelectedOption.setMessage("Hide all flights with stopovers");
        if (this.mNonStopFlightOptionCBLabel != null && getContext() != null) {
            this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getResources().getString(R.string.non_stop_flight_only).toLowerCase()}));
        }
    }

    /* access modifiers changed from: private */
    public void resetRoundTripFilter() {
        this.roundtripSelectedOption = null;
        this.roundtripSelectedOption = new CJRFlightHomepageRequestFilterResponse.IJROnward();
        this.roundtripSelectedOption.setHeader("All flights");
        if (this.mNonStopFlightOptionCBLabel != null && getContext() != null) {
            this.mNonStopFlightOptionCBLabel.setText(String.format(getString(R.string.show_data), new Object[]{getResources().getString(R.string.non_stop_flight_only).toLowerCase()}));
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
    }

    private void addStoreFrontFragment() {
        Bundle bundle = new Bundle();
        com.travel.flight.b.a();
        this.mEndLessFragment = com.travel.flight.b.b().a((WeakReference<View>) new WeakReference(this.mHomeScrollView));
        bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
        bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
        bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        bundle.putString("origin", "flight");
        bundle.putString("store_front_url_key", "flightStoreFrontUrl");
        bundle.putBoolean("trigger-impression-on-visibility", true);
        this.mEndLessFragment.setArguments(bundle);
        getChildFragmentManager().a().b(R.id.framelayout_storefront, this.mEndLessFragment, "TAG_FLIGHT_STOREFRONT").b();
    }

    private void addInternationalFlightStoreFrontFragment() {
        Bundle bundle = new Bundle();
        com.travel.flight.b.a();
        this.mEndLessFragment = com.travel.flight.b.b().a((WeakReference<View>) new WeakReference(this.mHomeScrollView));
        bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
        bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
        bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        bundle.putString("origin", "flight");
        bundle.putBoolean("trigger-impression-on-visibility", true);
        if (getArguments().containsKey("bundle_extra_category_item") && getArguments().getSerializable("bundle_extra_category_item") != null) {
            bundle.putSerializable("bundle_extra_category_item", getArguments().getSerializable("bundle_extra_category_item"));
        }
        this.mEndLessFragment.setArguments(bundle);
        getChildFragmentManager().a().b(R.id.framelayout_storefront, this.mEndLessFragment, "TAG_FLIGHT_STOREFRONT").b();
    }

    private HashMap<String, Object> getMapForPrefilledDetails(boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (z) {
            hashMap.put("event_label", "success");
        }
        TextView textView = this.mSourceCity;
        if (textView != null && !TextUtils.isEmpty(textView.getText()) && !this.mSourceCity.getText().toString().equalsIgnoreCase(this.mSourceCity.getResources().getString(R.string.enter_origin_city))) {
            hashMap.put("event_label3", this.mSourceCity.getText());
        }
        TextView textView2 = this.mDestinationCity;
        if (textView2 != null && !TextUtils.isEmpty(textView2.getText()) && !this.mDestinationCity.getText().toString().equalsIgnoreCase(this.mDestinationCity.getResources().getString(R.string.enter_destination_city))) {
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.mDestinationCity.getText());
        }
        if (!TextUtils.isEmpty(this.mCheckInDateWithYear) && !this.mCheckInDateWithYear.equalsIgnoreCase(this.mDestinationCity.getResources().getString(R.string.select_dept_date))) {
            hashMap.put("event_label7", this.mCheckInDateWithYear);
        }
        if (!TextUtils.isEmpty(this.mCheckOutDateWithYear) && this.mIsRoundTripSelected && !this.mCheckOutDateWithYear.equalsIgnoreCase(this.mDestinationCity.getResources().getString(R.string.flight_select_return_date))) {
            hashMap.put("event_label8", this.mCheckOutDateWithYear);
        }
        TextView textView3 = this.mSourceCityCode;
        if (textView3 != null && !TextUtils.isEmpty(textView3.getText()) && !this.mSourceCityCode.getText().toString().equalsIgnoreCase(UpiConstants.FROM)) {
            hashMap.put("event_label9", this.mSourceCityCode.getText());
        }
        TextView textView4 = this.mDestCityCode;
        if (textView4 != null && !TextUtils.isEmpty(textView4.getText()) && !this.mDestCityCode.getText().toString().equalsIgnoreCase("To")) {
            hashMap.put("event_label10", this.mDestCityCode.getText());
        }
        j.a aVar = j.f25593a;
        hashMap.put("event_label11", j.a.a(!this.mIsRoundTripSelected));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void sendCustomPulseEvent(String str, HashMap<String, Object> hashMap) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights", "flights_home", str, hashMap);
    }

    /* access modifiers changed from: private */
    public void sendTripTypePulseEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        sendCustomPulseEvent("trip_type_selected", hashMap);
    }
}
