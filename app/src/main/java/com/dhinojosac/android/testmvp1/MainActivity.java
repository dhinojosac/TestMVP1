package com.dhinojosac.android.testmvp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @Bind(R.id.btnStart)
    Button btnStart;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.textViewResult)
    TextView textViewResult;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new PresenterImpl(this);
        presenter.onCreate();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void enableInputs() {
        btnStart.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        btnStart.setEnabled(false);
    }

    @Override
    public void resetInput() {
        editText.setText("");
    }

    @Override
    public void showAnswer(String text) {
        textViewResult.setText(text);
    }

   @OnClick(R.id.btnStart)
    public void sendText(View v) {
        if(editText.length()>0) {
            String text = editText.getText().toString();
            Log.d("text-Main", text.toString());
            presenter.sendText(text);
        }else {
            Toast.makeText(this,"Tiene que ingresar texto",Toast.LENGTH_SHORT).show();
            Log.d("EmptyText", "Sin valor en editText");
        }
    }
}
