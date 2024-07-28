package com.paytmmall.artifact.d;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class m {

    /* renamed from: b  reason: collision with root package name */
    private static String f15727b = "CommonStorageUtil";

    /* renamed from: c  reason: collision with root package name */
    private static m f15728c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f15729a;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f15730d;

    interface a {
        void onCacheInitialize();
    }

    private m() {
    }

    public static m a() {
        if (f15728c == null) {
            f15728c = new m();
        }
        return f15728c;
    }

    public final void a(Context context, String str) {
        if (this.f15730d != null || this.f15729a) {
            c(context, str);
        } else {
            a(context, (a) new a(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onCacheInitialize() {
                    m.this.c(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void c(Context context, String str) {
        Map<String, String> map = this.f15730d;
        if (map != null) {
            map.remove(str);
            a(context, this.f15730d);
        }
    }

    public final void a(Context context, String str, String str2) {
        AsyncTask.execute(new Runnable(context, str, str2) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                m.this.b(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public final String a(Activity activity, String str) {
        if (this.f15730d != null || this.f15729a) {
            Map<String, String> map = this.f15730d;
            return (map == null || !map.containsKey(str)) ? "" : this.f15730d.get(str);
        }
        a((Context) activity, (a) null);
        return "";
    }

    public final String a(String str) {
        Map<String, String> map = this.f15730d;
        return (map == null || !map.containsKey(str)) ? "" : this.f15730d.get(str);
    }

    public final void a(Context context, a aVar) {
        this.f15729a = true;
        AsyncTask.execute(new Runnable(context, aVar) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ m.a f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                m.this.b(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Context context, a aVar) {
        this.f15730d = a(context);
        this.f15729a = false;
        if (aVar != null) {
            aVar.onCacheInitialize();
        }
    }

    private synchronized void a(Context context, Map<String, String> map) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(context.getDir("data", 0), "common_storage")));
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e2) {
            m.class.getName();
            q.b(e2.getMessage());
        }
    }

    private static Map<String, String> a(Context context) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(context.getDir("data", 0), "common_storage")));
            Map<String, String> map = (Map) objectInputStream.readObject();
            objectInputStream.close();
            return map;
        } catch (IOException e2) {
            q.c(e2.getMessage());
            return new HashMap();
        } catch (ClassNotFoundException e3) {
            q.c(e3.getMessage());
            return new HashMap();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Context context, String str, String str2) {
        Map<String, String> map = this.f15730d;
        if (map != null) {
            map.put(str, str2);
            a(context, this.f15730d);
        }
    }
}
