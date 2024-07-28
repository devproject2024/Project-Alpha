package net.one97.paytm.common.entity.weex;

public class SliderViewData {
    private String image_url;
    private String type;

    public SliderViewData(String str, String str2) {
        this.type = str;
        this.image_url = str2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        return this.image_url;
    }

    public void setUrl(String str) {
        this.image_url = str;
    }
}
