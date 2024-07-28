package exfilepicker.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f46123a = new SimpleDateFormat("mm:ss");

    public static String a(long j) {
        long j2 = j / 60000;
        long round = (long) Math.round(((float) (j % 60000)) / 1000.0f);
        String str = "";
        if (j2 < 10) {
            str = str + "0";
        }
        String str2 = str + j2 + AppConstants.COLON;
        if (round < 10) {
            str2 = str2 + "0";
        }
        return str2 + round;
    }
}
