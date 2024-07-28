package com.business.merchant_payments.mapqr.model;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SaveResponseBody {
    @c(a = "questions")
    public List<Questions> questions;

    public SaveResponseBody() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ SaveResponseBody copy$default(SaveResponseBody saveResponseBody, List<Questions> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = saveResponseBody.questions;
        }
        return saveResponseBody.copy(list);
    }

    public final List<Questions> component1() {
        return this.questions;
    }

    public final SaveResponseBody copy(List<Questions> list) {
        k.d(list, "questions");
        return new SaveResponseBody(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SaveResponseBody) && k.a((Object) this.questions, (Object) ((SaveResponseBody) obj).questions);
        }
        return true;
    }

    public final int hashCode() {
        List<Questions> list = this.questions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SaveResponseBody(questions=" + this.questions + ")";
    }

    public SaveResponseBody(List<Questions> list) {
        k.d(list, "questions");
        this.questions = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveResponseBody(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? kotlin.a.k.a(new Questions((String) null, (List) null, 3, (g) null)) : list);
    }

    public final List<Questions> getQuestions() {
        return this.questions;
    }

    public final void setQuestions(List<Questions> list) {
        k.d(list, "<set-?>");
        this.questions = list;
    }
}
