package android.courses.com.basiccalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mul, div, egal, period;
    static String msg;
    EditText disp, showRes;
    int op1;
    int op2;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        zero  = (Button)findViewById(R.id.button0);
        one   = (Button)findViewById(R.id.button1);
        two   = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four  = (Button)findViewById(R.id.button4);
        five  = (Button)findViewById(R.id.button5);
        six   = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine  = (Button)findViewById(R.id.button9);
        add   = (Button)findViewById(R.id.buttonPlus);
        sub   = (Button)findViewById(R.id.buttonSub);
        div   = (Button)findViewById(R.id.buttonDiv);
        mul   = (Button)findViewById(R.id.buttonMul);
        egal  = (Button)findViewById(R.id.buttonEgal);
        period = (Button)findViewById(R.id.buttonPoint);
        showRes = (EditText) findViewById(R.id.editText);

        /*
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRes.setText("0");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRes.setText("1");

            }
        });
*/
        two.setOnClickListener(this);
        //addKeyListner();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }


    public int operation(String optr, String resp){
        if(optr.equals("+")){
            op1 = Integer.parseInt(resp.split("+")[0]);
            op2 = Integer.parseInt(resp.split("+")[1]);
            op1 = op1 + op2;

        }else if(optr.equals("-")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 - op2;
            disp.setText("Result : " + Integer.toString(op1));
        }else if(optr.equals("*")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 * op2;
            disp.setText("Result : " + Integer.toString(op1));
        } else if(optr.equals("/")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 / op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
        return op1;
    }

    private void init(){
    res="";
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        egal.setOnClickListener(this);
        period.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
    String op = "";
        if(R.id.button0 == v.getId())
            res += " 0";
        if(R.id.button1 == v.getId())
            res += " 1";
        if(R.id.button2 == v.getId())
            res += " 2";
        if(R.id.button3 == v.getId())
            res += " 3";
        if(R.id.button4 == v.getId())
            res += " 4";
        if(R.id.button5 == v.getId())
            res += " 5";
        if(R.id.button6 == v.getId())
            res += " 6";
        if(R.id.button7 == v.getId())
            res += " 7";
        if(R.id.button8 == v.getId())
            res += " 8";
        if(R.id.button9 == v.getId())
            res += " 9";
        if(R.id.buttonPlus == v.getId()) {
            res += " +";
            op = "+";
        }
        if(R.id.buttonMul == v.getId()) {
            res += " *";
            op = "*";
        }
        if(R.id.buttonSub == v.getId()) {
            res += " -";
            op = "-";
        }
        if(R.id.buttonDiv == v.getId()) {
            res += " /";
            op = "/";
        }
        if(R.id.buttonPoint == v.getId())
            res += ".";
        if(R.id.buttonEgal == v.getId()) {
            int resp =  operation(op, res);
            res += " = " +resp;
        }



        showRes.setText(res);

    }
}
