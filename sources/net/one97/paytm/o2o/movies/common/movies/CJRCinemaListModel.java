package net.one97.paytm.o2o.movies.common.movies;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.LinkedHashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCinemaListModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRCinemaListModel> CREATOR = new Parcelable.Creator<CJRCinemaListModel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRCinemaListModel[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRCinemaListModel(parcel);
        }
    };
    @b(a = "listOfVal")
    private LinkedHashMap<String, Integer> listOfVal;
    @b(a = "title")
    private String title;
    @b(a = "uiType")
    private String uiType;

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.title;
    }

    public LinkedHashMap<String, Integer> getListOfVal() {
        return this.listOfVal;
    }

    public String getUiType() {
        return this.uiType;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeSerializable(this.listOfVal);
        parcel.writeString(this.uiType);
    }

    public CJRCinemaListModel() {
    }

    protected CJRCinemaListModel(Parcel parcel) {
        this.title = parcel.readString();
        this.listOfVal = (LinkedHashMap) parcel.readSerializable();
        this.uiType = parcel.readString();
    }
}
