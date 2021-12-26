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

    fun hasChildren(): Boolean{
        return childrenNodes.isNotEmpty()
    }

    fun printNode(){
        println("$value $nodeLevel")
        for(node in childrenNodes){
            node.printNode()
        }
    }

    fun getMasterNode(): Node? {
        var master = parentNode
        for(i in 0..nodeLevel){
            if(master.nodeLevel == 0)break
            master = master.parentNode
        }
        return master!!
    }
}