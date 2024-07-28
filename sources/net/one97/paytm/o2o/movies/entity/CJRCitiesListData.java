package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRCitiesListData {
    @b(a = "cities")
    private ArrayList<CJRCityInfo> cities;
    @b(a = "topCities")
    private ArrayList<Integer> topCities;

    public CJRCitiesListData() {
        this((ArrayList) null, (ArrayList) null, 3, (g) null);
    }

    public static /* synthetic */ CJRCitiesListData copy$default(CJRCitiesListData cJRCitiesListData, ArrayList<CJRCityInfo> arrayList, ArrayList<Integer> arrayList2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRCitiesListData.cities;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = cJRCitiesListData.topCities;
        }
        return cJRCitiesListData.copy(arrayList, arrayList2);
    }

    public final ArrayList<CJRCityInfo> component1() {
        return this.cities;
    }

    public final ArrayList<Integer> component2() {
        return this.topCities;
    }

    public final CJRCitiesListData copy(ArrayList<CJRCityInfo> arrayList, ArrayList<Integer> arrayList2) {
        return new CJRCitiesListData(arrayList, arrayList2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCitiesListData)) {
            return false;
        }
        CJRCitiesListData cJRCitiesListData = (CJRCitiesListData) obj;
        return k.a((Object) this.cities, (Object) cJRCitiesListData.cities) && k.a((Object) this.topCities, (Object) cJRCitiesListData.topCities);
    }

    public final int hashCode() {
        ArrayList<CJRCityInfo> arrayList = this.cities;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<Integer> arrayList2 = this.topCities;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCitiesListData(cities=" + this.cities + ", topCities=" + this.topCities + ")";
    }

    public CJRCitiesListData(ArrayList<CJRCityInfo> arrayList, ArrayList<Integer> arrayList2) {
        this.cities = arrayList;
        this.topCities = arrayList2;
    }

    public final ArrayList<CJRCityInfo> getCities() {
        return this.cities;
    }

    public final void setCities(ArrayList<CJRCityInfo> arrayList) {
        this.cities = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRCitiesListData(ArrayList arrayList, ArrayList arrayList2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : arrayList2);
    }

    public final ArrayList<Integer> getTopCities() {
        return this.topCities;
    }

    public final void setTopCities(ArrayList<Integer> arrayList) {
        this.topCities = arrayList;
    }
}
