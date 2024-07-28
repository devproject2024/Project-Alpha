package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new Parcelable.Creator<CropImageOptions>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CropImageOptions[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CropImageOptions(parcel);
        }
    };
    public int A;
    public int B;
    public int C;
    public CharSequence D;
    public int E;
    public Uri F;
    public Bitmap.CompressFormat G;
    public int H;
    public int I;
    public int J;
    public PBCropImageView.i K;
    public boolean L;
    public Rect M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public CharSequence U;
    public int V;

    /* renamed from: a  reason: collision with root package name */
    public PBCropImageView.b f19654a;

    /* renamed from: b  reason: collision with root package name */
    public float f19655b;

    /* renamed from: c  reason: collision with root package name */
    public float f19656c;

    /* renamed from: d  reason: collision with root package name */
    public PBCropImageView.c f19657d;

    /* renamed from: e  reason: collision with root package name */
    public PBCropImageView.j f19658e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19659f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19660g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19661h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19662i;
    public int j;
    public float k;
    public boolean l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;
    public float s;
    public int t;
    public float u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public int describeContents() {
        return 0;
    }

    public CropImageOptions() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f19654a = PBCropImageView.b.RECTANGLE;
        this.f19655b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f19656c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f19657d = PBCropImageView.c.ON_TOUCH;
        this.f19658e = PBCropImageView.j.FIT_CENTER;
        this.f19659f = true;
        this.f19660g = true;
        this.f19661h = true;
        this.f19662i = false;
        this.j = 4;
        this.k = 0.1f;
        this.l = false;
        this.m = 1;
        this.n = 1;
        this.o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.p = Color.argb(170, PriceRangeSeekBar.INVALID_POINTER_ID, PriceRangeSeekBar.INVALID_POINTER_ID, PriceRangeSeekBar.INVALID_POINTER_ID);
        this.q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.t = -1;
        this.u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.v = Color.argb(170, PriceRangeSeekBar.INVALID_POINTER_ID, PriceRangeSeekBar.INVALID_POINTER_ID, PriceRangeSeekBar.INVALID_POINTER_ID);
        this.w = Color.argb(119, 0, 0, 0);
        this.x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.z = 40;
        this.A = 40;
        this.B = 99999;
        this.C = 99999;
        this.D = "";
        this.E = 0;
        this.F = Uri.EMPTY;
        this.G = Bitmap.CompressFormat.JPEG;
        this.H = 90;
        this.I = 0;
        this.J = 0;
        this.K = PBCropImageView.i.NONE;
        this.L = false;
        this.M = null;
        this.N = -1;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = 90;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = 0;
    }

    protected CropImageOptions(Parcel parcel) {
        this.f19654a = PBCropImageView.b.values()[parcel.readInt()];
        this.f19655b = parcel.readFloat();
        this.f19656c = parcel.readFloat();
        this.f19657d = PBCropImageView.c.values()[parcel.readInt()];
        this.f19658e = PBCropImageView.j.values()[parcel.readInt()];
        boolean z2 = true;
        this.f19659f = parcel.readByte() != 0;
        this.f19660g = parcel.readByte() != 0;
        this.f19661h = parcel.readByte() != 0;
        this.f19662i = parcel.readByte() != 0;
        this.j = parcel.readInt();
        this.k = parcel.readFloat();
        this.l = parcel.readByte() != 0;
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readFloat();
        this.p = parcel.readInt();
        this.q = parcel.readFloat();
        this.r = parcel.readFloat();
        this.s = parcel.readFloat();
        this.t = parcel.readInt();
        this.u = parcel.readFloat();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.E = parcel.readInt();
        this.F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.G = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = PBCropImageView.i.values()[parcel.readInt()];
        this.L = parcel.readByte() != 0;
        this.M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.N = parcel.readInt();
        this.O = parcel.readByte() != 0;
        this.P = parcel.readByte() != 0;
        this.Q = parcel.readByte() != 0;
        this.R = parcel.readInt();
        this.S = parcel.readByte() != 0;
        this.T = parcel.readByte() == 0 ? false : z2;
        this.U = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.V = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19654a.ordinal());
        parcel.writeFloat(this.f19655b);
        parcel.writeFloat(this.f19656c);
        parcel.writeInt(this.f19657d.ordinal());
        parcel.writeInt(this.f19658e.ordinal());
        parcel.writeByte(this.f19659f ? (byte) 1 : 0);
        parcel.writeByte(this.f19660g ? (byte) 1 : 0);
        parcel.writeByte(this.f19661h ? (byte) 1 : 0);
        parcel.writeByte(this.f19662i ? (byte) 1 : 0);
        parcel.writeInt(this.j);
        parcel.writeFloat(this.k);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeFloat(this.o);
        parcel.writeInt(this.p);
        parcel.writeFloat(this.q);
        parcel.writeFloat(this.r);
        parcel.writeFloat(this.s);
        parcel.writeInt(this.t);
        parcel.writeFloat(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        TextUtils.writeToParcel(this.D, parcel, i2);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.F, i2);
        parcel.writeString(this.G.name());
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K.ordinal());
        parcel.writeInt(this.L ? 1 : 0);
        parcel.writeParcelable(this.M, i2);
        parcel.writeInt(this.N);
        parcel.writeByte(this.O ? (byte) 1 : 0);
        parcel.writeByte(this.P ? (byte) 1 : 0);
        parcel.writeByte(this.Q ? (byte) 1 : 0);
        parcel.writeInt(this.R);
        parcel.writeByte(this.S ? (byte) 1 : 0);
        parcel.writeByte(this.T ? (byte) 1 : 0);
        TextUtils.writeToParcel(this.U, parcel, i2);
        parcel.writeInt(this.V);
    }

    public final void a() {
        if (this.j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.f19656c >= 0.0f) {
            float f2 = this.k;
            if (f2 < 0.0f || ((double) f2) >= 0.5d) {
                throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
            } else if (this.m <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.n <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.o < 0.0f) {
                throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
            } else if (this.q < 0.0f) {
                throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
            } else if (this.u < 0.0f) {
                throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
            } else if (this.y >= 0) {
                int i2 = this.z;
                if (i2 >= 0) {
                    int i3 = this.A;
                    if (i3 < 0) {
                        throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                    } else if (this.B < i2) {
                        throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                    } else if (this.C < i3) {
                        throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                    } else if (this.I < 0) {
                        throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                    } else if (this.J >= 0) {
                        int i4 = this.R;
                        if (i4 < 0 || i4 > 360) {
                            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                    }
                } else {
                    throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                }
            } else {
                throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
            }
        } else {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
    }
}
