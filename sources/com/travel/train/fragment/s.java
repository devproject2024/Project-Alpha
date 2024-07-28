package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.travel.train.R;
import com.travel.train.i.u;
import com.travel.train.j.g;
import com.travel.train.model.trainticket.CJRTrainMessagingConfig;
import java.util.HashMap;
import kotlin.g.b.k;

public final class s extends am {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27151a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ImageView f27152b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27153c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27154d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27155e;

    /* renamed from: f  reason: collision with root package name */
    private Button f27156f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f27157g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f27158h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public u f27159i;
    private boolean j;
    private HashMap k;

    private View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final s a(Bundle bundle) {
        return a.a(bundle);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static s a(Bundle bundle) {
            k.c(bundle, "args");
            s sVar = new s();
            sVar.setArguments(bundle);
            return sVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("from_home_page")) {
            this.j = arguments.getBoolean("from_home_page");
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (getParentFragment() != null && (getParentFragment() instanceof u)) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f27159i = (u) parentFragment;
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.travel.train.trainlistener.IJRTrainSRPListener");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_no_result_found_train_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f27152b = (ImageView) view.findViewById(R.id.no_train_image);
        this.f27153c = (TextView) view.findViewById(R.id.no_result_label);
        this.f27154d = (TextView) view.findViewById(R.id.no_trains_text);
        this.f27155e = (TextView) view.findViewById(R.id.no_trains_text1);
        this.f27156f = (Button) view.findViewById(R.id.modify_search_btn);
        this.f27157g = (LinearLayout) view.findViewById(R.id.alternate_dates_container);
        this.f27158h = (LinearLayout) view.findViewById(R.id.nearby_station_container);
        Button button = this.f27156f;
        if (button != null) {
            button.setOnClickListener(new b(this));
        }
        Button button2 = this.f27156f;
        if (button2 != null) {
            button2.setText(getString(R.string.train_clear_filter));
        }
        String string = getString(R.string.trains_filteria_mesg);
        k.a((Object) string, "getString(R.string.trains_filteria_mesg)");
        if (g.f27551a != null) {
            CJRTrainMessagingConfig cJRTrainMessagingConfig = g.f27551a;
            k.a((Object) cJRTrainMessagingConfig, "CJRTrainConstants.trainMessages");
            if (cJRTrainMessagingConfig.getZeroTrainsFilter() != null) {
                CJRTrainMessagingConfig cJRTrainMessagingConfig2 = g.f27551a;
                k.a((Object) cJRTrainMessagingConfig2, "CJRTrainConstants.trainMessages");
                string = cJRTrainMessagingConfig2.getZeroTrainsFilter();
                k.a((Object) string, "CJRTrainConstants.trainMessages.zeroTrainsFilter");
            }
        }
        if (!this.j) {
            ImageView imageView = (ImageView) a(R.id.no_train_image);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            String string2 = getString(R.string.no_route_found_header);
            k.a((Object) string2, "getString(R.string.no_route_found_header)");
            a(string2, string, true);
            return;
        }
        ImageView imageView2 = (ImageView) a(R.id.no_train_image);
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f27160a;

        b(s sVar) {
            this.f27160a = sVar;
        }

        public final void onClick(View view) {
            u a2 = this.f27160a.f27159i;
            if (a2 != null) {
                a2.h();
            }
        }
    }

    public final void a(String str, String str2, boolean z) {
        k.c(str, "title");
        k.c(str2, "msg");
        TextView textView = this.f27155e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f27154d;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        LinearLayout linearLayout = this.f27157g;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (z) {
            Button button = this.f27156f;
            if (button != null) {
                button.setVisibility(0);
            }
        } else {
            Button button2 = this.f27156f;
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
        TextView textView3 = this.f27153c;
        if (textView3 != null) {
            textView3.setText(str);
        }
        TextView textView4 = this.f27154d;
        if (textView4 != null) {
            textView4.setText(str2);
        }
        ImageView imageView = (ImageView) a(R.id.no_train_image);
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_group_81));
        }
        ImageView imageView2 = (ImageView) a(R.id.no_train_image);
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
