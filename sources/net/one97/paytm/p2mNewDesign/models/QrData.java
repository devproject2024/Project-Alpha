package net.one97.paytm.p2mNewDesign.models;

import com.google.gson.f;
import net.one97.paytm.common.entity.IJRDataModel;

public class QrData implements IJRDataModel {
    private Long Tbackend;
    private Long Tcache;
    private Long Tpayment;
    private Long Tprocess;
    private Long Tscan;
    private String action = "Scan";
    private String correctionLevel;
    private Long eventEndTime;
    private String eventName;
    private Long eventStartTime;
    private String failReason;
    private int firebase_failed_attempts;
    private Long firstFrame_QrFound;
    private String firstQrDetectedTime;
    private String flow;
    private String isMultiQREnabled;
    private String isSuccess;
    private String isWinner;
    private Long qrFound_qrResolution;
    private String qrPayload;
    private Long qrResolution_enterAmount;
    private String qrVersion;
    private Long scanClick_enterAmount;
    private Long scanClick_firstFrame;
    private String scanDuration;
    private String scanPaySessionEndTime;
    private String scanPaySessionStartTime;
    private String scanSessionId;
    private String scannedCount;
    private String status;
    private Long timeTaken;
    private String trigger_point;
    private int zxing_falied_attempts;

    public Long getScanClick_firstFrame() {
        return this.scanClick_firstFrame;
    }

    public void setScanClick_firstFrame(Long l) {
        this.scanClick_firstFrame = l;
    }

    public Long getFirstFrame_QrFound() {
        return this.firstFrame_QrFound;
    }

    public void setFirstFrame_QrFound(Long l) {
        this.firstFrame_QrFound = l;
    }

    public String getTrigger_point() {
        return this.trigger_point;
    }

    public void setTrigger_point(String str) {
        this.trigger_point = str;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setZxing_falied_attempts(int i2) {
        this.zxing_falied_attempts = i2;
    }

    public void setFirebase_failed_attempts(int i2) {
        this.firebase_failed_attempts = i2;
    }

    public Long getQrFound_qrResolution() {
        return this.qrFound_qrResolution;
    }

    public void setQrFound_qrResolution(Long l) {
        this.qrFound_qrResolution = l;
    }

    public Long getQrResolution_enterAmount() {
        return this.qrResolution_enterAmount;
    }

    public void setQrResolution_enterAmount(Long l) {
        this.qrResolution_enterAmount = l;
    }

    public Long getScanClick_enterAmount() {
        return this.scanClick_enterAmount;
    }

    public void setScanClick_enterAmount(Long l) {
        this.scanClick_enterAmount = l;
    }

    public QrData() {
    }

    public QrData(String str, Long l, long j, long j2, String str2, String str3) {
        setEventName(str);
        setEventStartTime(l);
        setEventEndTime(Long.valueOf(j));
        setTimeTaken(Long.valueOf(j2));
        setStatus(str2);
        setFlow(str3);
    }

    public String getScanDuration() {
        return this.scanDuration;
    }

    public void setScanDuration(String str) {
        this.scanDuration = str;
    }

    public String getFirstQrDetectedTime() {
        return this.firstQrDetectedTime;
    }

    public void setFirstQrDetectedTime(String str) {
        this.firstQrDetectedTime = str;
    }

    public String getScannedCount() {
        return this.scannedCount;
    }

    public void setScannedCount(String str) {
        this.scannedCount = str;
    }

    public String getQrVersion() {
        return this.qrVersion;
    }

    public void setQrVersion(String str) {
        this.qrVersion = str;
    }

    public String getIsMultiQREnabled() {
        return this.isMultiQREnabled;
    }

    public void setIsMultiQREnabled(String str) {
        this.isMultiQREnabled = str;
    }

    public String getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(String str) {
        this.isSuccess = str;
    }

    public String getIsWinner() {
        return this.isWinner;
    }

    public void setIsWinner(String str) {
        this.isWinner = str;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String str) {
        this.eventName = str;
    }

    public String getQrPayload() {
        return this.qrPayload;
    }

    public void setQrPayload(String str) {
        this.qrPayload = str;
    }

    public String getScanSessionId() {
        return this.scanSessionId;
    }

    public void setScanSessionId(String str) {
        this.scanSessionId = str;
    }

    public String getFailReason() {
        return this.failReason;
    }

    public void setFailReason(String str) {
        this.failReason = str;
    }

    public String getCorrectionLevel() {
        return this.correctionLevel;
    }

    public void setCorrectionLevel(String str) {
        this.correctionLevel = str;
    }

    public void setEventStartTime(Long l) {
        this.eventStartTime = l;
    }

    public void setEventEndTime(Long l) {
        this.eventEndTime = l;
    }

    public void setTimeTaken(Long l) {
        this.timeTaken = l;
    }

    public void setFlow(String str) {
        this.flow = str;
    }

    public void setScanPaySessionStartTime(String str) {
        this.scanPaySessionStartTime = str;
    }

    public void setScanPaySessionEndTime(String str) {
        this.scanPaySessionEndTime = str;
    }

    public void setTscan(Long l) {
        this.Tscan = l;
    }

    public void setTbackend(Long l) {
        this.Tbackend = l;
    }

    public void setTcache(Long l) {
        this.Tcache = l;
    }

    public void setTprocess(Long l) {
        this.Tprocess = l;
    }

    public void setTpayment(Long l) {
        this.Tpayment = l;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        try {
            return new f().b(this);
        } catch (Exception unused) {
            return "";
        }
    }
}
