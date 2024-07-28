package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieVideoModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "durationOfVideo")
    private String durationOfVideo;
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "numberOfViews")
    private String numberOfViews;
    @b(a = "videoUrl")
    private String videoUrl;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getNumberOfViews() {
        return this.numberOfViews;
    }

    public String getDurationOfVideo() {
        return this.durationOfVideo;
    }
}
