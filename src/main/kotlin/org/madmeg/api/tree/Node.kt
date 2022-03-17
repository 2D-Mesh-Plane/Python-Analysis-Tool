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

    fun getMasterNode(): Node {
        var master = parentNode
        for(i in 0..nodeLevel){
            if(master.nodeLevel == 0)break
            master = master.parentNode
        }
        return master
    }


    fun search(search: (Node) -> Boolean): Node? {
        for(node in childrenNodes){
            if(search(node)){
                return node
            }

            val result =  node.search(search)

            if(result != null){
                return result
            }
        }

        return null
    }


    fun findRegex(search: (Node) -> String): Node? {
        for (node in childrenNodes){
            val regex = search(node).toRegex()

            if(regex.matches(node.value)){
                return node
            }

            val result =  node.findRegex(search)

            if(result != null){
                return result
            }
        }

        return null
    }

}