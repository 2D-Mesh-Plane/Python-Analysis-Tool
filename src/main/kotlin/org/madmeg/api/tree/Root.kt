package org.madmeg.api.tree

import org.madmeg.api.elements.SplitFile

/**
 * @author Madmegsox1
 * @since 26/12/2021
 */


class Root(file: SplitFile) {
    var masterNodes: ArrayList<Node> = ArrayList()
    private val lines: ArrayList<String>
    init {
        this.lines = file.lines
        compileTree()
    }

    private fun compileTree(){
        for(line in lines){
            var indent = 0
            for(c in line){
                if(c != ' ')break
                if(c == ' ') indent++
            }
            indent /= 4
            if(indent == 0) {
                val node = Node(line, indent)
                masterNodes.add(node)
            }else{
                val childNode = Node(line, indent)
                if(masterNodes.isEmpty())continue

                var parentNode = masterNodes.last()

                if(indent > 1) {
                    for (i in 0..indent) {
                        parentNode = parentNode.childrenNodes.last()
                        if(parentNode.nodeLevel + 1 == indent)break
                    }
                }

                childNode.parentNode = parentNode
                parentNode.childrenNodes.add(childNode)
            }
        }
    }

    fun printTree(){

        for(node in masterNodes){
            node.printNode()
        }
    }


    fun search(search: (Node) -> Boolean): Node? {
        for(node in masterNodes){
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
        for (node in masterNodes){
            val regex = search(node).toRegex()

            if(regex.matches(node.value)){
                return node
            }

            val result = node.findRegex(search)

            if(result != null){
                return result
            }
        }

        return null
    }

}