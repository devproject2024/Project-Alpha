package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new Parcelable.Creator<SpliceNullCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new SpliceNullCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }
    };

    public final void writeToParcel(Parcel parcel, int i2) {
    }
}
