package com.dhinojosac.android.testmvp1;

import android.os.Handler;

import com.dhinojosac.android.testmvp1.events.MyEvent;
import com.dhinojosac.android.testmvp1.libs.EventBus;
import com.dhinojosac.android.testmvp1.libs.GreenRobotEventBus;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public class RepositoryImpl implements Repository{
    private String result;
    private static final int TIME = 1000;

    @Override
    public void execute(final String text) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Task(text);
            }
        }, 1000);
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void postEvent(int type, String error) {
        MyEvent event = new MyEvent();
        event.setEventType(type);
        event.setError(error);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }
    public void postEvent(int type) {
        MyEvent event = new MyEvent();
        event.setEventType(type);
        event.setError(null);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }

    public void Task(String text){
        result=text.toUpperCase();
        postEvent(MyEvent.ON_SUCCESS);
    }


}
