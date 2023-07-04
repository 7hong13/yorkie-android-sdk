package dev.yorkie.document.crdt

/**
 * Converts the given node to XML.
 */
internal fun CrdtTreeNode.toXml(): String {
    return if (isText) {
        value
    } else {
        val attrs = attributesToXml
        val children = children.joinToString("") { it.toXml() }
        "<$type$attrs>$children</$type>"
    }
}

/**
 * Converts the given node to JSON.
 */
internal fun CrdtTreeNode.toJson(): TreeNode {
    return if (isText) {
        TreeNode(type, value = value)
    } else {
        TreeNode(type, children.map { it.toJson() }, attributes = attributes)
    }
}