package net.one97.paytm.recharge.widgets.model;

import android.os.Bundle;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRRechargeErrorModel {
    private HashMap<String, Stack<String>> actionsMap;
    private String categoryId;
    private String errorCode;
    private String errorMsg;
    private ERROR_TYPE errorType;
    private Object extraObj;
    private Bundle extras;
    private CRUFlowModel flowName;
    private String productId;
    private String rechargeItemCategoryId;
    private String screenName;
    private String transcationId;
    private String url;
    private a.b userFacing;
    private VERTICAL verticalName;

    public CJRRechargeErrorModel() {
        this((VERTICAL) null, (ERROR_TYPE) null, (String) null, (a.b) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CRUFlowModel) null, (HashMap) null, (String) null, (Bundle) null, (Object) null, 32767, (g) null);
    }

    public static /* synthetic */ CJRRechargeErrorModel copy$default(CJRRechargeErrorModel cJRRechargeErrorModel, VERTICAL vertical, ERROR_TYPE error_type, String str, a.b bVar, String str2, String str3, String str4, String str5, String str6, String str7, CRUFlowModel cRUFlowModel, HashMap hashMap, String str8, Bundle bundle, Object obj, int i2, Object obj2) {
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        int i3 = i2;
        return cJRRechargeErrorModel.copy((i3 & 1) != 0 ? cJRRechargeErrorModel2.verticalName : vertical, (i3 & 2) != 0 ? cJRRechargeErrorModel2.errorType : error_type, (i3 & 4) != 0 ? cJRRechargeErrorModel2.url : str, (i3 & 8) != 0 ? cJRRechargeErrorModel2.userFacing : bVar, (i3 & 16) != 0 ? cJRRechargeErrorModel2.errorMsg : str2, (i3 & 32) != 0 ? cJRRechargeErrorModel2.errorCode : str3, (i3 & 64) != 0 ? cJRRechargeErrorModel2.categoryId : str4, (i3 & 128) != 0 ? cJRRechargeErrorModel2.transcationId : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRRechargeErrorModel2.screenName : str6, (i3 & 512) != 0 ? cJRRechargeErrorModel2.productId : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? cJRRechargeErrorModel2.flowName : cRUFlowModel, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRRechargeErrorModel2.actionsMap : hashMap, (i3 & 4096) != 0 ? cJRRechargeErrorModel2.rechargeItemCategoryId : str8, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRRechargeErrorModel2.extras : bundle, (i3 & 16384) != 0 ? cJRRechargeErrorModel2.extraObj : obj);
    }

    public final VERTICAL component1() {
        return this.verticalName;
    }

    public final String component10() {
        return this.productId;
    }

    public final CRUFlowModel component11() {
        return this.flowName;
    }

    public final HashMap<String, Stack<String>> component12() {
        return this.actionsMap;
    }

    public final String component13() {
        return this.rechargeItemCategoryId;
    }

    public final Bundle component14() {
        return this.extras;
    }

    public final Object component15() {
        return this.extraObj;
    }

    public final ERROR_TYPE component2() {
        return this.errorType;
    }

    public final String component3() {
        return this.url;
    }

    public final a.b component4() {
        return this.userFacing;
    }

    public final String component5() {
        return this.errorMsg;
    }

    public final String component6() {
        return this.errorCode;
    }

    public final String component7() {
        return this.categoryId;
    }

    public final String component8() {
        return this.transcationId;
    }

    public final String component9() {
        return this.screenName;
    }

    public final CJRRechargeErrorModel copy(VERTICAL vertical, ERROR_TYPE error_type, String str, a.b bVar, String str2, String str3, String str4, String str5, String str6, String str7, CRUFlowModel cRUFlowModel, HashMap<String, Stack<String>> hashMap, String str8, Bundle bundle, Object obj) {
        HashMap<String, Stack<String>> hashMap2 = hashMap;
        k.c(hashMap2, "actionsMap");
        return new CJRRechargeErrorModel(vertical, error_type, str, bVar, str2, str3, str4, str5, str6, str7, cRUFlowModel, hashMap2, str8, bundle, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRechargeErrorModel)) {
            return false;
        }
        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
        return k.a((Object) this.verticalName, (Object) cJRRechargeErrorModel.verticalName) && k.a((Object) this.errorType, (Object) cJRRechargeErrorModel.errorType) && k.a((Object) this.url, (Object) cJRRechargeErrorModel.url) && k.a((Object) this.userFacing, (Object) cJRRechargeErrorModel.userFacing) && k.a((Object) this.errorMsg, (Object) cJRRechargeErrorModel.errorMsg) && k.a((Object) this.errorCode, (Object) cJRRechargeErrorModel.errorCode) && k.a((Object) this.categoryId, (Object) cJRRechargeErrorModel.categoryId) && k.a((Object) this.transcationId, (Object) cJRRechargeErrorModel.transcationId) && k.a((Object) this.screenName, (Object) cJRRechargeErrorModel.screenName) && k.a((Object) this.productId, (Object) cJRRechargeErrorModel.productId) && k.a((Object) this.flowName, (Object) cJRRechargeErrorModel.flowName) && k.a((Object) this.actionsMap, (Object) cJRRechargeErrorModel.actionsMap) && k.a((Object) this.rechargeItemCategoryId, (Object) cJRRechargeErrorModel.rechargeItemCategoryId) && k.a((Object) this.extras, (Object) cJRRechargeErrorModel.extras) && k.a(this.extraObj, cJRRechargeErrorModel.extraObj);
    }

    public final int hashCode() {
        VERTICAL vertical = this.verticalName;
        int i2 = 0;
        int hashCode = (vertical != null ? vertical.hashCode() : 0) * 31;
        ERROR_TYPE error_type = this.errorType;
        int hashCode2 = (hashCode + (error_type != null ? error_type.hashCode() : 0)) * 31;
        String str = this.url;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        a.b bVar = this.userFacing;
        int hashCode4 = (hashCode3 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str2 = this.errorMsg;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.errorCode;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.categoryId;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.transcationId;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.screenName;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.productId;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        CRUFlowModel cRUFlowModel = this.flowName;
        int hashCode11 = (hashCode10 + (cRUFlowModel != null ? cRUFlowModel.hashCode() : 0)) * 31;
        HashMap<String, Stack<String>> hashMap = this.actionsMap;
        int hashCode12 = (hashCode11 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        String str8 = this.rechargeItemCategoryId;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Bundle bundle = this.extras;
        int hashCode14 = (hashCode13 + (bundle != null ? bundle.hashCode() : 0)) * 31;
        Object obj = this.extraObj;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode14 + i2;
    }

    public final String toString() {
        return "CJRRechargeErrorModel(verticalName=" + this.verticalName + ", errorType=" + this.errorType + ", url=" + this.url + ", userFacing=" + this.userFacing + ", errorMsg=" + this.errorMsg + ", errorCode=" + this.errorCode + ", categoryId=" + this.categoryId + ", transcationId=" + this.transcationId + ", screenName=" + this.screenName + ", productId=" + this.productId + ", flowName=" + this.flowName + ", actionsMap=" + this.actionsMap + ", rechargeItemCategoryId=" + this.rechargeItemCategoryId + ", extras=" + this.extras + ", extraObj=" + this.extraObj + ")";
    }

    public CJRRechargeErrorModel(VERTICAL vertical, ERROR_TYPE error_type, String str, a.b bVar, String str2, String str3, String str4, String str5, String str6, String str7, CRUFlowModel cRUFlowModel, HashMap<String, Stack<String>> hashMap, String str8, Bundle bundle, Object obj) {
        k.c(hashMap, "actionsMap");
        this.verticalName = vertical;
        this.errorType = error_type;
        this.url = str;
        this.userFacing = bVar;
        this.errorMsg = str2;
        this.errorCode = str3;
        this.categoryId = str4;
        this.transcationId = str5;
        this.screenName = str6;
        this.productId = str7;
        this.flowName = cRUFlowModel;
        this.actionsMap = hashMap;
        this.rechargeItemCategoryId = str8;
        this.extras = bundle;
        this.extraObj = obj;
    }

    public final VERTICAL getVerticalName() {
        return this.verticalName;
    }

    public final void setVerticalName(VERTICAL vertical) {
        this.verticalName = vertical;
    }

    public final ERROR_TYPE getErrorType() {
        return this.errorType;
    }

    public final void setErrorType(ERROR_TYPE error_type) {
        this.errorType = error_type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final a.b getUserFacing() {
        return this.userFacing;
    }

    public final void setUserFacing(a.b bVar) {
        this.userFacing = bVar;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(String str) {
        this.categoryId = str;
    }

    public final String getTranscationId() {
        return this.transcationId;
    }

    public final void setTranscationId(String str) {
        this.transcationId = str;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final void setScreenName(String str) {
        this.screenName = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final CRUFlowModel getFlowName() {
        return this.flowName;
    }

    public final void setFlowName(CRUFlowModel cRUFlowModel) {
        this.flowName = cRUFlowModel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRRechargeErrorModel(net.one97.paytm.recharge.widgets.model.VERTICAL r17, net.one97.paytm.recharge.widgets.model.ERROR_TYPE r18, java.lang.String r19, com.paytm.network.a.b r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, net.one97.paytm.recharge.widgets.model.CRUFlowModel r27, java.util.HashMap r28, java.lang.String r29, android.os.Bundle r30, java.lang.Object r31, int r32, kotlin.g.b.g r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0065
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            goto L_0x0067
        L_0x0065:
            r13 = r28
        L_0x0067:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006d
            r14 = r2
            goto L_0x006f
        L_0x006d:
            r14 = r29
        L_0x006f:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0075
            r15 = r2
            goto L_0x0077
        L_0x0075:
            r15 = r30
        L_0x0077:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r2 = r31
        L_0x007e:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel.<init>(net.one97.paytm.recharge.widgets.model.VERTICAL, net.one97.paytm.recharge.widgets.model.ERROR_TYPE, java.lang.String, com.paytm.network.a$b, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.recharge.widgets.model.CRUFlowModel, java.util.HashMap, java.lang.String, android.os.Bundle, java.lang.Object, int, kotlin.g.b.g):void");
    }

    public final HashMap<String, Stack<String>> getActionsMap() {
        return this.actionsMap;
    }

    public final void setActionsMap(HashMap<String, Stack<String>> hashMap) {
        k.c(hashMap, "<set-?>");
        this.actionsMap = hashMap;
    }

    public final String getRechargeItemCategoryId() {
        return this.rechargeItemCategoryId;
    }

    public final void setRechargeItemCategoryId(String str) {
        this.rechargeItemCategoryId = str;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public final Object getExtraObj() {
        return this.extraObj;
    }

    public final void setExtraObj(Object obj) {
        this.extraObj = obj;
    }

    public final LinkedList<String> getLogs() {
        if (this.flowName == null) {
            this.flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
        }
        CRUFlowModel cRUFlowModel = this.flowName;
        if (cRUFlowModel == null) {
            k.a();
        }
        return cRUFlowModel.getLogs();
    }

    public final void addLog(String str) {
        k.c(str, "log");
        LinkedList<String> logs = getLogs();
        if (logs.size() == 20) {
            logs.pop();
        }
        logs.push(str);
    }

    public final void clear() {
        this.verticalName = null;
        this.errorType = null;
        this.url = null;
        this.errorMsg = null;
        this.errorCode = null;
        this.categoryId = null;
        this.transcationId = null;
        this.screenName = null;
        this.productId = null;
        CRUFlowModel cRUFlowModel = this.flowName;
        if (cRUFlowModel != null) {
            cRUFlowModel.clear();
        }
        this.flowName = null;
        this.extras = null;
    }
}
