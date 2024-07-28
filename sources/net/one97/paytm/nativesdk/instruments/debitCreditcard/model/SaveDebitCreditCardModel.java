package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;

public class SaveDebitCreditCardModel {
    public i<String> bankName;
    public i<String> cardNumber;
    public ObservableBoolean cardSelected;
    public ObservableInt emiOptionAvailableVisibility = new ObservableInt(8);
    public i<String> imageUrl;
    public ObservableInt lowSuccess = new ObservableInt(8);

    public SaveDebitCreditCardModel(String str, String str2, String str3) {
        this.cardNumber = new i<>(str);
        this.bankName = new i<>(str2);
        this.imageUrl = new i<>(str3);
    }
}
