// Generated code from Butter Knife. Do not modify!
package com.example.recyclerview.kindofrecyclerview;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChooseCenterActivity$$ViewBinder<T extends com.example.recyclerview.kindofrecyclerview.ChooseCenterActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427424, "field 'rvCenter'");
    target.rvCenter = finder.castView(view, 2131427424, "field 'rvCenter'");
  }

  @Override public void unbind(T target) {
    target.rvCenter = null;
  }
}
