package org.npci.upi.security.pinactivitycomponent;

import android.os.Process;
import com.business.merchant_payments.utility.StringUtility;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public class k implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    String f72994a = StringUtility.NEW_LINE;

    public void uncaughtException(Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        StringBuilder sb = new StringBuilder();
        sb.append("************ LOCATION OF ERROR ************\n\n");
        sb.append("NPCI Common Library");
        sb.append(this.f72994a);
        sb.append("\n************ CAUSE OF ERROR ************\n\n");
        sb.append(stringWriter.toString());
        sb.append(this.f72994a);
        Process.killProcess(Process.myPid());
    }
}
