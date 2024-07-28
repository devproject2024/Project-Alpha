package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

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

public class SelectedCommunityResponse$$Parcelable implements Parcelable, e<SelectedCommunityResponse> {
    public static final Parcelable.Creator<SelectedCommunityResponse$$Parcelable> CREATOR = new Parcelable.Creator<SelectedCommunityResponse$$Parcelable>() {
        public final SelectedCommunityResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new SelectedCommunityResponse$$Parcelable(SelectedCommunityResponse$$Parcelable.read(parcel, new a()));
        }

        public final SelectedCommunityResponse$$Parcelable[] newArray(int i2) {
            return new SelectedCommunityResponse$$Parcelable[i2];
        }
    };
    private SelectedCommunityResponse selectedCommunityResponse$$0;

    public int describeContents() {
        return 0;
    }

    public SelectedCommunityResponse$$Parcelable(SelectedCommunityResponse selectedCommunityResponse) {
        this.selectedCommunityResponse$$0 = selectedCommunityResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.selectedCommunityResponse$$0, parcel, i2, new a());
    }

    public static void write(SelectedCommunityResponse selectedCommunityResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) selectedCommunityResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) selectedCommunityResponse));
        new b.C0602b();
        if (b.a(SelectedCommunityResponse.class, selectedCommunityResponse, "docs") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(SelectedCommunityResponse.class, selectedCommunityResponse, "docs")).size());
            new b.C0602b();
            for (CommunityPostResponse write : (List) b.a(SelectedCommunityResponse.class, selectedCommunityResponse, "docs")) {
                CommunityPostResponse$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, selectedCommunityResponse, "numFound")).intValue());
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, selectedCommunityResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, selectedCommunityResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, selectedCommunityResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, selectedCommunityResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, selectedCommunityResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, selectedCommunityResponse, "status"));
    }

    public SelectedCommunityResponse getParcel() {
        return this.selectedCommunityResponse$$0;
    }

    public static SelectedCommunityResponse read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            SelectedCommunityResponse selectedCommunityResponse = new SelectedCommunityResponse();
            aVar.a(a2, selectedCommunityResponse);
            int readInt2 = parcel.readInt();
            HashMap hashMap = null;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(CommunityPostResponse$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(SelectedCommunityResponse.class, selectedCommunityResponse, "docs", arrayList);
            b.a(BaseResponse.class, selectedCommunityResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, selectedCommunityResponse, "start", Integer.valueOf(parcel.readInt()));
            int readInt3 = parcel.readInt();
            if (readInt3 >= 0) {
                hashMap = new HashMap(c.a(readInt3));
                for (int i3 = 0; i3 < readInt3; i3++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, selectedCommunityResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, selectedCommunityResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, selectedCommunityResponse, "status", parcel.readString());
            aVar.a(readInt, selectedCommunityResponse);
            return selectedCommunityResponse;
        } else if (!aVar.b(readInt)) {
            return (SelectedCommunityResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
