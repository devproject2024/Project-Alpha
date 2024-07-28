package net.one97.paytm.feed.repository.models.language;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedLanguageData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private boolean isSelected;
    @c(a = "displayName")
    private final String lang;
    private final String languageCode;
    private final String localeName;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedLanguageData(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedLanguageData[i2];
        }
    }

    public static /* synthetic */ FeedLanguageData copy$default(FeedLanguageData feedLanguageData, String str, String str2, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedLanguageData.lang;
        }
        if ((i2 & 2) != 0) {
            str2 = feedLanguageData.languageCode;
        }
        if ((i2 & 4) != 0) {
            z = feedLanguageData.isSelected;
        }
        if ((i2 & 8) != 0) {
            str3 = feedLanguageData.localeName;
        }
        return feedLanguageData.copy(str, str2, z, str3);
    }

    public final String component1() {
        return this.lang;
    }

    public final String component2() {
        return this.languageCode;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final String component4() {
        return this.localeName;
    }

    public final FeedLanguageData copy(String str, String str2, boolean z, String str3) {
        k.c(str, "lang");
        k.c(str2, "languageCode");
        k.c(str3, "localeName");
        return new FeedLanguageData(str, str2, z, str3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedLanguageData) {
                FeedLanguageData feedLanguageData = (FeedLanguageData) obj;
                if (k.a((Object) this.lang, (Object) feedLanguageData.lang) && k.a((Object) this.languageCode, (Object) feedLanguageData.languageCode)) {
                    if (!(this.isSelected == feedLanguageData.isSelected) || !k.a((Object) this.localeName, (Object) feedLanguageData.localeName)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.lang;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.languageCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.localeName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "FeedLanguageData(lang=" + this.lang + ", languageCode=" + this.languageCode + ", isSelected=" + this.isSelected + ", localeName=" + this.localeName + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.lang);
        parcel.writeString(this.languageCode);
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeString(this.localeName);
    }

    public FeedLanguageData(String str, String str2, boolean z, String str3) {
        k.c(str, "lang");
        k.c(str2, "languageCode");
        k.c(str3, "localeName");
        this.lang = str;
        this.languageCode = str2;
        this.isSelected = z;
        this.localeName = str3;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getLocaleName() {
        return this.localeName;
    }
}
