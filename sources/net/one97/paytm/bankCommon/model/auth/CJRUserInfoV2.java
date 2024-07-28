package net.one97.paytm.bankCommon.model.auth;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.MinKycDetails;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUserInfoV2 extends CJRDataModelItem {
    @b(a = "isPasswordExistent")
    private boolean isPasswordSet;
    @b(a = "message")
    private String mMessage;
    @b(a = "minKycDetails")
    private MinKycDetails mMinKycDetails;
    @b(a = "responseCode")
    private int mResponseCode;
    @b(a = "socialInfo")
    private ArrayList<CJRUserSocialInfoV2> mSocialInfoList;
    @b(a = "status")
    private String mStatus;
    @b(a = "userAttributeInfo")
    private PassbookUserAttributeInfo mUserAttributeInfo;
    @b(a = "defaultInfo")
    private CJRUserDefaultInfo mUserDefaultInfo;
    @b(a = "userId")
    private String mUserId;
    @b(a = "userTypes")
    private ArrayList<String> mUserTypes;
    @b(a = "userCredentials")
    private PasscodeState passcode;

    public String getName() {
        return null;
    }

    public MinKycDetails getmMinKycDetails() {
        return this.mMinKycDetails;
    }

    public void setmMinKycDetails(MinKycDetails minKycDetails) {
        this.mMinKycDetails = minKycDetails;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(int i2) {
        this.mResponseCode = i2;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public CJRUserDefaultInfo getUserDefaultInfo() {
        return this.mUserDefaultInfo;
    }

    public void setUserDefaultInfo(CJRUserDefaultInfo cJRUserDefaultInfo) {
        this.mUserDefaultInfo = cJRUserDefaultInfo;
    }

    public PassbookUserAttributeInfo getUserAttributeInfo() {
        return this.mUserAttributeInfo;
    }

    public ArrayList<CJRUserSocialInfoV2> getUserSocialInfoList() {
        return this.mSocialInfoList;
    }

    public void setUserSocialInfoList(ArrayList<CJRUserSocialInfoV2> arrayList) {
        this.mSocialInfoList = arrayList;
    }

    public ArrayList<String> getUserTypes() {
        return this.mUserTypes;
    }

    public void setUserTypes(ArrayList<String> arrayList) {
        this.mUserTypes = arrayList;
    }

    public PasscodeState getPasscode() {
        return this.passcode;
    }

    public void setPasscode(PasscodeState passcodeState) {
        this.passcode = passcodeState;
    }

    public boolean isPasswordSet() {
        return this.isPasswordSet;
    }

    public static class PasscodeState implements IJRDataModel {
        @b(a = "isPassCodeSet")
        boolean isPassCodeSet;

        public boolean isPassCodeSet() {
            return this.isPassCodeSet;
        }
    }

    public static class PassbookUserAttributeInfo implements IJRDataModel {
        @b(a = "CREDIT_CARD")
        private boolean hasCreditCard;
        @b(a = "GOLD_ACCOUNT")
        private boolean hasGoldAccount;

        public boolean getCreditCardFlag() {
            return this.hasCreditCard;
        }

        public boolean getGoldAccountFlag() {
            return this.hasGoldAccount;
        }
    }
}
