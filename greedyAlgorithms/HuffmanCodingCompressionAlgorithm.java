package algorithms.greedyAlgorithms;

import java.util.*;

public class HuffmanCodingCompressionAlgorithm {
    private class Node{
        char c;
        int frequency;
        Node left;
        Node right;

        public Node(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        public Node(char c,int frequency,Node left,Node right){
            this.c = c;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        public int getFrequency() {
            return frequency;
        }
    }
    String toCompress;
    public HuffmanCodingCompressionAlgorithm(String s){
        this.toCompress = s;
    }

    public void solve(){
        Map<Character,Integer> freq = new HashMap<>();
        for(char c :toCompress.toCharArray()){
            freq.merge(c,1,Integer::sum);
        }
        System.out.println(freq);
        PriorityQueue<Node> q = new PriorityQueue<>(
                (a,b) -> a.getFrequency() - b.getFrequency()
        );

        for(var set : freq.keySet()){
            q.offer(new Node(set,freq.get(set)));
        }

        while (q.size() != 1){
           Node left = q.poll();
           Node right = q.poll();

           int sumOfFrequencies = left.frequency + right.frequency;
           q.offer(new Node(' ',sumOfFrequencies,left,right));
        }


        var root = q.poll();
        Map<Character,String> huffmanCodes = new HashMap<>();
        encodeString(root,"",huffmanCodes);

        StringBuilder encodedString = new StringBuilder();
        for(char c : toCompress.toCharArray())
            encodedString.append(huffmanCodes.get(c));

        System.out.println("Huffman Map " + huffmanCodes);
        System.out.println("Encoded String " + encodedString);
    }




    private void encodeString(Node root,String s,Map<Character,String> code){
        if(root == null)
            return;

        if(isLeaf(root)){
            code.put(root.c,s);
        }

        encodeString(root.left,s+"0",code);
        encodeString(root.right,s+"1",code);

    }

    private boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
}
