package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;

public class CJRUpdatedValue implements IJRDataModel {
    @b(a = "billAmount")
    private double billAmount;
    @b(a = "billamount_editable")
    private boolean billamountEditable;
    @b(a = "challan_type")
    private String challanType;
    @b(a = "displayValues")
    private List<CJRDisplayValues> displayValues = null;
    @b(a = "faculty_Code")
    private String facultyCode;
    @b(a = "fee_type_visibility")
    private String feeTypeVisibility;
    @b(a = "fee_types")
    private String feeTypes;
    @b(a = "id")
    private String id;
    @b(a = "label")
    private String label;

    public double getBillAmount() {
        return this.billAmount;
    }

    public void setBillAmount(double d2) {
        this.billAmount = d2;
    }

    public boolean getBillamountEditable() {
        return this.billamountEditable;
    }

    public void setBillamountEditable(Boolean bool) {
        this.billamountEditable = bool.booleanValue();
    }

    public List<CJRDisplayValues> getDisplayValues() {
        return this.displayValues;
    }

    public void setDisplayValues(List<CJRDisplayValues> list) {
        this.displayValues = list;
    }

    public String getFacultyCode() {
        return this.facultyCode;
    }

    public void setFacultyCode(String str) {
        this.facultyCode = str;
    }

    public String getFeeTypes() {
        return this.feeTypes;
    }

    public void setFeeTypes(String str) {
        this.feeTypes = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getChallanType() {
        return this.challanType;
    }

    public void setChallanType(String str) {
        this.challanType = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getFeeTypeVisibility() {
        return this.feeTypeVisibility;
    }

    public void setFeeTypeVisibility(String str) {
        this.feeTypeVisibility = str;
    }
}
