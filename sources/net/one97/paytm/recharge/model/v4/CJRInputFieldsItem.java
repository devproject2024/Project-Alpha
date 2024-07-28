package net.one97.paytm.recharge.model.v4;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRInputFieldsItem implements IJRDataModel {
    @b(a = "title")
    private final String _title;
    @b(a = "type")
    private final String _type;
    @b(a = "configKey")
    private final String configKey;
    @b(a = "dynamicLength")
    private final String dynamicLength;
    @b(a = "url")
    private final String groupingCategoryId;
    @b(a = "help")
    private final List<Help> help;
    @b(a = "hideFieldCondition")
    private final String hideFieldCondition;
    @b(a = "hideFieldConfigKeys")
    private final String hideFieldConfigKeys;
    @b(a = "hide")
    private String hideInputField;
    @b(a = "isAlphanumeric")
    private final int isAlphanumeric;
    @b(a = "label")
    private final String label;
    @b(a = "mandatory")
    private final Integer mandatory;
    @b(a = "max")
    private Double max;
    @b(a = "maxFieldLength")
    private final String maxFieldLength;
    @b(a = "message")
    private final String message;
    @b(a = "min")
    private Double min;
    @b(a = "name")
    private final String name;
    @b(a = "optional")
    private Integer optional;
    @b(a = "readOnly")
    private final Integer readOnly;
    @b(a = "regex")
    private String regex;
    @b(a = "sampleBill")
    private final String sampleBill;
    @b(a = "show_contact")
    private final Boolean showContact;
    @b(a = "showPhoneBook")
    private final Integer showPhoneBook;

    public CJRInputFieldsItem() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (Boolean) null, (List) null, 0, (String) null, (Integer) null, 8388607, (g) null);
    }

    private final String component10() {
        return this._type;
    }

    private final String component13() {
        return this.dynamicLength;
    }

    private final Integer component23() {
        return this.optional;
    }

    private final String component7() {
        return this._title;
    }

    private final String component8() {
        return this.hideInputField;
    }

    public static /* synthetic */ CJRInputFieldsItem copy$default(CJRInputFieldsItem cJRInputFieldsItem, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, Double d2, Double d3, String str11, String str12, String str13, Boolean bool, List list, int i2, String str14, Integer num4, int i3, Object obj) {
        CJRInputFieldsItem cJRInputFieldsItem2 = cJRInputFieldsItem;
        int i4 = i3;
        return cJRInputFieldsItem.copy((i4 & 1) != 0 ? cJRInputFieldsItem2.name : str, (i4 & 2) != 0 ? cJRInputFieldsItem2.configKey : str2, (i4 & 4) != 0 ? cJRInputFieldsItem2.sampleBill : str3, (i4 & 8) != 0 ? cJRInputFieldsItem2.regex : str4, (i4 & 16) != 0 ? cJRInputFieldsItem2.showPhoneBook : num, (i4 & 32) != 0 ? cJRInputFieldsItem2.readOnly : num2, (i4 & 64) != 0 ? cJRInputFieldsItem2._title : str5, (i4 & 128) != 0 ? cJRInputFieldsItem2.hideInputField : str6, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRInputFieldsItem2.label : str7, (i4 & 512) != 0 ? cJRInputFieldsItem2._type : str8, (i4 & TarConstants.EOF_BLOCK) != 0 ? cJRInputFieldsItem2.message : str9, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRInputFieldsItem2.mandatory : num3, (i4 & 4096) != 0 ? cJRInputFieldsItem2.dynamicLength : str10, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRInputFieldsItem2.min : d2, (i4 & 16384) != 0 ? cJRInputFieldsItem2.max : d3, (i4 & 32768) != 0 ? cJRInputFieldsItem2.hideFieldConfigKeys : str11, (i4 & 65536) != 0 ? cJRInputFieldsItem2.hideFieldCondition : str12, (i4 & 131072) != 0 ? cJRInputFieldsItem2.groupingCategoryId : str13, (i4 & 262144) != 0 ? cJRInputFieldsItem2.showContact : bool, (i4 & 524288) != 0 ? cJRInputFieldsItem2.help : list, (i4 & 1048576) != 0 ? cJRInputFieldsItem2.isAlphanumeric : i2, (i4 & 2097152) != 0 ? cJRInputFieldsItem2.maxFieldLength : str14, (i4 & 4194304) != 0 ? cJRInputFieldsItem2.optional : num4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component11() {
        return this.message;
    }

    public final Integer component12() {
        return this.mandatory;
    }

    public final Double component14() {
        return this.min;
    }

    public final Double component15() {
        return this.max;
    }

    public final String component16() {
        return this.hideFieldConfigKeys;
    }

    public final String component17() {
        return this.hideFieldCondition;
    }

    public final String component18() {
        return this.groupingCategoryId;
    }

    public final Boolean component19() {
        return this.showContact;
    }

    public final String component2() {
        return this.configKey;
    }

    public final List<Help> component20() {
        return this.help;
    }

    public final int component21() {
        return this.isAlphanumeric;
    }

    public final String component22() {
        return this.maxFieldLength;
    }

    public final String component3() {
        return this.sampleBill;
    }

    public final String component4() {
        return this.regex;
    }

    public final Integer component5() {
        return this.showPhoneBook;
    }

    public final Integer component6() {
        return this.readOnly;
    }

    public final String component9() {
        return this.label;
    }

    public final CJRInputFieldsItem copy(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, Double d2, Double d3, String str11, String str12, String str13, Boolean bool, List<Help> list, int i2, String str14, Integer num4) {
        return new CJRInputFieldsItem(str, str2, str3, str4, num, num2, str5, str6, str7, str8, str9, num3, str10, d2, d3, str11, str12, str13, bool, list, i2, str14, num4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRInputFieldsItem) {
                CJRInputFieldsItem cJRInputFieldsItem = (CJRInputFieldsItem) obj;
                if (k.a((Object) this.name, (Object) cJRInputFieldsItem.name) && k.a((Object) this.configKey, (Object) cJRInputFieldsItem.configKey) && k.a((Object) this.sampleBill, (Object) cJRInputFieldsItem.sampleBill) && k.a((Object) this.regex, (Object) cJRInputFieldsItem.regex) && k.a((Object) this.showPhoneBook, (Object) cJRInputFieldsItem.showPhoneBook) && k.a((Object) this.readOnly, (Object) cJRInputFieldsItem.readOnly) && k.a((Object) this._title, (Object) cJRInputFieldsItem._title) && k.a((Object) this.hideInputField, (Object) cJRInputFieldsItem.hideInputField) && k.a((Object) this.label, (Object) cJRInputFieldsItem.label) && k.a((Object) this._type, (Object) cJRInputFieldsItem._type) && k.a((Object) this.message, (Object) cJRInputFieldsItem.message) && k.a((Object) this.mandatory, (Object) cJRInputFieldsItem.mandatory) && k.a((Object) this.dynamicLength, (Object) cJRInputFieldsItem.dynamicLength) && k.a((Object) this.min, (Object) cJRInputFieldsItem.min) && k.a((Object) this.max, (Object) cJRInputFieldsItem.max) && k.a((Object) this.hideFieldConfigKeys, (Object) cJRInputFieldsItem.hideFieldConfigKeys) && k.a((Object) this.hideFieldCondition, (Object) cJRInputFieldsItem.hideFieldCondition) && k.a((Object) this.groupingCategoryId, (Object) cJRInputFieldsItem.groupingCategoryId) && k.a((Object) this.showContact, (Object) cJRInputFieldsItem.showContact) && k.a((Object) this.help, (Object) cJRInputFieldsItem.help)) {
                    if (!(this.isAlphanumeric == cJRInputFieldsItem.isAlphanumeric) || !k.a((Object) this.maxFieldLength, (Object) cJRInputFieldsItem.maxFieldLength) || !k.a((Object) this.optional, (Object) cJRInputFieldsItem.optional)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.configKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.sampleBill;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.regex;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.showPhoneBook;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.readOnly;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str5 = this._title;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.hideInputField;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.label;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this._type;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.message;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Integer num3 = this.mandatory;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str10 = this.dynamicLength;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Double d2 = this.min;
        int hashCode14 = (hashCode13 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.max;
        int hashCode15 = (hashCode14 + (d3 != null ? d3.hashCode() : 0)) * 31;
        String str11 = this.hideFieldConfigKeys;
        int hashCode16 = (hashCode15 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.hideFieldCondition;
        int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.groupingCategoryId;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        Boolean bool = this.showContact;
        int hashCode19 = (hashCode18 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<Help> list = this.help;
        int hashCode20 = (((hashCode19 + (list != null ? list.hashCode() : 0)) * 31) + this.isAlphanumeric) * 31;
        String str14 = this.maxFieldLength;
        int hashCode21 = (hashCode20 + (str14 != null ? str14.hashCode() : 0)) * 31;
        Integer num4 = this.optional;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        return hashCode21 + i2;
    }

    public final String toString() {
        return "CJRInputFieldsItem(name=" + this.name + ", configKey=" + this.configKey + ", sampleBill=" + this.sampleBill + ", regex=" + this.regex + ", showPhoneBook=" + this.showPhoneBook + ", readOnly=" + this.readOnly + ", _title=" + this._title + ", hideInputField=" + this.hideInputField + ", label=" + this.label + ", _type=" + this._type + ", message=" + this.message + ", mandatory=" + this.mandatory + ", dynamicLength=" + this.dynamicLength + ", min=" + this.min + ", max=" + this.max + ", hideFieldConfigKeys=" + this.hideFieldConfigKeys + ", hideFieldCondition=" + this.hideFieldCondition + ", groupingCategoryId=" + this.groupingCategoryId + ", showContact=" + this.showContact + ", help=" + this.help + ", isAlphanumeric=" + this.isAlphanumeric + ", maxFieldLength=" + this.maxFieldLength + ", optional=" + this.optional + ")";
    }

    public CJRInputFieldsItem(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, Double d2, Double d3, String str11, String str12, String str13, Boolean bool, List<Help> list, int i2, String str14, Integer num4) {
        this.name = str;
        this.configKey = str2;
        this.sampleBill = str3;
        this.regex = str4;
        this.showPhoneBook = num;
        this.readOnly = num2;
        this._title = str5;
        this.hideInputField = str6;
        this.label = str7;
        this._type = str8;
        this.message = str9;
        this.mandatory = num3;
        this.dynamicLength = str10;
        this.min = d2;
        this.max = d3;
        this.hideFieldConfigKeys = str11;
        this.hideFieldCondition = str12;
        this.groupingCategoryId = str13;
        this.showContact = bool;
        this.help = list;
        this.isAlphanumeric = i2;
        this.maxFieldLength = str14;
        this.optional = num4;
    }

    public final String getName() {
        return this.name;
    }

    public final String getConfigKey() {
        return this.configKey;
    }

    public final String getSampleBill() {
        return this.sampleBill;
    }

    public final String getRegex() {
        return this.regex;
    }

    public final void setRegex(String str) {
        this.regex = str;
    }

    public final Integer getShowPhoneBook() {
        return this.showPhoneBook;
    }

    public final Integer getReadOnly() {
        return this.readOnly;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getMandatory() {
        return this.mandatory;
    }

    public final Double getMin() {
        return this.min;
    }

    public final void setMin(Double d2) {
        this.min = d2;
    }

    public final Double getMax() {
        return this.max;
    }

    public final void setMax(Double d2) {
        this.max = d2;
    }

    public final String getHideFieldConfigKeys() {
        return this.hideFieldConfigKeys;
    }

    public final String getHideFieldCondition() {
        return this.hideFieldCondition;
    }

    public final String getGroupingCategoryId() {
        return this.groupingCategoryId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRInputFieldsItem(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.Integer r29, java.lang.Integer r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Integer r36, java.lang.String r37, java.lang.Double r38, java.lang.Double r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.Boolean r43, java.util.List r44, int r45, java.lang.String r46, java.lang.Integer r47, int r48, kotlin.g.b.g r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r25
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r26
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r27
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r28
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r29
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r30
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r31
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r32
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r33
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r34
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r35
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r36
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r37
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r38
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r39
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r40
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r41
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r42
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            java.lang.Boolean r19 = java.lang.Boolean.FALSE
            goto L_0x00a7
        L_0x00a5:
            r19 = r43
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r44
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 1
            goto L_0x00bd
        L_0x00bb:
            r21 = r45
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r46
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00d0
            r0 = 0
            goto L_0x00d2
        L_0x00d0:
            r0 = r47
        L_0x00d2:
            r25 = r24
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r36 = r12
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r2
            r41 = r16
            r42 = r17
            r43 = r18
            r44 = r19
            r45 = r20
            r46 = r21
            r47 = r22
            r48 = r0
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRInputFieldsItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.List, int, java.lang.String, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final Boolean getShowContact() {
        return this.showContact;
    }

    public final List<Help> getHelp() {
        return this.help;
    }

    public final int isAlphanumeric() {
        return this.isAlphanumeric;
    }

    public final String getMaxFieldLength() {
        return this.maxFieldLength;
    }

    public final String getType() {
        return !TextUtils.isEmpty(this._type) ? this._type : this.name;
    }

    public final String getTitle() {
        return !TextUtils.isEmpty(this._title) ? this._title : this.label;
    }

    public final List<String> getHideConfigKeyList() {
        CharSequence charSequence = this.hideFieldConfigKeys;
        if (charSequence == null || p.a(charSequence)) {
            return null;
        }
        String str = this.hideFieldConfigKeys;
        if (str == null) {
            k.a();
        }
        return kotlin.a.k.e(p.a((CharSequence) str, new String[]{AppConstants.COMMA}));
    }

    public final boolean getAlphanumeric() {
        return this.isAlphanumeric != 0;
    }

    public final boolean isHideInputField() {
        return p.a("TRUE", this.hideInputField, true);
    }

    public final boolean isShowPhoneBook() {
        Integer num = this.showPhoneBook;
        return num != null && num.intValue() == 1;
    }

    public final boolean isReadOnly() {
        Integer num = this.readOnly;
        return num != null && num.intValue() == 1;
    }

    public final boolean isMandatory() {
        Integer num = this.mandatory;
        return num != null && num.intValue() == 1;
    }

    public final boolean isOptional() {
        Integer num = this.optional;
        return num != null && num.intValue() == 1;
    }

    public final boolean isDynamicLength() {
        String str = this.dynamicLength;
        if (str == null) {
            return false;
        }
        return (str != null ? Boolean.valueOf(p.a(str, "1", true)) : null).booleanValue();
    }

    public static final class Builder {
        private Integer mandatory;
        private Integer readOnly;
        private String title;

        public final Builder setIsReadyOnly(boolean z) {
            this.readOnly = Integer.valueOf(z ? 1 : 0);
            return this;
        }

        public final Builder setTitle(String str) {
            k.c(str, "title");
            this.title = str;
            return this;
        }

        public final Builder setMandatory(boolean z) {
            this.mandatory = Integer.valueOf(z ? 1 : 0);
            return this;
        }

        public final CJRInputFieldsItem build() {
            return new CJRInputFieldsItem((String) null, (String) null, (String) null, (String) null, (Integer) null, this.readOnly, this.title, (String) null, (String) null, (String) null, (String) null, this.mandatory, (String) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (Boolean) null, (List) null, 0, (String) null, (Integer) null, 8384512, (g) null);
        }
    }
}
