package com.excelreader.activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.excelreader.R;
import com.excelreader.adapters.DummyDataListRecycleViewAdapter;
import com.excelreader.models.DummyData;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;
import com.yuyh.jsonviewer.library.JsonRecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final private String TAG = "MainActivity.class";

    ArrayList<DummyData> listOfData = new ArrayList<>();

    private ExtendedFloatingActionButton startParsingButton;
    private ExtendedFloatingActionButton startParsingForList;
    private ExtendedFloatingActionButton backButton;

    private RecyclerView recyclerView;

    private DummyDataListRecycleViewAdapter adapter;

    private ProgressDialog progressDialog;

    private JsonRecyclerView jsonRecyclerView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startParsingButton = findViewById(R.id.startParsingButton);
        startParsingForList = findViewById(R.id.startParsingButtonList);
        recyclerView = findViewById(R.id.recycleView);
        backButton = findViewById(R.id.backButton);
        startParsingButton.setBackgroundColor(Color.parseColor("#8BC34A"));
        //getColor(R.color.colorPrimary)
        startParsingForList.setBackgroundColor(Color.parseColor("#8BC34A"));
        backButton.setBackgroundColor(Color.parseColor("#8BC34A"));
        jsonRecyclerView = findViewById(R.id.rv_json);
        startParsingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startParsingButton.setVisibility(View.INVISIBLE);
                startParsingForList.setVisibility(View.INVISIBLE);
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Parsing CSV");
                progressDialog.setMessage("Please Wait");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                backButton.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        readStudentsDataForJson();
                    }
                }, 3000);
            }
        });

        startParsingForList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.VISIBLE);
                startParsingButton.setVisibility(View.INVISIBLE);
                startParsingForList.setVisibility(View.INVISIBLE);
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Parsing CSV");
                progressDialog.setMessage("Please Wait");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                backButton.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        readStudentsDataForList();
                    }
                }, 3000);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfData.clear();
                backButton.setVisibility(View.INVISIBLE);
                if (recyclerView != null) {
                    adapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.INVISIBLE);
                    recyclerView = null;
                } else {
                    jsonRecyclerView.bindJson("[]");
                }
                startParsingButton.setVisibility(View.VISIBLE);
                startParsingForList.setVisibility(View.VISIBLE);
            }
        });
    }

    private void readStudentsDataForJson() {
        InputStream inputStream = getResources().openRawResource(R.raw.sample_2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line;
        int length = 1;
        try {
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null && length < 10) {
                String[] data = line.split(",");
                listOfData.add(new DummyData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
                length++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonRecyclerView.bindJson(new Gson().toJson(listOfData).toString());
        progressDialog.cancel();
        backButton.setVisibility(View.VISIBLE);
    }

    private void readStudentsDataForList() {
        InputStream inputStream = getResources().openRawResource(R.raw.sample_2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line;
        int length = 1;
        try {
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null && length < 10) {
                String[] data = line.split(",");
                listOfData.add(new DummyData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
                length++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        jsonRecyclerView.bindJson(new Gson().toJson(listOfData).toString());
        progressDialog.cancel();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new DummyDataListRecycleViewAdapter(listOfData, MainActivity.this);
        recyclerView.setAdapter(adapter);
        backButton.setVisibility(View.VISIBLE);
    }
}
