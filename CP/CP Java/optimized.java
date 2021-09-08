import java.util.*;

public class optimized{

    static int minDistance(int dist[], Boolean sptSet[],int vertices){

        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < vertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }

    // Checking purpose 

    void printSolutioncheck(int dist[],int destination,int vertices)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
 
 
   
    static void printSolution(int dist[],int des)
    { 
       if(dist[des]==Integer.MAX_VALUE){
           System.out.println(0);
       }
       else{
           System.out.println(dist[des]);
       }
        
    }
 
    
    static void dijkstra(int graph[][], int src,int destination,int vertices)
    {
        int dist[] = new int[vertices]; 
 
        
        Boolean sptSet[] = new Boolean[vertices];
 
        
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        
        dist[src] = 0;
 
       
        for (int count = 0; count < vertices - 1; count++) {
            
            int u = minDistance(dist, sptSet,vertices);
 
            
            sptSet[u] = true;
 
            
            for (int v = 0; v < vertices; v++)
 
                
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        
        printSolution(dist,destination);
    }

   
  

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t= sc.nextInt();

        for(int i= 0; i <t;i++){

            int v=sc.nextInt();
            int n =sc.nextInt();

            int matrix[][] = new int[v][v];

            for(int row=0; row < v;row++){
                for (int column=0;column < v;column++){

                    matrix[row][column] =0;

                }
            }

            for(int j=0;j<n;j++){

                int p1=sc.nextInt();
                int p2=sc.nextInt();
                matrix[p1][p2]=p1+p2;
                matrix[p2][p1]=p1+p2;
            }

            int src=sc.nextInt();
            int des=sc.nextInt();


            dijkstra(matrix,src,des,v);


        }

    }
}