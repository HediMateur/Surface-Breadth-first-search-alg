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
        
    }
    
}
