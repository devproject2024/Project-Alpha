package com.paytm.android.chat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.d;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.f.a;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.view.c;
import com.paytm.utility.q;
import com.sendbird.android.SendBirdException;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.d.g;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChangeProfilePicActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    d f41580a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f41581b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    String f41582c = "";

    /* renamed from: d  reason: collision with root package name */
    File f41583d;

    /* renamed from: e  reason: collision with root package name */
    RecyclerView f41584e;

    /* renamed from: f  reason: collision with root package name */
    private final int f41585f = 3;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_change_profile_pic);
        this.f41584e = (RecyclerView) findViewById(R.id.change_profile_pic_rv);
        this.f41584e.setLayoutManager(new GridLayoutManager(this, 3));
        Toolbar toolbar = (Toolbar) findViewById(R.id.change_profile_pic_toolbar);
        toolbar.setTitle(R.string.chat_module_profile_change_pic);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().e(R.drawable.chat_ic_back_arrow);
        }
        this.f41581b.add("addpic");
        this.f41582c = SharedPreferencesUtil.getProfileImg() != null ? SharedPreferencesUtil.getProfileImg() : "";
        this.f41581b.add(this.f41582c);
        this.f41580a = new d(this, this.f41581b);
        this.f41580a.f41054a = new d.a() {
            public final void a(int i2) {
                if (i2 == 0) {
                    ChangeProfilePicActivity changeProfilePicActivity = ChangeProfilePicActivity.this;
                    Toast.makeText(changeProfilePicActivity, changeProfilePicActivity.getResources().getString(R.string.chat_module_add_new_profile_picture), 0).show();
                    new c(ChangeProfilePicActivity.this, new c.a() {
                        public final void a(int i2) {
                            Uri uri;
                            if (i2 == 0) {
                                a.b((Activity) ChangeProfilePicActivity.this);
                            } else if (i2 == 1) {
                                ChangeProfilePicActivity changeProfilePicActivity = ChangeProfilePicActivity.this;
                                File file = new File(Build.VERSION.SDK_INT >= 24 ? changeProfilePicActivity.getFilesDir() : Environment.getExternalStorageDirectory(), "Pictures/");
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                changeProfilePicActivity.f41583d = new File(file, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg");
                                if (Build.VERSION.SDK_INT < 23 || changeProfilePicActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
                                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        String a2 = a.a((Context) changeProfilePicActivity);
                                        ChangeProfilePicActivity.class.getSimpleName();
                                        q.a("----authority=" + a2 + ",new_file=" + changeProfilePicActivity.f41583d.getAbsolutePath());
                                        uri = FileProvider.getUriForFile(changeProfilePicActivity, a2, changeProfilePicActivity.f41583d);
                                    } else {
                                        uri = Uri.fromFile(changeProfilePicActivity.f41583d);
                                    }
                                    intent.putExtra("output", uri);
                                    intent.addFlags(2);
                                    if (Build.VERSION.SDK_INT < 21) {
                                        for (ResolveInfo resolveInfo : changeProfilePicActivity.getPackageManager().queryIntentActivities(intent, 65536)) {
                                            changeProfilePicActivity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
                                        }
                                    }
                                    changeProfilePicActivity.startActivityForResult(intent, 300);
                                    return;
                                }
                                changeProfilePicActivity.requestPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
                            }
                        }
                    }).show();
                    return;
                }
                ChangeProfilePicActivity changeProfilePicActivity2 = ChangeProfilePicActivity.this;
                Toast.makeText(changeProfilePicActivity2, ChangeProfilePicActivity.this.getResources().getString(R.string.chat_module_change_pic_to_pos) + i2, 0).show();
                if (ChangeProfilePicActivity.this.f41581b.get(i2).equals(ChangeProfilePicActivity.this.f41582c)) {
                    ChangeProfilePicActivity changeProfilePicActivity3 = ChangeProfilePicActivity.this;
                    Toast.makeText(changeProfilePicActivity3, changeProfilePicActivity3.getResources().getString(R.string.chat_module_set_profile_picture_success), 0).show();
                    ChangeProfilePicActivity.this.setResult(-1);
                    ChangeProfilePicActivity.this.finish();
                    return;
                }
                ChangeProfilePicActivity changeProfilePicActivity4 = ChangeProfilePicActivity.this;
                ChatManager.b().f40994f.updateCurrentUserProfileImage(new File(changeProfilePicActivity4.f41581b.get(i2))).a(new io.reactivex.rxjava3.d.a(new File(changeProfilePicActivity4.f41581b.get(i2))) {
                    private final /* synthetic */ File f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ChangeProfilePicActivity.this.a(this.f$1);
                    }
                }, new g() {
                    public final void accept(Object obj) {
                        ChangeProfilePicActivity.this.a((Throwable) obj);
                    }
                });
            }
        };
        this.f41584e.setAdapter(this.f41580a);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(File file) throws Throwable {
        Toast.makeText(this, getResources().getString(R.string.chat_module_set_profile_picture_success), 0).show();
        this.f41582c = file.getAbsolutePath();
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Throwable th) throws Throwable {
        if (th instanceof SendBirdException) {
            SendBirdException sendBirdException = (SendBirdException) th;
            Toast.makeText(this, sendBirdException.getCode() + AppConstants.COLON + sendBirdException.getMessage(), 0).show();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 300 && i3 == -1) {
            List<String> list = this.f41581b;
            if (list != null) {
                list.add(1, this.f41583d.getAbsolutePath());
            }
            if (this.f41581b.size() > 8) {
                for (int size = this.f41581b.size() - 1; size > 7; size--) {
                    this.f41581b.remove(size);
                }
            }
            d dVar = this.f41580a;
            if (dVar != null) {
                dVar.notifyDataSetChanged();
            }
        } else if (i2 == 304 && i3 == -1) {
            a.b(intent);
            List<String> c2 = a.c(intent);
            if (this.f41581b != null) {
                for (String next : c2) {
                    q.a("media path:[" + next + "]");
                    this.f41581b.add(1, next);
                }
                if (this.f41581b.size() > 8) {
                    for (int size2 = this.f41581b.size() - 1; size2 > 7; size2--) {
                        this.f41581b.remove(size2);
                    }
                }
            }
            d dVar2 = this.f41580a;
            if (dVar2 != null) {
                dVar2.notifyDataSetChanged();
            }
        }
    }
}
