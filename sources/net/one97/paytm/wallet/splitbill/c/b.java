package net.one97.paytm.wallet.splitbill.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupDTO;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupSnapshot;

public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public List<SBGroupSnapshot> f72108a;

    /* renamed from: b  reason: collision with root package name */
    public List<SBGroupSnapshot> f72109b;

    /* renamed from: c  reason: collision with root package name */
    public List<SBGroupSnapshot> f72110c;

    /* renamed from: d  reason: collision with root package name */
    public SBGroupDTO f72111d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f72112e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f72113f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f72114g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f72115h;

    /* renamed from: i  reason: collision with root package name */
    private Float f72116i;
    private Float j;
    private Context k;
    private RecyclerView l;
    private RecyclerView m;
    private net.one97.paytm.wallet.splitbill.a.f n;
    private net.one97.paytm.wallet.splitbill.a.f o;

    public b() {
        Float valueOf = Float.valueOf(0.0f);
        this.f72116i = valueOf;
        this.j = valueOf;
    }

    public static b a() {
        return new b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.k = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_bottom_sheet_pay_receive_fragment, viewGroup, false);
        this.f72112e = (ImageView) inflate.findViewById(R.id.cross_btn);
        this.f72113f = (RoboTextView) inflate.findViewById(R.id.group_name);
        this.f72115h = (RoboTextView) inflate.findViewById(R.id.total_pay);
        this.f72114g = (RoboTextView) inflate.findViewById(R.id.total_receive);
        this.m = (RecyclerView) inflate.findViewById(R.id.totalPayableRV);
        this.l = (RecyclerView) inflate.findViewById(R.id.totalReceivableRV);
        List<SBGroupSnapshot> list = this.f72108a;
        if (list != null && list.size() > 0) {
            for (SBGroupSnapshot next : this.f72108a) {
                if (Float.parseFloat(next.getAmount()) > 0.0f) {
                    this.f72116i = Float.valueOf(this.f72116i.floatValue() + Float.valueOf(Math.abs(Float.parseFloat(next.getAmount()))).floatValue());
                    this.f72109b.add(next);
                } else if (Float.parseFloat(next.getAmount()) < 0.0f) {
                    this.j = Float.valueOf(this.j.floatValue() + Float.parseFloat(next.getAmount()));
                    this.f72110c.add(next);
                }
            }
            if (this.f72116i.floatValue() == 0.0f) {
                this.f72115h.setText("No Amounts Due");
                this.f72115h.setAlpha(0.5f);
            } else {
                this.f72115h.setText(String.valueOf(Math.abs(this.f72116i.floatValue())));
                this.f72115h.setAlpha(1.0f);
            }
            if (this.j.floatValue() == 0.0f) {
                this.f72114g.setText("No Amounts Due");
                this.f72114g.setAlpha(0.5f);
            } else {
                this.f72114g.setText(String.valueOf(Math.abs(this.j.floatValue())));
                this.f72114g.setAlpha(1.0f);
            }
        }
        SBGroupDTO sBGroupDTO = this.f72111d;
        if (sBGroupDTO != null) {
            this.f72113f.setText(sBGroupDTO.getName());
        }
        this.m.setLayoutManager(new LinearLayoutManager(this.k));
        this.n = new net.one97.paytm.wallet.splitbill.a.f(this.k, this.f72109b, true);
        this.m.setAdapter(this.n);
        this.l.setLayoutManager(new LinearLayoutManager(this.k));
        this.o = new net.one97.paytm.wallet.splitbill.a.f(this.k, this.f72110c, false);
        this.l.setAdapter(this.o);
        this.f72112e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
        return inflate;
    }
}
