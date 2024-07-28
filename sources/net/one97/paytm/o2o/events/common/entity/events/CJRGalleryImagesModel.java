package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGalleryImagesModel implements IJRDataModel {
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "popUpUrl")
    private String popUpUrl;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPopUpUrl() {
        return this.popUpUrl;
    }
}
