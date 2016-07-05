package com.dhinojosac.android.testmvp1.libs;

import android.content.Context;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
