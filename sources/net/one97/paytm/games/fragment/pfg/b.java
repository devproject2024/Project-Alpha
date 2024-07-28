package net.one97.paytm.games.fragment.pfg;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.f;

public final class b extends net.one97.paytm.games.fragment.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f35700c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public int f35701a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f35702b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f35703d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f35704e;

    public final View a(int i2) {
        if (this.f35704e == null) {
            this.f35704e = new HashMap();
        }
        View view = (View) this.f35704e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f35704e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f35704e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.message_dialog, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        String str3;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        k.a((Object) requireContext, "requireContext()");
        ((TextView) a(R.id.btn_ok)).setOnClickListener(new C0601b(this, requireContext));
        int i2 = this.f35701a;
        String str4 = "";
        if (i2 == 2001) {
            try {
                str3 = com.paytm.utility.a.b(requireContext);
                k.a((Object) str3, "ApplaunchUtility.getMobile(requireContext)");
            } catch (Throwable unused) {
                str3 = str4;
            }
            if (!f.a((Object) str3)) {
                str4 = " ".concat(String.valueOf(str3));
            }
            str2 = "Please check your SMS Inbox.";
            str = "An SMS with the details has been sent to your mobile number";
        } else {
            if (i2 == 3026) {
                str = "Please try again tomorrow";
            } else {
                TextView textView = (TextView) a(R.id.btn_ok);
                k.a((Object) textView, "btn_ok");
                textView.setText("Retry");
                ImageView imageView = (ImageView) a(R.id.iv_message);
                k.a((Object) imageView, "iv_message");
                imageView.setVisibility(8);
                this.f35703d = true;
                str = "Something went wrong. Please try again";
            }
            str2 = str4;
        }
        SpannableString spannableString = new SpannableString(str + str4 + ". " + str2);
        int length = str.length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00B9F2")), length, str4.length() + length, 33);
        TextView textView2 = (TextView) a(R.id.tv_message);
        k.a((Object) textView2, "tv_message");
        textView2.setText(spannableString);
    }

    /* renamed from: net.one97.paytm.games.fragment.pfg.b$b  reason: collision with other inner class name */
    static final class C0601b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f35705a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f35706b;

        C0601b(b bVar, Context context) {
            this.f35705a = bVar;
            this.f35706b = context;
        }

        public final void onClick(View view) {
            if (this.f35705a.f35703d) {
                if (!f.a(this.f35706b)) {
                    Context context = this.f35706b;
                    Toast.makeText(context, context.getString(R.string.com_gamepind_no_internet_available), 0).show();
                    return;
                }
                Runnable runnable = this.f35705a.f35702b;
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.f35705a.dismissAllowingStateLoss();
        }
    }

    public final void onResume() {
        Window window;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setGravity(17);
            k.a((Object) window, "this");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        super.onResume();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
