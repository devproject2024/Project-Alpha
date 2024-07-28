package com.paytm.android.chat.bean.jsonbean;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.bean.CtaType;
import com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean;
import com.paytm.android.chat.data.models.messages.ChatMessageUPIData;
import com.paytm.android.chat.utils.DateUtils;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.moneytransfer.requestmoney.MTChatResponse;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class TxNotifyData {
    public static final Companion Companion = new Companion((g) null);
    public static final String DATE_FORMAT = "yyyy-mm-dd hh:mm:ss";
    public static final String PAYMENT_STATUS_FAILURE = "FAILURE";
    public static final String PAYMENT_STATUS_PENDING = "PENDING";
    public static final String PAYMENT_STATUS_SUCCESS = "SUCCESS";
    /* access modifiers changed from: private */
    public static final String PAYMENT_STATUS_TXN_FAILURE = "TXN_FAILURE";
    /* access modifiers changed from: private */
    public static final String PAYMENT_STATUS_TXN_PENDING = "TXN_PENDING";
    /* access modifiers changed from: private */
    public static final String PAYMENT_STATUS_TXN_SUCCESS = "TXN_SUCCESS";
    public static final String PAYMENT_STATUS_UNKNOWN = "PENDING";
    public static final String UPI_STATUS_CANCELLED = "CANCELLED";
    public static final String UPI_STATUS_DECLINED = "DECLINED";
    public static final String UPI_STATUS_EXPIRED = "EXPIRED";
    public static final String UPI_STATUS_MARK_AS_SPAM = "MARK_AS_SPAM";
    public static final String UPI_STATUS_UPI_REQUESTED = "UPI_REQUESTED";
    @b(a = "amount")
    private final String amount;
    @b(a = "channel")
    private final String channel;
    @b(a = "deeplinkUrl")
    private final String deeplinkUrl;
    @b(a = "errorMsg")
    private final String errorMsg;
    @b(a = "expireDate")
    private final String expireDate;
    @b(a = "flowType")
    private final String flowType;
    @b(a = "message")
    private final String message;
    @b(a = "note")
    private final String note;
    @b(a = "orderId")
    private final String orderId;
    @b(a = "payeeVpa")
    private final String payeeVpa;
    @b(a = "payerName")
    private final String payerName;
    @b(a = "payerVpa")
    private final String payerVpa;
    @b(a = "paymentMode")
    private final String paymentMode;
    @b(a = "rrn")
    private final String rrn;
    @b(a = "status")
    private String status;
    @b(a = "themeData")
    private final ThemeData themeData;
    @b(a = "txnDate")
    private final String txnDate;
    @b(a = "txnId")
    private final String txnId;
    @b(a = "type")
    private final String type;

    public static /* synthetic */ TxNotifyData copy$default(TxNotifyData txNotifyData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, ThemeData themeData2, String str14, String str15, String str16, String str17, String str18, int i2, Object obj) {
        TxNotifyData txNotifyData2 = txNotifyData;
        int i3 = i2;
        return txNotifyData.copy((i3 & 1) != 0 ? txNotifyData2.status : str, (i3 & 2) != 0 ? txNotifyData2.txnId : str2, (i3 & 4) != 0 ? txNotifyData2.rrn : str3, (i3 & 8) != 0 ? txNotifyData2.amount : str4, (i3 & 16) != 0 ? txNotifyData2.txnDate : str5, (i3 & 32) != 0 ? txNotifyData2.type : str6, (i3 & 64) != 0 ? txNotifyData2.note : str7, (i3 & 128) != 0 ? txNotifyData2.channel : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? txNotifyData2.deeplinkUrl : str9, (i3 & 512) != 0 ? txNotifyData2.paymentMode : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? txNotifyData2.orderId : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? txNotifyData2.message : str12, (i3 & 4096) != 0 ? txNotifyData2.flowType : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? txNotifyData2.themeData : themeData2, (i3 & 16384) != 0 ? txNotifyData2.payerName : str14, (i3 & 32768) != 0 ? txNotifyData2.payerVpa : str15, (i3 & 65536) != 0 ? txNotifyData2.payeeVpa : str16, (i3 & 131072) != 0 ? txNotifyData2.errorMsg : str17, (i3 & 262144) != 0 ? txNotifyData2.expireDate : str18);
    }

    public static final TxNotifyData createFromChatMessageUPIData(String str, ChatMessageUPIData chatMessageUPIData) {
        return Companion.createFromChatMessageUPIData(str, chatMessageUPIData);
    }

    public static final TxNotifyData createFromPFPaymentStatusBean(String str, PFPaymentStatusBean pFPaymentStatusBean) {
        return Companion.createFromPFPaymentStatusBean(str, pFPaymentStatusBean);
    }

    public static final TxNotifyData createFromPaymentResponse(String str, MTSDKPostPaymentResponse mTSDKPostPaymentResponse) {
        return Companion.createFromPaymentResponse(str, mTSDKPostPaymentResponse);
    }

    public static final TxNotifyData createFromRequestMoneyActionResponse(String str, MTSDKPostPaymentResponse mTSDKPostPaymentResponse, CtaType ctaType) {
        return Companion.createFromRequestMoneyActionResponse(str, mTSDKPostPaymentResponse, ctaType);
    }

    public static final TxNotifyData createFromRequestMoneyResponse(String str, MTChatResponse mTChatResponse) {
        return Companion.createFromRequestMoneyResponse(str, mTChatResponse);
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.paymentMode;
    }

    public final String component11() {
        return this.orderId;
    }

    public final String component12() {
        return this.message;
    }

    public final String component13() {
        return this.flowType;
    }

    public final ThemeData component14() {
        return this.themeData;
    }

    public final String component15() {
        return this.payerName;
    }

    public final String component16() {
        return this.payerVpa;
    }

    public final String component17() {
        return this.payeeVpa;
    }

    public final String component18() {
        return this.errorMsg;
    }

    public final String component19() {
        return this.expireDate;
    }

    public final String component2() {
        return this.txnId;
    }

    public final String component3() {
        return this.rrn;
    }

    public final String component4() {
        return this.amount;
    }

    public final String component5() {
        return this.txnDate;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.note;
    }

    public final String component8() {
        return this.channel;
    }

    public final String component9() {
        return this.deeplinkUrl;
    }

    public final TxNotifyData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, ThemeData themeData2, String str14, String str15, String str16, String str17, String str18) {
        String str19 = str;
        k.c(str7, "note");
        k.c(str8, "channel");
        k.c(str10, "paymentMode");
        k.c(str12, "message");
        return new TxNotifyData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, themeData2, str14, str15, str16, str17, str18);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TxNotifyData)) {
            return false;
        }
        TxNotifyData txNotifyData = (TxNotifyData) obj;
        return k.a((Object) this.status, (Object) txNotifyData.status) && k.a((Object) this.txnId, (Object) txNotifyData.txnId) && k.a((Object) this.rrn, (Object) txNotifyData.rrn) && k.a((Object) this.amount, (Object) txNotifyData.amount) && k.a((Object) this.txnDate, (Object) txNotifyData.txnDate) && k.a((Object) this.type, (Object) txNotifyData.type) && k.a((Object) this.note, (Object) txNotifyData.note) && k.a((Object) this.channel, (Object) txNotifyData.channel) && k.a((Object) this.deeplinkUrl, (Object) txNotifyData.deeplinkUrl) && k.a((Object) this.paymentMode, (Object) txNotifyData.paymentMode) && k.a((Object) this.orderId, (Object) txNotifyData.orderId) && k.a((Object) this.message, (Object) txNotifyData.message) && k.a((Object) this.flowType, (Object) txNotifyData.flowType) && k.a((Object) this.themeData, (Object) txNotifyData.themeData) && k.a((Object) this.payerName, (Object) txNotifyData.payerName) && k.a((Object) this.payerVpa, (Object) txNotifyData.payerVpa) && k.a((Object) this.payeeVpa, (Object) txNotifyData.payeeVpa) && k.a((Object) this.errorMsg, (Object) txNotifyData.errorMsg) && k.a((Object) this.expireDate, (Object) txNotifyData.expireDate);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.txnId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rrn;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.amount;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.txnDate;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.type;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.note;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.channel;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.deeplinkUrl;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.paymentMode;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.orderId;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.message;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.flowType;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        ThemeData themeData2 = this.themeData;
        int hashCode14 = (hashCode13 + (themeData2 != null ? themeData2.hashCode() : 0)) * 31;
        String str14 = this.payerName;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.payerVpa;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.payeeVpa;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.errorMsg;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.expireDate;
        if (str18 != null) {
            i2 = str18.hashCode();
        }
        return hashCode18 + i2;
    }

    public final String toString() {
        return "TxNotifyData(status=" + this.status + ", txnId=" + this.txnId + ", rrn=" + this.rrn + ", amount=" + this.amount + ", txnDate=" + this.txnDate + ", type=" + this.type + ", note=" + this.note + ", channel=" + this.channel + ", deeplinkUrl=" + this.deeplinkUrl + ", paymentMode=" + this.paymentMode + ", orderId=" + this.orderId + ", message=" + this.message + ", flowType=" + this.flowType + ", themeData=" + this.themeData + ", payerName=" + this.payerName + ", payerVpa=" + this.payerVpa + ", payeeVpa=" + this.payeeVpa + ", errorMsg=" + this.errorMsg + ", expireDate=" + this.expireDate + ")";
    }

    public TxNotifyData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, ThemeData themeData2, String str14, String str15, String str16, String str17, String str18) {
        String str19 = str10;
        String str20 = str12;
        k.c(str7, "note");
        k.c(str8, "channel");
        k.c(str19, "paymentMode");
        k.c(str20, "message");
        this.status = str;
        this.txnId = str2;
        this.rrn = str3;
        this.amount = str4;
        this.txnDate = str5;
        this.type = str6;
        this.note = str7;
        this.channel = str8;
        this.deeplinkUrl = str9;
        this.paymentMode = str19;
        this.orderId = str11;
        this.message = str20;
        this.flowType = str13;
        this.themeData = themeData2;
        this.payerName = str14;
        this.payerVpa = str15;
        this.payeeVpa = str16;
        this.errorMsg = str17;
        this.expireDate = str18;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getRrn() {
        return this.rrn;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getTxnDate() {
        return this.txnDate;
    }

    public final String getType() {
        return this.type;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getFlowType() {
        return this.flowType;
    }

    public final ThemeData getThemeData() {
        return this.themeData;
    }

    public final String getPayerName() {
        return this.payerName;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final String getPayeeVpa() {
        return this.payeeVpa;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TxNotifyData(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, net.one97.paytm.p2p.theme.ThemeData r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, int r43, kotlin.g.b.g r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r24
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r25
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r26
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r27
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r28
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r29
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r32
        L_0x003b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0041
            r14 = r2
            goto L_0x0043
        L_0x0041:
            r14 = r34
        L_0x0043:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x004a
            r16 = r2
            goto L_0x004c
        L_0x004a:
            r16 = r36
        L_0x004c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0053
            r17 = r2
            goto L_0x0055
        L_0x0053:
            r17 = r37
        L_0x0055:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x005c
            r18 = r2
            goto L_0x005e
        L_0x005c:
            r18 = r38
        L_0x005e:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0067
            r19 = r2
            goto L_0x0069
        L_0x0067:
            r19 = r39
        L_0x0069:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0071
            r20 = r2
            goto L_0x0073
        L_0x0071:
            r20 = r40
        L_0x0073:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007b
            r21 = r2
            goto L_0x007d
        L_0x007b:
            r21 = r41
        L_0x007d:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0085
            r22 = r2
            goto L_0x0087
        L_0x0085:
            r22 = r42
        L_0x0087:
            r3 = r23
            r10 = r30
            r11 = r31
            r13 = r33
            r15 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.bean.jsonbean.TxNotifyData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2p.theme.ThemeData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getExpireDate() {
        return this.expireDate;
    }

    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CtaType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[CtaType.UPI_CANCEL.ordinal()] = 1;
                $EnumSwitchMapping$0[CtaType.UPI_MARK_AS_SPAM.ordinal()] = 2;
                $EnumSwitchMapping$0[CtaType.UPI_DECLINE.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TxNotifyData createFromPaymentResponse(String str, MTSDKPostPaymentResponse mTSDKPostPaymentResponse) {
            String str2;
            k.c(str, "channelUrl");
            k.c(mTSDKPostPaymentResponse, Payload.RESPONSE);
            String transactionStatus = mTSDKPostPaymentResponse.getTransactionStatus();
            String str3 = "SUCCESS";
            if (!k.a((Object) transactionStatus, (Object) str3) && !k.a((Object) transactionStatus, (Object) TxNotifyData.PAYMENT_STATUS_TXN_SUCCESS)) {
                if (k.a((Object) transactionStatus, (Object) "PENDING") || k.a((Object) transactionStatus, (Object) TxNotifyData.PAYMENT_STATUS_TXN_PENDING)) {
                    str3 = "FAILURE";
                } else {
                    if (!k.a((Object) transactionStatus, (Object) "FAILURE")) {
                        boolean a2 = k.a((Object) transactionStatus, (Object) TxNotifyData.PAYMENT_STATUS_TXN_FAILURE);
                    }
                    str3 = "PENDING";
                }
            }
            Long transactionTime = mTSDKPostPaymentResponse.getTransactionTime();
            if (transactionTime == null || (str2 = DateUtils.getDateTime(transactionTime.longValue(), TxNotifyData.DATE_FORMAT)) == null) {
                str2 = DateUtils.getCurrentDateTime(TxNotifyData.DATE_FORMAT);
            }
            String str4 = str2;
            String amount = mTSDKPostPaymentResponse.getAmount();
            String referenceNumber = mTSDKPostPaymentResponse.getReferenceNumber();
            String uniqueKey = mTSDKPostPaymentResponse.getUniqueKey();
            String paymentMode = mTSDKPostPaymentResponse.getPaymentMode();
            if (paymentMode == null) {
                paymentMode = "NA";
            }
            String str5 = paymentMode;
            String comment = mTSDKPostPaymentResponse.getComment();
            if (comment == null) {
                comment = "";
            }
            return new TxNotifyData(str3, uniqueKey, referenceNumber, amount, str4, "PAY", comment, str, (String) null, str5, (String) null, "", mTSDKPostPaymentResponse.getFlowType(), mTSDKPostPaymentResponse.getThemeData(), (String) null, (String) null, (String) null, mTSDKPostPaymentResponse.getErrorMessage(), (String) null, 378112, (g) null);
        }

        public final TxNotifyData createFromRequestMoneyActionResponse(String str, MTSDKPostPaymentResponse mTSDKPostPaymentResponse, CtaType ctaType) {
            k.c(str, "channelUrl");
            k.c(mTSDKPostPaymentResponse, Payload.RESPONSE);
            k.c(ctaType, "ctaType");
            TxNotifyData createFromPaymentResponse = createFromPaymentResponse(str, mTSDKPostPaymentResponse);
            int i2 = WhenMappings.$EnumSwitchMapping$0[ctaType.ordinal()];
            createFromPaymentResponse.setStatus(i2 != 1 ? i2 != 2 ? i2 != 3 ? createFromPaymentResponse.getStatus() : TxNotifyData.UPI_STATUS_DECLINED : TxNotifyData.UPI_STATUS_MARK_AS_SPAM : TxNotifyData.UPI_STATUS_CANCELLED);
            return createFromPaymentResponse;
        }

        public final TxNotifyData createFromRequestMoneyResponse(String str, MTChatResponse mTChatResponse) {
            String str2;
            Long d2;
            k.c(str, "channelUrl");
            k.c(mTChatResponse, Payload.RESPONSE);
            String date = mTChatResponse.getDate();
            if (date == null || (d2 = p.d(date)) == null || (str2 = DateUtils.getDateTime(d2.longValue(), TxNotifyData.DATE_FORMAT)) == null) {
                str2 = DateUtils.getCurrentDateTime(TxNotifyData.DATE_FORMAT);
            }
            String str3 = str2;
            String amount = mTChatResponse.getAmount();
            String note = mTChatResponse.getNote();
            if (note == null) {
                note = "";
            }
            String payerName = mTChatResponse.getPayerName();
            String payerVpa = mTChatResponse.getPayerVpa();
            String receiverVPA = mTChatResponse.getReceiverVPA();
            return new TxNotifyData(TxNotifyData.UPI_STATUS_UPI_REQUESTED, mTChatResponse.getRequestID(), (String) null, amount, str3, (String) null, note, str, (String) null, "PAY", (String) null, "", (String) null, (ThemeData) null, payerName, payerVpa, receiverVPA, mTChatResponse.getErrorMessage(), mTChatResponse.getExpiryDate(), 13604, (g) null);
        }

        public final TxNotifyData createFromChatMessageUPIData(String str, ChatMessageUPIData chatMessageUPIData) {
            k.c(str, "channelUrl");
            k.c(chatMessageUPIData, "data");
            String currentDateTime = DateUtils.getCurrentDateTime(TxNotifyData.DATE_FORMAT);
            String amount = chatMessageUPIData.getAmount();
            String txnId = chatMessageUPIData.getTxnId();
            String note = chatMessageUPIData.getNote();
            if (note == null) {
                note = "";
            }
            return new TxNotifyData(TxNotifyData.UPI_STATUS_EXPIRED, txnId, (String) null, amount, currentDateTime, (String) null, note, str, (String) null, "PAY", (String) null, "", (String) null, (ThemeData) null, (String) null, (String) null, (String) null, (String) null, chatMessageUPIData.getExpireOn(), 259364, (g) null);
        }

        public final TxNotifyData createFromPFPaymentStatusBean(String str, PFPaymentStatusBean pFPaymentStatusBean) {
            String str2;
            k.c(str, "channelUrl");
            k.c(pFPaymentStatusBean, Payload.RESPONSE);
            String currentDateTime = DateUtils.getCurrentDateTime(TxNotifyData.DATE_FORMAT);
            String amount = pFPaymentStatusBean.getAmount();
            String str3 = pFPaymentStatusBean.getmRc();
            String orderId = pFPaymentStatusBean.getOrderId();
            String txnId = pFPaymentStatusBean.getTxnId();
            String deeplinkUrl = pFPaymentStatusBean.getDeeplinkUrl();
            String paymentMode = pFPaymentStatusBean.getPaymentMode();
            k.a((Object) paymentMode, "response.paymentMode");
            String importantNote = pFPaymentStatusBean.getImportantNote();
            if (importantNote == null) {
                importantNote = "";
            }
            String str4 = importantNote;
            String errorMsg = pFPaymentStatusBean.getErrorMsg();
            int status = pFPaymentStatusBean.getStatus();
            String str5 = "PENDING";
            if (status == 0) {
                str2 = "SUCCESS";
            } else if (status != 1) {
                return new TxNotifyData(str5, txnId, str3, amount, currentDateTime, "PAY", str4, str, deeplinkUrl, paymentMode, orderId, "", (String) null, (ThemeData) null, (String) null, (String) null, (String) null, errorMsg, (String) null, 389120, (g) null);
            } else {
                str2 = "FAILURE";
            }
            str5 = str2;
            return new TxNotifyData(str5, txnId, str3, amount, currentDateTime, "PAY", str4, str, deeplinkUrl, paymentMode, orderId, "", (String) null, (ThemeData) null, (String) null, (String) null, (String) null, errorMsg, (String) null, 389120, (g) null);
        }
    }
}
