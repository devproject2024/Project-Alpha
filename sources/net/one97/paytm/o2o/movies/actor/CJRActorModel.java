package net.one97.paytm.o2o.movies.actor;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRActorModel extends IJRPaytmDataModel implements IJRDataModel {
    public String birthName;
    public CJRActorBlogData blogs;
    public String bornInfo;
    public String height;
    public String image;
    public CJRActorMovieData movies;
    public Integer moviesCount;
    public String name;
    public List<String> nickNames;
    public List<String> professions;
    public String summary;
    public CJRMovieVideoData videos;
}
