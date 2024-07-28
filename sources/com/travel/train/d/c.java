package com.travel.train.d;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.travel.train.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class c extends WebViewClient {

    /* renamed from: b  reason: collision with root package name */
    b f26617b;

    /* renamed from: c  reason: collision with root package name */
    Timer f26618c;

    public c(b bVar) {
        this.f26617b = bVar;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        "Starting page - ".concat(String.valueOf(str));
        a.a();
        Timer timer = this.f26618c;
        if (timer != null) {
            timer.cancel();
            this.f26618c = null;
            a.a();
        }
        b bVar = this.f26617b;
        a.a();
        if (bVar.f26602g != null) {
            bVar.f26602g.setVisibility(8);
        }
        if (bVar.p != null) {
            bVar.p.b("");
            d dVar = bVar.p;
            a.a();
            try {
                if (dVar.f26632h != null) {
                    dVar.f26625a.unregisterReceiver(dVar.f26632h);
                }
            } catch (Exception unused) {
            }
            dVar.f26627c.a(R.id.travelHelper_upper_view, Boolean.FALSE);
        }
        try {
            this.f26617b.getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    c.this.f26617b.f26598c.show();
                }
            });
        } catch (Exception unused2) {
        }
    }

    public void onPageFinished(final WebView webView, final String str) {
        super.onPageFinished(webView, str);
        "Loaded page - ".concat(String.valueOf(str));
        a.a();
        this.f26618c = new Timer();
        this.f26618c.schedule(new TimerTask() {
            public final void run() {
                c.this.f26617b.f26597b.runOnUiThread(new Runnable() {
                    public final void run() {
                        String str;
                        b bVar = c.this.f26617b;
                        WebView webView = webView;
                        String str2 = str;
                        ArrayList arrayList = new ArrayList();
                        Iterator<Map<String, String>> it2 = bVar.f26599d.iterator();
                        while (it2.hasNext()) {
                            Map next = it2.next();
                            String str3 = (String) next.get("action");
                            if (str2.indexOf((String) next.get("url")) != -1 || ((String) next.get("url")).equals("*")) {
                                String query = Uri.parse(str2).getQuery();
                                if (query == null) {
                                    query = "";
                                }
                                if (next.get("query") != null) {
                                    if (((String) next.get("query")).equals("null") && !query.equals("")) {
                                        StringBuilder sb = new StringBuilder("query1 - ");
                                        sb.append((String) next.get("query"));
                                        sb.append(" - ");
                                        sb.append(query);
                                        a.a();
                                    } else if (!((String) next.get("query")).equals("null") && query.indexOf((String) next.get("query")) == -1) {
                                        StringBuilder sb2 = new StringBuilder("query2 - ");
                                        sb2.append((String) next.get("query"));
                                        sb2.append(" - ");
                                        sb2.append(query);
                                        a.a();
                                    }
                                }
                                if (((String) bVar.f26600e.get(0).get(str3)).equals("true")) {
                                    arrayList.add(next);
                                }
                            }
                        }
                        new StringBuilder("found actions ").append(arrayList.size());
                        a.a();
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            Map map = (Map) it3.next();
                            if (map.get("active") == null || !((String) map.get("active")).equals("false")) {
                                String str4 = (String) map.get("id");
                                if (!str4.equals("28") && !str4.equals("22") && !str4.equals("33") && !str4.equals("19")) {
                                    String str5 = (String) map.get("selector");
                                    String str6 = (String) map.get("customjs");
                                    if (str6 == null) {
                                        str6 = "customJs=function(){};";
                                    }
                                    map.put("functionStart", "(function(){ try { ".concat(String.valueOf(str6)));
                                    map.put("functionEnd", "}catch(e){ Android.logError(" + str4 + "); Android.logData(e); } })();");
                                    String str7 = (String) map.get("action");
                                    String str8 = (String) map.get("selectorType");
                                    String str9 = (String) map.get("buttonSelectorName");
                                    if (str8.equals("name")) {
                                        str = "var fields = document.getElementsByName('" + str5 + "');" + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                                    } else {
                                        str = "";
                                    }
                                    if (str8.equals("tagname")) {
                                        str = "var fields = document.getElementsByTagName('" + str5 + "');" + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                                    }
                                    if (str8.equals("id")) {
                                        str = "var field = document.getElementById('" + str5 + "'); var fields = field ? [field] : [];" + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                                    }
                                    if (str8.equals("custom")) {
                                        str = ((String) map.get("customSelector")) + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                                    }
                                    if (str8.equals("password") || str8.equals(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
                                        str = "var fields = document.getElementsByName('" + str5 + "');" + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                                    }
                                    map.put("fields", str);
                                    if (str7.equals("passwordtracker")) {
                                        a.a();
                                        bVar.p = new d(bVar.f26597b, webView, bVar, map, str9);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }, 500);
        try {
            this.f26617b.getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    c.this.f26617b.f26598c.cancel();
                }
            });
        } catch (Exception unused) {
        }
    }

    public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        new StringBuilder("SSL Error occured ").append(sslError.toString());
        a.a();
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }
}
