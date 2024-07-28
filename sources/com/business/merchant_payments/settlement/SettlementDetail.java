package com.business.merchant_payments.settlement;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.FragmentSettlementDetailBinding;
import com.business.merchant_payments.settlement.image_target.MpP4bBankImageTarget;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class SettlementDetail extends BaseActivity {
    public final z<BWSettlementM2BTransactionDetailObservableModel> BWSettlementM2BTransactionDetailObservableModel = new SettlementDetail$BWSettlementM2BTransactionDetailObservableModel$1(this);
    public HashMap _$_findViewCache;
    public String bankNumber;
    public FragmentSettlementDetailBinding binding;
    public String iconUrl;
    public SettlementDetailAdapter mAdapter;
    public int mCurrentPage = 1;
    public boolean mIsPaginatingBillList;
    public boolean mIsUnknownBankCase;
    public boolean mSettlementListLoading;
    public final SettlementDetail$mSettlementsOnScrollListener$1 mSettlementsOnScrollListener = new SettlementDetail$mSettlementsOnScrollListener$1(this);
    public SettlementDetailViewModel mViewModel;
    public String netAmount = "--";
    public int settlementBankType = 1;
    public String settlementQueryType;
    public String startDate;

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

    public static final /* synthetic */ String access$getBankNumber$p(SettlementDetail settlementDetail) {
        String str = settlementDetail.bankNumber;
        if (str == null) {
            k.a("bankNumber");
        }
        return str;
    }

    public static final /* synthetic */ String access$getIconUrl$p(SettlementDetail settlementDetail) {
        String str = settlementDetail.iconUrl;
        if (str == null) {
            k.a(SDKConstants.ICON_URL);
        }
        return str;
    }

    public static final /* synthetic */ String access$getStartDate$p(SettlementDetail settlementDetail) {
        String str = settlementDetail.startDate;
        if (str == null) {
            k.a("startDate");
        }
        return str;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = f.a(this, R.layout.fragment_settlement_detail);
        k.b(a2, "DataBindingUtil.setConte…agment_settlement_detail)");
        this.binding = (FragmentSettlementDetailBinding) a2;
        getIntentData();
        initObservers();
        this.mAdapter = new SettlementDetailAdapter(this, new ArrayList(), this.settlementBankType);
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
        if (fragmentSettlementDetailBinding == null) {
            k.a("binding");
        }
        RecyclerView recyclerView = fragmentSettlementDetailBinding.rvSettlementDetail;
        SettlementDetailAdapter settlementDetailAdapter = this.mAdapter;
        if (settlementDetailAdapter == null) {
            k.a("mAdapter");
        }
        recyclerView.setAdapter(settlementDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnScrollListener(this.mSettlementsOnScrollListener);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setAutoMeasureEnabled(true);
        }
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding2 = this.binding;
        if (fragmentSettlementDetailBinding2 == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView = fragmentSettlementDetailBinding2.tvDate;
        k.b(mpRoboTextView, "binding.tvDate");
        String str = this.startDate;
        if (str == null) {
            k.a("startDate");
        }
        mpRoboTextView.setText(DateUtility.convertDateToDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "d MMM"));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding3 = this.binding;
        if (fragmentSettlementDetailBinding3 == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView2 = fragmentSettlementDetailBinding3.tvSettledAmnt;
        k.b(mpRoboTextView2, "binding.tvSettledAmnt");
        mpRoboTextView2.setText(this.netAmount);
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding4 = this.binding;
        if (fragmentSettlementDetailBinding4 == null) {
            k.a("binding");
        }
        fragmentSettlementDetailBinding4.ivBack.setOnClickListener(new SettlementDetail$onCreate$2(this));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding5 = this.binding;
        if (fragmentSettlementDetailBinding5 == null) {
            k.a("binding");
        }
        MpRoboTextView mpRoboTextView3 = fragmentSettlementDetailBinding5.tvSettledTo;
        k.b(mpRoboTextView3, "binding.tvSettledTo");
        mpRoboTextView3.setText(getHeaderText());
        String str2 = this.startDate;
        if (str2 == null) {
            k.a("startDate");
        }
        callSettlementDetailApi(str2);
    }

    private final void getIntentData() {
        int i2;
        if (getIntent() != null) {
            if (getIntent().hasExtra(AppConstants.START_DATE)) {
                String stringExtra = getIntent().getStringExtra(AppConstants.START_DATE);
                k.b(stringExtra, "intent.getStringExtra(AppConstants.START_DATE)");
                this.startDate = stringExtra;
            }
            if (getIntent().hasExtra(AppConstants.NET_AMOUNT)) {
                String stringExtra2 = getIntent().getStringExtra(AppConstants.NET_AMOUNT);
                k.b(stringExtra2, "intent.getStringExtra(AppConstants.NET_AMOUNT)");
                this.netAmount = stringExtra2;
            }
            if (getIntent().hasExtra(AppConstants.IS_SETTLED_IN_MULTIPLE_BANK)) {
                if (getIntent().getIntExtra(AppConstants.IS_SETTLED_IN_MULTIPLE_BANK, this.settlementBankType) == 2) {
                    this.mIsUnknownBankCase = true;
                    i2 = 0;
                } else {
                    i2 = getIntent().getIntExtra(AppConstants.IS_SETTLED_IN_MULTIPLE_BANK, this.settlementBankType);
                }
                this.settlementBankType = i2;
            }
            if (getIntent().hasExtra(AppConstants.SETTLEMENT_TYPE)) {
                String stringExtra3 = getIntent().getStringExtra(AppConstants.SETTLEMENT_TYPE);
                k.b(stringExtra3, "intent.getStringExtra(Ap…onstants.SETTLEMENT_TYPE)");
                this.settlementQueryType = stringExtra3;
            }
            if (getIntent().hasExtra(AppConstants.ICON_URL)) {
                String stringExtra4 = getIntent().getStringExtra(AppConstants.ICON_URL);
                k.b(stringExtra4, "intent.getStringExtra(AppConstants.ICON_URL)");
                this.iconUrl = stringExtra4;
            }
            if (getIntent().hasExtra(AppConstants.FORMATTED_BANK_ACCOUNNT_NUMBER)) {
                String stringExtra5 = getIntent().getStringExtra(AppConstants.FORMATTED_BANK_ACCOUNNT_NUMBER);
                k.b(stringExtra5, "intent.getStringExtra(Ap…TED_BANK_ACCOUNNT_NUMBER)");
                this.bankNumber = stringExtra5;
            }
        }
    }

    private final String getHeaderText() {
        String str = this.settlementQueryType;
        if (str == null) {
            k.a("settlementQueryType");
        }
        if (k.a((Object) str, (Object) "PENDING")) {
            String string = getString(R.string.mp_total_pending_settlements);
            k.b(string, "getString(R.string.mp_total_pending_settlements)");
            return string;
        }
        String str2 = this.settlementQueryType;
        if (str2 == null) {
            k.a("settlementQueryType");
        }
        if (k.a((Object) str2, (Object) "SUCCESS")) {
            String string2 = getString(R.string.mp_settlement_amount_lbl);
            k.b(string2, "getString(R.string.mp_settlement_amount_lbl)");
            return string2;
        } else if (this.mIsUnknownBankCase) {
            String string3 = getString(R.string.mp_label_settlement);
            k.b(string3, "getString(R.string.mp_label_settlement)");
            return string3;
        } else if (this.settlementBankType == 0) {
            String string4 = getString(R.string.mp_settled_to_multiple_accounts);
            k.b(string4, "getString(R.string.mp_se…led_to_multiple_accounts)");
            return string4;
        } else {
            loadBankLogoAndDetails();
            String string5 = getString(R.string.mp_label_online_settled_to);
            k.b(string5, "getString(R.string.mp_label_online_settled_to)");
            return string5;
        }
    }

    private final void loadBankLogoAndDetails() {
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
        if (fragmentSettlementDetailBinding == null) {
            k.a("binding");
        }
        ImageView imageView = fragmentSettlementDetailBinding.bwSettlementDetailBankLogoImage;
        k.b(imageView, "binding.bwSettlementDetailBankLogoImage");
        MpP4bBankImageTarget mpP4bBankImageTarget = new MpP4bBankImageTarget(new WeakReference(imageView));
        String str = this.iconUrl;
        boolean z = true;
        if (str != null) {
            if (str == null) {
                k.a(SDKConstants.ICON_URL);
            }
            if (!(str == null || str.length() == 0)) {
                FragmentSettlementDetailBinding fragmentSettlementDetailBinding2 = this.binding;
                if (fragmentSettlementDetailBinding2 == null) {
                    k.a("binding");
                }
                ImageView imageView2 = fragmentSettlementDetailBinding2.bwSettlementDetailBankLogoImage;
                k.b(imageView2, "binding.bwSettlementDetailBankLogoImage");
                imageView2.setVisibility(0);
                w a2 = w.a();
                String str2 = this.iconUrl;
                if (str2 == null) {
                    k.a(SDKConstants.ICON_URL);
                }
                a2.a(str2).a((af) mpP4bBankImageTarget);
            }
        }
        String str3 = this.iconUrl;
        if (str3 != null) {
            if (str3 == null) {
                k.a(SDKConstants.ICON_URL);
            }
            if (!(str3 == null || str3.length() == 0)) {
                z = false;
            }
            if (!z) {
                FragmentSettlementDetailBinding fragmentSettlementDetailBinding3 = this.binding;
                if (fragmentSettlementDetailBinding3 == null) {
                    k.a("binding");
                }
                MpRoboTextView mpRoboTextView = fragmentSettlementDetailBinding3.bwSettlementDetailBankNameText;
                k.b(mpRoboTextView, "binding.bwSettlementDetailBankNameText");
                mpRoboTextView.setVisibility(0);
                if (this.bankNumber != null) {
                    FragmentSettlementDetailBinding fragmentSettlementDetailBinding4 = this.binding;
                    if (fragmentSettlementDetailBinding4 == null) {
                        k.a("binding");
                    }
                    MpRoboTextView mpRoboTextView2 = fragmentSettlementDetailBinding4.bwSettlementDetailBankNameText;
                    k.b(mpRoboTextView2, "binding.bwSettlementDetailBankNameText");
                    String str4 = this.bankNumber;
                    if (str4 == null) {
                        k.a("bankNumber");
                    }
                    mpRoboTextView2.setText(str4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void loadMoreSettlementItems() {
        this.mSettlementListLoading = true;
        String str = this.startDate;
        if (str == null) {
            k.a("startDate");
        }
        callSettlementDetailApi(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r6 = r6.getM2b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleM2bTransactionDetail(com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel r6) {
        /*
            r5 = this;
            r0 = 0
            r5.mSettlementListLoading = r0
            com.business.common_module.utilities.a.b r1 = r6.getWrappedData()
            com.business.common_module.utilities.a.e r1 = r1.f7357b
            if (r1 == 0) goto L_0x0078
            int[] r2 = com.business.merchant_payments.settlement.SettlementDetail.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0017
            goto L_0x0078
        L_0x0017:
            com.business.common_module.utilities.a.b r1 = r6.getWrappedData()
            T r1 = r1.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r1 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r1
            if (r1 == 0) goto L_0x004f
            com.business.merchant_payments.settlement.model.M2BModel r1 = r1.getM2b()
            if (r1 == 0) goto L_0x004f
            java.util.ArrayList r1 = r1.getOrderList()
            if (r1 == 0) goto L_0x004f
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x004d
            com.business.common_module.utilities.a.b r1 = r6.getWrappedData()
            T r1 = r1.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r1 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r1
            if (r1 == 0) goto L_0x004f
            com.business.merchant_payments.settlement.SettlementDetailAdapter r3 = r5.mAdapter
            if (r3 != 0) goto L_0x0046
            java.lang.String r4 = "mAdapter"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0046:
            r3.setM2BDetailResponse(r1)
            r5.removeProgressDialog()
            goto L_0x004f
        L_0x004d:
            r5.mIsPaginatingBillList = r0
        L_0x004f:
            com.business.common_module.utilities.a.b r6 = r6.getWrappedData()
            T r6 = r6.f7358c
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r6
            if (r6 == 0) goto L_0x0064
            com.business.merchant_payments.settlement.model.M2BModel r6 = r6.getM2b()
            if (r6 == 0) goto L_0x0064
            java.util.ArrayList r6 = r6.getOrderList()
            goto L_0x0065
        L_0x0064:
            r6 = 0
        L_0x0065:
            if (r6 == 0) goto L_0x0075
            int r6 = r6.size()
            r1 = 50
            if (r6 != r1) goto L_0x0075
            int r6 = r5.mCurrentPage
            int r6 = r6 + r2
            r5.mCurrentPage = r6
            return
        L_0x0075:
            r5.mIsPaginatingBillList = r0
            return
        L_0x0078:
            r5.handleError()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.SettlementDetail.handleM2bTransactionDetail(com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel):void");
    }

    private final void handleError() {
        String str;
        removeProgressDialog();
        if (this.mCurrentPage == 1) {
            handleGeneralError();
            return;
        }
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

    public final void initObservers() {
        LiveData<BWSettlementM2BTransactionDetailObservableModel> mSelectedSettledBillListDetail;
        c provideViewModel = provideViewModel(SettlementDetailViewModel.class, (Fragment) null);
        k.b(provideViewModel, "provideViewModel(Settlem…wModel::class.java, null)");
        SettlementDetailViewModel settlementDetailViewModel = (SettlementDetailViewModel) provideViewModel;
        this.mViewModel = settlementDetailViewModel;
        if (settlementDetailViewModel == null) {
            k.a("mViewModel");
        }
        if (!(settlementDetailViewModel == null || (mSelectedSettledBillListDetail = settlementDetailViewModel.getMSelectedSettledBillListDetail()) == null)) {
            mSelectedSettledBillListDetail.observe(this, this.BWSettlementM2BTransactionDetailObservableModel);
        }
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
        if (fragmentSettlementDetailBinding == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout = fragmentSettlementDetailBinding.clErrorLayout;
        k.b(constraintLayout, "binding.clErrorLayout");
        ((MpRoboTextView) constraintLayout.findViewById(R.id.errorRetryBtn)).setOnClickListener(new SettlementDetail$initObservers$1(this));
    }

    public final void callSettlementDetailApi(String str) {
        k.d(str, "startDate");
        showProgressDialog();
        if (i.a(getApplication())) {
            FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
            if (fragmentSettlementDetailBinding == null) {
                k.a("binding");
            }
            LinearLayout linearLayout = fragmentSettlementDetailBinding.ll;
            k.b(linearLayout, "binding.ll");
            linearLayout.setVisibility(0);
            FragmentSettlementDetailBinding fragmentSettlementDetailBinding2 = this.binding;
            if (fragmentSettlementDetailBinding2 == null) {
                k.a("binding");
            }
            ConstraintLayout constraintLayout = fragmentSettlementDetailBinding2.clErrorLayout;
            k.b(constraintLayout, "binding.clErrorLayout");
            constraintLayout.setVisibility(8);
            this.mIsPaginatingBillList = true;
            SettlementDetailViewModel settlementDetailViewModel = this.mViewModel;
            if (settlementDetailViewModel == null) {
                k.a("mViewModel");
            }
            String startDateOfTimeStamp = DateUtility.getStartDateOfTimeStamp(str);
            k.b(startDateOfTimeStamp, "DateUtility.getStartDateOfTimeStamp(startDate)");
            String endDateOfDifferentFormat = DateUtility.getEndDateOfDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
            k.b(endDateOfDifferentFormat, "DateUtility.getEndDateOf…teUtility.V2_TIME_FORMAT)");
            String str2 = this.settlementQueryType;
            if (str2 == null) {
                k.a("settlementQueryType");
            }
            settlementDetailViewModel.getSettlementBillListDetail(startDateOfTimeStamp, endDateOfDifferentFormat, str2);
            return;
        }
        this.mSettlementListLoading = false;
        removeProgressDialog();
        if (this.mCurrentPage == 1) {
            handleErrorForNoNetwork();
        } else {
            Toast.makeText(this, getString(R.string.no_internet), 0).show();
        }
    }

    private final void handleErrorForNoNetwork() {
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
        if (fragmentSettlementDetailBinding == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout = fragmentSettlementDetailBinding.clErrorLayout;
        k.b(constraintLayout, "binding.clErrorLayout");
        ((ImageView) constraintLayout.findViewById(R.id.errorImage)).setImageDrawable(b.a((Context) this, R.drawable.mp_p4b_no_internet));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding2 = this.binding;
        if (fragmentSettlementDetailBinding2 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout2 = fragmentSettlementDetailBinding2.clErrorLayout;
        k.b(constraintLayout2, "binding.clErrorLayout");
        MpRoboTextView mpRoboTextView = (MpRoboTextView) constraintLayout2.findViewById(R.id.errorTitleText);
        k.b(mpRoboTextView, "binding.clErrorLayout.errorTitleText");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        mpRoboTextView.setText(instance.getAppContext().getString(R.string.no_connection));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding3 = this.binding;
        if (fragmentSettlementDetailBinding3 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout3 = fragmentSettlementDetailBinding3.clErrorLayout;
        k.b(constraintLayout3, "binding.clErrorLayout");
        MpRoboTextView mpRoboTextView2 = (MpRoboTextView) constraintLayout3.findViewById(R.id.errorDescriptionText);
        k.b(mpRoboTextView2, "binding.clErrorLayout.errorDescriptionText");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        mpRoboTextView2.setText(instance2.getAppContext().getString(R.string.mp_label_please_check_your_internet_connection_and_try_again));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding4 = this.binding;
        if (fragmentSettlementDetailBinding4 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout4 = fragmentSettlementDetailBinding4.clErrorLayout;
        k.b(constraintLayout4, "binding.clErrorLayout");
        constraintLayout4.setVisibility(0);
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding5 = this.binding;
        if (fragmentSettlementDetailBinding5 == null) {
            k.a("binding");
        }
        LinearLayout linearLayout = fragmentSettlementDetailBinding5.ll;
        k.b(linearLayout, "binding.ll");
        linearLayout.setVisibility(4);
    }

    private final void handleGeneralError() {
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding = this.binding;
        if (fragmentSettlementDetailBinding == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout = fragmentSettlementDetailBinding.clErrorLayout;
        k.b(constraintLayout, "binding.clErrorLayout");
        ((ImageView) constraintLayout.findViewById(R.id.errorImage)).setImageDrawable(b.a((Context) this, R.drawable.mp_error_sign));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding2 = this.binding;
        if (fragmentSettlementDetailBinding2 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout2 = fragmentSettlementDetailBinding2.clErrorLayout;
        k.b(constraintLayout2, "binding.clErrorLayout");
        MpRoboTextView mpRoboTextView = (MpRoboTextView) constraintLayout2.findViewById(R.id.errorTitleText);
        k.b(mpRoboTextView, "binding.clErrorLayout.errorTitleText");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        mpRoboTextView.setText(instance.getAppContext().getString(R.string.mp_error_something_went_wrong));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding3 = this.binding;
        if (fragmentSettlementDetailBinding3 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout3 = fragmentSettlementDetailBinding3.clErrorLayout;
        k.b(constraintLayout3, "binding.clErrorLayout");
        MpRoboTextView mpRoboTextView2 = (MpRoboTextView) constraintLayout3.findViewById(R.id.errorDescriptionText);
        k.b(mpRoboTextView2, "binding.clErrorLayout.errorDescriptionText");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        mpRoboTextView2.setText(instance2.getAppContext().getString(R.string.mp_please_try_again));
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding4 = this.binding;
        if (fragmentSettlementDetailBinding4 == null) {
            k.a("binding");
        }
        ConstraintLayout constraintLayout4 = fragmentSettlementDetailBinding4.clErrorLayout;
        k.b(constraintLayout4, "binding.clErrorLayout");
        constraintLayout4.setVisibility(0);
        FragmentSettlementDetailBinding fragmentSettlementDetailBinding5 = this.binding;
        if (fragmentSettlementDetailBinding5 == null) {
            k.a("binding");
        }
        LinearLayout linearLayout = fragmentSettlementDetailBinding5.ll;
        k.b(linearLayout, "binding.ll");
        linearLayout.setVisibility(4);
    }
}
