package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieSummaryGallery implements IJRDataModel {
    @c(a = "data")
    private List<CJRMovieGalleryData> data = null;
    @c(a = "sub_title")
    private String sub_title;
    @c(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.sub_title;
    }

    public List<CJRMovieGalleryData> getData() {
        return this.data;
    }
}
