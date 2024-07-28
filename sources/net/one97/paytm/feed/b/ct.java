package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.ui.feed.actions.b;

public final class ct extends cs {
    private static final ViewDataBinding.b D = null;
    private static final SparseIntArray E;
    private final ConstraintLayout F;
    private long G;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(R.id.pnrHeader, 1);
        E.put(R.id.close, 2);
        E.put(R.id.header_guideline, 3);
        E.put(R.id.trainName, 4);
        E.put(R.id.trainDepartureTime, 5);
        E.put(R.id.trainDepartureDate, 6);
        E.put(R.id.boardingStationName, 7);
        E.put(R.id.trainArrivalTime, 8);
        E.put(R.id.trainArrivalDate, 9);
        E.put(R.id.destinationStation, 10);
        E.put(R.id.divider1, 11);
        E.put(R.id.divider2, 12);
        E.put(R.id.coachClass, 13);
        E.put(R.id.coachType, 14);
        E.put(R.id.divider3, 15);
        E.put(R.id.reservationQuota, 16);
        E.put(R.id.reservationQuotaType, 17);
        E.put(R.id.pnrMessage, 18);
        E.put(R.id.divider4, 19);
        E.put(R.id.travellerName, 20);
        E.put(R.id.berth, 21);
        E.put(R.id.coach, 22);
        E.put(R.id.status, 23);
        E.put(R.id.travellerList, 24);
        E.put(R.id.divider5, 25);
        E.put(R.id.ivCharPrepared, 26);
        E.put(R.id.chatPrepared, 27);
        E.put(R.id.divider6, 28);
    }

    public ct(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 29, D, E));
    }

    private ct(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[21], objArr[7], objArr[27], objArr[2], objArr[22], objArr[13], objArr[14], objArr[10], objArr[11], objArr[12], objArr[15], objArr[19], objArr[25], objArr[28], objArr[3], objArr[26], objArr[1], objArr[18], objArr[16], objArr[17], objArr[23], objArr[9], objArr[8], objArr[6], objArr[5], objArr[4], objArr[24], objArr[20]);
        this.G = -1;
        this.F = objArr[0];
        this.F.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.G = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.q != i2) {
            return false;
        }
        this.C = (b) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.G = 0;
        }
    }
}
