package net.one97.paytm.passbook.beans.data;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class IconMetaDataModel extends IJRDataModel {
    private String cacheURL1 = "";
    private String cacheURL2 = "";
    private String cacheURL3 = "";
    private String cacheURL4 = "";
    private int iconIDTemp = -1;
    private String resolution = "";
    private String url1 = "";
    private String url2 = "";
    private String url3 = "";
    private String url4 = "";

    public int getIconIDTemp() {
        return this.iconIDTemp;
    }

    public void setIconIDTemp(int i2) {
        this.iconIDTemp = i2;
    }

    public String getCacheURL1() {
        return this.cacheURL1;
    }

    public void setCacheURL1(String str) {
        this.cacheURL1 = str;
    }

    public String getUrl1() {
        return this.url1;
    }

    public void setUrl1(String str) {
        this.url1 = str;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public String getUrl2() {
        return this.url2;
    }

    public void setUrl2(String str) {
        this.url2 = str;
    }

    public String getUrl3() {
        return this.url3;
    }

    public void setUrl3(String str) {
        this.url3 = str;
    }

    public String getUrl4() {
        return this.url4;
    }

    public void setUrl4(String str) {
        this.url4 = str;
    }

    public String getCacheURL2() {
        return this.cacheURL2;
    }

    public void setCacheURL2(String str) {
        this.cacheURL2 = str;
    }

    public String getCacheURL3() {
        return this.cacheURL3;
    }

    public void setCacheURL3(String str) {
        this.cacheURL3 = str;
    }

    public String getCacheURL4() {
        return this.cacheURL4;
    }

    public void setCacheURL4(String str) {
        this.cacheURL4 = str;
    }
}
