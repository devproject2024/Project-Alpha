package android.support.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface a extends IInterface {
    Bundle a() throws RemoteException;

    Bundle a(Bundle bundle) throws RemoteException;

    int b() throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    Bundle c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    /* renamed from: android.support.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0007a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public C0007a() {
            attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "android.support.customtabs.trusted.ITrustedWebActivityService"
                if (r5 == r0) goto L_0x00a7
                r0 = 0
                r3 = 0
                switch(r5) {
                    case 2: goto L_0x0081;
                    case 3: goto L_0x0068;
                    case 4: goto L_0x005a;
                    case 5: goto L_0x0049;
                    case 6: goto L_0x0023;
                    case 7: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0012:
                r6.enforceInterface(r2)
                android.os.Bundle r5 = r4.c()
                r7.writeNoException()
                r7.writeInt(r1)
                r5.writeToParcel(r7, r1)
                return r1
            L_0x0023:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0035
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0035:
                android.os.Bundle r5 = r4.a(r3)
                r7.writeNoException()
                if (r5 == 0) goto L_0x0045
                r7.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x0048
            L_0x0045:
                r7.writeInt(r0)
            L_0x0048:
                return r1
            L_0x0049:
                r6.enforceInterface(r2)
                android.os.Bundle r5 = r4.a()
                r7.writeNoException()
                r7.writeInt(r1)
                r5.writeToParcel(r7, r1)
                return r1
            L_0x005a:
                r6.enforceInterface(r2)
                int r5 = r4.b()
                r7.writeNoException()
                r7.writeInt(r5)
                return r1
            L_0x0068:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x007a
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x007a:
                r4.c(r3)
                r7.writeNoException()
                return r1
            L_0x0081:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0093
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0093:
                android.os.Bundle r5 = r4.b(r3)
                r7.writeNoException()
                if (r5 == 0) goto L_0x00a3
                r7.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x00a6
            L_0x00a3:
                r7.writeInt(r0)
            L_0x00a6:
                return r1
            L_0x00a7:
                r7.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.a.C0007a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }
}
