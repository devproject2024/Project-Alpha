package net.one97.paytm.o2o.movies.actor;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRActorMovieModel extends IJRPaytmDataModel implements IJRDataModel {
    public String bannerImage;
    public Long id;
    public String imdbRating;
    public List<String> languages;
    public CJRMovieModelMetaData metadata;
    public String releaseDate;
    public String title;
}
