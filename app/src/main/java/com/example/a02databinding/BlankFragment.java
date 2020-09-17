package com.example.a02databinding;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a02databinding.databinding.FragmentBlankBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        List<Item> list = new ArrayList<Item>();
        for(int i =0 ; i <10;i++ ){
            list.add(new Item(i));

        }
        Log.d("aaaaaaa",list.size()+"");
        mAdapter= new MyAdapter(list,getActivity());

        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //不复杂的界面仅使用viewbinding 已提高性能
//        FragmentBlankBinding fragmentBlankBinding = DataBindingUtil.inflate(inflater, R.layout_fragment_blank_item.fragment_blank, container, false);
        FragmentBlankBinding fragmentBlankBinding = FragmentBlankBinding.inflate(inflater,container,false);
        fragmentBlankBinding.list.setAdapter(mAdapter);
        fragmentBlankBinding.list.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout_fragment_blank_item size of the RecyclerView
//        fragmentBlankBinding.list.setHasFixedSize(true);

        // Inflate the layout_fragment_blank_item for this fragment
//        return inflater.inflate(R.layout_fragment_blank_item.fragment_blank, container, false);
       return fragmentBlankBinding.getRoot();
    }




}