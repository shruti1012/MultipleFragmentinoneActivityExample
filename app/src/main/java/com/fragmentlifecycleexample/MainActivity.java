package com.fragmentlifecycleexample;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener,
        SecondFragment.OnFragmentInteractionListener,ThirdFragment.OnFragmentInteractionListener,View.OnClickListener {
    Button frag1, frag2, frag3;

    Fragment firstFrag, secondFrag, thirdFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Fragment example");
        defineview();

        //setting Firstfragment as default fragment
        firstFrag = new FirstFragment();
        secondFrag = new SecondFragment();
        thirdFrag = new ThirdFragment();

        this.SetDefaultFragment(firstFrag);

    }

    public void defineview(){
        frag1 = (Button) findViewById(R.id.frag1);
        frag2 = (Button) findViewById(R.id.frag2);
        frag3 = (Button) findViewById(R.id.frag3);
        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.e("inside activity","onfragemntinterface");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.frag1:
                    SetFragment(firstFrag);
                return;
            case R.id.frag2:
                SetFragment(secondFrag);
                return;
            case R.id.frag3:
                SetFragment(thirdFrag);
                return;
            default:
                return;

        }

    }

    public void SetDefaultFragment(Fragment defaultFragment){
        this.SetFragment(defaultFragment);
    }

    private void SetFragment(Fragment setFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.dyanmic_fragment, setFragment);
        fragmentTransaction.commit();

    }
}
