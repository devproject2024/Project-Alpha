package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPKycDetails extends IJRDataModel {
    @c(a = "aadhaarNumber")
    private String aadhaarNumber;
    @c(a = "dob")
    private String dob;
    @c(a = "firstName")
    private String firstName;
    @c(a = "gender")
    private String gender;
    @c(a = "lastName")
    private String lastName;
    @c(a = "pan")
    private String pan;
    @c(a = "permanentAddressCity")
    private String permanentAddressCity;
    @c(a = "permanentAddressLine1")
    private String permanentAddressLine1;
    @c(a = "permanentAddressLine2")
    private String permanentAddressLine2;
    @c(a = "permanentAddressPostalCode")
    private String permanentAddressPostalCode;
    @c(a = "permanentAddressState")
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
