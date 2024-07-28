package net.one97.paytm.common.entity.postpaid;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPPKycDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "aadhaarNumber")
    private String aadhaarNumber;
    @b(a = "dob")
    private String dob;
    @b(a = "firstName")
    private String firstName;
    @b(a = "gender")
    private String gender;
    @b(a = "lastName")
    private String lastName;
    @b(a = "pan")
    private String pan;
    @b(a = "permanentAddressCity")
    private String permanentAddressCity;
    @b(a = "permanentAddressLine1")
    private String permanentAddressLine1;
    @b(a = "permanentAddressLine2")
    private String permanentAddressLine2;
    @b(a = "permanentAddressPostalCode")
    private String permanentAddressPostalCode;
    @b(a = "permanentAddressState")
    private String permanentAddressState;

    public final String getPermanentAddressState() {
        return this.permanentAddressState;
    }

    public final void setPermanentAddressState(String str) {
        this.permanentAddressState = str;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }

    public final String getAadhaarNumber() {
        return this.aadhaarNumber;
    }

    public final void setAadhaarNumber(String str) {
        this.aadhaarNumber = str;
    }

    public final String getPermanentAddressLine1() {
        return this.permanentAddressLine1;
    }

    public final void setPermanentAddressLine1(String str) {
        this.permanentAddressLine1 = str;
    }

    public final String getDob() {
        return this.dob;
    }

    public final void setDob(String str) {
        this.dob = str;
    }

    public final String getPermanentAddressLine2() {
        return this.permanentAddressLine2;
    }

    public final void setPermanentAddressLine2(String str) {
        this.permanentAddressLine2 = str;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        this.gender = str;
    }

    public final String getPermanentAddressPostalCode() {
        return this.permanentAddressPostalCode;
    }

    public final void setPermanentAddressPostalCode(String str) {
        this.permanentAddressPostalCode = str;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final String getPermanentAddressCity() {
        return this.permanentAddressCity;
    }

    public final void setPermanentAddressCity(String str) {
        this.permanentAddressCity = str;
    }

    public final String getPan() {
        return this.pan;
    }

    public final void setPan(String str) {
        this.pan = str;
    }
}
