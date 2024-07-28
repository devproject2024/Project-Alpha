package net.one97.paytm.o2o.movies.common.movies.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieWidget implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieWidget> CREATOR = new Parcelable.Creator<CJRMovieWidget>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieWidget[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieWidget(parcel);
        }
    };
    @b(a = "info")
    private CJRMovieWidgetInfo info;
    @b(a = "type")
    private String type;

    public int describeContents() {
        return 0;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CJRMovieWidgetInfo getInfo() {
        return this.info;
    }

    public void setInfo(CJRMovieWidgetInfo cJRMovieWidgetInfo) {
        this.info = cJRMovieWidgetInfo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.type);
        parcel.writeSerializable(this.info);
    }

    public CJRMovieWidget() {
    }

    protected CJRMovieWidget(Parcel parcel) {
        this.type = parcel.readString();
        this.info = (CJRMovieWidgetInfo) parcel.readSerializable();
    }
}
