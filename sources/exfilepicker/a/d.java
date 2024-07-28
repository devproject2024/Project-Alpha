package exfilepicker.a;

import android.content.Context;
import android.os.Build;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.android.chat.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;

public final class d {
    public static LinkedHashMap<String, String> a(Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            arrayList.addAll(Arrays.asList(context.getExternalCacheDirs()));
        } else {
            arrayList.add(context.getExternalCacheDir());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            File file = (File) it2.next();
            if (file != null) {
                String str = file.getPath().split("/Android")[0];
                linkedHashMap.put(str, new File(str).getName());
            }
        }
        return linkedHashMap;
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(AppUtility.CENTER_DOT);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase(Locale.getDefault());
    }

    public static String a(Context context, long j) {
        String[] stringArray = context.getResources().getStringArray(R.array.chat_module_efp__size_units);
        int length = stringArray.length;
        while (true) {
            length--;
            if (length >= 0) {
                double d2 = (double) j;
                double d3 = (double) length;
                if (d2 >= Math.pow(1024.0d, d3)) {
                    return Math.round(d2 / Math.pow(1024.0d, d3)) + " " + stringArray[length];
                }
            } else {
                return j + " " + stringArray[0];
            }
        }
    }

    public static int a(Context context, int i2) {
        return context.getTheme().obtainStyledAttributes(new int[]{i2}).getResourceId(0, 0);
    }
}
