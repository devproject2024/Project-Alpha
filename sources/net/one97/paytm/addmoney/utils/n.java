package net.one97.paytm.addmoney.utils;

import com.paytmmoney.lite.mod.util.PMConstants;

public enum n {
    UPI(-6, "upi"),
    FIXED_DEPOSIT(-5, "fixed_deposit"),
    DIGITAL_CREDIT(-4, "digital_credit"),
    SUSPENSE_ACCOUNT(-3, "suspense_account"),
    SAVINGS_ACCOUNT(-2, "saving_account"),
    PAYTM_WALLET(0, "paytm_wallet"),
    FOOD_WALLET(2, "food_wallet"),
    GIFT_CARDS(3, "gift_cards"),
    GIFT_VOUCHER(12, "gift_voucher"),
    TOLL(6, "toll"),
    REMITTANCE(10, "Remittance Wallet"),
    FUEL_WALLET(9, "Fuel Wallet"),
    ALLOWALANCE_WALLET(8, "Allowance Wallet"),
    COMMUNICATION_WALLET(13, "Communication Wallet"),
    LOYALTY_WALLET(11, "Loyalty Wallet"),
    LOYALTY_WALLET_TYPE_7(7, "Loyalty Wallet"),
    PAYTM_POSTPAID(20, "paytm_postpaid"),
    DIGITAL_GOLD(21, "digital_gold"),
    MERCHANT_PAYMENTS(-7, "merchant_payments"),
    EDC_PASSBOOK(-8, "edc_passbook"),
    PAYTM_MONEY(-9, PMConstants.MONEY_VERTICAL_NAME);
    
    private final String walletName;
    private final Integer walletTypeInteger;

    private n(Integer num, String str) {
        this.walletTypeInteger = num;
        this.walletName = str;
    }

    public final int getValue() {
        return this.walletTypeInteger.intValue();
    }

    public final String getWalletName() {
        return this.walletName;
    }
}
