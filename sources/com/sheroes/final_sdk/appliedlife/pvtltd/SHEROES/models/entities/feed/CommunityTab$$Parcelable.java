package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class CommunityTab$$Parcelable implements Parcelable, e<CommunityTab> {
    public static final Parcelable.Creator<CommunityTab$$Parcelable> CREATOR = new Parcelable.Creator<CommunityTab$$Parcelable>() {
        public final CommunityTab$$Parcelable createFromParcel(Parcel parcel) {
            return new CommunityTab$$Parcelable(CommunityTab$$Parcelable.read(parcel, new a()));
        }

        public final CommunityTab$$Parcelable[] newArray(int i2) {
            return new CommunityTab$$Parcelable[i2];
        }
    };
    private CommunityTab communityTab$$0;

    public int describeContents() {
        return 0;
    }

    public CommunityTab$$Parcelable(CommunityTab communityTab) {
        this.communityTab$$0 = communityTab;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.communityTab$$0, parcel, i2, new a());
    }

    public static void write(CommunityTab communityTab, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) communityTab);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) communityTab));
        parcel.writeString(communityTab.dataUrl);
        parcel.writeString(communityTab.emptyImageUrl);
        parcel.writeInt(communityTab.lastModifiedByL);
        parcel.writeString(communityTab.fabIconUrl);
        parcel.writeString(communityTab.dataHtml);
        parcel.writeInt(communityTab.minAppVersionCode);
        parcel.writeInt(communityTab.isActive ? 1 : 0);
        parcel.writeString(communityTab.title);
        parcel.writeString(communityTab.type);
        parcel.writeInt(communityTab.priority);
        parcel.writeInt(communityTab.createdBy);
        parcel.writeString(communityTab.emptyTitle);
        parcel.writeString(communityTab.emptyDescription);
        parcel.writeInt(communityTab.showFabButton ? 1 : 0);
        parcel.writeInt(communityTab.id);
        parcel.writeSerializable(communityTab.lastModified);
        parcel.writeString(communityTab.fabUrl);
        parcel.writeInt(communityTab.communityId);
        parcel.writeSerializable(communityTab.mCreated);
        parcel.writeString(communityTab.key);
    }

    public CommunityTab getParcel() {
        return this.communityTab$$0;
    }

    public static CommunityTab read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CommunityTab communityTab = new CommunityTab();
            aVar.a(a2, communityTab);
            communityTab.dataUrl = parcel.readString();
            communityTab.emptyImageUrl = parcel.readString();
            communityTab.lastModifiedByL = parcel.readInt();
            communityTab.fabIconUrl = parcel.readString();
            communityTab.dataHtml = parcel.readString();
            communityTab.minAppVersionCode = parcel.readInt();
            boolean z = false;
            communityTab.isActive = parcel.readInt() == 1;
            communityTab.title = parcel.readString();
            communityTab.type = parcel.readString();
            communityTab.priority = parcel.readInt();
            communityTab.createdBy = parcel.readInt();
            communityTab.emptyTitle = parcel.readString();
            communityTab.emptyDescription = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            }
            communityTab.showFabButton = z;
            communityTab.id = parcel.readInt();
            communityTab.lastModified = (Date) parcel.readSerializable();
            communityTab.fabUrl = parcel.readString();
            communityTab.communityId = parcel.readInt();
            communityTab.mCreated = (Date) parcel.readSerializable();
            communityTab.key = parcel.readString();
            aVar.a(readInt, communityTab);
            return communityTab;
        } else if (!aVar.b(readInt)) {
            return (CommunityTab) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
