package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.g;
import net.one97.travelpass.R;

public final class l extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30752b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f30753f = f30753f;

    /* renamed from: a  reason: collision with root package name */
    String f30754a;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f30755c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30756d;

    /* renamed from: e  reason: collision with root package name */
    private Button f30757e;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f30758g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        CharSequence string = arguments != null ? arguments.getString(f30753f) : null;
        if (!(string == null || string.length() == 0)) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString(f30753f);
            }
            if (str == null) {
                k.a();
            }
        } else {
            str = "";
        }
        this.f30754a = str;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.promo_copy_view, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.cancel_img);
        if (findViewById != null) {
            this.f30755c = (ImageView) findViewById;
            this.f30756d = (TextView) view.findViewById(R.id.promo_text);
            this.f30757e = (Button) view.findViewById(R.id.copy_button);
            ResourceUtils.loadTPassImagesFromCDN$default(this.f30755c, "close_circle_filled.png", false, true, (n.a) null, 16, (Object) null);
            ImageView imageView = this.f30755c;
            if (imageView != null) {
                imageView.setOnClickListener(new b(this));
            }
            TextView textView = this.f30756d;
            if (textView != null) {
                textView.setText(this.f30754a);
            }
            Button button = this.f30757e;
            if (button != null) {
                button.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f30759a;

        b(l lVar) {
            this.f30759a = lVar;
        }

        public final void onClick(View view) {
            this.f30759a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f30760a;

        c(l lVar) {
            this.f30760a = lVar;
        }

        public final void onClick(View view) {
            l lVar = this.f30760a;
            Context context = lVar.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager != null) {
                clipboardManager.setText(lVar.f30754a);
            }
            Toast.makeText(lVar.getContext(), "Promocode " + lVar.f30754a + " Copied", 0).show();
            this.f30760a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f30758g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
