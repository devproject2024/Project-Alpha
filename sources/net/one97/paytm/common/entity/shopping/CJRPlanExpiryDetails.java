package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.c;
import com.paytm.utility.q;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CJRPlanExpiryDetails extends CJRExpandableRecyclerManager implements Serializable {
    @c(a = "amount")
    private String amount;
    private boolean checked = true;
    @c(a = "discount")
    private String discount;
    @c(a = "packageLabel")
    private String packageLabel;
    @c(a = "packagename")
    private String packagename;
    @c(a = "packname")
    private String packname;
    @c(a = "planduration")
    private String planduration;
    @c(a = "planexpirydate")
    private String planexpirydate;
    @c(a = "planpoid")
    private String planpoid;
    @c(a = "Show/Hide")
    private String showHide;

    public boolean isParentRow() {
        return false;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public String getShowHide() {
        return this.showHide;
    }

    public void setShowHide(String str) {
        this.showHide = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String str) {
        this.discount = str;
    }

    public String getPackageLabel() {
        return this.packageLabel;
    }

    public void setPackageLabel(String str) {
        this.packageLabel = str;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public void setPackagename(String str) {
        this.packagename = str;
    }

    public String getPackname() {
        return this.packname;
    }

    public void setPackname(String str) {
        this.packname = str;
    }

    public String getPlanduration() {
        return this.planduration;
    }

    public void setPlanduration(String str) {
        this.planduration = str;
    }

    public String getPlanexpirydate() {
        return this.planexpirydate;
    }

    public String getFormatedDateWithFullYear() {
        try {
            return new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH).parse(this.planexpirydate));
        } catch (Exception unused) {
            getClass().getSimpleName();
            q.d("date Exception");
            return null;
        }
    }

    public void setPlanexpirydate(String str) {
        this.planexpirydate = str;
    }

    public String getPlanpoid() {
        return this.planpoid;
    }

    public void setPlanpoid(String str) {
        this.planpoid = str;
    }
}
