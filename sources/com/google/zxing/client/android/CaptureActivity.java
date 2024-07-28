package com.google.zxing.client.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.a;
import com.google.zxing.client.android.a.d;
import com.google.zxing.client.android.c;
import com.google.zxing.e;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;

public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {

    /* renamed from: h  reason: collision with root package name */
    private static final String f40084h = CaptureActivity.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f40085i = {"http://zxing.appspot.com/scan", "zxing://scan/"};
    private static final Collection<s> j = EnumSet.of(s.ISSUE_NUMBER, s.SUGGESTED_PRICE, s.ERROR_CORRECTION_LEVEL, s.POSSIBLE_COUNTRY);

    /* renamed from: a  reason: collision with root package name */
    d f40086a;

    /* renamed from: b  reason: collision with root package name */
    c f40087b;

    /* renamed from: c  reason: collision with root package name */
    ViewfinderView f40088c;

    /* renamed from: d  reason: collision with root package name */
    r f40089d;

    /* renamed from: e  reason: collision with root package name */
    com.google.zxing.client.android.history.d f40090e;

    /* renamed from: f  reason: collision with root package name */
    k f40091f;

    /* renamed from: g  reason: collision with root package name */
    b f40092g;
    private r k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private View o;
    private boolean p;
    private boolean q;
    private l r;
    private String s;
    private o t;
    private Collection<a> u;
    private Map<e, ?> v;
    private String w;
    private a x;
    private boolean y = true;

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.capture);
        this.m = (ImageView) findViewById(R.id.qr_header_close_menu);
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CaptureActivity.this.finish();
            }
        });
        this.n = (ImageView) findViewById(R.id.qr_header_flash_icon);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.p = false;
        this.f40091f = new k(this);
        this.f40092g = new b(this);
        this.x = new a(this);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
            r8 = this;
            super.onResume()
            com.google.zxing.client.android.history.d r0 = new com.google.zxing.client.android.history.d
            r0.<init>(r8)
            r8.f40090e = r0
            com.google.zxing.client.android.history.d r0 = r8.f40090e
            r0.c()
            com.google.zxing.client.android.a.d r0 = new com.google.zxing.client.android.a.d
            android.app.Application r1 = r8.getApplication()
            r0.<init>(r1)
            r8.f40086a = r0
            int r0 = com.google.zxing.client.android.R.id.viewfinder_view
            android.view.View r0 = r8.findViewById(r0)
            com.google.zxing.client.android.ViewfinderView r0 = (com.google.zxing.client.android.ViewfinderView) r0
            r8.f40088c = r0
            com.google.zxing.client.android.ViewfinderView r0 = r8.f40088c
            com.google.zxing.client.android.a.d r1 = r8.f40086a
            r0.setCameraManager(r1)
            int r0 = com.google.zxing.client.android.R.id.result_view
            android.view.View r0 = r8.findViewById(r0)
            r8.o = r0
            int r0 = com.google.zxing.client.android.R.id.status_view
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.l = r0
            r0 = 0
            r8.f40087b = r0
            r8.f40089d = r0
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8)
            r2 = 1
            r8.setRequestedOrientation(r2)
            r8.c()
            com.google.zxing.client.android.b r3 = r8.f40092g
            r3.a()
            com.google.zxing.client.android.a r3 = r8.x
            com.google.zxing.client.android.a.d r4 = r8.f40086a
            r3.f40107b = r4
            android.content.Context r4 = r3.f40106a
            android.content.SharedPreferences r4 = android.preference.PreferenceManager.getDefaultSharedPreferences(r4)
            com.google.zxing.client.android.a.e r4 = com.google.zxing.client.android.a.e.readPref(r4)
            com.google.zxing.client.android.a.e r5 = com.google.zxing.client.android.a.e.AUTO
            if (r4 != r5) goto L_0x0081
            android.content.Context r4 = r3.f40106a
            java.lang.String r5 = "sensor"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.hardware.SensorManager r4 = (android.hardware.SensorManager) r4
            r5 = 5
            android.hardware.Sensor r5 = r4.getDefaultSensor(r5)
            r3.f40108c = r5
            android.hardware.Sensor r5 = r3.f40108c
            if (r5 == 0) goto L_0x0081
            android.hardware.Sensor r5 = r3.f40108c
            r6 = 3
            r4.registerListener(r3, r5, r6)
        L_0x0081:
            com.google.zxing.client.android.k r3 = r8.f40091f
            r3.c()
            android.content.Intent r3 = r8.getIntent()
            java.lang.String r4 = "preferences_copy_to_clipboard"
            boolean r1 = r1.getBoolean(r4, r2)
            r4 = 0
            if (r1 == 0) goto L_0x009f
            if (r3 == 0) goto L_0x009d
            java.lang.String r1 = "SAVE_HISTORY"
            boolean r1 = r3.getBooleanExtra(r1, r2)
            if (r1 == 0) goto L_0x009f
        L_0x009d:
            r1 = 1
            goto L_0x00a0
        L_0x009f:
            r1 = 0
        L_0x00a0:
            r8.q = r1
            com.google.zxing.client.android.l r1 = com.google.zxing.client.android.l.NONE
            r8.r = r1
            r8.s = r0
            r8.t = r0
            r8.u = r0
            r8.w = r0
            if (r3 == 0) goto L_0x016c
            java.lang.String r0 = r3.getAction()
            java.lang.String r1 = r3.getDataString()
            java.lang.String r5 = "com.google.zxing.client.android.SCAN"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0113
            com.google.zxing.client.android.l r0 = com.google.zxing.client.android.l.NATIVE_APP_INTENT
            r8.r = r0
            java.util.Set r0 = com.google.zxing.client.android.e.a((android.content.Intent) r3)
            r8.u = r0
            java.util.Map r0 = com.google.zxing.client.android.g.a((android.content.Intent) r3)
            r8.v = r0
            java.lang.String r0 = "SCAN_WIDTH"
            boolean r1 = r3.hasExtra(r0)
            if (r1 == 0) goto L_0x00f1
            java.lang.String r1 = "SCAN_HEIGHT"
            boolean r2 = r3.hasExtra(r1)
            if (r2 == 0) goto L_0x00f1
            int r0 = r3.getIntExtra(r0, r4)
            int r1 = r3.getIntExtra(r1, r4)
            if (r0 <= 0) goto L_0x00f1
            if (r1 <= 0) goto L_0x00f1
            com.google.zxing.client.android.a.d r2 = r8.f40086a
            r2.b(r0, r1)
        L_0x00f1:
            java.lang.String r0 = "SCAN_CAMERA_ID"
            boolean r1 = r3.hasExtra(r0)
            if (r1 == 0) goto L_0x0105
            r1 = -1
            int r0 = r3.getIntExtra(r0, r1)
            if (r0 < 0) goto L_0x0105
            com.google.zxing.client.android.a.d r1 = r8.f40086a
            r1.a((int) r0)
        L_0x0105:
            java.lang.String r0 = "PROMPT_MESSAGE"
            java.lang.String r0 = r3.getStringExtra(r0)
            if (r0 == 0) goto L_0x0164
            android.widget.TextView r1 = r8.l
            r1.setText(r0)
            goto L_0x0164
        L_0x0113:
            if (r1 == 0) goto L_0x0130
            java.lang.String r0 = "http://www.google"
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x0130
            java.lang.String r0 = "/m/products/scan"
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x0130
            com.google.zxing.client.android.l r0 = com.google.zxing.client.android.l.PRODUCT_SEARCH_LINK
            r8.r = r0
            r8.s = r1
            java.util.Set<com.google.zxing.a> r0 = com.google.zxing.client.android.e.f40193a
            r8.u = r0
            goto L_0x0164
        L_0x0130:
            if (r1 == 0) goto L_0x0144
            java.lang.String[] r0 = f40085i
            int r5 = r0.length
            r6 = 0
        L_0x0136:
            if (r6 >= r5) goto L_0x0144
            r7 = r0[r6]
            boolean r7 = r1.startsWith(r7)
            if (r7 == 0) goto L_0x0141
            goto L_0x0145
        L_0x0141:
            int r6 = r6 + 1
            goto L_0x0136
        L_0x0144:
            r2 = 0
        L_0x0145:
            if (r2 == 0) goto L_0x0164
            com.google.zxing.client.android.l r0 = com.google.zxing.client.android.l.ZXING_LINK
            r8.r = r0
            r8.s = r1
            android.net.Uri r0 = android.net.Uri.parse(r1)
            com.google.zxing.client.android.o r1 = new com.google.zxing.client.android.o
            r1.<init>(r0)
            r8.t = r1
            java.util.Set r1 = com.google.zxing.client.android.e.a((android.net.Uri) r0)
            r8.u = r1
            java.util.Map r0 = com.google.zxing.client.android.g.a((android.net.Uri) r0)
            r8.v = r0
        L_0x0164:
            java.lang.String r0 = "CHARACTER_SET"
            java.lang.String r0 = r3.getStringExtra(r0)
            r8.w = r0
        L_0x016c:
            int r0 = com.google.zxing.client.android.R.id.preview_view
            android.view.View r0 = r8.findViewById(r0)
            android.view.SurfaceView r0 = (android.view.SurfaceView) r0
            android.view.SurfaceHolder r0 = r0.getHolder()
            boolean r1 = r8.p
            if (r1 == 0) goto L_0x0180
            r8.a((android.view.SurfaceHolder) r0)
            return
        L_0x0180:
            r0.addCallback(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.CaptureActivity.onResume():void");
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        c cVar = this.f40087b;
        if (cVar != null) {
            cVar.f40165b = c.a.DONE;
            cVar.f40166c.d();
            Message.obtain(cVar.f40164a.a(), R.id.quit).sendToTarget();
            try {
                cVar.f40164a.join(500);
            } catch (InterruptedException unused) {
            }
            cVar.removeMessages(R.id.decode_succeeded);
            cVar.removeMessages(R.id.decode_failed);
            this.f40087b = null;
        }
        this.f40091f.b();
        a aVar = this.x;
        if (aVar.f40108c != null) {
            ((SensorManager) aVar.f40106a.getSystemService("sensor")).unregisterListener(aVar);
            aVar.f40107b = null;
            aVar.f40108c = null;
        }
        this.f40092g.close();
        this.f40086a.b();
        if (!this.p) {
            ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        this.f40091f.d();
        super.onDestroy();
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (!(i2 == 27 || i2 == 80)) {
                if (i2 == 24) {
                    this.f40086a.a(true);
                } else if (i2 == 25) {
                    this.f40086a.a(false);
                    return true;
                }
            }
            return true;
        } else if (this.r == l.NATIVE_APP_INTENT) {
            setResult(0);
            finish();
            return true;
        } else if ((this.r == l.NONE || this.r == l.ZXING_LINK) && this.f40089d != null) {
            c cVar = this.f40087b;
            if (cVar != null) {
                cVar.sendEmptyMessageDelayed(R.id.restart_preview, 0);
            }
            c();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        int intExtra;
        if (i3 == -1 && i2 == 47820 && (intExtra = intent.getIntExtra("ITEM_NUMBER", -1)) >= 0) {
            a(this.f40090e.a(intExtra).f40236a);
        }
    }

    private void a(r rVar) {
        if (this.f40087b == null) {
            this.k = rVar;
            return;
        }
        if (rVar != null) {
            this.k = rVar;
        }
        if (this.k != null) {
            this.f40087b.sendMessage(Message.obtain(this.f40087b, R.id.decode_succeeded, this.k));
        }
        this.k = null;
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.p) {
            this.p = true;
            a(surfaceHolder);
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.p = false;
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (!this.f40086a.a()) {
            try {
                this.f40086a.a(surfaceHolder);
                if (this.f40087b == null) {
                    this.f40087b = new c(this, this.u, this.v, this.w, this.f40086a);
                }
                a((r) null);
            } catch (IOException unused) {
                b();
            } catch (RuntimeException unused2) {
                b();
            }
        }
    }

    private void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.msg_camera_framework_bug));
        builder.setPositiveButton(R.string.button_ok, new i(this));
        builder.setOnCancelListener(new i(this));
        builder.show();
    }

    private void c() {
        this.o.setVisibility(8);
        this.l.setBackgroundColor(0);
        this.l.setText(R.string.msg_default_status);
        this.l.setVisibility(0);
        this.f40088c.setVisibility(0);
        this.f40089d = null;
    }

    public final void a() {
        ViewfinderView viewfinderView = this.f40088c;
        Bitmap bitmap = viewfinderView.f40098a;
        viewfinderView.f40098a = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        viewfinderView.invalidate();
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, float f2, r rVar) {
        t[] tVarArr = rVar.f40579c;
        if (tVarArr != null && tVarArr.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_points));
            if (tVarArr.length == 2) {
                paint.setStrokeWidth(4.0f);
                a(canvas, paint, tVarArr[0], tVarArr[1], f2);
            } else if (tVarArr.length == 4 && (rVar.f40580d == a.UPC_A || rVar.f40580d == a.EAN_13)) {
                a(canvas, paint, tVarArr[0], tVarArr[1], f2);
                a(canvas, paint, tVarArr[2], tVarArr[3], f2);
            } else {
                paint.setStrokeWidth(10.0f);
                for (t tVar : tVarArr) {
                    if (tVar != null) {
                        canvas.drawPoint(tVar.f40584a * f2, tVar.f40585b * f2, paint);
                    }
                }
            }
        }
    }

    private static void a(Canvas canvas, Paint paint, t tVar, t tVar2, float f2) {
        if (tVar != null && tVar2 != null) {
            canvas.drawLine(f2 * tVar.f40584a, f2 * tVar.f40585b, f2 * tVar2.f40584a, f2 * tVar2.f40585b, paint);
        }
    }
}
