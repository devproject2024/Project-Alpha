package net.one97.paytm.paymentsBank.si.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class AllSIResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "documentation")
        private String documentation;
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMessage")
        private String errorMessage;
        @b(a = "standingInstructionList")
        private List<StandingInstructions> standingInstructionList = null;

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public String getDocumentation() {
            return this.documentation;
        }

        public void setDocumentation(String str) {
            this.documentation = str;
        }

        public List<StandingInstructions> getStandingInstructionList() {
            return this.standingInstructionList;
        }

        public void setStandingInstructionList(List<StandingInstructions> list) {
            this.standingInstructionList = list;
        }
    }

    public static class StandingInstructions extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "amount")
        private Double amount;
        @b(a = "beneficiaryName")
        private String beneficiaryName;
        @b(a = "customerId")
        private String customerId;
        @b(a = "dateIndex")
        private Integer dateIndex;
        @b(a = "dayOfWeekIndex")
        private String dayOfWeekIndex;
        @b(a = "destinationAccount")
        private String destinationAccount;
        @b(a = "endDate")
        private String endDate;
        @b(a = "frequency")
        private String frequency;
        @b(a = "id")
        private Integer id;
        @b(a = "ifscCode")
        private String ifscCode;
        @b(a = "monthIndex")
        private String monthIndex;
        @b(a = "nextExecutionDate")
        private String nextExecutionDate;
        @b(a = "reminderDisplayName")
        private String reminderDisplayName;
        @b(a = "sourceAccount")
        private String sourceAccount;
        @b(a = "startDate")
        private String startDate;
        @b(a = "status")
        private String status;
        @b(a = "supportingData")
        private SupportingData supportingData;
        @b(a = "type")
        private String type;

        public String getCustomerId() {
            return this.customerId;
        }

        public void setCustomerId(String str) {
            this.customerId = str;
        }

        public String getSourceAccount() {
            return this.sourceAccount;
        }

        public void setSourceAccount(String str) {
            this.sourceAccount = str;
        }

        public String getDestinationAccount() {
            return this.destinationAccount;
        }

        public void setDestinationAccount(String str) {
            this.destinationAccount = str;
        }

        public String getStartDate() {
            return this.startDate;
        }

        public void setStartDate(String str) {
            this.startDate = str;
        }

        public String getEndDate() {
            return this.endDate;
        }

        public void setEndDate(String str) {
            this.endDate = str;
        }

        public Double getAmount() {
            return this.amount;
        }

        public void setAmount(Double d2) {
            this.amount = d2;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getFrequency() {
            return this.frequency;
        }

        public void setFrequency(String str) {
            this.frequency = str;
        }

        public SupportingData getSupportingData() {
            return this.supportingData;
        }

        public void setSupportingData(SupportingData supportingData2) {
            this.supportingData = supportingData2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getNextExecutionDate() {
            return this.nextExecutionDate;
        }

        public void setNextExecutionDate(String str) {
            this.nextExecutionDate = str;
        }

        public String getDayOfWeekIndex() {
            return this.dayOfWeekIndex;
        }

        public void setDayOfWeekIndex(String str) {
            this.dayOfWeekIndex = str;
        }

        public String getMonthIndex() {
            return this.monthIndex;
        }

        public void setMonthIndex(String str) {
            this.monthIndex = str;
        }

        public Integer getDateIndex() {
            return this.dateIndex;
        }

        public void setDateIndex(Integer num) {
            this.dateIndex = num;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer num) {
            this.id = num;
        }

        public String getReminderDisplayName() {
            return this.reminderDisplayName;
        }

        public void setReminderDisplayName(String str) {
            this.reminderDisplayName = str;
        }

        public String getBeneficiaryName() {
            return this.beneficiaryName;
        }

        public void setBeneficiaryName(String str) {
            this.beneficiaryName = str;
        }

        public String getIfscCode() {
            return this.ifscCode;
        }

        public void setIfscCode(String str) {
            this.ifscCode = str;
        }
    }

    public static class SupportingData extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "bankName")
        private String bankName;
        @b(a = "beneficiaryName")
        private String beneficiaryName;
        @b(a = "destinationIfsc")
        private String destinationIfsc;

        public String getDestinationIfsc() {
            return this.destinationIfsc;
        }

        public void setDestinationIfsc(String str) {
            this.destinationIfsc = str;
        }

        public String getBeneficiaryName() {
            return this.beneficiaryName;
        }

        public void setBeneficiaryName(String str) {
            this.beneficiaryName = str;
        }

        public String getBankName() {
            return this.bankName;
        }

        public void setBankName(String str) {
            this.bankName = str;
        }
    }
}
