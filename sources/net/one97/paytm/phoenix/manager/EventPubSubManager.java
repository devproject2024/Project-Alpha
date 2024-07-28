package net.one97.paytm.phoenix.manager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONObject;

public final class EventPubSubManager extends net.one97.paytm.phoenix.core.a implements p {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f59585a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final EventPubSubManager$receiver$1 f59586b = new EventPubSubManager$receiver$1(this);

    /* renamed from: c  reason: collision with root package name */
    private final Activity f59587c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventPubSubManager(Activity activity) {
        super("subscribe", "unsubscribe", "testsubscribe");
        k.c(activity, "activity");
        this.f59587c = activity;
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        H5Event h5Event2 = h5Event;
        k.c(h5Event2, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        if (h5Event.getActivity() != null) {
            String msgType = h5Event.getMsgType();
            if (msgType != null) {
                int hashCode = msgType.hashCode();
                if (hashCode != 514841930) {
                    if (hashCode == 583281361 && msgType.equals("unsubscribe")) {
                        j jVar = j.f59646a;
                        j.b("EventPubSubManager", "UNSUBSCRIBE: " + h5Event.getBridgeName());
                        String bridgeName = h5Event.getBridgeName();
                        if (bridgeName != null && bridgeName.equals(H5Param.DEFAULT_LONG_BACK_BEHAVIOR) && (h5Event.getActivity() instanceof PhoenixActivity)) {
                            Activity activity = h5Event.getActivity();
                            if (activity != null) {
                                ((PhoenixActivity) activity).n.deleteObservers();
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                            }
                        }
                        String bridgeName2 = h5Event.getBridgeName();
                        if (bridgeName2 != null && bridgeName2.equals(H5Plugin.CommonEvents.SET_OPTION_MENU) && (h5Event.getActivity() instanceof PhoenixActivity)) {
                            Activity activity2 = h5Event.getActivity();
                            if (activity2 != null) {
                                ((PhoenixActivity) activity2).y.deleteObservers();
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                            }
                        }
                        Collection collection = this.f59585a;
                        String bridgeName3 = h5Event.getBridgeName();
                        if (collection != null) {
                            ab.b(collection).remove(bridgeName3);
                            b();
                            a();
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        }
                    }
                } else if (msgType.equals("subscribe")) {
                    j jVar2 = j.f59646a;
                    j.b("EventPubSubManager", "SUBSCRIBE: " + h5Event.getBridgeName());
                    String bridgeName4 = h5Event.getBridgeName();
                    if (bridgeName4 == null) {
                        bridgeName4 = "";
                    }
                    int hashCode2 = bridgeName4.hashCode();
                    if (hashCode2 != 3015911) {
                        if (hashCode2 != 1306974590) {
                            if (hashCode2 == 1849742710 && bridgeName4.equals(H5Plugin.CommonEvents.SET_OPTION_MENU)) {
                                if (h5Event.getActivity() instanceof PhoenixActivity) {
                                    Activity activity3 = h5Event.getActivity();
                                    if (activity3 != null) {
                                        ((PhoenixActivity) activity3).y.deleteObservers();
                                        Activity activity4 = h5Event.getActivity();
                                        if (activity4 != null) {
                                            ((PhoenixActivity) activity4).y.addObserver(new b(this, h5Event2));
                                        } else {
                                            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                        }
                                    } else {
                                        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                    }
                                }
                            }
                        } else if (bridgeName4.equals("paytmPickFile")) {
                            if (h5Event.getActivity() instanceof PhoenixActivity) {
                                Activity activity5 = h5Event.getActivity();
                                if (activity5 != null) {
                                    ((PhoenixActivity) activity5).A.deleteObservers();
                                    Activity activity6 = h5Event.getActivity();
                                    if (activity6 != null) {
                                        ((PhoenixActivity) activity6).A.addObserver(new c(this, h5Event2));
                                    } else {
                                        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                }
                            }
                        }
                    } else if (bridgeName4.equals(H5Param.DEFAULT_LONG_BACK_BEHAVIOR)) {
                        if (h5Event.getActivity() instanceof PhoenixActivity) {
                            Activity activity7 = h5Event.getActivity();
                            if (activity7 != null) {
                                ((PhoenixActivity) activity7).n.deleteObservers();
                                Activity activity8 = h5Event.getActivity();
                                if (activity8 != null) {
                                    ((PhoenixActivity) activity8).n.addObserver(new a(this, h5Event2));
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                            }
                        }
                    }
                    Iterable<String> listOfSubscribeBridges = PhoenixManager.INSTANCE.getListOfSubscribeBridges();
                    if (kotlin.a.k.a(listOfSubscribeBridges, h5Event.getBridgeName())) {
                        for (String str : listOfSubscribeBridges) {
                            EventPubSubManager eventPubSubManager = this;
                            if (kotlin.m.p.a(h5Event.getBridgeName(), str, false) && !eventPubSubManager.f59585a.contains(str)) {
                                eventPubSubManager.f59585a.add(str);
                                j jVar3 = j.f59646a;
                                j.b("EventPubSubManager", "connectListener registerReceiver: ");
                                androidx.localbroadcastmanager.a.a.a((Context) eventPubSubManager.f59587c).a(eventPubSubManager.f59586b, new IntentFilter(str));
                            }
                        }
                    } else {
                        a(new H5Event(h5Event.getBridgeName(), "subscribe", (JSONObject) null, h5Event.getCallbackId(), true, 4, (g) null), net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Not valid");
                    }
                }
            }
            a(new H5Event(h5Event.getBridgeName(), "subscribe", (JSONObject) null, h5Event.getCallbackId(), true, 4, (g) null), net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Not valid");
        }
        return true;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventPubSubManager f59588a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59589b;

        a(EventPubSubManager eventPubSubManager, H5Event h5Event) {
            this.f59588a = eventPubSubManager;
            this.f59589b = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            net.one97.paytm.phoenix.core.a.a(this.f59588a, new H5Event(this.f59589b.getBridgeName(), "subscribe", (JSONObject) null, this.f59589b.getCallbackId(), true, 4, (g) null), obj, false, 4);
        }
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventPubSubManager f59590a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59591b;

        b(EventPubSubManager eventPubSubManager, H5Event h5Event) {
            this.f59590a = eventPubSubManager;
            this.f59591b = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            EventPubSubManager eventPubSubManager = this.f59590a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clicked", obj.toString());
            net.one97.paytm.phoenix.core.a.a(eventPubSubManager, new H5Event(this.f59591b.getBridgeName(), "subscribe", (JSONObject) null, this.f59591b.getCallbackId(), true, 4, (g) null), jSONObject, false, 4);
        }
    }

    static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventPubSubManager f59592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59593b;

        c(EventPubSubManager eventPubSubManager, H5Event h5Event) {
            this.f59592a = eventPubSubManager;
            this.f59593b = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            net.one97.paytm.phoenix.core.a.a(this.f59592a, new H5Event(this.f59593b.getBridgeName(), "subscribe", (JSONObject) null, this.f59593b.getCallbackId(), true, 4, (g) null), obj, false, 4);
        }
    }

    @aa(a = k.a.ON_START)
    public final void onStart() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "start");
        a("start");
    }

    @aa(a = k.a.ON_RESUME)
    public final void onResume() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "resume");
        a();
        a("resume");
    }

    @aa(a = k.a.ON_PAUSE)
    public final void onPause() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "pause");
        a("pause");
    }

    @aa(a = k.a.ON_STOP)
    public final void onStop() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "stop");
        a("stop");
        b();
    }

    private void a() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "connectListener registerReceiver on ON_RESUME: ");
        IntentFilter intentFilter = new IntentFilter();
        for (String addAction : this.f59585a) {
            intentFilter.addAction(addAction);
        }
        androidx.localbroadcastmanager.a.a.a((Context) this.f59587c).a(this.f59586b, intentFilter);
    }

    private void b() {
        j jVar = j.f59646a;
        j.b("EventPubSubManager", "disconnectListener ON_STOP: ");
        androidx.localbroadcastmanager.a.a.a((Context) this.f59587c).a((BroadcastReceiver) this.f59586b);
    }

    private final void a(String str) {
        if (this.f59585a.contains(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", true);
            jSONObject.put(AppConstants.NOTIFICATION_DETAILS.EVENT, str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            a(new H5Event(str, "subscribe", jSONObject2, str, true), (Object) jSONObject2, true);
        }
    }
}
