package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import java.util.Map;

public final class mc extends a implements kv {
    mc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void initialize(b bVar, zzv zzv, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        r.a(a2, (Parcelable) zzv);
        a2.writeLong(j);
        b(1, a2);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (Parcelable) bundle);
        r.a(a2, z);
        r.a(a2, z2);
        a2.writeLong(j);
        b(2, a2);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, lw lwVar, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (Parcelable) bundle);
        r.a(a2, (IInterface) lwVar);
        a2.writeLong(j);
        b(3, a2);
    }

    public final void setUserProperty(String str, String str2, b bVar, boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (IInterface) bVar);
        r.a(a2, z);
        a2.writeLong(j);
        b(4, a2);
    }

    public final void getUserProperties(String str, String str2, boolean z, lw lwVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, z);
        r.a(a2, (IInterface) lwVar);
        b(5, a2);
    }

    public final void getMaxUserProperties(String str, lw lwVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        r.a(a2, (IInterface) lwVar);
        b(6, a2);
    }

    public final void setUserId(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(7, a2);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) bundle);
        a2.writeLong(j);
        b(8, a2);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (Parcelable) bundle);
        b(9, a2);
    }

    public final void getConditionalUserProperties(String str, String str2, lw lwVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (IInterface) lwVar);
        b(10, a2);
    }

    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, z);
        a2.writeLong(j);
        b(11, a2);
    }

    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(12, a2);
    }

    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(13, a2);
    }

    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(14, a2);
    }

    public final void setCurrentScreen(b bVar, String str, String str2, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeLong(j);
        b(15, a2);
    }

    public final void getCurrentScreenName(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(16, a2);
    }

    public final void getCurrentScreenClass(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(17, a2);
    }

    public final void setInstanceIdProvider(mh mhVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) mhVar);
        b(18, a2);
    }

    public final void getCachedAppInstanceId(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(19, a2);
    }

    public final void getAppInstanceId(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(20, a2);
    }

    public final void getGmpAppId(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(21, a2);
    }

    public final void generateEventId(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(22, a2);
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(23, a2);
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        b(24, a2);
    }

    public final void onActivityStarted(b bVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeLong(j);
        b(25, a2);
    }

    public final void onActivityStopped(b bVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeLong(j);
        b(26, a2);
    }

    public final void onActivityCreated(b bVar, Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        r.a(a2, (Parcelable) bundle);
        a2.writeLong(j);
        b(27, a2);
    }

    public final void onActivityDestroyed(b bVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeLong(j);
        b(28, a2);
    }

    public final void onActivityPaused(b bVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeLong(j);
        b(29, a2);
    }

    public final void onActivityResumed(b bVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        a2.writeLong(j);
        b(30, a2);
    }

    public final void onActivitySaveInstanceState(b bVar, lw lwVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) bVar);
        r.a(a2, (IInterface) lwVar);
        a2.writeLong(j);
        b(31, a2);
    }

    public final void performAction(Bundle bundle, lw lwVar, long j) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) bundle);
        r.a(a2, (IInterface) lwVar);
        a2.writeLong(j);
        b(32, a2);
    }

    public final void logHealthData(int i2, String str, b bVar, b bVar2, b bVar3) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i2);
        a2.writeString(str);
        r.a(a2, (IInterface) bVar);
        r.a(a2, (IInterface) bVar2);
        r.a(a2, (IInterface) bVar3);
        b(33, a2);
    }

    public final void setEventInterceptor(mg mgVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) mgVar);
        b(34, a2);
    }

    public final void registerOnMeasurementEventListener(mg mgVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) mgVar);
        b(35, a2);
    }

    public final void unregisterOnMeasurementEventListener(mg mgVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) mgVar);
        b(36, a2);
    }

    public final void initForTests(Map map) throws RemoteException {
        Parcel a2 = a();
        a2.writeMap(map);
        b(37, a2);
    }

    public final void getTestFlag(lw lwVar, int i2) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        a2.writeInt(i2);
        b(38, a2);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, z);
        b(39, a2);
    }

    public final void isDataCollectionEnabled(lw lwVar) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (IInterface) lwVar);
        b(40, a2);
    }
}
