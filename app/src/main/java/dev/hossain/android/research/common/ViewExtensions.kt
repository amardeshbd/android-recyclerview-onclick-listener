package dev.hossain.android.research.common

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Sets visibility to VISIBLE or GONE.
 */
@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}
