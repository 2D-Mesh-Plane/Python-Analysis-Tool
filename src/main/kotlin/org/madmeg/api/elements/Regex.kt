package org.madmeg.api.elements

import kotlin.text.Regex

/**
 * @author Madmegsox1
 * @since 25/12/2021
 */


val importRegex = Regex("^import.*")

val classRegex = Regex("^class\\s[a-zA-Z0-9]*")

val functionRegex = Regex("^def\\s[a-zA-Z0-9]*")

val varRegex = Regex("[a-zA-Z0-9]* =[^=]")