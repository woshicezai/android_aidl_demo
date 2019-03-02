package com.example.hll_mall.myaidldemoserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    IMyAidlInterface.Stub mStub = new IMyAidlInterface.Stub() {

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Log.d("测试", "onTransact");
            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public int add(int arg1, int arg2) throws RemoteException {
            Log.d("测试", "add");
            return arg1 + arg2;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mStub;
    }
}
