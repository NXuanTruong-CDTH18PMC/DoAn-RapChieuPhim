package com.example.doanrapphim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.doanrapphim.Adapter.PagerAdapter1;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Activity_TrangChu extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView  navigationView;
    private TabItem dangchieu,sapchieu;
    private ListView listView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        viewPager =findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(this, getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());



        navigationView = findViewById(R.id.nav_view);
        tabLayout = findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.pager);
        Toolbar toolbar = findViewById(R.id.tootbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        drawerLayout = findViewById(R.id.drawer_layout);
        //cac tab
        PagerAdapter1 pagerAdapter = new PagerAdapter1(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ActionBarDrawerToggle togge = new ActionBarDrawerToggle(this ,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        togge.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.nav_dangxuat:
                        intent = new Intent(Activity_TrangChu.this, Activity_DangNhap1.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_ds:
                         intent = new Intent(Activity_TrangChu.this, Activity_DanhSachPhim.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_person:
                        intent = new Intent(Activity_TrangChu.this, Activity_TrangCaNhan.class);
                        startActivity(intent);
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    public  void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.image1));
        list.add(new Photo(R.drawable.image2));
        list.add(new Photo(R.drawable.image3));
        list.add(new Photo(R.drawable.image4));
        list.add(new Photo(R.drawable.image5));
        list.add(new Photo(R.drawable.image6));
        return list;
    }
}