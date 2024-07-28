package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.one97.paytm.common.entity.IJRDataModel;

public class DigilockerInfo extends IJRPaytmDataModel implements IJRDataModel {
    private String appId;
    private Error error;
    private String hmac;
    private String iv;
    private String key;
    private String orgId;
    private String statusCode;
    private String statusMessage;
    private String ts;
    private String txn;
    private String uid;
    private String url;

    public class Error {
        private String errorCode;
        private String errorMsg;

        public Error() {
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getIv() {
        return this.iv;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public String getErrorErrorCode() {
        Error error2 = this.error;
        if (error2 != null) {
            return error2.getErrorCode();
        }
        return null;
    }

    public String getErrorErrorMessage() {
        Error error2 = this.error;
        if (error2 != null) {
            return error2.getErrorMsg();
        }
        return null;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getUid() {
        return this.uid;
    }

    public String getTs() {
        return this.ts;
    }

    public String getTxn() {
        return this.txn;
    }

    public String getHmac() {
        return this.hmac;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPostData() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(URLEncoder.encode("orgId", AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getOrgId(), AppConstants.UTF_8));
            sb.append(AppConstants.AND_SIGN);
            sb.append(URLEncoder.encode(com.business.merchant_payments.common.utility.AppConstants.TRANSACTION, AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getTxn(), AppConstants.UTF_8));
            sb.append(AppConstants.AND_SIGN);
            sb.append(URLEncoder.encode(StringSet.ts, AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getTs(), AppConstants.UTF_8));
            sb.append(AppConstants.AND_SIGN);
            sb.append(URLEncoder.encode("hmac", AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getHmac(), AppConstants.UTF_8));
            sb.append(AppConstants.AND_SIGN);
            sb.append(URLEncoder.encode("appId", AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getAppId(), AppConstants.UTF_8));
            sb.append(AppConstants.AND_SIGN);
            sb.append(URLEncoder.encode("uid", AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(getUid(), AppConstants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        DigilockerInfo digilockerInfo;
        try {
            String b2 = net.one97.paytm.common.utility.f.b(getIv(), getKey(), str);
            q.d(b2);
            digilockerInfo = (DigilockerInfo) fVar.a(b2, getClass());
            try {
                q.d(b2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            digilockerInfo = null;
            e.printStackTrace();
            return digilockerInfo;
        }
        return digilockerInfo;
    }
}
