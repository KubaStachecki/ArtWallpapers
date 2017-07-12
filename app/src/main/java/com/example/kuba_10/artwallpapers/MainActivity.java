package com.example.kuba_10.artwallpapers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuba_10.artwallpapers.Connection.DaggerServiceComponent;
import com.example.kuba_10.artwallpapers.Connection.InternetAPI;
import com.example.kuba_10.artwallpapers.Connection.ServiceComponent;
import com.example.kuba_10.artwallpapers.Connection.ServiceModule;
import com.example.kuba_10.artwallpapers.Model.Film;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private GridLayoutManager gridManager;
    private CustomAdapter adapter;
    private List<Film> data_list;
    ServiceComponent serviceComponent;
    InternetAPI internetAPI;
    String url;
    private RecyclerView recyclerView;


    @Inject
    Retrofit retrofit;


//    @BindView(R.id.recyclerView)
//    RecyclerView recyclerView;
//
//    @BindView(R.id.image)
//    ImageView image;
//
//    @BindView(R.id.text)
//    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);


        url = "http://www.json-generator.com/api/json/";

        injecServiceComponent();


        data_list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        gridManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridManager);



        adapter = new CustomAdapter(this, data_list);
        recyclerView.setAdapter(adapter);


        load_data_from_web();


    }

    private void load_data_from_web() {

        internetAPI.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Film>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                        Log.d("LOLOLO", "subscribed");


                    }

                    @Override
                    public void onNext(@NonNull List<Film> films) {

                        data_list.addAll(films);

                        Log.d("LOLOLO", "filmy sie sciagnely");
                        Log.d("LOLOLO", Integer.toString(data_list.size()));

                        adapter.notifyDataSetChanged();



                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.d("LOLOLO", "jablo" + e.toString());


                    }

                    @Override
                    public void onComplete() {

                        Log.d("LOLOLO", "complete");


                    }
                });

    }

    private void injecServiceComponent() {
        serviceComponent = DaggerServiceComponent.builder()
                .serviceModule(new ServiceModule(url))
                .build();
        serviceComponent.inject(this);
        internetAPI = retrofit.create(InternetAPI.class);

    }


}
