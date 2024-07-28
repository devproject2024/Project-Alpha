package net.one97.paytm.nativesdk.instruments.giftVoucher;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import androidx.localbroadcastmanager.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.AccountBalance;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public final class GiftVoucherView<T extends ao> extends PaytmBaseView implements p {
    private final TextView amount;
    private final View btnProceed;
    private double gvBalance;
    private final TextView gvName;
    private final View instrumentContainer;
    private final RadioButton instrumentRadioButton;
    private final boolean isValid;
    private TextView mTvErrorOffer;
    private final PaymentModes paymentModes;
    private final GiftVoucherViewModel viewModel;

    public final PaymentModes getPaymentModes() {
        return this.paymentModes;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GiftVoucherView(T t, Context context, Instruments instruments, PaymentModes paymentModes2, boolean z) {
        super(instruments);
        PayChannelOptions payChannelOptions;
        BalanceInfo balanceInfo;
        AccountBalance accountBalance;
        String value;
        Double b2;
        k.c(t, "viewModelStoreOwner");
        k.c(context, "context");
        k.c(instruments, "instruments");
        k.c(paymentModes2, "paymentModes");
        this.paymentModes = paymentModes2;
        this.isValid = z;
        ExtensionsKt.attachToLifecycleOwner(this, context);
        PaymentModes paymentModes3 = this.paymentModes;
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, "Gift Voucher", (PaymentInstrument) null);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ai a2 = new al((ao) t, (al.b) new GiftVoucherViewModelFactory(paymentModes3, transactionProcessor, (Application) applicationContext)).a(GiftVoucherViewModel.class);
            k.a((Object) a2, "ViewModelProvider(this, …elFactory)[T::class.java]");
            this.viewModel = (GiftVoucherViewModel) a2;
            View inflate = LayoutInflater.from(context).inflate(R.layout.instrument_gift_voucher, (ViewGroup) null, false);
            this.view = inflate;
            this.context = context;
            View findViewById = inflate.findViewById(R.id.instrument_container);
            k.a((Object) findViewById, "view.findViewById<Linear….id.instrument_container)");
            this.instrumentContainer = findViewById;
            View findViewById2 = inflate.findViewById(R.id.gv_name);
            k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.gv_name)");
            this.gvName = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.btnProceed);
            k.a((Object) findViewById3, "view.findViewById(R.id.btnProceed)");
            this.btnProceed = findViewById3;
            this.btnProceed.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ GiftVoucherView this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.proceedButtonClicked();
                }
            });
            View findViewById4 = inflate.findViewById(R.id.radio_button);
            k.a((Object) findViewById4, "view.findViewById(R.id.radio_button)");
            this.instrumentRadioButton = (RadioButton) findViewById4;
            View findViewById5 = inflate.findViewById(R.id.amount);
            k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.amount)");
            this.amount = (TextView) findViewById5;
            this.gvName.setText(this.paymentModes.getDisplayName());
            this.mTvErrorOffer = (TextView) inflate.findViewById(R.id.tv_bank_offer_error);
            this.instrumentContainer.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ GiftVoucherView this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.selectOrDeselect();
                }
            });
            updateAmountView();
            ArrayList<PayChannelOptions> payChannelOptions2 = this.paymentModes.getPayChannelOptions();
            if (!(payChannelOptions2 == null || (payChannelOptions = (PayChannelOptions) kotlin.a.k.e(payChannelOptions2)) == null || (balanceInfo = payChannelOptions.getBalanceInfo()) == null || (accountBalance = balanceInfo.getAccountBalance()) == null || (value = accountBalance.getValue()) == null || (b2 = kotlin.m.p.b(value)) == null)) {
                this.gvBalance = b2.doubleValue();
            }
            this.amount.setText(context.getString(R.string.nativesdk_balance, new Object[]{String.valueOf(this.gvBalance)}));
            if (!this.isValid) {
                disableView();
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    /* access modifiers changed from: private */
    public final void selectOrDeselect() {
        try {
            if (!androidx.core.h.u.M(this.view)) {
                return;
            }
            if (!this.instrumentRadioButton.isChecked()) {
                selectView();
            } else {
                closeView();
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    /* access modifiers changed from: private */
    public final void proceedButtonClicked() {
        if (SDKUtility.shouldShowValidatePromoError()) {
            showBankOfferText();
            return;
        }
        GiftVoucherViewModel giftVoucherViewModel = this.viewModel;
        View findViewById = this.view.findViewById(R.id.btnProceed);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.btnProceed)");
        giftVoucherViewModel.goForTransaction(findViewById);
    }

    private final void showBankOfferText() {
        TextView textView = this.mTvErrorOffer;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void openAutoInstrument() {
        selectView();
        PaytmBaseView.isOnceClicked = true;
    }

    private final void selectNextInstrument() {
        Intent intent = new Intent();
        intent.setAction(SDKConstants.SELECT_NEXT_INSTRUMENT);
        intent.putExtra(SDKConstants.SELECTED_INSTRUMENT, "Gift Voucher");
        Context context = this.context;
        k.a((Object) context, "context");
        a.a(context.getApplicationContext()).a(intent);
    }

    private final void disableView() {
        setDisabled(true);
        ExtensionsKt.gone(this.btnProceed);
        this.gvName.setTypeface((Typeface) null, 0);
        this.gvName.setAlpha(0.4f);
        this.amount.setAlpha(0.4f);
        this.instrumentContainer.setAlpha(0.4f);
        this.instrumentRadioButton.setAlpha(0.4f);
        this.instrumentContainer.setClickable(false);
        this.instrumentContainer.setFocusable(false);
    }

    private final void selectView() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String amount2 = merchantInstance.getAmount();
        k.a((Object) amount2, "MerchantBL.getMerchantInstance().amount");
        if (SDKUtility.parseDouble(kotlin.m.p.a(amount2, AppConstants.COMMA, "", false)) <= this.gvBalance) {
            setDisabled(false);
            ExtensionsKt.visible(this.btnProceed);
            this.instrumentRadioButton.setChecked(true);
            setSelected(true);
            onInstrumentSelected();
            this.gvName.setTypeface((Typeface) null, 1);
            scrollToTop();
            updateAmountView();
            return;
        }
        disableView();
        selectNextInstrument();
    }

    private final void updateAmountView() {
        View findViewById = this.view.findViewById(R.id.paysecurely);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.paysecurely)");
        ((TextView) findViewById).setText(SDKUtility.getNetPaySecurelyText(this.context, 0.0d, 0.0d));
    }

    private final void scrollToTop() {
        new Handler().postDelayed(new GiftVoucherView$scrollToTop$1(this), 200);
    }

    private final void deselectWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.DESELECT_WALLET);
            a.a(this.context).b(intent);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    private final void onInstrumentSelected() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isPaytmWalletChecked()) {
            deselectWallet();
        }
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        instance2.setPaytmBaseView(this);
    }

    public final void closeView() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.setPaytmBaseView((PaytmBaseView) null);
        this.instrumentRadioButton.setChecked(false);
        ExtensionsKt.gone(this.btnProceed);
        setSelected(false);
        this.gvName.setTypeface((Typeface) null, 0);
    }

    public final void refreshLayout() {
        super.refreshLayout();
        closeView();
    }
}
