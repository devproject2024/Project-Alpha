package com.zhihu.matisse.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.utility.q;
import com.zhihu.matisse.internal.b.a;
import com.zhihu.matisse.internal.c.c;
import com.zhihu.matisse.internal.c.d;
import com.zhihu.matisse.internal.c.e;
import com.zhihu.matisse.internal.c.g;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import com.zhihu.matisse.internal.ui.SelectedPreviewActivity;
import com.zhihu.matisse.internal.ui.a;
import com.zhihu.matisse.internal.ui.a.a;
import com.zhihu.matisse.internal.ui.a.b;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import net.one97.paytm.activity.PaytmActivity;

public class MatisseActivity extends PaytmActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, a.C0763a, a.C0764a, a.b, a.d, a.e {
    private static Uri o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final com.zhihu.matisse.internal.b.a f45902a = new com.zhihu.matisse.internal.b.a();

    /* renamed from: b  reason: collision with root package name */
    private c f45903b;

    /* renamed from: c  reason: collision with root package name */
    private com.zhihu.matisse.internal.b.c f45904c = new com.zhihu.matisse.internal.b.c(this);

    /* renamed from: d  reason: collision with root package name */
    private com.zhihu.matisse.internal.entity.c f45905d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.zhihu.matisse.internal.ui.widget.a f45906e;

    /* renamed from: f  reason: collision with root package name */
    private b f45907f;

    /* renamed from: g  reason: collision with root package name */
    private View f45908g;

    /* renamed from: h  reason: collision with root package name */
    private View f45909h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f45910i;
    private View j;
    private View k;
    private LinearLayout l;
    private CheckRadioView m;
    private boolean n;

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* access modifiers changed from: private */
    public void e() {
        if (androidx.core.content.b.a((Context) this, "android.permission.CAMERA") == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", "camera_" + System.currentTimeMillis());
            o = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", o);
            startActivityForResult(intent, 2);
            return;
        }
        androidx.core.app.a.a(this, new String[]{"android.permission.CAMERA"}, 26);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 1) {
            if (i2 == 26) {
                if (androidx.core.content.b.a((Context) this, "android.permission.CAMERA") == 0) {
                    e();
                } else {
                    Toast.makeText(this, R.string.chat_module_need_camera_permission, 0).show();
                }
            }
        } else if (androidx.core.content.b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.f45902a.a();
        } else {
            finish();
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f45904c.b(bundle);
        bundle.putInt("state_current_selection", this.f45902a.f45728d);
        bundle.putBoolean("checkState", this.n);
    }

    public void onResume() {
        super.onResume();
        com.paytm.android.chat.c.a(this);
    }

    public void onPause() {
        com.paytm.android.chat.c.e();
        super.onPause();
    }

    public void onDestroy() {
        com.paytm.android.chat.c.e();
        super.onDestroy();
        com.zhihu.matisse.internal.b.a aVar = this.f45902a;
        if (aVar.f45726b != null) {
            aVar.f45726b.a(1);
        }
        aVar.f45727c = null;
        com.zhihu.matisse.internal.entity.c cVar = this.f45905d;
        cVar.v = null;
        cVar.r = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 2 && o != null) {
                Intent intent2 = new Intent(this, SelectedPreviewActivity.class);
                Bundle bundle = new Bundle();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(new Item(o));
                o = null;
                bundle.putParcelableArrayList("state_selection", new ArrayList(linkedHashSet));
                bundle.putInt("state_collection_type", 1);
                bundle.putBoolean("extra_result_original_enable", this.n);
                bundle.putBoolean("extra_is_from_camera", true);
                intent2.putExtra("extra_default_bundle", bundle);
                startActivityForResult(intent2, 23);
            } else if (i2 == 23) {
                Bundle bundleExtra = intent.getBundleExtra("extra_result_bundle");
                ArrayList parcelableArrayList = bundleExtra.getParcelableArrayList("state_selection");
                this.n = intent.getBooleanExtra("extra_result_original_enable", false);
                int i4 = bundleExtra.getInt("state_collection_type", 0);
                if (intent.getBooleanExtra("extra_result_apply", false)) {
                    Intent intent3 = new Intent();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_result_bundle_caption");
                    if (parcelableArrayList != null) {
                        Iterator it2 = parcelableArrayList.iterator();
                        while (it2.hasNext()) {
                            Item item = (Item) it2.next();
                            arrayList.add(item.f45765c);
                            arrayList2.add(d.a(this, item.f45765c));
                        }
                    }
                    intent3.putParcelableArrayListExtra("wholesome_items", parcelableArrayList);
                    intent3.putParcelableArrayListExtra("extra_result_selection", arrayList);
                    intent3.putStringArrayListExtra("extra_result_selection_path", arrayList2);
                    intent3.putStringArrayListExtra("extra_result_selection_caption", stringArrayListExtra);
                    intent3.putExtra("extra_result_original_enable", this.n);
                    setResult(-1, intent3);
                    finish();
                    return;
                }
                if (!intent.getBooleanExtra("extra_is_from_camera", false)) {
                    com.zhihu.matisse.internal.b.c cVar = this.f45904c;
                    if (parcelableArrayList.size() == 0) {
                        cVar.f45734b = 0;
                    } else {
                        cVar.f45734b = i4;
                    }
                    cVar.f45733a.clear();
                    cVar.f45733a.addAll(parcelableArrayList);
                }
                Fragment c2 = getSupportFragmentManager().c(com.zhihu.matisse.internal.ui.a.class.getSimpleName());
                if (c2 instanceof com.zhihu.matisse.internal.ui.a) {
                    ((com.zhihu.matisse.internal.ui.a) c2).f45808a.notifyDataSetChanged();
                }
                f();
            } else if (i2 == 24) {
                Uri uri = this.f45903b.f45744d;
                String str = this.f45903b.f45745e;
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(uri);
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(str);
                Intent intent4 = new Intent();
                intent4.putParcelableArrayListExtra("extra_result_selection", arrayList3);
                intent4.putStringArrayListExtra("extra_result_selection_path", arrayList4);
                setResult(-1, intent4);
                if (Build.VERSION.SDK_INT < 21) {
                    revokeUriPermission(uri, 3);
                }
                new g(getApplicationContext(), str, new g.a() {
                    public final void a() {
                        q.a("scan finish!");
                    }
                });
                finish();
            }
        }
    }

    private void f() {
        if (!this.f45905d.x) {
            int f2 = this.f45904c.f();
            int i2 = 0;
            if (f2 == 0) {
                this.f45910i.setEnabled(false);
                this.f45910i.setText(getString(R.string.chat_module_button_apply_default));
            } else if (f2 != 1 || !this.f45905d.b()) {
                this.f45910i.setEnabled(true);
                this.f45910i.setText(getString(R.string.chat_module_button_apply, new Object[]{Integer.valueOf(f2)}));
            } else {
                this.f45910i.setText(R.string.chat_module_button_apply_default);
                this.f45910i.setEnabled(true);
            }
            if (this.f45905d.s) {
                this.l.setVisibility(0);
                g();
            } else {
                this.l.setVisibility(4);
            }
            View view = this.f45908g;
            if (f2 <= 0) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    private void g() {
        this.m.setChecked(this.n);
        if (h() > 0 && this.n) {
            com.zhihu.matisse.internal.ui.widget.c.a("", getString(R.string.chat_module_error_over_original_size, new Object[]{Integer.valueOf(this.f45905d.u)})).show(getSupportFragmentManager(), com.zhihu.matisse.internal.ui.widget.c.class.getName());
            this.m.setChecked(false);
            this.n = false;
        }
    }

    private int h() {
        int f2 = this.f45904c.f();
        int i2 = 0;
        for (int i3 = 0; i3 < f2; i3++) {
            Item item = this.f45904c.b().get(i3);
            if (com.zhihu.matisse.b.isImage(item.f45764b) && e.a(item.f45766d) > ((float) this.f45905d.u)) {
                i2++;
            }
        }
        return i2;
    }

    public void onClick(View view) {
        if (view == this.f45909h) {
            if (FastClickUtil.isFastClick()) {
                Intent intent = new Intent(this, SelectedPreviewActivity.class);
                intent.putExtra("extra_default_bundle", this.f45904c.a());
                intent.putExtra("extra_result_original_enable", this.n);
                startActivityForResult(intent, 23);
            }
        } else if (view.getId() == R.id.button_apply) {
            if (FastClickUtil.isFastClick()) {
                Intent intent2 = new Intent();
                intent2.putParcelableArrayListExtra("extra_result_selection", (ArrayList) this.f45904c.c());
                intent2.putStringArrayListExtra("extra_result_selection_path", (ArrayList) this.f45904c.d());
                intent2.putExtra("extra_result_original_enable", this.n);
                setResult(-1, intent2);
                finish();
            }
        } else if (view.getId() == R.id.originalLayout && FastClickUtil.isFastClick()) {
            int h2 = h();
            if (h2 > 0) {
                com.zhihu.matisse.internal.ui.widget.c.a("", getString(R.string.chat_module_error_over_original_count, new Object[]{Integer.valueOf(h2), Integer.valueOf(this.f45905d.u)})).show(getSupportFragmentManager(), com.zhihu.matisse.internal.ui.widget.c.class.getName());
                return;
            }
            this.n = !this.n;
            this.m.setChecked(this.n);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f45902a.f45728d = i2;
        this.f45907f.getCursor().moveToPosition(i2);
        Album a2 = Album.a(this.f45907f.getCursor());
        if (a2.b() && c.a.f45787a.k) {
            a2.a();
        }
        a(a2);
    }

    public final void a(final Cursor cursor) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f45907f.swapCursor(cursor);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                cursor.moveToPosition(MatisseActivity.this.f45902a.f45728d);
                com.zhihu.matisse.internal.ui.widget.a c2 = MatisseActivity.this.f45906e;
                MatisseActivity matisseActivity = MatisseActivity.this;
                c2.a(matisseActivity, matisseActivity.f45902a.f45728d);
                Album a2 = Album.a(cursor);
                if (a2.b() && c.a.f45787a.k) {
                    a2.a();
                }
                MatisseActivity.this.a(a2);
            }
        });
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f45907f.swapCursor((Cursor) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(Album album) {
        if (!album.b() || !album.c()) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            getSupportFragmentManager().a().b(R.id.container, com.zhihu.matisse.internal.ui.a.a(album), com.zhihu.matisse.internal.ui.a.class.getSimpleName()).c();
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }

    public final void b() {
        f();
        if (this.f45905d.r != null) {
            com.zhihu.matisse.d.c cVar = this.f45905d.r;
            this.f45904c.c();
            cVar.a(this.f45904c.d());
        }
    }

    public final void a(Item item, int i2) {
        if (this.f45905d.x) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_result_selection", (ArrayList) this.f45904c.c());
            intent.putStringArrayListExtra("extra_result_selection_path", (ArrayList) this.f45904c.d());
            intent.putExtra("extra_result_original_enable", this.n);
            setResult(-1, intent);
            finish();
        }
    }

    public final com.zhihu.matisse.internal.b.c c() {
        return this.f45904c;
    }

    public final void d() {
        File file;
        com.zhihu.matisse.internal.c.c cVar = this.f45903b;
        if (cVar != null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getPackageManager()) != null) {
                File file2 = null;
                try {
                    String format = String.format("JPEG_%s.jpg", new Object[]{new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date())});
                    if (cVar.f45743c.f45772a) {
                        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else {
                        file = ((Activity) cVar.f45741a.get()).getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    }
                    if (cVar.f45743c.f45774c != null) {
                        File file3 = new File(file, cVar.f45743c.f45774c);
                        if (!file3.exists()) {
                            file3.mkdirs();
                        }
                        file = file3;
                    }
                    File file4 = new File(file, format);
                    if ("mounted".equals(androidx.core.d.d.a(file4))) {
                        file2 = file4;
                    }
                } catch (IOException unused) {
                }
                if (file2 != null) {
                    cVar.f45745e = file2.getAbsolutePath();
                    cVar.f45744d = FileProvider.getUriForFile((Context) cVar.f45741a.get(), cVar.f45743c.f45773b, file2);
                    intent.putExtra("output", cVar.f45744d);
                    intent.addFlags(2);
                    if (Build.VERSION.SDK_INT < 21) {
                        for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 65536)) {
                            grantUriPermission(resolveInfo.activityInfo.packageName, cVar.f45744d, 3);
                        }
                    }
                    if (cVar.f45742b != null) {
                        ((Fragment) cVar.f45742b.get()).startActivityForResult(intent, 24);
                    } else {
                        ((Activity) cVar.f45741a.get()).startActivityForResult(intent, 24);
                    }
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.f45905d = c.a.f45787a;
        setTheme(this.f45905d.f45781d);
        super.onCreate(bundle);
        if (!this.f45905d.q) {
            setResult(0);
            finish();
            return;
        }
        setContentView(R.layout.chat_activity_matisse);
        if (this.f45905d.c()) {
            setRequestedOrientation(this.f45905d.f45782e);
        }
        if (this.f45905d.k) {
            this.f45903b = new com.zhihu.matisse.internal.c.c(this);
            if (this.f45905d.l != null) {
                this.f45903b.f45743c = this.f45905d.l;
            } else {
                throw new RuntimeException("Don't forget to set CaptureStrategy.");
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.c(false);
        supportActionBar.b(true);
        Drawable navigationIcon = toolbar.getNavigationIcon();
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{R.attr.album_element_color});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        navigationIcon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.f45910i = (TextView) findViewById(R.id.button_apply);
        this.f45908g = findViewById(R.id.bottom_toolbar);
        this.f45909h = findViewById(R.id.button_done);
        this.f45910i.setOnClickListener(this);
        this.f45908g.setOnClickListener(this);
        this.f45909h.setOnClickListener(this);
        this.j = findViewById(R.id.container);
        this.k = findViewById(R.id.empty_view);
        this.l = (LinearLayout) findViewById(R.id.originalLayout);
        this.m = (CheckRadioView) findViewById(R.id.original);
        this.l.setOnClickListener(this);
        this.f45904c.a(bundle);
        if (bundle != null) {
            this.n = bundle.getBoolean("checkState");
        }
        f();
        this.f45907f = new b(this);
        this.f45906e = new com.zhihu.matisse.internal.ui.widget.a(this);
        com.zhihu.matisse.internal.ui.widget.a aVar = this.f45906e;
        aVar.f45887d = this;
        aVar.f45885b = (TextView) findViewById(R.id.selected_album);
        aVar.f45885b.setVisibility(8);
        aVar.f45885b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(
/*
Method generation error in method: com.zhihu.matisse.internal.ui.widget.a.2.onClick(android.view.View):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.zhihu.matisse.internal.ui.widget.a.2.onClick(android.view.View):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
        com.zhihu.matisse.internal.ui.widget.a aVar2 = this.f45906e;
        View findViewById = findViewById(R.id.toolbar);
        View findViewById2 = findViewById(R.id.root);
        aVar2.f45886c.f45893a = findViewById;
        aVar2.f45888e = findViewById;
        aVar2.f45889f = findViewById2;
        com.zhihu.matisse.internal.ui.widget.a aVar3 = this.f45906e;
        b bVar = this.f45907f;
        com.zhihu.matisse.internal.ui.widget.b bVar2 = aVar3.f45886c;
        bVar2.f45895c = bVar;
        bVar2.f45894b.setAdapter(bVar);
        aVar3.f45884a = bVar;
        com.zhihu.matisse.internal.b.a aVar4 = this.f45902a;
        aVar4.f45725a = new WeakReference<>(this);
        aVar4.f45726b = getSupportLoaderManager();
        aVar4.f45727c = this;
        com.zhihu.matisse.internal.b.a aVar5 = this.f45902a;
        if (bundle != null) {
            aVar5.f45728d = bundle.getInt("state_current_selection");
        }
        if (androidx.core.content.b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.f45902a.a();
        } else {
            androidx.core.app.a.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
        if (com.zhihu.matisse.internal.c.c.a(this)) {
            findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MatisseActivity.this.e();
                }
            });
        } else {
            findViewById(R.id.btnCamera).setVisibility(8);
        }
    }
}
