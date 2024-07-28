package net.one97.paytm.nativesdk.login.view.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.Request;
import com.bumptech.glide.b;
import com.business.merchant_payments.common.utility.AppUtility;
import java.util.Iterator;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.PermissionUtil;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.databinding.LoginFragmentLayoutBinding;
import net.one97.paytm.nativesdk.instruments.InstrumentListeneres;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.login.listeners.LoginListeners;
import net.one97.paytm.nativesdk.login.viewmodel.LoginViewModel;
import net.one97.paytm.nativesdk.otp.view.OtpVerificationFragment;

public class LoginFragment extends h implements LoginListeners {
    /* access modifiers changed from: private */
    public AppCompatActivity appCompatActivity;
    /* access modifiers changed from: private */
    public LoginFragmentLayoutBinding binding;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LoginFragment.this.closeView();
        }
    };
    private CashierInstrumentCom cashierInstrumentCom;
    private LoginViewModel loginViewModel;
    private int merchantLogo = 0;
    private OtpVerificationFragment otpVerificationFragment;
    private PaytmBaseView upiView;

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cashierInstrumentCom = new CashierInstrumentCom();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.appCompatActivity = (AppCompatActivity) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (LoginFragmentLayoutBinding) f.a(getLayoutInflater(), R.layout.login_fragment_layout, (ViewGroup) null, false);
        this.binding.etMobileNumber.setSupportBackgroundTintList(ColorStateList.valueOf(getActivity().getResources().getColor(R.color.native_sdk_line_color)));
        this.loginViewModel = new LoginViewModel(getActivity(), MerchantBL.getMerchantInstance().getToken(), this, MerchantBL.getMerchantInstance().getAmount());
        this.binding.setLandingPageViewModel(this.loginViewModel);
        if (!PermissionUtil.checkingPermissionIsEnabledOrNotForSmsPhoneState(getContext())) {
            PermissionUtil.requestPermissionIsEnabledOrNotForSmsPhoneState(getActivity());
        }
        this.binding.rlPaytmPayOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginFragment.this.binding.rbPaytmPayOption.setChecked(true);
                LoginFragment.this.binding.llLogin.setVisibility(0);
                DirectPaymentBL.getInstance().closeOpnedView();
            }
        });
        setPayMethodViews();
        this.binding.rlMerchantInfo.post(new Runnable() {
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LoginFragment.this.binding.otpFragmentContainer.getLayoutParams();
                layoutParams.height = (int) (((float) ((LoginFragment.this.binding.scrollView.getMeasuredHeight() - LoginFragment.this.binding.rlMerchantInfo.getMeasuredHeight()) - LoginFragment.this.binding.lytSelectOtherOption.getMeasuredHeight())) - (Resources.getSystem().getDisplayMetrics().density * 10.0f));
                LoginFragment.this.binding.otpFragmentContainer.setLayoutParams(layoutParams);
            }
        });
        this.binding.ivCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginFragment.this.getActivity().onBackPressed();
            }
        });
        String[] split = MerchantBL.getMerchantInstance().getAmount().split("\\.");
        TextView textView = this.binding.tvAmount;
        textView.setText(getString(R.string.rupee_symbol) + " " + split[0]);
        if (split.length > 1) {
            TextView textView2 = this.binding.tvDecimalAmt;
            textView2.setText(AppUtility.CENTER_DOT + split[1]);
            this.binding.tvDecimalAmt.setVisibility(0);
        }
        if (getContext() != null) {
            if (this.merchantLogo != 0) {
                try {
                    this.binding.ivMerchantLogo.setImageResource(this.merchantLogo);
                } catch (Exception unused) {
                    b.b(getContext()).a(MerchantBL.getMerchantInstance().getMerchantLogoUrl()).a(this.binding.ivMerchantLogo);
                }
            } else if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getMerchantLogoUrl())) {
                b.b(getContext()).a(MerchantBL.getMerchantInstance().getMerchantLogoUrl()).a(this.binding.ivMerchantLogo);
            }
        }
        return this.binding.getRoot();
    }

    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNCHECK_VIEWS_ACTION_FILTER);
        a.a(getContext().getApplicationContext()).a(this.broadcastReceiver, intentFilter);
    }

    public void onStop() {
        super.onStop();
    }

    public void onOTPSend(String str) {
        this.binding.otpFragmentContainer.setVisibility(0);
        this.otpVerificationFragment = OtpVerificationFragment.getInstance(str);
        getFragmentManager().a().a(R.id.otp_fragment_container, (Fragment) this.otpVerificationFragment).b();
        this.binding.lytSignInButton.setEnabled(false);
        closeView();
    }

    public void hideOtpFragment() {
        if (this.otpVerificationFragment != null) {
            getFragmentManager().a().a((Fragment) this.otpVerificationFragment).b();
            this.binding.otpFragmentContainer.setVisibility(8);
        }
        this.binding.lytSignInButton.setEnabled(true);
    }

    public void onNetworkUnavailable(Request request) {
        DialogUtility.showNetworkDialog(request, getActivity());
    }

    public void onFailureOTPSend(String str) {
        Toast.makeText(getActivity(), str, 1).show();
    }

    public void errorOnMobileNumber(int i2) {
        if (i2 == -1 || i2 == 0) {
            this.binding.tvErrMobileNumber.setVisibility(0);
            this.binding.tvErrMobileNumber.setText(getString(R.string.invalid_mobile_number_error));
        } else if (i2 == 2) {
            this.binding.tvErrMobileNumber.setVisibility(0);
            this.binding.tvErrMobileNumber.setText(getString(R.string.unknown_error));
        } else {
            this.binding.tvErrMobileNumber.setVisibility(8);
            this.binding.tvErrMobileNumber.setText("");
        }
    }

    public void hideKeyboard() {
        SDKUtility.hideKeyboard(this.binding.etMobileNumber, getContext());
    }

    public void setPayMethodViews() {
        MerchantPayOption merchantPayOption;
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null) {
            if ((DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption() != null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getPaymentModes() != null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getPaymentModes().size() > 0) && (merchantPayOption = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption()) != null) {
                Iterator<PaymentModes> it2 = merchantPayOption.getPaymentModes().iterator();
                while (it2.hasNext()) {
                    PaymentModes next = it2.next();
                    if (next.getPaymentMode().equalsIgnoreCase(PayMethodType.CREDIT_CARD.name())) {
                        addViewInScrollView(new Instruments(this.cashierInstrumentCom).getPgOnlyCreditCardsView((Context) getActivity(), DirectPaymentBL.getInstance().getCjPayMethodResponse(), (LinearLayout) null).getView());
                    } else if (next.getPaymentMode().equalsIgnoreCase(PayMethodType.DEBIT_CARD.name())) {
                        addViewInScrollView(new Instruments(this.cashierInstrumentCom).getPgOnlyDebitCardsView((Context) getActivity(), DirectPaymentBL.getInstance().getCjPayMethodResponse(), (LinearLayout) null).getView());
                    } else if (next.getPaymentMode().equalsIgnoreCase(PayMethodType.UPI.name())) {
                        this.upiView = new Instruments(this.cashierInstrumentCom).getUpiCollectViewNew(getActivity(), next);
                        addViewInScrollView(this.upiView.getView());
                    } else if (!next.getPaymentMode().equalsIgnoreCase(PayMethodType.EMI.name()) && next.getPaymentMode().equalsIgnoreCase(PayMethodType.NET_BANKING.name())) {
                        addViewInScrollView(new Instruments(this.cashierInstrumentCom).getNetBankingView(getActivity(), next, false, true).getView());
                    }
                }
            }
        }
    }

    private void addViewInScrollView(View view) {
        this.binding.lytPaymethods.addView(view);
        this.binding.lytPaymethods.addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.line_xml, (ViewGroup) null, false));
    }

    class CashierInstrumentCom extends InstrumentListeneres {
        private CashierInstrumentCom() {
        }

        public void closeCashier() {
            DirectPaymentBL.getInstance().getSelectedInstrument().getBaseViewModel().completeTransaction(LoginFragment.this.appCompatActivity);
        }

        public NestedScrollView getScrollView() {
            return LoginFragment.this.binding.scrollView;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void closeView() {
        this.binding.rbPaytmPayOption.setChecked(false);
        this.binding.llLogin.setVisibility(8);
    }
}
