class MedianFinder {

    PriorityQueue<Double> max, min;
    /** initialize your data structure here. */
    public MedianFinder() {
       max = new PriorityQueue<>(Collections.reverseOrder());
       min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        double dou = (double) num;

        if(min.peek() == null){
            if(max.peek() == null){
                min.add(dou);
            } else {
                Double e = max.peek();
             if(dou<e)
                 max.add(dou);
            else
                min.add(dou);
            }
        } else{
            min.add(dou);
        }

        if(min.size() > max.size()){
            double d = min.poll();
            max.add(d);
        }

        if(min.size() < max.size()){
            double d = max.poll();
            min.add(d);
        }
    }

    public double findMedian() {
        if(max.size() > min.size())
            return (double) max.peek();
        else if(min.size() > max.size())
            return (double) min.peek();
        else {
            return (double)  ((double) max.peek()+ (double) min.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
