package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.List;

public class CJRParkPackageDetailsModel implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "custom_info")
    private String mParkCustomInfo;
    @b(a = "description")
    private String mParkPackageDescription;
    @b(a = "id")
    private int mParkPackageId;
    @b(a = "type")
    private String mParkPackageType;
    @b(a = "prices")
    private List<CJRSeatDetailsModel> mParkSeatDetails;

    public int getmParkPackageId() {
        return this.mParkPackageId;
    }

    public void setmParkPackageId(int i2) {
        this.mParkPackageId = i2;
    }

    public String getmParkPackageType() {
        return this.mParkPackageType;
    }

    public void setmParkPackageType(String str) {
        this.mParkPackageType = str;
    }

    public String getmParkPackageDescription() {
        return this.mParkPackageDescription;
    }

    public void setmParkPackageDescription(String str) {
        this.mParkPackageDescription = str;
    }

    public String getmParkCustomInfo() {
        return this.mParkCustomInfo;
    }

    public void setmParkCustomInfo(String str) {
        this.mParkCustomInfo = str;
    }

    public List<CJRSeatDetailsModel> getmParkSeatDetails() {
        return this.mParkSeatDetails;
    }

    public void setmParkSeatDetails(List<CJRSeatDetailsModel> list) {
        this.mParkSeatDetails = list;
    }
}
