package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj$$Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class AllCommunitiesResponse$$Parcelable implements Parcelable, e<AllCommunitiesResponse> {
    public static final Parcelable.Creator<AllCommunitiesResponse$$Parcelable> CREATOR = new Parcelable.Creator<AllCommunitiesResponse$$Parcelable>() {
        public final AllCommunitiesResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new AllCommunitiesResponse$$Parcelable(AllCommunitiesResponse$$Parcelable.read(parcel, new a()));
        }

        public final AllCommunitiesResponse$$Parcelable[] newArray(int i2) {
            return new AllCommunitiesResponse$$Parcelable[i2];
        }
    };
    private AllCommunitiesResponse allCommunitiesResponse$$0;

    public int describeContents() {
        return 0;
    }

    public AllCommunitiesResponse$$Parcelable(AllCommunitiesResponse allCommunitiesResponse) {
        this.allCommunitiesResponse$$0 = allCommunitiesResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.allCommunitiesResponse$$0, parcel, i2, new a());
    }

    public static void write(AllCommunitiesResponse allCommunitiesResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) allCommunitiesResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) allCommunitiesResponse));
        if (allCommunitiesResponse.feedDetails == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(allCommunitiesResponse.feedDetails.size());
            for (CommunityFeedSolrObj write : allCommunitiesResponse.feedDetails) {
                CommunityFeedSolrObj$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, allCommunitiesResponse, "numFound")).intValue());
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, allCommunitiesResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, allCommunitiesResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, allCommunitiesResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, allCommunitiesResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, allCommunitiesResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, allCommunitiesResponse, "status"));
    }

    public AllCommunitiesResponse getParcel() {
        return this.allCommunitiesResponse$$0;
    }

    public static AllCommunitiesResponse read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            AllCommunitiesResponse allCommunitiesResponse = new AllCommunitiesResponse();
            aVar.a(a2, allCommunitiesResponse);
            int readInt2 = parcel.readInt();
            HashMap hashMap = null;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(CommunityFeedSolrObj$$Parcelable.read(parcel, aVar));
                }
            }
            allCommunitiesResponse.feedDetails = arrayList;
            b.a(BaseResponse.class, allCommunitiesResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, allCommunitiesResponse, "start", Integer.valueOf(parcel.readInt()));
            int readInt3 = parcel.readInt();
            if (readInt3 >= 0) {
                hashMap = new HashMap(c.a(readInt3));
                for (int i3 = 0; i3 < readInt3; i3++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, allCommunitiesResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, allCommunitiesResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, allCommunitiesResponse, "status", parcel.readString());
            aVar.a(readInt, allCommunitiesResponse);
            return allCommunitiesResponse;
        } else if (!aVar.b(readInt)) {
            return (AllCommunitiesResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
