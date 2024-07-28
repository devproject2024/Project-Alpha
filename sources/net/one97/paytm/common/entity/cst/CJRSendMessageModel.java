package net.one97.paytm.common.entity.cst;

public class CJRSendMessageModel {
    private String comment;
    private String fileData;
    private String fileName;
    private String mimeType;
    private String ticketNumber;

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(String str) {
        this.ticketNumber = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getFileData() {
        return this.fileData;
    }

    public void setFileData(String str) {
        this.fileData = str;
    }
}
