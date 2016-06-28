package com.moshangjian.test.recyclerviewanimationtest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by hubing on 16/6/25.
 */
public class EasyItemAnimation extends RecyclerView.ItemAnimator {

    private ArrayList<RecyclerView.ViewHolder> persistenceList ;


    public  EasyItemAnimation(){
        persistenceList = new ArrayList<>();
    }


    @Override
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @Nullable ItemHolderInfo postLayoutInfo) {
        return false;
    }

    @Override
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        return false;
    }

    @Override
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        persistenceList.add(viewHolder);
        animationMove(viewHolder,preLayoutInfo.top,postLayoutInfo.top);
        return true;
    }

    @Override
    public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    private void animationMove(RecyclerView.ViewHolder holder , int fromTop ,int toTop){
        ViewCompat.setTranslationY(holder.itemView,fromTop);
    }
}
