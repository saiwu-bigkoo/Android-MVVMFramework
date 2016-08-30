package com.bigkoo.mvvmframework.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * RecyclerView分割条
 */
public class DividerHorizontalDecoration extends RecyclerView.ItemDecoration {
  private int margin = 2;

  public DividerHorizontalDecoration(int margin) {
    this.margin = margin*2;
  }
  public DividerHorizontalDecoration() {
  }
  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.set(0, 0, 0, margin);
  }
}