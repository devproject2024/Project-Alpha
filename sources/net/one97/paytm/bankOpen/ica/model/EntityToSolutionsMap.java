package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EntityToSolutionsMap extends IJRPaytmDataModel {
    @b(a = "INDIVIDUAL")
    private final List<String> INDIVIDUAL;
    @b(a = "KYC")
    private final List<String> KYC;

    public EntityToSolutionsMap() {
        this((List) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ EntityToSolutionsMap copy$default(EntityToSolutionsMap entityToSolutionsMap, List<String> list, List<String> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = entityToSolutionsMap.INDIVIDUAL;
        }
        if ((i2 & 2) != 0) {
            list2 = entityToSolutionsMap.KYC;
        }
        return entityToSolutionsMap.copy(list, list2);
    }

    public final List<String> component1() {
        return this.INDIVIDUAL;
    }

    public final List<String> component2() {
        return this.KYC;
    }

    public final EntityToSolutionsMap copy(List<String> list, List<String> list2) {
        k.c(list, "INDIVIDUAL");
        k.c(list2, "KYC");
        return new EntityToSolutionsMap(list, list2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntityToSolutionsMap)) {
            return false;
        }
        EntityToSolutionsMap entityToSolutionsMap = (EntityToSolutionsMap) obj;
        return k.a((Object) this.INDIVIDUAL, (Object) entityToSolutionsMap.INDIVIDUAL) && k.a((Object) this.KYC, (Object) entityToSolutionsMap.KYC);
    }

    public final int hashCode() {
        List<String> list = this.INDIVIDUAL;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.KYC;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EntityToSolutionsMap(INDIVIDUAL=" + this.INDIVIDUAL + ", KYC=" + this.KYC + ")";
    }

    public final List<String> getINDIVIDUAL() {
        return this.INDIVIDUAL;
    }

    public final List<String> getKYC() {
        return this.KYC;
    }

    public EntityToSolutionsMap(List<String> list, List<String> list2) {
        k.c(list, "INDIVIDUAL");
        k.c(list2, "KYC");
        this.INDIVIDUAL = list;
        this.KYC = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EntityToSolutionsMap(List list, List list2, int i2, g gVar) {
        this((i2 & 1) != 0 ? w.INSTANCE : list, (i2 & 2) != 0 ? w.INSTANCE : list2);
    }
}
