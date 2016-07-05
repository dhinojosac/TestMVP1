package com.dhinojosac.android.testmvp1;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public interface MainView {
    void showProgress();
    void hideProgress();

    void enableInputs();
    void disableInputs();

    void resetInput();

    void showAnswer(String text);
}
