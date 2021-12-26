package org.madmeg.api

import org.madmeg.api.elements.FileLoader
import org.madmeg.api.elements.SplitFile
import java.io.File

/**
 * @author Madmegsox1
 * @since 25/12/2021
 */


class Loader: FileLoader {
    lateinit var file: SplitFile

    override fun load(file: File) {
        val newLines = ArrayList<String>()
        val lines = file.readLines()
        for(i in lines){
            if(i.replace("\n", "") == "") continue
            newLines.add(i)
        }
        this.file = SplitFile(newLines)
        newLines.clear()
    }

    override fun save(path: String) {

    }

}