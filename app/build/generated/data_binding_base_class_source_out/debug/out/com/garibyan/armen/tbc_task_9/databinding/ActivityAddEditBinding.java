// Generated by view binder compiler. Do not edit!
package com.garibyan.armen.tbc_task_9.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.garibyan.armen.tbc_task_9.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddEditBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AppCompatImageButton btnAdd;

  @NonNull
  public final AppCompatEditText edtEmail;

  @NonNull
  public final AppCompatEditText edtName;

  @NonNull
  public final AppCompatEditText edtSurname;

  @NonNull
  public final AppCompatTextView tvTitle;

  private ActivityAddEditBinding(@NonNull FrameLayout rootView,
      @NonNull AppCompatImageButton btnAdd, @NonNull AppCompatEditText edtEmail,
      @NonNull AppCompatEditText edtName, @NonNull AppCompatEditText edtSurname,
      @NonNull AppCompatTextView tvTitle) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.edtSurname = edtSurname;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      AppCompatImageButton btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.edtEmail;
      AppCompatEditText edtEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edtName;
      AppCompatEditText edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.edtSurname;
      AppCompatEditText edtSurname = ViewBindings.findChildViewById(rootView, id);
      if (edtSurname == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      AppCompatTextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ActivityAddEditBinding((FrameLayout) rootView, btnAdd, edtEmail, edtName,
          edtSurname, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
