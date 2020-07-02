class Solution {
    public boolean equationsPossible(String[] equations) {

        List<Set<Character>> list = new ArrayList();


        for(int a=0; a<equations.length; a++)
        System.out.print(equations[a] + " ");

        for(int i=0; i<equations.length; i++){
            String val = equations[i];
            if(val.charAt(1) ==  '=' && val.charAt(2) == '='){
                if(list.isEmpty()){
                    Set<Character> set = new HashSet();
                    set.add(val.charAt(0));
                    set.add(val.charAt(3));
                    list.add(set);
                } else{

                    //Iterator<Set<Character>> it = list.iterator();
                    for(int k=0; k<13; k++){

                        if(k>=list.size())
                            break;

                        Set<Character> s = list.get(k);
                        if(s.contains(val.charAt(0)) || s.contains(val.charAt(3))){
                            s.add(val.charAt(0));
                            s.add(val.charAt(3));
                        }else{
                            Set<Character> set = new HashSet();
                            set.add(val.charAt(0));
                            set.add(val.charAt(3));
                            list.add(set);
                        }
                    }

                }
            }
        }


        for(int x=0; x<13; x++){

            if(x>=list.size())
                break;
            for(int y=x+1; y<13; y++){
                if(y>=list.size())
                    break;

                if(!Collections.disjoint(list.get(x), list.get(y))){
                    list.get(x).addAll(list.get(y));
                    list.remove(y);
                }

            }
        }

        System.out.println(list);

        for(int i=0; i<equations.length; i++){
            String val = equations[i];
            if(val.charAt(1) ==  '!' && val.charAt(2) == '='){

                if(val.charAt(0) == val.charAt(3))
                    return false;

                   for(Set<Character> s : list){
                       if(s.contains(val.charAt(0)) && s.contains(val.charAt(3)))
                           return false;
                   }
            }
        }

        return true;
    }
}
