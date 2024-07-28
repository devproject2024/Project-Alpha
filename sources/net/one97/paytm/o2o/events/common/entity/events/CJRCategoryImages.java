package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoryImages implements IJRDataModel {
    @b(a = "image")
    private String image;
    @b(a = "image_android")
    private String imageAndroid;
    @b(a = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public String getImageAndroid() {
        return this.imageAndroid;
    }
}
