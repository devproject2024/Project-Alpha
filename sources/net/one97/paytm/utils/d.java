package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import net.one97.paytm.landingpage.activity.AJRLauncherUtility;
import net.one97.paytm.paytm_finance.R;

public final class d {
    public static ArrayList<ShortcutInfo> a(Context context) {
        ArrayList<ShortcutInfo> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutInfo.Builder icon = new ShortcutInfo.Builder(context, "scan_and_pay_shortcut").setShortLabel(context.getString(R.string.scan_and_pay)).setRank(1).setLongLabel(context.getString(R.string.scan_and_pay)).setIcon(Icon.createWithResource(context, R.drawable.scan_n_pay_circular));
            Intent intent = new Intent("android.intent.action.MAIN", Uri.EMPTY, context, AJRLauncherUtility.class);
            intent.setFlags(32768);
            intent.putExtra("extra_type", 2);
            arrayList.add(icon.setIntent(intent).build());
            ShortcutInfo.Builder icon2 = new ShortcutInfo.Builder(context, "add_money_shortcut").setShortLabel(context.getString(R.string.add_money)).setLongLabel(context.getString(R.string.add_money)).setRank(3).setIcon(Icon.createWithResource(context, R.drawable.add_money_circular));
            Intent intent2 = new Intent("android.intent.action.MAIN", Uri.EMPTY, context, AJRLauncherUtility.class);
            intent2.setFlags(32768);
            intent2.putExtra("extra_type", 1);
            arrayList.add(icon2.setIntent(intent2).build());
            ShortcutInfo.Builder icon3 = new ShortcutInfo.Builder(context, "passbook_shortcut").setShortLabel(context.getString(R.string.view_balance)).setLongLabel(context.getString(R.string.view_balance)).setRank(4).setIcon(Icon.createWithResource(context, R.drawable.passbook_circular));
            Intent intent3 = new Intent("android.intent.action.MAIN", Uri.EMPTY, context, AJRLauncherUtility.class);
            intent3.setFlags(32768);
            intent3.putExtra("extra_type", 3);
            arrayList.add(icon3.setIntent(intent3).build());
        }
        return arrayList;
    }
}
