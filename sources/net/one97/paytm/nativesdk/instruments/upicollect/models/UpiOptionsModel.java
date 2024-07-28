package net.one97.paytm.nativesdk.instruments.upicollect.models;

import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class UpiOptionsModel implements Parcelable {
    public static final Parcelable.Creator<UpiOptionsModel> CREATOR = new Parcelable.Creator<UpiOptionsModel>() {
        public final UpiOptionsModel createFromParcel(Parcel parcel) {
            return new UpiOptionsModel(parcel);
        }

        public final UpiOptionsModel[] newArray(int i2) {
            return new UpiOptionsModel[i2];
        }
    };
    private String appName;
    private Bitmap bitmap;
    private Drawable drawable;
    private ResolveInfo resolveInfo;
    private int sortingIndex;

    public int describeContents() {
        return 0;
    }

    public UpiOptionsModel(ResolveInfo resolveInfo2, String str, Drawable drawable2) {
        this.appName = str;
        this.drawable = drawable2;
        this.resolveInfo = resolveInfo2;
    }

    protected UpiOptionsModel(Parcel parcel) {
        this.appName = parcel.readString();
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.resolveInfo = (ResolveInfo) parcel.readParcelable(ResolveInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.appName);
        parcel.writeParcelable(this.bitmap, i2);
        parcel.writeParcelable(this.resolveInfo, i2);
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
    }

    public ResolveInfo getResolveInfo() {
        return this.resolveInfo;
    }

    public void setResolveInfo(ResolveInfo resolveInfo2) {
        this.resolveInfo = resolveInfo2;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public void setSortingIndex(int i2) {
        this.sortingIndex = i2;
    }

    public int getSortingIndex() {
        return this.sortingIndex;
    }
}
