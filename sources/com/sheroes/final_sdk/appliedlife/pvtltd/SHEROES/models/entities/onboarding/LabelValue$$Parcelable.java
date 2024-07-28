package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.onboarding;

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

public class LabelValue$$Parcelable implements Parcelable, e<LabelValue> {
    public static final Parcelable.Creator<LabelValue$$Parcelable> CREATOR = new Parcelable.Creator<LabelValue$$Parcelable>() {
        public final LabelValue$$Parcelable createFromParcel(Parcel parcel) {
            return new LabelValue$$Parcelable(LabelValue$$Parcelable.read(parcel, new a()));
        }

        public final LabelValue$$Parcelable[] newArray(int i2) {
            return new LabelValue$$Parcelable[i2];
        }
    };
    private LabelValue labelValue$$0;

    public int describeContents() {
        return 0;
    }

    public LabelValue$$Parcelable(LabelValue labelValue) {
        this.labelValue$$0 = labelValue;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.labelValue$$0, parcel, i2, new a());
    }

    public static void write(LabelValue labelValue, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) labelValue);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) labelValue));
        parcel.writeString(labelValue.imgUrl);
        Class cls = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LabelValue.class, labelValue, "isSelected")).booleanValue() ? 1 : 0);
        parcel.writeString(labelValue.label);
        parcel.writeLong(labelValue.value);
        parcel.writeString(labelValue.desc);
        Class cls2 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, labelValue, "numFound")).intValue());
        Class cls3 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, labelValue, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, labelValue, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, labelValue, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, labelValue, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, labelValue, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, labelValue, "status"));
    }

    public LabelValue getParcel() {
        return this.labelValue$$0;
    }

    public static LabelValue read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            LabelValue labelValue = new LabelValue();
            aVar.a(a2, labelValue);
            labelValue.imgUrl = parcel.readString();
            Class<LabelValue> cls = LabelValue.class;
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, labelValue, "isSelected", Boolean.valueOf(z));
            labelValue.label = parcel.readString();
            labelValue.value = parcel.readLong();
            labelValue.desc = parcel.readString();
            b.a(BaseResponse.class, labelValue, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, labelValue, "start", Integer.valueOf(parcel.readInt()));
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
            b.a(BaseResponse.class, labelValue, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, labelValue, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, labelValue, "status", parcel.readString());
            aVar.a(readInt, labelValue);
            return labelValue;
        } else if (!aVar.b(readInt)) {
            return (LabelValue) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
