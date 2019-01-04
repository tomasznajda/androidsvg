package com.caverock.androidsvg.element.base

import com.caverock.androidsvg.element.style.Style

abstract class SvgElementBase(nodeName: String = "") : SvgObject(nodeName) {

    var id: String? = null
    var spacePreserve: Boolean? = null
    var baseStyle: Style? = null   // style defined by explicit style attributes in the element (eg. fill="black")
    var style: Style? = null       // style expressed in a 'style' attribute (eg. style="fill:black")
    var classNames: List<String>? = null  // contents of the 'class' attribute

    override fun toString() = nodeName
}