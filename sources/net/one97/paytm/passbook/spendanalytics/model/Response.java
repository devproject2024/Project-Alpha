package net.one97.paytm.passbook.spendanalytics.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class Response extends IJRDataModel {
    @b(a = "dist")
    private SpendAnalyticsDistribution distribution;
    @b(a = "subDis")
    private ArrayList<Subdistribution> subDistrubution;

    public static /* synthetic */ Response copy$default(Response response, SpendAnalyticsDistribution spendAnalyticsDistribution, ArrayList<Subdistribution> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            spendAnalyticsDistribution = response.distribution;
        }
        if ((i2 & 2) != 0) {
            arrayList = response.subDistrubution;
        }
        return response.copy(spendAnalyticsDistribution, arrayList);
    }

    public final SpendAnalyticsDistribution component1() {
        return this.distribution;
    }

    public final ArrayList<Subdistribution> component2() {
        return this.subDistrubution;
    }

    public final Response copy(SpendAnalyticsDistribution spendAnalyticsDistribution, ArrayList<Subdistribution> arrayList) {
        k.c(spendAnalyticsDistribution, "distribution");
        k.c(arrayList, "subDistrubution");
        return new Response(spendAnalyticsDistribution, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return k.a((Object) this.distribution, (Object) response.distribution) && k.a((Object) this.subDistrubution, (Object) response.subDistrubution);
    }

    public final int hashCode() {
        SpendAnalyticsDistribution spendAnalyticsDistribution = this.distribution;
        int i2 = 0;
        int hashCode = (spendAnalyticsDistribution != null ? spendAnalyticsDistribution.hashCode() : 0) * 31;
        ArrayList<Subdistribution> arrayList = this.subDistrubution;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Response(distribution=" + this.distribution + ", subDistrubution=" + this.subDistrubution + ")";
    }

    public final SpendAnalyticsDistribution getDistribution() {
        return this.distribution;
    }

    public final void setDistribution(SpendAnalyticsDistribution spendAnalyticsDistribution) {
        k.c(spendAnalyticsDistribution, "<set-?>");
        this.distribution = spendAnalyticsDistribution;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Response(SpendAnalyticsDistribution spendAnalyticsDistribution, ArrayList arrayList, int i2, g gVar) {
        this(spendAnalyticsDistribution, (i2 & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<Subdistribution> getSubDistrubution() {
        return this.subDistrubution;
    }

    public final void setSubDistrubution(ArrayList<Subdistribution> arrayList) {
        k.c(arrayList, "<set-?>");
        this.subDistrubution = arrayList;
    }

    public Response(SpendAnalyticsDistribution spendAnalyticsDistribution, ArrayList<Subdistribution> arrayList) {
        k.c(spendAnalyticsDistribution, "distribution");
        k.c(arrayList, "subDistrubution");
        this.distribution = spendAnalyticsDistribution;
        this.subDistrubution = arrayList;
    }
}
