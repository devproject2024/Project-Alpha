package net.one97.paytm.o2o.movies.actor;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieVideoModelNew extends IJRPaytmDataModel implements IJRDataModel {
    public Long id;
    public String imageUrl;
    public String title;
    public String videoDuration;
    public String videoUrl;
    public Long viewCount;
}
