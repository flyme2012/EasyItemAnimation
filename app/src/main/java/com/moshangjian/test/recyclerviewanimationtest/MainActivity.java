package com.moshangjian.test.recyclerviewanimationtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ArrayList<String> list;
    private Handler handler;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView listView = (RecyclerView) findViewById(R.id.test_list);
        listView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new ListAdapter();
        listView.setItemAnimator(new EasyItemAnimation());
        listView.setAdapter(adapter);
        handler = new Handler(getMainLooper() , this);

        sendMessage();

    }

    private void sendMessage(){
        handler.sendEmptyMessageDelayed(0,5000);
    }

    private void initData(){
        list = new ArrayList<>();
        for (int i=0;i <100;i ++){
            list.add("sun  fei  is  beautiful " + i);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        list.add(2,"sun fei is  beautiful "+list.size());
        adapter.notifyItemInserted(2);
        sendMessage();
        return true;
    }


    class ListAdapter extends RecyclerView.Adapter<ListHolder>{

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_view,null));
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
            holder.text.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ListHolder extends RecyclerView.ViewHolder{

        public TextView text ;
        public ListHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.test);
        }
    }

}
