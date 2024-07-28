package net.one97.paytm.payments.visascp.network.model;

public class VisaCertificateData {
    private String certificateKey;
    private Long endDate;
    private Long id;
    private Long startDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public Long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Long l) {
        this.startDate = l;
    }

    public Long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Long l) {
        this.endDate = l;
    }

    public String getCertificateKey() {
        return this.certificateKey;
    }

    public void setCertificateKey(String str) {
        this.certificateKey = str;
    }
}
