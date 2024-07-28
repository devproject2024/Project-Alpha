package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class MembersList$$Parcelable implements Parcelable, e<MembersList> {
    public static final Parcelable.Creator<MembersList$$Parcelable> CREATOR = new Parcelable.Creator<MembersList$$Parcelable>() {
        public final MembersList$$Parcelable createFromParcel(Parcel parcel) {
            return new MembersList$$Parcelable(MembersList$$Parcelable.read(parcel, new a()));
        }

        public final MembersList$$Parcelable[] newArray(int i2) {
            return new MembersList$$Parcelable[i2];
        }
    };
    private MembersList membersList$$0;

    public int describeContents() {
        return 0;
    }

    public MembersList$$Parcelable(MembersList membersList) {
        this.membersList$$0 = membersList;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.membersList$$0, parcel, i2, new a());
    }

    public static void write(MembersList membersList, Parcel parcel, int i2, a aVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = aVar.b((Object) membersList);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) membersList));
        Class<Boolean> cls = Boolean.class;
        int i8 = 0;
        if (b.a(MembersList.class, membersList, "commIsClosed") == null) {
            i3 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls2 = Boolean.class;
            i3 = ((Boolean) b.a(MembersList.class, membersList, "commIsClosed")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i3);
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "comType"));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "typeS"));
        Class<Boolean> cls5 = Boolean.class;
        if (b.a(MembersList.class, membersList, "commIsDeleted") == null) {
            i4 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls6 = Boolean.class;
            i4 = ((Boolean) b.a(MembersList.class, membersList, "commIsDeleted")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i4);
        Class<Boolean> cls7 = Boolean.class;
        if (b.a(MembersList.class, membersList, "commIsActive") == null) {
            i5 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls8 = Boolean.class;
            i5 = ((Boolean) b.a(MembersList.class, membersList, "commIsActive")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i5);
        Class<String> cls9 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserLastName"));
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserCityName"));
        Class<Boolean> cls11 = Boolean.class;
        if (b.a(MembersList.class, membersList, "isActive") == null) {
            i6 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls12 = Boolean.class;
            i6 = ((Boolean) b.a(MembersList.class, membersList, "isActive")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i6);
        Class<Long> cls13 = Long.class;
        if (b.a(MembersList.class, membersList, "communityMemberId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls14 = Long.class;
            parcel.writeLong(((Long) b.a(MembersList.class, membersList, "communityMemberId")).longValue());
        }
        Class cls15 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, "cityMasterId")).intValue());
        Class cls16 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, "communityUserId")).intValue());
        Class cls17 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(MembersList.class, membersList, "isOwner")).booleanValue() ? 1 : 0);
        Class<String> cls18 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "comLogoUrl"));
        Class cls19 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, "communityUserCityId")).intValue());
        Class cls20 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, "comId")).intValue());
        Class<String> cls21 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "id"));
        Class<Long> cls22 = Long.class;
        if (b.a(MembersList.class, membersList, "communityId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls23 = Long.class;
            parcel.writeLong(((Long) b.a(MembersList.class, membersList, "communityId")).longValue());
        }
        Class<Boolean> cls24 = Boolean.class;
        if (b.a(MembersList.class, membersList, "isApproved") == null) {
            i7 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls25 = Boolean.class;
            i7 = ((Boolean) b.a(MembersList.class, membersList, "isApproved")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i7);
        Class<String> cls26 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserPhotoUrlPath"));
        Class<Boolean> cls27 = Boolean.class;
        if (b.a(MembersList.class, membersList, "commIsFeatured") == null) {
            i8 = -1;
        } else {
            parcel.writeInt(1);
            Class<Boolean> cls28 = Boolean.class;
            if (((Boolean) b.a(MembersList.class, membersList, "commIsFeatured")).booleanValue()) {
                i8 = 1;
            }
        }
        parcel.writeInt(i8);
        Class<String> cls29 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "approvedDate"));
        Class<String> cls30 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserFirstName"));
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserEmailid"));
        Class<Long> cls32 = Long.class;
        if (b.a(MembersList.class, membersList, "usersId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls33 = Long.class;
            parcel.writeLong(((Long) b.a(MembersList.class, membersList, "usersId")).longValue());
        }
        Class<String> cls34 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "comName"));
        Class cls35 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, CLPConstants.ARGUMENT_KEY_POSITION)).intValue());
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(MembersList.class, membersList, "communityUserMobile"));
        Class cls37 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(MembersList.class, membersList, "communityUserParticipantId")).intValue());
        Class cls38 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, membersList, "numFound")).intValue());
        Class cls39 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, membersList, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, membersList, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, membersList, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, membersList, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls40 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, membersList, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls41 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, membersList, "status"));
    }

    public MembersList getParcel() {
        return this.membersList$$0;
    }

    public static MembersList read(Parcel parcel, a aVar) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Long l;
        Long l2;
        Boolean bool5;
        Boolean bool6;
        Long l3;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            MembersList membersList = new MembersList();
            aVar.a(a2, membersList);
            HashMap hashMap = null;
            boolean z = true;
            if (parcel.readInt() < 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() == 1);
            }
            b.a(MembersList.class, membersList, "commIsClosed", bool);
            b.a(MembersList.class, membersList, "comType", parcel.readString());
            b.a(MembersList.class, membersList, "typeS", parcel.readString());
            if (parcel.readInt() < 0) {
                bool2 = null;
            } else {
                bool2 = Boolean.valueOf(parcel.readInt() == 1);
            }
            b.a(MembersList.class, membersList, "commIsDeleted", bool2);
            if (parcel.readInt() < 0) {
                bool3 = null;
            } else {
                bool3 = Boolean.valueOf(parcel.readInt() == 1);
            }
            b.a(MembersList.class, membersList, "commIsActive", bool3);
            b.a(MembersList.class, membersList, "communityUserLastName", parcel.readString());
            b.a(MembersList.class, membersList, "communityUserCityName", parcel.readString());
            if (parcel.readInt() < 0) {
                bool4 = null;
            } else {
                bool4 = Boolean.valueOf(parcel.readInt() == 1);
            }
            b.a(MembersList.class, membersList, "isActive", bool4);
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            b.a(MembersList.class, membersList, "communityMemberId", l);
            b.a(MembersList.class, membersList, "cityMasterId", Integer.valueOf(parcel.readInt()));
            b.a(MembersList.class, membersList, "communityUserId", Integer.valueOf(parcel.readInt()));
            b.a(MembersList.class, membersList, "isOwner", Boolean.valueOf(parcel.readInt() == 1));
            b.a(MembersList.class, membersList, "comLogoUrl", parcel.readString());
            b.a(MembersList.class, membersList, "communityUserCityId", Integer.valueOf(parcel.readInt()));
            b.a(MembersList.class, membersList, "comId", Integer.valueOf(parcel.readInt()));
            b.a(MembersList.class, membersList, "id", parcel.readString());
            if (parcel.readInt() < 0) {
                l2 = null;
            } else {
                l2 = Long.valueOf(parcel.readLong());
            }
            b.a(MembersList.class, membersList, "communityId", l2);
            if (parcel.readInt() < 0) {
                bool5 = null;
            } else {
                bool5 = Boolean.valueOf(parcel.readInt() == 1);
            }
            b.a(MembersList.class, membersList, "isApproved", bool5);
            b.a(MembersList.class, membersList, "communityUserPhotoUrlPath", parcel.readString());
            if (parcel.readInt() < 0) {
                bool6 = null;
            } else {
                if (parcel.readInt() != 1) {
                    z = false;
                }
                bool6 = Boolean.valueOf(z);
            }
            b.a(MembersList.class, membersList, "commIsFeatured", bool6);
            b.a(MembersList.class, membersList, "approvedDate", parcel.readString());
            b.a(MembersList.class, membersList, "communityUserFirstName", parcel.readString());
            b.a(MembersList.class, membersList, "communityUserEmailid", parcel.readString());
            if (parcel.readInt() < 0) {
                l3 = null;
            } else {
                l3 = Long.valueOf(parcel.readLong());
            }
            b.a(MembersList.class, membersList, "usersId", l3);
            b.a(MembersList.class, membersList, "comName", parcel.readString());
            b.a(MembersList.class, membersList, CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(parcel.readInt()));
            b.a(MembersList.class, membersList, "communityUserMobile", parcel.readString());
            b.a(MembersList.class, membersList, "communityUserParticipantId", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, membersList, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, membersList, "start", Integer.valueOf(parcel.readInt()));
            int readInt2 = parcel.readInt();
            if (readInt2 >= 0) {
                hashMap = new HashMap(c.a(readInt2));
                for (int i2 = 0; i2 < readInt2; i2++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, membersList, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, membersList, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, membersList, "status", parcel.readString());
            aVar.a(readInt, membersList);
            return membersList;
        } else if (!aVar.b(readInt)) {
            return (MembersList) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
