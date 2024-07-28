package com.paytm.notification.c;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43021a = new a();

    private a() {
    }

    public static long a(String str) {
        if (str == null) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConstants.DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date parse = simpleDateFormat.parse(str);
        k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        return parse.getTime();
    }

    public static String a(long j) {
        try {
            long j2 = j / 86400000;
            long j3 = j % 86400000;
            long j4 = j3 / 3600000;
            long j5 = j3 % 3600000;
            return j2 + " d, " + j4 + " h, " + (j5 / 60000) + " m, " + ((j5 % 60000) / 1000) + " s";
        } catch (Exception unused) {
            return SDKConstants.UNKNOWN;
        }
    }
}
