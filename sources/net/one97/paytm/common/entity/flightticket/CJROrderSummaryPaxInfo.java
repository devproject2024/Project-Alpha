package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryPaxInfo implements IJRDataModel {
    private String age;
    private String booking_firstname;
    private String booking_lastname;
    private String dob;
    private String firstname;
    private String frequent_flyer;
    private String id;
    private String lastname;
    private String name;
    private String name_tweak;
    private String nationality;
    private String passport_issue_country;
    private String passport_issue_date;
    private String student_visa_note;
    private String title;
    private String type;
    private String visa_type;

    public String getStudent_visa_note() {
        return this.student_visa_note;
    }

    public void setStudent_visa_note(String str) {
        this.student_visa_note = str;
    }

    public String getBooking_firstname() {
        return this.booking_firstname;
    }

    public void setBooking_firstname(String str) {
        this.booking_firstname = str;
    }

    public String getName_tweak() {
        return this.name_tweak;
    }

    public void setName_tweak(String str) {
        this.name_tweak = str;
    }

    public String getBooking_lastname() {
        return this.booking_lastname;
    }

    public void setBooking_lastname(String str) {
        this.booking_lastname = str;
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

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPassport_issue_date() {
        return this.passport_issue_date;
    }

    public void setPassport_issue_date(String str) {
        this.passport_issue_date = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getFrequent_flyer() {
        return this.frequent_flyer;
    }

    public void setFrequent_flyer(String str) {
        this.frequent_flyer = str;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String str) {
        this.nationality = str;
    }

    public String getVisa_type() {
        return this.visa_type;
    }

    public void setVisa_type(String str) {
        this.visa_type = str;
    }

    public String getPassport_issue_country() {
        return this.passport_issue_country;
    }

    public void setPassport_issue_country(String str) {
        this.passport_issue_country = str;
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

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }
}
