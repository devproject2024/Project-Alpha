package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.app.n;
import androidx.core.content.FileProvider;
import androidx.core.g.f;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.util.HashMap;
import net.one97.paytm.i.g;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.b.b;
import net.one97.paytm.o2o.movies.common.d;

public class r extends g {

    /* renamed from: a  reason: collision with root package name */
    a f75430a = null;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f75431b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f75432c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f75433d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f75434e;

    public interface a {
        void a();
    }

    public static r a(int i2, String str, String str2, String str3) {
        r rVar = new r();
        Bundle bundle = new Bundle();
        rVar.setCancelable(false);
        bundle.putInt("SELECTED_SEATS", i2);
        bundle.putString("MOVIE_NAME", str);
        bundle.putString("SHOW_TIME", str2);
        bundle.putString("CINEMA_NAME", str3);
        rVar.setArguments(bundle);
        return rVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof a) {
                this.f75430a = (a) context;
            } else if (getParentFragment() instanceof a) {
                this.f75430a = (a) getParentFragment();
            }
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 16973839);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f75432c = (ImageView) view.findViewById(R.id.btn_close);
        this.f75431b = (ProgressBar) view.findViewById(R.id.loading);
        this.f75433d = (ImageView) view.findViewById(R.id.img_seat_share);
        this.f75434e = (RelativeLayout) view.findViewById(R.id.btn_share_seatmap);
        this.f75432c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.a(view);
            }
        });
        this.f75432c.setVisibility(4);
        this.f75433d.setVisibility(4);
        this.f75434e.setVisibility(4);
        this.f75431b.setVisibility(0);
        view.postDelayed(new Runnable() {
            public final void run() {
                r.this.c();
            }
        }, 50);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a aVar = this.f75430a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f75431b.setVisibility(8);
        this.f75432c.setVisibility(0);
        this.f75433d.setVisibility(0);
        this.f75434e.setVisibility(0);
        setCancelable(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(File file, View view) {
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            Uri uriForFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file);
            if (uriForFile != null) {
                Bundle arguments = getArguments();
                String str5 = "";
                if (arguments != null) {
                    str3 = arguments.getString("MOVIE_NAME");
                    str2 = arguments.getString("CINEMA_NAME");
                    str = arguments.getString("SHOW_TIME");
                    i2 = arguments.getInt("SELECTED_SEATS");
                } else {
                    str3 = str5;
                    str2 = str3;
                    str = str2;
                    i2 = 0;
                }
                if (str3 == null) {
                    str3 = str5;
                }
                if (str2 == null) {
                    str2 = str5;
                }
                if (str == null) {
                    str = str5;
                }
                if (i2 > 0) {
                    str4 = activity.getString(R.string.ss_msg_some_seat_selected, new Object[]{str3, str, "https://m.p-y.tm/PtMmV"});
                } else {
                    str4 = activity.getString(R.string.ss_msg_no_seat_selected, new Object[]{str3, str, "https://m.p-y.tm/PtMmV"});
                }
                n.a aVar = new n.a((Context) f.a(activity), activity.getComponentName());
                aVar.f2800a.setType("image/jpg");
                aVar.f2800a.putExtra("android.intent.extra.TEXT", str4);
                aVar.f2801b = getString(R.string.seat_share_chooser);
                if (!"android.intent.action.SEND".equals(aVar.f2800a.getAction())) {
                    aVar.f2800a.setAction("android.intent.action.SEND");
                }
                aVar.f2805f = null;
                aVar.f2800a.putExtra("android.intent.extra.STREAM", uriForFile);
                if (aVar.f2802c != null) {
                    aVar.a("android.intent.extra.EMAIL", aVar.f2802c);
                    aVar.f2802c = null;
                }
                if (aVar.f2803d != null) {
                    aVar.a("android.intent.extra.CC", aVar.f2803d);
                    aVar.f2803d = null;
                }
                if (aVar.f2804e != null) {
                    aVar.a("android.intent.extra.BCC", aVar.f2804e);
                    aVar.f2804e = null;
                }
                boolean z = aVar.f2805f != null && aVar.f2805f.size() > 1;
                boolean equals = "android.intent.action.SEND_MULTIPLE".equals(aVar.f2800a.getAction());
                if (!z && equals) {
                    aVar.f2800a.setAction("android.intent.action.SEND");
                    if (aVar.f2805f == null || aVar.f2805f.isEmpty()) {
                        aVar.f2800a.removeExtra("android.intent.extra.STREAM");
                    } else {
                        aVar.f2800a.putExtra("android.intent.extra.STREAM", aVar.f2805f.get(0));
                    }
                    aVar.f2805f = null;
                }
                if (z && !equals) {
                    aVar.f2800a.setAction("android.intent.action.SEND_MULTIPLE");
                    if (aVar.f2805f == null || aVar.f2805f.isEmpty()) {
                        aVar.f2800a.removeExtra("android.intent.extra.STREAM");
                    } else {
                        aVar.f2800a.putParcelableArrayListExtra("android.intent.extra.STREAM", aVar.f2805f);
                    }
                }
                Intent addFlags = Intent.createChooser(aVar.f2800a, aVar.f2801b).addFlags(1);
                a(uriForFile, addFlags);
                activity.startActivityForResult(addFlags, 666);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    HashMap hashMap = new HashMap();
                    if (d.a((Context) activity2, "movies") != null) {
                        str5 = d.a((Context) activity2, "movies").getValue();
                    }
                    hashMap.put(b.f75007b, b.I);
                    hashMap.put(b.f75008c, b.J);
                    hashMap.put(b.p, b.r);
                    hashMap.put(b.f75009d, str5 + ";" + str3 + ";" + str2);
                    if (com.paytm.utility.b.r((Context) activity2)) {
                        hashMap.put(b.q, com.paytm.utility.b.n((Context) activity2));
                    }
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(b.f75006a, hashMap, activity2);
                }
            }
        }
        this.f75434e.setEnabled(false);
        this.f75434e.postDelayed(new Runnable() {
            public final void run() {
                r.this.a();
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.f75434e.setEnabled(true);
        } catch (Exception unused) {
        }
    }

    private void a(Uri uri, Intent intent) {
        try {
            Context context = getContext();
            if (context != null) {
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_seat_share, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        try {
            getDialog().getWindow().getDecorView().setAlpha(0.0f);
            getDialog().getWindow().getDecorView().animate().alpha(1.0f).setDuration(200).start();
        } catch (Exception unused) {
        }
    }

    public final void a(File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f75433d.setImageBitmap(decodeFile);
        }
        this.f75434e.setOnClickListener(new View.OnClickListener(file) {
            private final /* synthetic */ File f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                r.this.a(this.f$1, view);
            }
        });
        this.f75432c.postDelayed(new Runnable() {
            public final void run() {
                r.this.b();
            }
        }, 50);
    }
}
