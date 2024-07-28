package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class FeedResponsePojo$$Parcelable implements Parcelable, e<FeedResponsePojo> {
    public static final Parcelable.Creator<FeedResponsePojo$$Parcelable> CREATOR = new Parcelable.Creator<FeedResponsePojo$$Parcelable>() {
        public final FeedResponsePojo$$Parcelable createFromParcel(Parcel parcel) {
            return new FeedResponsePojo$$Parcelable(FeedResponsePojo$$Parcelable.read(parcel, new a()));
        }

        public final FeedResponsePojo$$Parcelable[] newArray(int i2) {
            return new FeedResponsePojo$$Parcelable[i2];
        }
    };
    private FeedResponsePojo feedResponsePojo$$0;

    public int describeContents() {
        return 0;
    }

    public FeedResponsePojo$$Parcelable(FeedResponsePojo feedResponsePojo) {
        this.feedResponsePojo$$0 = feedResponsePojo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.feedResponsePojo$$0, parcel, i2, new a());
    }

    public static void write(FeedResponsePojo feedResponsePojo, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) feedResponsePojo);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) feedResponsePojo));
        Class<Integer> cls = Integer.class;
        if (b.a(FeedResponsePojo.class, feedResponsePojo, "serverFeedConfigVersion") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls2 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedResponsePojo.class, feedResponsePojo, "serverFeedConfigVersion")).intValue());
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(FeedResponsePojo.class, feedResponsePojo, "nextToken"));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(FeedResponsePojo.class, feedResponsePojo, "setOrderKey"));
        new b.C0602b();
        if (b.a(FeedResponsePojo.class, feedResponsePojo, "featuredDocs") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedResponsePojo.class, feedResponsePojo, "featuredDocs")).size());
            new b.C0602b();
            for (FeedDetail write : (List) b.a(FeedResponsePojo.class, feedResponsePojo, "featuredDocs")) {
                FeedDetail$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedResponsePojo.class, feedResponsePojo, "feedDetails") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedResponsePojo.class, feedResponsePojo, "feedDetails")).size());
            new b.C0602b();
            for (FeedDetail write2 : (List) b.a(FeedResponsePojo.class, feedResponsePojo, "feedDetails")) {
                FeedDetail$$Parcelable.write(write2, parcel, i2, aVar);
            }
        }
        Class cls5 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, feedResponsePojo, "numFound")).intValue());
        Class cls6 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, feedResponsePojo, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, feedResponsePojo, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, feedResponsePojo, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, feedResponsePojo, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, feedResponsePojo, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, feedResponsePojo, "status"));
    }

    public FeedResponsePojo getParcel() {
        return this.feedResponsePojo$$0;
    }

    public static FeedResponsePojo read(Parcel parcel, a aVar) {
        Integer num;
        ArrayList arrayList;
        ArrayList arrayList2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            FeedResponsePojo feedResponsePojo = new FeedResponsePojo();
            aVar.a(a2, feedResponsePojo);
            HashMap hashMap = null;
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedResponsePojo.class, feedResponsePojo, "serverFeedConfigVersion", num);
            b.a(FeedResponsePojo.class, feedResponsePojo, "nextToken", parcel.readString());
            b.a(FeedResponsePojo.class, feedResponsePojo, "setOrderKey", parcel.readString());
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(FeedDetail$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedResponsePojo.class, feedResponsePojo, "featuredDocs", arrayList);
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(FeedDetail$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedResponsePojo.class, feedResponsePojo, "feedDetails", arrayList2);
            b.a(BaseResponse.class, feedResponsePojo, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, feedResponsePojo, "start", Integer.valueOf(parcel.readInt()));
            int readInt4 = parcel.readInt();
            if (readInt4 >= 0) {
                hashMap = new HashMap(c.a(readInt4));
                for (int i4 = 0; i4 < readInt4; i4++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, feedResponsePojo, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, feedResponsePojo, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, feedResponsePojo, "status", parcel.readString());
            aVar.a(readInt, feedResponsePojo);
            return feedResponsePojo;
        } else if (!aVar.b(readInt)) {
            return (FeedResponsePojo) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
