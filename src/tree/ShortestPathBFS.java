package tree;

import java.util.*;
public class ShortestPathBFS
{
    Node root;

    public int BFS(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;

        while(!que.isEmpty())
        {
            int length = que.size();
            for(int i = 0; i < length; i++)
            {
                Node cur = que.poll();

                if(cur.lt == null & cur.rt == null)
                    return depth;

                if(cur.lt != null)
                    que.offer(cur.lt);

                if(cur.rt != null)
                    que.offer(cur.rt);

            }
            depth++;
        }

        return 0;
    }

    public static void main(String args[])
    {
        ShortestPathBFS tree = new ShortestPathBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }
}
