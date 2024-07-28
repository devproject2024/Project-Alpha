package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like;

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

public class LikeResponse$$Parcelable implements Parcelable, e<LikeResponse> {
    public static final Parcelable.Creator<LikeResponse$$Parcelable> CREATOR = new Parcelable.Creator<LikeResponse$$Parcelable>() {
        public final LikeResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new LikeResponse$$Parcelable(LikeResponse$$Parcelable.read(parcel, new a()));
        }

        public final LikeResponse$$Parcelable[] newArray(int i2) {
            return new LikeResponse$$Parcelable[i2];
        }
    };
    private LikeResponse likeResponse$$0;

    public int describeContents() {
        return 0;
    }

    public LikeResponse$$Parcelable(LikeResponse likeResponse) {
        this.likeResponse$$0 = likeResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.likeResponse$$0, parcel, i2, new a());
    }

    public static void write(LikeResponse likeResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) likeResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) likeResponse));
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, likeResponse, "numFound")).intValue());
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, likeResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, likeResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, likeResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, likeResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, likeResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, likeResponse, "status"));
    }

    public LikeResponse getParcel() {
        return this.likeResponse$$0;
    }

    public static LikeResponse read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            LikeResponse likeResponse = new LikeResponse();
            aVar.a(a2, likeResponse);
            b.a(BaseResponse.class, likeResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, likeResponse, "start", Integer.valueOf(parcel.readInt()));
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
            b.a(BaseResponse.class, likeResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, likeResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, likeResponse, "status", parcel.readString());
            aVar.a(readInt, likeResponse);
            return likeResponse;
        } else if (!aVar.b(readInt)) {
            return (LikeResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
