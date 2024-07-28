package com.travel.train.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.j.n;
import com.travel.train.k.g;
import com.travel.train.model.searchResult.Body;
import com.travel.train.model.searchResult.CJRSearchByTrainDetails;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.searchResult.FareData;
import com.travel.train.model.searchResult.SearchResultMetaData;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class q extends am {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27125a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f27126b;

    /* renamed from: c  reason: collision with root package name */
    private CJRSearchByTrainNumberModel f27127c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Object> f27128d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.travel.train.k.b f27129e;

    /* renamed from: f  reason: collision with root package name */
    private String f27130f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f27131g;

    private View a(int i2) {
        if (this.f27131g == null) {
            this.f27131g = new HashMap();
        }
        View view = (View) this.f27131g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f27131g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static q a(Bundle bundle) {
            q qVar = new q();
            qVar.setArguments(bundle);
            return qVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_f_j_r_train_calendar_list, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LinearLayout linearLayout;
        View childAt;
        Body body;
        CJRSearchByTrainDetails trainDetails;
        Body body2;
        CJRSearchByTrainDetails trainDetails2;
        List<FareData> fareRange;
        SearchResultMetaData meta;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Integer num = null;
        this.f27127c = (CJRSearchByTrainNumberModel) (arguments != null ? arguments.get("search_by_train_result") : null);
        CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel = this.f27127c;
        this.f27128d = (cJRSearchByTrainNumberModel == null || (meta = cJRSearchByTrainNumberModel.getMeta()) == null) ? null : meta.getClassesMeta();
        Bundle arguments2 = getArguments();
        this.f27130f = (String) (arguments2 != null ? arguments2.get("mClassTypeSelect") : null);
        View a2 = a(R.id.class_type_layout);
        LinearLayout linearLayout2 = a2 != null ? (LinearLayout) a2.findViewById(R.id.inner_layout) : null;
        if (linearLayout2 != null) {
            this.f27126b = linearLayout2;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                g.a aVar = new g.a(g.b.SEARCHBYTRAIN);
                a.C0484a aVar2 = com.travel.train.a.a.f25797a;
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                this.f27129e = (com.travel.train.k.b) am.a(activity, (al.b) new g(aVar.a(aVar2.a(new com.travel.train.a.a.a(activity2))))).a(com.travel.train.k.b.class);
            }
            LinearLayout linearLayout3 = this.f27126b;
            if (linearLayout3 != null) {
                linearLayout3.removeAllViews();
            }
            CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel2 = this.f27127c;
            if (cJRSearchByTrainNumberModel2 != null) {
                Integer valueOf = (cJRSearchByTrainNumberModel2 == null || (body2 = cJRSearchByTrainNumberModel2.getBody()) == null || (trainDetails2 = body2.getTrainDetails()) == null || (fareRange = trainDetails2.getFareRange()) == null) ? null : Integer.valueOf(fareRange.size());
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 0) {
                    CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel3 = this.f27127c;
                    List<FareData> fareRange2 = (cJRSearchByTrainNumberModel3 == null || (body = cJRSearchByTrainNumberModel3.getBody()) == null || (trainDetails = body.getTrainDetails()) == null) ? null : trainDetails.getFareRange();
                    if (fareRange2 == null) {
                        k.a();
                    }
                    for (FareData fareData : fareRange2) {
                        LinearLayout linearLayout4 = this.f27126b;
                        if (linearLayout4 != null) {
                            k.c(fareData, "value");
                            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pre_t_train_class_type_list_item, (ViewGroup) null);
                            inflate.findViewById(R.id.lyt_class_parent);
                            TextView textView = (TextView) inflate.findViewById(R.id.class_type_text);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.seat_status_text);
                            TextView textView3 = (TextView) inflate.findViewById(R.id.price_text);
                            TextView textView4 = (TextView) inflate.findViewById(R.id.updated_status_text);
                            TextView textView5 = (TextView) inflate.findViewById(R.id.tip_text);
                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.prediction_progressBar);
                            inflate.findViewById(R.id.prediction_progressBar_txt);
                            if (textView5 != null) {
                                textView5.setVisibility(8);
                            }
                            if (textView2 != null) {
                                textView2.setVisibility(8);
                            }
                            if (progressBar != null) {
                                progressBar.setVisibility(8);
                            }
                            if (textView4 != null) {
                                textView4.setVisibility(8);
                            }
                            if (textView != null) {
                                textView.setVisibility(0);
                            }
                            if (textView3 != null) {
                                textView3.setVisibility(0);
                            }
                            String className = fareData.getClassName();
                            if (className == null) {
                                k.a();
                            }
                            if (!className.equals("allClasses")) {
                                if (textView != null) {
                                    textView.setText(n.a(fareData.getClassName(), this.f27128d) + " (" + fareData.getClassName() + ")");
                                }
                            } else if (textView != null) {
                                textView.setText("All Classes");
                            }
                            if (textView3 != null) {
                                textView3.setText(fareData.getPrice());
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.weight = 1.0f;
                            layoutParams.leftMargin = com.paytm.utility.b.a(6.0f, (Context) getActivity());
                            layoutParams.rightMargin = com.paytm.utility.b.a(6.0f, (Context) getActivity());
                            k.a((Object) inflate, "itemView");
                            inflate.setLayoutParams(layoutParams);
                            inflate.setOnClickListener(new b(this, fareData, inflate));
                            linearLayout4.addView(inflate);
                        }
                    }
                }
            }
            LinearLayout linearLayout5 = this.f27126b;
            if (linearLayout5 != null) {
                num = Integer.valueOf(linearLayout5.getChildCount());
            }
            if (num == null) {
                k.a();
            }
            if (!(num.intValue() <= 0 || (linearLayout = this.f27126b) == null || (childAt = linearLayout.getChildAt(0)) == null)) {
                childAt.performClick();
            }
            Switch switchR = (Switch) a(R.id.available_only_switch);
            if (switchR != null) {
                switchR.setOnCheckedChangeListener(new c(this));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    static final class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f27135a;

        c(q qVar) {
            this.f27135a = qVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                com.travel.train.k.b a2 = this.f27135a.f27129e;
                if (a2 != null) {
                    a2.a(true);
                    return;
                }
                return;
            }
            com.travel.train.k.b a3 = this.f27135a.f27129e;
            if (a3 != null) {
                a3.a(false);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f27132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FareData f27133b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f27134c;

        b(q qVar, FareData fareData, View view) {
            this.f27132a = qVar;
            this.f27133b = fareData;
            this.f27134c = view;
        }

        public final void onClick(View view) {
            String className = this.f27133b.getClassName();
            if (className == null) {
                k.a();
            }
            if (className.equals("allClasses")) {
                com.travel.train.k.b a2 = this.f27132a.f27129e;
                if (a2 != null) {
                    a2.a((String) null);
                }
            } else {
                com.travel.train.k.b a3 = this.f27132a.f27129e;
                if (a3 != null) {
                    a3.a(this.f27133b.getClassName());
                }
            }
            q qVar = this.f27132a;
            View view2 = this.f27134c;
            k.a((Object) view2, "itemView");
            q.a(qVar, view2);
        }
    }

    public static final /* synthetic */ void a(q qVar, View view) {
        Resources resources;
        Resources resources2;
        LinearLayout linearLayout = qVar.f27126b;
        Drawable drawable = null;
        Integer valueOf = linearLayout != null ? Integer.valueOf(linearLayout.getChildCount()) : null;
        if (valueOf == null) {
            k.a();
        }
        int intValue = valueOf.intValue() - 1;
        if (intValue >= 0) {
            int i2 = 0;
            while (true) {
                LinearLayout linearLayout2 = qVar.f27126b;
                View childAt = linearLayout2 != null ? linearLayout2.getChildAt(i2) : null;
                if (childAt != null) {
                    LinearLayout linearLayout3 = (LinearLayout) childAt.findViewById(R.id.lyt_class_sub_inner);
                    if (linearLayout3 == null) {
                        k.a();
                    }
                    FragmentActivity activity = qVar.getActivity();
                    linearLayout3.setBackground((activity == null || (resources2 = activity.getResources()) == null) ? null : resources2.getDrawable(R.drawable.pre_t_train_class_type_selector));
                    if (i2 == intValue) {
                        break;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
            }
        }
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.lyt_class_sub_inner);
        if (linearLayout4 != null) {
            FragmentActivity activity2 = qVar.getActivity();
            if (!(activity2 == null || (resources = activity2.getResources()) == null)) {
                drawable = resources.getDrawable(R.drawable.pre_t_train_rectangle_blue_stroke);
            }
            linearLayout4.setBackground(drawable);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f27131g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
