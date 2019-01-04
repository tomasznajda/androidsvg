package com.caverock.androidsvg.element.style

import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGAndroidRenderer

class Length : Cloneable {
    var value: Float = 0.toFloat()
    var unit: Unit

    val isZero: Boolean
        get() = value == 0f

    val isNegative: Boolean
        get() = value < 0f

    constructor(value: Float, unit: Unit) {
        this.value = value
        this.unit = unit
    }

    constructor(value: Float) {
        this.value = value
        this.unit = Unit.px
    }

    fun floatValue(): Float {
        return value
    }

    // Convert length to user units for a horizontally-related context.
    fun floatValueX(renderer: SVGAndroidRenderer): Float {
        when (unit) {
            SVG.Unit.px -> return value
            SVG.Unit.em -> return value * renderer.getCurrentFontSize()
            SVG.Unit.ex -> return value * renderer.getCurrentFontXHeight()
            SVG.Unit.`in` -> return value * renderer.getDPI()
            SVG.Unit.cm -> return value * renderer.getDPI() / 2.54f
            SVG.Unit.mm -> return value * renderer.getDPI() / 25.4f
            SVG.Unit.pt // 1 point = 1/72 in
            -> return value * renderer.getDPI() / 72f
            SVG.Unit.pc // 1 pica = 1/6 in
            -> return value * renderer.getDPI() / 6f
            SVG.Unit.percent -> {
                val viewPortUser = renderer.getCurrentViewPortInUserUnits() ?: return value
// Undefined in this situation - so just return value to avoid an NPE
                return value * viewPortUser.width / 100f
            }
            else -> return value
        }
    }

    // Convert length to user units for a vertically-related context.
    fun floatValueY(renderer: SVGAndroidRenderer): Float {
        if (unit == Unit.percent) {
            val viewPortUser = renderer.getCurrentViewPortInUserUnits() ?: return value
// Undefined in this situation - so just return value to avoid an NPE
            return value * viewPortUser.height / 100f
        }
        return floatValueX(renderer)
    }

    // Convert length to user units for a context that is not orientation specific.
    // For example, stroke width.
    fun floatValue(renderer: SVGAndroidRenderer): Float {
        if (unit == Unit.percent) {
            val viewPortUser = renderer.getCurrentViewPortInUserUnits() ?: return value
// Undefined in this situation - so just return value to avoid an NPE
            val w = viewPortUser.width
            val h = viewPortUser.height
            if (w == h)
                return value * w / 100f
            val n = (Math.sqrt((w * w + h * h).toDouble()) / SQRT2).toFloat()  // see spec section 7.10
            return value * n / 100f
        }
        return floatValueX(renderer)
    }

    // Convert length to user units for a context that is not orientation specific.
    // For percentage values, use the given 'max' parameter to represent the 100% value.
    fun floatValue(renderer: SVGAndroidRenderer, max: Float): Float {
        return if (unit == Unit.percent) {
            value * max / 100f
        } else floatValueX(renderer)
    }

    // For situations (like calculating the initial viewport) when we can only rely on
    // physical real world units.
    fun floatValue(dpi: Float): Float {
        when (unit) {
            SVG.Unit.px -> return value
            SVG.Unit.`in` -> return value * dpi
            SVG.Unit.cm -> return value * dpi / 2.54f
            SVG.Unit.mm -> return value * dpi / 25.4f
            SVG.Unit.pt // 1 point = 1/72 in
            -> return value * dpi / 72f
            SVG.Unit.pc // 1 pica = 1/6 in
            -> return value * dpi / 6f
            SVG.Unit.em, SVG.Unit.ex, SVG.Unit.percent -> return value
            else -> return value
        }
    }

    override fun toString(): String {
        return value.toString() + unit
    }
}
