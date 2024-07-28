package com.bumptech.glide;

public enum e {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float multiplier;

    private e(float f2) {
        this.multiplier = f2;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }
}
