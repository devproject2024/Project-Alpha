package net.one97.paytm.wallet.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRNobleInitiative;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ai;
import net.one97.paytm.wallet.b.b;
import net.one97.paytm.wallet.d.h;
import net.one97.paytm.wallet.f.i;
import net.one97.paytm.wallet.f.l;

public class m extends f implements View.OnClickListener, b.a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    CJRNobleInitiative f70073a;

    /* renamed from: b  reason: collision with root package name */
    NetworkImageView f70074b;

    /* renamed from: c  reason: collision with root package name */
    TextView f70075c;

    /* renamed from: d  reason: collision with root package name */
    TextView f70076d;

    /* renamed from: e  reason: collision with root package name */
    RecyclerView f70077e;

    /* renamed from: f  reason: collision with root package name */
    b<Integer> f70078f;

    /* renamed from: g  reason: collision with root package name */
    Context f70079g;

    /* renamed from: h  reason: collision with root package name */
    Button f70080h;

    /* renamed from: i  reason: collision with root package name */
    Integer f70081i;
    TextView j;
    h k;
    BottomSheetBehavior l;
    l m;
    RelativeLayout n;
    RelativeLayout o;
    TextView p;
    boolean q = false;
    int r = 0;
    int s = -1;

    public final /* synthetic */ void a(Object obj, int i2) {
        Integer num = (Integer) obj;
        this.l.setState(3);
        this.f70077e.invalidate();
        this.f70081i = num;
        this.s = i2;
        this.m.c(i2);
        this.f70080h.setVisibility(0);
        this.f70080h.setText(getString(R.string.cart_proceed_to_pay, String.valueOf(num)));
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.k == null) {
            this.k = new h();
        }
        this.k.a((Activity) getActivity(), (i) new i() {
            public final void a() {
            }

            public final void a(String str) {
            }

            public final void b() {
            }

            public final void a(IJRDataModel iJRDataModel) {
                net.one97.paytm.f.b.a().c();
                if (m.this.l != null) {
                    m.this.l.setState(5);
                }
                if (m.this.m != null) {
                    m.this.m.a(m.this.f70081i.intValue());
                }
                m.this.a();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.noble_dialog_bottom_sheet, viewGroup, false);
        this.f70079g = inflate.getContext();
        this.f70074b = (NetworkImageView) inflate.findViewById(R.id.parent_image_view);
        this.f70075c = (TextView) inflate.findViewById(R.id.description_noble);
        this.f70076d = (TextView) inflate.findViewById(R.id.sub_header_noble);
        this.f70077e = (RecyclerView) inflate.findViewById(R.id.recycler_slabs);
        this.f70080h = (Button) inflate.findViewById(R.id.id_proceed_to_pay);
        this.j = (TextView) inflate.findViewById(R.id.paytm_noble);
        this.n = (RelativeLayout) inflate.findViewById(R.id.contribute_layout);
        this.o = (RelativeLayout) inflate.findViewById(R.id.contribute_layout_success);
        this.p = (TextView) inflate.findViewById(R.id.noble_success);
        CJRNobleInitiative cJRNobleInitiative = this.f70073a;
        if (!(cJRNobleInitiative == null || cJRNobleInitiative.response == null)) {
            this.j.setText(this.f70073a.response.subHeader);
            this.f70074b.setImageUrl(this.f70073a.response.imageUrlBig, ai.INSTANCE.getImageLoader());
            this.f70075c.setText(this.f70073a.response.description);
            this.f70076d.setText(this.f70073a.response.subHeader);
            this.f70076d.setVisibility(4);
            this.f70077e.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            CJRNobleInitiative cJRNobleInitiative2 = this.f70073a;
            if (cJRNobleInitiative2 != null && cJRNobleInitiative2.response.slab.size() > 0) {
                this.f70078f = new b<>(this.f70073a.response.slab, this);
                this.f70077e.setAdapter(this.f70078f);
            }
        }
        if (this.q) {
            int i2 = this.r;
            if (i2 != 0) {
                this.f70081i = Integer.valueOf(i2);
            }
            a();
        } else {
            int i3 = this.s;
            if (i3 != -1 && i3 < this.f70073a.response.slab.size()) {
                this.f70077e.post(new Runnable() {
                    public final void run() {
                        m.this.f70077e.findViewHolderForAdapterPosition(m.this.s).itemView.performClick();
                    }
                });
            }
        }
        this.f70080h.setOnClickListener(this);
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f70073a = (CJRNobleInitiative) arguments.getSerializable("donate_item");
            this.q = arguments.getBoolean("is_money_paid");
            this.r = arguments.getInt("amount_paid");
            this.s = arguments.getInt("selected_position");
        }
    }

    public void onStart() {
        super.onStart();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                m.this.l = BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet));
                m.this.l.setState(4);
                m.this.l.setPeekHeight((int) ((m.this.getActivity().getResources().getDisplayMetrics().density * 480.0f) + 0.5f));
            }
        });
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.n.setVisibility(8);
        this.o.setVisibility(0);
        this.p.setText(getString(R.string.success_amount, this.f70081i));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.id_proceed_to_pay) {
            try {
                if (this.f70081i != null) {
                    this.m.b(this.f70081i.intValue());
                    this.f70080h.setEnabled(false);
                    dismiss();
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            m.this.f70080h.setEnabled(true);
                        }
                    }, 3000);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        if (getActivity() != null && isAdded()) {
            dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }

    public final void b() {
        this.f70077e.invalidate();
        this.f70080h.setVisibility(4);
    }
}
