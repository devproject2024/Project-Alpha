package com.travel.flight.flightticket.g;

import android.content.Context;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRTravellerDetails;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValue;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f25031a;

    /* renamed from: b  reason: collision with root package name */
    public CJRFlightDetails f25032b;

    /* renamed from: c  reason: collision with root package name */
    public int f25033c;

    /* renamed from: d  reason: collision with root package name */
    public int f25034d;

    /* renamed from: e  reason: collision with root package name */
    public int f25035e;

    /* renamed from: f  reason: collision with root package name */
    public int f25036f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<CJRTravellerDetails> f25037g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public String f25038h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f25039i = "";
    private int j = 0;

    public g(Context context) {
        this.f25031a = context;
    }

    public final void a() {
        try {
            if (this.f25032b != null) {
                this.f25037g = new ArrayList<>();
                int i2 = 0;
                int i3 = 0;
                while (i3 < this.f25033c) {
                    i3++;
                    this.f25037g.add(a("", "", "", "Adult", "adult", i3));
                }
                int i4 = 0;
                while (i4 < this.f25034d) {
                    i4++;
                    this.f25037g.add(a("", "", "", "Child", "child", i4));
                }
                while (i2 < this.f25035e) {
                    i2++;
                    this.f25037g.add(a("", "", "", "Infant", "infant", i2));
                }
            }
        } catch (Exception unused) {
        }
    }

    private CJRTravellerDetails a(String str, String str2, String str3, String str4, String str5, int i2) {
        CJRTravellerDetails cJRTravellerDetails = new CJRTravellerDetails();
        cJRTravellerDetails.setTravellerTitle(str);
        cJRTravellerDetails.setTravellerFirstName(str2);
        cJRTravellerDetails.setTravellerLastName(str3);
        cJRTravellerDetails.setTravellerDOB((String) null);
        cJRTravellerDetails.setTravellerType(str4);
        cJRTravellerDetails.setmTravellerType_en(str5);
        cJRTravellerDetails.setTravellerCount(i2);
        if ("Adult".equalsIgnoreCase(str4)) {
            cJRTravellerDetails.setPassengerType("Adult ".concat(String.valueOf(i2)));
            cJRTravellerDetails.setValidations(e());
            cJRTravellerDetails.setmTooltip(d());
        } else if ("Child".equalsIgnoreCase(str4)) {
            cJRTravellerDetails.setPassengerType("Child ".concat(String.valueOf(i2)));
            cJRTravellerDetails.setValidations(f());
            cJRTravellerDetails.setmTooltip(c());
        } else if ("Infant".equalsIgnoreCase(str4)) {
            cJRTravellerDetails.setPassengerType("Infant ".concat(String.valueOf(i2)));
            cJRTravellerDetails.setValidations(g());
            cJRTravellerDetails.setmTooltip(b());
        }
        return cJRTravellerDetails;
    }

    private String b() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant().getValidations() == null) {
                return null;
            }
            return this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant().getTooltip();
        } catch (Exception unused) {
            return null;
        }
    }

    private String c() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild().getValidations() == null) {
                return null;
            }
            return this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild().getTooltip();
        } catch (Exception unused) {
            return null;
        }
    }

    private String d() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult().getValidations() == null) {
                return null;
            }
            return this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult().getTooltip();
        } catch (Exception unused) {
            return null;
        }
    }

    private List<CJRDynamicValidation> e() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult().getValidations() == null) {
                return null;
            }
            return a(this.f25032b.getMeta().getCJRDynamicPaxInfo().getAdult());
        } catch (Exception unused) {
            return null;
        }
    }

    private List<CJRDynamicValidation> f() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild().getValidations() == null) {
                return null;
            }
            return a(this.f25032b.getMeta().getCJRDynamicPaxInfo().getChild());
        } catch (Exception unused) {
            return null;
        }
    }

    private List<CJRDynamicValidation> g() {
        try {
            if (this.f25032b.getMeta() == null || this.f25032b.getMeta().getCJRPaxInfo() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant() == null || this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant().getValidations() == null) {
                return null;
            }
            return a(this.f25032b.getMeta().getCJRDynamicPaxInfo().getInfant());
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<CJRDynamicValidation> a(CJRDynamicPassenger cJRDynamicPassenger) {
        ArrayList arrayList = new ArrayList();
        int size = cJRDynamicPassenger.getValidations().size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRDynamicValidation cJRDynamicValidation = new CJRDynamicValidation();
            cJRDynamicValidation.setValue(cJRDynamicPassenger.getValidations().get(i2).getValue());
            cJRDynamicValidation.setPath(cJRDynamicPassenger.getValidations().get(i2).getPath());
            cJRDynamicValidation.setAfter(cJRDynamicPassenger.getValidations().get(i2).getAfter());
            cJRDynamicValidation.setBefore(cJRDynamicPassenger.getValidations().get(i2).getBefore());
            cJRDynamicValidation.setKey(cJRDynamicPassenger.getValidations().get(i2).getKey());
            cJRDynamicValidation.setMaxLength(cJRDynamicPassenger.getValidations().get(i2).getMaxLength());
            cJRDynamicValidation.setMinLength(cJRDynamicPassenger.getValidations().get(i2).getMinLength());
            cJRDynamicValidation.setNote(cJRDynamicPassenger.getValidations().get(i2).getNote());
            cJRDynamicValidation.setType(cJRDynamicPassenger.getValidations().get(i2).getType());
            cJRDynamicValidation.setKey(cJRDynamicPassenger.getValidations().get(i2).getKey());
            cJRDynamicValidation.setValue(cJRDynamicPassenger.getValidations().get(i2).getValue());
            cJRDynamicValidation.setRegex(cJRDynamicPassenger.getValidations().get(i2).getRegex());
            cJRDynamicValidation.setRegexErrorMessage(cJRDynamicPassenger.getValidations().get(i2).getRegexErrorMessage());
            if (cJRDynamicPassenger.getValidations().get(i2).isOptional() != null) {
                cJRDynamicValidation.setOptional(cJRDynamicPassenger.getValidations().get(i2).isOptional());
            }
            ArrayList arrayList2 = new ArrayList();
            int size2 = cJRDynamicPassenger.getValidations().get(i2).getValues().size();
            for (int i3 = 0; i3 < size2; i3++) {
                CJRDynamicValue cJRDynamicValue = new CJRDynamicValue();
                cJRDynamicValue.setKey(cJRDynamicPassenger.getValidations().get(i2).getValues().get(i3).getKey());
                cJRDynamicValue.setValue(cJRDynamicPassenger.getValidations().get(i2).getValues().get(i3).getValue());
                arrayList2.add(cJRDynamicValue);
            }
            cJRDynamicValidation.setValues(arrayList2);
            arrayList.add(cJRDynamicValidation);
        }
        return arrayList;
    }
}
