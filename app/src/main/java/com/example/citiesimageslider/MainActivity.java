package com.example.citiesimageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView cityName;
    private TabLayout tabLayout;
    private ViewPager citiesViewPager;
    private RadioGroup rgCities;

    private ArrayList<City> cities;

    private ViewPagerAdapter adapter;

    private City selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        cities = new ArrayList<>();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        InitializationCities();

        citiesViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(citiesViewPager);

        selectedCity = getCityByName("London");
        ArrayList<ImageFragment> fragments = new ArrayList<>();

        for(int i = 0; i < selectedCity.getImageURLs().size(); i++){
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", selectedCity.getImageURLs().get(i));
            imageFragment.setArguments(bundle);
            fragments.add(imageFragment);
        }

        adapter.setFragments(fragments);
        cityName.setText(selectedCity.getName());

        rgCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cityChanged(i);
            }
        });
    }

    private void cityChanged(int RbId) {
        Log.d(TAG, "cityChanged: started");

        switch (RbId){
            case R.id.rbLondon:
                selectedCity = getCityByName("London");
                break;
            case R.id.rbTokyo:
                selectedCity = getCityByName("Tokyo");
                break;
            case R.id.rbNewYork:
                selectedCity = getCityByName("New York");
                break;
            case R.id.rbZuirich:
                selectedCity = getCityByName("Zurich");
                break;
            default:
                break;

        }
        if(null != selectedCity){
            cityName.setText(selectedCity.getName());

            ArrayList<ImageFragment> fragments = new ArrayList<>();

            for(int i = 0; i<selectedCity.getImageURLs().size(); i++){
                ImageFragment imageFragment = new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("imageUrl", selectedCity.getImageURLs().get(i));
                imageFragment.setArguments(bundle);
                fragments.add(imageFragment);
            }
            adapter.setFragments(fragments);
        }
    }

    private City getCityByName(String name) {
        Log.d(TAG, "getCityByName: started");
        for(City city: cities){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    private void initViews() {
        Log.d(TAG, "initWidgets: started");

        cityName = findViewById(R.id.txtCityName);
        tabLayout = findViewById(R.id.tabLayout);
        citiesViewPager = findViewById(R.id.citiesViewPager);
        rgCities = findViewById(R.id.rgCities);
    }

    private void InitializationCities() {
        City london = new City();
        london.setName("London");
        ArrayList<String> londonImageUrls = new ArrayList<>();
        londonImageUrls.add("https://images.unsplash.com/photo-1529655683826-aba9b3e77383?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80");
        londonImageUrls.add("https://images.unsplash.com/photo-1526129318478-62ed807ebdf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        londonImageUrls.add("https://images.unsplash.com/photo-1494922275507-58dc039ed337?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        londonImageUrls.add("https://images.unsplash.com/photo-1534359265607-b9cdb5e0a81e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=621&q=80");

        london.setImageURLs(londonImageUrls);

        City tokyo = new City();
        tokyo.setName("Tokyo");
        ArrayList<String> tokyoImageUrls = new ArrayList<>();
        tokyoImageUrls.add("https://images.unsplash.com/photo-1503899036084-c55cdd92da26?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");
        tokyoImageUrls.add("https://images.unsplash.com/photo-1554797589-7241bb691973?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=676&q=80");
        tokyoImageUrls.add("https://images.unsplash.com/photo-1498036882173-b41c28a8ba34?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80");
        tokyoImageUrls.add("https://images.unsplash.com/photo-1542931287-023b922fa89b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        tokyo.setImageURLs(tokyoImageUrls);

        City newYork = new City();
        newYork.setName("New York");
        ArrayList<String> newYorkImageUrls = new ArrayList<>();
        newYorkImageUrls.add("https://images.unsplash.com/photo-1528809677-ac3432892018?ixlib=rb-1.2.1&auto=format&fit=crop&w=701&q=80");
        newYorkImageUrls.add("https://images.unsplash.com/photo-1531887259712-aa6e090e9289?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80");
        newYorkImageUrls.add("https://images.unsplash.com/photo-1516465201375-3ee3f53b5416?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80");
        newYorkImageUrls.add("https://images.unsplash.com/photo-1506383298917-6390d67679bf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80");

        newYork.setImageURLs(newYorkImageUrls);

        City zurich = new City();
        zurich.setName("Zurich");
        ArrayList<String> zurichImageUrls = new ArrayList<>();
        zurichImageUrls.add("https://images.unsplash.com/photo-1544392827-1fc9d8111cb1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80");
        zurichImageUrls.add("https://images.unsplash.com/photo-1535964047557-5bad8df9b37a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80");
        zurichImageUrls.add("https://images.unsplash.com/photo-1530444896743-93edcb6fe6fe?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80");
        zurichImageUrls.add("https://images.unsplash.com/photo-1566330409389-192ac5e0391e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80");

        zurich.setImageURLs(zurichImageUrls);

        cities.add(london);
        cities.add(tokyo);
        cities.add(newYork);
        cities.add(zurich);
    }
}