package org.madmeg.api.tree

/**
 * @author Madmegsox1
 * @since 26/12/2021
 */


class Node(value: String, nodeLevel: Int) {
    var value: String
    val nodeLevel: Int

    lateinit var parentNode: Node
    val childrenNodes: ArrayList<Node>

    init {
        this.value = value
        this.nodeLevel = nodeLevel
        childrenNodes = ArrayList()
    }

    fun printNode(){
        var wSpace = ""
        if(nodeLevel > 0){
            for(i in 0..nodeLevel){
                wSpace+="\t"
            }
        }
        println(wSpace + value)
        for(node in childrenNodes){
            node.printNode()
        }
    }
}