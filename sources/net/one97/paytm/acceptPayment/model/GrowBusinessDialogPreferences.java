package net.one97.paytm.acceptPayment.model;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class GrowBusinessDialogPreferences {
    public long firstLaunchTimestamp;
    public ArrayList<Integer> futureDialogs;
    public long lastLaunchTimestamp;
    public int launchCount;
    public int nextDialog;

    public static /* synthetic */ GrowBusinessDialogPreferences copy$default(GrowBusinessDialogPreferences growBusinessDialogPreferences, long j, long j2, int i2, int i3, ArrayList arrayList, int i4, Object obj) {
        GrowBusinessDialogPreferences growBusinessDialogPreferences2 = growBusinessDialogPreferences;
        return growBusinessDialogPreferences.copy((i4 & 1) != 0 ? growBusinessDialogPreferences2.lastLaunchTimestamp : j, (i4 & 2) != 0 ? growBusinessDialogPreferences2.firstLaunchTimestamp : j2, (i4 & 4) != 0 ? growBusinessDialogPreferences2.nextDialog : i2, (i4 & 8) != 0 ? growBusinessDialogPreferences2.launchCount : i3, (i4 & 16) != 0 ? growBusinessDialogPreferences2.futureDialogs : arrayList);
    }

    public final long component1() {
        return this.lastLaunchTimestamp;
    }

    public final long component2() {
        return this.firstLaunchTimestamp;
    }

    public final int component3() {
        return this.nextDialog;
    }

    public final int component4() {
        return this.launchCount;
    }

    public final ArrayList<Integer> component5() {
        return this.futureDialogs;
    }

    public final GrowBusinessDialogPreferences copy(long j, long j2, int i2, int i3, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = arrayList;
        k.d(arrayList2, "futureDialogs");
        return new GrowBusinessDialogPreferences(j, j2, i2, i3, arrayList2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GrowBusinessDialogPreferences)) {
            return false;
        }
        GrowBusinessDialogPreferences growBusinessDialogPreferences = (GrowBusinessDialogPreferences) obj;
        return this.lastLaunchTimestamp == growBusinessDialogPreferences.lastLaunchTimestamp && this.firstLaunchTimestamp == growBusinessDialogPreferences.firstLaunchTimestamp && this.nextDialog == growBusinessDialogPreferences.nextDialog && this.launchCount == growBusinessDialogPreferences.launchCount && k.a((Object) this.futureDialogs, (Object) growBusinessDialogPreferences.futureDialogs);
    }

    public final int hashCode() {
        long j = this.lastLaunchTimestamp;
        long j2 = this.firstLaunchTimestamp;
        int i2 = ((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.nextDialog) * 31) + this.launchCount) * 31;
        ArrayList<Integer> arrayList = this.futureDialogs;
        return i2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        return "GrowBusinessDialogPreferences(lastLaunchTimestamp=" + this.lastLaunchTimestamp + ", firstLaunchTimestamp=" + this.firstLaunchTimestamp + ", nextDialog=" + this.nextDialog + ", launchCount=" + this.launchCount + ", futureDialogs=" + this.futureDialogs + ")";
    }

    public GrowBusinessDialogPreferences(long j, long j2, int i2, int i3, ArrayList<Integer> arrayList) {
        k.d(arrayList, "futureDialogs");
        this.lastLaunchTimestamp = j;
        this.firstLaunchTimestamp = j2;
        this.nextDialog = i2;
        this.launchCount = i3;
        this.futureDialogs = arrayList;
    }

    public final long getLastLaunchTimestamp() {
        return this.lastLaunchTimestamp;
    }

    public final void setLastLaunchTimestamp(long j) {
        this.lastLaunchTimestamp = j;
    }

    public final long getFirstLaunchTimestamp() {
        return this.firstLaunchTimestamp;
    }

    public final void setFirstLaunchTimestamp(long j) {
        this.firstLaunchTimestamp = j;
    }

    public final int getNextDialog() {
        return this.nextDialog;
    }

    public final void setNextDialog(int i2) {
        this.nextDialog = i2;
    }

    public final int getLaunchCount() {
        return this.launchCount;
    }

    public final void setLaunchCount(int i2) {
        this.launchCount = i2;
    }

    public final ArrayList<Integer> getFutureDialogs() {
        return this.futureDialogs;
    }

    public final void setFutureDialogs(ArrayList<Integer> arrayList) {
        k.d(arrayList, "<set-?>");
        this.futureDialogs = arrayList;
    }
}
