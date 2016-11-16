/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surfacebfs;

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
    boolean visited;
    public Node(char[][] map,int X,int Y){
       this.map=map;
       this.X=X;
       this.Y=Y;
       this.visited = false;
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
        ArrayList<Node> explored = new ArrayList<>();
        queue.add(this.startNode);
        int k=0;
        int com=map.length * map[0].length;
        
        while(explored.size()<com&&!queue.isEmpty()){
            
            Node current = queue.getFirst();
            queue.removeFirst();
            if(map[current.Y][current.X]=='O'&&!current.visited){    
                boolean tester= false;
                //int somme = startNode.X-current.X+current.Y-startNode.Y+current.iterX+current.iterY;
           /*     for(int i=0;i<explored.size();i++){
                    if(current.X==explored.get(i).X&&current.Y==explored.get(i).Y){
                        tester = true;
                    }
                }*/
                
                        map[current.Y][current.X]='V';
                        k++;
                    if(!current.getChildren().isEmpty()){
                            queue.addAll(current.getChildren());
                    }
                    explored.add(current);
            }
        }

        return k;
    }
}
public class SurfaceBfs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int L = 4;
        int H = 4;
        char [][]map=new char[H][L];
        String row1="####";
        String row2="##O#";
        String row3="#OO#";
        String row4 ="####";
        map[0]=row1.toCharArray();
        map[1]=row2.toCharArray();
        map[2]=row3.toCharArray();
        map[3]=row4.toCharArray();
        int N=1;
        int X=1;
        int Y=2;
        Node startNode = new Node(map,X,Y);
        BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, map);
        System.out.println(bfs.compute());
        /*for (int i = 0; i < N; i++) {

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("answer");
        }*/
    }
    
}
