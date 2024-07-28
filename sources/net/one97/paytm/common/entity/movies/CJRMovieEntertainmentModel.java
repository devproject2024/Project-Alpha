package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieEntertainmentModel implements IJRDataModel {
    @b(a = "blogUrl")
    private String blogUrl;
    @b(a = "dateOfUpload")
    private String dateOfUpload;
    @b(a = "description")
    private String description;
    @b(a = "imageUrl")
    private String imageUrl;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getBlogUrl() {
        return this.blogUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDateOfUpload() {
        return this.dateOfUpload;
    }
}
