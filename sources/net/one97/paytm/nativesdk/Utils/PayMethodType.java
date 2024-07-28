package net.one97.paytm.nativesdk.Utils;

public enum PayMethodType {
    CREDIT_CARD(1),
    DEBIT_CARD(2),
    NET_BANKING(3),
    EMI(4),
    UPI(5),
    BALANCE(6),
    PAYTM_DIGITAL_CREDIT(7),
    PPBL(8),
    COD(9),
    WALLET(10),
    GIFT_VOUCHER(11),
    BANK_MANDATE(12);
    
    int value;

    private PayMethodType(int i2) {
        this.value = i2;
    }
}
