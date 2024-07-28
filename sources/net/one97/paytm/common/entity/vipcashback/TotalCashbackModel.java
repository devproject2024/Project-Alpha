package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class TotalCashbackModel extends IJRPaytmDataModel {
    @b(a = "amt")
    private float amt;
    @b(a = "cnt")
    private int cnt;

    public TotalCashbackModel() {
        this(0, 0.0f, 3, (g) null);
    }

    public static /* synthetic */ TotalCashbackModel copy$default(TotalCashbackModel totalCashbackModel, int i2, float f2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = totalCashbackModel.cnt;
        }
        if ((i3 & 2) != 0) {
            f2 = totalCashbackModel.amt;
        }
        return totalCashbackModel.copy(i2, f2);
    }

    public final int component1() {
        return this.cnt;
    }

    public final float component2() {
        return this.amt;
    }

    public final TotalCashbackModel copy(int i2, float f2) {
        return new TotalCashbackModel(i2, f2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TotalCashbackModel) {
                TotalCashbackModel totalCashbackModel = (TotalCashbackModel) obj;
                if (!(this.cnt == totalCashbackModel.cnt) || Float.compare(this.amt, totalCashbackModel.amt) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.cnt * 31) + Float.floatToIntBits(this.amt);
    }

    public final String toString() {
        return "TotalCashbackModel(cnt=" + this.cnt + ", amt=" + this.amt + ")";
    }

    public final int getCnt() {
        return this.cnt;
    }

    public final void setCnt(int i2) {
        this.cnt = i2;
    }

    public TotalCashbackModel(int i2, float f2) {
        this.cnt = i2;
        this.amt = f2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TotalCashbackModel(int i2, float f2, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? 0.0f : f2);
    }

    public final float getAmt() {
        return this.amt;
    }

    public final void setAmt(float f2) {
        this.amt = f2;
    }
}
