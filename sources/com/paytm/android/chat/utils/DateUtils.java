package com.paytm.android.chat.utils;

import android.content.Context;
import com.paytm.android.chat.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private DateUtils() {
    }

    private static String getStringFromResource(Context context, int i2, String str) {
        return (context == null || i2 == 0) ? str : context.getString(i2);
    }

    public static String getMessageDate(long j, Context context) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (j >= instance.getTimeInMillis()) {
            return getStringFromResource(context, R.string.chat_module_chat_today, "Today");
        }
        if (j >= instance.getTimeInMillis() - 86400000) {
            return getStringFromResource(context, R.string.chat_module_chat_yesterday, "Yesterday");
        }
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static String formatTime(long j) {
        return new SimpleDateFormat("HH:mm t\\\\M", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static String formatTimeWithMarker(long j) {
        return new SimpleDateFormat("h:mm a", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static int getHourOfDay(long j) {
        return Integer.valueOf(new SimpleDateFormat("H", Locale.getDefault()).format(Long.valueOf(j))).intValue();
    }

    public static int getMinute(long j) {
        return Integer.valueOf(new SimpleDateFormat("m", Locale.getDefault()).format(Long.valueOf(j))).intValue();
    }

    public static String formatDateTime(long j) {
        if (isToday(j)) {
            return formatTime(j);
        }
        return formatDate(j);
    }

    public static String formatDateOr(long j, Context context) {
        if (isToday(j)) {
            return formatTimeWithMarker(j);
        }
        if (isYesterday(j)) {
            return getStringFromResource(context, R.string.chat_module_chat_yesterday, "Yesterday");
        }
        return formatDate(j);
    }

    public static boolean isYesterday(long j) {
        Calendar instance = Calendar.getInstance();
        clearCalendar(instance, 11, 12, 13, 14);
        instance.add(5, -1);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j);
        clearCalendar(instance, 11, 12, 13, 14);
        return timeInMillis == instance.getTimeInMillis();
    }

    private static void clearCalendar(Calendar calendar, int... iArr) {
        for (int i2 : iArr) {
            calendar.set(i2, 0);
        }
    }

    public static String formatDate(long j) {
        return new SimpleDateFormat("MMM dd", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static String formatDateMonthTime(long j) {
        return new SimpleDateFormat("dd MMM, h:mm a", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static boolean isToday(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    public static boolean hasSameDate(long j, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(j2)));
    }

    public static String secToTime2(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long j2 = j / 1000;
        long j3 = j2 / 60;
        if (j2 < 60) {
            return "00:" + unitFormat(j2);
        } else if (j3 < 60) {
            return unitFormat(j3) + AppConstants.COLON + unitFormat(j2 % 60);
        } else {
            long j4 = j3 / 60;
            long j5 = j3 % 60;
            return unitFormat(j4) + AppConstants.COLON + unitFormat(j5) + AppConstants.COLON + unitFormat((j2 - (3600 * j4)) - (60 * j5));
        }
    }

    public static String unitFormat(long j) {
        if (j < 0 || j >= 10) {
            return String.valueOf(j);
        }
        return "0".concat(String.valueOf(j));
    }

    public static String getAudioTime(long j) {
        if (j == 0) {
            return "";
        }
        return "(" + secToTime2(j) + ")";
    }

    public static String getCurrentDateTime(String str) {
        return new SimpleDateFormat(str).format(Calendar.getInstance().getTime());
    }

    public static String getDateTime(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getDateForSince(String str) {
        try {
            return new SimpleDateFormat("MMM YYYY", Locale.getDefault()).format(new SimpleDateFormat("MMM d, yyyy hh:mm:ss aaa", Locale.getDefault()).parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }
}
