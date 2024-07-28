package net.one97.paytm.p2mNewDesign.entity;

public enum a {
    ONUS("ONUS"),
    OFFUS("OFFUS");
    
    private String model;

    private a(String str) {
        this.model = str;
    }

    public final String getModel() {
        return this.model;
    }
}
