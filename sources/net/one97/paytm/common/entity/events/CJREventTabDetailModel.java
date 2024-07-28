package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventTabDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "description")
    private String mDiscription;
    @b(a = "image1")
    private String mImage1;
    @b(a = "image2")
    private String mImage2;
    @b(a = "image")
    private String mImageUrl;
    @b(a = "label")
    private String mLabel;
    @b(a = "name")
    private String mName;
    @b(a = "score")
    private Float mScore;

    public String getName() {
        return this.mName;
    }

    public String getDiscription() {
        return this.mDiscription;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getCustomImage() {
        return this.mImage1;
    }

    public String getFullScreenImage() {
        return this.mImage2;
    }

    public Float getScore() {
        return this.mScore;
    }

    public String getLabel() {
        return this.mLabel;
    }
}
