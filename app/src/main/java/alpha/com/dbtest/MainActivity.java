package alpha.com.dbtest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String SharedPreference = "MyFile";
    int count = 0;
    private TextView myText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences(SharedPreference, MODE_PRIVATE);
        int countReturned;

        countReturned = prefs.getInt("count", 0); //0 is the default value.
        TextView textView = (TextView) findViewById(R.id.countView);
        textView.setText(String.valueOf(countReturned));

    }
    public void advanceView(View view) {

        TextView textView = (TextView) findViewById(R.id.countView);
        textView.setText(String.valueOf(advanceFn()));

    }

    public void saveCountFn(View view) {

        SharedPreferences.Editor editor = getSharedPreferences(SharedPreference, MODE_PRIVATE).edit();
        editor.putInt("count", count);
        editor.apply();
    }



    private int advanceFn() {

        count++;
        return count;
    }



}
