package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import java.util.Map;

public interface kv extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(lw lwVar) throws RemoteException;

    void getAppInstanceId(lw lwVar) throws RemoteException;

    void getCachedAppInstanceId(lw lwVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, lw lwVar) throws RemoteException;

    void getCurrentScreenClass(lw lwVar) throws RemoteException;

    void getCurrentScreenName(lw lwVar) throws RemoteException;

    void getGmpAppId(lw lwVar) throws RemoteException;

    void getMaxUserProperties(String str, lw lwVar) throws RemoteException;

    void getTestFlag(lw lwVar, int i2) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, lw lwVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(b bVar, zzv zzv, long j) throws RemoteException;

    void isDataCollectionEnabled(lw lwVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, lw lwVar, long j) throws RemoteException;

    void logHealthData(int i2, String str, b bVar, b bVar2, b bVar3) throws RemoteException;

    void onActivityCreated(b bVar, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(b bVar, long j) throws RemoteException;

    void onActivityPaused(b bVar, long j) throws RemoteException;

    void onActivityResumed(b bVar, long j) throws RemoteException;

    void onActivitySaveInstanceState(b bVar, lw lwVar, long j) throws RemoteException;

    void onActivityStarted(b bVar, long j) throws RemoteException;

    void onActivityStopped(b bVar, long j) throws RemoteException;

    void performAction(Bundle bundle, lw lwVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(mg mgVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(b bVar, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setEventInterceptor(mg mgVar) throws RemoteException;

    void setInstanceIdProvider(mh mhVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, b bVar, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(mg mgVar) throws RemoteException;
}
