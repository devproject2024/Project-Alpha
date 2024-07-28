package net.one97.paytm.common.entity.upgradeKyc;

public class Next {
    private int percentage;
    private int priority;
    private String profileVariables;

    public String getProfileVariables() {
        return this.profileVariables;
    }

    public void setProfileVariables(String str) {
        this.profileVariables = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int i2) {
        this.percentage = i2;
    }
}
