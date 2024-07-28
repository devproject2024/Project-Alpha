package net.one97.paytm.paymentsBank.cifCreation.view.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.cifCreation.a.a;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.cifCreation.view.activity.PostCIFCreatedActivity;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.c;
import net.one97.paytm.paymentsBank.utils.j;

public final class a extends f implements a.b {

    /* renamed from: a  reason: collision with root package name */
    int f18002a;

    /* renamed from: b  reason: collision with root package name */
    int f18003b = 1;

    /* renamed from: c  reason: collision with root package name */
    public a.C0295a f18004c;

    /* renamed from: d  reason: collision with root package name */
    private int f18005d;

    /* renamed from: e  reason: collision with root package name */
    private long f18006e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f18007f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f18008g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f18009h;

    /* renamed from: i  reason: collision with root package name */
    private View f18010i;
    private View j;
    private ProgressBar k;
    private TextView l;
    private TextView m;
    private final C0296a n = new C0296a(this);
    private ImageView o;
    private HashMap p;

    public final void a(double d2) {
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        k.c(arrayList, "mTncDataList");
    }

    public final void a(CIFCreationResponse cIFCreationResponse) {
        k.c(cIFCreationResponse, "cifCreationResponse");
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        k.c(slfdMetaApiResponseModel, "slfdMetaApiResponse");
    }

    public final void a(boolean z) {
    }

    public final void b(boolean z) {
    }

    /* renamed from: net.one97.paytm.paymentsBank.cifCreation.view.a.a$a  reason: collision with other inner class name */
    public static final class C0296a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18011a;

        C0296a(a aVar) {
            this.f18011a = aVar;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message == null) {
                k.a();
            }
            int i2 = message.what;
            if (i2 == this.f18011a.f18002a) {
                if (this.f18011a.a() != null) {
                    this.f18011a.a().d();
                }
            } else if (i2 == this.f18011a.f18003b) {
                try {
                    this.f18011a.dismiss();
                    this.f18011a.startActivity(new Intent(this.f18011a.getActivity(), PostCIFCreatedActivity.class));
                    FragmentActivity activity = this.f18011a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a(CIFStatusResponse cIFStatusResponse) {
        k.c(cIFStatusResponse, "cifBottomSheetResponse");
        if (isAdded()) {
            if (this.f18005d < 3 && (p.a(cIFStatusResponse.getStatus(), "IN_PROGRESS", false) || p.a(cIFStatusResponse.getStatus(), "PENDING", false))) {
                this.n.sendEmptyMessageDelayed(this.f18002a, this.f18006e);
                this.f18005d++;
                if (this.f18005d == 3) {
                    ProgressBar progressBar = this.f18007f;
                    if (progressBar == null) {
                        k.a("pbProgress");
                    }
                    net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
                    ImageView imageView = this.o;
                    if (imageView == null) {
                        k.a("crossBtn");
                    }
                    imageView.setVisibility(0);
                    LinearLayout linearLayout = this.f18008g;
                    if (linearLayout == null) {
                        k.a("lytErrorMessage");
                    }
                    linearLayout.setVisibility(0);
                    ImageView imageView2 = this.f18009h;
                    if (imageView2 == null) {
                        k.a("statusImageView");
                    }
                    imageView2.setVisibility(0);
                    ImageView imageView3 = this.f18009h;
                    if (imageView3 == null) {
                        k.a("statusImageView");
                    }
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    imageView3.setImageDrawable(androidx.core.content.b.a(context, R.drawable.pb_cif_orange));
                    View view = this.f18010i;
                    if (view == null) {
                        k.a("dividerView");
                    }
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = j.a(getContext(), 115.0f);
                    View view2 = this.f18010i;
                    if (view2 == null) {
                        k.a("dividerView");
                    }
                    view2.setLayoutParams(layoutParams);
                }
            } else if (p.a(cIFStatusResponse.getStatus(), "NOT_APPLIED", false)) {
                ProgressBar progressBar2 = this.f18007f;
                if (progressBar2 == null) {
                    k.a("pbProgress");
                }
                net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
                ImageView imageView4 = this.o;
                if (imageView4 == null) {
                    k.a("crossBtn");
                }
                imageView4.setVisibility(0);
                LinearLayout linearLayout2 = this.f18008g;
                if (linearLayout2 == null) {
                    k.a("lytErrorMessage");
                }
                linearLayout2.setVisibility(0);
                ImageView imageView5 = this.f18009h;
                if (imageView5 == null) {
                    k.a("statusImageView");
                }
                imageView5.setVisibility(0);
                ImageView imageView6 = this.f18009h;
                if (imageView6 == null) {
                    k.a("statusImageView");
                }
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                imageView6.setImageDrawable(androidx.core.content.b.a(context2, R.drawable.pb_cif_orange));
                View view3 = this.f18010i;
                if (view3 == null) {
                    k.a("dividerView");
                }
                ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                layoutParams2.height = j.a(getContext(), 115.0f);
                View view4 = this.f18010i;
                if (view4 == null) {
                    k.a("dividerView");
                }
                view4.setLayoutParams(layoutParams2);
            } else if (p.a(cIFStatusResponse.getStatus(), "ISSUED", false)) {
                LinearLayout linearLayout3 = this.f18008g;
                if (linearLayout3 == null) {
                    k.a("lytErrorMessage");
                }
                linearLayout3.setVisibility(8);
                ProgressBar progressBar3 = this.f18007f;
                if (progressBar3 == null) {
                    k.a("pbProgress");
                }
                net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar3);
                ImageView imageView7 = this.f18009h;
                if (imageView7 == null) {
                    k.a("statusImageView");
                }
                imageView7.setVisibility(0);
                ImageView imageView8 = this.f18009h;
                if (imageView8 == null) {
                    k.a("statusImageView");
                }
                imageView8.setImageResource(R.drawable.ic_active_green_tick);
                View view5 = this.f18010i;
                if (view5 == null) {
                    k.a("dividerView");
                }
                ViewGroup.LayoutParams layoutParams3 = view5.getLayoutParams();
                layoutParams3.height = j.a(getContext(), 46.0f);
                View view6 = this.f18010i;
                if (view6 == null) {
                    k.a("dividerView");
                }
                view6.setLayoutParams(layoutParams3);
                View view7 = this.j;
                if (view7 == null) {
                    k.a("lastImageView");
                }
                net.one97.paytm.paymentsBank.slfd.b.a.b.b(view7);
                ProgressBar progressBar4 = this.k;
                if (progressBar4 == null) {
                    k.a("lastProgress");
                }
                net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar4);
                TextView textView = this.m;
                if (textView == null) {
                    k.a("passBookView");
                }
                TextView textView2 = this.m;
                if (textView2 == null) {
                    k.a("passBookView");
                }
                textView.setTypeface(textView2.getTypeface(), 1);
                TextView textView3 = this.l;
                if (textView3 == null) {
                    k.a("registerView");
                }
                textView3.setTypeface(Typeface.SANS_SERIF);
                this.n.sendEmptyMessageDelayed(this.f18003b, 1000);
            }
        }
    }

    public final a.C0295a a() {
        a.C0295a aVar = this.f18004c;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        this.f18006e = 10000;
        c cVar = c.f18958a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        k.a((Object) applicationContext, "activity!!.applicationContext");
        a.C0295a aVar = new net.one97.paytm.paymentsBank.cifCreation.b.a(c.a(applicationContext), this);
        k.c(aVar, "<set-?>");
        this.f18004c = aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_cif_create_bottom_sheet, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.cross_btn);
        if (findViewById != null) {
            this.o = (ImageView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.pb_sec_progress);
            k.a((Object) findViewById2, "root.findViewById(R.id.pb_sec_progress)");
            this.f18007f = (ProgressBar) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.image_sec_pending);
            k.a((Object) findViewById3, "root.findViewById(R.id.image_sec_pending)");
            this.f18009h = (ImageView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.lyt_error_message);
            k.a((Object) findViewById4, "root.findViewById(R.id.lyt_error_message)");
            this.f18008g = (LinearLayout) findViewById4;
            View findViewById5 = inflate.findViewById(R.id.secondDividerView);
            k.a((Object) findViewById5, "root.findViewById(R.id.secondDividerView)");
            this.f18010i = findViewById5;
            View findViewById6 = inflate.findViewById(R.id.image_failed);
            k.a((Object) findViewById6, "root.findViewById(R.id.image_failed)");
            this.j = findViewById6;
            View findViewById7 = inflate.findViewById(R.id.pb_progress);
            k.a((Object) findViewById7, "root.findViewById(R.id.pb_progress)");
            this.k = (ProgressBar) findViewById7;
            View findViewById8 = inflate.findViewById(R.id.register_text);
            k.a((Object) findViewById8, "root.findViewById(R.id.register_text)");
            this.l = (TextView) findViewById8;
            View findViewById9 = inflate.findViewById(R.id.passbook_message);
            k.a((Object) findViewById9, "root.findViewById(R.id.passbook_message)");
            this.m = (TextView) findViewById9;
            ImageView imageView = this.o;
            if (imageView == null) {
                k.a("crossBtn");
            }
            imageView.setOnClickListener(new b(this));
            a().d();
            ProgressBar progressBar = this.f18007f;
            if (progressBar == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return inflate;
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18012a;

        b(a aVar) {
            this.f18012a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f18012a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.finish();
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
