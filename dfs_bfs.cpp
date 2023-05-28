#include<iostream>
#include<map>
#include<list>
#include<queue>
using namespace std;

class Graph
{
public:
    map<int,list<int>>adjList;
    map<int,bool>visited;
    queue<int>q;

    void addEdge(int src,int dest)
    {
        adjList[src].push_back(dest);
        adjList[dest].push_back(src);
    }

    void DFS(int node)
    {
        visited[node]=true;
        cout<<node<< " ";
        for(int i:adjList[node])
        {
            if(!visited[i])
                DFS(i);
        }
    }

    void BFS()
    {
        if(q.empty())
            return;
        int node=q.front();
        q.pop();
        cout<<node<<" ";
        for(int i:adjList[node])
        {
            if(!visited[i])
            {
                visited[i]=true;
                q.push(i);
            }
        }
        BFS();
    }
};
int main()
{
    Graph g;
    g.addEdge(1,2);
    g.addEdge(1,3);
    g.addEdge(2,4);
    g.addEdge(2,5);
    g.addEdge(3,6);
    g.addEdge(3,7);
    g.addEdge(1,8);

    int ch;
    cout<<"0 for DFS 1 for BFS"<<endl;
    cin>>ch;

   if(!ch)
   {
       cout<<"DFS on graph is:";
       g.DFS(1);
   }
   else
   {
       cout<<"BFS on given graph is:";
       g.q.push(1);
       g.visited[1]=true;
       g.BFS();
   }
   return 0;
}