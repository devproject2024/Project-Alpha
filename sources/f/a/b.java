package f.a;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13524a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f13525b = "₹";

    public static final boolean a(String str, Context context) {
        return a.a(str, context);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static String b(String str) {
            k.c(str, "str");
            try {
                String format = new DecimalFormat("₹ ##,##,##,##,###").format(new BigDecimal(str));
                k.a((Object) format, "formatter.format(parsed)");
                return format;
            } catch (Exception unused) {
                return "";
            }
        }

        public static String a(Integer num) {
            if (num != null && num.intValue() == 13) {
                return "insurance_type_2w";
            }
            if (num != null && num.intValue() == 9) {
                return "insurance_type_4w";
            }
            if (num != null && num.intValue() == 14) {
                return "insurance_type_health";
            }
            if (num != null && num.intValue() == 15) {
                return "insurance_type_life";
            }
            if (num != null && num.intValue() == 17) {
                return "insurance_type_new_vehicle";
            }
            return (num != null && num.intValue() == 18) ? "insurance_type_cycle" : " ";
        }

        public static String a(String str, String str2, String str3) {
            Date date;
            k.c(str, "dateTime");
            k.c(str2, "inputPattern");
            k.c(str3, "outputPattern");
            try {
                date = new SimpleDateFormat(str2).parse(str);
            } catch (ParseException e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
                date = null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.US);
            if (date == null) {
                return null;
            }
            return simpleDateFormat.format(date);
        }

        public static String b(String str, String str2, String str3) {
            Date date;
            k.c(str, "dateTime");
            k.c(str2, "inputPattern");
            k.c(str3, "outputPattern");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
                date = null;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3, Locale.US);
            if (date == null) {
                return null;
            }
            return simpleDateFormat2.format(date);
        }

        public static String a(String str) {
            k.c(str, "amount");
            if (p.a((CharSequence) str, (CharSequence) AppUtility.CENTER_DOT, false)) {
                return c(str);
            }
            return b(str);
        }

        private static String c(String str) {
            BigDecimal bigDecimal = new BigDecimal(str);
            String format = new DecimalFormat(b.f13525b + AppConstants.PRICE_PATTERN).format(bigDecimal.doubleValue());
            k.a((Object) format, "formatter.format(parsed.toDouble())");
            return format;
        }

        public static boolean a(String str, Context context) {
            k.c(str, "minVersion");
            k.c(context, "context");
            try {
                String Q = com.paytm.utility.b.Q(context);
                k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
                List<String> split = new l("\\.").split(Q, 0);
                List<String> split2 = new l("\\.").split(str, 0);
                int size = split.size() < split2.size() ? split.size() : split2.size();
                int i2 = 0;
                while (i2 < size) {
                    String str2 = split.get(i2);
                    if (str2 != null) {
                        int intValue = Integer.valueOf(p.b(str2).toString()).intValue();
                        String str3 = split2.get(i2);
                        if (str3 != null) {
                            Integer valueOf = Integer.valueOf(p.b(str3).toString());
                            k.a((Object) valueOf, "Integer.valueOf\n        …inVersionArray[i].trim())");
                            if (k.a(intValue, valueOf.intValue()) > 0) {
                                return true;
                            }
                            String str4 = split.get(i2);
                            if (str4 != null) {
                                int intValue2 = Integer.valueOf(p.b(str4).toString()).intValue();
                                String str5 = split2.get(i2);
                                if (str5 != null) {
                                    Integer valueOf2 = Integer.valueOf(p.b(str5).toString());
                                    k.a((Object) valueOf2, "Integer.valueOf(minVersionArray[i].trim())");
                                    if (k.a(intValue2, valueOf2.intValue()) < 0) {
                                        return false;
                                    }
                                    i2++;
                                } else {
                                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                int i3 = 0;
                for (String next : split) {
                    if (next != null) {
                        Integer valueOf3 = Integer.valueOf(p.b(next).toString());
                        k.a((Object) valueOf3, "Integer.valueOf(element.trim())");
                        i3 += valueOf3.intValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                int i4 = 0;
                for (String next2 : split2) {
                    if (next2 != null) {
                        Integer valueOf4 = Integer.valueOf(p.b(next2).toString());
                        k.a((Object) valueOf4, "Integer.valueOf(element.trim())");
                        i4 += valueOf4.intValue();
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                if (i3 >= i4) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
    }
}
