package net.one97.paytm.locale.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.n;
import net.one97.paytm.i.f;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.locale.SlantingProgressbar;

public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public a f53081a;

    /* renamed from: b  reason: collision with root package name */
    private SlantingProgressbar f53082b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f53083c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f53084d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f53085e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f53086f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f53087g = "en";

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f53088h = new View.OnClickListener() {
        public final void onClick(View view) {
            if (b.this.f53081a != null) {
                b.this.f53081a.a(b.this.f53087g);
            }
            b.this.dismissAllowingStateLoss();
        }
    };

    public interface a {
        void a(String str);
    }

    /* renamed from: net.one97.paytm.locale.a.b$b  reason: collision with other inner class name */
    public interface C0946b {
        void doUpdateProgress(int i2, int i3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f53086f = new Handler(Looper.getMainLooper());
        View inflate = layoutInflater.inflate(R.layout.language_bottom_sheet, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.close_button);
        this.f53083c = (RoboTextView) inflate.findViewById(R.id.tv_please_wait);
        this.f53084d = (RoboTextView) inflate.findViewById(R.id.tv_download_language_status);
        this.f53085e = (RoboTextView) inflate.findViewById(R.id.tv_cancel_download);
        if (!(getArguments() == null || getArguments().getString("languageCode") == null)) {
            this.f53087g = n.a();
            String c2 = n.c(getContext(), getArguments().getString("languageCode"));
            this.f53084d.setText(getString(R.string.msg_please_wait_while_we_change_app_lang, c2));
            this.f53083c.setText(R.string.please_wait_loading);
            this.f53085e.setText(R.string.cancel_download);
        }
        imageView.setOnClickListener(this.f53088h);
        this.f53085e.setOnClickListener(this.f53088h);
        this.f53082b = (SlantingProgressbar) inflate.findViewById(R.id.progressbar_view);
        b();
        return inflate;
    }

    private void b() {
        SlantingProgressbar slantingProgressbar = this.f53082b;
        if (slantingProgressbar != null) {
            slantingProgressbar.setVisibility(0);
        }
    }

    public final void a() {
        SlantingProgressbar slantingProgressbar = this.f53082b;
        if (slantingProgressbar != null) {
            slantingProgressbar.setVisibility(8);
        }
    }

    public final void a(int i2) {
        SlantingProgressbar slantingProgressbar = this.f53082b;
        if (slantingProgressbar != null) {
            if (slantingProgressbar.getVisibility() != 0) {
                b();
            }
            this.f53086f.post(new Runnable(i2) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.this.b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2) {
        this.f53082b.setProgress(i2);
    }
}
