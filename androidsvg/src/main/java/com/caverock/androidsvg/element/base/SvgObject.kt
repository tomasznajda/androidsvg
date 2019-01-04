package com.caverock.androidsvg.element.base

import com.caverock.androidsvg.SVG

abstract class SvgObject(open val nodeName: String = "") {

    open var document: SVG? = null
    open var parent: SvgContainer? = null
}