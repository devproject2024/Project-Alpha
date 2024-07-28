package net.one97.paytm.feed.repository.models.polls;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class Polls extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    private boolean isVoted;
    @c(a = "logo")
    private final String logoUrl;
    @c(a = "cards")
    private final List<PollsData> pollsList;
    private final String title;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((PollsData) PollsData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new Polls(readString, readString2, z, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new Polls[i2];
        }
    }

    public static /* synthetic */ Polls copy$default(Polls polls, String str, String str2, boolean z, List<PollsData> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = polls.title;
        }
        if ((i2 & 2) != 0) {
            str2 = polls.logoUrl;
        }
        if ((i2 & 4) != 0) {
            z = polls.isVoted;
        }
        if ((i2 & 8) != 0) {
            list = polls.pollsList;
        }
        return polls.copy(str, str2, z, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.logoUrl;
    }

    public final boolean component3() {
        return this.isVoted;
    }

    public final List<PollsData> component4() {
        return this.pollsList;
    }

    public final Polls copy(String str, String str2, boolean z, List<PollsData> list) {
        k.c(list, "pollsList");
        return new Polls(str, str2, z, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Polls) {
                Polls polls = (Polls) obj;
                if (k.a((Object) this.title, (Object) polls.title) && k.a((Object) this.logoUrl, (Object) polls.logoUrl)) {
                    if (!(this.isVoted == polls.isVoted) || !k.a((Object) this.pollsList, (Object) polls.pollsList)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.logoUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isVoted;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        List<PollsData> list = this.pollsList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "Polls(title=" + this.title + ", logoUrl=" + this.logoUrl + ", isVoted=" + this.isVoted + ", pollsList=" + this.pollsList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.logoUrl);
        parcel.writeInt(this.isVoted ? 1 : 0);
        List<PollsData> list = this.pollsList;
        parcel.writeInt(list.size());
        for (PollsData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final boolean isVoted() {
        return this.isVoted;
    }

    public final void setVoted(boolean z) {
        this.isVoted = z;
    }

    public Polls(String str, String str2, boolean z, List<PollsData> list) {
        k.c(list, "pollsList");
        this.title = str;
        this.logoUrl = str2;
        this.isVoted = z;
        this.pollsList = list;
    }

    public final List<PollsData> getPollsList() {
        return this.pollsList;
    }
}
