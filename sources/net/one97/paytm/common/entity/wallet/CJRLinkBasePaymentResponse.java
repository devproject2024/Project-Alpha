package net.one97.paytm.common.entity.wallet;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRLinkBasePaymentResponse extends CJRWalletDataModel implements IJRDataModel {
    private String active;
    @c(a = "amount")
    public double amount = 0.0d;
    private String createdDate;
    private String dueDate;
    @c(a = "errorCode")
    public String errorCode;
    @c(a = "errorMessage")
    public String errorMessage;
    private String expiryDate;
    @c(a = "id")
    public String id;
    @c(a = "imageData")
    public String imageData;
    @c(a = "imageName")
    public String imageName;
    private String invoiceId;
    private String isActive;
    @c(a = "linkDescription")
    public String linkDescription;
    @c(a = "linkName")
    public String linkName;
    @c(a = "linkType")
    public String linkType;
    private String longUrl;
    private String merchantHtml;
    @c(a = "merchantName")
    public String merchantName;
    @c(a = "mid")
    public String mid;
    private String penaltyFee;
    @c(a = "pgEnabled")
    public boolean pgEnabled = false;
    private String shortUrl;
    private CJRWarningMessageContainer warningMessageContainer;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006d A[Catch:{ JSONException -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070 A[Catch:{ JSONException -> 0x0079 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject getResponseJSON() {
        /*
            r7 = this;
            java.lang.String r0 = "MERCHANT_NAME"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "mappingId"
            java.lang.String r3 = r7.mid     // Catch:{ JSONException -> 0x0079 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0079 }
            double r2 = r7.amount     // Catch:{ JSONException -> 0x0079 }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x001d
            java.lang.String r2 = "TXN_AMOUNT"
            double r3 = r7.amount     // Catch:{ JSONException -> 0x0079 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0079 }
        L_0x001d:
            java.lang.String r2 = r7.merchantName     // Catch:{ JSONException -> 0x0079 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r2 = r7.merchantName     // Catch:{ JSONException -> 0x0079 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = "pgEnabled"
            boolean r2 = r7.pgEnabled     // Catch:{ JSONException -> 0x0079 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = "logoURL"
            java.lang.String r2 = r7.imageData     // Catch:{ JSONException -> 0x0079 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = "INDUSTRY_TYPE_ID"
            java.lang.String r2 = "retail"
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = r7.linkType     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r2 = "linkType"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r2 = "link_invoice_id"
            net.one97.paytm.common.utility.j r3 = net.one97.paytm.common.utility.j.FIXED     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r3 = r3.name()     // Catch:{ JSONException -> 0x0079 }
            boolean r3 = r0.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0079 }
            if (r3 != 0) goto L_0x0061
            net.one97.paytm.common.utility.j r3 = net.one97.paytm.common.utility.j.GENERIC     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r3 = r3.name()     // Catch:{ JSONException -> 0x0079 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x0079 }
            if (r0 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            java.lang.String r0 = r7.invoiceId     // Catch:{ JSONException -> 0x0079 }
            goto L_0x0063
        L_0x0061:
            java.lang.String r0 = r7.id     // Catch:{ JSONException -> 0x0079 }
        L_0x0063:
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = "warning_msg"
            net.one97.paytm.common.entity.wallet.CJRWarningMessageContainer r2 = r7.warningMessageContainer     // Catch:{ JSONException -> 0x0079 }
            if (r2 != 0) goto L_0x0070
            java.lang.String r2 = ""
            goto L_0x0076
        L_0x0070:
            net.one97.paytm.common.entity.wallet.CJRWarningMessageContainer r2 = r7.warningMessageContainer     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r2 = r2.getWarningMessage()     // Catch:{ JSONException -> 0x0079 }
        L_0x0076:
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0079 }
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse.getResponseJSON():org.json.JSONObject");
    }

    public CJRWarningMessageContainer getWarningMessageContainer() {
        return this.warningMessageContainer;
    }

    public String getInvoiceId() {
        return this.invoiceId;
    }
}
