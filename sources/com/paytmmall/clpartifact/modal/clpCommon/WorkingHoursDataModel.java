package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;

public final class WorkingHoursDataModel implements Serializable {
    @c(a = "days")
    private final List<Integer> mDays;
    @c(a = "timings")
    private final List<TimingsDataModel> mTimings;

    public static /* synthetic */ WorkingHoursDataModel copy$default(WorkingHoursDataModel workingHoursDataModel, List<Integer> list, List<TimingsDataModel> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = workingHoursDataModel.mDays;
        }
        if ((i2 & 2) != 0) {
            list2 = workingHoursDataModel.mTimings;
        }
        return workingHoursDataModel.copy(list, list2);
    }

    public final List<Integer> component1() {
        return this.mDays;
    }

    public final List<TimingsDataModel> component2() {
        return this.mTimings;
    }

    public final WorkingHoursDataModel copy(List<Integer> list, List<TimingsDataModel> list2) {
        return new WorkingHoursDataModel(list, list2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkingHoursDataModel)) {
            return false;
        }
        WorkingHoursDataModel workingHoursDataModel = (WorkingHoursDataModel) obj;
        return k.a((Object) this.mDays, (Object) workingHoursDataModel.mDays) && k.a((Object) this.mTimings, (Object) workingHoursDataModel.mTimings);
    }

    public final int hashCode() {
        List<Integer> list = this.mDays;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<TimingsDataModel> list2 = this.mTimings;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "WorkingHoursDataModel(mDays=" + this.mDays + ", mTimings=" + this.mTimings + ")";
    }

    public WorkingHoursDataModel(List<Integer> list, List<TimingsDataModel> list2) {
        this.mDays = list;
        this.mTimings = list2;
    }

    public final List<Integer> getMDays() {
        return this.mDays;
    }

    public final List<TimingsDataModel> getMTimings() {
        return this.mTimings;
    }
}
