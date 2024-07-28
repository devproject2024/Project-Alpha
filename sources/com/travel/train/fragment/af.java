package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.travel.train.R;
import com.travel.train.i.n;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;

public final class af extends f implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26830a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private com.travel.train.b.af f26831b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends CJRTrainLSSearchResult.Schedule> f26832c;

    /* renamed from: d  reason: collision with root package name */
    private n f26833d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f26834e;

    private View a(int i2) {
        if (this.f26834e == null) {
            this.f26834e = new HashMap();
        }
        View view = (View) this.f26834e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f26834e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final af a(Bundle bundle) {
        return a.a(bundle);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static af a(Bundle bundle) {
            k.c(bundle, "args");
            af afVar = new af();
            afVar.setArguments(bundle);
            return afVar;
        }
    }

    public final void a(n nVar) {
        k.c(nVar, "clickListener");
        this.f26833d = nVar;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments != null && arguments.containsKey("intent_extra_train_selected")) {
                Serializable serializable = arguments.getSerializable("intent_extra_train_selected");
                if (serializable != null) {
                    CJRTrainLSSearchResult.Train train = (CJRTrainLSSearchResult.Train) serializable;
                    if (train != null) {
                        this.f26832c = train.getSchedule();
                        System.out.println("bp's " + this.f26832c);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train");
            }
            return;
        }
        throw new RuntimeException("Arguments required");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_activity_train_select_boarding_point, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) a(R.id.close_lyt);
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        List<? extends CJRTrainLSSearchResult.Schedule> list = this.f26832c;
        if (list != null) {
            if (list == null) {
                k.a();
            }
            if (list.size() > 0) {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                this.f26831b = new com.travel.train.b.af(context, this.f26832c, this);
                ListView listView = (ListView) a(R.id.boarding_points_list);
                if (listView != null) {
                    listView.setAdapter(this.f26831b);
                }
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ af f26835a;

        b(af afVar) {
            this.f26835a = afVar;
        }

        public final void onClick(View view) {
            this.f26835a.dismiss();
        }
    }

    public final void a(CJRTrainLSSearchResult.Schedule schedule) {
        k.c(schedule, "schedule");
        dismiss();
        n nVar = this.f26833d;
        if (nVar != null) {
            nVar.a(schedule);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f26834e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
