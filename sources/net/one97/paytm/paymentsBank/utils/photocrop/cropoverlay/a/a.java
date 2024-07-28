package net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.a;

public enum a {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;
    
    private float mCoordinate;

    public static float getWidth() {
        return RIGHT.getCoordinate() - LEFT.getCoordinate();
    }

    public static float getHeight() {
        return BOTTOM.getCoordinate() - TOP.getCoordinate();
    }

    public final float getCoordinate() {
        return this.mCoordinate;
    }

    public final void setCoordinate(float f2) {
        this.mCoordinate = f2;
    }
}
