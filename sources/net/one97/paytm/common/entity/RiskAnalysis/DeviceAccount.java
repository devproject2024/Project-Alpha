package net.one97.paytm.common.entity.RiskAnalysis;

public class DeviceAccount {
    private String type;
    private String value;

    public DeviceAccount(String str, String str2) {
        this.type = str;
        this.value = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}
