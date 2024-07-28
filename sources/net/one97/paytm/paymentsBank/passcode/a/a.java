package net.one97.paytm.paymentsBank.passcode.a;

public enum a {
    LEFT("left"),
    RIGHT("right"),
    CENTER("center");
    
    private String position;

    private a(String str) {
        this.position = str;
    }

    public final String getPosition() {
        return this.position;
    }

    public final void setPosition(String str) {
        this.position = str;
    }
}
