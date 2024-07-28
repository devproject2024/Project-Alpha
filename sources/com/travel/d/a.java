package com.travel.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.R;
import com.travel.d;
import java.util.Map;

public class a extends com.travel.travels.b.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f23422a = "FJRUpdateAppMessageFragment";

    /* renamed from: c  reason: collision with root package name */
    private TextView f23423c;

    /* renamed from: d  reason: collision with root package name */
    private Button f23424d;

    /* renamed from: e  reason: collision with root package name */
    private View f23425e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f23426f;

    /* renamed from: g  reason: collision with root package name */
    private String f23427g = "";

    public void onEditViewClick(View view) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23425e = layoutInflater.inflate(R.layout.pre_td_update_message_activity, (ViewGroup) null, false);
        int g2 = b.g((Context) getActivity());
        this.f23426f = (ProgressBar) this.f23425e.findViewById(R.id.page_progress);
        this.f23423c = (TextView) this.f23425e.findViewById(R.id.update_message);
        this.f23423c.setPadding(g2, g2, g2, g2);
        this.f23424d = (Button) this.f23425e.findViewById(R.id.update_app_btn);
        getActivity();
        b.c((TextView) this.f23424d);
        if (getArguments() != null) {
            this.f23427g = getArguments().getString("url_type", "");
        }
        this.f23424d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f23426f.setVisibility(0);
                String packageName = a.this.getActivity().getPackageName();
                try {
                    a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(packageName)))));
                } catch (ActivityNotFoundException unused) {
                    a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=".concat(String.valueOf(packageName)))));
                } catch (Exception e2) {
                    a.this.f23426f.setVisibility(8);
                    String unused2 = a.this.f23422a;
                    q.c(e2.getMessage());
                }
            }
        });
        try {
            d.a();
            Map<String, Map<String, String>> h2 = d.b().h();
            if (h2 != null) {
                if (h2.containsKey(this.f23427g)) {
                    Map map = h2.get(this.f23427g);
                    if (map != null) {
                        map.get("title");
                        a((String) map.get("message"), (String) map.get("show_update"));
                    }
                } else {
                    Map map2 = h2.get("default");
                    if (map2 != null) {
                        map2.get("title");
                        a((String) map2.get("message"), (String) map2.get("show_update"));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.f23425e;
    }

    private void a(String str, String str2) {
        try {
            this.f23423c.setText(str);
            if (str2 == null || !str2.equalsIgnoreCase("true")) {
                this.f23424d.setVisibility(8);
            } else {
                this.f23424d.setVisibility(0);
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public void onResume() {
        super.onResume();
        ProgressBar progressBar = this.f23426f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
