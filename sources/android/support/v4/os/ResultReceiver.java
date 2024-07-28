package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;

public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ResultReceiver[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final boolean f910a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f911b = null;

    /* renamed from: c  reason: collision with root package name */
    a f912c;

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f914a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f915b;

        b(int i2, Bundle bundle) {
            this.f914a = i2;
            this.f915b = bundle;
        }

        public final void run() {
            ResultReceiver.this.a(this.f914a, this.f915b);
        }
    }

    class a extends a.C0018a {
        a() {
        }

        public final void a(int i2, Bundle bundle) {
            if (ResultReceiver.this.f911b != null) {
                ResultReceiver.this.f911b.post(new b(i2, bundle));
            } else {
                ResultReceiver.this.a(i2, bundle);
            }
        }
    }

    public final void b(int i2, Bundle bundle) {
        if (this.f910a) {
            Handler handler = this.f911b;
            if (handler != null) {
                handler.post(new b(i2, bundle));
            } else {
                a(i2, bundle);
            }
        } else {
            a aVar = this.f912c;
            if (aVar != null) {
                try {
                    aVar.a(i2, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f912c == null) {
                this.f912c = new a();
            }
            parcel.writeStrongBinder(this.f912c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f912c = a.C0018a.a(parcel.readStrongBinder());
    }
}
