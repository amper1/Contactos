package mx.amper.miscotactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.amper.miscotactos.R;
import mx.amper.miscotactos.adapter.ContactoAdaptador;
import mx.amper.miscotactos.pojo.Contacto;

/**
 * Created by MB17056 on 13/02/2017.
 */

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;

    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ArrayList<String> nombresContacto = new ArrayList<>();

        listaContactos=(RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        // Con LinearLayout
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador (){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.unnamed2, "Ernesto Pedraza", "5555 6666", "a@a.com"));
        contactos.add(new Contacto(R.drawable.unnamed3, "Pedro Sanchez", "6666 6666", "b@a.com"));
        contactos.add(new Contacto(R.drawable.unnamed4, "Juan Perez", "3333 4444", "c@a.com"));
        contactos.add(new Contacto(R.drawable.unnamed5, "Maria Lopez", "5555 1111", "d@a.com"));

    }
}
