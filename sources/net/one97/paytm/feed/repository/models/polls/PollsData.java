package net.one97.paytm.feed.repository.models.polls;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.feed.utility.b;

public final class PollsData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String createdAt = b.a(this.createdAt);
    private final String id;
    private boolean isVoted;
    private final List<Options> options;
    private String pollsId;
    private final String title;
    private final int totalCount;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((Options) Options.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new PollsData(readString, readString2, readString3, readInt, arrayList, parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i2) {
            return new PollsData[i2];
        }
    }

    public static /* synthetic */ PollsData copy$default(PollsData pollsData, String str, String str2, String str3, int i2, List<Options> list, String str4, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pollsData.id;
        }
        if ((i3 & 2) != 0) {
            str2 = pollsData.pollsId;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = pollsData.title;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            i2 = pollsData.totalCount;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            list = pollsData.options;
        }
        List<Options> list2 = list;
        if ((i3 & 32) != 0) {
            str4 = pollsData.createdAt;
        }
        String str7 = str4;
        if ((i3 & 64) != 0) {
            z = pollsData.isVoted;
        }
        return pollsData.copy(str, str5, str6, i4, list2, str7, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.pollsId;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final List<Options> component5() {
        return this.options;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final boolean component7() {
        return this.isVoted;
    }

    public final PollsData copy(String str, String str2, String str3, int i2, List<Options> list, String str4, boolean z) {
        k.c(str, "id");
        k.c(str2, "pollsId");
        k.c(str3, "title");
        k.c(list, "options");
        k.c(str4, "createdAt");
        return new PollsData(str, str2, str3, i2, list, str4, z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PollsData) {
                PollsData pollsData = (PollsData) obj;
                if (k.a((Object) this.id, (Object) pollsData.id) && k.a((Object) this.pollsId, (Object) pollsData.pollsId) && k.a((Object) this.title, (Object) pollsData.title)) {
                    if ((this.totalCount == pollsData.totalCount) && k.a((Object) this.options, (Object) pollsData.options) && k.a((Object) this.createdAt, (Object) pollsData.createdAt)) {
                        if (this.isVoted == pollsData.isVoted) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pollsId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.valueOf(this.totalCount).hashCode()) * 31;
        List<Options> list = this.options;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.createdAt;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode4 + i2) * 31;
        boolean z = this.isVoted;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "PollsData(id=" + this.id + ", pollsId=" + this.pollsId + ", title=" + this.title + ", totalCount=" + this.totalCount + ", options=" + this.options + ", createdAt=" + this.createdAt + ", isVoted=" + this.isVoted + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.pollsId);
        parcel.writeString(this.title);
        parcel.writeInt(this.totalCount);
        List<Options> list = this.options;
        parcel.writeInt(list.size());
        for (Options writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.createdAt);
        parcel.writeInt(this.isVoted ? 1 : 0);
    }

    public PollsData(String str, String str2, String str3, int i2, List<Options> list, String str4, boolean z) {
        k.c(str, "id");
        k.c(str2, "pollsId");
        k.c(str3, "title");
        k.c(list, "options");
        k.c(str4, "createdAt");
        this.id = str;
        this.pollsId = str2;
        this.title = str3;
        this.totalCount = i2;
        this.options = list;
        this.createdAt = str4;
        this.isVoted = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPollsId() {
        return this.pollsId;
    }

    public final void setPollsId(String str) {
        k.c(str, "<set-?>");
        this.pollsId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<Options> getOptions() {
        return this.options;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        k.c(str, "<set-?>");
        this.createdAt = str;
    }

    public final boolean isVoted() {
        return this.isVoted;
    }

    public final void setVoted(boolean z) {
        this.isVoted = z;
    }
}
