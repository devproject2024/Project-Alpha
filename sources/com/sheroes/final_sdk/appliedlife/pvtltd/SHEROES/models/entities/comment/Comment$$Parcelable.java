package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class Comment$$Parcelable implements Parcelable, e<Comment> {
    public static final Parcelable.Creator<Comment$$Parcelable> CREATOR = new Parcelable.Creator<Comment$$Parcelable>() {
        public final Comment$$Parcelable createFromParcel(Parcel parcel) {
            return new Comment$$Parcelable(Comment$$Parcelable.read(parcel, new a()));
        }

        public final Comment$$Parcelable[] newArray(int i2) {
            return new Comment$$Parcelable[i2];
        }
    };
    private Comment comment$$0;

    public int describeContents() {
        return 0;
    }

    public Comment$$Parcelable(Comment comment) {
        this.comment$$0 = comment;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.comment$$0, parcel, i2, new a());
    }

    public static void write(Comment comment, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) comment);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) comment));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "city"));
        Class<Long> cls2 = Long.class;
        if (b.a(Comment.class, comment, "entityAuthorUserId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls3 = Long.class;
            parcel.writeLong(((Long) b.a(Comment.class, comment, "entityAuthorUserId")).longValue());
        }
        parcel.writeInt(comment.likeCount);
        Class cls4 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(Comment.class, comment, "isActive")).booleanValue() ? 1 : 0);
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "createdOn"));
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "postedDate"));
        Class cls7 = Long.TYPE;
        parcel.writeLong(((Long) b.a(Comment.class, comment, "participantId")).longValue());
        Class cls8 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(Comment.class, comment, "participantActive")).booleanValue() ? 1 : 0);
        parcel.writeInt(comment.itemPosition);
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(Comment.class, comment, "id")).intValue());
        Class cls10 = Long.TYPE;
        parcel.writeLong(((Long) b.a(Comment.class, comment, "participationTypeId")).longValue());
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "communityId"));
        Class cls12 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(Comment.class, comment, "likeValue")).intValue());
        Class<Long> cls13 = Long.class;
        if (b.a(Comment.class, comment, "participantUserId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls14 = Long.class;
            parcel.writeLong(((Long) b.a(Comment.class, comment, "participantUserId")).longValue());
        }
        parcel.writeInt(comment.isLiked ? 1 : 0);
        Class cls15 = Long.TYPE;
        parcel.writeLong(((Long) b.a(Comment.class, comment, "entityId")).longValue());
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "lastModifiedOn"));
        Class cls17 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(Comment.class, comment, "isVerifiedMentor")).booleanValue() ? 1 : 0);
        Class cls18 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(Comment.class, comment, "myOwnParticipation")).booleanValue() ? 1 : 0);
        Class cls19 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(Comment.class, comment, "isAnonymous")).booleanValue() ? 1 : 0);
        parcel.writeInt(comment.isEdit ? 1 : 0);
        parcel.writeInt(comment.byDefaultMenuOpen);
        Class cls20 = Long.TYPE;
        parcel.writeLong(((Long) b.a(Comment.class, comment, "commentsId")).longValue());
        Class<String> cls21 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "participantImageUrl"));
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, CJRQRScanResultModel.KEY_COMMENT_SMALL));
        Class<String> cls23 = String.class;
        parcel.writeString((String) b.a(Comment.class, comment, "participantName"));
        Class cls24 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, comment, "numFound")).intValue());
        Class cls25 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, comment, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, comment, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, comment, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, comment, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls26 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, comment, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls27 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, comment, "status"));
    }

    public Comment getParcel() {
        return this.comment$$0;
    }

    public static Comment read(Parcel parcel, a aVar) {
        Long l;
        Long l2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Comment comment = new Comment();
            aVar.a(a2, comment);
            b.a(Comment.class, comment, "city", parcel.readString());
            HashMap hashMap = null;
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            b.a(Comment.class, comment, "entityAuthorUserId", l);
            comment.likeCount = parcel.readInt();
            boolean z = true;
            b.a(Comment.class, comment, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(Comment.class, comment, "createdOn", parcel.readString());
            b.a(Comment.class, comment, "postedDate", parcel.readString());
            b.a(Comment.class, comment, "participantId", Long.valueOf(parcel.readLong()));
            b.a(Comment.class, comment, "participantActive", Boolean.valueOf(parcel.readInt() == 1));
            comment.itemPosition = parcel.readInt();
            b.a(Comment.class, comment, "id", Integer.valueOf(parcel.readInt()));
            b.a(Comment.class, comment, "participationTypeId", Long.valueOf(parcel.readLong()));
            b.a(Comment.class, comment, "communityId", parcel.readString());
            b.a(Comment.class, comment, "likeValue", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                l2 = null;
            } else {
                l2 = Long.valueOf(parcel.readLong());
            }
            b.a(Comment.class, comment, "participantUserId", l2);
            comment.isLiked = parcel.readInt() == 1;
            b.a(Comment.class, comment, "entityId", Long.valueOf(parcel.readLong()));
            b.a(Comment.class, comment, "lastModifiedOn", parcel.readString());
            b.a(Comment.class, comment, "isVerifiedMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(Comment.class, comment, "myOwnParticipation", Boolean.valueOf(parcel.readInt() == 1));
            b.a(Comment.class, comment, "isAnonymous", Boolean.valueOf(parcel.readInt() == 1));
            if (parcel.readInt() != 1) {
                z = false;
            }
            comment.isEdit = z;
            comment.byDefaultMenuOpen = parcel.readInt();
            b.a(Comment.class, comment, "commentsId", Long.valueOf(parcel.readLong()));
            b.a(Comment.class, comment, "participantImageUrl", parcel.readString());
            b.a(Comment.class, comment, CJRQRScanResultModel.KEY_COMMENT_SMALL, parcel.readString());
            b.a(Comment.class, comment, "participantName", parcel.readString());
            b.a(BaseResponse.class, comment, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, comment, "start", Integer.valueOf(parcel.readInt()));
            int readInt2 = parcel.readInt();
            if (readInt2 >= 0) {
                hashMap = new HashMap(c.a(readInt2));
                for (int i2 = 0; i2 < readInt2; i2++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, comment, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, comment, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, comment, "status", parcel.readString());
            aVar.a(readInt, comment);
            return comment;
        } else if (!aVar.b(readInt)) {
            return (Comment) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
