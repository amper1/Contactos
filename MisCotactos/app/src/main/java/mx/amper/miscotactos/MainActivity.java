package mx.amper.miscotactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import mx.amper.miscotactos.adapter.ContactoAdaptador;
import mx.amper.miscotactos.adapter.PageAdapter;
import mx.amper.miscotactos.fragment.PerfilFragment;
import mx.amper.miscotactos.fragment.RecyclerViewFragment;
import mx.amper.miscotactos.pojo.Contacto;

public class MainActivity extends AppCompatActivity {

    //Para el Recycler View
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setupViewPager();

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.MiActionBar);

        //En forma de renglones con LinearLayout
/*

        //Con GridLayout
        GridLayoutManager glm = new GridLayoutManager(this, 2);
*/


/*        //con GridLayout
        listaContactos.setLayoutManager(glm);
*/

/*
        //Original con ListView
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                //Elimina la actividad
                finish();

            }
        });*/

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList <Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setupViewPager(){
        //Inicaliza los Fragments
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);

    }

}
