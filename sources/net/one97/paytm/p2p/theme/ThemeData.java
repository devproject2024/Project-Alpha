package net.one97.paytm.p2p.theme;

import net.one97.paytm.common.entity.IJRDataModel;

public class ThemeData implements IJRDataModel {
    private String bgcolor;
    private String color;
    private String imagerURL;
    private String jsonData;
    private String lastUpdatedAt;
    private String message;
    private String themeId;
    private String themeName;
    private String whiteNavText;

    public String getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public void setLastUpdatedAt(String str) {
        this.lastUpdatedAt = str;
    }

    public String getImagerURL() {
        return this.imagerURL;
    }

    public void setImagerURL(String str) {
        this.imagerURL = str;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public void setJsonData(String str) {
        this.jsonData = str;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public void setThemeId(String str) {
        this.themeId = str;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public void setThemeName(String str) {
        this.themeName = str;
    }

    public String getBgcolor() {
        return this.bgcolor;
    }

    public void setBgcolor(String str) {
        this.bgcolor = str;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getWhiteNavText() {
        return this.whiteNavText;
    }

    public void setWhiteNavText(String str) {
        this.whiteNavText = str;
    }
}
