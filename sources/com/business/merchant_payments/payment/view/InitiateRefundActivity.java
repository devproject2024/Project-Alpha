package com.business.merchant_payments.payment.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.databinding.MpInitiateRefundNewBinding;
import com.business.merchant_payments.event.NoNetworkEvent;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderListItem;
import com.business.merchant_payments.payment.listener.InitiateRefundListener;
import com.business.merchant_payments.payment.viewmodel.InitiateRefundViewModel;
import com.google.android.material.snackbar.Snackbar;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class InitiateRefundActivity extends BaseActivity implements InitiateRefundListener {
    public Snackbar failureSnackBar;
    public MpInitiateRefundNewBinding initiateRefundNewBinding;
    public InitiateRefundViewModel initiateRefundViewModel;
    public boolean isPCFTransaction;
    public String mClickedFrom = "INITIATEREFUND";
    public String mComingFromScreen = "";
    public OrderListItem mTransDetails;

    public String getComingFromScreen() {
        return this.mComingFromScreen;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setComingFromScreen();
        initDataBinding();
        this.initiateRefundViewModel.snackBarCmd().observe(this, new z() {
            public final void onChanged(Object obj) {
                InitiateRefundActivity.this.lambda$onCreate$0$InitiateRefundActivity((String) obj);
            }
        });
        checkForMultipleQRCase();
    }

    public /* synthetic */ void lambda$onCreate$0$InitiateRefundActivity(String str) {
        if (!TextUtils.isEmpty(str)) {
            showSnackBar(str);
        }
    }

    private void checkForMultipleQRCase() {
        if (getIntent().getBooleanExtra(AppConstants.IS_FROM_MULTIPLE_QR, false)) {
            this.initiateRefundViewModel.setMultipleQR(getIntent().getBooleanExtra(AppConstants.IS_FROM_MULTIPLE_QR, false));
        }
    }

    private void setComingFromScreen() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mComingFromScreen = intent.getStringExtra(AppConstants.SCREEN_NAME);
            this.isPCFTransaction = intent.getBooleanExtra(AppConstants.IS_PCF_TRANSACTION, false);
        }
    }

    private void initDataBinding() {
        this.mTransDetails = (OrderListItem) getIntent().getSerializableExtra(AppConstants.TRANSACTION_OBJECT);
        MpInitiateRefundNewBinding mpInitiateRefundNewBinding = (MpInitiateRefundNewBinding) f.a(this, R.layout.mp_initiate_refund_new);
        this.initiateRefundNewBinding = mpInitiateRefundNewBinding;
        mpInitiateRefundNewBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InitiateRefundActivity.this.lambda$initDataBinding$1$InitiateRefundActivity(view);
            }
        });
        this.initiateRefundNewBinding.refundTvCommissionCheckbox.setVisibility(this.isPCFTransaction ? 0 : 8);
        InitiateRefundViewModel initiateRefundViewModel2 = new InitiateRefundViewModel(this, this, this.mTransDetails, this.isPCFTransaction);
        this.initiateRefundViewModel = initiateRefundViewModel2;
        this.initiateRefundNewBinding.setInitiateRefundViewModel(initiateRefundViewModel2);
        this.initiateRefundNewBinding.etRefundAmount.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                InitiateRefundActivity.this.initiateRefundViewModel.setEnteredAmount(charSequence.toString());
            }

            public void afterTextChanged(Editable editable) {
                InitiateRefundViewModel initiateRefundViewModel = InitiateRefundActivity.this.initiateRefundViewModel;
                if (initiateRefundViewModel != null) {
                    initiateRefundViewModel.errorText.set("");
                }
                if (editable.toString().equalsIgnoreCase(AppUtility.CENTER_DOT)) {
                    InitiateRefundActivity.this.initiateRefundNewBinding.etRefundAmount.setText("0.");
                    InitiateRefundActivity.this.initiateRefundNewBinding.etRefundAmount.setSelection(2);
                } else if (editable.toString().contains(AppUtility.CENTER_DOT)) {
                    String[] split = editable.toString().split("\\.");
                    if (split.length >= 2 && split[1].length() > 2) {
                        String str = split[0] + AppUtility.CENTER_DOT + split[1].substring(0, 2);
                        InitiateRefundActivity.this.initiateRefundNewBinding.etRefundAmount.setText(str);
                        InitiateRefundActivity.this.initiateRefundNewBinding.etRefundAmount.setSelection(str.length());
                    }
                }
            }
        });
    }

    public /* synthetic */ void lambda$initDataBinding$1$InitiateRefundActivity(View view) {
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void showSnackBar(String str) {
        Snackbar snackbar = this.failureSnackBar;
        if (snackbar != null) {
            snackbar.d();
        }
        Snackbar a2 = Snackbar.a((View) this.initiateRefundNewBinding.coordinatorLayout, (CharSequence) str, -2).a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                InitiateRefundActivity.this.lambda$showSnackBar$2$InitiateRefundActivity(view);
            }
        });
        this.failureSnackBar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.failureSnackBar.b();
        b2.setBackgroundColor(b.c(this, R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.failureSnackBar.c();
    }

    public /* synthetic */ void lambda$showSnackBar$2$InitiateRefundActivity(View view) {
        this.failureSnackBar.d();
        this.initiateRefundViewModel.getApiCall();
    }

    @j(a = ThreadMode.MAIN)
    public void onNoNetwork(NoNetworkEvent noNetworkEvent) {
        if (this.initiateRefundViewModel != null) {
            String clickType = noNetworkEvent.getClickType();
            String clickedFrom = noNetworkEvent.getClickedFrom();
            LogUtility.d("CLICKEDTYPE", "---------- CLICKED TYPE -------------".concat(String.valueOf(clickType)));
            if (clickType != null && clickedFrom != null && clickedFrom.equalsIgnoreCase(this.mClickedFrom)) {
                if (clickType.equals(AppConstants.NETWORK_RETRY_CLICK)) {
                    this.initiateRefundViewModel.inclVisibility.set(false);
                    this.initiateRefundViewModel.getApiCall();
                    return;
                }
                this.initiateRefundViewModel.inclVisibility.set(false);
            }
        }
    }

    public void showProgressDialog() {
        super.showProgressDialog();
    }

    public void removeProgressDialog() {
        super.removeProgressDialog();
    }

    public void showDialog(String str, String str2) {
        DialogUtility.showDialog(this, str, str2);
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        c.a().b(this);
        super.onStop();
    }
}
