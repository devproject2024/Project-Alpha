package com.paytm.network;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.ConnectionMatrices;
import com.paytm.network.model.NetworkResponse;
import java.util.HashMap;

public interface j {
    void a(Context context, int i2, String str, long j, NetworkResponse networkResponse, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices, double d2);

    void a(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices);

    void a(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices, String str4);
}
