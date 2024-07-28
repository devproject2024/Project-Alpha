package net.one97.paytm.dynamicModule;

public class DynamicModuleLoaderItem implements Cloneable {
    private int downloadPercent;
    private int downloadTime = -5000;
    private int errorCode = -5000;
    private String failureDump = null;
    private int iconUrl;
    private boolean isFailed;
    private boolean isRequestInitiatedButNotDownload;
    private String name;
    private int sessionId;
    private long size = -5000;
    private int statusCode = -5000;
    private String statusText;
    private String title;

    public DynamicModuleLoaderItem(String str) {
        this.name = str;
        this.title = DynamicModuleHelper.getModuleTitle(str);
        this.iconUrl = DynamicModuleHelper.getModuleIcon(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setStatusText(String str) {
        this.statusText = str;
    }

    public boolean isFailed() {
        return this.isFailed;
    }

    public void setFailed(boolean z) {
        this.isFailed = z;
    }

    public int getDownloadPercent() {
        return this.downloadPercent;
    }

    public void setDownloadPercent(int i2) {
        this.downloadPercent = i2;
    }

    public int getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(int i2) {
        this.iconUrl = i2;
    }

    public boolean isRequestInitiatedButNotDownload() {
        return this.isRequestInitiatedButNotDownload;
    }

    public void setRequestInitiatedButNotDownload(boolean z) {
        this.isRequestInitiatedButNotDownload = z;
    }

    public DynamicModuleLoaderItem clone() throws CloneNotSupportedException {
        return (DynamicModuleLoaderItem) super.clone();
    }

    public void setSessionId(int i2) {
        this.sessionId = i2;
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public int getDownloadTime() {
        return this.downloadTime;
    }

    public void setDownloadTime(int i2) {
        this.downloadTime = i2;
    }

    public String getFailureDump() {
        return this.failureDump;
    }

    public void setFailureDump(String str) {
        this.failureDump = str;
    }
}
