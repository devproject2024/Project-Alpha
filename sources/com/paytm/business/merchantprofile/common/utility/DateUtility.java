package com.paytm.business.merchantprofile.common.utility;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtility {
    public static final String BW_DATE_INPUT_FORMAT = "dd MMM yy HH:mm:ss";
    public static final String DD_MMMM_YY_FORMAT = "dd MMMM yy";
    public static final String DD_MMM_DATE_FORMAT = "dd MMM";
    public static final String DD_MMM_YY_FORMAT = "dd MMM yy";
    public static final String DEEP_LINK_FORMAT = "dd/MM/yyyy";
    public static final String DISPLAY_DATE_FORMAT = "dd MMMM yyyy";
    public static final String DISPLAY_TIME_FORMAT = "hh:mm a";
    public static final String D_MM_DATE_FORMAT = "d MMM";
    public static final String GA_DATE_FORMAT_SETTLMENT = "dd-MM-yyyy";
    public static final String HEADER_OUTPUT_DATE_FORMAT = "EEE, dd MMM yyyy";
    public static final String INPUT_24_HOUR = "HH:mm:ss";
    public static final String INPUT_DATE_FORMAT_OFFLINE = "dd/MM/yyyy";
    public static final String INPUT_DATE_FORMAT_ONLINE = "yyyy-MM-dd";
    public static final String INPUT_DATE_FORMAT_ONLINE_2 = "MM/dd/yyyy";
    public static final String INPUT_DATE_TIME_FORMAT_OFFLINE = "dd/MM/yyyy HH:mm:ss";
    public static final String INPUT_DATE_TIME_FORMAT_ONLINE = "yyyy-MM-dd HH:mm:ss.0";
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String LAST_SETTLEMENT_HOME_DATE_FORMAT = "dd MMM, hh:mm:ss a";
    public static final String MONTH_YEAR_FORMAT = "MMM yyyy";
    public static final String OFFLINE_HEADER_DATE_FORMAT = "d MMM ''yy";
    public static final String OUTPUT_DATE_FORMAT_COMMON = "dd MMM yyyy";
    public static final String OUTPUT_DATE_FORMAT_LAST = "dd MMM";
    public static final String OUTPUT_DATE_FORMAT_SETTLEMENT_COMPLETE_MONTH = "dd MMM, HH:mm a";
    public static final String P4B_NEW_DATE_FORMAT = "dd MMMM";
    public static final String REFUND_DATE_TIME_FORMAT_ONLINE = "yyyy-MM-dd HH:mm:ss";
    public static final String REFUND_DETAIL_FORMAT_NEW = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String SETTLEMENT_DATE_FORMAT_CUSTOMDATE = "dd-MM-yyyy";
    public static final String SETTLEMENT_V3_DISPLAY_TIME_FORMAT = "h:mm a";
    public static final String TICKET_INPUT_DATE_FORMAT = "d/MM/yyyy";
    public static final String TIME_DATE_FORMAT = "hh:mm:ss a, dd MMMM yyyy";
    public static final String TXN_DETAIL_FORMAT = "HH:mm a, dd MMMM yyyy";
    public static final String TXN_DETAIL_FORMAT_NEW = "dd MMM yyyy, hh:mm a";
    public static final String TXN_OUTPUT_FORMAT_FOR_UTR = "dd-MM-yyyy HH:mm:ss";
    public static final String V2_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";

    public static String getFormattedDate(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        try {
            return new SimpleDateFormat(str3, Locale.getDefault()).format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    public static String getFormattedDateLowerCase(String str, String str2, String str3) {
        String str4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        try {
            str4 = new SimpleDateFormat(str3, Locale.US).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            str4 = "";
        }
        if (!str4.contains(" ")) {
            return str4;
        }
        return str4.split(" ")[0] + " " + str4.substring(str4.indexOf(" "), str4.length()).toLowerCase();
    }

    public static String getFormattedDate(long j, String str) {
        return new SimpleDateFormat(str, Locale.US).format(new Date(j));
    }

    public static String getCurrentFormattedDate(String str) {
        return new SimpleDateFormat(str, Locale.US).format(Calendar.getInstance().getTime());
    }

    public static String getYesterdayEndDate(String str) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        return new SimpleDateFormat(str, Locale.US).format(instance.getTime());
    }

    public static String getYesterdayStartDate(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(5, -1);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        return new SimpleDateFormat(str, Locale.US).format(gregorianCalendar.getTime());
    }

    public static String getBWalletDetailDateHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(" ");
        if (split.length < 6) {
            return null;
        }
        String str2 = split[split.length - 1];
        String str3 = split[1];
        String str4 = split[2];
        String displayName = Calendar.getInstance().getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf = String.valueOf(Calendar.getInstance().get(1));
        String valueOf2 = String.valueOf(Calendar.getInstance().get(5));
        if (valueOf2.length() == 1) {
            valueOf2 = "0".concat(String.valueOf(valueOf2));
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        String displayName2 = instance.getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf3 = String.valueOf(instance.get(1));
        String valueOf4 = String.valueOf(instance.get(5));
        if (valueOf4.length() == 1) {
            valueOf4 = "0".concat(String.valueOf(valueOf4));
        }
        if (str2.equalsIgnoreCase(valueOf) && str3.equalsIgnoreCase(displayName) && str4.equalsIgnoreCase(valueOf2)) {
            return ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today) + ", " + addSuffixToDate(str4) + " " + str3;
        } else if (!str2.equalsIgnoreCase(valueOf3) || !str3.equalsIgnoreCase(displayName2) || !str4.equalsIgnoreCase(valueOf4)) {
            return addSuffixToDate(str4) + " " + str3;
        } else {
            return ProfileConfig.getInstance().getAppContext().getString(R.string.pr_yesterday) + ", " + addSuffixToDate(str4) + " " + str3;
        }
    }

    public static String getSettlementListDateHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("/");
        if (split.length < 3) {
            return null;
        }
        String str2 = split[split.length - 1];
        String str3 = split[1];
        String str4 = split[0];
        Calendar instance = Calendar.getInstance();
        instance.set(2, Integer.parseInt(str3) - 1);
        String displayName = instance.getDisplayName(2, 1, Locale.ENGLISH);
        String displayName2 = Calendar.getInstance().getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf = String.valueOf(Calendar.getInstance().get(1));
        String valueOf2 = String.valueOf(Calendar.getInstance().get(5));
        if (valueOf2.length() == 1) {
            valueOf2 = "0".concat(String.valueOf(valueOf2));
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, -1);
        String displayName3 = instance2.getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf3 = String.valueOf(instance2.get(1));
        String valueOf4 = String.valueOf(instance2.get(5));
        if (valueOf4.length() == 1) {
            valueOf4 = "0".concat(String.valueOf(valueOf4));
        }
        if (str2.equalsIgnoreCase(valueOf) && displayName.equalsIgnoreCase(displayName2) && str4.equalsIgnoreCase(valueOf2)) {
            return "TODAY, " + addSuffixToDate(str4) + " " + displayName;
        } else if (!str2.equalsIgnoreCase(valueOf3) || !displayName.equalsIgnoreCase(displayName3) || !str4.equalsIgnoreCase(valueOf4)) {
            return addSuffixToDate(str4) + " " + displayName;
        } else {
            return "YESTERDAY, " + addSuffixToDate(str4) + " " + displayName;
        }
    }

    public static String getTransactionListDateHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("-");
        if (split.length < 3) {
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[split.length - 1];
        Calendar instance = Calendar.getInstance();
        instance.set(2, Integer.parseInt(str3) - 1);
        String displayName = instance.getDisplayName(2, 1, Locale.ENGLISH);
        String displayName2 = Calendar.getInstance().getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf = String.valueOf(Calendar.getInstance().get(1));
        String valueOf2 = String.valueOf(Calendar.getInstance().get(5));
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, -1);
        String displayName3 = instance2.getDisplayName(2, 1, Locale.ENGLISH);
        String valueOf3 = String.valueOf(instance2.get(1));
        String valueOf4 = String.valueOf(instance2.get(5));
        if (str2.equalsIgnoreCase(valueOf) && displayName.equalsIgnoreCase(displayName2) && str4.equalsIgnoreCase(valueOf2)) {
            return ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today).toUpperCase() + ", " + addSuffixToDate(str4) + " " + displayName;
        } else if (!str2.equalsIgnoreCase(valueOf3) || !displayName.equalsIgnoreCase(displayName3) || !str4.equalsIgnoreCase(valueOf4)) {
            return addSuffixToDate(str4) + " " + displayName;
        } else {
            return ProfileConfig.getInstance().getAppContext().getString(R.string.pr_yesterday).toUpperCase() + ", " + addSuffixToDate(str4) + " " + displayName;
        }
    }

    public static String addSuffixToDate(String str) {
        if (str.endsWith("1") && !str.endsWith("11")) {
            return str + H5Param.SHOW_TITLEBAR;
        } else if (str.endsWith("2") && !str.endsWith("12")) {
            return str + "nd";
        } else if (!str.endsWith("3") || str.endsWith("13")) {
            return str + "th";
        } else {
            return str + "th";
        }
    }

    public static String getCurrentYear() {
        return getCurrentFormattedDate("yyyy");
    }

    public static String getMonthStartDate(String str) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(5, 1);
            instance.set(10, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            return new SimpleDateFormat(str).format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getWeekStartDate(String str) {
        List<String> currentWeek = getCurrentWeek();
        return (currentWeek == null || currentWeek.size() <= 0) ? "" : getFormattedDate(splitDate(currentWeek.get(0)), "dd/MM/yyyy", str);
    }

    public static List<String> getCurrentWeek() {
        try {
            Calendar instance = Calendar.getInstance();
            if (instance.get(7) == 1) {
                instance.add(6, -6);
            } else {
                instance.add(7, 2 - instance.get(7));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
            ArrayList arrayList = new ArrayList();
            arrayList.add(simpleDateFormat.format(instance.getTime()));
            arrayList.add(simpleDateFormat.format(Calendar.getInstance().getTime()));
            return getFormatTime(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<String> getFormatTime(List<String> list) {
        String[] split = list.get(0).split(" ");
        String replace = split[1].replace(split[1], "00:00:00");
        list.set(0, split[0] + " " + replace);
        return list;
    }

    public static List<String> getCurrentMonth() {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        int i2 = Calendar.getInstance().get(6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        ArrayList arrayList = new ArrayList();
        for (int i3 = instance.get(6); i3 <= i2; i3++) {
            arrayList.add(simpleDateFormat.format(instance.getTime()));
            System.out.print(instance.getTime());
            instance.add(5, 1);
        }
        return getFormatTime(arrayList);
    }

    public static String getThisMonthRange(Context context) {
        String currentFormattedDate = getCurrentFormattedDate("dd MMM");
        String firstDateOfMonth = getFirstDateOfMonth(new Date());
        return "(" + firstDateOfMonth + " " + context.getResources().getString(R.string.pr_to) + " " + currentFormattedDate + ")";
    }

    public static String getLastThirtyDaysDate(String str, String str2) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(2, -1);
        gregorianCalendar.add(5, 1);
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    public static String getPreviousDaysDate(String str, String str2) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, -1);
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    public static String getLastThirtyDaysDate(String str) {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(2, -1);
        gregorianCalendar.add(5, 1);
        return new SimpleDateFormat(str, Locale.US).format(gregorianCalendar.getTime());
    }

    public static Date getLastThirtyDaysDateObject() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, -30);
        return gregorianCalendar.getTime();
    }

    public static Date getLastSixMonthsDateObject() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(2, -6);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        return gregorianCalendar.getTime();
    }

    public static Date getLastYearObject() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, 1);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.add(1, -1);
        return gregorianCalendar.getTime();
    }

    public static String getThirtyDaysDate(String str) {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, -30);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        return new SimpleDateFormat(str, Locale.US).format(gregorianCalendar.getTime());
    }

    public static String getTodayMidDateForUTR(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        return new SimpleDateFormat(str, Locale.US).format(gregorianCalendar.getTime());
    }

    public static List<String> getCurrentWeekForUTR(String str) {
        Calendar instance = Calendar.getInstance();
        instance.get(6);
        instance.get(1);
        if (instance.get(7) == 1) {
            instance.add(6, -6);
        } else {
            instance.add(7, 2 - instance.get(7));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        ArrayList arrayList = new ArrayList();
        instance.get(1);
        arrayList.add(simpleDateFormat.format(instance.getTime()));
        arrayList.add(simpleDateFormat.format(Calendar.getInstance().getTime()));
        return (str.equalsIgnoreCase("dd/MM/yyyy") || str.equals("yyyy-MM-dd")) ? arrayList : getFormatTime(arrayList);
    }

    public static String getCurrentWeekStart(String str) {
        try {
            Calendar instance = Calendar.getInstance();
            if (instance.get(7) == 1) {
                instance.add(6, -6);
            } else {
                instance.add(7, 2 - instance.get(7));
            }
            return new SimpleDateFormat(str, Locale.US).format(instance.getTime());
        } catch (Exception e2) {
            e2.printStackTrace();
            return getTodayStartDate(str);
        }
    }

    public static List<String> getCurrentMonthForUTR(String str) {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        int i2 = Calendar.getInstance().get(6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        ArrayList arrayList = new ArrayList();
        for (int i3 = instance.get(6); i3 <= i2; i3++) {
            arrayList.add(simpleDateFormat.format(instance.getTime()));
            System.out.print(instance.getTime());
            instance.add(5, 1);
        }
        if (str.equalsIgnoreCase("dd/MM/yyyy")) {
            return arrayList;
        }
        return getFormatTime(arrayList);
    }

    public static String getFirstDateOfMonth(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(5, instance.getActualMinimum(5));
        return new SimpleDateFormat("dd MMM", Locale.US).format(instance.getTime());
    }

    public static String getRelativeTimeTwoDaysFormat(String str, String str2, Context context) {
        String str3 = str;
        String str4 = str2;
        String[] split = str3.split(" ");
        if (split.length <= 1) {
            return str3;
        }
        String str5 = split[1];
        String formattedDate = getFormattedDate(split[0], str4.split(" ")[0], "dd MMM");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str4, Locale.US);
        Date date = new Date();
        try {
            long time = date.getTime() - simpleDateFormat.parse(str3).getTime();
            int date2 = getDate(getFormattedDate(str3, str4, "dd mm"));
            int date3 = getDate(new SimpleDateFormat("dd mm", Locale.US).format(date));
            if (date3 == 0 || date2 == 0) {
                return formattedDate + ", " + getFormattedDate(str5, "HH:mm:ss", "hh:mm a");
            }
            int i2 = date3 - date2;
            if (i2 == 0) {
                long j = time / 1000;
                long j2 = time / 60000;
                long j3 = time / 3600000;
                if (j >= 0 && j < 60) {
                    return j + " " + context.getResources().getString(R.string.pr_sec_ago);
                } else if (j2 >= 0 && j2 < 60) {
                    return j2 + " " + context.getResources().getString(R.string.pr_min_ago);
                } else if (j3 > 0 && j3 == 1) {
                    return j3 + " " + context.getResources().getString(R.string.pr_hr_ago);
                } else if (j3 > 1) {
                    return j3 + " " + context.getResources().getString(R.string.pr_hrs_ago);
                } else {
                    return formattedDate + ", " + getFormattedDate(str5, "HH:mm:ss", "hh:mm a");
                }
            } else if (i2 == 1) {
                return context.getResources().getString(R.string.pr_yesterday_at) + " " + getFormattedDate(str5, "HH:mm:ss", "hh:mm a");
            } else {
                return formattedDate + ", " + getFormattedDate(str5, "HH:mm:ss", "hh:mm a");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int getDate(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Integer.parseInt(str.substring(0, str.indexOf(" ")));
        }
        return 0;
    }

    public static boolean checkDateIsTodayDate(String str) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date()).equals(str);
    }

    public static String splitDate(String str) {
        return str.split(" ")[0];
    }

    public static String formatAggregateDate(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(" ");
        String formattedDate = getFormattedDate(split[0], "dd/MM/yyyy", "yyyy-MM-dd");
        return formattedDate + " " + split[1];
    }

    public static String constructDateDisplayFormatForSettlement(String str, String str2) {
        try {
            ProfileConfig.getInstance().getAppContext();
            String formattedDate = getFormattedDate(str, "dd-MM-yyyy HH:mm:ss", "dd MMM");
            String formattedDate2 = getFormattedDate(str2, "dd-MM-yyyy HH:mm:ss", "dd MMM");
            return formattedDate + " - " + formattedDate2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String constructDateDisplayFormat(String str, String str2, String str3, String str4) {
        try {
            ProfileConfig.getInstance().getAppContext();
            String formattedDate = getFormattedDate(str, str3, str4);
            String formattedDate2 = getFormattedDate(str2, str3, str4);
            return formattedDate + " - " + formattedDate2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getWeek() {
        List<String> currentWeek = getCurrentWeek();
        if (currentWeek == null || currentWeek.size() <= 0) {
            return null;
        }
        String splitDate = splitDate(currentWeek.get(0));
        String splitDate2 = splitDate(currentWeek.get(currentWeek.size() - 1));
        String formattedDate = getFormattedDate(splitDate, "dd/MM/yyyy", "dd MMM");
        String formattedDate2 = getFormattedDate(splitDate2, "dd/MM/yyyy", "dd MMM");
        return formattedDate + " " + ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_to) + " " + formattedDate2;
    }

    public static String getWeek(String str) {
        List<Date> currentWeekDates = getCurrentWeekDates();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        return simpleDateFormat.format(currentWeekDates.get(0)) + " " + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_to) + " " + simpleDateFormat.format(currentWeekDates.get(1));
    }

    public static List<Date> getCurrentWeekDates() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(7) == 1) {
            instance.add(6, -6);
        } else {
            instance.add(7, 2 - instance.get(7));
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(instance.getTime());
        arrayList.add(Calendar.getInstance().getTime());
        return arrayList;
    }

    public static boolean isExactlySameFormat(String str, String str2) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        simpleDateFormat.setLenient(false);
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        if (date != null) {
            return true;
        }
        return false;
    }

    public static String getOfflineCompatibleDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (isExactlySameFormat(str, "yyyy-MM-dd HH:mm:ss.0")) {
            return getFormattedDate(str, "yyyy-MM-dd HH:mm:ss.0", "dd/MM/yyyy HH:mm:ss");
        }
        return isExactlySameFormat(str, "yyyy-MM-dd HH:mm:ss") ? getFormattedDate(str, "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy HH:mm:ss") : str;
    }

    public static long getTimestamp(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public static String getDateAfter(String str, String str2, int i2, String str3, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        if (timeZone != null) {
            try {
                simpleDateFormat.setTimeZone(timeZone);
            } catch (ParseException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        Date parse = simpleDateFormat.parse(str);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(parse);
        gregorianCalendar.add(5, i2);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3, Locale.US);
        if (timeZone != null) {
            simpleDateFormat2.setTimeZone(timeZone);
        }
        return simpleDateFormat2.format(gregorianCalendar.getTime());
    }

    public static DateRange getCurrentWeekDateRange() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        if (instance.get(7) == 1) {
            instance.add(6, -6);
        } else {
            instance.add(7, 2 - instance.get(7));
        }
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return new DateRange(instance.getTime(), time);
    }

    public static DateRange getCurrentMonthDateRange() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        instance.set(5, instance.getActualMinimum(5));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return new DateRange(instance.getTime(), time);
    }

    public static DateRange getTodayDateRange() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return new DateRange(instance.getTime(), time);
    }

    public static DateRange getYesterDayRange() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        Date time = instance.getTime();
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        return new DateRange(time, instance.getTime());
    }

    public static int compareTimes(Date date, Date date2) {
        return date.after(date2) ? 1 : 0;
    }

    public static String addSuffixToFirstPart(String str) {
        String str2;
        String str3 = str.split(" ")[0];
        if (str3.endsWith("1") && !str3.endsWith("11")) {
            str2 = str3 + H5Param.SHOW_TITLEBAR;
        } else if (str3.endsWith("2") && !str3.endsWith("12")) {
            str2 = str3 + "nd";
        } else if (!str3.endsWith("3") || str3.endsWith("13")) {
            str2 = str3 + "th";
        } else {
            str2 = str3 + "rd";
        }
        return str2 + str.substring(str3.length());
    }

    public static int getDaysBetweenDates(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 0) {
            return (int) TimeUnit.MILLISECONDS.toDays(j3);
        }
        return 0;
    }

    public static String getDateFromTimeStamp(String str) {
        try {
            return new SimpleDateFormat("d MMM", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US).parse(str));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTimeFromTimeStamp(String str) {
        try {
            return new SimpleDateFormat("h:mm a", Locale.US).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US).parse(str));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getStartDateOfDifferentFormat(String str, String str2, String str3) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            return new SimpleDateFormat(str3, Locale.US).format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getEndDateOfDifferentFormat(String str, String str2, String str3) {
        try {
            if (isDateCurrentDate(str, str2)) {
                return getCurrentFormattedDate(str3);
            }
            Date parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            return new SimpleDateFormat(str3, Locale.US).format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String timeIn12HourFormat(int i2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (i2 > 12) {
                sb.append(i2 - 12);
                sb.append("pm");
                return sb.toString();
            } else if (i2 == 12) {
                sb.append(i2);
                sb.append("pm");
                return sb.toString();
            } else {
                sb.append(i2);
                sb.append("am");
                return sb.toString();
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isDateCurrentDate(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(str));
            Calendar instance2 = Calendar.getInstance();
            if (instance2.get(2) == instance.get(2) && instance2.get(5) == instance.get(5)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static int getDaysFromToday(String str, String str2) {
        try {
            return getDaysBetweenDates(getTimestamp(str, str2), Calendar.getInstance().getTimeInMillis());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String convertDateToDifferentFormat(String str, String str2, String str3) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return new SimpleDateFormat(str3, Locale.US).format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTimeDiffForSettlement(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str, Locale.US).parse(str2);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Calendar instance2 = Calendar.getInstance();
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            return String.valueOf((instance2.getTimeInMillis() - instance.getTimeInMillis()) / 86400000);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean areDatesOfSameDay(String str, String str2, String str3, String str4) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.US);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str4, Locale.US);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(str));
            instance2.setTime(simpleDateFormat2.parse(str2));
            if (instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static String getTodayStartDate(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        return new SimpleDateFormat(str, Locale.US).format(gregorianCalendar.getTime());
    }

    public static String getStartDateOfTimeStamp(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
            Date parse = simpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            return simpleDateFormat.format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean checkTodaysDate(Date date) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        return instance.get(2) == instance2.get(2) && instance.get(6) == instance2.get(6);
    }

    public static String getDateFromTimeStamp(String str, String str2) {
        try {
            return new SimpleDateFormat("d MMM", Locale.getDefault()).format(new SimpleDateFormat(str2, Locale.US).parse(str));
        } catch (Exception unused) {
            return "";
        }
    }
}
