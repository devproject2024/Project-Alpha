package net.one97.paytm.upgradeKyc.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.R;

public final class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f65663a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65664b;

    private View a(int i2) {
        if (this.f65664b == null) {
            this.f65664b = new HashMap();
        }
        View view = (View) this.f65664b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65664b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.try_again_btn) {
            dismiss();
        } else if (view != null && view.getId() == R.id.cross_iv) {
            dismiss();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f65663a = arguments.getInt("noOfAttempts", 0);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.gaurdian_not_kyc_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f65663a != 0) {
            TextView textView = (TextView) a(R.id.attempt_tv);
            k.a((Object) textView, "attempt_tv");
            textView.setText(getString(R.string.x_attempts_remaining, Integer.valueOf(this.f65663a)));
        } else {
            TextView textView2 = (TextView) a(R.id.please_enter_tv);
            k.a((Object) textView2, "please_enter_tv");
            textView2.setText(getString(R.string.exhausted_attempts_for_today));
            TextView textView3 = (TextView) a(R.id.unfortunately_tv);
            k.a((Object) textView3, "unfortunately_tv");
            textView3.setText(getString(R.string.try_again_with_full_kyc));
            Button button = (Button) a(R.id.try_again_btn);
            k.a((Object) button, "try_again_btn");
            button.setVisibility(8);
            ImageView imageView = (ImageView) a(R.id.cross_iv);
            k.a((Object) imageView, "cross_iv");
            imageView.setVisibility(8);
            TextView textView4 = (TextView) a(R.id.attempt_tv);
            k.a((Object) textView4, "attempt_tv");
            textView4.setText(getString(R.string.come_back_later_kyc));
            ((TextView) a(R.id.attempt_tv)).setTextColor(getResources().getColor(R.color.color_00b9f5));
            ((TextView) a(R.id.attempt_tv)).setOnClickListener(new a(this));
        }
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.try_again_btn)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.cross_iv)).setOnClickListener(onClickListener);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65665a;

        a(b bVar) {
            this.f65665a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            if (this.f65665a.getActivity() != null && (activity = this.f65665a.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65664b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
