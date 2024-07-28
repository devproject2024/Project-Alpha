package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class InfoV4 extends IJRPaytmDataModel {
    @b(a = "campaign")
    private Campaign campaign;
    @b(a = "cancelled_txn_count")
    private Integer cancelledTxnCount;
    @b(a = "cb_earned_at")
    private String cbEarnedAt;
    @b(a = "game_expiry_reason")
    private String gameExpiryReason;
    @b(a = "offer_expiry_reason")
    private String offerExpiryReason;
    @b(a = "transactions")
    private ArrayList<CashBackTransactionV4> transactions;

    public Campaign getCampaign() {
        return this.campaign;
    }

    public ArrayList<CashBackTransactionV4> getTransactions() {
        return this.transactions;
    }

    public String getCbEarnedAt() {
        return this.cbEarnedAt;
    }

    public String getOfferExpiryReason() {
        return this.offerExpiryReason;
    }

    public Integer getCancelledTxnCount() {
        return this.cancelledTxnCount;
    }

    public String getGameExpiryReason() {
        return this.gameExpiryReason;
    }
}
