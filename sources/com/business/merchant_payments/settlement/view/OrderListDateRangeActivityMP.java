package com.business.merchant_payments.settlement.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.business.common_module.a.a.a;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.view.CommonOverlayDialogFragment;
import com.business.merchant_payments.common.view.ReportDownloadBottomSheet;
import com.business.merchant_payments.model.customcards.CustomCardUIModel;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;
import com.business.merchant_payments.newhome.AmountOnHoldDialogFragment;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.newhome.HomeRVListener;
import com.business.merchant_payments.newhome.SelectDateBottomSheet;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.reports.ReportsApiCallViewModel;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.M2BOrderListItemModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
import com.business.merchant_payments.utility.MPConstants;
import com.business.merchant_payments.utility.UIUtilityMPKt;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;

public final class OrderListDateRangeActivityMP extends BaseActivity implements CommonOverlayDialogFragment.CommonOverlayDialogListener, ReportDownloadBottomSheet.IReportDownloadListener, HomeRVListener {
    public HashMap _$_findViewCache;
    public HomeRVAdapter mAdapter;
    public final String mApiDateFormat = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";
    public final z<BWSettlementM2BTransactionDetailObservableModel> mBillListDetailObserver = new OrderListDateRangeActivityMP$mBillListDetailObserver$1(this);
    public final z<b<SettlementBillListModel>> mBillListObserver = new OrderListDateRangeActivityMP$mBillListObserver$1(this);
    public final String mCalendarStartDateFormat = "dd MMM yy";
    public int mCurrentPage = 1;
    public final String mDateFormatUsed = "dd MMM yy";
    public String mDownloadEndDate = "";
    public com.business.common_module.a.a.b mDownloadReportCalendarUtil;
    public String mDownloadStartDate = "";
    public String mEndDate;
    public boolean mIsListLoading;
    public boolean mIsPaginating;
    public ReportsApiCallViewModel mReportsViewMode;
    public com.business.common_module.a.a.b mSettlementCalendarUtil;
    public final z<SettlementRangeSummaryModel> mSettlementRangeSummaryObserver = new OrderListDateRangeActivityMP$mSettlementRangeSummaryObserver$1(this);
    public final OrderListDateRangeActivityMP$mSettlementsOnScrollListener$1 mSettlementsOnScrollListener = new OrderListDateRangeActivityMP$mSettlementsOnScrollListener$1(this);
    public String mStartDate;
    public AcceptPaymentViewModel mViewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[e.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[e.SUCCESS.ordinal()] = 1;
        }
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
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

    public final boolean isInactiveMerchantData(Object obj) {
        k.d(obj, "any");
        return false;
    }

    public final void onCTAClick(CustomCardUIModel customCardUIModel, int i2) {
    }

    public final void onCardClosed(CustomCardUIModel customCardUIModel, int i2) {
    }

    public final void onCustomCardClick(CustomCardUIModel customCardUIModel, int i2) {
    }

    public final void onDateRangeDownloadStatementClick() {
    }

    public final void onDisabledSettleNowInfoClicked() {
    }

    public final void onExpandBWPendingSummaryCard(boolean z) {
    }

    public final void onExpandBusinessWalletSummaryCard(boolean z, int i2) {
    }

    public final void onPaymentsTabClick() {
    }

    public final void onSettleNowClick(String str) {
        k.d(str, "amount");
    }

    public final void onSettlementTabClick() {
    }

    public final void onShowMoreClick() {
    }

    public final void onTransactionItemClick(OrderDetail orderDetail) {
        k.d(orderDetail, "detail");
    }

    public final void onViewPastPaymentsClick() {
    }

    public final void showInstantSettlementCoachmark(View view) {
        k.d(view, "itemView");
    }

    public static final /* synthetic */ String access$getMEndDate$p(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        String str = orderListDateRangeActivityMP.mEndDate;
        if (str == null) {
            k.a("mEndDate");
        }
        return str;
    }

    public static final /* synthetic */ String access$getMStartDate$p(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        String str = orderListDateRangeActivityMP.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        return str;
    }

    public static final /* synthetic */ AcceptPaymentViewModel access$getMViewModel$p(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        AcceptPaymentViewModel acceptPaymentViewModel = orderListDateRangeActivityMP.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        return acceptPaymentViewModel;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            String str = null;
            boolean z = true;
            if (i2 == 1) {
                String stringExtra = intent != null ? intent.getStringExtra("intent_extra_selected_start_date") : null;
                if (intent != null) {
                    str = intent.getStringExtra("intent_extra_selected_end_date");
                }
                if (!(stringExtra == null || p.a(stringExtra))) {
                    if (str != null && !p.a(str)) {
                        z = false;
                    }
                    if (!z) {
                        setDateRange(stringExtra, str);
                        loadSettlementRangeSummary();
                        loadRecyclerViewSettlementData();
                        return;
                    }
                }
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                Toast.makeText(this, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            } else if (i2 == 1000) {
                String stringExtra2 = intent != null ? intent.getStringExtra("intent_extra_selected_start_date") : null;
                if (intent != null) {
                    str = intent.getStringExtra("intent_extra_selected_end_date");
                }
                if (!(stringExtra2 == null || p.a(stringExtra2))) {
                    if (str != null && !p.a(str)) {
                        z = false;
                    }
                    if (!z) {
                        this.mDownloadStartDate = stringExtra2;
                        this.mDownloadEndDate = str;
                        return;
                    }
                }
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                Toast.makeText(this, instance2.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setDateRange(String str, String str2) {
        this.mStartDate = str;
        this.mEndDate = str2;
        if (str == null) {
            k.a("mStartDate");
        }
        String dateFromTimeStamp = DateUtility.getDateFromTimeStamp(str, this.mDateFormatUsed);
        String str3 = this.mEndDate;
        if (str3 == null) {
            k.a("mEndDate");
        }
        String dateFromTimeStamp2 = DateUtility.getDateFromTimeStamp(str3, this.mDateFormatUsed);
        if (k.a((Object) dateFromTimeStamp, (Object) dateFromTimeStamp2)) {
            k.b(dateFromTimeStamp, "start");
        } else {
            dateFromTimeStamp = getString(R.string.mp_custom_range, new Object[]{dateFromTimeStamp, dateFromTimeStamp2});
            k.b(dateFromTimeStamp, "getString(R.string.mp_custom_range, start, end)");
        }
        MpRoboTextView mpRoboTextView = (MpRoboTextView) _$_findCachedViewById(R.id.dateRangeHeaderTitleText);
        k.b(mpRoboTextView, "dateRangeHeaderTitleText");
        mpRoboTextView.setText(dateFromTimeStamp);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mp_activity_order_list_date_range);
        c provideViewModel = provideViewModel(AcceptPaymentViewModel.class, (Fragment) null);
        k.b(provideViewModel, "provideViewModel(AcceptP…wModel::class.java, null)");
        this.mViewModel = (AcceptPaymentViewModel) provideViewModel;
        this.mReportsViewMode = new ReportsApiCallViewModel();
        setCalendarUtils();
        getDataFromIntent();
        initCliCkListeners();
        initVars();
    }

    private final void setCalendarUtils() {
        this.mSettlementCalendarUtil = new com.business.common_module.a.a.b(this, new OrderListDateRangeActivityMP$setCalendarUtils$1(this));
        this.mDownloadReportCalendarUtil = new com.business.common_module.a.a.b(this, new OrderListDateRangeActivityMP$setCalendarUtils$2(this));
    }

    private final void handleBillListError() {
        this.mIsPaginating = false;
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        if (homeRVAdapter.isShimmerShowing()) {
            HomeRVAdapter homeRVAdapter2 = this.mAdapter;
            if (homeRVAdapter2 == null) {
                k.a("mAdapter");
            }
            homeRVAdapter2.showErrorUI(-1, new OrderListDateRangeActivityMP$handleBillListError$1(this));
            return;
        }
        showErrorSnackBarForSettlementBillList();
    }

    private final void showErrorSnackBarForSettlementBillList() {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.dateRangeOrderListRoot);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            str = instance2.getAppContext().getString(R.string.mp_oops_something_went_wrong);
        } else {
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            k.b(instance3, "PaymentsConfig.getInstance()");
            str = instance3.getAppContext().getString(R.string.no_internet);
        }
        Snackbar a2 = Snackbar.a((View) constraintLayout, (CharSequence) str, -2);
        PaymentsConfig instance4 = PaymentsConfig.getInstance();
        k.b(instance4, "PaymentsConfig.getInstance()");
        Snackbar a3 = a2.a((CharSequence) instance4.getAppContext().getString(R.string.retry), (View.OnClickListener) new OrderListDateRangeActivityMP$showErrorSnackBarForSettlementBillList$mSnackBar$1(this));
        k.b(a3, "Snackbar.make(\n         …E\n            )\n        }");
        a3.c();
    }

    private final void getDataFromIntent() {
        String str;
        String stringExtra;
        Intent intent = getIntent();
        String str2 = "";
        if (intent == null || (str = intent.getStringExtra("startDate")) == null) {
            str = str2;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (stringExtra = intent2.getStringExtra("endDate")) == null)) {
            str2 = stringExtra;
        }
        setDateRange(str, str2);
    }

    private final void initCliCkListeners() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.arrowView)).setOnClickListener(new OrderListDateRangeActivityMP$initCliCkListeners$1(this));
        setConstraintsForDateContainer();
        ((LinearLayout) _$_findCachedViewById(R.id.dateRangeHeaderDateContainer)).setOnClickListener(new OrderListDateRangeActivityMP$initCliCkListeners$2(this));
    }

    private final void setConstraintsForDateContainer() {
        MpRoboTextView mpRoboTextView = (MpRoboTextView) _$_findCachedViewById(R.id.dateRangeHeaderDownloadStatementContainer);
        k.b(mpRoboTextView, "dateRangeHeaderDownloadStatementContainer");
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        mpRoboTextView.setVisibility(acceptPaymentViewModel.getShoulShowDownloadStatement() ? 0 : 8);
        ((MpRoboTextView) _$_findCachedViewById(R.id.dateRangeHeaderDownloadStatementContainer)).setOnClickListener(new OrderListDateRangeActivityMP$setConstraintsForDateContainer$1(this));
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.b((ConstraintLayout) _$_findCachedViewById(R.id.orderListHeader));
        MpRoboTextView mpRoboTextView2 = (MpRoboTextView) _$_findCachedViewById(R.id.dateRangeHeaderDownloadStatementContainer);
        k.b(mpRoboTextView2, "dateRangeHeaderDownloadStatementContainer");
        if (mpRoboTextView2.getVisibility() == 0) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.dateRangeHeaderDateContainer);
            k.b(linearLayout, "dateRangeHeaderDateContainer");
            int id = linearLayout.getId();
            MpRoboTextView mpRoboTextView3 = (MpRoboTextView) _$_findCachedViewById(R.id.dateRangeHeaderDownloadStatementContainer);
            k.b(mpRoboTextView3, "dateRangeHeaderDownloadStatementContainer");
            cVar.a(id, 7, mpRoboTextView3.getId(), 6);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.dateRangeHeaderDateContainer);
            k.b(linearLayout2, "dateRangeHeaderDateContainer");
            int id2 = linearLayout2.getId();
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.orderListHeader);
            k.b(constraintLayout, "orderListHeader");
            cVar.a(id2, 7, constraintLayout.getId(), 7);
        }
        cVar.c((ConstraintLayout) _$_findCachedViewById(R.id.orderListHeader));
    }

    /* access modifiers changed from: private */
    public final void startDownloadingReports() {
        String str = this.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        this.mDownloadStartDate = str;
        String str2 = this.mEndDate;
        if (str2 == null) {
            k.a("mEndDate");
        }
        this.mDownloadEndDate = str2;
        String string = getString(R.string.mp_label_download_settlements_received_for);
        k.b(string, "getString(R.string.mp_la…settlements_received_for)");
        String str3 = this.mStartDate;
        if (str3 == null) {
            k.a("mStartDate");
        }
        String str4 = this.mEndDate;
        if (str4 == null) {
            k.a("mEndDate");
        }
        openSelectDateBottomSheet(true, string, str3, str4);
    }

    private final void initVars() {
        String str = this.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        if (!p.a(str)) {
            String str2 = this.mEndDate;
            if (str2 == null) {
                k.a("mEndDate");
            }
            if (!p.a(str2)) {
                showDataInRecyclerView();
                return;
            }
        }
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Toast.makeText(this, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 1).show();
        finish();
    }

    private final ArrayList<Object> initAdapterForSettlements() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addAll(P4BSettlementsDataHelperMP.INSTANCE.getElementShimmers(7));
        return arrayList;
    }

    private final void showDataInRecyclerView() {
        initObservers();
        ArrayList arrayList = new ArrayList();
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        this.mAdapter = new HomeRVAdapter(this, arrayList, this, acceptPaymentViewModel);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.orderListRv);
        k.b(recyclerView, "orderListRv");
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        recyclerView.setAdapter(homeRVAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.orderListRv);
        k.b(recyclerView2, "orderListRv");
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.orderListRv);
        k.b(recyclerView3, "orderListRv");
        recyclerView3.setItemAnimator(new g());
        ((RecyclerView) _$_findCachedViewById(R.id.orderListRv)).addOnScrollListener(this.mSettlementsOnScrollListener);
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.dateRangeOrderListSwipeToRefresh)).setOnRefreshListener(new OrderListDateRangeActivityMP$showDataInRecyclerView$1(this));
        loadSettlementRangeSummary();
        loadRecyclerViewSettlementData();
    }

    /* access modifiers changed from: private */
    public final void loadRecyclerViewSettlementData() {
        this.mIsListLoading = true;
        this.mIsPaginating = true;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(R.id.dateRangeOrderListSwipeToRefresh);
        k.b(swipeRefreshLayout, "dateRangeOrderListSwipeToRefresh");
        swipeRefreshLayout.setRefreshing(true);
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        homeRVAdapter.resetLastExpandedItemIndex();
        HomeRVAdapter homeRVAdapter2 = this.mAdapter;
        if (homeRVAdapter2 == null) {
            k.a("mAdapter");
        }
        ArrayList<Object> initAdapterForSettlements = initAdapterForSettlements();
        initAdapterForSettlements.add(0, new SettlementRangeSummaryModel("", true, 0, 4, (kotlin.g.b.g) null));
        homeRVAdapter2.updateRVAdapterList(initAdapterForSettlements);
        loadMoreSettlementItems();
    }

    private final void initObservers() {
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        acceptPaymentViewModel.getMSettlementBillListModel().observe(this, this.mBillListObserver);
        AcceptPaymentViewModel acceptPaymentViewModel2 = this.mViewModel;
        if (acceptPaymentViewModel2 == null) {
            k.a("mViewModel");
        }
        acceptPaymentViewModel2.getMSelectedSettledBillListDetail().observe(this, this.mBillListDetailObserver);
        AcceptPaymentViewModel acceptPaymentViewModel3 = this.mViewModel;
        if (acceptPaymentViewModel3 == null) {
            k.a("mViewModel");
        }
        acceptPaymentViewModel3.getMSettlementRangeSummary().observe(this, this.mSettlementRangeSummaryObserver);
    }

    /* access modifiers changed from: private */
    public final void handleBillListResponse(b<SettlementBillListModel> bVar) {
        this.mIsListLoading = false;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(R.id.dateRangeOrderListSwipeToRefresh);
        k.b(swipeRefreshLayout, "dateRangeOrderListSwipeToRefresh");
        swipeRefreshLayout.setRefreshing(false);
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        homeRVAdapter.removeLoadingFooter();
        if (bVar.f7357b == e.SUCCESS) {
            SettlementBillListModel settlementBillListModel = (SettlementBillListModel) bVar.f7358c;
            onBillListSuccess(settlementBillListModel != null ? settlementBillListModel.getSettlementBillList() : null);
        } else if (!ErrorUtil.handleInvalidToken(bVar.f7356a)) {
            handleBillListError();
        }
    }

    private final void onBillListSuccess(ArrayList<SettlementBillListItemModel> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            processDataEnd();
            HomeRVAdapter homeRVAdapter = this.mAdapter;
            if (homeRVAdapter == null) {
                k.a("mAdapter");
            }
            homeRVAdapter.updateSettlementSummaryRangeVisibility(8);
            return;
        }
        HomeRVAdapter homeRVAdapter2 = this.mAdapter;
        if (homeRVAdapter2 == null) {
            k.a("mAdapter");
        }
        homeRVAdapter2.updateSettlementSummaryRangeVisibility(0);
        HomeRVAdapter homeRVAdapter3 = this.mAdapter;
        if (homeRVAdapter3 == null) {
            k.a("mAdapter");
        }
        HomeRVAdapter.addSettlements$default(homeRVAdapter3, arrayList, false, false, 4, (Object) null);
        if (arrayList.size() == 50) {
            this.mCurrentPage++;
        } else {
            processDataEnd();
        }
    }

    private final void processDataEnd() {
        this.mIsPaginating = false;
        this.mCurrentPage = 1;
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        if (homeRVAdapter.isShimmerShowing()) {
            HomeRVAdapter homeRVAdapter2 = this.mAdapter;
            if (homeRVAdapter2 == null) {
                k.a("mAdapter");
            }
            HomeRVAdapter.removeSettlementShimmer$default(homeRVAdapter2, R.string.mp_labeel_yout_do_not_have_settlements_between_these_dates, R.drawable.mp_no_settlements_permissions, false, false, 8, (Object) null);
        }
    }

    public static /* synthetic */ void openSelectDateBottomSheet$default(OrderListDateRangeActivityMP orderListDateRangeActivityMP, boolean z, String str, String str2, String str3, int i2, Object obj) {
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
        orderListDateRangeActivityMP.openSelectDateBottomSheet(z, str, str2, str3);
    }

    private final void openSelectDateBottomSheet(boolean z, String str, String str2, String str3) {
        SelectDateBottomSheet selectDateBottomSheet = new SelectDateBottomSheet();
        com.business.common_module.a.a.b bVar = this.mSettlementCalendarUtil;
        if (bVar == null) {
            k.a("mSettlementCalendarUtil");
        }
        selectDateBottomSheet.setCalenderUtl(bVar);
        selectDateBottomSheet.setDownloadListener(this);
        if (z) {
            com.business.common_module.a.a.b bVar2 = this.mDownloadReportCalendarUtil;
            if (bVar2 == null) {
                k.a("mDownloadReportCalendarUtil");
            }
            selectDateBottomSheet.setCalenderUtl(bVar2);
            selectDateBottomSheet.setBottomSheetTitle(str);
            selectDateBottomSheet.isDownloadReportFlow(true);
            selectDateBottomSheet.setDates(str2, str3);
        }
        selectDateBottomSheet.show(getSupportFragmentManager(), SelectDateBottomSheet.class.getSimpleName());
    }

    /* access modifiers changed from: private */
    public final void handleSettlementRangeSummaryResponse(SettlementRangeSummaryModel settlementRangeSummaryModel) {
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        homeRVAdapter.onSettlementSummaryRangeResponse(settlementRangeSummaryModel);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        r2 = r2.getM2b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleBillListDetailResponse(com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel r5) {
        /*
            r4 = this;
            r4.removeProgressDialog()
            com.business.common_module.utilities.a.b r0 = r5.getWrappedData()
            com.business.common_module.utilities.a.e r1 = r0.f7357b
            if (r1 == 0) goto L_0x004b
            int[] r2 = com.business.merchant_payments.settlement.view.OrderListDateRangeActivityMP.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0017
            goto L_0x004b
        L_0x0017:
            com.business.merchant_payments.newhome.HomeRVAdapter r1 = r4.mAdapter
            if (r1 != 0) goto L_0x0020
            java.lang.String r2 = "mAdapter"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0020:
            int r5 = r5.getPosition()
            T r2 = r0.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r2 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r2
            r3 = 0
            if (r2 == 0) goto L_0x0036
            com.business.merchant_payments.settlement.model.M2BModel r2 = r2.getM2b()
            if (r2 == 0) goto L_0x0036
            java.util.ArrayList r2 = r2.getOrderList()
            goto L_0x0037
        L_0x0036:
            r2 = r3
        L_0x0037:
            T r0 = r0.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r0 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r0
            if (r0 == 0) goto L_0x0047
            com.business.merchant_payments.settlement.model.SettlementAmountDetailsModel r0 = r0.getAmountDetails()
            if (r0 == 0) goto L_0x0047
            java.util.ArrayList r3 = r0.getSettlementAmountDetails()
        L_0x0047:
            r1.onSettlementBillListItemDetailResponse(r5, r2, r3)
            return
        L_0x004b:
            r4.showApiError()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.view.OrderListDateRangeActivityMP.handleBillListDetailResponse(com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel):void");
    }

    private final void showApiError() {
        String str;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            str = instance2.getAppContext().getString(R.string.mp_oops_something_went_wrong);
        } else {
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            k.b(instance3, "PaymentsConfig.getInstance()");
            str = instance3.getAppContext().getString(R.string.no_internet);
        }
        k.b(str, "if (NetworkUtility.isNet…ing(R.string.no_internet)");
        Toast.makeText(this, str, 1).show();
    }

    /* access modifiers changed from: private */
    public final void loadMoreSettlementItems() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(R.id.dateRangeOrderListSwipeToRefresh);
        k.b(swipeRefreshLayout, "dateRangeOrderListSwipeToRefresh");
        swipeRefreshLayout.setRefreshing(true);
        this.mIsListLoading = true;
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        int i2 = this.mCurrentPage;
        String str = this.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        String startDateOfDifferentFormat = DateUtility.getStartDateOfDifferentFormat(str, this.mDateFormatUsed, this.mApiDateFormat);
        k.b(startDateOfDifferentFormat, "DateUtility.getStartDate…rmatUsed, mApiDateFormat)");
        String str2 = this.mEndDate;
        if (str2 == null) {
            k.a("mEndDate");
        }
        String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(str2, this.mDateFormatUsed, this.mApiDateFormat);
        k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…rmatUsed, mApiDateFormat)");
        acceptPaymentViewModel.getSettlementBillList(i2, startDateOfDifferentFormat, endDateOfDifferentFormat, 50);
    }

    public final void onSettlmentDateRangeClick() {
        openSelectDateBottomSheet$default(this, false, (String) null, (String) null, (String) null, 15, (Object) null);
    }

    public final void onDateRangeHeaderBackPressed() {
        onBackPressed();
    }

    public final void onToggleCompressState(boolean z, int i2) {
        HomeRVAdapter homeRVAdapter = this.mAdapter;
        if (homeRVAdapter == null) {
            k.a("mAdapter");
        }
        homeRVAdapter.onToggleCompressState(!z, i2);
    }

    public final void onBWSettlementItemClick(boolean z, int i2, SettlementBillListItemModel settlementBillListItemModel) {
        k.d(settlementBillListItemModel, "modelData");
        if (isFinishing()) {
            return;
        }
        if (z) {
            HomeRVAdapter homeRVAdapter = this.mAdapter;
            if (homeRVAdapter == null) {
                k.a("mAdapter");
            }
            homeRVAdapter.onSettlementBillListItemDetailResponse(i2, (ArrayList<M2BOrderListItemModel>) null, (ArrayList<LabelModel>) null);
            return;
        }
        showProgressDialog();
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        String startDateOfTimeStamp = DateUtility.getStartDateOfTimeStamp(settlementBillListItemModel.getSettlementTime());
        k.b(startDateOfTimeStamp, "DateUtility.getStartDate…modelData.settlementTime)");
        String settlementTime = settlementBillListItemModel.getSettlementTime();
        String str = this.mApiDateFormat;
        String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(settlementTime, str, str);
        k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…teFormat, mApiDateFormat)");
        acceptPaymentViewModel.getSettlementBillListDetail(startDateOfTimeStamp, endDateOfDifferentFormat, i2);
    }

    public final void onCustomDateClicked() {
        com.business.common_module.a.a.b bVar = this.mDownloadReportCalendarUtil;
        if (bVar == null) {
            k.a("mDownloadReportCalendarUtil");
        }
        bVar.a(a.f7279a, a.f7282d);
    }

    public final void onRangeSelected(String str) {
        k.d(str, "range");
        switch (str.hashCode()) {
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY)) {
                    String yesterdayStartDate = DateUtility.getYesterdayStartDate("dd MMMM yy");
                    k.b(yesterdayStartDate, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadStartDate = yesterdayStartDate;
                    String yesterdayEndDate = DateUtility.getYesterdayEndDate("dd MMMM yy");
                    k.b(yesterdayEndDate, "DateUtility.getYesterday…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadEndDate = yesterdayEndDate;
                    return;
                }
                break;
            case 3645428:
                if (str.equals("week")) {
                    List<String> currentWeekForUTR = DateUtility.getCurrentWeekForUTR("dd MMMM yy");
                    k.b(currentWeekForUTR, "DateUtility.getCurrentWe…tility.DD_MMMM_YY_FORMAT)");
                    if (!currentWeekForUTR.isEmpty()) {
                        String currentWeekStart = DateUtility.getCurrentWeekStart("dd MMMM yy");
                        k.b(currentWeekStart, "DateUtility.getCurrentWe…tility.DD_MMMM_YY_FORMAT)");
                        this.mDownloadStartDate = currentWeekStart;
                        String currentFormattedDate = DateUtility.getCurrentFormattedDate("dd MMMM yy");
                        k.b(currentFormattedDate, "DateUtility.getCurrentFo…tility.DD_MMMM_YY_FORMAT)");
                        this.mDownloadEndDate = currentFormattedDate;
                        return;
                    }
                    return;
                }
                break;
            case 41248326:
                if (str.equals(AppConstants.CURRENT_SELECTION)) {
                    String str2 = this.mStartDate;
                    if (str2 == null) {
                        k.a("mStartDate");
                    }
                    this.mDownloadStartDate = str2;
                    String str3 = this.mEndDate;
                    if (str3 == null) {
                        k.a("mEndDate");
                    }
                    this.mDownloadEndDate = str3;
                    return;
                }
                break;
            case 104080000:
                if (str.equals(MPConstants.PaymentSummaryRange.MONTH)) {
                    String monthStartDate = DateUtility.getMonthStartDate("dd MMMM yy");
                    k.b(monthStartDate, "DateUtility.getMonthStar…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadStartDate = monthStartDate;
                    String todayStartDate = DateUtility.getTodayStartDate("dd MMMM yy");
                    k.b(todayStartDate, "DateUtility.getTodayStar…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadEndDate = todayStartDate;
                    return;
                }
                break;
            case 110534465:
                if (str.equals("today")) {
                    String todayStartDate2 = DateUtility.getTodayStartDate("dd MMMM yy");
                    k.b(todayStartDate2, "DateUtility.getTodayStar…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadStartDate = todayStartDate2;
                    String currentFormattedDate2 = DateUtility.getCurrentFormattedDate("dd MMMM yy");
                    k.b(currentFormattedDate2, "DateUtility.getCurrentFo…tility.DD_MMMM_YY_FORMAT)");
                    this.mDownloadEndDate = currentFormattedDate2;
                    return;
                }
                break;
        }
        LogUtility.d(OrderListDateRangeActivityMP.class.getSimpleName(), "Custom Date Selected");
    }

    /* access modifiers changed from: private */
    public final void fireGAEventOnDateSelect(String str, String str2) {
        if (!(str2.length() == 0)) {
            String eventLabelonDateSelet = UIUtilityMPKt.getEventLabelonDateSelet(str2);
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(this, "Settlement Date Range Page", str, "", eventLabelonDateSelet);
        }
    }

    public final void onDownloadClicked() {
        if (p.a(this.mDownloadStartDate) || p.a(this.mDownloadEndDate)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Toast.makeText(this, instance.getAppContext().getString(R.string.mp_label_inavlid_date_range_selected_error), 0).show();
            return;
        }
        ReportsApiCallViewModel reportsApiCallViewModel = this.mReportsViewMode;
        if (reportsApiCallViewModel == null) {
            k.a("mReportsViewMode");
        }
        reportsApiCallViewModel.initiateDownload((CoordinatorLayout) _$_findCachedViewById(R.id.coordinatorLayout), "settled", DateUtility.getStartDateOfDifferentFormat(this.mDownloadStartDate, this.mDateFormatUsed, "dd/MM/yyyy HH:mm:ss"), DateUtility.getEndDateOfDifferentFormat(this.mDownloadEndDate, this.mDateFormatUsed, "dd/MM/yyyy HH:mm:ss"), "settled");
    }

    /* access modifiers changed from: private */
    public final void loadSettlementRangeSummary() {
        AcceptPaymentViewModel acceptPaymentViewModel = this.mViewModel;
        if (acceptPaymentViewModel == null) {
            k.a("mViewModel");
        }
        String str = this.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        String str2 = this.mEndDate;
        if (str2 == null) {
            k.a("mEndDate");
        }
        acceptPaymentViewModel.fetchSettlementRangeSummary(str, str2);
    }

    public final void onCarryForwardBalanceClick(LinkedHashMap<String, String> linkedHashMap) {
        k.d(linkedHashMap, "amountOnHoldValue");
        AmountOnHoldDialogFragment.Companion.newInstance(linkedHashMap).show(getSupportFragmentManager(), "amountOnHoldDialog");
    }

    public final void onMDRChangesClick() {
        CommonOverlayDialogFragment.Companion companion = CommonOverlayDialogFragment.Companion;
        String string = getString(R.string.mp_label_val_mdr_charges);
        k.b(string, "getString(R.string.mp_label_val_mdr_charges)");
        String string2 = getString(R.string.mp_label_mdr_description);
        k.b(string2, "getString(R.string.mp_label_mdr_description)");
        String string3 = getString(R.string.mp_label_mdr_btn_txt);
        k.b(string3, "getString(R.string.mp_label_mdr_btn_txt)");
        companion.newInstance(string, string2, string3, this).show(getSupportFragmentManager(), "mdrChargesDialog");
    }

    public final void onDialogButtonClick() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this, "paytmba://business-app/h/limits-and-charges/upgrade-limits");
    }

    public final RecyclerView.v getInactivateMerchantViewHolder(ViewGroup viewGroup) {
        k.d(viewGroup, "parent");
        throw new Exception();
    }
}
