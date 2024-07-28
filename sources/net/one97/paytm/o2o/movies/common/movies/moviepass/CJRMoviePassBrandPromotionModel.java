package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassBrandPromotionModel implements IJRDataModel {
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "is_enabled")
    private boolean isEnabled;
    private String text;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }
}
