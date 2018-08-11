package com.example.harinie.calculator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    private Thread textClearer;
    private Thread editTxtColorFlasher;
    private Thread resTxtColorFlasher;

    private Pattern pattern = Pattern.compile("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        /*
           Disable the soft keyboard that automatically pops up from the edit text view when clicked or touched
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

        mEditTxt.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
            }
        });


        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnOne);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnTwo);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnThree);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnFour);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnFive);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnSix);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnSeven);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnEight);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnNine);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnZero);

                if (checkDigit()) {
                    displayText(symbol);
                }
            }
        });

        mDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.btnDot);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.add);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.subtract);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.multiply);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.divide);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symbol = res.getString(R.string.percentage);

                if (checkSign(symbol)) {
                    displayText(symbol);
                }
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtColorFlasher.start();
                resTxtColorFlasher.start();
                textClearer.start();
            }
        });

        mBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence currentText = mEditTxt.getText();
                CharSequence resTxt = mResTxt.getText();
                if (resTxt.length() > 0 || currentText.length() == 0) {
                    mEditTxt.setText(null);
                    mResTxt.setText(null);
                } else if (currentText.length() > 1) {
                    mEditTxt.setText(currentText.subSequence(0, currentText.length() - 1));
                }
                adjustCursor();
            }
        });

        mEqualTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeInput();
            }
        });

        textClearer = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEditTxt.setText(null);
                        mResTxt.setText(null);
                        adjustCursor();
                    }
                });
            }
        });

        editTxtColorFlasher = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        changeBackgroundColor(mEditTxt);
                    }
                });
            }
        });

        resTxtColorFlasher = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        changeBackgroundColor(mResTxt);
                    }
                });
            }
        });

    }


    /**
     * Initialising the views
     */

    private void initViews() {

        res = getResources();

        mEditTxt = findViewById(R.id.EditTxtView);
        mResTxt = findViewById(R.id.ResTxtView);

        mEditTxt.addTextChangedListener(textWatcher);

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


    /**
     * Setting the cursor position always to be at the end of the expression
     */

    private void adjustCursor() {
        mEditTxt.setSelection(mEditTxt.getText().length());
    }


    /**
     * Check the length of the characters in Edit Text and
     * Send vibrating Toast if max character limit reached
     * <p>
     * Color the MATH symbols  with primary color of the app using regex
     */

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String currentText = mEditTxt.getText().toString();

            if (currentText.length() >= 50) {
                mEditTxt.setText(currentText.subSequence(0, currentText.length() - 1));
                new VibratingToast(MainActivity.this, "Max word length reached", Toast.LENGTH_SHORT);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Matcher matcher = pattern.matcher(editable.toString());

            while (matcher.find()) {
                char previousInput = editable.toString().charAt(matcher.start() - 1);
                if (!Character.toString(previousInput).matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]")) {
                    editable.setSpan(new ForegroundColorSpan(res.getColor(R.color.colorPrimary)), matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    };


    /**
     * Display the text in Edit Text
     *
     * @param symbol to be appended to the Edit Text
     */

    private void displayText(String symbol) {
        mEditTxt.setText(getString(R.string.input_numbr, mEditTxt.getText().toString(), symbol));
        adjustCursor();
    }


    /**
     * To check what symbol the user have pressed
     * how the Result text view and edit text view state is and handle accordingly
     *
     * @param symbol is the input math symbol pressed by user for handling
     * @return boolean to decide whether the symbol to be displayed in UI or not
     */

    private boolean checkSign(String symbol) {

        String currentText = mEditTxt.getText().toString();
        String resTxt = mResTxt.getText().toString();


        if (resTxt.length() == 0) {

            if ((currentText.length() == 0) && !(symbol.equals(res.getString(R.string.percentage)))) {
                mEditTxt.setText(res.getString(R.string.btnZero));
            } else if (currentText.length() > 0) {
                String endString = currentText.subSequence(currentText.length() - 1, currentText.length()).toString();

                if (endString.endsWith(symbol)) {
                    return false;
                } else if ((symbol.equals(res.getString(R.string.btnDot))) && endString.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]")) {
                    mEditTxt.setText(getString(R.string.input_numbr, mEditTxt.getText().toString(), res.getString(R.string.btnZero)));
                } else if ((symbol.equals(res.getString(R.string.btnDot))) && endString.matches("\\d")) {
                    /* No two dots allowed in a number */
                    String[] data = currentText.split("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]");
                    String currentExp = data[data.length - 1];
                    return !currentExp.contains(".");
                } else if (symbol.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]") && endString.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]")) {

                    if (symbol.matches("[\\u002D]") && endString.matches("[\\u00D7\\u00F7\\u0025]")) {
                        return true;
                    } else if (symbol.matches("[\\u002B\\u00D7\\u00F7\\u0025]") && currentText.matches("^.*[\\u002B\\u002D\\u00D7\\u00F7\\u0025]{2}$")) {
                        mEditTxt.setText(currentText.subSequence(0, currentText.length() - 2));
                    } else {
                        mEditTxt.setText(currentText.subSequence(0, currentText.length() - 1));
                    }

                } else if (symbol.matches("[\\u002B\\u002D\\u00D7\\u00F7\\u0025]") && endString.matches("[.]")) {
                    mEditTxt.setText(getString(R.string.input_numbr, mEditTxt.getText().toString(), res.getString(R.string.btnZero)));
                }

            } else {
                return false;
            }

        } else {
            if (symbol.equals(res.getString(R.string.btnDot))) {
                mEditTxt.setText(R.string.btnZero);
            } else {
                mEditTxt.setText(resTxt);
            }
            mResTxt.setText(null);
        }

        return true;
    }


    /**
     * To display the digits pressed considering both the views
     *
     * @return boolean to display in UI
     */

    private boolean checkDigit() {
        String resTxt = mResTxt.getText().toString();

        if (resTxt.length() > 0) {
            mEditTxt.setText(null);
            mResTxt.setText(null);
        }
        return true;
    }


    /**
     * Computing the input entered by the User when Equal to button is clicked.
     * The text from Edit Text is properly corrected for preventing Exceptions
     * The result is set in Result Text View after formatting.
     */

    private void computeInput() {
        String input = mEditTxt.getText().toString();

        if (input.length() > 0) {
            try {
                String parsedInput = makeStringProper(input);
                Expression expression = new ExpressionBuilder(parsedInput).build();
                double result = expression.evaluate();
                mResTxt.setText(formatResult(result));
            } catch (ArithmeticException e) {
                mResTxt.setText(R.string.btnZero);
            } catch (Exception e) {
                mResTxt.setText(R.string.btnZero);
            }
        }
    }


    /**
     * To make the input expression proper to get it evaluated
     * Since Expression builder doesn't parse the unicode multiply and divide signs,
     * they are replaced with '*' and '/' respectively.
     * If the user pressed any MATH symbol and pressed Equal to button, it throws Exception.
     * To avoid this, the input String has been sliced and returned.
     *
     * @param input is the input expression from Edit text view.
     * @return the parsedInput to be evaluated.
     */

    private static String makeStringProper(String input) {
        String parsedInput = input.replaceAll("\\u00D7", "*").replaceAll("\\u00F7", "/");

        if (!Character.isDigit(parsedInput.charAt(parsedInput.length() - 1))) {
            parsedInput = parsedInput.substring(0, parsedInput.length() - 1);
        }
        return parsedInput;
    }


    /**
     * To format the result accordingly
     *
     * @param result is the double to be formatted
     * @return the formatted string to be displayed in UI
     */

    private String formatResult(double result) {

        DecimalFormat decimalFormat;

        decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setMaximumFractionDigits(5);
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        if (Double.toString(result).length() >= 15) {
            if (Double.toString(result).matches("^.*E\\d*$")) {
                decimalFormat = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            } else {
                decimalFormat = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            }
        }

        return decimalFormat.format(result);
    }


    /**
     * To change the background color of the views for a small duration
     * showing all clear action performed
     *
     * @param view is the view for which background color will be changed
     */

    private void changeBackgroundColor(View view) {

        ObjectAnimator animator = ObjectAnimator.ofInt(view, "backgroundColor", R.color.colorPrimary, android.R.color.transparent);
        animator.setDuration(25);
        animator.setRepeatCount(2);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

    }

}