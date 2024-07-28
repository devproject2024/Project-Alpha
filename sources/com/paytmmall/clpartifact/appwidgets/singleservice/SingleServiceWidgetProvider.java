package com.paytmmall.clpartifact.appwidgets.singleservice;

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
import kotlin.g.b.k;

public final class SingleServiceWidgetProvider extends AppWidgetProvider {
    public final PendingIntent getPendingIntent(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "action");
        k.c(str2, "type");
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        intent.putExtra("itemType", str2);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        k.a((Object) broadcast, "PendingIntent.getBroadcast(context, 0, intent, 0)");
        return broadcast;
    }

    public final RemoteViews setRemoteViews(Context context) {
        RemoteViews remoteViews = new RemoteViews(context != null ? context.getPackageName() : null, R.layout.layout_single_service_widget);
        if (context != null) {
            remoteViews.setTextViewText(R.id.text1, context.getResources().getString(R.string.scan_amp_pay));
            remoteViews.setOnClickPendingIntent(R.id.scan_and_pay_single, getPendingIntent(context, WidgetUtils.INSTANCE.getACTION_SCAN_PAY_CLICK(), WidgetUtils.INSTANCE.getTYPE_PAY_GRID()));
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
            new Handler().postDelayed(new SingleServiceWidgetProvider$onReceive$1$1(intent), WidgetUtils.INSTANCE.getGA_CLICK_DELAY_TIME());
        } else if (k.a((Object) intent.getAction(), (Object) WidgetUtils.INSTANCE.getACTION_UPDATE_SINGLE_SERVICE_WIDGET())) {
            AppWidgetManager instance2 = AppWidgetManager.getInstance(context);
            if (context == null) {
                k.a();
            }
            instance2.updateAppWidget(new ComponentName(context, SingleServiceWidgetProvider.class), setRemoteViews(context));
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
