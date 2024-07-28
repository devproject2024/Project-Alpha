package net.one97.paytm.nativesdk.bank_mandate.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.f;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.adapter.BankMandateAuthenticateAdapter;
import net.one97.paytm.nativesdk.bank_mandate.adapter.BankMandateBankSelectAdapter;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.bank_mandate.listeners.BankMandateAuthListener;
import net.one97.paytm.nativesdk.bank_mandate.listeners.MandateViewActionListener;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateAllOtherBanksFragment;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateFindIFSCFragment;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateViewModel;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.databinding.BankEMandateNewAcBinding;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManager;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.RecyclerItemClickListner;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class BankMandateView extends PaytmBaseView implements MandateViewActionListener {
    /* access modifiers changed from: private */
    public String authType = "";
    /* access modifiers changed from: private */
    public BankEMandateNewAcBinding bankEMandateNewAcBinding;
    /* access modifiers changed from: private */
    public BankMandateViewModel bankMandateViewModel;
    /* access modifiers changed from: private */
    public String channelCode = "";
    /* access modifiers changed from: private */
    public String iconUrl = "";
    private MandateAccountDetails mandateAccountDetails;
    private final PaymentModes paymentModes;

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

    public BankMandateView(Context context, MandateAccountDetails mandateAccountDetails2, PaymentModes paymentModes2, Instruments instruments) {
        super(instruments);
        this.context = context;
        this.mandateAccountDetails = mandateAccountDetails2;
        this.paymentModes = paymentModes2;
        this.bankMandateViewModel = new BankMandateViewModel();
        if (this.context != null) {
            new IntentFilter().addAction(SDKConstants.REFRESH_UPI);
        }
    }

    public PaytmBaseView getBankMandateView(PaymentModes paymentModes2, MandateAccountDetails mandateAccountDetails2, InstrumentsSelectionManager instrumentsSelectionManager) {
        this.bankEMandateNewAcBinding = (BankEMandateNewAcBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.bank_e_mandate_new_ac, (ViewGroup) null, false);
        this.view = this.bankEMandateNewAcBinding.getRoot();
        initView(this.bankEMandateNewAcBinding, mandateAccountDetails2, paymentModes2);
        return this;
    }

    private void initView(final BankEMandateNewAcBinding bankEMandateNewAcBinding2, final MandateAccountDetails mandateAccountDetails2, final PaymentModes paymentModes2) {
        bankEMandateNewAcBinding2.rbBankEMandate.setText(paymentModes2.getDisplayName());
        bankEMandateNewAcBinding2.rbBankEMandate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    BankMandateView.this.scrollTo(bankEMandateNewAcBinding2.getRoot());
                    BankMandateView.this.selectedView();
                    bankEMandateNewAcBinding2.rbBankEMandate.setTypeface((Typeface) null, 1);
                    if (mandateAccountDetails2 == null) {
                        bankEMandateNewAcBinding2.clBankMandateBankSelect.setVisibility(0);
                        bankEMandateNewAcBinding2.clBankMandateBankForm.setVisibility(8);
                        bankEMandateNewAcBinding2.tvBankMandateChange.setVisibility(8);
                        bankEMandateNewAcBinding2.tvBankMandateFindIfsc.setVisibility(8);
                        bankEMandateNewAcBinding2.btnProceedMandate.setVisibility(8);
                        final ArrayList<PayChannelOptions> payChannelOptions = paymentModes2.getPayChannelOptions();
                        if (payChannelOptions != null) {
                            if (payChannelOptions.size() <= 6) {
                                bankEMandateNewAcBinding2.clSelectAllOtherBank.setVisibility(8);
                            } else {
                                bankEMandateNewAcBinding2.clSelectAllOtherBank.setVisibility(0);
                                for (int findViewById : bankEMandateNewAcBinding2.clSelectAllOtherBank.getReferencedIds()) {
                                    BankMandateView.this.view.findViewById(findViewById).setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            new BankMandateAllOtherBanksFragment();
                                            BankMandateAllOtherBanksFragment newInstance = BankMandateAllOtherBanksFragment.newInstance(payChannelOptions);
                                            ((InstrumentActivity) BankMandateView.this.context).getSupportFragmentManager().a().a(R.id.fragment_container, newInstance, BankMandateAllOtherBanksFragment.class.getSimpleName()).a((String) null).c();
                                            newInstance.setListener(new BankMandateAllOtherBanksFragment.OtherBankSelectedListener() {
                                                public void onSelected(PayChannelOptions payChannelOptions) {
                                                    BankMandateView.this.onSelectBank(bankEMandateNewAcBinding2, payChannelOptions, 0, payChannelOptions);
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                            BankMandateBankSelectAdapter bankMandateBankSelectAdapter = new BankMandateBankSelectAdapter(BankMandateView.this.context, payChannelOptions);
                            bankEMandateNewAcBinding2.rvGridBankList.setHasFixedSize(true);
                            bankEMandateNewAcBinding2.rvGridBankList.setLayoutManager(new GridLayoutManager(BankMandateView.this.context, 3));
                            bankEMandateNewAcBinding2.rvGridBankList.setAdapter(bankMandateBankSelectAdapter);
                            bankEMandateNewAcBinding2.rvGridBankList.addOnItemTouchListener(new RecyclerItemClickListner(BankMandateView.this.context, new RecyclerItemClickListner.OnItemClickListener() {
                                public void onItemClick(View view, int i2) {
                                    if (i2 != -1) {
                                        BankMandateView.this.onSelectBank(bankEMandateNewAcBinding2, payChannelOptions, i2, (PayChannelOptions) null);
                                    }
                                }
                            }));
                            return;
                        }
                        return;
                    }
                    bankEMandateNewAcBinding2.clBankMandateBankSelect.setVisibility(8);
                    bankEMandateNewAcBinding2.clBankMandateBankForm.setVisibility(0);
                    bankEMandateNewAcBinding2.btnProceedMandate.setVisibility(0);
                    bankEMandateNewAcBinding2.tvBankMandateChange.setVisibility(8);
                    bankEMandateNewAcBinding2.tvBankMandateFindIfsc.setVisibility(8);
                    bankEMandateNewAcBinding2.tiEtName.setFocusable(false);
                    bankEMandateNewAcBinding2.tiEtBankAc.setFocusable(false);
                    bankEMandateNewAcBinding2.tiEtIfsc.setFocusable(false);
                    if (!TextUtils.isEmpty(mandateAccountDetails2.getChannelName())) {
                        bankEMandateNewAcBinding2.tvBankMandateSelectedBank.setText(mandateAccountDetails2.getChannelName());
                        String unused = BankMandateView.this.channelCode = mandateAccountDetails2.getChannelCode();
                        String unused2 = BankMandateView.this.authType = "";
                        b.b(BankMandateView.this.context).a(mandateAccountDetails2.getIconUrl()).a(bankEMandateNewAcBinding2.ivBankMandateSelectedLogo);
                        String unused3 = BankMandateView.this.iconUrl = mandateAccountDetails2.getIconUrl();
                    }
                    if (!TextUtils.isEmpty(mandateAccountDetails2.getAccountHolderName())) {
                        bankEMandateNewAcBinding2.tiEtName.setText(mandateAccountDetails2.getAccountHolderName());
                    }
                    if (!TextUtils.isEmpty(mandateAccountDetails2.getAccountNumber())) {
                        bankEMandateNewAcBinding2.tiEtBankAc.setText(mandateAccountDetails2.getAccountNumber());
                    }
                    if (!TextUtils.isEmpty(mandateAccountDetails2.getIfsc())) {
                        bankEMandateNewAcBinding2.tiEtIfsc.setText(mandateAccountDetails2.getIfsc());
                    }
                    if (mandateAccountDetails2.getMandateAuthMode() != null && mandateAccountDetails2.getMandateAuthMode().size() > 0) {
                        bankEMandateNewAcBinding2.includeAuthUsingView.clBankEMandateAuth.setVisibility(0);
                        BankMandateAuthenticateAdapter bankMandateAuthenticateAdapter = new BankMandateAuthenticateAdapter(BankMandateView.this.context, mandateAccountDetails2.getMandateAuthMode(), new BankMandateAuthListener() {
                            public void onAuthTypeSelected(String str) {
                                String unused = BankMandateView.this.authType = str;
                            }
                        });
                        bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setHasFixedSize(true);
                        bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setLayoutManager(new LinearLayoutManager(BankMandateView.this.context));
                        bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setAdapter(bankMandateAuthenticateAdapter);
                    }
                }
            }
        });
        bankEMandateNewAcBinding2.clMainBankMandate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bankEMandateNewAcBinding2.rbBankEMandate.setChecked(true);
                bankEMandateNewAcBinding2.clMainBankMandate.setClickable(false);
            }
        });
        setTextChangeListener();
        bankEMandateNewAcBinding2.btnProceedMandate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(bankEMandateNewAcBinding2.tiEtName.getText().toString()) || bankEMandateNewAcBinding2.tiEtName.getText().toString().length() < 3 || bankEMandateNewAcBinding2.tiEtName.getText().toString().length() > 50) {
                    bankEMandateNewAcBinding2.tilEnterName.setError(BankMandateView.this.context.getResources().getString(R.string.invalid_name_error));
                } else if (TextUtils.isEmpty(bankEMandateNewAcBinding2.tiEtBankAc.getText().toString()) || bankEMandateNewAcBinding2.tiEtBankAc.getText().toString().length() < 9 || bankEMandateNewAcBinding2.tiEtBankAc.getText().toString().length() > 19) {
                    bankEMandateNewAcBinding2.tilEnterBankAc.setError(BankMandateView.this.context.getResources().getString(R.string.invalid_account_number_error));
                } else if (!SDKUtility.isValidIFSCode(bankEMandateNewAcBinding2.tiEtIfsc.getText().toString())) {
                    bankEMandateNewAcBinding2.tilEnterIfsc.setError(BankMandateView.this.context.getResources().getString(R.string.invalid_ifsc_error));
                } else if (TextUtils.isEmpty(BankMandateView.this.authType)) {
                    bankEMandateNewAcBinding2.includeAuthUsingView.tvAuthenticateUsing.setTextColor(BankMandateView.this.context.getResources().getColor(R.color.native_error_color));
                } else {
                    try {
                        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo() != null && BankMandateView.this.context != null) {
                            BankMandateView.this.bankMandateViewModel.getBankMandatePTCModel(bankEMandateNewAcBinding2.tiEtBankAc.getText().toString(), bankEMandateNewAcBinding2.tiEtName.getText().toString(), bankEMandateNewAcBinding2.tiEtIfsc.getText().toString(), BankMandateView.this.authType, BankMandateView.this.channelCode, DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getSubscriptionDetailsInfo(), paymentModes2).observe((q) BankMandateView.this.context, new z<BankMandatePTCModel>() {
                                public void onChanged(BankMandatePTCModel bankMandatePTCModel) {
                                    if (bankMandatePTCModel != null) {
                                        new BankMandateSubscriptionDetailsFragment();
                                        BankMandateSubscriptionDetailsFragment newInstance = BankMandateSubscriptionDetailsFragment.newInstance(bankMandatePTCModel.getAccountHolderName(), bankEMandateNewAcBinding2.tvBankMandateSelectedBank.getText().toString(), bankMandatePTCModel.getAccountNumber(), bankMandatePTCModel.getBankIfsc(), BankMandateView.this.iconUrl, BankMandateView.this.context.getResources().getString(R.string.savings_ac_text), SDKConstants.NEW_MANDATE, BankMandateView.this.authType);
                                        ((InstrumentActivity) BankMandateView.this.context).getSupportFragmentManager().a().a(R.id.fragment_container, newInstance, BankMandateSubscriptionDetailsFragment.class.getSimpleName()).a((String) null).c();
                                        newInstance.setListener(BankMandateView.this);
                                    }
                                }
                            });
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
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
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.NEW_BANK_MANDATE, new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), getProcessTransactionRequest(this.paymentModes.getPaymentMode())));
        transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
        transactionProcessor.setMandateNativeFlow(true);
        transactionProcessor.startTransaction(this.bankEMandateNewAcBinding.btnProceedMandate);
    }

    public HashMap<String, String> getProcessTransactionRequest(String str) {
        return PayUtility.getBankMandatePtcParam(str, DirectPaymentBL.getInstance().getBankMandatePTCModel());
    }

    /* access modifiers changed from: private */
    public void onSelectBank(final BankEMandateNewAcBinding bankEMandateNewAcBinding2, ArrayList<PayChannelOptions> arrayList, int i2, PayChannelOptions payChannelOptions) {
        if (payChannelOptions == null) {
            bankEMandateNewAcBinding2.tvBankMandateSelectedBank.setText(arrayList.get(i2).getChannelName());
            bankEMandateNewAcBinding2.tiEtIfsc.setText("");
            bankEMandateNewAcBinding2.tiEtBankAc.setText("");
            this.channelCode = arrayList.get(i2).getChannelCode();
            this.authType = "";
            b.b(this.context).a(arrayList.get(i2).getIconUrl()).a(bankEMandateNewAcBinding2.ivBankMandateSelectedLogo);
            this.iconUrl = arrayList.get(i2).getIconUrl();
            if (arrayList.get(i2).getMandateAuthMode() != null && arrayList.get(i2).getMandateAuthMode().size() > 0) {
                bankEMandateNewAcBinding2.includeAuthUsingView.clBankEMandateAuth.setVisibility(0);
                BankMandateAuthenticateAdapter bankMandateAuthenticateAdapter = new BankMandateAuthenticateAdapter(this.context, arrayList.get(i2).getMandateAuthMode(), new BankMandateAuthListener() {
                    public void onAuthTypeSelected(String str) {
                        String unused = BankMandateView.this.authType = str;
                        bankEMandateNewAcBinding2.includeAuthUsingView.tvAuthenticateUsing.setTextColor(BankMandateView.this.context.getResources().getColor(R.color.color_222222));
                    }
                });
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setHasFixedSize(true);
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setLayoutManager(new LinearLayoutManager(this.context));
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setAdapter(bankMandateAuthenticateAdapter);
                bankEMandateNewAcBinding2.tvBankMandateFindIfsc.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        new BankMandateFindIFSCFragment();
                        BankMandateFindIFSCFragment newInstance = BankMandateFindIFSCFragment.newInstance();
                        ((InstrumentActivity) BankMandateView.this.context).getSupportFragmentManager().a().a(R.id.fragment_container, newInstance, BankMandateFindIFSCFragment.class.getSimpleName()).a((String) null).c();
                        newInstance.setListener(new BankMandateFindIFSCFragment.BankMandateIFSCSelectListener() {
                            public void onIFSCSelected(String str) {
                                bankEMandateNewAcBinding2.tiEtIfsc.setText(str);
                            }
                        });
                    }
                });
            }
        } else {
            bankEMandateNewAcBinding2.tvBankMandateSelectedBank.setText(payChannelOptions.getChannelName());
            bankEMandateNewAcBinding2.tiEtIfsc.setText("");
            bankEMandateNewAcBinding2.tiEtBankAc.setText("");
            this.channelCode = payChannelOptions.getChannelCode();
            this.authType = "";
            b.b(this.context).a(payChannelOptions.getIconUrl()).a(bankEMandateNewAcBinding2.ivBankMandateSelectedLogo);
            this.iconUrl = payChannelOptions.getIconUrl();
            if (payChannelOptions.getMandateAuthMode() != null && payChannelOptions.getMandateAuthMode().size() > 0) {
                bankEMandateNewAcBinding2.includeAuthUsingView.clBankEMandateAuth.setVisibility(0);
                BankMandateAuthenticateAdapter bankMandateAuthenticateAdapter2 = new BankMandateAuthenticateAdapter(this.context, payChannelOptions.getMandateAuthMode(), new BankMandateAuthListener() {
                    public void onAuthTypeSelected(String str) {
                        String unused = BankMandateView.this.authType = str;
                    }
                });
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setHasFixedSize(true);
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setLayoutManager(new LinearLayoutManager(this.context));
                bankEMandateNewAcBinding2.includeAuthUsingView.rvBankEMandateAuthList.setAdapter(bankMandateAuthenticateAdapter2);
                bankEMandateNewAcBinding2.tvBankMandateFindIfsc.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        new BankMandateFindIFSCFragment();
                        BankMandateFindIFSCFragment newInstance = BankMandateFindIFSCFragment.newInstance();
                        ((InstrumentActivity) BankMandateView.this.context).getSupportFragmentManager().a().a(R.id.fragment_container, newInstance, BankMandateFindIFSCFragment.class.getSimpleName()).a((String) null).c();
                        newInstance.setListener(new BankMandateFindIFSCFragment.BankMandateIFSCSelectListener() {
                            public void onIFSCSelected(String str) {
                                bankEMandateNewAcBinding2.tiEtIfsc.setText(str);
                            }
                        });
                    }
                });
            }
        }
        bankEMandateNewAcBinding2.clBankMandateBankSelect.setVisibility(8);
        bankEMandateNewAcBinding2.clBankMandateBankForm.setVisibility(0);
        bankEMandateNewAcBinding2.tvBankMandateChange.setVisibility(0);
        bankEMandateNewAcBinding2.tvBankMandateFindIfsc.setVisibility(0);
        bankEMandateNewAcBinding2.btnProceedMandate.setVisibility(0);
        bankEMandateNewAcBinding2.tiEtName.setFocusable(true);
        bankEMandateNewAcBinding2.tiEtName.setFocusableInTouchMode(true);
        bankEMandateNewAcBinding2.tiEtBankAc.setFocusable(true);
        bankEMandateNewAcBinding2.tiEtBankAc.setFocusableInTouchMode(true);
        bankEMandateNewAcBinding2.tiEtIfsc.setFocusable(true);
        bankEMandateNewAcBinding2.tiEtIfsc.setFocusableInTouchMode(true);
        bankEMandateNewAcBinding2.tvBankMandateChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bankEMandateNewAcBinding2.clBankMandateBankSelect.setVisibility(0);
                bankEMandateNewAcBinding2.clBankMandateBankForm.setVisibility(8);
                bankEMandateNewAcBinding2.btnProceedMandate.setVisibility(8);
            }
        });
    }

    private void setTextChangeListener() {
        this.bankEMandateNewAcBinding.tiEtName.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void afterTextChanged(Editable editable) {
                BankMandateView.this.bankEMandateNewAcBinding.tilEnterName.setError((CharSequence) null);
            }
        });
        this.bankEMandateNewAcBinding.tiEtBankAc.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void afterTextChanged(Editable editable) {
                BankMandateView.this.bankEMandateNewAcBinding.tilEnterBankAc.setError((CharSequence) null);
            }
        });
        this.bankEMandateNewAcBinding.tiEtIfsc.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void afterTextChanged(Editable editable) {
                BankMandateView.this.bankEMandateNewAcBinding.tilEnterIfsc.setError((CharSequence) null);
            }
        });
    }

    public void closeView() {
        this.bankEMandateNewAcBinding.rbBankEMandate.setChecked(false);
        clearAllSelection();
    }

    public void openAutoInstrument() {
        isOnceClicked = true;
        this.bankEMandateNewAcBinding.rbBankEMandate.setChecked(true);
        this.bankEMandateNewAcBinding.clMainBankMandate.setClickable(false);
    }

    public void clearAllSelection() {
        this.authType = "";
        this.bankEMandateNewAcBinding.clMainBankMandate.setClickable(true);
        this.bankEMandateNewAcBinding.rbBankEMandate.setTypeface((Typeface) null, 0);
        this.bankEMandateNewAcBinding.clBankMandateBankSelect.setVisibility(8);
        this.bankEMandateNewAcBinding.clBankMandateBankForm.setVisibility(8);
        if (this.bankEMandateNewAcBinding.btnProceedMandate.getVisibility() == 0) {
            this.bankEMandateNewAcBinding.btnProceedMandate.setVisibility(8);
        }
        if (this.bankEMandateNewAcBinding.tvBankMandateChange.getVisibility() == 0) {
            this.bankEMandateNewAcBinding.tvBankMandateChange.setVisibility(8);
        }
        if (this.bankEMandateNewAcBinding.tvBankMandateFindIfsc.getVisibility() == 0) {
            this.bankEMandateNewAcBinding.tvBankMandateFindIfsc.setVisibility(8);
        }
        if (this.bankEMandateNewAcBinding.clSelectAllOtherBank.getVisibility() == 0) {
            this.bankEMandateNewAcBinding.clSelectAllOtherBank.setVisibility(8);
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
                ObjectAnimator.ofInt(BankMandateView.this.instruments.getScrollView(), "scrollY", new int[]{((int) (((View) view.getParent()).getY() + view.getY())) - 50}).setDuration(500).start();
            }
        }, 200);
    }
}
