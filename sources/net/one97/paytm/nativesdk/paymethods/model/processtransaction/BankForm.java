package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class BankForm implements Serializable {
    private ArrayList<BankFormItem> directForms;
    private DisplayFields displayField;
    private OneClickInfo oneClickInfo;
    private String pageType;
    private BankFormItem redirectForm;

    public static /* synthetic */ BankForm copy$default(BankForm bankForm, String str, BankFormItem bankFormItem, OneClickInfo oneClickInfo2, ArrayList<BankFormItem> arrayList, DisplayFields displayFields, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankForm.pageType;
        }
        if ((i2 & 2) != 0) {
            bankFormItem = bankForm.redirectForm;
        }
        BankFormItem bankFormItem2 = bankFormItem;
        if ((i2 & 4) != 0) {
            oneClickInfo2 = bankForm.oneClickInfo;
        }
        OneClickInfo oneClickInfo3 = oneClickInfo2;
        if ((i2 & 8) != 0) {
            arrayList = bankForm.directForms;
        }
        ArrayList<BankFormItem> arrayList2 = arrayList;
        if ((i2 & 16) != 0) {
            displayFields = bankForm.displayField;
        }
        return bankForm.copy(str, bankFormItem2, oneClickInfo3, arrayList2, displayFields);
    }

    public final String component1() {
        return this.pageType;
    }

    public final BankFormItem component2() {
        return this.redirectForm;
    }

    public final OneClickInfo component3() {
        return this.oneClickInfo;
    }

    public final ArrayList<BankFormItem> component4() {
        return this.directForms;
    }

    public final DisplayFields component5() {
        return this.displayField;
    }

    public final BankForm copy(String str, BankFormItem bankFormItem, OneClickInfo oneClickInfo2, ArrayList<BankFormItem> arrayList, DisplayFields displayFields) {
        return new BankForm(str, bankFormItem, oneClickInfo2, arrayList, displayFields);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankForm)) {
            return false;
        }
        BankForm bankForm = (BankForm) obj;
        return k.a((Object) this.pageType, (Object) bankForm.pageType) && k.a((Object) this.redirectForm, (Object) bankForm.redirectForm) && k.a((Object) this.oneClickInfo, (Object) bankForm.oneClickInfo) && k.a((Object) this.directForms, (Object) bankForm.directForms) && k.a((Object) this.displayField, (Object) bankForm.displayField);
    }

    public final int hashCode() {
        String str = this.pageType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        BankFormItem bankFormItem = this.redirectForm;
        int hashCode2 = (hashCode + (bankFormItem != null ? bankFormItem.hashCode() : 0)) * 31;
        OneClickInfo oneClickInfo2 = this.oneClickInfo;
        int hashCode3 = (hashCode2 + (oneClickInfo2 != null ? oneClickInfo2.hashCode() : 0)) * 31;
        ArrayList<BankFormItem> arrayList = this.directForms;
        int hashCode4 = (hashCode3 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        DisplayFields displayFields = this.displayField;
        if (displayFields != null) {
            i2 = displayFields.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "BankForm(pageType=" + this.pageType + ", redirectForm=" + this.redirectForm + ", oneClickInfo=" + this.oneClickInfo + ", directForms=" + this.directForms + ", displayField=" + this.displayField + ")";
    }

    public BankForm(String str, BankFormItem bankFormItem, OneClickInfo oneClickInfo2, ArrayList<BankFormItem> arrayList, DisplayFields displayFields) {
        this.pageType = str;
        this.redirectForm = bankFormItem;
        this.oneClickInfo = oneClickInfo2;
        this.directForms = arrayList;
        this.displayField = displayFields;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setPageType(String str) {
        this.pageType = str;
    }

    public final BankFormItem getRedirectForm() {
        return this.redirectForm;
    }

    public final void setRedirectForm(BankFormItem bankFormItem) {
        this.redirectForm = bankFormItem;
    }

    public final OneClickInfo getOneClickInfo() {
        return this.oneClickInfo;
    }

    public final void setOneClickInfo(OneClickInfo oneClickInfo2) {
        this.oneClickInfo = oneClickInfo2;
    }

    public final ArrayList<BankFormItem> getDirectForms() {
        return this.directForms;
    }

    public final void setDirectForms(ArrayList<BankFormItem> arrayList) {
        this.directForms = arrayList;
    }

    public final DisplayFields getDisplayField() {
        return this.displayField;
    }

    public final void setDisplayField(DisplayFields displayFields) {
        this.displayField = displayFields;
    }
}
