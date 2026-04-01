class TreeMap {
    Set<Integer> keys = new HashSet<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();
    class TreeNode {
        int key;
        int val;
        TreeNode left= null;
        TreeNode right = null;
        TreeNode(){
            key = -1;
            val = -1;

        }
        TreeNode(int v){
            this.key = -1;
            this.val = v;
        }
        TreeNode(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    TreeNode root;
    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null){
            root = newNode;
            return;
        }  
        TreeNode node = root;
        while (true){
                if (key < node.key){
                    if (node.left == null){
                        node.left = newNode;
                        return;
                    }
                    node = node.left;
                }
                else if (key > node.key){
                    if (node.right == null){
                        node.right = newNode;
                        return;
                    }
                    node = node.right;
                }
                else {
                    node.val = val;
                    return;
                }
            }
        
    }

    public int get(int key) {
        return dfsFindValueByKey(root, key, new HashSet<>());
    }

    int dfsFindValueByKey(TreeNode node, int key, Set<TreeNode> visited){
        if (node == null){
            return -1;
        }
        if (visited.contains(node)){
            return -1;
        }
        visited.add(node);
        if (node.key == key){
            return node.val;
        }
        int v1 = dfsFindValueByKey(node.left, key, visited);
        if (v1 != -1){
            return 1;
        }
        int v2 = dfsFindValueByKey(node.right, key, visited);
        if (v2 != -1){
            return v2;
        }
        return -1;
    }

    public int getMin() {
        int min = -1;
        TreeNode node = root;
        while (node != null){
            min = node.val;
            node = node.left;
        }
        return min;
    }
      public TreeNode minNode(TreeNode node) {
        while (node != null && node.left != null){
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        int max = -1;
        TreeNode node = root;
        while (node != null){
            max = node.val;
            node = node.right;
        }
        return max;
    }

    public void remove(int key) {
        root = remover(key, root);
    }

    public TreeNode remover(int key, TreeNode node){
        if (node == null){
            return null;
        }
        if (key < node.key){
            node.left = remover(key, node.left);
        } else if (key > node.key){
            node.right = remover(key, node.right);
        } else {
            if (node.left == null){
                // Replace curr with right
                return node.right;
            } else if (node.right == null){
                // Replace curr with left
                return node.left;
            } else {
                // Swap node and the inorder successor 
                TreeNode min = minNode(node.right);
                node.key = min.key;
                node.val = min.val;
                node.right = remover(min.key, node.right);
            }
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder( TreeNode node, List<Integer> path){
        if (node == null){
            return;
        }
        inOrder(node.left, path);
        path.add(node.key);
        inOrder(node.right, path);
    }
}
