package net.one97.paytm.common.entity.wallet;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel;

public class CJRPostcardSentData implements IJRDataModel {
    private boolean isLuckyLifafa;
    private String mAmount;
    private String mDesciptionMessage;
    private String mLifafaCount;
    private String mLifafaKey;
    private String mName;
    private String mRecepientName;
    private IconMetaDataModel mSummaryView;
    private String mThemeId;

    public String getmThemeId() {
        return this.mThemeId;
    }

    public void setmThemeId(String str) {
        this.mThemeId = str;
    }

    public String getmLifafaCount() {
        return this.mLifafaCount;
    }

    public void setmLifafaCount(String str) {
        this.mLifafaCount = str;
    }

    public boolean isLuckyLifafa() {
        return this.isLuckyLifafa;
    }

    public void setLuckyLifafa(boolean z) {
        this.isLuckyLifafa = z;
    }

    public String getmLifafaKey() {
        return this.mLifafaKey;
    }

    public void setmLifafaKey(String str) {
        this.mLifafaKey = str;
    }

    public IconMetaDataModel getmSummaryView() {
        return this.mSummaryView;
    }

    public void setmSummaryView(IconMetaDataModel iconMetaDataModel) {
        this.mSummaryView = iconMetaDataModel;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getRecepientName() {
        return this.mRecepientName;
    }

    public void setRecepientName(String str) {
        this.mRecepientName = str;
    }

    public String getDesciptionMessage() {
        return this.mDesciptionMessage;
    }

    public void setDesciptionMessage(String str) {
        this.mDesciptionMessage = str;
    }
}
