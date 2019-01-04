package com.caverock.androidsvg.element.base

interface SvgContainer {

    val children: List<SvgObject>
    fun addChild(elem: SvgObject)
}

