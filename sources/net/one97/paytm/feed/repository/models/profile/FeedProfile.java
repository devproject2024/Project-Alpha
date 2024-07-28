package net.one97.paytm.feed.repository.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class FeedProfile implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean exception;
    private final ResultProfile result;
    private final int status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedProfile(parcel.readInt() != 0, (ResultProfile) ResultProfile.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new FeedProfile[i2];
        }
    }

    public static /* synthetic */ FeedProfile copy$default(FeedProfile feedProfile, boolean z, ResultProfile resultProfile, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = feedProfile.exception;
        }
        if ((i3 & 2) != 0) {
            resultProfile = feedProfile.result;
        }
        if ((i3 & 4) != 0) {
            i2 = feedProfile.status;
        }
        return feedProfile.copy(z, resultProfile, i2);
    }

    public final boolean component1() {
        return this.exception;
    }

    public final ResultProfile component2() {
        return this.result;
    }

    public final int component3() {
        return this.status;
    }

    public final FeedProfile copy(boolean z, ResultProfile resultProfile, int i2) {
        k.c(resultProfile, "result");
        return new FeedProfile(z, resultProfile, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedProfile) {
                FeedProfile feedProfile = (FeedProfile) obj;
                if ((this.exception == feedProfile.exception) && k.a((Object) this.result, (Object) feedProfile.result)) {
                    if (this.status == feedProfile.status) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.exception;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        ResultProfile resultProfile = this.result;
        return ((i2 + (resultProfile != null ? resultProfile.hashCode() : 0)) * 31) + Integer.valueOf(this.status).hashCode();
    }

    public final String toString() {
        return "FeedProfile(exception=" + this.exception + ", result=" + this.result + ", status=" + this.status + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.exception ? 1 : 0);
        this.result.writeToParcel(parcel, 0);
        parcel.writeInt(this.status);
    }

    public FeedProfile(boolean z, ResultProfile resultProfile, int i2) {
        k.c(resultProfile, "result");
        this.exception = z;
        this.result = resultProfile;
        this.status = i2;
    }

    public final boolean getException() {
        return this.exception;
    }

    public final ResultProfile getResult() {
        return this.result;
    }

    public final int getStatus() {
        return this.status;
    }
}
