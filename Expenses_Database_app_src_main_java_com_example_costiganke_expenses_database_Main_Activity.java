package com.example.costiganke.expenses_database;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;


public class Main_Activity extends Activity {
    EditText dateTxt, amountTxt, categoryTxt, subcategoryTxt,
    descriptionTxt, volumeTxt, weightTxt, caloriesTxt, payeeTxt,
    distanceTxt;
    List<Expense>Expenses = new ArrayList<>();
    ListView expenseListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        dateTxt = (EditText) findViewById(R.id.txtName);
        amountTxt = (EditText) findViewById(R.id.txtName);
        categoryTxt = (EditText) findViewById(R.id.txtName);
        subcategoryTxt = (EditText) findViewById(R.id.txtName);
        descriptionTxt = (EditText) findViewById(R.id.txtName);
        volumeTxt = (EditText) findViewById(R.id.txtName);
        weightTxt = (EditText) findViewById(R.id.txtName);
        caloriesTxt = (EditText) findViewById(R.id.txtName);
        payeeTxt = (EditText) findViewById(R.id.txtName);
        distanceTxt = (EditText) findViewById(R.id.txtName);
        expenseListView = (ListView) findViewById(R.id.listview);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabExpenseList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener((view) (
                        Expenses.add(new Expense(0, dateTxt.getText().toString(), amountTxt.getText().toString(), categoryTxt.getText().toString(),
                                        subcategoryTxt.getText().toString(), descriptionTxt.getText().toString(), volumeTxt.getText().toString(),
                                        weightTxt.getText().toString(),caloriesTxt.getText().toString(), payeeTxt.getText().toString(),
                                        distanceTxt.getText().toString());
                                        populateList();
        Toast.makeText(getApplicationContext(),amountTxt.getText().toString() + "Has been added to your Expenses!",Toast.LENGTH_SHORT).show();


    })

    dateTxt.addTextChangedListener(new TextWatcher(){
        @Override
                public void beforeTextChanged(CharSequence charSequence, int 1, int 12, int 13){

        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
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
}
