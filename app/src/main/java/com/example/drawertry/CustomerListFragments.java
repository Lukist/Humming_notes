package com.example.drawertry;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerListFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerListFragments extends Fragment  implements Serializable {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomerListFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerListFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomerListFragments newInstance(String param1, String param2) {
        CustomerListFragments fragment = new CustomerListFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ListAdapter mAdapter;
    ListView lvClientes;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_customer_list_fragments, container, false);
        lvClientes = root.findViewById(R.id.lv_customer);

        db = new DatabaseHelper(getContext());

        mAdapter = new ClienteListaAdapter(getContext(), R.layout.customer_list_rows, db.getAllClientes());
        lvClientes.setAdapter(mAdapter);

        lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Intent intent = new Intent(getContext(), CustomerShowInfo.class);
                intent.putExtra("cliente", (ModeloClientes) mAdapter.getItem(position));
                startActivity(intent);
            }
        });


        return root;
    }
}