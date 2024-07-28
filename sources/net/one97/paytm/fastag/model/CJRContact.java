package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRContact extends IJRPaytmDataModel {
    @b(a = "address")
    private String mAddress;
    @b(a = "alt_phone")
    private String mAltPhone;
    @b(a = "area_type")
    private String mAreaType;
    @b(a = "city")
    private String mCity;
    @b(a = "contact_person")
    private String mContactPerson;
    @b(a = "distance")
    private String mDistance;
    @b(a = "email")
    private String mEmail;
    @b(a = "facility_display_name")
    private String mFacilityDisplayName;
    @b(a = "facility_name")
    private String mFacilityName;
    @b(a = "phone")
    private String mPhone;
    @b(a = "pincode")
    private String mPincode;
    @b(a = "shipper_id")
    private String mShipperId;
    @b(a = "state")
    private String mState;

    public enum AreaType {
        CITY("city", 0),
        STATE("state", 1),
        REGION("region", 2),
        COUNTRY(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, 3),
        IGNORE("ignore", -1);
        
        private int index;
        private String name;

        private AreaType(String str, int i2) {
            this.name = str;
            this.index = i2;
        }

        public final int getIndex() {
            return this.index;
        }

        public static AreaType fromName(String str) {
            for (AreaType areaType : values()) {
                if (areaType.name.equalsIgnoreCase(str)) {
                    return areaType;
                }
            }
            return IGNORE;
        }
    }

    public String getAreaType() {
        return this.mAreaType;
    }

    public String getPhone() {
        return this.mPhone;
    }
}
