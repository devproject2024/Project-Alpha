package net.one97.paytm.landingpage.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ak;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.y;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.landingpage.R;

public final class SFDeeplinkActivity extends PaytmActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f52722a;

    /* renamed from: b  reason: collision with root package name */
    private String f52723b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f52724c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.landingpage.a.c f52725d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<View> f52726e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private IGAHandlerListener f52727f;

    /* renamed from: g  reason: collision with root package name */
    private final g f52728g = new ak(y.b(net.one97.paytm.landingpage.g.a.class), new b(this), new a(this));

    /* renamed from: h  reason: collision with root package name */
    private HashMap f52729h;

    /* access modifiers changed from: private */
    public final net.one97.paytm.landingpage.g.a a() {
        return (net.one97.paytm.landingpage.g.a) this.f52728g.getValue();
    }

    public final android.view.View a(int i2) {
        if (this.f52729h == null) {
            this.f52729h = new HashMap();
        }
        android.view.View view = (android.view.View) this.f52729h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        android.view.View findViewById = findViewById(i2);
        this.f52729h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SFDeeplinkActivity f52730a;

        c(SFDeeplinkActivity sFDeeplinkActivity) {
            this.f52730a = sFDeeplinkActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            RecyclerView recyclerView = (RecyclerView) this.f52730a.a(R.id.rv_sf_widgets);
            k.a((Object) recyclerView, "rv_sf_widgets");
            recyclerView.setVisibility(0);
            android.view.View a2 = this.f52730a.a(R.id.no_network_layout);
            k.a((Object) a2, "no_network_layout");
            a2.setVisibility(8);
            ProgressBar progressBar = (ProgressBar) this.f52730a.a(R.id.pb_loading);
            k.a((Object) progressBar, "pb_loading");
            progressBar.setVisibility(8);
            this.f52730a.f52726e.clear();
            this.f52730a.f52726e.addAll(sanitizedResponseModel.getRvWidgets());
            net.one97.paytm.landingpage.a.c b2 = this.f52730a.f52725d;
            if (b2 != null) {
                b2.f52658a = sanitizedResponseModel.getGaListener();
            }
            net.one97.paytm.landingpage.a.c b3 = this.f52730a.f52725d;
            if (b3 != null) {
                b3.notifyDataSetChanged();
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sf_deeplink_activity);
        String stringExtra = getIntent().getStringExtra("sf_deeplink");
        if (stringExtra != null) {
            String queryParameter = Uri.parse(stringExtra).getQueryParameter("url");
            if (queryParameter == null) {
                queryParameter = "";
            }
            this.f52722a = queryParameter;
            String queryParameter2 = Uri.parse(stringExtra).getQueryParameter("title");
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            this.f52723b = queryParameter2;
            String queryParameter3 = Uri.parse(stringExtra).getQueryParameter("backbtn");
            this.f52724c = queryParameter3 != null ? Boolean.parseBoolean(queryParameter3) : true;
            net.one97.paytm.landingpage.g.a a2 = a();
            String queryParameter4 = Uri.parse(stringExtra).getQueryParameter("vertical");
            if (queryParameter4 == null) {
                queryParameter4 = "generic_storefront";
            }
            a2.f52794c = queryParameter4;
        }
        Context context = this;
        this.f52725d = new net.one97.paytm.landingpage.a.c(context, this.f52726e, this.f52727f);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_sf_widgets);
        k.a((Object) recyclerView, "rv_sf_widgets");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_sf_widgets);
        k.a((Object) recyclerView2, "rv_sf_widgets");
        recyclerView2.setAdapter(this.f52725d);
        setTitle(a(this.f52723b));
        if (this.f52724c) {
            ImageView imageView = (ImageView) a(R.id.iv_back);
            k.a((Object) imageView, "iv_back");
            imageView.setVisibility(0);
        }
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new e(this));
        ((TextView) a(R.id.retry_network)).setOnClickListener(new f(this));
        TextView textView = (TextView) a(R.id.tv_title);
        k.a((Object) textView, "tv_title");
        textView.setText(a(this.f52723b));
        if (com.paytm.utility.b.c(getApplicationContext())) {
            String str = this.f52722a;
            if (str != null) {
                a().a(str);
            }
        } else {
            android.view.View a3 = a(R.id.no_network_layout);
            k.a((Object) a3, "no_network_layout");
            a3.setVisibility(0);
            RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_sf_widgets);
            k.a((Object) recyclerView3, "rv_sf_widgets");
            recyclerView3.setVisibility(8);
        }
        q qVar = this;
        a().f52792a.observe(qVar, new c(this));
        a().f52793b.observe(qVar, new d(this));
    }

    public static final class a extends l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        public final al.b invoke() {
            al.b defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            k.a((Object) defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final class b extends l implements kotlin.g.a.a<an> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        public final an invoke() {
            an viewModelStore = this.$this_viewModels.getViewModelStore();
            k.a((Object) viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SFDeeplinkActivity f52732a;

        e(SFDeeplinkActivity sFDeeplinkActivity) {
            this.f52732a = sFDeeplinkActivity;
        }

        public final void onClick(android.view.View view) {
            this.f52732a.onBackPressed();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SFDeeplinkActivity f52733a;

        f(SFDeeplinkActivity sFDeeplinkActivity) {
            this.f52733a = sFDeeplinkActivity;
        }

        public final void onClick(android.view.View view) {
            String c2;
            if (com.paytm.utility.b.c((Context) this.f52733a) && (c2 = this.f52733a.f52722a) != null) {
                this.f52733a.a().a(c2);
            }
        }
    }

    private final CharSequence a(String str) {
        String str2;
        try {
            str2 = getString(getResources().getIdentifier(str, "string", getPackageName()));
        } catch (Exception unused) {
            str2 = "";
        }
        return str2 != null ? str2 : str;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.locale.b.e.a(context));
    }

    static final class d<T> implements z<net.one97.paytm.landingpage.leftNavigation.model.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SFDeeplinkActivity f52731a;

        d(SFDeeplinkActivity sFDeeplinkActivity) {
            this.f52731a = sFDeeplinkActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ProgressBar progressBar = (ProgressBar) this.f52731a.a(R.id.pb_loading);
            k.a((Object) progressBar, "pb_loading");
            progressBar.setVisibility(8);
            android.view.View a2 = this.f52731a.a(R.id.no_network_layout);
            k.a((Object) a2, "no_network_layout");
            a2.setVisibility(0);
            ((ImageView) this.f52731a.a(R.id.no_network_img)).setImageDrawable((Drawable) null);
            TextView textView = (TextView) this.f52731a.a(R.id.no_network_title);
            k.a((Object) textView, "no_network_title");
            textView.setText("");
            TextView textView2 = (TextView) this.f52731a.a(R.id.retry_network);
            k.a((Object) textView2, "retry_network");
            textView2.setText("");
            TextView textView3 = (TextView) this.f52731a.a(R.id.retry_network);
            k.a((Object) textView3, "retry_network");
            textView3.setBackground((Drawable) null);
            TextView textView4 = (TextView) this.f52731a.a(R.id.no_network_msg);
            k.a((Object) textView4, "no_network_msg");
            textView4.setText(this.f52731a.getString(R.string.some_went_wrong));
        }
    }
}
