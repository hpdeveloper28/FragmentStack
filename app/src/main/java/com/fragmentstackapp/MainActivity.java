package com.fragmentstackapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fragmentstackapp.fragments.FirstFragment;
import com.fragmentstackapp.fragments.SecondFragment;
import com.fragmentstackapp.fragments.ThirdFragment;
import com.hpdeveloper.fragmentstack.FragmentStack;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int counter = -1;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentStack fragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentStack = new FragmentStack(MainActivity.this, getSupportFragmentManager(), R.id.frameContainer);
        initFragmentList();
    }

    private void initFragmentList() {
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btnPrevious:
                if (counter != 0) {
                    counter--;
                    fragmentStack.back();
                }
                break;

            case R.id.btnNext:
                if (counter != 2) {
                    counter++;
                    fragmentStack.push(fragmentList.get(counter));
                }
                break;
        }
    }
}
