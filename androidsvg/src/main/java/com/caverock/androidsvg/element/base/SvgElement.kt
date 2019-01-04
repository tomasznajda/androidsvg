package com.caverock.androidsvg.element.base

import com.caverock.androidsvg.SVG

abstract class SvgElement(nodeName: String = "") : SvgElementBase(nodeName) {

    val boundingBox: SVG.Box? = null
}