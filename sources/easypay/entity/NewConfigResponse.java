package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;

public class NewConfigResponse implements Serializable {
    @c(a = "assistBaseSRO")
    private AssistDetailsResponse assistBaseSRO;
    @c(a = "assistFeatureEvents")
    private AssistFeatureEvents assistFeatureEvents;
    @c(a = "responseCode")
    private Integer responseCode;
    @c(a = "responseMessage")
    private String responseMessage;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public AssistDetailsResponse getAssistBaseSRO() {
        return this.assistBaseSRO;
    }

    public void setAssistBaseSRO(AssistDetailsResponse assistDetailsResponse) {
        this.assistBaseSRO = assistDetailsResponse;
    }

    public AssistFeatureEvents getAssistFeatureEvents() {
        return this.assistFeatureEvents;
    }

    public void setAssistFeatureEvents(AssistFeatureEvents assistFeatureEvents2) {
        this.assistFeatureEvents = assistFeatureEvents2;
    }

    public class AssistFeatureEvents implements Serializable {
        @c(a = "AutoSubmitTimer")
        private int autoSubmitTimer;
        @c(a = "isNewUIEnabled")
        private boolean isNewUIEnabled;

        public AssistFeatureEvents() {
        }

        public boolean isNewUIEnabled() {
            return this.isNewUIEnabled;
        }

        public void setNewUIEnabled(boolean z) {
            this.isNewUIEnabled = z;
        }

        public int getAutoSubmitTimer() {
            return this.autoSubmitTimer;
        }

        public void setAutoSubmitTimer(int i2) {
            this.autoSubmitTimer = i2;
        }
    }
}
