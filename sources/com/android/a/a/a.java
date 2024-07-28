package com.android.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface a extends IInterface {
    int a(int i2, String str, String str2) throws RemoteException;

    Bundle a(int i2, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle a(int i2, String str, String str2, String str3) throws RemoteException;

    Bundle a(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle a(int i2, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle a(int i2, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle a(int i2, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    int b(int i2, String str, String str2) throws RemoteException;

    int b(int i2, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle b(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int c(int i2, String str, String str2) throws RemoteException;

    /* renamed from: com.android.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0524a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0525a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r14, android.os.Parcel r15, android.os.Parcel r16, int r17) throws android.os.RemoteException {
            /*
                r13 = this;
                r7 = r13
                r0 = r14
                r1 = r15
                r8 = r16
                r2 = 801(0x321, float:1.122E-42)
                r3 = 0
                r9 = 0
                java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
                r10 = 1
                if (r0 == r2) goto L_0x01d7
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r0 == r2) goto L_0x01d3
                switch(r0) {
                    case 1: goto L_0x01b9;
                    case 2: goto L_0x0187;
                    case 3: goto L_0x0156;
                    case 4: goto L_0x012f;
                    case 5: goto L_0x0115;
                    case 6: goto L_0x00fb;
                    case 7: goto L_0x00c5;
                    case 8: goto L_0x0082;
                    case 9: goto L_0x0044;
                    case 10: goto L_0x001b;
                    default: goto L_0x0016;
                }
            L_0x0016:
                boolean r0 = super.onTransact(r14, r15, r16, r17)
                return r0
            L_0x001b:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r4 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x0039
                android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r3.createFromParcel(r15)
                r3 = r1
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0039:
                int r0 = r13.b(r0, r2, r4, r3)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x0044:
                r15.enforceInterface(r4)
                int r2 = r15.readInt()
                java.lang.String r4 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x0067
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x0068
            L_0x0067:
                r11 = r3
            L_0x0068:
                r0 = r13
                r1 = r2
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.a((int) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.os.Bundle) r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x007e
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0081
            L_0x007e:
                r8.writeInt(r9)
            L_0x0081:
                return r10
            L_0x0082:
                r15.enforceInterface(r4)
                int r2 = r15.readInt()
                java.lang.String r4 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                java.lang.String r11 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x00a9
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r12 = r0
                goto L_0x00aa
            L_0x00a9:
                r12 = r3
            L_0x00aa:
                r0 = r13
                r1 = r2
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r11
                r6 = r12
                android.os.Bundle r0 = r0.a((int) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (android.os.Bundle) r6)
                r16.writeNoException()
                if (r0 == 0) goto L_0x00c1
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x00c4
            L_0x00c1:
                r8.writeInt(r9)
            L_0x00c4:
                return r10
            L_0x00c5:
                r15.enforceInterface(r4)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.util.ArrayList r4 = r15.createStringArrayList()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                java.lang.String r11 = r15.readString()
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r11
                android.os.Bundle r0 = r0.a((int) r1, (java.lang.String) r2, (java.util.List<java.lang.String>) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)
                r16.writeNoException()
                if (r0 == 0) goto L_0x00f7
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x00fa
            L_0x00f7:
                r8.writeInt(r9)
            L_0x00fa:
                return r10
            L_0x00fb:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.c(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x0115:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.b(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x012f:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                java.lang.String r1 = r15.readString()
                android.os.Bundle r0 = r13.a((int) r0, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r1)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0152
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0155
            L_0x0152:
                r8.writeInt(r9)
            L_0x0155:
                return r10
            L_0x0156:
                r15.enforceInterface(r4)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r4 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                android.os.Bundle r0 = r0.a((int) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0183
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0186
            L_0x0183:
                r8.writeInt(r9)
            L_0x0186:
                return r10
            L_0x0187:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r4 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x01a5
                android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r3.createFromParcel(r15)
                r3 = r1
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x01a5:
                android.os.Bundle r0 = r13.a((int) r0, (java.lang.String) r2, (java.lang.String) r4, (android.os.Bundle) r3)
                r16.writeNoException()
                if (r0 == 0) goto L_0x01b5
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x01b8
            L_0x01b5:
                r8.writeInt(r9)
            L_0x01b8:
                return r10
            L_0x01b9:
                r15.enforceInterface(r4)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.a(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x01d3:
                r8.writeString(r4)
                return r10
            L_0x01d7:
                r15.enforceInterface(r4)
                int r2 = r15.readInt()
                java.lang.String r4 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x01fa
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x01fb
            L_0x01fa:
                r11 = r3
            L_0x01fb:
                r0 = r13
                r1 = r2
                r2 = r4
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.b(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0211
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0214
            L_0x0211:
                r8.writeInt(r9)
            L_0x0214:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.a.a.a.C0524a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.android.a.a.a$a$a  reason: collision with other inner class name */
        static class C0525a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30903a;

            C0525a(IBinder iBinder) {
                this.f30903a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f30903a;
            }

            public final int a(int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f30903a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30903a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f30903a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f30903a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b(int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f30903a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int c(int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f30903a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f30903a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30903a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle a(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30903a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b(int i2, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30903a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle b(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30903a.transact(801, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
