package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class Question extends IJRPaytmDataModel {
    @b(a = "curable")
    private final boolean curable;
    @b(a = "displayType")
    private final String displayType;
    @b(a = "id")
    private final int id;
    @b(a = "mandatory")
    private final boolean mandatory;
    @b(a = "options")
    private final List<Option> options;
    @b(a = "questionAlias")
    private final String questionAlias;
    @b(a = "status")
    private final boolean status;
    @b(a = "text")
    private final String text;

    public static /* synthetic */ Question copy$default(Question question, boolean z, String str, int i2, boolean z2, List list, String str2, boolean z3, String str3, int i3, Object obj) {
        Question question2 = question;
        int i4 = i3;
        return question.copy((i4 & 1) != 0 ? question2.curable : z, (i4 & 2) != 0 ? question2.displayType : str, (i4 & 4) != 0 ? question2.id : i2, (i4 & 8) != 0 ? question2.mandatory : z2, (i4 & 16) != 0 ? question2.options : list, (i4 & 32) != 0 ? question2.questionAlias : str2, (i4 & 64) != 0 ? question2.status : z3, (i4 & 128) != 0 ? question2.text : str3);
    }

    public final boolean component1() {
        return this.curable;
    }

    public final String component2() {
        return this.displayType;
    }

    public final int component3() {
        return this.id;
    }

    public final boolean component4() {
        return this.mandatory;
    }

    public final List<Option> component5() {
        return this.options;
    }

    public final String component6() {
        return this.questionAlias;
    }

    public final boolean component7() {
        return this.status;
    }

    public final String component8() {
        return this.text;
    }

    public final Question copy(boolean z, String str, int i2, boolean z2, List<Option> list, String str2, boolean z3, String str3) {
        k.c(str, "displayType");
        k.c(list, "options");
        String str4 = str2;
        k.c(str4, "questionAlias");
        String str5 = str3;
        k.c(str5, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        return new Question(z, str, i2, z2, list, str4, z3, str5);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Question) {
                Question question = (Question) obj;
                if ((this.curable == question.curable) && k.a((Object) this.displayType, (Object) question.displayType)) {
                    if (this.id == question.id) {
                        if ((this.mandatory == question.mandatory) && k.a((Object) this.options, (Object) question.options) && k.a((Object) this.questionAlias, (Object) question.questionAlias)) {
                            if (!(this.status == question.status) || !k.a((Object) this.text, (Object) question.text)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.curable;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.displayType;
        int i3 = 0;
        int hashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.id) * 31;
        boolean z3 = this.mandatory;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode + (z3 ? 1 : 0)) * 31;
        List<Option> list = this.options;
        int hashCode2 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.questionAlias;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z4 = this.status;
        if (!z4) {
            z2 = z4;
        }
        int i5 = (hashCode3 + (z2 ? 1 : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i5 + i3;
    }

    public final String toString() {
        return "Question(curable=" + this.curable + ", displayType=" + this.displayType + ", id=" + this.id + ", mandatory=" + this.mandatory + ", options=" + this.options + ", questionAlias=" + this.questionAlias + ", status=" + this.status + ", text=" + this.text + ")";
    }

    public final boolean getCurable() {
        return this.curable;
    }

    public final String getDisplayType() {
        return this.displayType;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getMandatory() {
        return this.mandatory;
    }

    public final List<Option> getOptions() {
        return this.options;
    }

    public final String getQuestionAlias() {
        return this.questionAlias;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public Question(boolean z, String str, int i2, boolean z2, List<Option> list, String str2, boolean z3, String str3) {
        k.c(str, "displayType");
        k.c(list, "options");
        k.c(str2, "questionAlias");
        k.c(str3, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.curable = z;
        this.displayType = str;
        this.id = i2;
        this.mandatory = z2;
        this.options = list;
        this.questionAlias = str2;
        this.status = z3;
        this.text = str3;
    }
}
