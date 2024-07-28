package com.google.androidbrowserhelper.trusted;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class FocusActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f37615a;

    public static void a(Intent intent, Context context) {
        Intent intent2 = new Intent(context, FocusActivity.class);
        if (f37615a == null) {
            f37615a = Boolean.valueOf(intent2.resolveActivityInfo(context.getPackageManager(), 0) != null);
        }
        if (!Boolean.FALSE.equals(f37615a)) {
            intent2.setFlags(268435456);
            intent.putExtra("androidx.browser.customtabs.extra.FOCUS_INTENT", PendingIntent.getActivity(context, 0, intent2, 0));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
