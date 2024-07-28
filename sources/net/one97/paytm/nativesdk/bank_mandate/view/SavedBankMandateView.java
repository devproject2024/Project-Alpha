package net.one97.paytm.nativesdk.bank_mandate.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.f;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.b;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.adapter.BankMandateAuthenticateAdapter;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.bank_mandate.listeners.BankMandateAuthListener;
import net.one97.paytm.nativesdk.bank_mandate.listeners.MandateViewActionListener;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.SavedMandateViewModel;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.databinding.SavedMandateLayoutBinding;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManager;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class SavedBankMandateView extends PaytmBaseView implements MandateViewActionListener {
    /* access modifiers changed from: private */
    public String authType = "";
    /* access modifiers changed from: private */
    public PaymentModes paymentModes;
    private SavedMandateLayoutBinding savdMdDataBindingUtil;
    private SavedMandateBanksItem savedMandateDetails;
    /* access modifiers changed from: private */
    public SavedMandateViewModel savedMandateViewModel;

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void disableProceedButton() {
    }

    public void enableProceedButton() {
    }

    public void setAmount(String str) {
    }

    public void startCheckingOfferAnimation() {
    }

    public void stopCheckingOfferAnimation() {
    }

    public void updateCheckBalanceLayout() {
    }

    public SavedBankMandateView(Context context, SavedMandateBanksItem savedMandateBanksItem, PaymentModes paymentModes2, Instruments instruments) {
        super(instruments);
        this.context = context;
        this.savedMandateDetails = savedMandateBanksItem;
        this.paymentModes = paymentModes2;
        this.savedMandateViewModel = new SavedMandateViewModel();
        if (this.context != null) {
            new IntentFilter().addAction(SDKConstants.REFRESH_UPI);
        }
    }

    public PaytmBaseView getSavedMandateView(PaymentModes paymentModes2, SavedMandateBanksItem savedMandateBanksItem, InstrumentsSelectionManager instrumentsSelectionManager) {
        this.savdMdDataBindingUtil = (SavedMandateLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.saved_mandate_layout, (ViewGroup) null, false);
        this.view = this.savdMdDataBindingUtil.getRoot();
        if (savedMandateBanksItem != null) {
            initView(this.savdMdDataBindingUtil, savedMandateBanksItem);
        }
        return this;
    }

    private void initView(final SavedMandateLayoutBinding savedMandateLayoutBinding, final SavedMandateBanksItem savedMandateBanksItem) {
        if (!TextUtils.isEmpty(savedMandateBanksItem.getDisplayName())) {
            savedMandateLayoutBinding.rbBankName.setText(savedMandateBanksItem.getDisplayName());
        }
        if (!TextUtils.isEmpty(savedMandateBanksItem.getMaskedAccountNumber())) {
            savedMandateLayoutBinding.txtAccount.setText(this.context.getResources().getString(R.string.vpa_account_number, new Object[]{SDKUtility.maskNumber(savedMandateBanksItem.getMaskedAccountNumber())}));
        }
        b.b(this.context).a(savedMandateBanksItem.getIconUrl()).a(savedMandateLayoutBinding.ivSavedMandateBank);
        savedMandateLayoutBinding.rbBankName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SavedBankMandateView.this.selectedView();
                    savedMandateLayoutBinding.rbBankName.setTypeface((Typeface) null, 1);
                    savedMandateLayoutBinding.includeAuthUsingViewSaved.clBankEMandateAuth.setVisibility(0);
                    savedMandateLayoutBinding.btnProceedSavedMandate.setVisibility(0);
                    BankMandateAuthenticateAdapter bankMandateAuthenticateAdapter = new BankMandateAuthenticateAdapter(SavedBankMandateView.this.context, savedMandateBanksItem.getMandateAuthMode(), new BankMandateAuthListener() {
                        public void onAuthTypeSelected(String str) {
                            String unused = SavedBankMandateView.this.authType = str;
                            savedMandateLayoutBinding.includeAuthUsingViewSaved.tvAuthenticateUsing.setTextColor(SavedBankMandateView.this.context.getResources().getColor(R.color.color_222222));
                        }
                    });
                    savedMandateLayoutBinding.includeAuthUsingViewSaved.rvBankEMandateAuthList.setHasFixedSize(true);
                    savedMandateLayoutBinding.includeAuthUsingViewSaved.rvBankEMandateAuthList.setLayoutManager(new LinearLayoutManager(SavedBankMandateView.this.context));
                    savedMandateLayoutBinding.includeAuthUsingViewSaved.rvBankEMandateAuthList.setAdapter(bankMandateAuthenticateAdapter);
                    return;
                }
                savedMandateLayoutBinding.rbBankName.setTypeface((Typeface) null, 0);
            }
        });
        savedMandateLayoutBinding.clMainSavedMandate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                savedMandateLayoutBinding.rbBankName.setChecked(true);
                savedMandateLayoutBinding.clMainSavedMandate.setClickable(false);
            }
        });
        savedMandateLayoutBinding.btnProceedSavedMandate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(SavedBankMandateView.this.authType)) {
                        savedMandateLayoutBinding.includeAuthUsingViewSaved.tvAuthenticateUsing.setTextColor(SavedBankMandateView.this.context.getResources().getColor(R.color.native_error_color));
                    } else if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo() != null && SavedBankMandateView.this.context != null) {
                        SavedBankMandateView.this.savedMandateViewModel.getBankMandatePTCModel(savedMandateBanksItem, SavedBankMandateView.this.authType, DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo(), SavedBankMandateView.this.paymentModes).observe((q) SavedBankMandateView.this.context, new z<BankMandatePTCModel>() {
                            public void onChanged(BankMandatePTCModel bankMandatePTCModel) {
                                if (bankMandatePTCModel != null) {
                                    new BankMandateSubscriptionDetailsFragment();
                                    BankMandateSubscriptionDetailsFragment newInstance = BankMandateSubscriptionDetailsFragment.newInstance(bankMandatePTCModel.getAccountHolderName(), savedMandateBanksItem.getChannelName(), savedMandateBanksItem.getMaskedAccountNumber(), bankMandatePTCModel.getBankIfsc(), savedMandateBanksItem.getIconUrl(), savedMandateBanksItem.getAccountType(), SDKConstants.SAVED_MANDATE, SavedBankMandateView.this.authType);
                                    ((InstrumentActivity) SavedBankMandateView.this.context).getSupportFragmentManager().a().a(R.id.fragment_container, newInstance, BankMandateSubscriptionDetailsFragment.class.getSimpleName()).a((String) null).c();
                                    newInstance.setListener(SavedBankMandateView.this);
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void onProceedClicked() {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        } else {
            initProcessTransaction();
        }
    }

    private void initProcessTransaction() {
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.SAVED_BANK_MANDATE, new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), getProcessTransactionRequest(this.paymentModes.getPaymentMode())));
        transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
        transactionProcessor.setMandateNativeFlow(true);
        transactionProcessor.startTransaction(this.savdMdDataBindingUtil.btnProceedSavedMandate);
    }

    public HashMap<String, String> getProcessTransactionRequest(String str) {
        return PayUtility.getSavedMandatePtcParam(str, DirectPaymentBL.getInstance().getBankMandatePTCModel());
    }

    public void closeView() {
        this.savdMdDataBindingUtil.rbBankName.setChecked(false);
        clearAllSelection();
    }

    public void openAutoInstrument() {
        isOnceClicked = true;
        this.savdMdDataBindingUtil.rbBankName.setChecked(true);
        this.savdMdDataBindingUtil.clMainSavedMandate.setClickable(false);
    }

    public void clearAllSelection() {
        this.authType = "";
        this.savdMdDataBindingUtil.clMainSavedMandate.setClickable(true);
        this.savdMdDataBindingUtil.rbBankName.setTypeface((Typeface) null, 0);
        this.savdMdDataBindingUtil.includeAuthUsingViewSaved.clBankEMandateAuth.setVisibility(8);
        if (this.savdMdDataBindingUtil.btnProceedSavedMandate.getVisibility() == 0) {
            this.savdMdDataBindingUtil.btnProceedSavedMandate.setVisibility(8);
        }
    }

    public void selectedView() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
    }

    public void onConfirmClick() {
        onProceedClicked();
    }

    public void scrollTo(final View view) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofInt(SavedBankMandateView.this.instruments.getScrollView(), "scrollY", new int[]{((int) (((View) view.getParent()).getY() + view.getY())) - 50}).setDuration(500).start();
            }
        }, 200);
    }
}
