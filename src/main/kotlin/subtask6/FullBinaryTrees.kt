package subtask6


class Node {
    var depth = 0
    var left: Node? = null
    var right: Node? = null
}

class FullBinaryTrees {

    private fun formatTreeToList(n: Node): ArrayList<Int?> {
        val result = ArrayList<Int?>()
        val root = n
        result.add(0)
        val maxDepth = root.depth
        val children = ArrayList<Node?>()
        children.add(root.left)
        children.add(root.right)
        var currentLevel = 0
        while (children.isNotEmpty()) {
            val newChildren = ArrayList<Node?>()
            for (child in children) {
                if (child == null) {
                    if (currentLevel != maxDepth) result.add(null)
                } else {
                    result.add(0)
                    newChildren.add(child.left)
                    newChildren.add(child.right)
                }
            }
            children.clear()
            children.addAll(newChildren)
            newChildren.clear()
            currentLevel++
        }
        return result
    }

    private fun createTrees(n: Int): ArrayList<Node> {
        if (n % 2 == 0) return ArrayList()
        if (n == 1) return arrayListOf(Node())
        val result = ArrayList<Node>()
        for (i in 1 until n step 2) {
            val left = createTrees(i)
            val right = createTrees(n - 1 - i)
            for (ln in left) {
                for (rn in right) {
                    val root = Node()
                    root.left = ln
                    root.right = rn
                    root.depth = maxOf(ln.depth, rn.depth) + 1
                    result.add(root)
                }
            }
        }
        return result
    }

    fun stringForNodeCount(count: Int): String {
        val r = createTrees(count)
        val result = ArrayList<ArrayList<Int?>>()
        for (n in r) {
            val l = formatTreeToList(n)
            while (l[l.size - 1] == null) {
                l.removeAt(l.size - 1)
            }
            result.add(l)
        }
        return result.toString()
    }
}