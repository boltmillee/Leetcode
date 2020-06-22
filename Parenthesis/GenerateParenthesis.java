class Solution {
    static List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        char[] str = new char[2*n];
        for(int i=0; i<n; i++)
            str[i] = '(';

        for(int i=n; i<str.length; i++)
            str[i] = ')';

        findPermutations(str, 0, str.length);

        for(String st : list){
            char[] ch = st.toCharArray();
            if(areParenthesisBalanced(ch)){
                result.add(st);
            }
        }
        list.clear();
        return result;
    }

    // Returns true if str[curr] does not matches with any of the
// characters after str[start]
    static boolean shouldSwap(char str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }

// Prints all distinct permutations in str[0..n-1]
    static void findPermutations(char str[], int index, int n) {
        if (index >= n) {
            list.add(new String(str));
            return;
        }

        for (int i = index; i < n; i++) {

            // Proceed further for str[i] only if it
            // doesn't match with any of the characters
            // after str[index]
            boolean check = shouldSwap(str, index, i);
            if (check) {
                swap(str, index, i);
                findPermutations(str, index + 1, n);
                swap(str, index, i);
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

        static class stack
    {
        int top=-1;
        char items[] = new char[100];

        void push(char x)
        {
            if (top == 99)
            {
                System.out.println("Stack full");
            }
            else
            {
                items[++top] = x;
            }
        }

        char pop()
        {
            if (top == -1)
            {
                System.out.println("Underflow error");
                return '\0';
            }
            else
            {
                char element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }
    }

    /* Returns true if character1 and character2
       are matching left and right Parenthesis */
    static boolean isMatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else if (character1 == '{' && character2 == '}')
         return true;
       else if (character1 == '[' && character2 == ']')
         return true;
       else
         return false;
    }

    /* Return true if expression has balanced
       Parenthesis */
    static boolean areParenthesisBalanced(char exp[])
    {
       /* Declare an empty character stack */
       stack st=new stack();

       /* Traverse the given expression to
          check matching parenthesis */
       for(int i=0;i<exp.length;i++)
       {

          /*If the exp[i] is a starting
            parenthesis then push it*/
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
            st.push(exp[i]);

          /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
          {

              /* If we see an ending parenthesis without
                 a pair then return false*/
             if (st.isEmpty())
               {
                   return false;
               }

             /* Pop the top element from stack, if
                it is not a pair parenthesis of character
                then there is a mismatch. This happens for
                expressions like {(}) */
             else if ( !isMatchingPair(st.pop(), exp[i]) )
               {
                   return false;
               }
          }

       }

       /* If there is something left in expression
          then there is a starting parenthesis without
          a closing parenthesis */

       if (st.isEmpty())
         return true; /*balanced*/
       else
         {   /*not balanced*/
             return false;
         }
    }
}
