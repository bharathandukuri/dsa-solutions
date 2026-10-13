class SmallestInfiniteSet {

    PriorityQueue<Integer> heap;
    Set<Integer> addedBack;
    int curr;

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        addedBack = new HashSet<>();
        curr = 1;
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            int smallest = heap.poll();
            addedBack.remove(smallest);
            return smallest;
        }

        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && addedBack.add(num)) {
            heap.offer(num);
        }
    }
}