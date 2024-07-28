package net.one97.paytm.nativesdk.instruments.netbanking.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.f;
import androidx.databinding.i;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.databinding.RowNetBankingLayoutBinding;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingListener;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NBAdapterViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;

public class NetBankingAdapter extends RecyclerView.a<ViewHolder> {
    public NBAdapterViewModel NBAdapterViewModel;
    /* access modifiers changed from: private */
    public boolean hideLoader = false;
    private boolean isProceedButtonEnabled = true;
    /* access modifiers changed from: private */
    public int lastSelectedItem = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public NetBankingListener netBankingListener;
    /* access modifiers changed from: private */
    public List<PayChannelOptions> payChannelOptions = new ArrayList();
    /* access modifiers changed from: private */
    public int selectedPosition = -1;
    private boolean showCashBackText = true;

    public static class NBItemViewModel {
        public i<String> amount = new i<>("");
        public ObservableBoolean applyPromoFailed = new ObservableBoolean(false);
        public i<String> bankOfferText = new i<>("");
        public ObservableInt bankOfferVisibility = new ObservableInt(8);
        public ObservableBoolean bankSelectionProceedVisible = new ObservableBoolean(false);
        public i<String> cashBackText = new i<>("");
        public ObservableInt cashBackTextVisibility = new ObservableInt(8);
        public i<String> channelName = new i<>("");
        public i<String> convFeeText = new i<>("");
        public ObservableInt convFeeTextVisibility = new ObservableInt(8);
        public i<String> disableMessage = new i<>("");
        public ObservableInt disableMessageVisibility = new ObservableInt(8);
        public i<String> iconUrl = new i<>("");
        public ObservableBoolean isGreenTickVisible = new ObservableBoolean(false);
        public i<String> loaderMsg = new i<>("");
        public ObservableInt lowSuccessVisibility = new ObservableInt(8);
        public i<String> paySecurelyText = new i<>();
    }

    public void setHideLoader(boolean z) {
        this.hideLoader = z;
    }

    public NetBankingAdapter(Context context, List<PayChannelOptions> list, NetBankingListener netBankingListener2) {
        this.payChannelOptions.addAll(list);
        this.netBankingListener = netBankingListener2;
        this.NBAdapterViewModel = new NBAdapterViewModel(netBankingListener2);
        this.mContext = context;
    }

    public void setShowCashBackText(boolean z) {
        this.showCashBackText = z;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder((RowNetBankingLayoutBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.row_net_banking_layout, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i2) {
        final PayChannelOptions payChannelOptions2 = this.payChannelOptions.get(i2);
        boolean isConvenienceFeeEnabled = ConvenienceFeeController.getInstance().isConvenienceFeeEnabled();
        viewHolder.mBinding.procced.setVisibility(8);
        viewHolder.mBinding.procced.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_CONSENT_STATUS, String.valueOf(viewHolder.mBinding.cbUpiCheckbox.isChecked()), "net_banking|".concat(String.valueOf((NetBankingAdapter.this.getSelectedPosition() < 0 || NetBankingAdapter.this.getSelectedPosition() >= NetBankingAdapter.this.payChannelOptions.size()) ? "" : ((PayChannelOptions) NetBankingAdapter.this.payChannelOptions.get(NetBankingAdapter.this.getSelectedPosition())).getChannelName())), MerchantBL.getMerchantInstance().getMid()));
                boolean z = false;
                boolean unused = NetBankingAdapter.this.hideLoader = false;
                NetBankingListener access$300 = NetBankingAdapter.this.netBankingListener;
                PayChannelOptions payChannelOptions = payChannelOptions2;
                if (viewHolder.mBinding.llUpiCheckbox.getVisibility() == 0) {
                    z = true;
                }
                access$300.onProceedClick(view, payChannelOptions, z, viewHolder.mBinding.cbUpiCheckbox.isChecked());
            }
        });
        viewHolder.mBinding.btnProceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String channelName = (NetBankingAdapter.this.getSelectedPosition() < 0 || NetBankingAdapter.this.getSelectedPosition() >= NetBankingAdapter.this.payChannelOptions.size()) ? "" : ((PayChannelOptions) NetBankingAdapter.this.payChannelOptions.get(NetBankingAdapter.this.getSelectedPosition())).getChannelName();
                String concat = "net_banking|".concat(String.valueOf(channelName));
                boolean z = false;
                if (!SDKUtility.shouldShowValidatePromoError() || (!viewHolder.nbItemViewModel.applyPromoFailed.get() && !DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_PAYMENT_CONFIRMATION, SDKConstants.GA_NB_BANK_SELECTION_PAYMENT_CONFIRMED, channelName));
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_CONSENT_STATUS, String.valueOf(viewHolder.mBinding.cbUpiCheckbox.isChecked()), concat, MerchantBL.getMerchantInstance().getMid()));
                    boolean unused = NetBankingAdapter.this.hideLoader = false;
                    NetBankingListener access$300 = NetBankingAdapter.this.netBankingListener;
                    PayChannelOptions payChannelOptions = payChannelOptions2;
                    if (viewHolder.mBinding.llUpiCheckbox.getVisibility() == 0) {
                        z = true;
                    }
                    access$300.onProceedClick(view, payChannelOptions, z, viewHolder.mBinding.cbUpiCheckbox.isChecked());
                    return;
                }
                viewHolder.nbItemViewModel.bankOfferVisibility.set(0);
                viewHolder.nbItemViewModel.bankOfferText.set(NetBankingAdapter.this.mContext.getString(R.string.applied_promocode_not_valid));
                viewHolder.mBinding.tvBankOffer.setBackgroundColor(b.c(NetBankingAdapter.this.mContext, R.color.white));
                viewHolder.mBinding.tvBankOffer.setTextColor(b.c(NetBankingAdapter.this.mContext, R.color.color_fd5c5c));
            }
        });
        viewHolder.mBinding.tvUpiCheckbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                viewHolder.mBinding.cbUpiCheckbox.setChecked(!viewHolder.mBinding.cbUpiCheckbox.isChecked());
            }
        });
        viewHolder.nbItemViewModel.channelName.set(payChannelOptions2.getChannelName());
        if (!(DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getIconBaseUrl() == null)) {
            i<String> iVar = viewHolder.nbItemViewModel.iconUrl;
            iVar.set(DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getIconBaseUrl() + payChannelOptions2.getIconUrl());
        }
        if (i2 == this.selectedPosition) {
            if (payChannelOptions2.showCheckingOffer) {
                if (isConvenienceFeeEnabled) {
                    viewHolder.nbItemViewModel.loaderMsg.set(this.mContext.getString(R.string.conv_fee_fetching));
                } else {
                    viewHolder.nbItemViewModel.loaderMsg.set(this.mContext.getString(R.string.native_checking_offers));
                }
                viewHolder.mBinding.llCheckOffer.setVisibility(0);
                SDKUtility.startAnimation(viewHolder.mBinding.ltvCheckingOffer);
            } else {
                viewHolder.mBinding.llCheckOffer.setVisibility(8);
                SDKUtility.stopAnimation(viewHolder.mBinding.ltvCheckingOffer);
            }
            viewHolder.nbItemViewModel.isGreenTickVisible.set(true);
            viewHolder.nbItemViewModel.bankSelectionProceedVisible.set(true);
            if (payChannelOptions2.getHasLowSuccess() == null || !payChannelOptions2.getHasLowSuccess().getStatus()) {
                viewHolder.nbItemViewModel.lowSuccessVisibility.set(8);
            } else {
                viewHolder.nbItemViewModel.lowSuccessVisibility.set(0);
                viewHolder.mBinding.txtSuccessrate.setText(payChannelOptions2.getHasLowSuccess().getMsg());
            }
            String netPaySecurelyText = SDKUtility.getNetPaySecurelyText(this.mContext, getTotalInstantDiscount(payChannelOptions2), payChannelOptions2.getConvenienceFee());
            ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer(payChannelOptions2);
            if (!SDKUtility.isOfferValid(paymentOffer) || paymentOffer.getOfferBreakup() == null || paymentOffer.getOfferBreakup().size() <= 0) {
                viewHolder.nbItemViewModel.bankOfferVisibility.set(8);
                viewHolder.nbItemViewModel.cashBackTextVisibility.set(8);
                viewHolder.nbItemViewModel.paySecurelyText.set(netPaySecurelyText);
                viewHolder.nbItemViewModel.applyPromoFailed.set(true);
                if (SDKUtility.shouldShowValidatePromoError() && !payChannelOptions2.showCheckingOffer && !DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY)) {
                    viewHolder.nbItemViewModel.bankOfferVisibility.set(0);
                    viewHolder.nbItemViewModel.bankOfferText.set(this.mContext.getString(R.string.applied_promocode_not_valid));
                    viewHolder.mBinding.tvBankOffer.setBackgroundColor(b.c(this.mContext, R.color.white));
                    viewHolder.mBinding.tvBankOffer.setTextColor(b.c(this.mContext, R.color.color_fd5c5c));
                }
            } else if (paymentOffer.getTotalCashbackAmount() != null) {
                viewHolder.mBinding.tvBankOffer.setBackgroundColor(b.c(this.mContext, R.color.color_e8f8f1));
                viewHolder.mBinding.tvBankOffer.setTextColor(b.c(this.mContext, R.color.color_21c17a));
                viewHolder.nbItemViewModel.bankOfferVisibility.set(0);
                viewHolder.nbItemViewModel.bankOfferText.set(this.mContext.getString(R.string.cashback_applied_successfully, new Object[]{paymentOffer.getTotalCashbackAmount()}));
                if (this.showCashBackText) {
                    viewHolder.nbItemViewModel.cashBackTextVisibility.set(0);
                } else {
                    viewHolder.nbItemViewModel.cashBackTextVisibility.set(8);
                }
                viewHolder.nbItemViewModel.cashBackText.set(this.mContext.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalCashbackAmount()))}));
                viewHolder.nbItemViewModel.paySecurelyText.set(netPaySecurelyText);
                viewHolder.nbItemViewModel.applyPromoFailed.set(false);
            } else if (paymentOffer.getTotalInstantDiscount() != null) {
                viewHolder.mBinding.tvBankOffer.setBackgroundColor(b.c(this.mContext, R.color.color_e8f8f1));
                viewHolder.mBinding.tvBankOffer.setTextColor(b.c(this.mContext, R.color.color_21c17a));
                viewHolder.nbItemViewModel.bankOfferVisibility.set(0);
                viewHolder.nbItemViewModel.cashBackTextVisibility.set(8);
                viewHolder.nbItemViewModel.bankOfferText.set(this.mContext.getString(R.string.instant_discount_applied_successfully, new Object[]{paymentOffer.getTotalInstantDiscount()}));
                viewHolder.nbItemViewModel.paySecurelyText.set(this.mContext.getString(R.string.nativesdk_amount_pay, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalInstantDiscount()))}));
                viewHolder.nbItemViewModel.applyPromoFailed.set(false);
            } else {
                viewHolder.nbItemViewModel.bankOfferVisibility.set(8);
                viewHolder.nbItemViewModel.cashBackTextVisibility.set(8);
                viewHolder.nbItemViewModel.paySecurelyText.set(netPaySecurelyText);
                viewHolder.nbItemViewModel.applyPromoFailed.set(false);
                if (SDKUtility.shouldShowValidatePromoError()) {
                    viewHolder.nbItemViewModel.bankOfferVisibility.set(0);
                    viewHolder.nbItemViewModel.bankOfferText.set(paymentOffer.getOfferBreakup().get(0).getPromotext());
                }
            }
            if (isConvenienceFeeEnabled && payChannelOptions2.isConvFeeLoading()) {
                SDKUtility.startAnimation(viewHolder.mBinding.ltvCheckingOffer);
                viewHolder.mBinding.llCheckOffer.setVisibility(0);
                viewHolder.nbItemViewModel.loaderMsg.set(this.mContext.getString(R.string.conv_fee_fetching));
            } else if (!isConvenienceFeeEnabled || payChannelOptions2.isConvFeeLoading() || payChannelOptions2.showCheckingOffer) {
                viewHolder.nbItemViewModel.paySecurelyText.set(netPaySecurelyText);
            } else {
                viewHolder.nbItemViewModel.paySecurelyText.set(netPaySecurelyText);
                if (!TextUtils.isEmpty(payChannelOptions2.getConvFeeText())) {
                    viewHolder.nbItemViewModel.convFeeText.set(payChannelOptions2.getConvFeeText());
                    viewHolder.nbItemViewModel.convFeeTextVisibility.set(0);
                    if (getPaymentOffer(payChannelOptions2) != null && !TextUtils.isEmpty(getPaymentOffer(payChannelOptions2).getTotalCashbackAmount())) {
                        String netPayableAmount = SDKUtility.getNetPayableAmount(this.mContext, SDKUtility.parseDouble(getPaymentOffer(payChannelOptions2).getTotalCashbackAmount()), payChannelOptions2.getConvenienceFee());
                        viewHolder.nbItemViewModel.cashBackText.set(this.mContext.getString(R.string.effective_cashback_price, new Object[]{netPayableAmount}));
                    }
                } else {
                    viewHolder.nbItemViewModel.convFeeTextVisibility.set(8);
                }
                viewHolder.mBinding.llCheckOffer.setVisibility(8);
                SDKUtility.stopAnimation(viewHolder.mBinding.ltvCheckingOffer);
            }
            if (SDKUtils.isToShowUpiConsent(payChannelOptions2.getChannelCode())) {
                viewHolder.mBinding.llUpiCheckbox.setVisibility(0);
                viewHolder.mBinding.cbUpiCheckbox.setChecked(true);
                viewHolder.mBinding.tvUpiCheckbox.setText(this.mContext.getString(R.string.native_upi_consent_text, new Object[]{payChannelOptions2.getChannelName()}));
            } else {
                viewHolder.mBinding.llUpiCheckbox.setVisibility(8);
                viewHolder.mBinding.cbUpiCheckbox.setChecked(false);
                VpaBankAccountDetail unused = viewHolder.vpaBankAccountDetail = SDKUtils.isToShowUpiPayOption(payChannelOptions2.getChannelCode(), this.mContext);
                if ((viewHolder.vpaBankAccountDetail == null || viewHolder.vpaBankAccountDetail.getBankMetaData() == null || TextUtils.isEmpty(viewHolder.vpaBankAccountDetail.getBankMetaData().getPerTxnLimit()) || Double.parseDouble(viewHolder.vpaBankAccountDetail.getBankMetaData().getPerTxnLimit()) >= SDKUtility.getDiffAmount()) && SDKUtility.isPaytmApp(this.mContext) && SDKUtility.isUpiPushEnabled() && viewHolder.vpaBankAccountDetail != null) {
                    viewHolder.mBinding.upiPayOption.setVisibility(0);
                    viewHolder.mBinding.upiPayText.setText(this.mContext.getString(R.string.native_upi_option_text, new Object[]{payChannelOptions2.getChannelName()}));
                } else {
                    viewHolder.mBinding.upiPayOption.setVisibility(8);
                }
            }
            viewHolder.mBinding.upiPayOption.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ENCOURAGEMENT, SDKConstants.UPI_NET_BANKING, MerchantBL.getMerchantInstance().getOrderId(), ((PayChannelOptions) NetBankingAdapter.this.payChannelOptions.get(NetBankingAdapter.this.getSelectedPosition())).getChannelName(), MerchantBL.getMerchantInstance().getMid()));
                    NetBankingAdapter.this.netBankingListener.onUpiPayClick(viewHolder.mBinding.btnProceed, viewHolder.vpaBankAccountDetail);
                }
            });
        } else {
            viewHolder.nbItemViewModel.isGreenTickVisible.set(false);
            viewHolder.nbItemViewModel.bankSelectionProceedVisible.set(false);
            viewHolder.nbItemViewModel.lowSuccessVisibility.set(8);
            viewHolder.nbItemViewModel.amount.set("");
            viewHolder.nbItemViewModel.bankOfferVisibility.set(8);
            viewHolder.nbItemViewModel.cashBackTextVisibility.set(8);
            viewHolder.nbItemViewModel.bankOfferVisibility.set(8);
            viewHolder.mBinding.llCheckOffer.setVisibility(8);
            viewHolder.nbItemViewModel.convFeeTextVisibility.set(8);
            SDKUtility.stopAnimation(viewHolder.mBinding.ltvCheckingOffer);
            viewHolder.mBinding.llUpiCheckbox.setVisibility(8);
            viewHolder.mBinding.cbUpiCheckbox.setChecked(false);
            viewHolder.mBinding.upiPayOption.setVisibility(8);
            setEnableDisableBank(viewHolder, payChannelOptions2);
        }
        viewHolder.mBinding.btnProceed.setClickable(this.isProceedButtonEnabled);
        viewHolder.mBinding.btnProceed.setEnabled(this.isProceedButtonEnabled);
        viewHolder.mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (payChannelOptions2.getIsDisabled() == null || !payChannelOptions2.getIsDisabled().getStatus()) {
                    int unused = NetBankingAdapter.this.selectedPosition = viewHolder.getLayoutPosition();
                    NetBankingAdapter.this.netBankingListener.bankSelected(payChannelOptions2);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_PAYMENT_CONFIRMATION, SDKConstants.GA_NB_BANK_SELECTED, payChannelOptions2.getChannelName()));
                    if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                        NetBankingAdapter.this.netBankingListener.getBankOffer(payChannelOptions2);
                    } else {
                        NetBankingAdapter.this.netBankingListener.getConvenienceFee(payChannelOptions2);
                    }
                    if (NetBankingAdapter.this.lastSelectedItem != -1) {
                        ((PayChannelOptions) NetBankingAdapter.this.payChannelOptions.get(NetBankingAdapter.this.lastSelectedItem)).setProceedVisible(false);
                        NetBankingAdapter netBankingAdapter = NetBankingAdapter.this;
                        netBankingAdapter.notifyItemChanged(netBankingAdapter.lastSelectedItem);
                    }
                    if (payChannelOptions2.getHasLowSuccess() == null || !payChannelOptions2.getHasLowSuccess().getStatus()) {
                        NetBankingAdapter netBankingAdapter2 = NetBankingAdapter.this;
                        int unused2 = netBankingAdapter2.lastSelectedItem = netBankingAdapter2.selectedPosition;
                        NetBankingAdapter.this.notifyDataSetChanged();
                    } else if (!payChannelOptions2.isProceedVisible()) {
                        payChannelOptions2.setProceedVisible(true);
                        NetBankingAdapter netBankingAdapter3 = NetBankingAdapter.this;
                        netBankingAdapter3.notifyItemChanged(netBankingAdapter3.selectedPosition);
                    }
                }
            }
        });
        if (this.hideLoader) {
            this.netBankingListener.hideProceedButtonLoading(viewHolder.mBinding.btnProceed);
        }
    }

    private ApplyPromoResponse.PaymentOffer getPaymentOffer(PayChannelOptions payChannelOptions2) {
        return SDKUtility.isHybridCase() ? payChannelOptions2.getHybridPaymentOffer() : payChannelOptions2.getPaymentOffer();
    }

    private double getTotalInstantDiscount(PayChannelOptions payChannelOptions2) {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer(payChannelOptions2);
        if (paymentOffer == null || TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount())) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    public int getItemCount() {
        return this.payChannelOptions.size();
    }

    public void sendGAEventBackPressed() {
        int i2 = this.selectedPosition;
        if (i2 != -1) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_PAYMENT_CONFIRMATION, SDKConstants.GA_NB_BANK_SELECTION_BACK_CLICKED, this.payChannelOptions.get(i2).getChannelName()));
        }
    }

    public static class ViewHolder extends RecyclerView.v {
        /* access modifiers changed from: private */
        public RowNetBankingLayoutBinding mBinding;
        /* access modifiers changed from: private */
        public NBItemViewModel nbItemViewModel = new NBItemViewModel();
        /* access modifiers changed from: private */
        public VpaBankAccountDetail vpaBankAccountDetail;

        public ViewHolder(RowNetBankingLayoutBinding rowNetBankingLayoutBinding) {
            super(rowNetBankingLayoutBinding.getRoot());
            this.mBinding = rowNetBankingLayoutBinding;
            this.mBinding.setNetbanking(this.nbItemViewModel);
            this.mBinding.executePendingBindings();
        }
    }

    public List<PayChannelOptions> getBankList() {
        return this.payChannelOptions;
    }

    public void setSelectedPosition(int i2) {
        this.selectedPosition = i2;
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public void setProceedButtonEnabled(boolean z) {
        this.isProceedButtonEnabled = z;
        notifyDataSetChanged();
    }

    private void setEnableDisableBank(ViewHolder viewHolder, PayChannelOptions payChannelOptions2) {
        if (payChannelOptions2 == null || payChannelOptions2.getIsDisabled() == null || !payChannelOptions2.getIsDisabled().getStatus()) {
            viewHolder.mBinding.imgBank.setAlpha(1.0f);
            viewHolder.mBinding.txtBankName.setAlpha(1.0f);
            viewHolder.nbItemViewModel.disableMessageVisibility.set(8);
            viewHolder.nbItemViewModel.disableMessage.set("");
            return;
        }
        viewHolder.mBinding.imgBank.setAlpha(0.4f);
        viewHolder.mBinding.txtBankName.setAlpha(0.4f);
        viewHolder.nbItemViewModel.disableMessageVisibility.set(0);
        viewHolder.nbItemViewModel.disableMessage.set(this.mContext.getString(R.string.disable_paymode_error_message));
    }
}
