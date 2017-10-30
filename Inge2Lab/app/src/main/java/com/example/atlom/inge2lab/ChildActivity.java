package com.example.atlom.inge2lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.atlom.inge2lab.hijo.HijoFragment;


public class ChildActivity extends AppCompatActivity {

    protected int id_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        /**Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);**/

        id_usuario = getIntent().getExtras().getInt("id_usuario");
        Bundle bundle = new Bundle();
        bundle.putInt("id_usuario",id_usuario);



        //HijoFragment
        HijoFragment fragment = (HijoFragment)
                getSupportFragmentManager().findFragmentById(R.id.hijo_container);
        if(fragment == null){
            fragment = HijoFragment.newInstance();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.hijo_container,fragment)
                    .commit();
        }

    }
}
