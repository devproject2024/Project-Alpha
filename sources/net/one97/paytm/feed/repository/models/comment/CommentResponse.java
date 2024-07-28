package net.one97.paytm.feed.repository.models.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.upi.util.UpiConstants;

public final class CommentResponse extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String createdAt;
    private final CreatedBy createdBy;
    private final boolean edited;
    private final int flagCount;
    private final String id;
    private Boolean isSensitive;
    private String moderationType;
    private final String postId;
    private String text;
    private final String updatedAt;
    private final String userId;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            k.c(parcel, "in");
            String readString = parcel.readString();
            CreatedBy createdBy = (CreatedBy) CreatedBy.CREATOR.createFromParcel(parcel);
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return new CommentResponse(readString, createdBy, z2, readInt, readString2, readString3, readString4, readString5, readString6, readString7, bool);
        }

        public final Object[] newArray(int i2) {
            return new CommentResponse[i2];
        }
    }

    public static /* synthetic */ CommentResponse copy$default(CommentResponse commentResponse, String str, CreatedBy createdBy2, boolean z, int i2, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i3, Object obj) {
        CommentResponse commentResponse2 = commentResponse;
        int i4 = i3;
        return commentResponse.copy((i4 & 1) != 0 ? commentResponse2.createdAt : str, (i4 & 2) != 0 ? commentResponse2.createdBy : createdBy2, (i4 & 4) != 0 ? commentResponse2.edited : z, (i4 & 8) != 0 ? commentResponse2.flagCount : i2, (i4 & 16) != 0 ? commentResponse2.id : str2, (i4 & 32) != 0 ? commentResponse2.moderationType : str3, (i4 & 64) != 0 ? commentResponse2.postId : str4, (i4 & 128) != 0 ? commentResponse2.text : str5, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? commentResponse2.updatedAt : str6, (i4 & 512) != 0 ? commentResponse2.userId : str7, (i4 & TarConstants.EOF_BLOCK) != 0 ? commentResponse2.isSensitive : bool);
    }

    public final String component1() {
        return this.createdAt;
    }

    public final String component10() {
        return this.userId;
    }

    public final Boolean component11() {
        return this.isSensitive;
    }

    public final CreatedBy component2() {
        return this.createdBy;
    }

    public final boolean component3() {
        return this.edited;
    }

    public final int component4() {
        return this.flagCount;
    }

    public final String component5() {
        return this.id;
    }

    public final String component6() {
        return this.moderationType;
    }

    public final String component7() {
        return this.postId;
    }

    public final String component8() {
        return this.text;
    }

    public final String component9() {
        return this.updatedAt;
    }

    public final CommentResponse copy(String str, CreatedBy createdBy2, boolean z, int i2, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool) {
        k.c(str, "createdAt");
        k.c(createdBy2, "createdBy");
        String str8 = str2;
        k.c(str8, "id");
        String str9 = str3;
        k.c(str9, "moderationType");
        String str10 = str4;
        k.c(str10, "postId");
        String str11 = str5;
        k.c(str11, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        String str12 = str6;
        k.c(str12, "updatedAt");
        String str13 = str7;
        k.c(str13, "userId");
        return new CommentResponse(str, createdBy2, z, i2, str8, str9, str10, str11, str12, str13, bool);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CommentResponse) {
                CommentResponse commentResponse = (CommentResponse) obj;
                if (k.a((Object) this.createdAt, (Object) commentResponse.createdAt) && k.a((Object) this.createdBy, (Object) commentResponse.createdBy)) {
                    if (this.edited == commentResponse.edited) {
                        if (!(this.flagCount == commentResponse.flagCount) || !k.a((Object) this.id, (Object) commentResponse.id) || !k.a((Object) this.moderationType, (Object) commentResponse.moderationType) || !k.a((Object) this.postId, (Object) commentResponse.postId) || !k.a((Object) this.text, (Object) commentResponse.text) || !k.a((Object) this.updatedAt, (Object) commentResponse.updatedAt) || !k.a((Object) this.userId, (Object) commentResponse.userId) || !k.a((Object) this.isSensitive, (Object) commentResponse.isSensitive)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.createdAt;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CreatedBy createdBy2 = this.createdBy;
        int hashCode2 = (hashCode + (createdBy2 != null ? createdBy2.hashCode() : 0)) * 31;
        boolean z = this.edited;
        if (z) {
            z = true;
        }
        int hashCode3 = (((hashCode2 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.flagCount).hashCode()) * 31;
        String str2 = this.id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.moderationType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.postId;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.text;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.updatedAt;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.userId;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Boolean bool = this.isSensitive;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "CommentResponse(createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", edited=" + this.edited + ", flagCount=" + this.flagCount + ", id=" + this.id + ", moderationType=" + this.moderationType + ", postId=" + this.postId + ", text=" + this.text + ", updatedAt=" + this.updatedAt + ", userId=" + this.userId + ", isSensitive=" + this.isSensitive + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.createdAt);
        this.createdBy.writeToParcel(parcel, 0);
        parcel.writeInt(this.edited ? 1 : 0);
        parcel.writeInt(this.flagCount);
        parcel.writeString(this.id);
        parcel.writeString(this.moderationType);
        parcel.writeString(this.postId);
        parcel.writeString(this.text);
        parcel.writeString(this.updatedAt);
        parcel.writeString(this.userId);
        Boolean bool = this.isSensitive;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final CreatedBy getCreatedBy() {
        return this.createdBy;
    }

    public final boolean getEdited() {
        return this.edited;
    }

    public final int getFlagCount() {
        return this.flagCount;
    }

    public final String getId() {
        return this.id;
    }

    public final String getModerationType() {
        return this.moderationType;
    }

    public final void setModerationType(String str) {
        k.c(str, "<set-?>");
        this.moderationType = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        k.c(str, "<set-?>");
        this.text = str;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isSensitive() {
        return this.isSensitive;
    }

    public final void setSensitive(Boolean bool) {
        this.isSensitive = bool;
    }

    public CommentResponse(String str, CreatedBy createdBy2, boolean z, int i2, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool) {
        k.c(str, "createdAt");
        k.c(createdBy2, "createdBy");
        k.c(str2, "id");
        k.c(str3, "moderationType");
        k.c(str4, "postId");
        k.c(str5, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        k.c(str6, "updatedAt");
        k.c(str7, "userId");
        this.createdAt = str;
        this.createdBy = createdBy2;
        this.edited = z;
        this.flagCount = i2;
        this.id = str2;
        this.moderationType = str3;
        this.postId = str4;
        this.text = str5;
        this.updatedAt = str6;
        this.userId = str7;
        this.isSensitive = bool;
    }
}
