package com.example.weblog.ui.fragment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weblog.R;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.ui.adapter.TextListAdapter;
import com.example.weblog.ui.fragment.base.BaseFragment;
import com.example.weblog.ui.listener.OnGetTextListDataListener;
import com.example.weblog.ui.persent.TextListPersent;

public class TextListFragment extends BaseFragment {
    private RecyclerView  recyclerTextList;
    private TextListPersent textListPersent;
    private TextListAdapter textListAdapter;



    @Override
    protected void loadData() {
        textListPersent.getTextList( new OnGetTextListDataListener() {

            @Override
            public void getSuccess(final TextListResult textListResult) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //  adapter.setList(movieResult.datas);
                        //  page++;
//                        tvTitle.setText(movieResult.getTitle());
//                        tvTotal.setText("总数："+movieResult.getTotal());
//                        String a=movieResult.getDatas().get(0).getImages().getMedium();
//                        Glide.with(MovieListsActivity.this).load(a).into(ivListTopBackground);
//                        movieListAdapter.setList(movieResult.getDatas());
                        textListAdapter.setList(textListResult.getData());



                    }
                });
            }

            @Override
            public void getFailed(Throwable throwable) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //  showErrorView();
                    }
                });


            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        recyclerTextList =super.view.findViewById(R.id.recycler_testlist);
        textListAdapter=new TextListAdapter(getActivity());
        recyclerTextList.setLayoutManager (new LinearLayoutManager(getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerTextList.setAdapter(textListAdapter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_textlist;
    }
}
