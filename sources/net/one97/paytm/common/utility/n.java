package net.one97.paytm.common.utility;

import android.app.Activity;
import kotlin.g.b.k;
import net.one97.paytm.core.R;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49621a = new a((byte) 0);

    public interface c {
        void Z_();

        void a(String str, String str2, String str3);

        void a(b bVar);

        void b();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public enum b {
        ;

        public abstract int getErrorCode();

        public abstract String getErrorMessage(Activity activity);

        static final class c extends b {
            public final int getErrorCode() {
                return 0;
            }

            c(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_incorrect_mpin);
                k.a((Object) string, "context.getString(R.string.upi_incorrect_mpin)");
                return string;
            }
        }

        static final class g extends b {
            public final int getErrorCode() {
                return 1;
            }

            g(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_check_balance_error);
                k.a((Object) string, "context.getString(R.stri….upi_check_balance_error)");
                return string;
            }
        }

        /* renamed from: net.one97.paytm.common.utility.n$b$b  reason: collision with other inner class name */
        static final class C0883b extends b {
            public final int getErrorCode() {
                return 2;
            }

            C0883b(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_some_went_wrong);
                k.a((Object) string, "context.getString(R.string.upi_some_went_wrong)");
                return string;
            }
        }

        static final class e extends b {
            public final int getErrorCode() {
                return 3;
            }

            e(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_no_internet);
                k.a((Object) string, "context.getString(R.string.upi_no_internet)");
                return string;
            }
        }

        static final class f extends b {
            public final int getErrorCode() {
                return 4;
            }

            f(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_session_time_out_msg);
                k.a((Object) string, "context.getString(R.stri…upi_session_time_out_msg)");
                return string;
            }
        }

        static final class d extends b {
            public final int getErrorCode() {
                return 5;
            }

            d(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_incorrect_mpin_many_times);
                k.a((Object) string, "context.getString(R.stri…ncorrect_mpin_many_times)");
                return string;
            }
        }

        static final class a extends b {
            public final int getErrorCode() {
                return 6;
            }

            a(String str, int i2) {
                super(str, i2, (kotlin.g.b.g) null);
            }

            public final String getErrorMessage(Activity activity) {
                k.c(activity, "context");
                String string = activity.getString(R.string.upi_back_pressed_mpin_screen);
                k.a((Object) string, "context.getString(R.stri…back_pressed_mpin_screen)");
                return string;
            }
        }
    }
}
