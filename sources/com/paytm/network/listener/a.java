package com.paytm.network.listener;

import com.paytm.network.model.ConnectionMatrices;
import com.paytm.utility.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public final class a extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    public ConnectionMatrices f42960a;

    /* renamed from: b  reason: collision with root package name */
    public long f42961b;

    /* renamed from: c  reason: collision with root package name */
    public long f42962c;

    /* renamed from: d  reason: collision with root package name */
    private Stack<C0716a> f42963d = new Stack<>();

    /* renamed from: e  reason: collision with root package name */
    private Stack<C0716a> f42964e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    private Stack<C0716a> f42965f = new Stack<>();

    /* renamed from: g  reason: collision with root package name */
    private Stack<C0716a> f42966g = new Stack<>();

    /* renamed from: h  reason: collision with root package name */
    private Stack<C0716a> f42967h = new Stack<>();

    /* renamed from: i  reason: collision with root package name */
    private Stack<C0716a> f42968i = new Stack<>();
    private Stack<C0716a> j = new Stack<>();
    private long k;
    private long l;
    private String m;
    private String n;
    private long o;

    private static double a(long j2, long j3) {
        return ((double) (j2 - j3)) / 1000000.0d;
    }

    public final void connectionAcquired(Call call, Connection connection) {
    }

    public a(String str) {
        this.m = str;
    }

    public final void callStart(Call call) {
        this.k = System.nanoTime();
    }

    public final void callEnd(Call call) {
        this.l = System.nanoTime();
    }

    public final void dnsStart(Call call, String str) {
        a(System.nanoTime(), this.f42963d);
    }

    public final void dnsEnd(Call call, String str, List<InetAddress> list) {
        b(System.nanoTime(), this.f42963d);
        if (list != null && !list.isEmpty()) {
            this.n = list.get(0).getHostAddress();
            q.d("url " + list.get(0).getHostAddress());
        }
    }

    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        a(System.nanoTime(), this.f42964e);
    }

    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        b(System.nanoTime(), this.f42964e);
    }

    public final void secureConnectStart(Call call) {
        a(System.nanoTime(), this.f42965f);
    }

    public final void secureConnectEnd(Call call, Handshake handshake) {
        b(System.nanoTime(), this.f42965f);
    }

    public final void requestHeadersStart(Call call) {
        a(System.nanoTime(), this.f42966g);
    }

    public final void requestHeadersEnd(Call call, Request request) {
        b(System.nanoTime(), this.f42966g);
    }

    public final void responseHeadersStart(Call call) {
        a(System.nanoTime(), this.f42968i);
    }

    public final void responseHeadersEnd(Call call, Response response) {
        b(System.nanoTime(), this.f42968i);
    }

    public final void connectionReleased(Call call, Connection connection) {
        this.l = System.nanoTime();
    }

    public final void responseBodyStart(Call call) {
        a(System.nanoTime(), this.j);
    }

    public final void responseBodyEnd(Call call, long j2) {
        b(System.nanoTime(), this.j);
        this.l = System.nanoTime();
    }

    public final void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        this.l = System.nanoTime();
    }

    public final void requestBodyStart(Call call) {
        a(System.nanoTime(), this.f42967h);
    }

    public final void requestBodyEnd(Call call, long j2) {
        b(System.nanoTime(), this.f42967h);
    }

    /* renamed from: com.paytm.network.listener.a$a  reason: collision with other inner class name */
    class C0716a {

        /* renamed from: a  reason: collision with root package name */
        long f42969a;

        /* renamed from: b  reason: collision with root package name */
        long f42970b;

        C0716a() {
        }
    }

    private void a(long j2, Stack<C0716a> stack) {
        C0716a aVar = new C0716a();
        aVar.f42969a = j2;
        stack.add(aVar);
    }

    private static void b(long j2, Stack<C0716a> stack) {
        if (!stack.isEmpty()) {
            ((C0716a) stack.lastElement()).f42970b = j2;
        }
    }

    public final ConnectionMatrices a() {
        if (this.f42960a == null) {
            this.f42960a = new ConnectionMatrices();
            this.f42960a.setUrl(this.m);
            this.f42960a.setMetricDomainLookupTime(a(this.f42963d));
            this.f42960a.setMetricSecureConnectionTime(a(this.f42965f));
            this.f42960a.setMetricRequestTime(a(this.f42966g) + a(this.f42967h));
            this.f42960a.setMetricResponseTime(a(this.f42968i) + a(this.j));
            this.f42960a.setMetricConnectionTime(a(this.f42964e));
            this.f42960a.setIpa(this.n);
            double a2 = a(this.l, this.k);
            if (a2 > 0.0d) {
                this.f42960a.setMetricTotalTime(a2);
            } else {
                ConnectionMatrices connectionMatrices = this.f42960a;
                connectionMatrices.setMetricTotalTime(connectionMatrices.getMetricDomainLookupTime() + this.f42960a.getMetricConnectionTime() + this.f42960a.getMetricResponseTime() + this.f42960a.getMetricRequestTime());
            }
            this.f42960a.setRequestWaitTime(this.f42962c - this.f42961b);
        }
        return this.f42960a;
    }

    private static double a(Stack<C0716a> stack) {
        double d2 = 0.0d;
        try {
            Iterator it2 = stack.iterator();
            while (it2.hasNext()) {
                C0716a aVar = (C0716a) it2.next();
                if (!(aVar.f42970b == 0 || aVar.f42969a == 0)) {
                    d2 += a(aVar.f42970b, aVar.f42969a);
                }
            }
        } catch (Exception unused) {
        }
        return d2;
    }

    public final void callFailed(Call call, IOException iOException) {
        String.format("%.3f %s%n", new Object[]{Double.valueOf(((double) (System.nanoTime() - this.o)) / 1000000.0d), "callFailed"});
        this.l = System.nanoTime();
    }
}
