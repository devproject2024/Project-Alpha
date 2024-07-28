package net.one97.paytm.passbook.utility;

import com.paytmmoney.lite.mod.util.PMConstants;
import net.one97.paytm.passbook.beans.CJRSubWallet;

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
    PAYTM_FIRST_GAMES_WALLET(7, "PaytmFirstGames.com Bonus"),
    PAYTM_POSTPAID(20, "paytm_postpaid"),
    DIGITAL_GOLD(21, "digital_gold"),
    MERCHANT_PAYMENTS(-7, "merchant_payments"),
    PAYTM_MONEY(-9, PMConstants.MONEY_VERTICAL_NAME),
    CREDIT_CARD(-30, "credit_card"),
    ICA_CURRENT_ACCOUNT(100, "current_account"),
    ICA_FIXED_DEPOSIT(101, "current_account_fd"),
    PAYTM_COINS(102, "paytm_coins"),
    WALLET_PFG(110, "Paytm First Games\nBalance");
    
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

    public static n getPassbookTypeByWalletType(CJRSubWallet cJRSubWallet) {
        int subWalletType = cJRSubWallet.getSubWalletType();
        if (subWalletType == UPI.walletTypeInteger.intValue()) {
            return UPI;
        }
        if (subWalletType == FIXED_DEPOSIT.walletTypeInteger.intValue()) {
            return FIXED_DEPOSIT;
        }
        if (subWalletType == DIGITAL_CREDIT.walletTypeInteger.intValue()) {
            return DIGITAL_CREDIT;
        }
        if (subWalletType == SUSPENSE_ACCOUNT.walletTypeInteger.intValue()) {
            return SUSPENSE_ACCOUNT;
        }
        if (subWalletType == SAVINGS_ACCOUNT.walletTypeInteger.intValue()) {
            return SAVINGS_ACCOUNT;
        }
        if (subWalletType == PAYTM_WALLET.walletTypeInteger.intValue()) {
            return PAYTM_WALLET;
        }
        if (subWalletType == FOOD_WALLET.walletTypeInteger.intValue()) {
            return FOOD_WALLET;
        }
        if (subWalletType == GIFT_CARDS.walletTypeInteger.intValue()) {
            return GIFT_CARDS;
        }
        if (subWalletType == GIFT_VOUCHER.walletTypeInteger.intValue()) {
            return GIFT_VOUCHER;
        }
        if (subWalletType == TOLL.walletTypeInteger.intValue()) {
            return TOLL;
        }
        if (subWalletType == REMITTANCE.walletTypeInteger.intValue()) {
            return REMITTANCE;
        }
        if (subWalletType == FUEL_WALLET.walletTypeInteger.intValue()) {
            return FUEL_WALLET;
        }
        if (subWalletType == ALLOWALANCE_WALLET.walletTypeInteger.intValue()) {
            return ALLOWALANCE_WALLET;
        }
        if (subWalletType == COMMUNICATION_WALLET.walletTypeInteger.intValue()) {
            return COMMUNICATION_WALLET;
        }
        if (subWalletType == LOYALTY_WALLET.walletTypeInteger.intValue()) {
            return LOYALTY_WALLET;
        }
        if (subWalletType == LOYALTY_WALLET_TYPE_7.walletTypeInteger.intValue()) {
            return LOYALTY_WALLET_TYPE_7;
        }
        if (subWalletType == PAYTM_POSTPAID.walletTypeInteger.intValue()) {
            return PAYTM_POSTPAID;
        }
        if (subWalletType == DIGITAL_GOLD.walletTypeInteger.intValue()) {
            return DIGITAL_GOLD;
        }
        if (subWalletType == MERCHANT_PAYMENTS.walletTypeInteger.intValue()) {
            return MERCHANT_PAYMENTS;
        }
        if (subWalletType == PAYTM_MONEY.walletTypeInteger.intValue()) {
            return PAYTM_MONEY;
        }
        if (subWalletType == CREDIT_CARD.walletTypeInteger.intValue()) {
            return CREDIT_CARD;
        }
        if (subWalletType == PAYTM_COINS.walletTypeInteger.intValue()) {
            return PAYTM_COINS;
        }
        return null;
    }
}
