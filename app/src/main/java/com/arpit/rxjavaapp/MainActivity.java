package com.arpit.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;

    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private RVcustomAdapter rVcustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rVcustomAdapter = new RVcustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rVcustomAdapter);

//        Observable.just("Arpit","Ram","Akash","Baba").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                rVcustomAdapter.addStringToList(s);
//            }
//        });


        Entries entry1 = new Entries("PS4", BigDecimal.valueOf(1500),new Date());
        Entries entry2 = new Entries("Xbox one", BigDecimal.valueOf(2000),new Date());
        Entries entry3 = new Entries("Mouse", BigDecimal.valueOf(500),new Date());
        Entries entry4 = new Entries("RAM", BigDecimal.valueOf(3000),new Date());

        Observable.just(entry1,entry2,entry3,entry4).subscribe(new Consumer<Entries>() {
            @Override
            public void accept(Entries entries) throws Throwable {

                rVcustomAdapter.addEntry(entries);
            }
        });

    }
}
