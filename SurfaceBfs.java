/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surfacebfs;
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Hedi Mateur
 */
class Node {
    char[][] map;
    int X;
    int Y;
    public Node(char[][] map,int X,int Y){
       this.map=map;
       this.X=X;
       this.Y=Y;
    }
    public ArrayList<Node> getChildren(){
        ArrayList<Node> childNodes = new ArrayList<>();
        if(this.Y <map.length-1)
        {
            childNodes.add(new Node(map,X,Y+1));
        }
        if(this.Y >0) {
            childNodes.add(new Node(map,X,Y-1));
        }
        if(this.X >0) {
            childNodes.add(new Node(map,X-1,Y));
        }
        if(this.X <map[0].length-1) {
            childNodes.add(new Node(map,X+1,Y));
        }
        return childNodes;
    }
}
class BreadthFirstSearch {

    Node startNode;
    char[][] map;
    public BreadthFirstSearch(Node startNode,char[][] map){
        this.startNode = startNode;
        this.map = map;
    }
    public int compute(){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(this.startNode);
        int k=0;
        int maxNodeNumber=map.length * map[0].length;
        int comp=0;
        while(comp<maxNodeNumber&&!queue.isEmpty()){
            Node current = queue.getFirst();
            queue.removeFirst();
            if(map[current.Y][current.X]=='O'){    
                map[current.Y][current.X]='V';
                k++;
                if(!current.getChildren().isEmpty()){
                    queue.addAll(current.getChildren());
                    comp++;
                }
            }
        }
        return k;
    }
}
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
//LINK TO THE PROBLEM : https://www.codingame.com/ide/62023168993c571c9cfb0e791644e12a8a81430
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        ArrayList<String> rows = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            rows.add(in.nextLine());
        }
        int N = in.nextInt();
        for (int k = 0; k < N; k++) {
            int X = in.nextInt();
            int Y =in.nextInt();
            char[][] map = new char[H][L] ;
            for(int j=0;j<H;j++)
                map[j]=rows.get(j).toCharArray();
            Node startNode = new Node(map,X,Y);
            BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, map);
            System.out.println(bfs.compute());
        }
    }
}
