package net.one97.paytm.o2o.movies.common.movies.seats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSeat extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRSeat> CREATOR = new Parcelable.Creator<CJRSeat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeat(parcel);
        }
    };
    @b(a = "seatLayout")
    private CJRSeatLayout CJRSeatLayout;
    @b(a = "areas")
    private ArrayList<CJRAreas> areas;
    @b(a = "groupedSeats")
    private ArrayList<ArrayList<CJRGroupedSeats>> groupedSeats;
    @b(a = "initMessages")
    private ArrayList<String> initMessages;
    @b(a = "messages")
    private Map<Integer, String> messages;
    @b(a = "product_id")
    private String productId;
    @b(a = "seatLegends")
    private Map<String, String> seatLegends;
    @b(a = "sessionMessages")
    private ArrayList<MessageObject> sessionMessages;
    @b(a = "tempTransId")
    private String tempTransId;

    public int describeContents() {
        return 0;
    }

    public Map<String, String> getSeatLegends() {
        return this.seatLegends;
    }

    public ArrayList<String> getInitMessages() {
        return this.initMessages;
    }

    public ArrayList<MessageObject> getSessionMessages() {
        return this.sessionMessages;
    }

    public void setSessionMessages(ArrayList<MessageObject> arrayList) {
        this.sessionMessages = arrayList;
    }

    public String getTempTransId() {
        return this.tempTransId;
    }

    public CJRSeatLayout getSeatLayout() {
        return this.CJRSeatLayout;
    }

    public String getProductId() {
        return this.productId;
    }

    public ArrayList<ArrayList<CJRGroupedSeats>> getGroupedSeats() {
        return this.groupedSeats;
    }

    public ArrayList<CJRAreas> getAreas() {
        return this.areas;
    }

    public void sortSeats() {
        if (getSeatLayout() != null && getSeatLayout().getColAreas() != null && getSeatLayout().getColAreas().getObjArea() != null) {
            Iterator<CJRObjArea> it2 = getSeatLayout().getColAreas().getObjArea().iterator();
            while (it2.hasNext()) {
                CJRObjArea next = it2.next();
                if (!(next == null || next.getObjRow() == null)) {
                    next.sortObjRow();
                    Iterator<CJRObjRow> it3 = next.getObjRow().iterator();
                    while (it3.hasNext()) {
                        CJRObjRow next2 = it3.next();
                        if (!(next2 == null || next2.getObjSeat() == null)) {
                            next2.sortObjSeat();
                        }
                    }
                }
            }
        }
    }

    public Map<Integer, String> getMessages() {
        return this.messages;
    }

    public class MessageObject implements Parcelable {
        @b(a = "id")

        /* renamed from: a  reason: collision with root package name */
        public int f75210a;
        @b(a = "msg")

        /* renamed from: b  reason: collision with root package name */
        public String f75211b;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f75210a);
            parcel.writeString(this.f75211b);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.tempTransId);
        parcel.writeSerializable(this.CJRSeatLayout);
        parcel.writeString(this.productId);
        parcel.writeList(this.areas);
        parcel.writeList(this.groupedSeats);
        Map<Integer, String> map = this.messages;
        if (map != null) {
            parcel.writeInt(map.size());
            for (Map.Entry next : this.messages.entrySet()) {
                parcel.writeValue(next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        parcel.writeList(this.sessionMessages);
    }

    public CJRSeat() {
    }

    protected CJRSeat(Parcel parcel) {
        this.tempTransId = parcel.readString();
        this.CJRSeatLayout = (CJRSeatLayout) parcel.readSerializable();
        this.productId = parcel.readString();
        this.areas = new ArrayList<>();
        parcel.readList(this.areas, CJRAreas.class.getClassLoader());
        this.groupedSeats = new ArrayList<>();
        parcel.readList(this.groupedSeats, CJRGroupedSeats.class.getClassLoader());
        int readInt = parcel.readInt();
        this.messages = new HashMap(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.messages.put(Integer.valueOf(parcel.readInt()), parcel.readString());
        }
        this.sessionMessages = new ArrayList<>();
        parcel.readList(this.sessionMessages, MessageObject.class.getClassLoader());
    }
}
