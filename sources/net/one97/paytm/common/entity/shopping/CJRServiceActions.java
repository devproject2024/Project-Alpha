package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRAdditionalUserInfo;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;

public class CJRServiceActions implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "additionalUserInfo")
    private CJRAdditionalUserInfo cJRAdditionalUserInfo;
    @b(a = "dthPlanInfo")
    private CJRDthPlanInfo dthPlanInfo;
    @b(a = "customer_bill_download")
    private boolean isCustomerBillDownload = false;
    @b(a = "billAmount")
    private String mBillAmount;
    @b(a = "billamount_editable")
    private boolean mBillAmountEditable;
    @b(a = "bill_amount_max")
    private String mBillAmountMax;
    @b(a = "bill_amount_min")
    private String mBillAmountMin;
    @b(a = "billDueDate")
    private String mBillDueDate;
    @b(a = "caNumber")
    private String mCaNumber;
    @b(a = "course")
    private String mCourse;
    @b(a = "customerEmail")
    private String mCustomerEmail;
    @b(a = "customerName")
    private String mCustomerName;
    @b(a = "displayValues")
    private ArrayList<CJRDisplayValues> mDisplayValues;
    @b(a = "dob")
    private String mDob;
    @b(a = "fatherName")
    private String mFatherName;
    @b(a = "groupDisplay")
    private ArrayList<CJRGroupDisplay> mGroupDisplay;
    @b(a = "label")
    private String mLabel;
    @b(a = "message")
    private String mMessage;
    @b(a = "section")
    private String mSection;
    @b(a = "studentClass")
    private String mStudentClass;
    @b(a = "year")
    private String mYear;
    @b(a = "payment_options")
    private List<CJRPaymentOptions> paymentOptions;
    @b(a = "updatedValues")
    private List<CJRUpdatedValue> updatedValues = null;

    public CJRDthPlanInfo getDthPlanInfo() {
        return this.dthPlanInfo;
    }

    public void setDthPlanInfo(CJRDthPlanInfo cJRDthPlanInfo) {
        this.dthPlanInfo = cJRDthPlanInfo;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getmLabel() {
        return this.mLabel;
    }

    public String getBillAmount() {
        return this.mBillAmount;
    }

    public String getmBillDueDate() {
        return this.mBillDueDate;
    }

    public String getBillAmountMax() {
        return this.mBillAmountMax;
    }

    public String getBillAmountMin() {
        return this.mBillAmountMin;
    }

    public boolean isBillAmountEditable() {
        return this.mBillAmountEditable;
    }

    public String getCaNumber() {
        return this.mCaNumber;
    }

    public String getCourse() {
        return this.mCourse;
    }

    public String getCustomerEmail() {
        return this.mCustomerEmail;
    }

    public String getCustomerName() {
        return this.mCustomerName;
    }

    public String getDob() {
        return this.mDob;
    }

    public String getFatherName() {
        return this.mFatherName;
    }

    public String getSection() {
        return this.mSection;
    }

    public String getStudentClass() {
        return this.mStudentClass;
    }

    public String getYear() {
        return this.mYear;
    }

    public ArrayList<CJRDisplayValues> getDisplayValues() {
        return this.mDisplayValues;
    }

    public List<CJRUpdatedValue> getUpdatedValues() {
        return this.updatedValues;
    }

    public void setUpdatedValues(List<CJRUpdatedValue> list) {
        this.updatedValues = list;
    }

    public List<CJRPaymentOptions> getPaymentOptions() {
        return this.paymentOptions;
    }

    public CJRAdditionalUserInfo getAdditionalUserInfo() {
        return this.cJRAdditionalUserInfo;
    }

    public void setAdditionalUserInfo(CJRAdditionalUserInfo cJRAdditionalUserInfo2) {
        this.cJRAdditionalUserInfo = cJRAdditionalUserInfo2;
    }

    public ArrayList<CJRGroupDisplay> getGroupDisplay() {
        return this.mGroupDisplay;
    }

    public boolean isCustomerBillDownload() {
        return this.isCustomerBillDownload;
    }
}
