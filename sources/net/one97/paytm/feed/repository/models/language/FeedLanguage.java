package net.one97.paytm.feed.repository.models.language;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedLanguage extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean isBoard;
    private final List<FeedLanguageData> languages;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((FeedLanguageData) FeedLanguageData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new FeedLanguage(z, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new FeedLanguage[i2];
        }
    }

    public static /* synthetic */ FeedLanguage copy$default(FeedLanguage feedLanguage, boolean z, List<FeedLanguageData> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = feedLanguage.isBoard;
        }
        if ((i2 & 2) != 0) {
            list = feedLanguage.languages;
        }
        return feedLanguage.copy(z, list);
    }

    public final boolean component1() {
        return this.isBoard;
    }

    public final List<FeedLanguageData> component2() {
        return this.languages;
    }

    public final FeedLanguage copy(boolean z, List<FeedLanguageData> list) {
        k.c(list, "languages");
        return new FeedLanguage(z, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedLanguage) {
                FeedLanguage feedLanguage = (FeedLanguage) obj;
                if (!(this.isBoard == feedLanguage.isBoard) || !k.a((Object) this.languages, (Object) feedLanguage.languages)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isBoard;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        List<FeedLanguageData> list = this.languages;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "FeedLanguage(isBoard=" + this.isBoard + ", languages=" + this.languages + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.isBoard ? 1 : 0);
        List<FeedLanguageData> list = this.languages;
        parcel.writeInt(list.size());
        for (FeedLanguageData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public final boolean isBoard() {
        return this.isBoard;
    }

    public final List<FeedLanguageData> getLanguages() {
        return this.languages;
    }

    public FeedLanguage(boolean z, List<FeedLanguageData> list) {
        k.c(list, "languages");
        this.isBoard = z;
        this.languages = list;
    }
}
