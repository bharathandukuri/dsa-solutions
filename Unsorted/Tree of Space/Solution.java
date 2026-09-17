import java.util.*;

class Node {

    String name;
    Node parent;
    List<Node> children = new ArrayList<>();

    int lockedAncestors;
    int lockedDescendants;

    boolean locked;
    int lockedBy;

    Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }
}

class LockingTree {

    private final Map<String, Node> nodes = new HashMap<>();

    LockingTree(Node root) {
        mapNodes(root);
    }

    private void mapNodes(Node node) {

        nodes.put(node.name, node);

        for (Node child : node.children) {
            mapNodes(child);
        }
    }

    /*
     * Update lockedAncestors of all descendants.
     *
     * change = +1 -> a new locked ancestor
     * change = -1 -> a locked ancestor was removed
     */
    private void updateDescendants(Node node, int change) {

        for (Node child : node.children) {

            child.lockedAncestors += change;

            updateDescendants(child, change);
        }
    }

    /*
     * Update lockedDescendants of all ancestors.
     *
     * change = +1 -> a new locked descendant
     * change = -1 -> a locked descendant was removed
     */
    private void updateAncestors(Node node, int change) {

        Node current = node.parent;

        while (current != null) {

            current.lockedDescendants += change;

            current = current.parent;
        }
    }

    public boolean lock(String name, int user) {

        Node node = nodes.get(name);

        // Node doesn't exist or is already locked
        if (node == null || node.locked) {
            return false;
        }

        // An ancestor or descendant is locked
        if (node.lockedAncestors > 0 ||
                node.lockedDescendants > 0) {
            return false;
        }

        // Update ancestors
        updateAncestors(node, 1);

        // Update descendants
        updateDescendants(node, 1);

        node.locked = true;
        node.lockedBy = user;

        return true;
    }

    public boolean unlock(String name, int user) {

        Node node = nodes.get(name);

        // Node doesn't exist or isn't locked
        if (node == null || !node.locked) {
            return false;
        }

        // Only the user who locked it can unlock it
        if (node.lockedBy != user) {
            return false;
        }

        // Remove this locked node from ancestors
        updateAncestors(node, -1);

        // Remove this locked node from descendants
        updateDescendants(node, -1);

        node.locked = false;
        node.lockedBy = 0;

        return true;
    }

    /*
     * Collect all locked descendants.
     *
     * Returns false if a locked descendant
     * belongs to another user.
     */
    private boolean collectLockedDescendants(
            Node node,
            int user,
            List<Node> lockedNodes) {

        if (node.locked) {

            if (node.lockedBy != user) {
                return false;
            }

            lockedNodes.add(node);
        }

        for (Node child : node.children) {

            // Skip completely unlocked subtrees
            if (!child.locked &&
                    child.lockedDescendants == 0) {
                continue;
            }

            if (!collectLockedDescendants(
                    child,
                    user,
                    lockedNodes)) {
                return false;
            }
        }

        return true;
    }

    public boolean upgrade(String name, int user) {

        Node node = nodes.get(name);

        // Node doesn't exist or is already locked
        if (node == null || node.locked) {
            return false;
        }

        // Cannot upgrade if an ancestor is locked
        if (node.lockedAncestors > 0) {
            return false;
        }

        // Must have at least one locked descendant
        if (node.lockedDescendants == 0) {
            return false;
        }

        List<Node> lockedNodes = new ArrayList<>();

        /*
         * All locked descendants must belong
         * to the same user.
         */
        if (!collectLockedDescendants(
                node,
                user,
                lockedNodes)) {
            return false;
        }

        // Unlock all locked descendants
        for (Node lockedNode : lockedNodes) {
            unlock(lockedNode.name, user);
        }

        // Lock the current node
        return lock(name, user);
    }
}

public class Solution {

    private static Node buildTree(
            List<String> names,
            int m) {

        Node root = new Node(names.get(0), null);

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() &&
                index < names.size()) {

            Node parent = queue.poll();

            for (int i = 0; i < m && index < names.size(); i++) {

                Node child = new Node(
                        names.get(index++),
                        parent);

                parent.children.add(child);
                queue.offer(child);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int q = Integer.parseInt(sc.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }

        Node root = buildTree(names, m);

        LockingTree tree = new LockingTree(root);

        for (int i = 0; i < q; i++) {

            String line = sc.nextLine();

            int firstIndex = line.indexOf(" ");
            int lastIndex = line.lastIndexOf(" ");
            int type = Integer.parseInt(line.substring(0, firstIndex));
            String name = line.substring(firstIndex + 1, lastIndex);
            int user = Integer.parseInt(line.substring(lastIndex + 1));

            boolean result;

            if (type == 1) {
                result = tree.lock(name, user);

            } else if (type == 2) {
                result = tree.unlock(name, user);

            } else {
                result = tree.upgrade(name, user);
            }

            System.out.println(result);
        }

        sc.close();
    }
}