package net.one97.paytm.o2o.movies.actor;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRActorMovieData extends IJRPaytmDataModel implements IJRDataModel {
    public List<CJRActorMovieModel> movieData;
}
