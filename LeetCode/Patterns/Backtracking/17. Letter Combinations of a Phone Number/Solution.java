class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> mappings = Map.of(
            '2',
            List.of("a", "b", "c"),
            '3',
            List.of("d", "e", "f"),
            '4',
            List.of("g", "h", "i"),
            '5',
            List.of("j", "k", "l"),
            '6',
            List.of("m", "n", "o"),
            '7',
            List.of("p", "q", "r", "s"),
            '8',
            List.of("t", "u", "v"),
            '9',
            List.of("w", "x", "y", "z")
        );

        List<String> result = mappings.get(digits.charAt(0));
        for (int i = 1; i < digits.length(); i++) {
            List<String> combinations = new ArrayList<>();
            List<String> letters = mappings.get(digits.charAt(i));

            for (int j = 0; j < letters.size(); j++) {
                for (int k = 0; k < result.size(); k++) {
                    combinations.add(result.get(k) + letters.get(j));
                }
            }

            result = combinations;
        }
        return result;
    }
}
