package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.k;

public final class CJRCityModel {
    @b(a = "list")
    private List<CJRCity> list;

    public static /* synthetic */ CJRCityModel copy$default(CJRCityModel cJRCityModel, List<CJRCity> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list2 = cJRCityModel.list;
        }
        return cJRCityModel.copy(list2);
    }

    public final List<CJRCity> component1() {
        return this.list;
    }

    public final CJRCityModel copy(List<CJRCity> list2) {
        k.c(list2, "list");
        return new CJRCityModel(list2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRCityModel) && k.a((Object) this.list, (Object) ((CJRCityModel) obj).list);
        }
        return true;
    }

    public final int hashCode() {
        List<CJRCity> list2 = this.list;
        if (list2 != null) {
            return list2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRCityModel(list=" + this.list + ")";
    }

    public CJRCityModel(List<CJRCity> list2) {
        k.c(list2, "list");
        this.list = list2;
    }

    public final List<CJRCity> getList() {
        return this.list;
    }

    public final void setList(List<CJRCity> list2) {
        k.c(list2, "<set-?>");
        this.list = list2;
    }
}
