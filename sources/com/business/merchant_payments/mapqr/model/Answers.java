package com.business.merchant_payments.mapqr.model;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class Answers {
    @c(a = "code")
    public String code;
    @c(a = "text")
    public String text;

    public static /* synthetic */ Answers copy$default(Answers answers, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = answers.code;
        }
        if ((i2 & 2) != 0) {
            str2 = answers.text;
        }
        return answers.copy(str, str2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.text;
    }

    public final Answers copy(String str, String str2) {
        k.d(str, "code");
        k.d(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        return new Answers(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Answers)) {
            return false;
        }
        Answers answers = (Answers) obj;
        return k.a((Object) this.code, (Object) answers.code) && k.a((Object) this.text, (Object) answers.text);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Answers(code=" + this.code + ", text=" + this.text + ")";
    }

    public Answers(String str, String str2) {
        k.d(str, "code");
        k.d(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.code = str;
        this.text = str2;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        k.d(str, "<set-?>");
        this.code = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        k.d(str, "<set-?>");
        this.text = str;
    }
}
