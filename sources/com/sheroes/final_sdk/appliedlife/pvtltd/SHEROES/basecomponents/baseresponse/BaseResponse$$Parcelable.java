package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class BaseResponse$$Parcelable implements Parcelable, e<BaseResponse> {
    public static final Parcelable.Creator<BaseResponse$$Parcelable> CREATOR = new Parcelable.Creator<BaseResponse$$Parcelable>() {
        public final BaseResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new BaseResponse$$Parcelable(BaseResponse$$Parcelable.read(parcel, new a()));
        }

        public final BaseResponse$$Parcelable[] newArray(int i2) {
            return new BaseResponse$$Parcelable[i2];
        }
    };
    private BaseResponse baseResponse$$0;

    public int describeContents() {
        return 0;
    }

    public BaseResponse$$Parcelable(BaseResponse baseResponse) {
        this.baseResponse$$0 = baseResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.baseResponse$$0, parcel, i2, new a());
    }

    public static void write(BaseResponse baseResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) baseResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) baseResponse));
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, baseResponse, "numFound")).intValue());
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, baseResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, baseResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, baseResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, baseResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, baseResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, baseResponse, "status"));
    }

    public BaseResponse getParcel() {
        return this.baseResponse$$0;
    }

    public static BaseResponse read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            BaseResponse baseResponse = new BaseResponse();
            aVar.a(a2, baseResponse);
            b.a(BaseResponse.class, baseResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, baseResponse, "start", Integer.valueOf(parcel.readInt()));
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
            b.a(BaseResponse.class, baseResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, baseResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, baseResponse, "status", parcel.readString());
            aVar.a(readInt, baseResponse);
            return baseResponse;
        } else if (!aVar.b(readInt)) {
            return (BaseResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
