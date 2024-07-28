package org.npci.upi.security.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.npci.upi.security.services.CLResultReceiver;

public interface CLRemoteService extends IInterface {

    public abstract class Stub extends Binder implements CLRemoteService {
        private static final String DESCRIPTOR = "org.npci.upi.security.services.CLRemoteService";
        static final int TRANSACTION_getChallenge = 1;
        static final int TRANSACTION_getCredential = 3;
        static final int TRANSACTION_registerApp = 2;

        class Proxy implements CLRemoteService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getChallenge(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    obtain.writeString(str8);
                    obtain.writeStrongBinder(cLResultReceiver != null ? cLResultReceiver.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean registerApp(String str, String str2, String str3, String str4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static CLRemoteService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof CLRemoteService)) ? new Proxy(iBinder) : (CLRemoteService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = i2;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i4 == 1) {
                parcel3.enforceInterface(DESCRIPTOR);
                String challenge = getChallenge(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel4.writeString(challenge);
                return true;
            } else if (i4 == 2) {
                parcel3.enforceInterface(DESCRIPTOR);
                boolean registerApp = registerApp(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel4.writeInt(registerApp ? 1 : 0);
                return true;
            } else if (i4 == 3) {
                parcel3.enforceInterface(DESCRIPTOR);
                getCredential(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), CLResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i4 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    String getChallenge(String str, String str2);

    void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver);

    boolean registerApp(String str, String str2, String str3, String str4);
}
