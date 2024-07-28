package com.travel.train.d;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.webkit.WebView;
import com.travel.train.R;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    Activity f26625a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f26626b;

    /* renamed from: c  reason: collision with root package name */
    public b f26627c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f26628d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f26629e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    String f26630f;

    /* renamed from: g  reason: collision with root package name */
    String f26631g = "PasswordTravelHelper";

    /* renamed from: h  reason: collision with root package name */
    BroadcastReceiver f26632h = new BroadcastReceiver() {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r8, android.content.Intent r9) {
            /*
                r7 = this;
                android.os.Bundle r8 = r9.getExtras()
                java.lang.String r9 = "eventName"
                java.lang.String r9 = r8.getString(r9)
                int r0 = r9.hashCode()
                r1 = 0
                java.lang.String r2 = "togglePassword"
                r3 = 3
                r4 = 2
                r5 = 1
                switch(r0) {
                    case -1905225220: goto L_0x0036;
                    case -1641265649: goto L_0x002e;
                    case 747733309: goto L_0x0024;
                    case 2104149715: goto L_0x0019;
                    default: goto L_0x0018;
                }
            L_0x0018:
                goto L_0x0040
            L_0x0019:
                java.lang.String r0 = "submitPassword"
                boolean r9 = r9.equals(r0)
                if (r9 == 0) goto L_0x0040
                r9 = 2
                goto L_0x0041
            L_0x0024:
                java.lang.String r0 = "focusCallback"
                boolean r9 = r9.equals(r0)
                if (r9 == 0) goto L_0x0040
                r9 = 3
                goto L_0x0041
            L_0x002e:
                boolean r9 = r9.equals(r2)
                if (r9 == 0) goto L_0x0040
                r9 = 1
                goto L_0x0041
            L_0x0036:
                java.lang.String r0 = "activatePasswordHelper"
                boolean r9 = r9.equals(r0)
                if (r9 == 0) goto L_0x0040
                r9 = 0
                goto L_0x0041
            L_0x0040:
                r9 = -1
            L_0x0041:
                java.lang.String r0 = "id"
                java.lang.String r6 = "data0"
                if (r9 == 0) goto L_0x00d1
                if (r9 == r5) goto L_0x00ad
                if (r9 == r4) goto L_0x006b
                if (r9 == r3) goto L_0x004e
                goto L_0x006a
            L_0x004e:
                com.travel.train.d.d r9 = com.travel.train.d.d.this
                java.lang.String r8 = r8.getString(r6)
                java.lang.Boolean.parseBoolean(r8)
                com.travel.train.d.b r8 = r9.f26627c
                boolean r9 = r8.o
                if (r9 != 0) goto L_0x006a
                boolean r9 = r8.m
                if (r9 == 0) goto L_0x006a
                android.widget.LinearLayout r9 = r8.l
                if (r9 == 0) goto L_0x006a
                android.widget.LinearLayout r8 = r8.l
                r8.setVisibility(r1)
            L_0x006a:
                return
            L_0x006b:
                com.travel.train.d.d r8 = com.travel.train.d.d.this
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "(function(){l=document.getElementsByName('"
                r9.append(r0)
                java.lang.String r0 = r8.f26630f
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r9)
                java.lang.String r9 = "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()"
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "javascript:"
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                android.webkit.WebView r0 = r8.f26626b
                r0.loadUrl(r9)
                java.lang.String r9 = "false"
                r8.a(r9)
                return
            L_0x00ad:
                com.travel.train.d.d r8 = com.travel.train.d.d.this
                java.lang.Boolean r9 = r8.f26629e
                boolean r9 = r9.booleanValue()
                r9 = r9 ^ r5
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                r8.f26629e = r9
                r8.a()
                com.travel.train.d.d r8 = com.travel.train.d.d.this
                com.travel.train.d.b r8 = r8.f26627c
                com.travel.train.d.d r9 = com.travel.train.d.d.this
                java.util.Map<java.lang.String, java.lang.String> r9 = r9.f26628d
                java.lang.Object r9 = r9.get(r0)
                java.lang.String r9 = (java.lang.String) r9
                r8.logEvent(r2, r9)
                return
            L_0x00d1:
                com.travel.train.d.d r9 = com.travel.train.d.d.this
                java.lang.String r8 = r8.getString(r6)
                r9.a(r8)
                com.travel.train.d.d r8 = com.travel.train.d.d.this
                com.travel.train.d.b r8 = r8.f26627c
                com.travel.train.d.d r9 = com.travel.train.d.d.this
                java.util.Map<java.lang.String, java.lang.String> r9 = r9.f26628d
                java.lang.Object r9 = r9.get(r0)
                java.lang.String r9 = (java.lang.String) r9
                java.lang.String r0 = "activated"
                r8.logEvent(r0, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.d.d.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private String f26633i;
    private String j = "";
    private String k = "";
    private String l = "";

    public d(Activity activity, WebView webView, b bVar, Map<String, String> map, String str) {
        this.f26625a = activity;
        this.f26627c = bVar;
        this.f26628d = map;
        this.f26626b = webView;
        this.f26630f = str;
        this.f26625a.registerReceiver(this.f26632h, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        this.f26633i = this.f26628d.get("fields");
        webView.loadUrl("javascript:" + this.f26628d.get("functionStart") + this.f26633i + (this.f26633i + "var a=fields; for(var i=0;i<a.length;i++){if(a[i].type=='password'){a[i].blur();Android.showLog(\"input type is password\");a[i].addEventListener('input', function(e){Android.logTempData(this.value)}); a[i].addEventListener('focusin', function(){Android.sendEvent('focusCallback', true , 0);}); a[i].addEventListener('focusout', function(){Android.sendEvent('focusCallback', false , 0);});}}") + this.f26628d.get("functionEnd"));
    }

    public final void a(String str) {
        if (str.equals("true")) {
            this.f26625a.runOnUiThread(new Runnable() {
                public final void run() {
                    d.this.f26627c.a(R.id.travelHelper_upper_view, Boolean.TRUE);
                }
            });
            return;
        }
        this.j = "";
        this.f26625a.runOnUiThread(new Runnable() {
            public final void run() {
                d.this.f26627c.a(R.id.travelHelper_upper_view, Boolean.FALSE);
                d.this.a();
            }
        });
    }

    public final void a() {
        if (this.f26629e.booleanValue()) {
            this.k = this.j;
            this.l = "Hide";
        } else {
            this.l = "Show";
        }
        this.f26625a.runOnUiThread(new Runnable() {
            public final void run() {
            }
        });
    }

    public final void b(String str) {
        this.j = str;
        this.f26627c.a(R.id.leftTravelHelperView, str);
    }
}
