package com.example.harinie.calculator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Resources res;

    private EditText mEditTxt;
    private TextView mResTxt;

    private Button mOne;
    private Button mTwo;
    private Button mThree;
    private Button mFour;
    private Button mFive;
    private Button mSix;
    private Button mSeven;
    private Button mEight;
    private Button mNine;
    private Button mZero;
    private Button mDot;

    private Button mAdd;
    private Button mSubtract;
    private Button mMultiply;
    private Button mDivide;
    private Button mPercentage;
    private Button mEqualTo;

    private Button mClear;
    private Button mBackspace;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        /*
           Disable the soft keyboard that automatically pops up from the edit text view when clicked
           by using InputMethodManager (imm)
         */

        mEditTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnOne)));
                adjustCursor();
            }
        });

        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnTwo)));
                adjustCursor();
            }
        });

        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnThree)));
                adjustCursor();
            }
        });

        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnFour)));
                adjustCursor();
            }
        });

        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnFive)));
                adjustCursor();
            }
        });

        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnSix)));
                adjustCursor();
            }
        });

        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnSeven)));
                adjustCursor();
            }
        });

        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnEight)));
                adjustCursor();
            }
        });

        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnNine)));
                adjustCursor();
            }
        });

        mZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnZero)));
                adjustCursor();
            }
        });

        mDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnDot);
                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    adjustCursor();
                }
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.add);
                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    setFontColor(symbol);
                    adjustCursor();
                }
            }
        });

        mSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.subtract);
                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    setFontColor(symbol);
                    adjustCursor();
                }
            }
        });

        mMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.multiply);

                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    setFontColor(symbol);
                    adjustCursor();
                }
            }
        });

        mDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.divide);

                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    setFontColor(symbol);
                    adjustCursor();
                }
            }
        });

        mPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.percentage);

                if (checkSign(symbol)) {
                    mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), symbol));
                    setFontColor(symbol);
                    adjustCursor();
                }
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTxt.setText(null);
                adjustCursor();
            }
        });

        mBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence currentText = mEditTxt.getText();
                if (currentText.length() > 1) {
                    mEditTxt.setText(currentText.subSequence(0, currentText.length() - 1));
                    adjustCursor();
                } else {
                    mEditTxt.setText(null);
                    adjustCursor();
                }
            }
        });

    }

    private void initViews() {

        /* Initialising the views */

        res = getResources();

        mEditTxt = findViewById(R.id.EditTxtView);
        mResTxt = findViewById(R.id.ResTxtView);

        mOne = findViewById(R.id.BtnOne);
        mTwo = findViewById(R.id.BtnTwo);
        mThree = findViewById(R.id.BtnThree);
        mFour = findViewById(R.id.BtnFour);
        mFive = findViewById(R.id.BtnFive);
        mSix = findViewById(R.id.BtnSix);
        mSeven = findViewById(R.id.BtnSeven);
        mEight = findViewById(R.id.BtnEight);
        mNine = findViewById(R.id.BtnNine);
        mZero = findViewById(R.id.BtnZero);
        mDot = findViewById(R.id.BtnDot);

        mAdd = findViewById(R.id.BtnAdd);
        mSubtract = findViewById(R.id.BtnSubtract);
        mMultiply = findViewById(R.id.BtnMultiply);
        mDivide = findViewById(R.id.BtnDivide);
        mPercentage = findViewById(R.id.BtnPercentage);
        mEqualTo = findViewById(R.id.BtnEqualTo);

        mClear = findViewById(R.id.BtnClear);
        mBackspace = findViewById(R.id.BtnBackspace);

    }

    private void adjustCursor() {

        /* Setting the cursor position always to be at the end of the expression */

        mEditTxt.setSelection(mEditTxt.getText().length());
    }

    private void setFontColor(String symbol){

        /*  Setting the color of math symbols to the primary color of the app */

        String currentText = mEditTxt.getText().toString();
        Spannable letterToSpan = new SpannableString(currentText);
        letterToSpan.setSpan(new ForegroundColorSpan(res.getColor(R.color.colorPrimary)),currentText.length()-1,currentText.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mEditTxt.setText(letterToSpan);
    }

    private boolean checkSign(String symbol) {

        /* To check what symbol the user have pressed and handle accordingly */

        CharSequence currentText = mEditTxt.getText();
        if ((currentText.length() == 0) && symbol.equals(res.getString(R.string.btnDot))) {
            mEditTxt.setText(res.getString(R.string.btnZero));
            return true;
        } else if (currentText.length() > 0) {
            String endString = currentText.subSequence(currentText.length() - 1, currentText.length()).toString();

            if (endString.endsWith(symbol)) {
                return false;
            } else if ((symbol.equals(res.getString(R.string.btnDot))) && endString.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]")) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnZero)));
                return true;
            } else if ((symbol.equals(res.getString(R.string.btnDot))) && endString.matches("\\d")) {
                /* No two dots allowed in a number */
                String[] data = currentText.toString().split("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]");
                String currentExp = data[data.length - 1];
                if (currentExp.contains(".")) {
                    return false;
                }
            } else if (symbol.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]") && endString.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]")) {
                mEditTxt.setText(currentText.subSequence(0, currentText.length() - 1));
                return true;
            }else if (symbol.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]") && endString.matches("[.]")) {
                mEditTxt.setText(getString(R.string.input_numbr,mEditTxt.getText().toString(), res.getString(R.string.btnZero)));
                return true;
            }

        } else {
            return false;
        }

        return true;
    }

}