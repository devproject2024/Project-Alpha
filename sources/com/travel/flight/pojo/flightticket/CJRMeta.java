package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRSeats;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryText;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPaxInfo;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMeta implements IJRDataModel {
    @b(a = "dynamic_variables")
    private CJRDynamicPaxInfo CJRDynamicPaxInfo;
    @b(a = "pax_info")
    private CJRPaxInfo CJRPaxInfo;
    @b(a = "fbi")
    private CJRFBI filterAndBannerInfo;
    @b(a = "ancillary")
    private CJRAncillaryText mAncillaryText;
    @b(a = "seats")
    private CJRSeats mSeats;
    @b(a = "student_visa_notes")
    private ArrayList<String> mStudentVisaNotes;
    @b(a = "student_visa_popup")
    private ArrayList<String> mStudentVisaPopup;
    @b(a = "notes")
    private List<String> notes = new ArrayList();

    public List<String> getNotes() {
        return this.notes;
    }

    public void setNotes(List<String> list) {
        this.notes = list;
    }

    public CJRPaxInfo getCJRPaxInfo() {
        return this.CJRPaxInfo;
    }

    public void setCJRPaxInfo(CJRPaxInfo cJRPaxInfo) {
        this.CJRPaxInfo = cJRPaxInfo;
    }

    public CJRDynamicPaxInfo getCJRDynamicPaxInfo() {
        return this.CJRDynamicPaxInfo;
    }

    public void setCJRDynamicPaxInfo(CJRDynamicPaxInfo cJRDynamicPaxInfo) {
        this.CJRDynamicPaxInfo = cJRDynamicPaxInfo;
    }

    public ArrayList<String> getmStudentVisaNotes() {
        return this.mStudentVisaNotes;
    }

    public ArrayList<String> getmStudentVisaPopup() {
        return this.mStudentVisaPopup;
    }

    public CJRAncillaryText getmAncillaryText() {
        return this.mAncillaryText;
    }

    public void setmAncillaryText(CJRAncillaryText cJRAncillaryText) {
        this.mAncillaryText = cJRAncillaryText;
    }

    public CJRSeats getmSeats() {
        return this.mSeats;
    }

    public void setmSeats(CJRSeats cJRSeats) {
        this.mSeats = cJRSeats;
    }

    public CJRFBI getFilterAndBannerInfo() {
        return this.filterAndBannerInfo;
    }

    public void setFilterAndBannerInfo(CJRFBI cjrfbi) {
        this.filterAndBannerInfo = cjrfbi;
    }
}
