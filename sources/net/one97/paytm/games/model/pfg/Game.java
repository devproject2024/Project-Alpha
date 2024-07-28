package net.one97.paytm.games.model.pfg;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Game implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private String bestScore;
    private String cpName;
    private String destinationMID;
    private String deviceId;
    private String gameId;
    private String gameName;
    private String gameType;
    private String iconUrl;
    private String id;
    private String imageUrl;
    private String isDelete;
    private String isDownload;
    private String isShowTitlebar;
    private String iscash;
    private String lastPlaytime;
    private String loadPath;
    private String noCpToken;
    private String orientaion;
    private String packageSize;
    private String paymentMode;
    private String playtimes;
    private String recentTabIcon;
    private String shareContent;
    private String startTime;
    private String svgUrl;
    private String url;
    private String useName;
    private String userId;

    public final int describeContents() {
        return 0;
    }

    public Game() {
        this.id = "";
        this.deviceId = "";
        this.gameId = "";
        this.gameName = "";
        this.gameType = "";
        this.imageUrl = "";
        this.iconUrl = "";
        this.svgUrl = "";
        this.lastPlaytime = "";
        this.packageSize = "";
        this.playtimes = "";
        this.url = "";
        this.loadPath = "";
        this.useName = "";
        this.userId = "";
        this.startTime = "";
        this.bestScore = "";
        this.isDownload = "";
        this.isDelete = "";
        this.cpName = "";
        this.destinationMID = "";
        this.orientaion = "";
        this.iscash = "";
        this.noCpToken = "0";
        this.paymentMode = "";
        this.isShowTitlebar = "";
        this.recentTabIcon = "";
        this.shareContent = "";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        if (parcel == null) {
            k.a();
        }
        parcel.writeString(this.id);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.gameId);
        parcel.writeString(this.gameName);
        parcel.writeString(this.gameType);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.svgUrl);
        parcel.writeString(this.destinationMID);
        parcel.writeString(this.cpName);
        parcel.writeString(this.lastPlaytime);
        parcel.writeString(this.packageSize);
        parcel.writeString(this.playtimes);
        parcel.writeString(this.useName);
        parcel.writeString(this.userId);
        parcel.writeString(this.url);
        parcel.writeString(this.startTime);
        parcel.writeString(this.bestScore);
        parcel.writeString(this.isDownload);
        parcel.writeString(this.isDelete);
        parcel.writeString(this.loadPath);
        parcel.writeString(this.orientaion);
        parcel.writeString(this.iscash);
        parcel.writeString(this.noCpToken);
        parcel.writeString(this.isShowTitlebar);
        parcel.writeString(this.recentTabIcon);
        parcel.writeString(this.shareContent);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final void setGameId(String str) {
        this.gameId = str;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final void setGameName(String str) {
        this.gameName = str;
    }

    public final String getGameType() {
        return this.gameType;
    }

    public final void setGameType(String str) {
        this.gameType = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getSvgUrl() {
        return this.svgUrl;
    }

    public final void setSvgUrl(String str) {
        this.svgUrl = str;
    }

    public final String getLastPlaytime() {
        return this.lastPlaytime;
    }

    public final void setLastPlaytime(String str) {
        this.lastPlaytime = str;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final void setPackageSize(String str) {
        this.packageSize = str;
    }

    public final String getPlaytimes() {
        return this.playtimes;
    }

    public final void setPlaytimes(String str) {
        this.playtimes = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getLoadPath() {
        return this.loadPath;
    }

    public final void setLoadPath(String str) {
        this.loadPath = str;
    }

    public final String getUseName() {
        return this.useName;
    }

    public final void setUseName(String str) {
        this.useName = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final String getBestScore() {
        return this.bestScore;
    }

    public final void setBestScore(String str) {
        this.bestScore = str;
    }

    public final String isDownload() {
        return this.isDownload;
    }

    public final void setDownload(String str) {
        this.isDownload = str;
    }

    public final String isDelete() {
        return this.isDelete;
    }

    public final void setDelete(String str) {
        this.isDelete = str;
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

    public final String getOrientaion() {
        return this.orientaion;
    }

    public final void setOrientaion(String str) {
        this.orientaion = str;
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

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final String isShowTitlebar() {
        return this.isShowTitlebar;
    }

    public final void setShowTitlebar(String str) {
        this.isShowTitlebar = str;
    }

    public final String getRecentTabIcon() {
        return this.recentTabIcon;
    }

    public final void setRecentTabIcon(String str) {
        this.recentTabIcon = str;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final void setShareContent(String str) {
        this.shareContent = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Game(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.id = parcel.readString();
        this.deviceId = parcel.readString();
        this.gameId = parcel.readString();
        this.gameName = parcel.readString();
        this.gameType = parcel.readString();
        this.imageUrl = parcel.readString();
        this.iconUrl = parcel.readString();
        this.svgUrl = parcel.readString();
        this.destinationMID = parcel.readString();
        this.cpName = parcel.readString();
        this.lastPlaytime = parcel.readString();
        this.packageSize = parcel.readString();
        this.playtimes = parcel.readString();
        this.useName = parcel.readString();
        this.userId = parcel.readString();
        this.url = parcel.readString();
        this.startTime = parcel.readString();
        this.bestScore = parcel.readString();
        this.isDownload = parcel.readString();
        this.isDelete = parcel.readString();
        this.loadPath = parcel.readString();
        this.orientaion = parcel.readString();
        this.iscash = parcel.readString();
        this.noCpToken = parcel.readString();
        this.isShowTitlebar = parcel.readString();
        this.recentTabIcon = parcel.readString();
        this.shareContent = parcel.readString();
    }

    public static final class CREATOR implements Parcelable.Creator<Game> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final Game createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new Game(parcel);
        }

        public final Game[] newArray(int i2) {
            return new Game[i2];
        }
    }
}
