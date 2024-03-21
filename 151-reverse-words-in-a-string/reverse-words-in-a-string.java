class Solution {
    public String reverseWords(String s) {
        //Split the string and stack them.
        String[] splits = s.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for(String word:splits) {
            if(word.trim().length() != 0)stack.add(word.trim());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            if(!stack.isEmpty())sb.append(" ");
        }
        return sb.toString();
    }
}