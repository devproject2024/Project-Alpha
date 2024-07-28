package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.cashback.posttxn.Campaign;

public class MerchantCampaignGameItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "campaign")
    private Campaign campaign;
    @b(a = "isSupercashGame")
    private boolean isSupercashGame;
    @b(a = "supercashGame")
    private MerchantGameItem supercashGame;

    public boolean isIsSupercashGame() {
        return this.isSupercashGame;
    }

    public MerchantGameItem getSupercashGame() {
        return this.supercashGame;
    }

    public Campaign getCampaign() {
        return this.campaign;
    }
}
