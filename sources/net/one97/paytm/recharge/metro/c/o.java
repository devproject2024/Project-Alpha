package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;

public final class o extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f63421a;

    /* renamed from: b  reason: collision with root package name */
    private String f63422b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f63423c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f63424d;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f63421a = arguments.getStringArrayList("messageList");
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            this.f63422b = arguments2.getString("title");
            return;
        }
        throw new RuntimeException("Arguments required");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_metro_penalty_help, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.linear_layout_bullet_view);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById;
            View findViewById2 = inflate.findViewById(R.id.button_got_it);
            if (findViewById2 != null) {
                TextView textView = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.title);
                if (findViewById3 != null) {
                    this.f63423c = (TextView) findViewById3;
                    TextView textView2 = this.f63423c;
                    if (textView2 != null) {
                        textView2.setText(this.f63422b);
                    }
                    textView.setOnClickListener(this);
                    k.c(linearLayout, "llView");
                    ArrayList<String> arrayList = this.f63421a;
                    if (arrayList == null) {
                        k.a();
                    }
                    Iterator<String> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_metro_penalty_help_bullet_view, (ViewGroup) null, false);
                        k.a((Object) inflate2, "LayoutInflater.from(cont…bullet_view, null, false)");
                        View findViewById4 = inflate2.findViewById(R.id.message);
                        if (findViewById4 != null) {
                            ((TextView) findViewById4).setText(next);
                            linearLayout.addView(inflate2);
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    }
                    return inflate;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public final void onClick(View view) {
        FragmentActivity activity;
        k.c(view, "v");
        if (view.getId() == R.id.button_got_it && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63424d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
