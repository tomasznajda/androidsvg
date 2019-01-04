package com.caverock.androidsvg.element

import android.graphics.Matrix
import com.caverock.androidsvg.element.base.HasTransform
import com.caverock.androidsvg.element.base.SvgConditionalContainer

open class Group(var transform: Matrix,
                 val nodeName: String = "group") : SvgConditionalContainer(), HasTransform