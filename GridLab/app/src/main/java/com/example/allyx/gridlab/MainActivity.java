package com.example.allyx.gridlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.allyx.gridlab.baseclasses.ManageNumberAdapter;
import com.example.allyx.gridlab.baseclasses.FileClassManagement;
import com.example.allyx.gridlab.baseclasses.Numbers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    int nbCorrectAns=0, nbNotCorrentAns=0;

    ArrayList<Numbers> listOfNumbers;
    //ArrayAdapter<Numbers> gridViewAdapter;
    ManageNumberAdapter gridViewAdapter;

    GridView gridViewListOfNumbers;
    EditText txtResult;
    TextView viewScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        gridViewListOfNumbers =
                (GridView)findViewById(R.id.gridViewListOfNumbers);
        listOfNumbers =
                FileClassManagement.readFile(this,"questions.txt");
        gridViewAdapter =
                new ManageNumberAdapter(this,listOfNumbers);
        gridViewListOfNumbers.setOnItemClickListener(this);

        txtResult = (EditText) findViewById(R.id.editTextResult);

        viewScore = (TextView) findViewById(R.id.textViewScore);

        /*gridViewAdapter =
          new ArrayAdapter<Numbers>
                  (this,R.layout.one_element,
                          listOfNumbers);*/
        gridViewListOfNumbers.setAdapter(gridViewAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == 4 || position == 9 || position == 14 || position == 19 || position == 24) {

            String ans = txtResult.getText().toString();
            Numbers oneNumber = new Numbers(ans);
            listOfNumbers.set(position, oneNumber);
            gridViewAdapter.notifyDataSetChanged();
            int correctAns, num1,num2;

            switch (position){
                case 4:
                    num1 = Integer.valueOf(listOfNumbers.get(0).toString());
                    num2 = Integer.valueOf(listOfNumbers.get(2).toString());
                    break;
                case 9:
                    num1 = Integer.valueOf(listOfNumbers.get(5).toString());
                    num2 = Integer.valueOf(listOfNumbers.get(7).toString());
                    break;
                case 14:
                    num1 = Integer.valueOf(listOfNumbers.get(10).toString());
                    num2 = Integer.valueOf(listOfNumbers.get(12).toString());
                    break;
                case 19:
                    num1 = Integer.valueOf(listOfNumbers.get(15).toString());
                    num2 = Integer.valueOf(listOfNumbers.get(17).toString());
                    break;
                default:
                    num1 = Integer.valueOf(listOfNumbers.get(20).toString());
                    num2 = Integer.valueOf(listOfNumbers.get(22).toString());

            }


            correctAns = num1 * num2;

            String str="";

               int userAns = Integer.valueOf(ans);

                if (correctAns == userAns){
                    nbCorrectAns++;
                }
                else {
                    nbNotCorrentAns++;

                }

                    if (position==24) {
                        computeScore(nbCorrectAns, nbNotCorrentAns, str);
                    }

            }



        }

    private void computeScore(int nbCorrectAns, int nbNotCorrentAns, String str) {
        int total = 5;

        float percCorrenct, percNotCorrect;

        percCorrenct = ((float) nbCorrectAns / (float)total)*100;
        percNotCorrect = ((float) nbNotCorrentAns / (float)total)*100;
        str = str + String.valueOf(percCorrenct)+ "% Correct Answer \n"+
                String.valueOf(percNotCorrect) + "% Wrong Answer ";

        viewScore.setText(str);

    }

    }
