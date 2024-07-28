package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJRHelpVideoList;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class ab extends h implements ai {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f60435a;

    /* renamed from: b  reason: collision with root package name */
    public String f60436b;

    /* renamed from: c  reason: collision with root package name */
    public ac f60437c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f60438d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRHelpVideoList f60439e;

    /* renamed from: f  reason: collision with root package name */
    private am f60440f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f60441g;

    /* renamed from: h  reason: collision with root package name */
    private String f60442h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f60443i;
    /* access modifiers changed from: private */
    public LinearLayout j;
    private Button k;
    private ProgressBar l;
    private boolean m;
    private boolean n;
    private a o;
    private String p;

    public interface a {
        void b(Boolean bool);
    }

    public static ab a(String str, Boolean bool, a aVar, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("help_section_key", str);
        bundle.putString("category_id", str2);
        bundle.putString("category_selected", str2);
        ab abVar = new ab();
        abVar.n = bool.booleanValue();
        abVar.o = aVar;
        abVar.setArguments(bundle);
        return abVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f60442h = getArguments().getString("help_section_key", "");
            this.p = getArguments().getString("category_id", "");
            this.f60436b = getArguments().getString("category_selected", "");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.recharge_help_fragment, (ViewGroup) null, false);
        this.f60438d = (RecyclerView) inflate.findViewById(R.id.list_help_videos);
        this.f60435a = (LinearLayout) inflate.findViewById(R.id.content_layout);
        this.j = (LinearLayout) inflate.findViewById(R.id.show_more_layout);
        this.f60441g = (LinearLayout) inflate.findViewById(R.id.no_video_layout);
        this.k = (Button) inflate.findViewById(R.id.show_more_btn);
        this.l = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        if (this.m && !this.f60443i && !this.n) {
            d dVar = d.f64967a;
            a("load_help_service_video_list", d.a(ACTION_TYPE.HELP, ERROR_TYPE.UNDEFINED));
        }
        return inflate;
    }

    private void a(String str, Object obj) {
        c cVar = c.f62654a;
        String aw = c.aw();
        if (aw != null) {
            String str2 = aw + com.paytm.utility.c.a(getContext(), false);
            if (!TextUtils.isEmpty(this.f60442h)) {
                this.f60442h = this.f60442h.trim();
                String str3 = this.f60442h.split(" ")[0];
                if (!TextUtils.isEmpty(str3)) {
                    if (str2.contains("?")) {
                        str2 = str2 + "&key=" + str3;
                    } else {
                        str2 = str2 + "?key=" + str3;
                    }
                }
                String str4 = str2;
                if (!this.m) {
                    this.l.setVisibility(0);
                }
                HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), getContext());
                getContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, str4, this, new CJRHelpVideoList(), a2, obj));
                a aVar = this.o;
                if (aVar != null) {
                    aVar.b(Boolean.TRUE);
                }
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        List list;
        this.l.setVisibility(8);
        if (iJRPaytmDataModel instanceof CJRHelpVideoList) {
            this.f60443i = true;
            this.f60439e = (CJRHelpVideoList) iJRPaytmDataModel;
            if (!isAdded() || isDetached() || this.f60439e.getVideos() == null || this.f60439e.getVideos().size() <= 0) {
                this.f60435a.setVisibility(8);
                this.f60441g.setVisibility(0);
                return;
            }
            if (this.f60439e.getVideos().size() > 3) {
                list = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
                    list.add(this.f60439e.getVideos().get(i2));
                }
                this.j.setVisibility(0);
                this.k.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ab.this.j.setVisibility(8);
                        if (ab.this.f60438d.getAdapter() instanceof ac) {
                            ab.this.f60439e.getVideos();
                            ac acVar = (ac) ab.this.f60438d.getAdapter();
                            acVar.f60448d = ab.this.f60439e.getVideos();
                            acVar.a();
                            acVar.notifyDataSetChanged();
                        }
                    }
                });
            } else {
                list = this.f60439e.getVideos();
            }
            this.f60437c = new ac(this.f60438d, getContext(), list, getChildFragmentManager(), this.f60440f, this.p, this.f60436b);
            this.f60438d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.f60438d.setAdapter(this.f60437c);
            this.f60435a.setVisibility(0);
            this.f60441g.setVisibility(8);
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        a aVar = this.o;
        if (aVar != null) {
            aVar.b(Boolean.FALSE);
        }
        this.l.setVisibility(8);
        this.f60441g.setVisibility(0);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.f60438d == null) {
            this.m = true;
        } else if (z && !this.f60443i) {
            d dVar = d.f64967a;
            a("load_help_service_video_list", d.a(ACTION_TYPE.HELP, ERROR_TYPE.UNDEFINED));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof am) {
            this.f60440f = (am) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f60440f = null;
    }
}
