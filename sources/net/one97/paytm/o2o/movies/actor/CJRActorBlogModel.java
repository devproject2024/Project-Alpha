package net.one97.paytm.o2o.movies.actor;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRActorBlogModel extends IJRPaytmDataModel implements IJRDataModel {
    public String blogUrl;
    public String dateOfUpload;
    public String imageUrl;
    public String title;
}
