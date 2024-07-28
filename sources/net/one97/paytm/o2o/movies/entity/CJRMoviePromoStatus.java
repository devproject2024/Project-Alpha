package net.one97.paytm.o2o.movies.entity;

public class CJRMoviePromoStatus {
    public final String cashBack;
    public final boolean isMoviePassPromo;
    public final boolean isSuccess;
    public final String paytmDiscount;
    public final String promoCode;
    public final String promoText;

    public CJRMoviePromoStatus(boolean z, String str, String str2, String str3, boolean z2, String str4) {
        this.isSuccess = z;
        this.promoCode = str;
        this.cashBack = str2;
        this.promoText = str3;
        this.isMoviePassPromo = z2;
        this.paytmDiscount = str4;
    }
}
