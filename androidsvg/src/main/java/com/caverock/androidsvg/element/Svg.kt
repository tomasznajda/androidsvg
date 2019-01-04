package com.caverock.androidsvg.element

import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.element.base.SvgViewBoxContainer
import com.caverock.androidsvg.element.style.Length

data class Svg(override val viewBox: SVG.Box,
               val x: Length? = null,
               val y: Length? = null,
               val width: Length? = null,
               val height: Length? = null,
               val version: String? = null)
    : SvgViewBoxContainer("svg")