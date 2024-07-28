package net.one97.paytm.games.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import androidx.fragment.app.FragmentActivity;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.games.e.f;
import net.one97.paytm.i.h;

public abstract class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private IntentFilter f35656a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f35657b;

    public void a(int i2, Object obj) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.a(context);
    }

    public void onStart() {
        IntentFilter intentFilter;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity != null && (intentFilter = this.f35656a) != null) {
            activity.registerReceiver(this.f35657b, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(IntentFilter intentFilter) {
        this.f35656a = intentFilter;
        if (this.f35657b == null) {
            this.f35657b = new BroadcastReceiver() {

                /* renamed from: b  reason: collision with root package name */
                private NetworkInfo.State f35659b;

                public final void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if (((action.hashCode() == -1172645946 && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) ? (char) 0 : 65535) == 0) {
                        NetworkInfo.State state = f.a(context) ? NetworkInfo.State.CONNECTED : NetworkInfo.State.DISCONNECTED;
                        NetworkInfo.State state2 = this.f35659b;
                        if (!(state2 == null || state == state2)) {
                            b.this.a(3, state);
                        }
                        this.f35659b = state;
                    }
                }
            };
        }
    }

    public void onStop() {
        super.onStop();
        if (getActivity() != null && this.f35657b != null) {
            getActivity().unregisterReceiver(this.f35657b);
        }
    }
}
