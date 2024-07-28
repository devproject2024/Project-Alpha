package com.business.merchant_payments.mapqr.model;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Questions {
    @c(a = "answers")
    public List<Answers> answers;
    @c(a = "code")
    public String code;

    public Questions() {
        this((String) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ Questions copy$default(Questions questions, String str, List<Answers> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = questions.code;
        }
        if ((i2 & 2) != 0) {
            list = questions.answers;
        }
        return questions.copy(str, list);
    }

    public final String component1() {
        return this.code;
    }

    public final List<Answers> component2() {
        return this.answers;
    }

    public final Questions copy(String str, List<Answers> list) {
        k.d(str, "code");
        k.d(list, "answers");
        return new Questions(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Questions)) {
            return false;
        }
        Questions questions = (Questions) obj;
        return k.a((Object) this.code, (Object) questions.code) && k.a((Object) this.answers, (Object) questions.answers);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Answers> list = this.answers;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Questions(code=" + this.code + ", answers=" + this.answers + ")";
    }

    public Questions(String str, List<Answers> list) {
        k.d(str, "code");
        k.d(list, "answers");
        this.code = str;
        this.answers = list;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        k.d(str, "<set-?>");
        this.code = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Questions(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? "qr_use_feedback" : str, (i2 & 2) != 0 ? kotlin.a.k.a(new Answers("", "")) : list);
    }

    public final List<Answers> getAnswers() {
        return this.answers;
    }

    public final void setAnswers(List<Answers> list) {
        k.d(list, "<set-?>");
        this.answers = list;
    }
}
