package toygildin.myfuture.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mainScreen = findViewById(R.id.main_screen);
        Button[] numButtons = new Button[10];
        numButtons[0] = findViewById(R.id.button_0);
        numButtons[1] = findViewById(R.id.button_1);
        numButtons[2] = findViewById(R.id.button_2);
        numButtons[3] = findViewById(R.id.button_3);
        numButtons[4] = findViewById(R.id.button_4);
        numButtons[5] = findViewById(R.id.button_5);
        numButtons[6] = findViewById(R.id.button_6);
        numButtons[7] = findViewById(R.id.button_7);
        numButtons[8] = findViewById(R.id.button_8);
        numButtons[9] = findViewById(R.id.button_9);
        for (Button numButton : numButtons) {
            numButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonClick(v);
                }
            });
        }
        Button buttonDot = findViewById(R.id.button_dot);
    }

    private void handleButtonClick(View v) {

    }
}