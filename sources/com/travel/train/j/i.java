package com.travel.train.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainLsDateModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f27561a = new SimpleDateFormat("EEE dd MMM");

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f27562b = new SimpleDateFormat("MMM dd EEE");

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f27563c = new SimpleDateFormat("dd MMM");

    /* renamed from: d  reason: collision with root package name */
    private static String f27564d = "CJRTrainDateUtils";

    public static String a(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("dd MMM yyyy").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String b(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("EEE, dd MMM").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String c(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("EEE, dd MMM").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String a(String str, String str2) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str3 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str3 = new SimpleDateFormat(str2).format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str3) ? str3 : str;
    }

    public static String a(String str, String str2, String str3, int i2) {
        if (!TextUtils.isEmpty(str)) {
            String str4 = null;
            String str5 = str + "T" + str2 + ":00";
            try {
                long time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str5).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                str4 = c(str5, new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)) + "T" + str3 + ":00");
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
            if (str4 != null) {
                return str4;
            }
        }
        return str3;
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        new SimpleDateFormat("HH:mm");
        try {
            long time = simpleDateFormat.parse(str).getTime();
            String[] split = str2.split(AppConstants.COLON);
            if (split == null || split[0] == null || split[1] == null) {
                return "";
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = new Date();
            date.setTime(time + TimeUnit.HOURS.toMillis((long) Integer.parseInt(split[0])) + TimeUnit.MINUTES.toMillis((long) Integer.parseInt(split[1])));
            return simpleDateFormat2.format(date);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-ddHH:mm").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String e(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("dd MMM").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String a(String str, String str2, String str3) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        String str4 = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str4 = new SimpleDateFormat(str3).format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str4) ? str4.replace("-", " ") : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r9, java.lang.String r10) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd'T'HH:mm:ss"
            r0.<init>(r1)
            r1 = 0
            java.util.Date r9 = r0.parse(r9)     // Catch:{ Exception -> 0x0038 }
            java.util.Date r10 = r0.parse(r10)     // Catch:{ Exception -> 0x0038 }
            long r3 = r10.getTime()     // Catch:{ Exception -> 0x0038 }
            long r9 = r9.getTime()     // Catch:{ Exception -> 0x0038 }
            long r3 = r3 - r9
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            long r5 = r3 / r9
            long r3 = r3 % r9
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r3 / r9
            long r3 = r3 % r9
            r9 = 60000(0xea60, double:2.9644E-319)
            long r9 = r3 / r9
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0042
            r3 = 24
            long r5 = r5 * r3
            long r7 = r7 + r5
            goto L_0x0042
        L_0x0036:
            r9 = move-exception
            goto L_0x003a
        L_0x0038:
            r9 = move-exception
            r7 = r1
        L_0x003a:
            java.lang.String r9 = r9.getMessage()
            com.paytm.utility.q.c(r9)
            r9 = r1
        L_0x0042:
            r0 = 1
            r3 = 0
            r4 = 2
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 <= 0) goto L_0x005a
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = java.lang.String.valueOf(r7)
            r5[r3] = r6
            java.lang.String r6 = " h "
            r5[r0] = r6
            java.lang.String r5 = com.paytm.utility.v.a((java.lang.String[]) r5)
            goto L_0x005b
        L_0x005a:
            r5 = 0
        L_0x005b:
            int r6 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x008a
            java.lang.String r1 = " m "
            if (r5 == 0) goto L_0x007b
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L_0x007b
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]
            r2[r3] = r5
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r2[r0] = r9
            r2[r4] = r1
            java.lang.String r9 = com.paytm.utility.v.a((java.lang.String[]) r2)
            goto L_0x0089
        L_0x007b:
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r2[r3] = r9
            r2[r0] = r1
            java.lang.String r9 = com.paytm.utility.v.a((java.lang.String[]) r2)
        L_0x0089:
            r5 = r9
        L_0x008a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.i.c(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String f(String str) {
        Date date;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            date = null;
        }
        try {
            str2 = new SimpleDateFormat("HH:mm").format(date);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
        return !TextUtils.isEmpty(str2) ? str2.replace("-", " ") : str;
    }

    public static String d(String str, String str2) {
        return str + "T" + str2 + ":00";
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale(n.a(context, n.a())));
        try {
            return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, new Locale(n.a()));
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static boolean g(String str) {
        Date date;
        Date date2;
        try {
            if (str.contains(AppConstants.COMMA)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy, EEE");
                date = simpleDateFormat.parse(str);
                date2 = simpleDateFormat.parse(h("dd MMM yy, EEE"));
            } else {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yy");
                date = simpleDateFormat2.parse(str);
                date2 = simpleDateFormat2.parse(h("dd MMM yy"));
            }
            if (!date.after(date2) && date.before(date2)) {
                return true;
            }
            return false;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
        }
    }

    public static boolean a(String str, String str2, String str3, String str4) {
        try {
            if (new SimpleDateFormat(str2).parse(str).equals(new SimpleDateFormat(str4).parse(str3))) {
                return true;
            }
            return false;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    public static String c(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            return new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String h(String str) {
        return new SimpleDateFormat(str).format(Calendar.getInstance().getTime());
    }

    public static String a(Activity activity, String str, String str2, Date date) {
        if (n.a().equalsIgnoreCase("hi") || n.a().equalsIgnoreCase("ta") || n.a().equalsIgnoreCase("te") || n.a().equalsIgnoreCase("kn") || n.a().equalsIgnoreCase("pa") || n.a().equalsIgnoreCase("mr") || n.a().equalsIgnoreCase("gu") || n.a().equalsIgnoreCase("bn") || n.a().equalsIgnoreCase("or") || n.a().equalsIgnoreCase("ml")) {
            return b.a(date, str2);
        }
        return a(activity, date.toString(), str, str2);
    }

    public static String a(Activity activity, String str, String str2, String str3) {
        try {
            Locale locale = Locale.ENGLISH;
            return new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, locale).parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            com.travel.train.b.a();
            com.travel.train.b.b().a(activity, activity.getLocalClassName());
            return "";
        } catch (Exception e3) {
            q.c(e3.getMessage());
            com.travel.train.b.a();
            com.travel.train.b.b().a(activity, activity.getLocalClassName());
            return "";
        }
    }

    public static long a(Date date, Date date2, TimeUnit timeUnit) {
        return timeUnit.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS);
    }

    public static Date a(Activity activity, String str, Locale locale) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd MMMM yy", locale).parse(str);
        } catch (ParseException e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
            com.travel.train.b.a();
            com.travel.train.b.b().a(activity, activity.getLocalClassName());
            return null;
        }
    }

    public static int a(int i2, int i3, int i4) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.set(i2, i3, i4);
        int i5 = instance2.get(1) - instance.get(1);
        return instance2.get(6) < instance.get(6) ? i5 - 1 : i5;
    }

    public static List<CJRTrainLsDateModel> a(char[] cArr, CJRTrainLSSearchResult.Schedule schedule, String str) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        if (schedule == null) {
            return arrayList;
        }
        try {
            Date parse = simpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance(Locale.ENGLISH);
            instance.setTime(parse);
            if (instance == null && cArr == null) {
                return arrayList;
            }
            int i2 = instance.get(7) - 2;
            instance.add(5, -1);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                i3++;
                i4++;
                if (cArr[i2] == 'Y') {
                    arrayList.add(a(instance, schedule));
                }
                instance.add(5, -1);
                if (arrayList.size() >= 2) {
                    break;
                }
                if (i2 == 0 && i3 != cArr.length) {
                    i2 = cArr.length;
                } else if (i3 == cArr.length) {
                    i3 = 0;
                }
                if (i4 == 14) {
                    System.out.println("Two dates not found");
                    break;
                }
                i2--;
            }
            Collections.reverse(arrayList);
            return arrayList;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return arrayList;
        }
    }

    public static List<CJRTrainLsDateModel> b(char[] cArr, CJRTrainLSSearchResult.Schedule schedule, String str) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        if (schedule == null) {
            return arrayList;
        }
        Calendar calendar = null;
        try {
            Date parse = simpleDateFormat.parse(str);
            calendar = Calendar.getInstance(Locale.ENGLISH);
            calendar.setTime(parse);
        } catch (ParseException e2) {
            q.c(e2.getMessage());
        }
        if ((calendar == null) || (cArr == null)) {
            return arrayList;
        }
        int i2 = calendar.get(7) - 1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= cArr.length) {
                break;
            }
            i3++;
            i4++;
            if (cArr[i2] == 'Y') {
                arrayList.add(a(calendar, schedule));
            }
            calendar.add(5, 1);
            if (arrayList.size() >= 2) {
                break;
            }
            if (i2 == cArr.length - 1 && i3 != cArr.length) {
                i2 = -1;
            } else if (i3 == cArr.length) {
                i3 = 0;
            }
            if (i4 == 14) {
                System.out.println("Two dates not found");
                break;
            }
            i2++;
        }
        return arrayList;
    }

    private static CJRTrainLsDateModel a(Calendar calendar, CJRTrainLSSearchResult.Schedule schedule) {
        CJRTrainLsDateModel cJRTrainLsDateModel = new CJRTrainLsDateModel();
        Calendar calendar2 = (Calendar) calendar.clone();
        if (schedule == null || TextUtils.isEmpty(schedule.getDayCount())) {
            int i2 = calendar.get(5);
            String displayName = calendar.getDisplayName(7, 2, Locale.ENGLISH);
            String displayName2 = calendar.getDisplayName(2, 1, Locale.ENGLISH);
            cJRTrainLsDateModel.setValue1(i2 + " " + displayName2);
            cJRTrainLsDateModel.setValue2(displayName);
        } else if (Integer.parseInt(schedule.getDayCount()) > 1) {
            calendar2.add(5, Integer.parseInt(schedule.getDayCount()) - 1);
            int i3 = calendar2.get(5);
            String displayName3 = calendar2.getDisplayName(7, 2, Locale.ENGLISH);
            String displayName4 = calendar2.getDisplayName(2, 1, Locale.ENGLISH);
            cJRTrainLsDateModel.setValue1(i3 + " " + displayName4);
            cJRTrainLsDateModel.setValue2(displayName3);
        } else {
            int i4 = calendar.get(5);
            String displayName5 = calendar.getDisplayName(7, 2, Locale.ENGLISH);
            String displayName6 = calendar.getDisplayName(2, 1, Locale.ENGLISH);
            cJRTrainLsDateModel.setValue1(i4 + " " + displayName6);
            cJRTrainLsDateModel.setValue2(displayName5);
        }
        DecimalFormat decimalFormat = new DecimalFormat("00");
        cJRTrainLsDateModel.setDate_str(calendar.get(1) + decimalFormat.format((long) (calendar.get(2) + 1)) + decimalFormat.format((long) calendar.get(5)));
        cJRTrainLsDateModel.setDate(calendar.getTime());
        long ceil = (long) Math.ceil((double) (((float) (calendar2.getTimeInMillis() - Calendar.getInstance(Locale.ENGLISH).getTimeInMillis())) / 8.64E7f));
        if (ceil >= 0 && ceil < 1) {
            cJRTrainLsDateModel.setToday(true);
        } else if (ceil >= 1 && ceil < 2) {
            cJRTrainLsDateModel.setTomorrow(true);
        }
        return cJRTrainLsDateModel;
    }

    public static String d(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    public static String b(Context context, String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", new Locale(n.a(context, n.a())));
        try {
            return new SimpleDateFormat("dd MMM yy", Locale.ENGLISH).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String i(String str) {
        Date i2 = b.i(str, "yyyyMMdd", "");
        if (i2 == null) {
            return null;
        }
        int a2 = b.a(i2);
        return v.a(b.d(str, "yyyyMMdd", "EEE"), AppConstants.COMMA, " ", String.valueOf(a2), b.b(a2), " ", b.a(i2, 1));
    }

    public static String a(String str, int i2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy");
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
        }
        instance.add(5, i2);
        return simpleDateFormat.format(new Date(instance.getTimeInMillis()));
    }

    public static Date a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static Date a(Date date, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, i2);
        return new Date(instance.getTimeInMillis());
    }

    public static String a() {
        return new SimpleDateFormat("dd MMM yy").format(Calendar.getInstance().getTime());
    }

    public static String j(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy, EEE");
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }
}
