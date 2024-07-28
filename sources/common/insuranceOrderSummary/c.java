package common.insuranceOrderSummary;

import android.app.DownloadManager;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.insurance.R;

public abstract class c extends h implements b {

    /* renamed from: a  reason: collision with root package name */
    public d f13436a;

    /* renamed from: b  reason: collision with root package name */
    public String f13437b;

    /* renamed from: c  reason: collision with root package name */
    protected Boolean f13438c = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    private final int f13439d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private int f13440e = 30000;

    /* renamed from: f  reason: collision with root package name */
    private final long f13441f = 1000;

    /* renamed from: g  reason: collision with root package name */
    private Context f13442g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f13443h = Boolean.FALSE;

    /* renamed from: i  reason: collision with root package name */
    private String f13444i;
    private IJRPaytmDataModel j;
    private HashMap k;

    public View a(int i2) {
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

    public void b() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f13442g = context;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, "orderSummaryModel");
        this.j = iJRPaytmDataModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.f13437b = arguments != null ? arguments.getString("order_id") : null;
        Bundle arguments2 = getArguments();
        this.f13438c = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("IS_MY_ORDER_SCREEN", false)) : null;
        Bundle arguments3 = getArguments();
        this.f13443h = arguments3 != null ? Boolean.valueOf(arguments3.getBoolean("IS_SHOW_HOME", true)) : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str = arguments4.getString("insurance_post_payment_url", (String) null);
        }
        this.f13444i = str;
    }

    public final void a(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.f13446b;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void b(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.f13445a;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void a(ImageView imageView) {
        String str;
        k.c(imageView, "view");
        w a2 = w.a();
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.f13447c;
        } else {
            str = null;
        }
        a2.a(str).b(R.drawable.ins_ic_default_bank).a(imageView);
    }

    public final void b(ImageView imageView) {
        String str;
        k.c(imageView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.f13447c;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    public final void c(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.f13451g;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void d(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.o;
        } else {
            str = null;
        }
        textView.setText(str);
        textView.setVisibility(0);
    }

    public final void c(ImageView imageView) {
        Drawable drawable;
        k.c(imageView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            drawable = dVar.f13452h;
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void e(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.j;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void f(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.k;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void g(TextView textView) {
        String str;
        k.c(textView, "view");
        d dVar = this.f13436a;
        if (dVar != null) {
            str = dVar.l;
        } else {
            str = null;
        }
        textView.setText(str);
    }

    public final void c() {
        String str;
        String str2;
        String str3;
        String str4;
        d dVar = this.f13436a;
        Object obj = null;
        if (dVar != null) {
            str = dVar.f13448d;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                d dVar2 = this.f13436a;
                if (dVar2 != null) {
                    str2 = dVar2.f13448d;
                } else {
                    str2 = null;
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str2));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                d dVar3 = this.f13436a;
                if (dVar3 != null) {
                    str3 = dVar3.f13448d;
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3)) {
                    d dVar4 = this.f13436a;
                    if (dVar4 != null) {
                        str4 = dVar4.f13446b;
                    } else {
                        str4 = null;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        d dVar5 = this.f13436a;
                        if (dVar5 != null) {
                            str3 = dVar5.f13446b;
                        }
                    } else {
                        Context context = getContext();
                        if (context != null) {
                            str3 = context.getString(R.string.policy_wording);
                        }
                    }
                    str3 = null;
                }
                request.setDestinationInExternalFilesDir(getContext(), Environment.DIRECTORY_DOWNLOADS, k.a(str3, (Object) ".pdf"));
                Context context2 = getContext();
                if (context2 != null) {
                    obj = context2.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                }
                DownloadManager downloadManager = (DownloadManager) obj;
                Context context3 = getContext();
                if (context3 != null) {
                    context3.registerReceiver(new InsurancePostPaymentFragment$downloadPDF$1(this), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                if (downloadManager == null) {
                    k.a();
                }
                downloadManager.enqueue(request);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str) {
        String a2 = k.a(this.f13444i, (Object) str);
        a l = new com.paytm.network.b().a(this.f13442g).a(a.C0715a.GET).a(a.c.INSURANCE).a(com.paytm.utility.b.b(this.f13442g, a2) + "&actions=1").b((String) null).a((Map<String, String>) null).a(this.j).c("InsurancePostPaymentFragment").a((b) this).a(a.b.SILENT).l();
        if (l != null) {
            l.a();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        b();
    }
}
