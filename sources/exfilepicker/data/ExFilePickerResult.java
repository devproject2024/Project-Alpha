package exfilepicker.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ExFilePickerResult implements Parcelable {
    public static final Parcelable.Creator<ExFilePickerResult> CREATOR = new Parcelable.Creator<ExFilePickerResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ExFilePickerResult[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ExFilePickerResult(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f46125a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f46126b;

    /* renamed from: c  reason: collision with root package name */
    public int f46127c;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ ExFilePickerResult(Parcel parcel, byte b2) {
        this(parcel);
    }

    private ExFilePickerResult(Parcel parcel) {
        this.f46125a = "";
        this.f46126b = new ArrayList();
        this.f46127c = 0;
        this.f46125a = parcel.readString();
        this.f46126b = parcel.createStringArrayList();
        this.f46127c = parcel.readInt();
    }

    public ExFilePickerResult(String str, List<String> list) {
        this.f46125a = "";
        this.f46126b = new ArrayList();
        this.f46127c = 0;
        this.f46125a = str;
        this.f46126b = list;
        this.f46127c = list.size();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f46125a);
        parcel.writeStringList(this.f46126b);
        parcel.writeInt(this.f46127c);
    }

    public static ExFilePickerResult a(Intent intent) {
        if (intent != null) {
            return (ExFilePickerResult) intent.getParcelableExtra("RESULT");
        }
        return null;
    }
}
