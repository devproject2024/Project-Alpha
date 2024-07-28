package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;
import net.one97.paytm.feed.e.b;

public final class Feed implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean exception;
    private final Result result;
    private final int status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Feed(parcel.readInt(), parcel.readInt() != 0, (Result) Result.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i2) {
            return new Feed[i2];
        }
    }

    public static /* synthetic */ Feed copy$default(Feed feed, int i2, boolean z, Result result2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = feed.status;
        }
        if ((i3 & 2) != 0) {
            z = feed.exception;
        }
        if ((i3 & 4) != 0) {
            result2 = feed.result;
        }
        return feed.copy(i2, z, result2);
    }

    public final int component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.exception;
    }

    public final Result component3() {
        return this.result;
    }

    public final Feed copy(int i2, boolean z, Result result2) {
        k.c(result2, "result");
        return new Feed(i2, z, result2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Feed) {
                Feed feed = (Feed) obj;
                if (this.status == feed.status) {
                    if (!(this.exception == feed.exception) || !k.a((Object) this.result, (Object) feed.result)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.status).hashCode() * 31;
        boolean z = this.exception;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        Result result2 = this.result;
        return i2 + (result2 != null ? result2.hashCode() : 0);
    }

    public final String toString() {
        return "Feed(status=" + this.status + ", exception=" + this.exception + ", result=" + this.result + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.status);
        parcel.writeInt(this.exception ? 1 : 0);
        this.result.writeToParcel(parcel, 0);
    }

    public Feed(int i2, boolean z, Result result2) {
        k.c(result2, "result");
        this.status = i2;
        this.exception = z;
        this.result = result2;
        b bVar = b.f34268c;
        b.k();
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getException() {
        return this.exception;
    }

    public final Result getResult() {
        return this.result;
    }
}
