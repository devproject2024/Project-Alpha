package net.one97.paytm.wallet.newdesign.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.zxing.l;
import com.paytm.e.a.c;
import com.paytm.e.a.d;
import com.paytm.e.a.e;
import com.paytm.e.a.f;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.offline.OfflineLeadOTPModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.activity.BarcodeZoomActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import net.one97.paytm.wallet.newdesign.activity.QRZoomActivity;
import net.one97.paytm.wallet.newdesign.activity.ShowCodeActivity;
import net.one97.paytm.wallet.newdesign.activity.ShowCodeOverlayActivity;
import net.one97.paytm.wallet.newdesign.utils.BarcodeQRGenerator;
import net.one97.paytm.wallet.newdesign.utils.CustomDialog;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class e extends h implements View.OnClickListener, CustomDialog.OnDialogDismissListener {
    /* access modifiers changed from: private */
    public long A;
    /* access modifiers changed from: private */
    public long B;
    private boolean C;
    private Context D;
    private int E = 0;
    private int F = 0;
    /* access modifiers changed from: private */
    public int[] G = new int[2];
    /* access modifiers changed from: private */
    public int H = 0;
    /* access modifiers changed from: private */
    public int I = 0;

    /* renamed from: a  reason: collision with root package name */
    private com.paytm.e.a.e f70847a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f70848b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f70849c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70850d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f70851e;

    /* renamed from: f  reason: collision with root package name */
    private f f70852f;

    /* renamed from: g  reason: collision with root package name */
    private d f70853g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70854h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f70855i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public Bitmap k;
    /* access modifiers changed from: private */
    public Bitmap l;
    private a m;
    /* access modifiers changed from: private */
    public ImageView n;
    private LinearLayout o;
    private Button p;
    private TextView q;
    private TextView r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public int t = 0;
    private boolean u;
    private boolean v;
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public LottieAnimationView y;
    private long z;

    static /* synthetic */ int j(e eVar) {
        int i2 = eVar.t;
        eVar.t = i2 - 1;
        return i2;
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.fragment_tv_generate_otp) {
            this.s = true;
            this.t = 1;
            a(false);
            a("offline_payments", "showcode_refreshotp_clicked", (Context) getActivity(), "home/pay-send/show-code");
            try {
                new c();
                str = c.a(b.a().getWalletSSOToken(b.a().getContext()), "6", WalletSharedPrefs.INSTANCE.getOfflineTimeCounter(this.D), 1);
                this.A = System.currentTimeMillis();
                this.B = (this.z + 120000) - this.A;
            } catch (Exception unused) {
                str = "0";
            }
            b(str);
            if (str.length() == 6) {
                str = str.substring(0, 3) + ' ' + str.substring(3, 6);
            }
            this.f70848b.setContentDescription(str.replaceAll(" ", ""));
            this.f70848b.setText(str);
            this.m = new a(this, (byte) 0);
            this.m.execute(new Integer[]{1});
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        this.r.setEnabled(z2);
        if (z2) {
            this.r.setTextColor(androidx.core.content.b.c(this.D, R.color.paytm_blue));
        } else {
            this.r.setTextColor(androidx.core.content.b.c(this.D, R.color.wallet_disabled_blue));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.D = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getArguments() != null) {
            this.C = getArguments().getBoolean(UpiConstants.KEY_IS_SCAN_ONLY, false);
        }
        return layoutInflater.inflate(R.layout.w_fragment_show_code, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        CJRHomePageItem cJRHomePageItem;
        super.onActivityCreated(bundle);
        this.r = (TextView) getView().findViewById(R.id.fragment_tv_generate_otp);
        this.r.setOnClickListener(this);
        this.j = (LinearLayout) getView().findViewById(R.id.fragment_show_code_loading_layout);
        this.f70854h = (TextView) getView().findViewById(R.id.fragment_show_code_tv_configuration);
        this.f70855i = (LinearLayout) getView().findViewById(R.id.fragment_show_code_main_layout);
        this.f70848b = (TextView) getView().findViewById(R.id.fragment_show_code_tv_offline_otp);
        this.f70849c = (TextView) getView().findViewById(R.id.fragment_show_code_tv_mobile_number);
        this.f70851e = (ImageView) getView().findViewById(R.id.fragment_show_code_iv_barcode);
        this.n = (ImageView) getView().findViewById(R.id.fragment_show_code_iv_qr_code);
        this.f70850d = (TextView) getView().findViewById(R.id.fragment_show_code_tv_timer);
        this.o = (LinearLayout) getView().findViewById(R.id.fragment_show_code_empty_layout);
        this.p = (Button) getView().findViewById(R.id.fragment_show_code_btn_login);
        this.q = (TextView) getView().findViewById(R.id.fragment_show_code_empty_tv);
        this.y = (LottieAnimationView) getView().findViewById(R.id.dot_progress_bar);
        String l2 = com.paytm.utility.b.l((Context) getActivity());
        if (!(l2 == null || l2.trim().length() == 0)) {
            if (l2.length() == 10) {
                l2 = l2.substring(0, 5) + ' ' + l2.substring(5, 10);
            }
            this.f70849c.setText(l2);
        }
        this.f70851e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.k != null) {
                    try {
                        e.this.a("offline_payments", "showcode_barcode_clicked", (Context) e.this.getActivity(), "home/pay-send/show-code");
                    } catch (Exception unused) {
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    e.this.k.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intent intent = new Intent(e.this.getActivity(), BarcodeZoomActivity.class);
                    intent.putExtra("barcode", byteArray);
                    e.this.startActivityForResult(intent, 345, androidx.core.app.b.a(e.this.getActivity(), e.this.f70851e, e.this.getString(R.string.zoom_transition)).a());
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.l != null) {
                    e eVar = e.this;
                    eVar.a("offline_payments", "showcode_qrcode_clicked", (Context) eVar.getActivity(), "home/pay-send/show-code");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    e.this.l.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intent intent = new Intent(e.this.getActivity(), QRZoomActivity.class);
                    intent.putExtra("qrcode", byteArray);
                    intent.putExtra("is_from_show_code", true);
                    e.this.startActivityForResult(intent, 345, androidx.core.app.b.a(e.this.getActivity(), e.this.n, e.this.getString(R.string.zoom_transition)).a());
                }
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(e.this.getActivity(), PaySendInfoActivity.class);
                intent.putExtra("openTab", n.aH);
                e.this.getActivity().startActivity(intent);
            }
        });
        ((ShowCodeActivity) getActivity()).findViewById(R.id.activity_show_code_toolbar).setVisibility(0);
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && (activity instanceof PaySendActivityV2)) {
                PaySendActivityV2 paySendActivityV2 = (PaySendActivityV2) activity;
                Bundle bundle2 = paySendActivityV2.f70523h != null ? paySendActivityV2.f70523h.get(n.aH) : null;
                if (bundle2 != null && (cJRHomePageItem = (CJRHomePageItem) bundle2.getSerializable("extra_home_data")) != null) {
                    String overlay = cJRHomePageItem.getOverlay();
                    if (!TextUtils.isEmpty(overlay) && overlay.equalsIgnoreCase("coachmark")) {
                        this.f70848b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public final void onGlobalLayout() {
                                e.this.f70848b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                e.this.f70848b.getLocationOnScreen(e.this.G);
                                e eVar = e.this;
                                int unused = eVar.I = eVar.f70848b.getMeasuredHeight();
                                e eVar2 = e.this;
                                int unused2 = eVar2.H = eVar2.f70848b.getMeasuredWidth();
                                Intent intent = new Intent(e.this.getActivity(), ShowCodeOverlayActivity.class);
                                intent.setFlags(67108864);
                                intent.putExtra("otp_loc_x", e.this.G[0]);
                                intent.putExtra("otp_loc_y", e.this.G[1] - e.s(e.this));
                                intent.putExtra("otp_width", e.this.H);
                                intent.putExtra("otp_height", e.this.I);
                                e.this.startActivity(intent);
                            }
                        });
                        PaySendActivityV2 paySendActivityV22 = (PaySendActivityV2) activity;
                        String str = n.aH;
                        if (paySendActivityV22.f70523h != null) {
                            paySendActivityV22.f70523h.remove(str);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a() {
        long walletTokenExpireTime = b.a().getWalletTokenExpireTime(getActivity());
        if (walletTokenExpireTime > 0 && System.currentTimeMillis() >= walletTokenExpireTime) {
            this.f70854h.setVisibility(8);
            this.o.setVisibility(0);
        } else if (b.a().getWalletSSOToken(b.a().getContext()) == null || WalletSharedPrefs.INSTANCE.getUserDeviceMap(getContext()) == null || WalletSharedPrefs.INSTANCE.getCGCPHeader(getContext()) == null || (!com.paytm.utility.b.ag(this.D) && com.paytm.utility.b.c(getContext()) && !this.w)) {
            this.f70855i.setVisibility(8);
            this.j.setVisibility(0);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            String stringFromGTM = b.a().getStringFromGTM(getActivity(), "getalltokens");
            if (URLUtil.isValidUrl(stringFromGTM) || getActivity() == null || getActivity().isFinishing()) {
                String e2 = com.paytm.utility.b.e(this.D.getApplicationContext(), stringFromGTM + "/" + com.paytm.utility.a.q(b.a().getContext()));
                HashMap hashMap2 = new HashMap();
                hashMap2.put("screen_name", getClass().getSimpleName());
                if (com.paytm.utility.b.c(getContext())) {
                    net.one97.paytm.network.a aVar = new net.one97.paytm.network.a(e2, new CJRPGTokenList(), hashMap2, hashMap);
                    aVar.e();
                    aVar.a(5000);
                    aVar.c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            e.this.b((net.one97.paytm.network.f) obj);
                        }
                    });
                } else if (getActivity() != null) {
                    getActivity().isFinishing();
                }
            }
            if (!com.paytm.utility.b.ag(this.D)) {
                this.w = true;
            }
        } else {
            this.f70855i.setVisibility(0);
            this.j.setVisibility(8);
            long offlineTimeCounter = WalletSharedPrefs.INSTANCE.getOfflineTimeCounter(getActivity());
            if (b.a().getWalletSSOToken(b.a().getContext()) == null) {
                Toast.makeText(getActivity(), getString(R.string.relogin), 1).show();
                return;
            }
            d();
            if (offlineTimeCounter > 0) {
                this.f70852f = new f(offlineTimeCounter);
                this.f70853g = new d(getActivity());
                this.f70847a = new com.paytm.e.a.e(this.f70852f, this.f70853g);
                this.f70847a.f42690b = new e.a() {
                    public final void a(final long j) {
                        e.this.getActivity().runOnUiThread(new Runnable() {
                            public final void run() {
                                long j = j;
                                if (e.this.s) {
                                    j = j + 60000;
                                }
                                if (j < 60150) {
                                    boolean unused = e.this.s = false;
                                    e.this.a(true);
                                }
                            }
                        });
                    }

                    public final void a() {
                        if (e.this.isResumed() || e.this.x) {
                            if (e.this.t != 0) {
                                e.j(e.this);
                            }
                            if (e.this.A == 0 || (e.this.A > 0 && System.currentTimeMillis() - e.this.A > e.this.B)) {
                                e.m(e.this);
                                long unused = e.this.A = 0;
                            }
                        }
                    }
                };
                com.paytm.e.a.e eVar = this.f70847a;
                if (!eVar.f42689a) {
                    eVar.run();
                    return;
                }
                throw new IllegalStateException("Task already stopped and cannot be restarted.");
            }
        }
    }

    private void b() {
        b.a().showSessionTimeoutAlert(getActivity());
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && isResumed()) {
            onResume();
        }
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            if (!com.paytm.utility.b.c(getContext())) {
                this.u = com.paytm.utility.b.ag(this.D);
                if (this.u || this.v) {
                    a();
                    return;
                }
                if (com.paytm.utility.b.c(this.D)) {
                    a("Time_out_of_sync", "", "Internet Available");
                } else {
                    a("Time_out_of_sync", "", "Internet Unvailable");
                }
                this.v = true;
                c();
                return;
            }
            a();
        }
    }

    private void c() {
        CustomDialog.initListener(new CustomDialog.OkClickListener() {
            public final void onOkClick() {
                e.this.a("Go_to_datetime_settings_clicked", "clicks go to date & time settings", "");
                if (e.this.isAdded()) {
                    e.this.startActivityForResult(new Intent("android.settings.DATE_SETTINGS"), 203);
                }
            }
        });
        if (getActivity() != null && !getActivity().isFinishing()) {
            CustomDialog.showAlert(this.D, getString(R.string.update_time_phone), getString(R.string.enable_automatic_time_date_message), true, (CustomDialog.OnDialogDismissListener) this);
        }
    }

    private static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String substring = str.substring(str.indexOf(44) + 2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(substring).getTime();
        } catch (ParseException e2) {
            long currentTimeMillis = System.currentTimeMillis();
            q.d(String.valueOf(e2));
            return currentTimeMillis;
        }
    }

    private void b(String str) {
        if (getActivity() != null && !TextUtils.isEmpty(str)) {
            try {
                String showCodeRSAKey = b.a().getShowCodeRSAKey();
                String a2 = com.paytm.e.a.b.a(showCodeRSAKey, str);
                net.one97.paytm.wallet.newdesign.a.a.a(getActivity().getApplicationContext()).a(a2, com.paytm.e.a.b.a(showCodeRSAKey, b.a().getWalletSSOToken(b.a().getContext()) + AppConstants.COLON + System.currentTimeMillis()), com.paytm.e.a.b.a(showCodeRSAKey, CLConstants.CREDTYPE_TOTP));
            } catch (NoSuchAlgorithmException e2) {
                q.d(String.valueOf(e2));
            } catch (NoSuchPaddingException e3) {
                q.d(String.valueOf(e3));
            } catch (InvalidKeyException e4) {
                q.d(String.valueOf(e4));
            } catch (IllegalBlockSizeException e5) {
                q.d(String.valueOf(e5));
            } catch (BadPaddingException e6) {
                q.d(String.valueOf(e6));
            } catch (InvalidKeySpecException e7) {
                q.d(String.valueOf(e7));
            } catch (Exception e8) {
                q.d(String.valueOf(e8));
            }
        }
    }

    private void d() {
        com.paytm.e.a.e eVar = this.f70847a;
        if (eVar != null) {
            eVar.f42689a = true;
            this.f70847a = null;
        }
    }

    public void onStop() {
        d();
        a aVar = this.m;
        if (aVar != null) {
            aVar.cancel(true);
        }
        super.onStop();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 203) {
            this.x = true;
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(net.one97.paytm.common.utility.d.cw, str2);
            }
            hashMap.put("user_id", com.paytm.utility.b.n(this.D));
            hashMap.put(net.one97.paytm.common.utility.d.cv, "offline_payments");
            b.a().sendNewCustomGTMEvents(this.D, net.one97.paytm.common.utility.d.bE, str, str2, str3, (String) null, "show code", "offline_payments");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onDialogDismissed() {
        this.x = true;
        a();
    }

    class a extends AsyncTask<Integer, Void, Bitmap[]> {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            if (e.this.getActivity() == null || TextUtils.isEmpty(b.a().getWalletSSOToken(b.a().getContext()))) {
                return null;
            }
            String offlineBarcodeQRSoundData = BarcodeQRGenerator.INSTANCE.getOfflineBarcodeQRSoundData(b.a().getWalletSSOToken(b.a().getContext()), WalletSharedPrefs.INSTANCE.getOfflineTimeCounter(e.this.getActivity()), WalletSharedPrefs.INSTANCE.getCGCPHeader(e.this.getActivity()), WalletSharedPrefs.INSTANCE.getUserDeviceMap(e.this.getActivity()), "2", "c", numArr[0].intValue());
            e eVar = e.this;
            Bitmap b2 = eVar.b((Activity) eVar.getActivity(), offlineBarcodeQRSoundData);
            e eVar2 = e.this;
            Bitmap a2 = eVar2.a((Activity) eVar2.getActivity(), offlineBarcodeQRSoundData);
            e.a(e.this, offlineBarcodeQRSoundData);
            return new Bitmap[]{b2, a2};
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Bitmap[] bitmapArr = (Bitmap[]) obj;
            super.onPostExecute(bitmapArr);
            if (bitmapArr != null) {
                e.this.f70851e.setImageBitmap(bitmapArr[0]);
                e.this.n.setImageBitmap(bitmapArr[1]);
                Bitmap unused = e.this.k = bitmapArr[0];
                Bitmap unused2 = e.this.l = bitmapArr[1];
                e.this.y.setVisibility(8);
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            e.o(e.this);
        }
    }

    public final Bitmap a(Activity activity, String str) {
        l lVar = new l();
        try {
            if (this.E == 0) {
                this.E = com.paytm.utility.b.a(202, (Context) activity);
            }
            com.google.zxing.b.b a2 = lVar.a(str, com.google.zxing.a.QR_CODE, this.E, this.E);
            Bitmap createBitmap = Bitmap.createBitmap(a2.f39889a, a2.f39890b, Bitmap.Config.ARGB_8888);
            for (int i2 = 0; i2 < a2.f39889a; i2++) {
                for (int i3 = 0; i3 < a2.f39890b; i3++) {
                    createBitmap.setPixel(i2, i3, a2.a(i2, i3) ? -16777216 : -1);
                }
            }
            return createBitmap;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public final Bitmap b(Activity activity, String str) {
        try {
            if (this.F == 0) {
                this.F = com.paytm.utility.b.a(60, (Context) activity);
            }
            com.google.zxing.b.b a2 = new l().a(Uri.encode(str), com.google.zxing.a.CODE_128, com.paytm.utility.b.c(295), 1);
            int i2 = a2.f39889a;
            Bitmap createBitmap = Bitmap.createBitmap(i2, this.F, Bitmap.Config.ARGB_8888);
            for (int i3 = 0; i3 < i2; i3++) {
                int[] iArr = new int[this.F];
                Arrays.fill(iArr, a2.a(i3, 0) ? -16777216 : -1);
                createBitmap.setPixels(iArr, 0, 1, i3, 0, 1, this.F);
            }
            return createBitmap;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            b.a().sendCustomGTMEvents(str, str2, this.C ? "flow_through_scan_icon" : "flow_through_pay_icon", (String) null, context, str3, "offline_payments");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a != net.one97.paytm.network.h.SUCCESS) {
            net.one97.paytm.network.h hVar = net.one97.paytm.network.h.ERROR;
        } else if (fVar.f55797b instanceof OfflineLeadOTPModel) {
            OfflineLeadOTPModel offlineLeadOTPModel = (OfflineLeadOTPModel) fVar.f55797b;
            if (offlineLeadOTPModel.status.equalsIgnoreCase("success")) {
                if (getActivity() != null && !getActivity().isFinishing()) {
                    WalletSharedPrefs.INSTANCE.storeOfflineCounterCachedTime(getActivity(), System.currentTimeMillis());
                    WalletSharedPrefs.INSTANCE.storeUserDeviceMap(getActivity(), offlineLeadOTPModel.ud_map);
                    WalletSharedPrefs.INSTANCE.storeCGCPHeader(getActivity(), offlineLeadOTPModel.cgcp_offline_header);
                    if (offlineLeadOTPModel.otp_config != null) {
                        WalletSharedPrefs.INSTANCE.storeServerTime(getActivity(), offlineLeadOTPModel.otp_config.epoch_time);
                        WalletSharedPrefs.INSTANCE.storeOfflineTimeCounter(getActivity(), (long) offlineLeadOTPModel.otp_config.time_interval);
                    }
                    a();
                }
            } else if (offlineLeadOTPModel.responseCode == null || !offlineLeadOTPModel.responseCode.equals("815")) {
                this.j.setVisibility(8);
            } else {
                this.f70854h.setVisibility(8);
                this.o.setVisibility(0);
                if (!TextUtils.isEmpty(offlineLeadOTPModel.message)) {
                    this.q.setText(offlineLeadOTPModel.message);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b instanceof CJRPGTokenList) {
                b.a().getPgToken((CJRPGTokenList) fVar.f55797b);
                if (TimeUnit.MILLISECONDS.toSeconds(Math.abs(a(fVar.f55797b.getNetworkResponse().headers.get("Date")) - Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis())) > 60) {
                    c();
                } else if (b.a().getWalletSSOToken(b.a().getContext()) == null) {
                    b();
                } else if (getActivity() != null && !getActivity().isFinishing()) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Authorization", com.paytm.utility.b.m());
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("session_token", b.a().getWalletSSOToken(b.a().getContext()));
                        hashMap.put("version", "2");
                        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(com.paytm.utility.b.e((Context) getActivity(), b.a().getStringFromGTM(getActivity(), "offlineConfig")), new OfflineLeadOTPModel(), (Map<String, String>) null, hashMap, "");
                        if (com.paytm.utility.b.c((Context) getActivity())) {
                            bVar.c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    e.this.a((net.one97.paytm.network.f) obj);
                                }
                            });
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            int i2 = fVar.f55798c.f55799a;
            if (i2 == 401 || i2 == 410 || i2 == 403) {
                b();
            }
        }
    }

    static /* synthetic */ void m(e eVar) {
        String str;
        try {
            new c();
            str = c.a(b.a().getWalletSSOToken(b.a().getContext()), "6", WalletSharedPrefs.INSTANCE.getOfflineTimeCounter(eVar.getActivity()), 0);
            eVar.z = System.currentTimeMillis();
        } catch (Exception unused) {
            str = "0";
        }
        eVar.b(str);
        if (str.length() == 6) {
            str = str.substring(0, 3) + ' ' + str.substring(3, 6);
        }
        eVar.f70848b.setContentDescription(str.replaceAll(" ", ""));
        eVar.f70848b.setText(str);
        eVar.m = new a(eVar, (byte) 0);
        eVar.m.execute(new Integer[]{0});
    }

    static /* synthetic */ void o(e eVar) {
        eVar.y.setVisibility(0);
        eVar.y.setAnimation("Payments-Loader.json");
        eVar.y.loop(true);
        eVar.y.playAnimation();
    }

    static /* synthetic */ void a(e eVar, String str) {
        if (eVar.getActivity() != null && !TextUtils.isEmpty(str)) {
            try {
                String showCodeRSAKey = b.a().getShowCodeRSAKey();
                String a2 = com.paytm.e.a.b.a(showCodeRSAKey, str);
                net.one97.paytm.wallet.newdesign.a.a.a(eVar.getActivity().getApplicationContext()).a(a2, com.paytm.e.a.b.a(showCodeRSAKey, b.a().getWalletSSOToken(b.a().getContext()) + AppConstants.COLON + System.currentTimeMillis()), com.paytm.e.a.b.a(showCodeRSAKey, "QB_Code"));
            } catch (NoSuchAlgorithmException e2) {
                q.d(String.valueOf(e2));
            } catch (NoSuchPaddingException e3) {
                q.d(String.valueOf(e3));
            } catch (InvalidKeyException e4) {
                q.d(String.valueOf(e4));
            } catch (IllegalBlockSizeException e5) {
                q.d(String.valueOf(e5));
            } catch (BadPaddingException e6) {
                q.d(String.valueOf(e6));
            } catch (InvalidKeySpecException e7) {
                q.d(String.valueOf(e7));
            } catch (Exception e8) {
                q.d(String.valueOf(e8));
            }
        }
    }

    static /* synthetic */ int s(e eVar) {
        int identifier = eVar.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return eVar.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
