package net.one97.paytm.common.entity.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCityTranslationModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRCityTranslationModel> CREATOR = new Parcelable.Creator<CJRCityTranslationModel>() {
        public final CJRCityTranslationModel createFromParcel(Parcel parcel) {
            return new CJRCityTranslationModel(parcel);
        }

        public final CJRCityTranslationModel[] newArray(int i2) {
            return new CJRCityTranslationModel[i2];
        }
    };
    @c(a = "label")
    private String label;

    public int describeContents() {
        return 0;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    protected CJRCityTranslationModel(Parcel parcel) {
        this.label = parcel.readString();
    }

    public CJRCityTranslationModel(String str) {
        this.label = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.label);
    }
}
