package com.dhinojosac.android.testmvp1;

import com.dhinojosac.android.testmvp1.events.MyEvent;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public interface Presenter {
    void onCreate();
    void onDestroy();

    void sendText(String text);

    void onEventMainThread(MyEvent event);
}
