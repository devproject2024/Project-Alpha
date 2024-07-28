package net.one97.paytm.recharge.model.v4;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class GroupAttributesItem extends IJRPaytmDataModel {
    @b(a = "show_after_inputfield")
    private final Boolean _showAfterInputfield;
    @b(a = "allowedValues")
    private final List<Object> allowedValues;
    @b(a = "attrId")
    private final Integer attrId;
    @b(a = "defaultValue")
    private final Object defaultValue;
    @b(a = "description")
    private final Object description;
    @b(a = "displayName")
    private final String displayName;
    @b(a = "error")
    private final String error;
    @b(a = "maxValue")
    private final Object maxValue;
    @b(a = "minValue")
    private final Object minValue;
    @b(a = "name")
    private final String name;
    @b(a = "placeholder")
    private final String placeholder;
    @b(a = "showField")
    private final Integer showField;
    @b(a = "type")
    private final CJRDeviceType type;

    public GroupAttributesItem() {
        this((List) null, (Object) null, (Integer) null, (Integer) null, (String) null, (Object) null, (Object) null, (String) null, (Object) null, (String) null, (CJRDeviceType) null, (String) null, (Boolean) null, 8191, (g) null);
    }

    private final Boolean component13() {
        return this._showAfterInputfield;
    }

    public static /* synthetic */ GroupAttributesItem copy$default(GroupAttributesItem groupAttributesItem, List list, Object obj, Integer num, Integer num2, String str, Object obj2, Object obj3, String str2, Object obj4, String str3, CJRDeviceType cJRDeviceType, String str4, Boolean bool, int i2, Object obj5) {
        GroupAttributesItem groupAttributesItem2 = groupAttributesItem;
        int i3 = i2;
        return groupAttributesItem.copy((i3 & 1) != 0 ? groupAttributesItem2.allowedValues : list, (i3 & 2) != 0 ? groupAttributesItem2.minValue : obj, (i3 & 4) != 0 ? groupAttributesItem2.attrId : num, (i3 & 8) != 0 ? groupAttributesItem2.showField : num2, (i3 & 16) != 0 ? groupAttributesItem2.displayName : str, (i3 & 32) != 0 ? groupAttributesItem2.maxValue : obj2, (i3 & 64) != 0 ? groupAttributesItem2.defaultValue : obj3, (i3 & 128) != 0 ? groupAttributesItem2.name : str2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? groupAttributesItem2.description : obj4, (i3 & 512) != 0 ? groupAttributesItem2.placeholder : str3, (i3 & TarConstants.EOF_BLOCK) != 0 ? groupAttributesItem2.type : cJRDeviceType, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? groupAttributesItem2.error : str4, (i3 & 4096) != 0 ? groupAttributesItem2._showAfterInputfield : bool);
    }

    public final List<Object> component1() {
        return this.allowedValues;
    }

    public final String component10() {
        return this.placeholder;
    }

    public final CJRDeviceType component11() {
        return this.type;
    }

    public final String component12() {
        return this.error;
    }

    public final Object component2() {
        return this.minValue;
    }

    public final Integer component3() {
        return this.attrId;
    }

    public final Integer component4() {
        return this.showField;
    }

    public final String component5() {
        return this.displayName;
    }

    public final Object component6() {
        return this.maxValue;
    }

    public final Object component7() {
        return this.defaultValue;
    }

    public final String component8() {
        return this.name;
    }

    public final Object component9() {
        return this.description;
    }

    public final GroupAttributesItem copy(List<? extends Object> list, Object obj, Integer num, Integer num2, String str, Object obj2, Object obj3, String str2, Object obj4, String str3, CJRDeviceType cJRDeviceType, String str4, Boolean bool) {
        return new GroupAttributesItem(list, obj, num, num2, str, obj2, obj3, str2, obj4, str3, cJRDeviceType, str4, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupAttributesItem)) {
            return false;
        }
        GroupAttributesItem groupAttributesItem = (GroupAttributesItem) obj;
        return k.a((Object) this.allowedValues, (Object) groupAttributesItem.allowedValues) && k.a(this.minValue, groupAttributesItem.minValue) && k.a((Object) this.attrId, (Object) groupAttributesItem.attrId) && k.a((Object) this.showField, (Object) groupAttributesItem.showField) && k.a((Object) this.displayName, (Object) groupAttributesItem.displayName) && k.a(this.maxValue, groupAttributesItem.maxValue) && k.a(this.defaultValue, groupAttributesItem.defaultValue) && k.a((Object) this.name, (Object) groupAttributesItem.name) && k.a(this.description, groupAttributesItem.description) && k.a((Object) this.placeholder, (Object) groupAttributesItem.placeholder) && k.a((Object) this.type, (Object) groupAttributesItem.type) && k.a((Object) this.error, (Object) groupAttributesItem.error) && k.a((Object) this._showAfterInputfield, (Object) groupAttributesItem._showAfterInputfield);
    }

    public final int hashCode() {
        List<Object> list = this.allowedValues;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Object obj = this.minValue;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Integer num = this.attrId;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.showField;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.displayName;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        Object obj2 = this.maxValue;
        int hashCode6 = (hashCode5 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.defaultValue;
        int hashCode7 = (hashCode6 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj4 = this.description;
        int hashCode9 = (hashCode8 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        String str3 = this.placeholder;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CJRDeviceType cJRDeviceType = this.type;
        int hashCode11 = (hashCode10 + (cJRDeviceType != null ? cJRDeviceType.hashCode() : 0)) * 31;
        String str4 = this.error;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this._showAfterInputfield;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "GroupAttributesItem(allowedValues=" + this.allowedValues + ", minValue=" + this.minValue + ", attrId=" + this.attrId + ", showField=" + this.showField + ", displayName=" + this.displayName + ", maxValue=" + this.maxValue + ", defaultValue=" + this.defaultValue + ", name=" + this.name + ", description=" + this.description + ", placeholder=" + this.placeholder + ", type=" + this.type + ", error=" + this.error + ", _showAfterInputfield=" + this._showAfterInputfield + ")";
    }

    public final List<Object> getAllowedValues() {
        return this.allowedValues;
    }

    public final Object getMinValue() {
        return this.minValue;
    }

    public final Integer getAttrId() {
        return this.attrId;
    }

    public final Integer getShowField() {
        return this.showField;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Object getMaxValue() {
        return this.maxValue;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getDescription() {
        return this.description;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final CJRDeviceType getType() {
        return this.type;
    }

    public final String getError() {
        return this.error;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GroupAttributesItem(java.util.List r15, java.lang.Object r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.String r19, java.lang.Object r20, java.lang.Object r21, java.lang.String r22, java.lang.Object r23, java.lang.String r24, net.one97.paytm.recharge.model.v4.CJRDeviceType r25, java.lang.String r26, java.lang.Boolean r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.GroupAttributesItem.<init>(java.util.List, java.lang.Object, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Object, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, net.one97.paytm.recharge.model.v4.CJRDeviceType, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public GroupAttributesItem(List<? extends Object> list, Object obj, Integer num, Integer num2, String str, Object obj2, Object obj3, String str2, Object obj4, String str3, CJRDeviceType cJRDeviceType, String str4, Boolean bool) {
        this.allowedValues = list;
        this.minValue = obj;
        this.attrId = num;
        this.showField = num2;
        this.displayName = str;
        this.maxValue = obj2;
        this.defaultValue = obj3;
        this.name = str2;
        this.description = obj4;
        this.placeholder = str3;
        this.type = cJRDeviceType;
        this.error = str4;
        this._showAfterInputfield = bool;
    }

    public final boolean getShowAfterInputfield() {
        Boolean bool = this._showAfterInputfield;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean showField() {
        Integer num = this.showField;
        return num != null && num.intValue() == 1;
    }
}
