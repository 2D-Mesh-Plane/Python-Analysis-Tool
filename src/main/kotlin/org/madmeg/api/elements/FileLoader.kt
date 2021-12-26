package org.madmeg.api.elements

import java.io.File

/**
 * @author Madmegsox1
 * @since 25/12/2021
 */


interface FileLoader {
    fun load(file: File)

    fun save(path: String)
}