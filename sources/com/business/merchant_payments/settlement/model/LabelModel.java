package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class LabelModel {
    @c(a = "key")
    public String key;
    @c(a = "value")
    public String value;
    @c(a = "valueArray")
    public ArrayList<PreviouslyFailedBalanceData> valueArray;

    public static /* synthetic */ LabelModel copy$default(LabelModel labelModel, String str, String str2, ArrayList<PreviouslyFailedBalanceData> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = labelModel.key;
        }
        if ((i2 & 2) != 0) {
            str2 = labelModel.value;
        }
        if ((i2 & 4) != 0) {
            arrayList = labelModel.valueArray;
        }
        return labelModel.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final ArrayList<PreviouslyFailedBalanceData> component3() {
        return this.valueArray;
    }

    public final LabelModel copy(String str, String str2, ArrayList<PreviouslyFailedBalanceData> arrayList) {
        return new LabelModel(str, str2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LabelModel)) {
            return false;
        }
        LabelModel labelModel = (LabelModel) obj;
        return k.a((Object) this.key, (Object) labelModel.key) && k.a((Object) this.value, (Object) labelModel.value) && k.a((Object) this.valueArray, (Object) labelModel.valueArray);
    }

    public final int hashCode() {
        String str = this.key;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<PreviouslyFailedBalanceData> arrayList = this.valueArray;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "LabelModel(key=" + this.key + ", value=" + this.value + ", valueArray=" + this.valueArray + ")";
    }

    public LabelModel(String str, String str2, ArrayList<PreviouslyFailedBalanceData> arrayList) {
        this.key = str;
        this.value = str2;
        this.valueArray = arrayList;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final ArrayList<PreviouslyFailedBalanceData> getValueArray() {
        return this.valueArray;
    }

    public final void setValueArray(ArrayList<PreviouslyFailedBalanceData> arrayList) {
        this.valueArray = arrayList;
    }
}
