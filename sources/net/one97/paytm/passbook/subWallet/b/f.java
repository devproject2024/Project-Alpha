package net.one97.paytm.passbook.subWallet.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivity;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.subWallet.a.b;
import net.one97.paytm.passbook.toll_kotlin.imported.a;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollTxnPsgHstryModel;
import net.one97.paytm.passbook.utility.j;

public class f extends h implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f58872a;

    /* renamed from: b  reason: collision with root package name */
    private View f58873b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f58874c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.passbook.toll_kotlin.imported.a.a f58875d;

    /* renamed from: e  reason: collision with root package name */
    private TollTxnPsgHstryModel f58876e;

    /* renamed from: f  reason: collision with root package name */
    private b f58877f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f58878g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f58879h;

    /* renamed from: i  reason: collision with root package name */
    private int f58880i = 0;
    private RelativeLayout j;
    private LinearLayout k;
    private LottieAnimationView l;
    private Activity m;
    private NestedScrollView n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_toll, (ViewGroup) null);
        this.f58876e = new TollTxnPsgHstryModel(getActivity());
        this.m = getActivity();
        this.f58875d = new net.one97.paytm.passbook.toll_kotlin.imported.a.a(this.f58876e, this, this.m);
        this.j = (RelativeLayout) inflate.findViewById(R.id.toll_date_heading);
        this.f58872a = (TextView) inflate.findViewById(R.id.toll_date_heading).findViewById(R.id.passbook_entry_row_heading_month_tv);
        this.k = (LinearLayout) inflate.findViewById(R.id.loader_ll);
        this.l = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        this.f58879h = (RelativeLayout) inflate.findViewById(R.id.noresult_toll_passagehistory);
        this.f58874c = (RecyclerView) inflate.findViewById(R.id.toll_passbook_recycler);
        this.f58878g = new LinearLayoutManager(getActivity());
        this.f58874c.setLayoutManager(this.f58878g);
        this.f58874c.setItemAnimator(new g());
        this.f58877f = new b(this.f58875d);
        this.f58874c.setAdapter(this.f58877f);
        this.f58873b = inflate.findViewById(R.id.noresult_toll_passagehistory);
        this.n = (NestedScrollView) inflate.findViewById(R.id.nsv_wallet);
        this.n.setOnScrollChangeListener(new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                if (i3 != nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                    return;
                }
                if (f.this.f58875d.f58945d) {
                    f.this.f58875d.a();
                } else {
                    net.one97.paytm.passbook.toll_kotlin.imported.a.a unused = f.this.f58875d;
                }
            }
        });
        inflate.findViewById(R.id.toll_date_heading).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(f.this.getActivity(), StatementDownloadActivity.class);
                intent.putExtra("CallingFragment", "TransactionTollPassageHistoryFragment");
                f.this.startActivity(intent);
            }
        });
        net.one97.paytm.passbook.toll_kotlin.imported.a.a aVar = this.f58875d;
        if (aVar != null && aVar.f58944c.isEmpty()) {
            this.f58875d.a();
        }
        return inflate;
    }

    public final void a() {
        this.k.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.l);
    }

    public final void b() {
        this.k.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.l);
    }

    public final void a(int i2, int i3) {
        if (i2 == 0 && i3 > 0) {
            net.one97.paytm.passbook.toll_kotlin.imported.a.a aVar = this.f58875d;
            if (aVar.f58944c != null && aVar.f58944c.size() > 0) {
                aVar.f58943b.a(com.paytm.utility.b.h(aVar.a(0).getTxnDateTime(), "yyyy-MM-dd'T'HH:mm:ss", "MMMM yyyy"));
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.j.setVisibility(8);
        }
        if (i2 == 0 && i3 == 0) {
            this.f58873b.setVisibility(0);
        } else {
            this.f58873b.setVisibility(8);
        }
        if (i2 == 0) {
            this.f58877f.notifyDataSetChanged();
        } else {
            this.f58877f.notifyItemRangeChanged(i2, i3);
        }
    }

    public final void a(String str, String str2) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            c.a((Context) getActivity(), str, str2);
        }
    }

    public final void a(final e eVar) {
        try {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (!activity.isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle(getResources().getString(R.string.no_connection));
                builder.setMessage(getResources().getString(R.string.no_internet));
                builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                        if (com.paytm.utility.b.c((Context) f.this.getActivity())) {
                            f.this.getActivity();
                            net.one97.paytm.passbook.mapping.a.c.a();
                            net.one97.paytm.passbook.mapping.a.c.b(eVar);
                            return;
                        }
                        f.this.a(eVar);
                    }
                });
                builder.show();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(Throwable th) {
        FragmentActivity activity;
        if ((th instanceof NetworkCustomError) && (activity = getActivity()) != null && isAdded() && !activity.isFinishing()) {
            FragmentActivity activity2 = getActivity();
            PassbookSubwalletActivity.class.getName();
            j.a((Activity) activity2, th);
        }
    }

    public final void a(String str) {
        this.f58872a.setText(str);
        this.j.setVisibility(0);
    }
}
