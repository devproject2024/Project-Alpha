package net.one97.paytm.upi.common.upi;

import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiGenerateCashbackDataModel implements UpiBaseDataModel {
    int claimableCount;
    String code;
    String message;
    ArrayList<CJRScratchCard> scratchCards;
    String status;
    String txnId;

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public int getClaimableCount() {
        return this.claimableCount;
    }

    public ArrayList<CJRScratchCard> getScratchCards() {
        return this.scratchCards;
    }

    public class CJRScratchCard implements UpiBaseDataModel {
        double amount;
        long avalilable_on;
        String scratchCardId;
        String status;

        public CJRScratchCard() {
        }

        public String getScratchCardId() {
            return this.scratchCardId;
        }

        public String getStatus() {
            return this.status;
        }

        public long getAvalilable_on() {
            return this.avalilable_on;
        }

        public double getAmount() {
            return this.amount;
        }
    }
}
