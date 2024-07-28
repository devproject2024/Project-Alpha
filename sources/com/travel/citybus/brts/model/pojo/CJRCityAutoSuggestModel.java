package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.k;

public final class CJRCityAutoSuggestModel {
    @b(a = "list")
    private List<CJRCityAutoSuggest> list;

    public static /* synthetic */ CJRCityAutoSuggestModel copy$default(CJRCityAutoSuggestModel cJRCityAutoSuggestModel, List<CJRCityAutoSuggest> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list2 = cJRCityAutoSuggestModel.list;
        }
        return cJRCityAutoSuggestModel.copy(list2);
    }

    public final List<CJRCityAutoSuggest> component1() {
        return this.list;
    }

    public final CJRCityAutoSuggestModel copy(List<CJRCityAutoSuggest> list2) {
        k.c(list2, "list");
        return new CJRCityAutoSuggestModel(list2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRCityAutoSuggestModel) && k.a((Object) this.list, (Object) ((CJRCityAutoSuggestModel) obj).list);
        }
        return true;
    }

    public final int hashCode() {
        List<CJRCityAutoSuggest> list2 = this.list;
        if (list2 != null) {
            return list2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRCityAutoSuggestModel(list=" + this.list + ")";
    }

    public CJRCityAutoSuggestModel(List<CJRCityAutoSuggest> list2) {
        k.c(list2, "list");
        this.list = list2;
    }

    public final List<CJRCityAutoSuggest> getList() {
        return this.list;
    }

    public final void setList(List<CJRCityAutoSuggest> list2) {
        k.c(list2, "<set-?>");
        this.list = list2;
    }
}
