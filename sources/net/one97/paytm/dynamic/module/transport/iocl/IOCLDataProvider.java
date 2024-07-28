package net.one97.paytm.dynamic.module.transport.iocl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl.activity.AJRIOCLHomeActivity;

public class IOCLDataProvider {
    public static void initIOCLTransport(Application application) {
        IOCLHelper instance = IOCLHelper.getInstance();
        IOCLGTMHelper instance2 = IOCLGTMHelper.getInstance();
        if (a.f14208a == null) {
            a.f14208a = new a();
        }
        a.a().f14209b = instance;
        a.a().f14210c = instance2;
    }

    public static Intent getIOCLHomeClassIntent(Context context) {
        return new Intent(context, AJRIOCLHomeActivity.class);
    }

    public static String getIOCLHomeClassName() {
        return AJRIOCLHomeActivity.class.getName();
    }
}
