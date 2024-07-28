package net.one97.paytm.common.entity.vipcashback;

import com.paytm.network.model.IJRPaytmDataModel;

public class ScratchCardData extends IJRPaytmDataModel {
    public String campaignId;
    public String cardHeadline;
    public String deeplink;
    public String description;
    public String detailId;
    public String frontEndRedemptionType;
    public String gameId;
    public boolean isAssured;
    public boolean isBetterLuck;
    public boolean isFlip;
    public boolean isGame;
    public boolean isLockedCard;
    public boolean isScratchCard;
    public Boolean isStickerType = Boolean.FALSE;
    public boolean keepRupeeSign = true;
    public Boolean luckyDraw;
    public String mCashBackAmount;
    public String mThumbnail;
    public String mWinningText;
    public String offerName;
    public String redemptionCTA;
    public String redemptionCTADeeplink;
    public String redemptionMaxAmount;
    public String redemptionText;
    public String redemptionType;
    public String refrenceId;
    public String scratchCardId;
    public String scratchCardImage;
    public String serverTime;
    public String siteId;
    public String state;
    public int totalTxnCount;
    public String validUpto;

    public boolean equals(Object obj) {
        if (!(obj instanceof ScratchCardData)) {
            return super.equals(obj);
        }
        String str = ((ScratchCardData) obj).scratchCardId;
        return str != null && str.equals(this.scratchCardId);
    }

    public String toString() {
        return "scratchCardId " + this.scratchCardId;
    }
}
