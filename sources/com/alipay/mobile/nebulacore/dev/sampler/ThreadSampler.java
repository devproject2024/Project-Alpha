package com.alipay.mobile.nebulacore.dev.sampler;

import com.alibaba.a.e;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class ThreadSampler extends AbstractSampler {
    private final e mResultCache = new e();

    public ThreadSampler(long j) {
        super(j);
    }

    /* access modifiers changed from: package-private */
    public e doSample() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup threadGroup2 = threadGroup;
        while (threadGroup != null) {
            threadGroup2 = threadGroup;
            threadGroup = threadGroup.getParent();
        }
        Thread[] threadArr = new Thread[(threadGroup2.activeCount() * 2)];
        int enumerate = threadGroup2.enumerate(threadArr);
        Thread[] threadArr2 = new Thread[enumerate];
        System.arraycopy(threadArr, 0, threadArr2, 0, enumerate);
        this.mResultCache.put(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, (Object) Integer.valueOf(threadArr2.length));
        return this.mResultCache;
    }
}
