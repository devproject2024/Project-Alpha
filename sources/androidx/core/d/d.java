package androidx.core.d;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class d {
    public static String a(File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Environment.getExternalStorageState(file);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                return Environment.getExternalStorageState();
            }
            return SDKConstants.UNKNOWN;
        } catch (IOException e2) {
            new StringBuilder("Failed to resolve canonical path: ").append(e2);
            return SDKConstants.UNKNOWN;
        }
    }
}
