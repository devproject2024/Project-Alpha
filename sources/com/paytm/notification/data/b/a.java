package com.paytm.notification.data.b;

import android.content.Context;
import com.google.gson.f;
import com.paytm.pai.network.model.EventResponse;
import kotlin.g.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f43053a;

    /* renamed from: b  reason: collision with root package name */
    protected String f43054b;

    /* renamed from: c  reason: collision with root package name */
    String f43055c;

    /* renamed from: d  reason: collision with root package name */
    protected String f43056d;

    /* renamed from: e  reason: collision with root package name */
    protected String f43057e;

    /* renamed from: f  reason: collision with root package name */
    protected String f43058f;

    /* renamed from: g  reason: collision with root package name */
    protected String f43059g;

    public a(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            this.f43053a = applicationContext;
            return;
        }
        throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
    }

    /* access modifiers changed from: protected */
    public final String a() {
        String str = this.f43056d;
        if (str == null) {
            k.a("endPoints");
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f43056d = str;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        String str = this.f43057e;
        if (str == null) {
            k.a("url");
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        k.c(str, "<set-?>");
        this.f43057e = str;
    }

    /* access modifiers changed from: protected */
    public final String c() {
        String str = this.f43058f;
        if (str == null) {
            k.a("secret");
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        k.c(str, "<set-?>");
        this.f43058f = str;
    }

    /* access modifiers changed from: protected */
    public final String d() {
        String str = this.f43059g;
        if (str == null) {
            k.a("clientId");
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void d(String str) {
        k.c(str, "<set-?>");
        this.f43059g = str;
    }

    protected static <T> EventResponse<?> a(EventResponse<String> eventResponse, e<T> eVar, Class<?> cls) {
        Integer responseCode;
        Integer responseCode2;
        Integer responseCode3;
        EventResponse eventResponse2 = new EventResponse((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
        String str = null;
        String response = eventResponse != null ? eventResponse.getResponse() : null;
        if (response != null) {
            eventResponse2.setResponse(eVar.a(response, cls));
            int i2 = 0;
            if (eventResponse2.getResponse() == null) {
                EventResponse eventResponse3 = new EventResponse((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
                StringBuilder sb = new StringBuilder("Code: ");
                sb.append((eventResponse == null || (responseCode3 = eventResponse.getResponseCode()) == null) ? 0 : responseCode3.intValue());
                sb.append(" Response: ");
                if (eventResponse != null) {
                    str = eventResponse.getResponse();
                }
                sb.append(str);
                eventResponse3.setResponse(sb.toString());
                if (!(eventResponse == null || (responseCode2 = eventResponse.getResponseCode()) == null)) {
                    i2 = responseCode2.intValue();
                }
                a(i2, (EventResponse<?>) eventResponse3);
                return eventResponse3;
            }
            if (!(eventResponse == null || (responseCode = eventResponse.getResponseCode()) == null)) {
                i2 = responseCode.intValue();
            }
            a(i2, (EventResponse<?>) eventResponse2);
            return eventResponse2;
        }
        throw new u("null cannot be cast to non-null type kotlin.String");
    }

    protected static <T> EventResponse<T> a(EventResponse<String> eventResponse, b<? super String, ? extends T> bVar) {
        k.c(bVar, "parse");
        EventResponse eventResponse2 = new EventResponse((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
        if (eventResponse == null) {
            k.a();
        }
        String response = eventResponse.getResponse();
        if (response != null) {
            eventResponse2.setResponse(bVar.invoke(response));
            Integer responseCode = eventResponse.getResponseCode();
            if (responseCode != null) {
                a(responseCode.intValue(), (EventResponse<?>) eventResponse2);
                return eventResponse2;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
        throw new u("null cannot be cast to non-null type kotlin.String");
    }

    private static void a(int i2, EventResponse<?> eventResponse) {
        eventResponse.setResponseCode(Integer.valueOf(i2));
        if (i2 == 200) {
            eventResponse.setErrorMessage((String) null);
            eventResponse.setSuccess(Boolean.TRUE);
        } else if (i2 == 202) {
            eventResponse.setErrorMessage((String) null);
            eventResponse.setSuccess(Boolean.TRUE);
        } else if (i2 == 400) {
            eventResponse.setErrorMessage("Invalid Request");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 401) {
            eventResponse.setErrorMessage("Unauthorized");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 403) {
            eventResponse.setErrorMessage("Forbidden");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (500 <= i2 && 599 >= i2) {
            eventResponse.setErrorMessage("Server Error");
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 1) {
            eventResponse.setErrorMessage("Network Error");
            eventResponse.setSuccess(Boolean.FALSE);
        } else {
            eventResponse.setErrorMessage("UnKnown Error");
            eventResponse.setSuccess(Boolean.FALSE);
        }
    }

    /* access modifiers changed from: protected */
    public final <T> void a(T t) {
        this.f43054b = new f().b(t);
    }
}
