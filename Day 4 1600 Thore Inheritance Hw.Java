class ThroneInheritance {
    String king;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> dead = new HashSet<>();

    public ThroneInheritance(String kingName) {
        king = kingName;
        map.put(kingName, new ArrayList<>());
    }

    public void birth(String p, String c) {
        map.get(p).add(c);
        map.put(c, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(king, res);
        return res;
    }

    void dfs(String s, List<String> res) {
        if (!dead.contains(s)) res.add(s);
        for (String x : map.get(s)) dfs(x, res);
    }
}
/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
