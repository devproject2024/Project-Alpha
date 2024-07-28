package net.one97.paytm.common.entity.vipcashback;

import kotlin.g.b.k;

public final class MyOfferBusinessUIObj {
    private String gratificationMessage;
    private boolean isGratificationMessageVisible;
    private boolean isGratificationProcessed;
    private String redemptionText;
    private String rrnNo;
    private MerchantStage stage;
    private String stageStatus;
    private String title = "";

    public final MerchantStage getStage() {
        return this.stage;
    }

    public final void setStage(MerchantStage merchantStage) {
        this.stage = merchantStage;
    }

    public final boolean isGratificationMessageVisible() {
        return this.isGratificationMessageVisible;
    }

    public final void setGratificationMessageVisible(boolean z) {
        this.isGratificationMessageVisible = z;
    }

    public final boolean isGratificationProcessed() {
        return this.isGratificationProcessed;
    }

    public final void setGratificationProcessed(boolean z) {
        this.isGratificationProcessed = z;
    }

    public final String getRedemptionText() {
        return this.redemptionText;
    }

    public final void setRedemptionText(String str) {
        this.redemptionText = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final String getGratificationMessage() {
        return this.gratificationMessage;
    }

    public final void setGratificationMessage(String str) {
        this.gratificationMessage = str;
    }

    public final String getRrnNo() {
        return this.rrnNo;
    }

    public final void setRrnNo(String str) {
        this.rrnNo = str;
    }

    public final String getStageStatus() {
        return this.stageStatus;
    }

    public final void setStageStatus(String str) {
        this.stageStatus = str;
    }
}
