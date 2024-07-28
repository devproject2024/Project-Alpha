package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class CJRParkRidesDetailModel implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "ride_description")
    private String mRideDescription;
    @b(a = "ride_image")
    private String mRideImage;
    @b(a = "ride_image_app")
    private String mRideImageApp;
    @b(a = "ride_name")
    private String mRideName;

    public String getmRideName() {
        return this.mRideName;
    }

    public void setmRideName(String str) {
        this.mRideName = str;
    }

    public String getmRideDescription() {
        return this.mRideDescription;
    }

    public void setmRideDescription(String str) {
        this.mRideDescription = str;
    }

    public String getmRideImage() {
        return this.mRideImage;
    }

    public void setmRideImage(String str) {
        this.mRideImage = str;
    }

    public String getmRideImageApp() {
        return this.mRideImageApp;
    }

    public void setmRideImageApp(String str) {
        this.mRideImageApp = str;
    }
}
