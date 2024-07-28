package net.one97.paytm.passbook.transactionHistory.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.ExtraInfo;
import net.one97.paytm.passbook.beans.SADetailsResponse;
import net.one97.paytm.passbook.mapping.a.d;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.j;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.transactionHistory.activity.SATransactionDetailsActivity;
import net.one97.paytm.passbook.utility.q;

public final class a extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.passbook.transactionHistory.a.a f59186a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.passbook.transactionHistory.a f59187b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SADetailsResponse f59188c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f59189d = new b(this);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f59190e;

    public final View a(int i2) {
        if (this.f59190e == null) {
            this.f59190e = new HashMap();
        }
        View view = (View) this.f59190e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f59190e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.passbook.transactionHistory.fragments.a$a  reason: collision with other inner class name */
    static final class C1142a<T> implements z<f<? extends SADetailsResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59191a;

        C1142a(a aVar) {
            this.f59191a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError;
            String str;
            String c2;
            f fVar = (f) obj;
            String str2 = null;
            if (fVar.f57886a == j.SUCCESS) {
                this.f59191a.f59188c = (SADetailsResponse) fVar.f57887b;
                SADetailsResponse a2 = this.f59191a.f59188c;
                if (!TextUtils.isEmpty(a2 != null ? a2.getResponseCode() : null)) {
                    SADetailsResponse sADetailsResponse = (SADetailsResponse) fVar.f57887b;
                    if (sADetailsResponse != null) {
                        str2 = sADetailsResponse.getMessage();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.f59191a.getString(R.string.pass_payment_history_list_default_failure_msg);
                    }
                    a.b(this.f59191a).a(str2);
                } else {
                    net.one97.paytm.passbook.transactionHistory.a b2 = a.b(this.f59191a);
                    SADetailsResponse a3 = this.f59191a.f59188c;
                    if (a3 != null) {
                        k.c(a3, Payload.RESPONSE);
                        b2.f59160a = a3;
                        FrameLayout frameLayout = (FrameLayout) b2.f59161b.a(R.id.ilError);
                        k.a((Object) frameLayout, "transactionHistoryFragment.ilError");
                        frameLayout.setVisibility(8);
                        TextView textView = (TextView) b2.f59161b.a(R.id.tvStatus);
                        k.a((Object) textView, "transactionHistoryFragment.tvStatus");
                        textView.setText(a3.getDetailNarration());
                        ImageView imageView = (ImageView) b2.f59161b.a(R.id.share_imv);
                        k.a((Object) imageView, "transactionHistoryFragment.share_imv");
                        imageView.setVisibility(0);
                        String amount = a3.getAmount();
                        if (!(amount == null || (c2 = net.one97.paytm.passbook.utility.f.c(Double.parseDouble(amount))) == null)) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) b2.f59161b.a(R.id.tvAmount);
                            k.a((Object) appCompatTextView, "transactionHistoryFragment.tvAmount");
                            net.one97.paytm.passbook.utility.f.a(appCompatTextView, c2);
                        }
                        if (a3.getDateTime() != null) {
                            TextView textView2 = (TextView) b2.f59161b.a(R.id.tvDateTime);
                            k.a((Object) textView2, "transactionHistoryFragment.tvDateTime");
                            textView2.setText(net.one97.paytm.passbook.mapping.a.l(a3.getDateTime(), "yyyy-MM-dd HH:mm:ss", "dd MMM yyyy, hh:mm a"));
                        }
                        RelativeLayout relativeLayout = (RelativeLayout) b2.f59161b.a(R.id.rvHeader);
                        k.a((Object) relativeLayout, "transactionHistoryFragment.rvHeader");
                        ((RelativeLayout) b2.f59161b.a(R.id.toolbar)).setBackgroundColor(androidx.core.content.b.c(relativeLayout.getContext(), R.color.color_f3f7f8));
                        ArrayList<String> referenceIds = a3.getReferenceIds();
                        if (referenceIds != null) {
                            int size = referenceIds.size();
                            String str3 = "";
                            for (int i2 = 0; i2 < size; i2++) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str3);
                                if (i2 == referenceIds.size() - 1) {
                                    str = referenceIds.get(i2);
                                } else {
                                    str = referenceIds.get(i2) + 10;
                                }
                                sb.append(str);
                                str3 = sb.toString();
                            }
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) b2.f59161b.a(R.id.tvReferenceIds);
                            k.a((Object) appCompatTextView2, "transactionHistoryFragment.tvReferenceIds");
                            CharSequence charSequence = str3;
                            appCompatTextView2.setText(charSequence);
                            if (str3 == null) {
                                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                            } else if (!TextUtils.isEmpty(p.b(charSequence).toString())) {
                                View a4 = b2.f59161b.a(R.id.seperator);
                                k.a((Object) a4, "transactionHistoryFragment.seperator");
                                a4.setVisibility(0);
                            } else {
                                View a5 = b2.f59161b.a(R.id.seperator);
                                k.a((Object) a5, "transactionHistoryFragment.seperator");
                                a5.setVisibility(8);
                            }
                        }
                        b2.a(a3.getFirstInstrument());
                        b2.a(a3.getSecondInstrument());
                        w.a().a(a3.getStatusLogoUrl()).a((ImageView) b2.f59161b.a(R.id.ivStatus));
                        if (net.one97.paytm.passbook.transactionHistory.a.a(a3)) {
                            ((TextView) b2.f59161b.a(R.id.tvNeedHelp)).setText(R.string.pass_view_more_details);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.SADetailsResponse");
                    }
                }
            } else if (fVar.f57886a == j.ERROR) {
                d<? extends T> dVar = fVar.f57888c;
                if (dVar != null) {
                    networkCustomError = dVar.f57879a;
                } else {
                    networkCustomError = null;
                }
                if (((networkCustomError == null || networkCustomError.getStatusCode() != -1) && networkCustomError != null && networkCustomError.getStatusCode() == 410) || ((networkCustomError != null && networkCustomError.getStatusCode() == 401) || (networkCustomError != null && networkCustomError.getStatusCode() == 403))) {
                    this.f59191a.getClass().getName();
                    net.one97.paytm.passbook.utility.j.a(this.f59191a.getActivity(), networkCustomError, false, true);
                } else {
                    a.b(this.f59191a).a((String) null);
                }
            }
            a.a();
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.transactionHistory.a b(a aVar) {
        net.one97.paytm.passbook.transactionHistory.a aVar2 = aVar.f59187b;
        if (aVar2 == null) {
            k.a("uiHandler");
        }
        return aVar2;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_history, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.transactionHistory.a.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ilsViewModel::class.java)");
        this.f59186a = (net.one97.paytm.passbook.transactionHistory.a.a) a2;
        this.f59187b = new net.one97.paytm.passbook.transactionHistory.a(this);
        b();
        net.one97.paytm.passbook.transactionHistory.a.a aVar = this.f59186a;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.f59163a.observe(this, new C1142a(this));
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.ivBack)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.share_imv)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.btnRetry)).setOnClickListener(onClickListener);
        ((RelativeLayout) a(R.id.rlNeedHelp)).setOnClickListener(onClickListener);
    }

    private final void b() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            d();
            net.one97.paytm.passbook.transactionHistory.a.a aVar = this.f59186a;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.a(intent.getStringExtra("ACCOUNT_NUMBER"), intent.getStringExtra("tranDateEpochMilli"), intent.getStringExtra("dateTimeEpochMilli"), intent.getStringExtra("txnId"));
        }
    }

    public final void onClick(View view) {
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ivBack;
        if (valueOf != null && valueOf.intValue() == i2) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        int i3 = R.id.share_imv;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.btnRetry;
            if (valueOf != null && valueOf.intValue() == i4) {
                Context context = getContext();
                if (context != null) {
                    k.a((Object) context, "it");
                    if (net.one97.paytm.passbook.utility.f.a(context)) {
                        b();
                    } else {
                        c.a(context, getString(R.string.no_connection), getString(R.string.no_internet_body));
                    }
                }
            } else {
                int i5 = R.id.rlNeedHelp;
                if (valueOf != null && valueOf.intValue() == i5) {
                    SADetailsResponse sADetailsResponse = this.f59188c;
                    if (sADetailsResponse != null) {
                        if (this.f59187b == null) {
                            k.a("uiHandler");
                        }
                        if (net.one97.paytm.passbook.transactionHistory.a.a(sADetailsResponse)) {
                            ExtraInfo extraInfo = sADetailsResponse.getExtraInfo();
                            if (!TextUtils.isEmpty(extraInfo != null ? extraInfo.getUpiTranId() : null)) {
                                StringBuilder sb = new StringBuilder("paytmmp://upi_passbook?featuretype=transactiondetail&txnId=");
                                ExtraInfo extraInfo2 = sADetailsResponse.getExtraInfo();
                                if (extraInfo2 != null) {
                                    str = extraInfo2.getUpiTranId();
                                }
                                sb.append(str);
                                net.one97.paytm.passbook.d.b().a(sb.toString(), (Activity) getActivity());
                                return;
                            }
                        }
                        c();
                        return;
                    }
                    c();
                }
            }
        } else if (isAdded() && getActivity() != null && (getActivity() instanceof SATransactionDetailsActivity)) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                SATransactionDetailsActivity sATransactionDetailsActivity = (SATransactionDetailsActivity) activity2;
                if (sATransactionDetailsActivity != null) {
                    Runnable runnable = this.f59189d;
                    k.c(runnable, "taskRunnable");
                    sATransactionDetailsActivity.f59169a = runnable;
                    if (s.a()) {
                        Activity activity3 = sATransactionDetailsActivity;
                        if (!s.c(activity3)) {
                            s.b(activity3);
                            return;
                        }
                    }
                    sATransactionDetailsActivity.a();
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.transactionHistory.activity.SATransactionDetailsActivity");
        }
    }

    private final void c() {
        y<f<SADetailsResponse>> yVar;
        f value;
        SADetailsResponse sADetailsResponse;
        Object cstorderItem;
        net.one97.paytm.passbook.transactionHistory.a.a aVar = this.f59186a;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar != null && (yVar = aVar.f59163a) != null && (value = yVar.getValue()) != null && (sADetailsResponse = (SADetailsResponse) value.f57887b) != null && (cstorderItem = sADetailsResponse.getCstorderItem()) != null) {
            net.one97.paytm.passbook.d.b().a((AppCompatActivity) getActivity(), new com.google.gson.f().b(cstorderItem).toString());
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59192a;

        b(a aVar) {
            this.f59192a = aVar;
        }

        public final void run() {
            View findViewById;
            Uri a2;
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", this.f59192a.getString(R.string.post_payment_share_subject));
                View view = this.f59192a.getView();
                if (view != null && (findViewById = view.findViewById(R.id.svContent)) != null && (a2 = q.a(this.f59192a.getContext(), a.a(findViewById))) != null) {
                    intent.putExtra("android.intent.extra.STREAM", a2);
                    Intent createChooser = Intent.createChooser(intent, this.f59192a.getString(R.string.post_payment_share_title));
                    Context context = this.f59192a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                        this.f59192a.startActivity(createChooser);
                    } else {
                        Toast.makeText(this.f59192a.getActivity(), this.f59192a.getString(R.string.no_app_found), 1).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static Bitmap a(View view) {
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.rlNeedHelp);
        k.a((Object) findViewById, "needHelp");
        int visibility = findViewById.getVisibility();
        findViewById.setVisibility(8);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        findViewById.setVisibility(visibility);
        k.a((Object) createBitmap, "bitmap");
        return createBitmap;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            b();
        }
    }

    private void d() {
        Context context = getContext();
        if (context != null) {
            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
            k.a((Object) context, "it");
            net.one97.paytm.passbook.genericPassbook.d.a.f.a(context);
        }
    }

    public static void a() {
        net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
        net.one97.paytm.passbook.genericPassbook.d.a.f.a();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59190e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
