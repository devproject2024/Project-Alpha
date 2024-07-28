package net.one97.paytm.common.entity.insurance.healthInsurance;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.insurance.AmountObject;
import net.one97.paytm.model.LifeInsPlanTaxBreakUp;
import net.one97.paytm.model.PolicySummary;

public final class SelectQuoteErrorStatus implements IJRDataModel {
    private DetailMessage detail_message;
    private Boolean error;
    private String error_message;
    private SummaryObject summary_object;

    public static /* synthetic */ SelectQuoteErrorStatus copy$default(SelectQuoteErrorStatus selectQuoteErrorStatus, Boolean bool, String str, SummaryObject summaryObject, DetailMessage detailMessage, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = selectQuoteErrorStatus.error;
        }
        if ((i2 & 2) != 0) {
            str = selectQuoteErrorStatus.error_message;
        }
        if ((i2 & 4) != 0) {
            summaryObject = selectQuoteErrorStatus.summary_object;
        }
        if ((i2 & 8) != 0) {
            detailMessage = selectQuoteErrorStatus.detail_message;
        }
        return selectQuoteErrorStatus.copy(bool, str, summaryObject, detailMessage);
    }

    public final Boolean component1() {
        return this.error;
    }

    public final String component2() {
        return this.error_message;
    }

    public final SummaryObject component3() {
        return this.summary_object;
    }

    public final DetailMessage component4() {
        return this.detail_message;
    }

    public final SelectQuoteErrorStatus copy(Boolean bool, String str, SummaryObject summaryObject, DetailMessage detailMessage) {
        return new SelectQuoteErrorStatus(bool, str, summaryObject, detailMessage);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectQuoteErrorStatus)) {
            return false;
        }
        SelectQuoteErrorStatus selectQuoteErrorStatus = (SelectQuoteErrorStatus) obj;
        return k.a((Object) this.error, (Object) selectQuoteErrorStatus.error) && k.a((Object) this.error_message, (Object) selectQuoteErrorStatus.error_message) && k.a((Object) this.summary_object, (Object) selectQuoteErrorStatus.summary_object) && k.a((Object) this.detail_message, (Object) selectQuoteErrorStatus.detail_message);
    }

    public final int hashCode() {
        Boolean bool = this.error;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.error_message;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        SummaryObject summaryObject = this.summary_object;
        int hashCode3 = (hashCode2 + (summaryObject != null ? summaryObject.hashCode() : 0)) * 31;
        DetailMessage detailMessage = this.detail_message;
        if (detailMessage != null) {
            i2 = detailMessage.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SelectQuoteErrorStatus(error=" + this.error + ", error_message=" + this.error_message + ", summary_object=" + this.summary_object + ", detail_message=" + this.detail_message + ")";
    }

    public SelectQuoteErrorStatus(Boolean bool, String str, SummaryObject summaryObject, DetailMessage detailMessage) {
        this.error = bool;
        this.error_message = str;
        this.summary_object = summaryObject;
        this.detail_message = detailMessage;
    }

    public final Boolean getError() {
        return this.error;
    }

    public final void setError(Boolean bool) {
        this.error = bool;
    }

    public final String getError_message() {
        return this.error_message;
    }

    public final void setError_message(String str) {
        this.error_message = str;
    }

    public final SummaryObject getSummary_object() {
        return this.summary_object;
    }

    public final void setSummary_object(SummaryObject summaryObject) {
        this.summary_object = summaryObject;
    }

    public final DetailMessage getDetail_message() {
        return this.detail_message;
    }

    public final void setDetail_message(DetailMessage detailMessage) {
        this.detail_message = detailMessage;
    }

    public static final class DetailMessage implements IJRDataModel {
        private String heading;
        private String message;

        public DetailMessage(String str, String str2) {
            this.heading = str;
            this.message = str2;
        }

        public final String getHeading() {
            return this.heading;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setHeading(String str) {
            this.heading = str;
        }

        public final void setMessage(String str) {
            this.message = str;
        }
    }

    public final class SummaryObject implements IJRDataModel {
        private ArrayList<AmountObject> amount_object;
        private Disclaimer disclaimer;
        private ArrayList<HealthPlanDiscount> discount;
        private OperatorSummary operator_summary;
        private PaymentSummary payment_summary;
        private PolicyDetails policy_details;
        private PolicySummary policy_summary;
        private PolicyWording policy_wording;
        private ArrayList<LifeInsPlanTaxBreakUp> tax_breakup;
        private TNC tnc;

        public SummaryObject(OperatorSummary operatorSummary, PolicyDetails policyDetails, PaymentSummary paymentSummary, PolicyWording policyWording, ArrayList<AmountObject> arrayList, Disclaimer disclaimer2, PolicySummary policySummary, ArrayList<HealthPlanDiscount> arrayList2, ArrayList<LifeInsPlanTaxBreakUp> arrayList3, TNC tnc2) {
            this.operator_summary = operatorSummary;
            this.policy_details = policyDetails;
            this.payment_summary = paymentSummary;
            this.policy_wording = policyWording;
            this.amount_object = arrayList;
            this.disclaimer = disclaimer2;
            this.policy_summary = policySummary;
            this.discount = arrayList2;
            this.tax_breakup = arrayList3;
            this.tnc = tnc2;
        }

        public final OperatorSummary getOperator_summary() {
            return this.operator_summary;
        }

        public final void setOperator_summary(OperatorSummary operatorSummary) {
            this.operator_summary = operatorSummary;
        }

        public final PolicyDetails getPolicy_details() {
            return this.policy_details;
        }

        public final void setPolicy_details(PolicyDetails policyDetails) {
            this.policy_details = policyDetails;
        }

        public final PaymentSummary getPayment_summary() {
            return this.payment_summary;
        }

        public final void setPayment_summary(PaymentSummary paymentSummary) {
            this.payment_summary = paymentSummary;
        }

        public final PolicyWording getPolicy_wording() {
            return this.policy_wording;
        }

        public final void setPolicy_wording(PolicyWording policyWording) {
            this.policy_wording = policyWording;
        }

        public final ArrayList<AmountObject> getAmount_object() {
            return this.amount_object;
        }

        public final void setAmount_object(ArrayList<AmountObject> arrayList) {
            this.amount_object = arrayList;
        }

        public final Disclaimer getDisclaimer() {
            return this.disclaimer;
        }

        public final void setDisclaimer(Disclaimer disclaimer2) {
            this.disclaimer = disclaimer2;
        }

        public final PolicySummary getPolicy_summary() {
            return this.policy_summary;
        }

        public final void setPolicy_summary(PolicySummary policySummary) {
            this.policy_summary = policySummary;
        }

        public final ArrayList<HealthPlanDiscount> getDiscount() {
            return this.discount;
        }

        public final void setDiscount(ArrayList<HealthPlanDiscount> arrayList) {
            this.discount = arrayList;
        }

        public final ArrayList<LifeInsPlanTaxBreakUp> getTax_breakup() {
            return this.tax_breakup;
        }

        public final void setTax_breakup(ArrayList<LifeInsPlanTaxBreakUp> arrayList) {
            this.tax_breakup = arrayList;
        }

        public final class OperatorSummary implements IJRDataModel {
            private String image_url;
            private String title;

            public OperatorSummary(String str, String str2) {
                this.image_url = str;
                this.title = str2;
            }

            public final String getImage_url() {
                return this.image_url;
            }

            public final void setImage_url(String str) {
                this.image_url = str;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                this.title = str;
            }
        }

        public final TNC getTnc() {
            return this.tnc;
        }

        public final void setTnc(TNC tnc2) {
            this.tnc = tnc2;
        }

        public final class PolicyDetails implements IJRDataModel {
            private String members_count;
            private String policy_tenure;
            private String sum_insured;

            public PolicyDetails(String str, String str2, String str3) {
                this.sum_insured = str;
                this.policy_tenure = str2;
                this.members_count = str3;
            }

            public final String getSum_insured() {
                return this.sum_insured;
            }

            public final void setSum_insured(String str) {
                this.sum_insured = str;
            }

            public final String getPolicy_tenure() {
                return this.policy_tenure;
            }

            public final void setPolicy_tenure(String str) {
                this.policy_tenure = str;
            }

            public final String getMembers_count() {
                return this.members_count;
            }

            public final void setMembers_count(String str) {
                this.members_count = str;
            }
        }

        public final class PaymentSummary implements IJRDataModel {
            private String basic_premium;
            private String net_payable;
            private String net_premium;
            private String net_taxation;

            public PaymentSummary(String str, String str2, String str3, String str4) {
                this.net_premium = str;
                this.net_taxation = str2;
                this.basic_premium = str3;
                this.net_payable = str4;
            }

            public final String getNet_premium() {
                return this.net_premium;
            }

            public final void setNet_premium(String str) {
                this.net_premium = str;
            }

            public final String getNet_taxation() {
                return this.net_taxation;
            }

            public final void setNet_taxation(String str) {
                this.net_taxation = str;
            }

            public final String getBasic_premium() {
                return this.basic_premium;
            }

            public final void setBasic_premium(String str) {
                this.basic_premium = str;
            }

            public final String getNet_payable() {
                return this.net_payable;
            }

            public final void setNet_payable(String str) {
                this.net_payable = str;
            }
        }

        public final class PolicyWording implements IJRDataModel {
            private String endpoint;
            private String heading;

            public PolicyWording(String str, String str2) {
                this.heading = str;
                this.endpoint = str2;
            }

            public final String getHeading() {
                return this.heading;
            }

            public final void setHeading(String str) {
                this.heading = str;
            }

            public final String getEndpoint() {
                return this.endpoint;
            }

            public final void setEndpoint(String str) {
                this.endpoint = str;
            }
        }

        public final class TNC implements IJRDataModel {
            private String endpoint;
            private String title;

            public TNC(String str, String str2) {
                this.title = str;
                this.endpoint = str2;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                this.title = str;
            }

            public final String getEndpoint() {
                return this.endpoint;
            }

            public final void setEndpoint(String str) {
                this.endpoint = str;
            }
        }

        public final class Disclaimer implements IJRDataModel {
            private String text;

            public Disclaimer(String str) {
                this.text = str;
            }

            public final String getText() {
                return this.text;
            }

            public final void setText(String str) {
                this.text = str;
            }
        }

        public final class HealthPlanDiscount implements IJRDataModel {
            @b(a = "cover_name")
            private String coverName;
            @b(a = "discounted_amount")
            private String discountedAmount;
            @b(a = "rate")
            private String rate;

            public HealthPlanDiscount(String str, String str2, String str3) {
                this.coverName = str;
                this.rate = str2;
                this.discountedAmount = str3;
            }

            public final String getCoverName() {
                return this.coverName;
            }

            public final void setCoverName(String str) {
                this.coverName = str;
            }

            public final String getRate() {
                return this.rate;
            }

            public final void setRate(String str) {
                this.rate = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ HealthPlanDiscount(SummaryObject summaryObject, String str, String str2, String str3, int i2, g gVar) {
                this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
            }

            public final String getDiscountedAmount() {
                return this.discountedAmount;
            }

            public final void setDiscountedAmount(String str) {
                this.discountedAmount = str;
            }
        }
    }

    public static final class MetaData implements IJRDataModel {
        private String request_id;

        public MetaData(String str) {
            this.request_id = str;
        }

        public final String getRequest_id() {
            return this.request_id;
        }

        public final void setRequest_id(String str) {
            this.request_id = str;
        }
    }
}
