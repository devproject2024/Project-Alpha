package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatAncillaryCombinedModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "body")
    private CJRSeatBody CJRSeatBody;
    @a
    @b(a = "meta")
    private CJRSeatSkeletonMeta CJRSeatSkeletonMeta;
    @a
    @b(a = "status")
    private CJRSeatStatus CJRSeatStatus;
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private String error;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public CJRSeatStatus getCJRSeatStatus() {
        return this.CJRSeatStatus;
    }

    public void setCJRSeatStatus(CJRSeatStatus cJRSeatStatus) {
        this.CJRSeatStatus = cJRSeatStatus;
    }

    public CJRSeatBody getCJRSeatBody() {
        return this.CJRSeatBody;
    }

    public void setCJRSeatBody(CJRSeatBody cJRSeatBody) {
        this.CJRSeatBody = cJRSeatBody;
    }

    public CJRSeatSkeletonMeta getCJRSeatSkeletonMeta() {
        return this.CJRSeatSkeletonMeta;
    }

    public void setCJRSeatSkeletonMeta(CJRSeatSkeletonMeta cJRSeatSkeletonMeta) {
        this.CJRSeatSkeletonMeta = cJRSeatSkeletonMeta;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public String toString() {
        return "Example{error=" + this.error + ", status=" + this.CJRSeatStatus + ", body=" + this.CJRSeatBody + ", meta=" + this.CJRSeatSkeletonMeta + ", code=" + this.code + '}';
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
