package com.travel.train.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.h;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.j.e;
import com.travel.train.j.g;
import com.travel.train.j.i;
import com.travel.train.j.o;
import com.travel.train.j.r;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.a;
import com.travel.train.model.trainticket.BoardingStationData;
import com.travel.train.model.trainticket.CJRBoardingStationDetails;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import com.travel.train.model.trainticket.CJRTrainInfantInfo;
import com.travel.train.model.trainticket.CJRTrainQuickBook;
import com.travel.train.model.trainticket.CJRTrainQuickBookBody;
import com.travel.train.model.trainticket.CJRTrainQuickBookPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.CJRTrainUserFavourite;
import com.travel.train.model.trainticket.CJRTrainUserOptions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class AJRTrainQuickBookActivity extends CJRTrainBaseActivity implements View.OnClickListener, b, r.a {
    private String LOG_TAG = "AJRTrainQuickBookActivity";
    private CJRHomePageItem deepLinkItem;
    private boolean isFromDeepLink = false;
    private String mBoardingDate = "";
    private ArrayList<CJRBoardingStationDetails> mBoardingStationDetails = new ArrayList<>();
    private ArrayList<String> mBoardingStationList = new ArrayList<>();
    private String mBoardingTime = "";
    private String mChosenDate;
    private String mClassCode;
    private HashMap<String, Object> mClassMap;
    private String mClassName;
    private String mDepartureDate;
    private String mDestination;
    private String mEmailId;
    private String mFormattedBoardingStation;
    private String mFunnelType;
    private String mInsuranceChecked = "false";
    private boolean mIsWaitingList;
    private String mMobileNumber;
    private ArrayList<CJRPassengerInfo> mPassengerList = new ArrayList<>();
    private String mQuotaCode;
    private HashMap<String, String> mQuotaMap;
    private String mQuotaName;
    private String mRequestId;
    private String mSelectedBoardingStation;
    private String mSource;
    private ArrayList<CJRTrainAvailability> mTrainAvailability;
    private CJRTrainBooking mTrainBooking;
    private CJRTrainSearchResultsTrain mTrainDetails;
    private CJRTrainDetailsBody mTrainDetailsBody = new CJRTrainDetailsBody();
    private CJRTrainQuickBook mTrainQuickBook;
    private CJRTrainQuickBookBody mTrainQuickBookBody;
    private CJRTrainSearchInput mTrainSearchInput;
    private String mTripId;
    private CJRTrainUserFavourite mUserFavourite;
    private String mWalletSSOToken;
    private boolean minsuranceAlwaysTrue;
    private boolean minsuranceOption;

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_quick_book);
        getIntentData();
        getWalletToken();
        r.a(this);
    }

    public void getIntentData() {
        Intent intent = getIntent();
        if (intent.getExtras().containsKey("train_favourite_quick_book")) {
            this.mUserFavourite = (CJRTrainUserFavourite) intent.getSerializableExtra("train_favourite_quick_book");
            CJRTrainUserFavourite cJRTrainUserFavourite = this.mUserFavourite;
            if (cJRTrainUserFavourite != null && !TextUtils.isEmpty(cJRTrainUserFavourite.getTripId())) {
                this.mTripId = this.mUserFavourite.getTripId();
                this.mDepartureDate = i.a((Context) this, this.mUserFavourite.getmDepartureDateForQuickBook());
            }
        }
        if (intent.getExtras().containsKey("extra_home_data")) {
            this.deepLinkItem = (CJRHomePageItem) getIntent().getExtras().getSerializable("extra_home_data");
            if (!TextUtils.isEmpty(this.deepLinkItem.getURL())) {
                String queryParameter = Uri.parse(this.deepLinkItem.getURL()).buildUpon().build().getQueryParameter("url");
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.deepLinkItem.setUrl(queryParameter);
                }
            } else {
                CJRHomePageItem cJRHomePageItem = this.deepLinkItem;
                if (cJRHomePageItem instanceof CJRHomePageItem) {
                    String deeplink = cJRHomePageItem.getDeeplink();
                    if (!TextUtils.isEmpty(deeplink)) {
                        this.deepLinkItem.setUrl(deeplink);
                    }
                }
            }
            CJRHomePageItem cJRHomePageItem2 = this.deepLinkItem;
            if (cJRHomePageItem2 != null && !TextUtils.isEmpty(cJRHomePageItem2.getURL())) {
                this.isFromDeepLink = true;
                getDetailsFromURL();
            }
        }
    }

    private void getDetailsFromURL() {
        if (!TextUtils.isEmpty(this.deepLinkItem.getURL()) && this.isFromDeepLink) {
            if (this.deepLinkItem.getURLType().equalsIgnoreCase("train-resume")) {
                Uri parse = Uri.parse(this.deepLinkItem.getURL());
                if (!TextUtils.isEmpty(parse.getQueryParameter("funnel_id"))) {
                    this.mTripId = parse.getQueryParameter("funnel_id");
                }
                if (!TextUtils.isEmpty(parse.getQueryParameter("funnel_type"))) {
                    this.mFunnelType = parse.getQueryParameter("funnel_type");
                    return;
                }
                return;
            }
            Uri parse2 = Uri.parse(this.deepLinkItem.getURL());
            if (!TextUtils.isEmpty(parse2.getQueryParameter("trip_id"))) {
                this.mTripId = parse2.getQueryParameter("trip_id");
            }
            if (!TextUtils.isEmpty(parse2.getQueryParameter("departure_date"))) {
                this.mDepartureDate = parse2.getQueryParameter("departure_date");
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    private void getWalletToken() {
        if (com.paytm.utility.b.c((Context) this)) {
            showProgressDialog(this, getResources().getString(R.string.pp_please_wait));
            com.travel.train.b.a();
            com.travel.train.b.a((Activity) this, (b) this);
            return;
        }
        com.paytm.utility.b.c((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_train));
    }

    public void onDestroy() {
        removeProgressDialog();
        super.onDestroy();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        try {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                removeProgressDialog();
                this.mWalletSSOToken = e.a((CJRPGTokenList) iJRPaytmDataModel);
                prepareQuickBookAPI();
            } else if (iJRPaytmDataModel instanceof CJRTrainQuickBook) {
                this.mTrainQuickBook = (CJRTrainQuickBook) iJRPaytmDataModel;
                if (this.mTrainQuickBook.getmTrainQuickBookBody() != null) {
                    this.mTrainQuickBookBody = this.mTrainQuickBook.getmTrainQuickBookBody();
                    if (this.mTrainQuickBook.getmTrainQuickBookBody().getmTrainAvailability() != null) {
                        this.mTrainAvailability = this.mTrainQuickBook.getmTrainQuickBookBody().getmTrainAvailability();
                        checkIfWaitingList(this.mTrainAvailability.get(0));
                    }
                    saveIRCTCUserId();
                    seperateCommonDetailsFromResponse(this.mTrainQuickBookBody);
                    if (TextUtils.isEmpty(this.mTrainQuickBookBody.getmErrorMsg())) {
                        if (TextUtils.isEmpty(this.mTrainQuickBookBody.getmErrorTitle())) {
                            checkPageToLand(this.mTrainQuickBookBody);
                            return;
                        }
                    }
                    showErrorMessage(this.mTrainQuickBookBody.getmErrorMsg(), this.mTrainQuickBookBody.getmErrorTitle(), this.mTrainQuickBookBody);
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            removeProgressDialog();
            a aVar = new a();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        aVar = (a) new f().a(new String(networkResponse.data), aVar.getClass());
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (i2 != 401) {
                if (i2 != 410) {
                    if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                        showErrorDialog(aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                        return;
                    } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                            com.travel.train.b.a();
                            if (!com.travel.train.b.b().a((Context) this, (Exception) networkCustomError, "error.trains@paytm.com")) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    showErrorDialog(getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                    return;
                                }
                                showErrorDialog(getResources().getString(R.string.error_data_display), getResources().getString(R.string.trains_message_error_data_display));
                                return;
                            }
                        }
                        showErrorDialog(getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train));
                        return;
                    } else {
                        showErrorDialog(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                        return;
                    }
                }
            }
            showSessionTimeoutAlert(networkCustomError);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public void getPassengerDetails(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody.getPaxInfo() != null && cJRTrainQuickBookBody.getPaxInfo().size() > 0) {
            for (int i2 = 0; i2 < cJRTrainQuickBookBody.getPaxInfo().size(); i2++) {
                CJRTrainQuickBookPassengerInfo cJRTrainQuickBookPassengerInfo = cJRTrainQuickBookBody.getPaxInfo().get(i2);
                CJRPassengerInfo cJRPassengerInfo = new CJRPassengerInfo();
                if (cJRTrainQuickBookPassengerInfo.getConcessionOpted() != null) {
                    if (cJRTrainQuickBookPassengerInfo.getConcessionOpted().booleanValue()) {
                        cJRPassengerInfo.setIsSeniorCityZen(true);
                    } else {
                        cJRPassengerInfo.setIsSeniorCityZen(false);
                    }
                }
                cJRPassengerInfo.setmCategory(cJRTrainQuickBookPassengerInfo.getPassengerCategory());
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerBerthChoice())) {
                    cJRPassengerInfo.setBerthPreference(o.i(cJRTrainQuickBookPassengerInfo.getPassengerBerthChoice()));
                } else {
                    cJRPassengerInfo.setBerthPreference(o.i("NC"));
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerFoodChoice())) {
                    cJRPassengerInfo.setMealPreference(o.k(cJRTrainQuickBookPassengerInfo.getPassengerFoodChoice()));
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerNationality())) {
                    cJRPassengerInfo.setCountryCode(cJRTrainQuickBookPassengerInfo.getPassengerNationality());
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerNationality()) && cJRTrainQuickBookPassengerInfo.getPassengerNationality().equalsIgnoreCase("IN")) {
                    cJRPassengerInfo.setmCountryName("India");
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerName())) {
                    cJRPassengerInfo.setFullName(cJRTrainQuickBookPassengerInfo.getPassengerName());
                }
                new Integer(cJRTrainQuickBookPassengerInfo.getPassengerAge());
                cJRPassengerInfo.setAge(String.valueOf(cJRTrainQuickBookPassengerInfo.getPassengerAge()));
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerGender())) {
                    cJRPassengerInfo.setTIttle(genderCode(cJRTrainQuickBookPassengerInfo.getPassengerGender()));
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerCardNumber())) {
                    cJRPassengerInfo.setIdNumber(genderCode(cJRTrainQuickBookPassengerInfo.getPassengerCardNumber()));
                }
                if (!TextUtils.isEmpty(cJRTrainQuickBookPassengerInfo.getPassengerCardType())) {
                    cJRPassengerInfo.setIdentity(genderCode(cJRTrainQuickBookPassengerInfo.getPassengerCardType()));
                }
                if (cJRTrainQuickBookPassengerInfo.getChildBerthFlag() != null) {
                    if (cJRTrainQuickBookPassengerInfo.getChildBerthFlag().booleanValue()) {
                        cJRPassengerInfo.setIsBerthFlag(true);
                    } else {
                        cJRPassengerInfo.setIsBerthFlag(false);
                    }
                }
                if (cJRTrainQuickBookPassengerInfo.getPassengerBedRollChoice() != null) {
                    if (cJRTrainQuickBookPassengerInfo.getPassengerBedRollChoice().booleanValue()) {
                        cJRPassengerInfo.setBedRollChoice(true);
                    } else {
                        cJRPassengerInfo.setBedRollChoice(false);
                    }
                }
                if (!this.minsuranceOption) {
                    this.mInsuranceChecked = "false";
                } else if (cJRTrainQuickBookPassengerInfo.getTravelInsuranceOpted() != null) {
                    if (cJRTrainQuickBookPassengerInfo.getTravelInsuranceOpted().booleanValue()) {
                        this.mInsuranceChecked = "true";
                    } else {
                        this.mInsuranceChecked = "false";
                    }
                }
                this.mPassengerList.add(cJRPassengerInfo);
            }
        }
    }

    public void getInfantDetails(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody != null && cJRTrainQuickBookBody.getmInfantInfo() != null) {
            Iterator<CJRTrainInfantInfo> it2 = cJRTrainQuickBookBody.getmInfantInfo().iterator();
            while (it2.hasNext()) {
                CJRTrainInfantInfo next = it2.next();
                CJRPassengerInfo cJRPassengerInfo = new CJRPassengerInfo();
                if (!TextUtils.isEmpty(next.getAge())) {
                    cJRPassengerInfo.setAge(next.getAge());
                }
                if (!TextUtils.isEmpty(next.getName())) {
                    cJRPassengerInfo.setFullName(next.getName());
                }
                if (!TextUtils.isEmpty(next.getGender())) {
                    cJRPassengerInfo.setTIttle(genderCode(next.getGender()));
                }
                cJRPassengerInfo.setmCategory("IF");
                this.mPassengerList.add(cJRPassengerInfo);
            }
        }
    }

    public void saveIRCTCUserId() {
        CJRTrainQuickBookBody cJRTrainQuickBookBody = this.mTrainQuickBookBody;
        if (cJRTrainQuickBookBody != null) {
            if (cJRTrainQuickBookBody.getmUserOptions() != null && !TextUtils.isEmpty(this.mTrainQuickBookBody.getmUserOptions().getIrctcUserId())) {
                com.paytm.utility.b.j((Context) this, this.mTrainQuickBookBody.getmUserOptions().getIrctcUserId());
            }
            if (this.mTrainQuickBookBody.getmUserOptions() != null) {
                if (!TextUtils.isEmpty(this.mTrainQuickBookBody.getmUserOptions().getContactMobile())) {
                    this.mMobileNumber = this.mTrainQuickBookBody.getmUserOptions().getContactMobile();
                }
                if (!TextUtils.isEmpty(this.mTrainQuickBookBody.getmUserOptions().getContactEmail())) {
                    this.mEmailId = this.mTrainQuickBookBody.getmUserOptions().getContactEmail();
                }
            }
        }
    }

    private String genderCode(String str) {
        if (str.equalsIgnoreCase("M")) {
            return "Male";
        }
        return str.equalsIgnoreCase(AppConstants.FEED_SUB_TYPE) ? "Female" : "Transgender";
    }

    public Object deepCopy(Serializable serializable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception unused) {
            return null;
        }
    }

    public void seperateCommonDetailsFromResponse(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (this.mTrainQuickBook.getMeta() != null) {
            if (this.mTrainQuickBook.getMeta().getClasses() != null) {
                this.mClassMap = this.mTrainQuickBook.getMeta().getClasses();
            }
            if (this.mTrainQuickBook.getMeta().getQuota() != null) {
                this.mQuotaMap = this.mTrainQuickBook.getMeta().getQuota();
            }
            if (!TextUtils.isEmpty(this.mTrainQuickBook.getMeta().getRequestid())) {
                this.mRequestId = this.mTrainQuickBook.getMeta().getRequestid();
            }
        }
        if (cJRTrainQuickBookBody.getmTrainInfo() != null) {
            if (!TextUtils.isEmpty(cJRTrainQuickBookBody.getmTrainInfo().getQuota())) {
                this.mQuotaCode = cJRTrainQuickBookBody.getmTrainInfo().getQuota();
                this.mQuotaName = getQuotaFullName(this.mQuotaCode);
            }
            if (!TextUtils.isEmpty(cJRTrainQuickBookBody.getmTrainInfo().getTrainClass())) {
                this.mClassCode = cJRTrainQuickBookBody.getmTrainInfo().getTrainClass();
                this.mClassName = getClassFullName(this.mClassCode);
            }
            if (!TextUtils.isEmpty(cJRTrainQuickBookBody.getmTrainInfo().getSource())) {
                this.mSource = cJRTrainQuickBookBody.getmTrainInfo().getSource();
            }
            if (!TextUtils.isEmpty(cJRTrainQuickBookBody.getmTrainInfo().getDestination())) {
                this.mDestination = cJRTrainQuickBookBody.getmTrainInfo().getDestination();
            }
            constructTrainSearchInput(cJRTrainQuickBookBody.getmTrainInfo());
        }
        if (!(cJRTrainQuickBookBody.getmBoardingStations() == null || cJRTrainQuickBookBody.getmBoardingDetail() == null)) {
            this.mBoardingStationList = cJRTrainQuickBookBody.getmBoardingStations();
            this.mBoardingStationDetails = cJRTrainQuickBookBody.getmBoardingDetail();
        }
        prepareGstDetails(cJRTrainQuickBookBody);
    }

    public void constructTrainInfo(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        ArrayList<CJRTrainAvailability> arrayList;
        this.mTrainDetails = (CJRTrainSearchResultsTrain) deepCopy(cJRTrainSearchResultsTrain);
        this.mTrainDetails.setMirctcuserid(com.paytm.utility.b.W((Context) this));
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getQuickTrainName())) {
            this.mTrainDetails.setTrainName(cJRTrainSearchResultsTrain.getQuickTrainName());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getQuickTrainNumber())) {
            this.mTrainDetails.setTrainNumber(cJRTrainSearchResultsTrain.getQuickTrainNumber());
        }
        if (this.mTrainDetails.getDuration() != null && (arrayList = this.mTrainAvailability) != null && arrayList.get(0) != null) {
            String f2 = i.f(this.mTrainDetails.getDeparture());
            setTrainTime(i.b(i.d(this.mTrainAvailability.get(0).getmDate() + f2), this.mTrainDetails.getDuration()), this.mTrainAvailability.get(0));
        }
    }

    private void setTrainTime(String str, CJRTrainAvailability cJRTrainAvailability) {
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.mTrainDetails;
        if (cJRTrainSearchResultsTrain != null) {
            String f2 = i.f(cJRTrainSearchResultsTrain.getDeparture());
            this.mTrainDetails.setMSearchedTrainArrivalTime(str);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2 = this.mTrainDetails;
            cJRTrainSearchResultsTrain2.setMSearchedTrainDepartureTime(i.d(cJRTrainAvailability.getmDate() + f2));
        }
    }

    public void setBoardingStationDetails() {
        ArrayList<String> arrayList = this.mBoardingStationList;
        if (arrayList != null && arrayList.size() > 0) {
            int boardingStationPosition = getBoardingStationPosition();
            String[] split = this.mBoardingStationList.get(boardingStationPosition).split("-");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            BoardingStationData boardingStationData = new BoardingStationData();
            int i2 = 0;
            if (split != null && split.length == 2) {
                sb.append(split[1]);
                sb.append("-");
                sb.append(com.paytm.utility.b.A(split[0]));
            }
            ArrayList<CJRBoardingStationDetails> arrayList2 = this.mBoardingStationDetails;
            if (!(arrayList2 == null || arrayList2.size() <= 0 || this.mBoardingStationDetails.get(boardingStationPosition) == null)) {
                this.mSelectedBoardingStation = this.mBoardingStationList.get(boardingStationPosition);
                sb.append(", ");
                sb2.append(this.mBoardingStationDetails.get(boardingStationPosition).getDepartureTime());
                this.mBoardingTime = this.mBoardingStationDetails.get(boardingStationPosition).getDepartureTime();
                if (this.mBoardingStationDetails.get(0) != null) {
                    i2 = this.mBoardingStationDetails.get(0).getDayCount();
                }
                int dayCount = this.mBoardingStationDetails.get(boardingStationPosition).getDayCount() - i2;
                sb2.append(AppConstants.COMMA);
                this.mBoardingDate = calculateReachingDate(dayCount, Boolean.TRUE);
                String calculateReachingDate = calculateReachingDate(dayCount, Boolean.FALSE);
                sb2.append(" ");
                sb2.append(calculateReachingDate);
            }
            boardingStationData.setStationTitle(sb.toString());
            boardingStationData.setTravelDate(sb2.toString());
            this.mFormattedBoardingStation = boardingStationData.getStationTitle() + boardingStationData.getTravelDate();
        }
    }

    public int getBoardingStationPosition() {
        CJRTrainQuickBookBody cJRTrainQuickBookBody = this.mTrainQuickBookBody;
        if (cJRTrainQuickBookBody == null || cJRTrainQuickBookBody.getmTrainInfo() == null || this.mTrainQuickBookBody.getmTrainInfo().getBoardingStation() == null || this.mBoardingStationList == null) {
            return -1;
        }
        String str = " - " + this.mTrainQuickBookBody.getmTrainInfo().getBoardingStation().trim();
        for (int i2 = 0; i2 < this.mBoardingStationList.size(); i2++) {
            if (this.mBoardingStationList.get(0).contains(str)) {
                return i2;
            }
        }
        return -1;
    }

    private String calculateReachingDate(int i2, Boolean bool) {
        if (this.mTrainDetails.getMSearchedTrainDepartureTime() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                long time = simpleDateFormat.parse(this.mTrainDetails.getMSearchedTrainDepartureTime()).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                if (bool.booleanValue()) {
                    return i.a(simpleDateFormat.format(new Date(time)), "dd MMM yyyy");
                }
                return i.a(simpleDateFormat.format(new Date(time)), "dd MMM");
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    public void constructTrainDetailBodyForTravellerPage(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (!TextUtils.isEmpty(cJRTrainQuickBookBody.getmTrainName())) {
            this.mTrainDetailsBody.setmTrainName(cJRTrainQuickBookBody.getmTrainName());
        }
        if (cJRTrainQuickBookBody.getmMessage() != null) {
            this.mTrainDetailsBody.setMessage(cJRTrainQuickBookBody.getmMessage());
        }
        if (cJRTrainQuickBookBody.getmTrainPreferences() != null) {
            this.mTrainDetailsBody.setTrainPreferences(cJRTrainQuickBookBody.getmTrainPreferences());
        }
        if (cJRTrainQuickBookBody.getmTrainConfig() != null) {
            this.mTrainDetailsBody.setmTrainConfig(cJRTrainQuickBookBody.getmTrainConfig());
        }
        if (cJRTrainQuickBookBody.getmBoardingStations() != null) {
            this.mTrainDetailsBody.setmBoardingStation(cJRTrainQuickBookBody.getmBoardingStations());
        }
        if (cJRTrainQuickBookBody.getmBerth() != null) {
            this.mTrainDetailsBody.setmBerth(cJRTrainQuickBookBody.getmBerth());
        }
        if (cJRTrainQuickBookBody.getmBoardingDetail() != null) {
            this.mTrainDetailsBody.setBoardingDetail(cJRTrainQuickBookBody.getmBoardingDetail());
        }
        if (cJRTrainQuickBookBody.isGst_enabled()) {
            this.mTrainDetailsBody.setGst_enabled(true);
        } else {
            this.mTrainDetailsBody.setGst_enabled(false);
        }
        ArrayList<CJRTrainAvailability> arrayList = this.mTrainAvailability;
        if (arrayList != null) {
            CJRTrainAvailability cJRTrainAvailability = arrayList.get(0);
            cJRTrainAvailability.setmQuotaCode(this.mQuotaCode);
            cJRTrainAvailability.setQuota(this.mQuotaName);
            this.mTrainDetailsBody.setmTrainAvailability(this.mTrainAvailability);
            this.mChosenDate = com.paytm.utility.b.d(cJRTrainAvailability.getmDate(), "yyyy-MM-dd", "EEE, dd MMM");
            if (cJRTrainAvailability.isMinsuranceOption()) {
                this.minsuranceAlwaysTrue = cJRTrainAvailability.isMinsuranceAlwaysTrue();
                this.minsuranceOption = true;
            } else {
                this.minsuranceOption = false;
            }
        }
        if (cJRTrainQuickBookBody.getmTrainInfo() != null) {
            constructTrainInfo(cJRTrainQuickBookBody.getmTrainInfo());
        }
    }

    public void constructTrainSearchInput(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        this.mTrainSearchInput = new CJRTrainSearchInput();
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getSource())) {
            this.mTrainSearchInput.setmSourceCityCode(cJRTrainSearchResultsTrain.getSource());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getSourceName())) {
            this.mTrainSearchInput.setmSourceCityName(cJRTrainSearchResultsTrain.getSourceName());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDestination())) {
            this.mTrainSearchInput.setmDestCityCode(cJRTrainSearchResultsTrain.getDestination());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDestinationName())) {
            this.mTrainSearchInput.setmDestCityName(cJRTrainSearchResultsTrain.getDestinationName());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDeparture())) {
            this.mTrainSearchInput.setmDate(i.a(cJRTrainSearchResultsTrain.getDeparture(), "yyyy-MM-dd'T'HH:mm:ss", "dd MMM yy, EEE"));
        }
    }

    private void prepareQuickBookAPI() {
        if (TextUtils.isEmpty(this.mTripId) || TextUtils.isEmpty(this.mDepartureDate)) {
            CJRHomePageItem cJRHomePageItem = this.deepLinkItem;
            if (cJRHomePageItem == null || !"train-resume".equalsIgnoreCase(cJRHomePageItem.getURLType()) || TextUtils.isEmpty(this.mTripId)) {
                Toast.makeText(this, getResources().getString(R.string.network_error_message_train), 1).show();
                callTrainHomePage();
                return;
            }
            com.travel.train.b.a();
            String ai = com.travel.train.b.b().ai();
            if (URLUtil.isValidUrl(ai)) {
                Uri.Builder buildUpon = Uri.parse(o.b(getApplicationContext(), com.paytm.utility.b.s(this, ai))).buildUpon();
                buildUpon.appendQueryParameter("funnel_id", this.mTripId);
                if (!TextUtils.isEmpty(this.mFunnelType)) {
                    buildUpon.appendQueryParameter("funnel_type", this.mFunnelType);
                }
                buildUpon.appendQueryParameter("quick_book", "true");
                callQuickBookAPI(buildUpon.build().toString());
                return;
            }
            return;
        }
        com.travel.train.b.a();
        String E = com.travel.train.b.b().E();
        if (URLUtil.isValidUrl(E)) {
            Uri.Builder buildUpon2 = Uri.parse(o.b(getApplicationContext(), com.paytm.utility.b.s(this, E))).buildUpon();
            buildUpon2.appendQueryParameter("departure_date", this.mDepartureDate);
            buildUpon2.appendQueryParameter("trip_id", this.mTripId);
            buildUpon2.appendQueryParameter("quick_book", "true");
            callQuickBookAPI(buildUpon2.build().toString());
        }
    }

    private void callTrainHomePage() {
        Bundle bundle = new Bundle();
        bundle.putString("origin", "deeplinking");
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) this, "paytmmp://trainticket?landing=book_tickets", bundle);
        onBackPressed();
    }

    public void callQuickBookAPI(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
        hashMap.put("wallet_token", this.mWalletSSOToken);
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.TRAIN;
        bVar.n = a.b.SILENT;
        bVar.o = g.p;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = str;
        bVar.f42882f = hashMap;
        bVar.f42885i = new CJRTrainQuickBook();
        bVar.j = this;
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        if (com.paytm.utility.b.c((Context) this)) {
            showProgressDialog(this, getString(R.string.please_wait_loading_quick_book));
            l.a();
            return;
        }
        showNetworkDialog(l);
    }

    public void prepareTrainBodyForReviewPage(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody.getmTrainDetailsBody() != null) {
            this.mTrainDetailsBody = (CJRTrainDetailsBody) deepCopy(cJRTrainQuickBookBody.getmTrainDetailsBody());
            if (cJRTrainQuickBookBody.getmBoardingStations() != null) {
                this.mTrainDetailsBody.setmBoardingStation(cJRTrainQuickBookBody.getmBoardingStations());
            }
            if (cJRTrainQuickBookBody.getmBoardingDetail() != null) {
                this.mTrainDetailsBody.setBoardingDetail(cJRTrainQuickBookBody.getmBoardingDetail());
            }
            this.mTrainDetailsBody.setMiSelectedPosition(0);
            this.mTrainAvailability.get(0).setQuota(this.mQuotaName);
            this.mTrainAvailability.get(0).setmQuotaCode(this.mQuotaCode);
            this.mTrainDetailsBody.setmTrainAvailability(this.mTrainAvailability);
            setAdditionalPrefernceDetails();
        }
    }

    public void setAdditionalPrefernceDetails() {
        CJRTrainQuickBookBody cJRTrainQuickBookBody = this.mTrainQuickBookBody;
        if (cJRTrainQuickBookBody == null || cJRTrainQuickBookBody.getmUserOptions() == null || !this.mTrainQuickBookBody.getmTrainDetailsBody().getTrainPreferences().isEnable()) {
            this.mTrainDetailsBody.setCoachNumber("");
            this.mTrainDetailsBody.setmReservationChoice("");
            this.mTrainDetailsBody.setReservationCode(-1);
            return;
        }
        CJRTrainUserOptions cJRTrainUserOptions = this.mTrainQuickBookBody.getmUserOptions();
        if (cJRTrainUserOptions.getAutoUpgrade()) {
            this.mTrainDetailsBody.setAutoUpgrade(true);
        } else {
            this.mTrainDetailsBody.setAutoUpgrade(false);
        }
        if (!TextUtils.isEmpty(cJRTrainUserOptions.getCoachId())) {
            this.mTrainDetailsBody.setCoachNumber(cJRTrainUserOptions.getCoachId());
        } else {
            this.mTrainDetailsBody.setCoachNumber("");
        }
        this.mTrainDetailsBody.setmReservationChoice("");
        this.mTrainDetailsBody.setReservationCode(-1);
        new Integer(cJRTrainUserOptions.getReservationChoice());
        this.mTrainDetailsBody.setReservationCode(cJRTrainUserOptions.getReservationChoice());
        if (this.mTrainQuickBookBody.getmTrainDetailsBody() != null && this.mTrainQuickBookBody.getmTrainDetailsBody().getTrainPreferences() != null && this.mTrainQuickBookBody.getmTrainDetailsBody().getTrainPreferences().getPreferenceChoice() != null && this.mTrainQuickBookBody.getmTrainDetailsBody().getTrainPreferences().getPreferenceChoice().size() > 0) {
            for (Map.Entry next : this.mTrainQuickBookBody.getmTrainDetailsBody().getTrainPreferences().getPreferenceChoice().entrySet()) {
                if (((Integer) next.getValue()).intValue() == cJRTrainUserOptions.getReservationChoice()) {
                    this.mTrainDetailsBody.setmReservationChoice((String) next.getKey());
                    return;
                }
            }
        }
    }

    public void setAdditionalPrefernceDetailsPassengerPage() {
        CJRTrainQuickBookBody cJRTrainQuickBookBody = this.mTrainQuickBookBody;
        if (cJRTrainQuickBookBody == null || cJRTrainQuickBookBody.getmUserOptions() == null || !this.mTrainQuickBookBody.getmTrainPreferences().isEnable()) {
            this.mTrainDetailsBody.setCoachNumber("");
            this.mTrainDetailsBody.setmReservationChoice("");
            this.mTrainDetailsBody.setReservationCode(-1);
            return;
        }
        CJRTrainUserOptions cJRTrainUserOptions = this.mTrainQuickBookBody.getmUserOptions();
        if (cJRTrainUserOptions.getAutoUpgrade()) {
            this.mTrainDetailsBody.setAutoUpgrade(true);
        } else {
            this.mTrainDetailsBody.setAutoUpgrade(false);
        }
        if (!TextUtils.isEmpty(cJRTrainUserOptions.getCoachId())) {
            this.mTrainDetailsBody.setCoachNumber(cJRTrainUserOptions.getCoachId());
        } else {
            this.mTrainDetailsBody.setCoachNumber("");
        }
        this.mTrainDetailsBody.setmReservationChoice("");
        this.mTrainDetailsBody.setReservationCode(-1);
        new Integer(cJRTrainUserOptions.getReservationChoice());
        this.mTrainDetailsBody.setReservationCode(cJRTrainUserOptions.getReservationChoice());
        if (this.mTrainQuickBookBody.getmTrainDetailsBody() != null && this.mTrainQuickBookBody.getmTrainPreferences() != null && this.mTrainQuickBookBody.getmTrainPreferences().getPreferenceChoice() != null && this.mTrainQuickBookBody.getmTrainPreferences().getPreferenceChoice().size() > 0) {
            for (Map.Entry next : this.mTrainQuickBookBody.getmTrainPreferences().getPreferenceChoice().entrySet()) {
                if (((Integer) next.getValue()).intValue() == cJRTrainUserOptions.getReservationChoice()) {
                    this.mTrainDetailsBody.setmReservationChoice((String) next.getKey());
                    return;
                }
            }
        }
    }

    public void prepareGstDetails(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody.getmUserOptions() != null && cJRTrainQuickBookBody.getmUserOptions().getGstDetails() != null) {
            CJRTrainGstDetails gstDetails = cJRTrainQuickBookBody.getmUserOptions().getGstDetails();
            if (!TextUtils.isEmpty(gstDetails.getGstIn())) {
                this.mTrainSearchInput.setmGSTINNumber(gstDetails.getGstIn());
            } else {
                this.mTrainSearchInput.setmGSTINNumber("");
            }
            if (!TextUtils.isEmpty(gstDetails.getNameOnGst())) {
                this.mTrainSearchInput.setmGSTName(gstDetails.getNameOnGst());
            } else {
                this.mTrainSearchInput.setmGSTName("");
            }
            if (!TextUtils.isEmpty(gstDetails.getFlat())) {
                this.mTrainSearchInput.setmGSTFlat(gstDetails.getFlat());
            } else {
                this.mTrainSearchInput.setmGSTFlat("");
            }
            if (!TextUtils.isEmpty(gstDetails.getStreet())) {
                this.mTrainSearchInput.setmGSTStreet(gstDetails.getStreet());
            } else {
                this.mTrainSearchInput.setmGSTStreet("");
            }
            if (!TextUtils.isEmpty(gstDetails.getCity())) {
                this.mTrainSearchInput.setmGSTCity(gstDetails.getCity());
            } else {
                this.mTrainSearchInput.setmGSTCity("");
            }
            if (!TextUtils.isEmpty(gstDetails.getPin())) {
                this.mTrainSearchInput.setmGSTPinCode(gstDetails.getPin());
            } else {
                this.mTrainSearchInput.setmGSTPinCode("");
            }
            if (!TextUtils.isEmpty(gstDetails.getState())) {
                this.mTrainSearchInput.setmGSTState(gstDetails.getState());
            } else {
                this.mTrainSearchInput.setmGSTState("");
            }
        }
    }

    public void prepareInputForSearchPage(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody != null && !TextUtils.isEmpty(cJRTrainQuickBookBody.getmSourceCode()) && !TextUtils.isEmpty(cJRTrainQuickBookBody.getmDestinationCode()) && !TextUtils.isEmpty(cJRTrainQuickBookBody.getmDepartureDate()) && !TextUtils.isEmpty(cJRTrainQuickBookBody.getmSourceName()) && !TextUtils.isEmpty(cJRTrainQuickBookBody.getmDestinationName())) {
            this.mTrainSearchInput = new CJRTrainSearchInput();
            this.mTrainSearchInput.setmSourceCityCode(cJRTrainQuickBookBody.getmSourceCode());
            this.mTrainSearchInput.setmDestCityCode(cJRTrainQuickBookBody.getmDestinationCode());
            this.mTrainSearchInput.setmDate(getDeeplinkFormatedDate(this, cJRTrainQuickBookBody.getmDepartureDate()));
            this.mTrainSearchInput.setmDestCityName(cJRTrainQuickBookBody.getmDestinationName());
            this.mTrainSearchInput.setmSourceCityName(cJRTrainQuickBookBody.getmSourceName());
        }
    }

    private String getDeeplinkFormatedDate(Context context, String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", new Locale(n.a(context, n.a())));
        try {
            return new SimpleDateFormat("dd MMM yy, EEE", Locale.ENGLISH).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public void checkPageToLand(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody != null && cJRTrainQuickBookBody.getmPageToLoad() != null) {
            int intValue = cJRTrainQuickBookBody.getmPageToLoad().intValue();
            if (intValue != 1) {
                if (intValue == 2) {
                    landOnTravellerPage(cJRTrainQuickBookBody);
                } else if (intValue == 3) {
                    landOnReviewPage(cJRTrainQuickBookBody);
                }
            } else if (this.isFromDeepLink) {
                prepareInputForSearchPage(cJRTrainQuickBookBody);
                callSearchResultsActivity();
            } else {
                onBackPressed();
            }
        }
    }

    public void landOnTravellerPage(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        constructTrainDetailBodyForTravellerPage(cJRTrainQuickBookBody);
        getPassengerDetails(cJRTrainQuickBookBody);
        getInfantDetails(cJRTrainQuickBookBody);
        setAdditionalPrefernceDetailsPassengerPage();
        callPassengerDetailActivity();
    }

    public void landOnReviewPage(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        checkAvailability(cJRTrainQuickBookBody);
        getPassengerDetails(cJRTrainQuickBookBody);
        getInfantDetails(cJRTrainQuickBookBody);
        if (cJRTrainQuickBookBody.getmTrainInfo() != null) {
            constructTrainInfo(cJRTrainQuickBookBody.getmTrainInfo());
        }
        setBoardingStationDetails();
        prepareTrainBodyForReviewPage(cJRTrainQuickBookBody);
        callReviewItineraryActivity();
    }

    public void checkAvailability(CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        if (cJRTrainQuickBookBody != null && cJRTrainQuickBookBody.getmTrainDetailsBody() != null && cJRTrainQuickBookBody.getmTrainDetailsBody().getmTrainAvailability() != null) {
            ArrayList<CJRTrainAvailability> arrayList = cJRTrainQuickBookBody.getmTrainDetailsBody().getmTrainAvailability();
            if (arrayList.get(0) != null) {
                this.mTrainAvailability = (ArrayList) deepCopy(arrayList);
                checkIfWaitingList(arrayList.get(0));
            }
        }
    }

    public void showErrorDialog(String str, String str2) {
        final h hVar = new h(this);
        if (str2 != null) {
            hVar.setTitle(str);
            hVar.setCancelable(false);
            hVar.a(str2);
            hVar.a(-3, getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    AJRTrainQuickBookActivity.this.onBackPressed();
                }
            });
            hVar.show();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = hVar.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            window.setAttributes(layoutParams);
        }
    }

    public void callSearchResultsActivity() {
        if (this.mTrainSearchInput != null) {
            Intent intent = new Intent(this, AJRTrainSearchActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("intent_extra_train_search_input", this.mTrainSearchInput);
            intent.putExtra("train_home_bundle", bundle);
            startActivity(intent);
        }
        onBackPressed();
    }

    public void callPassengerDetailActivity() {
        Intent intent = new Intent(this, AJRTrainPassengerDetailActivity.class);
        intent.putExtra("train_class_code", this.mClassCode);
        intent.putExtra("train_class_details", this.mClassName);
        this.mTrainDetailsBody.setMiSelectedPosition(0);
        this.mTrainDetailsBody.setPassengerInfo(this.mPassengerList);
        intent.putExtra("quota", this.mQuotaCode);
        intent.putExtra("quota_name", this.mQuotaName);
        intent.putExtra("waiting_list", this.mIsWaitingList);
        intent.putExtra("train_detail_body", this.mTrainDetailsBody);
        intent.putExtra("train_detail", this.mTrainDetails);
        intent.putExtra("intent_extra_train_search_input", this.mTrainSearchInput);
        intent.putExtra("chosenDate", this.mChosenDate);
        intent.putExtra("source", this.mSource);
        intent.putExtra("destination", this.mDestination);
        intent.putExtra("request_id", this.mRequestId);
        intent.putExtra("is_from_quick_book", true);
        intent.putExtra("minsuranceAlwaysTrue", this.minsuranceAlwaysTrue);
        intent.putExtra("minsuranceOption", this.minsuranceOption);
        startActivityForResult(intent, 989);
        onBackPressed();
    }

    public void callReviewItineraryActivity() {
        this.mTrainDetailsBody.setSelectedBoardingStation(this.mSelectedBoardingStation);
        this.mTrainDetailsBody.setBoardingDate(this.mBoardingDate);
        this.mTrainDetailsBody.setBoardingTime(this.mBoardingTime);
        this.mTrainDetailsBody.setFormattedBoardingStation(this.mFormattedBoardingStation);
        this.mTrainDetailsBody.setPassengerInfo(this.mPassengerList);
        this.mTrainDetailsBody.setUserMobileNumber(this.mMobileNumber);
        this.mTrainDetailsBody.setEmailAddress(this.mEmailId);
        prepareTrainConfirmationDetails();
        Intent intent = new Intent(this, AJRTrainReviewItineraryActivity.class);
        intent.putExtra("train_detail_body", this.mTrainDetailsBody);
        intent.putExtra("train_detail", this.mTrainDetails);
        intent.putExtra("intent_extra_train_search_input", this.mTrainSearchInput);
        intent.putExtra("request_id", this.mRequestId);
        intent.putExtra("train_class_code", this.mClassCode);
        intent.putExtra("train_class_name", this.mClassName);
        intent.putExtra("waiting_list", this.mIsWaitingList);
        intent.putExtra("is_from_quick_book", true);
        intent.putExtra("insuranceChecked", this.mInsuranceChecked);
        intent.putExtra("train_booking_details", this.mTrainBooking);
        startActivity(intent);
        onBackPressed();
    }

    public void prepareTrainConfirmationDetails() {
        this.mTrainBooking = new CJRTrainBooking();
        if (this.mTrainQuickBookBody != null) {
            CJRTrainConfirmation cJRTrainConfirmation = new CJRTrainConfirmation();
            if (this.mTrainQuickBookBody.getmTrainDetailsBody() != null) {
                cJRTrainConfirmation.setmTrainDetails(this.mTrainQuickBookBody.getmTrainDetailsBody());
            }
            if (this.mTrainQuickBookBody.getPaxInfo() != null) {
                cJRTrainConfirmation.setmPassengerInfo(this.mTrainQuickBookBody.getPaxInfo());
            }
            if (this.mTrainQuickBookBody.getmInfantInfo() != null) {
                cJRTrainConfirmation.setmInfantInfo(this.mTrainQuickBookBody.getmInfantInfo());
            }
            if (this.mTrainQuickBookBody.getmFastForward() != null) {
                cJRTrainConfirmation.setFastForward(this.mTrainQuickBookBody.getmFastForward());
            }
            if (this.mTrainQuickBookBody.getmCancellationInsurance() != null) {
                cJRTrainConfirmation.setCancellationInsurance(this.mTrainQuickBookBody.getmCancellationInsurance());
            }
            if (!TextUtils.isEmpty(this.mTrainQuickBookBody.getmReviewItineraryMessage())) {
                cJRTrainConfirmation.setReviewItineraryMessage(this.mTrainQuickBookBody.getmReviewItineraryMessage());
            }
            if (this.mTrainQuickBookBody.getmAddOns() != null) {
                cJRTrainConfirmation.setmAddOns(this.mTrainQuickBookBody.getmAddOns());
            }
            if (!TextUtils.isEmpty(this.mTrainQuickBookBody.getFfButtonText())) {
                cJRTrainConfirmation.setFfButtonText(this.mTrainQuickBookBody.getFfButtonText());
            }
            cJRTrainConfirmation.setGrandTotalKey(Integer.valueOf(this.mTrainQuickBookBody.getGrandTotalKey()));
            if (this.mTrainQuickBookBody.getFareDetails() != null) {
                cJRTrainConfirmation.setFareDetails(this.mTrainQuickBookBody.getFareDetails());
            }
            if (!TextUtils.isEmpty(this.mTrainQuickBookBody.getmTransactionId())) {
                cJRTrainConfirmation.setmTransactionId(this.mTrainQuickBookBody.getmTransactionId());
            }
            this.mTrainBooking.setConfirmation(cJRTrainConfirmation);
        }
    }

    public void showNetworkDialog(final com.paytm.network.a aVar) {
        removeProgressDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) AJRTrainQuickBookActivity.this)) {
                    AJRTrainQuickBookActivity aJRTrainQuickBookActivity = AJRTrainQuickBookActivity.this;
                    aJRTrainQuickBookActivity.showProgressDialog(aJRTrainQuickBookActivity, aJRTrainQuickBookActivity.getString(R.string.please_wait_loading_quick_book));
                    aVar.a();
                    return;
                }
                AJRTrainQuickBookActivity.this.showNetworkDialog(aVar);
            }
        });
        builder.show();
    }

    private void showErrorMessage(String str, String str2, final CJRTrainQuickBookBody cJRTrainQuickBookBody) {
        removeProgressDialog();
        final h hVar = new h(this);
        if (str != null) {
            hVar.setTitle(str2);
            hVar.setCancelable(false);
            hVar.a(str);
            hVar.a(-3, getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    AJRTrainQuickBookActivity.this.checkPageToLand(cJRTrainQuickBookBody);
                }
            });
            hVar.show();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = hVar.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            window.setAttributes(layoutParams);
        }
    }

    private String getClassFullName(String str) {
        String str2 = str;
        for (Map.Entry next : this.mClassMap.entrySet()) {
            if (((String) next.getKey()).equals(str)) {
                str2 = next.getValue().toString();
            }
        }
        return str2;
    }

    private String getQuotaFullName(String str) {
        String str2 = str;
        for (Map.Entry next : this.mQuotaMap.entrySet()) {
            if (((String) next.getKey()).equals(str)) {
                str2 = (String) next.getValue();
            }
        }
        return str2;
    }

    private void checkIfWaitingList(CJRTrainAvailability cJRTrainAvailability) {
        HashMap<String, String> typeMap = cJRTrainAvailability.getTypeMap();
        if (typeMap != null) {
            for (Map.Entry<String, String> value : typeMap.entrySet()) {
                this.mIsWaitingList = !value.getValue().equals("1");
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((i3 != -1 && i3 == 0) || i2 != 3) {
            return;
        }
        if (e.a((Context) this)) {
            getWalletToken();
        } else {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
