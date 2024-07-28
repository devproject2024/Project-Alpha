package com.business.merchant_payments.payment.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.business.common_module.a.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.view.ReportDownloadBottomSheet;
import com.business.merchant_payments.databinding.MpActivityPaymentListBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import com.business.merchant_payments.newhome.SelectDateBottomSheet;
import com.business.merchant_payments.payment.model.PaymentsEmptyModel;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper;
import com.business.merchant_payments.payment.model.datahelpers.SummaryListDataHelper;
import com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.payment.view.PaymentsListRvAdapter;
import com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel;
import com.business.merchant_payments.reports.ReportsApiCallViewModel;
import com.business.merchant_payments.utility.MPConstants;
import com.business.merchant_payments.utility.UIUtilityMPKt;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;

public class PaymentListActivity extends BaseActivity implements ReportDownloadBottomSheet.IReportDownloadListener {
    public HashMap _$_findViewCache;
    public PaymentsListRvAdapter mAdapter;
    public MpActivityPaymentListBinding mBinding;
    public PaymentsDataHelper mCurrentHelper;
    public b mDownloadStatementCalendarUtil;
    public String mEndDate = "";
    public boolean mFetchingPayments;
    public boolean mFetchingSummaries;
    public b mPaymentCalendarUtil;
    public final PaymentListActivity$mPaymentsListOnScrollListener$1 mPaymentsListOnScrollListener = new PaymentListActivity$mPaymentsListOnScrollListener$1(this);
    public String mRange = "";
    public ReportsApiCallViewModel mReportsApiCallViewModel;
    public String mSavedEndDate = "";
    public String mSavedStartDate = "";
    public Snackbar mSnackBar;
    public String mStartDate = "";
    public ArrayList<Object> mSummaryList;
    public SummaryListDataHelper mSummaryListDataHelper;
    public PaymentsListViewModel mViewModel;
    public String reportEndDate = "";
    public String reportStartDate = "";

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[e.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[e.LOADING.ordinal()] = 1;
            $EnumSwitchMapping$0[e.SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[e.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$0[e.FAILURE.ordinal()] = 4;
            int[] iArr2 = new int[e.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[e.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$1[e.ERROR.ordinal()] = 2;
            int[] iArr3 = new int[e.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[e.LOADING.ordinal()] = 1;
            $EnumSwitchMapping$2[e.SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$2[e.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$2[e.FAILURE.ordinal()] = 4;
            int[] iArr4 = new int[e.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[e.LOADING.ordinal()] = 1;
            $EnumSwitchMapping$3[e.SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$3[e.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$3[e.FAILURE.ordinal()] = 4;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void addIntentData(Intent intent) {
        k.d(intent, "intent");
    }

    public void launchDateRangeClickGA() {
    }

    public static final /* synthetic */ PaymentsListRvAdapter access$getMAdapter$p(PaymentListActivity paymentListActivity) {
        PaymentsListRvAdapter paymentsListRvAdapter = paymentListActivity.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        return paymentsListRvAdapter;
    }

    public static final /* synthetic */ ArrayList access$getMSummaryList$p(PaymentListActivity paymentListActivity) {
        ArrayList<Object> arrayList = paymentListActivity.mSummaryList;
        if (arrayList == null) {
            k.a("mSummaryList");
        }
        return arrayList;
    }

    public static final /* synthetic */ PaymentsListViewModel access$getMViewModel$p(PaymentListActivity paymentListActivity) {
        PaymentsListViewModel paymentsListViewModel = paymentListActivity.mViewModel;
        if (paymentsListViewModel == null) {
            k.a("mViewModel");
        }
        return paymentsListViewModel;
    }

    public final ReportsApiCallViewModel getMReportsApiCallViewModel() {
        ReportsApiCallViewModel reportsApiCallViewModel = this.mReportsApiCallViewModel;
        if (reportsApiCallViewModel == null) {
            k.a("mReportsApiCallViewModel");
        }
        return reportsApiCallViewModel;
    }

    public final void setMReportsApiCallViewModel(ReportsApiCallViewModel reportsApiCallViewModel) {
        k.d(reportsApiCallViewModel, "<set-?>");
        this.mReportsApiCallViewModel = reportsApiCallViewModel;
    }

    public final Snackbar getMSnackBar() {
        return this.mSnackBar;
    }

    public final PaymentsDataHelper getMCurrentHelper() {
        PaymentsDataHelper paymentsDataHelper = this.mCurrentHelper;
        if (paymentsDataHelper == null) {
            k.a("mCurrentHelper");
        }
        return paymentsDataHelper;
    }

    public final void setMCurrentHelper(PaymentsDataHelper paymentsDataHelper) {
        k.d(paymentsDataHelper, "<set-?>");
        this.mCurrentHelper = paymentsDataHelper;
    }

    public final String getMEndDate() {
        return this.mEndDate;
    }

    public final void setMEndDate(String str) {
        k.d(str, "<set-?>");
        this.mEndDate = str;
    }

    public final String getMStartDate() {
        return this.mStartDate;
    }

    public final void setMStartDate(String str) {
        k.d(str, "<set-?>");
        this.mStartDate = str;
    }

    public final SummaryListDataHelper getMSummaryListDataHelper() {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        return summaryListDataHelper;
    }

    public final MpActivityPaymentListBinding getMBinding() {
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        return mpActivityPaymentListBinding;
    }

    public final void setMBinding(MpActivityPaymentListBinding mpActivityPaymentListBinding) {
        k.d(mpActivityPaymentListBinding, "<set-?>");
        this.mBinding = mpActivityPaymentListBinding;
    }

    public final void setReportStartDate(String str) {
        k.d(str, "<set-?>");
        this.reportStartDate = str;
    }

    public final void setReportEndDate(String str) {
        k.d(str, "<set-?>");
        this.reportEndDate = str;
    }

    public void onCreate(Bundle bundle) {
        Trace a2 = a.a("PaymentListActivity-onCreate");
        super.onCreate(bundle);
        ViewDataBinding a3 = f.a(this, R.layout.mp_activity_payment_list);
        k.b(a3, "DataBindingUtil.setConte…mp_activity_payment_list)");
        this.mBinding = (MpActivityPaymentListBinding) a3;
        c provideViewModel = provideViewModel(PaymentsListViewModel.class, (Fragment) null);
        k.b(provideViewModel, "provideViewModel(Payment…wModel::class.java, null)");
        this.mViewModel = (PaymentsListViewModel) provideViewModel;
        initReportViewModel();
        setCalendarUtils();
        handleIntent();
        bindModel();
        initUI();
        initScrollListener();
        initData();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/Payment Date Range Page");
        a2.stop();
    }

    public void initReportViewModel() {
        this.mReportsApiCallViewModel = new ReportsApiCallViewModel();
    }

    public void handleIntent() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_deeplink_data");
            String stringExtra2 = getIntent().getStringExtra(AppConstants.KEY_OPEN_SCREEN);
            boolean z = false;
            if (!(stringExtra == null || stringExtra.length() == 0)) {
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    z = true;
                }
                if (!z) {
                    try {
                        if (p.a(AppConstants.KEY_SCREEN_PAYMENTS, stringExtra2, true)) {
                            Uri parse = Uri.parse(stringExtra);
                            String queryParameter = parse.getQueryParameter("select");
                            if (p.a(queryParameter, AppConstants.CUSTOM_DATE, true)) {
                                String queryParameter2 = parse.getQueryParameter("start");
                                if (queryParameter2 == null) {
                                    queryParameter2 = "";
                                }
                                String startDateOfDifferentFormat = DateUtility.getStartDateOfDifferentFormat(queryParameter2, "dd/MM/yyyy", "dd MMMM yy");
                                k.b(startDateOfDifferentFormat, "DateUtility.getStartDate…                        )");
                                this.mStartDate = startDateOfDifferentFormat;
                                String queryParameter3 = parse.getQueryParameter("end");
                                if (queryParameter3 == null) {
                                    queryParameter3 = "";
                                }
                                String startDateOfDifferentFormat2 = DateUtility.getStartDateOfDifferentFormat(queryParameter3, "dd/MM/yyyy", "dd MMMM yy");
                                k.b(startDateOfDifferentFormat2, "DateUtility.getStartDate…                        )");
                                this.mEndDate = startDateOfDifferentFormat2;
                            } else if (p.a(queryParameter, AppConstants.YESTERDAY, true)) {
                                String yesterdayStartDate = DateUtility.getYesterdayStartDate("dd MMMM yy");
                                k.b(yesterdayStartDate, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                                this.mStartDate = yesterdayStartDate;
                                String yesterdayStartDate2 = DateUtility.getYesterdayStartDate("dd MMMM yy");
                                k.b(yesterdayStartDate2, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                                this.mEndDate = yesterdayStartDate2;
                            } else {
                                String todayStartDate = DateUtility.getTodayStartDate("dd MMMM yy");
                                k.b(todayStartDate, "DateUtility.getTodayStar…tility.DD_MMMM_YY_FORMAT)");
                                this.mStartDate = todayStartDate;
                                String currentFormattedDate = DateUtility.getCurrentFormattedDate("dd MMMM yy");
                                k.b(currentFormattedDate, "DateUtility.getCurrentFo…tility.DD_MMMM_YY_FORMAT)");
                                this.mEndDate = currentFormattedDate;
                            }
                        } else if (p.a(AppConstants.KEY_SCREEN_PAYMENTS_FOR_TWO_WEEKS, stringExtra2, true)) {
                            Calendar instance = Calendar.getInstance();
                            k.b(instance, "Calendar.getInstance()");
                            String formattedDate = DateUtility.getFormattedDate(instance.getTimeInMillis(), "dd MMMM yy");
                            k.b(formattedDate, "DateUtility.getFormatted…tility.DD_MMMM_YY_FORMAT)");
                            this.mStartDate = formattedDate;
                            instance.set(5, instance.get(5) - 14);
                            String formattedDate2 = DateUtility.getFormattedDate(instance.getTimeInMillis(), "dd MMMM yy");
                            k.b(formattedDate2, "DateUtility.getFormatted…tility.DD_MMMM_YY_FORMAT)");
                            this.mEndDate = formattedDate2;
                        }
                    } catch (Exception unused) {
                        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
                        if (mpActivityPaymentListBinding == null) {
                            k.a("mBinding");
                        }
                        Snackbar a2 = Snackbar.a((View) mpActivityPaymentListBinding.coordinatorLayout, (CharSequence) getString(R.string.mp_unable_to_perform_action), -2);
                        this.mSnackBar = a2;
                        a2.c();
                    }
                    this.mSavedStartDate = this.mStartDate;
                    this.mSavedEndDate = this.mEndDate;
                }
            }
            String stringExtra3 = getIntent().getStringExtra("startDate");
            k.b(stringExtra3, "intent.getStringExtra(Ap….INTENT_EXTRA_START_DATE)");
            this.mStartDate = stringExtra3;
            String stringExtra4 = getIntent().getStringExtra("endDate");
            k.b(stringExtra4, "intent.getStringExtra(Ap…ts.INTENT_EXTRA_END_DATE)");
            this.mEndDate = stringExtra4;
            this.mSavedStartDate = this.mStartDate;
            this.mSavedEndDate = this.mEndDate;
        }
    }

    public void bindModel() {
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        PaymentsListViewModel paymentsListViewModel = this.mViewModel;
        if (paymentsListViewModel == null) {
            k.a("mViewModel");
        }
        mpActivityPaymentListBinding.setModel(paymentsListViewModel);
    }

    public void initUI() {
        PaymentsListViewModel paymentsListViewModel = this.mViewModel;
        if (paymentsListViewModel == null) {
            k.a("mViewModel");
        }
        this.mSummaryListDataHelper = paymentsListViewModel.getMSummaryListDataHelper();
        setTitle();
        initBackButtonUI();
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        mpActivityPaymentListBinding.errorRetryBtn.setOnClickListener(new PaymentListActivity$initUI$1(this));
        setOnTitleClickListener();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().h()) {
            MpActivityPaymentListBinding mpActivityPaymentListBinding2 = this.mBinding;
            if (mpActivityPaymentListBinding2 == null) {
                k.a("mBinding");
            }
            mpActivityPaymentListBinding2.downloadStatementLabel.setOnClickListener(new PaymentListActivity$initUI$2(this));
        } else {
            MpActivityPaymentListBinding mpActivityPaymentListBinding3 = this.mBinding;
            if (mpActivityPaymentListBinding3 == null) {
                k.a("mBinding");
            }
            TextView textView = mpActivityPaymentListBinding3.downloadStatementLabel;
            k.b(textView, "mBinding.downloadStatementLabel");
            textView.setVisibility(8);
        }
        PaymentsListViewModel paymentsListViewModel2 = this.mViewModel;
        if (paymentsListViewModel2 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel2.getMDaywiseSummaryListAPIData().observe(this, new PaymentListActivity$initUI$3(this));
        PaymentsListViewModel paymentsListViewModel3 = this.mViewModel;
        if (paymentsListViewModel3 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel3.getMNonMigratedPaymentsAPIData().observe(this, new PaymentListActivity$initUI$4(this));
        PaymentsListViewModel paymentsListViewModel4 = this.mViewModel;
        if (paymentsListViewModel4 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel4.getMorePaymentsForDateAPIData().observe(this, new PaymentListActivity$initUI$5(this));
        PaymentsListViewModel paymentsListViewModel5 = this.mViewModel;
        if (paymentsListViewModel5 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel5.getMDateRangeSummeryAPIData().observe(this, new PaymentListActivity$initUI$6(this));
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        ArrayList<Object> summaryList = summaryListDataHelper.getSummaryList();
        this.mSummaryList = summaryList;
        if (summaryList == null) {
            k.a("mSummaryList");
        }
        this.mAdapter = new PaymentsListRvAdapter(this, summaryList, new PaymentsListRVListener());
        MpActivityPaymentListBinding mpActivityPaymentListBinding4 = this.mBinding;
        if (mpActivityPaymentListBinding4 == null) {
            k.a("mBinding");
        }
        RecyclerView recyclerView = mpActivityPaymentListBinding4.paymentsRv;
        k.b(recyclerView, "mBinding.paymentsRv");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MpActivityPaymentListBinding mpActivityPaymentListBinding5 = this.mBinding;
        if (mpActivityPaymentListBinding5 == null) {
            k.a("mBinding");
        }
        RecyclerView recyclerView2 = mpActivityPaymentListBinding5.paymentsRv;
        k.b(recyclerView2, "mBinding.paymentsRv");
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        recyclerView2.setAdapter(paymentsListRvAdapter);
        MpActivityPaymentListBinding mpActivityPaymentListBinding6 = this.mBinding;
        if (mpActivityPaymentListBinding6 == null) {
            k.a("mBinding");
        }
        RecyclerView recyclerView3 = mpActivityPaymentListBinding6.paymentsRv;
        k.b(recyclerView3, "mBinding.paymentsRv");
        recyclerView3.setItemAnimator(new g());
    }

    public void setOnTitleClickListener() {
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        mpActivityPaymentListBinding.title.setOnClickListener(new PaymentListActivity$setOnTitleClickListener$1(this));
    }

    public final void setTitleActions() {
        openSelectDateBottomSheet$default(this, false, (String) null, (String) null, (String) null, 15, (Object) null);
        launchDateRangeClickGA();
    }

    public void initBackButtonUI() {
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        mpActivityPaymentListBinding.back.setOnClickListener(new PaymentListActivity$initBackButtonUI$1(this));
    }

    public void initScrollListener() {
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        mpActivityPaymentListBinding.paymentsRv.addOnScrollListener(this.mPaymentsListOnScrollListener);
    }

    public void initData() {
        PaymentsListViewModel paymentsListViewModel = this.mViewModel;
        if (paymentsListViewModel == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel.setDateRange(this.mStartDate, this.mEndDate);
        PaymentsListViewModel paymentsListViewModel2 = this.mViewModel;
        if (paymentsListViewModel2 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel2.setLoadingState(true);
        PaymentsListViewModel paymentsListViewModel3 = this.mViewModel;
        if (paymentsListViewModel3 == null) {
            k.a("mViewModel");
        }
        paymentsListViewModel3.fetchOrderSummery();
        PaymentsListViewModel paymentsListViewModel4 = this.mViewModel;
        if (paymentsListViewModel4 == null) {
            k.a("mViewModel");
        }
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        paymentsListViewModel4.fetchPayments(summaryListDataHelper.getPageForAPI());
    }

    private final void setCalendarUtils() {
        this.mPaymentCalendarUtil = new b(this, new PaymentListActivity$setCalendarUtils$1(this));
        this.mDownloadStatementCalendarUtil = new b(this, new PaymentListActivity$setCalendarUtils$2(this));
    }

    /* access modifiers changed from: private */
    public final void resetCurrentRange(String str, String str2) {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        summaryListDataHelper.resetSummaries();
        ArrayList<Object> arrayList = this.mSummaryList;
        if (arrayList == null) {
            k.a("mSummaryList");
        }
        arrayList.clear();
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        paymentsListRvAdapter.updateRVAdapterList(arrayList2);
        this.mStartDate = str;
        this.mEndDate = str2;
        this.mSavedStartDate = str;
        this.mSavedEndDate = str2;
        setTitle();
        initData();
    }

    public void setTitle() {
        String str = this.mStartDate;
        Locale locale = Locale.getDefault();
        k.b(locale, "Locale.getDefault()");
        String formattedDate = getFormattedDate(str, "dd MMMM yy", "dd MMM", locale);
        String str2 = this.mEndDate;
        Locale locale2 = Locale.getDefault();
        k.b(locale2, "Locale.getDefault()");
        String formattedDate2 = getFormattedDate(str2, "dd MMMM yy", "dd MMM", locale2);
        if (!k.a((Object) formattedDate, (Object) formattedDate2)) {
            formattedDate = getString(R.string.mp_custom_range, new Object[]{formattedDate, formattedDate2});
            k.b(formattedDate, "getString(R.string.mp_custom_range, start, end)");
        }
        MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
        if (mpActivityPaymentListBinding == null) {
            k.a("mBinding");
        }
        TextView textView = mpActivityPaymentListBinding.title;
        k.b(textView, "mBinding.title");
        textView.setText(formattedDate);
    }

    public final String getFormattedDate(String str, String str2, String str3, Locale locale) {
        k.d(locale, ContactsConstant.LOCALE);
        try {
            String format = new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, Locale.US).parse(str));
            k.b(format, "outputDateFormat.format(date)");
            return format;
        } catch (ParseException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final void handleV2OrderListResponse(com.business.common_module.utilities.a.b<V2OrderListModel> bVar) {
        PaymentsDataHelper paymentsDataHelper;
        if (bVar.f7357b != e.LOADING) {
            this.mFetchingPayments = false;
        }
        e eVar = bVar.f7357b;
        if (eVar != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[eVar.ordinal()];
            if (i2 == 2) {
                if (!(((V2OrderListModel) bVar.f7358c).getOrderList() == null || (paymentsDataHelper = this.mCurrentHelper) == null)) {
                    if (paymentsDataHelper == null) {
                        k.a("mCurrentHelper");
                    }
                    paymentsDataHelper.incrementPageNumber();
                    PaymentsDataHelper paymentsDataHelper2 = this.mCurrentHelper;
                    if (paymentsDataHelper2 == null) {
                        k.a("mCurrentHelper");
                    }
                    List<OrderDetail> orderList = ((V2OrderListModel) bVar.f7358c).getOrderList();
                    if (orderList != null) {
                        addMorePayments(paymentsDataHelper2.addMoreTransactions((ArrayList) orderList));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.business.merchant_payments.payment.model.orderDetail.OrderDetail>");
                    }
                }
                PaymentsDataHelper paymentsDataHelper3 = this.mCurrentHelper;
                if (paymentsDataHelper3 != null) {
                    if (paymentsDataHelper3 == null) {
                        k.a("mCurrentHelper");
                    }
                    paymentsDataHelper3.checkForFinalState();
                }
            } else if (i2 != 3) {
                if (i2 == 4 && !isFinishing()) {
                    if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                        finish();
                    }
                    MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
                    if (mpActivityPaymentListBinding == null) {
                        k.a("mBinding");
                    }
                    Snackbar a2 = Snackbar.a((View) mpActivityPaymentListBinding.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7360e), 0);
                    this.mSnackBar = a2;
                    a2.c();
                    PaymentsDataHelper paymentsDataHelper4 = this.mCurrentHelper;
                    if (paymentsDataHelper4 != null) {
                        if (paymentsDataHelper4 == null) {
                            k.a("mCurrentHelper");
                        }
                        paymentsDataHelper4.getShowMoreModel().getShowMoreButtonProgressState().set(false);
                    }
                }
            } else if (!isFinishing()) {
                if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                    finish();
                }
                MpActivityPaymentListBinding mpActivityPaymentListBinding2 = this.mBinding;
                if (mpActivityPaymentListBinding2 == null) {
                    k.a("mBinding");
                }
                Snackbar a3 = Snackbar.a((View) mpActivityPaymentListBinding2.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7356a), 0);
                this.mSnackBar = a3;
                a3.c();
                PaymentsDataHelper paymentsDataHelper5 = this.mCurrentHelper;
                if (paymentsDataHelper5 != null) {
                    if (paymentsDataHelper5 == null) {
                        k.a("mCurrentHelper");
                    }
                    paymentsDataHelper5.getShowMoreModel().getShowMoreButtonProgressState().set(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleSummeryData(com.business.common_module.utilities.a.b<SummaryDateRangeViewData> bVar) {
        e eVar = bVar.f7357b;
        if (eVar != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[eVar.ordinal()];
            if (i2 == 1) {
                processSummeryInfoData((SummaryDateRangeViewData) bVar.f7358c);
            } else if (i2 == 2) {
                processSummeryInfoData(new SummaryDateRangeViewData((String) null, (String) null));
            }
        }
    }

    private final void processSummeryInfoData(SummaryDateRangeViewData summaryDateRangeViewData) {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        summaryListDataHelper.setDataFromSummeryApi(summaryDateRangeViewData);
        SummaryListDataHelper summaryListDataHelper2 = this.mSummaryListDataHelper;
        if (summaryListDataHelper2 == null) {
            k.a("mSummaryListDataHelper");
        }
        ArrayList<Object> summaryList = summaryListDataHelper2.getSummaryList();
        this.mSummaryList = summaryList;
        if (summaryList == null) {
            k.a("mSummaryList");
        }
        if (summaryList.isEmpty()) {
            ArrayList<Object> arrayList = this.mSummaryList;
            if (arrayList == null) {
                k.a("mSummaryList");
            }
            arrayList.add(new PaymentsEmptyModel());
        }
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        paymentsListRvAdapter.updateRVAdapterList(arrayList2);
    }

    /* access modifiers changed from: private */
    public final void addMorePayments(ArrayList<Object> arrayList) {
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        PaymentsDataHelper paymentsDataHelper = this.mCurrentHelper;
        if (paymentsDataHelper == null) {
            k.a("mCurrentHelper");
        }
        int indexOf = arrayList2.indexOf(paymentsDataHelper.getShowMoreModel());
        if (indexOf >= 0) {
            ArrayList<Object> arrayList3 = this.mSummaryList;
            if (arrayList3 == null) {
                k.a("mSummaryList");
            }
            arrayList3.addAll(indexOf, arrayList);
            PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
            if (paymentsListRvAdapter == null) {
                k.a("mAdapter");
            }
            ArrayList<Object> arrayList4 = this.mSummaryList;
            if (arrayList4 == null) {
                k.a("mSummaryList");
            }
            paymentsListRvAdapter.updateRVAdapterList(arrayList4);
            PaymentsDataHelper paymentsDataHelper2 = this.mCurrentHelper;
            if (paymentsDataHelper2 == null) {
                k.a("mCurrentHelper");
            }
            if (!paymentsDataHelper2.hasMorePayments()) {
                PaymentsDataHelper paymentsDataHelper3 = this.mCurrentHelper;
                if (paymentsDataHelper3 == null) {
                    k.a("mCurrentHelper");
                }
                paymentsDataHelper3.getShowMoreModel().getShowMoreButtonState().set(false);
            }
            PaymentsDataHelper paymentsDataHelper4 = this.mCurrentHelper;
            if (paymentsDataHelper4 == null) {
                k.a("mCurrentHelper");
            }
            paymentsDataHelper4.getShowMoreModel().getShowMoreButtonProgressState().set(false);
        }
    }

    /* access modifiers changed from: private */
    public final void collapsePaymentsForDate() {
        ArrayList<Object> arrayList = this.mSummaryList;
        if (arrayList == null) {
            k.a("mSummaryList");
        }
        PaymentsDataHelper paymentsDataHelper = this.mCurrentHelper;
        if (paymentsDataHelper == null) {
            k.a("mCurrentHelper");
        }
        int indexOf = arrayList.indexOf(paymentsDataHelper.getHeaderModel());
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        PaymentsDataHelper paymentsDataHelper2 = this.mCurrentHelper;
        if (paymentsDataHelper2 == null) {
            k.a("mCurrentHelper");
        }
        int indexOf2 = arrayList2.indexOf(paymentsDataHelper2.getShowMoreModel());
        ArrayList<Object> arrayList3 = this.mSummaryList;
        if (arrayList3 == null) {
            k.a("mSummaryList");
        }
        ArrayList<Object> arrayList4 = new ArrayList<>();
        Iterator<T> it2 = arrayList3.iterator();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            if (indexOf + 4 + 2 <= i2 && indexOf2 > i2) {
                z = false;
            }
            if (z) {
                arrayList4.add(next);
            }
            i2 = i3;
        }
        this.mSummaryList = arrayList4;
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> arrayList5 = this.mSummaryList;
        if (arrayList5 == null) {
            k.a("mSummaryList");
        }
        paymentsListRvAdapter.updateRVAdapterList(arrayList5);
        PaymentsDataHelper paymentsDataHelper3 = this.mCurrentHelper;
        if (paymentsDataHelper3 == null) {
            k.a("mCurrentHelper");
        }
        paymentsDataHelper3.getShowMoreModel().getShowMoreButtonState().set(true);
        PaymentsDataHelper paymentsDataHelper4 = this.mCurrentHelper;
        if (paymentsDataHelper4 == null) {
            k.a("mCurrentHelper");
        }
        paymentsDataHelper4.getShowMoreModel().getShowMoreButtonProgressState().set(false);
    }

    /* access modifiers changed from: private */
    public final void processSummaryListResponse(com.business.common_module.utilities.a.b<DaywiseSummaryListModel> bVar) {
        if (bVar.f7357b != e.LOADING) {
            this.mFetchingSummaries = false;
            PaymentsListViewModel paymentsListViewModel = this.mViewModel;
            if (paymentsListViewModel == null) {
                k.a("mViewModel");
            }
            paymentsListViewModel.setLoadingState(false);
        }
        e eVar = bVar.f7357b;
        if (eVar != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$2[eVar.ordinal()];
            if (i2 == 2) {
                T t = bVar.f7358c;
                k.b(t, "response.data");
                processSummaryListAPIData$default(this, (DaywiseSummaryListModel) t, false, 2, (Object) null);
            } else if (i2 != 3) {
                if (i2 == 4 && !isFinishing()) {
                    if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                        finish();
                    }
                    ArrayList<Object> arrayList = this.mSummaryList;
                    if (arrayList == null) {
                        k.a("mSummaryList");
                    }
                    if (arrayList.isEmpty()) {
                        PaymentsListViewModel paymentsListViewModel2 = this.mViewModel;
                        if (paymentsListViewModel2 == null) {
                            k.a("mViewModel");
                        }
                        paymentsListViewModel2.setErrorState(true);
                        return;
                    }
                    MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
                    if (mpActivityPaymentListBinding == null) {
                        k.a("mBinding");
                    }
                    Snackbar a2 = Snackbar.a((View) mpActivityPaymentListBinding.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7360e), 0);
                    this.mSnackBar = a2;
                    a2.c();
                }
            } else if (!isFinishing()) {
                if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                    finish();
                }
                ArrayList<Object> arrayList2 = this.mSummaryList;
                if (arrayList2 == null) {
                    k.a("mSummaryList");
                }
                if (arrayList2.isEmpty()) {
                    PaymentsListViewModel paymentsListViewModel3 = this.mViewModel;
                    if (paymentsListViewModel3 == null) {
                        k.a("mViewModel");
                    }
                    paymentsListViewModel3.setErrorState(true);
                    return;
                }
                MpActivityPaymentListBinding mpActivityPaymentListBinding2 = this.mBinding;
                if (mpActivityPaymentListBinding2 == null) {
                    k.a("mBinding");
                }
                Snackbar a3 = Snackbar.a((View) mpActivityPaymentListBinding2.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7356a), 0);
                this.mSnackBar = a3;
                a3.c();
            }
        }
    }

    public static /* synthetic */ void processSummaryListAPIData$default(PaymentListActivity paymentListActivity, DaywiseSummaryListModel daywiseSummaryListModel, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            paymentListActivity.processSummaryListAPIData(daywiseSummaryListModel, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processSummaryListAPIData");
    }

    public void processSummaryListAPIData(DaywiseSummaryListModel daywiseSummaryListModel, boolean z) {
        k.d(daywiseSummaryListModel, "data");
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        summaryListDataHelper.setDataFromSummaryListAPI(daywiseSummaryListModel, z);
        SummaryListDataHelper summaryListDataHelper2 = this.mSummaryListDataHelper;
        if (summaryListDataHelper2 == null) {
            k.a("mSummaryListDataHelper");
        }
        ArrayList<Object> summaryList = summaryListDataHelper2.getSummaryList();
        this.mSummaryList = summaryList;
        if (summaryList == null) {
            k.a("mSummaryList");
        }
        if (summaryList.isEmpty()) {
            ArrayList<Object> arrayList = this.mSummaryList;
            if (arrayList == null) {
                k.a("mSummaryList");
            }
            arrayList.add(new PaymentsEmptyModel());
        }
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        paymentsListRvAdapter.updateRVAdapterList(arrayList2);
    }

    /* access modifiers changed from: private */
    public final void handleNonMigratedPaymentsResponse(com.business.common_module.utilities.a.b<NonMigratedPaymentsModel> bVar) {
        if (bVar.f7357b != e.LOADING) {
            this.mFetchingSummaries = false;
            PaymentsListViewModel paymentsListViewModel = this.mViewModel;
            if (paymentsListViewModel == null) {
                k.a("mViewModel");
            }
            paymentsListViewModel.setLoadingState(false);
        }
        e eVar = bVar.f7357b;
        if (eVar != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$3[eVar.ordinal()];
            if (i2 == 2) {
                T t = bVar.f7358c;
                k.b(t, "response.data");
                processNonMigratedAPIData((NonMigratedPaymentsModel) t);
            } else if (i2 != 3) {
                if (i2 == 4 && !isFinishing()) {
                    if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                        finish();
                    }
                    ArrayList<Object> arrayList = this.mSummaryList;
                    if (arrayList == null) {
                        k.a("mSummaryList");
                    }
                    if (arrayList.isEmpty()) {
                        PaymentsListViewModel paymentsListViewModel2 = this.mViewModel;
                        if (paymentsListViewModel2 == null) {
                            k.a("mViewModel");
                        }
                        paymentsListViewModel2.setErrorState(true);
                        return;
                    }
                    MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
                    if (mpActivityPaymentListBinding == null) {
                        k.a("mBinding");
                    }
                    Snackbar a2 = Snackbar.a((View) mpActivityPaymentListBinding.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7360e), 0);
                    this.mSnackBar = a2;
                    a2.c();
                }
            } else if (!isFinishing()) {
                if (ErrorUtil.handleInvalidToken(bVar.f7356a)) {
                    finish();
                }
                ArrayList<Object> arrayList2 = this.mSummaryList;
                if (arrayList2 == null) {
                    k.a("mSummaryList");
                }
                if (arrayList2.isEmpty()) {
                    PaymentsListViewModel paymentsListViewModel3 = this.mViewModel;
                    if (paymentsListViewModel3 == null) {
                        k.a("mViewModel");
                    }
                    paymentsListViewModel3.setErrorState(true);
                    return;
                }
                MpActivityPaymentListBinding mpActivityPaymentListBinding2 = this.mBinding;
                if (mpActivityPaymentListBinding2 == null) {
                    k.a("mBinding");
                }
                Snackbar a3 = Snackbar.a((View) mpActivityPaymentListBinding2.coordinatorLayout, (CharSequence) ErrorUtil.getErrorMessage(bVar.f7356a), 0);
                this.mSnackBar = a3;
                a3.c();
            }
        }
    }

    private final void processNonMigratedAPIData(NonMigratedPaymentsModel nonMigratedPaymentsModel) {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        summaryListDataHelper.setDataFromNonMigratedAPI(nonMigratedPaymentsModel);
        SummaryListDataHelper summaryListDataHelper2 = this.mSummaryListDataHelper;
        if (summaryListDataHelper2 == null) {
            k.a("mSummaryListDataHelper");
        }
        ArrayList<Object> summaryList = summaryListDataHelper2.getSummaryList();
        this.mSummaryList = summaryList;
        if (summaryList == null) {
            k.a("mSummaryList");
        }
        if (summaryList.isEmpty()) {
            ArrayList<Object> arrayList = this.mSummaryList;
            if (arrayList == null) {
                k.a("mSummaryList");
            }
            arrayList.add(new PaymentsEmptyModel());
        }
        PaymentsListRvAdapter paymentsListRvAdapter = this.mAdapter;
        if (paymentsListRvAdapter == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> arrayList2 = this.mSummaryList;
        if (arrayList2 == null) {
            k.a("mSummaryList");
        }
        paymentsListRvAdapter.updateRVAdapterList(arrayList2);
    }

    public void onRangeSelected(String str) {
        k.d(str, "range");
        switch (str.hashCode()) {
            case -1778017348:
                if (str.equals(AppConstants.CUSTOM_DATE)) {
                    String string = getString(R.string.mp_custom_date);
                    k.b(string, "getString(R.string.mp_custom_date)");
                    this.mRange = string;
                    return;
                }
                return;
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY)) {
                    String string2 = getString(R.string.mp_yesterday);
                    k.b(string2, "getString(R.string.mp_yesterday)");
                    this.mRange = string2;
                    String yesterdayStartDate = DateUtility.getYesterdayStartDate("dd MMMM yy");
                    k.b(yesterdayStartDate, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                    this.reportStartDate = yesterdayStartDate;
                    String yesterdayEndDate = DateUtility.getYesterdayEndDate("dd MMMM yy");
                    k.b(yesterdayEndDate, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                    this.reportEndDate = yesterdayEndDate;
                    return;
                }
                return;
            case 3645428:
                if (str.equals("week")) {
                    String string3 = getString(R.string.mp_this_week);
                    k.b(string3, "getString(R.string.mp_this_week)");
                    this.mRange = string3;
                    String currentWeekStart = DateUtility.getCurrentWeekStart("dd MMMM yy");
                    k.b(currentWeekStart, "DateUtility.getCurrentWe…tility.DD_MMMM_YY_FORMAT)");
                    this.reportStartDate = currentWeekStart;
                    String currentFormattedDate = DateUtility.getCurrentFormattedDate("dd MMMM yy");
                    k.b(currentFormattedDate, "DateUtility.getCurrentFo…tility.DD_MMMM_YY_FORMAT)");
                    this.reportEndDate = currentFormattedDate;
                    return;
                }
                return;
            case 41248326:
                if (str.equals(AppConstants.CURRENT_SELECTION)) {
                    String string4 = getString(R.string.mp_current_selection);
                    k.b(string4, "getString(R.string.mp_current_selection)");
                    this.mRange = string4;
                    this.reportStartDate = this.mSavedStartDate;
                    this.reportEndDate = this.mSavedEndDate;
                    return;
                }
                return;
            case 104080000:
                if (str.equals(MPConstants.PaymentSummaryRange.MONTH)) {
                    String string5 = getString(R.string.mp_this_month);
                    k.b(string5, "getString(R.string.mp_this_month)");
                    this.mRange = string5;
                    String monthStartDate = DateUtility.getMonthStartDate("dd MMMM yy");
                    k.b(monthStartDate, "DateUtility.getMonthStar…tility.DD_MMMM_YY_FORMAT)");
                    this.reportStartDate = monthStartDate;
                    String todayStartDate = DateUtility.getTodayStartDate("dd MMMM yy");
                    k.b(todayStartDate, "DateUtility.getTodayStar…tility.DD_MMMM_YY_FORMAT)");
                    this.reportEndDate = todayStartDate;
                    return;
                }
                return;
            case 110534465:
                if (str.equals("today")) {
                    String string6 = getString(R.string.mp_today);
                    k.b(string6, "getString(R.string.mp_today)");
                    this.mRange = string6;
                    String todayStartDate2 = DateUtility.getTodayStartDate("dd MMMM yy");
                    k.b(todayStartDate2, "DateUtility.getTodayStar…tility.DD_MMMM_YY_FORMAT)");
                    this.reportStartDate = todayStartDate2;
                    String currentFormattedDate2 = DateUtility.getCurrentFormattedDate("dd MMMM yy");
                    k.b(currentFormattedDate2, "DateUtility.getCurrentFo…tility.DD_MMMM_YY_FORMAT)");
                    this.reportEndDate = currentFormattedDate2;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void fireGAEventOnDateSelect(String str, String str2) {
        if (!(str2.length() == 0)) {
            String eventLabelonDateSelet = UIUtilityMPKt.getEventLabelonDateSelet(str2);
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(this, "Payment Date Range Page", str, "", eventLabelonDateSelet);
        }
    }

    public void onCustomDateClicked() {
        launchCalendarForDownloadStatementRangeSelection();
    }

    public void onDownloadClicked() {
        if (MPConstants.isP4BClient()) {
            downloadStatement();
            return;
        }
        String startDateOfDifferentFormat = DateUtility.getStartDateOfDifferentFormat(this.reportStartDate, "dd MMMM yy", "dd/MM/yyyy HH:mm:ss");
        String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(this.reportEndDate, "dd MMMM yy", "dd/MM/yyyy HH:mm:ss");
        k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…DATE_TIME_FORMAT_OFFLINE)");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this, AppUtility.getDownloadStatementDeeplink(startDateOfDifferentFormat, endDateOfDifferentFormat));
    }

    /* access modifiers changed from: private */
    public final void downloadStatement() {
        String startDateOfDifferentFormat = DateUtility.getStartDateOfDifferentFormat(this.reportStartDate, "dd MMMM yy", "dd/MM/yyyy HH:mm:ss");
        String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(this.reportEndDate, "dd MMMM yy", "dd/MM/yyyy HH:mm:ss");
        k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…DATE_TIME_FORMAT_OFFLINE)");
        GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this, "Payments", "Download_Stmt_date_submit", this.mRange);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            ReportsApiCallViewModel reportsApiCallViewModel = this.mReportsApiCallViewModel;
            if (reportsApiCallViewModel == null) {
                k.a("mReportsApiCallViewModel");
            }
            MpActivityPaymentListBinding mpActivityPaymentListBinding = this.mBinding;
            if (mpActivityPaymentListBinding == null) {
                k.a("mBinding");
            }
            reportsApiCallViewModel.initiateDownload(mpActivityPaymentListBinding.coordinatorLayout, AppConstants.TRANSACTION, startDateOfDifferentFormat, endDateOfDifferentFormat, AppConstants.TRANSACTION);
            return;
        }
        MpActivityPaymentListBinding mpActivityPaymentListBinding2 = this.mBinding;
        if (mpActivityPaymentListBinding2 == null) {
            k.a("mBinding");
        }
        Snackbar a2 = Snackbar.a((View) mpActivityPaymentListBinding2.coordinatorLayout, R.string.no_connection, -2).a(R.string.retry, (View.OnClickListener) new PaymentListActivity$downloadStatement$1(this));
        this.mSnackBar = a2;
        if (a2 != null) {
            a2.c();
        }
    }

    private final void launchCalendarForDownloadStatementRangeSelection() {
        b bVar = this.mDownloadStatementCalendarUtil;
        if (bVar == null) {
            k.a("mDownloadStatementCalendarUtil");
        }
        bVar.a(com.business.common_module.a.a.a.f7279a, com.business.common_module.a.a.a.f7282d);
    }

    private final void launchCalendarWithCurrentState() {
        b bVar = this.mPaymentCalendarUtil;
        if (bVar == null) {
            k.a("mPaymentCalendarUtil");
        }
        bVar.a(com.business.common_module.a.a.a.f7279a, com.business.common_module.a.a.a.f7282d);
    }

    public static /* synthetic */ void openSelectDateBottomSheet$default(PaymentListActivity paymentListActivity, boolean z, String str, String str2, String str3, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                str2 = "";
            }
            if ((i2 & 8) != 0) {
                str3 = "";
            }
            paymentListActivity.openSelectDateBottomSheet(z, str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSelectDateBottomSheet");
    }

    /* access modifiers changed from: private */
    public final void openSelectDateBottomSheet(boolean z, String str, String str2, String str3) {
        SelectDateBottomSheet selectDateBottomSheet = new SelectDateBottomSheet();
        b bVar = this.mPaymentCalendarUtil;
        if (bVar == null) {
            k.a("mPaymentCalendarUtil");
        }
        selectDateBottomSheet.setCalenderUtl(bVar);
        selectDateBottomSheet.setDownloadListener(this);
        if (z) {
            b bVar2 = this.mDownloadStatementCalendarUtil;
            if (bVar2 == null) {
                k.a("mDownloadStatementCalendarUtil");
            }
            selectDateBottomSheet.setCalenderUtl(bVar2);
            selectDateBottomSheet.setBottomSheetTitle(str);
            selectDateBottomSheet.isDownloadReportFlow(true);
            selectDateBottomSheet.setDates(str2, str3);
        }
        selectDateBottomSheet.show(getSupportFragmentManager(), SelectDateBottomSheet.class.getSimpleName());
    }

    /* access modifiers changed from: private */
    public final boolean isReversalOrVoidTransaction(AdditionalInfo additionalInfo, OrderDetail orderDetail) {
        if ((additionalInfo != null ? additionalInfo.getCancelRequestType() : null) == null) {
            return false;
        }
        if (!p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.REVERSAL, true) && !p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.VOID, true)) {
            return false;
        }
        orderDetail.setBizType(additionalInfo.getCancelRequestType());
        return true;
    }

    public final class PaymentsListRVListener implements PaymentsListRvAdapter.PaymentsRVListener {
        public PaymentsListRVListener() {
        }

        public final void onTransactionItemClick(OrderDetail orderDetail) {
            Intent intent;
            k.d(orderDetail, "detail");
            if (p.a("REFUND", orderDetail.getBizType(), true)) {
                intent = new Intent(PaymentListActivity.this, RefundDetailsActivity.class);
            } else if (p.a(AppConstants.ApiNames.VOID, orderDetail.getBizType(), true) || p.a(AppConstants.ApiNames.REVERSAL, orderDetail.getBizType(), true) || p.a(AppConstants.ApiNames.CHARGEBACK, orderDetail.getBizType(), true) || PaymentListActivity.this.isReversalOrVoidTransaction(orderDetail.getAdditionalInfo(), orderDetail)) {
                intent = new Intent(PaymentListActivity.this, ReversalDetailsActivity.class);
            } else {
                intent = new Intent(PaymentListActivity.this, OnlineTxnDetailsActivity.class);
            }
            intent.putExtra(AppConstants.TRANSACTION_OBJECT_V2, orderDetail);
            PaymentListActivity.this.addIntentData(intent);
            PaymentListActivity.this.startActivity(intent);
        }

        public final void onShowMoreClick(PaymentsShowMoreModel paymentsShowMoreModel) {
            if (PaymentListActivity.this.mFetchingPayments) {
                PaymentListActivity paymentListActivity = PaymentListActivity.this;
                Toast.makeText(paymentListActivity, paymentListActivity.getString(R.string.mp_request_in_process), 0).show();
            } else if (paymentsShowMoreModel != null) {
                PaymentListActivity paymentListActivity2 = PaymentListActivity.this;
                paymentListActivity2.setMCurrentHelper(paymentListActivity2.getMSummaryListDataHelper().getPaymentsHelperForDate(paymentsShowMoreModel.getDate()));
                paymentsShowMoreModel.getShowMoreButtonProgressState().set(true);
                if (!paymentsShowMoreModel.getShowMoreButtonState().get()) {
                    PaymentListActivity.this.collapsePaymentsForDate();
                } else if (!PaymentListActivity.this.getMCurrentHelper().hasMorePayments()) {
                    PaymentListActivity paymentListActivity3 = PaymentListActivity.this;
                    paymentListActivity3.addMorePayments(paymentListActivity3.getMCurrentHelper().getAllRemainingPayments());
                } else {
                    APSharedPreferences instance = APSharedPreferences.getInstance();
                    k.b(instance, "APSharedPreferences.getInstance()");
                    if (instance.isMerchantMigrated()) {
                        PaymentListActivity.this.mFetchingPayments = true;
                        PaymentListActivity.access$getMViewModel$p(PaymentListActivity.this).getMorePaymentsForDate(PaymentListActivity.this.getMCurrentHelper().getDateForAPI(), PaymentListActivity.this.getMCurrentHelper().getPageForAPI());
                    }
                }
            }
        }

        public final void onViewPastPaymentsClick() {
            PaymentListActivity.this.resetSummaryData();
            PaymentListActivity.access$getMAdapter$p(PaymentListActivity.this).updateRVAdapterList(PaymentListActivity.access$getMSummaryList$p(PaymentListActivity.this));
            PaymentListActivity.openSelectDateBottomSheet$default(PaymentListActivity.this, false, (String) null, (String) null, (String) null, 15, (Object) null);
        }
    }

    public final void resetSummaryData() {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        summaryListDataHelper.resetSummaries();
        ArrayList<Object> arrayList = this.mSummaryList;
        if (arrayList == null) {
            k.a("mSummaryList");
        }
        arrayList.clear();
    }
}
