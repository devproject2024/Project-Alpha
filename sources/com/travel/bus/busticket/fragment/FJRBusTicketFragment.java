package com.travel.bus.busticket.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.activity.AJRBusSearchSRPActivity;
import com.travel.bus.busticket.activity.AJRBusSelectCityActivity;
import com.travel.bus.busticket.b.g;
import com.travel.bus.busticket.i.j;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.y;
import com.travel.bus.busticket.i.z;
import com.travel.bus.pojo.busticket.CJRBusOriginCity;
import com.travel.bus.pojo.busticket.CJRBusOriginCityItem;
import com.travel.bus.pojo.busticket.CJRBusRnRHome;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class FJRBusTicketFragment extends h implements View.OnClickListener, Response.ErrorListener, Response.Listener<IJRDataModel>, b, g, com.travel.common.a.b {
    private Locale appLocale;
    /* access modifiers changed from: private */
    public CJRBusOriginCityItem cityItemDestination;
    /* access modifiers changed from: private */
    public CJRBusOriginCityItem cityItemSource;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.b.b compositeDisposable;
    private RelativeLayout dateLayout;
    private ImageView imgOneWayIcon;
    private String isDealsFilter = "";
    private boolean isFragmentPaused = false;
    private boolean isFromCurrentLocation = false;
    private boolean isRecentSearchAvilable = false;
    private boolean isStoreFrontFragmentAddPending;
    private boolean isTravelOfferFragmentLoaded = false;
    private boolean isValidDestination = true;
    private boolean isValidSource = true;
    private Animation mAnimMoveDown;
    private Animation mAnimMoveUp;
    private Animation mAnimationShake;
    private ScrollView mBusHomeContainer;
    private Context mContext;
    private String mCurrentLocationCity;
    /* access modifiers changed from: private */
    public SimpleDateFormat mDateFormat;
    String mDateValue;
    /* access modifiers changed from: private */
    public TextView mDestinationCity;
    private int mDestinationCityScreenVisitCount = 0;
    private Fragment mEndLessFragment;
    private int mGridUnit;
    private LinearLayout mJourneyDateViewContainer;
    private long mLastLoadTime;
    private RelativeLayout mLytMaintenanceView;
    private String mOperatorId;
    private Button mProceedButton;
    private Animation mRotateAnimation;
    /* access modifiers changed from: private */
    public long mSelectedDateValue;
    /* access modifiers changed from: private */
    public TextView mSourceCity;
    private int mSourceCityScreenVisitCount = 0;
    /* access modifiers changed from: private */
    public TextView mSourceDate;
    private TextView mSourceDateTextView;
    private TextView mSourceMonthTextView;
    private TextView mSourceWeekTextView;
    private TextView mTodayText;
    private TextView mTomorrowText;
    private String mUserId;
    private ViewPager mViewPager;
    private ViewTreeObserver.OnScrollChangedListener onScrollListener;
    private String popularChoiceFilter = "";
    /* access modifiers changed from: private */
    public String pulseDate = "";
    private boolean rnrApiCallDone;
    private View view;

    public void onErrorResponse(VolleyError volleyError) {
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
    }

    public void onResponse(IJRDataModel iJRDataModel) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.compositeDisposable = new io.reactivex.rxjava3.b.b();
        if (getArguments() != null) {
            checkDeepLinking();
        }
    }

    private void checkDeepLinking() {
        try {
            if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
                a.a();
                a.b().a("/bus-tickets", (CJRHomePageItem) getArguments().getSerializable("extra_home_data"), (Context) getActivity());
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isFragmentPaused = true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (getActivity() instanceof com.travel.bus.busticket.f.a) {
                getActivity();
            }
            callEventsAndEndlessScroll();
        }
    }

    private void callEventsAndEndlessScroll() {
        if (getActivity() != null) {
            a.a();
            a.b().a("/bus-tickets", "BusTicket", (Context) getActivity());
            a.a();
            a.b().a("screen_loaded_bus_ticket", (Context) getActivity());
            loadEndlessScrollFragment();
        }
    }

    private void loadEndlessScrollFragment() {
        if (!this.isTravelOfferFragmentLoaded && isResumed() && getUserVisibleHint()) {
            this.isTravelOfferFragmentLoaded = true;
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" - Loaded");
            getBusHomeRnRApiCall();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        com.google.android.play.core.splitcompat.a.a(activity.getApplicationContext());
        com.google.android.play.core.splitcompat.a.b((Context) activity);
        this.mContext = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments;
        this.view = layoutInflater.inflate(R.layout.pre_b_bus_ticket_home, (ViewGroup) null);
        initUI(this.view);
        this.appLocale = new Locale(n.a());
        this.mBusHomeContainer.setVisibility(0);
        prefillBusDetails(this.view);
        if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
            if (!(cJRHomePageItem == null || cJRHomePageItem.getURLType() == null || !"busticket".equalsIgnoreCase(cJRHomePageItem.getURLType()) || cJRHomePageItem.getURL() == null)) {
                this.mOperatorId = Uri.parse(cJRHomePageItem.getURL()).getQueryParameter("operatorId");
                HashMap hashMap = new HashMap();
                String str = this.mOperatorId;
                if (str == null || str.isEmpty()) {
                    hashMap.put("event_label", "");
                } else {
                    hashMap.put("event_label", this.mOperatorId);
                }
                hashMap.put("userid", com.paytm.utility.b.n((Context) getActivity()));
                a.a();
                a.a("customEvent", "/bus-tickets", "bus_home", "operator_qr_code_scanned", hashMap);
            }
            if (!(cJRHomePageItem == null || cJRHomePageItem.getURL() == null)) {
                this.isDealsFilter = Uri.parse(cJRHomePageItem.getURL()).getQueryParameter("Deals".toLowerCase());
            }
            if (!(cJRHomePageItem == null || cJRHomePageItem.getURL() == null)) {
                this.popularChoiceFilter = Uri.parse(cJRHomePageItem.getURL()).getQueryParameter("route_time_id".toLowerCase());
            }
        }
        y yVar = y.f22482a;
        y.a(CJRBusSearchInput.class).subscribe(new w<CJRBusSearchInput>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                CJRBusSearchInput cJRBusSearchInput = (CJRBusSearchInput) obj;
                if (cJRBusSearchInput != null && FJRBusTicketFragment.this.getActivity() != null && !FJRBusTicketFragment.this.getActivity().isDestroyed() && FJRBusTicketFragment.this.isAdded()) {
                    if (cJRBusSearchInput.getSource() != null && !TextUtils.isEmpty(cJRBusSearchInput.getSource().getCityName())) {
                        FJRBusTicketFragment.this.mSourceCity.setText(cJRBusSearchInput.getSource().getCityName());
                    }
                    if (cJRBusSearchInput.getDestination() != null && !TextUtils.isEmpty(cJRBusSearchInput.getDestination().getCityName())) {
                        FJRBusTicketFragment.this.mDestinationCity.setText(cJRBusSearchInput.getDestination().getCityName());
                    }
                    try {
                        if (!TextUtils.isEmpty(cJRBusSearchInput.getDate())) {
                            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(cJRBusSearchInput.getDate());
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE-d-MMMM");
                            String format = new SimpleDateFormat("d MMM yy").format(parse);
                            FJRBusTicketFragment.this.setDateToLayout(simpleDateFormat.format(parse));
                            FJRBusTicketFragment.this.mSourceDate.setTag(com.paytm.utility.b.a(Long.valueOf(parse.getTime())));
                            TextView access$400 = FJRBusTicketFragment.this.mSourceDate;
                            FragmentActivity activity = FJRBusTicketFragment.this.getActivity();
                            String format2 = FJRBusTicketFragment.this.mDateFormat.format(Long.valueOf(parse.getTime()));
                            a.a();
                            access$400.setText(com.paytm.utility.b.a((Activity) activity, format2, "dd MMM yy", "EEE, dd MMM", a.b().b()));
                            FJRBusTicketFragment fJRBusTicketFragment = FJRBusTicketFragment.this;
                            FragmentActivity activity2 = FJRBusTicketFragment.this.getActivity();
                            String format3 = FJRBusTicketFragment.this.mDateFormat.format(Long.valueOf(parse.getTime()));
                            a.a();
                            String unused = fJRBusTicketFragment.pulseDate = com.paytm.utility.b.a((Activity) activity2, format3, "dd MMM yy", "dd-MMM-yy", a.b().b());
                            long unused2 = FJRBusTicketFragment.this.mSelectedDateValue = parse.getTime();
                            if (FJRBusTicketFragment.this.isTodayDate(format)) {
                                FJRBusTicketFragment.this.setTodayButton();
                            } else if (FJRBusTicketFragment.this.isTomoDate(format)) {
                                FJRBusTicketFragment.this.setTomorrowButton();
                            } else {
                                FJRBusTicketFragment.this.disableTodayAndTomorrowButton();
                            }
                        }
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                    CJRBusOriginCityItem unused3 = FJRBusTicketFragment.this.cityItemSource = cJRBusSearchInput.getSource();
                    CJRBusOriginCityItem unused4 = FJRBusTicketFragment.this.cityItemDestination = cJRBusSearchInput.getDestination();
                }
            }

            public final void onSubscribe(c cVar) {
                FJRBusTicketFragment.this.compositeDisposable.a(cVar);
            }
        });
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("from_bus_retry") && intent.getBooleanExtra("from_bus_retry", false) && (arguments = getArguments()) != null) {
            prefillBusDetailsRetryData(arguments);
        }
        return this.view;
    }

    public void onPause() {
        super.onPause();
        this.isDealsFilter = "";
        this.popularChoiceFilter = "";
    }

    private void prefillBusDetails(View view2) {
        boolean z;
        boolean z2;
        try {
            if (getArguments() == null || !getArguments().containsKey("extra_home_data") || !(getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
                z = false;
            } else {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
                z = true;
                if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityName()) || TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityShortName())) {
                    z2 = false;
                } else {
                    getCitiesApiCall(cJRHomePageItem.getPushSourceCityName(), true);
                    z2 = true;
                }
                if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getPushDestinationCityName()) || TextUtils.isEmpty(cJRHomePageItem.getPushDestinationCityShortName())) {
                    z = z2;
                } else {
                    getCitiesApiCall(cJRHomePageItem.getPushDestinationCityName(), false);
                }
                if (cJRHomePageItem == null || cJRHomePageItem.getPushDate() == null) {
                    getPrefilDateValue();
                } else if (cJRHomePageItem.getPushDate().equalsIgnoreCase("today")) {
                    setTodaysDate(false);
                    setTodayButton();
                } else if (cJRHomePageItem.getPushDate().equalsIgnoreCase("tomorrow")) {
                    setTomorrowsDate(false);
                    setTomorrowButton();
                } else if (!TextUtils.isEmpty(cJRHomePageItem.getPushDate()) && isTomoDate(cJRHomePageItem.getPushDate().trim())) {
                    setTomorrowsDate(false);
                    setTomorrowButton();
                } else if (!TextUtils.isEmpty(cJRHomePageItem.getPushDate()) && isTodayDate(cJRHomePageItem.getPushDate().trim())) {
                    setTodaysDate(false);
                    setTodayButton();
                }
            }
            if (!z) {
                getPrefillFromCity();
                getPrefillToCity();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isTomoDate(String str) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        return str.equalsIgnoreCase(new SimpleDateFormat("d MMM yy", this.appLocale).format(instance.getTime()));
    }

    /* access modifiers changed from: private */
    public boolean isTodayDate(String str) {
        return str.equalsIgnoreCase(new SimpleDateFormat("d MMM yy", this.appLocale).format(Calendar.getInstance().getTime()));
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        if (this.isStoreFrontFragmentAddPending) {
            addStoreFrontFragment();
            this.isStoreFrontFragmentAddPending = false;
        }
    }

    private void initUI(View view2) {
        try {
            this.mDateFormat = new SimpleDateFormat("d MMM yy");
            this.mSourceCity = (TextView) view2.findViewById(R.id.source);
            this.mSourceCity.setOnClickListener(this);
            this.mDestinationCity = (TextView) view2.findViewById(R.id.destination);
            this.mDestinationCity.setOnClickListener(this);
            this.mTodayText = (TextView) view2.findViewById(R.id.txt_today_date);
            this.mTomorrowText = (TextView) view2.findViewById(R.id.txt_tomorrow_date);
            this.mTodayText.setOnClickListener(this);
            this.mTomorrowText.setOnClickListener(this);
            this.mJourneyDateViewContainer = (LinearLayout) view2.findViewById(R.id.journey_date_view_container);
            this.mJourneyDateViewContainer.setOnClickListener(this);
            this.mBusHomeContainer = (ScrollView) view2.findViewById(R.id.bus_ticket_home_container);
            this.onScrollListener = new ViewTreeObserver.OnScrollChangedListener() {
                public final void onScrollChanged() {
                    FJRBusTicketFragment.this.lambda$initUI$0$FJRBusTicketFragment();
                }
            };
            this.mBusHomeContainer.getViewTreeObserver().addOnScrollChangedListener(this.onScrollListener);
            this.mLastLoadTime = System.currentTimeMillis();
            this.mLytMaintenanceView = (RelativeLayout) view2.findViewById(R.id.lyt_maintenance_view);
            int g2 = com.paytm.utility.b.g((Context) getActivity());
            this.dateLayout = (RelativeLayout) view2.findViewById(R.id.date_selection_layout);
            this.mSourceDate = (TextView) view2.findViewById(R.id.source_date);
            this.mSourceDateTextView = (TextView) view2.findViewById(R.id.source_date_text_view);
            this.mSourceMonthTextView = (TextView) view2.findViewById(R.id.source_month_text_view);
            this.mSourceWeekTextView = (TextView) view2.findViewById(R.id.source_week_text_view);
            setTodaysDate(true);
            setTodayButton();
            this.mSourceDate.setOnClickListener(this);
            int i2 = (int) (((double) g2) * 1.5d);
            view2.findViewById(R.id.bus_home).setPadding(i2, 0, i2, i2);
            view2.findViewById(R.id.journey_date).setPadding(0, i2, 0, i2);
            view2.findViewById(R.id.lyt_bus_type_check_box_container).setPadding(0, 0, 0, i2);
            this.mRotateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_b_rotate360);
            this.mRotateAnimation.setRepeatCount(1);
            this.mAnimMoveUp = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_b_move_up);
            this.mAnimMoveDown = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_b_move_down);
            this.mAnimationShake = AnimationUtils.loadAnimation(getActivity(), R.anim.pre_b_shake);
            this.imgOneWayIcon = (ImageView) view2.findViewById(R.id.sep_route);
            this.imgOneWayIcon.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FJRBusTicketFragment.this.lambda$initUI$1$FJRBusTicketFragment(view);
                }
            });
            this.mProceedButton = (Button) view2.findViewById(R.id.proceed_btn);
            this.mProceedButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FJRBusTicketFragment.this.lambda$initUI$2$FJRBusTicketFragment(view);
                }
            });
            this.mGridUnit = com.paytm.utility.b.f((Context) getActivity());
            this.mViewPager = (ViewPager) view2.findViewById(R.id.image_pager);
            ViewGroup.LayoutParams layoutParams = this.mViewPager.getLayoutParams();
            layoutParams.height = (int) (((double) this.mGridUnit) * 8.5d);
            layoutParams.width = (int) (((double) this.mGridUnit) * 16.0d);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public /* synthetic */ void lambda$initUI$0$FJRBusTicketFragment() {
        ScrollView scrollView = this.mBusHomeContainer;
        if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (this.mBusHomeContainer.getHeight() + this.mBusHomeContainer.getScrollY()) == 0) {
            if (this.mEndLessFragment != null && shouldRequestForLoadMore()) {
                a.a();
                a.b().a(this.mEndLessFragment);
            }
        } else if (this.mEndLessFragment != null) {
            a.a();
            a.b().b(this.mEndLessFragment);
        }
    }

    public /* synthetic */ void lambda$initUI$1$FJRBusTicketFragment(View view2) {
        onExchangePressed();
    }

    public /* synthetic */ void lambda$initUI$2$FJRBusTicketFragment(View view2) {
        onProceedClick(true);
    }

    private boolean shouldRequestForLoadMore() {
        if (System.currentTimeMillis() - this.mLastLoadTime <= 1000) {
            return false;
        }
        this.mLastLoadTime = System.currentTimeMillis();
        return true;
    }

    public void onClick(View view2) {
        if (view2 == this.mJourneyDateViewContainer || view2 == this.mSourceDate) {
            launchCalenderActivity(200, this.mSourceDate.getTag().toString());
        } else if (view2 == this.mSourceCity) {
            sendCustomGAEvents("from_clicked");
            launchOriginCityActivity(201, "source");
        } else if (view2 == this.mDestinationCity) {
            sendCustomGAEvents("to_clicked");
            launchOriginCityActivity(201, "destination");
        } else if (view2 == this.mTodayText) {
            setTodaysDate(false);
            setTodayButton();
            this.mSelectedDateValue = 0;
            pulseEvent("Today", "date_selected");
            pulseEvent("Today", "today_tomorrow_clicked");
            sendDateTodayButtonClickGTMEvent();
        } else if (view2 == this.mTomorrowText) {
            this.mSelectedDateValue = 0;
            setTomorrowsDate(false);
            setTomorrowButton();
            pulseEvent("Tomorrow", "date_selected");
            pulseEvent("Tomorrow", "today_tomorrow_clicked");
            sendDateTomorrowButtonClickGTMEvent();
        }
    }

    private void sendCustomGAEvents(String str) {
        if (getActivity() != null && !TextUtils.isEmpty(str)) {
            o.a((Context) getActivity(), "/bus-tickets", "bus_home", str);
        }
    }

    /* access modifiers changed from: private */
    public void setTomorrowButton() {
        this.mTomorrowText.setTextColor(getResources().getColor(R.color.bus_paytm_blue));
        this.mTodayText.setTextColor(getResources().getColor(R.color.gray));
    }

    /* access modifiers changed from: private */
    public void disableTodayAndTomorrowButton() {
        this.mTomorrowText.setTextColor(getResources().getColor(R.color.gray));
        this.mTodayText.setTextColor(getResources().getColor(R.color.gray));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setTomorrowsDate(boolean r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            r2 = 5
            r3 = 1
            r1.add(r2, r3)
            java.util.Date r2 = r1.getTime()
            if (r7 != 0) goto L_0x0022
            android.widget.TextView r3 = r6.mSourceDate
            long r4 = r2.getTime()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = com.paytm.utility.b.a((java.lang.Long) r4)
            r3.setTag(r4)
        L_0x0022:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x003b }
            java.lang.String r4 = "EEEE-d-MMM"
            r3.<init>(r4)     // Catch:{ Exception -> 0x003b }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x003b }
            java.lang.String r5 = "EEEE-d-MMMM"
            r4.<init>(r5)     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.format(r2)     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r4.format(r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r4 = move-exception
            goto L_0x003d
        L_0x003b:
            r4 = move-exception
            r3 = r0
        L_0x003d:
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.c(r4)
        L_0x0044:
            if (r7 != 0) goto L_0x004e
            r6.setDateToLayout(r0)
            android.widget.TextView r7 = r6.mSourceDate
            r7.setText(r3)
        L_0x004e:
            android.widget.TextView r7 = r6.mSourceDate
            java.lang.CharSequence r7 = r7.getText()
            long r2 = r2.getTime()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r0 = com.paytm.utility.b.a((java.lang.Long) r0)
            r6.savePrefilDateValue(r7, r0)
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            java.text.SimpleDateFormat r0 = r6.mDateFormat
            java.util.Date r1 = r1.getTime()
            java.lang.String r0 = r0.format(r1)
            com.travel.bus.a.a()
            com.travel.g.a r1 = com.travel.bus.a.b()
            java.lang.String r1 = r1.b()
            java.lang.String r2 = "dd MMM yy"
            java.lang.String r3 = "dd-MMM-yy"
            java.lang.String r7 = com.paytm.utility.b.a((android.app.Activity) r7, (java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r1)
            r6.pulseDate = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.FJRBusTicketFragment.setTomorrowsDate(boolean):void");
    }

    /* access modifiers changed from: private */
    public void setDateToLayout(String str) {
        if (this.dateLayout.getVisibility() != 0) {
            this.dateLayout.setVisibility(0);
            this.mSourceDate.setVisibility(8);
        }
        String[] split = str.split("-");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        this.mSourceWeekTextView.setText((CharSequence) arrayList.get(0));
        this.mSourceDateTextView.setText((CharSequence) arrayList.get(1));
        this.mSourceMonthTextView.setText((CharSequence) arrayList.get(2));
    }

    /* access modifiers changed from: private */
    public void setTodayButton() {
        this.mTodayText.setTextColor(getResources().getColor(R.color.bus_paytm_blue));
        this.mTomorrowText.setTextColor(getResources().getColor(R.color.gray));
    }

    private void setTodaysDate(boolean z) {
        String str;
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        try {
            str = new SimpleDateFormat("EEEE-d-MMMM").format(time);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            str = "";
        }
        this.mSourceDate.setTag(com.paytm.utility.b.a(Long.valueOf(time.getTime())));
        setDateToLayout(str);
        TextView textView = this.mSourceDate;
        FragmentActivity activity = getActivity();
        String format = this.mDateFormat.format(instance.getTime());
        a.a();
        textView.setText(com.paytm.utility.b.a((Activity) activity, format, "dd MMM yy", "EEE, dd MMM", a.b().b()));
        if (!z) {
            savePrefilDateValue(this.mSourceDate.getText(), com.paytm.utility.b.a(Long.valueOf(time.getTime())));
        }
        FragmentActivity activity2 = getActivity();
        String format2 = this.mDateFormat.format(instance.getTime());
        a.a();
        this.pulseDate = com.paytm.utility.b.a((Activity) activity2, format2, "dd MMM yy", "dd-MMM-yy", a.b().b());
    }

    private void launchOriginCityActivity(int i2, String str) {
        try {
            if (getActivity() != null) {
                if (str != null) {
                    if (str.equalsIgnoreCase("source")) {
                        this.mSourceCityScreenVisitCount++;
                    } else if (str.equalsIgnoreCase("destination")) {
                        this.mDestinationCityScreenVisitCount++;
                    }
                }
                Intent intent = new Intent(getActivity(), AJRBusSelectCityActivity.class);
                intent.putExtra("activity_name", str);
                intent.putExtra("intent_extra_selected_city_source_item", this.cityItemSource);
                intent.putExtra("intent_extra_selected_city_destination_item", this.cityItemDestination);
                if (!(this.mSourceCity.getText() == null || this.mSourceCity.getText().length() == 0)) {
                    intent.putExtra("city_source_name", this.mSourceCity.getText());
                }
                if (!(this.mDestinationCity.getText() == null || this.mDestinationCity.getText().length() == 0)) {
                    intent.putExtra("city_destination_name", this.mDestinationCity.getText());
                }
                getActivity().startActivityForResult(intent, i2);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void launchCalenderActivity(int i2, String str) {
        a.a();
        getActivity().startActivityForResult(a.b().a((Activity) requireActivity(), getResources().getString(R.string.bus_departure), str, this.mSelectedDateValue, z.a()), i2);
    }

    private void pulseEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        hashMap.put("event_label2", this.pulseDate.replace("-", " "));
        hashMap.put("userid", com.paytm.utility.b.n((Context) getActivity()));
        a.a();
        a.a("customEvent", "/bus-tickets", "bus_home", str2, hashMap);
    }

    private String getFormatedDate(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new SimpleDateFormat("dd MMMM yy", Locale.ENGLISH).parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        onActivityResult(i2, intent);
    }

    public void onActivityResult(int i2, Intent intent) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ScrollView scrollView = this.mBusHomeContainer;
        if (scrollView != null) {
            scrollView.fullScroll(33);
        }
        if (i2 != 9876) {
            switch (i2) {
                case 200:
                    if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
                        String stringExtra = intent.getStringExtra("intent_extra_selected_depart_date");
                        if (intent != null && intent.hasExtra("intent_extra_selected_date_time")) {
                            this.mSelectedDateValue = intent.getLongExtra("intent_extra_selected_date_time", 0);
                        }
                        this.mDateValue = intent.getStringExtra("date_value");
                        String str = this.mDateValue;
                        if (str != null) {
                            if (str.equalsIgnoreCase("today")) {
                                setTodayButton();
                            } else if (this.mDateValue.equalsIgnoreCase("tomorrow")) {
                                setTomorrowButton();
                            } else {
                                setDateButtons();
                            }
                        }
                        if (this.mSourceDate != null) {
                            if (n.a().equalsIgnoreCase("hi") || n.a().equalsIgnoreCase("ta") || n.a().equalsIgnoreCase("te") || n.a().equalsIgnoreCase("kn") || n.a().equalsIgnoreCase("pa") || n.a().equalsIgnoreCase("mr") || n.a().equalsIgnoreCase("gu") || n.a().equalsIgnoreCase("bn") || n.a().equalsIgnoreCase("or") || n.a().equalsIgnoreCase("ml")) {
                                TextView textView5 = this.mSourceDate;
                                getActivity();
                                textView5.setText(com.paytm.utility.b.a("EEE, dd MMM", this.mSelectedDateValue));
                                FragmentActivity activity = getActivity();
                                a.a();
                                this.pulseDate = com.paytm.utility.b.a((Activity) activity, stringExtra, "dd MMM yy", "dd-MMM-yy", a.b().b());
                            } else {
                                FragmentActivity activity2 = getActivity();
                                a.a();
                                this.pulseDate = com.paytm.utility.b.a((Activity) activity2, stringExtra, "dd MMM yy", "dd-MMM-yy", a.b().b());
                                TextView textView6 = this.mSourceDate;
                                FragmentActivity activity3 = getActivity();
                                a.a();
                                textView6.setText(com.paytm.utility.b.a((Activity) activity3, stringExtra, "dd MMM yy", "EEE, dd MMM", a.b().b()));
                            }
                        }
                        String a2 = com.paytm.utility.b.a(Long.valueOf(this.mSelectedDateValue));
                        savePrefilDateValue(this.mSourceDate.getText(), a2);
                        this.mSourceDate.setTag(a2);
                        try {
                            a2 = new SimpleDateFormat("EEEE-d-MMMM").format(Long.valueOf(this.mSelectedDateValue));
                        } catch (Exception e2) {
                            q.c(e2.getMessage());
                        }
                        setDateToLayout(a2);
                        sendDateSelectedGTMEvent(stringExtra);
                        pulseEvent("Calendar", "date_selected");
                        return;
                    }
                    return;
                case 201:
                    if ((intent != null && intent.hasExtra("intent_extra_selected_city_source_item")) || (intent != null && intent.hasExtra("intent_extra_selected_city_destination_item"))) {
                        String stringExtra2 = intent.getStringExtra("intent_extra_selected_source_city_name");
                        String stringExtra3 = intent.getStringExtra("intent_extra_selected_destination_city_name");
                        this.cityItemSource = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_source_item");
                        this.cityItemDestination = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_destination_item");
                        String stringExtra4 = intent.getStringExtra("intent_extra_city_catagory");
                        int intExtra = intent.getIntExtra("intent_extra_selected_city_position", 0);
                        String stringExtra5 = intent.getStringExtra("intent_extra_last_known_search_keyword");
                        if (!(stringExtra2 == null || (textView3 = this.mSourceCity) == null)) {
                            textView3.setText(stringExtra2);
                            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_000000));
                        }
                        if (!(stringExtra3 == null || (textView2 = this.mDestinationCity) == null)) {
                            textView2.setText(stringExtra3);
                            this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_000000));
                        }
                        TextView textView7 = this.mSourceCity;
                        CJRBusOriginCityItem cJRBusOriginCityItem = null;
                        CJRBusOriginCityItem cJRBusOriginCityItem2 = (textView7 == null || textView7.getTag() == null || !(this.mSourceCity.getTag() instanceof CJRBusOriginCityItem)) ? null : (CJRBusOriginCityItem) this.mSourceCity.getTag();
                        TextView textView8 = this.mDestinationCity;
                        if (!(textView8 == null || textView8.getTag() == null || !(this.mDestinationCity.getTag() instanceof CJRBusOriginCityItem))) {
                            cJRBusOriginCityItem = (CJRBusOriginCityItem) this.mDestinationCity.getTag();
                        }
                        TextView textView9 = this.mSourceCity;
                        String str2 = "";
                        String charSequence = (textView9 == null || textView9.getText() == null) ? str2 : this.mSourceCity.getText().toString();
                        TextView textView10 = this.mDestinationCity;
                        if (!(textView10 == null || textView10.getText() == null)) {
                            str2 = this.mDestinationCity.getText().toString();
                        }
                        boolean sourceDestValidation = getSourceDestValidation(this.mSourceCity, cJRBusOriginCityItem2, charSequence);
                        boolean sourceDestValidation2 = getSourceDestValidation(this.mDestinationCity, cJRBusOriginCityItem, str2);
                        CJRBusOriginCityItem cJRBusOriginCityItem3 = this.cityItemSource;
                        if (cJRBusOriginCityItem3 != null && cJRBusOriginCityItem3.getName() != null && this.mSourceCity != null) {
                            sendFromFieldSelectedGTMEvent(this.cityItemSource.getDisplayCityName() != null ? this.cityItemSource.getDisplayCityName() : this.cityItemSource.getName(), stringExtra4, intExtra, stringExtra5);
                            this.mSourceCity.setTag(this.cityItemSource);
                            savePrefillFromData(this.cityItemSource);
                            this.isValidSource = true;
                        } else if (sourceDestValidation) {
                            this.isValidSource = false;
                        }
                        CJRBusOriginCityItem cJRBusOriginCityItem4 = this.cityItemDestination;
                        if (cJRBusOriginCityItem4 != null && (textView = this.mDestinationCity) != null) {
                            textView.setTag(cJRBusOriginCityItem4);
                            savePrefillToData(this.cityItemDestination);
                            this.isValidDestination = true;
                        } else if (sourceDestValidation2) {
                            this.isValidDestination = false;
                        }
                        TextView textView11 = this.mSourceCity;
                        if (textView11 != null && this.mDestinationCity != null && !TextUtils.isEmpty(textView11.getText()) && !TextUtils.isEmpty(this.mDestinationCity.getText())) {
                            String charSequence2 = this.mSourceCity.getText().toString();
                            String charSequence3 = this.mDestinationCity.getText().toString();
                            if (!charSequence2.equalsIgnoreCase(getString(R.string.bus_origin_txt))) {
                                charSequence3.equalsIgnoreCase(getString(R.string.bus_destination_txt));
                            }
                        }
                    }
                    TextView textView12 = this.mDestinationCity;
                    if (textView12 != null && textView12.getText() != null && this.mDestinationCity.getText().toString().equalsIgnoreCase(getResources().getString(R.string.bus_destination_txt)) && this.mDestinationCityScreenVisitCount <= 0 && intent != null) {
                        new Handler().post(new Runnable() {
                            public final void run() {
                                FJRBusTicketFragment.this.lambda$onActivityResult$3$FJRBusTicketFragment();
                            }
                        });
                        return;
                    }
                    return;
                case 202:
                    if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
                        CJRBusOriginCityItem cJRBusOriginCityItem5 = (CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_name");
                        String stringExtra6 = intent.getStringExtra("intent_extra_city_catagory");
                        int intExtra2 = intent.getIntExtra("intent_extra_selected_city_position", 0);
                        String stringExtra7 = intent.getStringExtra("intent_extra_last_known_search_keyword");
                        if (!(cJRBusOriginCityItem5 == null || cJRBusOriginCityItem5.getName() == null)) {
                            String displayCityName = cJRBusOriginCityItem5.getDisplayCityName() != null ? cJRBusOriginCityItem5.getDisplayCityName() : cJRBusOriginCityItem5.getName();
                            if (!(displayCityName == null || (textView4 = this.mDestinationCity) == null)) {
                                textView4.setText(displayCityName);
                                this.mDestinationCity.setTag(cJRBusOriginCityItem5);
                                this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_000000));
                                savePrefillToData(cJRBusOriginCityItem5);
                                sendToFieldSelectedGTMEvent(displayCityName, stringExtra6, intExtra2, stringExtra7);
                            }
                        }
                    }
                    TextView textView13 = this.mSourceCity;
                    if (textView13 != null && textView13.getText() != null && this.mSourceCity.getText().toString().equalsIgnoreCase(getResources().getString(R.string.bus_origin_txt)) && this.mSourceCityScreenVisitCount <= 0 && intent != null) {
                        new Handler().post(new Runnable() {
                            public final void run() {
                                FJRBusTicketFragment.this.lambda$onActivityResult$4$FJRBusTicketFragment();
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            onBusSrpResult();
        }
    }

    public /* synthetic */ void lambda$onActivityResult$3$FJRBusTicketFragment() {
        launchOriginCityActivity(202, "destination");
    }

    public /* synthetic */ void lambda$onActivityResult$4$FJRBusTicketFragment() {
        launchOriginCityActivity(201, "source");
    }

    private boolean getSourceDestValidation(TextView textView, CJRBusOriginCityItem cJRBusOriginCityItem, String str) {
        if (!(textView == null || cJRBusOriginCityItem == null)) {
            String displayCityName = cJRBusOriginCityItem.getDisplayCityName() != null ? cJRBusOriginCityItem.getDisplayCityName() : cJRBusOriginCityItem.getName();
            return displayCityName != null && !displayCityName.equalsIgnoreCase(str);
        }
    }

    public void onBusSrpResult() {
        this.mOperatorId = "";
        getPrefillFromCity();
        getPrefillToCity();
        getPrefilDateValue();
    }

    private void setDateButtons() {
        this.mTomorrowText.setTextColor(getResources().getColor(R.color.bus_tab_unselected_text));
        this.mTodayText.setTextColor(getResources().getColor(R.color.bus_tab_unselected_text));
    }

    public void onProceedClick(boolean z) {
        validateEntries(z);
    }

    private void validateEntries(boolean z) {
        String charSequence = this.mSourceCity.getText().toString();
        String charSequence2 = this.mDestinationCity.getText().toString();
        Resources resources = getResources();
        if (charSequence.equalsIgnoreCase(resources.getString(R.string.bus_origin_txt)) || TextUtils.isEmpty(charSequence)) {
            this.mSourceCity.startAnimation(this.mAnimationShake);
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.bus_origin_city_missing_title), resources.getString(R.string.bus_origin_city_missing_msg));
        } else if (charSequence2.equalsIgnoreCase(resources.getString(R.string.bus_destination_txt)) || TextUtils.isEmpty(charSequence2)) {
            this.mDestinationCity.startAnimation(this.mAnimationShake);
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.bus_destination_city_missing_title), resources.getString(R.string.bus_destination_city_missing_msg));
        } else if (charSequence.equalsIgnoreCase(charSequence2)) {
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.bus_travel_same_from_to_title), getResources().getString(R.string.bus_travel_same_from_to_desc));
        } else if (!this.isValidSource || !this.isValidDestination) {
            Toast.makeText(getContext(), getString(R.string.please_enter_valid_city), 0).show();
        } else if (this.mSourceDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.bus_pick_date))) {
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.bus_travel_date_missing_title), resources.getString(R.string.bus_travel_date_missing_msg));
        } else if (TextUtils.isEmpty(this.mSourceDate.getText().toString())) {
            com.paytm.utility.b.a((Activity) getActivity(), FJRBusTicketFragment.class.getName());
        } else {
            o.a((Context) getActivity(), (CJRBusOriginCityItem) this.mSourceCity.getTag(), true, o.a());
            o.a((Context) getActivity(), (CJRBusOriginCityItem) this.mDestinationCity.getTag(), false, o.a());
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
            hashMap.put("bus_origin", this.mSourceCity.getText().toString());
            hashMap.put("bus_destination", this.mDestinationCity.getText().toString());
            hashMap.put("bus_travel_date", this.mSourceDate.getTag().toString());
            a.a();
            a.b().a("bus_home_search_bus_clicked", (Map<String, Object>) hashMap, (Context) getActivity());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_label", this.mSourceCity.getText().toString() + "/" + this.mDestinationCity.getText().toString());
            hashMap2.put("event_label2", this.pulseDate.replace("-", " "));
            hashMap2.put("userid", com.paytm.utility.b.n((Context) getActivity()));
            a.a();
            a.a("customEvent", "/bus-tickets", "bus_home", "search_bus_clicked", hashMap2);
            Intent intent = new Intent(getActivity(), AJRBusSearchSRPActivity.class);
            if (this.mSourceCity.getTag() != null) {
                intent.putExtra("intent_extra_bus_search_from", (CJRBusOriginCityItem) this.mSourceCity.getTag());
            }
            if (this.mDestinationCity.getTag() != null) {
                intent.putExtra("intent_extra_bus_search_to", (CJRBusOriginCityItem) this.mDestinationCity.getTag());
            }
            intent.putExtra("intent_extra_bus_search_date", getFormatedDate(this.mSourceDate.getTag().toString()));
            intent.putExtra("operatorId", this.mOperatorId);
            intent.putExtra("deals_filter", this.isDealsFilter);
            if (!TextUtils.isEmpty(this.popularChoiceFilter)) {
                intent.putExtra("popular_choice_filter_id", this.popularChoiceFilter);
            }
            getActivity().startActivityForResult(intent, 9876);
            if (z) {
                saveRecentsData((CJRBusOriginCityItem) this.mSourceCity.getTag(), (CJRBusOriginCityItem) this.mDestinationCity.getTag(), this.mSourceDate.getTag().toString());
            }
        }
    }

    private void saveRecentsData(CJRBusOriginCityItem cJRBusOriginCityItem, CJRBusOriginCityItem cJRBusOriginCityItem2, String str) {
        o.a(getActivity(), cJRBusOriginCityItem, cJRBusOriginCityItem2, str, o.a());
        this.mSourceCity.setText(cJRBusOriginCityItem.getCityName());
        this.mDestinationCity.setText(cJRBusOriginCityItem2.getCityName());
        if (cJRBusOriginCityItem != null && cJRBusOriginCityItem2 != null) {
            TextUtils.isEmpty(str);
        }
    }

    private void onExchangePressed() {
        String charSequence = this.mSourceCity.getText().toString();
        String charSequence2 = this.mDestinationCity.getText().toString();
        Object tag = this.mSourceCity.getTag();
        Object tag2 = this.mDestinationCity.getTag();
        if (!charSequence.isEmpty() && !charSequence.equalsIgnoreCase(getResources().getString(R.string.bus_origin_txt)) && !charSequence2.isEmpty() && !charSequence2.equalsIgnoreCase(getResources().getString(R.string.bus_destination_txt))) {
            this.mSourceCity.startAnimation(this.mAnimMoveDown);
            this.mDestinationCity.startAnimation(this.mAnimMoveUp);
            this.mSourceCity.setText(charSequence2);
            this.mDestinationCity.setText(charSequence);
            this.mSourceCity.setTag(tag2);
            this.mDestinationCity.setTag(tag);
            CJRBusOriginCityItem cJRBusOriginCityItem = this.cityItemSource;
            this.cityItemSource = this.cityItemDestination;
            this.cityItemDestination = cJRBusOriginCityItem;
            this.mSourceCity.startAnimation(this.mAnimMoveUp);
            this.mDestinationCity.startAnimation(this.mAnimMoveDown);
            this.mRotateAnimation.setFillAfter(true);
            savePrefillFromData(this.cityItemSource);
            savePrefillToData(this.cityItemDestination);
        }
    }

    private void sendBusTicketSearchErrorGTMEvent(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.getAlertMessage() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(networkCustomError.getStatusCode()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRBusRnRHome cJRBusRnRHome;
        if (!isDetached() && isAdded() && getActivity() != null && iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof CJRBusOriginCity) {
                CJRBusOriginCity cJRBusOriginCity = (CJRBusOriginCity) iJRPaytmDataModel;
                if (cJRBusOriginCity != null && cJRBusOriginCity.getmOriginCityItems() != null && cJRBusOriginCity.getmOriginCityItems().size() > 0) {
                    if (cJRBusOriginCity.isSource()) {
                        savePrefillFromData(cJRBusOriginCity.getmOriginCityItems().get(0));
                    } else {
                        savePrefillToData(cJRBusOriginCity.getmOriginCityItems().get(0));
                    }
                    if (!this.isFromCurrentLocation || this.isRecentSearchAvilable) {
                        new j(getActivity(), this, cJRBusOriginCity, "bus_city_url_type").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        setCurrentCity(validateFromCity(cJRBusOriginCity));
                        this.isFromCurrentLocation = false;
                    }
                    if (!(getArguments() == null || cJRBusOriginCity == null || cJRBusOriginCity.getmOriginCityItems() == null || cJRBusOriginCity.getmOriginCityItems().size() <= 0)) {
                        if (cJRBusOriginCity.isSource()) {
                            setSourceName(cJRBusOriginCity.getmOriginCityItems().get(0));
                        } else {
                            setDestinationName(cJRBusOriginCity.getmOriginCityItems().get(0));
                        }
                        if (isSourceDestFilled()) {
                            setJourneyDate(getArguments().getString("selected_date"));
                        }
                    }
                    CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
                    if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityName()) || TextUtils.isEmpty(cJRHomePageItem.getPushSourceCityShortName()) || !cJRBusOriginCity.isSource()) {
                        if (cJRHomePageItem != null && !TextUtils.isEmpty(cJRHomePageItem.getPushDestinationCityName()) && !TextUtils.isEmpty(cJRHomePageItem.getPushDestinationCityShortName()) && !cJRBusOriginCity.isSource() && cJRBusOriginCity != null && cJRBusOriginCity.getmOriginCityItems() != null && cJRBusOriginCity.getmOriginCityItems().size() > 0) {
                            setDestinationName(cJRBusOriginCity.getmOriginCityItems().get(0));
                        }
                    } else if (!(cJRBusOriginCity == null || cJRBusOriginCity.getmOriginCityItems() == null || cJRBusOriginCity.getmOriginCityItems().size() <= 0)) {
                        setSourceName(cJRBusOriginCity.getmOriginCityItems().get(0));
                    }
                    if (cJRHomePageItem != null && !TextUtils.isEmpty(cJRHomePageItem.getPushDate()) && isSourceDestFilled()) {
                        setJourneyDate(cJRHomePageItem.getPushDate());
                    }
                }
            } else if ((iJRPaytmDataModel instanceof CJRBusRnRHome) && (cJRBusRnRHome = (CJRBusRnRHome) iJRPaytmDataModel) != null && cJRBusRnRHome.getRatingInfo() != null && cJRBusRnRHome.getRatingInfo().getHalf_card_exists()) {
                openRNRCurvedPopup(iJRPaytmDataModel);
            }
        }
    }

    private void openRNRCurvedPopup(IJRPaytmDataModel iJRPaytmDataModel) {
        n a2 = n.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bus-rating", iJRPaytmDataModel);
        bundle.putBoolean("bus-from-rnr-home", true);
        a2.setArguments(bundle);
        a2.show(getActivity().getSupportFragmentManager(), "rnrBottomSheetFragment");
    }

    private boolean isSourceDestFilled() {
        String charSequence = this.mSourceCity.getText().toString();
        String charSequence2 = this.mDestinationCity.getText().toString();
        Resources resources = getResources();
        return !charSequence.equalsIgnoreCase(resources.getString(R.string.bus_origin_txt)) && !TextUtils.isEmpty(charSequence) && !charSequence2.equalsIgnoreCase(resources.getString(R.string.bus_destination_txt)) && !TextUtils.isEmpty(charSequence2);
    }

    private void setCurrentCity(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null && TextUtils.isEmpty(this.mSourceCity.getText())) {
            if (cJRBusOriginCityItem.getDisplayCityName() != null) {
                this.mSourceCity.setText(cJRBusOriginCityItem.getDisplayCityName());
            }
            this.mSourceCity.setTag(cJRBusOriginCityItem);
            this.cityItemSource = cJRBusOriginCityItem;
            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_000000));
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        sendBusTicketErrorGTMEvent(i2, networkCustomError);
        if (getActivity() != null && !(iJRPaytmDataModel instanceof CJRBusRnRHome)) {
            try {
                CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            cJRNewErrorFormat = (CJRNewErrorFormat) new f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (networkCustomError != null) {
                    sendBusTicketSearchErrorGTMEvent(networkCustomError);
                    if (!TextUtils.isEmpty(networkCustomError.getFullUrl())) {
                        String fullUrl = networkCustomError.getFullUrl();
                        a.a();
                        if (fullUrl.contains(a.b().f("busMyTrips"))) {
                            return;
                        }
                    }
                    if (cJRNewErrorFormat.getStatus() != null) {
                        String valueOf = String.valueOf(cJRNewErrorFormat.getCode());
                        if (valueOf != null && valueOf.equalsIgnoreCase("503")) {
                            showMaintenanceView();
                        } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            sendBusTicketDDEErrorGTMEvent(networkCustomError);
                            com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                        } else if (cJRNewErrorFormat.getStatus().getMessage().f22819b == null || cJRNewErrorFormat.getStatus().getMessage().f22820c == null) {
                            com.paytm.utility.b.b((Context) getActivity(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                        } else {
                            o.a(getActivity(), cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a(), (Intent) null, getLayoutInflater());
                        }
                    } else {
                        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    }
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.c(e3.getMessage());
                }
            }
        }
    }

    private void sendBusTicketDDEErrorGTMEvent(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.getAlertMessage() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_home");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", "client_error");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        }
    }

    private void sendBusTicketErrorGTMEvent(int i2, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.getAlertMessage() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_home");
            hashMap.put("event_action", "error_popup");
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(i2));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        }
    }

    public void onDestroyView() {
        io.reactivex.rxjava3.b.b bVar = this.compositeDisposable;
        if (bVar != null) {
            bVar.a();
            this.compositeDisposable.dispose();
        }
        if (this.onScrollListener != null) {
            this.mBusHomeContainer.getViewTreeObserver().removeOnScrollChangedListener(this.onScrollListener);
        }
        super.onDestroyView();
    }

    public void onFileWriteComplete(String str) {
        this.mBusHomeContainer.setVisibility(0);
    }

    private void showMaintenanceView() {
        ScrollView scrollView = this.mBusHomeContainer;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.mLytMaintenanceView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
        this.isFragmentPaused = false;
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        loadEndlessScrollFragment();
    }

    private void sendFromFieldSelectedGTMEvent(String str, String str2, int i2, String str3) {
        if (str != null) {
            try {
                HashMap hashMap = new HashMap();
                if (str3 != null && !str3.equalsIgnoreCase("")) {
                    str2 = "Cities/Town";
                }
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
                hashMap.put("bus_origin", str);
                hashMap.put("bus_city_category", str2);
                hashMap.put("bus_autosuggest_city_position", Integer.valueOf(i2));
                hashMap.put("bus_city_search_keyword", str3);
                a.a();
                a.b().a("bus_home_from_selected", (Map<String, Object>) hashMap, (Context) getActivity());
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private void sendToFieldSelectedGTMEvent(String str, String str2, int i2, String str3) {
        if (str != null) {
            try {
                HashMap hashMap = new HashMap();
                if (str3 != null && !str3.equalsIgnoreCase("")) {
                    str2 = "Cities/Town";
                }
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
                hashMap.put("bus_destination", str);
                hashMap.put("bus_city_category", str2);
                hashMap.put("bus_autosuggest_city_position", Integer.valueOf(i2));
                hashMap.put("bus_city_search_keyword", str3);
                a.a();
                a.b().a("bus_home_to_selected", (Map<String, Object>) hashMap, (Context) getActivity());
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private void sendDateTodayButtonClickGTMEvent() {
        try {
            sendCalanderFooterSelectedGTMEvent(true);
            sendDepartureDateTodaySelectedGTMEvent(true);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void sendDateTomorrowButtonClickGTMEvent() {
        try {
            sendCalanderFooterSelectedGTMEvent(false);
            sendDepartureDateTodaySelectedGTMEvent(false);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void sendDateSelectedGTMEvent(String str) {
        if (str != null) {
            try {
                if (this.mDateValue != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
                    hashMap.put("bus_travel_date", this.mDateValue.toString());
                    hashMap.put("bus_date_source", "Calender");
                    a.a();
                    a.b().a("bus_home_date_selected", (Map<String, Object>) hashMap, (Context) getActivity());
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private void sendCalanderFooterSelectedGTMEvent(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
        hashMap.put("bus_user_id", com.paytm.utility.b.n((Context) getActivity()));
        String str = "NA";
        hashMap.put("bus_origin", this.mSourceCity.getText().toString().equalsIgnoreCase("from") ? str : this.mSourceCity.getText().toString());
        if (!this.mDestinationCity.getText().toString().equalsIgnoreCase("to")) {
            str = this.mDestinationCity.getText().toString();
        }
        hashMap.put("bus_destination", str);
        hashMap.put("click_trip_day_button", "Today");
        String str2 = z ? "bus_home_today_clicked" : "bus_home_tomorrow_clicked";
        a.a();
        a.b().a(str2, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private void prefillBusDetailsRetryData(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("Source", "");
            String string2 = bundle.getString("Destination", "");
            if (!TextUtils.isEmpty(string)) {
                getCitiesApiCall(string, true);
            }
            if (!TextUtils.isEmpty(string2)) {
                getCitiesApiCall(string2, false);
            }
        }
    }

    private void setSourceName(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            this.mSourceCity.setTag(cJRBusOriginCityItem);
            this.mSourceCity.setText(cJRBusOriginCityItem.getDisplayCityName());
        }
        this.mSourceCity.setTextColor(getResources().getColor(R.color.color_000000));
    }

    private void setDestinationName(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            this.mDestinationCity.setTag(cJRBusOriginCityItem);
            this.mDestinationCity.setText(cJRBusOriginCityItem.getDisplayCityName());
        }
        this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_000000));
    }

    private void setJourneyDate(String str) {
        try {
            this.appLocale = new Locale(n.a());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", this.appLocale);
            Calendar instance = Calendar.getInstance();
            String format = simpleDateFormat.format(instance.getTime());
            instance.add(5, 1);
            String format2 = simpleDateFormat.format(instance.getTime());
            Date parse = simpleDateFormat.parse(str);
            int compareTo = parse.compareTo(simpleDateFormat.parse(format));
            if (compareTo >= 0) {
                if (compareTo == 0) {
                    setTodaysDate(false);
                    setTodayButton();
                } else if (parse.compareTo(simpleDateFormat.parse(format2)) == 0) {
                    setTomorrowsDate(false);
                    setTomorrowButton();
                } else {
                    setDateButtons();
                    this.mSourceDate.setTag(com.paytm.utility.b.a(Long.valueOf(parse.getTime())));
                    TextView textView = this.mSourceDate;
                    FragmentActivity activity = getActivity();
                    a.a();
                    textView.setText(com.paytm.utility.b.a((Activity) activity, str, "yyyy-MM-dd", "EEE, dd MMM", a.b().b()));
                    FragmentActivity activity2 = getActivity();
                    a.a();
                    this.pulseDate = com.paytm.utility.b.a((Activity) activity2, str, "yyyy-MM-dd", "dd-MMM-yy", a.b().b());
                }
                onProceedClick(true);
                return;
            }
            onClick(this.mSourceDate);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    private void sendDepartureDateTodaySelectedGTMEvent(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("today_tomorrow", "Today");
            hashMap.put("bus_user_id", com.paytm.utility.b.n((Context) getActivity()));
        } else {
            hashMap.put("today_tomorrow", "Tomorrow");
            hashMap.put("bus_user_id", com.paytm.utility.b.n((Context) getActivity()));
        }
        a.a();
        a.b().a("bus_home_today_tomorrow_clicked", (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private void savePrefillFromData(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            String a2 = new f().a((Object) cJRBusOriginCityItem);
            a.a();
            com.travel.bus.b.a.a(a.b().D()).a("prefill-from-data", a2, false);
        }
    }

    private void savePrefillToData(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            String a2 = new f().a((Object) cJRBusOriginCityItem);
            a.a();
            com.travel.bus.b.a.a(a.b().D()).a("prefill-to-data", a2, false);
        }
    }

    private void savePrefilDateValue(CharSequence charSequence, String str) {
        if (charSequence != null) {
            a.a();
            com.travel.bus.b.a.a(a.b().D()).a("prefill-date-value", String.valueOf(charSequence), false);
            a.a();
            com.travel.bus.b.a.a(a.b().D()).a("prefill-date-value-tag", str, false);
        }
    }

    private void getPrefillFromCity() {
        a.a();
        String b2 = com.travel.bus.b.a.a(a.b().D()).b("prefill-from-data", "", false);
        CJRBusOriginCityItem cJRBusOriginCityItem = !TextUtils.isEmpty(b2) ? (CJRBusOriginCityItem) new f().a(b2, new com.google.gson.b.a<CJRBusOriginCityItem>() {
        }.getType()) : null;
        if (o.a(cJRBusOriginCityItem)) {
            this.isRecentSearchAvilable = true;
            this.mSourceCity.setText(cJRBusOriginCityItem.getDisplayCityName());
            this.mSourceCity.setTag(cJRBusOriginCityItem);
            this.mSourceCity.setTextColor(getResources().getColor(R.color.color_000000));
            this.cityItemSource = cJRBusOriginCityItem;
            return;
        }
        fetchlastLocation();
    }

    private void getPrefilDateValue() {
        a.a();
        String b2 = com.travel.bus.b.a.a(a.b().D()).b("prefill-date-value", "", false);
        a.a();
        String b3 = com.travel.bus.b.a.a(a.b().D()).b("prefill-date-value-tag", "", false);
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(b3) && !b2.equals("")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
            try {
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                Date parse2 = simpleDateFormat.parse(b2);
                if (parse != null) {
                    if (parse.before(parse2)) {
                        this.mSourceDate.setText(b2);
                        this.pulseDate = new SimpleDateFormat("dd-MMM-yy").format(parse2);
                        setDateToLayout(new SimpleDateFormat("EEEE-d-MMMM").format(parse2));
                        resetDateButtonColors();
                        if (!b3.equals("")) {
                            this.mSourceDate.setTag(b3);
                        }
                    } else {
                        setTodaysDate(false);
                        setTodayButton();
                    }
                    try {
                        Calendar instance = Calendar.getInstance();
                        instance.setTime(new Date());
                        instance.add(6, 1);
                        if (b3.equals(com.paytm.utility.b.a(Long.valueOf(instance.getTime().getTime())))) {
                            setTomorrowButton();
                        }
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                }
            } catch (ParseException e3) {
                q.c(e3.getMessage());
            }
        }
    }

    private void resetDateButtonColors() {
        this.mTodayText.setTextColor(getResources().getColor(R.color.gray));
        this.mTomorrowText.setTextColor(getResources().getColor(R.color.gray));
    }

    private void getPrefillToCity() {
        a.a();
        String b2 = com.travel.bus.b.a.a(a.b().D()).b("prefill-to-data", "", false);
        CJRBusOriginCityItem cJRBusOriginCityItem = !TextUtils.isEmpty(b2) ? (CJRBusOriginCityItem) new f().a(b2, new com.google.gson.b.a<CJRBusOriginCityItem>() {
        }.getType()) : null;
        if (o.a(cJRBusOriginCityItem)) {
            this.isRecentSearchAvilable = true;
            this.mDestinationCity.setText(cJRBusOriginCityItem.getDisplayCityName());
            this.mDestinationCity.setTag(cJRBusOriginCityItem);
            this.mDestinationCity.setTextColor(getResources().getColor(R.color.color_000000));
            this.cityItemDestination = cJRBusOriginCityItem;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchlastLocation() {
        /*
            r7 = this;
            r0 = 1
            r7.isFromCurrentLocation = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "busticketfragment :: fetchLastLocation getActivity "
            r1.<init>(r2)
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            r1.append(r2)
            java.lang.String r2 = " getcontext "
            r1.append(r2)
            android.content.Context r2 = r7.getContext()
            r1.append(r2)
            java.lang.String r2 = " context is "
            r1.append(r2)
            android.content.Context r2 = r7.mContext
            r1.append(r2)
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            if (r1 != 0) goto L_0x002e
            return
        L_0x002e:
            android.content.Context r1 = r7.mContext
            android.content.Context r1 = r1.getApplicationContext()
            com.paytm.b.a.a r1 = com.travel.bus.b.a.a(r1)
            if (r1 == 0) goto L_0x0078
            java.lang.String r2 = "pref_key_latitude"
            boolean r3 = r1.b(r2, r0)
            if (r3 == 0) goto L_0x0078
            java.lang.String r3 = "pref_key_longitude"
            boolean r4 = r1.b(r3, r0)
            if (r4 == 0) goto L_0x0078
            java.lang.String r4 = ""
            java.lang.String r2 = r1.b((java.lang.String) r2, (java.lang.String) r4, (boolean) r0)
            java.lang.String r0 = r1.b((java.lang.String) r3, (java.lang.String) r4, (boolean) r0)
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x0078
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0078
            r3 = 0
            double r1 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x006b }
            double r5 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x006c }
            goto L_0x006d
        L_0x006b:
            r1 = r3
        L_0x006c:
            r5 = r3
        L_0x006d:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0078
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0078
            r7.setAddress(r1, r5)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.fragment.FJRBusTicketFragment.fetchlastLocation():void");
    }

    private void setAddress(double d2, double d3) {
        try {
            List<Address> fromLocation = new Geocoder(getContext(), Locale.getDefault()).getFromLocation(d2, d3, 1);
            if (fromLocation != null && fromLocation.size() > 0) {
                this.mCurrentLocationCity = fromLocation.get(0).getLocality();
                getCitiesApiCall(fromLocation.get(0).getLocality(), true);
            }
        } catch (IOException e2) {
            q.c(e2.getMessage());
        }
    }

    private CJRBusOriginCityItem validateFromCity(CJRBusOriginCity cJRBusOriginCity) {
        if (cJRBusOriginCity == null || cJRBusOriginCity.getmOriginCityItems() == null || cJRBusOriginCity.getmOriginCityItems().size() <= 0) {
            return null;
        }
        Iterator<CJRBusOriginCityItem> it2 = cJRBusOriginCity.getmOriginCityItems().iterator();
        while (it2.hasNext()) {
            CJRBusOriginCityItem next = it2.next();
            if (next != null && next.getHeadingCityName().equalsIgnoreCase(this.mCurrentLocationCity)) {
                return next;
            }
        }
        return null;
    }

    private void getCitiesApiCall(String str, boolean z) {
        a.a();
        String f2 = a.b().f("busSearchCityUrl");
        performNetworkCall((f2 == null || f2.isEmpty()) ? "" : Uri.parse(f2).buildUpon().appendPath(str).build().toString(), z);
    }

    private void performNetworkCall(String str, boolean z) {
        if (str != null) {
            new ArrayList().add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
            CJRBusOriginCity cJRBusOriginCity = new CJRBusOriginCity();
            cJRBusOriginCity.setSource(z);
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getContext()));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str;
            bVar.f42884h = null;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42885i = cJRBusOriginCity;
            bVar.j = this;
            bVar.t = createDisplayErrorJsonObject();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-home-page";
            bVar.l().a();
        }
    }

    private JSONObject createDisplayErrorJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusHomePage");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public void onVisibleToUser(boolean z) {
        new StringBuilder(" onVisibleToUser :: ").append(getClass().getSimpleName());
        new Handler().post(new Runnable() {
            public final void run() {
                FJRBusTicketFragment.this.lambda$onVisibleToUser$5$FJRBusTicketFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onVisibleToUser$5$FJRBusTicketFragment() {
        if (!isAdded() || isDetached()) {
            this.isStoreFrontFragmentAddPending = true;
        } else {
            addStoreFrontFragment();
        }
    }

    public void onVisibilityGone() {
        this.isStoreFrontFragmentAddPending = false;
        new Handler().post(new Runnable() {
            public final void run() {
                FJRBusTicketFragment.this.lambda$onVisibilityGone$6$FJRBusTicketFragment();
            }
        });
    }

    public /* synthetic */ void lambda$onVisibilityGone$6$FJRBusTicketFragment() {
        if (isAdded() && !isDetached()) {
            removeStoreFrontFragment();
        }
    }

    private void removeStoreFrontFragment() {
        if (this.mEndLessFragment != null) {
            getChildFragmentManager().a().a(this.mEndLessFragment).c();
        }
    }

    private void addStoreFrontFragment() {
        if (!this.isFragmentPaused) {
            Bundle bundle = new Bundle();
            com.travel.bus.a.a();
            this.mEndLessFragment = com.travel.bus.a.b().a((WeakReference<View>) new WeakReference(this.mBusHomeContainer));
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putString("origin", "bus");
            bundle.putString("store_front_url_key", "busStoreFrontUrl");
            bundle.putBoolean("trigger-impression-on-visibility", true);
            this.mEndLessFragment.setArguments(bundle);
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            a2.a(R.id.framelayout_storefront, this.mEndLessFragment, "TAG_BUS_STOREFRONT");
            a2.b();
        }
    }

    private void getBusHomeRnRApiCall() {
        if (!this.rnrApiCallDone) {
            com.travel.bus.a.a();
            String f2 = com.travel.bus.a.b().f("busRNRHomeApi");
            this.mUserId = com.paytm.utility.b.n((Context) getActivity());
            if (!TextUtils.isEmpty(f2) && !TextUtils.isEmpty(this.mUserId)) {
                Uri.Builder buildUpon = Uri.parse(f2).buildUpon();
                buildUpon.appendQueryParameter("user_id", this.mUserId);
                buildUpon.appendQueryParameter("is_home", "true");
                String uri = buildUpon.build().toString();
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getActivity();
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = uri;
                bVar.f42881e = null;
                bVar.f42882f = null;
                bVar.f42883g = null;
                bVar.f42885i = new CJRBusRnRHome();
                bVar.j = this;
                bVar.n = a.b.SILENT;
                bVar.o = "bus-home-page";
                bVar.l().a();
                this.rnrApiCallDone = true;
            }
        }
    }
}
