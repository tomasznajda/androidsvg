package com.caverock.androidsvg.element.base

import com.caverock.androidsvg.SVG

abstract class SvgViewBoxContainer(nodeName: String = "") : SvgPreserveAspectRatioContainer(nodeName) {

    abstract val viewBox: SVG.Box
}