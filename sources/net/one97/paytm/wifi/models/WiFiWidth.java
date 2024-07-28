package net.one97.paytm.wifi.models;

public enum WiFiWidth {
    MHZ_20(20),
    MHZ_40(40),
    MHZ_80(80),
    MHZ_160(160),
    MHZ_80_PLUS(80);
    
    private final int frequencyWidthHalf;

    private WiFiWidth(int i2) {
        this.frequencyWidthHalf = i2 / 2;
    }

    public final int getFrequencyWidthHalf() {
        return this.frequencyWidthHalf;
    }
}
