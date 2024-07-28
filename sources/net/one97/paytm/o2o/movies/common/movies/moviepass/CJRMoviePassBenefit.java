package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassBenefit implements IJRDataModel {
    @b(a = "image_url")
    private String imageUrl;
    private String label;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
