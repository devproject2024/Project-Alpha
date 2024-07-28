package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class KycSavedUserData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "errorMsg")
    private String errorMsg;
    @b(a = "kycAppointmentDetail")
    private List<KYCDetail> kycAppointmentDetail = new ArrayList();
    @b(a = "message")
    private String message;
    @b(a = "name")
    private String name;
    @b(a = "statusCode")
    private Integer statusCode;

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<KYCDetail> getKYCDetail() {
        return this.kycAppointmentDetail;
    }

    public void setKYCDetail(List<KYCDetail> list) {
        this.kycAppointmentDetail = list;
    }

    public String geterrorMsg() {
        return this.errorMsg;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        q.d(str);
        return super.parseResponse(str, fVar);
    }
}
