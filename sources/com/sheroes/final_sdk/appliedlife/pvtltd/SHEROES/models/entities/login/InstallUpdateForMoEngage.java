package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import org.parceler.Parcel;

@Parcel
public class InstallUpdateForMoEngage {
    private int appVersion;
    private boolean isAppInstallFirstTime;
    private boolean isFirstOpen;
    private boolean isOnBoardingSkipped;
    private boolean isWalkThroughShown;
    private boolean isWelcome;

    public int getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(int i2) {
        this.appVersion = i2;
    }

    public boolean isFirstOpen() {
        return this.isFirstOpen;
    }

    public void setFirstOpen(boolean z) {
        this.isFirstOpen = z;
    }

    public boolean isWelcome() {
        return this.isWelcome;
    }

    public void setWelcome(boolean z) {
        this.isWelcome = z;
    }

    public boolean isAppInstallFirstTime() {
        return this.isAppInstallFirstTime;
    }

    public void setAppInstallFirstTime(boolean z) {
        this.isAppInstallFirstTime = z;
    }

    public boolean isWalkThroughShown() {
        return this.isWalkThroughShown;
    }

    public void setWalkThroughShown(boolean z) {
        this.isWalkThroughShown = z;
    }

    public boolean isOnBoardingSkipped() {
        return this.isOnBoardingSkipped;
    }

    public void setOnBoardingSkipped(boolean z) {
        this.isOnBoardingSkipped = z;
    }
}
