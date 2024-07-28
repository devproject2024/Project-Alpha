package net.one97.paytm.games.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.c;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public abstract class GpBaseActivity extends PaytmActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f35466a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f35467b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35468c;

    /* renamed from: d  reason: collision with root package name */
    private IntentFilter f35469d;

    /* renamed from: e  reason: collision with root package name */
    private BroadcastReceiver f35470e;

    /* renamed from: f  reason: collision with root package name */
    private AlertDialog f35471f;

    public void a(int i2, Object obj) {
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(g.a().c().wrapContext(context));
        a.b((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f35466a = getResources().getDisplayMetrics().widthPixels;
    }

    /* access modifiers changed from: protected */
    public final void a(IntentFilter intentFilter) {
        this.f35469d = intentFilter;
        if (this.f35469d != null) {
            if (this.f35470e == null) {
                this.f35470e = new BroadcastReceiver() {

                    /* renamed from: b  reason: collision with root package name */
                    private NetworkInfo.State f35473b;

                    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
                    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
                        /*
                            r4 = this;
                            java.lang.String r0 = r6.getAction()
                            int r1 = r0.hashCode()
                            r2 = -1172645946(0xffffffffba1ad7c6, float:-5.9067865E-4)
                            r3 = 1
                            if (r1 == r2) goto L_0x001e
                            r2 = -839937853(0xffffffffcdef90c3, float:-5.02405216E8)
                            if (r1 == r2) goto L_0x0014
                            goto L_0x0028
                        L_0x0014:
                            java.lang.String r1 = "gamepind.action.shortcutStatus"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0028
                            r0 = 1
                            goto L_0x0029
                        L_0x001e:
                            java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0028
                            r0 = 0
                            goto L_0x0029
                        L_0x0028:
                            r0 = -1
                        L_0x0029:
                            if (r0 == 0) goto L_0x0051
                            if (r0 == r3) goto L_0x002e
                            goto L_0x0050
                        L_0x002e:
                            net.one97.paytm.games.activity.GpBaseActivity r5 = net.one97.paytm.games.activity.GpBaseActivity.this
                            boolean r0 = net.one97.paytm.games.e.f.a((android.app.Activity) r5)
                            if (r0 != 0) goto L_0x0050
                            java.lang.String r0 = "product_id"
                            java.lang.String r6 = r6.getStringExtra(r0)
                            int r0 = android.os.Build.VERSION.SDK_INT
                            r1 = 26
                            if (r0 < r1) goto L_0x004d
                            boolean r6 = net.one97.paytm.games.e.f.a((android.content.Context) r5, (java.lang.String) r6)
                            if (r6 != 0) goto L_0x004d
                            r6 = 4
                            net.one97.paytm.games.e.f.a((android.content.Context) r5, (int) r6)
                            return
                        L_0x004d:
                            net.one97.paytm.games.e.f.a((android.content.Context) r5, (int) r3)
                        L_0x0050:
                            return
                        L_0x0051:
                            boolean r5 = net.one97.paytm.games.e.f.a((android.content.Context) r5)
                            if (r5 == 0) goto L_0x005a
                            android.net.NetworkInfo$State r5 = android.net.NetworkInfo.State.CONNECTED
                            goto L_0x005c
                        L_0x005a:
                            android.net.NetworkInfo$State r5 = android.net.NetworkInfo.State.DISCONNECTED
                        L_0x005c:
                            android.net.NetworkInfo$State r6 = r4.f35473b
                            if (r6 == 0) goto L_0x0068
                            if (r5 == r6) goto L_0x0068
                            net.one97.paytm.games.activity.GpBaseActivity r6 = net.one97.paytm.games.activity.GpBaseActivity.this
                            r0 = 3
                            r6.a((int) r0, (java.lang.Object) r5)
                        L_0x0068:
                            r4.f35473b = r5
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.GpBaseActivity.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                    }
                };
            }
            registerReceiver(this.f35470e, this.f35469d);
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
        this.f35468c = true;
    }

    public void onPause() {
        this.f35468c = false;
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ProgressDialog progressDialog;
        if (!f.a((Activity) this) && (progressDialog = this.f35467b) != null) {
            progressDialog.dismiss();
        }
    }

    public void onDestroy() {
        if (this.f35469d != null) {
            unregisterReceiver(this.f35470e);
        }
        super.onDestroy();
    }

    public static void a(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(Color.parseColor("#ffffff"));
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
            }
        } catch (Throwable th) {
            q.b(th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void a(GpCommonBaseResponse gpCommonBaseResponse) {
        String str;
        if (this.f35471f == null) {
            String str2 = gpCommonBaseResponse.message;
            if (f.a((Object) str2)) {
                str2 = getString(R.string.com_gamepind_some_error);
            }
            if (gpCommonBaseResponse.code == 0) {
                str = str2 + " [CS]";
            } else {
                str = str2 + " [CS" + gpCommonBaseResponse.code + "]";
            }
            this.f35471f = f.a((Activity) this, "", str, getString(R.string.com_gamepind_btn_cst), getString(R.string.com_gamepind_btn_ok), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    GpBaseActivity.this.a(dialogInterface, i2);
                }
            });
            this.f35471f.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    GpBaseActivity.this.a(dialogInterface);
                }
            });
            this.f35471f.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        if (i2 == -1 && !f.a((Activity) this)) {
            c.a((Activity) this);
        }
        finish();
        this.f35471f = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f35471f = null;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        if (!f.a((Activity) this)) {
            if (this.f35467b == null) {
                AnonymousClass2 r0 = new ProgressDialog(this) {
                    /* access modifiers changed from: protected */
                    public final void onCreate(Bundle bundle) {
                        super.onCreate(bundle);
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) getLayoutInflater().inflate(R.layout.com_gamepind_common_progress_bar, (ViewGroup) null).findViewById(R.id.com_gamepind_progress_bar);
                        f.a(lottieAnimationView);
                        setContentView(lottieAnimationView);
                        ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
                        layoutParams.width = GpBaseActivity.this.getResources().getDimensionPixelSize(R.dimen.com_gamepind_progress_bar_width);
                        layoutParams.height = GpBaseActivity.this.getResources().getDimensionPixelSize(R.dimen.com_gamepind_progress_bar_height);
                        lottieAnimationView.setLayoutParams(layoutParams);
                    }
                };
                r0.setCancelable(false);
                Window window = r0.getWindow();
                if (window != null) {
                    window.setBackgroundDrawableResource(17170445);
                }
                this.f35467b = r0;
            }
            this.f35467b.getWindow();
            this.f35467b.setMessage(str);
            this.f35467b.show();
        }
    }
}
