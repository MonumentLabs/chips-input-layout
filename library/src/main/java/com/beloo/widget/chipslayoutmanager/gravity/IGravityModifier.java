package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

import androidx.annotation.IntRange;

public interface IGravityModifier {
    /**
     * @param childRect input rect. Immutable
     * @return created rect based on modified input rect due to concrete gravity modifier.
     */
    Rect modifyChildRect(@IntRange(from = 0) int minTop, @IntRange(from = 0) int maxBottom, Rect childRect);
}
