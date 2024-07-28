package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.firebase.iid.t;

public class FirebaseIidMessengerCompat implements Parcelable {
    public static final Parcelable.Creator<FirebaseIidMessengerCompat> CREATOR = new Parcelable.Creator<FirebaseIidMessengerCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new FirebaseIidMessengerCompat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new FirebaseIidMessengerCompat(readStrongBinder);
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Messenger f38768a;

    /* renamed from: b  reason: collision with root package name */
    t f38769b;

    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            FirebaseInstanceId.i();
            return FirebaseIidMessengerCompat.class;
        }
    }

    public int describeContents() {
        return 0;
    }

    public FirebaseIidMessengerCompat(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f38768a = new Messenger(iBinder);
        } else {
            this.f38769b = new t.a(iBinder);
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f38768a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f38769b.a(message);
        }
    }

    private IBinder a() {
        Messenger messenger = this.f38768a;
        return messenger != null ? messenger.getBinder() : this.f38769b.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((FirebaseIidMessengerCompat) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f38768a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f38769b.asBinder());
        }
    }
}
