package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final String DATE_ONLY_FORMAT = "yyyy-MM-dd";
    public static final Locale LOCALE = Locale.US;
    private static final String TAG = DateUtil.class.getName();

    private static boolean validateDate(Date date) {
        return date != null;
    }

    public static DateUtil getInstance() {
        return new DateUtil();
    }

    public long getTimeInMillis(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str).getTime();
        } catch (Exception e2) {
            Bamboo.e(TAG, "", e2);
            return 0;
        }
    }

    public String getRoundedDifferenceInHours(long j, long j2) {
        long round = (long) Math.round((float) ((j - j2) / 60000));
        int i2 = (int) (round / 1440);
        long j3 = round - ((long) ((i2 * 24) * 60));
        int i3 = (int) (j3 / 60);
        long j4 = j3 - ((long) (i3 * 60));
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i2);
            if (i2 == 1) {
                sb.append(AppConstants.DAY);
            } else {
                sb.append(" days");
            }
        } else if (i3 > 0) {
            sb.append(i3);
            if (i3 == 1) {
                sb.append(AppConstants.HOUR);
            } else {
                sb.append(" hrs");
            }
        } else if (j4 > 0) {
            sb.append(j4);
            if (j4 == 1) {
                sb.append(AppConstants.MINUT);
            } else {
                sb.append(" mins");
            }
        } else {
            sb.append(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_JUST_NOW));
        }
        return sb.toString();
    }

    public static String toDateOnlyString(Date date) {
        if (!validateDate(date)) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd", LOCALE).format(date);
    }
}
