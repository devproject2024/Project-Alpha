package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class LoginResponse$$Parcelable implements Parcelable, e<LoginResponse> {
    public static final Parcelable.Creator<LoginResponse$$Parcelable> CREATOR = new Parcelable.Creator<LoginResponse$$Parcelable>() {
        public final LoginResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new LoginResponse$$Parcelable(LoginResponse$$Parcelable.read(parcel, new a()));
        }

        public final LoginResponse$$Parcelable[] newArray(int i2) {
            return new LoginResponse$$Parcelable[i2];
        }
    };
    private LoginResponse loginResponse$$0;

    public int describeContents() {
        return 0;
    }

    public LoginResponse$$Parcelable(LoginResponse loginResponse) {
        this.loginResponse$$0 = loginResponse;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.loginResponse$$0, parcel, i2, new a());
    }

    public static void write(LoginResponse loginResponse, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) loginResponse);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) loginResponse));
        Class<UserSummary> cls = UserSummary.class;
        UserSummary$$Parcelable.write((UserSummary) b.a(LoginResponse.class, loginResponse, "userSummary"), parcel, i2, aVar);
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(LoginResponse.class, loginResponse, "gcmId"));
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LoginResponse.class, loginResponse, "sheUser")).booleanValue() ? 1 : 0);
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(LoginResponse.class, loginResponse, "nextScreen"));
        Class cls5 = Long.TYPE;
        parcel.writeLong(((Long) b.a(LoginResponse.class, loginResponse, "tokenTime")).longValue());
        Class cls6 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(LoginResponse.class, loginResponse, "isAppContactAccessed")).booleanValue() ? 1 : 0);
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(LoginResponse.class, loginResponse, "tokenType"));
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(LoginResponse.class, loginResponse, StringSet.token));
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, loginResponse, "numFound")).intValue());
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, loginResponse, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, loginResponse, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, loginResponse, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, loginResponse, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, loginResponse, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, loginResponse, "status"));
    }

    public LoginResponse getParcel() {
        return this.loginResponse$$0;
    }

    public static LoginResponse read(Parcel parcel, a aVar) {
        HashMap hashMap;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            LoginResponse loginResponse = new LoginResponse();
            aVar.a(a2, loginResponse);
            b.a(LoginResponse.class, loginResponse, "userSummary", UserSummary$$Parcelable.read(parcel, aVar));
            b.a(LoginResponse.class, loginResponse, "gcmId", parcel.readString());
            boolean z = true;
            b.a(LoginResponse.class, loginResponse, "sheUser", Boolean.valueOf(parcel.readInt() == 1));
            b.a(LoginResponse.class, loginResponse, "nextScreen", parcel.readString());
            b.a(LoginResponse.class, loginResponse, "tokenTime", Long.valueOf(parcel.readLong()));
            Class<LoginResponse> cls = LoginResponse.class;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, loginResponse, "isAppContactAccessed", Boolean.valueOf(z));
            b.a(LoginResponse.class, loginResponse, "tokenType", parcel.readString());
            b.a(LoginResponse.class, loginResponse, StringSet.token, parcel.readString());
            b.a(BaseResponse.class, loginResponse, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, loginResponse, "start", Integer.valueOf(parcel.readInt()));
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
            b.a(BaseResponse.class, loginResponse, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, loginResponse, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, loginResponse, "status", parcel.readString());
            aVar.a(readInt, loginResponse);
            return loginResponse;
        } else if (!aVar.b(readInt)) {
            return (LoginResponse) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
