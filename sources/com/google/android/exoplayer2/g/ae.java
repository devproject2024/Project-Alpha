package com.google.android.exoplayer2.g;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.v;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.one97.paytm.upi.util.UpiConstants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final int f32499a = Build.VERSION.SDK_INT;

    /* renamed from: b  reason: collision with root package name */
    public static final String f32500b = Build.DEVICE;

    /* renamed from: c  reason: collision with root package name */
    public static final String f32501c = Build.MANUFACTURER;

    /* renamed from: d  reason: collision with root package name */
    public static final String f32502d = Build.MODEL;

    /* renamed from: e  reason: collision with root package name */
    public static final String f32503e = (f32500b + ", " + f32502d + ", " + f32501c + ", " + f32499a);

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f32504f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f32505g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f32506h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f32507i = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static HashMap<String, String> j;
    private static final String[] k = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "slo", "sk", "wel", "cy"};
    private static final int[] l;

    @EnsuresNonNull({"#1"})
    public static <T> T a(T t) {
        return t;
    }

    public static boolean a(int i2) {
        return i2 == 10 || i2 == 13;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] a(T[] tArr) {
        return tArr;
    }

    public static int b(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static long b(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j2 ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static int c(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public static boolean c(int i2) {
        return i2 == 3 || i2 == 2 || i2 == Integer.MIN_VALUE || i2 == 1073741824 || i2 == 4;
    }

    public static boolean d(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == 1073741824;
    }

    public static int f(int i2) {
        switch (i2) {
            case 1:
            case 12:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    static {
        int[] iArr = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        // fill-array-data instruction
        iArr[0] = 0;
        iArr[1] = 79764919;
        iArr[2] = 159529838;
        iArr[3] = 222504665;
        iArr[4] = 319059676;
        iArr[5] = 398814059;
        iArr[6] = 445009330;
        iArr[7] = 507990021;
        iArr[8] = 638119352;
        iArr[9] = 583659535;
        iArr[10] = 797628118;
        iArr[11] = 726387553;
        iArr[12] = 890018660;
        iArr[13] = 835552979;
        iArr[14] = 1015980042;
        iArr[15] = 944750013;
        iArr[16] = 1276238704;
        iArr[17] = 1221641927;
        iArr[18] = 1167319070;
        iArr[19] = 1095957929;
        iArr[20] = 1595256236;
        iArr[21] = 1540665371;
        iArr[22] = 1452775106;
        iArr[23] = 1381403509;
        iArr[24] = 1780037320;
        iArr[25] = 1859660671;
        iArr[26] = 1671105958;
        iArr[27] = 1733955601;
        iArr[28] = 2031960084;
        iArr[29] = 2111593891;
        iArr[30] = 1889500026;
        iArr[31] = 1952343757;
        iArr[32] = -1742489888;
        iArr[33] = -1662866601;
        iArr[34] = -1851683442;
        iArr[35] = -1788833735;
        iArr[36] = -1960329156;
        iArr[37] = -1880695413;
        iArr[38] = -2103051438;
        iArr[39] = -2040207643;
        iArr[40] = -1104454824;
        iArr[41] = -1159051537;
        iArr[42] = -1213636554;
        iArr[43] = -1284997759;
        iArr[44] = -1389417084;
        iArr[45] = -1444007885;
        iArr[46] = -1532160278;
        iArr[47] = -1603531939;
        iArr[48] = -734892656;
        iArr[49] = -789352409;
        iArr[50] = -575645954;
        iArr[51] = -646886583;
        iArr[52] = -952755380;
        iArr[53] = -1007220997;
        iArr[54] = -827056094;
        iArr[55] = -898286187;
        iArr[56] = -231047128;
        iArr[57] = -151282273;
        iArr[58] = -71779514;
        iArr[59] = -8804623;
        iArr[60] = -515967244;
        iArr[61] = -436212925;
        iArr[62] = -390279782;
        iArr[63] = -327299027;
        iArr[64] = 881225847;
        iArr[65] = 809987520;
        iArr[66] = 1023691545;
        iArr[67] = 969234094;
        iArr[68] = 662832811;
        iArr[69] = 591600412;
        iArr[70] = 771767749;
        iArr[71] = 717299826;
        iArr[72] = 311336399;
        iArr[73] = 374308984;
        iArr[74] = 453813921;
        iArr[75] = 533576470;
        iArr[76] = 25881363;
        iArr[77] = 88864420;
        iArr[78] = 134795389;
        iArr[79] = 214552010;
        iArr[80] = 2023205639;
        iArr[81] = 2086057648;
        iArr[82] = 1897238633;
        iArr[83] = 1976864222;
        iArr[84] = 1804852699;
        iArr[85] = 1867694188;
        iArr[86] = 1645340341;
        iArr[87] = 1724971778;
        iArr[88] = 1587496639;
        iArr[89] = 1516133128;
        iArr[90] = 1461550545;
        iArr[91] = 1406951526;
        iArr[92] = 1302016099;
        iArr[93] = 1230646740;
        iArr[94] = 1142491917;
        iArr[95] = 1087903418;
        iArr[96] = -1398421865;
        iArr[97] = -1469785312;
        iArr[98] = -1524105735;
        iArr[99] = -1578704818;
        iArr[100] = -1079922613;
        iArr[101] = -1151291908;
        iArr[102] = -1239184603;
        iArr[103] = -1293773166;
        iArr[104] = -1968362705;
        iArr[105] = -1905510760;
        iArr[106] = -2094067647;
        iArr[107] = -2014441994;
        iArr[108] = -1716953613;
        iArr[109] = -1654112188;
        iArr[110] = -1876203875;
        iArr[111] = -1796572374;
        iArr[112] = -525066777;
        iArr[113] = -462094256;
        iArr[114] = -382327159;
        iArr[115] = -302564546;
        iArr[116] = -206542021;
        iArr[117] = -143559028;
        iArr[118] = -97365931;
        iArr[119] = -17609246;
        iArr[120] = -960696225;
        iArr[121] = -1031934488;
        iArr[122] = -817968335;
        iArr[123] = -872425850;
        iArr[124] = -709327229;
        iArr[125] = -780559564;
        iArr[126] = -600130067;
        iArr[127] = -654598054;
        iArr[128] = 1762451694;
        iArr[129] = 1842216281;
        iArr[130] = 1619975040;
        iArr[131] = 1682949687;
        iArr[132] = 2047383090;
        iArr[133] = 2127137669;
        iArr[134] = 1938468188;
        iArr[135] = 2001449195;
        iArr[136] = 1325665622;
        iArr[137] = 1271206113;
        iArr[138] = 1183200824;
        iArr[139] = 1111960463;
        iArr[140] = 1543535498;
        iArr[141] = 1489069629;
        iArr[142] = 1434599652;
        iArr[143] = 1363369299;
        iArr[144] = 622672798;
        iArr[145] = 568075817;
        iArr[146] = 748617968;
        iArr[147] = 677256519;
        iArr[148] = 907627842;
        iArr[149] = 853037301;
        iArr[150] = 1067152940;
        iArr[151] = 995781531;
        iArr[152] = 51762726;
        iArr[153] = 131386257;
        iArr[154] = 177728840;
        iArr[155] = 240578815;
        iArr[156] = 269590778;
        iArr[157] = 349224269;
        iArr[158] = 429104020;
        iArr[159] = 491947555;
        iArr[160] = -248556018;
        iArr[161] = -168932423;
        iArr[162] = -122852000;
        iArr[163] = -60002089;
        iArr[164] = -500490030;
        iArr[165] = -420856475;
        iArr[166] = -341238852;
        iArr[167] = -278395381;
        iArr[168] = -685261898;
        iArr[169] = -739858943;
        iArr[170] = -559578920;
        iArr[171] = -630940305;
        iArr[172] = -1004286614;
        iArr[173] = -1058877219;
        iArr[174] = -845023740;
        iArr[175] = -916395085;
        iArr[176] = -1119974018;
        iArr[177] = -1174433591;
        iArr[178] = -1262701040;
        iArr[179] = -1333941337;
        iArr[180] = -1371866206;
        iArr[181] = -1426332139;
        iArr[182] = -1481064244;
        iArr[183] = -1552294533;
        iArr[184] = -1690935098;
        iArr[185] = -1611170447;
        iArr[186] = -1833673816;
        iArr[187] = -1770699233;
        iArr[188] = -2009983462;
        iArr[189] = -1930228819;
        iArr[190] = -2119160460;
        iArr[191] = -2056179517;
        iArr[192] = 1569362073;
        iArr[193] = 1498123566;
        iArr[194] = 1409854455;
        iArr[195] = 1355396672;
        iArr[196] = 1317987909;
        iArr[197] = 1246755826;
        iArr[198] = 1192025387;
        iArr[199] = 1137557660;
        iArr[200] = 2072149281;
        iArr[201] = 2135122070;
        iArr[202] = 1912620623;
        iArr[203] = 1992383480;
        iArr[204] = 1753615357;
        iArr[205] = 1816598090;
        iArr[206] = 1627664531;
        iArr[207] = 1707420964;
        iArr[208] = 295390185;
        iArr[209] = 358241886;
        iArr[210] = 404320391;
        iArr[211] = 483945776;
        iArr[212] = 43990325;
        iArr[213] = 106832002;
        iArr[214] = 186451547;
        iArr[215] = 266083308;
        iArr[216] = 932423249;
        iArr[217] = 861060070;
        iArr[218] = 1041341759;
        iArr[219] = 986742920;
        iArr[220] = 613929101;
        iArr[221] = 542559546;
        iArr[222] = 756411363;
        iArr[223] = 701822548;
        iArr[224] = -978770311;
        iArr[225] = -1050133554;
        iArr[226] = -869589737;
        iArr[227] = -924188512;
        iArr[228] = -693284699;
        iArr[229] = -764654318;
        iArr[230] = -550540341;
        iArr[231] = -605129092;
        iArr[232] = -475935807;
        iArr[233] = -413084042;
        iArr[234] = -366743377;
        iArr[235] = -287118056;
        iArr[236] = -257573603;
        iArr[237] = -194731862;
        iArr[238] = -114850189;
        iArr[239] = -35218492;
        iArr[240] = -1984365303;
        iArr[241] = -1921392450;
        iArr[242] = -2143631769;
        iArr[243] = -2063868976;
        iArr[244] = -1698919467;
        iArr[245] = -1635936670;
        iArr[246] = -1824608069;
        iArr[247] = -1744851700;
        iArr[248] = -1347415887;
        iArr[249] = -1418654458;
        iArr[250] = -1506661409;
        iArr[251] = -1561119128;
        iArr[252] = -1129027987;
        iArr[253] = -1200260134;
        iArr[254] = -1254728445;
        iArr[255] = -1309196108;
        l = iArr;
    }

    public static ComponentName a(Context context, Intent intent) {
        if (f32499a >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || CommunityPostActivity.TYPE_FILE.equals(scheme);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean a(Object[] objArr, Object obj) {
        for (Object a2 : objArr) {
            if (a(a2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T> void a(List<T> list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        } else if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static <T> T[] a(T[] tArr, int i2) {
        a.a(i2 <= tArr.length);
        return Arrays.copyOf(tArr, i2);
    }

    public static <T> T[] a(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    public static Handler a(Handler.Callback callback) {
        return a(a(), callback);
    }

    public static Handler a(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Looper a() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static ExecutorService a(String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Thread newThread(Runnable runnable) {
                return ae.a(this.f$0, runnable);
            }
        });
    }

    public static void a(i iVar) {
        if (iVar != null) {
            try {
                iVar.c();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (f32499a >= 21) {
            replace = Locale.forLanguageTag(replace).toLanguageTag();
        }
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        String d2 = d(str);
        String str2 = d2.split("-", 2)[0];
        if (str2.length() != 3) {
            return d2;
        }
        if (j == null) {
            j = c();
        }
        String str3 = j.get(str2);
        if (str3 == null) {
            return d2;
        }
        return str3 + d2.substring(3);
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Charset.forName(AppConstants.UTF_8));
    }

    public static String a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charset.forName(AppConstants.UTF_8));
    }

    public static byte[] c(String str) {
        return str.getBytes(Charset.forName(AppConstants.UTF_8));
    }

    public static String[] a(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] b(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String d(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    public static String e(String str) {
        return str == null ? str : str.toUpperCase(Locale.US);
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int a(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static long a(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static long a(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static float a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static int a(long[] jArr, long j2, boolean z) {
        int i2;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j2) {
                    i2 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j2);
            i2 = binarySearch + 1;
        }
        return z ? Math.max(0, i2) : i2;
    }

    public static <T extends Comparable<? super T>> int a(List<? extends Comparable<? super T>> list, T t, boolean z) {
        int i2;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || ((Comparable) list.get(binarySearch)).compareTo(t) != 0) {
                    i2 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (((Comparable) list.get(binarySearch)).compareTo(t) != 0);
            i2 = binarySearch + 1;
        }
        return z ? Math.max(0, i2) : i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r5 = ~r0
            goto L_0x0019
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r4.length
            if (r0 >= r1) goto L_0x0013
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0008
        L_0x0013:
            if (r7 == 0) goto L_0x0018
            int r5 = r0 + -1
            goto L_0x0019
        L_0x0018:
            r5 = r0
        L_0x0019:
            if (r8 == 0) goto L_0x0023
            int r4 = r4.length
            int r4 = r4 + -1
            int r4 = java.lang.Math.min(r4, r5)
            return r4
        L_0x0023:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.ae.a(long[], long, boolean, boolean):int");
    }

    public static long f(String str) {
        Matcher matcher = f32506h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d2 = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? 3600.0d * Double.parseDouble(group4) : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        if (group6 != null) {
            d2 = Double.parseDouble(group6);
        }
        long j2 = (long) ((parseDouble5 + d2) * 1000.0d);
        return isEmpty ? -j2 : j2;
    }

    public static long g(String str) throws v {
        Matcher matcher = f32505g.matcher(str);
        if (matcher.matches()) {
            int i2 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i2 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            return i2 != 0 ? timeInMillis - ((long) (i2 * 60000)) : timeInMillis;
        }
        throw new v("Invalid date/time format: ".concat(String.valueOf(str)));
    }

    public static long b(long j2, long j3, long j4) {
        int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
        if (i2 >= 0 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (i2 < 0 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        return (long) (((double) j2) * (((double) j3) / ((double) j4)));
    }

    public static long[] a(List<Long> list, long j2) {
        long[] jArr = new long[list.size()];
        int i2 = 0;
        int i3 = (j2 > 1000000 ? 1 : (j2 == 1000000 ? 0 : -1));
        if (i3 >= 0 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = list.get(i2).longValue() / j3;
                i2++;
            }
        } else if (i3 >= 0 || 1000000 % j2 != 0) {
            double d2 = 1000000.0d / ((double) j2);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) list.get(i2).longValue()) * d2);
                i2++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = list.get(i2).longValue() * j4;
                i2++;
            }
        }
        return jArr;
    }

    public static void a(long[] jArr, long j2) {
        int i2 = 0;
        int i3 = (j2 > 1000000 ? 1 : (j2 == 1000000 ? 0 : -1));
        if (i3 >= 0 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
        } else if (i3 >= 0 || 1000000 % j2 != 0) {
            double d2 = 1000000.0d / ((double) j2);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d2);
                i2++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j4;
                i2++;
            }
        }
    }

    public static long a(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) * ((double) f2));
    }

    public static long b(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) / ((double) f2));
    }

    public static long a(long j2, af afVar, long j3, long j4) {
        if (af.f31106a.equals(afVar)) {
            return j2;
        }
        long j5 = afVar.f31111f;
        long j6 = j2 - j5;
        if (((j5 ^ j2) & (j2 ^ j6)) < 0) {
            j6 = Long.MIN_VALUE;
        }
        long b2 = b(j2, afVar.f31112g);
        boolean z = true;
        boolean z2 = j6 <= j3 && j3 <= b2;
        if (j6 > j4 || j4 > b2) {
            z = false;
        }
        if (z2 && z) {
            return Math.abs(j3 - j2) <= Math.abs(j4 - j2) ? j3 : j4;
        }
        if (z2) {
            return j3;
        }
        return z ? j4 : j6;
    }

    public static int[] a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        return iArr;
    }

    public static int h(String str) {
        int length = str.length();
        a.a(length <= 4);
        char c2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            c2 = (c2 << 8) | str.charAt(i2);
        }
        return c2;
    }

    public static byte[] i(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public static String b(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.10.5";
    }

    public static String a(String str, int i2) {
        String[] j2 = j(str);
        if (j2.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : j2) {
            if (i2 == o.i(str2)) {
                if (sb.length() > 0) {
                    sb.append(AppConstants.COMMA);
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return str.trim().split("(\\s*,\\s*)", -1);
    }

    public static int e(int i2) {
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i3 = f32499a;
                return (i3 < 23 && i3 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int b(int i2, int i3) {
        if (i2 == Integer.MIN_VALUE) {
            return i3 * 3;
        }
        if (i2 != 1073741824) {
            if (i2 == 2) {
                return i3 * 2;
            }
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                throw new IllegalArgumentException();
            }
        }
        return i3 * 4;
    }

    public static int b(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return k(path);
    }

    public static int k(String str) {
        String d2 = d(str);
        if (d2.endsWith(".mpd")) {
            return 0;
        }
        if (d2.endsWith(".m3u8")) {
            return 2;
        }
        return d2.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    public static String a(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        long j3 = (j2 + 500) / 1000;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 60;
        long j6 = j3 / 3600;
        sb.setLength(0);
        if (j6 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j4)}).toString();
    }

    public static int b(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = l[((i3 >>> 24) ^ (bArr[i4] & 255)) & 255] ^ (i3 << 8);
        }
        return i3;
    }

    public static int a(Context context) {
        ConnectivityManager connectivityManager;
        int i2 = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i2 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        return 3;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 4;
                    case 13:
                        return 5;
                    case 18:
                        return 2;
                    default:
                        return 6;
                }
            }
        } catch (SecurityException unused) {
        }
        return i2;
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return e(networkCountryIso);
            }
        }
        return e(Locale.getDefault().getCountry());
    }

    public static boolean a(r rVar, r rVar2, Inflater inflater) {
        if (rVar.b() <= 0) {
            return false;
        }
        byte[] bArr = rVar2.f32566a;
        if (bArr.length < rVar.b()) {
            bArr = new byte[(rVar.b() * 2)];
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(rVar.f32566a, rVar.f32567b, rVar.b());
        int i2 = 0;
        while (true) {
            try {
                i2 += inflater.inflate(bArr, i2, bArr.length - i2);
                if (inflater.finished()) {
                    rVar2.a(bArr, i2);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i2 == bArr.length) {
                    bArr = Arrays.copyOf(bArr, bArr.length * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static HashMap<String, String> c() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + k.length);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = k;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static void a(Throwable th) {
        throw th;
    }

    public static String[] b() {
        String[] strArr;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i2 = f32499a;
        if (i2 >= 24) {
            strArr = configuration.getLocales().toLanguageTags().split(AppConstants.COMMA, -1);
        } else {
            strArr = i2 >= 21 ? new String[]{configuration.locale.toLanguageTag()} : new String[]{configuration.locale.toString()};
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = b(strArr[i3]);
        }
        return strArr;
    }
}
