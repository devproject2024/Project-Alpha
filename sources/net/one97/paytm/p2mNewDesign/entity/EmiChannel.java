package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.models.EmiChannelInfosV2;
import net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2;
import net.one97.paytm.p2mNewDesign.models.IsDisabledV2;
import net.one97.paytm.p2mNewDesign.models.MoneyV2;

public class EmiChannel extends CJRWalletDataModel implements IJRDataModel {
    private String channelCode;
    private String channelName;
    private EmiChannelInfosV2[] emiChannelInfos;
    private HasLowSuccessV2 hasLowSuccess;
    private String iconUrl;
    private IsDisabledV2 isDisabled;
    private String isHybridDisabled;
    private MoneyV2 maxAmount;
    private MoneyV2 minAmount;

    public MoneyV2 getMinAmount() {
        return this.minAmount;
    }

    public HasLowSuccessV2 getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public String getIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public EmiChannelInfosV2[] getEmiChannelInfos() {
        return this.emiChannelInfos;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public IsDisabledV2 getIsDisabled() {
        return this.isDisabled;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public MoneyV2 getMaxAmount() {
        return this.maxAmount;
    }

    public String getChannelCode() {
        return this.channelCode;
    }
}
