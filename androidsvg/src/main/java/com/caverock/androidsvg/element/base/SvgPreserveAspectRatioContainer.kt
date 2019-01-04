package com.caverock.androidsvg.element.base

import com.caverock.androidsvg.PreserveAspectRatio

abstract class SvgPreserveAspectRatioContainer(nodeName: String = "") : SvgConditionalContainer(nodeName) {

    val preserveAspectRatio: PreserveAspectRatio? = null
}