package com.eposp.aidlserviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import eeepay.androidmorefunctiondemo.util.IRemoteServiceCallback;
import eeepay.androidmorefunctiondemo.util.Ieeepay;

public class MyIntentService extends IntentService {
	Integer lock = 0;
	static String yinsheng = null;
	public static IRemoteServiceCallback mIRemoteServiceCallback = null;
	public static int myCallpid=0x01;
	public static String strTn;

	public MyIntentService() {
		super("myIntentService");
	}

	public MyIntentService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		System.out.println("onHandleIntent");
	}

	/**
	 * 
	 */
	@Override
	public IBinder onBind(Intent intent) {

		if (Ieeepay.class.getName().equals(intent.getAction())) {
			return mBinder3;
		}
		return null;
	}

	/**
	 * 
	 */
	private final Ieeepay.Stub mBinder3 = new Ieeepay.Stub() {

		@Override
		public void unregisterCallback(
				IRemoteServiceCallback paramIRemoteServiceCallback)
				throws RemoteException {
			mIRemoteServiceCallback=null;
		}

		@Override
		public String test() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void registerCallback(
				IRemoteServiceCallback paramIRemoteServiceCallback)
				throws RemoteException {
			yinsheng = null;
			myCallpid=getCallingPid();
			mIRemoteServiceCallback = paramIRemoteServiceCallback;
			mIRemoteServiceCallback.startActivity("com.eposp.aidlserviceapp",
					"com.eposp.aidlserviceapp.MainActivity",myCallpid,
					null);

		}

		@Override
		public String Pay(String paramString) throws RemoteException {
             strTn=paramString;//json串形式
			return "success";
		}
	};
}
