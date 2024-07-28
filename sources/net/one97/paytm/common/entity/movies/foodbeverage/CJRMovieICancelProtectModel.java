package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.CJRMovieLoyaltyModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJRMovieICancelProtectModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "durationBeforeShowTime")
    private String durationBeforeShowTime;
    @b(a = "img_cancel")
    private String img_cancel;
    @b(a = "img_refund")
    private String img_refund;
    @b(a = "insuranceAvailable")
    private boolean insuranceAvailable;
    @b(a = "insurance_end_date")
    private String insuranceEndDate;
    @b(a = "mLoyal")
    private CJRMovieLoyaltyModel mLoyal;
    @b(a = "max_claim_amount")
    private Float maxClaimAmount;
    @b(a = "message")
    private String message;
    @b(a = "pre_selected")
    private Boolean pre_selected;
    @b(a = "premium")
    private Float premium;
    @b(a = "price_per_ticket")
    private Float pricePerTicket;
    @b(a = "promocodeAllowed")
    private Boolean promocodeAllowed;
    @b(a = "showTaxInformation")
    private List<CJRTaxInfo> showTaxInformation;
    @b(a = "terms_cond")
    private CJRMovieCancelProtectTerms termsCond;
    @b(a = "total_insurance_price")
    private Float totalInsurancePrice;
    @b(a = "total_price_tax_split")
    private CJRTotalPriceTaxSplit totalPriceTaxSplit;
    @b(a = "ui_label")
    private String ui_label;
    @b(a = "ui_label_cancel")
    private String ui_label_cancel;
    @b(a = "ui_label_refund")
    private String ui_label_refund;
    @b(a = "ui_label_tnc")
    private String ui_label_tnc;

    public boolean getInsuranceAvailable() {
        return this.insuranceAvailable;
    }

    public void setInsuranceAvailable(Boolean bool) {
        this.insuranceAvailable = bool.booleanValue();
    }

    public String getMessage() {
        return this.message;
    }

    public CJRMovieCancelProtectTerms getTermsCond() {
        return this.termsCond;
    }

    public Float getTotalInsurancePrice() {
        return this.totalInsurancePrice;
    }

    public Float getPricePerTicket() {
        return this.pricePerTicket;
    }

    public Float getMaxClaimAmount() {
        return this.maxClaimAmount;
    }

    public String getInsuranceEndDate() {
        return this.insuranceEndDate;
    }

    public Boolean getPromocodeAllowed() {
        return this.promocodeAllowed;
    }

    public CJRTotalPriceTaxSplit getTotalPriceTaxSplit() {
        return this.totalPriceTaxSplit;
    }

    public Float getPremium() {
        return this.premium;
    }

    public String getUi_label() {
        return this.ui_label;
    }

    public Boolean getPre_selected() {
        return this.pre_selected;
    }

    public String getDurationBeforeShowTime() {
        return this.durationBeforeShowTime;
    }

    public List<CJRTaxInfo> getShowTaxInformation() {
        return this.showTaxInformation;
    }

    public void setShowTaxInformation(List<CJRTaxInfo> list) {
        this.showTaxInformation = list;
    }

    public CJRMovieLoyaltyModel getmLoyal() {
        return this.mLoyal;
    }

    public void setmLoyal(CJRMovieLoyaltyModel cJRMovieLoyaltyModel) {
        this.mLoyal = cJRMovieLoyaltyModel;
    }

    public boolean isInsuranceAvailable() {
        return this.insuranceAvailable;
    }

    public String getUi_label_cancel() {
        return this.ui_label_cancel;
    }

    public String getUi_label_refund() {
        return this.ui_label_refund;
    }

    public String getImg_cancel() {
        return this.img_cancel;
    }

    public String getImg_refund() {
        return this.img_refund;
    }

    public String getUi_label_tnc() {
        return this.ui_label_tnc;
    }
}
