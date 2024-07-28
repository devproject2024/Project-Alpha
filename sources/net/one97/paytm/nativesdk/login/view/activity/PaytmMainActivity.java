package net.one97.paytm.nativesdk.login.view.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.e;
import androidx.cardview.widget.CardView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.Request;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LocationManager;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.databinding.ActivityLoginBinding;
import net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBinding;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.login.view.fragment.LoginFragment;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.listeners.SetOnCashierSheetListener;
import net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel;
import net.one97.paytm.nativesdk.paymethods.views.fragments.LoadingInstrumentFragment;
import net.one97.paytm.nativesdk.transcation.view.TranscationStatusSheet;

public class PaytmMainActivity extends BaseActivity implements OnBottomSheetChangeListener, OnPayMethodSelectedListener, SetOnCashierSheetListener {
    public ActivityLoginBinding mActivityLoginBinding;
    private LinearLayout mBorderLinesLayout;
    private LytInstrumentSelectedSheetBinding mSelectedInstrumentBinding;
    private SelectedInstrumentSheetViewModel mSelectedInstrumentSheetViewModel;
    private CardView mSelectedInstrumentView;
    /* access modifiers changed from: private */
    public TranscationStatusSheet transcationStatusSheet;

    public String getChildClassName() {
        return "PaytmMainActivity";
    }

    public void onNetworkUnavailable(Request request) {
    }

    public boolean shouldKillActivity() {
        return true;
    }

    public void onBackPressed() {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("back_button_clicked", "", ""));
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_back_press, (ViewGroup) null, false);
        final AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
        inflate.findViewById(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PaytmSDK.getCallbackListener() != null) {
                    PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
                }
                Intent intent = new Intent("kill");
                intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                a.a((Context) PaytmMainActivity.this).a(intent);
                create.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_no).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.getWindow().setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
        create.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        e.m();
        this.mActivityLoginBinding = (ActivityLoginBinding) f.a(this, R.layout.activity_login);
        this.mActivityLoginBinding.tvAmout.setText(getString(R.string.nativesdk_amount, new Object[]{MerchantBL.getMerchantInstance().getAmount()}));
        if (MerchantBL.getMerchantInstance().isAuthenticated()) {
            startInstrumentActivity();
        } else {
            LoadingInstrumentFragment loadingInstrumentFragment = new LoadingInstrumentFragment();
            loadingInstrumentFragment.setBottomSheetChangeListener(this);
            Bundle bundle2 = new Bundle();
            bundle2.putString(SDKConstants.INTENT, SDKConstants.FETCH_ONLY);
            loadingInstrumentFragment.setArguments(bundle2);
            changeFragment(loadingInstrumentFragment, false);
        }
        LocationManager.getManger().buildGoogleApiClient(getApplicationContext());
    }

    public void startInstrumentActivity() {
        Intent intent = new Intent(this, InstrumentActivity.class);
        intent.putExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "Paytm Wallet");
        intent.putExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "Balance Rs 1200");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);
        finish();
    }

    public void onChangeBottomSheet(String str, boolean z) {
        LoginFragment loginFragment = new LoginFragment();
        if (str.equals("cashier")) {
            Intent intent = new Intent(this, InstrumentActivity.class);
            intent.putExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "Paytm Wallet");
            intent.putExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "Balance Rs 1200");
            intent.putExtra(SDKConstants.IS_CASHIER, z);
            if (z) {
                if (!DirectPaymentBL.getInstance().isInstrumentEnabledOnMerchant()) {
                    startActivity(intent);
                }
            } else if (!DirectPaymentBL.getInstance().isInstrumentEnabledOnAddMoney()) {
                startActivity(intent);
            }
        } else if (str.equals(SDKConstants.FETCH_ONLY)) {
            this.mSelectedInstrumentBinding = this.mActivityLoginBinding.lytSelectedInstrument;
            changeFragment(loginFragment, false);
        } else if (str.equals(SDKConstants.SELECTED)) {
            this.mSelectedInstrumentBinding = this.mActivityLoginBinding.lytSelectedInstrument;
            this.mSelectedInstrumentView = this.mActivityLoginBinding.lytSelectedInstrument.cvSelectedInstrument;
            this.mSelectedInstrumentView.setVisibility(0);
            this.mSelectedInstrumentSheetViewModel = new SelectedInstrumentSheetViewModel(this, this);
            this.mSelectedInstrumentBinding.setSelectedInstrumentSheetViewModel(this.mSelectedInstrumentSheetViewModel);
        } else if (str.equalsIgnoreCase("close")) {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void OnPayMethodSelected() {
        SelectedInstrument selectedInstrument = DirectPaymentBL.getInstance().getSelectedInstrument();
        if (selectedInstrument != null) {
            this.mSelectedInstrumentSheetViewModel.updateState(selectedInstrument.getPrimaryName(), selectedInstrument.getSecondaryName());
        }
    }

    public void onCashierSheetDismiss() {
        OnPayMethodSelected();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void saveActivityFromFinish(String str) {
        if (getChildClassName().equalsIgnoreCase(str)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    TranscationStatusSheet unused = PaytmMainActivity.this.transcationStatusSheet = new TranscationStatusSheet();
                    if (!SDKUtility.isPaytmApp(PaytmMainActivity.this)) {
                        PaytmMainActivity.this.transcationStatusSheet.setCancelable(false);
                    }
                    PaytmMainActivity.this.transcationStatusSheet.show(PaytmMainActivity.this.getSupportFragmentManager(), (String) null);
                }
            }, 200);
        } else {
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment c2 = getSupportFragmentManager().c(LoginFragment.class.getName());
        if (c2 != null) {
            c2.onActivityResult(i2, i3, intent);
        }
    }
}
