package timber.log;

import com.business.merchant_payments.utility.StringUtility;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile C1468a[] f73052a = f73053b;

    /* renamed from: b  reason: collision with root package name */
    private static final C1468a[] f73053b = new C1468a[0];

    /* renamed from: c  reason: collision with root package name */
    private static final List<C1468a> f73054c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final C1468a f73055d = new C1468a() {
        public final void a(String str, Object... objArr) {
            for (C1468a a2 : a.f73052a) {
                a2.a(str, objArr);
            }
        }

        public final void b(String str, Object... objArr) {
            for (C1468a b2 : a.f73052a) {
                b2.b(str, objArr);
            }
        }

        public final void a(Throwable th) {
            for (C1468a a2 : a.f73052a) {
                a2.a(th);
            }
        }

        /* access modifiers changed from: protected */
        public final void a() {
            throw new AssertionError("Missing override for log method.");
        }
    };

    public static void a(String str, Object... objArr) {
        f73055d.a(str, objArr);
    }

    public static void b(String str, Object... objArr) {
        f73055d.b(str, objArr);
    }

    public static void a(Throwable th) {
        f73055d.a(th);
    }

    /* renamed from: timber.log.a$a  reason: collision with other inner class name */
    public static abstract class C1468a {

        /* renamed from: a  reason: collision with root package name */
        final ThreadLocal<String> f73056a = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        public abstract void a();

        private String b() {
            String str = this.f73056a.get();
            if (str != null) {
                this.f73056a.remove();
            }
            return str;
        }

        public void a(String str, Object... objArr) {
            a((Throwable) null, str, objArr);
        }

        public void b(String str, Object... objArr) {
            a((Throwable) null, str, objArr);
        }

        public void a(Throwable th) {
            a(th, (String) null, new Object[0]);
        }

        private void a(Throwable th, String str, Object... objArr) {
            b();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr != null && objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(StringUtility.NEW_LINE);
                    sb.append(b(th));
                }
            } else if (th != null) {
                b(th);
            } else {
                return;
            }
            a();
        }

        private static String b(Throwable th) {
            StringWriter stringWriter = new StringWriter(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }
}
