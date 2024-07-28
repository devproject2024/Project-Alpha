package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public class CJRRechargePayment extends IJRPaytmDataModel implements IJRDataModel {
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
    private final String KEY_TXN_AMOUNT = "TXN_AMOUNT";
    private final String KEY_TXN_TOKEN = "txnToken";
    private final String NATIVE_WITHDRAWL_DETAILS = "native_withdraw_details";
    private int mCode;
    private String mDelayedOrderPayload;
    private CJRError mError;
    private String mMID;
    private String mMessage;
    private String mNativeWithdrawl;
    private String mOrderId;
    private HashMap<String, String> mPGParams = new HashMap<>();
    private String mPGUrlToHit;
    private String mResult;
    private String mStatus;
    private String mTxnAmount;
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

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        parseJSONObject(str);
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|(1:4)|5|6|(2:8|(4:11|(1:13)|14|(4:20|(1:22)|23|(2:25|98)(1:99))))|26|27|(4:30|(2:32|91)(2:33|(2:35|92)(2:36|(5:38|(1:40)(2:41|(1:43)(1:44))|(4:46|(1:48)(1:49)|50|(1:52))(1:53)|54|93)(17:55|(1:57)|58|(1:60)|61|(1:63)|64|(1:66)|67|(1:73)|74|(1:76)|77|(3:79|(4:82|(2:84|96)(1:97)|85|80)|95)|86|87|94)))|89|28)|90|101) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008f */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099 A[Catch:{ JSONException -> 0x01a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseJSONObject(java.lang.String r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "txnToken"
            java.lang.String r2 = "native_withdraw_details"
            java.lang.String r3 = "txnAmount"
            java.lang.String r4 = "native_withdraw"
            java.lang.String r5 = "TXN_AMOUNT"
            java.lang.String r6 = "ORDER_ID"
            java.lang.String r7 = "error"
            java.lang.String r8 = "result"
            java.lang.String r9 = "pgUrlToHit"
            java.lang.String r10 = "code"
            java.lang.String r11 = "title"
            java.lang.String r12 = "status"
            java.lang.String r13 = "message"
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01a7 }
            r15 = r20
            r14.<init>(r15)     // Catch:{ JSONException -> 0x01a7 }
            boolean r15 = r14.has(r10)     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x0033
            int r10 = r14.getInt(r10)     // Catch:{ JSONException -> 0x01a7 }
            r0.mCode = r10     // Catch:{ JSONException -> 0x01a7 }
        L_0x0033:
            boolean r10 = r14.has(r12)     // Catch:{ JSONException -> 0x008f }
            if (r10 == 0) goto L_0x008f
            java.lang.Object r10 = r14.get(r12)     // Catch:{ JSONException -> 0x008f }
            boolean r15 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x008f }
            if (r15 == 0) goto L_0x008f
            if (r10 == 0) goto L_0x008f
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ JSONException -> 0x008f }
            boolean r15 = r10.has(r8)     // Catch:{ JSONException -> 0x008f }
            if (r15 == 0) goto L_0x0051
            java.lang.String r8 = r10.getString(r8)     // Catch:{ JSONException -> 0x008f }
            r0.mResult = r8     // Catch:{ JSONException -> 0x008f }
        L_0x0051:
            java.lang.String r8 = r0.mResult     // Catch:{ JSONException -> 0x008f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x008f }
            if (r8 != 0) goto L_0x008f
            java.lang.String r8 = r0.mResult     // Catch:{ JSONException -> 0x008f }
            java.lang.String r15 = "failure"
            boolean r8 = r8.equalsIgnoreCase(r15)     // Catch:{ JSONException -> 0x008f }
            if (r8 == 0) goto L_0x008f
            org.json.JSONObject r8 = r10.getJSONObject(r13)     // Catch:{ JSONException -> 0x008f }
            if (r8 == 0) goto L_0x008f
            com.paytm.network.model.CJRError r10 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x008f }
            r10.<init>()     // Catch:{ JSONException -> 0x008f }
            r0.mError = r10     // Catch:{ JSONException -> 0x008f }
            boolean r10 = r8.has(r13)     // Catch:{ JSONException -> 0x008f }
            if (r10 == 0) goto L_0x007f
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x008f }
            java.lang.String r15 = r8.getString(r13)     // Catch:{ JSONException -> 0x008f }
            r10.setMessage(r15)     // Catch:{ JSONException -> 0x008f }
        L_0x007f:
            boolean r10 = r8.has(r11)     // Catch:{ JSONException -> 0x008f }
            if (r10 == 0) goto L_0x008e
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x008f }
            java.lang.String r8 = r8.getString(r11)     // Catch:{ JSONException -> 0x008f }
            r10.setTitle(r8)     // Catch:{ JSONException -> 0x008f }
        L_0x008e:
            return
        L_0x008f:
            java.util.Iterator r8 = r14.keys()     // Catch:{ JSONException -> 0x01a7 }
        L_0x0093:
            boolean r10 = r8.hasNext()     // Catch:{ JSONException -> 0x01a7 }
            if (r10 == 0) goto L_0x01a7
            java.lang.Object r10 = r8.next()     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ JSONException -> 0x01a7 }
            boolean r15 = r10.equalsIgnoreCase(r9)     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x00ac
            java.lang.String r10 = r14.getString(r9)     // Catch:{ JSONException -> 0x01a7 }
            r0.mPGUrlToHit = r10     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x0093
        L_0x00ac:
            boolean r15 = r10.equalsIgnoreCase(r12)     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x00b9
            java.lang.String r10 = r14.getString(r12)     // Catch:{ JSONException -> 0x01a7 }
            r0.mStatus = r10     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x0093
        L_0x00b9:
            boolean r15 = r10.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x010c
            java.lang.Object r10 = r14.get(r10)     // Catch:{ JSONException -> 0x01a7 }
            boolean r15 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x00cc
            org.json.JSONObject r15 = r14.getJSONObject(r7)     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x00da
        L_0x00cc:
            boolean r15 = r10 instanceof java.lang.String     // Catch:{ JSONException -> 0x01a7 }
            if (r15 == 0) goto L_0x00d9
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01a7 }
            r15.<init>()     // Catch:{ JSONException -> 0x01a7 }
            r15.put(r13, r10)     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x00da
        L_0x00d9:
            r15 = 0
        L_0x00da:
            if (r15 == 0) goto L_0x0107
            com.paytm.network.model.CJRError r10 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x01a7 }
            r10.<init>()     // Catch:{ JSONException -> 0x01a7 }
            r0.mError = r10     // Catch:{ JSONException -> 0x01a7 }
            boolean r10 = r15.has(r13)     // Catch:{ JSONException -> 0x01a7 }
            if (r10 == 0) goto L_0x00f5
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x01a7 }
            r16 = r7
            java.lang.String r7 = r15.getString(r13)     // Catch:{ JSONException -> 0x01a7 }
            r10.setMessage(r7)     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x00f7
        L_0x00f5:
            r16 = r7
        L_0x00f7:
            boolean r7 = r15.has(r11)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0109
            com.paytm.network.model.CJRError r7 = r0.mError     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r10 = r15.getString(r11)     // Catch:{ JSONException -> 0x01a7 }
            r7.setTitle(r10)     // Catch:{ JSONException -> 0x01a7 }
            goto L_0x0109
        L_0x0107:
            r16 = r7
        L_0x0109:
            r7 = r16
            goto L_0x0093
        L_0x010c:
            r16 = r7
            boolean r7 = r10.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x011a
            java.lang.String r7 = r14.getString(r6)     // Catch:{ JSONException -> 0x01a7 }
            r0.mOrderId = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x011a:
            java.lang.String r7 = "MID"
            boolean r7 = r10.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0128
            java.lang.String r7 = r14.getString(r10)     // Catch:{ JSONException -> 0x01a7 }
            r0.mMID = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x0128:
            boolean r7 = r10.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0134
            java.lang.String r7 = r14.getString(r5)     // Catch:{ JSONException -> 0x01a7 }
            r0.mTxnAmount = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x0134:
            boolean r7 = r10.equalsIgnoreCase(r13)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0140
            java.lang.String r7 = r14.getString(r10)     // Catch:{ JSONException -> 0x01a7 }
            r0.mMessage = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x0140:
            java.lang.String r7 = r0.mTxnAmount     // Catch:{ JSONException -> 0x01a7 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x015d
            boolean r7 = r10.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x015d
            org.json.JSONObject r7 = r14.getJSONObject(r3)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x015d
            java.lang.String r15 = "value"
            java.lang.String r7 = r7.optString(r15)     // Catch:{ JSONException -> 0x01a7 }
            r0.mTxnAmount = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x015d:
            boolean r7 = r10.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0169
            java.lang.String r7 = r14.getString(r4)     // Catch:{ JSONException -> 0x01a7 }
            r0.mNativeWithdrawl = r7     // Catch:{ JSONException -> 0x01a7 }
        L_0x0169:
            boolean r7 = r10.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x01a7 }
            if (r7 == 0) goto L_0x0196
            org.json.JSONObject r7 = r14.getJSONObject(r2)     // Catch:{ JSONException -> 0x01a7 }
            java.util.Iterator r15 = r7.keys()     // Catch:{ JSONException -> 0x01a7 }
        L_0x0177:
            boolean r17 = r15.hasNext()     // Catch:{ JSONException -> 0x01a7 }
            if (r17 == 0) goto L_0x0196
            java.lang.Object r17 = r15.next()     // Catch:{ JSONException -> 0x01a7 }
            r18 = r2
            r2 = r17
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x01a7 }
            boolean r2 = r2.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x01a7 }
            if (r2 == 0) goto L_0x0193
            java.lang.String r2 = r7.getString(r1)     // Catch:{ JSONException -> 0x01a7 }
            r0.mTxnToken = r2     // Catch:{ JSONException -> 0x01a7 }
        L_0x0193:
            r2 = r18
            goto L_0x0177
        L_0x0196:
            r18 = r2
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r0.mPGParams     // Catch:{ JSONException -> 0x01a7 }
            java.lang.String r7 = r14.getString(r10)     // Catch:{ JSONException -> 0x01a7 }
            r2.put(r10, r7)     // Catch:{ JSONException -> 0x01a7 }
            r7 = r16
            r2 = r18
            goto L_0x0093
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.recharge.CJRRechargePayment.parseJSONObject(java.lang.String):void");
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

    public String getTxnAmount() {
        return this.mTxnAmount;
    }

    public void setTxnAmount(String str) {
        this.mTxnAmount = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }
}
