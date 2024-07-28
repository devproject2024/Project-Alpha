package net.one97.paytm.hotel4.service.model.details;

import kotlin.g.b.g;

public final class Ratings {
    private int starRating;

    public Ratings() {
        this(0, 1, (g) null);
    }

    public Ratings(int i2) {
        this.starRating = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ratings(int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2);
    }

    public final int getStarRating() {
        return this.starRating;
    }

    public final void setStarRating(int i2) {
        this.starRating = i2;
    }
}
