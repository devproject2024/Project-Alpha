package net.one97.paytm.common.entity.vipcashback;

public final class GratificationTypeCountWrapper {
    private int gratificationCount;
    private int gratificationType;
    private boolean isInitailisedState;

    public final int getGratificationType() {
        return this.gratificationType;
    }

    public final void setGratificationType(int i2) {
        this.gratificationType = i2;
    }

    public final int getGratificationCount() {
        return this.gratificationCount;
    }

    public final void setGratificationCount(int i2) {
        this.gratificationCount = i2;
    }

    public final boolean isInitailisedState() {
        return this.isInitailisedState;
    }

    public final void setInitailisedState(boolean z) {
        this.isInitailisedState = z;
    }
}
