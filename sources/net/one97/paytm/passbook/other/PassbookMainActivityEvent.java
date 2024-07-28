package net.one97.paytm.passbook.other;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class PassbookMainActivityEvent extends IJRDataModel {
    public static final int OUTERTAB_SAVING_ACCOUNT = 1;
    public static final int OUTERTAB_SUMMARY = 1;
    public static final int OUTERTAB_WALLET = 1;
    public static final int RELOAD_PASSBOOK = 0;
    private int actionType;
    private int innertabPosition;
    private int outerTabPosition;

    public int getActionType() {
        return this.actionType;
    }

    public void setActionType(int i2) {
        this.actionType = i2;
    }

    public int getOuterTabPosition() {
        return this.outerTabPosition;
    }

    public void setOuterTabPosition(int i2) {
        this.outerTabPosition = i2;
    }

    public int getInnertabPosition() {
        return this.innertabPosition;
    }

    public void setInnertabPosition(int i2) {
        this.innertabPosition = i2;
    }
}
