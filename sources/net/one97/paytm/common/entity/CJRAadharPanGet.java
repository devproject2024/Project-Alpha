package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.KYCForm60;
import net.one97.paytm.common.entity.upgradeKyc.ProfileData;

public class CJRAadharPanGet extends IJRPaytmDataModel implements IJRDataModel {
    private CersaiDetails cersaiInfo;
    private String dob;
    private List<CJRAadharPanDocList> documents;
    public Error error;
    private String firstname;
    private KYCForm60 form60Data;
    private String gender;
    private boolean isKycDone;
    private String lastname;
    private String message;
    private String name;
    private ProfileData profileData;
    private String responseCode;
    private String status;

    public CersaiDetails getCersaiInfo() {
        return this.cersaiInfo;
    }

    public void setCersaiInfo(CersaiDetails cersaiDetails) {
        this.cersaiInfo = cersaiDetails;
    }

    public ProfileData getProfileData() {
        return this.profileData;
    }

    public void setProfileData(ProfileData profileData2) {
        this.profileData = profileData2;
    }

    public KYCForm60 getForm60Data() {
        return this.form60Data;
    }

    public void setForm60Data(KYCForm60 kYCForm60) {
        this.form60Data = kYCForm60;
    }

    public List<CJRAadharPanDocList> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<CJRAadharPanDocList> list) {
        this.documents = list;
    }

    public boolean isKycDone() {
        return this.isKycDone;
    }

    public void setKycDone(boolean z) {
        this.isKycDone = z;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String str) {
        this.firstname = str;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String str) {
        this.lastname = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public Error getError() {
        return this.error;
    }

    public class Error {
        private String errorCode;
        private String errorMsg;

        public Error() {
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }
}
