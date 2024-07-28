package net.one97.paytm.nativesdk.upiHelp.pojo;

public class UpiHelpModel {
    private String gifUrl;
    private String title;

    public UpiHelpModel(String str, String str2) {
        this.gifUrl = str2;
        this.title = str;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
