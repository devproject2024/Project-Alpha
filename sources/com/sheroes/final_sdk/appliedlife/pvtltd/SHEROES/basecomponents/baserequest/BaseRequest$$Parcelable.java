package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest;

import android.os.Parcel;
import android.os.Parcelable;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class BaseRequest$$Parcelable implements Parcelable, e<BaseRequest> {
    public static final Parcelable.Creator<BaseRequest$$Parcelable> CREATOR = new Parcelable.Creator<BaseRequest$$Parcelable>() {
        public final BaseRequest$$Parcelable createFromParcel(Parcel parcel) {
            return new BaseRequest$$Parcelable(BaseRequest$$Parcelable.read(parcel, new a()));
        }

        public final BaseRequest$$Parcelable[] newArray(int i2) {
            return new BaseRequest$$Parcelable[i2];
        }
    };
    private BaseRequest baseRequest$$0;

    public int describeContents() {
        return 0;
    }

    public BaseRequest$$Parcelable(BaseRequest baseRequest) {
        this.baseRequest$$0 = baseRequest;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.baseRequest$$0, parcel, i2, new a());
    }

    public static void write(BaseRequest baseRequest, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) baseRequest);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) baseRequest));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "appVersion"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "deviceUniqueId"));
        Class<Double> cls3 = Double.class;
        if (b.a(BaseRequest.class, baseRequest, "lattitude") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Double> cls4 = Double.class;
            parcel.writeDouble(((Double) b.a(BaseRequest.class, baseRequest, "lattitude")).doubleValue());
        }
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "testUserType"));
        Class cls6 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, baseRequest, "pageNo")).intValue());
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "cloudMessagingId"));
        Class cls8 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, baseRequest, "pageSize")).intValue());
        Class<String> cls9 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "source"));
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, baseRequest, "lastScreenName"));
        Class<Double> cls12 = Double.class;
        if (b.a(BaseRequest.class, baseRequest, "longitude") == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        Class<Double> cls13 = Double.class;
        parcel.writeDouble(((Double) b.a(BaseRequest.class, baseRequest, "longitude")).doubleValue());
    }

    public BaseRequest getParcel() {
        return this.baseRequest$$0;
    }

    public static BaseRequest read(Parcel parcel, a aVar) {
        Double d2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            BaseRequest baseRequest = new BaseRequest();
            aVar.a(a2, baseRequest);
            b.a(BaseRequest.class, baseRequest, "appVersion", parcel.readString());
            b.a(BaseRequest.class, baseRequest, "deviceUniqueId", parcel.readString());
            Double d3 = null;
            if (parcel.readInt() < 0) {
                d2 = null;
            } else {
                d2 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, baseRequest, "lattitude", d2);
            b.a(BaseRequest.class, baseRequest, "testUserType", parcel.readString());
            b.a(BaseRequest.class, baseRequest, "pageNo", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, baseRequest, "cloudMessagingId", parcel.readString());
            b.a(BaseRequest.class, baseRequest, "pageSize", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, baseRequest, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseRequest.class, baseRequest, "source", parcel.readString());
            b.a(BaseRequest.class, baseRequest, "lastScreenName", parcel.readString());
            if (parcel.readInt() >= 0) {
                d3 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, baseRequest, "longitude", d3);
            aVar.a(readInt, baseRequest);
            return baseRequest;
        } else if (!aVar.b(readInt)) {
            return (BaseRequest) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
