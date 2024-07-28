package com.travel.travel;

import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpUserProfileContact implements Cloneable, IJRDataModel {
    private String address;
    private String age;
    private boolean bedRollCheck;
    private boolean berthChoiceOpted;
    private String berthPreference;
    private String birth_country;
    private String birth_country_code;
    private boolean contactSelectCheck;
    private String count;
    private String dob;
    private String email;
    private HashMap<String, String> ff = new HashMap<>();
    private String firstname;
    private String frequentFlyer;
    private String frequentFlyerNo;
    private String fullname;
    private String gender;
    private String irctc_id;
    private String lastname;
    private String meal_type;
    private String middlename;
    private String mobile;
    private String nationality;
    private String nationality_country_code;
    private String passort_country_code;
    private String passport_country;
    private String passport_expiry;
    private String passport_issue_date;
    private String passport_no;
    private String person_id;
    private boolean seniorCitizenCheck;
    private int sortIndex;
    private String title;
    private String travelDate;
    private a travellerType;
    private String visa_type;

    public boolean isBerthChoiceOpted() {
        return this.berthChoiceOpted;
    }

    public void setBerthChoiceOpted(boolean z) {
        this.berthChoiceOpted = z;
    }

    public boolean isSeniorCitizenCheck() {
        return this.seniorCitizenCheck;
    }

    public void setSeniorCitizenCheck(boolean z) {
        this.seniorCitizenCheck = z;
    }

    public boolean isBedRollCheck() {
        return this.bedRollCheck;
    }

    public void setBedRollCheck(boolean z) {
        this.bedRollCheck = z;
    }

    public String getBerthPreference() {
        return this.berthPreference;
    }

    public void setBerthPreference(String str) {
        this.berthPreference = str;
    }

    public String getMeal_type() {
        return this.meal_type;
    }

    public void setMeal_type(String str) {
        this.meal_type = str;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public void setMiddlename(String str) {
        this.middlename = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(String str) {
        this.person_id = str;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String str) {
        this.lastname = str;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String str) {
        this.firstname = str;
    }

    public String getPassport_no() {
        return this.passport_no;
    }

    public void setPassport_no(String str) {
        this.passport_no = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String str) {
        this.nationality = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getVisa_type() {
        return this.visa_type;
    }

    public void setVisa_type(String str) {
        this.visa_type = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPassport_expiry() {
        return this.passport_expiry;
    }

    public void setPassport_expiry(String str) {
        this.passport_expiry = str;
    }

    public String getPassport_country() {
        return this.passport_country;
    }

    public void setPassport_country(String str) {
        this.passport_country = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
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

    public String getIrctc_id() {
        return this.irctc_id;
    }

    public void setIrctc_id(String str) {
        this.irctc_id = str;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String str) {
        this.fullname = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public a getTravellerType() {
        return this.travellerType;
    }

    public void setTravellerType(a aVar) {
        this.travellerType = aVar;
    }

    public String getFrequentFlyer() {
        return this.frequentFlyer;
    }

    public void setFrequentFlyer(String str) {
        this.frequentFlyer = str;
    }

    public String getFrequentFlyerNo() {
        return this.frequentFlyerNo;
    }

    public void setFrequentFlyerNo(String str) {
        this.frequentFlyerNo = str;
    }

    public boolean isContactSelectCheck() {
        return this.contactSelectCheck;
    }

    public void setContactSelectCheck(boolean z) {
        this.contactSelectCheck = z;
    }

    public int getSortIndex() {
        return this.sortIndex;
    }

    public void setSortIndex(int i2) {
        this.sortIndex = i2;
    }

    public CJRTpUserProfileContact clone() throws CloneNotSupportedException {
        return (CJRTpUserProfileContact) super.clone();
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
    }

    public String getPassport_issue_date() {
        return this.passport_issue_date;
    }

    public void setPassport_issue_date(String str) {
        this.passport_issue_date = str;
    }

    public String getPassport_issue_country() {
        return this.passport_country;
    }

    public void setPassport_issue_country(String str) {
        this.passport_country = str;
    }

    public String getPassort_country_code() {
        return this.passort_country_code;
    }

    public void setPassort_country_code(String str) {
        this.passort_country_code = str;
    }

    public String getBirth_country() {
        return this.birth_country;
    }

    public void setBirth_country(String str) {
        this.birth_country = str;
    }

    public String getBirth_country_code() {
        return this.birth_country_code;
    }

    public void setBirth_country_code(String str) {
        this.birth_country_code = str;
    }

    public String getNationality_country_code() {
        return this.nationality_country_code;
    }

    public void setNationality_country_code(String str) {
        this.nationality_country_code = str;
    }

    public HashMap<String, String> getFf() {
        return this.ff;
    }

    public void setFf(HashMap<String, String> hashMap) {
        this.ff = hashMap;
    }
}
