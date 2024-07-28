package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.R;

public final class az extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56394a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f56395c;

    /* renamed from: b  reason: collision with root package name */
    private b f56396b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56397d;

    public interface b {
        void onOptionSelected(boolean z);
    }

    private View a(int i2) {
        if (this.f56397d == null) {
            this.f56397d = new HashMap();
        }
        View view = (View) this.f56397d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56397d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static az a(boolean z) {
            az.f56395c = z;
            return new az();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.DialogFragmentStyle);
    }

    public final void a(b bVar) {
        k.c(bVar, "listener");
        this.f56396b = bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return layoutInflater.inflate(R.layout.fragment_dialog_otp_chooser, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtOnSms);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.txtOnCall);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        b bVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.txtOnSms;
        if (valueOf != null && valueOf.intValue() == i2) {
            b bVar2 = this.f56396b;
            if (bVar2 != null) {
                bVar2.onOptionSelected(false);
                return;
            }
            return;
        }
        int i3 = R.id.txtOnCall;
        if (valueOf != null && valueOf.intValue() == i3 && (bVar = this.f56396b) != null) {
            bVar.onOptionSelected(true);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56397d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
