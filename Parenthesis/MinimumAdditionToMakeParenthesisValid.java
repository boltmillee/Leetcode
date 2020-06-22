class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> s = new Stack();
        String str = "";

        for(int i=0; i<S.length(); i++){
            s.add(S.charAt(i));
        }
        int count=0;
        while(!s.isEmpty()){
            Character c = s.pop();

            if(c == ')'){
                str = str + ')';
                continue;
            }

            if(c == '('){
                if(str.length() == 0){
                    count++;
                    continue;
                }

                str = str.substring(1);
            }

        }

        if(str.length()>0)
            count += str.length();

        return count;
    }
}
