package net.one97.paytm.paymentslimit.bean;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRPaymentLimitDetail extends CJRWalletDataModel {
    @b(a = "limitDetails")
    public LimitDetails limitDetails;
    @b(a = "userLimitConfig")
    public LimitConfig userLimitConfig;

    public static class Item extends CJRWalletDataModel {
        @b(a = "periodLimits")
        public PeriodLimit periodLimits;
        @b(a = "status")
        public boolean status;
    }

    public static class LimitConfig extends CJRWalletDataModel {
        @b(a = "PURCHASE_LIMIT")
        public Item PURCHASE_LIMIT;
        @b(a = "WALLET_TO_BANK_TRANSFER_LIMIT")
        public Item WALLET_TO_BANK_TRANSFER_LIMIT;
        @b(a = "WALLET_TO_WALLET_TRANSFER_LIMIT")
        public Item WALLET_TO_WALLET_TRANSFER_LIMIT;
    }

    public static class LimitDetails extends CJRWalletDataModel {
        @b(a = "PURCHASE_LIMIT")
        public LimitDetailsItem PURCHASE_LIMIT;
        @b(a = "WALLET_TO_BANK_TRANSFER_LIMIT")
        public LimitDetailsItem WALLET_TO_BANK_TRANSFER_LIMIT;
        @b(a = "WALLET_TO_WALLET_TRANSFER_LIMIT")
        public LimitDetailsItem WALLET_TO_WALLET_TRANSFER_LIMIT;
    }

    public static class LimitDetailsInfo extends CJRWalletDataModel {
        @b(a = "amountConsumed")
        public String amountConsumed;
        @b(a = "countConsumed")
        public String countConsumed;
    }

    public static class LimitDetailsItem extends CJRWalletDataModel {
        @b(a = "properties")
        public LimitDetailsProperties properties;
        @b(a = "status")
        public boolean status;
    }

    public static class LimitDetailsProperties extends CJRWalletDataModel {
        @b(a = "dayProperties")
        public LimitDetailsInfo dayProperties;
        @b(a = "monthProperties")
        public LimitDetailsInfo monthProperties;
    }

    public static class LimitInfo extends CJRWalletDataModel {
        @b(a = "amount")
        public String amount;
        @b(a = "count")
        public String count;
    }

    public static class PeriodLimit extends CJRWalletDataModel {
        @b(a = "dayPeriodLimit")
        public LimitInfo dayPeriodLimit;
        @b(a = "monthPeriodLimit")
        public LimitInfo monthPeriodLimit;
        @b(a = "yearPeriodLimit")
        public LimitInfo yearPeriodLimit;
    }
}
