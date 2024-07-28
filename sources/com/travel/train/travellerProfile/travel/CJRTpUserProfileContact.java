package com.travel.train.travellerProfile.travel;

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
    private b travellerType;
    private String visa_type;

    public boolean isBerthChoiceOpted() {
        return this.berthChoiceOpted;
    }

    public boolean isSeniorCitizenCheck() {
        return this.seniorCitizenCheck;
    }

    public boolean isBedRollCheck() {
        return this.bedRollCheck;
    }

    public String getBerthPreference() {
        return this.berthPreference;
    }

    public String getMeal_type() {
        return this.meal_type;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public String getCount() {
        return this.count;
    }

    public String getPerson_id() {
        return this.person_id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getPassport_no() {
        return this.passport_no;
    }

    public String getTitle() {
        return this.title;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getAddress() {
        return this.address;
    }

    public String getVisa_type() {
        return this.visa_type;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassport_expiry() {
        return this.passport_expiry;
    }

    public String getPassport_country() {
        return this.passport_country;
    }

    public String getAge() {
        return this.age;
    }

    public String getDob() {
        return this.dob;
    }

    public String getGender() {
        return this.gender;
    }

    public String getIrctc_id() {
        return this.irctc_id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public b getTravellerType() {
        return this.travellerType;
    }

    public String getFrequentFlyer() {
        return this.frequentFlyer;
    }

    public String getFrequentFlyerNo() {
        return this.frequentFlyerNo;
    }

    public boolean isContactSelectCheck() {
        return this.contactSelectCheck;
    }

    public int getSortIndex() {
        return this.sortIndex;
    }

    public CJRTpUserProfileContact clone() throws CloneNotSupportedException {
        return (CJRTpUserProfileContact) super.clone();
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public String getPassport_issue_date() {
        return this.passport_issue_date;
    }

    public String getPassport_issue_country() {
        return this.passport_country;
    }

    public String getPassort_country_code() {
        return this.passort_country_code;
    }

    public String getBirth_country() {
        return this.birth_country;
    }

    public String getBirth_country_code() {
        return this.birth_country_code;
    }

    public String getNationality_country_code() {
        return this.nationality_country_code;
    }

    public HashMap<String, String> getFf() {
        return this.ff;
    }
}
