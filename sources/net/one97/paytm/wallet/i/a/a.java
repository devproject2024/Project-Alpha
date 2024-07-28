package net.one97.paytm.wallet.i.a;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f70383a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f70384b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f70385c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.enable_scp_info_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        this.f70383a = inflate;
        View view = this.f70383a;
        if (view == null) {
            k.a("rootView");
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.animation_view);
        k.a((Object) lottieAnimationView, "rootView.animation_view");
        this.f70384b = lottieAnimationView;
        View view2 = this.f70383a;
        if (view2 == null) {
            k.a("rootView");
        }
        return view2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = this.f70383a;
        if (view2 == null) {
            k.a("rootView");
        }
        TextView textView = (TextView) view2.findViewById(R.id.bottomsheet_info_tc);
        if (textView != null) {
            textView.setOnClickListener(new C1420a(this));
        }
        LottieAnimationView lottieAnimationView = this.f70384b;
        if (lottieAnimationView == null) {
            k.a("lottieView");
        }
        lottieAnimationView.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = this.f70384b;
        if (lottieAnimationView2 == null) {
            k.a("lottieView");
        }
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        lottieAnimationView2.setAnimation(a2.getScpAnimation());
        LottieAnimationView lottieAnimationView3 = this.f70384b;
        if (lottieAnimationView3 == null) {
            k.a("lottieView");
        }
        lottieAnimationView3.setRepeatCount(-1);
        LottieAnimationView lottieAnimationView4 = this.f70384b;
        if (lottieAnimationView4 == null) {
            k.a("lottieView");
        }
        lottieAnimationView4.playAnimation();
        View view3 = this.f70383a;
        if (view3 == null) {
            k.a("rootView");
        }
        TextView textView2 = (TextView) view3.findViewById(R.id.bottomsheet_info_description);
        if (textView2 != null) {
            textView2.setText(b.a().getStringFromGTM(getContext(), SDKConstants.KEY_ENABLE_SCP_INFO_DESCRIPTION));
        }
        View view4 = this.f70383a;
        if (view4 == null) {
            k.a("rootView");
        }
        TextView textView3 = (TextView) view4.findViewById(R.id.bottomsheet_info_header);
        if (textView3 != null) {
            textView3.setText(b.a().getStringFromGTM(getContext(), SDKConstants.KEY_SCP_PAYMENT_TITLE));
        }
        String string = getString(R.string.important_with_colon);
        k.a((Object) string, "getString(R.string.important_with_colon)");
        CharSequence charSequence = string + ' ' + b.a().getStringFromGTM(getContext(), SDKConstants.KEY_ENABLE_SCP_INFO_NOTE);
        int a3 = p.a(charSequence, string, 0, false, 6);
        int length = string.length();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_ffad00)), a3, length, 33);
        View view5 = this.f70383a;
        if (view5 == null) {
            k.a("rootView");
        }
        TextView textView4 = (TextView) view5.findViewById(R.id.tv_important);
        if (textView4 != null) {
            textView4.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    /* renamed from: net.one97.paytm.wallet.i.a.a$a  reason: collision with other inner class name */
    static final class C1420a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70386a;

        C1420a(a aVar) {
            this.f70386a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f70386a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r2 = r2.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.wallet.i.a.a r2) {
        /*
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 != 0) goto L_0x001f
            android.content.Context r0 = r2.getContext()
            int r1 = net.one97.paytm.wallet.R.string.no_connection
            java.lang.String r2 = r2.getString(r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1 = 1
            android.widget.Toast r2 = android.widget.Toast.makeText(r0, r2, r1)
            r2.show()
            return
        L_0x001f:
            net.one97.paytm.wallet.i.a.b r0 = new net.one97.paytm.wallet.i.a.b
            r0.<init>()
            boolean r1 = r2.isRemoving()
            if (r1 != 0) goto L_0x004f
            android.content.Context r1 = r2.getContext()
            if (r1 == 0) goto L_0x004f
            androidx.fragment.app.FragmentActivity r2 = r2.getActivity()     // Catch:{ Exception -> 0x004f }
            r1 = 0
            if (r2 == 0) goto L_0x0042
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x0042
            androidx.fragment.app.q r2 = r2.a()     // Catch:{ Exception -> 0x004f }
            goto L_0x0043
        L_0x0042:
            r2 = r1
        L_0x0043:
            if (r2 == 0) goto L_0x004a
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ Exception -> 0x004f }
            r2.a((androidx.fragment.app.Fragment) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x004f }
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.c()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.i.a.a.a(net.one97.paytm.wallet.i.a.a):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f70385c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
