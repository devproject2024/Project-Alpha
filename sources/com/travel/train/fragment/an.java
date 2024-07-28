package com.travel.train.fragment;

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
import com.travel.train.R;
import java.util.Map;

public class an extends am {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26903a;

    /* renamed from: b  reason: collision with root package name */
    private Button f26904b;

    /* renamed from: c  reason: collision with root package name */
    private View f26905c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f26906d;

    /* renamed from: e  reason: collision with root package name */
    private String f26907e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f26908f = "FJRUpgradeMessageFragment";

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f26905c = layoutInflater.inflate(R.layout.upgrade_message_view, (ViewGroup) null, false);
        int g2 = b.g((Context) getActivity());
        this.f26906d = (ProgressBar) this.f26905c.findViewById(R.id.page_progress);
        this.f26903a = (TextView) this.f26905c.findViewById(R.id.update_message);
        this.f26903a.setPadding(g2, g2, g2, g2);
        this.f26904b = (Button) this.f26905c.findViewById(R.id.update_app_btn);
        getActivity();
        b.c((TextView) this.f26904b);
        if (getArguments() != null) {
            this.f26907e = getArguments().getString("url_type", "");
        }
        this.f26904b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                an.this.f26906d.setVisibility(0);
                String packageName = an.this.getActivity().getPackageName();
                try {
                    an.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(packageName)))));
                } catch (ActivityNotFoundException unused) {
                    an.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=".concat(String.valueOf(packageName)))));
                } catch (Exception e2) {
                    an.this.f26906d.setVisibility(8);
                    String unused2 = an.this.f26908f;
                    q.c(e2.getMessage());
                }
            }
        });
        try {
            com.travel.train.b.a();
            Map<String, Map<String, String>> c2 = com.travel.train.b.b().c();
            if (c2 != null) {
                if (c2.containsKey(this.f26907e)) {
                    Map map = c2.get(this.f26907e);
                    if (map != null) {
                        map.get("title");
                        a((String) map.get("message"), (String) map.get("show_update"));
                    }
                } else {
                    Map map2 = c2.get("default");
                    if (map2 != null) {
                        map2.get("title");
                        a((String) map2.get("message"), (String) map2.get("show_update"));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.f26905c;
    }

    private void a(String str, String str2) {
        try {
            this.f26903a.setText(str);
            if (str2 == null || !str2.equalsIgnoreCase("true")) {
                this.f26904b.setVisibility(8);
            } else {
                this.f26904b.setVisibility(0);
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public void onResume() {
        super.onResume();
        ProgressBar progressBar = this.f26906d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
