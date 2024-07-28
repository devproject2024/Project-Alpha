package net.one97.paytm.o2o.movies.one_pager;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpFeaturedModel extends IJRPaytmDataModel implements Comparable<OpFeaturedModel>, IJRDataModel {
    public String _id;
    public List<String> applicable_filters;
    public OpCategory category_id;
    public String deeplink;
    public String horizontal_cover_image;
    public String name;
    public float popularity_score;
    public String price_display_string;
    public String slug;
    public String type;
    public String venue_date_string;
    public String venue_name;
    public String vertical_cover_image;

    public int compareTo(OpFeaturedModel opFeaturedModel) {
        if (opFeaturedModel != null) {
            return this.popularity_score >= opFeaturedModel.popularity_score ? 1 : -1;
        }
        return 0;
    }
}
