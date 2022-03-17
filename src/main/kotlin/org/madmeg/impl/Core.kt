package org.madmeg.impl

import org.madmeg.api.Loader
import org.madmeg.api.tree.Root
import java.io.File
import kotlin.system.exitProcess

/**
 * @author 0x0001
 * @author Madmegsox1
 * @since 25/12/2021
 * @version 1.0.0
 */

var loader: Loader = Loader()

fun main(){
    println("Please input the .py file you would like to analyse: ")

    val file: File = File(readLine())

    if(!file.exists()){
        error("The file " + file.name + " doesnt exist!")
    }
    println("Loading File")
    loader.load(file)
    println("Loaded File")

    val root = Root(loader.file)
    root.printTree()
}