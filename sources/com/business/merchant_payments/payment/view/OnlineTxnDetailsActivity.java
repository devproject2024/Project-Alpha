package com.business.merchant_payments.payment.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.biometrics.PaymentsP4BLockActivity;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.CommonConfirmationBottomSheet;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.GTMScreenViewsConstants;
import com.business.merchant_payments.databinding.MpTransactionDetailBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.businesswallet.OrdersItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderDetailItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;
import com.business.merchant_payments.requestmoney.EdcPrintReciept;
import com.google.android.material.snackbar.Snackbar;
import org.greenrobot.eventbus.c;

public class OnlineTxnDetailsActivity extends BaseActivity {
    public static final String CASH_WITHDRAWAL_INCENTIVE_TXN = "51051000100000000049";
    public static final String CASH_WITHDRAWAL_TXN = "51051000100000000048";
    public static final String KEY_B_WALLET_ORDER_ITEM = "key_b_wallet_order_item";
    public final int OPEN_AUTH_SCREEN_FOR_INITIATE_REFUND = 672;
    public Snackbar failureSnackBar;
    public boolean isMultipleQRCase;
    public OrdersItem mBWalletOrderItem;
    public MpTransactionDetailBinding mBinding;
    public String mScreenFrom = "";
    public int retryCount = 0;
    public OrderListItem txnItem;
    public OnlineTxnDetailsViewModel viewModel;

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 672 && i3 == -1) {
            startInitiateRefundOnAuthSuccess();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setScreenFrom();
        this.mBinding = (MpTransactionDetailBinding) f.a(this, R.layout.mp_transaction_detail);
        initUI();
        this.mBinding.setViewModel(this.viewModel);
        this.mBinding.detailsContainer.setViewModel(this.viewModel);
        setStatusBarWhiteColor(true);
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        singleInstance.pushScreenEvent(GTMScreenViewsConstants.GTMString + GTMScreenViewsConstants.TRANSACTION_DETAIL_VIEW);
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    private void setScreenFrom() {
        if (getIntent() != null) {
            this.mScreenFrom = getIntent().getStringExtra(AppConstants.SCREEN_NAME);
        }
    }

    public void initUI() {
        this.viewModel = (OnlineTxnDetailsViewModel) provideViewModel(OnlineTxnDetailsViewModel.class, (Fragment) null);
        Intent intent = getIntent();
        if (intent != null && intent.getSerializableExtra(AppConstants.TXN_OBJECT) != null) {
            OrderListItem orderListItem = (OrderListItem) intent.getSerializableExtra(AppConstants.TXN_OBJECT);
            this.txnItem = orderListItem;
            this.viewModel.setData(orderListItem);
        } else if (this.txnItem == null && intent != null && intent.getParcelableExtra("key_b_wallet_order_item") != null) {
            OrdersItem ordersItem = (OrdersItem) getIntent().getParcelableExtra("key_b_wallet_order_item");
            this.mBWalletOrderItem = ordersItem;
            this.viewModel.setData(ordersItem);
        } else if (intent != null && intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT) != null) {
            OrderListItem transformToOrderList = transformToOrderList((OfflineTransDetailObject) intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT));
            this.txnItem = transformToOrderList;
            this.viewModel.setData(transformToOrderList);
        } else if (intent != null && intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2) != null && (intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2) instanceof OrderDetail)) {
            OrderListItem transformToOrderList2 = transformToOrderList((OrderDetail) intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2));
            this.txnItem = transformToOrderList2;
            this.viewModel.setData(transformToOrderList2);
        } else if (!(intent == null || intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2) == null || !(intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2) instanceof OrderDetailV2Model))) {
            OrderListItem transformToOrderList3 = transformToOrderList((OrderDetailV2Model) intent.getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2));
            this.txnItem = transformToOrderList3;
            this.viewModel.setData(transformToOrderList3);
        }
        if (intent != null && intent.getBooleanExtra(AppConstants.IS_FROM_MULTIPLE_QR, false)) {
            this.isMultipleQRCase = intent.getBooleanExtra(AppConstants.IS_FROM_MULTIPLE_QR, false);
        }
        this.viewModel.setApiFlag();
        setObservers();
        this.mBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnlineTxnDetailsActivity.this.lambda$initUI$0$OnlineTxnDetailsActivity(view);
            }
        });
        this.mBinding.initiateRefundBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnlineTxnDetailsActivity.this.lambda$initUI$1$OnlineTxnDetailsActivity(view);
            }
        });
        this.mBinding.rlNeedHelp.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnlineTxnDetailsActivity.this.lambda$initUI$2$OnlineTxnDetailsActivity(view);
            }
        });
        this.mBinding.detailsContainer.utrText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnlineTxnDetailsActivity.this.lambda$initUI$3$OnlineTxnDetailsActivity(view);
            }
        });
        this.mBinding.detailsContainer.tvPaymentDescriptionText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnlineTxnDetailsActivity.this.lambda$initUI$4$OnlineTxnDetailsActivity(view);
            }
        });
        this.mBinding.detailsContainer.tvOrderIdText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnlineTxnDetailsActivity onlineTxnDetailsActivity = OnlineTxnDetailsActivity.this;
                onlineTxnDetailsActivity.showDialogSheet(onlineTxnDetailsActivity.getString(R.string.mp_Order_id_name), OnlineTxnDetailsActivity.this.viewModel.orderId.get());
            }
        });
        if (AppUtility.isEdcFlavour().booleanValue()) {
            this.mBinding.rlPrintReciept.setVisibility(0);
            this.mBinding.rlPrintReciept.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(OnlineTxnDetailsActivity.this, "Payment Detail Page", "Initiate Print", "");
                    EdcPrintReciept.INSTANCE.printPaymentReciept(OnlineTxnDetailsActivity.this.getApplicationContext(), OnlineTxnDetailsActivity.this.viewModel);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initUI$0$OnlineTxnDetailsActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initUI$1$OnlineTxnDetailsActivity(View view) {
        startActivityForResult(new Intent(this, PaymentsP4BLockActivity.class), 672);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Payment Detail Page", "Initiate Refund Clicked", "", "", "", this.viewModel.transactionAMount + ";" + DateUtility.getFormattedDate(this.viewModel.orderListItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd") + ";" + DateUtility.getDaysBetweenDates(DateUtility.getTimestamp(this.viewModel.orderListItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss"), System.currentTimeMillis()));
    }

    public /* synthetic */ void lambda$initUI$2$OnlineTxnDetailsActivity(View view) {
        String str;
        if (GTMDataProviderImpl.Companion.getMInstance().shouldUseCInfraNeedHelp()) {
            str = "paytmba://home-app/support|business-app/h/my-account/help";
        } else {
            str = "paytmba://business-app/ump-web?url=" + (GTMDataProviderImpl.Companion.getMInstance().getNeedHelpNavEngineLevelsUrl() + "&view=ACQUIRING&orderId=" + this.viewModel.mBizOrderId.get());
        }
        PaymentsConfig.getInstance().getDeepLinkUtils().a(this, str);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Payment Detail Page", "Need Help Clicked", "", "", "", this.viewModel.transactionAMount + ";" + DateUtility.getFormattedDate(this.viewModel.orderListItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd") + ";" + DateUtility.getDaysBetweenDates(DateUtility.getTimestamp(this.viewModel.orderListItem.getOrderCreatedTime(), "yyyy-MM-dd HH:mm:ss"), System.currentTimeMillis()));
    }

    public /* synthetic */ void lambda$initUI$3$OnlineTxnDetailsActivity(View view) {
        showDialogSheet("Reference No.", AppUtility.insertCharacterForEveryNDistance(this.viewModel.utr.get(), 4, ' '));
    }

    public /* synthetic */ void lambda$initUI$4$OnlineTxnDetailsActivity(View view) {
        showDialogSheet(getResources().getString(R.string.mp_rm_description), this.viewModel.comment.get());
    }

    private void setMaxRefundData() {
        T t;
        b value = this.viewModel.getmObservableV2Response().getValue();
        if (value != null && (t = value.f7358c) != null && ((OrderDetailV2Model) t).getAdditionalInfo() != null) {
            boolean booleanValue = ((OrderDetailV2Model) value.f7358c).getAdditionalInfo().getRefundAllowed().booleanValue();
            this.txnItem.setIsRefundAllowed(booleanValue);
            if (booleanValue && ((OrderDetailV2Model) value.f7358c).getMaxRefundableAmt() != null) {
                this.txnItem.setMaxRefund(((OrderDetailV2Model) value.f7358c).getMaxRefundableAmt().getValue());
            }
        }
    }

    private void showSnackBar(String str) {
        Snackbar snackbar = this.failureSnackBar;
        if (snackbar != null) {
            snackbar.d();
        }
        if (this.retryCount > 0) {
            this.failureSnackBar = Snackbar.a((View) this.mBinding.coordinatorLayout, (CharSequence) getApplicationContext().getString(R.string.mp_something_wrong_try_later), -2);
        } else {
            this.failureSnackBar = Snackbar.a((View) this.mBinding.coordinatorLayout, (CharSequence) str, -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener() {
                public final void onClick(View view) {
                    OnlineTxnDetailsActivity.this.lambda$showSnackBar$5$OnlineTxnDetailsActivity(view);
                }
            });
        }
        this.failureSnackBar.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.failureSnackBar.b();
        b2.setBackgroundColor(androidx.core.content.b.c(this, R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.failureSnackBar.c();
    }

    public /* synthetic */ void lambda$showSnackBar$5$OnlineTxnDetailsActivity(View view) {
        this.failureSnackBar.d();
        this.viewModel.setApiFlag();
        this.viewModel.setProgress(true);
        this.retryCount++;
    }

    private OrderListItem transformToOrderList(OrderDetail orderDetail) {
        double d2;
        OrderListItem orderListItem = new OrderListItem();
        orderListItem.setmTxnId(orderDetail.getBizOrderId());
        orderListItem.setmOrderId(orderDetail.getMerchantTransId());
        orderListItem.setmOrderCreatedTime(DateUtility.getFormattedDate(orderDetail.getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss"));
        orderListItem.setmUserPhoneNo(orderDetail.getOppositePhone());
        orderListItem.setmUserEmail(orderDetail.getOppositeEmail());
        orderListItem.setCustomerEmailId(orderDetail.getOppositeEmail());
        orderListItem.setOrderStatus(orderDetail.getOrderStatus());
        orderListItem.setUserVPA(orderDetail.getMUpiId());
        if (orderDetail.getCashPosIncentiveAmount() != null && !orderDetail.getCashPosIncentiveAmount().getValue().isEmpty()) {
            orderListItem.setIncentiveAmt(orderDetail.getCashPosIncentiveAmount().getValue());
        }
        if (orderDetail.getProductCode() != null && !orderDetail.getProductCode().isEmpty()) {
            orderListItem.setProductCode(orderDetail.getProductCode());
        }
        if (getIntent() == null || getIntent().getStringExtra(AppConstants.NET_AMOUNT) == null) {
            d2 = Double.parseDouble(orderDetail.getPayMoneyAmount().getValue().replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, "")) / 100.0d;
        } else {
            d2 = Double.parseDouble(getIntent().getStringExtra(AppConstants.NET_AMOUNT).replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, ""));
        }
        orderListItem.setmTxnAmt(String.valueOf(d2));
        orderListItem.setPayMethod(orderDetail.getMPayMode());
        return orderListItem;
    }

    private OrderListItem transformToOrderList(OfflineTransDetailObject offlineTransDetailObject) {
        OrderListItem orderListItem = new OrderListItem();
        orderListItem.setmTxnId(offlineTransDetailObject.getmTransactionID());
        orderListItem.setmOrderId(offlineTransDetailObject.getmMerchantOrderID());
        orderListItem.setmOrderCreatedTime(DateUtility.getFormattedDate(offlineTransDetailObject.getmTransactionDate(), "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss"));
        orderListItem.setmUserPhoneNo(offlineTransDetailObject.getmPayerPhoneNumber());
        orderListItem.setmTxnAmt(offlineTransDetailObject.getmTransactionAmmount());
        return orderListItem;
    }

    private void setObservers() {
        this.viewModel.snackBarCmd().observe(this, new z() {
            public final void onChanged(Object obj) {
                OnlineTxnDetailsActivity.this.lambda$setObservers$6$OnlineTxnDetailsActivity((String) obj);
            }
        });
        this.viewModel.getmObservalbleResponse().observe(this, new z() {
            public final void onChanged(Object obj) {
                OnlineTxnDetailsActivity.this.lambda$setObservers$7$OnlineTxnDetailsActivity((b) obj);
            }
        });
        this.viewModel.getmObservableV2Response().observe(this, new z() {
            public final void onChanged(Object obj) {
                OnlineTxnDetailsActivity.this.lambda$setObservers$8$OnlineTxnDetailsActivity((b) obj);
            }
        });
        this.viewModel.getmObservableOfflineResponse().observe(this, new z() {
            public final void onChanged(Object obj) {
                OnlineTxnDetailsActivity.this.lambda$setObservers$9$OnlineTxnDetailsActivity((b) obj);
            }
        });
        this.viewModel.setStartToEndForBarrier.observe(this, new z() {
            public final void onChanged(Object obj) {
                OnlineTxnDetailsActivity.this.lambda$setObservers$10$OnlineTxnDetailsActivity((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setObservers$6$OnlineTxnDetailsActivity(String str) {
        if (!TextUtils.isEmpty(str)) {
            showSnackBar(str);
        }
    }

    public /* synthetic */ void lambda$setObservers$7$OnlineTxnDetailsActivity(b bVar) {
        if (bVar != null) {
            int i2 = 0;
            this.viewModel.setProgress(false);
            OrderDetailItem orderDetailItem = (OrderDetailItem) bVar.f7358c;
            if (orderDetailItem != null) {
                this.viewModel.setOrderData(orderDetailItem);
                TextView textView = this.mBinding.initiateRefundBtn;
                if (this.viewModel.isRefundNeededForNonMigrated.get()) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r5.getAdditionalInfo().getRefundAllowed().booleanValue() == false) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$setObservers$8$OnlineTxnDetailsActivity(com.business.common_module.utilities.a.b r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r1 = 0
            if (r5 == 0) goto L_0x00c4
            com.business.common_module.utilities.a.e r2 = r5.f7357b
            com.business.common_module.utilities.a.e r3 = com.business.common_module.utilities.a.e.SUCCESS
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c4
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r2 = r4.viewModel
            r2.setProgress(r1)
            T r5 = r5.f7358c
            com.business.merchant_payments.model.v2.OrderDetailV2Model r5 = (com.business.merchant_payments.model.v2.OrderDetailV2Model) r5
            if (r5 == 0) goto L_0x00b6
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r2 = r4.viewModel
            r2.setV2Object(r5)
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            if (r2 == 0) goto L_0x0050
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.Boolean r2 = r2.getRefundAllowed()
            if (r2 == 0) goto L_0x0050
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r2 = r4.viewModel
            androidx.databinding.ObservableBoolean r2 = r2.isRefundable
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r3 = r5.getAdditionalInfo()
            java.lang.Boolean r3 = r3.getRefundAllowed()
            boolean r3 = r3.booleanValue()
            r2.set(r3)
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.Boolean r2 = r2.getRefundAllowed()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x005d
        L_0x0050:
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r2 = r4.mBinding
            android.widget.TextView r2 = r2.initiateRefundBtn
            int r3 = com.business.merchant_payments.R.color.color_909090
            int r3 = androidx.core.content.b.c(r4, r3)
            r2.setTextColor(r3)
        L_0x005d:
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            if (r2 == 0) goto L_0x00df
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.String r2 = r2.getPayMethod()
            if (r2 == 0) goto L_0x00df
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.String r2 = r2.getPayMethod()
            java.lang.String r3 = "EMI"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "EMI CC"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "EMI DC"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "DEBIT CARD"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "CREDIT CARD"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "CASH WITHDRAWAL INCENTIVE"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ad
            java.lang.String r3 = "CASH WITHDRAWAL"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00df
        L_0x00ad:
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r5 = r5.getAdditionalInfo()
            java.lang.String r5 = r5.getIssuingBankName()
            goto L_0x00e0
        L_0x00b6:
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r5 = r4.mBinding
            android.widget.TextView r5 = r5.initiateRefundBtn
            int r2 = com.business.merchant_payments.R.color.color_909090
            int r2 = androidx.core.content.b.c(r4, r2)
            r5.setTextColor(r2)
            goto L_0x00df
        L_0x00c4:
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r5 = r4.viewModel
            r5.setProgress(r1)
            int r5 = com.business.merchant_payments.R.string.mp_something_went_wrong
            java.lang.String r5 = r4.getString(r5)
            r4.showSnackBar(r5)
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r5 = r4.mBinding
            android.widget.TextView r5 = r5.initiateRefundBtn
            int r2 = com.business.merchant_payments.R.color.color_909090
            int r2 = androidx.core.content.b.c(r4, r2)
            r5.setTextColor(r2)
        L_0x00df:
            r5 = r0
        L_0x00e0:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L_0x0127
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r0 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r0 = r0.detailsContainer
            android.widget.TextView r0 = r0.profileLabelBankName
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r0 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r0
            r1 = -2
            r0.height = r1
            r1 = 16
            int r1 = com.business.merchant_payments.common.utility.AppUtility.getValueInDp(r4, r1)
            r0.topMargin = r1
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r1 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r1 = r1.detailsContainer
            android.widget.TextView r1 = r1.profileLabelBankName
            r1.setLayoutParams(r0)
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r0 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r0 = r0.detailsContainer
            android.widget.TextView r0 = r0.profileLabelBankName
            com.business.merchant_payments.PaymentsConfig r1 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.content.Context r1 = r1.getAppContext()
            int r2 = com.business.merchant_payments.R.string.mp_bank_name
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r0 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r0 = r0.detailsContainer
            android.widget.TextView r0 = r0.dataProfileBankName
            r0.setText(r5)
            return
        L_0x0127:
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r5 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r5 = r5.detailsContainer
            android.widget.TextView r5 = r5.profileLabelBankName
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5
            r5.height = r1
            r5.topMargin = r1
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r1 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r1 = r1.detailsContainer
            android.widget.TextView r1 = r1.profileLabelBankName
            r1.setLayoutParams(r5)
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r5 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r5 = r5.detailsContainer
            android.widget.TextView r5 = r5.profileLabelBankName
            r5.setText(r0)
            com.business.merchant_payments.databinding.MpTransactionDetailBinding r5 = r4.mBinding
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r5 = r5.detailsContainer
            android.widget.TextView r5 = r5.dataProfileBankName
            r5.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.view.OnlineTxnDetailsActivity.lambda$setObservers$8$OnlineTxnDetailsActivity(com.business.common_module.utilities.a.b):void");
    }

    public /* synthetic */ void lambda$setObservers$9$OnlineTxnDetailsActivity(b bVar) {
        if (bVar != null) {
            this.viewModel.setProgress(false);
            OfflineTransDetailObject offlineTransDetailObject = (OfflineTransDetailObject) bVar.f7358c;
            if (offlineTransDetailObject != null) {
                this.viewModel.setOfflineObject(offlineTransDetailObject);
            }
        }
    }

    public /* synthetic */ void lambda$setObservers$10$OnlineTxnDetailsActivity(Boolean bool) {
        this.mBinding.detailsContainer.ivPaymode.setMaxWidth(0);
        this.mBinding.detailsContainer.ivPaymode.getLayoutParams().width = 0;
        this.mBinding.detailsContainer.ivPaymode.requestLayout();
    }

    public void showDialogSheet(String str, String str2) {
        CommonConfirmationBottomSheet instance = CommonConfirmationBottomSheet.Companion.getInstance(str, str2, (String) null, (Integer) null, (Integer) null);
        instance.setSubHeadingFontFace(Typeface.DEFAULT_BOLD);
        instance.setSubHeadingFontColor(Integer.valueOf(androidx.core.content.b.c(this, R.color.black)));
        instance.show(getSupportFragmentManager(), "reference_number");
    }

    private void startInitiateRefundOnAuthSuccess() {
        GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this, "Payments", "select transaction", "Initiate_Refund");
        Intent intent = new Intent(this, InitiateRefundActivity.class);
        if (!TextUtils.isEmpty(this.mScreenFrom)) {
            intent.putExtra(AppConstants.SCREEN_NAME, this.mScreenFrom);
        }
        intent.putExtra(AppConstants.IS_PCF_TRANSACTION, this.viewModel.isPCFTransaction.get());
        setMaxRefundData();
        intent.putExtra(AppConstants.TRANSACTION_OBJECT, this.txnItem);
        intent.putExtra(AppConstants.IS_FROM_MULTIPLE_QR, this.isMultipleQRCase);
        startActivity(intent);
    }

    private OrderListItem transformToOrderList(OrderDetailV2Model orderDetailV2Model) {
        double d2;
        OrderListItem orderListItem = new OrderListItem();
        orderListItem.setmTxnId(orderDetailV2Model.getBizOrderId());
        orderListItem.setmOrderId(orderDetailV2Model.getMerchantTransId());
        orderListItem.setmOrderCreatedTime(DateUtility.getFormattedDate(orderDetailV2Model.getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss"));
        orderListItem.setmUserPhoneNo(orderDetailV2Model.getOppositePhone());
        orderListItem.setmUserEmail(orderDetailV2Model.getOppositeEmail());
        orderListItem.setCustomerEmailId(orderDetailV2Model.getOppositeEmail());
        orderListItem.setOrderStatus(orderDetailV2Model.getOrderStatus());
        orderListItem.setUserVPA(orderDetailV2Model.getmUpiId());
        if (orderDetailV2Model.getCashPosIncentiveAmount() != null && !orderDetailV2Model.getCashPosIncentiveAmount().getValue().isEmpty()) {
            orderListItem.setIncentiveAmt(orderDetailV2Model.getCashPosIncentiveAmount().getValue());
        }
        if (orderDetailV2Model.getProductCode() != null && !orderDetailV2Model.getProductCode().isEmpty()) {
            orderListItem.setProductCode(orderDetailV2Model.getProductCode());
        }
        if (getIntent() == null || getIntent().getStringExtra(AppConstants.NET_AMOUNT) == null) {
            d2 = Double.parseDouble(orderDetailV2Model.getPayMoneyAmount().getValue().replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, "")) / 100.0d;
        } else {
            d2 = Double.parseDouble(getIntent().getStringExtra(AppConstants.NET_AMOUNT).replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA, ""));
        }
        orderListItem.setmTxnAmt(String.valueOf(d2));
        orderListItem.setPayMethod(orderDetailV2Model.getmPayMode());
        return orderListItem;
    }
}
