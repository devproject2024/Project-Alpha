package net.one97.paytm.common.entity.inbox.videos;

import com.paytm.network.model.IJRPaytmDataModel;

public class NewsFeedVideoCardModel extends IJRPaytmDataModel {
    private String channelGenreCode;
    private String channelId;
    private String channelName;
    private String channelUrl;
    private long createdAt;
    private String id;
    private String imgUrl;
    private String languageCode;
    private String programDescription;
    private long programEndTime;
    private String programName;
    private long programStartTime;
    private String source;
    private long updatedAt;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getChannelUrl() {
        return this.channelUrl;
    }

    public void setChannelUrl(String str) {
        this.channelUrl = str;
    }

    public String getChannelGenreCode() {
        return this.channelGenreCode;
    }

    public void setChannelGenreCode(String str) {
        this.channelGenreCode = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public String getProgramDescription() {
        return this.programDescription;
    }

    public void setProgramDescription(String str) {
        this.programDescription = str;
    }

    public long getProgramStartTime() {
        return this.programStartTime;
    }

    public void setProgramStartTime(long j) {
        this.programStartTime = j;
    }

    public String getProgramName() {
        return this.programName;
    }

    public void setProgramName(String str) {
        this.programName = str;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public long getProgramEndTime() {
        return this.programEndTime;
    }

    public void setProgramEndTime(long j) {
        this.programEndTime = j;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }
}
