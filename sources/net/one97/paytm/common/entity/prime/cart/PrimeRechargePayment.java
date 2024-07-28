package net.one97.paytm.common.entity.prime.cart;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public class PrimeRechargePayment extends IJRPaytmDataModel implements IJRDataModel {
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
    private String code;
    private String error;
    private String errorCode;
    private String error_title;
    private int mCode;
    private CJRError mError;
    private String mMID;
    private String mNativeWithdrawl;
    private String mOrderId;
    private HashMap<String, String> mPGParams = new HashMap<>();
    private String mPGUrlToHit;
    private String mResult;
    private String mStatus;
    private String mTxnAmount;
    private String mTxnToken;
    private String paymentDetails;

    public String getPaymentDetails() {
        return this.paymentDetails;
    }

    public String getMID() {
        return this.mMID;
    }

    public String getOrderId() {
        return this.mOrderId;
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

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(1:4)|5|6|(2:8|(4:11|(1:13)|14|(4:20|(1:22)|23|(2:25|88)(1:89))))|26|27|(4:30|(2:32|81)(2:33|(2:35|82)(2:36|(5:38|(1:40)(2:41|(1:43)(1:44))|(4:46|(1:48)(1:49)|50|(1:52))(1:53)|54|83)(13:55|(1:57)|58|(1:60)|61|(1:63)|64|(1:66)|67|(3:69|(4:72|(2:74|86)(1:87)|75|70)|85)|76|77|84)))|79|28)|80|91) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A[Catch:{ JSONException -> 0x017b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseJSONObject(java.lang.String r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "txnToken"
            java.lang.String r2 = "native_withdraw_details"
            java.lang.String r3 = "native_withdraw"
            java.lang.String r4 = "TXN_AMOUNT"
            java.lang.String r5 = "MID"
            java.lang.String r6 = "ORDER_ID"
            java.lang.String r7 = "error"
            java.lang.String r8 = "result"
            java.lang.String r9 = "pgUrlToHit"
            java.lang.String r10 = "code"
            java.lang.String r11 = "title"
            java.lang.String r12 = "status"
            java.lang.String r13 = "message"
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017b }
            r15 = r20
            r14.<init>(r15)     // Catch:{ JSONException -> 0x017b }
            boolean r15 = r14.has(r10)     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x0032
            int r10 = r14.getInt(r10)     // Catch:{ JSONException -> 0x017b }
            r0.mCode = r10     // Catch:{ JSONException -> 0x017b }
        L_0x0032:
            boolean r10 = r14.has(r12)     // Catch:{ JSONException -> 0x008e }
            if (r10 == 0) goto L_0x008e
            java.lang.Object r10 = r14.get(r12)     // Catch:{ JSONException -> 0x008e }
            boolean r15 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x008e }
            if (r15 == 0) goto L_0x008e
            if (r10 == 0) goto L_0x008e
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ JSONException -> 0x008e }
            boolean r15 = r10.has(r8)     // Catch:{ JSONException -> 0x008e }
            if (r15 == 0) goto L_0x0050
            java.lang.String r8 = r10.getString(r8)     // Catch:{ JSONException -> 0x008e }
            r0.mResult = r8     // Catch:{ JSONException -> 0x008e }
        L_0x0050:
            java.lang.String r8 = r0.mResult     // Catch:{ JSONException -> 0x008e }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x008e }
            if (r8 != 0) goto L_0x008e
            java.lang.String r8 = r0.mResult     // Catch:{ JSONException -> 0x008e }
            java.lang.String r15 = "failure"
            boolean r8 = r8.equalsIgnoreCase(r15)     // Catch:{ JSONException -> 0x008e }
            if (r8 == 0) goto L_0x008e
            org.json.JSONObject r8 = r10.getJSONObject(r13)     // Catch:{ JSONException -> 0x008e }
            if (r8 == 0) goto L_0x008e
            com.paytm.network.model.CJRError r10 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x008e }
            r10.<init>()     // Catch:{ JSONException -> 0x008e }
            r0.mError = r10     // Catch:{ JSONException -> 0x008e }
            boolean r10 = r8.has(r13)     // Catch:{ JSONException -> 0x008e }
            if (r10 == 0) goto L_0x007e
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x008e }
            java.lang.String r15 = r8.getString(r13)     // Catch:{ JSONException -> 0x008e }
            r10.setMessage(r15)     // Catch:{ JSONException -> 0x008e }
        L_0x007e:
            boolean r10 = r8.has(r11)     // Catch:{ JSONException -> 0x008e }
            if (r10 == 0) goto L_0x008d
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x008e }
            java.lang.String r8 = r8.getString(r11)     // Catch:{ JSONException -> 0x008e }
            r10.setTitle(r8)     // Catch:{ JSONException -> 0x008e }
        L_0x008d:
            return
        L_0x008e:
            java.util.Iterator r8 = r14.keys()     // Catch:{ JSONException -> 0x017b }
        L_0x0092:
            boolean r10 = r8.hasNext()     // Catch:{ JSONException -> 0x017b }
            if (r10 == 0) goto L_0x017b
            java.lang.Object r10 = r8.next()     // Catch:{ JSONException -> 0x017b }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ JSONException -> 0x017b }
            boolean r15 = r10.equalsIgnoreCase(r9)     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x00ab
            java.lang.String r10 = r14.getString(r9)     // Catch:{ JSONException -> 0x017b }
            r0.mPGUrlToHit = r10     // Catch:{ JSONException -> 0x017b }
            goto L_0x0092
        L_0x00ab:
            boolean r15 = r10.equalsIgnoreCase(r12)     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x00b8
            java.lang.String r10 = r14.getString(r12)     // Catch:{ JSONException -> 0x017b }
            r0.mStatus = r10     // Catch:{ JSONException -> 0x017b }
            goto L_0x0092
        L_0x00b8:
            boolean r15 = r10.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x010b
            java.lang.Object r10 = r14.get(r10)     // Catch:{ JSONException -> 0x017b }
            boolean r15 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x00cb
            org.json.JSONObject r15 = r14.getJSONObject(r7)     // Catch:{ JSONException -> 0x017b }
            goto L_0x00d9
        L_0x00cb:
            boolean r15 = r10 instanceof java.lang.String     // Catch:{ JSONException -> 0x017b }
            if (r15 == 0) goto L_0x00d8
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017b }
            r15.<init>()     // Catch:{ JSONException -> 0x017b }
            r15.put(r13, r10)     // Catch:{ JSONException -> 0x017b }
            goto L_0x00d9
        L_0x00d8:
            r15 = 0
        L_0x00d9:
            if (r15 == 0) goto L_0x0106
            com.paytm.network.model.CJRError r10 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x017b }
            r10.<init>()     // Catch:{ JSONException -> 0x017b }
            r0.mError = r10     // Catch:{ JSONException -> 0x017b }
            boolean r10 = r15.has(r13)     // Catch:{ JSONException -> 0x017b }
            if (r10 == 0) goto L_0x00f4
            com.paytm.network.model.CJRError r10 = r0.mError     // Catch:{ JSONException -> 0x017b }
            r16 = r7
            java.lang.String r7 = r15.getString(r13)     // Catch:{ JSONException -> 0x017b }
            r10.setMessage(r7)     // Catch:{ JSONException -> 0x017b }
            goto L_0x00f6
        L_0x00f4:
            r16 = r7
        L_0x00f6:
            boolean r7 = r15.has(r11)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x0108
            com.paytm.network.model.CJRError r7 = r0.mError     // Catch:{ JSONException -> 0x017b }
            java.lang.String r10 = r15.getString(r11)     // Catch:{ JSONException -> 0x017b }
            r7.setTitle(r10)     // Catch:{ JSONException -> 0x017b }
            goto L_0x0108
        L_0x0106:
            r16 = r7
        L_0x0108:
            r7 = r16
            goto L_0x0092
        L_0x010b:
            r16 = r7
            boolean r7 = r10.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x0119
            java.lang.String r7 = r14.getString(r6)     // Catch:{ JSONException -> 0x017b }
            r0.mOrderId = r7     // Catch:{ JSONException -> 0x017b }
        L_0x0119:
            boolean r7 = r10.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x0125
            java.lang.String r7 = r14.getString(r5)     // Catch:{ JSONException -> 0x017b }
            r0.mMID = r7     // Catch:{ JSONException -> 0x017b }
        L_0x0125:
            boolean r7 = r10.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x0131
            java.lang.String r7 = r14.getString(r4)     // Catch:{ JSONException -> 0x017b }
            r0.mTxnAmount = r7     // Catch:{ JSONException -> 0x017b }
        L_0x0131:
            boolean r7 = r10.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x013d
            java.lang.String r7 = r14.getString(r3)     // Catch:{ JSONException -> 0x017b }
            r0.mNativeWithdrawl = r7     // Catch:{ JSONException -> 0x017b }
        L_0x013d:
            boolean r7 = r10.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x017b }
            if (r7 == 0) goto L_0x016a
            org.json.JSONObject r7 = r14.getJSONObject(r2)     // Catch:{ JSONException -> 0x017b }
            java.util.Iterator r15 = r7.keys()     // Catch:{ JSONException -> 0x017b }
        L_0x014b:
            boolean r17 = r15.hasNext()     // Catch:{ JSONException -> 0x017b }
            if (r17 == 0) goto L_0x016a
            java.lang.Object r17 = r15.next()     // Catch:{ JSONException -> 0x017b }
            r18 = r2
            r2 = r17
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x017b }
            boolean r2 = r2.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x017b }
            if (r2 == 0) goto L_0x0167
            java.lang.String r2 = r7.getString(r1)     // Catch:{ JSONException -> 0x017b }
            r0.mTxnToken = r2     // Catch:{ JSONException -> 0x017b }
        L_0x0167:
            r2 = r18
            goto L_0x014b
        L_0x016a:
            r18 = r2
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r0.mPGParams     // Catch:{ JSONException -> 0x017b }
            java.lang.String r7 = r14.getString(r10)     // Catch:{ JSONException -> 0x017b }
            r2.put(r10, r7)     // Catch:{ JSONException -> 0x017b }
            r7 = r16
            r2 = r18
            goto L_0x0092
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment.parseJSONObject(java.lang.String):void");
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

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|(1:4)|5|6|(2:8|(4:11|(1:13)|14|(5:20|(1:22)|23|(1:25)|26)))|27|28|(4:31|(2:33|86)(2:34|(2:36|87)(2:37|(5:39|(1:41)(2:42|(1:44)(1:45))|(5:47|(1:49)(1:50)|51|(1:53)|54)(1:55)|56|88)(13:57|(1:59)|60|(1:62)|63|(1:65)|66|(1:68)|69|(3:71|(4:74|(2:76|91)(1:92)|77|72)|90)|78|79|89)))|84|29)|85|80) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad A[Catch:{ JSONException -> 0x01cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.paytm.network.model.IJRPaytmDataModel parseResponse(java.lang.String r21, com.google.gsonhtcfix.f r22) throws java.lang.Exception {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "txnToken"
            java.lang.String r2 = "native_withdraw_details"
            java.lang.String r3 = "native_withdraw"
            java.lang.String r4 = "TXN_AMOUNT"
            java.lang.String r5 = "MID"
            java.lang.String r6 = "ORDER_ID"
            java.lang.String r7 = "error"
            java.lang.String r8 = "result"
            java.lang.String r9 = "pgUrlToHit"
            java.lang.String r10 = "code"
            java.lang.String r11 = "title"
            java.lang.String r12 = "status"
            java.lang.String r13 = "message"
            net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment r14 = new net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment
            r14.<init>()
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01cf }
            r16 = r1
            r1 = r21
            r15.<init>(r1)     // Catch:{ JSONException -> 0x01cf }
            boolean r17 = r15.has(r10)     // Catch:{ JSONException -> 0x01cf }
            if (r17 == 0) goto L_0x003e
            int r10 = r15.getInt(r10)     // Catch:{ JSONException -> 0x01cf }
            r0.mCode = r10     // Catch:{ JSONException -> 0x01cf }
            int r10 = r0.mCode     // Catch:{ JSONException -> 0x01cf }
            r14.setmCode(r10)     // Catch:{ JSONException -> 0x01cf }
        L_0x003e:
            boolean r10 = r15.has(r12)     // Catch:{ JSONException -> 0x00a3 }
            if (r10 == 0) goto L_0x00a3
            java.lang.Object r10 = r15.get(r12)     // Catch:{ JSONException -> 0x00a3 }
            boolean r1 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x00a3 }
            if (r1 == 0) goto L_0x00a3
            if (r10 == 0) goto L_0x00a3
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ JSONException -> 0x00a3 }
            boolean r1 = r10.has(r8)     // Catch:{ JSONException -> 0x00a3 }
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = r10.getString(r8)     // Catch:{ JSONException -> 0x00a3 }
            r0.mResult = r1     // Catch:{ JSONException -> 0x00a3 }
        L_0x005c:
            java.lang.String r1 = r0.mResult     // Catch:{ JSONException -> 0x00a3 }
            r14.setmResult(r1)     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r1 = r0.mResult     // Catch:{ JSONException -> 0x00a3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00a3 }
            if (r1 != 0) goto L_0x00a3
            java.lang.String r1 = r0.mResult     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r8 = "failure"
            boolean r1 = r1.equalsIgnoreCase(r8)     // Catch:{ JSONException -> 0x00a3 }
            if (r1 == 0) goto L_0x00a3
            org.json.JSONObject r1 = r10.getJSONObject(r13)     // Catch:{ JSONException -> 0x00a3 }
            if (r1 == 0) goto L_0x00a3
            com.paytm.network.model.CJRError r8 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x00a3 }
            r8.<init>()     // Catch:{ JSONException -> 0x00a3 }
            r0.mError = r8     // Catch:{ JSONException -> 0x00a3 }
            boolean r8 = r1.has(r13)     // Catch:{ JSONException -> 0x00a3 }
            if (r8 == 0) goto L_0x008f
            com.paytm.network.model.CJRError r8 = r0.mError     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r10 = r1.getString(r13)     // Catch:{ JSONException -> 0x00a3 }
            r8.setMessage(r10)     // Catch:{ JSONException -> 0x00a3 }
        L_0x008f:
            boolean r8 = r1.has(r11)     // Catch:{ JSONException -> 0x00a3 }
            if (r8 == 0) goto L_0x009e
            com.paytm.network.model.CJRError r8 = r0.mError     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r1 = r1.getString(r11)     // Catch:{ JSONException -> 0x00a3 }
            r8.setTitle(r1)     // Catch:{ JSONException -> 0x00a3 }
        L_0x009e:
            com.paytm.network.model.CJRError r1 = r0.mError     // Catch:{ JSONException -> 0x00a3 }
            r14.setmError(r1)     // Catch:{ JSONException -> 0x00a3 }
        L_0x00a3:
            java.util.Iterator r1 = r15.keys()     // Catch:{ JSONException -> 0x01cf }
        L_0x00a7:
            boolean r8 = r1.hasNext()     // Catch:{ JSONException -> 0x01cf }
            if (r8 == 0) goto L_0x01ce
            java.lang.Object r8 = r1.next()     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x01cf }
            boolean r10 = r8.equalsIgnoreCase(r9)     // Catch:{ JSONException -> 0x01cf }
            if (r10 == 0) goto L_0x00c5
            java.lang.String r8 = r15.getString(r9)     // Catch:{ JSONException -> 0x01cf }
            r0.mPGUrlToHit = r8     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r8 = r0.mPGUrlToHit     // Catch:{ JSONException -> 0x01cf }
            r14.setmPGUrlToHit(r8)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x00a7
        L_0x00c5:
            boolean r10 = r8.equalsIgnoreCase(r12)     // Catch:{ JSONException -> 0x01cf }
            if (r10 == 0) goto L_0x00d7
            java.lang.String r8 = r15.getString(r12)     // Catch:{ JSONException -> 0x01cf }
            r0.mStatus = r8     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r8 = r0.mStatus     // Catch:{ JSONException -> 0x01cf }
            r14.setmStatus(r8)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x00a7
        L_0x00d7:
            boolean r10 = r8.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x01cf }
            if (r10 == 0) goto L_0x0130
            java.lang.Object r8 = r15.get(r8)     // Catch:{ JSONException -> 0x01cf }
            boolean r10 = r8 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x01cf }
            if (r10 == 0) goto L_0x00ea
            org.json.JSONObject r10 = r15.getJSONObject(r7)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x00f8
        L_0x00ea:
            boolean r10 = r8 instanceof java.lang.String     // Catch:{ JSONException -> 0x01cf }
            if (r10 == 0) goto L_0x00f7
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01cf }
            r10.<init>()     // Catch:{ JSONException -> 0x01cf }
            r10.put(r13, r8)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x00f8
        L_0x00f7:
            r10 = 0
        L_0x00f8:
            if (r10 == 0) goto L_0x012a
            com.paytm.network.model.CJRError r8 = new com.paytm.network.model.CJRError     // Catch:{ JSONException -> 0x01cf }
            r8.<init>()     // Catch:{ JSONException -> 0x01cf }
            r0.mError = r8     // Catch:{ JSONException -> 0x01cf }
            boolean r8 = r10.has(r13)     // Catch:{ JSONException -> 0x01cf }
            if (r8 == 0) goto L_0x0113
            com.paytm.network.model.CJRError r8 = r0.mError     // Catch:{ JSONException -> 0x01cf }
            r17 = r1
            java.lang.String r1 = r10.getString(r13)     // Catch:{ JSONException -> 0x01cf }
            r8.setMessage(r1)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x0115
        L_0x0113:
            r17 = r1
        L_0x0115:
            boolean r1 = r10.has(r11)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x0124
            com.paytm.network.model.CJRError r1 = r0.mError     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r8 = r10.getString(r11)     // Catch:{ JSONException -> 0x01cf }
            r1.setTitle(r8)     // Catch:{ JSONException -> 0x01cf }
        L_0x0124:
            com.paytm.network.model.CJRError r1 = r0.mError     // Catch:{ JSONException -> 0x01cf }
            r14.setmError(r1)     // Catch:{ JSONException -> 0x01cf }
            goto L_0x012c
        L_0x012a:
            r17 = r1
        L_0x012c:
            r1 = r17
            goto L_0x00a7
        L_0x0130:
            r17 = r1
            boolean r1 = r8.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x0143
            java.lang.String r1 = r15.getString(r6)     // Catch:{ JSONException -> 0x01cf }
            r0.mOrderId = r1     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r1 = r0.mOrderId     // Catch:{ JSONException -> 0x01cf }
            r14.setmOrderId(r1)     // Catch:{ JSONException -> 0x01cf }
        L_0x0143:
            boolean r1 = r8.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x0154
            java.lang.String r1 = r15.getString(r5)     // Catch:{ JSONException -> 0x01cf }
            r0.mMID = r1     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r1 = r0.mMID     // Catch:{ JSONException -> 0x01cf }
            r14.setmMID(r1)     // Catch:{ JSONException -> 0x01cf }
        L_0x0154:
            boolean r1 = r8.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x0165
            java.lang.String r1 = r15.getString(r4)     // Catch:{ JSONException -> 0x01cf }
            r0.mTxnAmount = r1     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r1 = r0.mTxnAmount     // Catch:{ JSONException -> 0x01cf }
            r14.setTxnAmount(r1)     // Catch:{ JSONException -> 0x01cf }
        L_0x0165:
            boolean r1 = r8.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x0176
            java.lang.String r1 = r15.getString(r3)     // Catch:{ JSONException -> 0x01cf }
            r0.mNativeWithdrawl = r1     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r1 = r0.mNativeWithdrawl     // Catch:{ JSONException -> 0x01cf }
            r14.setmNativeEnabled(r1)     // Catch:{ JSONException -> 0x01cf }
        L_0x0176:
            boolean r1 = r8.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x01cf }
            if (r1 == 0) goto L_0x01b0
            org.json.JSONObject r1 = r15.getJSONObject(r2)     // Catch:{ JSONException -> 0x01cf }
            java.util.Iterator r10 = r1.keys()     // Catch:{ JSONException -> 0x01cf }
        L_0x0184:
            boolean r18 = r10.hasNext()     // Catch:{ JSONException -> 0x01cf }
            if (r18 == 0) goto L_0x01b0
            java.lang.Object r18 = r10.next()     // Catch:{ JSONException -> 0x01cf }
            r19 = r2
            r2 = r18
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x01cf }
            r18 = r3
            r3 = r16
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x01cf }
            if (r2 == 0) goto L_0x01a9
            java.lang.String r2 = r1.getString(r3)     // Catch:{ JSONException -> 0x01cf }
            r0.mTxnToken = r2     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r2 = r0.mTxnAmount     // Catch:{ JSONException -> 0x01cf }
            r14.setmTxnToken(r2)     // Catch:{ JSONException -> 0x01cf }
        L_0x01a9:
            r16 = r3
            r3 = r18
            r2 = r19
            goto L_0x0184
        L_0x01b0:
            r19 = r2
            r18 = r3
            r3 = r16
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r0.mPGParams     // Catch:{ JSONException -> 0x01cf }
            java.lang.String r2 = r15.getString(r8)     // Catch:{ JSONException -> 0x01cf }
            r1.put(r8, r2)     // Catch:{ JSONException -> 0x01cf }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r0.mPGParams     // Catch:{ JSONException -> 0x01cf }
            r14.setmPGParams(r1)     // Catch:{ JSONException -> 0x01cf }
            r16 = r3
            r1 = r17
            r3 = r18
            r2 = r19
            goto L_0x00a7
        L_0x01ce:
            return r14
        L_0x01cf:
            com.paytm.network.model.IJRPaytmDataModel r1 = super.parseResponse(r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.prime.cart.PrimeRechargePayment.parseResponse(java.lang.String, com.google.gsonhtcfix.f):com.paytm.network.model.IJRPaytmDataModel");
    }
}
