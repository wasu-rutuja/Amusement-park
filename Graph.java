package dsa2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Graph {

	int Ride_no; 		 //total number of rides present
	int noEdge;			//total number of Edges
	int mat[][]=new int[20][20];  //matrix to create graph
	int visited[];
	NodeRide Array[]=new NodeRide[20];   //array of type NodeRide

	Graph() {           //default constructor
		Ride_no=0;
		noEdge=0;
		for(int i=0;i<20;i++) {
			Array[i]=new NodeRide();
		}
	}
	void addEdge()       //to make a edge/path between two rides
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter source ride id:");
		int i=sc.nextInt();
		System.out.println("enter destination ride id:");
		int d=sc.nextInt();
		System.out.println("Enter distance between two rides in metres: ");
		int w=sc.nextInt();
		mat[i][d]=w;
		mat[d][i]=w;
	}

	void createMat() //function to create graph
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of rides=");     //accept total number of rides initially 

		Ride_no=sc.nextInt();


		for(int i=0;i<Ride_no;i++) {
			Array[i].accept();
		}

		System.out.println("Enter number of edges="); //number of edges between those rides
		noEdge=sc.nextInt();

		for(int i=0;i<noEdge;i++)  
		{

			System.out.println("Enter ride ID across edge "+(i+1)+ " =");
			int data1=sc.nextInt();
			int data2=sc.nextInt();
			System.out.println("Enter distance between 2 rides");
			int dist=sc.nextInt();
			mat[data1][data2]=dist;
			mat[data2][data1]=dist;
		}
		for(int i=0;i<Ride_no;i++)
		{
			mat[i][i]=0;
		}

	}
	void displayMat()
	{
		System.out.print("\t");
		for(int i=0;i<Ride_no;i++)
		{
			System.out.print("       house"+(i)+"\t");
		}
		System.out.println();
		for(int i=0;i<Ride_no;i++)
		{
			System.out.print("house"+(i)+"\t");
			for(int j=0;j<Ride_no;j++)
			{
				System.out.print("\t"+mat[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("\n_____________________________________________");
	}
	 
	void addRide() {         //function to add extra ride(in near future)
		Scanner ob=new Scanner(System.in);
		Array[Ride_no].accept();
		Ride_no+=1;      //increment total no. of rides        
		System.out.println("Enter ride ID across edge "+(noEdge+1)+ " ="); //add edges
		int data1=ob.nextInt();
		int data2=ob.nextInt();
		System.out.println("Enter distance between 2 rides");
		int dist=ob.nextInt();
		if(dist!=0) {
			noEdge++;
		}
		mat[data1][data2]=dist;
		mat[data2][data1]=dist;
		for(int i=0;i<Ride_no;i++)
		{
			mat[i][i]=0;
		}
	}

	void printallrides() {       //function to display all rides and details about rides in amusement park 
		System.out.println("Ride Name"+"\t\t"+"RideID"+"\t\t"+"Age Limit");
		System.out.println("");
		for(int i=0;i<Ride_no;i++) {
			System.out.println(" "+Array[i].name+"\t\t"+i+"\t\t"+Array[i].ageLimit);
		}
		System.out.println("------------------------------------------------------");
	}
	public boolean dfs_recursive(boolean visited[], int start,int dest)    //func to check whether a given path between two rides exists
	{
		if(start==dest) {
			// Set current node as visited
			visited[start] = true;
			return true;
		}
		visited[start] = true;
		// For every node of the graph
		for (int i = 0; i < Ride_no; i++) {

			// If some node is adjacent to the current node
			// and it has not already been visited
			if (mat[start][i] !=0 && (!visited[i])) {
				boolean retVal=dfs_recursive(visited,i,dest);//Recursive call
				if(retVal==true) {
					return true;
				}
			}
		}
		return false;
	}
	void hasPath_check() //helper function to check if a path exists between the two given rides
	{
		Scanner sc=new Scanner(System.in);
		int src=-1,dest=-1;//initially both source and destination are initialized to -1
		System.out.println("Enter present ride name: ");
		String s=sc.nextLine();
		System.out.println("Enter ride you are searching for: ");
		String d=sc.nextLine();
		for(int i=0;i<Ride_no;i++)
		{
			if(s.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of source
			{
				src=i;
			}
			if(d.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of destination
			{
				dest=i;
			}
		}


		hasPath(src, dest);//calls the hasPath function 
	}

	void hasPath(int src,int dest)//function to check if a path exists between the two given rides
	{
		boolean visited[]= new boolean[Ride_no];
		if(dfs_recursive(visited,src,dest)==true)//if while dfs traversal we reach from source to destination then the two rides are in the same sector
			System.out.println("Ride is in your block!");
		else {
			System.out.println("Sorry!!Ride is in other block ");//if the two rides are in different sector
		}
	}

	void print_list_age() {   //func to print which rides are available for kids and adults
		String kids[]=new String[20];
		String adults[]=new String[20];
		int counter=Ride_no;
		int flag1=0,flag2=0;

		for(int i=0;i<Ride_no;i++) {
			if(Array[i].ageLimit<18)
				kids[i]=Array[i].name;
			else
				adults[i]=Array[i].name;
		}
		System.out.println("Kids Rides are :");
		for(int i=0;i<Ride_no;i++) //for printing rides available for kids
		{
			if(Array[i].ageLimit<18) {
				System.out.println(kids[i]);
				flag1++;}
		}
		System.out.println("Total Kids Rides are :"+flag1);
		System.out.println("Adult Rides are :");
		for(int i=0;i<Ride_no;i++) //for printing rides available for adults
		{
			if(Array[i].ageLimit>18) {
				System.out.println(adults[i]);
				flag2++;}
		}
		System.out.println("Total Adult Rides are :"+flag2);

	}
	void print_list_activity() {  //func to print which rides are active and inactive

		String active[]=new String[20];
		String inactive[]=new String[20];
		int counter=Ride_no;
		int flag1=0,flag2=0;

		for(int i=0;i<Ride_no;i++) {
			if(Array[i].activity==1)
				active[i]=Array[i].name;
			else
				inactive[i]=Array[i].name;
		}
		System.out.println("Active Rides List");
		System.out.println("-------------------------");
		for(int i=0;i<counter;i++) //for printing rides that are active
		{
			if(Array[i].activity==1) {
				System.out.println(active[i]);
				flag1++;}
		}
		if(flag1==0)System.out.println("No active rides");
		System.out.println();

		System.out.println("INActive Rides List ");
		System.out.println("-------------------------");
		for(int i=0;i<Ride_no;i++) //for printing rides that are inactive
		{
			if(Array[i].activity==0) {
				System.out.println(inactive[i]);
				flag2++;}
		}
		if(flag2==0)System.out.println("No Inactive rides");

		System.out.println();
	}
	/*void displayMat1() {
		System.out.println("Matrix=");
		for(int i=0;i<Ride_no;i++) {
			for(int j=0;j<Ride_no;j++) {
				if(j<i &&  mat[i][j]!=0) {
					System.out.println("Ride "+Array[i].name+"-->"+Array[j].name+" ; Distance:"+mat[i][j]);
				}
			}
		}
	}
	 */




	void dijkstra() //func to find shortest path between two rides
	{
		Scanner sc=new Scanner(System.in);
		int startVertex=-1,dest=-1;//initially both source and destination are initialized to -1
		System.out.println("Enter present ride name: ");
		String s=sc.nextLine();
		System.out.println("Enter ride you are searching for: ");
		String d=sc.nextLine();
		for(int i=0;i<Ride_no;i++)
		{
			if(s.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of source
			{
				startVertex=i;
			}
			if(d.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of destination
			{
				dest=i;
			}
		}
		boolean visited[]= new boolean[Ride_no];
		boolean temp=dfs_recursive(visited, startVertex, dest);
		if(temp==false)
		{
			System.out.println("The two rides are in different section");
			System.out.println();
			return;
		}
		int nVertices = Ride_no;

		// shortestDistances[i] will hold the// shortest distance from src to i
		int[] shortestDistances = new int[nVertices];

		// added[i] will true if vertex i is// included / in shortest path tree// or shortest distance from src to// i is finalized
		boolean[] added = new boolean[nVertices];

		// Initialize all distances as// INFINITE and added[] as false
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
		{
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}

		// Distance of source vertex from// itself is always 0
		shortestDistances[startVertex] = 0;
		// Parent array to store shortest// path tree
		int[] parents = new int[nVertices];

		// The starting vertex does not// have a parent
		parents[startVertex] = -1;

		// Find shortest path for all// vertices

		for (int i = 0; i < nVertices-1; i++)
		{
			int nearestVertex = -1;
			// Pick the minimum distance vertex
			// from the set of vertices not yet
			// processed. nearestVertex is
			// always equal to startNode in
			// first iteration.

			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0;vertexIndex < nVertices; vertexIndex++)
			{

				if (!added[vertexIndex] &&shortestDistances[vertexIndex] < shortestDistance)
				{
					nearestVertex = vertexIndex;

					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as
			// processed
			//System.out.print(nearestVertex);
			if(nearestVertex==-1)
				continue;
			added[nearestVertex] = true;

			// Update dist value of the
			// adjacent vertices of the
			// picked vertex.
			for (int vertexIndex = 0;vertexIndex < nVertices; vertexIndex++)
			{
				int edgeDistance = mat[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && !added[vertexIndex]&& ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))
				{
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}

		printSolution(startVertex, shortestDistances, parents,dest);
	}

	void printSolution(int startVertex,int[] distances,int[] parents,int dest)//A utility function to print the constructed distances array and shortest paths
	{
		int nVertices = distances.length;
		System.out.print("Locations\t Distance\tPath");

		System.out.print("\n" + startVertex + " -> ");
		System.out.print(dest + " \t\t ");
		System.out.print(distances[dest] + "\t\t");
		printPath(dest, parents);
		System.out.println("ARRIVED!");
		System.out.println();
	}


	private void printPath(int currentVertex,int[] parents)// Function to print shortest path  from source to currentVertex using parents array
	{

		// Base case : Source node has been processed

		if (currentVertex == -1)
		{
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(currentVertex + "->");
	}
	public void getPaths() //func to get a path between two rides or basically to check whether they are in same section
	{
		Scanner sc=new Scanner(System.in);
		int src=-1,dest=-1;//initially both source and destination are initialized to -1
		System.out.println("Enter present ride name: ");
		String s=sc.nextLine();
		System.out.println("Enter ride you are searching for: ");
		String d=sc.nextLine();
		for(int i=0;i<Ride_no;i++)
		{
			if(s.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of source
			{
				src=i;
			}
			if(d.compareTo(Array[i].name)==0)//checks the ride name in the entire array so that it gives us the ID of destination
			{
				dest=i;
			}
		}
			boolean visited[]= new boolean[Ride_no];
			boolean temp=dfs_recursive(visited, src, dest);
			if(temp==false)
			{
				System.out.println("The two rides are in different section");
				System.out.println();
				return;
			}
			boolean[] isVisited = new boolean[Ride_no];
			ArrayList<Integer> pathList = new ArrayList<>();

			// add source to path[]
			pathList.add(src);

			// Call recursive utility
			System.out.println("\nPaths (Mentioned numbers are ride numbers,follow in sequence left to right):");
			printAllPathsUtil(src, dest, isVisited, pathList);
		}

	// A recursive function to print
	// all paths from 'u' to 'd'.
	// isVisited[] keeps track of
	// vertices in current path.
	// localPathList<> stores actual
	// vertices in the current path
	private void printAllPathsUtil(Integer u, Integer d,boolean[] isVisited,List<Integer> localPathList)
	{

		if (u.equals(d)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			int j=localPathList.size()-1;
			while(localPathList.size()!=1) {
				localPathList.remove(j);
				j--;
			}
			  return;
		}

		// Mark the current node
		isVisited[u] = true;

		// Recur for all the vertices
		// adjacent to current vertex
		for (int i=0;i<Ride_no;i++) {
			if (!isVisited[i]&&mat[u][i]!=0) {
				// store current node
				// in path[]
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);

				// remove current node
				// in path[]
			}
		}

		// Mark the current node
		isVisited[u] = false;
	}

}