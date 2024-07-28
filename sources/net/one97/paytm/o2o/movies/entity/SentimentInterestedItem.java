package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SentimentInterestedItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "countInfo")
    private HashMap<String, Long> countInfo;
    @b(a = "percentage")
    private String percentage;
    @b(a = "thresholdReached")
    private Boolean thresholdReached;
    @b(a = "userInput")
    private String userInput;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            k.c(parcel, "in");
            String readString = parcel.readString();
            HashMap hashMap = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                HashMap hashMap2 = new HashMap(readInt);
                while (readInt != 0) {
                    hashMap2.put(parcel.readString(), Long.valueOf(parcel.readLong()));
                    readInt--;
                }
                hashMap = hashMap2;
            }
            return new SentimentInterestedItem(readString, bool, hashMap, parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new SentimentInterestedItem[i2];
        }
    }

    public SentimentInterestedItem() {
        this((String) null, (Boolean) null, (HashMap) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ SentimentInterestedItem copy$default(SentimentInterestedItem sentimentInterestedItem, String str, Boolean bool, HashMap<String, Long> hashMap, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sentimentInterestedItem.userInput;
        }
        if ((i2 & 2) != 0) {
            bool = sentimentInterestedItem.thresholdReached;
        }
        if ((i2 & 4) != 0) {
            hashMap = sentimentInterestedItem.countInfo;
        }
        if ((i2 & 8) != 0) {
            str2 = sentimentInterestedItem.percentage;
        }
        return sentimentInterestedItem.copy(str, bool, hashMap, str2);
    }

    public final String component1() {
        return this.userInput;
    }

    public final Boolean component2() {
        return this.thresholdReached;
    }

    public final HashMap<String, Long> component3() {
        return this.countInfo;
    }

    public final String component4() {
        return this.percentage;
    }

    public final SentimentInterestedItem copy(String str, Boolean bool, HashMap<String, Long> hashMap, String str2) {
        return new SentimentInterestedItem(str, bool, hashMap, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SentimentInterestedItem)) {
            return false;
        }
        SentimentInterestedItem sentimentInterestedItem = (SentimentInterestedItem) obj;
        return k.a((Object) this.userInput, (Object) sentimentInterestedItem.userInput) && k.a((Object) this.thresholdReached, (Object) sentimentInterestedItem.thresholdReached) && k.a((Object) this.countInfo, (Object) sentimentInterestedItem.countInfo) && k.a((Object) this.percentage, (Object) sentimentInterestedItem.percentage);
    }

    public final int hashCode() {
        String str = this.userInput;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.thresholdReached;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        HashMap<String, Long> hashMap = this.countInfo;
        int hashCode3 = (hashCode2 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        String str2 = this.percentage;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SentimentInterestedItem(userInput=" + this.userInput + ", thresholdReached=" + this.thresholdReached + ", countInfo=" + this.countInfo + ", percentage=" + this.percentage + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.userInput);
        Boolean bool = this.thresholdReached;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        HashMap<String, Long> hashMap = this.countInfo;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, Long> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                parcel.writeLong(next.getValue().longValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.percentage);
    }

    public SentimentInterestedItem(String str, Boolean bool, HashMap<String, Long> hashMap, String str2) {
        this.userInput = str;
        this.thresholdReached = bool;
        this.countInfo = hashMap;
        this.percentage = str2;
    }

    public final String getUserInput() {
        return this.userInput;
    }

    public final void setUserInput(String str) {
        this.userInput = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SentimentInterestedItem(String str, Boolean bool, HashMap hashMap, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? Boolean.FALSE : bool, (i2 & 4) != 0 ? null : hashMap, (i2 & 8) != 0 ? null : str2);
    }

    public final Boolean getThresholdReached() {
        return this.thresholdReached;
    }

    public final void setThresholdReached(Boolean bool) {
        this.thresholdReached = bool;
    }

    public final HashMap<String, Long> getCountInfo() {
        return this.countInfo;
    }

    public final void setCountInfo(HashMap<String, Long> hashMap) {
        this.countInfo = hashMap;
    }

    public final String getPercentage() {
        return this.percentage;
    }

    public final void setPercentage(String str) {
        this.percentage = str;
    }
}
