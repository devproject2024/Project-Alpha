package net.one97.paytm.wallet.splitbill.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.g;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private Context f72118a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f72119b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f72120c;

    /* renamed from: d  reason: collision with root package name */
    private g f72121d;

    /* renamed from: e  reason: collision with root package name */
    private String f72122e;

    /* renamed from: f  reason: collision with root package name */
    private String f72123f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<SBUserList> f72124g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private AppCompatImageView f72125h;

    public static c a() {
        return new c();
    }

    public final void a(String str, ArrayList<SBUserList> arrayList, String str2) {
        this.f72122e = str;
        this.f72124g = arrayList;
        this.f72123f = str2;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72118a = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_bottom_sheet_group_member_list_fragment, viewGroup, false);
        this.f72119b = (RoboTextView) inflate.findViewById(R.id.group_name);
        this.f72125h = (AppCompatImageView) inflate.findViewById(R.id.cross_btn);
        this.f72119b.setText(this.f72122e);
        this.f72120c = (RecyclerView) inflate.findViewById(R.id.group_member_list_rv);
        this.f72120c.setLayoutManager(new LinearLayoutManager(this.f72118a));
        this.f72121d = new g(this.f72118a, this.f72124g, this.f72123f);
        this.f72120c.setAdapter(this.f72121d);
        this.f72125h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        return inflate;
    }
}
