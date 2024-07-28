package net.one97.paytm.games.model.pfg;

import kotlin.g.b.k;

public final class Banner {
    private int contentType = 1;
    private String cpName = "";
    private String data = "";
    private String deeplink;
    private String destinationMID = "";
    private String gameId = "";
    private String gameName = "";
    private GPLData gplData;
    private String imageName = "";
    private int isPVP = 2;
    private String iscash = "";
    private String linksUrl = "";
    private String noCpToken = "";
    private String picUrl = "";
    private String title = "";

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final void setPicUrl(String str) {
        k.c(str, "<set-?>");
        this.picUrl = str;
    }

    public final String getLinksUrl() {
        return this.linksUrl;
    }

    public final void setLinksUrl(String str) {
        k.c(str, "<set-?>");
        this.linksUrl = str;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final void setGameId(String str) {
        k.c(str, "<set-?>");
        this.gameId = str;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final void setGameName(String str) {
        this.gameName = str;
    }

    public final String getImageName() {
        return this.imageName;
    }

    public final void setImageName(String str) {
        this.imageName = str;
    }

    public final String getCpName() {
        return this.cpName;
    }

    public final void setCpName(String str) {
        this.cpName = str;
    }

    public final String getDestinationMID() {
        return this.destinationMID;
    }

    public final void setDestinationMID(String str) {
        this.destinationMID = str;
    }

    public final String getIscash() {
        return this.iscash;
    }

    public final void setIscash(String str) {
        this.iscash = str;
    }

    public final String getNoCpToken() {
        return this.noCpToken;
    }

    public final void setNoCpToken(String str) {
        this.noCpToken = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final void setContentType(int i2) {
        this.contentType = i2;
    }

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        k.c(str, "<set-?>");
        this.data = str;
    }

    public final int isPVP() {
        return this.isPVP;
    }

    public final void setPVP(int i2) {
        this.isPVP = i2;
    }

    public final GPLData getGplData() {
        return this.gplData;
    }

    public final void setGplData(GPLData gPLData) {
        this.gplData = gPLData;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }
}
