package com.dhinojosac.android.testmvp1;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public interface Repository {
    void execute(String text);
    String getResult();
    void postEvent(int type, String error);
}
