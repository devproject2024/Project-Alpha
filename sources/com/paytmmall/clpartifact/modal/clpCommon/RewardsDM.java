package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.k;

public final class RewardsDM {
    @c(a = "promos")
    private final List<PromosDM> promos;

    public static /* synthetic */ RewardsDM copy$default(RewardsDM rewardsDM, List<PromosDM> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = rewardsDM.promos;
        }
        return rewardsDM.copy(list);
    }

    public final List<PromosDM> component1() {
        return this.promos;
    }

    public final RewardsDM copy(List<PromosDM> list) {
        return new RewardsDM(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RewardsDM) && k.a((Object) this.promos, (Object) ((RewardsDM) obj).promos);
        }
        return true;
    }

    public final int hashCode() {
        List<PromosDM> list = this.promos;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "RewardsDM(promos=" + this.promos + ")";
    }

    public RewardsDM(List<PromosDM> list) {
        this.promos = list;
    }

    public final List<PromosDM> getPromos() {
        return this.promos;
    }
}
