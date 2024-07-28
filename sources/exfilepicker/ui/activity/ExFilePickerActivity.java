package exfilepicker.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.utility.q;
import exfilepicker.a;
import exfilepicker.a.b;
import exfilepicker.a.d;
import exfilepicker.data.ExFilePickerResult;
import exfilepicker.ui.a.a;
import exfilepicker.ui.b.a;
import exfilepicker.ui.b.b;
import exfilepicker.ui.b.c;
import exfilepicker.ui.view.FilesListToolbar;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;

public class ExFilePickerActivity extends PaytmActivity implements View.OnClickListener, Toolbar.b, a, a.C0778a, b.a, c.a {

    /* renamed from: a  reason: collision with root package name */
    Handler f46128a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    private boolean f46129b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f46130c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f46131d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46132e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46133f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46134g;

    /* renamed from: h  reason: collision with root package name */
    private a.C0777a f46135h = a.C0777a.ALL;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a.b f46136i = a.b.NAME_ASC;
    private File j;
    private FilesListToolbar k;
    /* access modifiers changed from: private */
    public RecyclerView l;
    /* access modifiers changed from: private */
    public View m;
    /* access modifiers changed from: private */
    public exfilepicker.ui.adapter.a n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private SearchView.SearchAutoComplete s;
    /* access modifiers changed from: private */
    public SearchView t;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_ex_file_picker);
        Intent intent = getIntent();
        this.f46129b = intent.getBooleanExtra("CAN_CHOOSE_ONLY_ONE_ITEM", false);
        this.f46130c = intent.getStringArrayExtra("SHOW_ONLY_EXTENSIONS");
        this.f46131d = intent.getStringArrayExtra("EXCEPT_EXTENSIONS");
        this.f46132e = intent.getBooleanExtra("IS_NEW_FOLDER_BUTTON_DISABLED", false);
        this.f46133f = intent.getBooleanExtra("IS_SORT_BUTTON_DISABLED", false);
        this.f46134g = intent.getBooleanExtra("IS_QUIT_BUTTON_ENABLED", false);
        this.f46135h = (a.C0777a) intent.getSerializableExtra("CHOICE_TYPE");
        this.f46136i = (a.b) intent.getSerializableExtra("SORTING_TYPE");
        this.j = a(intent);
        this.p = intent.getBooleanExtra("USE_FIRST_ITEM_AS_UP_ENABLED", false);
        this.q = intent.getBooleanExtra("HIDE_HIDDEN_FILES", false);
        this.r = intent.getStringExtra("RECEIVER_NAME");
        this.l = (RecyclerView) findViewById(R.id.recycler_view);
        this.l.setLayoutManager(new LinearLayoutManager(this));
        this.n = new exfilepicker.ui.adapter.a();
        exfilepicker.ui.adapter.a aVar = this.n;
        aVar.f46203c = this;
        aVar.f46207g = new exfilepicker.ui.a.a() {
            public final void a(int i2) {
                ExFilePickerActivity.f(ExFilePickerActivity.this);
            }
        };
        this.n.f46205e = this.f46135h == a.C0777a.FILES;
        exfilepicker.ui.adapter.a aVar2 = this.n;
        aVar2.f46206f = this.p;
        this.l.setAdapter(aVar2);
        this.k = (FilesListToolbar) findViewById(R.id.toolbar);
        this.k.setOnMenuItemClickListener(this);
        this.k.setNavigationOnClickListener(this);
        this.k.setQuitButtonEnabled(this.f46134g);
        this.k.setMultiChoiceModeEnabled(false);
        Menu menu = this.k.getMenu();
        e();
        menu.findItem(R.id.new_folder).setVisible(!this.f46132e);
        menu.findItem(R.id.sort).setVisible(!this.f46133f);
        this.m = findViewById(R.id.empty_view);
        if (bundle != null && bundle.containsKey("DIRECTORY_STATE")) {
            this.j = new File(bundle.getString("DIRECTORY_STATE"));
        }
        if (androidx.core.content.b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            a(this.j);
        } else {
            androidx.core.app.a.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
        this.k.setVisibility(8);
        setSupportActionBar((Toolbar) findViewById(R.id.top_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
        }
        exfilepicker.ui.adapter.a aVar3 = this.n;
        exfilepicker.a.b.a(aVar3.f46201a, aVar3.f46208h, (b.a) null);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3 || i3 != -1) {
            return;
        }
        if (intent == null) {
            q.d("data is null!");
            return;
        }
        q.d("data: " + intent.getData());
        File file = new File(exfilepicker.a.c.a((Context) this, intent.getData()));
        q.d("---->path: " + file.getAbsolutePath());
        q.d("---->file.getName(): " + file.getName());
        q.d("---->file.getParentFile(): " + file.getParentFile().getAbsolutePath());
        a(file.getParentFile(), file.getName());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu_home, menu);
        MenuItem findItem = menu.findItem(R.id.action_search);
        findItem.setVisible(false);
        this.t = (SearchView) findItem.getActionView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.top_toolbar);
        this.t.setMaxWidth(toolbar.getWidth() - toolbar.getChildAt(2).getLayoutParams().width);
        ImageView imageView = (ImageView) this.t.findViewById(androidx.appcompat.R.id.search_close_btn);
        imageView.setImageResource(R.drawable.chat_ic_search);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ExFilePickerActivity.this.t.clearFocus();
            }
        });
        imageView.setVisibility(8);
        ImageView imageView2 = (ImageView) this.t.findViewById(androidx.appcompat.R.id.search_button);
        imageView2.setImageResource(R.drawable.chat_ic_toolbar_search);
        imageView2.setVisibility(8);
        this.t.findViewById(androidx.appcompat.R.id.search_edit_frame).setBackgroundResource(R.drawable.chat_search_view);
        this.t.findViewById(androidx.appcompat.R.id.search_plate).setBackgroundColor(0);
        this.s = (SearchView.SearchAutoComplete) this.t.findViewById(androidx.appcompat.R.id.search_src_text);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.s, Integer.valueOf(R.drawable.chat_search_view_cursor));
        } catch (Exception unused) {
        }
        this.s.setTextSize(2, 14.0f);
        this.s.setHint("");
        this.t.setOnQueryTextListener(new SearchView.b() {
            public final boolean a(String str) {
                ExFilePickerActivity.class.getSimpleName();
                q.a("onQueryTextSubmit->".concat(String.valueOf(str)));
                c(str);
                ExFilePickerActivity.this.t.clearFocus();
                return true;
            }

            public final boolean b(String str) {
                ExFilePickerActivity.class.getSimpleName();
                q.a("onQueryTextChange->".concat(String.valueOf(str)));
                c(str);
                return true;
            }

            private void c(String str) {
                q.a("callSearch->".concat(String.valueOf(str)));
                ExFilePickerActivity.this.n.a(str);
                if (ExFilePickerActivity.this.n.getItemCount() == 0) {
                    ExFilePickerActivity.this.l.setVisibility(8);
                    ExFilePickerActivity.this.m.setVisibility(0);
                    return;
                }
                ExFilePickerActivity.this.l.setVisibility(0);
                ExFilePickerActivity.this.m.setVisibility(8);
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            if (this.s.isShown()) {
                this.s.setText("");
                Method declaredMethod = this.t.getClass().getDeclaredMethod("onCloseClicked", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.t, new Object[0]);
                return true;
            }
        } catch (Exception unused) {
        }
        onBackPressed();
        return true;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            a(this.j);
        } else if (i2 == 2) {
            c();
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void a(int i2) {
        File a2 = this.n.a(i2);
        if (this.o) {
            if (this.f46129b) {
                this.n.b();
            }
            exfilepicker.ui.adapter.a aVar = this.n;
            boolean z = !aVar.b(i2);
            String name = aVar.a(i2).getName();
            if (z) {
                aVar.f46202b.add(name);
            } else {
                aVar.f46202b.remove(name);
            }
            aVar.notifyItemChanged(i2);
        } else if (i2 == -1) {
            b();
        } else if (a2.isDirectory()) {
            this.j = new File(this.j, a2.getName());
            a(this.j);
        } else {
            a(this.j, a2.getName());
        }
    }

    public final boolean a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.ok) {
            if (this.o) {
                a(this.j, this.n.f46202b);
            } else if (this.f46135h == a.C0777a.DIRECTORIES) {
                if (c(this.j)) {
                    a(this.j, "/");
                } else {
                    a(this.j.getParentFile(), this.j.getName());
                }
            }
        } else if (itemId == R.id.sort) {
            exfilepicker.ui.b.b bVar = new exfilepicker.ui.b.b(this);
            bVar.f46227b = this;
            bVar.f46226a.b();
        } else if (itemId == R.id.storage) {
            c cVar = new c(this);
            cVar.f46229b = this;
            cVar.f46228a.b();
        } else if (itemId == R.id.new_folder) {
            if (androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                c();
            } else {
                androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            }
        } else if (itemId == R.id.select_all) {
            exfilepicker.ui.adapter.a aVar = this.n;
            aVar.f46202b.clear();
            for (File name : aVar.f46201a) {
                aVar.f46202b.add(name.getName());
            }
            aVar.notifyDataSetChanged();
        } else if (itemId == R.id.deselect) {
            this.n.b();
        } else if (itemId == R.id.invert_selection) {
            exfilepicker.ui.adapter.a aVar2 = this.n;
            ArrayList arrayList = new ArrayList();
            for (File next : aVar2.f46201a) {
                if (!aVar2.f46202b.contains(next.getName())) {
                    arrayList.add(next.getName());
                }
            }
            aVar2.f46202b = new ArrayList(arrayList);
            aVar2.notifyDataSetChanged();
        } else if (itemId != R.id.change_view) {
            return false;
        } else {
            MenuItem findItem = this.k.getMenu().findItem(R.id.change_view);
            if (this.n.f46204d) {
                this.l.setLayoutManager(new LinearLayoutManager(this));
                findItem.setIcon(d.a((Context) this, R.attr.efp__ic_action_grid));
                findItem.setTitle(R.string.chat_module_efp__action_grid);
                this.n.a(false);
            } else {
                this.l.setLayoutManager(new GridLayoutManager(this, (int) (((float) getResources().getDisplayMetrics().widthPixels) / getResources().getDimension(R.dimen.files_grid_item_size))));
                findItem.setIcon(d.a((Context) this, R.attr.efp__ic_action_list));
                findItem.setTitle(R.string.chat_module_efp__action_list);
                this.n.a(true);
            }
            a(this.k.getMenu());
        }
        return true;
    }

    public void onClick(View view) {
        if (this.o) {
            d();
            e();
            return;
        }
        finish();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            if (!a()) {
                finish();
            }
        } else if (keyEvent.getAction() == 0 && (keyEvent.getFlags() & 128) == 128) {
            finish();
        }
        return true;
    }

    public void onBackPressed() {
        if (!a()) {
            super.onBackPressed();
        }
    }

    private boolean a() {
        Class<ExFilePickerActivity> cls = ExFilePickerActivity.class;
        if (this.o) {
            d();
            e();
            return true;
        }
        String absolutePath = this.j.getAbsolutePath();
        String absolutePath2 = a(getIntent()).getAbsolutePath();
        cls.getSimpleName();
        q.a("mCurrentDirectory->[" + absolutePath + "]");
        cls.getSimpleName();
        q.a("getStartDirectory->[" + absolutePath2 + "]");
        boolean equals = absolutePath.equals(absolutePath2);
        cls.getSimpleName();
        q.a("isStartDirectory->".concat(String.valueOf(equals)));
        if (c(this.j)) {
            finish();
        } else if (equals) {
            return false;
        } else {
            b();
        }
        return true;
    }

    public final void a(String str) {
        if (str.length() > 0) {
            File file = new File(this.j, str);
            if (file.exists()) {
                Toast.makeText(this, R.string.chat_module_efp__folder_already_exists, 0).show();
            } else if (file.mkdir()) {
                a(this.j);
                Toast.makeText(this, R.string.chat_module_efp__folder_created, 0).show();
            } else {
                Toast.makeText(this, R.string.chat_module_efp__folder_not_created, 0).show();
            }
        }
    }

    public final void a(a.b bVar) {
        this.f46136i = bVar;
        this.n.a(this.f46136i);
    }

    public final void b(String str) {
        this.j = new File(str);
        a(this.j);
    }

    private void b() {
        this.j = this.j.getParentFile();
        a(this.j);
    }

    private void a(File file) {
        b.a aVar;
        b(file);
        this.n.f46206f = !c(file) && this.p;
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            this.m.setVisibility(8);
            this.l.setVisibility(0);
            final ArrayList arrayList = new ArrayList();
            String[] strArr = this.f46130c;
            if (strArr != null && strArr.length > 0 && this.f46135h != a.C0777a.DIRECTORIES) {
                final List asList = Arrays.asList(this.f46130c);
                aVar = new b.a<File>() {
                    public final /* synthetic */ boolean a(Object obj) {
                        File file = (File) obj;
                        return file.isDirectory() || asList.contains(d.a(file.getName()));
                    }
                };
            } else if (this.f46135h == a.C0777a.DIRECTORIES) {
                aVar = new b.a<File>() {
                    public final /* synthetic */ boolean a(Object obj) {
                        return ((File) obj).isDirectory();
                    }
                };
            } else {
                aVar = this.f46135h == a.C0777a.FILES ? new b.a<File>() {
                    public final /* synthetic */ boolean a(Object obj) {
                        return !((File) obj).isDirectory();
                    }
                } : null;
            }
            exfilepicker.a.b.a((T[]) listFiles, arrayList, aVar);
            String[] strArr2 = this.f46131d;
            if (!(strArr2 == null || strArr2.length <= 0 || this.f46135h == a.C0777a.DIRECTORIES)) {
                final List asList2 = Arrays.asList(this.f46131d);
                exfilepicker.a.b.a(arrayList, new b.a<File>() {
                    public final /* synthetic */ boolean a(Object obj) {
                        File file = (File) obj;
                        return !file.isDirectory() && asList2.contains(d.a(file.getName()));
                    }
                });
            }
            if (this.q) {
                exfilepicker.a.b.a(arrayList, new b.a<File>() {
                    public final /* synthetic */ boolean a(Object obj) {
                        return ((File) obj).isHidden();
                    }
                });
            }
            if (arrayList.size() <= 0) {
                this.m.setVisibility(0);
            }
            this.f46128a.post(new Runnable() {
                public final void run() {
                    ExFilePickerActivity.this.n.a((List<File>) arrayList, ExFilePickerActivity.this.f46136i);
                }
            });
        } else if (this.p) {
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.n.a((List<File>) new ArrayList(), this.f46136i);
        } else {
            this.m.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    private void b(File file) {
        if (c(file)) {
            this.k.setTitle((CharSequence) "/");
        } else {
            this.k.setTitle((CharSequence) file.getName());
        }
    }

    private void c() {
        exfilepicker.ui.b.a aVar = new exfilepicker.ui.b.a(this);
        aVar.f46224a = this;
        aVar.a();
    }

    private void d() {
        boolean z = false;
        this.o = false;
        this.k.setMultiChoiceModeEnabled(false);
        exfilepicker.ui.adapter.a aVar = this.n;
        if (this.p && !c(this.j)) {
            z = true;
        }
        aVar.f46206f = z;
        this.n.a();
        a(this.k.getMenu());
    }

    private static boolean c(File file) {
        return file != null && "/".equals(file.getAbsolutePath());
    }

    private void a(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.change_view);
        if (findItem != null) {
            findItem.setIcon(d.a((Context) this, this.n.f46204d ? R.attr.efp__ic_action_list : R.attr.efp__ic_action_grid));
            findItem.setTitle(this.n.f46204d ? R.string.chat_module_efp__action_list : R.string.chat_module_efp__action_grid);
        }
    }

    private void a(final File file, final String str) {
        try {
            if (new FileInputStream(file + "/" + str).available() > 20971520) {
                Toast.makeText(this, getResources().getString(R.string.chat_module_file_size_is_more_than), 0).show();
                return;
            }
        } catch (Exception unused) {
        }
        new c.a(this).b((CharSequence) Html.fromHtml(String.format("Send %s to %s", new Object[]{"<b>\"" + str + "\"</b>", this.r}))).b((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).a((CharSequence) "Send", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ExFilePickerActivity.this.a(file, (List<String>) new ArrayList(Collections.singletonList(str)));
            }
        }).a().show();
    }

    /* access modifiers changed from: private */
    public void a(File file, List<String> list) {
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        ExFilePickerResult exFilePickerResult = new ExFilePickerResult(absolutePath, list);
        Intent intent = new Intent();
        intent.putExtra("RESULT", exFilePickerResult);
        setResult(-1, intent);
        finish();
    }

    private void e() {
        this.k.getMenu().findItem(R.id.ok).setVisible(this.f46135h == a.C0777a.DIRECTORIES);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r0.isDirectory() != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File a(android.content.Intent r3) {
        /*
            r2 = this;
            java.lang.String r0 = "START_DIRECTORY"
            java.lang.String r3 = r3.getStringExtra(r0)
            if (r3 == 0) goto L_0x0020
            int r0 = r3.length()
            if (r0 <= 0) goto L_0x0020
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x0020
            boolean r3 = r0.isDirectory()
            if (r3 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 != 0) goto L_0x003f
            java.util.LinkedHashMap r3 = exfilepicker.a.d.a((android.content.Context) r2)
            int r1 = r3.size()
            if (r1 <= 0) goto L_0x003f
            java.io.File r0 = new java.io.File
            java.util.Set r3 = r3.keySet()
            java.lang.Object[] r3 = r3.toArray()
            r1 = 0
            r3 = r3[r1]
            java.lang.String r3 = (java.lang.String) r3
            r0.<init>(r3)
        L_0x003f:
            if (r0 != 0) goto L_0x0058
            java.io.File r0 = new java.io.File
            java.lang.String r3 = "/"
            r0.<init>(r3)
            java.lang.String r3 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0058
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: exfilepicker.ui.activity.ExFilePickerActivity.a(android.content.Intent):java.io.File");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("DIRECTORY_STATE", this.j.getAbsolutePath());
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
    }

    static /* synthetic */ void f(ExFilePickerActivity exFilePickerActivity) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 19) {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        } else {
            intent.setType("image/* video/*");
        }
        intent.setAction("android.intent.action.GET_CONTENT");
        exFilePickerActivity.startActivityForResult(Intent.createChooser(intent, "Select Media"), 3);
    }
}
