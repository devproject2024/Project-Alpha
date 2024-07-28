package net.one97.paytm.games.view.pfg.refresh;

public enum d {
    TOP(0),
    BOTTOM(1),
    BOTH(2),
    NEVER(3);
    
    private int mode;

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i2) {
        this.mode = i2;
    }

    private d(int i2) {
        this.mode = i2;
    }
}
