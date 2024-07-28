package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class GetAllDataRequest$$Parcelable implements Parcelable, e<GetAllDataRequest> {
    public static final Parcelable.Creator<GetAllDataRequest$$Parcelable> CREATOR = new Parcelable.Creator<GetAllDataRequest$$Parcelable>() {
        public final GetAllDataRequest$$Parcelable createFromParcel(Parcel parcel) {
            return new GetAllDataRequest$$Parcelable(GetAllDataRequest$$Parcelable.read(parcel, new a()));
        }

        public final GetAllDataRequest$$Parcelable[] newArray(int i2) {
            return new GetAllDataRequest$$Parcelable[i2];
        }
    };
    private GetAllDataRequest getAllDataRequest$$0;

    public int describeContents() {
        return 0;
    }

    public GetAllDataRequest$$Parcelable(GetAllDataRequest getAllDataRequest) {
        this.getAllDataRequest$$0 = getAllDataRequest;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.getAllDataRequest$$0, parcel, i2, new a());
    }

    public static void write(GetAllDataRequest getAllDataRequest, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) getAllDataRequest);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) getAllDataRequest));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(GetAllDataRequest.class, getAllDataRequest, "q"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(GetAllDataRequest.class, getAllDataRequest, "masterDataType"));
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "appVersion"));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "deviceUniqueId"));
        Class<Double> cls5 = Double.class;
        if (b.a(BaseRequest.class, getAllDataRequest, "lattitude") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Double> cls6 = Double.class;
            parcel.writeDouble(((Double) b.a(BaseRequest.class, getAllDataRequest, "lattitude")).doubleValue());
        }
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "testUserType"));
        Class cls8 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, getAllDataRequest, "pageNo")).intValue());
        Class<String> cls9 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "cloudMessagingId"));
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, getAllDataRequest, "pageSize")).intValue());
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "source"));
        Class<String> cls13 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, getAllDataRequest, "lastScreenName"));
        Class<Double> cls14 = Double.class;
        if (b.a(BaseRequest.class, getAllDataRequest, "longitude") == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        Class<Double> cls15 = Double.class;
        parcel.writeDouble(((Double) b.a(BaseRequest.class, getAllDataRequest, "longitude")).doubleValue());
    }

    public GetAllDataRequest getParcel() {
        return this.getAllDataRequest$$0;
    }

    public static GetAllDataRequest read(Parcel parcel, a aVar) {
        Double d2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            GetAllDataRequest getAllDataRequest = new GetAllDataRequest();
            aVar.a(a2, getAllDataRequest);
            b.a(GetAllDataRequest.class, getAllDataRequest, "q", parcel.readString());
            b.a(GetAllDataRequest.class, getAllDataRequest, "masterDataType", parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "appVersion", parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "deviceUniqueId", parcel.readString());
            Double d3 = null;
            if (parcel.readInt() < 0) {
                d2 = null;
            } else {
                d2 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, getAllDataRequest, "lattitude", d2);
            b.a(BaseRequest.class, getAllDataRequest, "testUserType", parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "pageNo", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, getAllDataRequest, "cloudMessagingId", parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "pageSize", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, getAllDataRequest, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "source", parcel.readString());
            b.a(BaseRequest.class, getAllDataRequest, "lastScreenName", parcel.readString());
            if (parcel.readInt() >= 0) {
                d3 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, getAllDataRequest, "longitude", d3);
            aVar.a(readInt, getAllDataRequest);
            return getAllDataRequest;
        } else if (!aVar.b(readInt)) {
            return (GetAllDataRequest) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
