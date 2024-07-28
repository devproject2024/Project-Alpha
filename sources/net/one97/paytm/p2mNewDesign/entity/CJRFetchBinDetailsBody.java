package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRFetchBinDetailsBody extends CJRWalletDataModel implements IJRDataModel {
    private String[] authModes;
    private BinDetailV2 binDetail;
    private EmiChannel emiChannel;
    private String errorMessage;
    private HasLowSuccessRate hasLowSuccessRate;
    private String iconUrl;
    private boolean isEmiAvailable;
    private String isHybridDisabled;
    private String oneClickMaxAmount;
    private boolean oneClickSupported;
    private ResultInfo resultInfo;

    public void setOneClickSupported(boolean z) {
        this.oneClickSupported = z;
    }

    public BinDetailV2 getBinDetail() {
        return this.binDetail;
    }

    public String getIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public HasLowSuccessRate getHasLowSuccessRate() {
        return this.hasLowSuccessRate;
    }

    public String[] getAuthModes() {
        return this.authModes;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public boolean isEmiAvailable() {
        return this.isEmiAvailable;
    }

    public EmiChannel getEmiChannel() {
        return this.emiChannel;
    }

    public boolean isOneClickSupported() {
        return this.oneClickSupported;
    }

    public String getOneClickMaxAmount() {
        return this.oneClickMaxAmount;
    }
}
