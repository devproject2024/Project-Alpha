package com.alipay.mobile.nebula.io;

import androidx.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ByteArrayPool {
    private static final boolean DEBUG = H5Utils.isDebuggable(H5Utils.getContext());
    private static final String TAG = "ByteArrayPool";
    private final BytePool mBuffersFastCache = new BytePool(12);
    /* access modifiers changed from: private */
    public int mCurrentSize = 0;
    private boolean mEnabled = DEBUG;
    private final AtomicBoolean mIsTriming = new AtomicBoolean(false);
    private final int mSizeLimit;
    /* access modifiers changed from: private */
    public final Object mSizeLock = new Object();
    private int mTotallyReusedSize = 0;

    public ByteArrayPool(int i2) {
        this.mSizeLimit = i2;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            this.mEnabled = H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_enableByteArrayPool"));
        }
    }

    public byte[] getBuf(int i2) {
        byte[] bArr;
        if (!this.mEnabled) {
            return new byte[i2];
        }
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = (LinkedList) this.mBuffersFastCache.get(Integer.valueOf(i2));
        if (linkedList == null || (bArr = (byte[]) linkedList.poll()) == null) {
            if (DEBUG) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0) {
                    H5Log.d(TAG, "(debug only) new byte, use time: ".concat(String.valueOf(currentTimeMillis2)));
                }
            }
            return new byte[i2];
        }
        synchronized (this.mSizeLock) {
            this.mCurrentSize -= bArr.length;
        }
        if (DEBUG) {
            this.mTotallyReusedSize += bArr.length;
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis3 > 0) {
                H5Log.d(TAG, "(debug only) reuse pool: " + i2 + "(" + this.mTotallyReusedSize + ") use time: " + currentTimeMillis3);
            }
        }
        return bArr;
    }

    public void returnBuf(byte[] bArr) {
        if (this.mEnabled && bArr != null && bArr.length <= this.mSizeLimit) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.mSizeLock) {
                this.mCurrentSize += bArr.length;
            }
            LinkedList linkedList = (LinkedList) this.mBuffersFastCache.get(Integer.valueOf(bArr.length));
            if (linkedList == null) {
                ConcurrentLinkedList concurrentLinkedList = new ConcurrentLinkedList();
                concurrentLinkedList.offer(bArr);
                this.mBuffersFastCache.put(Integer.valueOf(bArr.length), concurrentLinkedList);
            } else {
                linkedList.offer(bArr);
            }
            trim();
            if (DEBUG) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0) {
                    H5Log.d(TAG, "(debug only) return use time: ".concat(String.valueOf(currentTimeMillis2)));
                }
            }
        }
    }

    private void trim() {
        if (!this.mIsTriming.get() && this.mCurrentSize > this.mSizeLimit) {
            this.mIsTriming.set(true);
            BytePool bytePool = this.mBuffersFastCache;
            bytePool.trimToSize(bytePool.size() / 2);
            this.mIsTriming.set(false);
        }
    }

    class BytePool extends e<Integer, LinkedList<byte[]>> {
        private BytePool(int i2) {
            super(i2);
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, Integer num, LinkedList<byte[]> linkedList, LinkedList<byte[]> linkedList2) {
            synchronized (ByteArrayPool.this.mSizeLock) {
                if (z || linkedList2 != null) {
                    int unused = ByteArrayPool.this.mCurrentSize = ByteArrayPool.this.mCurrentSize - (num.intValue() * linkedList.size());
                }
            }
        }
    }

    class ConcurrentLinkedList<T> extends LinkedList<T> {
        private ConcurrentLinkedList() {
        }

        public T poll() {
            T poll;
            synchronized (this) {
                poll = super.poll();
            }
            return poll;
        }

        public boolean offer(T t) {
            boolean offer;
            synchronized (this) {
                offer = super.offer(t);
            }
            return offer;
        }
    }
}
