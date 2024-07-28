package net.one97.paytm.dynamicModule.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.dynamicModule.DynamicModuleHelper;
import net.one97.paytm.dynamicModule.DynamicModuleLoaderListener;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.dynamicModule.test.DynamicModuleAdapter;
import net.one97.paytm.dynamicModule.test.DynamicModuleTestActivity;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleTestActivity extends PaytmActivity {
    private static final String TAG = "PlayCore";
    /* access modifiers changed from: private */
    public DynamicModuleAdapter dynamicModuleAdapter;
    /* access modifiers changed from: private */
    public DynamicModuleManager dynamicModuleManager;
    /* access modifiers changed from: private */
    public boolean isDefferedInstallEnabled;
    /* access modifiers changed from: private */
    public ArrayList<DynamicModuleItem> modulesItemArrayList;
    /* access modifiers changed from: private */
    public ArrayList<String> modulesStringArrayList;
    /* access modifiers changed from: private */
    public TextView tvStatus;

    private void log(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_dynamic_module_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) "DD Modules Controller");
        setSupportActionBar(toolbar);
        getSupportActionBar().b(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_modules);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.tvStatus = (TextView) findViewById(R.id.tv_status);
        this.modulesItemArrayList = getModulesArrayList();
        this.modulesStringArrayList = new ArrayList<>();
        Iterator<DynamicModuleItem> it2 = this.modulesItemArrayList.iterator();
        while (it2.hasNext()) {
            this.modulesStringArrayList.add(it2.next().getName());
        }
        this.dynamicModuleManager = DynamicModuleManager.getInstance();
        this.dynamicModuleAdapter = new DynamicModuleAdapter(this, this.modulesItemArrayList, new DynamicModuleAdapter.ItemClickListener() {
            public void onCheckedChangeListener(boolean z, String str) {
                if (!z) {
                    DynamicModuleTestActivity.this.dynamicModuleManager.deferredUninstall(str);
                } else if (DynamicModuleTestActivity.this.isDefferedInstallEnabled) {
                    DynamicModuleTestActivity.this.dynamicModuleManager.deferredInstall(str);
                } else {
                    DynamicModuleTestActivity.this.tvStatus.setText("Status");
                    DynamicModuleHelper.loadModuleWithBottomSheet((AppCompatActivity) DynamicModuleTestActivity.this, str, (DynamicModuleLoaderListener) new DynamicModuleLoaderListener() {
                        public final void onInstalled() {
                            DynamicModuleTestActivity.AnonymousClass1.this.lambda$onCheckedChangeListener$0$DynamicModuleTestActivity$1();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onCheckedChangeListener$0$DynamicModuleTestActivity$1() {
                DynamicModuleTestActivity.this.tvStatus.setText("Installed Successfully!");
            }
        });
        recyclerView.setAdapter(this.dynamicModuleAdapter);
        Switch switchR = (Switch) findViewById(R.id.sw_toggle_deffered_install);
        switchR.setChecked(this.isDefferedInstallEnabled);
        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = DynamicModuleTestActivity.this.isDefferedInstallEnabled = z;
            }
        });
        findViewById(R.id.btn_toggle_install_all).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (DynamicModuleTestActivity.this.isDefferedInstallEnabled) {
                    DynamicModuleTestActivity.this.dynamicModuleManager.deferredInstall((ArrayList<String>) DynamicModuleTestActivity.this.modulesStringArrayList);
                    return;
                }
                DynamicModuleTestActivity.this.tvStatus.setText("Starting install without client update");
                DynamicModuleTestActivity.this.dynamicModuleManager.startInstall((ArrayList<String>) DynamicModuleTestActivity.this.modulesStringArrayList, (Activity) DynamicModuleTestActivity.this);
            }
        });
        findViewById(R.id.btn_toggle_install_multiple).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                ArrayList access$400 = DynamicModuleTestActivity.this.modulesItemArrayList;
                for (int i2 = 0; i2 < access$400.size(); i2++) {
                    arrayList.add(((DynamicModuleItem) access$400.get(i2)).getName());
                    if (arrayList.size() == 2) {
                        break;
                    }
                }
                if (DynamicModuleTestActivity.this.isDefferedInstallEnabled) {
                    DynamicModuleTestActivity.this.dynamicModuleManager.deferredInstall((ArrayList<String>) arrayList);
                    return;
                }
                DynamicModuleTestActivity.this.tvStatus.setText("Starting install without client update");
                DynamicModuleTestActivity.this.dynamicModuleManager.startInstall((ArrayList<String>) arrayList, (Activity) DynamicModuleTestActivity.this);
            }
        });
        findViewById(R.id.btn_refresh_status).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DynamicModuleTestActivity.this.tvStatus.setText("Status");
                ArrayList unused = DynamicModuleTestActivity.this.modulesItemArrayList = DynamicModuleTestActivity.getModulesArrayList();
                DynamicModuleTestActivity.this.dynamicModuleAdapter.setNewData(DynamicModuleTestActivity.this.modulesItemArrayList);
            }
        });
    }

    public static ArrayList<DynamicModuleItem> getModulesArrayList() {
        ArrayList<String> allDynamicModulesList = DynamicModuleHelper.getAllDynamicModulesList();
        ArrayList<DynamicModuleItem> arrayList = new ArrayList<>();
        Iterator<String> it2 = allDynamicModulesList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            DynamicModuleItem dynamicModuleItem = new DynamicModuleItem(next);
            dynamicModuleItem.setInstalled(DynamicModuleManager.getInstance().isInstalled(next));
            arrayList.add(dynamicModuleItem);
        }
        return arrayList;
    }

    private void toastAndLog(String str) {
        this.tvStatus.setText(str);
        log(str);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
