package com.business.merchant_payments.payment.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.b;
import androidx.databinding.f;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.CommonConfirmationBottomSheet;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.databinding.MpRefundInitiatedNewBinding;
import com.business.merchant_payments.model.initiaterefundmodel.InitiateRefundResponseModel;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.payment.viewmodel.RefundInitiatedViewModel;
import com.business.merchant_payments.utility.MPConstants;
import org.greenrobot.eventbus.c;

public class RefundInitiatedActivity extends BaseActivity {
    public boolean isMultipleQRCase;
    public String mAmount;
    public String mComingFromScreen = "";
    public String mDate;
    public Boolean mStatus;
    public OrderListItem mTransDetails;
    public InitiateRefundResponseModel nResponseModel;
    public MpRefundInitiatedNewBinding refundInitiatedBinding;
    public RefundInitiatedViewModel refundInitiatedViewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTransDetails = (OrderListItem) getIntent().getSerializableExtra(AppConstants.TRANSACTION_OBJECT);
        this.nResponseModel = (InitiateRefundResponseModel) getIntent().getSerializableExtra("Initiate_response");
        this.mDate = (String) getIntent().getSerializableExtra("Date");
        this.mStatus = (Boolean) getIntent().getSerializableExtra("Status");
        this.mAmount = (String) getIntent().getSerializableExtra("Amount");
        this.mComingFromScreen = getIntent().getStringExtra(AppConstants.SCREEN_NAME);
        this.isMultipleQRCase = getIntent().getBooleanExtra(AppConstants.IS_FROM_MULTIPLE_QR, false);
        initDataBinding();
        this.refundInitiatedBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RefundInitiatedActivity.this.lambda$onCreate$0$RefundInitiatedActivity(view);
            }
        });
        c.a().a((Object) this);
    }

    public /* synthetic */ void lambda$onCreate$0$RefundInitiatedActivity(View view) {
        onBackPressed();
    }

    private void openPaymentsLinkScreen() {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.KEY_OPEN_SCREEN, "accept_payment_tab");
        bundle.putBoolean("internal_source", true);
        bundle.putString("key_deeplink_data", "paytmba://business-app/h/accept-payments/request-money");
        PaymentsConfig.getInstance().getDeepLinkUtils().a(this);
    }

    private void openPaymentsScreen() {
        if (MPConstants.isP4BClient()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("internal_source", true);
            bundle.putString("key_deeplink_data", "paytmba://business-app/h/payments");
            PaymentsConfig.getInstance().getDeepLinkUtils().a(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c.a().b(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!TextUtils.isEmpty(this.mComingFromScreen)) {
            String str = this.mComingFromScreen;
            char c2 = 65535;
            if (str.hashCode() == -2018414862 && str.equals(AppConstants.PAYMENTS_LINK_RECV_SCREEN)) {
                c2 = 0;
            }
            if (c2 != 0) {
                finish();
            } else {
                openPaymentsLinkScreen();
            }
        } else if (this.isMultipleQRCase) {
            openPaymentQRScreen();
        } else {
            openPaymentsScreen();
        }
    }

    private void openPaymentQRScreen() {
        PaymentsConfig.getInstance().getDeepLinkUtils().a(this, "paytmba://business-app/h/payments?select=today&posId=null");
        finish();
    }

    public void initDataBinding() {
        MpRefundInitiatedNewBinding mpRefundInitiatedNewBinding = (MpRefundInitiatedNewBinding) f.a(this, R.layout.mp_refund_initiated_new);
        this.refundInitiatedBinding = mpRefundInitiatedNewBinding;
        RefundInitiatedViewModel refundInitiatedViewModel2 = new RefundInitiatedViewModel(this, this.mTransDetails, this.nResponseModel, this.mDate, this.mAmount, this.mStatus, mpRefundInitiatedNewBinding);
        this.refundInitiatedViewModel = refundInitiatedViewModel2;
        this.refundInitiatedBinding.setRefundInitiatedViewModel(refundInitiatedViewModel2);
        if (APSharedPreferences.getInstance().isMerchantMigrated()) {
            this.refundInitiatedBinding.statusImage.setImageDrawable(b.a((Context) this, R.drawable.mp_ic_pending));
            this.refundInitiatedBinding.amount.setTextColor(getResources().getColor(R.color.orange));
            this.refundInitiatedBinding.tvRefundStatus.setText(getResources().getString(R.string.mp_lbl_refund_initiated));
        }
        this.refundInitiatedBinding.tvOrderIdText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(RefundInitiatedActivity.this.refundInitiatedViewModel.orderId.get())) {
                    RefundInitiatedActivity refundInitiatedActivity = RefundInitiatedActivity.this;
                    refundInitiatedActivity.showDialogSheet(refundInitiatedActivity.getResources().getString(R.string.mp_Order_id_name), RefundInitiatedActivity.this.refundInitiatedViewModel.orderId.get());
                }
            }
        });
    }

    public void showDialogSheet(String str, String str2) {
        CommonConfirmationBottomSheet instance = CommonConfirmationBottomSheet.Companion.getInstance(str, str2, (String) null, (Integer) null, (Integer) null);
        instance.setSubHeadingFontFace(Typeface.DEFAULT_BOLD);
        instance.setSubHeadingFontColor(Integer.valueOf(b.c(this, R.color.black)));
        instance.show(getSupportFragmentManager(), "email_id");
    }
}
