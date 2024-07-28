package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class FeedRequestPojo$$Parcelable implements Parcelable, e<FeedRequestPojo> {
    public static final Parcelable.Creator<FeedRequestPojo$$Parcelable> CREATOR = new Parcelable.Creator<FeedRequestPojo$$Parcelable>() {
        public final FeedRequestPojo$$Parcelable createFromParcel(Parcel parcel) {
            return new FeedRequestPojo$$Parcelable(FeedRequestPojo$$Parcelable.read(parcel, new a()));
        }

        public final FeedRequestPojo$$Parcelable[] newArray(int i2) {
            return new FeedRequestPojo$$Parcelable[i2];
        }
    };
    private FeedRequestPojo feedRequestPojo$$0;

    public int describeContents() {
        return 0;
    }

    public FeedRequestPojo$$Parcelable(FeedRequestPojo feedRequestPojo) {
        this.feedRequestPojo$$0 = feedRequestPojo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.feedRequestPojo$$0, parcel, i2, new a());
    }

    public static void write(FeedRequestPojo feedRequestPojo, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) feedRequestPojo);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) feedRequestPojo));
        Class<Long> cls = Long.class;
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "idForFeedDetail") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls2 = Long.class;
            parcel.writeLong(((Long) b.a(FeedRequestPojo.class, feedRequestPojo, "idForFeedDetail")).longValue());
        }
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedRequestPojo.class, feedRequestPojo, "isAnonymousPostHide")).booleanValue() ? 1 : 0);
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(FeedRequestPojo.class, feedRequestPojo, "question"));
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "cities") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "cities")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "cities")) {
                parcel.writeString(writeString);
            }
        }
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(FeedRequestPojo.class, feedRequestPojo, "postingDate"));
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "functionalAreas") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "functionalAreas")).size());
            new b.C0602b();
            for (String writeString2 : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "functionalAreas")) {
                parcel.writeString(writeString2);
            }
        }
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "opportunityTypes") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "opportunityTypes")).size());
            new b.C0602b();
            for (String writeString3 : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "opportunityTypes")) {
                parcel.writeString(writeString3);
            }
        }
        Class<Integer> cls6 = Integer.class;
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "experienceTo") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls7 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedRequestPojo.class, feedRequestPojo, "experienceTo")).intValue());
        }
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "skills") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "skills")).size());
            new b.C0602b();
            for (String writeString4 : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "skills")) {
                parcel.writeString(writeString4);
            }
        }
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "categoryIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "categoryIds")).size());
            new b.C0602b();
            for (Long l : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "categoryIds")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "articleCategories") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedRequestPojo.class, feedRequestPojo, "articleCategories")).size());
            new b.C0602b();
            for (String writeString5 : (List) b.a(FeedRequestPojo.class, feedRequestPojo, "articleCategories")) {
                parcel.writeString(writeString5);
            }
        }
        Class<Integer> cls8 = Integer.class;
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "autherId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls9 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedRequestPojo.class, feedRequestPojo, "autherId")).intValue());
        }
        Class<Integer> cls10 = Integer.class;
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "sourceEntityId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls11 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedRequestPojo.class, feedRequestPojo, "sourceEntityId")).intValue());
        }
        Class cls12 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedRequestPojo.class, feedRequestPojo, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls13 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedRequestPojo.class, feedRequestPojo, "onlyActive")).booleanValue() ? 1 : 0);
        Class<String> cls14 = String.class;
        parcel.writeString((String) b.a(FeedRequestPojo.class, feedRequestPojo, "subType"));
        Class cls15 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedRequestPojo.class, feedRequestPojo, "isOnBoardingCommunities")).booleanValue() ? 1 : 0);
        if (feedRequestPojo.communityId == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(feedRequestPojo.communityId.longValue());
        }
        Class<Integer> cls16 = Integer.class;
        if (b.a(FeedRequestPojo.class, feedRequestPojo, "experienceFrom") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls17 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedRequestPojo.class, feedRequestPojo, "experienceFrom")).intValue());
        }
        Class cls18 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedRequestPojo.class, feedRequestPojo, "isAcceptedOrActive")).booleanValue() ? 1 : 0);
        Class<String> cls19 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "appVersion"));
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "deviceUniqueId"));
        Class<Double> cls21 = Double.class;
        if (b.a(BaseRequest.class, feedRequestPojo, "lattitude") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Double> cls22 = Double.class;
            parcel.writeDouble(((Double) b.a(BaseRequest.class, feedRequestPojo, "lattitude")).doubleValue());
        }
        Class<String> cls23 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "testUserType"));
        Class cls24 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, feedRequestPojo, "pageNo")).intValue());
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "cloudMessagingId"));
        Class cls26 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseRequest.class, feedRequestPojo, "pageSize")).intValue());
        Class<String> cls27 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls28 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "source"));
        Class<String> cls29 = String.class;
        parcel.writeString((String) b.a(BaseRequest.class, feedRequestPojo, "lastScreenName"));
        Class<Double> cls30 = Double.class;
        if (b.a(BaseRequest.class, feedRequestPojo, "longitude") == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        Class<Double> cls31 = Double.class;
        parcel.writeDouble(((Double) b.a(BaseRequest.class, feedRequestPojo, "longitude")).doubleValue());
    }

    public FeedRequestPojo getParcel() {
        return this.feedRequestPojo$$0;
    }

    public static FeedRequestPojo read(Parcel parcel, a aVar) {
        Long l;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Integer num;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        Integer num2;
        Integer num3;
        Long l2;
        Integer num4;
        Double d2;
        Long l3;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            FeedRequestPojo feedRequestPojo = new FeedRequestPojo();
            aVar.a(a2, feedRequestPojo);
            Double d3 = null;
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "idForFeedDetail", l);
            boolean z = false;
            b.a(FeedRequestPojo.class, feedRequestPojo, "isAnonymousPostHide", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedRequestPojo.class, feedRequestPojo, "question", parcel.readString());
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(parcel.readString());
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "cities", arrayList);
            b.a(FeedRequestPojo.class, feedRequestPojo, "postingDate", parcel.readString());
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(parcel.readString());
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "functionalAreas", arrayList2);
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    arrayList3.add(parcel.readString());
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "opportunityTypes", arrayList3);
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "experienceTo", num);
            int readInt5 = parcel.readInt();
            if (readInt5 < 0) {
                arrayList4 = null;
            } else {
                arrayList4 = new ArrayList(readInt5);
                for (int i5 = 0; i5 < readInt5; i5++) {
                    arrayList4.add(parcel.readString());
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "skills", arrayList4);
            int readInt6 = parcel.readInt();
            if (readInt6 < 0) {
                arrayList5 = null;
            } else {
                arrayList5 = new ArrayList(readInt6);
                for (int i6 = 0; i6 < readInt6; i6++) {
                    if (parcel.readInt() < 0) {
                        l3 = null;
                    } else {
                        l3 = Long.valueOf(parcel.readLong());
                    }
                    arrayList5.add(l3);
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "categoryIds", arrayList5);
            int readInt7 = parcel.readInt();
            if (readInt7 < 0) {
                arrayList6 = null;
            } else {
                arrayList6 = new ArrayList(readInt7);
                for (int i7 = 0; i7 < readInt7; i7++) {
                    arrayList6.add(parcel.readString());
                }
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "articleCategories", arrayList6);
            if (parcel.readInt() < 0) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "autherId", num2);
            if (parcel.readInt() < 0) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "sourceEntityId", num3);
            b.a(FeedRequestPojo.class, feedRequestPojo, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedRequestPojo.class, feedRequestPojo, "onlyActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedRequestPojo.class, feedRequestPojo, "subType", parcel.readString());
            b.a(FeedRequestPojo.class, feedRequestPojo, "isOnBoardingCommunities", Boolean.valueOf(parcel.readInt() == 1));
            if (parcel.readInt() < 0) {
                l2 = null;
            } else {
                l2 = Long.valueOf(parcel.readLong());
            }
            feedRequestPojo.communityId = l2;
            if (parcel.readInt() < 0) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedRequestPojo.class, feedRequestPojo, "experienceFrom", num4);
            Class<FeedRequestPojo> cls = FeedRequestPojo.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, feedRequestPojo, "isAcceptedOrActive", Boolean.valueOf(z));
            b.a(BaseRequest.class, feedRequestPojo, "appVersion", parcel.readString());
            b.a(BaseRequest.class, feedRequestPojo, "deviceUniqueId", parcel.readString());
            if (parcel.readInt() < 0) {
                d2 = null;
            } else {
                d2 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, feedRequestPojo, "lattitude", d2);
            b.a(BaseRequest.class, feedRequestPojo, "testUserType", parcel.readString());
            b.a(BaseRequest.class, feedRequestPojo, "pageNo", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, feedRequestPojo, "cloudMessagingId", parcel.readString());
            b.a(BaseRequest.class, feedRequestPojo, "pageSize", Integer.valueOf(parcel.readInt()));
            b.a(BaseRequest.class, feedRequestPojo, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseRequest.class, feedRequestPojo, "source", parcel.readString());
            b.a(BaseRequest.class, feedRequestPojo, "lastScreenName", parcel.readString());
            if (parcel.readInt() >= 0) {
                d3 = Double.valueOf(parcel.readDouble());
            }
            b.a(BaseRequest.class, feedRequestPojo, "longitude", d3);
            aVar.a(readInt, feedRequestPojo);
            return feedRequestPojo;
        } else if (!aVar.b(readInt)) {
            return (FeedRequestPojo) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
