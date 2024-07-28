package com.paytmmall.artifact.search.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected JSONArray f16010a;

    /* renamed from: b  reason: collision with root package name */
    final HashSet<String> f16011b;

    /* renamed from: c  reason: collision with root package name */
    f f16012c;

    /* renamed from: d  reason: collision with root package name */
    private String f16013d = "GsonArraySerializer";

    /* renamed from: e  reason: collision with root package name */
    private File f16014e;

    /* renamed from: f  reason: collision with root package name */
    private final String f16015f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Object> f16016g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f16017h;

    a(Context context, String str, String str2) {
        this.f16017h = new Handler(context.getMainLooper());
        this.f16015f = str2;
        this.f16011b = new HashSet<>();
        this.f16016g = new ArrayList<>();
        this.f16012c = new f();
        a(context, str);
    }

    private void a(Context context, String str) {
        this.f16014e = new File(context.getDir("data", 0), str);
        JSONArray jSONArray = null;
        try {
            if (this.f16014e.exists()) {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f16014e));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                if (!TextUtils.isEmpty(sb)) {
                    jSONArray = new JSONArray(sb.toString());
                }
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        if (jSONArray != null) {
            this.f16010a = jSONArray;
        } else {
            this.f16010a = new JSONArray();
        }
        b();
    }

    private void b() {
        this.f16011b.clear();
        JSONArray jSONArray = this.f16010a;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f16011b.add(jSONArray.optJSONObject(i2).optString(this.f16015f));
        }
    }

    /* access modifiers changed from: protected */
    public final JSONArray a() {
        return this.f16010a;
    }
}
