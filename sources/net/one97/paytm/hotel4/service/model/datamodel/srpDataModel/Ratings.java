package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import kotlin.g.b.g;

public final class Ratings {
    private final String starRating;

    public Ratings() {
        this((String) null, 1, (g) null);
    }

    public Ratings(String str) {
        this.starRating = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ratings(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getStarRating() {
        return this.starRating;
    }
}
