package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class LastComment$$Parcelable implements Parcelable, e<LastComment> {
    public static final Parcelable.Creator<LastComment$$Parcelable> CREATOR = new Parcelable.Creator<LastComment$$Parcelable>() {
        public final LastComment$$Parcelable createFromParcel(Parcel parcel) {
            return new LastComment$$Parcelable(LastComment$$Parcelable.read(parcel, new a()));
        }

        public final LastComment$$Parcelable[] newArray(int i2) {
            return new LastComment$$Parcelable[i2];
        }
    };
    private LastComment lastComment$$0;

    public int describeContents() {
        return 0;
    }

    public LastComment$$Parcelable(LastComment lastComment) {
        this.lastComment$$0 = lastComment;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.lastComment$$0, parcel, i2, new a());
    }

    public static void write(LastComment lastComment, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) lastComment);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) lastComment));
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "likeValue")).intValue());
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "entityId")).intValue());
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LastComment.class, lastComment, "isActive")).booleanValue() ? 1 : 0);
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(LastComment.class, lastComment, "createdOn"));
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(LastComment.class, lastComment, "lastModifiedOn"));
        Class cls6 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "participantId")).intValue());
        Class cls7 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LastComment.class, lastComment, "isVerifiedMentor")).booleanValue() ? 1 : 0);
        Class cls8 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LastComment.class, lastComment, "myOwnParticipation")).booleanValue() ? 1 : 0);
        Class cls9 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LastComment.class, lastComment, "isAnonymous")).booleanValue() ? 1 : 0);
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "commentsId")).intValue());
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(LastComment.class, lastComment, "participantImageUrl"));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(LastComment.class, lastComment, CJRQRScanResultModel.KEY_COMMENT_SMALL));
        Class cls13 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "id")).intValue());
        Class cls14 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "participationTypeId")).intValue());
        Class<String> cls15 = String.class;
        parcel.writeString((String) b.a(LastComment.class, lastComment, "participantName"));
        Class cls16 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(LastComment.class, lastComment, "entityAuthorUserIdL")).intValue());
    }

    public LastComment getParcel() {
        return this.lastComment$$0;
    }

    public static LastComment read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            LastComment lastComment = new LastComment();
            aVar.a(a2, lastComment);
            b.a(LastComment.class, lastComment, "likeValue", Integer.valueOf(parcel.readInt()));
            b.a(LastComment.class, lastComment, "entityId", Integer.valueOf(parcel.readInt()));
            boolean z = false;
            b.a(LastComment.class, lastComment, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(LastComment.class, lastComment, "createdOn", parcel.readString());
            b.a(LastComment.class, lastComment, "lastModifiedOn", parcel.readString());
            b.a(LastComment.class, lastComment, "participantId", Integer.valueOf(parcel.readInt()));
            b.a(LastComment.class, lastComment, "isVerifiedMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(LastComment.class, lastComment, "myOwnParticipation", Boolean.valueOf(parcel.readInt() == 1));
            Class<LastComment> cls = LastComment.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, lastComment, "isAnonymous", Boolean.valueOf(z));
            b.a(LastComment.class, lastComment, "commentsId", Integer.valueOf(parcel.readInt()));
            b.a(LastComment.class, lastComment, "participantImageUrl", parcel.readString());
            b.a(LastComment.class, lastComment, CJRQRScanResultModel.KEY_COMMENT_SMALL, parcel.readString());
            b.a(LastComment.class, lastComment, "id", Integer.valueOf(parcel.readInt()));
            b.a(LastComment.class, lastComment, "participationTypeId", Integer.valueOf(parcel.readInt()));
            b.a(LastComment.class, lastComment, "participantName", parcel.readString());
            b.a(LastComment.class, lastComment, "entityAuthorUserIdL", Integer.valueOf(parcel.readInt()));
            aVar.a(readInt, lastComment);
            return lastComment;
        } else if (!aVar.b(readInt)) {
            return (LastComment) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
