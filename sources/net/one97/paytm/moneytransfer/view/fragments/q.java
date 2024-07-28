package net.one97.paytm.moneytransfer.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackpocket.scratchoff.c;
import com.jackpocket.scratchoff.views.ScratchableLinearLayout;
import net.one97.paytm.common.entity.CJRClaimCashbackDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.g;
import net.one97.paytm.moneytransfer.b.a.b;
import net.one97.paytm.moneytransfer.presenter.f;
import net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public class q extends h implements g.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f54608a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f54609b;

    /* renamed from: c  reason: collision with root package name */
    private String f54610c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public g.a f54611d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f54612e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f54613f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f54614g;

    /* renamed from: h  reason: collision with root package name */
    private View f54615h;

    /* renamed from: i  reason: collision with root package name */
    private ScratchableLinearLayout f54616i;
    private RelativeLayout j;
    private RelativeLayout k;
    private LinearLayout l;
    /* access modifiers changed from: private */
    public c m;
    private a n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public double p;

    public interface a {
        void b(boolean z);
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f54611d = (g.a) obj;
    }

    public static q a(String str) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putString("txn_id", str);
        qVar.setArguments(bundle);
        return qVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.n = (a) context;
        }
        if (getArguments() != null) {
            this.f54608a = getArguments().getString("txn_id");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b a2 = net.one97.paytm.moneytransfer.b.a(getActivity());
        getActivity();
        this.f54611d = new f(this, a2, net.one97.paytm.upi.g.a());
        this.f54611d.e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_scratch, (ViewGroup) null, false);
        this.j = (RelativeLayout) inflate.findViewById(R.id.rl_parent);
        this.k = (RelativeLayout) inflate.findViewById(R.id.rl_cashback_view);
        this.l = (LinearLayout) inflate.findViewById(R.id.ll_better_luck_view);
        this.f54612e = (TextView) inflate.findViewById(R.id.tv_cashback_won_label);
        this.f54613f = (TextView) inflate.findViewById(R.id.tv_cashback_amount);
        this.f54614g = (TextView) inflate.findViewById(R.id.tv_cashback_duration_label);
        this.f54615h = inflate.findViewById(R.id.v_divider);
        this.f54616i = (ScratchableLinearLayout) inflate.findViewById(R.id.scratch_view);
        this.j.setVisibility(8);
        return inflate;
    }

    public final void a(UpiGenerateCashbackDataModel.CJRScratchCard cJRScratchCard) {
        this.f54611d.a();
        double amount = cJRScratchCard.getAmount();
        String scratchCardId = cJRScratchCard.getScratchCardId();
        this.p = amount;
        this.f54609b = scratchCardId;
        if (this.p <= 0.0d || TextUtils.isEmpty(this.f54609b)) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            a();
            return;
        }
        double d2 = this.p;
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        TextView textView = this.f54613f;
        textView.setText(getString(R.string.rupee_symbol) + " " + ((int) d2));
        if (!TextUtils.isEmpty(this.f54610c)) {
            this.f54614g.setText(this.f54610c);
        }
        a();
    }

    private void a() {
        this.j.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.top_to_down_animation));
        this.j.setVisibility(0);
        a(getView());
    }

    public final void a(CJRClaimCashbackDataModel cJRClaimCashbackDataModel) {
        if (cJRClaimCashbackDataModel != null) {
            TextUtils.isEmpty(cJRClaimCashbackDataModel.getMessage());
        }
    }

    private void a(View view) {
        c cVar = new c(getContext());
        cVar.f40812e = 0.25d;
        c a2 = cVar.a(getContext(), 25);
        a2.f40814g = true;
        a2.f40813f = true;
        a2.f40809b = new Runnable() {
            public final void run() {
                boolean unused = q.this.o = true;
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        q.a(q.this, true);
                    }
                }, 1000);
                if (q.this.p > 0.0d) {
                    q.this.f54611d.a(q.this.f54608a, q.this.f54609b);
                }
            }
        };
        this.m = a2.a(view.findViewById(R.id.scratch_view), view.findViewById(R.id.scratch_view_behind));
        this.m.b().setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!q.this.o) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        q.a(q.this, false);
                    } else if (action == 1) {
                        q.a(q.this, true);
                    }
                }
                return q.this.m.onTouch(view, motionEvent);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.m;
        if (cVar != null) {
            cVar.g();
            if (cVar.f40808a != null) {
                com.jackpocket.scratchoff.b bVar = cVar.f40808a;
                if (bVar.f40797c != null) {
                    bVar.f40797c.recycle();
                    bVar.f40797c = null;
                    bVar.f40796b = null;
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        c cVar = this.m;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void onResume() {
        super.onResume();
        c cVar = this.m;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if ((getView() != null && isAdded() && isResumed()) && upiProfileDefaultBank.getCreditBank() != null) {
            this.f54610c = String.format(getString(R.string.mt_cashback_credit_duration_with_bank), new Object[]{upiProfileDefaultBank.getCreditBank().getBankName()});
        }
    }

    static /* synthetic */ void a(q qVar, boolean z) {
        a aVar = qVar.n;
        if (aVar != null) {
            aVar.b(z);
        }
    }
}
