package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class g implements Serializable {
    @b(a = "onward")
    private f[] onwardLeg;
    @b(a = "return")
    private f[] returnLeg;

    public g() {
        this((f[]) null, (f[]) null, 3, (kotlin.g.b.g) null);
    }

    public g(f[] fVarArr, f[] fVarArr2) {
        this.onwardLeg = fVarArr;
        this.returnLeg = fVarArr2;
    }

    public final f[] getOnwardLeg() {
        return this.onwardLeg;
    }

    public final void setOnwardLeg(f[] fVarArr) {
        this.onwardLeg = fVarArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(f[] fVarArr, f[] fVarArr2, int i2, kotlin.g.b.g gVar) {
        this((i2 & 1) != 0 ? null : fVarArr, (i2 & 2) != 0 ? null : fVarArr2);
    }

    public final f[] getReturnLeg() {
        return this.returnLeg;
    }

    public final void setReturnLeg(f[] fVarArr) {
        this.returnLeg = fVarArr;
    }
}
