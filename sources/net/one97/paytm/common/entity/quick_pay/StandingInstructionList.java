package net.one97.paytm.common.entity.quick_pay;

import com.google.gson.a.a;
import net.one97.paytm.common.entity.IJRDataModel;

public class StandingInstructionList implements IJRDataModel {
    private String amount;
    private String customerId;
    private String dateIndex;
    private String dayOfWeekIndex;
    private String destinationAccount;
    private boolean enablePaymentsReminder;
    private String endDate;
    private String externalId;
    private String frequency;
    private String id;
    @a
    private String lastPaid;
    private boolean markedAsPaid;
    private String monthIndex;
    private String nextExecutionDate;
    private String nextReminderDate;
    private String reminderDateIndex;
    private String reminderDayOfWeek;
    private String reminderDisplayName;
    private String reminderFrequency;
    private String reminderTimeRange;
    private String sourceAccount;
    private String startDate;
    private String status;
    private SupportingData supportingData;
    private String type;
    private String weekIndex;

    public String getSourceAccount() {
        return this.sourceAccount;
    }

    public void setSourceAccount(String str) {
        this.sourceAccount = str;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public boolean getEnablePaymentsReminder() {
        return this.enablePaymentsReminder;
    }

    public void setEnablePaymentsReminder(boolean z) {
        this.enablePaymentsReminder = z;
    }

    public SupportingData getSupportingData() {
        return this.supportingData;
    }

    public void setSupportingData(SupportingData supportingData2) {
        this.supportingData = supportingData2;
    }

    public String getReminderDayOfWeek() {
        return this.reminderDayOfWeek;
    }

    public void setReminderDayOfWeek(String str) {
        this.reminderDayOfWeek = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getReminderTimeRange() {
        return this.reminderTimeRange;
    }

    public void setReminderTimeRange(String str) {
        this.reminderTimeRange = str;
    }

    public String getDestinationAccount() {
        return this.destinationAccount;
    }

    public void setDestinationAccount(String str) {
        this.destinationAccount = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getReminderDateIndex() {
        return this.reminderDateIndex;
    }

    public void setReminderDateIndex(String str) {
        this.reminderDateIndex = str;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public String getWeekIndex() {
        return this.weekIndex;
    }

    public void setWeekIndex(String str) {
        this.weekIndex = str;
    }

    public String getDateIndex() {
        return this.dateIndex;
    }

    public void setDateIndex(String str) {
        this.dateIndex = str;
    }

    public String getDayOfWeekIndex() {
        return this.dayOfWeekIndex;
    }

    public void setDayOfWeekIndex(String str) {
        this.dayOfWeekIndex = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getMonthIndex() {
        return this.monthIndex;
    }

    public void setMonthIndex(String str) {
        this.monthIndex = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getReminderFrequency() {
        return this.reminderFrequency;
    }

    public void setReminderFrequency(String str) {
        this.reminderFrequency = str;
    }

    public String getNextExecutionDate() {
        return this.nextExecutionDate;
    }

    public void setNextExecutionDate(String str) {
        this.nextExecutionDate = str;
    }

    public String getNextReminderDate() {
        return this.nextReminderDate;
    }

    public void setNextReminderDate(String str) {
        this.nextReminderDate = str;
    }

    public String getReminderDisplayName() {
        return this.reminderDisplayName;
    }

    public void setReminderDisplayName(String str) {
        this.reminderDisplayName = str;
    }

    public String getLastPaid() {
        return this.lastPaid;
    }

    public void setLastPaid(String str) {
        this.lastPaid = str;
    }

    public String toString() {
        return "ClassPojo [sourceAccount = " + this.sourceAccount + ", startDate = " + this.startDate + ", enablePaymentsReminder = " + this.enablePaymentsReminder + ", supportingData = " + this.supportingData + ", reminderDayOfWeek = " + this.reminderDayOfWeek + ", status = " + this.status + ", reminderTimeRange = " + this.reminderTimeRange + ", destinationAccount = " + this.destinationAccount + ", endDate = " + this.endDate + ", frequency = " + this.frequency + ", type = " + this.type + ", reminderDateIndex = " + this.reminderDateIndex + ", externalId = " + this.externalId + ", weekIndex = " + this.weekIndex + ", dateIndex = " + this.dateIndex + ", dayOfWeekIndex = " + this.dayOfWeekIndex + ", id = " + this.id + ", amount = " + this.amount + ", monthIndex = " + this.monthIndex + ", customerId = " + this.customerId + ", reminderFrequency = " + this.reminderFrequency + ", nextExecutionDate = " + this.nextExecutionDate + ", nextReminderDate = " + this.nextReminderDate + "]";
    }

    public boolean isMarkedAsPaid() {
        return this.markedAsPaid;
    }

    public void setMarkedAsPaid(boolean z) {
        this.markedAsPaid = z;
    }
}
