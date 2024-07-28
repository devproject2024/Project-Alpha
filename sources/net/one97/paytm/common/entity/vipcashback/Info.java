package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.Campaign;

public class Info extends IJRPaytmDataModel {
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
    private ArrayList<VIPCashBackTransaction> transactions;

    public Campaign getCampaign() {
        return this.campaign;
    }

    public ArrayList<VIPCashBackTransaction> getTransactions() {
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
