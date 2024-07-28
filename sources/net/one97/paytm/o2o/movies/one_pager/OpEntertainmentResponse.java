package net.one97.paytm.o2o.movies.one_pager;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpEntertainmentResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "dates")
    public OpDatesModel dates;
    @c(a = "featured")
    public List<OpFeaturedModel> featured;
    @c(a = "list")
    public OpList list;
}
