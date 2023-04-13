public class TaskDependency {

    public static boolean isWellSorted(String[][] dependencies, String[] sequence) {
        Set<String> visited = new HashSet<>();
        for (String task : sequence) {
            if (!visited.contains(task)) {
                if (!visit(task, dependencies, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean visit(String task, String[][] dependencies, Set<String> visited) {
        visited.add(task);
        for (String[] dependency : dependencies) {
            if (dependency[1].equals(task)) {
                if (!visited.contains(dependency[0])) {
                    if (!visit(dependency[0], dependencies, visited)) {
                        return false;
                    }
                } else {
                    return false; // cycle detected
                }
            }
        }
        return true;
    }

}

