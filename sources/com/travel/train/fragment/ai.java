package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.b.ar;
import com.travel.train.helper.c;
import com.travel.train.j.g;
import com.travel.train.model.trainticket.CJRTrainMessagingConfig;
import com.travel.train.model.trainticket.i;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;

public final class ai extends f implements ar.a {

    /* renamed from: a  reason: collision with root package name */
    private ar f26868a;

    /* renamed from: b  reason: collision with root package name */
    private int f26869b;

    /* renamed from: c  reason: collision with root package name */
    private c f26870c;

    /* renamed from: d  reason: collision with root package name */
    private i f26871d;

    /* renamed from: e  reason: collision with root package name */
    private ar.a f26872e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f26873f;

    private View a(int i2) {
        if (this.f26873f == null) {
            this.f26873f = new HashMap();
        }
        View view = (View) this.f26873f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f26873f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public ai(ar.a aVar) {
        k.c(aVar, "mClickListener");
        this.f26872e = aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = 0;
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i2 = arguments.getInt("click_position");
        }
        this.f26869b = i2;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.b(context);
    }

    public final void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_sort_by_bottom_sheet, viewGroup, false);
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (g.f27551a != null) {
            CJRTrainMessagingConfig cJRTrainMessagingConfig = g.f27551a;
            k.a((Object) cJRTrainMessagingConfig, "CJRTrainConstants.trainMessages");
            if (cJRTrainMessagingConfig.getSortTitle() != null) {
                CJRTrainMessagingConfig cJRTrainMessagingConfig2 = g.f27551a;
                k.a((Object) cJRTrainMessagingConfig2, "CJRTrainConstants.trainMessages");
                String sortTitle = cJRTrainMessagingConfig2.getSortTitle();
                k.a((Object) sortTitle, "CJRTrainConstants.trainM…               .sortTitle");
                CharSequence charSequence = sortTitle;
                int length = charSequence.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!TextUtils.isEmpty(charSequence.subSequence(i2, length + 1).toString())) {
                    RoboTextView roboTextView = (RoboTextView) a(R.id.sort_trains_title);
                    k.a((Object) roboTextView, "sort_trains_title");
                    CJRTrainMessagingConfig cJRTrainMessagingConfig3 = g.f27551a;
                    k.a((Object) cJRTrainMessagingConfig3, "CJRTrainConstants.trainMessages");
                    roboTextView.setText(cJRTrainMessagingConfig3.getSortTitle());
                }
            }
        }
        this.f26870c = new c(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView = (RecyclerView) a(R.id.sort_by_list);
        k.a((Object) recyclerView, "sort_by_list");
        recyclerView.setLayoutManager(linearLayoutManager);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        this.f26868a = new ar(context, this.f26869b, this);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.sort_by_list);
        k.a((Object) recyclerView2, "sort_by_list");
        recyclerView2.setAdapter(this.f26868a);
    }

    public final void a(int i2, i iVar) {
        this.f26869b = i2;
        c cVar = this.f26870c;
        if (cVar != null) {
            if (cVar == null) {
                k.a();
            }
            this.f26871d = cVar.e().get(i2);
            this.f26872e.a(i2, this.f26871d);
        }
        dismiss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f26873f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
