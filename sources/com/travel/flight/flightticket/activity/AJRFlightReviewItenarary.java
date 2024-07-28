package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.b.b;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.activity.AJREmbedWebView;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightSRPV2.a.y;
import com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity;
import com.travel.flight.flightticket.a.j;
import com.travel.flight.flightticket.e.h;
import com.travel.flight.flightticket.e.m;
import com.travel.flight.flightticket.f.i;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.flightticket.fragment.d;
import com.travel.flight.flightticket.g.e;
import com.travel.flight.flightticket.j.p;
import com.travel.flight.pojo.CJRFlightPromoBody;
import com.travel.flight.pojo.GSTDetailsReviewPage;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.pojo.flightticket.CJRFlightCampaign;
import com.travel.flight.pojo.flightticket.CJRFlightClientLoginPayload;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightOffer;
import com.travel.flight.pojo.flightticket.CJRFlightOfferCode;
import com.travel.flight.pojo.flightticket.CJRFlightOfferV2;
import com.travel.flight.pojo.flightticket.CJRFlightPaymentData;
import com.travel.flight.pojo.flightticket.CJRFlightPaymentInfo;
import com.travel.flight.pojo.flightticket.CJRFlightPrice;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRMetadetails;
import com.travel.flight.pojo.flightticket.CJRPromoMetaData;
import com.travel.flight.pojo.flightticket.CJRPromocodeErrorResponse;
import com.travel.flight.pojo.flightticket.CJRStatus;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRMIniRules;
import com.travel.flight.pojo.flightticket.FlightBundle;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponse;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo;
import com.travel.flight.span.TopAlignProportionalSpan;
import com.travel.flight.travellerProfile.a;
import com.travel.flight.travellerProfile.model.CJRTpUserProfile;
import com.travel.flight.travellerProfile.model.CJRTpUserProfileBody;
import com.travel.flight.tripsummary.AJRFlightConfirmation;
import com.travel.flight.utils.c;
import com.travel.flight.utils.j;
import com.travel.flight.views.FlightFareBreakupBottomSheetView;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRFlightReviewItenarary extends PaytmActivity implements View.OnClickListener, b, j.b, com.travel.flight.flightticket.f.b, i, k, VerifyPromoCallbackListener, OnPromoActivityDestroyListener {
    private CJRFlightOfferCode UpFrontOfferCodeSelected;
    private String acceptType = "";
    private com.travel.flight.flightticket.d.b bookingSegment = com.travel.flight.flightticket.d.b.Modify;
    private FlightFareBreakupBottomSheetView fareBottomSheet;
    private boolean isCashBackSnackBarVisible = false;
    /* access modifiers changed from: private */
    public boolean isRoundTrip = false;
    private boolean isSharedDeeplink = false;
    private boolean isSnackBarClosedByUser = false;
    private boolean isUpFrontPromo;
    private String journeyTypeForPrices = "one_way";
    private TextView mAmountText;
    private CJRFlightPromoResponse mAppliedPromoCheckResponse;
    private TextView mBookingAmount;
    private ConstraintLayout mCashBackSnackBar;
    private TextView mCashBackSnackBarTextView;
    private TextView mConvFeeMsg;
    private CoordinatorLayout mCoordinatorLayout;
    private ImageView mDestBackgroundImageView;
    private RelativeLayout mFareRulesAnimLayout;
    /* access modifiers changed from: private */
    public RelativeLayout mFareRulesGreyBgLayout;
    private CJRFareRulesResponse mFareRulesResponse;
    private m mFlightAlertDialog;
    private CJRFlightDetails mFlightDetails;
    private CJRFlightSearchResult mFlightSearchResult;
    private boolean mIsFromTravellerDetail = false;
    /* access modifiers changed from: private */
    public CJRFlightOffer mOffers;
    private String mPaymentIntent;
    private ProgressDialog mProgressDialog;
    private String mPromoCodeEntered = null;
    private VerifyPromoResultListener mPromoVerifyListener;
    /* access modifiers changed from: private */
    public RelativeLayout mRelativePaymentDetail;
    private String mRequestId;
    /* access modifiers changed from: private */
    public j mReviewDetailsAdapter;
    private e mReviewPresenter;
    private RecyclerView mReviewRecylerView;
    private CJRFlightSearchInput mSearchInputs;
    private List<FlightSellingBundleResponseData> mSellingBundleData;
    private String mServiceProvider;
    private RelativeLayout mShadowLyt;
    /* access modifiers changed from: private */
    public ImageView mShareIcon;
    private TextView mToatslPaseeengetCountText;
    private Toolbar mToolbar;
    private int mTotalPassenger;
    private String mTripType;
    private String profileType;

    public void clearPromoCode(String str, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
    }

    public void onPromoSearchActivityDestroy(boolean z) {
    }

    public void onReviewItenaryBundleResponseFail(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        RecyclerView recyclerView = this.mReviewRecylerView;
        boolean z = false;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (!this.isSnackBarClosedByUser) {
            z = this.isCashBackSnackBarVisible;
        }
        if (z) {
            showCashBackSnackBar();
        }
        super.onResume();
        q.a(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_activity_review_itinarary);
        getWindow().setSoftInputMode(3);
        CJRFlightAncillaryReqBody.clear();
        this.mReviewPresenter = new e(this);
        getIntentData();
        com.travel.flight.b.a();
        this.profileType = com.travel.flight.b.b().e(getApplicationContext());
        setToolBar();
        CJRFlightSearchInput cJRFlightSearchInput = this.mSearchInputs;
        if (cJRFlightSearchInput != null && !TextUtils.isEmpty(cJRFlightSearchInput.getDestCityCode())) {
            String replace = "http://assets.paytm.com/travel/flights/iata/v1/order_actions/small/DEFAULT.png".replace("DEFAULT", this.mSearchInputs.getDestCityCode());
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.mDestBackgroundImageView.getContext());
            a2.f43753a = replace;
            b.a.C0750a b2 = a2.a((Object) getResources().getDrawable(R.drawable.pre_f_flight_review_iternary_default)).b(getResources().getDrawable(R.drawable.pre_f_flight_review_iternary_default));
            b2.m = true;
            b.a.C0750a.a(b2, this.mDestBackgroundImageView, (com.paytm.utility.b.b.b) null, 2);
        }
        initViews();
        a a3 = a.a();
        a3.f25522a = null;
        if (a3.f25523b != null && a3.f25523b.size() > 0) {
            a3.f25523b.clear();
        }
        if (com.paytm.utility.b.r((Context) this) && !this.profileType.equalsIgnoreCase("reseller") && this.bookingSegment != com.travel.flight.flightticket.d.b.Modify) {
            callTravellerProfileApi();
        }
        callReviewAPI();
        this.fareBottomSheet = (FlightFareBreakupBottomSheetView) findViewById(R.id.bottom_sheet);
        this.fareBottomSheet.setupBehavior();
        this.fareBottomSheet.setContext(this);
        this.fareBottomSheet.setFlightDetails(this.mFlightDetails);
        this.mFlightAlertDialog = new m();
    }

    private void callTravellerProfileApi() {
        String str;
        showProgressBar();
        a.a();
        net.one97.paytmflight.common.entity.travel.a aVar = net.one97.paytmflight.common.entity.travel.a.flights;
        com.travel.flight.b.a();
        String K = com.travel.flight.b.b().K();
        if (aVar == net.one97.paytmflight.common.entity.travel.a.all) {
            str = K + "?vertical=";
        } else {
            str = K + "?vertical=" + aVar;
        }
        String s = com.paytm.utility.b.s(this, str);
        HashMap hashMap = new HashMap();
        com.travel.flight.b.a();
        hashMap.put("sso-token", com.travel.flight.b.b().a((Context) this));
        boolean z = true;
        if (URLUtil.isValidUrl(s)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.n = a.b.SILENT;
            bVar.o = getClass().getSimpleName();
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = s;
            bVar.f42882f = hashMap;
            bVar.f42885i = new CJRTpUserProfile();
            bVar.j = this;
            bVar.t = com.travel.flight.travellerProfile.a.b();
            bVar.l = true;
            bVar.l().a();
        } else {
            z = false;
        }
        if (!z) {
            removeProgressDialog();
        }
    }

    private void setToolBar() {
        String str;
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setColorFilter(androidx.core.content.b.c(this, R.color.white), PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_arrow);
        TextView textView = (TextView) findViewById(R.id.traveller_info);
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().c(false);
        TextView textView2 = (TextView) findViewById(R.id.source);
        TextView textView3 = (TextView) findViewById(R.id.destination);
        this.mDestBackgroundImageView = (ImageView) findViewById(R.id.background_image_view);
        setTransparentStatusBar(true);
        CJRFlightSearchInput cJRFlightSearchInput = this.mSearchInputs;
        if (cJRFlightSearchInput == null || cJRFlightSearchInput.getDestination() == null || this.mSearchInputs.getSource() == null) {
            str = "";
        } else {
            textView2.setText(this.mSearchInputs.getSource().getCityName());
            textView3.setText(this.mSearchInputs.getDestination().getCityName());
            this.mFlightDetails.setSource(this.mSearchInputs.getSource().getCityName());
            this.mFlightDetails.setDestination(this.mSearchInputs.getDestination().getCityName());
            if (this.isRoundTrip) {
                str = com.travel.flight.c.d.a.a(true, this.mSearchInputs.getDate(), this.mSearchInputs.getReturnDate());
                imageView2.setImageResource(R.drawable.pre_f_image_flight_rt_arrow_revamp);
            } else {
                str = com.travel.flight.c.d.a.a(false, this.mSearchInputs.getDate(), this.mSearchInputs.getReturnDate());
                imageView2.setImageResource(R.drawable.pre_f_image_flight_oneway_arrow_revamp);
            }
        }
        textView.setText(str + getTravellerData() + ", " + getClassForTrip(this.mSearchInputs.getClassType()));
    }

    private void setTransparentStatusBar(boolean z) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT >= 21) {
            if (z) {
                getWindow().setStatusBarColor(0);
                getWindow().getDecorView().setSystemUiVisibility(1280);
                this.mToolbar.setPadding(0, getStatusBarHeight(), 0, 0);
                return;
            }
            getWindow().setStatusBarColor(androidx.core.content.b.c(this, R.color.app_theme_color));
            getWindow().getDecorView().setSystemUiVisibility(1280);
            this.mFareRulesAnimLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        }
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private String getClassForTrip(String str) {
        if ("E".equalsIgnoreCase(str)) {
            return getString(R.string.economy_flight);
        }
        if ("B".equalsIgnoreCase(str)) {
            return getString(R.string.business);
        }
        return AppConstants.FEED_COMMUNITY_POST.equalsIgnoreCase(str) ? getString(R.string.premium_economy) : "";
    }

    private String getTravellerData() {
        String str = "";
        if (this.mSearchInputs.getmCount_adults() == 1) {
            str = str + ", " + this.mSearchInputs.getmCount_adults() + " " + getString(R.string.adult);
        } else if (this.mSearchInputs.getmCount_adults() > 1) {
            str = str + ", " + this.mSearchInputs.getmCount_adults() + " " + getString(R.string.adults);
        }
        if (this.mSearchInputs.getmCount_childerns() == 1) {
            str = str + ", " + this.mSearchInputs.getmCount_childerns() + " " + getString(R.string.child);
        } else if (this.mSearchInputs.getmCount_childerns() > 1) {
            str = str + ", " + this.mSearchInputs.getmCount_childerns() + " " + getString(R.string.children);
        }
        if (this.mSearchInputs.getmCount_infants() == 1) {
            str = str + ", " + this.mSearchInputs.getmCount_infants() + " " + getString(R.string.infant);
        } else if (this.mSearchInputs.getmCount_infants() > 1) {
            str = str + ", " + this.mSearchInputs.getmCount_infants() + " " + getString(R.string.infants);
        }
        this.mTotalPassenger = this.mSearchInputs.getmCount_adults() + this.mSearchInputs.getmCount_childerns() + this.mSearchInputs.getmCount_infants();
        return str;
    }

    /* access modifiers changed from: private */
    public void callReviewAPI() {
        String str;
        if (this.isRoundTrip) {
            str = getTwoWayReviewUrl();
        } else {
            str = getOneWayReviewUrl();
        }
        if (URLUtil.isValidUrl(str)) {
            String str2 = str + "&userType=" + this.profileType;
            if (com.paytm.utility.b.c((Context) this)) {
                showProgressDialog(getResources().getString(R.string.review_dialog));
                if (this.isSharedDeeplink) {
                    CJRFlightSearchInput cJRFlightSearchInput = this.mSearchInputs;
                    String a2 = com.travel.flight.c.d.a.a(cJRFlightSearchInput.getDate(), "yyyy-MM-dd", "yyyyMMdd");
                    Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
                    buildUpon.appendQueryParameter("isShare", "true");
                    buildUpon.appendQueryParameter("origin", cJRFlightSearchInput.getSourceCityCode());
                    buildUpon.appendQueryParameter("destination", cJRFlightSearchInput.getDestCityCode());
                    buildUpon.appendQueryParameter("departureDate", a2);
                    if (!TextUtils.isEmpty(cJRFlightSearchInput.getReturnDate())) {
                        buildUpon.appendQueryParameter("returnDate", com.travel.flight.c.d.a.a(cJRFlightSearchInput.getReturnDate(), "yyyy-MM-dd", "yyyyMMdd"));
                    }
                    buildUpon.appendQueryParameter(Item.KEY_CLASS, cJRFlightSearchInput.getClassType());
                    String str3 = "0";
                    buildUpon.appendQueryParameter("adults", cJRFlightSearchInput.getmCount_adults() > 0 ? String.valueOf(cJRFlightSearchInput.getmCount_adults()) : str3);
                    buildUpon.appendQueryParameter("children", cJRFlightSearchInput.getmCount_childerns() > 0 ? String.valueOf(cJRFlightSearchInput.getmCount_childerns()) : str3);
                    if (cJRFlightSearchInput.getmCount_infants() > 0) {
                        str3 = String.valueOf(cJRFlightSearchInput.getmCount_infants());
                    }
                    buildUpon.appendQueryParameter("infants", str3);
                    buildUpon.appendQueryParameter("as_origin_pos", String.valueOf(cJRFlightSearchInput.getmAutoSuggestOriginPos()));
                    buildUpon.appendQueryParameter("as_destination_pos", String.valueOf(cJRFlightSearchInput.getmAutoSuggestDestinationPos()));
                    if (cJRFlightSearchInput.getmAutoSuggestOriginSearchKey() != null) {
                        buildUpon.appendQueryParameter("as_origin", cJRFlightSearchInput.getmAutoSuggestOriginSearchKey());
                    }
                    if (cJRFlightSearchInput.getmAutoSuggestDestinationSearchKey() != null) {
                        buildUpon.appendQueryParameter("as_destination", cJRFlightSearchInput.getmAutoSuggestDestinationSearchKey());
                    }
                    buildUpon.appendQueryParameter("enable", "{\"multiPrice\": true, \"handBaggageFare\": true,\"paxWiseConvFee\": true,\"minirules\": true}");
                    str2 = buildUpon.build().toString();
                }
                String str4 = str2 + c.a(false, this.mSearchInputs.getmSelcetedOnwardPriceId(), this.mSearchInputs.getmSelcetedReturnPriceId());
                if (!TextUtils.isEmpty(this.acceptType)) {
                    str4 = str4 + ("&type=" + this.acceptType);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getApplicationContext()));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.n = a.b.SILENT;
                bVar.o = AJRFlightReviewItenarary.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = str4;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRFlightSearchResult();
                bVar.j = this;
                bVar.t = createDisplayErrorJsonObject();
                bVar.l().a();
                return;
            }
            showReviewApiNetworkDialog();
        }
    }

    private JSONObject createDisplayErrorJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightReviewScreen");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private String getTwoWayReviewUrl() {
        com.travel.flight.b.a();
        String t = com.travel.flight.b.b().t();
        String str = this.mSearchInputs.getmServiceProviserSelectedOnTop();
        String str2 = this.mFlightDetails.getmOnwardJourney().getmFlightId();
        String str3 = this.mFlightDetails.getmReturnJourney().getmFlightId();
        if (this.bookingSegment == com.travel.flight.flightticket.d.b.Modify) {
            com.travel.flight.b.a();
            t = com.travel.flight.b.b().V() + "?order_id=" + this.mSearchInputs.getModifyBookingOrderId() + AppConstants.AND_SIGN;
        }
        return t + "requestid=" + this.mRequestId + "&onward_provider=" + str + "&return_provider=" + str + "&onward_flightid=" + str2 + "&return_flightid=" + str3 + concatAirportCode();
    }

    private String concatAirportCode() {
        CJRFlightSearchInput cJRFlightSearchInput = this.mSearchInputs;
        if (cJRFlightSearchInput == null || cJRFlightSearchInput.getSourceIataCode() == null || this.mSearchInputs.getDestIataCode() == null || !this.mSearchInputs.isNearByAirportSelected()) {
            return "";
        }
        return "&origin_search_term=" + this.mSearchInputs.getSourceIataCode() + "&destination_search_term=" + this.mSearchInputs.getDestIataCode();
    }

    private String getOneWayReviewUrl() {
        String str;
        com.travel.flight.b.a();
        String t = com.travel.flight.b.b().t();
        if (this.mFlightDetails.getmOnwardServiceProvider() != null) {
            str = this.mFlightDetails.getmOnwardServiceProvider();
        } else if (this.mFlightDetails.getmOnwardJourney() == null || this.mFlightDetails.getmOnwardJourney().getmServiceProviderSelected() == null) {
            str = this.mFlightDetails.getmOnwardJourney().getmPrice().get(0).getmServiceProvider();
        } else {
            str = this.mFlightDetails.getmOnwardJourney().getmServiceProviderSelected().getmServiceProvider();
        }
        if (!this.isSharedDeeplink) {
            this.mServiceProvider = str;
        }
        String str2 = this.mFlightDetails.getmOnwardJourney().getmFlightId();
        if (this.bookingSegment == com.travel.flight.flightticket.d.b.Modify) {
            StringBuilder sb = new StringBuilder();
            com.travel.flight.b.a();
            sb.append(com.travel.flight.b.b().V());
            sb.append("?");
            t = sb.toString();
        }
        return t + "requestid=" + this.mRequestId + "&onward_provider=" + this.mServiceProvider + "&onward_flightid=" + str2 + concatAirportCode();
    }

    private void getIntentData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra("INTENT_EXTRA_REVIEW_TYPE")) {
                int intExtra = getIntent().getIntExtra("INTENT_EXTRA_REVIEW_TYPE", 0);
                if (intExtra == 0) {
                    this.bookingSegment = com.travel.flight.flightticket.d.b.Modify;
                } else if (intExtra != 2) {
                    this.bookingSegment = com.travel.flight.flightticket.d.b.Regular;
                } else {
                    this.bookingSegment = com.travel.flight.flightticket.d.b.Corporate;
                }
            } else {
                this.bookingSegment = com.travel.flight.flightticket.d.b.Regular;
            }
            if (getIntent().hasExtra("intent_extra_review_data")) {
                this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
                CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
                if (!(cJRFlightDetails == null || cJRFlightDetails.getmMetaDetails() == null)) {
                    this.mRequestId = this.mFlightDetails.getmMetaDetails().getmRequestId();
                }
            }
            if (getIntent().hasExtra("intent_extra_search_input_data")) {
                this.mSearchInputs = (CJRFlightSearchInput) getIntent().getSerializableExtra("intent_extra_search_input_data");
            }
            if (getIntent().hasExtra("intent_extra_trip_type")) {
                this.mTripType = getIntent().getStringExtra("intent_extra_trip_type");
                this.isRoundTrip = this.mTripType.equalsIgnoreCase("round_trip");
                new StringBuilder("--------TRIP TYPE----------- ").append(this.mTripType);
                com.paytm.utility.b.j();
            }
            if (getIntent().hasExtra("acceptType")) {
                this.acceptType = getIntent().getStringExtra("acceptType");
            }
            if (getIntent().hasExtra("extra_home_data")) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getExtras().getSerializable("extra_home_data");
                if (!TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                    getDetailsFromDeeplink(cJRHomePageItem.getURL());
                }
            }
        }
    }

    private void getDetailsFromDeeplink(String str) {
        Uri parse = Uri.parse(str);
        this.isSharedDeeplink = "true".equalsIgnoreCase(parse.getQueryParameter("isShare"));
        if (this.isSharedDeeplink) {
            this.mRequestId = parse.getQueryParameter("requestid");
            this.mTripType = parse.getQueryParameter("isRoundTrip");
            this.isRoundTrip = "round_trip".equalsIgnoreCase(this.mTripType);
            this.acceptType = parse.getQueryParameter("type");
            this.mServiceProvider = parse.getQueryParameter("onward_provider");
            if (this.mFlightDetails == null) {
                this.mFlightDetails = new CJRFlightDetails();
                CJRFlightDetailsItem cJRFlightDetailsItem = new CJRFlightDetailsItem();
                this.mSearchInputs = new CJRFlightSearchInput();
                if (this.isRoundTrip) {
                    cJRFlightDetailsItem.setmFlightId(parse.getQueryParameter("return_flightid"));
                    this.mFlightDetails.setmReturnJourney(cJRFlightDetailsItem);
                    this.mFlightDetails.setmReturnServiceProvider(this.mServiceProvider);
                    this.mSearchInputs.setmSelcetedReturnPriceId(parse.getQueryParameter("return_price_id"));
                }
                CJRFlightDetailsItem cJRFlightDetailsItem2 = new CJRFlightDetailsItem();
                cJRFlightDetailsItem2.setmFlightId(parse.getQueryParameter("onward_flightid"));
                this.mFlightDetails.setmOnwardJourney(cJRFlightDetailsItem2);
                this.mFlightDetails.setmOnwardServiceProvider(this.mServiceProvider);
                this.mSearchInputs.setmSelcetedOnwardPriceId(parse.getQueryParameter("onward_price_id"));
                this.mSearchInputs.setmServiceProviserSelectedOnTop(parse.getQueryParameter("return_provider"));
                this.mSearchInputs.setDate(parse.getQueryParameter("departureDate"));
                this.mSearchInputs.setReturnDate(parse.getQueryParameter("returnDate"));
                this.mSearchInputs.setClassType(parse.getQueryParameter(Item.KEY_CLASS));
                String queryParameter = parse.getQueryParameter("as_origin_pos");
                String queryParameter2 = parse.getQueryParameter("as_destination_pos");
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.mSearchInputs.setmAutoSuggestOriginPos(Integer.parseInt(queryParameter));
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    this.mSearchInputs.setmAutoSuggestDestinationPos(Integer.parseInt(queryParameter2));
                }
                this.mSearchInputs.setmAutoSuggestOriginSearchKey(parse.getQueryParameter("as_origin"));
                this.mSearchInputs.setmAutoSuggestDestinationSearchKey(parse.getQueryParameter("as_destination"));
                com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
                bVar.setShortCityName(parse.getQueryParameter("origin"));
                bVar.setCityName(parse.getQueryParameter("src_city_name"));
                this.mSearchInputs.setSource(bVar);
                this.mSearchInputs.setSourceCityCode(bVar.getShortCityName());
                com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
                bVar2.setShortCityName(parse.getQueryParameter("destination"));
                bVar2.setCityName(parse.getQueryParameter("dest_city_name"));
                this.mSearchInputs.setDestination(bVar2);
                this.mSearchInputs.setDestCityCode(bVar2.getShortCityName());
                String queryParameter3 = parse.getQueryParameter("adults");
                String queryParameter4 = parse.getQueryParameter("children");
                String queryParameter5 = parse.getQueryParameter("infants");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    this.mSearchInputs.setmCount_adults(Integer.parseInt(queryParameter3));
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    this.mSearchInputs.setmCount_childerns(Integer.parseInt(queryParameter4));
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    this.mSearchInputs.setmCount_infants(Integer.parseInt(queryParameter5));
                }
            }
        }
    }

    private void initViews() {
        this.mAmountText = (TextView) findViewById(R.id.txt_amount_text);
        this.mToatslPaseeengetCountText = (TextView) findViewById(R.id.txt_review_see_details);
        this.mReviewRecylerView = (RecyclerView) findViewById(R.id.recycler_view_review_itinarary);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mReviewRecylerView.setLayoutManager(linearLayoutManager);
        this.mBookingAmount = (TextView) findViewById(R.id.txt_review_booking_amnt);
        this.mConvFeeMsg = (TextView) findViewById(R.id.txt_view_convfee_msg);
        this.mRelativePaymentDetail = (RelativeLayout) findViewById(R.id.relative_review_payment_layout);
        this.mRelativePaymentDetail.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                ((RelativeLayout.LayoutParams) AJRFlightReviewItenarary.this.mFareRulesGreyBgLayout.getLayoutParams()).setMargins(0, 0, 0, AJRFlightReviewItenarary.this.mRelativePaymentDetail.getHeight());
                AJRFlightReviewItenarary.this.mRelativePaymentDetail.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        this.mFareRulesGreyBgLayout = (RelativeLayout) findViewById(R.id.lyt_flight_fare_rules_grey_bg);
        this.mFareRulesAnimLayout = (RelativeLayout) findViewById(R.id.fare_rules_anim_layout);
        this.mShadowLyt = (RelativeLayout) findViewById(R.id.lyt_convfee_msg);
        this.mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinater_lyt);
        this.mCoordinatorLayout.setVisibility(0);
        this.mShareIcon = (ImageView) findViewById(R.id.flight_share_icon);
        this.mShareIcon.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow_mini_rule_rule);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(this);
        findViewById(R.id.proceed_to_book_btn).setOnClickListener(this);
        findViewById(R.id.amount_detail).setOnClickListener(this);
    }

    private void setJourneyDetails() {
        CJRFlightSearchResult cJRFlightSearchResult = this.mFlightSearchResult;
        CJRMIniRules cJRMIniRules = null;
        String nearbyAirports = (cJRFlightSearchResult == null || cJRFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo() == null || TextUtils.isEmpty(this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getNearbyAirports())) ? null : this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getNearbyAirports();
        CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
        if (cJRFlightDetails != null) {
            CJRFlightSearchInput cJRFlightSearchInput = this.mSearchInputs;
            CJRFareRulesResponse cJRFareRulesResponse = this.mFareRulesResponse;
            if (!(cJRFareRulesResponse == null || cJRFareRulesResponse.getBody() == null || this.mFareRulesResponse.getBody().getMinirules() == null)) {
                cJRMIniRules = this.mFareRulesResponse.getBody().getMinirules();
            }
            this.mReviewDetailsAdapter = new j(this, cJRFlightDetails, cJRFlightSearchInput, this, nearbyAirports, cJRMIniRules, this.mSellingBundleData, this, this.bookingSegment);
            j jVar = this.mReviewDetailsAdapter;
            jVar.f24676d = this.mTripType;
            this.mReviewRecylerView.setAdapter(jVar);
        }
    }

    private void navigateToTravellersItenaryPage() {
        if (this.mFareRulesGreyBgLayout.getVisibility() == 0) {
            closeButtonClicked();
        }
        SendPulseContinueClickEvent();
        Intent intent = new Intent(this, AJRFlightTravellersItenary.class);
        CJRFlightSearchResult cJRFlightSearchResult = this.mFlightSearchResult;
        if (!(cJRFlightSearchResult == null || cJRFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getGst() == null)) {
            this.mFlightDetails.setGst(this.mFlightSearchResult.getmOnwardReturnFlights().getGst());
        }
        boolean z = false;
        if (this.bookingSegment == com.travel.flight.flightticket.d.b.Modify) {
            intent.setClass(this, AJRFlightConfirmation.class);
            intent.putExtra("booking_segment", 0);
            intent.putExtra("MODIFY_BOOKING_PASSENGERS", this.mFlightDetails.getmPassengerInfo());
            if (this.mFlightSearchResult.getmOnwardReturnFlights().getGstDetails() != null) {
                GSTDetailsReviewPage gstDetails = this.mFlightSearchResult.getmOnwardReturnFlights().getGstDetails();
                CJRGSTPassengerInfo cJRGSTPassengerInfo = new CJRGSTPassengerInfo();
                cJRGSTPassengerInfo.setGSTNumber(gstDetails.getGstNumber());
                cJRGSTPassengerInfo.setCompanyAddress(gstDetails.getPlaceOfSupply());
                cJRGSTPassengerInfo.setCompanyGstEmail(gstDetails.getCompanyGstEmail());
                cJRGSTPassengerInfo.setStateOfResidence(gstDetails.getStateCode());
                cJRGSTPassengerInfo.setCompanyName(gstDetails.getCompanyName());
                intent.putExtra("flight_gst_info", cJRGSTPassengerInfo);
            }
            Double valueOf = Double.valueOf(Double.parseDouble(this.mBookingAmount.getText().toString().replace(AppConstants.COMMA, "")));
            if (this.mFlightDetails.getJourneyDetails().getRequestId() == null) {
                this.mFlightDetails.getJourneyDetails().setRequestId(this.mRequestId);
            }
            intent.putExtra("flight_confirmation_amount", valueOf);
        }
        intent.putExtra("intent_extra_review_data", this.mFlightDetails);
        intent.putExtra("intent_extra_flight_fare_rules", this.mFareRulesResponse);
        intent.putExtra("intent_extra_search_input_data", this.mSearchInputs);
        intent.putExtra("intent_extra_trip_type", this.mTripType);
        intent.putExtra("acceptType", this.acceptType);
        intent.putExtra("isShare", this.isSharedDeeplink);
        if (!this.isSnackBarClosedByUser) {
            z = this.isCashBackSnackBarVisible;
        }
        excludeUnSerilaisedDataFromPojo();
        String str = this.mPaymentIntent;
        if (str != null) {
            intent.putExtra("intent_extra_flight_payment_intent", str);
        }
        intent.putExtra("intent_extra_is_cashback_snackbar_visible", z);
        startActivityForResult(intent, 4);
    }

    private void excludeUnSerilaisedDataFromPojo() {
        if (this.mFlightDetails.getPromoResponse() != null && this.mFlightDetails.getPromoResponse().getBody() != null) {
            if (this.mFlightDetails.getPromoResponse().getBody().getPayment_instruments() != null) {
                this.mFlightDetails.getPromoResponse().getBody().setPayment_instruments((CJPayMethodResponse) null);
            }
            if (this.mFlightDetails.getPromoResponse().getBody().getPaymentInfo() != null) {
                this.mFlightDetails.getPromoResponse().getBody().setPaymentInfo((CJRFlightPaymentInfo) null);
            }
            if (this.mFlightDetails.getPromoResponse().getBody().getPromoMetaData() != null) {
                this.mFlightDetails.getPromoResponse().getBody().setPromoMetaData((CJRPromoMetaData) null);
            }
        }
    }

    private void loadOffers() {
        if (com.paytm.utility.b.c((Context) this)) {
            if (this.mFlightDetails == null) {
                this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
                if (this.mFlightDetails == null) {
                    return;
                }
            }
            String str = "";
            String str2 = (this.mFlightDetails.getmFareDetails() == null || TextUtils.isEmpty(this.mFlightDetails.getmFareDetails().getmFlightCost())) ? str : this.mFlightDetails.getmFareDetails().getmFlightCost();
            com.travel.flight.b.a();
            String Z = com.travel.flight.b.b().Z();
            StringBuilder sb = new StringBuilder();
            sb.append(Z);
            sb.append("provider=");
            sb.append(this.mFlightDetails.getmOnwardServiceProvider());
            sb.append("&price=");
            sb.append(str2);
            if (!TextUtils.isEmpty(this.acceptType)) {
                str = "&type=" + this.acceptType;
            }
            sb.append(str);
            String str3 = sb.toString() + "&userType=" + this.profileType;
            if (!TextUtils.isEmpty(this.mSearchInputs.getmDeeplinkFilterAirlineCodes())) {
                str3 = str3 + "&airline_code=" + this.mSearchInputs.getmDeeplinkFilterAirlineCodes();
            }
            if (URLUtil.isValidUrl(str3)) {
                String str4 = this.mRequestId;
                CJRFlightOffer cJRFlightOffer = new CJRFlightOffer();
                AnonymousClass2 r3 = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AJRFlightReviewItenarary.this.removeProgressDialog();
                        if (iJRPaytmDataModel instanceof CJRFlightOfferV2) {
                            CJRFlightOfferV2 cJRFlightOfferV2 = (CJRFlightOfferV2) iJRPaytmDataModel;
                            CJRFlightOffer unused = AJRFlightReviewItenarary.this.mOffers = cJRFlightOfferV2.getFlightOffer();
                            AJRFlightReviewItenarary.this.mOffers.setStringResponseCodes(cJRFlightOfferV2.getStringResponse());
                            if (AJRFlightReviewItenarary.this.mReviewDetailsAdapter != null) {
                                j access$400 = AJRFlightReviewItenarary.this.mReviewDetailsAdapter;
                                access$400.f24673a = AJRFlightReviewItenarary.this.mOffers;
                                if (access$400.f24675c != null) {
                                    access$400.f24675c.f25250d = access$400.f24673a;
                                }
                                access$400.a();
                                access$400.notifyDataSetChanged();
                            }
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AJRFlightReviewItenarary.this.removeProgressDialog();
                    }
                };
                if (URLUtil.isValidUrl(str3)) {
                    String s = com.paytm.utility.b.s(this, str3);
                    if (!TextUtils.isEmpty(str4)) {
                        s = c.a(s, str4, 0);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this;
                    bVar.n = a.b.SILENT;
                    bVar.o = getClass().getSimpleName();
                    bVar.f42878b = a.c.FLIGHT;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = s;
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42884h = null;
                    bVar.f42885i = cJRFlightOffer;
                    bVar.j = r3;
                    bVar.t = null;
                    bVar.l().a();
                    return;
                }
                return;
            }
            removeProgressDialog();
        }
    }

    private boolean checkMiniRulesEnabled() {
        CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
        return (cJRFlightDetails == null || cJRFlightDetails.getmMetaDetails() == null || this.mFlightDetails.getmMetaDetails().getEnabledFeatures() == null || !this.mFlightDetails.getmMetaDetails().getEnabledFeatures().isMinirules()) ? false : true;
    }

    private void callFareRulesApi() {
        String str;
        com.travel.flight.b.a();
        String u = com.travel.flight.b.b().u();
        if (!TextUtils.isEmpty(u)) {
            CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
            if (!(cJRFlightDetails == null || cJRFlightDetails.getmMetaDetails() == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(u);
                sb.append("requestid=");
                sb.append(this.mFlightDetails.getmMetaDetails().getmRequestId());
                if (!TextUtils.isEmpty(this.acceptType)) {
                    str = "&type=" + this.acceptType;
                } else {
                    str = "";
                }
                sb.append(str);
                u = sb.toString();
            }
            CJRFlightDetails cJRFlightDetails2 = this.mFlightDetails;
            if (!(cJRFlightDetails2 == null || cJRFlightDetails2.getmFareDetails() == null || this.mFlightDetails.getmFareDetails().getmOnwardPriceId() == null || this.mFlightDetails.getmFareDetails().getmReturnPriceId() == null)) {
                u = v.a(u, c.a(checkforCombination(), this.mFlightDetails.getmFareDetails().getmOnwardPriceId(), this.mFlightDetails.getmFareDetails().getmReturnPriceId()));
            }
            CJRFlightDetails cJRFlightDetails3 = this.mFlightDetails;
            if (!(cJRFlightDetails3 == null || cJRFlightDetails3.getmOnwardJourney() == null || this.mFlightDetails.getmOnwardJourney().getmFlightId() == null || this.mFlightDetails.getmOnwardServiceProvider() == null)) {
                u = u + "&onward_flightid=" + this.mFlightDetails.getmOnwardJourney().getmFlightId() + "&onward_provider=" + this.mFlightDetails.getmOnwardServiceProvider();
            }
            CJRFlightDetails cJRFlightDetails4 = this.mFlightDetails;
            if (!(cJRFlightDetails4 == null || cJRFlightDetails4.getmReturnJourney() == null || this.mFlightDetails.getmReturnJourney().getmFlightId() == null || this.mFlightDetails.getmReturnServiceProvider() == null)) {
                u = u + "&return_flightid=" + this.mFlightDetails.getmReturnJourney().getmFlightId() + "&return_provider=" + this.mFlightDetails.getmReturnServiceProvider();
            }
            String str2 = v.a(v.a(v.a(u, AppConstants.AND_SIGN, "is_combined", "=", String.valueOf(checkforCombination()), AppConstants.AND_SIGN, "is_roundtrip", "=", String.valueOf(this.isRoundTrip)), AppConstants.AND_SIGN, "baggage_policy", "=", String.valueOf(Boolean.TRUE), AppConstants.AND_SIGN, "cancellation_policy", "=", String.valueOf(Boolean.TRUE), AppConstants.AND_SIGN, "modification_policy", "=", String.valueOf(Boolean.TRUE), AppConstants.AND_SIGN, "review_summary", "=", String.valueOf(Boolean.TRUE)), AppConstants.AND_SIGN, "type", "=", this.acceptType) + "&type=regular";
            if (URLUtil.isValidUrl(str2)) {
                if (com.paytm.utility.b.c((Context) this)) {
                    showProgressDialog(getResources().getString(R.string.review_dialog));
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getApplicationContext()));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = getApplicationContext();
                    bVar.n = a.b.SILENT;
                    bVar.o = AJRFlightReviewItenarary.class.getSimpleName();
                    bVar.f42878b = a.c.FLIGHT;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = str2;
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42884h = null;
                    bVar.f42885i = new CJRFareRulesResponse();
                    bVar.j = this;
                    bVar.t = createDisplayErrorJsonObject();
                    bVar.l().a();
                    return;
                }
                showReviewApiNetworkDialog();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.acceptType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkforCombination() {
        /*
            r2 = this;
            boolean r0 = r2.isRoundTrip
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r2.acceptType
            if (r0 == 0) goto L_0x0012
            java.lang.String r1 = "combination"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0012
            r0 = 1
            return r0
        L_0x0012:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary.checkforCombination():boolean");
    }

    private void showReviewApiNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                AJRFlightReviewItenarary.this.callReviewAPI();
            }
        });
        builder.show();
    }

    private void callLoginActivity() {
        Intent intent = new Intent();
        com.travel.flight.b.a();
        com.travel.flight.b.b().a((Context) this, intent);
    }

    private boolean isAuthUser() {
        String b2 = com.travel.flight.utils.i.a(getApplicationContext()).b("sso_token=", "", true);
        if (b2 == null || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        CJRFlightPrice cJRFlightPrice;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 2) {
                if (intent != null) {
                    if (!intent.hasExtra("intent_extra_applied_promo_check_response") || intent.getSerializableExtra("intent_extra_applied_promo_check_response") == null) {
                        onPromoCodeRemoved();
                    } else {
                        this.mAppliedPromoCheckResponse = (CJRFlightPromoResponse) intent.getSerializableExtra("intent_extra_applied_promo_check_response");
                        CJRFlightPromoResponse cJRFlightPromoResponse = this.mAppliedPromoCheckResponse;
                        if (!(cJRFlightPromoResponse == null || cJRFlightPromoResponse.getBody() == null || this.mAppliedPromoCheckResponse.getBody().getPaytmPromocode() == null)) {
                            CJRFlightClientLoginPayload.getInstance().setEvent(Utility.EVENT_CATEGORY_PROMOCODE, this.mAppliedPromoCheckResponse.getBody().getPaytmPromocode());
                            if (this.mReviewDetailsAdapter != null) {
                                this.mFlightDetails.setPromoResponse(this.mAppliedPromoCheckResponse);
                                this.mReviewDetailsAdapter.a(this.mAppliedPromoCheckResponse);
                            }
                            if (intent.hasExtra("INTENT_EXTRA_PROMO_CODE_SOURCE")) {
                                new StringBuilder("|").append(intent.getStringExtra("INTENT_EXTRA_PROMO_CODE_SOURCE"));
                            }
                            showCashBackSnackBar();
                        }
                    }
                }
            } else if (i2 == 206) {
                if (intent != null) {
                    if (!(!intent.hasExtra("intent_extra_trip_type") || intent.getSerializableExtra("intent_extra_trip_type") == null || (cJRFlightPrice = (CJRFlightPrice) intent.getSerializableExtra("intent_extra_trip_type")) == null)) {
                        if (this.journeyTypeForPrices.equalsIgnoreCase("one_way")) {
                            this.mSearchInputs.setmSelcetedOnwardPriceId(cJRFlightPrice.getmFlightPriceId());
                        } else {
                            this.mSearchInputs.setmSelcetedReturnPriceId(cJRFlightPrice.getmFlightPriceId());
                        }
                        if (this.isRoundTrip) {
                            this.mSearchInputs.setmServiceProviserSelectedOnTop(cJRFlightPrice.getmServiceProvider());
                        } else {
                            this.mFlightDetails.setmOnwardServiceProvider(cJRFlightPrice.getmServiceProvider());
                        }
                        callReviewAPI();
                    }
                } else if (i2 == 3) {
                    navigateToTravellersItenaryPage();
                }
            }
        }
        if (i2 == 4 && intent != null) {
            if (!(!intent.hasExtra("cpStatus") || this.mReviewDetailsAdapter == null || intent.getBooleanExtra("cpStatus", false) == this.mFlightDetails.isInsuranceCancelProtectApplied())) {
                j jVar = this.mReviewDetailsAdapter;
                if (jVar.f24677e != null) {
                    p pVar = jVar.f24677e;
                    if (!(pVar.f25193d == null || pVar.f25192c == null)) {
                        pVar.f25193d.setChecked(false);
                        pVar.f25192c.setChecked(true);
                        if (pVar.f25190a != null) {
                            pVar.f25190a.reviewIternaryActionClick("", (Intent) null, Boolean.valueOf(pVar.f25193d.isChecked()), com.travel.flight.flightticket.d.c.CANCEL_PROTECT_INSURANCE_CHECKBOX);
                        }
                    }
                }
            }
            if (intent.hasExtra("intent_extra_flight_is_clear_review_bank_promo") && intent.getBooleanExtra("intent_extra_flight_is_clear_review_bank_promo", false)) {
                onPromoCodeRemoved();
            }
        }
    }

    private void showProgressDialog(String str) {
        if (!isFinishing()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new ProgressDialog(this);
                try {
                    this.mProgressDialog.setProgressStyle(0);
                    this.mProgressDialog.setMessage(str);
                    this.mProgressDialog.setCancelable(true);
                    this.mProgressDialog.setCanceledOnTouchOutside(false);
                    this.mProgressDialog.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void removeProgressDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    private void handleReviewResponse(CJRFlightSearchResult cJRFlightSearchResult) {
        CJRFlightPrice cJRFlightPrice;
        if (!isFinishing() && !isDestroyed()) {
            if (this.mFlightDetails == null) {
                this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
                if (this.mFlightDetails == null) {
                    finish();
                    return;
                }
            }
            if (cJRFlightSearchResult == null || cJRFlightSearchResult.getmStatus() == null || cJRFlightSearchResult.getmOnwardReturnFlights() == null || !cJRFlightSearchResult.getmStatus().getmResult().equalsIgnoreCase("success")) {
                CJRStatus cJRStatus = cJRFlightSearchResult.getmStatus();
                if (cJRStatus != null && cJRStatus.getmFlightMesssgae() != null && cJRStatus.getmFlightMesssgae().getmMessage() != null) {
                    com.paytm.utility.b.b((Context) this, cJRStatus.getmFlightMesssgae().getmTitle(), cJRStatus.getmFlightMesssgae().getmMessage());
                    sendPulseEventFlightReviewLoadFail(cJRStatus.getmFlightMesssgae().getmTitle());
                    return;
                }
                return;
            }
            this.mRequestId = cJRFlightSearchResult.getmMetaDetails().getmRequestId();
            this.mFlightDetails.setStatus(cJRFlightSearchResult.getmStatus());
            ArrayList<CJRFlightPrice> arrayList = null;
            if (this.isRoundTrip) {
                ArrayList<CJRFlightPrice> arrayList2 = this.mFlightDetails.getmReturnJourney() != null ? this.mFlightDetails.getmReturnJourney().getmPrice() : null;
                this.mFlightDetails.setmReturnJourney(cJRFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight().getmRepriceFlight());
                this.mFlightDetails.setmReturnServiceProvider(cJRFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight().getmRepriceProvider());
                if (this.mFlightDetails.getmReturnJourney() != null) {
                    this.mFlightDetails.getmReturnJourney().setmPrice(arrayList2);
                }
            } else {
                ArrayList<CJRFlightPrice> arrayList3 = this.mFlightDetails.getmOnwardJourney().getmPrice();
                if (arrayList3 != null && arrayList3.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList3.size()) {
                            break;
                        } else if (arrayList3.get(i2).getmServiceProvider().equalsIgnoreCase(this.mFlightDetails.getmOnwardServiceProvider())) {
                            cJRFlightPrice = arrayList3.get(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                cJRFlightPrice = null;
                if (cJRFlightPrice != null) {
                    this.mFlightDetails.setmFareDetails(cJRFlightPrice);
                }
                this.mFlightDetails.getmOnwardJourney().setmPrice(arrayList3);
            }
            if (cJRFlightSearchResult.getmOnwardReturnFlights().getmCJRMeta() != null) {
                this.mFlightDetails.setMeta(cJRFlightSearchResult.getmOnwardReturnFlights().getmCJRMeta());
            }
            this.mFlightDetails.setmRepriceFareDetails(cJRFlightSearchResult.getmOnwardReturnFlights().getmRepriceFare());
            this.mFlightDetails.setmMetaDetails(cJRFlightSearchResult.getmMetaDetails());
            this.mFlightDetails.setmOnwardServiceProvider(cJRFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight().getmRepriceProvider());
            if (this.mFlightDetails.getmOnwardJourney() != null) {
                arrayList = this.mFlightDetails.getmOnwardJourney().getmPrice();
            }
            this.mFlightDetails.setmOnwardJourney(cJRFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight().getmRepriceFlight());
            if (this.mFlightDetails.getmOnwardJourney() != null) {
                this.mFlightDetails.getmOnwardJourney().setmPrice(arrayList);
            }
            if (this.mFlightSearchResult.getmOnwardReturnFlights().isShareEnable()) {
                this.mShareIcon.setVisibility(0);
            }
            if (!(cJRFlightSearchResult.getmOnwardReturnFlights().getmCJRMeta() == null || cJRFlightSearchResult.getmOnwardReturnFlights().getmCJRMeta().getNotes() == null)) {
                this.mFlightDetails.setImportantNotes(cJRFlightSearchResult.getmOnwardReturnFlights().getmCJRMeta().getNotes());
            }
            if (this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceFare().getmConvenienceFee() != null) {
                this.mFlightDetails.setmConvenienceFee(this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceFare().getmConvenienceFee());
            }
            if (!TextUtils.isEmpty(cJRFlightSearchResult.getmOnwardReturnFlights().getmReviewInfoBoxHtml())) {
                this.mFlightDetails.setmReviewInfoBoxHtml(cJRFlightSearchResult.getmOnwardReturnFlights().getmReviewInfoBoxHtml());
            }
            if (!TextUtils.isEmpty(cJRFlightSearchResult.getmOnwardReturnFlights().getReview_info_box_html_bottom())) {
                this.mFlightDetails.setmReviewInfoBoxHtmlBottom(cJRFlightSearchResult.getmOnwardReturnFlights().getReview_info_box_html_bottom());
            }
            if (!TextUtils.isEmpty(cJRFlightSearchResult.getmOnwardReturnFlights().getTraveller_details_info_box_html())) {
                this.mFlightDetails.setmTravelerDetailsInfoBoxHtml(cJRFlightSearchResult.getmOnwardReturnFlights().getTraveller_details_info_box_html());
            }
            if (!(this.mFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo() == null)) {
                if (this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getUmrahVisa() == null || TextUtils.isEmpty(this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getUmrahVisa())) {
                    this.mFlightDetails.setmUmraVisaMessage("");
                } else {
                    this.mFlightDetails.setmUmraVisaMessage(this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getUmrahVisa());
                }
                if (this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getOkToBoard() != null && !TextUtils.isEmpty(this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getOkToBoard())) {
                    List<String> importantInfoNotes = this.mFlightDetails.getImportantInfoNotes();
                    importantInfoNotes.add(this.mFlightSearchResult.getmOnwardReturnFlights().getAdditionalInfo().getOkToBoard());
                    this.mFlightDetails.setImportantNotes(importantInfoNotes);
                }
            }
            if (this.mFlightSearchResult.getmOnwardReturnFlights().getmPassengerInfo() != null) {
                this.mFlightDetails.setmPassengerInfo(this.mFlightSearchResult.getmOnwardReturnFlights().getmPassengerInfo());
            }
            updateJourneyDetailsAdapter();
            sendPulseEventFlightReviewLoadSuccess();
        }
    }

    private void updateJourneyDetailsAdapter() {
        setJourneyDetails();
        setBookingAmount();
    }

    private void showCashBackSnackBar() {
        if (this.mAppliedPromoCheckResponse.getBody().getPaytmCashback() > 0 || this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount() > 0 || this.mAppliedPromoCheckResponse.getBody().getPaytmPgcashback() > 0) {
            if (this.mCashBackSnackBar == null) {
                createCashBackSnackBar();
            }
            updateSnackBarMsg();
            this.mCashBackSnackBar.setVisibility(0);
            if (this.mCashBackSnackBar.getTag() != null) {
                this.mCashBackSnackBar.removeCallbacks((Runnable) this.mCashBackSnackBar.getTag());
            }
            AnonymousClass4 r0 = new Runnable() {
                public final void run() {
                    AJRFlightReviewItenarary.this.hideCashBackSnackBar();
                }
            };
            this.mCashBackSnackBar.setTag(r0);
            this.mCashBackSnackBar.postDelayed(r0, 5000);
            this.isCashBackSnackBarVisible = true;
            this.isSnackBarClosedByUser = false;
        }
    }

    private void createCashBackSnackBar() {
        this.mCashBackSnackBar = (ConstraintLayout) findViewById(R.id.snack_bar_lyt);
        this.mCashBackSnackBarTextView = (TextView) this.mCashBackSnackBar.findViewById(R.id.msg_txt);
        this.mCashBackSnackBar.findViewById(R.id.msg_icon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRFlightReviewItenarary.this.lambda$createCashBackSnackBar$0$AJRFlightReviewItenarary(view);
            }
        });
    }

    public /* synthetic */ void lambda$createCashBackSnackBar$0$AJRFlightReviewItenarary(View view) {
        this.isSnackBarClosedByUser = true;
        hideCashBackSnackBar();
    }

    private void updateSnackBarMsg() {
        TextView textView = this.mCashBackSnackBarTextView;
        if (textView != null && this.mAppliedPromoCheckResponse != null) {
            textView.setText(getSnackBarMsg());
        }
    }

    private CharSequence getSnackBarMsg() {
        int i2;
        String str;
        com.travel.flight.b.a();
        boolean w = com.travel.flight.b.b().w();
        double doubleValue = this.mFlightDetails.getmRepriceFareDetails().getmConvenienceFee().getMtotalConFee().doubleValue();
        double a2 = e.a(this.mFlightDetails);
        if (this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount() > 0) {
            i2 = this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount();
        } else {
            i2 = this.mAppliedPromoCheckResponse.getBody().getPaytmPgcashback() + this.mAppliedPromoCheckResponse.getBody().getPaytmCashback();
        }
        int i3 = ((int) a2) - i2;
        if (!w) {
            i3 = (int) (((double) i3) + doubleValue);
        }
        String a3 = c.a((double) i2);
        String a4 = c.a((double) i3);
        int i4 = 0;
        if (this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount() > 0) {
            str = String.format(getString(R.string.flight_bank_instant_discount), new Object[]{a3});
        } else {
            str = String.format(getString(R.string.flight_summary_cashback_yay), new Object[]{a3, a4});
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (true) {
            int indexOf = str.indexOf(FilterPriceSliderFragment.RUPEE_SYMBOL, i4);
            if (indexOf >= 0 && indexOf < str.length()) {
                i4 = indexOf + 1;
                arrayList.add(Integer.valueOf(indexOf));
            }
        }
        if (arrayList.size() <= 0) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (Integer intValue : arrayList) {
            int intValue2 = intValue.intValue();
            spannableString.setSpan(new TopAlignProportionalSpan(0.75f), intValue2, intValue2 + 1, 33);
        }
        return spannableString;
    }

    /* access modifiers changed from: private */
    public void hideCashBackSnackBar() {
        ConstraintLayout constraintLayout = this.mCashBackSnackBar;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            this.mCashBackSnackBar.removeCallbacks((Runnable) this.mCashBackSnackBar.getTag());
        }
        this.isCashBackSnackBarVisible = false;
        this.isSnackBarClosedByUser = true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mProgressDialog = null;
        if (this.mFlightDetails != null) {
            this.mFlightDetails = null;
        }
        if (this.mCashBackSnackBar != null) {
            this.mCashBackSnackBar = null;
        }
        if (this.mCashBackSnackBarTextView != null) {
            this.mCashBackSnackBarTextView = null;
        }
    }

    public void reviewIternaryActionClick(String str, Intent intent, Boolean bool, com.travel.flight.flightticket.d.c cVar) {
        CJRFlightOfferCode cJRFlightOfferCode;
        if (cVar != null) {
            String str2 = null;
            int i2 = 0;
            switch (cVar) {
                case NAVIGATE_TO_MINI_RULES:
                    handleSeeDetailsClick(checkMiniRulesEnabled(), h.FareBreakUp.toString());
                    return;
                case NAVIGATE_TO_CANCELLATION_RULES:
                    if (this.mFareRulesResponse != null) {
                        sendCustomPulseEvent("canellation_policy_clicked", (HashMap<String, Object>) null);
                        handleSeeDetailsClick(checkMiniRulesEnabled(), h.Cancellation.toString());
                        return;
                    }
                    return;
                case NAVIGATE_TO_FARE_RULES:
                    if (this.mFareRulesResponse != null) {
                        sendCustomPulseEvent("baggage_allowance_clicked", (HashMap<String, Object>) null);
                        handleSeeDetailsClick(checkMiniRulesEnabled(), h.Baggage.toString());
                        return;
                    }
                    return;
                case NAVIGATE_TO_OFFER_LIST:
                    onNavigateToOfferList(intent);
                    return;
                case NAVIGATE_TO_MORE_SELLER:
                    return;
                case ON_PROMO_CLICK:
                    if (isAuthUser()) {
                        this.mPromoCodeEntered = str;
                        this.isUpFrontPromo = true;
                        if (!(intent == null || !intent.hasExtra("INTENT_EXTRA_PROMO_CODE_SOURCE") || (cJRFlightOfferCode = (CJRFlightOfferCode) intent.getSerializableExtra("INTENT_EXTRA_PROMO_CODE_SOURCE")) == null)) {
                            this.UpFrontOfferCodeSelected = cJRFlightOfferCode;
                            if (cJRFlightOfferCode.getFilters() != null) {
                                str2 = cJRFlightOfferCode.getFilters().toString();
                            }
                        }
                        onPromoClick(this.mPromoCodeEntered, str2, (ArrayList<PaymentIntent>) null, (String) null, 0);
                        return;
                    }
                    callLoginActivity();
                    return;
                case ON_PROMO_TEXT_CHANGE:
                    onPromoTextChange(str);
                    return;
                case ON_PROMO_REMOVED:
                    onPromoCodeRemoved();
                    return;
                case NAVIGATE_TO_TC:
                    onNavigateToTermsAndCondition();
                    return;
                case CANCEL_PROTECT_INSURANCE_CHECKBOX:
                    if (bool.booleanValue()) {
                        sendPulseEventCP(true);
                        CJRFlightClientLoginPayload.getInstance().setEvent("is_cancellation_protect_selected", CommonPayParams.Builder.YES);
                    } else {
                        CJRFlightClientLoginPayload.getInstance().setEvent("is_cancellation_protect_selected", CommonPayParams.Builder.NO);
                    }
                    this.mFlightDetails.setInsuranceCancelProtectApplied(bool.booleanValue());
                    break;
                case CANCEL_PROTECT_TnC:
                    loadCancelProtectInsurance();
                    return;
                case ON_BUNDLE_SELECTED:
                    FlightSellingBundleResponseData flightSellingBundleResponseData = (FlightSellingBundleResponseData) intent.getSerializableExtra("INTENT_EXTRA_BUNDLE_INFO");
                    List<FlightSellingBundleResponseData> bundleList = this.mFlightDetails.getBundleList();
                    int i3 = 0;
                    while (true) {
                        if (i3 < bundleList.size()) {
                            if (bundleList.get(i3).getPartner_bundle_id().equalsIgnoreCase(flightSellingBundleResponseData.getPartner_bundle_id())) {
                                i2 = 1;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        sendPulseEventBundleSelected(flightSellingBundleResponseData.getProduct_title());
                        this.mFlightDetails.getBundleList().add(flightSellingBundleResponseData);
                    }
                    setBookingAmount();
                    updateSnackBarMsg();
                    return;
                case ON_BUNDLE_DESELECTED:
                    FlightSellingBundleResponseData flightSellingBundleResponseData2 = (FlightSellingBundleResponseData) intent.getSerializableExtra("INTENT_EXTRA_BUNDLE_INFO");
                    List<FlightSellingBundleResponseData> bundleList2 = this.mFlightDetails.getBundleList();
                    while (true) {
                        if (i2 >= bundleList2.size()) {
                            break;
                        } else if (bundleList2.get(i2).getPartner_bundle_id().equalsIgnoreCase(flightSellingBundleResponseData2.getPartner_bundle_id())) {
                            bundleList2.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                default:
                    return;
            }
            setBookingAmount();
            updateSnackBarMsg();
        }
    }

    public void updateJourneyTypeForPrices(String str) {
        this.journeyTypeForPrices = str;
    }

    public void showProgressBar() {
        showProgressDialog(getResources().getString(R.string.pre_f_please_wait_progress_msg));
    }

    public void onNavigateToOfferList(Intent intent) {
        startActivityForResult(intent, 2);
    }

    public void onNavigateToTermsAndCondition() {
        Intent intent = new Intent(this, FlightWebViewActivity.class);
        intent.putExtra("url", "https://paytm.com/terms");
        startActivity(intent);
    }

    public void onPromoTextChange(String str) {
        this.mPromoCodeEntered = str;
    }

    public void onPromoCodeRemoved() {
        this.mFlightDetails.setPromoResponse((CJRFlightPromoResponse) null);
        this.mPromoCodeEntered = null;
        this.mAppliedPromoCheckResponse = null;
        this.mPromoVerifyListener = null;
        this.mPaymentIntent = null;
        j jVar = this.mReviewDetailsAdapter;
        if (jVar != null) {
            jVar.a(this.mAppliedPromoCheckResponse);
        }
        hideCashBackSnackBar();
        setBookingAmount();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:21|(1:23)|24|(3:26|27|(4:29|(1:31)|32|(1:36)))|37|(1:39)|(2:41|(1:45))|46|47|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x013f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPromoClick(java.lang.String r15, java.lang.String r16, java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent> r17, java.lang.String r18, int r19) {
        /*
            r14 = this;
            r7 = r14
            r0 = r16
            r4 = r17
            r8 = r18
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01cf }
            if (r1 != 0) goto L_0x01b7
            boolean r1 = r14.isAuthUser()     // Catch:{ Exception -> 0x01cf }
            if (r1 == 0) goto L_0x01b3
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r14)     // Catch:{ Exception -> 0x01cf }
            if (r1 == 0) goto L_0x019b
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x01cf }
            int r2 = com.travel.flight.R.string.pre_f_please_wait_progress_msg     // Catch:{ Exception -> 0x01cf }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01cf }
            r14.showProgressDialog(r1)     // Catch:{ Exception -> 0x01cf }
            r9 = 0
            if (r4 == 0) goto L_0x0059
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x01cf }
            r1.<init>()     // Catch:{ Exception -> 0x01cf }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x01cf }
            r2.<init>()     // Catch:{ Exception -> 0x01cf }
            r3 = 0
        L_0x0034:
            int r5 = r17.size()     // Catch:{ Exception -> 0x01cf }
            if (r3 >= r5) goto L_0x0051
            java.lang.Object r5 = r4.get(r3)     // Catch:{ Exception -> 0x01cf }
            net.one97.paytm.nativesdk.common.model.PaymentIntent r5 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r5     // Catch:{ Exception -> 0x01cf }
            if (r5 == 0) goto L_0x004e
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x01cf }
            java.lang.String r5 = r2.a((java.lang.Object) r5)     // Catch:{ Exception -> 0x01cf }
            r6.<init>(r5)     // Catch:{ Exception -> 0x01cf }
            r1.put(r6)     // Catch:{ Exception -> 0x01cf }
        L_0x004e:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x0051:
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x01cf }
            r7.mPaymentIntent = r2     // Catch:{ Exception -> 0x01cf }
            r10 = r1
            goto L_0x005c
        L_0x0059:
            r7.mPaymentIntent = r9     // Catch:{ Exception -> 0x01cf }
            r10 = r9
        L_0x005c:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r11 = r7.mFlightDetails     // Catch:{ Exception -> 0x01cf }
            java.lang.String r12 = r7.mRequestId     // Catch:{ Exception -> 0x01cf }
            com.travel.flight.flightticket.activity.AJRFlightReviewItenarary$5 r13 = new com.travel.flight.flightticket.activity.AJRFlightReviewItenarary$5     // Catch:{ Exception -> 0x01cf }
            r1 = r13
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r19
            r6 = r15
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x01cf }
            com.travel.flight.b.a()     // Catch:{ Exception -> 0x01cf }
            com.travel.flight.c r1 = com.travel.flight.b.b()     // Catch:{ Exception -> 0x01cf }
            java.lang.String r1 = r1.aa()     // Catch:{ Exception -> 0x01cf }
            boolean r2 = android.webkit.URLUtil.isValidUrl(r1)     // Catch:{ Exception -> 0x01cf }
            if (r2 == 0) goto L_0x019a
            java.lang.String r1 = com.paytm.utility.b.s(r14, r1)     // Catch:{ Exception -> 0x01cf }
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01cf }
            if (r2 != 0) goto L_0x008f
            r2 = r19
            java.lang.String r1 = com.travel.flight.utils.c.a((java.lang.String) r1, (java.lang.String) r12, (int) r2)     // Catch:{ Exception -> 0x01cf }
        L_0x008f:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x01cf }
            r2.<init>()     // Catch:{ Exception -> 0x01cf }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x01cf }
            java.lang.String r3 = "sso_token"
            java.lang.String r4 = com.paytm.utility.a.q(r14)     // Catch:{ Exception -> 0x01cf }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x01cf }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01cf }
            r3.<init>()     // Catch:{ Exception -> 0x01cf }
            if (r11 == 0) goto L_0x0117
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r4 = r11.getmRepriceFareDetails()     // Catch:{ Exception -> 0x013f }
            if (r4 == 0) goto L_0x0117
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r4 = r11.getmRepriceFareDetails()     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = r4.getTotalFee()     // Catch:{ Exception -> 0x013f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x013f }
            if (r4 != 0) goto L_0x00cc
            java.lang.String r4 = "price"
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r5 = r11.getmRepriceFareDetails()     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = r5.getTotalFee()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
        L_0x00cc:
            java.lang.String r4 = "provider"
            java.lang.String r5 = r11.getmOnwardServiceProvider()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = "onward_provider"
            java.lang.String r5 = r11.getmOnwardServiceProvider()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = "onward_flightid"
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = r11.getmOnwardJourney()     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = r5.getmFlightId()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = r11.getmReturnServiceProvider()     // Catch:{ Exception -> 0x013f }
            if (r4 == 0) goto L_0x0117
            java.lang.String r4 = r11.getmReturnServiceProvider()     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = ""
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x013f }
            if (r4 != 0) goto L_0x0117
            java.lang.String r4 = "return_provider"
            java.lang.String r5 = r11.getmReturnServiceProvider()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
            java.lang.String r4 = "return_flightid"
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = r11.getmReturnJourney()     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = r5.getmFlightId()     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
        L_0x0117:
            java.lang.String r4 = "promocode"
            r5 = r15
            r3.put(r4, r15)     // Catch:{ Exception -> 0x013f }
            if (r0 == 0) goto L_0x0129
            java.lang.String r4 = "paymentFilters"
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x013f }
            r5.<init>(r0)     // Catch:{ Exception -> 0x013f }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x013f }
        L_0x0129:
            if (r10 == 0) goto L_0x013f
            java.lang.String r0 = "paymentIntent"
            r3.put(r0, r10)     // Catch:{ Exception -> 0x013f }
            if (r8 == 0) goto L_0x013f
            java.lang.String r0 = "[]"
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x013f }
            if (r0 != 0) goto L_0x013f
            java.lang.String r0 = "enable_upi_psp"
            r3.put(r0, r8)     // Catch:{ Exception -> 0x013f }
        L_0x013f:
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x01cf }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x01cf }
            android.net.Uri$Builder r1 = r1.buildUpon()     // Catch:{ Exception -> 0x01cf }
            java.lang.String r3 = "payment_info"
            java.lang.String r4 = "1"
            r1.appendQueryParameter(r3, r4)     // Catch:{ Exception -> 0x01cf }
            java.lang.String r3 = "payment_info_version"
            java.lang.String r4 = "2"
            r1.appendQueryParameter(r3, r4)     // Catch:{ Exception -> 0x01cf }
            android.net.Uri r1 = r1.build()     // Catch:{ Exception -> 0x01cf }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cf }
            com.paytm.network.b r3 = new com.paytm.network.b     // Catch:{ Exception -> 0x01cf }
            r3.<init>()     // Catch:{ Exception -> 0x01cf }
            r3.f42877a = r7     // Catch:{ Exception -> 0x01cf }
            com.paytm.network.a$b r4 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x01cf }
            r3.n = r4     // Catch:{ Exception -> 0x01cf }
            java.lang.Class r4 = r14.getClass()     // Catch:{ Exception -> 0x01cf }
            java.lang.String r4 = r4.getSimpleName()     // Catch:{ Exception -> 0x01cf }
            r3.o = r4     // Catch:{ Exception -> 0x01cf }
            com.paytm.network.a$c r4 = com.paytm.network.a.c.FLIGHT     // Catch:{ Exception -> 0x01cf }
            r3.f42878b = r4     // Catch:{ Exception -> 0x01cf }
            com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.POST     // Catch:{ Exception -> 0x01cf }
            r3.f42879c = r4     // Catch:{ Exception -> 0x01cf }
            r3.f42880d = r1     // Catch:{ Exception -> 0x01cf }
            r3.f42881e = r9     // Catch:{ Exception -> 0x01cf }
            r3.f42882f = r2     // Catch:{ Exception -> 0x01cf }
            r3.f42883g = r9     // Catch:{ Exception -> 0x01cf }
            r3.f42884h = r0     // Catch:{ Exception -> 0x01cf }
            com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r0 = new com.travel.flight.pojo.flightticket.CJRFlightPromoResponse     // Catch:{ Exception -> 0x01cf }
            r0.<init>()     // Catch:{ Exception -> 0x01cf }
            r3.f42885i = r0     // Catch:{ Exception -> 0x01cf }
            r3.j = r13     // Catch:{ Exception -> 0x01cf }
            r3.t = r9     // Catch:{ Exception -> 0x01cf }
            com.paytm.network.a r0 = r3.l()     // Catch:{ Exception -> 0x01cf }
            r0.a()     // Catch:{ Exception -> 0x01cf }
        L_0x019a:
            return
        L_0x019b:
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ Exception -> 0x01cf }
            int r1 = com.travel.flight.R.string.no_connection     // Catch:{ Exception -> 0x01cf }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x01cf }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x01cf }
            int r2 = com.travel.flight.R.string.no_internet     // Catch:{ Exception -> 0x01cf }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01cf }
            com.paytm.utility.b.b((android.content.Context) r14, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01cf }
            return
        L_0x01b3:
            r14.callLoginActivity()     // Catch:{ Exception -> 0x01cf }
            return
        L_0x01b7:
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ Exception -> 0x01cf }
            int r1 = com.travel.flight.R.string.error     // Catch:{ Exception -> 0x01cf }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x01cf }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ Exception -> 0x01cf }
            int r2 = com.travel.flight.R.string.msg_promo_code_missing_message     // Catch:{ Exception -> 0x01cf }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01cf }
            com.paytm.utility.b.b((android.content.Context) r14, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01cf }
            return
        L_0x01cf:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            com.paytm.utility.b.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary.onPromoClick(java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, int):void");
    }

    /* access modifiers changed from: private */
    public void handlePromoCodeResponse(CJRFlightPromoResponse cJRFlightPromoResponse, String str, ArrayList<PaymentIntent> arrayList, int i2) {
        String str2;
        m mVar = this.mFlightAlertDialog;
        if (mVar.f24910b != null && mVar.f24910b.isShowing()) {
            mVar.f24910b.dismiss();
            mVar.f24909a = false;
        }
        if (cJRFlightPromoResponse == null || cJRFlightPromoResponse.getBody() == null) {
            sendPulseEventPromoError(getResources().getString(R.string.msg_invalid_flight_promo_code), "");
            if (cJRFlightPromoResponse != null) {
                informErrorToPromoInterface(getNetworkErrorObject(cJRFlightPromoResponse, this.mPromoCodeEntered), cJRFlightPromoResponse.getCode().intValue());
                return;
            }
            return;
        }
        CJRFlightPromoBody body = cJRFlightPromoResponse.getBody();
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = getVerifyResponseData(body, i2);
        if (TextUtils.isEmpty(body.getPaytmPromocode())) {
            body.setPaytmPromocode(this.mPromoCodeEntered);
        }
        if (TextUtils.isEmpty(body.getPromostatus()) || !body.getPromostatus().trim().equalsIgnoreCase("SUCCESS")) {
            if (!TextUtils.isEmpty(body.getPromofailuretext())) {
                str2 = body.getPromofailuretext();
            } else {
                str2 = getResources().getString(R.string.msg_invalid_flight_promo_code);
            }
            sendPulseEventPromoError(str2, body.getPaytmPromocode());
            if (str != null) {
                if (this.isUpFrontPromo) {
                    if (body.getPaymentInfo() == null || body.getPayment_instruments() == null) {
                        handlerPromocodeError(getNetworkErrorObject(cJRFlightPromoResponse, str2), cJRFlightPromoResponse.getCode().intValue(), body.getPaytmPromocode(), i2);
                    } else {
                        openPromoBottomSheet(body, verifyResponseData);
                    }
                } else if (this.mPromoVerifyListener != null && body.getPayment_instruments() != null) {
                    this.mPromoVerifyListener.onVerifyPromoSuccess(body.getPayment_instruments(), false, verifyResponseData);
                }
            } else if (i2 != 1 || !isBankPromo(body)) {
                NetworkCustomError networkErrorObject = getNetworkErrorObject(cJRFlightPromoResponse, str2);
                handlerPromocodeError(networkErrorObject, cJRFlightPromoResponse.getCode().intValue(), body.getPaytmPromocode(), i2);
                informErrorToPromoInterface(networkErrorObject, cJRFlightPromoResponse.getCode().intValue());
            } else if (this.mPromoVerifyListener != null && cJRFlightPromoResponse.getBody().getPayment_instruments() != null) {
                this.mPromoVerifyListener.onVerifyPromoSuccess(cJRFlightPromoResponse.getBody().getPayment_instruments(), false, verifyResponseData);
            }
        } else {
            if (arrayList == null) {
                this.mPaymentIntent = null;
            }
            this.mAppliedPromoCheckResponse = cJRFlightPromoResponse;
            if (this.mFlightDetails == null) {
                this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
            }
            CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
            if (cJRFlightDetails != null) {
                cJRFlightDetails.setPromoResponse(this.mAppliedPromoCheckResponse);
            }
            this.mReviewDetailsAdapter.a(this.mAppliedPromoCheckResponse);
            VerifyPromoResultListener verifyPromoResultListener = this.mPromoVerifyListener;
            if (verifyPromoResultListener != null) {
                verifyPromoResultListener.onVerifyPromoSuccess(cJRFlightPromoResponse.getBody().getPayment_instruments(), true, verifyResponseData);
            }
            setBookingAmount();
            showCashBackSnackBar();
            sendCustomPulseEvent("promocode_applied", getDetailsMap(this.mPromoCodeEntered, (String) null));
            CJRFlightClientLoginPayload.getInstance().setEvent(Utility.EVENT_CATEGORY_PROMOCODE, body.getPaytmPromocode());
        }
    }

    private void openPromoBottomSheet(CJRFlightPromoBody cJRFlightPromoBody, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
        String str = cJRFlightPromoBody.getPaymentInfo() != null ? cJRFlightPromoBody.getPaymentInfo().mid : "";
        if (verifyResponseData.getIs8DigitBin() == null) {
            verifyResponseData.setIs8DigitBin(Boolean.FALSE);
        }
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(str, (Context) this, getSupportFragmentManager(), Double.parseDouble(cJRFlightPromoBody.getOrderTotal().toString()), cJRFlightPromoBody.getPayment_instruments(), (VerifyPromoCallbackListener) this, (OnPromoActivityDestroyListener) this, verifyResponseData);
    }

    private boolean isBankPromo(CJRFlightPromoBody cJRFlightPromoBody) {
        HashMap<String, CJRFlightCampaign> campData;
        CJRFlightCampaign cJRFlightCampaign;
        if (cJRFlightPromoBody.getPromoMetaData() == null || cJRFlightPromoBody.getPromoMetaData().getCampData() == null || (campData = cJRFlightPromoBody.getPromoMetaData().getCampData()) == null || (cJRFlightCampaign = campData.get(this.mPromoCodeEntered)) == null || cJRFlightCampaign.campaignType == null || !cJRFlightCampaign.campaignType.equalsIgnoreCase(Constants.BANK_OFFER_KEY)) {
            return false;
        }
        return true;
    }

    private NetworkCustomError getNetworkErrorObject(CJRFlightPromoResponse cJRFlightPromoResponse, String str) {
        NetworkCustomError networkCustomError = new NetworkCustomError("failure_error");
        if (cJRFlightPromoResponse.getStatus() == null || cJRFlightPromoResponse.getStatus().getMessage() == null || cJRFlightPromoResponse.getStatus().getMessage().getTitle() == null) {
            networkCustomError.setmAlertTitle(getString(R.string.some_went_wrong));
        } else {
            networkCustomError.setmAlertTitle(cJRFlightPromoResponse.getStatus().getMessage().getTitle());
        }
        networkCustomError.setAlertMessage(str);
        return networkCustomError;
    }

    /* access modifiers changed from: private */
    public void handlerPromocodeError(NetworkCustomError networkCustomError, int i2, String str, int i3) {
        CJRPromocodeErrorResponse cJRPromocodeErrorResponse = new CJRPromocodeErrorResponse();
        removeProgressDialog();
        if (networkCustomError != null) {
            try {
                if (!(networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null)) {
                    CJRPromocodeErrorResponse cJRPromocodeErrorResponse2 = (CJRPromocodeErrorResponse) new f().a(new String(networkCustomError.networkResponse.data), cJRPromocodeErrorResponse.getClass());
                    if (cJRPromocodeErrorResponse2 != null) {
                        String num = cJRPromocodeErrorResponse2.getCode().toString();
                        if (num != null && num.equalsIgnoreCase("503")) {
                            this.mReviewDetailsAdapter.a(getResources().getString(R.string.message_503));
                        } else if (!(cJRPromocodeErrorResponse2 == null || cJRPromocodeErrorResponse2.getStatus() == null || cJRPromocodeErrorResponse2.getStatus().getMessage() == null || cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage() == null)) {
                            this.mReviewDetailsAdapter.a(cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage());
                        }
                    }
                }
                if ((i2 == 401 || i2 == 500 || networkCustomError.getMessage().equalsIgnoreCase("failure_error")) && getLifecycle().a().isAtLeast(k.b.STARTED)) {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
                if (networkCustomError.getAlertMessage() != null) {
                    sendPulseEventPromoError(networkCustomError.getAlertMessage(), str);
                }
            } catch (Resources.NotFoundException e2) {
                com.paytm.utility.q.b(e2.getMessage());
            } catch (Exception e3) {
                com.paytm.utility.q.b(e3.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void informErrorToPromoInterface(NetworkCustomError networkCustomError, int i2) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        if (networkCustomError != null) {
            apiResponseError.setErrorMsg(networkCustomError.getAlertMessage());
            apiResponseError.setErrorTitle(networkCustomError.getAlertTitle());
            apiResponseError.setStatusCode(i2);
        }
        apiResponseError.setShouldClosePG(false);
        VerifyPromoResultListener verifyPromoResultListener = this.mPromoVerifyListener;
        if (verifyPromoResultListener != null) {
            verifyPromoResultListener.onVerifyPromoNetworkError(apiResponseError);
        }
    }

    private PaytmSDKRequestClient.VerifyResponseData getVerifyResponseData(CJRFlightPromoBody cJRFlightPromoBody, int i2) {
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        try {
            verifyResponseData.setOfferText(cJRFlightPromoBody.getPromotext());
            verifyResponseData.setPaytmCashBack((double) cJRFlightPromoBody.getPaytmCashback());
            verifyResponseData.setPaytmDiscount((double) cJRFlightPromoBody.getPaytmDiscount());
            if (cJRFlightPromoBody.getPaymentInfo() != null) {
                verifyResponseData.setMid(cJRFlightPromoBody.getPaymentInfo().mid);
            }
            boolean z = false;
            if (i2 == 1) {
                CJRPromoMetaData promoMetaData = cJRFlightPromoBody.getPromoMetaData();
                if (!(promoMetaData == null || promoMetaData.getPaymentData() == null)) {
                    CJRFlightPaymentData paymentData = promoMetaData.getPaymentData();
                    if (paymentData.is8DigitBin != null) {
                        z = paymentData.is8DigitBin.booleanValue();
                    }
                }
            } else if (!(this.UpFrontOfferCodeSelected == null || this.UpFrontOfferCodeSelected.getFilters() == null)) {
                z = ((Boolean) new JSONObject(this.UpFrontOfferCodeSelected.getFilters().toString()).get("is8DigitBin")).booleanValue();
            }
            verifyResponseData.setIs8DigitBin(Boolean.valueOf(z));
        } catch (Exception unused) {
        }
        return verifyResponseData;
    }

    public void openFareBreakupBottomSheet() {
        FlightFareBreakupBottomSheetView flightFareBreakupBottomSheetView = this.fareBottomSheet;
        if (flightFareBreakupBottomSheetView != null) {
            flightFareBreakupBottomSheetView.setFlightDetails(this.mFlightDetails);
            this.fareBottomSheet.setData(this.mFareRulesResponse, this.mFlightDetails, this.mAppliedPromoCheckResponse, this.mIsFromTravellerDetail);
            this.fareBottomSheet.b();
            if (!this.fareBottomSheet.d()) {
                sendCustomPulseEvent("fare_details_clicked", (HashMap<String, Object>) null);
            }
            this.fareBottomSheet.c();
        }
        hideCashBackSnackBar();
    }

    public void handleSeeDetailsClick(boolean z, String str) {
        if (this.mFareRulesGreyBgLayout.getVisibility() == 0) {
            closeButtonClicked();
            return;
        }
        this.mFareRulesGreyBgLayout.setVisibility(8);
        setTransparentStatusBar(false);
        this.mFareRulesAnimLayout.setVisibility(0);
        this.mCoordinatorLayout.setVisibility(8);
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("flightDetail", this.mFlightDetails);
        bundle.putBoolean("intent_extra_is_from_review", z);
        bundle.putSerializable("fareRules", this.mFareRulesResponse);
        bundle.putBoolean("isFromTravellerDetail", false);
        bundle.putBoolean("is_show_convenience_fee", true);
        bundle.putString("reviewItenaryPagetoOpen", str);
        dVar.setArguments(bundle);
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        a2.a(R.id.frame_fare_rules, dVar, "farerulesfragment").a("Review Itenarary");
        a2.b();
    }

    private void setBookingAmount() {
        double d2;
        String str;
        int i2;
        com.travel.flight.b.a();
        boolean w = com.travel.flight.b.b().w();
        if (this.mFlightDetails == null) {
            this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
            if (this.mFlightDetails == null) {
                finish();
                return;
            }
        }
        int a2 = this.mFlightDetails.getmConvenienceFee() != null ? c.a(this.mFlightDetails) : 0;
        if (w) {
            d2 = e.a(this.mFlightDetails);
            str = String.format(getResources().getString(R.string.flight_excluding_convenience_fee_msg), new Object[]{String.valueOf(a2)});
            if (this.mFlightDetails.isInsuranceCancelProtectApplied()) {
                str = str + " " + String.format(getResources().getString(R.string.and_cancel_protect_tooltip), new Object[]{getCancelProtectPerPassengerPrice()});
            }
            this.mAmountText.setText(getResources().getString(R.string.flight_total_airfare));
        } else {
            d2 = e.a(this.mFlightDetails, false);
            str = String.format(getResources().getString(R.string.flight_convenience_fee_args), new Object[]{String.valueOf(a2)});
            if (this.mFlightDetails.isInsuranceCancelProtectApplied()) {
                str = str + " " + String.format(getResources().getString(R.string.and_cancel_protect_tooltip), new Object[]{getCancelProtectPerPassengerPrice()});
            }
        }
        this.mConvFeeMsg.setText(str);
        CJRFlightPromoResponse cJRFlightPromoResponse = this.mAppliedPromoCheckResponse;
        if (cJRFlightPromoResponse == null || cJRFlightPromoResponse.getBody() == null || this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount() <= 0) {
            this.mBookingAmount.setText(c.a(d2));
        } else {
            String str2 = c.a(d2 - ((double) this.mAppliedPromoCheckResponse.getBody().getPaytmDiscount())) + " " + getResources().getString(R.string.rupee_plain) + c.a(d2);
            int lastIndexOf = str2.lastIndexOf(getResources().getString(R.string.rupee_plain));
            String i3 = c.i(str2);
            SpannableString spannableString = new SpannableString(i3);
            spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 1, i3.length(), 33);
            spannableString.setSpan(new TopAlignProportionalSpan(0.5f), lastIndexOf, i3.length(), 33);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf + 1, i3.length(), 33);
            this.mBookingAmount.setText(spannableString);
        }
        this.mToatslPaseeengetCountText.setVisibility(0);
        TextView textView = this.mToatslPaseeengetCountText;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.total_for_text));
        sb.append(" ");
        sb.append(this.mTotalPassenger);
        sb.append(" ");
        if (this.mTotalPassenger == 1) {
            i2 = R.string.traveler;
        } else {
            i2 = R.string.travelers;
        }
        sb.append(getString(i2));
        textView.setText(sb.toString());
        this.mRelativePaymentDetail.setVisibility(0);
    }

    private void handleBackPress() {
        d dVar = (d) getSupportFragmentManager().c("farerulesfragment");
        FlightFareBreakupBottomSheetView flightFareBreakupBottomSheetView = this.fareBottomSheet;
        if (flightFareBreakupBottomSheetView != null && flightFareBreakupBottomSheetView.d()) {
            this.fareBottomSheet.c();
        } else if (dVar == null || !dVar.isVisible()) {
            sendCustomPulseEvent("review_back_arrow_button_clicked", (HashMap<String, Object>) null);
            super.onBackPressed();
        } else {
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.f() > 0) {
                supportFragmentManager.d();
                setTransparentStatusBar(true);
                this.mFareRulesAnimLayout.setVisibility(8);
                this.mCoordinatorLayout.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_arrow || id == R.id.back_arrow_mini_rule_rule) {
            handleBackPress();
        } else if (id == R.id.proceed_to_book_btn) {
            navigateToTravellersItenaryPage();
        } else if (id == R.id.amount_detail) {
            openFareBreakupBottomSheet();
        } else if (id == R.id.flight_share_icon) {
            handleShareClick();
        }
    }

    private void handleShareClick() {
        if (this.mFlightDetails == null) {
            this.mFlightDetails = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
        }
        if (this.mFlightDetails != null) {
            try {
                this.mShareIcon.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_with_medium_anim_time));
                this.mShareIcon.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        AJRFlightReviewItenarary.this.mShareIcon.setClickable(true);
                        AJRFlightReviewItenarary.this.mShareIcon.clearAnimation();
                    }
                }, 1000);
                String string = getResources().getString(R.string.flight_review_itinerary_deeplink_title);
                String string2 = getResources().getString(R.string.flight_review_itinerary_deeplink_desc);
                String str = "https://s3-us-west-2.amazonaws.com/paytm-travel/Marketing/Prachi/train_icon/240x240.jpg";
                if (!(this.mFlightSearchResult.getmOnwardReturnFlights().getmShareDetails() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getmShareDetails().getTitle() == null)) {
                    string = this.mFlightSearchResult.getmOnwardReturnFlights().getmShareDetails().getTitle();
                    string2 = this.mFlightSearchResult.getmOnwardReturnFlights().getmShareDetails().getDesc();
                    str = this.mFlightSearchResult.getmOnwardReturnFlights().getmShareDetails().getIconUrl();
                }
                Uri.Builder buildUpon = Uri.parse("paytmmp://branchShare?b_key=flightreview").buildUpon();
                buildUpon.appendQueryParameter("requestid", this.mRequestId);
                buildUpon.appendQueryParameter("departureDate", this.mSearchInputs.getDate());
                if (!TextUtils.isEmpty(this.mSearchInputs.getReturnDate())) {
                    buildUpon.appendQueryParameter("returnDate", this.mSearchInputs.getReturnDate());
                }
                if (this.mSearchInputs.getmCount_adults() > 0) {
                    buildUpon.appendQueryParameter("adults", String.valueOf(this.mSearchInputs.getmCount_adults()));
                }
                if (this.mSearchInputs.getmCount_childerns() > 0) {
                    buildUpon.appendQueryParameter("children", String.valueOf(this.mSearchInputs.getmCount_childerns()));
                }
                if (this.mSearchInputs.getmCount_infants() > 0) {
                    buildUpon.appendQueryParameter("infants", String.valueOf(this.mSearchInputs.getmCount_infants()));
                }
                buildUpon.appendQueryParameter(Item.KEY_CLASS, this.mSearchInputs.getClassType());
                if (!TextUtils.isEmpty(this.mServiceProvider)) {
                    buildUpon.appendQueryParameter("onward_provider", this.mServiceProvider);
                }
                if (!TextUtils.isEmpty(this.mSearchInputs.getmServiceProviserSelectedOnTop())) {
                    buildUpon.appendQueryParameter("return_provider", this.mSearchInputs.getmServiceProviserSelectedOnTop());
                }
                buildUpon.appendQueryParameter("onward_flightid", this.mFlightDetails.getmOnwardJourney().getmFlightId());
                if (!TextUtils.isEmpty(this.mSearchInputs.getmSelcetedOnwardPriceId())) {
                    buildUpon.appendQueryParameter("onward_price_id", this.mSearchInputs.getmSelcetedOnwardPriceId());
                }
                if (this.isRoundTrip && !TextUtils.isEmpty(this.mFlightDetails.getmReturnJourney().getmFlightId())) {
                    buildUpon.appendQueryParameter("return_flightid", this.mFlightDetails.getmReturnJourney().getmFlightId());
                }
                if (!TextUtils.isEmpty(this.mSearchInputs.getmSelcetedReturnPriceId())) {
                    buildUpon.appendQueryParameter("return_price_id", this.mSearchInputs.getmSelcetedReturnPriceId());
                }
                buildUpon.appendQueryParameter("origin", this.mSearchInputs.getSource().getShortCityName());
                buildUpon.appendQueryParameter("src_city_name", this.mSearchInputs.getSource().getCityName());
                buildUpon.appendQueryParameter("destination", this.mSearchInputs.getDestination().getShortCityName());
                buildUpon.appendQueryParameter("dest_city_name", this.mSearchInputs.getDestination().getCityName());
                buildUpon.appendQueryParameter("type", this.acceptType);
                buildUpon.appendQueryParameter("isRoundTrip", this.mTripType);
                buildUpon.appendQueryParameter("isShare", "true");
                buildUpon.appendQueryParameter("as_origin_pos", String.valueOf(this.mSearchInputs.getmAutoSuggestOriginPos()));
                buildUpon.appendQueryParameter("as_destination_pos", String.valueOf(this.mSearchInputs.getmAutoSuggestDestinationPos()));
                buildUpon.appendQueryParameter("as_origin", this.mSearchInputs.getmAutoSuggestOriginSearchKey());
                buildUpon.appendQueryParameter("as_destination", this.mSearchInputs.getmAutoSuggestDestinationSearchKey());
                buildUpon.appendQueryParameter("title", string);
                buildUpon.appendQueryParameter(RequestConfirmationDialogFragment.KEY_DESCRIPTION, string2);
                buildUpon.appendQueryParameter("imgUrl", str);
                buildUpon.appendQueryParameter("campaignDisplayName", "flights");
                buildUpon.build();
                com.travel.flight.b.a();
                com.travel.flight.b.b();
                sendShareClickPulseEvent();
            } catch (Exception e2) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
    }

    public void sendShareClickPulseEvent() {
        try {
            sendCustomPulseEvent("share_button_clicked", (HashMap<String, Object>) null);
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing()) {
            int i2 = 0;
            if (iJRPaytmDataModel instanceof CJRFlightSearchResult) {
                this.mFlightSearchResult = (CJRFlightSearchResult) iJRPaytmDataModel;
                if (!(this.mFlightDetails == null || this.mFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight().getmRepriceFlight() == null || !this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight().getmRepriceFlight().getMealsAvaialable())) {
                    this.mFlightDetails.setOnwardMealsAvailable(this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceOnwardFlight().getmRepriceFlight().getMealsAvaialable());
                }
                if (!(this.mFlightDetails == null || this.mFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight() == null || this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight().getmRepriceFlight() == null || !this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight().getmRepriceFlight().getMealsAvaialable())) {
                    this.mFlightDetails.setReturnMealsAvailable(this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceReturnFlight().getmRepriceFlight().getMealsAvaialable());
                }
                if (!(this.mFlightDetails == null || this.mFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().paymentDetails == null)) {
                    this.mFlightDetails.setPaymentDetails(this.mFlightSearchResult.getmOnwardReturnFlights().paymentDetails);
                }
                if (!(this.mFlightDetails == null || this.mFlightSearchResult.getmOnwardReturnFlights() == null || this.mFlightSearchResult.getmOnwardReturnFlights().importantNotes == null)) {
                    this.mFlightDetails.setImportantNotes(this.mFlightSearchResult.getmOnwardReturnFlights().importantNotes);
                }
                if (!(this.mFlightDetails == null || this.mFlightSearchResult.getmOnwardReturnFlights() == null)) {
                    this.mFlightDetails.setSessionInfo(this.mFlightSearchResult.getmOnwardReturnFlights().getSessionInfo());
                }
                removeProgressDialog();
                handleReviewResponse(this.mFlightSearchResult);
                if (checkMiniRulesEnabled()) {
                    callFareRulesApi();
                }
                if (this.bookingSegment != com.travel.flight.flightticket.d.b.Modify) {
                    e eVar = this.mReviewPresenter;
                    CJRFlightDetails cJRFlightDetails = this.mFlightDetails;
                    CJRFlightSearchResult cJRFlightSearchResult = this.mFlightSearchResult;
                    HashMap hashMap = new HashMap();
                    if (cJRFlightDetails != null) {
                        CJRMetadetails cJRMetadetails = cJRFlightSearchResult.getmMetaDetails();
                        if (cJRMetadetails != null) {
                            hashMap.put("requestid", cJRMetadetails.getmRequestId());
                            if (cJRMetadetails.getQuery() != null) {
                                String str = "";
                                hashMap.put("src_countrycode", cJRMetadetails.getQuery() != null ? cJRMetadetails.getQuery().getOrigin_country_code() : str);
                                if (cJRMetadetails.getQuery() != null) {
                                    str = cJRMetadetails.getQuery().getDestination_country_code();
                                }
                                hashMap.put("dest_countrycode", str);
                            }
                        }
                        CJRFlightDetailsItem cJRFlightDetailsItem = cJRFlightDetails.getmOnwardJourney();
                        CJRFlightDetailsItem cJRFlightDetailsItem2 = cJRFlightDetails.getmReturnJourney();
                        if (cJRFlightDetailsItem != null) {
                            hashMap.put("onward_flightid", cJRFlightDetailsItem.getmFlightId());
                            hashMap.put("source", cJRFlightDetailsItem.getmOrigin());
                            hashMap.put("destination", cJRFlightDetailsItem.getmDestination());
                        }
                        if (cJRFlightDetailsItem2 != null) {
                            hashMap.put("return_flightid", cJRFlightDetailsItem2.getmFlightId());
                        }
                        if (!TextUtils.isEmpty(cJRFlightDetails.getmOnwardServiceProvider())) {
                            hashMap.put("onward_provider", cJRFlightDetails.getmOnwardServiceProvider());
                        }
                        if (!TextUtils.isEmpty(cJRFlightDetails.getmReturnServiceProvider())) {
                            hashMap.put("return_provider", cJRFlightDetails.getmReturnServiceProvider());
                        }
                        if (cJRFlightDetailsItem2 != null) {
                            hashMap.put("type", "combination");
                        } else {
                            hashMap.put("type", "regular");
                        }
                        hashMap.put("opened_from", CLPConstants.GA_CHANNEL_NAME);
                    }
                    com.travel.flight.flightticket.h.a aVar = eVar.f25023a;
                    kotlin.g.b.k.c(hashMap, "additionalParams");
                    kotlin.g.b.k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                    com.travel.flight.c b2 = com.travel.flight.b.b();
                    kotlin.g.b.k.a((Object) b2, "FlightController.getInstance().flightEventListener");
                    Context a2 = b2.a();
                    kotlin.g.b.k.a((Object) a2, "FlightController.getInst…stener.applicationContext");
                    com.travel.flight.b.a();
                    com.travel.flight.c b3 = com.travel.flight.b.b();
                    kotlin.g.b.k.a((Object) b3, "FlightController.getInst….getFlightEventListener()");
                    String S = b3.S();
                    com.travel.flight.b.a();
                    String str2 = S + "?userType=" + com.travel.flight.b.b().e(a2);
                    CharSequence charSequence = str2;
                    if (charSequence == null || charSequence.length() == 0) {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = a2;
                        bVar.n = a.b.SILENT;
                        bVar.o = AJRFlightReviewItenarary.class.getSimpleName();
                        bVar.f42878b = a.c.FLIGHT;
                        bVar.f42879c = a.C0715a.GET;
                        bVar.f42880d = str2;
                        bVar.f42885i = new FlightBundle((Integer) null, (FlightSellingBundleResponse) null);
                        bVar.j = aVar;
                        bVar.f42883g = hashMap;
                        y.a aVar2 = y.f24137a;
                        bVar.t = y.a.a();
                        com.paytm.network.a l = bVar.l();
                        kotlin.g.b.k.a((Object) l, "CJRCommonNetworkCallBuil…\n                .build()");
                        l.a();
                    }
                    loadOffers();
                    fetchInsurance();
                }
            } else if (iJRPaytmDataModel instanceof CJRFareRulesResponse) {
                this.mFareRulesResponse = (CJRFareRulesResponse) iJRPaytmDataModel;
                FlightFareBreakupBottomSheetView flightFareBreakupBottomSheetView = this.fareBottomSheet;
                if (flightFareBreakupBottomSheetView != null) {
                    flightFareBreakupBottomSheetView.setData(this.mFareRulesResponse, this.mFlightDetails, this.mAppliedPromoCheckResponse, this.mIsFromTravellerDetail);
                }
                removeProgressDialog();
                j jVar = this.mReviewDetailsAdapter;
                if (jVar != null) {
                    jVar.f24678f = this.mFareRulesResponse.getBody().getMinirules();
                    jVar.a();
                    jVar.notifyDataSetChanged();
                }
            } else if (iJRPaytmDataModel instanceof CJRInsuranceModel) {
                removeProgressDialog();
                CJRInsuranceModel cJRInsuranceModel = (CJRInsuranceModel) iJRPaytmDataModel;
                if (this.mFlightDetails != null && cJRInsuranceModel.getBody() != null) {
                    this.mFlightDetails.setInsuranceData(cJRInsuranceModel);
                    if (this.mReviewDetailsAdapter != null && this.mFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail() != null && this.mFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().size() > 0) {
                        j jVar2 = this.mReviewDetailsAdapter;
                        CJRFlightDetails cJRFlightDetails2 = this.mFlightDetails;
                        jVar2.f24674b = cJRFlightDetails2;
                        jVar2.f24679g = cJRFlightDetails2.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0);
                        jVar2.a();
                        jVar2.notifyDataSetChanged();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRTpUserProfile) {
                removeProgressDialog();
                CJRTpUserProfile cJRTpUserProfile = (CJRTpUserProfile) iJRPaytmDataModel;
                CJRTpUserProfileBody body = cJRTpUserProfile.getBody();
                ArrayList<CJRTpUserProfileContact> contacts = cJRTpUserProfile.getBody().getContacts();
                if (contacts != null && this.mFlightDetails != null) {
                    while (i2 < contacts.size()) {
                        if (this.mFlightDetails.getmReturnJourney() != null) {
                            contacts.get(i2).setTravelDate(this.mSearchInputs.getReturnDate());
                        } else {
                            contacts.get(i2).setTravelDate(this.mSearchInputs.getDate());
                        }
                        i2++;
                    }
                    body.setContacts(contacts);
                    com.travel.flight.travellerProfile.a a3 = com.travel.flight.travellerProfile.a.a();
                    CJRTpUserProfileBody body2 = cJRTpUserProfile.getBody();
                    a3.f25522a = body2;
                    if (body2.getContacts() != null) {
                        a3.f25523b = body2.getContacts();
                    }
                }
            }
        }
    }

    public void onBackPressed() {
        handleBackPress();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0175, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0176, code lost:
        com.paytm.utility.q.b(r7.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017d, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007f */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0175 A[ExcHandler: NotFoundException (r7v1 'e' android.content.res.Resources$NotFoundException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleErrorCode(int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9) {
        /*
            r6 = this;
            r6.removeProgressDialog()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r9 == 0) goto L_0x016b
            java.lang.String r7 = r9.getUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x0018
            java.lang.String r7 = r9.getUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = "user_details_get"
            boolean r7 = r7.contains(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x0018
            return
        L_0x0018:
            java.lang.String r7 = r9.getUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = "minirules"
            boolean r7 = r7.contains(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x0025
            return
        L_0x0025:
            com.travel.flight.b.a()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.c r7 = com.travel.flight.b.b()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r7 = r7.t()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = r9.getUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r0 = 500(0x1f4, float:7.0E-43)
            if (r8 == 0) goto L_0x012c
            java.lang.String r8 = r9.getFullUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r7 = r8.contains(r7)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x012c
            com.travel.flight.pojo.model.a r7 = new com.travel.flight.pojo.model.a     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r7.<init>()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8 = 0
            com.paytm.network.model.NetworkResponse r1 = r9.networkResponse     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r1 == 0) goto L_0x007f
            com.google.gsonhtcfix.f r8 = new com.google.gsonhtcfix.f     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8.<init>()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r1 = new java.lang.String     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.paytm.network.model.NetworkResponse r2 = r9.networkResponse     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            byte[] r2 = r2.data     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r1.<init>(r2)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.Class<com.paytm.network.model.CJRIllegalCodeError> r2 = com.paytm.network.model.CJRIllegalCodeError.class
            java.lang.Object r8 = r8.a((java.lang.String) r1, r2)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.paytm.network.model.CJRIllegalCodeError r8 = (com.paytm.network.model.CJRIllegalCodeError) r8     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.paytm.network.model.NetworkResponse r1 = r9.networkResponse     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            byte[] r2 = r1.data     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r2 == 0) goto L_0x007f
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            byte[] r1 = r1.data     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            r1.<init>()     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            java.lang.Object r1 = r1.a((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            com.travel.flight.pojo.model.a r1 = (com.travel.flight.pojo.model.a) r1     // Catch:{ Exception -> 0x007f, NotFoundException -> 0x0175 }
            r7 = r1
        L_0x007f:
            java.lang.String r1 = r9.getAlertTitle()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r2 = r9.getAlertMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x00cd
            com.travel.flight.pojo.model.b r3 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r3 == 0) goto L_0x00cd
            com.travel.flight.pojo.model.b r3 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.c r3 = r3.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r3 == 0) goto L_0x00cd
            com.travel.flight.pojo.model.b r3 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.c r3 = r3.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r3 = r3.f25442a     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r3 != 0) goto L_0x00cd
            com.travel.flight.pojo.model.b r3 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.c r3 = r3.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r3 = r3.f25443b     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r3 != 0) goto L_0x00cd
            com.travel.flight.pojo.model.b r1 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.c r1 = r1.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r1 = r1.f25442a     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.b r7 = r7.getStatus()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.pojo.model.c r7 = r7.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r2 = r7.f25443b     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
        L_0x00cd:
            r3 = r2
            r2 = r1
            r6.sendPulseEventFlightReviewLoadFail(r2)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r7 = r6.isSharedDeeplink     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x00f5
            if (r8 == 0) goto L_0x00f5
            java.lang.String r7 = "FL5_3031"
            java.lang.String r8 = r8.getmInternalErrorCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x00f5
            android.content.res.Resources r7 = r6.getResources()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            int r8 = com.travel.flight.R.string.flight_change_dates     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r4 = r7.getString(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r5 = 1
            r0 = r6
            r1 = r6
            r0.showAlertWithButtonText(r1, r2, r3, r4, r5)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            return
        L_0x00f5:
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8 = 400(0x190, float:5.6E-43)
            if (r7 == r8) goto L_0x011b
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8 = 417(0x1a1, float:5.84E-43)
            if (r7 == r8) goto L_0x011b
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == r0) goto L_0x011b
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8 = 517(0x205, float:7.24E-43)
            if (r7 == r8) goto L_0x011b
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r8 = 522(0x20a, float:7.31E-43)
            if (r7 != r8) goto L_0x012c
        L_0x011b:
            android.content.res.Resources r7 = r6.getResources()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            int r8 = com.travel.flight.R.string.flight_view_updated_search_results     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r4 = r7.getString(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r5 = 0
            r0 = r6
            r1 = r6
            r0.showAlertWithButtonText(r1, r2, r3, r4, r5)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            return
        L_0x012c:
            com.travel.flight.b.a()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.travel.flight.c r7 = com.travel.flight.b.b()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r7 = r7.e()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = r9.getUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r8 == 0) goto L_0x0148
            java.lang.String r8 = r9.getFullUrl()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            boolean r7 = r8.contains(r7)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x0148
            return
        L_0x0148:
            int r7 = r9.getStatusCode()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == r0) goto L_0x015a
            java.lang.String r7 = r9.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = "failure_error"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            if (r7 == 0) goto L_0x016b
        L_0x015a:
            java.lang.String r7 = r9.getAlertTitle()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            java.lang.String r8 = r9.getAlertMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r9.getMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
            r9.getAlertMessage()     // Catch:{ NotFoundException -> 0x0175, Exception -> 0x016c }
        L_0x016b:
            return
        L_0x016c:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.b(r7)
            return
        L_0x0175:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public void closeButtonClicked() {
        RelativeLayout relativeLayout = this.mShadowLyt;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_flight_bottom_to_top_above_tab_close);
        this.mFareRulesAnimLayout.setVisibility(8);
        this.mFareRulesGreyBgLayout.setVisibility(8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AJRFlightReviewItenarary.this.mFareRulesGreyBgLayout.setVisibility(8);
            }
        });
        this.mFareRulesAnimLayout.setAnimation(loadAnimation);
    }

    private void fetchInsurance() {
        try {
            String insuranceURL = getInsuranceURL();
            if (!TextUtils.isEmpty(insuranceURL)) {
                showProgressDialog(getResources().getString(R.string.pre_f_please_wait_progress_msg));
                HashMap hashMap = new HashMap();
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                if (com.paytm.utility.b.r((Context) this)) {
                    hashMap.put("userId", com.paytm.utility.b.n((Context) this));
                }
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = AJRFlightReviewItenarary.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = insuranceURL;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRInsuranceModel();
                bVar.j = this;
                bVar.t = createDisplayErrorJsonObject();
                bVar.l().a();
            }
        } catch (Exception unused) {
            System.out.println("error");
        }
    }

    private String getInsuranceURL() {
        com.travel.flight.b.a();
        String e2 = com.travel.flight.b.b().e();
        if (TextUtils.isEmpty(e2)) {
            return e2;
        }
        StringBuilder sb = new StringBuilder(e2);
        String serviceprovider = getServiceprovider();
        sb.append("?requestid=" + this.mRequestId);
        if (!TextUtils.isEmpty(this.acceptType)) {
            sb.append("&type=" + this.acceptType);
        }
        if (this.isRoundTrip) {
            sb.append("&return_flightid=" + this.mFlightDetails.getmReturnJourney().getmFlightId());
            sb.append("&return_provider=".concat(String.valueOf(serviceprovider)));
        }
        sb.append("&onward_flightid=" + this.mFlightDetails.getmOnwardJourney().getmFlightId());
        sb.append("&onward_provider=".concat(String.valueOf(serviceprovider)));
        sb.append("&userType=" + this.profileType);
        return sb.toString();
    }

    private String getServiceprovider() {
        if (this.isRoundTrip) {
            return this.mSearchInputs.getmServiceProviserSelectedOnTop();
        }
        if (this.mFlightDetails.getmOnwardServiceProvider() != null) {
            return this.mFlightDetails.getmOnwardServiceProvider();
        }
        if (this.mFlightDetails.getmOnwardJourney() == null || this.mFlightDetails.getmOnwardJourney().getmServiceProviderSelected() == null) {
            return this.mFlightDetails.getmOnwardJourney().getmPrice().get(0).getmServiceProvider();
        }
        return this.mFlightDetails.getmOnwardJourney().getmServiceProviderSelected().getmServiceProvider();
    }

    private void loadCancelProtectInsurance() {
        if (this.mFlightDetails.getInsuranceData() != null) {
            String tnc = this.mFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getTnc();
            String addonType = this.mFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getAddonType();
            Intent intent = new Intent(this, AJREmbedWebView.class);
            intent.putExtra("url", tnc);
            intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, addonType);
            startActivity(intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = r3.mFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getPriceDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getCancelProtectPerPassengerPrice() {
        /*
            r3 = this;
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.mFlightDetails
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            if (r0 == 0) goto L_0x0044
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.mFlightDetails
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r0 = r0.getBody()
            java.util.List r0 = r0.getCancelProtectInsuranceDetail()
            if (r0 == 0) goto L_0x0044
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.mFlightDetails
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r0 = r0.getBody()
            java.util.List r0 = r0.getCancelProtectInsuranceDetail()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r0 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r0
            java.util.ArrayList r0 = r0.getPriceDetails()
            if (r0 == 0) goto L_0x0044
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0044
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail r0 = (com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail) r0
            java.lang.String r0 = r0.getPremiumPerPassenger()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = ""
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary.getCancelProtectPerPassengerPrice():java.lang.String");
    }

    public void showAlertWithButtonText(Context context, String str, String str2, String str3, final boolean z) {
        if (!((Activity) context).isFinishing()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(context);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(false);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(hVar.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            hVar.a(-3, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (z) {
                        AJRFlightReviewItenarary.this.openFlightHomePage();
                    } else if (AJRFlightReviewItenarary.this.isRoundTrip) {
                        AJRFlightReviewItenarary.this.callRoundTripSearchList();
                    } else {
                        AJRFlightReviewItenarary.this.callOneWaySearchList();
                    }
                    AJRFlightReviewItenarary.this.finish();
                }
            });
            hVar.show();
            hVar.getWindow().setAttributes(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void openFlightHomePage() {
        Uri.Builder buildUpon = Uri.parse("paytmmp://flightticket?url=paytm.com/flight-ticket").buildUpon();
        buildUpon.appendQueryParameter("isShare", String.valueOf(this.isSharedDeeplink));
        buildUpon.appendQueryParameter("source_city_short_name", this.mSearchInputs.getSourceCityCode());
        buildUpon.appendQueryParameter("source_city_name", this.mSearchInputs.getSource().getCityName());
        buildUpon.appendQueryParameter("destination_city_short_name", this.mSearchInputs.getDestCityCode());
        buildUpon.appendQueryParameter("destination_city_name", this.mSearchInputs.getDestination().getCityName());
        buildUpon.appendQueryParameter("flight_class", getClassForTrip(this.mSearchInputs.getClassType()));
        buildUpon.appendQueryParameter("flight_trip_type", this.mTripType);
        if (this.mSearchInputs.getmCount_adults() > 0) {
            buildUpon.appendQueryParameter("adults", String.valueOf(this.mSearchInputs.getmCount_adults()));
        }
        if (this.mSearchInputs.getmCount_childerns() > 0) {
            buildUpon.appendQueryParameter("children", String.valueOf(this.mSearchInputs.getmCount_childerns()));
        }
        if (this.mSearchInputs.getmCount_infants() > 0) {
            buildUpon.appendQueryParameter("infants", String.valueOf(this.mSearchInputs.getmCount_infants()));
        }
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(buildUpon.toString(), (Context) this, "");
    }

    /* renamed from: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f24798b = new int[com.travel.flight.flightticket.d.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b9 */
        static {
            /*
                com.travel.flight.flightticket.d.b[] r0 = com.travel.flight.flightticket.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24798b = r0
                r0 = 1
                int[] r1 = f24798b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightticket.d.b r2 = com.travel.flight.flightticket.d.b.Regular     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f24798b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightticket.d.b r3 = com.travel.flight.flightticket.d.b.Modify     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f24798b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightticket.d.b r4 = com.travel.flight.flightticket.d.b.Corporate     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.travel.flight.flightticket.d.c[] r3 = com.travel.flight.flightticket.d.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f24797a = r3
                int[] r3 = f24797a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.travel.flight.flightticket.d.c r4 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_MINI_RULES     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.travel.flight.flightticket.d.c r3 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_CANCELLATION_RULES     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_FARE_RULES     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_OFFER_LIST     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_MORE_SELLER     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ON_PROMO_CLICK     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ON_PROMO_TEXT_CHANGE     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ON_PROMO_REMOVED     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.NAVIGATE_TO_TC     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CANCEL_PROTECT_INSURANCE_CHECKBOX     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.CANCEL_PROTECT_TnC     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ON_BUNDLE_SELECTED     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f24797a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                com.travel.flight.flightticket.d.c r1 = com.travel.flight.flightticket.d.c.ON_BUNDLE_DESELECTED     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightReviewItenarary.AnonymousClass9.<clinit>():void");
        }
    }

    private void addBookingSegmentData(Intent intent) {
        int i2 = AnonymousClass9.f24798b[this.bookingSegment.ordinal()];
        if (i2 == 1) {
            intent.putExtra("INTENT_EXTRA_REVIEW_TYPE", 1);
        } else if (i2 == 2) {
            intent.putExtra("INTENT_EXTRA_REVIEW_TYPE", 0);
        } else if (i2 == 3) {
            intent.putExtra("INTENT_EXTRA_REVIEW_TYPE", 2);
        }
    }

    /* access modifiers changed from: private */
    public void callOneWaySearchList() {
        Intent intent = new Intent(this, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        addBookingSegmentData(intent);
        if (this.isSharedDeeplink) {
            addIntentExtras(intent);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void callRoundTripSearchList() {
        Intent intent = new Intent(this, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        addBookingSegmentData(intent);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        if (this.isSharedDeeplink) {
            addIntentExtras(intent);
        }
        startActivity(intent);
    }

    private Intent addIntentExtras(Intent intent) {
        intent.putExtra("isShare", true);
        intent.putExtra("intent_extra_search_input_data", this.mSearchInputs);
        return intent;
    }

    public void onReviewItenaryBundleResponseSuccess(FlightBundle flightBundle) {
        removeProgressDialog();
        if (flightBundle != null && flightBundle.getData() != null && flightBundle.getData().getPartner_bundles() != null && flightBundle.getData().getPartner_bundles().size() > 0) {
            this.mSellingBundleData = flightBundle.getData().getPartner_bundles();
            j jVar = this.mReviewDetailsAdapter;
            if (jVar != null) {
                jVar.f24680h = this.mSellingBundleData;
                jVar.a();
                jVar.notifyDataSetChanged();
            }
        }
    }

    public void showAdditionalInfo(com.travel.flight.pojo.flightticket.f fVar) {
        Intent intent = new Intent(this, AJRMultiAirlineMessageDisplay.class);
        intent.putExtra("INTENT_EXTRA_MULTI_AIRLINE_MESSAGE", fVar);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void openPromoScreen() {
        if (this.mOffers == null) {
            this.mOffers = new CJRFlightOffer();
            this.mOffers.setStringResponseCodes("\"codes\": []");
        }
        double parseDouble = this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceFare() != null ? Double.parseDouble(this.mFlightSearchResult.getmOnwardReturnFlights().getmRepriceFare().getmTotalFare()) : 0.0d;
        String stringResponseCodes = this.mOffers.getStringResponseCodes();
        if (!TextUtils.isEmpty(stringResponseCodes) && Double.compare(parseDouble, 0.0d) > 0) {
            com.travel.flight.b.a();
            com.travel.flight.b.b().a("", this, parseDouble, stringResponseCodes, this, this, "flights");
        }
    }

    public void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        this.isUpFrontPromo = false;
        this.mPromoVerifyListener = verifyPromoResultListener;
        this.mPromoCodeEntered = str;
        onPromoClick(str, str2, (ArrayList<PaymentIntent>) null, (String) null, i2);
    }

    public void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, String str2, VerifyPromoResultListener verifyPromoResultListener) {
        this.mPromoVerifyListener = verifyPromoResultListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mPromoCodeEntered;
        }
        this.isUpFrontPromo = false;
        onPromoClick(str, (String) null, arrayList, str2, 0);
    }

    private void sendPulseEventFlightReviewLoadSuccess() {
        sendCustomPulseEvent("flights_review_page_load", getDetailsMap(CommonPayParams.Builder.YES, (String) null));
    }

    private void SendPulseContinueClickEvent() {
        sendCustomPulseEvent("continue_clicked", getDetailsMap((String) null, (String) null));
    }

    private void sendPulseEventFlightReviewLoadFail(String str) {
        sendCustomPulseEvent("flights_review_page_load", getDetailsMap(CommonPayParams.Builder.NO, str));
    }

    private void sendPulseEventCP(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", z ? CommonPayParams.Builder.YES : CommonPayParams.Builder.NO);
        sendCustomPulseEvent("cancellation_protect_checked", hashMap);
    }

    private void sendPulseEventBundleSelected(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        sendCustomPulseEvent("package_selected", hashMap);
    }

    private void sendPulseEventPromoError(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        hashMap.put("event_label2", str2);
        sendCustomPulseEvent("promocode_error", hashMap);
    }

    private HashMap<String, Object> getDetailsMap(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_label", str);
        }
        if (!TextUtils.isEmpty(this.mSearchInputs.getJourneyDetailType())) {
            hashMap.put("event_label2", this.mSearchInputs.getJourneyDetailType());
        }
        hashMap.put("event_label3", this.mSearchInputs.getSource().getCityName());
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.mSearchInputs.getDestination().getCityName());
        j.a aVar = com.travel.flight.utils.j.f25593a;
        hashMap.put("event_label6", j.a.a(this.mSearchInputs.getClassType(), (Context) this));
        hashMap.put("event_label7", com.paytm.utility.b.h(this.mSearchInputs.getDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label8", com.paytm.utility.b.h(this.mSearchInputs.getReturnDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label9", this.mSearchInputs.getSourceCityCode());
        hashMap.put("event_label10", this.mSearchInputs.getDestCityCode());
        if (!TextUtils.isEmpty(this.mSearchInputs.getJourneyType()) && this.mFlightDetails != null) {
            hashMap.put("event_label11", this.mSearchInputs.getJourneyType());
            if (this.mSearchInputs.getJourneyType().equalsIgnoreCase("one_way")) {
                if (this.mFlightDetails.getmOnwardJourney().getmFlights() != null && this.mFlightDetails.getmOnwardJourney().getmFlights().size() > 0) {
                    hashMap.put("event_label5", this.mFlightDetails.getmOnwardJourney().getmAirLineCode() + " " + this.mFlightDetails.getmOnwardJourney().getmFlights().get(0).getmFlightNumber());
                }
            } else if (this.mFlightDetails.getmOnwardJourney().getmFlights() != null && this.mFlightDetails.getmOnwardJourney().getmFlights().size() > 0 && this.mFlightDetails.getmReturnJourney().getmFlights() != null && this.mFlightDetails.getmReturnJourney().getmFlights().size() > 0) {
                hashMap.put("event_label5", "Onward{" + this.mFlightDetails.getmOnwardJourney().getmAirLineCode() + " " + this.mFlightDetails.getmOnwardJourney().getmFlights().get(0).getmFlightNumber() + "}, Return{" + this.mFlightDetails.getmReturnJourney().getmAirLineCode() + " " + this.mFlightDetails.getmReturnJourney().getmFlights().get(0).getmFlightNumber() + "}");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_label12", str2);
        }
        return hashMap;
    }

    private void sendCustomPulseEvent(String str, HashMap<String, Object> hashMap) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/review-itinerary", "flights_review", str, hashMap);
    }
}
