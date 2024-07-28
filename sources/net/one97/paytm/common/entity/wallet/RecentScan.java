package net.one97.paytm.common.entity.wallet;

import net.one97.paytm.common.entity.IJRDataModel;

public class RecentScan implements IJRDataModel {
    public static final int TYPE_DEEPLINK = 3;
    public static final int TYPE_PAY = 1;
    public static final int TYPE_UTS = 2;
    private MachineIntelligentRecent machineIntelligent = new MachineIntelligentRecent();
    private String scanResult;
    private long timestamp;
    private int type;
    private String uniqKey;

    public String getUniqKey() {
        return this.uniqKey;
    }

    public void setUniqKey(String str) {
        this.uniqKey = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public String getScanResult() {
        return this.scanResult;
    }

    public void setScanResult(String str) {
        this.scanResult = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public MachineIntelligentRecent getMachineIntelligent() {
        return this.machineIntelligent;
    }

    public void setMachineIntelligent(MachineIntelligentRecent machineIntelligentRecent) {
        this.machineIntelligent = machineIntelligentRecent;
    }
}
