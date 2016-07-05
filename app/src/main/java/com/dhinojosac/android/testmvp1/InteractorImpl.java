package com.dhinojosac.android.testmvp1;

/**
 * Created by negro-PC on 05-Jul-16.
 */
public class InteractorImpl implements Interactor{
    private Repository repository;

    public InteractorImpl() {
        this.repository = new RepositoryImpl();
    }

    @Override
    public void sendText(String text) {
        repository.execute(text);
    }

    @Override
    public String getText() {
        return repository.getResult();
    }
}
