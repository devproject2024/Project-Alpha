package net.one97.paytm.recharge.widgets.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CRUFlowModel {
    private Stack<String> actionList;
    private String actionType;
    private String alertType;
    private Integer amountEditable;
    private Integer deferredCheckout;
    private String errorType;
    private String isFastForward;
    private StringBuilder journeyStackTrace;
    private LinkedList<String> logs;
    private String orderId;
    private String otherDetails;
    private Integer prefetch;
    private Integer proceedDirectlyToPG;
    private String requestBody;
    private Integer requestRetryCount;
    private Integer requestTimeout;
    private List<String> stackTrace;
    private String tag;
    private String variantType;
    private String verifyErrorCode;

    public CRUFlowModel() {
        this((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
    }

    public static /* synthetic */ CRUFlowModel copy$default(CRUFlowModel cRUFlowModel, String str, String str2, LinkedList linkedList, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, Integer num5, Integer num6, String str7, String str8, List list, String str9, Stack stack, String str10, StringBuilder sb, int i2, Object obj) {
        CRUFlowModel cRUFlowModel2 = cRUFlowModel;
        int i3 = i2;
        return cRUFlowModel.copy((i3 & 1) != 0 ? cRUFlowModel2.errorType : str, (i3 & 2) != 0 ? cRUFlowModel2.actionType : str2, (i3 & 4) != 0 ? cRUFlowModel2.logs : linkedList, (i3 & 8) != 0 ? cRUFlowModel2.requestBody : str3, (i3 & 16) != 0 ? cRUFlowModel2.requestTimeout : num, (i3 & 32) != 0 ? cRUFlowModel2.requestRetryCount : num2, (i3 & 64) != 0 ? cRUFlowModel2.tag : str4, (i3 & 128) != 0 ? cRUFlowModel2.orderId : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cRUFlowModel2.isFastForward : str6, (i3 & 512) != 0 ? cRUFlowModel2.prefetch : num3, (i3 & TarConstants.EOF_BLOCK) != 0 ? cRUFlowModel2.amountEditable : num4, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cRUFlowModel2.proceedDirectlyToPG : num5, (i3 & 4096) != 0 ? cRUFlowModel2.deferredCheckout : num6, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cRUFlowModel2.verifyErrorCode : str7, (i3 & 16384) != 0 ? cRUFlowModel2.variantType : str8, (i3 & 32768) != 0 ? cRUFlowModel2.stackTrace : list, (i3 & 65536) != 0 ? cRUFlowModel2.alertType : str9, (i3 & 131072) != 0 ? cRUFlowModel2.actionList : stack, (i3 & 262144) != 0 ? cRUFlowModel2.otherDetails : str10, (i3 & 524288) != 0 ? cRUFlowModel2.journeyStackTrace : sb);
    }

    public final String component1() {
        return this.errorType;
    }

    public final Integer component10() {
        return this.prefetch;
    }

    public final Integer component11() {
        return this.amountEditable;
    }

    public final Integer component12() {
        return this.proceedDirectlyToPG;
    }

    public final Integer component13() {
        return this.deferredCheckout;
    }

    public final String component14() {
        return this.verifyErrorCode;
    }

    public final String component15() {
        return this.variantType;
    }

    public final List<String> component16() {
        return this.stackTrace;
    }

    public final String component17() {
        return this.alertType;
    }

    public final Stack<String> component18() {
        return this.actionList;
    }

    public final String component19() {
        return this.otherDetails;
    }

    public final String component2() {
        return this.actionType;
    }

    public final StringBuilder component20() {
        return this.journeyStackTrace;
    }

    public final LinkedList<String> component3() {
        return this.logs;
    }

    public final String component4() {
        return this.requestBody;
    }

    public final Integer component5() {
        return this.requestTimeout;
    }

    public final Integer component6() {
        return this.requestRetryCount;
    }

    public final String component7() {
        return this.tag;
    }

    public final String component8() {
        return this.orderId;
    }

    public final String component9() {
        return this.isFastForward;
    }

    public final CRUFlowModel copy(String str, String str2, LinkedList<String> linkedList, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, Integer num5, Integer num6, String str7, String str8, List<String> list, String str9, Stack<String> stack, String str10, StringBuilder sb) {
        String str11 = str;
        k.c(linkedList, "logs");
        return new CRUFlowModel(str, str2, linkedList, str3, num, num2, str4, str5, str6, num3, num4, num5, num6, str7, str8, list, str9, stack, str10, sb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CRUFlowModel)) {
            return false;
        }
        CRUFlowModel cRUFlowModel = (CRUFlowModel) obj;
        return k.a((Object) this.errorType, (Object) cRUFlowModel.errorType) && k.a((Object) this.actionType, (Object) cRUFlowModel.actionType) && k.a((Object) this.logs, (Object) cRUFlowModel.logs) && k.a((Object) this.requestBody, (Object) cRUFlowModel.requestBody) && k.a((Object) this.requestTimeout, (Object) cRUFlowModel.requestTimeout) && k.a((Object) this.requestRetryCount, (Object) cRUFlowModel.requestRetryCount) && k.a((Object) this.tag, (Object) cRUFlowModel.tag) && k.a((Object) this.orderId, (Object) cRUFlowModel.orderId) && k.a((Object) this.isFastForward, (Object) cRUFlowModel.isFastForward) && k.a((Object) this.prefetch, (Object) cRUFlowModel.prefetch) && k.a((Object) this.amountEditable, (Object) cRUFlowModel.amountEditable) && k.a((Object) this.proceedDirectlyToPG, (Object) cRUFlowModel.proceedDirectlyToPG) && k.a((Object) this.deferredCheckout, (Object) cRUFlowModel.deferredCheckout) && k.a((Object) this.verifyErrorCode, (Object) cRUFlowModel.verifyErrorCode) && k.a((Object) this.variantType, (Object) cRUFlowModel.variantType) && k.a((Object) this.stackTrace, (Object) cRUFlowModel.stackTrace) && k.a((Object) this.alertType, (Object) cRUFlowModel.alertType) && k.a((Object) this.actionList, (Object) cRUFlowModel.actionList) && k.a((Object) this.otherDetails, (Object) cRUFlowModel.otherDetails) && k.a((Object) this.journeyStackTrace, (Object) cRUFlowModel.journeyStackTrace);
    }

    public final int hashCode() {
        String str = this.errorType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.actionType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        LinkedList<String> linkedList = this.logs;
        int hashCode3 = (hashCode2 + (linkedList != null ? linkedList.hashCode() : 0)) * 31;
        String str3 = this.requestBody;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.requestTimeout;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.requestRetryCount;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str4 = this.tag;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.orderId;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.isFastForward;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num3 = this.prefetch;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.amountEditable;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.proceedDirectlyToPG;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.deferredCheckout;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 31;
        String str7 = this.verifyErrorCode;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.variantType;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<String> list = this.stackTrace;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        String str9 = this.alertType;
        int hashCode17 = (hashCode16 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Stack<String> stack = this.actionList;
        int hashCode18 = (hashCode17 + (stack != null ? stack.hashCode() : 0)) * 31;
        String str10 = this.otherDetails;
        int hashCode19 = (hashCode18 + (str10 != null ? str10.hashCode() : 0)) * 31;
        StringBuilder sb = this.journeyStackTrace;
        if (sb != null) {
            i2 = sb.hashCode();
        }
        return hashCode19 + i2;
    }

    public final String toString() {
        return "CRUFlowModel(errorType=" + this.errorType + ", actionType=" + this.actionType + ", logs=" + this.logs + ", requestBody=" + this.requestBody + ", requestTimeout=" + this.requestTimeout + ", requestRetryCount=" + this.requestRetryCount + ", tag=" + this.tag + ", orderId=" + this.orderId + ", isFastForward=" + this.isFastForward + ", prefetch=" + this.prefetch + ", amountEditable=" + this.amountEditable + ", proceedDirectlyToPG=" + this.proceedDirectlyToPG + ", deferredCheckout=" + this.deferredCheckout + ", verifyErrorCode=" + this.verifyErrorCode + ", variantType=" + this.variantType + ", stackTrace=" + this.stackTrace + ", alertType=" + this.alertType + ", actionList=" + this.actionList + ", otherDetails=" + this.otherDetails + ", journeyStackTrace=" + this.journeyStackTrace + ")";
    }

    public CRUFlowModel(String str, String str2, LinkedList<String> linkedList, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, Integer num5, Integer num6, String str7, String str8, List<String> list, String str9, Stack<String> stack, String str10, StringBuilder sb) {
        k.c(linkedList, "logs");
        this.errorType = str;
        this.actionType = str2;
        this.logs = linkedList;
        this.requestBody = str3;
        this.requestTimeout = num;
        this.requestRetryCount = num2;
        this.tag = str4;
        this.orderId = str5;
        this.isFastForward = str6;
        this.prefetch = num3;
        this.amountEditable = num4;
        this.proceedDirectlyToPG = num5;
        this.deferredCheckout = num6;
        this.verifyErrorCode = str7;
        this.variantType = str8;
        this.stackTrace = list;
        this.alertType = str9;
        this.actionList = stack;
        this.otherDetails = str10;
        this.journeyStackTrace = sb;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final void setErrorType(String str) {
        this.errorType = str;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        this.actionType = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CRUFlowModel(java.lang.String r22, java.lang.String r23, java.util.LinkedList r24, java.lang.String r25, java.lang.Integer r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.Integer r31, java.lang.Integer r32, java.lang.Integer r33, java.lang.Integer r34, java.lang.String r35, java.lang.String r36, java.util.List r37, java.lang.String r38, java.util.Stack r39, java.lang.String r40, java.lang.StringBuilder r41, int r42, kotlin.g.b.g r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r23
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            goto L_0x001e
        L_0x001c:
            r4 = r24
        L_0x001e:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0026
        L_0x0024:
            r5 = r25
        L_0x0026:
            r6 = r0 & 16
            r7 = -1
            if (r6 == 0) goto L_0x0030
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            goto L_0x0032
        L_0x0030:
            r6 = r26
        L_0x0032:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x003d
        L_0x003b:
            r7 = r27
        L_0x003d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0043
            r8 = 0
            goto L_0x0045
        L_0x0043:
            r8 = r28
        L_0x0045:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004b
            r9 = 0
            goto L_0x004d
        L_0x004b:
            r9 = r29
        L_0x004d:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0053
            r10 = 0
            goto L_0x0055
        L_0x0053:
            r10 = r30
        L_0x0055:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005b
            r11 = 0
            goto L_0x005d
        L_0x005b:
            r11 = r31
        L_0x005d:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0063
            r12 = 0
            goto L_0x0065
        L_0x0063:
            r12 = r32
        L_0x0065:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x006b
            r13 = 0
            goto L_0x006d
        L_0x006b:
            r13 = r33
        L_0x006d:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0073
            r14 = 0
            goto L_0x0075
        L_0x0073:
            r14 = r34
        L_0x0075:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x007b
            r15 = 0
            goto L_0x007d
        L_0x007b:
            r15 = r35
        L_0x007d:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0083
            r2 = 0
            goto L_0x0085
        L_0x0083:
            r2 = r36
        L_0x0085:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008f
            r16 = 0
            goto L_0x0091
        L_0x008f:
            r16 = r37
        L_0x0091:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            java.lang.String r18 = ""
            if (r17 == 0) goto L_0x009c
            r17 = r18
            goto L_0x009e
        L_0x009c:
            r17 = r38
        L_0x009e:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a7
            r19 = 0
            goto L_0x00a9
        L_0x00a7:
            r19 = r39
        L_0x00a9:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r18 = r40
        L_0x00b2:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00be
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x00c0
        L_0x00be:
            r0 = r41
        L_0x00c0:
            r22 = r21
            r23 = r1
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r15
            r37 = r2
            r38 = r16
            r39 = r17
            r40 = r19
            r41 = r18
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.model.CRUFlowModel.<init>(java.lang.String, java.lang.String, java.util.LinkedList, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.util.Stack, java.lang.String, java.lang.StringBuilder, int, kotlin.g.b.g):void");
    }

    public final LinkedList<String> getLogs() {
        return this.logs;
    }

    public final void setLogs(LinkedList<String> linkedList) {
        k.c(linkedList, "<set-?>");
        this.logs = linkedList;
    }

    public final String getRequestBody() {
        return this.requestBody;
    }

    public final void setRequestBody(String str) {
        this.requestBody = str;
    }

    public final Integer getRequestTimeout() {
        return this.requestTimeout;
    }

    public final void setRequestTimeout(Integer num) {
        this.requestTimeout = num;
    }

    public final Integer getRequestRetryCount() {
        return this.requestRetryCount;
    }

    public final void setRequestRetryCount(Integer num) {
        this.requestRetryCount = num;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String isFastForward() {
        return this.isFastForward;
    }

    public final void setFastForward(String str) {
        this.isFastForward = str;
    }

    public final Integer getPrefetch() {
        return this.prefetch;
    }

    public final void setPrefetch(Integer num) {
        this.prefetch = num;
    }

    public final Integer getAmountEditable() {
        return this.amountEditable;
    }

    public final void setAmountEditable(Integer num) {
        this.amountEditable = num;
    }

    public final Integer getProceedDirectlyToPG() {
        return this.proceedDirectlyToPG;
    }

    public final void setProceedDirectlyToPG(Integer num) {
        this.proceedDirectlyToPG = num;
    }

    public final Integer getDeferredCheckout() {
        return this.deferredCheckout;
    }

    public final void setDeferredCheckout(Integer num) {
        this.deferredCheckout = num;
    }

    public final String getVerifyErrorCode() {
        return this.verifyErrorCode;
    }

    public final void setVerifyErrorCode(String str) {
        this.verifyErrorCode = str;
    }

    public final String getVariantType() {
        return this.variantType;
    }

    public final void setVariantType(String str) {
        this.variantType = str;
    }

    public final List<String> getStackTrace() {
        return this.stackTrace;
    }

    public final void setStackTrace(List<String> list) {
        this.stackTrace = list;
    }

    public final String getAlertType() {
        return this.alertType;
    }

    public final void setAlertType(String str) {
        this.alertType = str;
    }

    public final Stack<String> getActionList() {
        return this.actionList;
    }

    public final void setActionList(Stack<String> stack) {
        this.actionList = stack;
    }

    public final String getOtherDetails() {
        return this.otherDetails;
    }

    public final void setOtherDetails(String str) {
        this.otherDetails = str;
    }

    public final StringBuilder getJourneyStackTrace() {
        return this.journeyStackTrace;
    }

    public final void setJourneyStackTrace(StringBuilder sb) {
        this.journeyStackTrace = sb;
    }

    public final void clear() {
        this.errorType = null;
        this.actionType = null;
        this.alertType = null;
        this.logs.clear();
        this.tag = null;
        this.requestBody = null;
        this.requestTimeout = null;
        this.requestRetryCount = null;
        this.journeyStackTrace = null;
        this.otherDetails = null;
        Stack<String> stack = this.actionList;
        if (stack != null) {
            stack.clear();
        }
        this.prefetch = null;
        this.amountEditable = null;
        this.proceedDirectlyToPG = null;
        this.deferredCheckout = null;
        this.actionList = null;
        List<String> list = this.stackTrace;
        if (list != null && (list instanceof ArrayList)) {
            if (list != null) {
                ((ArrayList) list).clear();
            } else {
                throw new u("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            }
        }
        this.stackTrace = null;
    }
}
