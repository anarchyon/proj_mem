package toygildin.myfuture.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainScreen;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
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
            numButton.setOnClickListener(this::handleNumButtonClick);
        }
        Button buttonDot = findViewById(R.id.button_dot);
        findViewById(R.id.button_plus).setOnClickListener(this::handlePlusButton);
        findViewById(R.id.button_minus).setOnClickListener(this::handleMinusButton);
        findViewById(R.id.button_divide).setOnClickListener(this::handleDivideButton);
        findViewById(R.id.button_multiply).setOnClickListener(this::handleMultiplyButton);
        Button buttonEquals = findViewById(R.id.button_equals);
        buttonEquals.setOnClickListener(this::handleEqualsButton);
    }

    private void handleMultiplyButton(View multiplyButton) {
        calculator.setOperator(Calculator.MULTIPLY);
        mainScreen.setText(calculator.getTextForScreen());
    }

    private void handleDivideButton(View divideButton) {
        calculator.setOperator(Calculator.DIVIDE);
        mainScreen.setText(calculator.getTextForScreen());
    }

    private void handleMinusButton(View minusButton) {
        calculator.setOperator(Calculator.MINUS);
        mainScreen.setText(calculator.getTextForScreen());
    }

    private void handlePlusButton(View plusButton) {
        calculator.setOperator(Calculator.PLUS);
        mainScreen.setText(calculator.getTextForScreen());
    }

    private void handleEqualsButton(View equalsButton) {
        calculator.calculate();
        mainScreen.setText(calculator.getResultString());
    }

    private void handleNumButtonClick(View numButton) {
        String digit = ((Button)numButton).getText().toString();
        calculator.addDigitToOperand(digit);
        mainScreen.setText(calculator.getTextForScreen());
    }
}