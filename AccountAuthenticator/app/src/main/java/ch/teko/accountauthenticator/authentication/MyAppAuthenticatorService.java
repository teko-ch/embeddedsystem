package ch.teko.accountauthenticator.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;


/**
 * Created by jonathan on 14.08.17.
 */

public class MyAppAuthenticatorService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        MyAppAuthenticator authenticator = new MyAppAuthenticator(this);
        return authenticator.getIBinder();
    }
}
