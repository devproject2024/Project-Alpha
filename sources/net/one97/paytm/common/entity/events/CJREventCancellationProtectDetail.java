package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJREventCancellationProtectDetail implements IJRDataModel {
    @b(a = "benefits")
    private ArrayList<String> benefits;
    @b(a = "display_header")
    private String displayHeader;
    @b(a = "display_msg")
    private String displayMessage;
    @b(a = "insurance_details")
    private ArrayList<CJREventCPInsuranceDetail> insuranceDetails;
    @b(a = "insurance_provider")
    private String insuranceProvider;
    @b(a = "insuranceTax")
    private ArrayList<CJRTaxInfo> insuranceTax;
    @b(a = "insurance_type")
    private int insuranceType;
    @b(a = "opt_in")
    private boolean isOptIn;
    @b(a = "netCgst")
    private String netCgst;
    @b(a = "netPremium")
    private String netPremium;
    @b(a = "netSgst")
    private String netSgst;
    @b(a = "num_policies")
    private int numPolicies;
    @b(a = "product_details")
    private CJREventCPProductDetail productDetail;
    @b(a = "request_id")
    private String requestId;
    @b(a = "tc")
    private CJREventCPTermAndConditionModel tc;
    @b(a = "totalPremium")
    private String totalPremium;

    public int getInsuranceType() {
        return this.insuranceType;
    }

    public String getInsuranceProvider() {
        return this.insuranceProvider;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public String getDisplayHeader() {
        return this.displayHeader;
    }

    public CJREventCPTermAndConditionModel getTc() {
        return this.tc;
    }

    public boolean isOptIn() {
        return this.isOptIn;
    }

    public CJREventCPProductDetail getProductDetail() {
        return this.productDetail;
    }

    public int getNumPolicies() {
        return this.numPolicies;
    }

    public ArrayList<CJREventCPInsuranceDetail> getInsuranceDetails() {
        return this.insuranceDetails;
    }

    public ArrayList<String> getBenefits() {
        return this.benefits;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getNetCgst() {
        return this.netCgst;
    }

    public String getNetSgst() {
        return this.netSgst;
    }

    public String getNetPremium() {
        return this.netPremium;
    }

    public String getTotalPremium() {
        return this.totalPremium;
    }

    public ArrayList<CJRTaxInfo> getInsuranceTax() {
        return this.insuranceTax;
    }

    public void setInsuranceTax(ArrayList<CJRTaxInfo> arrayList) {
        this.insuranceTax = arrayList;
    }

    public void setTotalPremium(String str) {
        this.totalPremium = str;
    }
}
