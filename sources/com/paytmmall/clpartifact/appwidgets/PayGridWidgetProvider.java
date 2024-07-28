package com.paytmmall.clpartifact.appwidgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.RemoteViews;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.appwidgets.utils.WidgetUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;

public final class PayGridWidgetProvider extends AppWidgetProvider {
    public final PendingIntent getPendingIntent(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "action");
        k.c(str2, "type");
        k.c(str3, CLPConstants.ARGUMENT_KEY_POSITION);
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        intent.putExtra("itemType", str2);
        intent.putExtra(CLPConstants.ARGUMENT_KEY_POSITION, str3);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        k.a((Object) broadcast, "PendingIntent.getBroadcast(context, 0, intent, 0)");
        return broadcast;
    }

    public final RemoteViews setRemoteViews(Context context) {
        RemoteViews remoteViews = new RemoteViews(context != null ? context.getPackageName() : null, R.layout.layout_pay_grid_widget);
        if (context != null) {
            remoteViews.setOnClickPendingIntent(R.id.scan_and_pay, getPendingIntent(context, WidgetUtils.INSTANCE.getACTION_SCAN_PAY_CLICK(), WidgetUtils.INSTANCE.getTYPE_PAY_GRID(), "0"));
            remoteViews.setOnClickPendingIntent(R.id.send_money, getPendingIntent(context, WidgetUtils.INSTANCE.getACTION_SEND_MONEY(), WidgetUtils.INSTANCE.getTYPE_PAY_GRID(), "1"));
            remoteViews.setOnClickPendingIntent(R.id.recharge_bills, getPendingIntent(context, WidgetUtils.INSTANCE.getACTION_RECHARGE_BILLS(), WidgetUtils.INSTANCE.getTYPE_PAY_GRID(), "2"));
            remoteViews.setOnClickPendingIntent(R.id.balance_history, getPendingIntent(context, WidgetUtils.INSTANCE.getACTION_BALANCE_HISTORY(), WidgetUtils.INSTANCE.getTYPE_PAY_GRID(), "3"));
            remoteViews.setTextViewText(R.id.text1, context.getResources().getString(R.string.scan_amp_pay));
            remoteViews.setTextViewText(R.id.text2, context.getResources().getString(R.string.send_money));
            remoteViews.setTextViewText(R.id.text3, context.getResources().getString(R.string.recharge_amp_pay_bills));
            remoteViews.setTextViewText(R.id.text4, context.getResources().getString(R.string.a_c_balance_amp_history));
        }
        return remoteViews;
    }

    public final void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent == null) {
            return;
        }
        if (intent.hasExtra(WidgetUtils.INSTANCE.getKEY_WIDGET_ITEM_TYPE()) && WidgetUtils.INSTANCE.getTYPE_PAY_GRID().equals(intent.getStringExtra(WidgetUtils.INSTANCE.getKEY_WIDGET_ITEM_TYPE()))) {
            Item item = new Item();
            WidgetUtils widgetUtils = WidgetUtils.INSTANCE;
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            item.setUrl(widgetUtils.getDeepLinkUrl(action));
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
            if (communicationListener != null) {
                communicationListener.handleDeeplinkUrl(context != null ? context.getApplicationContext() : null, item);
            }
            new Handler().postDelayed(new PayGridWidgetProvider$onReceive$1$1(intent), WidgetUtils.INSTANCE.getGA_CLICK_DELAY_TIME());
        } else if (k.a((Object) intent.getAction(), (Object) WidgetUtils.INSTANCE.getACTION_UPDATE_MULTI_SERVICE_WIDGET())) {
            AppWidgetManager instance2 = AppWidgetManager.getInstance(context);
            if (context == null) {
                k.a();
            }
            instance2.updateAppWidget(new ComponentName(context, PayGridWidgetProvider.class), setRemoteViews(context));
        }
    }

    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (appWidgetManager != null) {
                    appWidgetManager.updateAppWidget(i2, setRemoteViews(context));
                }
            }
        }
    }
}
