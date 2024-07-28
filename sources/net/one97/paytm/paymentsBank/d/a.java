package net.one97.paytm.paymentsBank.d;

public enum a {
    NACH_MANDATE("nach_mandate"),
    FORGOT_ATM_PIN("forgot_atm_pin"),
    ALTER_NOMINEE("alter_nominee");
    
    String featureType;

    private a(String str) {
        this.featureType = str;
    }

    public final String getFeatureType() {
        return this.featureType;
    }

    public final void setFeatureType(String str) {
        this.featureType = str;
    }
}
