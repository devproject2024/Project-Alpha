package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddressDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String mAddress;
    @b(a = "address_name")
    private String mAddressName;
    @b(a = "contact")
    private String mContact;
    @b(a = "description")
    private String mDescription;
    @b(a = "email")
    private String mEmail;
    @b(a = "latitude")
    private Double mLatitude;
    @b(a = "longitude")
    private Double mLongitude;
    @b(a = "name")
    private String mName;
    @b(a = "pincode")
    private String mPincode;
    private boolean mSoldOut;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getPincode() {
        return this.mPincode;
    }

    public void setPincode(String str) {
        this.mPincode = str;
    }

    public Double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(Double d2) {
        this.mLatitude = d2;
    }

    public Double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(Double d2) {
        this.mLongitude = d2;
    }

    public String getmContact() {
        return this.mContact;
    }

    public void setmContact(String str) {
        this.mContact = str;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public void setSoldOutInfo(boolean z) {
        this.mSoldOut = z;
    }

    public boolean getSoldOutInfo() {
        return this.mSoldOut;
    }

    public String getAddressName() {
        return this.mAddressName;
    }

    public void setAddressName(String str) {
        this.mAddressName = str;
    }

    public boolean extractVenueSoldOutInfo(List<CJRAmParkDateTimeModel> list) {
        if (list != null && list.size() > 0) {
            for (CJRAmParkDateTimeModel cJRAmParkDateTimeModel : list) {
                cJRAmParkDateTimeModel.getmPackageDetailsList();
            }
        }
        return true;
    }
}
