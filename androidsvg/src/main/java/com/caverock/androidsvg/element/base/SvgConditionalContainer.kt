package com.caverock.androidsvg.element.base

abstract class SvgConditionalContainer(nodeName: String = "")
    : SvgElement(nodeName), SvgContainer, SvgConditional {

    override var children: MutableList<SvgObject> = mutableListOf()
    override var requiredFeatures: Set<String>? = null
    override var requiredExtensions: String? = null
    override var systemLanguage: Set<String>? = null
    override var requiredFormats: Set<String>? = null
    override var requiredFonts: Set<String>? = null

    override fun addChild(elem: SvgObject) {
        children.add(elem)
    }
}
