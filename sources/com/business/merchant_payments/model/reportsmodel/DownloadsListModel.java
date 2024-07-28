package com.business.merchant_payments.model.reportsmodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;

public class DownloadsListModel extends BaseModel {
    public int clickedButton = -1;
    @c(a = "createdOn")
    @a
    public String createdOn;
    public long downloadId;
    @c(a = "id")
    @a
    public String id;
    public boolean isDownloading;
    public boolean isFileExist;
    public boolean isPaused;
    @c(a = "pgFileStatus")
    @a
    public String pgFileStatus;
    @c(a = "pgPlusFileStatus")
    public String pgPlusFileStatus;
    public int progress;
    @c(a = "relativePath")
    @a
    public String relativePath;
    @c(a = "requestJson")
    @a
    public String requestJson;

    public int getClickedButton() {
        return this.clickedButton;
    }

    public void setClickedButton(int i2) {
        this.clickedButton = i2;
    }

    public boolean getFileExist() {
        return this.isFileExist;
    }

    public void setFileExist(boolean z) {
        this.isFileExist = z;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void setPaused(boolean z) {
        this.isPaused = z;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i2) {
        this.progress = i2;
    }

    public long getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(long j) {
        this.downloadId = j;
    }

    public boolean getIsDownloading() {
        return this.isDownloading;
    }

    public void setDownloading(boolean z) {
        this.isDownloading = z;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getRequestJson() {
        return this.requestJson;
    }

    public void setRequestJson(String str) {
        this.requestJson = str;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public String getPgFileStatus() {
        String str = this.pgFileStatus;
        return str == null ? this.pgPlusFileStatus : str;
    }

    public void setPgFileStatus(String str) {
        this.pgFileStatus = str;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }
}
