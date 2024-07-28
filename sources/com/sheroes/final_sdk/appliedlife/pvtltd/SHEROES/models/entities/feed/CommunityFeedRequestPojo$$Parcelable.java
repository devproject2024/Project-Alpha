package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class CommunityFeedRequestPojo$$Parcelable implements Parcelable, e<CommunityFeedRequestPojo> {
    public static final Parcelable.Creator<CommunityFeedRequestPojo$$Parcelable> CREATOR = new Parcelable.Creator<CommunityFeedRequestPojo$$Parcelable>() {
        public final CommunityFeedRequestPojo$$Parcelable createFromParcel(Parcel parcel) {
            return new CommunityFeedRequestPojo$$Parcelable(CommunityFeedRequestPojo$$Parcelable.read(parcel, new a()));
        }

        public final CommunityFeedRequestPojo$$Parcelable[] newArray(int i2) {
            return new CommunityFeedRequestPojo$$Parcelable[i2];
        }
    };
    private CommunityFeedRequestPojo communityFeedRequestPojo$$0;

    public int describeContents() {
        return 0;
    }

    public CommunityFeedRequestPojo$$Parcelable(CommunityFeedRequestPojo communityFeedRequestPojo) {
        this.communityFeedRequestPojo$$0 = communityFeedRequestPojo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.communityFeedRequestPojo$$0, parcel, i2, new a());
    }

    public static void write(CommunityFeedRequestPojo communityFeedRequestPojo, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) communityFeedRequestPojo);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) communityFeedRequestPojo));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(CommunityFeedRequestPojo.class, communityFeedRequestPojo, "nextToken"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "appVersion"));
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "deviceUniqueId"));
        Class<Double> cls4 = Double.class;
        if (b.a(BaseRequest.class, communityFeedRequestPojo, "lattitude") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Double> cls5 = Double.class;
            parcel.writeDouble(((Double) b.a(BaseRequest.class, communityFeedRequestPojo, "lattitude")).doubleValue());
        }
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "testUserType"));
        Class cls7 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, communityFeedRequestPojo, "pageNo")).intValue());
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "cloudMessagingId"));
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, communityFeedRequestPojo, "pageSize")).intValue());
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "source"));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, communityFeedRequestPojo, "lastScreenName"));
        Class<Double> cls13 = Double.class;
        if (b.a(BaseRequest.class, communityFeedRequestPojo, "longitude") == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        Class<Double> cls14 = Double.class;
        parcel.writeDouble(((Double) b.a(BaseRequest.class, communityFeedRequestPojo, "longitude")).doubleValue());
    }

    public CommunityFeedRequestPojo getParcel() {
        return this.communityFeedRequestPojo$$0;
    }

    public static CommunityFeedRequestPojo read(Parcel parcel, a aVar) {
        Double d2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CommunityFeedRequestPojo communityFeedRequestPojo = new CommunityFeedRequestPojo();
            aVar.a(a2, communityFeedRequestPojo);
            b.a(CommunityFeedRequestPojo.class, communityFeedRequestPojo, "nextToken", parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "appVersion", parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "deviceUniqueId", parcel.readString());
            Double d3 = null;
            if (parcel.readInt() < 0) {
                d2 = null;
            } else {
                d2 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, communityFeedRequestPojo, "lattitude", d2);
            b.a(BaseRequest.class, communityFeedRequestPojo, "testUserType", parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "pageNo", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, communityFeedRequestPojo, "cloudMessagingId", parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "pageSize", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, communityFeedRequestPojo, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "source", parcel.readString());
            b.a(BaseRequest.class, communityFeedRequestPojo, "lastScreenName", parcel.readString());
            if (parcel.readInt() >= 0) {
                d3 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, communityFeedRequestPojo, "longitude", d3);
            aVar.a(readInt, communityFeedRequestPojo);
            return communityFeedRequestPojo;
        } else if (!aVar.b(readInt)) {
            return (CommunityFeedRequestPojo) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
