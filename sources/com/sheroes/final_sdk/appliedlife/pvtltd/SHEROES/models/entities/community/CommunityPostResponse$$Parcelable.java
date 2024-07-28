package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class CommunityPostResponse$$Parcelable implements Parcelable, e<CommunityPostResponse> {
    public static final Parcelable.Creator<CommunityPostResponse$$Parcelable> CREATOR = new Parcelable.Creator<CommunityPostResponse$$Parcelable>() {
        public final CommunityPostResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new CommunityPostResponse$$Parcelable(CommunityPostResponse$$Parcelable.read(parcel, new a()));
        }

        public final CommunityPostResponse$$Parcelable[] newArray(int i2) {
            return new CommunityPostResponse$$Parcelable[i2];
        }
    };
    private CommunityPostResponse communityPostResponse$$0;

    public int describeContents() {
        return 0;
    }

    public CommunityPostResponse$$Parcelable(CommunityPostResponse communityPostResponse) {
        this.communityPostResponse$$0 = communityPostResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.communityPostResponse$$0, parcel, i2, new a());
    }

    public static void write(CommunityPostResponse communityPostResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) communityPostResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) communityPostResponse));
        Class cls = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityPostResponse.class, communityPostResponse, "isOwner")).booleanValue() ? 1 : 0);
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(CommunityPostResponse.class, communityPostResponse, "logo"));
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(CommunityPostResponse.class, communityPostResponse, "community_type"));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(CommunityPostResponse.class, communityPostResponse, "id"));
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(CommunityPostResponse.class, communityPostResponse, "title"));
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(CommunityPostResponse.class, communityPostResponse, "category"));
        Class cls7 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityPostResponse.class, communityPostResponse, "isClosedCommunity")).booleanValue() ? 1 : 0);
        Class cls8 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, communityPostResponse, "numFound")).intValue());
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, communityPostResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, communityPostResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, communityPostResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, communityPostResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, communityPostResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, communityPostResponse, "status"));
    }

    public CommunityPostResponse getParcel() {
        return this.communityPostResponse$$0;
    }

    public static CommunityPostResponse read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CommunityPostResponse communityPostResponse = new CommunityPostResponse();
            aVar.a(a2, communityPostResponse);
            boolean z = true;
            b.a(CommunityPostResponse.class, communityPostResponse, "isOwner", Boolean.valueOf(parcel.readInt() == 1));
            b.a(CommunityPostResponse.class, communityPostResponse, "logo", parcel.readString());
            b.a(CommunityPostResponse.class, communityPostResponse, "community_type", parcel.readString());
            b.a(CommunityPostResponse.class, communityPostResponse, "id", parcel.readString());
            b.a(CommunityPostResponse.class, communityPostResponse, "title", parcel.readString());
            b.a(CommunityPostResponse.class, communityPostResponse, "category", parcel.readString());
            Class<CommunityPostResponse> cls = CommunityPostResponse.class;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, communityPostResponse, "isClosedCommunity", Boolean.valueOf(z));
            b.a(BaseResponse.class, communityPostResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, communityPostResponse, "start", Integer.valueOf(parcel.readInt()));
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap(c.a(readInt2));
                for (int i2 = 0; i2 < readInt2; i2++) {
                    hashMap2.put(parcel.readString(), parcel.readString());
                }
                hashMap = hashMap2;
            }
            b.a(BaseResponse.class, communityPostResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, communityPostResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, communityPostResponse, "status", parcel.readString());
            aVar.a(readInt, communityPostResponse);
            return communityPostResponse;
        } else if (!aVar.b(readInt)) {
            return (CommunityPostResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
