package net.one97.paytm.wifi.models;

public final class WifiAdditional {
    private OpenCloseTime openCloseTime;
    private String pId;
    private String vendorName;
    private WifiRating wifiRating;

    public final String getVendorName() {
        return this.vendorName;
    }

    public final void setVendorName(String str) {
        this.vendorName = str;
    }

    public final OpenCloseTime getOpenCloseTime() {
        return this.openCloseTime;
    }

    public final void setOpenCloseTime(OpenCloseTime openCloseTime2) {
        this.openCloseTime = openCloseTime2;
    }

    public final WifiRating getWifiRating() {
        return this.wifiRating;
    }

    public final void setWifiRating(WifiRating wifiRating2) {
        this.wifiRating = wifiRating2;
    }

    public final String getPId() {
        return this.pId;
    }

    public final void setPId(String str) {
        this.pId = str;
    }

    public final String toString() {
        return "WifiAdditional(vendorName=" + this.vendorName + ',' + " openCloseTime=" + this.openCloseTime + ", wifiRating=" + this.wifiRating + " pId=" + this.pId + ')';
    }
}
