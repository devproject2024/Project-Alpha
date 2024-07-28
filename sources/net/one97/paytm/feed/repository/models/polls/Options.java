package net.one97.paytm.feed.repository.models.polls;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Options implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "count")
    private int optionscount;
    @c(a = "id")
    private String optionsid;
    @c(a = "label")
    private String optionslabel;
    @c(a = "value")
    private String optionsvalue;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Options(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new Options[i2];
        }
    }

    public static /* synthetic */ Options copy$default(Options options, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = options.optionsid;
        }
        if ((i3 & 2) != 0) {
            str2 = options.optionslabel;
        }
        if ((i3 & 4) != 0) {
            str3 = options.optionsvalue;
        }
        if ((i3 & 8) != 0) {
            i2 = options.optionscount;
        }
        return options.copy(str, str2, str3, i2);
    }

    public final String component1() {
        return this.optionsid;
    }

    public final String component2() {
        return this.optionslabel;
    }

    public final String component3() {
        return this.optionsvalue;
    }

    public final int component4() {
        return this.optionscount;
    }

    public final Options copy(String str, String str2, String str3, int i2) {
        k.c(str, "optionsid");
        k.c(str2, "optionslabel");
        k.c(str3, "optionsvalue");
        return new Options(str, str2, str3, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Options) {
                Options options = (Options) obj;
                if (k.a((Object) this.optionsid, (Object) options.optionsid) && k.a((Object) this.optionslabel, (Object) options.optionslabel) && k.a((Object) this.optionsvalue, (Object) options.optionsvalue)) {
                    if (this.optionscount == options.optionscount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.optionsid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.optionslabel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.optionsvalue;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Integer.valueOf(this.optionscount).hashCode();
    }

    public final String toString() {
        return "Options(optionsid=" + this.optionsid + ", optionslabel=" + this.optionslabel + ", optionsvalue=" + this.optionsvalue + ", optionscount=" + this.optionscount + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.optionsid);
        parcel.writeString(this.optionslabel);
        parcel.writeString(this.optionsvalue);
        parcel.writeInt(this.optionscount);
    }

    public Options(String str, String str2, String str3, int i2) {
        k.c(str, "optionsid");
        k.c(str2, "optionslabel");
        k.c(str3, "optionsvalue");
        this.optionsid = str;
        this.optionslabel = str2;
        this.optionsvalue = str3;
        this.optionscount = i2;
    }

    public final String getOptionsid() {
        return this.optionsid;
    }

    public final void setOptionsid(String str) {
        k.c(str, "<set-?>");
        this.optionsid = str;
    }

    public final String getOptionslabel() {
        return this.optionslabel;
    }

    public final void setOptionslabel(String str) {
        k.c(str, "<set-?>");
        this.optionslabel = str;
    }

    public final String getOptionsvalue() {
        return this.optionsvalue;
    }

    public final void setOptionsvalue(String str) {
        k.c(str, "<set-?>");
        this.optionsvalue = str;
    }

    public final int getOptionscount() {
        return this.optionscount;
    }

    public final void setOptionscount(int i2) {
        this.optionscount = i2;
    }
}
