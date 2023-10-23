package com.devdroid.myfirst;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

//import com.devdroid.myfirst.adapter.LoaispAdapter;
import com.devdroid.myfirst.model.Loaisp;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    //LoaispAdapter loaispAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Anhxa();
//        ActionBar();
//        ActionViewflipper();
    }

    private void ActionViewflipper() {
        ArrayList<String> quangcao = new ArrayList<>();
        quangcao.add("https://photo2.tinhte.vn/data/attachment-files/2023/04/6406368_cover-trai-nghiem-san-pham-moi-hp-tinhte.jpg");
        quangcao.add("https://thoibaonganhang.vn/stores/news_dataimages/minhvl/122019/18/10/3449_4855479_nintendo-switch-tinhte-12.jpg");

        //for (int i=0; i< quangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load("https://photo2.tinhte.vn/data/attachment-files/2023/04/6406368_cover-trai-nghiem-san-pham-moi-hp-tinhte.jpg").into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        //}
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void Anhxa(){
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerViewmanhinhchinh = (RecyclerView) findViewById(R.id.recyclerview);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        /*mangloaisp = new ArrayList<>();
        loaispAdapter= new LoaispAdapter(mangloaisp,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);*/
    }
}