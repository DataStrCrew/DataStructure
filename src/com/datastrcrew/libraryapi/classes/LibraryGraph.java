package com.datastrcrew.libraryapi.classes; /**
 * This class has been made up to finding Destination
 * @author Mustafa Gurler
 */

import java.util.*;

public class LibraryGraph {

    private ListGraph cityGraph;// Graph

    /**
     * Constructor for creating graph
     */
    public LibraryGraph() {
        cityGraph = new ListGraph(100,false);
        addFloors();
    }

    /**
     * adding elements to graph
     */
    private void addFloors(){
        cityGraph.insert(new Edge(1, 2,1));
        cityGraph.insert(new Edge(2, 3,1));
        cityGraph.insert(new Edge(1, 12,1));
        cityGraph.insert(new Edge(12,4,1));
        cityGraph.insert(new Edge(4,5,1));
        cityGraph.insert(new Edge(5,6,1));
        cityGraph.insert(new Edge(4,11,1));
        cityGraph.insert(new Edge(11,7,1));
        cityGraph.insert(new Edge(7,8,1));
        cityGraph.insert(new Edge(8,9,1));
        cityGraph.insert(new Edge(1, 13,1));
        cityGraph.insert(new Edge(13,10,1));
    }

    /**
     * Finding shortest path from source to destination
     */
    public void getPath(){
        Scanner scanner = new Scanner(System.in);
        int source, destination;
        System.out.println("9-)Third Floor Third Section               8-)Third Floor Second Section                7-)Third Floor First Section" );
        System.out.println("                                                                                        11-)Stairs");
        System.out.println("6-)Second Floor Third Section              5-)Second Floor Second Section               4-)Second Floor First Section" );
        System.out.println("                                                                                        12-)Stairs");
        System.out.println("3-)First Floor Second Section               2-)First Floor First Section                1-)First Floor Entrance" );
        System.out.println("                                                                                        13-)Stairs");
        System.out.println("                                                                                        10-)Garage");

        System.out.println("Where are you?");
        source = scanner.nextInt();
        System.out.println("Where do you want to go");
        destination = scanner.nextInt();
        printPaths(source,destination);
    }

    /**
     * printing shortest path
     * @param s source
     * @param d destination
     */
    private void printPaths(int s, int d){
        Boolean[] visited = new Boolean[cityGraph.getNumV()];
        int[] path = new int[cityGraph.getNumV()];
        int path_index = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<cityGraph.getNumV(); i++){
            visited[i] =false;
        }

        printPathsUtil(s,d,visited,path,path_index, sb);
    }

    /**
     * recursive for shortest path
     * @param s
     * @param d
     * @param visited
     * @param path
     * @param path_index
     * @param sb
     */
    public void printPathsUtil(int s, int d, Boolean[] visited, int[] path, int path_index, StringBuilder sb){
        visited[s] = true;
        path[path_index] = s;
        path_index++;

        if(s==d){
            for(int i=1; i<path_index; i++)
                System.out.print("You need to go " + path(path[i]) + "\n");
            System.out.println("***Destination has been found!!");
            System.out.println();

        }
        else{
            Iterator it = cityGraph.edgeIterator(s);
            int i;
            Edge temp;
            while(it.hasNext()){
                temp = (Edge) it.next();
                i = temp.getDest();
                if(!visited[i])
                    printPathsUtil(i,d,visited,path,path_index, sb);
            }
        }

        path_index--;
        visited[s]=false;
    }

    /**
     * path of string version
     * @param dest
     * @return
     */
    private String path(int dest){
        switch (dest){
            case 1:
                return "First Floor Entrance";
            case 2:
                return "First Floor First Section";
            case 3:
                return "First Floor Second Section";
            case 4:
                return "Second Floor First Section";
            case 5:
                return "Second Floor Second Section";
            case 6:
                return "Second Floor Third Section";
            case 7:
                return "Third Floor First Section";
            case 8:
                return "Third Floor Second Section";
            case 9:
                return "Third Floor Third Section";
            case 10:
                return "Garage";
            case 12:
            case 13:
            case 11:
                return "Stairs";
        }
        return null;
    }
}
