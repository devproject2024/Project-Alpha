package net.one97.paytm.passbook.spendanalytics.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class Subdistribution extends IJRDataModel {
    @b(a = "dist")
    private SpendAnalyticsDistribution distribution;

    public static /* synthetic */ Subdistribution copy$default(Subdistribution subdistribution, SpendAnalyticsDistribution spendAnalyticsDistribution, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            spendAnalyticsDistribution = subdistribution.distribution;
        }
        return subdistribution.copy(spendAnalyticsDistribution);
    }

    public final SpendAnalyticsDistribution component1() {
        return this.distribution;
    }

    public final Subdistribution copy(SpendAnalyticsDistribution spendAnalyticsDistribution) {
        k.c(spendAnalyticsDistribution, "distribution");
        return new Subdistribution(spendAnalyticsDistribution);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Subdistribution) && k.a((Object) this.distribution, (Object) ((Subdistribution) obj).distribution);
        }
        return true;
    }

    public final int hashCode() {
        SpendAnalyticsDistribution spendAnalyticsDistribution = this.distribution;
        if (spendAnalyticsDistribution != null) {
            return spendAnalyticsDistribution.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Subdistribution(distribution=" + this.distribution + ")";
    }

    public final SpendAnalyticsDistribution getDistribution() {
        return this.distribution;
    }

    public final void setDistribution(SpendAnalyticsDistribution spendAnalyticsDistribution) {
        k.c(spendAnalyticsDistribution, "<set-?>");
        this.distribution = spendAnalyticsDistribution;
    }

    public Subdistribution(SpendAnalyticsDistribution spendAnalyticsDistribution) {
        k.c(spendAnalyticsDistribution, "distribution");
        this.distribution = spendAnalyticsDistribution;
    }
}
