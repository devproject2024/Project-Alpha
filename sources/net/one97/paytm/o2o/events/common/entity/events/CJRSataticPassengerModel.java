package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSataticPassengerModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address;
    @b(a = "addressError")
    private String addressError;
    @b(a = "age")
    private String age;
    @b(a = "ageError")
    private String ageError;
    @b(a = "city")
    private String city;
    @b(a = "cityError")
    private String cityError;
    @b(a = "email")
    private String email;
    @b(a = "emailError")
    private String emailError;
    @b(a = "genderError")
    private String genderError;
    @b(a = "mobileError")
    private String mobileError;
    @b(a = "mobileNumber")
    private String mobileNumber;
    @b(a = "name")
    private String name;
    @b(a = "nameError")
    private String nameError;
    @b(a = "pinCode")
    private String pinCode;
    @b(a = "pinCodeError")
    private String pinCodeError;
    @b(a = "state")
    private String state;
    @b(a = "stateError")
    private String stateError;
    @b(a = "title")
    private String title;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(String str) {
        this.pinCode = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getNameError() {
        return this.nameError;
    }

    public void setNameError(String str) {
        this.nameError = str;
    }

    public String getGenderError() {
        return this.genderError;
    }

    public void setGenderError(String str) {
        this.genderError = str;
    }

    public String getMobileError() {
        return this.mobileError;
    }

    public void setMobileError(String str) {
        this.mobileError = str;
    }

    public String getEmailError() {
        return this.emailError;
    }

    public void setEmailError(String str) {
        this.emailError = str;
    }

    public String getPinCodeError() {
        return this.pinCodeError;
    }

    public void setPinCodeError(String str) {
        this.pinCodeError = str;
    }

    public String getCityError() {
        return this.cityError;
    }

    public void setCityError(String str) {
        this.cityError = str;
    }

    public String getAgeError() {
        return this.ageError;
    }

    public void setAgeError(String str) {
        this.ageError = str;
    }

    public String getStateError() {
        return this.stateError;
    }

    public void setStateError(String str) {
        this.stateError = str;
    }

    public String getAddressError() {
        return this.addressError;
    }

    public void setAddressError(String str) {
        this.addressError = str;
    }
}
