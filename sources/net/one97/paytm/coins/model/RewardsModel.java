package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RewardsModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "grid_layout")
    private ArrayList<Reward> grid_layout;

    public RewardsModel() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ RewardsModel copy$default(RewardsModel rewardsModel, ArrayList<Reward> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = rewardsModel.grid_layout;
        }
        return rewardsModel.copy(arrayList);
    }

    public final ArrayList<Reward> component1() {
        return this.grid_layout;
    }

    public final RewardsModel copy(ArrayList<Reward> arrayList) {
        return new RewardsModel(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RewardsModel) && k.a((Object) this.grid_layout, (Object) ((RewardsModel) obj).grid_layout);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<Reward> arrayList = this.grid_layout;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "RewardsModel(grid_layout=" + this.grid_layout + ")";
    }

    public RewardsModel(ArrayList<Reward> arrayList) {
        this.grid_layout = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardsModel(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<Reward> getGrid_layout() {
        return this.grid_layout;
    }

    public final void setGrid_layout(ArrayList<Reward> arrayList) {
        this.grid_layout = arrayList;
    }
}
