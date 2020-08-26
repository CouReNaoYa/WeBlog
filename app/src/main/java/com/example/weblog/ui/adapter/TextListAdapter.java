package com.example.weblog.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weblog.R;
import com.example.weblog.bean.TextItem;
import com.example.weblog.ui.adapter.base.BaseAdapter;

import java.util.List;

public class TextListAdapter extends  RecyclerView.Adapter<TextListAdapter.MyViewHolder> implements BaseAdapter<TextListAdapter.MyViewHolder>,View.OnClickListener {

    List<TextItem> textItemList;
    Context context;

    public TextListAdapter(Context context ){
        this.context = context;
      //  this.textItemList =textItemList;
    }


    public void setList(List<TextItem> textItemList){
        this.textItemList.clear();
        this.textItemList.addAll(textItemList);
        notifyDataSetChanged();
    }

    public void addList(List<TextItem> textItemList){
        this.textItemList.addAll(textItemList);
        notifyDataSetChanged();
    }
    public List<TextItem> getList(){
        return textItemList;
    }

    @NonNull
    @Override
    public TextListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //实例化得到Item布局文件的View对象
        View v = View.inflate(context, R.layout.recyclerview_text,null);//R后面的是item的ui
        //返回MyViewHolder的对象
        return new TextListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_text_author_name.setText(textItemList.get(position).getAuthor());
        holder.tv_text_creat_time.setText(textItemList.get(position).getCreateTime());
        holder.tv_text_classify.setText(textItemList.get(position).getClassify());
        holder.tv_text_content.setText(textItemList.get(position).getContent());
    }



    @Override
    public int getItemCount() {
        return textItemList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public interface ItemCLickListener{
        void onClick(int position);
    }
    private ItemCLickListener itemCLickListener;
    public void setOnItemClickListener(ItemCLickListener itemClickListener){
        this.itemCLickListener=itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_text_author_name;
        public TextView tv_text_creat_time;
        public TextView tv_text_classify;
        public TextView tv_text_content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_text_author_name=itemView.findViewById(R.id.tv_text_author_name);
            tv_text_classify=itemView.findViewById(R.id.tv_text_classify);
            tv_text_creat_time=itemView.findViewById(R.id.tv_text_creat_time);
            tv_text_content=itemView.findViewById(R.id.tv_text_content);
        }
    }
}
