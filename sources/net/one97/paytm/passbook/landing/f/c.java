package net.one97.paytm.passbook.landing.f;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.utility.f;
import net.one97.paytm.passbook.utility.q;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final net.one97.paytm.passbook.landing.c.b f57735a;

    public c(net.one97.paytm.passbook.landing.c.b bVar) {
        k.c(bVar, "mPaymentHistoryFragment");
        this.f57735a = bVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57736a;

        public a(c cVar) {
            this.f57736a = cVar;
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "uth_txn_clear_filter_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            Context context = this.f57736a.f57735a.getContext();
            String str = null;
            if (context == null || f.a(context)) {
                net.one97.paytm.passbook.landing.c.b bVar = this.f57736a.f57735a;
                net.one97.paytm.passbook.landing.a.a aVar = new net.one97.paytm.passbook.landing.a.a(this.f57736a.f57735a, this.f57736a.f57735a);
                k.c(aVar, "<set-?>");
                bVar.f57604a = aVar;
                RecyclerView recyclerView = (RecyclerView) this.f57736a.f57735a.a(R.id.rvPassbookEntries);
                k.a((Object) recyclerView, "mPaymentHistoryFragment.rvPassbookEntries");
                recyclerView.setAdapter(this.f57736a.f57735a.b());
                net.one97.paytm.passbook.landing.c.b bVar2 = this.f57736a.f57735a;
                bVar2.f57605b = 1;
                bVar2.f57606c = null;
                this.f57736a.f57735a.c();
                View a2 = this.f57736a.f57735a.a(R.id.ilDataFetchError);
                k.a((Object) a2, "mPaymentHistoryFragment.ilDataFetchError");
                a2.setVisibility(8);
                return;
            }
            Context context2 = this.f57736a.f57735a.getContext();
            Context context3 = this.f57736a.f57735a.getContext();
            if (context3 != null) {
                str = context3.getString(R.string.no_internet_body);
            }
            Toast.makeText(context2, str, 0).show();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57737a;

        public b(c cVar) {
            this.f57737a = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f57737a.f57735a.c();
        }
    }

    public final void a(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        k.c(onClickListener, "listener");
        FragmentActivity activity = this.f57735a.getActivity();
        if (activity != null) {
            try {
                k.a((Object) activity, "it");
                if (!activity.isFinishing()) {
                    String str4 = null;
                    if (TextUtils.isEmpty(str)) {
                        Context context = this.f57735a.getContext();
                        str = context != null ? context.getString(R.string.error) : null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        Context context2 = this.f57735a.getContext();
                        str = context2 != null ? context2.getString(R.string.pass_payment_history_details_default_failure_msg) : null;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        Context context3 = this.f57735a.getContext();
                        if (context3 != null) {
                            str4 = context3.getString(R.string.ok);
                        }
                        str = str4;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f57735a.getContext());
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(str3, onClickListener);
                    builder.setCancelable(true);
                    builder.show();
                }
            } catch (Exception unused) {
                x xVar = x.f47997a;
            }
        }
    }

    public final void a(boolean z, ShimmerFrameLayout shimmerFrameLayout) {
        if (z) {
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.setVisibility(0);
            }
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
            View a2 = this.f57735a.a(R.id.paymentHistoryHeader);
            k.a((Object) a2, "mPaymentHistoryFragment.paymentHistoryHeader");
            a2.setVisibility(0);
            a();
            return;
        }
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setVisibility(8);
        }
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        View a3 = this.f57735a.a(R.id.paymentHistoryHeader);
        k.a((Object) a3, "mPaymentHistoryFragment.paymentHistoryHeader");
        a3.setVisibility(8);
    }

    private final void a() {
        String[] stringArray = this.f57735a.getResources().getStringArray(R.array.pass_payment_hist_filter_items);
        k.a((Object) stringArray, "mPaymentHistoryFragment.…ayment_hist_filter_items)");
        ArrayList arrayList = (ArrayList) kotlin.a.f.a((T[]) stringArray, new ArrayList());
        if (this.f57735a.b().f57545d == 0) {
            a(false);
            return;
        }
        View a2 = this.f57735a.a(R.id.paymentHistoryHeader);
        k.a((Object) a2, "mPaymentHistoryFragment.paymentHistoryHeader");
        AppCompatTextView appCompatTextView = (AppCompatTextView) a2.findViewById(R.id.tvSelectedFilter);
        k.a((Object) appCompatTextView, "mPaymentHistoryFragment.…ryHeader.tvSelectedFilter");
        appCompatTextView.setText((CharSequence) arrayList.get(this.f57735a.b().f57545d));
        a(true);
    }

    private final void a(boolean z) {
        if (z) {
            View a2 = this.f57735a.a(R.id.paymentHistoryHeader);
            k.a((Object) a2, "mPaymentHistoryFragment.paymentHistoryHeader");
            AppCompatTextView appCompatTextView = (AppCompatTextView) a2.findViewById(R.id.tvPaymentHistDesc);
            k.a((Object) appCompatTextView, "mPaymentHistoryFragment.…yHeader.tvPaymentHistDesc");
            appCompatTextView.setVisibility(8);
            View a3 = this.f57735a.a(R.id.paymentHistoryHeader);
            k.a((Object) a3, "mPaymentHistoryFragment.paymentHistoryHeader");
            ConstraintLayout constraintLayout = (ConstraintLayout) a3.findViewById(R.id.selectedFilterLayout);
            k.a((Object) constraintLayout, "mPaymentHistoryFragment.…ader.selectedFilterLayout");
            constraintLayout.setVisibility(0);
            View a4 = this.f57735a.a(R.id.paymentHistoryHeader);
            k.a((Object) a4, "mPaymentHistoryFragment.paymentHistoryHeader");
            AppCompatImageView appCompatImageView = (AppCompatImageView) a4.findViewById(R.id.vFilterIndicator);
            k.a((Object) appCompatImageView, "mPaymentHistoryFragment.…ryHeader.vFilterIndicator");
            appCompatImageView.setVisibility(0);
            return;
        }
        View a5 = this.f57735a.a(R.id.paymentHistoryHeader);
        k.a((Object) a5, "mPaymentHistoryFragment.paymentHistoryHeader");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a5.findViewById(R.id.selectedFilterLayout);
        k.a((Object) constraintLayout2, "mPaymentHistoryFragment.…ader.selectedFilterLayout");
        constraintLayout2.setVisibility(8);
        View a6 = this.f57735a.a(R.id.paymentHistoryHeader);
        k.a((Object) a6, "mPaymentHistoryFragment.paymentHistoryHeader");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a6.findViewById(R.id.vFilterIndicator);
        k.a((Object) appCompatImageView2, "mPaymentHistoryFragment.…ryHeader.vFilterIndicator");
        appCompatImageView2.setVisibility(8);
    }
}
