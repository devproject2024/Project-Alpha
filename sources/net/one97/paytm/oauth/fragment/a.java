package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.R;

public final class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final C1049a f56273b = new C1049a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    b f56274a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56275c;

    public interface b {
        void aa_();
    }

    private View a(int i2) {
        if (this.f56275c == null) {
            this.f56275c = new HashMap();
        }
        View view = (View) this.f56275c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56275c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.oauth.fragment.a$a  reason: collision with other inner class name */
    public static final class C1049a {
        private C1049a() {
        }

        public /* synthetic */ C1049a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.PermissionDialogFragmentStyle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_fragment_account_block_confirmation, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_yes);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_no);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_yes;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismissAllowingStateLoss();
            b bVar = this.f56274a;
            if (bVar == null) {
                k.a("accountBlockListener");
            }
            bVar.aa_();
            return;
        }
        int i3 = R.id.tv_no;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56275c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
