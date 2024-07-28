package net.one97.paytm.common.entity.vipcashback;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class GameOfferDetailModel extends IJRPaytmDataModel {
    public boolean autoActivate;
    public String backgroundImageUrl;
    public String cashbackDescription;
    public String cashbackText;
    public String ctaLink;
    public String ctaText;
    public Integer doneTxnCount;
    public boolean isExpiredGame;
    public boolean isGameCampaign;
    public String mCampaignId;
    public String mGameId;
    public boolean showCTA;
    public boolean showTimeLine;
    public String thumbnail;
    public String title;
    public String tnc;
    public Integer totalTxnCount;
    public ArrayList<TransactionsInfo> transactionsInfos;
    public String validityText;
}
