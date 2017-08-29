package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainTestActivity extends MainActivity {

    private TestCallback callback;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        message = (TextView) findViewById(R.id.instructions_text_view);
        message.setText("Testing Flavour");
    }

    public interface TestCallback {
        void onResponse(String joke);
    }

    public void setTestCallback(TestCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onJokeReceived(String joke) {
        if (callback != null) callback.onResponse(joke);
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }

}
