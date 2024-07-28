package net.one97.scanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import java.io.IOException;

public class CameraSourcePreview extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public d f72438a;

    /* renamed from: b  reason: collision with root package name */
    private Context f72439b;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceView f72440c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f72441d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f72442e = false;

    /* renamed from: f  reason: collision with root package name */
    private GraphicOverlay f72443f;

    /* renamed from: g  reason: collision with root package name */
    private a f72444g;

    public interface a {
        void a(MotionEvent motionEvent);
    }

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f72439b = context;
        this.f72440c = new SurfaceView(context);
        this.f72440c.getHolder().addCallback(new b(this, (byte) 0));
        addView(this.f72440c);
    }

    public final void a(d dVar) throws IOException, SecurityException {
        if (dVar == null) {
            a();
        }
        this.f72438a = dVar;
        if (this.f72438a != null) {
            this.f72441d = true;
            b();
        }
    }

    public final void a() {
        d dVar = this.f72438a;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void b() throws IOException, SecurityException {
        if (this.f72441d && this.f72442e) {
            this.f72438a.a(this.f72440c.getHolder());
            if (this.f72443f != null) {
                com.google.android.gms.common.images.a aVar = this.f72438a.f72470f;
                int min = Math.min(aVar.f8720a, aVar.f8721b);
                int max = Math.max(aVar.f8720a, aVar.f8721b);
                if (c()) {
                    this.f72443f.setCameraInfo(min, max, this.f72438a.f72469e);
                } else {
                    this.f72443f.setCameraInfo(max, min, this.f72438a.f72469e);
                }
                this.f72443f.a();
            }
            this.f72441d = false;
        }
    }

    public void setSingleTouchListener(a aVar) {
        this.f72444g = aVar;
    }

    class b implements SurfaceHolder.Callback {
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        private b() {
        }

        /* synthetic */ b(CameraSourcePreview cameraSourcePreview, byte b2) {
            this();
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.f72442e = true;
            try {
                CameraSourcePreview.this.b();
            } catch (IOException | SecurityException unused2) {
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.f72442e = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            getChildAt(i8).layout(0, 0, i6, i7);
        }
        try {
            b();
        } catch (IOException | SecurityException unused) {
        }
    }

    private boolean c() {
        int i2 = this.f72439b.getResources().getConfiguration().orientation;
        return i2 != 2 && i2 == 1;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        int action = motionEvent.getAction();
        if (this.f72438a != null) {
            if (motionEvent.getPointerCount() <= 1) {
                a aVar = this.f72444g;
                if (aVar != null) {
                    aVar.a(motionEvent);
                }
            } else if (action == 5) {
                this.f72438a.f72465a = d.a(motionEvent);
            } else if (action == 2) {
                d dVar = this.f72438a;
                synchronized (dVar.f72467c) {
                    if (dVar.f72468d != null) {
                        dVar.f72468d.cancelAutoFocus();
                    }
                }
                d dVar2 = this.f72438a;
                if (dVar2.f72468d != null) {
                    Camera.Parameters parameters = dVar2.f72468d.getParameters();
                    if (parameters != null) {
                        i3 = parameters.getMaxZoom();
                        i2 = parameters.getZoom();
                    } else {
                        i3 = 1;
                        i2 = 1;
                    }
                    float a2 = d.a(motionEvent);
                    if (a2 > dVar2.f72465a) {
                        if (i2 < i3) {
                            i2++;
                        }
                    } else if (a2 < dVar2.f72465a && i2 > 0) {
                        i2--;
                    }
                    dVar2.f72465a = a2;
                    parameters.setZoom(i2);
                    dVar2.f72468d.setParameters(parameters);
                }
            }
        }
        return true;
    }
}
