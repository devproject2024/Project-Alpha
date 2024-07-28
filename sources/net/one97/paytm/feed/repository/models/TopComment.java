package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class TopComment implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String createdAt;
    private final TopCommentCreatedBy createdBy;
    private final String id;
    private final String text;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new TopComment(parcel.readString(), (TopCommentCreatedBy) TopCommentCreatedBy.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new TopComment[i2];
        }
    }

    public static /* synthetic */ TopComment copy$default(TopComment topComment, String str, TopCommentCreatedBy topCommentCreatedBy, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = topComment.id;
        }
        if ((i2 & 2) != 0) {
            topCommentCreatedBy = topComment.createdBy;
        }
        if ((i2 & 4) != 0) {
            str2 = topComment.text;
        }
        if ((i2 & 8) != 0) {
            str3 = topComment.createdAt;
        }
        return topComment.copy(str, topCommentCreatedBy, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final TopCommentCreatedBy component2() {
        return this.createdBy;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.createdAt;
    }

    public final TopComment copy(String str, TopCommentCreatedBy topCommentCreatedBy, String str2, String str3) {
        k.c(str, "id");
        k.c(topCommentCreatedBy, "createdBy");
        k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        k.c(str3, "createdAt");
        return new TopComment(str, topCommentCreatedBy, str2, str3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopComment)) {
            return false;
        }
        TopComment topComment = (TopComment) obj;
        return k.a((Object) this.id, (Object) topComment.id) && k.a((Object) this.createdBy, (Object) topComment.createdBy) && k.a((Object) this.text, (Object) topComment.text) && k.a((Object) this.createdAt, (Object) topComment.createdAt);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        TopCommentCreatedBy topCommentCreatedBy = this.createdBy;
        int hashCode2 = (hashCode + (topCommentCreatedBy != null ? topCommentCreatedBy.hashCode() : 0)) * 31;
        String str2 = this.text;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "TopComment(id=" + this.id + ", createdBy=" + this.createdBy + ", text=" + this.text + ", createdAt=" + this.createdAt + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        this.createdBy.writeToParcel(parcel, 0);
        parcel.writeString(this.text);
        parcel.writeString(this.createdAt);
    }

    public TopComment(String str, TopCommentCreatedBy topCommentCreatedBy, String str2, String str3) {
        k.c(str, "id");
        k.c(topCommentCreatedBy, "createdBy");
        k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        k.c(str3, "createdAt");
        this.id = str;
        this.createdBy = topCommentCreatedBy;
        this.text = str2;
        this.createdAt = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final TopCommentCreatedBy getCreatedBy() {
        return this.createdBy;
    }

    public final String getText() {
        return this.text;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }
}
