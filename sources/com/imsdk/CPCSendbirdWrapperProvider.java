package com.imsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.appsflyer.AppsFlyerProperties;
import com.paytm.a;
import com.paytm.android.chat.utils.AppUtilKt;
import com.sendbird.android.SendBird;
import kotlin.g.b.k;

public final class CPCSendbirdWrapperProvider {
    public static final CPCSendbirdWrapperProvider INSTANCE = new CPCSendbirdWrapperProvider();
    private static CPCSendbirdWrapper sendbirdWrapper;

    private CPCSendbirdWrapperProvider() {
    }

    public static final synchronized CPCSendbirdWrapper getSendbirdWrapper(Application application, String str) {
        CPCSendbirdWrapper cPCSendbirdWrapper;
        synchronized (CPCSendbirdWrapperProvider.class) {
            k.c(application, "application");
            k.c(str, AppsFlyerProperties.APP_ID);
            if (AppUtilKt.isAppOnForeground()) {
                SendBird.initFromForeground(str, application.getApplicationContext());
            } else {
                SendBird.init(str, application.getApplicationContext());
            }
            SendBird.Options.setThreadOption(SendBird.Options.ThreadOption.NEW_THREAD, (Handler) null);
            a aVar = a.f40823c;
            Context context = application;
            k.c(context, "context");
            a.f40821a = context;
            a.c();
            if (sendbirdWrapper == null) {
                sendbirdWrapper = new CPCSendbirdWrapper();
            }
            cPCSendbirdWrapper = sendbirdWrapper;
            if (cPCSendbirdWrapper == null) {
                k.a();
            }
        }
        return cPCSendbirdWrapper;
    }
}
