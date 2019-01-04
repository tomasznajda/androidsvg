package com.caverock.androidsvg.element.base

interface SvgConditional {
    var requiredFeatures: Set<String>?
    var requiredExtensions: String?
    var systemLanguage: Set<String>?
    var requiredFormats: Set<String>?
    var requiredFonts: Set<String>?
}