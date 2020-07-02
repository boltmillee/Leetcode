class Solution {
    public int minSwaps(int[] data) {

        int count = 0;
        for(int i =0; i<data.length; i++){
            if(data[i] == 1)
                count++;
        }

        if(count ==1)
            return 0;

        // List<Integer> list = new ArrayList<>();
        // for(int i=0; i<count; i++)
        //     list.add(i);


        //List<Integer> listr = Arrays.asList(data);
        List<Integer> listr = new ArrayList<Integer>(data.length);
        for (int i : data)
            {
                listr.add(i);
            }
        int min = Integer.MAX_VALUE;
        List<Integer> sub = listr.subList(0, count);
        int oc = Collections.frequency(sub, 0);
        for(int j=1; j<=data.length-count; j++){
            //List<Integer> sub = listr.subList(j, count+j);
            //int oc = Collections.frequency(sub, 0);
            if(min>oc)
                min=oc;

            if(data[j-1]==0 && data[j+count-1]==1)
                oc--;
            else if(data[j-1]==1 && data[j+count-1]==0)
                oc++;

            // if(min>oc)
            //     min=oc;
        }

//         for(int j=0; j<=data.length-count; j++){
//             int swap = 0;
//             for(int i=0; i<data.length;i++){
//                 int val = 0;
//                 if(list.contains(i))
//                     val = 1;

//                 int orig = data[i];

//                 if(orig != val)
//                     swap++;

//             }
//             swap = swap/2;

//             if(min>swap)
//                 min=swap;

//             int r = list.indexOf(j);
//             list.remove(r);
//             list.add(count+j);
//         }

        return min;
    }
}
