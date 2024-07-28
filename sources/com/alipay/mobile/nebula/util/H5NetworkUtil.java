package com.alipay.mobile.nebula.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class H5NetworkUtil {
    public static final String TAG = "NetworkUtil";
    private static H5NetworkUtil instance;
    private Context context;
    private List<NetworkListener> listenerList = Collections.synchronizedList(new ArrayList());
    private Network network = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            H5NetworkUtil.this.updateNetwork();
        }
    };

    public enum Network {
        NETWORK_WIFI,
        NETWORK_MOBILE_FAST,
        NETWORK_MOBILE_MIDDLE,
        NETWORK_MOBILE_SLOW,
        NETWORK_NO_CONNECTION,
        NETWORK_TYPE_UNKNOWN
    }

    public interface NetworkListener {
        void onNetworkChanged(Network network, Network network2);
    }

    private H5NetworkUtil() {
    }

    public static final H5NetworkUtil getInstance() {
        synchronized (H5NetworkUtil.class) {
            if (instance == null) {
                instance = new H5NetworkUtil();
            }
        }
        return instance;
    }

    public void init(Context context2) {
        if (this.context == null) {
            this.context = context2.getApplicationContext();
            registerReceiver();
        }
    }

    public void registerReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.receiver, intentFilter);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public void unregisterReceiver() {
        try {
            this.context.unregisterReceiver(this.receiver);
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail", th);
        }
    }

    @Deprecated
    public final synchronized Network getNetworkType() {
        return this.network;
    }

    public final synchronized String getNetworkString() {
        if (this.network == null) {
            return H5Utils.NETWORK_TYPE_UNKNOWN;
        }
        int i2 = AnonymousClass2.$SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network[this.network.ordinal()];
        if (i2 == 1) {
            return H5Utils.NETWORK_TYPE_WIFI;
        }
        if (i2 == 2) {
            return H5Utils.NETWORK_TYPE_4G;
        }
        if (i2 == 3) {
            return H5Utils.NETWORK_TYPE_3G;
        }
        if (i2 != 4) {
            return H5Utils.NETWORK_TYPE_UNKNOWN;
        }
        return H5Utils.NETWORK_TYPE_2G;
    }

    /* renamed from: com.alipay.mobile.nebula.util.H5NetworkUtil$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network = new int[Network.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network[] r0 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network = r0
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network r1 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.NETWORK_WIFI     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network     // Catch:{ NoSuchFieldError -> 0x001f }
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network r1 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.NETWORK_MOBILE_FAST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network     // Catch:{ NoSuchFieldError -> 0x002a }
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network r1 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.NETWORK_MOBILE_MIDDLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network r1 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.NETWORK_MOBILE_SLOW     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.alipay.mobile.nebula.util.H5NetworkUtil$Network r1 = com.alipay.mobile.nebula.util.H5NetworkUtil.Network.NETWORK_NO_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5NetworkUtil.AnonymousClass2.<clinit>():void");
        }
    }

    public final void addListener(NetworkListener networkListener) {
        if (networkListener != null && !this.listenerList.contains(networkListener)) {
            this.listenerList.add(networkListener);
        }
    }

    public final void removeListener(NetworkListener networkListener) {
        if (networkListener != null) {
            this.listenerList.remove(networkListener);
        }
    }

    public static String TransferNetworkType(Network network2) {
        int i2 = AnonymousClass2.$SwitchMap$com$alipay$mobile$nebula$util$H5NetworkUtil$Network[network2.ordinal()];
        if (i2 == 1) {
            return "wifi";
        }
        if (i2 == 2) {
            return "4g";
        }
        if (i2 == 3) {
            return "3g";
        }
        if (i2 != 4) {
            return i2 != 5 ? SDKConstants.UNKNOWN : "none";
        }
        return "2g";
    }

    /* access modifiers changed from: private */
    public final void updateNetwork() {
        NetworkInfo networkInfo;
        List<NetworkListener> list;
        try {
            networkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail", th);
            networkInfo = null;
        }
        Network network2 = this.network;
        this.network = detectNetwork(networkInfo);
        if (network2 != null && this.network != network2 && (list = this.listenerList) != null) {
            synchronized (list) {
                for (NetworkListener next : this.listenerList) {
                    H5Log.d(TAG, "onNetworkChanged");
                    if (next != null) {
                        next.onNetworkChanged(network2, this.network);
                    }
                }
            }
        }
    }

    private final Network detectNetwork(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            try {
                return Network.NETWORK_NO_CONNECTION;
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
                return Network.NETWORK_TYPE_UNKNOWN;
            }
        } else if (!networkInfo.isConnected()) {
            return Network.NETWORK_NO_CONNECTION;
        } else {
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            H5Log.d(TAG, "type: " + type + " subType: " + subtype);
            if (type != 1) {
                if (type != 9) {
                    if (type != 0) {
                        return Network.NETWORK_TYPE_UNKNOWN;
                    }
                    if (subtype == 0) {
                        return Network.NETWORK_TYPE_UNKNOWN;
                    }
                    if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                        return Network.NETWORK_MOBILE_SLOW;
                    }
                    if (subtype != 13) {
                        return Network.NETWORK_MOBILE_MIDDLE;
                    }
                    return Network.NETWORK_MOBILE_FAST;
                }
            }
            return Network.NETWORK_WIFI;
        }
    }
}
