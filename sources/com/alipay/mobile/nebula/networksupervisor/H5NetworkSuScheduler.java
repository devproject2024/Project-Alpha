package com.alipay.mobile.nebula.networksupervisor;

import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H5NetworkSuScheduler {
    private static volatile H5NetworkSuScheduler sInstance;
    private List<H5NetworkSuEntity> entityList = new ArrayList();
    private Executor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(200), new H5ThreadPoolFactory.H5SingleThreadFactory("H5_SingleThreadExecutor_for_NetworkSupervisor"), new H5ThreadPoolFactory.DiscardOldestPolicy());

    private H5NetworkSuScheduler() {
    }

    public static H5NetworkSuScheduler getInstance() {
        if (sInstance == null) {
            synchronized (H5NetworkSuScheduler.class) {
                if (sInstance == null) {
                    sInstance = new H5NetworkSuScheduler();
                }
            }
        }
        return sInstance;
    }

    public void post(H5NetworkSuEntity h5NetworkSuEntity) {
        synchronized (this.entityList) {
            this.entityList.add(h5NetworkSuEntity);
        }
    }

    public void exec() {
        H5NetworkSupervisor h5NetworkSupervisor = (H5NetworkSupervisor) H5Utils.getH5ProviderManager().getProvider(H5NetworkSupervisor.class.getName());
        if (h5NetworkSupervisor != null) {
            execInternal(h5NetworkSupervisor);
        }
    }

    private void execInternal(final H5NetworkSupervisor h5NetworkSupervisor) {
        synchronized (this.entityList) {
            if (!this.entityList.isEmpty()) {
                final ArrayList arrayList = new ArrayList(this.entityList);
                this.entityList.clear();
                this.executor.execute(new Runnable() {
                    public void run() {
                        for (H5NetworkSuEntity h5NetworkSuEntity : arrayList) {
                            if (h5NetworkSuEntity != null) {
                                if (h5NetworkSuEntity instanceof H5NetworkSuRequest) {
                                    h5NetworkSupervisor.onSendReq((H5NetworkSuRequest) h5NetworkSuEntity);
                                } else {
                                    h5NetworkSupervisor.onReceiveRsp((H5NetworkSuResponse) h5NetworkSuEntity);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
