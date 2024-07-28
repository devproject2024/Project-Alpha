package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.common.entity.CJRError;
import java.util.HashMap;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public class CJRRechargePayment extends IJRPaytmDataModel {
    public static final String NATIVE_PG_ENABLE = "1";
    private static final long serialVersionUID = 1;
    private final String KEY_BODY = "body";
    private final String KEY_CODE = "code";
    private final String KEY_ERROR = "error";
    private final String KEY_MESSAGE = "message";
    private final String KEY_MID = "MID";
    private final String KEY_NATIVE_WITHDRAWL = "native_withdraw";
    private final String KEY_ORDER_ID = "ORDER_ID";
    private final String KEY_PG_URL_TO_HIT = CJRPGTransactionRequestUtils.PG_PAGE_URL;
    private final String KEY_RESULT = "result";
    private final String KEY_STATUS = "status";
    private final String KEY_TITLE = "title";
    private final String KEY_TXN_TOKEN = "txnToken";
    private final String NATIVE_WITHDRAWL_DETAILS = "native_withdraw_details";
    private int mCode;
    private String mDelayedOrderPayload;
    private CJRError mError;
    private String mMID;
    private String mNativeWithdrawl;
    private String mOrderId;
    private HashMap<String, String> mPGParams = new HashMap<>();
    private String mPGUrlToHit;
    private String mResult;
    private String mStatus;
    private String mTxnToken;
    private String paymentDetails;

    public String getmDelayedOrderPayload() {
        return this.mDelayedOrderPayload;
    }

    public void setDelayedOrderPayload(String str) {
        this.mDelayedOrderPayload = str;
    }

    public String getPaymentDetails() {
        return this.paymentDetails;
    }

    public String getMID() {
        return this.mMID;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }

    public String getPGUrlToHit() {
        return this.mPGUrlToHit;
    }

    public HashMap<String, String> getPGParams() {
        return this.mPGParams;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getmPGUrlToHit() {
        return this.mPGUrlToHit;
    }

    public void setmPGUrlToHit(String str) {
        this.mPGUrlToHit = str;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public CJRError getmError() {
        return this.mError;
    }

    public void setmError(CJRError cJRError) {
        this.mError = cJRError;
    }

    public String getmResult() {
        return this.mResult;
    }

    public void setmResult(String str) {
        this.mResult = str;
    }

    public int getmCode() {
        return this.mCode;
    }

    public void setmCode(int i2) {
        this.mCode = i2;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }

    public void setmOrderId(String str) {
        this.mOrderId = str;
    }

    public String getmMID() {
        return this.mMID;
    }

    public void setmMID(String str) {
        this.mMID = str;
    }

    public HashMap<String, String> getmPGParams() {
        return this.mPGParams;
    }

    public void setmPGParams(HashMap<String, String> hashMap) {
        this.mPGParams = hashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(1:4)|5|6|(2:8|(4:11|(1:13)|14|(4:20|(1:22)|23|(2:25|82)(1:83))))|26|27|(4:30|(2:32|72)(2:33|(2:35|73)(2:36|(3:38|(1:40)(2:41|(1:43))|(4:45|(1:47)|48|(2:50|76)(1:75))(1:74))(10:51|(1:53)|54|(1:56)|57|(1:59)|60|(3:62|(4:65|(2:67|81)(1:80)|78|63)|79)|68|77)))|70|28)|71|85) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e A[Catch:{ JSONException -> 0x0150 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseJSONObject(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "txnToken"
            java.lang.String r1 = "native_withdraw_details"
            java.lang.String r2 = "native_withdraw"
            java.lang.String r3 = "error"
            java.lang.String r4 = "result"
            java.lang.String r5 = "pgUrlToHit"
            java.lang.String r6 = "code"
            java.lang.String r7 = "title"
            java.lang.String r8 = "status"
            java.lang.String r9 = "message"
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0150 }
            r10.<init>(r14)     // Catch:{ JSONException -> 0x0150 }
            boolean r14 = r10.has(r6)     // Catch:{ JSONException -> 0x0150 }
            if (r14 == 0) goto L_0x0028
            int r14 = r10.getInt(r6)     // Catch:{ JSONException -> 0x0150 }
            r13.mCode = r14     // Catch:{ JSONException -> 0x0150 }
        L_0x0028:
            boolean r14 = r10.has(r8)     // Catch:{ JSONException -> 0x0084 }
            if (r14 == 0) goto L_0x0084
            java.lang.Object r14 = r10.get(r8)     // Catch:{ JSONException -> 0x0084 }
            boolean r6 = r14 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0084 }
            if (r6 == 0) goto L_0x0084
            if (r14 == 0) goto L_0x0084
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ JSONException -> 0x0084 }
            boolean r6 = r14.has(r4)     // Catch:{ JSONException -> 0x0084 }
            if (r6 == 0) goto L_0x0046
            java.lang.String r4 = r14.getString(r4)     // Catch:{ JSONException -> 0x0084 }
            r13.mResult = r4     // Catch:{ JSONException -> 0x0084 }
        L_0x0046:
            java.lang.String r4 = r13.mResult     // Catch:{ JSONException -> 0x0084 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0084 }
            if (r4 != 0) goto L_0x0084
            java.lang.String r4 = r13.mResult     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = "failure"
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0084
            org.json.JSONObject r14 = r14.getJSONObject(r9)     // Catch:{ JSONException -> 0x0084 }
            if (r14 == 0) goto L_0x0084
            com.paytmmall.artifact.common.entity.CJRError r4 = new com.paytmmall.artifact.common.entity.CJRError     // Catch:{ JSONException -> 0x0084 }
            r4.<init>()     // Catch:{ JSONException -> 0x0084 }
            r13.mError = r4     // Catch:{ JSONException -> 0x0084 }
            boolean r4 = r14.has(r9)     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0074
            com.paytmmall.artifact.common.entity.CJRError r4 = r13.mError     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = r14.getString(r9)     // Catch:{ JSONException -> 0x0084 }
            r4.setMessage(r6)     // Catch:{ JSONException -> 0x0084 }
        L_0x0074:
            boolean r4 = r14.has(r7)     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0083
            com.paytmmall.artifact.common.entity.CJRError r4 = r13.mError     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r14 = r14.getString(r7)     // Catch:{ JSONException -> 0x0084 }
            r4.setTitle(r14)     // Catch:{ JSONException -> 0x0084 }
        L_0x0083:
            return
        L_0x0084:
            java.util.Iterator r14 = r10.keys()     // Catch:{ JSONException -> 0x0150 }
        L_0x0088:
            boolean r4 = r14.hasNext()     // Catch:{ JSONException -> 0x0150 }
            if (r4 == 0) goto L_0x0150
            java.lang.Object r4 = r14.next()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0150 }
            boolean r6 = r4.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x00a1
            java.lang.String r4 = r10.getString(r5)     // Catch:{ JSONException -> 0x0150 }
            r13.mPGUrlToHit = r4     // Catch:{ JSONException -> 0x0150 }
            goto L_0x0088
        L_0x00a1:
            boolean r6 = r4.equalsIgnoreCase(r8)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x00ae
            java.lang.String r4 = r10.getString(r8)     // Catch:{ JSONException -> 0x0150 }
            r13.mStatus = r4     // Catch:{ JSONException -> 0x0150 }
            goto L_0x0088
        L_0x00ae:
            boolean r6 = r4.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x00f6
            java.lang.Object r4 = r10.get(r4)     // Catch:{ JSONException -> 0x0150 }
            r6 = 0
            boolean r11 = r4 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0150 }
            if (r11 == 0) goto L_0x00c2
            org.json.JSONObject r6 = r10.getJSONObject(r3)     // Catch:{ JSONException -> 0x0150 }
            goto L_0x00ce
        L_0x00c2:
            boolean r11 = r4 instanceof java.lang.String     // Catch:{ JSONException -> 0x0150 }
            if (r11 == 0) goto L_0x00ce
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0150 }
            r6.<init>()     // Catch:{ JSONException -> 0x0150 }
            r6.put(r9, r4)     // Catch:{ JSONException -> 0x0150 }
        L_0x00ce:
            if (r6 == 0) goto L_0x0088
            com.paytmmall.artifact.common.entity.CJRError r4 = new com.paytmmall.artifact.common.entity.CJRError     // Catch:{ JSONException -> 0x0150 }
            r4.<init>()     // Catch:{ JSONException -> 0x0150 }
            r13.mError = r4     // Catch:{ JSONException -> 0x0150 }
            boolean r4 = r6.has(r9)     // Catch:{ JSONException -> 0x0150 }
            if (r4 == 0) goto L_0x00e6
            com.paytmmall.artifact.common.entity.CJRError r4 = r13.mError     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r11 = r6.getString(r9)     // Catch:{ JSONException -> 0x0150 }
            r4.setMessage(r11)     // Catch:{ JSONException -> 0x0150 }
        L_0x00e6:
            boolean r4 = r6.has(r7)     // Catch:{ JSONException -> 0x0150 }
            if (r4 == 0) goto L_0x0088
            com.paytmmall.artifact.common.entity.CJRError r4 = r13.mError     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ JSONException -> 0x0150 }
            r4.setTitle(r6)     // Catch:{ JSONException -> 0x0150 }
            goto L_0x0088
        L_0x00f6:
            java.lang.String r6 = "ORDER_ID"
            boolean r6 = r4.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x0104
            java.lang.String r6 = r10.getString(r4)     // Catch:{ JSONException -> 0x0150 }
            r13.mOrderId = r6     // Catch:{ JSONException -> 0x0150 }
        L_0x0104:
            java.lang.String r6 = "MID"
            boolean r6 = r4.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x0112
            java.lang.String r6 = r10.optString(r4)     // Catch:{ JSONException -> 0x0150 }
            r13.mMID = r6     // Catch:{ JSONException -> 0x0150 }
        L_0x0112:
            boolean r6 = r4.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x011e
            java.lang.String r6 = r10.getString(r2)     // Catch:{ JSONException -> 0x0150 }
            r13.mNativeWithdrawl = r6     // Catch:{ JSONException -> 0x0150 }
        L_0x011e:
            boolean r6 = r4.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r6 == 0) goto L_0x0145
            org.json.JSONObject r6 = r10.getJSONObject(r1)     // Catch:{ JSONException -> 0x0150 }
            java.util.Iterator r11 = r6.keys()     // Catch:{ JSONException -> 0x0150 }
        L_0x012c:
            boolean r12 = r11.hasNext()     // Catch:{ JSONException -> 0x0150 }
            if (r12 == 0) goto L_0x0145
            java.lang.Object r12 = r11.next()     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x0150 }
            boolean r12 = r12.equalsIgnoreCase(r0)     // Catch:{ JSONException -> 0x0150 }
            if (r12 == 0) goto L_0x012c
            java.lang.String r12 = r6.getString(r0)     // Catch:{ JSONException -> 0x0150 }
            r13.mTxnToken = r12     // Catch:{ JSONException -> 0x0150 }
            goto L_0x012c
        L_0x0145:
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r13.mPGParams     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r11 = r10.getString(r4)     // Catch:{ JSONException -> 0x0150 }
            r6.put(r4, r11)     // Catch:{ JSONException -> 0x0150 }
            goto L_0x0088
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.cart.entity.CJRRechargePayment.parseJSONObject(java.lang.String):void");
    }

    public void setPaymentDetails(String str) {
        this.paymentDetails = str;
    }

    public String getmTxnToken() {
        return this.mTxnToken;
    }

    public String isNativeEnabled() {
        return this.mNativeWithdrawl;
    }

    public void setmNativeEnabled(String str) {
        this.mNativeWithdrawl = str;
    }

    public void setmTxnToken(String str) {
        this.mTxnToken = str;
    }

    public String toString() {
        return new f().a((Object) this);
    }
}
