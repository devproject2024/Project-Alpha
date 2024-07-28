package net.one97.paytm.acceptPayment.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.h;
import net.one97.paytm.acceptPayment.R;

public final class DialogUtility {

    public static class DialogDetail implements Parcelable {
        public static final Parcelable.Creator<DialogDetail> CREATOR = new Parcelable.Creator<DialogDetail>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new DialogDetail[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DialogDetail(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private String f52143a;

        /* renamed from: b  reason: collision with root package name */
        private String f52144b;

        /* renamed from: c  reason: collision with root package name */
        private String f52145c;

        /* renamed from: d  reason: collision with root package name */
        private String f52146d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f52147e;

        /* renamed from: f  reason: collision with root package name */
        private int f52148f;

        /* renamed from: g  reason: collision with root package name */
        private int f52149g;

        public int describeContents() {
            return 0;
        }

        protected DialogDetail(Parcel parcel) {
            this.f52143a = parcel.readString();
            this.f52144b = parcel.readString();
            this.f52145c = parcel.readString();
            this.f52146d = parcel.readString();
            this.f52149g = parcel.readInt();
            this.f52148f = parcel.readInt();
            this.f52147e = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f52143a);
            parcel.writeString(this.f52144b);
            parcel.writeString(this.f52145c);
            parcel.writeString(this.f52146d);
            parcel.writeInt(this.f52149g);
            parcel.writeInt(this.f52148f);
            parcel.writeByte(this.f52147e ? (byte) 1 : 0);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getResources().getString(R.string.ap_some_went_wrong);
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getString(R.string.mp_error);
        }
        final h hVar = new h(context);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.a(-3, context.getResources().getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }
}
