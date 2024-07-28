package net.one97.paytm.games.model.pfg;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GameTag extends BaseResult implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private String tagIcon;
    private String tagId;
    private String tagName;

    public final int describeContents() {
        return 0;
    }

    public GameTag() {
        this.tagName = "";
        this.tagId = "";
        this.tagIcon = "";
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final void setTagName(String str) {
        this.tagName = str;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final void setTagId(String str) {
        this.tagId = str;
    }

    public final String getTagIcon() {
        return this.tagIcon;
    }

    public final void setTagIcon(String str) {
        this.tagIcon = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GameTag(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.tagName = parcel.readString();
        this.tagId = parcel.readString();
        this.tagIcon = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "dest");
        parcel.writeString(this.tagName);
        parcel.writeString(this.tagId);
        parcel.writeString(this.tagIcon);
    }

    public static final class CREATOR implements Parcelable.Creator<GameTag> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final GameTag createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new GameTag(parcel);
        }

        public final GameTag[] newArray(int i2) {
            return new GameTag[i2];
        }
    }
}
