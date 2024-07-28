package net.one97.paytm.phoenix.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.util.g;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONObject;

public final class EventPubSubManager$receiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventPubSubManager f59594a;

    EventPubSubManager$receiver$1(EventPubSubManager eventPubSubManager) {
        this.f59594a = eventPubSubManager;
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            j jVar = j.f59646a;
            j.b("EventPubSubManager", "onReceive : " + intent.getAction());
            JSONObject jSONObject = new JSONObject();
            g gVar = g.f59641a;
            k.a((Object) extras, "bundle");
            g.a(extras, jSONObject);
            this.f59594a.a(new H5Event(intent.getAction(), "subscribe", jSONObject, intent.getAction(), true), (Object) jSONObject, true);
        }
    }
}
