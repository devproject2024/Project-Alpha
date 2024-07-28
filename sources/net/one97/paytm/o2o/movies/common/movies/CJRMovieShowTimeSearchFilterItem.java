package net.one97.paytm.o2o.movies.common.movies;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieShowTimeSearchFilterItem implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieShowTimeSearchFilterItem> CREATOR = new Parcelable.Creator<CJRMovieShowTimeSearchFilterItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieShowTimeSearchFilterItem[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieShowTimeSearchFilterItem(parcel);
        }
    };
    @b(a = "description")
    public String description;
    @b(a = "interval")
    public int interval;
    @b(a = "listOfVal")
    public ArrayList<String> listOfVal;
    @b(a = "maxVal")
    public String maxVal;
    @b(a = "minVal")
    public String minVal;
    @b(a = "title")
    public String title;
    @b(a = "uiType")
    public String uiType;

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getMinVal() {
        return this.minVal;
    }

    public String getMaxVal() {
        return this.maxVal;
    }

    public ArrayList<String> getListOfVal() {
        return this.listOfVal;
    }

    public String getUiType() {
        return this.uiType;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeInt(this.interval);
        parcel.writeString(this.minVal);
        parcel.writeString(this.maxVal);
        parcel.writeStringList(this.listOfVal);
        parcel.writeString(this.uiType);
        parcel.writeString(this.description);
    }

    public CJRMovieShowTimeSearchFilterItem() {
    }

    protected CJRMovieShowTimeSearchFilterItem(Parcel parcel) {
        this.title = parcel.readString();
        this.interval = parcel.readInt();
        this.minVal = parcel.readString();
        this.maxVal = parcel.readString();
        this.listOfVal = parcel.createStringArrayList();
        this.uiType = parcel.readString();
        this.description = parcel.readString();
    }
}
