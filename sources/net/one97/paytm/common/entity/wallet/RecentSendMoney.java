package net.one97.paytm.common.entity.wallet;

import net.one97.paytm.common.entity.IJRDataModel;

public class RecentSendMoney implements IJRDataModel {
    public static final int TYPE_DEEPLINK = 3;
    public static final int TYPE_PAY = 1;
    public static final int TYPE_UTS = 2;
    private String Imageurl;
    private String Name;
    private String PhoneNumber;
    private String amount;
    private MachineIntelligentRecent machineIntelligent = new MachineIntelligentRecent();
    private String merchantId;
    private String modeOfPayment;
    private String route;
    private long timestamp;

    public RecentSendMoney() {
    }

    public RecentSendMoney(String str, String str2) {
        this.Name = str;
        this.PhoneNumber = str2;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public String getName() {
        return this.Name;
    }

    public String getImageurl() {
        return this.Imageurl;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    public void setImageurl(String str) {
        this.Imageurl = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setPhoneNumber(String str) {
        this.PhoneNumber = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getModeOfPayment() {
        return this.modeOfPayment;
    }

    public void setModeOfPayment(String str) {
        this.modeOfPayment = str;
    }

    public MachineIntelligentRecent getMachineIntelligent() {
        return this.machineIntelligent;
    }

    public void setMachineIntelligent(MachineIntelligentRecent machineIntelligentRecent) {
        this.machineIntelligent = machineIntelligentRecent;
    }
}
