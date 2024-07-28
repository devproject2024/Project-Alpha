package com.business.merchant_payments.payment.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.businesswallet.repository.BWalletPassbookRepository;
import com.business.merchant_payments.businesswallet.util.BWalletUtil;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.CommonConfirmationBottomSheet;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding;
import com.business.merchant_payments.event.NoNetworkEvent;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.businesswallet.BWalletOrderDetails;
import com.business.merchant_payments.model.businesswallet.OrdersItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.nonetwork.NoNetworkViewModel;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;
import com.business.merchant_payments.requestmoney.EdcPrintReciept;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class RefundDetailsActivity extends BaseActivity {
    public static final String BUSINESS_WALLET_NET_ERROR = "business_wallet_net_error";
    public static final String KEY_B_WALLET_ORDER_ITEM = "key_b_wallet_order_item";
    public Snackbar failureSnackBar;
    public boolean isCancel = false;
    public OrdersItem mBusinessWalletOrderItem;
    public OfflineTransDetailObject mOfflineTransDetailObject;
    public OrderDetail orderDetailV2Model;
    public OrderListItem orderListItem;
    public MpRefundDetailsViewNewBinding refundDetailsBinding;
    public RefundDetailsViewModel refundDetailsViewModel;

    private void initToolBar() {
    }

    public void onCreate(Bundle bundle) {
        Trace a2 = a.a("RefundDetailsActivity-onCreate");
        super.onCreate(bundle);
        initDataBinding();
        setStatusBarWhiteColor(true);
        this.refundDetailsBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RefundDetailsActivity.this.lambda$onCreate$0$RefundDetailsActivity(view);
            }
        });
        this.mOfflineTransDetailObject = (OfflineTransDetailObject) getIntent().getSerializableExtra(AppConstants.TRANSACTION_OBJECT);
        if (getIntent().getSerializableExtra(AppConstants.TXN_OBJECT) != null) {
            this.orderListItem = (OrderListItem) getIntent().getSerializableExtra(AppConstants.TXN_OBJECT);
        }
        if (getIntent().getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2) != null) {
            this.orderDetailV2Model = (OrderDetail) getIntent().getSerializableExtra(AppConstants.TRANSACTION_OBJECT_V2);
        }
        if (this.mOfflineTransDetailObject == null && this.orderListItem == null && this.orderDetailV2Model == null) {
            this.mBusinessWalletOrderItem = (OrdersItem) getIntent().getParcelableExtra("key_b_wallet_order_item");
            this.isCancel = getIntent().getBooleanExtra(AppConstants.IS_CANCEL, false);
            loadBusinessWalletOrderDetails();
        } else if (this.mBusinessWalletOrderItem == null && this.orderDetailV2Model == null && this.mOfflineTransDetailObject == null) {
            this.isCancel = getIntent().getBooleanExtra(AppConstants.IS_CANCEL, false);
            loadOrderDetails();
        } else if (this.mBusinessWalletOrderItem == null && this.orderListItem == null && this.mOfflineTransDetailObject == null) {
            convertV2_AndLoadDetails();
        } else {
            showRefundUi();
        }
        observeLiveData();
        a2.stop();
    }

    public /* synthetic */ void lambda$onCreate$0$RefundDetailsActivity(View view) {
        finish();
    }

    private void observeLiveData() {
        this.refundDetailsViewModel.snackBarCmd().observe(this, new z() {
            public final void onChanged(Object obj) {
                RefundDetailsActivity.this.lambda$observeLiveData$1$RefundDetailsActivity((String) obj);
            }
        });
        this.refundDetailsViewModel.getmObservableV2ResponseRefund().observe(this, new z() {
            public final void onChanged(Object obj) {
                RefundDetailsActivity.this.lambda$observeLiveData$2$RefundDetailsActivity((b) obj);
            }
        });
        this.refundDetailsViewModel.getObservableV2ResponseAcquiring().observe(this, new z() {
            public final void onChanged(Object obj) {
                RefundDetailsActivity.this.lambda$observeLiveData$3$RefundDetailsActivity((b) obj);
            }
        });
        this.refundDetailsViewModel.getObservableV2ResponsePayment().observe(this, new z() {
            public final void onChanged(Object obj) {
                RefundDetailsActivity.this.lambda$observeLiveData$4$RefundDetailsActivity((b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$observeLiveData$1$RefundDetailsActivity(String str) {
        if (!TextUtils.isEmpty(str)) {
            showSnackBar(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$observeLiveData$2$RefundDetailsActivity(com.business.common_module.utilities.a.b r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x005e
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r2 = r4.refundDetailsViewModel
            r2.setProgress(r0)
            T r5 = r5.f7358c
            com.business.merchant_payments.model.v2.OrderDetailV2Model r5 = (com.business.merchant_payments.model.v2.OrderDetailV2Model) r5
            if (r5 == 0) goto L_0x005e
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r2 = r4.refundDetailsViewModel
            r2.setV2RefundObject(r5)
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            if (r2 == 0) goto L_0x005e
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.String r2 = r2.getPayMethod()
            if (r2 == 0) goto L_0x005e
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r2 = r5.getAdditionalInfo()
            java.lang.String r2 = r2.getPayMethod()
            java.lang.String r3 = "EMI"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0055
            java.lang.String r3 = "EMI CC"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0055
            java.lang.String r3 = "EMI DC"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0055
            java.lang.String r3 = "DEBIT CARD"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0055
            java.lang.String r3 = "CREDIT CARD"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x005e
        L_0x0055:
            com.business.merchant_payments.model.v2.OrderDetailV2Model$AdditionalInfo r5 = r5.getAdditionalInfo()
            java.lang.String r5 = r5.getIssuingBankName()
            goto L_0x005f
        L_0x005e:
            r5 = r1
        L_0x005f:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L_0x00a6
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r0 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r0.refundDetailSubview
            android.widget.TextView r0 = r0.profileLabelBankName
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r0 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r0
            r1 = 16
            int r1 = com.business.merchant_payments.common.utility.AppUtility.getValueInDp(r4, r1)
            r0.topMargin = r1
            r1 = -2
            r0.height = r1
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r1 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r1 = r1.refundDetailSubview
            android.widget.TextView r1 = r1.profileLabelBankName
            r1.setLayoutParams(r0)
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r0 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r0.refundDetailSubview
            android.widget.TextView r0 = r0.profileLabelBankName
            com.business.merchant_payments.PaymentsConfig r1 = com.business.merchant_payments.PaymentsConfig.getInstance()
            android.content.Context r1 = r1.getAppContext()
            int r2 = com.business.merchant_payments.R.string.mp_bank_name
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r0 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r0.refundDetailSubview
            android.widget.TextView r0 = r0.dataProfileBankName
            r0.setText(r5)
            return
        L_0x00a6:
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r5 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r5 = r5.refundDetailSubview
            android.widget.TextView r5 = r5.profileLabelBankName
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5
            r5.topMargin = r0
            r5.height = r0
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r0 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r0.refundDetailSubview
            android.widget.TextView r0 = r0.profileLabelBankName
            r0.setLayoutParams(r5)
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r5 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r5 = r5.refundDetailSubview
            android.widget.TextView r5 = r5.profileLabelBankName
            r5.setText(r1)
            com.business.merchant_payments.databinding.MpRefundDetailsViewNewBinding r5 = r4.refundDetailsBinding
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r5 = r5.refundDetailSubview
            android.widget.TextView r5 = r5.dataProfileBankName
            r5.setText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.view.RefundDetailsActivity.lambda$observeLiveData$2$RefundDetailsActivity(com.business.common_module.utilities.a.b):void");
    }

    public /* synthetic */ void lambda$observeLiveData$3$RefundDetailsActivity(b bVar) {
        if (bVar != null) {
            this.refundDetailsViewModel.setProgress(false);
            OrderDetailV2Model orderDetailV2Model2 = (OrderDetailV2Model) bVar.f7358c;
            if (orderDetailV2Model2 != null) {
                this.refundDetailsViewModel.setV2AcquiringObject(orderDetailV2Model2);
            }
        }
    }

    public /* synthetic */ void lambda$observeLiveData$4$RefundDetailsActivity(b bVar) {
        this.refundDetailsViewModel.setProgress(false);
        if (bVar != null) {
            printEdcReciept((OrderDetailV2Model) bVar.f7358c);
        } else {
            printEdcReciept((OrderDetailV2Model) null);
        }
    }

    private void printEdcReciept(OrderDetailV2Model orderDetailV2Model2) {
        EdcPrintReciept.INSTANCE.printRefundReceipt(getApplicationContext(), this.refundDetailsViewModel, orderDetailV2Model2);
    }

    private void showSnackBar(String str) {
        Snackbar snackbar = this.failureSnackBar;
        if (snackbar != null) {
            snackbar.d();
        }
        Snackbar a2 = Snackbar.a((View) this.refundDetailsBinding.coordinatorLayout, (CharSequence) str, -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                RefundDetailsActivity.this.lambda$showSnackBar$5$RefundDetailsActivity(view);
            }
        });
        this.failureSnackBar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.failureSnackBar.b();
        b2.setBackgroundColor(androidx.core.content.b.c(this, R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.failureSnackBar.c();
    }

    public /* synthetic */ void lambda$showSnackBar$5$RefundDetailsActivity(View view) {
        this.failureSnackBar.d();
        this.refundDetailsViewModel.callRefundDetails();
    }

    private void convertV2_AndLoadDetails() {
        String str;
        this.mOfflineTransDetailObject = new OfflineTransDetailObject();
        if (this.orderDetailV2Model != null) {
            if (getIntent() == null || getIntent().getStringExtra(AppConstants.NET_AMOUNT) == null) {
                str = String.valueOf(Double.parseDouble(this.orderDetailV2Model.getPayMoneyAmount().getValue()) / 100.0d);
            } else {
                str = getIntent().getStringExtra(AppConstants.NET_AMOUNT);
            }
            this.mOfflineTransDetailObject.setmTransactionAmmount(str);
            if (!TextUtils.isEmpty(this.orderDetailV2Model.getOrderCreatedTime())) {
                this.mOfflineTransDetailObject.setmTransactionDate(DateUtility.getFormattedDate(this.orderDetailV2Model.getOrderCreatedTime().split("\\+")[0], "yyyy-MM-dd'T'HH:mm:ss", "dd/MM/yyyy HH:mm:ss"));
            }
            this.mOfflineTransDetailObject.setmTransactionID(this.orderDetailV2Model.getBizOrderId());
            if (!TextUtils.isEmpty(this.orderDetailV2Model.getOppositePhone())) {
                this.mOfflineTransDetailObject.setmUserPhoneNo(this.orderDetailV2Model.getOppositePhone());
            }
            this.mOfflineTransDetailObject.setUserName(this.orderDetailV2Model.getOppositeNickname());
            if (!TextUtils.isEmpty(this.orderDetailV2Model.getMUpiId())) {
                this.mOfflineTransDetailObject.setUserVPA(this.orderDetailV2Model.getMUpiId());
            }
            if (!TextUtils.isEmpty(this.orderDetailV2Model.getMMaskedCardNo())) {
                this.mOfflineTransDetailObject.setMaskedCardNo(this.orderDetailV2Model.getMMaskedCardNo());
            }
            if (!TextUtils.isEmpty(this.orderDetailV2Model.getMPayMode())) {
                this.mOfflineTransDetailObject.setmPaymentMode(this.orderDetailV2Model.getMPayMode());
            }
            this.mOfflineTransDetailObject.setmMerchantOrderID(this.orderDetailV2Model.getMerchantTransId());
            this.mOfflineTransDetailObject.setEmail(this.orderDetailV2Model.getOppositeEmail());
        }
        showRefundUi();
    }

    private void loadOrderDetails() {
        OfflineTransDetailObject offlineTransDetailObject = new OfflineTransDetailObject();
        this.mOfflineTransDetailObject = offlineTransDetailObject;
        OrderListItem orderListItem2 = this.orderListItem;
        if (orderListItem2 != null) {
            offlineTransDetailObject.setmTransactionAmmount(orderListItem2.getTxnAmt());
            this.mOfflineTransDetailObject.setmTransactionDate(this.orderListItem.getOrderCreatedTime());
            this.mOfflineTransDetailObject.setmTransactionID(this.orderListItem.getTxnId());
            this.mOfflineTransDetailObject.setmUserPhoneNo(this.orderListItem.getUserPhoneNo());
            this.mOfflineTransDetailObject.setUserName(this.orderListItem.getUserName());
            this.mOfflineTransDetailObject.setUserVPA(this.orderListItem.getUserVPA());
            this.mOfflineTransDetailObject.setMaskedCardNo(this.orderListItem.getMaskedCardNo());
            this.mOfflineTransDetailObject.setPayMethod(this.orderListItem.getPayMethod());
            this.mOfflineTransDetailObject.setmMerchantOrderID(this.orderListItem.getOrderId());
            this.mOfflineTransDetailObject.setEmail(this.orderListItem.getUserEmail());
            this.mOfflineTransDetailObject.setmCustID(this.orderListItem.getCustId());
        }
        showRefundUi();
    }

    private void loadBusinessWalletOrderDetails() {
        new NoNetworkViewModel("business_wallet_net_error");
        if (i.a(PaymentsConfig.getInstance().getApplication())) {
            OrdersItem ordersItem = this.mBusinessWalletOrderItem;
            if (ordersItem == null || TextUtils.isEmpty(ordersItem.getTxnId())) {
                throw new IllegalStateException("mBWalletOrderItem can't be passed null");
            }
            BWalletPassbookRepository.Companion.getInstance().loadOrderDetails(this.mBusinessWalletOrderItem.getTxnId()).observe(this, new z() {
                public final void onChanged(Object obj) {
                    RefundDetailsActivity.this.handleBusinessOrderDetailsResponse((b) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleBusinessOrderDetailsResponse(b<BWalletOrderDetails> bVar) {
        e eVar;
        T t;
        if (bVar == null || (eVar = bVar.f7357b) == e.ERROR || eVar == e.FAILURE || (t = bVar.f7358c) == null) {
            ErrorUtil.handleAPIError("business_wallet_net_error", "", bVar);
            return;
        }
        try {
            BWalletOrderDetails bWalletOrderDetails = (BWalletOrderDetails) t;
            if ((TextUtils.isEmpty(bWalletOrderDetails.getErrorMessage()) || Integer.parseInt(bWalletOrderDetails.getResultCode()) == 0) && bWalletOrderDetails.getOrderDetail() != null) {
                com.business.merchant_payments.model.businesswallet.OrderDetail orderDetail = bWalletOrderDetails.getOrderDetail();
                if (TextUtils.isEmpty(orderDetail.getPayMethod()) && !TextUtils.isEmpty(this.mBusinessWalletOrderItem.getPayMethod())) {
                    orderDetail.setPayMethod(this.mBusinessWalletOrderItem.getPayMethod());
                }
                OfflineTransDetailObject transformWalletOrder = BWalletUtil.INSTANCE.transformWalletOrder(orderDetail);
                this.mOfflineTransDetailObject = transformWalletOrder;
                if (transformWalletOrder == null) {
                    Toast.makeText(this, getString(R.string.mp_error_inconvenience_msg), 1).show();
                    return;
                }
                this.mOfflineTransDetailObject.setIsSettled(TextUtils.isEmpty(this.mBusinessWalletOrderItem.getReconId()) ? "0" : "1");
                this.mOfflineTransDetailObject.setmUTRNumber(this.mBusinessWalletOrderItem.getReconId());
                showRefundUi();
                return;
            }
            Toast.makeText(this, getString(R.string.mp_error_inconvenience_msg), 1).show();
        } catch (NumberFormatException e2) {
            LogUtility.printStackTrace(e2);
            Toast.makeText(this, getString(R.string.mp_error_inconvenience_msg), 1).show();
        }
    }

    private void initDataBinding() {
        MpRefundDetailsViewNewBinding mpRefundDetailsViewNewBinding = (MpRefundDetailsViewNewBinding) f.a(this, R.layout.mp_refund_details_view_new);
        this.refundDetailsBinding = mpRefundDetailsViewNewBinding;
        mpRefundDetailsViewNewBinding.refundDetailSubview.tvPaymentDescriptionText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RefundDetailsActivity.this.lambda$initDataBinding$6$RefundDetailsActivity(view);
            }
        });
        initToolBar();
        this.refundDetailsBinding.refundDetailSubview.tvOrderIdText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RefundDetailsActivity refundDetailsActivity = RefundDetailsActivity.this;
                refundDetailsActivity.showDialogSheet(refundDetailsActivity.getResources().getString(R.string.mp_Order_id_name), RefundDetailsActivity.this.refundDetailsViewModel.getOrderId());
            }
        });
        this.refundDetailsBinding.rlNeedHelp.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RefundDetailsActivity.this.lambda$initDataBinding$7$RefundDetailsActivity(view);
            }
        });
        if (AppUtility.isEdcFlavour().booleanValue()) {
            this.refundDetailsBinding.rlPrintReciept.setVisibility(0);
            this.refundDetailsBinding.rlPrintReciept.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(RefundDetailsActivity.this, "Refund Detail Page", "Initiate Print", "");
                    RefundDetailsActivity.this.refundDetailsViewModel.makePaymentAmtCall(RefundDetailsActivity.this.orderDetailV2Model.getReferenceBizOrderId());
                }
            });
        }
    }

    public /* synthetic */ void lambda$initDataBinding$6$RefundDetailsActivity(View view) {
        showDialogSheet(getResources().getString(R.string.mp_rm_description), this.refundDetailsViewModel.comment.get());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = r3.mOfflineTransDetailObject;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$initDataBinding$7$RefundDetailsActivity(android.view.View r3) {
        /*
            r2 = this;
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r3 = r2.refundDetailsViewModel
            if (r3 == 0) goto L_0x001b
            com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject r3 = r3.mOfflineTransDetailObject
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r3.getmTransactionID()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x001b
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r3 = r2.refundDetailsViewModel
            com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject r3 = r3.mOfflineTransDetailObject
            java.lang.String r3 = r3.getmTransactionID()
            goto L_0x001d
        L_0x001b:
            java.lang.String r3 = ""
        L_0x001d:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r0 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r0 = r0.getMInstance()
            boolean r0 = r0.shouldUseCInfraNeedHelp()
            if (r0 == 0) goto L_0x002c
            java.lang.String r3 = "paytmba://home-app/support|business-app/h/my-account/help"
            goto L_0x0058
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r1 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r1 = r1.getMInstance()
            java.lang.String r1 = r1.getNeedHelpNavEngineLevelsUrl()
            r0.append(r1)
            java.lang.String r1 = "&view=ACQUIRING&orderId="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "paytmba://business-app/ump-web?url="
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x0058:
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            com.business.common_module.b.c r0 = r0.getDeepLinkUtils()
            r0.a(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.view.RefundDetailsActivity.lambda$initDataBinding$7$RefundDetailsActivity(android.view.View):void");
    }

    private void showRefundUi() {
        RefundDetailsViewModel refundDetailsViewModel2 = new RefundDetailsViewModel(this, this.mOfflineTransDetailObject, this.isCancel);
        this.refundDetailsViewModel = refundDetailsViewModel2;
        this.refundDetailsBinding.setRefundDetailsViewModel(refundDetailsViewModel2);
        this.refundDetailsBinding.refundDetailSubview.setViewModel(this.refundDetailsViewModel);
    }

    @j(a = ThreadMode.MAIN)
    public void onNoNetwork(NoNetworkEvent noNetworkEvent) {
        if (this.refundDetailsViewModel != null) {
            String clickType = noNetworkEvent.getClickType();
            String clickedFrom = noNetworkEvent.getClickedFrom();
            LogUtility.d("CLICKEDTYPE", "---------- CLICKED TYPE -------------".concat(String.valueOf(clickType)));
            if (clickType != null && clickedFrom != null && clickedFrom.equalsIgnoreCase("REFUNDDETAILS")) {
                if (clickType.equals(AppConstants.NETWORK_RETRY_CLICK)) {
                    this.refundDetailsViewModel.inclVisibility.set(false);
                    this.refundDetailsViewModel.callRefundDetails();
                    return;
                }
                this.refundDetailsViewModel.inclVisibility.set(false);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void showDialogSheet(String str, String str2) {
        CommonConfirmationBottomSheet instance = CommonConfirmationBottomSheet.Companion.getInstance(str, str2, (String) null, (Integer) null, (Integer) null);
        instance.setSubHeadingFontFace(Typeface.DEFAULT_BOLD);
        instance.setSubHeadingFontColor(Integer.valueOf(androidx.core.content.b.c(this, R.color.black)));
        instance.show(getSupportFragmentManager(), "reference_number");
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        c.a().b(this);
        super.onStop();
    }

    @j
    public void onRetry(com.business.common_module.events.b bVar) {
        if ("business_wallet_net_error".equalsIgnoreCase(bVar.f7341a)) {
            loadBusinessWalletOrderDetails();
        }
    }
}
