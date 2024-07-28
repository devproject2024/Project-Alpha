package com.travel.sale;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b.b;
import com.travel.R;
import com.travel.sale.data.model.CampaignSubscriptionResponse;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f25722b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String j = j;

    /* renamed from: a  reason: collision with root package name */
    C0480b f25723a;

    /* renamed from: c  reason: collision with root package name */
    private CampaignSubscriptionResponse f25724c;

    /* renamed from: d  reason: collision with root package name */
    private View f25725d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f25726e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f25727f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f25728g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f25729h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f25730i;
    private HashMap k;

    /* renamed from: com.travel.sale.b$b  reason: collision with other inner class name */
    public interface C0480b {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(j) : null;
        if (!(serializable instanceof CampaignSubscriptionResponse)) {
            serializable = null;
        }
        this.f25724c = (CampaignSubscriptionResponse) serializable;
    }

    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            k.c(context, "context");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = ((Activity) context).getWindowManager();
            k.a((Object) windowManager, "(context as Activity).windowManager");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = (int) (((double) displayMetrics.heightPixels) * 0.7d);
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            k.c(context2, "context");
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            WindowManager windowManager2 = ((Activity) context2).getWindowManager();
            k.a((Object) windowManager2, "(context as Activity).windowManager");
            windowManager2.getDefaultDisplay().getMetrics(displayMetrics2);
            int i3 = (int) (((double) displayMetrics2.widthPixels) * 0.95d);
            Window window = dialog.getWindow();
            if (window == null) {
                k.a();
            }
            window.setLayout(i3, i2);
            Window window2 = dialog.getWindow();
            if (window2 == null) {
                k.a();
            }
            window2.setBackgroundDrawableResource(R.drawable.sales_registered_rounded_corner);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.registered_view, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Context context;
        CampaignSubscriptionResponse.CampaignSubscriptionData body;
        CampaignSubscriptionResponse.CampaignSubscriptionData body2;
        CampaignSubscriptionResponse.CampaignSubscriptionData body3;
        Dialog dialog;
        Window window;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f25725d = view;
        if (getDialog() != null) {
            Dialog dialog2 = getDialog();
            if (!((dialog2 != null ? dialog2.getWindow() : null) == null || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null)) {
                window.setBackgroundDrawableResource(R.drawable.sales_registered_rounded_corner);
            }
        }
        View view2 = this.f25725d;
        this.f25726e = view2 != null ? (ImageView) view2.findViewById(R.id.state_image) : null;
        View view3 = this.f25725d;
        this.f25727f = view3 != null ? (TextView) view3.findViewById(R.id.state_title) : null;
        View view4 = this.f25725d;
        this.f25728g = view4 != null ? (TextView) view4.findViewById(R.id.state_description) : null;
        View view5 = this.f25725d;
        this.f25729h = view5 != null ? (RelativeLayout) view5.findViewById(R.id.register_btn) : null;
        View view6 = this.f25725d;
        this.f25730i = view6 != null ? (ImageView) view6.findViewById(R.id.cancel_button) : null;
        ImageView imageView = this.f25730i;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        RelativeLayout relativeLayout = this.f25729h;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new d(this));
        }
        TextView textView = this.f25727f;
        if (textView != null) {
            CampaignSubscriptionResponse campaignSubscriptionResponse = this.f25724c;
            textView.setText((campaignSubscriptionResponse == null || (body3 = campaignSubscriptionResponse.getBody()) == null) ? null : body3.getSuccessfullySubscribedHeading());
        }
        TextView textView2 = this.f25728g;
        if (textView2 != null) {
            CampaignSubscriptionResponse campaignSubscriptionResponse2 = this.f25724c;
            textView2.setText((campaignSubscriptionResponse2 == null || (body2 = campaignSubscriptionResponse2.getBody()) == null) ? null : body2.getSuccessfullySubscribedText());
        }
        ImageView imageView2 = this.f25726e;
        CampaignSubscriptionResponse campaignSubscriptionResponse3 = this.f25724c;
        String successfullySubscribedIconUrl = (campaignSubscriptionResponse3 == null || (body = campaignSubscriptionResponse3.getBody()) == null) ? null : body.getSuccessfullySubscribedIconUrl();
        CharSequence charSequence = successfullySubscribedIconUrl;
        if (!(charSequence == null || charSequence.length() == 0) && imageView2 != null && (context = getContext()) != null) {
            b.a aVar = com.paytm.utility.b.b.f43744a;
            k.a((Object) context, "it");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = successfullySubscribedIconUrl;
            a2.m = true;
            Resources resources = getResources();
            Drawable drawable = resources != null ? resources.getDrawable(R.drawable.sales_placeholder_default) : null;
            k.a((Object) drawable, "getResources()?.getDrawa…ales_placeholder_default)");
            b.a.C0750a b2 = a2.b(drawable);
            Resources resources2 = getResources();
            Drawable drawable2 = resources2 != null ? resources2.getDrawable(R.drawable.sales_placeholder_default) : null;
            k.a((Object) drawable2, "getResources()?.getDrawa…ales_placeholder_default)");
            b.a.C0750a.a(b2.a((Object) drawable2), imageView2, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25731a;

        c(b bVar) {
            this.f25731a = bVar;
        }

        public final void onClick(View view) {
            this.f25731a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25732a;

        d(b bVar) {
            this.f25732a = bVar;
        }

        public final void onClick(View view) {
            this.f25732a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
