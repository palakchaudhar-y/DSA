class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            q.offer(i);
        }
        int arr[]=new int[deck.length];
        for(int i=0;i<deck.length;i++){
            int index=q.poll();
            arr[index]=deck[i];
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return arr;
    }
}