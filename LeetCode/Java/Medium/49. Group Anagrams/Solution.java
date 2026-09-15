class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String, List<String>> data = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = sort(strs[i]);
            List<String> list = data.getOrDefault(temp, new ArrayList<>());
            list.add(strs[i]);
            data.put(temp, list);
        }
        for (Map.Entry<String, List<String>> e: data.entrySet()) {
            out.add(e.getValue());
        }
        return out;
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}