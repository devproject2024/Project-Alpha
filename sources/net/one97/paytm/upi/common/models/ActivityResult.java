package net.one97.paytm.upi.common.models;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class ActivityResult extends CropResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ActivityResult[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }
    };

    public final int describeContents() {
        return 0;
    }

    public ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i2, Rect rect2, int i3) {
        super((Bitmap) null, uri, (Bitmap) null, uri2, exc, fArr, rect, rect2, i2, i3);
    }

    protected ActivityResult(Parcel parcel) {
        super((Bitmap) null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Bitmap) null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(getOriginalUri(), i2);
        parcel.writeParcelable(getUri(), i2);
        parcel.writeSerializable(getError());
        parcel.writeFloatArray(getCropPoints());
        parcel.writeParcelable(getCropRect(), i2);
        parcel.writeParcelable(getWholeImageRect(), i2);
        parcel.writeInt(getRotation());
        parcel.writeInt(getSampleSize());
    }
}
