package org.madmeg.api.tree

import org.madmeg.api.elements.SplitFile

/**
 * @author Madmegsox1
 * @since 26/12/2021
 */


class Root(file: SplitFile) {
    var masterNodes: ArrayList<Node> = ArrayList()
    val lines: ArrayList<String>
    init {
        this.lines = file.lines
        compileTree()
    }

    fun compileTree(){
        for(line in lines){
            var indent = 0
            for(c in line){
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

}