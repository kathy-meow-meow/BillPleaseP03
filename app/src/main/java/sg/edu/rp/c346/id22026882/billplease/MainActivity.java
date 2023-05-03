package sg.edu.rp.c346.id22026882.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText billAmt;
    EditText disAmt;
    ToggleButton svsTogButton;
    ToggleButton gstTogButton;
    EditText paxAmt;
    RadioButton radioCashButton;
    RadioButton radioPaynowButton;
    Button calAmt;
    Button resetBttn;
    TextView finalB;
    TextView perpaxB;
    EditText paynowNum;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billAmt = findViewById(R.id.editAmt);
        disAmt = findViewById(R.id.discountAmt);
        svsTogButton = findViewById(R.id.svsTogButton);
        gstTogButton = findViewById(R.id.gstTogButton);
        paxAmt = findViewById(R.id.editPax);
        radioCashButton = findViewById(R.id.cashButton);
        radioPaynowButton = findViewById(R.id.paynowButton);
        calAmt = findViewById(R.id.calculateButton);
        resetBttn = findViewById(R.id.resetButton);
        finalB = findViewById(R.id.finalBill);
        perpaxB = findViewById(R.id.perPaxBill);
        paynowNum = findViewById(R.id.editPaynowNum);


        radioCashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paynowNum.setEnabled(false);
            }
        });

        radioPaynowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paynowNum.setEnabled(true);
            }
        });

        calAmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float fBill = -(billAmt.getInputType());
                float billChange = disAmt.getInputType();
                if (svsTogButton.isChecked()==true){
                    if(gstTogButton.isChecked()==true){
                        billChange = billChange + 17;
                    }else{
                        billChange = billChange +10;
                    }
                }else if( gstTogButton.isChecked()==true){
                    billChange = billChange + 7;
                }

                fBill = fBill + (billChange/100);

                String stringRes = finalB + " $" + fBill;

                String perPaxRes = perpaxB + " $" + (fBill/paxAmt.getInputType());
            }
        });



    }
}