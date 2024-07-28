package com.google.firebase.crashlytics.a.g;

import com.business.merchant_payments.common.utility.AppConstants;
import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class g implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final g f38597a = new g();

    private g() {
    }

    public static FilenameFilter a() {
        return f38597a;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(AppConstants.NOTIFICATION_DETAILS.EVENT);
    }
}
