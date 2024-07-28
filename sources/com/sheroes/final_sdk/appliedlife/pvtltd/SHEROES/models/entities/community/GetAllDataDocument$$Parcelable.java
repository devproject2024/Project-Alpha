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

public class GetAllDataDocument$$Parcelable implements Parcelable, e<GetAllDataDocument> {
    public static final Parcelable.Creator<GetAllDataDocument$$Parcelable> CREATOR = new Parcelable.Creator<GetAllDataDocument$$Parcelable>() {
        public final GetAllDataDocument$$Parcelable createFromParcel(Parcel parcel) {
            return new GetAllDataDocument$$Parcelable(GetAllDataDocument$$Parcelable.read(parcel, new a()));
        }

        public final GetAllDataDocument$$Parcelable[] newArray(int i2) {
            return new GetAllDataDocument$$Parcelable[i2];
        }
    };
    private GetAllDataDocument getAllDataDocument$$0;

    public int describeContents() {
        return 0;
    }

    public GetAllDataDocument$$Parcelable(GetAllDataDocument getAllDataDocument) {
        this.getAllDataDocument$$0 = getAllDataDocument;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.getAllDataDocument$$0, parcel, i2, new a());
    }

    public static void write(GetAllDataDocument getAllDataDocument, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) getAllDataDocument);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) getAllDataDocument));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(GetAllDataDocument.class, getAllDataDocument, "communityType"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(GetAllDataDocument.class, getAllDataDocument, "logo"));
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(GetAllDataDocument.class, getAllDataDocument, "isCommunityClosed")).booleanValue() ? 1 : 0);
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(GetAllDataDocument.class, getAllDataDocument, "id"));
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(GetAllDataDocument.class, getAllDataDocument, "title"));
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(GetAllDataDocument.class, getAllDataDocument, "category"));
        Class cls7 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(GetAllDataDocument.class, getAllDataDocument, "isChecked")).booleanValue() ? 1 : 0);
        Class cls8 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, getAllDataDocument, "numFound")).intValue());
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, getAllDataDocument, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, getAllDataDocument, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, getAllDataDocument, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, getAllDataDocument, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, getAllDataDocument, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, getAllDataDocument, "status"));
    }

    public GetAllDataDocument getParcel() {
        return this.getAllDataDocument$$0;
    }

    public static GetAllDataDocument read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            GetAllDataDocument getAllDataDocument = new GetAllDataDocument();
            aVar.a(a2, getAllDataDocument);
            b.a(GetAllDataDocument.class, getAllDataDocument, "communityType", parcel.readString());
            b.a(GetAllDataDocument.class, getAllDataDocument, "logo", parcel.readString());
            boolean z = true;
            b.a(GetAllDataDocument.class, getAllDataDocument, "isCommunityClosed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(GetAllDataDocument.class, getAllDataDocument, "id", parcel.readString());
            b.a(GetAllDataDocument.class, getAllDataDocument, "title", parcel.readString());
            b.a(GetAllDataDocument.class, getAllDataDocument, "category", parcel.readString());
            Class<GetAllDataDocument> cls = GetAllDataDocument.class;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, getAllDataDocument, "isChecked", Boolean.valueOf(z));
            b.a(BaseResponse.class, getAllDataDocument, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, getAllDataDocument, "start", Integer.valueOf(parcel.readInt()));
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
            b.a(BaseResponse.class, getAllDataDocument, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, getAllDataDocument, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, getAllDataDocument, "status", parcel.readString());
            aVar.a(readInt, getAllDataDocument);
            return getAllDataDocument;
        } else if (!aVar.b(readInt)) {
            return (GetAllDataDocument) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
