package net.one97.paytm.nativesdk.instruments;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ao;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateView;
import net.one97.paytm.nativesdk.bank_mandate.view.SavedBankMandateView;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.view.AOAWalletView;
import net.one97.paytm.nativesdk.instruments.cod.view.CodView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.DebitCreditCreditCardsView;
import net.one97.paytm.nativesdk.instruments.digitalCredit.view.DigitalCreditView;
import net.one97.paytm.nativesdk.instruments.emi.view.EmiView;
import net.one97.paytm.nativesdk.instruments.giftVoucher.GiftVoucherView;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingView;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.view.PaytmPaymentsBankView;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.view.PPBLUpiPushView;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.instruments.wallet.view.WalletView;

public class Instruments {
    private InstrumentListeneres instrumentListeneres;

    public Instruments(InstrumentListeneres instrumentListeneres2) {
        this.instrumentListeneres = instrumentListeneres2;
    }

    public Instruments() {
    }

    public void closeCashierSheet() {
        InstrumentListeneres instrumentListeneres2 = this.instrumentListeneres;
        if (instrumentListeneres2 != null) {
            instrumentListeneres2.closeCashier();
        }
    }

    public NestedScrollView getScrollView() {
        InstrumentListeneres instrumentListeneres2 = this.instrumentListeneres;
        if (instrumentListeneres2 != null) {
            return instrumentListeneres2.getScrollView();
        }
        return null;
    }

    public PaytmBaseView getPgOnlyDebitCardsView(Context context, CJPayMethodResponse cJPayMethodResponse, LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        if (!(cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments().size() <= 0)) {
            ArrayList<SavedInstruments> savedInstruments = cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments();
            for (int i2 = 0; i2 < savedInstruments.size(); i2++) {
                if (savedInstruments.get(i2).getCardDetails() != null && savedInstruments.get(i2).getCardDetails().getCardType().contains(SDKConstants.DEBIT)) {
                    arrayList.add(savedInstruments.get(i2));
                }
            }
        }
        return getPgOnlyDebitCardsView(context, (List<SavedInstruments>) arrayList, linearLayout);
    }

    public PaytmBaseView getPgOnlyDebitCardsView(Context context, List<SavedInstruments> list, LinearLayout linearLayout) {
        return new DebitCreditCreditCardsView(context, false, false, this, linearLayout).getDebitCreditCardsView(list);
    }

    public PaytmBaseView getPgOnlyCreditCardsView(Context context, CJPayMethodResponse cJPayMethodResponse, LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        if (!(cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments().size() <= 0)) {
            ArrayList<SavedInstruments> savedInstruments = cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments();
            for (int i2 = 0; i2 < savedInstruments.size(); i2++) {
                if (savedInstruments.get(i2).getCardDetails() != null && savedInstruments.get(i2).getCardDetails().getCardType().contains(SDKConstants.CREDIT)) {
                    arrayList.add(savedInstruments.get(i2));
                }
            }
        }
        return getPgOnlyCreditCardsView(context, (List<SavedInstruments>) arrayList, linearLayout);
    }

    public PaytmBaseView getPgOnlyCreditCardsView(Context context, List<SavedInstruments> list, LinearLayout linearLayout) {
        return new DebitCreditCreditCardsView(context, true, false, this, linearLayout).getDebitCreditCardsView(list);
    }

    public PaytmBaseView getEmiView(Context context, PaymentModes paymentModes) {
        return new EmiView(context, this, paymentModes).getEmiView();
    }

    public PaytmBaseView getAddMoneyDebitCardView(Context context, CJPayMethodResponse cJPayMethodResponse, LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        if (cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments() != null && cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments().size() > 0) {
            ArrayList<SavedInstruments> savedInstruments = cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments();
            for (int i2 = 0; i2 < savedInstruments.size(); i2++) {
                if (savedInstruments.get(i2).getCardDetails() != null && savedInstruments.get(i2).getCardDetails().getCardType().contains(SDKConstants.DEBIT)) {
                    arrayList.add(savedInstruments.get(i2));
                }
            }
        }
        return getAddMoneyDebitCardView(context, (List<SavedInstruments>) arrayList, linearLayout);
    }

    public PaytmBaseView getAddMoneyDebitCardView(Context context, List<SavedInstruments> list, LinearLayout linearLayout) {
        return new DebitCreditCreditCardsView(context, false, false, this, linearLayout).getDebitCreditCardsView(list);
    }

    public PaytmBaseView getAddMoneyCreditCardView(Context context, CJPayMethodResponse cJPayMethodResponse, LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        if (cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments() != null && cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments().size() > 0) {
            ArrayList<SavedInstruments> savedInstruments = cJPayMethodResponse.getBody().getAddMoneyPayOption().getSavedInstruments();
            for (int i2 = 0; i2 < savedInstruments.size(); i2++) {
                if (savedInstruments.get(i2).getCardDetails() != null && savedInstruments.get(i2).getCardDetails().getCardType().contains(SDKConstants.CREDIT)) {
                    arrayList.add(savedInstruments.get(i2));
                }
            }
        }
        return getAddMoneyCreditCardView(context, (List<SavedInstruments>) arrayList, linearLayout);
    }

    public PaytmBaseView getAddMoneyCreditCardView(Context context, List<SavedInstruments> list, LinearLayout linearLayout) {
        return new DebitCreditCreditCardsView(context, true, false, this, linearLayout).getDebitCreditCardsView(list);
    }

    public PaytmBaseView getNetBankingView(Context context, PaymentModes paymentModes, boolean z, boolean z2) {
        return new NetBankingView(context, this, z, z2).getNetbankingView(paymentModes);
    }

    public PaytmBaseView getWalletView(Context context, PaymentModes paymentModes, boolean z, InstrumentsSelectionManager instrumentsSelectionManager) {
        return new WalletView(context, this, z).getWalletView(paymentModes, instrumentsSelectionManager);
    }

    public PaytmBaseView getBankMandateView(Context context, PaymentModes paymentModes, MandateAccountDetails mandateAccountDetails, InstrumentsSelectionManager instrumentsSelectionManager) {
        return new BankMandateView(context, mandateAccountDetails, paymentModes, this).getBankMandateView(paymentModes, mandateAccountDetails, instrumentsSelectionManager);
    }

    public PaytmBaseView getSavedMandateView(Context context, PaymentModes paymentModes, SavedMandateBanksItem savedMandateBanksItem, InstrumentsSelectionManager instrumentsSelectionManager) {
        return new SavedBankMandateView(context, savedMandateBanksItem, paymentModes, this).getSavedMandateView(paymentModes, savedMandateBanksItem, instrumentsSelectionManager);
    }

    public PaytmBaseView getPaytmPaymentsBankView(Context context, PaymentModes paymentModes, boolean z, boolean z2) {
        return new PaytmPaymentsBankView(context, this, z).getBankView(paymentModes, z2);
    }

    public PaytmBaseView getDigitalCreditView(Context context, PaymentModes paymentModes, boolean z) {
        return new DigitalCreditView(context, this, z).getDigitalCreditView(paymentModes);
    }

    public PaytmBaseView getUpiCollectViewNew(Context context, PaymentModes paymentModes) {
        return new UpiCollectViewNew(context, this, paymentModes).getUpiCollectView();
    }

    public <T extends ao> PaytmBaseView getGiftVoucherView(T t, Context context, PaymentModes paymentModes, Boolean bool) {
        return new GiftVoucherView(t, context, this, paymentModes, bool.booleanValue());
    }

    public PaytmBaseView getUpiPushViewSingle(Context context, VpaBankAccountDetail vpaBankAccountDetail, PaymentModes paymentModes) {
        if ("Paytm Payments Bank".equalsIgnoreCase(vpaBankAccountDetail.getBank())) {
            return new PPBLUpiPushView(context, vpaBankAccountDetail, paymentModes, this).getUpiPushView();
        }
        return new UpiPushView(context, vpaBankAccountDetail, paymentModes, this).getUpiPushView();
    }

    public PaytmBaseView getCODView(Context context) {
        return new CodView(context, this).getCODView();
    }

    public PaytmBaseView getAoaWalletView(Context context) {
        return new AOAWalletView(context, this).getAoaWalletView();
    }

    public PaytmBaseView getSavedCardView(Context context, SavedInstruments savedInstruments, boolean z) {
        return new SavedCardView(context, savedInstruments, this, z).getSavedCardView();
    }

    public void loadInstruments(boolean z) {
        InstrumentListeneres instrumentListeneres2 = this.instrumentListeneres;
        if (instrumentListeneres2 != null) {
            instrumentListeneres2.loadInstruments(z);
        }
    }
}
