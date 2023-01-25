package com.odc.odc_compose_ui.lib.utils

import androidx.compose.ui.graphics.Color
import com.odc.odc_compose_ui.ui.theme.HighPColor
import com.odc.odc_compose_ui.ui.theme.LowPColor
import com.odc.odc_compose_ui.ui.theme.MediumPColor
import com.odc.odc_compose_ui.ui.theme.NonePColor

enum class Priority(val color: Color) {
    High(HighPColor),
    Medium(MediumPColor),
    Low(LowPColor),
    None(NonePColor)
}