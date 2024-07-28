package net.one97.paytm.nativesdk.instruments.netbanking.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.g;
import com.bumptech.glide.b;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.netbanking.adapter.NetBankingAdapter;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingListener;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NetBankingViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.listeners.UpiEncouragementListener;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class NetBankingView extends PaytmBaseView implements NetBankingListener {
    private boolean isCalledFromACashierSheet;
    private boolean mIsLoggedIn;
    private PaymentModes netBanking;
    private NetBankingAdapter netBankingAdapter;
    /* access modifiers changed from: private */
    public NativeNetBankingLayoutBinding netBankingLayoutBinding;
    /* access modifiers changed from: private */
    public NetBankingViewModel netBankingViewModel;
    private View selectedUpiPayButton;
    private VpaBankAccountDetail selectedVpaDetail;

    public NetBankingView(Context context, Instruments instruments, boolean z, boolean z2) {
        super(instruments);
        this.context = context;
        this.mIsLoggedIn = z;
        this.isCalledFromACashierSheet = z2;
    }

    public void refreshLayout() {
        this.netBankingViewModel.refreshLayout();
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.notifyDataSetChanged();
        }
        NetBankingViewModel netBankingViewModel2 = this.netBankingViewModel;
        netBankingViewModel2.fetchConvenienceFee(netBankingViewModel2.getLastChannelSelected(), this.netBankingViewModel.getSelectedChannelCode());
    }

    public PaytmBaseView getNetbankingView(PaymentModes paymentModes) {
        this.netBankingLayoutBinding = (NativeNetBankingLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.native_net_banking_layout, (ViewGroup) null, false);
        this.netBankingLayoutBinding.recyclerBankList.setNestedScrollingEnabled(false);
        this.netBanking = paymentModes;
        this.netBankingViewModel = new NetBankingViewModel(this.context, paymentModes, this, this.mIsLoggedIn, this.isCalledFromACashierSheet);
        this.netBankingLayoutBinding.setNetBankingViewModel(this.netBankingViewModel);
        SDKUtility.handlePromotionVisibility(this.netBankingLayoutBinding.tvPromotion, 0);
        this.netBankingLayoutBinding.tvUpiCheckbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NetBankingView.this.netBankingViewModel.upiCheckboxChecked.set(!NetBankingView.this.netBankingViewModel.upiCheckboxChecked.get());
            }
        });
        this.netBankingLayoutBinding.upiPayOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ENCOURAGEMENT, SDKConstants.UPI_NET_BANKING, MerchantBL.getMerchantInstance().getOrderId(), NetBankingView.this.netBankingViewModel.getSelectedChannelName(), MerchantBL.getMerchantInstance().getMid()));
                NetBankingView netBankingView = NetBankingView.this;
                netBankingView.onUpiPayClick(netBankingView.netBankingLayoutBinding.btnProceed, NetBankingView.this.netBankingViewModel.otherSelectedVpa);
            }
        });
        this.view = this.netBankingLayoutBinding.getRoot();
        return this;
    }

    public void hidePaymentsLoader() {
        NativeNetBankingLayoutBinding nativeNetBankingLayoutBinding;
        NetBankingViewModel netBankingViewModel2 = this.netBankingViewModel;
        if (!(netBankingViewModel2 == null || (nativeNetBankingLayoutBinding = this.netBankingLayoutBinding) == null)) {
            netBankingViewModel2.hidePaymentProgressbar(nativeNetBankingLayoutBinding.btnProceed);
        }
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.setHideLoader(true);
            this.netBankingAdapter.notifyDataSetChanged();
        }
    }

    public void hideProceedButtonLoading(View view) {
        NetBankingViewModel netBankingViewModel2 = this.netBankingViewModel;
        if (netBankingViewModel2 != null) {
            netBankingViewModel2.hidePaymentProgressbar(view);
        }
    }

    public void updateAdapter() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.notifyDataSetChanged();
        }
    }

    public void selectItemOnAdapter(int i2) {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.setSelectedPosition(i2);
            this.netBankingAdapter.notifyDataSetChanged();
        }
    }

    public void getBankOffer(PayChannelOptions payChannelOptions) {
        this.netBankingViewModel.getBankOffers(payChannelOptions);
    }

    public void hideCashBackVisibility() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.setShowCashBackText(false);
            this.netBankingAdapter.notifyDataSetChanged();
        }
    }

    public void getConvenienceFee(PayChannelOptions payChannelOptions) {
        this.netBankingViewModel.fetchConvenienceFee(payChannelOptions, "");
    }

    public int getSelectedItem() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            return netBankingAdapter2.getSelectedPosition();
        }
        return 0;
    }

    public void openAutoInstrument() {
        this.netBankingViewModel.setBankListVisiblity((View) null);
        isOnceClicked = true;
    }

    public void onBankListVisible() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 == null || netBankingAdapter2.getBankList().size() <= 0) {
            this.netBankingLayoutBinding.recyclerBankList.setLayoutManager(new LinearLayoutManager(this.context));
            this.netBankingLayoutBinding.recyclerBankList.setItemAnimator(new g());
            if (this.netBanking.getPayChannelOptions() != null) {
                this.netBankingAdapter = new NetBankingAdapter(this.context, this.netBanking.getPayChannelOptions(), this);
            }
            this.netBankingLayoutBinding.recyclerBankList.setAdapter(this.netBankingAdapter);
        } else {
            updateAdapter();
        }
        showHideAnimation(this.netBankingLayoutBinding.recyclerBankList, false);
    }

    public void updateBankIcon(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.context == null) {
                this.netBankingLayoutBinding.imgBank.setVisibility(8);
            } else if (!(this.context instanceof Activity) || !((Activity) this.context).isFinishing()) {
                this.netBankingLayoutBinding.imgBank.setVisibility(0);
                b.b(this.context).a(str).a(this.netBankingLayoutBinding.imgBank);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    private void showHideAnimation(View view, boolean z) {
        if (!z && isOnceClicked) {
            new Handler().post(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(NetBankingView.this.instruments.getScrollView(), "scrollY", new int[]{(int) NetBankingView.this.getView().getY()}).setDuration(500).start();
                }
            });
        }
    }

    public void onProceedClick(View view, PayChannelOptions payChannelOptions, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_NETBANKING, SDKConstants.GA_KEY_NEW, sb.toString(), ""));
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_NB));
        }
        if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || this.context == null) {
            this.netBankingViewModel.setSelectedInstrument(payChannelOptions);
            this.netBankingViewModel.bankSelectedProceedClicked(view);
            if (z) {
                this.netBankingViewModel.makeUpiConsentApiRequest(payChannelOptions.getChannelCode(), z2);
                return;
            }
            return;
        }
        Toast.makeText(this.context, this.context.getString(R.string.otp_not_validated), 0).show();
    }

    public void closeView() {
        this.netBankingAdapter = null;
        NetBankingViewModel netBankingViewModel2 = this.netBankingViewModel;
        netBankingViewModel2.isOtherBankSelected = false;
        netBankingViewModel2.tickImage.set(8);
        this.netBankingViewModel.upiCheckboxLayoutVisibility.set(8);
        this.netBankingViewModel.upiPayOptionVisibility.set(8);
        this.netBankingViewModel.setLastChannelSelected((PayChannelOptions) null);
        this.netBankingViewModel.otherBankText.set(this.context.getResources().getString(R.string.select_from_all_other_banks));
        this.netBankingLayoutBinding.imgBank.setVisibility(8);
        this.netBankingViewModel.showHideBankList();
        this.netBankingViewModel.deselectView();
        this.netBankingLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.netBankingLayoutBinding.txtHeaderInstrunmentName.setTypeface((Typeface) null, 0);
        try {
            SDKUtility.hideKeyboard((Activity) this.context);
        } catch (Exception unused) {
        }
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.netBankingLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_down_chevron_dark);
            this.netBankingLayoutBinding.txtHeaderInstrunmentName.setTypeface((Typeface) null, 1);
            SDKUtility.expand(this.netBankingLayoutBinding.animationLayout, (Integer) null);
            SDKUtility.handlePromotionVisibility(this.netBankingLayoutBinding.tvPromotion, 8);
            return;
        }
        this.netBankingLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.netBankingLayoutBinding.txtHeaderInstrunmentName.setTypeface((Typeface) null, 0);
        SDKUtility.collapse(this.netBankingLayoutBinding.animationLayout);
        SDKUtility.handlePromotionVisibility(this.netBankingLayoutBinding.tvPromotion, 0);
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    public void bankSelected(PayChannelOptions payChannelOptions) {
        this.netBankingViewModel.bankSelected(payChannelOptions);
        this.netBankingViewModel.setSelectedInstrument(payChannelOptions);
    }

    public void updateAdapterWithOffers() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.notifyDataSetChanged();
        }
    }

    public void enableProceedButton() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.setProceedButtonEnabled(true);
        }
        this.netBankingLayoutBinding.btnProceed.setEnabled(true);
        this.netBankingLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.setProceedButtonEnabled(false);
        }
        this.netBankingLayoutBinding.btnProceed.setEnabled(false);
        this.netBankingLayoutBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.netBankingLayoutBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.netBankingLayoutBinding.ltvGetOffers);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.netBankingLayoutBinding.tvBankOffer.setBackgroundColor(i2);
        this.netBankingLayoutBinding.tvBankOffer.setTextColor(i3);
        SDKUtility.setPaddingBankOffer(this.netBankingLayoutBinding.tvBankOffer, z, this.context, 15, 26, 10, 10);
    }

    public Object getVerifyResponseModel() {
        return this.netBankingViewModel.getVerifyResponseModel();
    }

    public void onUpiPayClick(View view, VpaBankAccountDetail vpaBankAccountDetail) {
        this.selectedUpiPayButton = view;
        this.selectedVpaDetail = vpaBankAccountDetail;
        if (SDKUtility.isPaytmApp(this.context) && SDKUtility.isUpiPushEnabled() && this.selectedVpaDetail != null) {
            if (!DirectPaymentBL.getInstance().isBankOffersAvailable() && !ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                SDKUtility.startUpiPush(this.context, this.selectedVpaDetail, SDKConstants.PUSH_FROM_PUSH, String.valueOf(SDKUtility.getDiffAmount()));
            } else if (this.context instanceof UpiEncouragementListener) {
                ((UpiEncouragementListener) this.context).autoSelectUpiPushView(this.selectedVpaDetail.getPgBankCode());
            }
        }
    }

    public void makeUpiPushPayment(String str, String str2, String str3) {
        PaymentInstrument paymentInstrument;
        if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof NetBankingView) {
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), (String) null, PayUtility.getUpiPushRequestParam(str, str2, str3, this.selectedVpaDetail));
            } else {
                paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), PayUtility.getUpiPushRequestParamWebRedirection(str, str2, str3, this.selectedVpaDetail));
            }
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            new TransactionProcessor(this.context, "upi_push", paymentInstrument).startTransaction(this.selectedUpiPayButton);
        }
    }

    public void sendGAEventBackPressed() {
        NetBankingAdapter netBankingAdapter2 = this.netBankingAdapter;
        if (netBankingAdapter2 != null) {
            netBankingAdapter2.sendGAEventBackPressed();
        } else {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_PAYMENT_CONFIRMATION, SDKConstants.GA_NB_BANK_SELECTION_BACK_CLICKED, ""));
        }
    }
}
