package net.one97.paytm.wallet.utility;

import android.app.Activity;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.paytm.utility.b;

public final class e {
    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        }
        return "";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith("+91")) {
            i2 = 3;
        } else if (replaceAll.startsWith("91")) {
            i2 = 2;
        } else if (replaceAll.startsWith("0")) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && Character.isLetter(str.charAt(0));
    }

    public static void a(EditText editText, Activity activity) {
        editText.requestFocus();
        editText.postDelayed(new Runnable(activity, editText) {
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ EditText f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                e.b(this.f$0, this.f$1);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Activity activity, EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
                activity.getWindow().setSoftInputMode(20);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(EditText editText, Activity activity) {
        editText.requestFocus();
        editText.postDelayed(new Runnable(activity, editText) {
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ EditText f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                e.a(this.f$0, this.f$1);
            }
        }, 350);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
                activity.getWindow().setSoftInputMode(20);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
